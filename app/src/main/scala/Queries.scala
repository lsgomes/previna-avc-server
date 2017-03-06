/**
  * Created by dossluca on 03/03/2017.
  */
object Queries {
  // ?subject ?pred ?object
  private val PREFIX = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
    "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
    "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
    "PREFIX stroke: <http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#>\n" +
    "PREFIX person: <http://www.semanticweb.org/lucas/ontologies/2016/9/stroke_individuals#>\n"

  val GET_ALL_INDIVIDUALS = PREFIX +
      "SELECT * WHERE {\n" +
      "Individual(?x)" +
      " }"

  val SUBJECT_HAS_AGE = PREFIX +
      "SELECT * " +
      "WHERE { ?subject stroke:hasAge ?object }"

  // query(?x, ?y) :- PropertyValue(?x, hasAge, ?y).
}