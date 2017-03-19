
package model.v6;

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
     * @param id
     *     the name of this Object
     */
    public Psychosocial_factors createPsychosocial_factors() {
        return new Psychosocial_factorsImpl();
    }

    public Psychosocial_factors createPsychosocial_factors(String id) {
        return new Psychosocial_factorsImpl(id);
    }

    /**
     * Create an instance of {@link Physical_activity} Create an instance of {@link Physical_activity}
     * 
     * @param id
     *     the name of this Object
     */
    public Physical_activity createPhysical_activity() {
        return new Physical_activityImpl();
    }

    public Physical_activity createPhysical_activity(String id) {
        return new Physical_activityImpl(id);
    }

    /**
     * Create an instance of {@link Sex} Create an instance of {@link Sex}
     * 
     * @param id
     *     the name of this Object
     */
    public Sex createSex() {
        return new SexImpl();
    }

    public Sex createSex(String id) {
        return new SexImpl(id);
    }

    /**
     * Create an instance of {@link Smoking_status} Create an instance of {@link Smoking_status}
     * 
     * @param id
     *     the name of this Object
     */
    public Smoking_status createSmoking_status() {
        return new Smoking_statusImpl();
    }

    public Smoking_status createSmoking_status(String id) {
        return new Smoking_statusImpl(id);
    }

    /**
     * Create an instance of {@link Wearable} Create an instance of {@link Wearable}
     * 
     * @param id
     *     the name of this Object
     */
    public Wearable createWearable() {
        return new WearableImpl();
    }

    public Wearable createWearable(String id) {
        return new WearableImpl(id);
    }

    /**
     * Create an instance of {@link Education} Create an instance of {@link Education}
     * 
     * @param id
     *     the name of this Object
     */
    public Education createEducation() {
        return new EducationImpl();
    }

    public Education createEducation(String id) {
        return new EducationImpl(id);
    }

    /**
     * Create an instance of {@link Alcohol_consumption} Create an instance of {@link Alcohol_consumption}
     * 
     * @param id
     *     the name of this Object
     */
    public Alcohol_consumption createAlcohol_consumption() {
        return new Alcohol_consumptionImpl();
    }

    public Alcohol_consumption createAlcohol_consumption(String id) {
        return new Alcohol_consumptionImpl(id);
    }

    /**
     * Create an instance of {@link Heart_disease} Create an instance of {@link Heart_disease}
     * 
     * @param id
     *     the name of this Object
     */
    public Heart_disease createHeart_disease() {
        return new Heart_diseaseImpl();
    }

    public Heart_disease createHeart_disease(String id) {
        return new Heart_diseaseImpl(id);
    }

    /**
     * Create an instance of {@link Person} Create an instance of {@link Person}
     * 
     * @param id
     *     the name of this Object
     */
    public Person createPerson() {
        return new PersonImpl();
    }

    public Person createPerson(String id) {
        return new PersonImpl(id);
    }

    /**
     * Create an instance of {@link Mobile_device} Create an instance of {@link Mobile_device}
     * 
     * @param id
     *     the name of this Object
     */
    public Mobile_device createMobile_device() {
        return new Mobile_deviceImpl();
    }

    public Mobile_device createMobile_device(String id) {
        return new Mobile_deviceImpl(id);
    }

    /**
     * Create an instance of {@link Sensor} Create an instance of {@link Sensor}
     * 
     * @param id
     *     the name of this Object
     */
    public Sensor createSensor() {
        return new SensorImpl();
    }

    public Sensor createSensor(String id) {
        return new SensorImpl(id);
    }

}
