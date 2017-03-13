
package model.v5;

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
     * @param name
     *     the name of this Object
     */
    public Psychosocial_factors createPsychosocial_factors() {
        return new Psychosocial_factorsImpl();
    }

    public Psychosocial_factors createPsychosocial_factors(String name) {
        return new Psychosocial_factorsImpl(name);
    }

    /**
     * Create an instance of {@link Ambient_light_sensor} Create an instance of {@link Ambient_light_sensor}
     * 
     * @param name
     *     the name of this Object
     */
    public Ambient_light_sensor createAmbient_light_sensor() {
        return new Ambient_light_sensorImpl();
    }

    public Ambient_light_sensor createAmbient_light_sensor(String name) {
        return new Ambient_light_sensorImpl(name);
    }

    /**
     * Create an instance of {@link Location_sensor} Create an instance of {@link Location_sensor}
     * 
     * @param name
     *     the name of this Object
     */
    public Location_sensor createLocation_sensor() {
        return new Location_sensorImpl();
    }

    public Location_sensor createLocation_sensor(String name) {
        return new Location_sensorImpl(name);
    }

    /**
     * Create an instance of {@link Physical_activity} Create an instance of {@link Physical_activity}
     * 
     * @param name
     *     the name of this Object
     */
    public Physical_activity createPhysical_activity() {
        return new Physical_activityImpl();
    }

    public Physical_activity createPhysical_activity(String name) {
        return new Physical_activityImpl(name);
    }

    /**
     * Create an instance of {@link Sex} Create an instance of {@link Sex}
     * 
     * @param name
     *     the name of this Object
     */
    public Sex createSex() {
        return new SexImpl();
    }

    public Sex createSex(String name) {
        return new SexImpl(name);
    }

    /**
     * Create an instance of {@link Proximity_sensor} Create an instance of {@link Proximity_sensor}
     * 
     * @param name
     *     the name of this Object
     */
    public Proximity_sensor createProximity_sensor() {
        return new Proximity_sensorImpl();
    }

    public Proximity_sensor createProximity_sensor(String name) {
        return new Proximity_sensorImpl(name);
    }

    /**
     * Create an instance of {@link Smoking_status} Create an instance of {@link Smoking_status}
     * 
     * @param name
     *     the name of this Object
     */
    public Smoking_status createSmoking_status() {
        return new Smoking_statusImpl();
    }

    public Smoking_status createSmoking_status(String name) {
        return new Smoking_statusImpl(name);
    }

    /**
     * Create an instance of {@link Login} Create an instance of {@link Login}
     * 
     * @param name
     *     the name of this Object
     */
    public Login createLogin() {
        return new LoginImpl();
    }

    public Login createLogin(String name) {
        return new LoginImpl(name);
    }

    /**
     * Create an instance of {@link Wearable} Create an instance of {@link Wearable}
     * 
     * @param name
     *     the name of this Object
     */
    public Wearable createWearable() {
        return new WearableImpl();
    }

    public Wearable createWearable(String name) {
        return new WearableImpl(name);
    }

    /**
     * Create an instance of {@link Education} Create an instance of {@link Education}
     * 
     * @param name
     *     the name of this Object
     */
    public Education createEducation() {
        return new EducationImpl();
    }

    public Education createEducation(String name) {
        return new EducationImpl(name);
    }

    /**
     * Create an instance of {@link Accelerometer} Create an instance of {@link Accelerometer}
     * 
     * @param name
     *     the name of this Object
     */
    public Accelerometer createAccelerometer() {
        return new AccelerometerImpl();
    }

    public Accelerometer createAccelerometer(String name) {
        return new AccelerometerImpl(name);
    }

    /**
     * Create an instance of {@link Gyroscope} Create an instance of {@link Gyroscope}
     * 
     * @param name
     *     the name of this Object
     */
    public Gyroscope createGyroscope() {
        return new GyroscopeImpl();
    }

    public Gyroscope createGyroscope(String name) {
        return new GyroscopeImpl(name);
    }

    /**
     * Create an instance of {@link Heart_rate_sensor} Create an instance of {@link Heart_rate_sensor}
     * 
     * @param name
     *     the name of this Object
     */
    public Heart_rate_sensor createHeart_rate_sensor() {
        return new Heart_rate_sensorImpl();
    }

    public Heart_rate_sensor createHeart_rate_sensor(String name) {
        return new Heart_rate_sensorImpl(name);
    }

    /**
     * Create an instance of {@link Alcohol_consumption} Create an instance of {@link Alcohol_consumption}
     * 
     * @param name
     *     the name of this Object
     */
    public Alcohol_consumption createAlcohol_consumption() {
        return new Alcohol_consumptionImpl();
    }

    public Alcohol_consumption createAlcohol_consumption(String name) {
        return new Alcohol_consumptionImpl(name);
    }

    /**
     * Create an instance of {@link Barometer} Create an instance of {@link Barometer}
     * 
     * @param name
     *     the name of this Object
     */
    public Barometer createBarometer() {
        return new BarometerImpl();
    }

    public Barometer createBarometer(String name) {
        return new BarometerImpl(name);
    }

    /**
     * Create an instance of {@link Fingerprint_sensor} Create an instance of {@link Fingerprint_sensor}
     * 
     * @param name
     *     the name of this Object
     */
    public Fingerprint_sensor createFingerprint_sensor() {
        return new Fingerprint_sensorImpl();
    }

    public Fingerprint_sensor createFingerprint_sensor(String name) {
        return new Fingerprint_sensorImpl(name);
    }

    /**
     * Create an instance of {@link Heart_disease} Create an instance of {@link Heart_disease}
     * 
     * @param name
     *     the name of this Object
     */
    public Heart_disease createHeart_disease() {
        return new Heart_diseaseImpl();
    }

    public Heart_disease createHeart_disease(String name) {
        return new Heart_diseaseImpl(name);
    }

    /**
     * Create an instance of {@link Person} Create an instance of {@link Person}
     * 
     * @param name
     *     the name of this Object
     */
    public Person createPerson() {
        return new PersonImpl();
    }

    public Person createPerson(String name) {
        return new PersonImpl(name);
    }

    /**
     * Create an instance of {@link Mobile_device} Create an instance of {@link Mobile_device}
     * 
     * @param name
     *     the name of this Object
     */
    public Mobile_device createMobile_device() {
        return new Mobile_deviceImpl();
    }

    public Mobile_device createMobile_device(String name) {
        return new Mobile_deviceImpl(name);
    }

}
