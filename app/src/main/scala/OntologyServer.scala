/**
  * Created by dossluca on 27/02/2017.
  */
import java.io.{File, FileWriter}
import java.util
import java.util.{Collection, HashSet}
import javax.annotation.PostConstruct
import javax.inject.Singleton
import javax.ws.rs._
import javax.ws.rs.core.{MediaType, Response}

import com.clarkparsia.pellet.owlapiv3.{PelletReasoner, PelletReasonerFactory}
import com.hp.hpl.jena.query.{QueryExecutionFactory, QueryFactory, ResultSet}
import com.hp.hpl.jena.rdf.model.{InfModel, ModelFactory}
import com.yoshtec.owl.marshall.{Marshaller, UnMarshaller}
import model.v6._
import org.semanticweb.owlapi.model.{IRI, OWLNamedIndividual}
import org.semanticweb.owlapi.reasoner.{InferenceType, NodeSet}
import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl
//import com.yoshtec.owl.marshall.{Marshaller, UnMarshaller}
//import de.derivo.sparqldlapi.{Query, QueryEngine, QueryResult}

import org.semanticweb.owlapi.apibinding.OWLManager
import org.semanticweb.owlapi.model.{OWLOntology, OWLOntologyManager}
import org.slf4j.{Logger, LoggerFactory}

import scala.collection.JavaConverters._
import scala.util.control.Breaks._

@Singleton
@Path("/rest")
class OntologyServer {

  var logger: Logger = _

  val ONTOLOGY_LOCATION = "ontology/stroke_v6.owl"

  val ONTOLOGY_IRI = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke"

  var manager: OWLOntologyManager = _

  var marshaller: Marshaller = _

  var unmarshaller: UnMarshaller = _

  //var individuals: HashSet[Thing] = new HashSet[Thing]
  var individuals: Collection[Object] = _

  var ontology: Option[OWLOntology] = None

  var reasoner: PelletReasoner = _

  var model: InfModel = _

  //var engine: Option[QueryEngine] = None

  @PostConstruct
  def setupOntologyServer: Unit = {

    logger = LoggerFactory.getLogger(this.getClass)

    logger.info("Starting Ontology Server.")

    manager = OWLManager.createOWLOntologyManager()

    marshaller = new Marshaller()

    unmarshaller = new UnMarshaller()
    unmarshaller.registerClass(classOf[PersonImpl])
    unmarshaller.registerClass(classOf[RiskFactorImpl])
    unmarshaller.registerClass(classOf[Alcohol_consumptionImpl])
    unmarshaller.registerClass(classOf[EducationImpl])
    unmarshaller.registerClass(classOf[Heart_diseaseImpl])
    unmarshaller.registerClass(classOf[Physical_activityImpl])
    unmarshaller.registerClass(classOf[Psychosocial_factorsImpl])
    unmarshaller.registerClass(classOf[SexImpl])
    unmarshaller.registerClass(classOf[Smoking_statusImpl])
    unmarshaller.registerClass(classOf[DeviceImpl])
    unmarshaller.registerClass(classOf[SensorImpl])
    unmarshaller.registerClass(classOf[Mobile_deviceImpl])
    unmarshaller.registerClass(classOf[WearableImpl])

    ontology = loadOntology(ONTOLOGY_LOCATION)

    loadReasoner()

    loadQueryExecutor()

    individuals = loadIndividuals(ontology)
  }

  def executeQueryAndReturnResult(query: String): String = {
    val queryResult = executeQuery(query)
    getResultFromMap(getResultMapFromQuery(queryResult))
  }

  def getResultFromMap(map: Map[String, String]): String = {
    val result = map.get(Queries.RESULT)

    if (result.isDefined) {
      return result.get
    }
    else {
      return "?"
    }
  }

  def getResultListFromQuery(result: ResultSet): List[String] = {
    var list = List[String]()

    result.asScala.foreach {
      solution => solution.varNames().asScala.foreach
      {
        variable =>  list = solution.getLiteral(variable).getString :: list
      }
    }

    list
  }

