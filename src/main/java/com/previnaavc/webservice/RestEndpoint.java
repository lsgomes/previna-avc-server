package com.previnaavc.webservice;

import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;
import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.previnaavc.model.Achievements;
import com.previnaavc.model.RiskFactorTips;
import com.previnaavc.model.TypeOfEntity;
import com.previnaavc.model.v8.*;
import com.previnaavc.webservice.utils.QueriesJava;
import com.previnaavc.webservice.utils.RiskCalculatorJava;
import com.previnaavc.webservice.utils.UtilsJava;
import com.yoshtec.owl.marshall.Marshaller;
import com.yoshtec.owl.marshall.UnMarshaller;
import org.apache.log4j.Logger;
import org.mindswap.pellet.jena.PelletInfGraph;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.*;

/**
 * Created by Lucas on 15/04/2017.
 */
@RestController
@RequestMapping("/rest")
public class RestEndpoint {

    Logger logger;

    String ONTOLOGY_LOCATION = "ontology/stroke_v8.owl";
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

        logger = Logger.getLogger(this.getClass());

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

    @PostMapping(
            value = "/calculateRiskForPerson",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonImpl calculateRiskForPerson(Locale locale,
                                             @RequestBody PersonImpl person) throws Exception {

        for (RiskFactor riskFactor : person.getHasRiskFactor()) {
            if (riskFactor.getHasAchievement() != null) {
                String achievement = Achievements.valueOf(riskFactor.getUri().split("#")[1].toUpperCase()).getTip(new Locale("pt", "br"));
                riskFactor.setHasAchievement(achievement);
            }
            if (riskFactor.getHasTip() != null) {
                String tip = RiskFactorTips.valueOf(riskFactor.getUri().split("#")[1].toUpperCase()).getTip(new Locale("pt", "br"));
                riskFactor.setHasTip(tip);
            }
        }

        logger.info("Checking if individual with name: " + person.getUri() + " exists");

        logger.info("PersonFromClient" + person.toString());

        addOntologyURI(person);

        for (RiskFactor r : person.getHasRiskFactor()) {
            addOntologyURI(r);
        }

        PersonImpl personFromServer = getIndividualFromList(person);

        if (personFromServer != null) {
            logger.info("PersonFromServer: " + personFromServer.toString());
            logger.info("Removing individual with name: " + person.getHasUserName() + " from list.");
            individuals.remove(personFromServer);
        }

        logger.info("Adding individual with name: " + person.getHasUserName() + " to list.");
        individuals.add(person);

        saveIndividuals();

        loadReasoner();

        loadQueryExecutor();

        //ontology = loadOntology(ONTOLOGY_LOCATION);

        String risk = getRiskLevel(UtilsJava.extractNameFromURI(person.getHasUserName()));

        if (!risk.equals(QUESTION_MARK)) {
            person.setHasRiskLevel(Double.valueOf(risk));
        }

        mapRiskFactorTips(person, executeQueryAndReturnMapEntitiesLiterals(locale, QueriesJava.getRiskFactorsTips(), TypeOfEntity.RISK_FACTOR));

        mapRiskFactorAchievements(person, executeQueryAndReturnMapEntitiesLiterals(locale, QueriesJava.getRiskFactorsAchievements(), TypeOfEntity.ACHIEVEMENT));

        logger.info("Sending Person: " + person.toString());

        return person;
    }

    @GetMapping(
            value = "/getRiskLevel",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String getRiskLevel(@RequestParam("name") String name) {

        logger.info("Getting risk level for " + name);

        String weights = executeQueryAndReturnResult(QueriesJava.calculatePropertiesWeights(name));

        if (weights.equals(QUESTION_MARK)) {
            logger.info("Risk level, weight=? for " + name + ". Field or user may not exist.");
            return QUESTION_MARK;
        }

        String age = executeQueryAndReturnResult(QueriesJava.calculateAge(name));

        if (age.equals(QUESTION_MARK)) {
            logger.info("Risk level, age=? for " + name + ". Field or user may not exist.");
            return QUESTION_MARK;
        }

        Double total = Double.valueOf(weights) + Double.valueOf(age);

        logger.info("Risk level result for " + name + ": " + total);

        return RiskCalculatorJava.calculateRiskPercentageRounded(total);
    }

    @GetMapping(
            value = "/examplePerson",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonImpl examplePerson() throws Exception {
        PersonImpl john = new PersonImpl();
        john.setUri(ONTOLOGY_IRI + "#John");
        john = getIndividualFromList(john);
        return john;
    }

    @GetMapping(
            value = "/saveIndividuals"
    )
    public void saveIndividuals() throws Exception {

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
            map.put(var, result.nextSolution().getLiteral(var).getString());
        }

//        result.forEachRemaining(r -> {
//
//            r.varNames().forEachRemaining(v -> {
//
//                map.put(v, r.getLiteral(v).getString());
//
//            });
//
//        });


//        result.forEachRemaining(r -> {
//
//
//                map.put("result", r.getLiteral("result").getString());

//                r.varNames().forEachRemaining(v -> {
//
//                    RDFNode node = r.get(v);
//
//                    if (node.isLiteral()) {
//                    map.put(v, node.asLiteral().getString());
//                    }
//                     else if (node.isResource()) {
//                    map.put(v, node.asResource().toString());
//                    }
//
//            });

        // });

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

    Map<String, String> mapEntitiesLiterals(Locale locale, ResultSet result, TypeOfEntity typeOfEntity) {
        Map map = new HashMap<String, String>();

        result.forEachRemaining(r -> {
            String riskFactor;
            try {
                if (TypeOfEntity.RISK_FACTOR.equals(typeOfEntity))
                    riskFactor = RiskFactorTips.valueOf(r.get("entity").asResource().getLocalName().toUpperCase()).getTip(locale);
                else if (TypeOfEntity.ACHIEVEMENT.equals(typeOfEntity))
                    riskFactor = Achievements.valueOf(r.get("entity").asResource().getLocalName().toUpperCase()).getTip(locale);
                else
                    riskFactor = r.get("result").asLiteral().getString();
            } catch (Exception error) {
                riskFactor = r.get("result").asLiteral().getString();
            }

            map.put(
                    r.get("entity").asResource().toString(),
                    riskFactor);
        });

        return map;
    }


    ResultSet executeQuery(String query) {
        logger.info("\n" + query);

        long startTime = System.currentTimeMillis();

        Query q = QueryFactory.create(query);
        QueryExecution queryExecution = QueryExecutionFactory.create(q, model);

        ResultSet select = queryExecution.execSelect();

        logger.info("Query took: " + (System.currentTimeMillis() - startTime) + " ms");

//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//
//        ResultSetRewindable r = ResultSetFactory.copyResults(select);
//        ResultSetFormatter.out(baos, r);
//
//        logger.info(new String(baos.toByteArray()));

        return select;
    }


    String getResultFromMap(Map<String, String> map) {

        String result = map.get(QueriesJava.RESULT);

        if (result != null) {
            return result;
        } else {
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

    <T> T getIndividualFromList(T individual) {
        for (Object i : individuals) {
            Thing thing = (Thing) i;
            Thing ind = (Thing) individual;
            // UtilsJava.extractNameFromURI(thing.getUri()).equals(ind.getUri())
            if (thing.getUri().equals(ind.getUri())) {
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
            //reasoner.prepareReasoner();
            //reasoner.precomputeInferences(InferenceType.CLASS_HIERARCHY, InferenceType.CLASS_ASSERTIONS,
            //        InferenceType.OBJECT_PROPERTY_HIERARCHY, InferenceType.DATA_PROPERTY_HIERARCHY);
        }
    }

    void loadQueryExecutor() {
        PelletInfGraph graph = new org.mindswap.pellet.jena.PelletReasoner().bind(reasoner.getKB());
        model = ModelFactory.createInfModel(graph);
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

    Map<String, String> executeQueryAndReturnMapEntitiesLiterals(Locale locale, String query, TypeOfEntity typeOfEntity) {
        ResultSet queryResult = executeQuery(query);
        return mapEntitiesLiterals(locale, queryResult, typeOfEntity);
    }


}
