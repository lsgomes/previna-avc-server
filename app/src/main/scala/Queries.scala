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

  def calculateAge(individual: String): String = {
    PREFIX +
      "SELECT DISTINCT (str(?variable) as ?result)\n" +
      "WHERE {stroke:" + individual + " stroke:hasAge ?age \n" +
      "bind(if(?age > 20, ?age - 20, 0) as ?variable)\n" +
      "}"
  }

  def calculateSex2(individual: String): String = {
    PREFIX +
      "SELECT DISTINCT (str(?weight) as ?result)\n" +
      "WHERE {\n" +
      "  stroke:" + individual + " stroke:hasSex ?sex .\n" +
      "    bind (\n" +
      "      if (?sex = stroke:Male, 3,  0) as ?weight\n" +
      "  )\n" +
      "}"
  }

/*  def calculateSex(individual: String): String = {
    PREFIX +
      "SELECT DISTINCT (str(?weight) as ?result)\n" +
      "WHERE {\n" +
      "  stroke:" + individual + " stroke:hasSex ?sex .\n" +
      "  ?sex stroke:hasWeight ?weight\n" +
      "}"
  }*/

  def calculateProperty(individual: String, property: String): String = {
    PREFIX +
      "SELECT DISTINCT (str(?weight) as ?result)\n" +
      "WHERE {\n" +
      "  stroke:" + individual + " stroke: " + property + " ?value .\n" +
      "  ?value stroke:hasWeight ?weight\n" +
      "}"
  }

  def calculateSex(individual: String): String = {
    calculateProperty(individual, "hasSex")
  }


  // query(?x, ?y) :- PropertyValue(?x, hasAge, ?y).
}