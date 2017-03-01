/**
  * Created by dossluca on 27/02/2017.
  */
import java.io.{File, FileInputStream, FileReader, FileWriter}
import java.util
import java.util.HashSet
import java.util.Collection
import javax.annotation.{PostConstruct, Resource}
import javax.inject.Singleton
import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, Produces}

import org.slf4j.Logger
import com.yoshtec.owl.marshall.Marshaller
import com.yoshtec.owl.marshall.UnMarshaller
import model.PersonImpl
import org.semanticweb.owlapi.apibinding.OWLManager
import org.semanticweb.owlapi.model.{IRI, OWLOntology, OWLOntologyManager}
import org.slf4j.LoggerFactory
import uk.ac.manchester.cs.owl.owlapi.OWLOntologyManagerImpl

import scala.collection.JavaConverters

@Singleton
@Path("/rest")
class OntologyServer {

  var logger: Logger = _

  val ONTOLOGY_LOCATION = "stroke_v2.owl"
  val INDIVIDUALS_LOCATION = "individuals.owl"

  var manager: OWLOntologyManager = _

  var marshaller: Marshaller = _

  var unmarshaller: UnMarshaller = _

  var individuals: util.HashSet[PersonImpl] = _

  @PostConstruct
  def setupOntologyServer: Unit = {

    logger = LoggerFactory.getLogger(this.getClass)

    logger.info("Starting Ontology Server.")

    manager = OWLManager.createOWLOntologyManager()

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

  def loadOntology(ontology: String): OWLOntology = {
    logger.info("Loading ontology: " + ontology)

    val file = new File(ontology)

    manager.loadOntologyFromOntologyDocument(file)
  }

  def loadIndividuals(): Unit = {

    val ontology = loadOntology(INDIVIDUALS_LOCATION)

    logger.info("Loading individuals: " + ontology)

    individuals = unmarshaller.unmarshal(ontology).asInstanceOf[HashSet[PersonImpl]]

    logger.info("Individuals size: " + individuals.size())

    individuals.forEach(i => logger.info(i.getIndividualName))
  }

   @GET
   @Path("/saveIndividuals")
   def saveIndividuals(): Unit = {
     logger.info("Saving individuals. size: " + individuals.size())

     val writer = new FileWriter(INDIVIDUALS_LOCATION)

     marshaller.marshal(individuals, IRI.create(INDIVIDUALS_LOCATION), writer, true)

     writer.close()
   }

  @GET
  @Path("/addIndividual")
  def addIndividual(): Unit = {
    logger.info("Adding individual")

    val person = new PersonImpl()
    person.setHasAge(21)
    person.setIndividualName("lucas2")
    person.setHasRiskLevel(3.0)

    individuals.add(person)

    saveIndividuals()
  }

}