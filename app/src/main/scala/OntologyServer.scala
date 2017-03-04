/**
  * Created by dossluca on 27/02/2017.
  */
import java.io.{File, FileWriter}
import java.util.HashSet
import javax.annotation.PostConstruct
import javax.inject.Singleton
import javax.ws.rs._
import javax.ws.rs.core.{MediaType, Response}

import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory
import com.yoshtec.owl.marshall.{Marshaller, UnMarshaller}
import de.derivo.sparqldlapi.{Query, QueryEngine, QueryResult}
import model.PersonImpl
import org.semanticweb.owlapi.apibinding.OWLManager
import org.semanticweb.owlapi.model.{IRI, OWLOntology, OWLOntologyManager}
import org.semanticweb.owlapi.reasoner.InferenceType
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory
import org.slf4j.{Logger, LoggerFactory}

import scala.collection.JavaConverters._

@Singleton
@Path("/rest")
class OntologyServer {

  var logger: Logger = _

  val ONTOLOGY_LOCATION = "ontology/stroke_v2.owl"
  val INDIVIDUALS_LOCATION = "ontology/individuals.owl"

  val INDIVIDUALS_IRI = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke_individuals"

  var manager: OWLOntologyManager = _

  var marshaller: Marshaller = _

  var unmarshaller: UnMarshaller = _

  var individuals: HashSet[PersonImpl] = new HashSet[PersonImpl]

  var strokeOntology: Option[OWLOntology] = None
  var individualsOntology: Option[OWLOntology] = None

  var engine: Option[QueryEngine] = None

  @PostConstruct
  def setupOntologyServer: Unit = {

    logger = LoggerFactory.getLogger(this.getClass)

    logger.info("Starting Ontology Server.")

    //val autoIRIMapper = new AutoIRIMapper(new File("ontology"), false)

    manager = OWLManager.createOWLOntologyManager()
    //manager.addIRIMapper(autoIRIMapper)

    marshaller = new Marshaller()

    unmarshaller = new UnMarshaller()
    unmarshaller.registerClass(classOf[PersonImpl])

    strokeOntology = loadOntology(ONTOLOGY_LOCATION)
    individualsOntology = loadOntology(INDIVIDUALS_LOCATION)

    loadIndividuals()

    loadReasoner()
  }

  def loadReasoner(): Unit = {
    val factory = PelletReasonerFactory.getInstance()

    if (individualsOntology.isDefined) {
      //val reasoner = factory.createReasoner(individualsOntology.get)
      //reasoner.precomputeInferences()
      //logger.info("isConsistent: " + reasoner.isConsistent)


      // Create an instance of an OWL API reasoner (we use the OWL API built-in StructuralReasoner for the purpose of demonstration here)
      val factory = new StructuralReasonerFactory()
      val reasoner = factory.createReasoner(individualsOntology.get)
      // Optionally let the reasoner compute the most relevant inferences in advance
      reasoner.precomputeInferences(InferenceType.CLASS_ASSERTIONS, InferenceType.OBJECT_PROPERTY_ASSERTIONS);
      // Create an instance of the SPARQL-DL query engine

      //https://github.com/protegeproject/sparql-dl-api/blob/master/src/main/java/de/derivo/sparqldlapi/examples/Example_Extended.java
      engine = Some(QueryEngine.create(manager, reasoner))

      //processQuery("ASK {}")

      val results = processQuery(
        Queries.GET_ALL_INDIVIDUALS
      )

      queryResultsToList(results).foreach(i => logger.info(i))



    }

  }

  def queryResultsToList(results: Option[QueryResult]): List[String] = {

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
  }

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

  def loadIndividuals(): Unit = {

    //val ontology = loadOntology(INDIVIDUALS_LOCATION)

    //manager.setOntologyDocumentIRI(ontology, IRI.create(INDIVIDUALS_IRI))

    if (!individualsOntology.isDefined) {
      logger.info("Cannot load individuals: individuals ontology not loaded")
      return
    }

    logger.info("Loading individuals: " + individualsOntology)

    individuals = unmarshaller.unmarshal(individualsOntology.get).asInstanceOf[HashSet[PersonImpl]]

    logger.info("Individuals size: " + individuals.size())

    individuals.forEach(i => logger.info(i.toString))
  }

   @GET
   @Path("/saveIndividuals")
   def saveIndividuals(): Unit = {

     logger.info("Saving individuals. size: " + individuals.size())

     individuals.forEach(i => logger.info(i.toString))

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

    person.setIndividualName(INDIVIDUALS_IRI + "#" + person.getIndividualName)

    individuals.add(person)

    saveIndividuals()

    Response.status(201).entity("Individual successfully added").build();
  }

  @GET
  @Path("/getIndividual")
  @Produces(Array[String](MediaType.APPLICATION_JSON))
  def getIndividual(@QueryParam("name") name:String): PersonImpl = {

    var individual: PersonImpl = null

    for (person: PersonImpl <- individuals.asScala) {
      if (person.getIndividualName.equals(name)) {
        logger.info("Getting individual: " + person.toString)
        individual = person
      }
    }

    individual
  }

  def processQuery(queryString: String) : Option[QueryResult] = {

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
  }

}