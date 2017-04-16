package server;

import java.io.File;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;
import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.yoshtec.owl.marshall.Marshaller;
import com.yoshtec.owl.marshall.UnMarshaller;
import model.v7.*;
import org.mindswap.pellet.jena.PelletInfGraph;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.InferenceType;
import org.semanticweb.owlapi.reasoner.NodeSet;
import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;


import org.semanticweb.owlapi.apibinding.OWLManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by Lucas on 15/04/2017.
 */
@Singleton
@Path("/rest")
public class OntologyServerJava {

    Logger logger;

    String ONTOLOGY_LOCATION = "ontology/stroke_v7.owl";
    String ONTOLOGY_IRI = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke";
    String QUESTION_MARK = "?";

    //hashset thing
    Collection<Object> individuals;

    OWLOntologyManager manager;
    OWLOntology ontology;

    Marshaller marshaller;
    UnMarshaller unmarshaller;

    PelletReasoner reasoner;
    InfModel model;

    @PostConstruct
    void setupOntologyServer() throws Exception {

        logger = LoggerFactory.getLogger(this.getClass());

        logger.info("Starting Ontology Server.");

        manager = OWLManager.createOWLOntologyManager();

        marshaller = new Marshaller();
        unmarshaller = new UnMarshaller();

        unmarshaller.registerClass(PersonImpl.class);
        unmarshaller.registerClass(RiskFactorImpl.class);
        unmarshaller.registerClass(Alcohol_consumptionImpl.class);
        unmarshaller.registerClass(EducationImpl.class);
        unmarshaller.registerClass(Heart_diseaseImpl.class);
        unmarshaller.registerClass(Physical_activityImpl.class);
        unmarshaller.registerClass(Psychosocial_factorsImpl.class);
        unmarshaller.registerClass(SexImpl.class);
        unmarshaller.registerClass(Smoking_statusImpl.class);
        unmarshaller.registerClass(DeviceImpl.class);
        unmarshaller.registerClass(SensorImpl.class);
        unmarshaller.registerClass(Mobile_deviceImpl.class);
        unmarshaller.registerClass(WearableImpl.class);
        ontology = loadOntology(ONTOLOGY_LOCATION);

        loadReasoner();

        loadQueryExecutor();

        individuals = loadIndividuals(ontology);
    }

    @POST
    @Path("/calculateRiskForPerson")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public PersonImpl calculateRiskForPerson(PersonImpl person) throws Exception {
        logger.info("Checking if individual with name: " + person.getUri() + " exists");

        logger.info(person.toString());

        addOntologyURI(person);

        for (RiskFactor r : person.getHasRiskFactor()) {
            addOntologyURI(r);
        }

        PersonImpl personFromServer = getIndividualFromList(person);

        if (personFromServer != null) {
            logger.info("Removing individual with name: " + person.getHasUserName() + " from list.");
            individuals.remove(personFromServer);
        }

        logger.info("Adding individual with name: " + person.getHasUserName() + " to list.");
        individuals.add(person);

        saveIndividuals();

        String risk = getRiskLevel(person.getHasUserName());

        if (!risk.equals(QUESTION_MARK)) {
            person.setHasRiskLevel(Double.valueOf(risk));
        }

        mapRiskFactorTips(person, executeQueryAndReturnMap(QueriesJava.getRiskFactorsTips()));

        mapRiskFactorAchievements(person, executeQueryAndReturnMap(QueriesJava.getRiskFactorsAchievements()));

        logger.info("Sending person: " + person);

        return person;
    }

    @GET
    @Path("/getRiskLevel")
    @Produces(MediaType.TEXT_PLAIN)
    public String getRiskLevel(@QueryParam("name") String name) {

        logger.info("Getting risk level for " + name);

        String weights = executeQueryAndReturnResult(QueriesJava.calculatePropertiesWeights(name));

        if (weights.equals(QUESTION_MARK)) {
            logger.info("Risk level, weight=? for " + name + ". Field or user may not exist.");
            return QUESTION_MARK;
        }

        String age =  executeQueryAndReturnResult(QueriesJava.calculateAge(name));

        if (age.equals(QUESTION_MARK)) {
            logger.info("Risk level, age=? for " + name + ". Field or user may not exist.");
            return QUESTION_MARK;
        }

        Double total = Double.valueOf(weights)+ Double.valueOf(age);

        logger.info("Risk level result for " + name + ": " + total);

        return RiskCalculatorJava.calculateRiskPercentageRounded(total);
    }

    @GET
    @Path("/saveIndividuals")
    public void saveIndividuals() throws  Exception {

        logger.info("Saving all individuals. size: " + individuals.size());

        marshaller.marshal(individuals, ontology, true);

        manager.saveOntology(ontology);
    }

