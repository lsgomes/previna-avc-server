
package model.v8;

import com.yoshtec.owl.annotations.OwlRegistry;


/**
 * Lets you create Classes from an OWL Ontology programmatically.
 * 
 */
@OwlRegistry
public class ObjectFactory {


    /**
     * Create an instance of {@link Psychosocial_factors} Create an instance of {@link Psychosocial_factors}
     * 
     * @param uri
     *     the name of this Object
     */
    public Psychosocial_factors createPsychosocial_factors() {
        return new Psychosocial_factorsImpl();
    }

    public Psychosocial_factors createPsychosocial_factors(String uri) {
        return new Psychosocial_factorsImpl(uri);
    }

    /**
     * Create an instance of {@link Physical_activity} Create an instance of {@link Physical_activity}
     * 
     * @param uri
     *     the name of this Object
     */
    public Physical_activity createPhysical_activity() {
        return new Physical_activityImpl();
    }

    public Physical_activity createPhysical_activity(String uri) {
        return new Physical_activityImpl(uri);
    }

    /**
     * Create an instance of {@link Sex} Create an instance of {@link Sex}
     * 
     * @param uri
     *     the name of this Object
     */
    public Sex createSex() {
        return new SexImpl();
    }

    public Sex createSex(String uri) {
        return new SexImpl(uri);
    }

    /**
     * Create an instance of {@link Smoking_status} Create an instance of {@link Smoking_status}
     * 
     * @param uri
     *     the name of this Object
     */
    public Smoking_status createSmoking_status() {
        return new Smoking_statusImpl();
    }

    public Smoking_status createSmoking_status(String uri) {
        return new Smoking_statusImpl(uri);
    }

    /**
     * Create an instance of {@link Wearable} Create an instance of {@link Wearable}
     * 
     * @param uri
     *     the name of this Object
     */
    public Wearable createWearable() {
        return new WearableImpl();
    }

    public Wearable createWearable(String uri) {
        return new WearableImpl(uri);
    }

    /**
     * Create an instance of {@link Education} Create an instance of {@link Education}
     * 
     * @param uri
     *     the name of this Object
     */
    public Education createEducation() {
        return new EducationImpl();
    }

    public Education createEducation(String uri) {
        return new EducationImpl(uri);
    }

    /**
     * Create an instance of {@link Alcohol_consumption} Create an instance of {@link Alcohol_consumption}
     * 
     * @param uri
     *     the name of this Object
     */
    public Alcohol_consumption createAlcohol_consumption() {
        return new Alcohol_consumptionImpl();
    }

    public Alcohol_consumption createAlcohol_consumption(String uri) {
        return new Alcohol_consumptionImpl(uri);
    }

    /**
     * Create an instance of {@link Heart_disease} Create an instance of {@link Heart_disease}
     * 
     * @param uri
     *     the name of this Object
     */
    public Heart_disease createHeart_disease() {
        return new Heart_diseaseImpl();
    }

    public Heart_disease createHeart_disease(String uri) {
        return new Heart_diseaseImpl(uri);
    }

    /**
     * Create an instance of {@link Person} Create an instance of {@link Person}
     * 
     * @param uri
     *     the name of this Object
     */
    public Person createPerson() {
        return new PersonImpl();
    }

    public Person createPerson(String uri) {
        return new PersonImpl(uri);
    }

    /**
     * Create an instance of {@link Mobile_device} Create an instance of {@link Mobile_device}
     * 
     * @param uri
     *     the name of this Object
     */
    public Mobile_device createMobile_device() {
        return new Mobile_deviceImpl();
    }

    public Mobile_device createMobile_device(String uri) {
        return new Mobile_deviceImpl(uri);
    }

    /**
     * Create an instance of {@link Sensor} Create an instance of {@link Sensor}
     * 
     * @param uri
     *     the name of this Object
     */
    public Sensor createSensor() {
        return new SensorImpl();
    }

    public Sensor createSensor(String uri) {
        return new SensorImpl(uri);
    }

}
