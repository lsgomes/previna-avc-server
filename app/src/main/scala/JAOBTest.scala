/**
  * Created by dossluca on 27/02/2017.
  */
import java.io.{File, FileWriter}

import com.yoshtec.owl.marshall.Marshaller
import model.PersonImpl
import org.semanticweb.owlapi.model.IRI

import scala.collection.JavaConverters

object JAOBTest extends App {

  val person = new PersonImpl()
  person.setIndividualName("lucas")
  person.setHasAge(24)
  person.setHasRiskLevel(10.0)

  val objectscollection = List(person)

  val javaCollection = JavaConverters.asJavaCollection(objectscollection)

  val marshaller = new Marshaller()

  val writer = new FileWriter("personInd_deep.owl")
  marshaller.marshal(javaCollection , IRI.create("personInd_deep.owl"), writer, true)
  Console.println("aaaaa")
}
