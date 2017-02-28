
package model;

import com.yoshtec.owl.annotations.OwlRegistry;


/**
 * Lets you create Classes from an OWL Ontology programmatically.
 * 
 */
@OwlRegistry
public class ObjectFactory {


    /**
     * Create an instance of {@link _drinks_per_week} Create an instance of {@link _drinks_per_week}
     * 
     * @param individualName
     *     the name of this Object
     */
    public _drinks_per_week create_drinks_per_week() {
        return new _drinks_per_weekImpl();
    }

    public _drinks_per_week create_drinks_per_week(String individualName) {
        return new _drinks_per_weekImpl(individualName);
    }

    /**
     * Create an instance of {@link Location_sensor} Create an instance of {@link Location_sensor}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Location_sensor createLocation_sensor() {
        return new Location_sensorImpl();
    }

    public Location_sensor createLocation_sensor(String individualName) {
        return new Location_sensorImpl(individualName);
    }

    /**
     * Create an instance of {@link College_diploma} Create an instance of {@link College_diploma}
     * 
     * @param individualName
     *     the name of this Object
     */
    public College_diploma createCollege_diploma() {
        return new College_diplomaImpl();
    }

    public College_diploma createCollege_diploma(String individualName) {
        return new College_diplomaImpl(individualName);
    }

    /**
     * Create an instance of {@link Proximity_sensor} Create an instance of {@link Proximity_sensor}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Proximity_sensor createProximity_sensor() {
        return new Proximity_sensorImpl();
    }

    public Proximity_sensor createProximity_sensor(String individualName) {
        return new Proximity_sensorImpl(individualName);
    }

    /**
     * Create an instance of {@link Male} Create an instance of {@link Male}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Male createMale() {
        return new MaleImpl();
    }

    public Male createMale(String individualName) {
        return new MaleImpl(individualName);
    }

    /**
     * Create an instance of {@link Drinker} Create an instance of {@link Drinker}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Drinker createDrinker() {
        return new DrinkerImpl();
    }

    public Drinker createDrinker(String individualName) {
        return new DrinkerImpl(individualName);
    }

    /**
     * Create an instance of {@link Often_or_always} Create an instance of {@link Often_or_always}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Often_or_always createOften_or_always() {
        return new Often_or_alwaysImpl();
    }

    public Often_or_always createOften_or_always(String individualName) {
        return new Often_or_alwaysImpl(individualName);
    }

    /**
     * Create an instance of {@link Renal_disease} Create an instance of {@link Renal_disease}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Renal_disease createRenal_disease() {
        return new Renal_diseaseImpl();
    }

    public Renal_disease createRenal_disease(String individualName) {
        return new Renal_diseaseImpl(individualName);
    }

    /**
     * Create an instance of {@link Accelerometer} Create an instance of {@link Accelerometer}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Accelerometer createAccelerometer() {
        return new AccelerometerImpl();
    }

    public Accelerometer createAccelerometer(String individualName) {
        return new AccelerometerImpl(individualName);
    }

    /**
     * Create an instance of {@link Heart_rate_sensor} Create an instance of {@link Heart_rate_sensor}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Heart_rate_sensor createHeart_rate_sensor() {
        return new Heart_rate_sensorImpl();
    }

    public Heart_rate_sensor createHeart_rate_sensor(String individualName) {
        return new Heart_rate_sensorImpl(individualName);
    }

    /**
     * Create an instance of {@link Abstain} Create an instance of {@link Abstain}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Abstain createAbstain() {
        return new AbstainImpl();
    }

    public Abstain createAbstain(String individualName) {
        return new AbstainImpl(individualName);
    }

    /**
     * Create an instance of {@link Login} Create an instance of {@link Login}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Login createLogin() {
        return new LoginImpl();
    }

    public Login createLogin(String individualName) {
        return new LoginImpl(individualName);
    }

    /**
     * Create an instance of {@link Wearable} Create an instance of {@link Wearable}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Wearable createWearable() {
        return new WearableImpl();
    }

    public Wearable createWearable(String individualName) {
        return new WearableImpl(individualName);
    }

    /**
     * Create an instance of {@link Active} Create an instance of {@link Active}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Active createActive() {
        return new ActiveImpl();
    }

    public Active createActive(String individualName) {
        return new ActiveImpl(individualName);
    }

    /**
     * Create an instance of {@link High_school_diploma_and_some_college} Create an instance of {@link High_school_diploma_and_some_college}
     * 
     * @param individualName
     *     the name of this Object
     */
    public High_school_diploma_and_some_college createHigh_school_diploma_and_some_college() {
        return new High_school_diploma_and_some_collegeImpl();
    }

