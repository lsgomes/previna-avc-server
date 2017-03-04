/**
  * Created by dossluca on 03/03/2017.
  */
object Queries {
  val GET_ALL_INDIVIDUALS =
    "PREFIX person: <http://www.semanticweb.org/lucas/ontologies/2016/9/stroke_individuals#>\n" +
      "SELECT * WHERE {\n" +
      "Individual(?x)" +
      "}"

  val GET_ALL_INDIVIDUALS2 =
      "PREFIX stroke: <http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#>\n" +
      "PREFIX person: <http://www.semanticweb.org/lucas/ontologies/2016/9/stroke_individuals#>\n" +
      "SELECT ?ind WHERE {\n" +
      " ?ind stroke:hasAge 22" +
      "}"
}