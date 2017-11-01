package server;

/**
 * Created by Lucas on 15/04/2017.
 */
public class QueriesJava {

    static String RESULT = "result";

    static String PREFIX = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
            "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
            "PREFIX stroke: <http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#>\n" +
            "PREFIX person: <http://www.semanticweb.org/lucas/ontologies/2016/9/stroke_individuals#>\n";

    static String calculateAge(String individual) {
        return PREFIX +
                "SELECT ?result\n" +
                "WHERE {stroke:" + individual + " stroke:hasAge ?age .\n" +
                "bind(if(?age > 20, ?age - 20, 0) as ?result) .\n" +
                "}";
    }

    static String calculatePropertiesWeights(String individual) {
        return PREFIX +
                "SELECT (SUM(?weight) as ?result)\n" +
                "WHERE\n" +
                "{\n" +
                "  stroke:" + individual + " stroke:hasRiskFactor ?q .\n" +
                "  ?q stroke:hasWeight ?weight .\n" +
                "}";
    }

    static String getRiskFactorsTips() {
        return PREFIX +
                "SELECT DISTINCT ?entity ?result\n" +
                "WHERE\n" +
                "{\n" +
                 "?entity rdf:type/rdfs:subClassOf* stroke:RiskFactor .\n" +
                "?entity stroke:hasTip ?result . \n" +
                 "}";
    }

    static String getRiskFactorsAchievements() {
        return PREFIX +
                "SELECT DISTINCT ?entity ?result\n" +
                "WHERE\n" +
                "{\n" +
                "?entity rdf:type/rdfs:subClassOf* stroke:RiskFactor .\n" +
                "?entity stroke:hasAchievement ?result . \n" +
                 "}";
    }
}