    public High_school_diploma_and_some_college createHigh_school_diploma_and_some_college(String individualName) {
        return new High_school_diploma_and_some_collegeImpl(individualName);
    }

    /**
     * Create an instance of {@link Gyroscope} Create an instance of {@link Gyroscope}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Gyroscope createGyroscope() {
        return new GyroscopeImpl();
    }

    public Gyroscope createGyroscope(String individualName) {
        return new GyroscopeImpl(individualName);
    }

    /**
     * Create an instance of {@link Barometer} Create an instance of {@link Barometer}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Barometer createBarometer() {
        return new BarometerImpl();
    }

    public Barometer createBarometer(String individualName) {
        return new BarometerImpl(individualName);
    }

    /**
     * Create an instance of {@link Person} Create an instance of {@link Person}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Person createPerson() {
        return new PersonImpl();
    }

    public Person createPerson(String individualName) {
        return new PersonImpl(individualName);
    }

    /**
     * Create an instance of {@link Sometimes_or_never} Create an instance of {@link Sometimes_or_never}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Sometimes_or_never createSometimes_or_never() {
        return new Sometimes_or_neverImpl();
    }

    public Sometimes_or_never createSometimes_or_never(String individualName) {
        return new Sometimes_or_neverImpl(individualName);
    }

    /**
     * Create an instance of {@link Peripheral_arterial_disease} Create an instance of {@link Peripheral_arterial_disease}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Peripheral_arterial_disease createPeripheral_arterial_disease() {
        return new Peripheral_arterial_diseaseImpl();
    }

    public Peripheral_arterial_disease createPeripheral_arterial_disease(String individualName) {
        return new Peripheral_arterial_diseaseImpl(individualName);
    }

    /**
     * Create an instance of {@link Ambient_light_sensor} Create an instance of {@link Ambient_light_sensor}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Ambient_light_sensor createAmbient_light_sensor() {
        return new Ambient_light_sensorImpl();
    }

    public Ambient_light_sensor createAmbient_light_sensor(String individualName) {
        return new Ambient_light_sensorImpl(individualName);
    }

    /**
     * Create an instance of {@link Congestive_heart_failure} Create an instance of {@link Congestive_heart_failure}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Congestive_heart_failure createCongestive_heart_failure() {
        return new Congestive_heart_failureImpl();
    }

    public Congestive_heart_failure createCongestive_heart_failure(String individualName) {
        return new Congestive_heart_failureImpl(individualName);
    }

    /**
     * Create an instance of {@link _or_more_drinks_per_week} Create an instance of {@link _or_more_drinks_per_week}
     * 
     * @param individualName
     *     the name of this Object
     */
    public _or_more_drinks_per_week create_or_more_drinks_per_week() {
        return new _or_more_drinks_per_weekImpl();
    }

    public _or_more_drinks_per_week create_or_more_drinks_per_week(String individualName) {
        return new _or_more_drinks_per_weekImpl(individualName);
    }

    /**
     * Create an instance of {@link Former_smoker} Create an instance of {@link Former_smoker}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Former_smoker createFormer_smoker() {
        return new Former_smokerImpl();
    }

    public Former_smoker createFormer_smoker(String individualName) {
        return new Former_smokerImpl(individualName);
    }

    /**
     * Create an instance of {@link _or_2_times_per_week} Create an instance of {@link _or_2_times_per_week}
     * 
     * @param individualName
     *     the name of this Object
     */
    public _or_2_times_per_week create_or_2_times_per_week() {
        return new _or_2_times_per_weekImpl();
    }

    public _or_2_times_per_week create_or_2_times_per_week(String individualName) {
        return new _or_2_times_per_weekImpl(individualName);
    }

