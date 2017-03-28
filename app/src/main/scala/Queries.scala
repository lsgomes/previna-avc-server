/**
  * Created by dossluca on 03/03/2017.
  */
object Queries {

  val RESULT = "result"

  val PREFIX = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
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

  def getAge(individual: String): String = {
    PREFIX +
    "SELECT ?result WHERE { stroke:" + individual + " stroke:hasAge ?result }"
  }

  def calculateAge(individual: String): String = {
    PREFIX +
      "SELECT ?result\n" +
      "WHERE {stroke:" + individual + " stroke:hasAge ?age .\n" +
      "bind(if(?age > 20, ?age - 20, 0) as ?result) .\n" +
      "}"
  }

//  def calculateSex2(individual: String): String = {
//    PREFIX +
//      "SELECT DISTINCT (str(?weight) as ?result)\n" +
//      "WHERE {\n" +
//      "  stroke:" + individual + " stroke:hasSex ?sex .\n" +
//      "    bind (\n" +
//      "      if (?sex = stroke:Male, 3,  0) as ?weight\n" +
//      "  )\n" +
//      "}"
//  }

/*  def calculateSex(individual: String): String = {
    PREFIX +
      "SELECT DISTINCT (str(?weight) as ?result)\n" +
      "WHERE {\n" +
      "  stroke:" + individual + " stroke:hasSex ?sex .\n" +
      "  ?sex stroke:hasWeight ?weight\n" +
      "}"
  }*/

 /* def calculateObjectProperty(individual: String, property: String): String = {
    PREFIX +
      "SELECT DISTINCT (str(?weight) as ?result)\n" +
      "WHERE {\n" +
      "  stroke:" + individual + " stroke: " + property + " ?value .\n" +
      "  ?value stroke:hasWeight ?weight\n" +
      "}"
  }
*/
/*  def calculateSex(individual: String): String = {
    calculateProperty(individual, "hasSex")
  }*/

  def calculatePropertiesWeights(individual: String): String = {
    PREFIX +
      "SELECT (SUM(?weight) as ?result)\n" +
      "WHERE\n" +
      "{\n" +
      "  stroke:" + individual + " stroke:hasRiskFactor ?q .\n" +
      "  ?q stroke:hasWeight ?weight .\n" +
      "}"
  }

  def getRiskFactorsTips(): String = {
    PREFIX +
      "SELECT DISTINCT ?entity ?result\n" +
      "WHERE\n" +
      "{\n"
      "?entity rdf:type/rdfs:subClassOf* stroke:RiskFactor .\n" +
      "?entity stroke:hasTip ?result . \n"
      "}"
  }

  def getRiskFactorsAchievements(): String = {
    PREFIX +
      "SELECT DISTINCT ?entity ?result\n" +
      "WHERE\n" +
      "{\n"
    "?entity rdf:type/rdfs:subClassOf* stroke:RiskFactor .\n" +
      "?entity stroke:hasAchievement ?result . \n"
    "}"
  }

  def riskFactorHasTip(riskFactor: String): String = {
    PREFIX +
      "SELECT ?result\n" +
      "WHERE\n" +
      "{\n"
      "stroke:" + riskFactor + " stroke:hasTip ?result .\n" +
      "}"
  }

  def test(): String = {
    PREFIX +
    "SELECT ?result WHERE \n" +
    "{ bind(1 as ?result) }"

  }

  // query(?x, ?y) :- PropertyValue(?x, hasAge, ?y).
}