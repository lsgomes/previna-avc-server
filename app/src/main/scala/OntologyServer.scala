/**
  * Created by dossluca on 27/02/2017.
  */
import java.io.File
import javax.annotation.PostConstruct
import javax.inject.Singleton
import javax.ws.rs._

import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory
import com.hp.hpl.jena.query.{QueryExecutionFactory, QueryFactory}
import com.hp.hpl.jena.rdf.model.ModelFactory
import com.lucas.stroke.v3.strokeFactory
import org.semanticweb.owlapi.reasoner.InferenceType
//import com.yoshtec.owl.marshall.{Marshaller, UnMarshaller}
//import de.derivo.sparqldlapi.{Query, QueryEngine, QueryResult}
//import model._
import org.protege.owl.codegeneration.inference.ReasonerBasedInference
import org.semanticweb.owlapi.apibinding.OWLManager
import org.semanticweb.owlapi.model.{OWLOntology, OWLOntologyManager}
import org.slf4j.{Logger, LoggerFactory}

import scala.collection.JavaConverters._

@Singleton
@Path("/rest")
class OntologyServer {

  var logger: Logger = _

  val ONTOLOGY_LOCATION = "ontology/stroke_v3.owl"
  val INDIVIDUALS_LOCATION = "ontology/individuals.owl"

  val INDIVIDUALS_IRI = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke_individuals"
  val ONTOLOGY_IRI = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke"

  var manager: OWLOntologyManager = _

  //var marshaller: Marshaller = _

  //var unmarshaller: UnMarshaller = _

  //var individuals: HashSet[PersonImpl] = new HashSet[PersonImpl]

  var strokeOntology: Option[OWLOntology] = None
  var individualsOntology: Option[OWLOntology] = None

  //var engine: Option[QueryEngine] = None

  var inference: ReasonerBasedInference = _
  var factory: strokeFactory = _

  @PostConstruct
  def setupOntologyServer: Unit = {

    logger = LoggerFactory.getLogger(this.getClass)

    logger.info("Starting Ontology Server.")

    //val autoIRIMapper = new AutoIRIMapper(new File("ontology"), false)

    manager = OWLManager.createOWLOntologyManager()
    //manager.addIRIMapper(autoIRIMapper)

    //marshaller = new Marshaller()

    //unmarshaller = new UnMarshaller()
    //unmarshaller.registerClass(classOf[PersonImpl])

    strokeOntology = loadOntology(ONTOLOGY_LOCATION)
    individualsOntology = loadOntology(INDIVIDUALS_LOCATION)

    //loadIndividuals()

    loadReasoner()

  }

