/**
  * Created by dossluca on 27/02/2017.
  */
import java.io.{File, FileWriter}
import java.util.HashSet
import javax.annotation.PostConstruct
import javax.inject.Singleton
import javax.ws.rs._
import javax.ws.rs.core.{MediaType, Response}

import com.clarkparsia.pellet.owlapiv3.{PelletReasoner, PelletReasonerFactory}
import com.hp.hpl.jena.query.{QueryExecutionFactory, QueryFactory, ResultSet}
import com.hp.hpl.jena.rdf.model.{InfModel, ModelFactory}
import com.yoshtec.owl.marshall.{Marshaller, UnMarshaller}
import model.v5._
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

  val ONTOLOGY_LOCATION = "ontology/stroke_v5.owl"
  val INDIVIDUALS_LOCATION = "ontology/individuals.owl"

  val INDIVIDUALS_IRI = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke_individuals"
  val ONTOLOGY_IRI = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke"

  var manager: OWLOntologyManager = _

  var marshaller: Marshaller = _

  var unmarshaller: UnMarshaller = _

  var individuals: HashSet[PersonImpl] = new HashSet[PersonImpl]

  var strokeOntology: Option[OWLOntology] = None
  var individualsOntology: Option[OWLOntology] = None

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
    //unmarshaller.registerClass(classOf[RiskFactor])
    //unmarshaller.registerClass(classOf[PersonImpl])
    unmarshaller.registerClass(classOf[RiskFactorImpl])

    strokeOntology = loadOntology(ONTOLOGY_LOCATION)
    individualsOntology = loadOntology(INDIVIDUALS_LOCATION)

    loadReasoner()

    loadQueryExecutor()

    //individuals = loadAllIndividuals[ThingImpl]()
    loadAllIndividuals[ThingImpl]()
  }

  def loadAllIndividuals[T](): HashSet[T] =
  {
    val individualsFromStrokeOntology = loadIndividualsWithType[T](strokeOntology)
//    val individualsFromIndividualsOntology = loadIndividuals(individualsOntology)
//    individualsFromStrokeOntology.addAll(individualsFromIndividualsOntology)
    individualsFromStrokeOntology
  }

  def executeQueryAndReturnInt(query: String): Int = {
    val queryResult = executeQuery(query)
    val result = getResultFromMap(getResultMapFromQuery(queryResult))
    result.get.toInt
  }

  def getResultFromMap(map: Map[String, String]): Option[String] = {
    map.get(Queries.RESULT)
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

    val ontology = strokeOntology

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

 def loadIndividualsWithType[T](ontology: Option[OWLOntology]): HashSet[T] = {

    var list = new HashSet[T]()

    if (!ontology.isDefined) {
      logger.info("Cannot load individuals: ontology " + ontology + " not loaded")
      return list
    }

    logger.info("Loading individuals: " + ontology)

    list = unmarshaller.unmarshal(ontology.get).asInstanceOf[HashSet[T]]

    logger.info("Individuals size: " + list.size())

    list
    //individuals.forEach(i => logger.info(i.toString))
  }

   @GET
   @Path("/saveIndividuals")
   def saveIndividuals(): Unit = {

     logger.info("Saving all individuals. size: " + individuals.size())

     //individuals.forEach(i => logger.info(i.toString))

     val writer = new FileWriter(INDIVIDUALS_LOCATION)

     marshaller.marshal(individuals, IRI.create(INDIVIDUALS_IRI), writer, true)

     writer.close()
   }

  @POST
  @Path("/addIndividual")
  @Consumes(Array[String](MediaType.APPLICATION_JSON))
  def addIndividual(person: PersonImpl): Response = {
    logger.info("Adding individual:")

    logger.info(person.toString)

    person.setName(ONTOLOGY_IRI + "#" + person.getName)

    individuals.add(person)

    saveIndividuals()

    Response.status(201).entity("Individual successfully added").build();
  }

  @GET
  @Path("/getRiskLevel")
  @Produces(Array[String](MediaType.TEXT_PLAIN))
  def getRiskLevel(@QueryParam("name") name: String): String = {
    val weights = executeQueryAndReturnInt(Queries.calculatePropertiesWeights(name))
    val age =  executeQueryAndReturnInt(Queries.calculateAge(name))
    val total = weights + age
    RiskCalculator.calculateRiskPercentageRounded(total)
  }

  @GET
  @Path("/getIndividual")
  @Produces(Array[String](MediaType.APPLICATION_JSON))
  def getIndividual(@QueryParam("name") name:String): PersonImpl = {

    var individual: PersonImpl = new PersonImpl()

    for (person: PersonImpl <- individuals.asScala) {
      if (Utils.extractNameFromURI(person.getName).equals(name)) {
        logger.info("Getting individual: " + person.toString)
        individual = person
      }
    }

    individual
  }

  @GET
  @Path("/exampleIndividual")
  @Produces(Array[String](MediaType.APPLICATION_JSON))
  def exampleIndividual(): Unit = {

    val person = new PersonImpl()

    person.setHasAge(List[Integer](65).asJava)

    val factory = new ObjectFactory

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