  def getResultMapFromQuery(result: ResultSet): Map[String, String] = {
    var map = Map[String, String]()

    result.asScala.foreach {
      solution => solution.varNames().asScala.foreach
      {
        variable => map += (variable -> solution.getLiteral(variable).getString)
      }
    }

    map
  }

  def executeQuery(query: String): ResultSet = {
    logger.info("\n" + query)

    val startTime = System.currentTimeMillis()

    val q = QueryFactory.create(query)
    val queryExecution = QueryExecutionFactory.create(q, model)

    val select = queryExecution.execSelect()

    logger.info("Query took: "+ (System.currentTimeMillis() - startTime) + " ms")

    select
  }

  def loadQueryExecutor(): Unit = {
    val graph = new org.mindswap.pellet.jena.PelletReasoner().bind(reasoner.getKB)
    model = ModelFactory.createInfModel( graph )
  }

  def loadReasoner(): Unit = {

    if (ontology.isDefined) {

      reasoner = PelletReasonerFactory.getInstance.createReasoner( ontology.get )
      reasoner.prepareReasoner()
      reasoner.precomputeInferences(InferenceType.CLASS_HIERARCHY, InferenceType.CLASS_ASSERTIONS,
        InferenceType.OBJECT_PROPERTY_HIERARCHY, InferenceType.DATA_PROPERTY_HIERARCHY);

      //reasoner.getKB.printClassTree()

      //SPARQL or any other way to query
      // the ontology are equivalent, i.e., through calls to the reasoner.

      /*val p = new PersonImpl()

      val expression = createClassExpression(p.getIRI)
      val instances = reasoner.getInstances(expression, false)

      val list = getIndividualsFromNodeSet(instances)

      val ind = getOWLIndividualFromList("luquinhas", list)
      val propers = Searcher.values(ontology.get.getDataPropertyAssertionAxioms(ind), null)
      val map = EntitySearcher.getDataPropertyValues(ind, ontology.get)

      printNodeSet(instances)*/



//      result.asScala.foreach {
//        solution => solution.varNames().asScala.foreach { variable =>
//        logger.info(variable + ": " + solution.get(variable).toString)
//        }
//      }

//      while (result.hasNext) {
//        val solution = result.next()
//        while (solution.varNames().hasNext) {
//          val variable = solution.varNames().next()
//          logger.info(variable)
//        }
//      }

      //val ind = reasoner.getInstances()
      //com.clarkparsia.pellet.sparqldl.model.Query
    }

  }

  def createClassExpression(iri: String): OWLClassImpl = {
    new OWLClassImpl(IRI.create(iri))
  }

/*  def createClassExpression(thing: Thing): OWLClassImpl = {
    new OWLClassImpl(IRI.create(thing.getIRI))
  }*/

  def getOWLIndividualFromList(name: String, list: List[OWLNamedIndividual]): OWLNamedIndividual = {
    var individual: OWLNamedIndividual = null

    breakable {
      list.foreach {
        i =>
          if (i.getIRI.toString.equals(ONTOLOGY_IRI + "#" + name)) {
            individual = i
            break
          }
      }
    }


    individual
  }


  def printNodeSet(nodeSet: NodeSet[OWLNamedIndividual]): Unit = {
    nodeSet.getNodes.forEach(n => n.getEntities.forEach(e => logger.info(e.getIRI.toString)))
  }

  def getIndividualsFromNodeSet(nodeSet: NodeSet[OWLNamedIndividual]): List[OWLNamedIndividual] = {
    var list = List[OWLNamedIndividual]()
    nodeSet.getNodes.forEach(n => n.getEntities.forEach(e => list = list :+ e.asOWLNamedIndividual()))
    list
  }

/*  def queryResultsToList(results: Option[QueryResult]): List[String] = {

    var list: List[String] = List()

    if (!results.isDefined) {
      return list
    }

    results.get.forEach {
      result => result.getBoundArgs.forEach {
        bound => list = list :+ result.get(bound).toString
      }
    }

    list
  }*/

