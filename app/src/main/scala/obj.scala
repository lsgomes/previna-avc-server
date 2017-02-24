/**
  * Created by Lucas on 22/02/2017.
  *
  * https://jena.apache.org/tutorials/rdf_api.html
  */

import org.apache.jena.rdf.model.ModelFactory
import org.apache.jena.ontology.{OntClass, OntModel, OntModelSpec}
import org.apache.jena.util.FileManager
import org.apache.jena.vocabulary.VCARD
import org.apache.jena.ontology.OntDocumentManager

object obj extends App {

  val namespace = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#"

  val personURI = "http://somewhere/JohnSmith"
  val fullName = "John Smith"

  //val modelFactory = ModelFactory.createDefaultModel()

  //val johnSmith = modelFactory.createResource(personURI)

  //johnSmith.addProperty()

  val ontologyDocumentManager = new OntDocumentManager()

  ontologyDocumentManager.setProcessImports(true)

  val ontologyModelSpec = new OntModelSpec( OntModelSpec.OWL_MEM_TRANS_INF )

  ontologyModelSpec.setDocumentManager(ontologyDocumentManager)

  val modelOntology = ModelFactory.createOntologyModel(ontologyModelSpec)


  val model = ModelFactory.createDefaultModel()

  val in = FileManager.get().open("stroke_v2.owl")

  //model.read(in, null)

  modelOntology.read(in, null)


  val lucas = model.createResource("lucas")

  //modelOntology.write(System.out)



  //modelOntology.listAllOntProperties().toList.forEach(println)

  //val person =  modelOntology.getOntClass(namespace + "Person")

  //person.listDeclaredProperties().toList.forEach(p => println(p.getLocalName))

  val resourcePerson = modelOntology.getResource( namespace + "Person" )

  modelOntology.listIndividuals().toList.forEach(println)
  modelOntology.imp
  val personLucas = modelOntology.createIndividual("Person Lucas", resourcePerson)

  val hasAge = modelOntology.getProperty(namespace + "hasAge")

  //val age = personLucas.addProperty(hasAge, "26")

  println(personLucas.getProperty(hasAge))
  //xprintln(personLucas.getProperty(hasSex))

  personLucas.listOntClasses(true).toList.forEach(println)
  println(personLucas.hasProperty(hasAge))

  //modelOntology.listIndividuals().toList.forEach(i => i.getOntClass.listDeclaredProperties().toList.forEach(println))


 // val classList = model.listClasses().toList

  //classList.forEach(println)



//  final Query query = QueryFactory.create("PREFIX rdf:<http://www.w3.org/2000/01/rdf-schema#> SELECT distinct ?class WHERE {?class a rdf:Class.}");
//  final ResultSet queryResult = QueryExecutionFactory.create(query, model).execSelect();
//  while (queryResult.hasNext()) {
//    System.out.println(queryResult.next());
//  }

}