    String executeQueryAndReturnResult(String query) {
        ResultSet queryResult = executeQuery(query);
        return getResultFromMap(getResultMapFromQuery(queryResult));
    }

    Map<String, String> getResultMapFromQuery(ResultSet result) {
        Map map = new HashMap<String, String>();


        for (String var : result.getResultVars()) {
            if (result.hasNext()) {
                map.put(var, result.nextSolution().getLiteral(var).getString());
            }
        }


//        while (result.hasNext()) {
//            QuerySolution solution = result.nextSolution();
//            Iterator<String> varNames = solution.varNames();
//            while (varNames.hasNext()) {
//                String variable = solution.varNames().next();
//
//                String value = solution.getLiteral(variable).getString();
//                map.put(variable, value);
//            }
//        }

        return map;
    }

    ResultSet executeQuery(String query) {
        logger.info("\n" + query);

        long startTime = System.currentTimeMillis();

        Query q = QueryFactory.create(query);
        QueryExecution queryExecution = QueryExecutionFactory.create(q, model);

        ResultSet select = queryExecution.execSelect();

        logger.info("Query took: "+ (System.currentTimeMillis() - startTime) + " ms");

        return select;
    }


    String getResultFromMap(Map<String, String> map) {

        String result = map.get(QueriesJava.RESULT);

        if (result != null) {
            return result;
        }
        else {
            return QUESTION_MARK;
        }
    }

    Collection<Object> loadIndividuals(OWLOntology ontology) throws Exception {

        logger.info("Loading individuals: " + ontology);

        if (ontology == null) {
            logger.info("Cannot load individuals: ontology " + ontology + " not loaded. Returning empty hash set of individuals");
            return new HashSet<>();
        }

        Collection<Object> list = unmarshaller.unmarshal(ontology);

        logger.info("Individuals size: " + list.size());

        return list;
    }

    void addOntologyURI(Thing individual) {
        if (!individual.getUri().contains("#")) { // or contains ONTOLOGY_URI
            String uri = ONTOLOGY_IRI + "#" + individual.getUri();
            individual.setUri(uri);
        }
    }

    <T> T getIndividualFromList(T individual)
    {
        for (Object i : individuals) {
            Thing thing = (Thing) i;
            Thing ind = (Thing) individual;
            if (UtilsJava.extractNameFromURI(thing.getUri()).equals(ind.getUri())) {
                logger.info("Getting individual: " + i.toString());
                return (T) i;
            }

        }

        logger.error("Not possible to get individual: " + individual + " . Returning null");

        return null;
    }

    OWLOntology loadOntology(String ontologyName) throws OWLOntologyCreationException {

        OWLOntology ontology = null;

        File file = new File(ontologyName);

        if (file.exists()) {
            logger.info("Loading ontology: " + ontologyName);
            ontology = manager.loadOntologyFromOntologyDocument(file);
        } else {
            logger.info("Cannot load ontology: file '" + ontologyName + "' does not exist.");
        }

        return ontology;
    }

    void loadReasoner() {

        if (ontology != null) {

            reasoner = PelletReasonerFactory.getInstance().createReasoner(ontology);
            reasoner.prepareReasoner();
            reasoner.precomputeInferences(InferenceType.CLASS_HIERARCHY, InferenceType.CLASS_ASSERTIONS,
                    InferenceType.OBJECT_PROPERTY_HIERARCHY, InferenceType.DATA_PROPERTY_HIERARCHY);
        }
    }

    void loadQueryExecutor() {
        PelletInfGraph graph = new org.mindswap.pellet.jena.PelletReasoner().bind(reasoner.getKB());
        model = ModelFactory.createInfModel( graph );
    }


    void mapRiskFactorTips(PersonImpl person, Map<String, String> map) {

        for (RiskFactor riskFactor : person.getHasRiskFactor()) {
            String exists = map.get(riskFactor.getUri());  // TODO may necessary to remove the #
            if (exists != null) {
                riskFactor.setHasTip(exists);
            }
        }
    }

    void mapRiskFactorAchievements(PersonImpl person, Map<String, String> map) {

        for (RiskFactor riskFactor : person.getHasRiskFactor()) {
            String exists = map.get(riskFactor.getUri());  // TODO may necessary to remove the #
            if (exists != null) {
                riskFactor.setHasAchievement(exists);
            }
        }
    }


    Map<String, String> executeQueryAndReturnMap(String query) {
        ResultSet queryResult = executeQuery(query);
        return getResultMapFromQuery(queryResult);
    }

}
