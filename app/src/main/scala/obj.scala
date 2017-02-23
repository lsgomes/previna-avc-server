/**
  * Created by Lucas on 22/02/2017.
  *
  * https://jena.apache.org/tutorials/rdf_api.html
  */

import org.apache.jena.rdf.model.ModelFactory
import org.apache.jena.ontology.{OntClass, OntModel, OntModelSpec}
import org.apache.jena.util.FileManager

object obj extends App {

  val personURI = "http://somewhere/JohnSmith"
  val fullName = "John Smith"

  //val modelFactory = ModelFactory.createDefaultModel()

  //val johnSmith = modelFactory.createResource(personURI)

  //johnSmith.addProperty()

  val model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM)

  val in = FileManager.get().open("stroke_v2.owl")

  model.read(in, null)

  val classList = model.listClasses().toList

  classList.forEach(println)


//  final Query query = QueryFactory.create("PREFIX rdf:<http://www.w3.org/2000/01/rdf-schema#> SELECT distinct ?class WHERE {?class a rdf:Class.}");
//  final ResultSet queryResult = QueryExecutionFactory.create(query, model).execSelect();
//  while (queryResult.hasNext()) {
//    System.out.println(queryResult.next());
//  }

}