  def loadReasoner(): Unit = {

    val ontology = strokeOntology

    if (ontology.isDefined) {
      //val reasoner = factory.createReasoner(individualsOntology.get)
      //reasoner.precomputeInferences()
      //logger.info("isConsistent: " + reasoner.isConsistent)
      //queryResultsToList(results).foreach(i => logger.info(i))
      val reasoner = PelletReasonerFactory.getInstance.createReasoner( ontology.get )
      reasoner.precomputeInferences(InferenceType.CLASS_HIERARCHY, InferenceType.CLASS_ASSERTIONS);
      reasoner.prepareReasoner()

      //inference = new ReasonerBasedInference(ontology.get, reasoner)
      factory = new strokeFactory(ontology.get)

      //reasoner.

      val graph = new org.mindswap.pellet.jena.PelletReasoner().bind(reasoner.getKB);
      val model = ModelFactory.createInfModel( graph )

      //reasoner.getKB.printClassTree()

      val q = QueryFactory.create(Queries.SUBJECT_HAS_AGE)
      val queryExecution = QueryExecutionFactory.create(q, model)
      val result = queryExecution.execSelect()

      //SPARQL or any other way to query
      // the ontology are equivalent, i.e., through calls to the reasoner.


      result.asScala.foreach {
        solution => solution.varNames().asScala.foreach { variable =>
        logger.info(variable + ": " + solution.get(variable).toString)
        }
      }

//      while (result.hasNext) {
//        val solution = result.next()
//        while (solution.varNames().hasNext) {
//          val variable = solution.varNames().next()
//          logger.info(variable)
//        }
//      }

      logger.info("a")
      //val ind = reasoner.getInstances()
      //com.clarkparsia.pellet.sparqldl.model.Query
    }

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

/*  def loadIndividuals(): Unit = {

    //val ontology = loadOntology(INDIVIDUALS_LOCATION)

    //manager.setOntologyDocumentIRI(ontology, IRI.create(INDIVIDUALS_IRI))

    if (!individualsOntology.isDefined) {
      logger.info("Cannot load individuals: individuals ontology not loaded")
      return
    }

    logger.info("Loading individuals: " + individualsOntology)

    //individuals = unmarshaller.unmarshal(individualsOntology.get).asInstanceOf[HashSet[PersonImpl]]

    logger.info("Individuals size: " + individuals.size())

    //individuals.forEach(i => logger.info(i.toString))
  }*/

/*   @GET
   @Path("/saveIndividuals")
   def saveIndividuals(): Unit = {

     logger.info("Saving individuals. size: " + individuals.size())

     //individuals.forEach(i => logger.info(i.toString))

     val writer = new FileWriter(INDIVIDUALS_LOCATION)

     //marshaller.marshal(individuals, IRI.create(INDIVIDUALS_IRI), writer, true)

     writer.close()
   }*/

  /*@POST
  @Path("/addIndividual")
  @Consumes(Array[String](MediaType.APPLICATION_JSON))
  def addIndividual(person: PersonImpl): Response = {
    logger.info("Adding individual:")

    logger.info(person.toString)

    //person.setIndividualName(INDIVIDUALS_IRI + "#" + person.getName)

    //individuals.add(person)

    saveIndividuals()

    Response.status(201).entity("Individual successfully added").build();
  }*/

/*  @GET
  @Path("/getIndividual")
  @Produces(Array[String](MediaType.APPLICATION_JSON))
  def getIndividual(@QueryParam("name") name:String): PersonImpl = {

    var individual: PersonImpl = null

    for (person: PersonImpl <- individuals.asScala) {
      if (Utils.extractNameFromURI(person.getName).equals(name)) {
        logger.info("Getting individual: " + person.toString)
        individual = person
      }
    }

    individual
  }*/

  @GET
  @Path("/protege")
  //@Produces(Array[String](MediaType.APPLICATION_JSON))
  def protege(): Unit = {

    val person = factory.createPerson("LUCAS")

    person.addHasAge(30)
    person.addHasSex(factory.createSex("Male"))

    val education = factory.createHigh_school_diploma_and_some_college("High_school_diploma_and_some_college")
    val smoker = factory.createSmoker("Smoker")
    val drinker = factory.createDrinker("Drinker")
    drinker.addHasDrinkPerWeekFrequency(factory.createSeven_or_more_drinks_per_week("Seven_or_more_drinks_per_week"))
    val inactive = factory.createInactive("Inactive")
    val anger = factory.createCritical_of_others("Critical_of_others")
    anger.addHasAdverbFrequency(factory.createOften_or_always("Often_or_always"))

    person.addHasRiskFactor(education)
    person.addHasRiskFactor(smoker)
    person.addHasRiskFactor(drinker)
    person.addHasRiskFactor(inactive)
    person.addHasRiskFactor(anger)

    person.getOwlOntology.saveOntology()
  }

  /*@GET
  @Path("/exampleIndividual")
  @Produces(Array[String](MediaType.APPLICATION_JSON))
  def exampleIndividual(): PersonImpl = {

    val person = new PersonImpl()
    person.setHasAge(62)
    person.setHasSex(new MaleImpl())
    person.setIndividualName("ExamplePerson")

    var riskFactors = new java.util.ArrayList[RiskFactor]()

    val education = new High_school_diploma_and_some_collegeImpl()
    val smoker = new SmokerImpl()
    val drinker = new DrinkerImpl(new _or_more_drinks_per_weekImpl())
    val inactive = new InactiveImpl()
    val anger = new Critical_of_othersImpl(new Often_or_alwaysImpl())

    riskFactors.add(education)
    riskFactors.add(smoker)
    riskFactors.add(drinker)
    riskFactors.add(inactive)
    riskFactors.add(anger)

    person.setHasRiskFactor(riskFactors)

    person
  }*/

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