  @GET
  @Path("/individuals")
  //@Produces(MediaType.APPLICATION_JSON)
  def getIndividuals(): Unit = {
    logger.info("REST call /individuals")
  }

  def loadOntology(ontologyName: String): Option[OWLOntology] = {

    var ontology: Option[OWLOntology] = None

    val file = new File(ontologyName)

    if (file.exists()) {
      logger.info("Loading ontology: " + ontologyName)
      ontology = Some(manager.loadOntologyFromOntologyDocument(file))
    } else {
      logger.info("Cannot load ontology: file '" + ontologyName + "' does not exist.")
    }

    ontology
  }

  def loadIndividuals(ontology: Option[OWLOntology]): Collection[Object] = {

    logger.info("Loading individuals: " + ontology)

    if (!ontology.isDefined) {
      logger.info("Cannot load individuals: ontology " + ontology + " not loaded. Returning empty hash set of individuals")
      return new HashSet
    }

    val list = unmarshaller.unmarshal(ontology.get)

    logger.info("Individuals size: " + list.size())

    list
  }

   @GET
   @Path("/saveIndividuals")
   def saveIndividuals(): Unit = {

     logger.info("Saving all individuals. size: " + individuals.size())

     marshaller.marshal(individuals, ontology.get, true)

     manager.saveOntology(ontology.get)
   }

  @POST
  @Path("/addIndividual")
  @Consumes(Array[String](MediaType.APPLICATION_JSON))
  def addIndividual(person: PersonImpl): Response = {
    logger.info("Adding individual:")

    logger.info(person.toString)

    person.setUri(ONTOLOGY_IRI + "#" + person.getUri)

    individuals.add(person)

    saveIndividuals()

    Response.status(201).entity("Individual successfully added").build();
  }

  def addOntologyURI(individual: Thing): Unit = {
    if (!individual.getUri.contains("#")) { // or contains ONTOLOGY_URI
      val uri = ONTOLOGY_IRI + "#" + individual.getUri
      individual.setUri(uri)
    }
  }

  @POST
  @Path("/calculateRiskForPerson")
  @Consumes(Array[String](MediaType.APPLICATION_JSON))
  @Produces(Array[String](MediaType.TEXT_PLAIN))
  def calculateRiskForPerson(person: PersonImpl): String = {
    logger.info("Checking if individual with name: " + person.getUri + " exists")

    logger.info(person.toString)

    addOntologyURI(person)

    person.getHasRiskFactor.forEach {
      r => addOntologyURI(r)
    }

    val personFromServer = getIndividualFromList[PersonImpl](person.getUri)

    if (personFromServer != null) {
      logger.info("Removing individual with name: " + person.getHasUserName + " from list.")
      individuals.remove(personFromServer)
    }

    logger.info("Adding individual with name: " + person.getHasUserName + " to list.")
    individuals.add(person)

    saveIndividuals()

    val risk = getRiskLevel(person.getHasUserName)

    risk
  }

  @GET
  @Path("/getRiskLevel")
  @Produces(Array[String](MediaType.TEXT_PLAIN))
  def getRiskLevel(@QueryParam("name") name: String): String = {

    val weights = executeQueryAndReturnResult(Queries.calculatePropertiesWeights(name))

    if (weights.equals("?")) {
      return "?"
    }

    val age =  executeQueryAndReturnResult(Queries.calculateAge(name))

    if (age.equals("?")) {
      return "?"
    }

    val total = weights.toInt + age.toInt

    RiskCalculator.calculateRiskPercentageRounded(total)
  }