    /**
     * Create an instance of {@link Never_smoked} Create an instance of {@link Never_smoked}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Never_smoked createNever_smoked() {
        return new Never_smokedImpl();
    }

    public Never_smoked createNever_smoked(String individualName) {
        return new Never_smokedImpl(individualName);
    }

    /**
     * Create an instance of {@link Smoker} Create an instance of {@link Smoker}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Smoker createSmoker() {
        return new SmokerImpl();
    }

    public Smoker createSmoker(String individualName) {
        return new SmokerImpl(individualName);
    }

    /**
     * Create an instance of {@link Ischemic_heart_disease} Create an instance of {@link Ischemic_heart_disease}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Ischemic_heart_disease createIschemic_heart_disease() {
        return new Ischemic_heart_diseaseImpl();
    }

    public Ischemic_heart_disease createIschemic_heart_disease(String individualName) {
        return new Ischemic_heart_diseaseImpl(individualName);
    }

    /**
     * Create an instance of {@link _or_more_times_per_week} Create an instance of {@link _or_more_times_per_week}
     * 
     * @param individualName
     *     the name of this Object
     */
    public _or_more_times_per_week create_or_more_times_per_week() {
        return new _or_more_times_per_weekImpl();
    }

    public _or_more_times_per_week create_or_more_times_per_week(String individualName) {
        return new _or_more_times_per_weekImpl(individualName);
    }

    /**
     * Create an instance of {@link Critical_of_others} Create an instance of {@link Critical_of_others}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Critical_of_others createCritical_of_others() {
        return new Critical_of_othersImpl();
    }

    public Critical_of_others createCritical_of_others(String individualName) {
        return new Critical_of_othersImpl(individualName);
    }

    /**
     * Create an instance of {@link Inactive} Create an instance of {@link Inactive}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Inactive createInactive() {
        return new InactiveImpl();
    }

    public Inactive createInactive(String individualName) {
        return new InactiveImpl(individualName);
    }

    /**
     * Create an instance of {@link Female} Create an instance of {@link Female}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Female createFemale() {
        return new FemaleImpl();
    }

    public Female createFemale(String individualName) {
        return new FemaleImpl(individualName);
    }

    /**
     * Create an instance of {@link Mobile_device} Create an instance of {@link Mobile_device}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Mobile_device createMobile_device() {
        return new Mobile_deviceImpl();
    }

    public Mobile_device createMobile_device(String individualName) {
        return new Mobile_deviceImpl(individualName);
    }

    /**
     * Create an instance of {@link Hypertension} Create an instance of {@link Hypertension}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Hypertension createHypertension() {
        return new HypertensionImpl();
    }

    public Hypertension createHypertension(String individualName) {
        return new HypertensionImpl(individualName);
    }

    /**
     * Create an instance of {@link Cry_easily} Create an instance of {@link Cry_easily}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Cry_easily createCry_easily() {
        return new Cry_easilyImpl();
    }

    public Cry_easily createCry_easily(String individualName) {
        return new Cry_easilyImpl(individualName);
    }

    /**
     * Create an instance of {@link No_high_school_diploma} Create an instance of {@link No_high_school_diploma}
     * 
     * @param individualName
     *     the name of this Object
     */
    public No_high_school_diploma createNo_high_school_diploma() {
        return new No_high_school_diplomaImpl();
    }

    public No_high_school_diploma createNo_high_school_diploma(String individualName) {
        return new No_high_school_diplomaImpl(individualName);
    }

    /**
     * Create an instance of {@link Fearful} Create an instance of {@link Fearful}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Fearful createFearful() {
        return new FearfulImpl();
    }

    public Fearful createFearful(String individualName) {
        return new FearfulImpl(individualName);
    }

    /**
     * Create an instance of {@link Former_alcoholic} Create an instance of {@link Former_alcoholic}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Former_alcoholic createFormer_alcoholic() {
        return new Former_alcoholicImpl();
    }

    public Former_alcoholic createFormer_alcoholic(String individualName) {
        return new Former_alcoholicImpl(individualName);
    }

    /**
     * Create an instance of {@link Fingerprint_sensor} Create an instance of {@link Fingerprint_sensor}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Fingerprint_sensor createFingerprint_sensor() {
        return new Fingerprint_sensorImpl();
    }

    public Fingerprint_sensor createFingerprint_sensor(String individualName) {
        return new Fingerprint_sensorImpl(individualName);
    }

    /**
     * Create an instance of {@link Diabetes} Create an instance of {@link Diabetes}
     * 
     * @param individualName
     *     the name of this Object
     */
    public Diabetes createDiabetes() {
        return new DiabetesImpl();
    }

    public Diabetes createDiabetes(String individualName) {
        return new DiabetesImpl(individualName);
    }

}
