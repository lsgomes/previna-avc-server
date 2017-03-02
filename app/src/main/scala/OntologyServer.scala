/**
  * Created by dossluca on 27/02/2017.
  */
import java.io.{File, FileWriter}
import java.util.HashSet
import javax.annotation.PostConstruct
import javax.inject.Singleton
import javax.ws.rs._
import javax.ws.rs.core.{MediaType, Response}

import com.yoshtec.owl.marshall.{Marshaller, UnMarshaller}
import model.PersonImpl
import org.semanticweb.owlapi.apibinding.OWLManager
import org.semanticweb.owlapi.model.{IRI, OWLOntology, OWLOntologyManager}
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


    loadOntology(ONTOLOGY_LOCATION)

    loadIndividuals()
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

    val ontology = loadOntology(INDIVIDUALS_LOCATION)

    //manager.setOntologyDocumentIRI(ontology, IRI.create(INDIVIDUALS_IRI))

    if (!ontology.isDefined) {
      logger.info("Cannot load individuals: individuals ontology not loaded")
      return
    }

    logger.info("Loading individuals: " + ontology)

    individuals = unmarshaller.unmarshal(ontology.get).asInstanceOf[HashSet[PersonImpl]]

    logger.info("Individuals size: " + individuals.size())

    individuals.forEach(i => logger.info(i.toString))
  }

   @GET
   @Path("/saveIndividuals")
   def saveIndividuals(): Unit = {
     logger.info("Saving individuals. size: " + individuals.size())

     individuals.forEach(i => logger.info(i.toString))

     val writer = new FileWriter(INDIVIDUALS_LOCATION)

     marshaller.marshal(individuals, IRI.create(INDIVIDUALS_IRI), IRI.create(INDIVIDUALS_LOCATION), writer, true)

     writer.close()
   }

  @POST
  @Path("/addIndividual")
  @Consumes(Array[String](MediaType.APPLICATION_JSON))
  def addIndividual(person: PersonImpl): Response = {
    logger.info("Adding individual:")

    logger.info(person.toString)

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

}