  @GET
  @Path("/getPerson")
  @Produces(Array[String](MediaType.APPLICATION_JSON))
  def getPerson(@QueryParam("name") name: String): PersonImpl = {
    getIndividualFromList[PersonImpl](name)
  }


  def getIndividualFromList[T](name: String): T = {

    individuals.forEach {
      i =>
        if (Utils.extractNameFromURI(i.asInstanceOf[Thing].getUri).equals(name)) {
          logger.info("Getting individual: " + i.toString)
          return i.asInstanceOf[T]
        }
    }

    logger.error("Not possible to get individual: " + name + " . Returning null")

    null.asInstanceOf[T]
  }

  @GET
  @Path("/examplePerson")
  @Produces(Array[String](MediaType.APPLICATION_JSON))
  def examplePerson(): PersonImpl = {

    val person = new PersonImpl()

    person.setHasAge(65)

    var riskFactors = List[RiskFactorImpl]()
    riskFactors = riskFactors :+ getIndividualFromList[RiskFactorImpl]("Drinker")
    riskFactors = riskFactors :+ getIndividualFromList[RiskFactorImpl]("Smoker")



    person.setHasRiskFactor(riskFactors.asJava)

    person.setUri(ONTOLOGY_IRI + "#" + "john2")

    person.setHasRiskLevel(65.0)

    person.setHasPassword("lucas1")
    person.setHasUserName("john2")

    val factory = new ObjectFactory
    val device = factory.createMobile_device(ONTOLOGY_IRI + "#" + "iPhone")
    device.setHasSensor(List[Sensor](getIndividualFromList[Sensor]("Gyroscope")).asJava)
    person.setHasDevice(List[Device](device).asJava)


    person
    //person.setHas

    //person.setHasRiskFactor()

    /*
    *  a) riskFactor.fromSPARQL...
    *  b) queries all risk factors
    *  c) riskFactor.getIRI
    *
    * */
  }

  /*def processQuery(queryString: String) : Option[QueryResult] = {

    var result: Option[QueryResult] = None

    try {

      if (!engine.isDefined) {
        return result
      }

      val startTime = System.currentTimeMillis()

      logger.info("Executing query: \n" + queryString + "\n ---------------------------------------")

      // Create a SPARQL-DL query
      val query = Query.create(queryString)

      result = Some(engine.get.execute(query))

      if (query.isAsk) {
        val ask = if (result.get.ask) "Yes" else "No"
        logger.info("Result: " + ask)
      }
      else {
        if (!result.get.ask) {
          logger.info("Query has no solution.\n")
        }
        else {
          logger.info("Results: \n" + result.get.toString + "\n Size of result set: " + result.get.size() + "\n-----------------------")
        }
      }

      logger.info("Finished in: " + (System.currentTimeMillis - startTime) + " ms")
    }
    catch  {
      case e: Throwable => logger.info("Query engine error: " + e)
    }

    result
  }*/

/*
  def sparql_dl(): Unit = {
    // Create an instance of an OWL API reasoner (we use the OWL API built-in StructuralReasoner for the purpose of demonstration here)
    val factory = new StructuralReasonerFactory()
    val reasoner = factory.createReasoner(individualsOntology.get)
    // Optionally let the reasoner compute the most relevant inferences in advance
    reasoner.precomputeInferences(InferenceType.CLASS_ASSERTIONS, InferenceType.OBJECT_PROPERTY_ASSERTIONS);
    // Create an instance of the SPARQL-DL query engine

    val parser = com.clarkparsia.pellet.sparqldl.engine.QueryEngine.getParser
    val query = parser.parse(Queries.SUBJECT_HAS_AGE, knowledgeBase)
    //https://github.com/protegeproject/sparql-dl-api/blob/master/src/main/java/de/derivo/sparqldlapi/examples/Example_Extended.java
    engine = Some(QueryEngine.create(manager, reasoner))

    //processQuery("ASK {}")

    val results = processQuery(
      Queries.SUBJECT_HAS_AGE
    )
  }
*/

}