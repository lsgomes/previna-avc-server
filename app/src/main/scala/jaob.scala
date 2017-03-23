import java.io.{File, FileWriter}

import com.yoshtec.owl.marshall.{Marshaller, UnMarshaller}
import model.v6._
import org.semanticweb.owlapi.apibinding.OWLManager
import org.semanticweb.owlapi.model.IRI

/**
  * Created by Lucas on 22/03/2017.
  */
object jaob extends App {

  val ONTOLOGY_LOCATION = "ontology/stroke_v6.owl"
  //val INDIVIDUALS_LOCATION = "ontology/individuals.owl"

  val marshaller = new Marshaller()

  val unmarshaller = new UnMarshaller()

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

  val manager = OWLManager.createOWLOntologyManager()
  val stroke = manager.loadOntologyFromOntologyDocument(new File(ONTOLOGY_LOCATION))

  val list = unmarshaller.unmarshal(stroke)

  val person = new PersonImpl("teste")
  person.setHasAge(12)
  person.setHasUserName("testeUser")
  list.add(person)
  //val writer = new FileWriter("ontology/jaob.owl")

  val stroke2 = marshaller.marshal(list, stroke, true)
  manager.saveOntology(stroke2)
  print("Done")
}
