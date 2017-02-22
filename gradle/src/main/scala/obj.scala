/**
  * Created by Lucas on 22/02/2017.
  *
  * https://jena.apache.org/tutorials/rdf_api.html
  */

import org.apache.jena.rdf.model.ModelFactory

object obj extends App {

  val personURI = "http://somewhere/JohnSmith"
  val fullName = "John Smith"

  val modelFactory = ModelFactory.createDefaultModel()

  val johnSmith = modelFactory.createResource(personURI)

  //johnSmith.addProperty()
}
