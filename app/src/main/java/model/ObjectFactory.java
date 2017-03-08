
package model;

import com.yoshtec.owl.annotations.OwlRegistry;


/**
 * Lets you create Classes from an OWL Ontology programmatically.
 * 
 */
@OwlRegistry
public class ObjectFactory {


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
     * Create an instance of {@link College_diploma} Create an instance of {@link College_diploma}
     * 
     * @param name
     *     the name of this Object
     */
    public College_diploma createCollege_diploma() {
        return new College_diplomaImpl();
    }

    public College_diploma createCollege_diploma(String name) {
        return new College_diplomaImpl(name);
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
     * Create an instance of {@link Male} Create an instance of {@link Male}
     * 
     * @param name
     *     the name of this Object
     */
    public Male createMale() {
        return new MaleImpl();
    }

    public Male createMale(String name) {
        return new MaleImpl(name);
    }

    /**
     * Create an instance of {@link Drinker} Create an instance of {@link Drinker}
     * 
     * @param name
     *     the name of this Object
     */
    public Drinker createDrinker() {
        return new DrinkerImpl();
    }

    public Drinker createDrinker(String name) {
        return new DrinkerImpl(name);
    }

    /**
     * Create an instance of {@link Often_or_always} Create an instance of {@link Often_or_always}
     * 
     * @param name
     *     the name of this Object
     */
    public Often_or_always createOften_or_always() {
        return new Often_or_alwaysImpl();
    }

    public Often_or_always createOften_or_always(String name) {
        return new Often_or_alwaysImpl(name);
    }

    /**
     * Create an instance of {@link Renal_disease} Create an instance of {@link Renal_disease}
     * 
     * @param name
     *     the name of this Object
     */
    public Renal_disease createRenal_disease() {
        return new Renal_diseaseImpl();
    }

    public Renal_disease createRenal_disease(String name) {
        return new Renal_diseaseImpl(name);
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
     * Create an instance of {@link Three_or_more_times_per_week} Create an instance of {@link Three_or_more_times_per_week}
     * 
     * @param name
     *     the name of this Object
     */
    public Three_or_more_times_per_week createThree_or_more_times_per_week() {
        return new Three_or_more_times_per_weekImpl();
    }

    public Three_or_more_times_per_week createThree_or_more_times_per_week(String name) {
        return new Three_or_more_times_per_weekImpl(name);
    }

    /**
     * Create an instance of {@link Abstain} Create an instance of {@link Abstain}
     * 
     * @param name
     *     the name of this Object
     */
    public Abstain createAbstain() {
        return new AbstainImpl();
    }

    public Abstain createAbstain(String name) {
        return new AbstainImpl(name);
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
     * Create an instance of {@link Active} Create an instance of {@link Active}
     * 
     * @param name
     *     the name of this Object
     */
    public Active createActive() {
        return new ActiveImpl();
    }

    public Active createActive(String name) {
        return new ActiveImpl(name);
    }

    /**
     * Create an instance of {@link High_school_diploma_and_some_college} Create an instance of {@link High_school_diploma_and_some_college}
     * 
     * @param name
     *     the name of this Object
     */
    public High_school_diploma_and_some_college createHigh_school_diploma_and_some_college() {
        return new High_school_diploma_and_some_collegeImpl();
    }

    public High_school_diploma_and_some_college createHigh_school_diploma_and_some_college(String name) {
        return new High_school_diploma_and_some_collegeImpl(name);
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
     * Create an instance of {@link Seven_or_more_drinks_per_week} Create an instance of {@link Seven_or_more_drinks_per_week}
     * 
     * @param name
     *     the name of this Object
     */
    public Seven_or_more_drinks_per_week createSeven_or_more_drinks_per_week() {
        return new Seven_or_more_drinks_per_weekImpl();
    }

    public Seven_or_more_drinks_per_week createSeven_or_more_drinks_per_week(String name) {
        return new Seven_or_more_drinks_per_weekImpl(name);
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
     * Create an instance of {@link Sometimes_or_never} Create an instance of {@link Sometimes_or_never}
     * 
     * @param name
     *     the name of this Object
     */
    public Sometimes_or_never createSometimes_or_never() {
        return new Sometimes_or_neverImpl();
    }

    public Sometimes_or_never createSometimes_or_never(String name) {
        return new Sometimes_or_neverImpl(name);
    }

    /**
     * Create an instance of {@link Peripheral_arterial_disease} Create an instance of {@link Peripheral_arterial_disease}
     * 
     * @param name
     *     the name of this Object
     */
    public Peripheral_arterial_disease createPeripheral_arterial_disease() {
        return new Peripheral_arterial_diseaseImpl();
    }

    public Peripheral_arterial_disease createPeripheral_arterial_disease(String name) {
        return new Peripheral_arterial_diseaseImpl(name);
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
     * Create an instance of {@link Congestive_heart_failure} Create an instance of {@link Congestive_heart_failure}
     * 
     * @param name
     *     the name of this Object
     */
    public Congestive_heart_failure createCongestive_heart_failure() {
        return new Congestive_heart_failureImpl();
    }

    public Congestive_heart_failure createCongestive_heart_failure(String name) {
        return new Congestive_heart_failureImpl(name);
    }

    /**
     * Create an instance of {@link Former_smoker} Create an instance of {@link Former_smoker}
     * 
     * @param name
     *     the name of this Object
     */
    public Former_smoker createFormer_smoker() {
        return new Former_smokerImpl();
    }

    public Former_smoker createFormer_smoker(String name) {
        return new Former_smokerImpl(name);
    }

    /**
     * Create an instance of {@link Never_smoked} Create an instance of {@link Never_smoked}
     * 
     * @param name
     *     the name of this Object
     */
    public Never_smoked createNever_smoked() {
        return new Never_smokedImpl();
    }

    public Never_smoked createNever_smoked(String name) {
        return new Never_smokedImpl(name);
    }

    /**
     * Create an instance of {@link One_or_two_times_per_week} Create an instance of {@link One_or_two_times_per_week}
     * 
     * @param name
     *     the name of this Object
     */
    public One_or_two_times_per_week createOne_or_two_times_per_week() {
        return new One_or_two_times_per_weekImpl();
    }

    public One_or_two_times_per_week createOne_or_two_times_per_week(String name) {
        return new One_or_two_times_per_weekImpl(name);
    }

    /**
     * Create an instance of {@link Smoker} Create an instance of {@link Smoker}
     * 
     * @param name
     *     the name of this Object
     */
    public Smoker createSmoker() {
        return new SmokerImpl();
    }

    public Smoker createSmoker(String name) {
        return new SmokerImpl(name);
    }

    /**
     * Create an instance of {@link Ischemic_heart_disease} Create an instance of {@link Ischemic_heart_disease}
     * 
     * @param name
     *     the name of this Object
     */
    public Ischemic_heart_disease createIschemic_heart_disease() {
        return new Ischemic_heart_diseaseImpl();
    }

    public Ischemic_heart_disease createIschemic_heart_disease(String name) {
        return new Ischemic_heart_diseaseImpl(name);
    }

    /**
     * Create an instance of {@link Critical_of_others} Create an instance of {@link Critical_of_others}
     * 
     * @param name
     *     the name of this Object
     */
    public Critical_of_others createCritical_of_others() {
        return new Critical_of_othersImpl();
    }

    public Critical_of_others createCritical_of_others(String name) {
        return new Critical_of_othersImpl(name);
    }

    /**
     * Create an instance of {@link Inactive} Create an instance of {@link Inactive}
     * 
     * @param name
     *     the name of this Object
     */
    public Inactive createInactive() {
        return new InactiveImpl();
    }

    public Inactive createInactive(String name) {
        return new InactiveImpl(name);
    }

    /**
     * Create an instance of {@link Female} Create an instance of {@link Female}
     * 
     * @param name
     *     the name of this Object
     */
    public Female createFemale() {
        return new FemaleImpl();
    }

    public Female createFemale(String name) {
        return new FemaleImpl(name);
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

    /**
     * Create an instance of {@link Hypertension} Create an instance of {@link Hypertension}
     * 
     * @param name
     *     the name of this Object
     */
    public Hypertension createHypertension() {
        return new HypertensionImpl();
    }

    public Hypertension createHypertension(String name) {
        return new HypertensionImpl(name);
    }

    /**
     * Create an instance of {@link Cry_easily} Create an instance of {@link Cry_easily}
     * 
     * @param name
     *     the name of this Object
     */
    public Cry_easily createCry_easily() {
        return new Cry_easilyImpl();
    }

    public Cry_easily createCry_easily(String name) {
        return new Cry_easilyImpl(name);
    }

    /**
     * Create an instance of {@link No_high_school_diploma} Create an instance of {@link No_high_school_diploma}
     * 
     * @param name
     *     the name of this Object
     */
    public No_high_school_diploma createNo_high_school_diploma() {
        return new No_high_school_diplomaImpl();
    }

    public No_high_school_diploma createNo_high_school_diploma(String name) {
        return new No_high_school_diplomaImpl(name);
    }

    /**
     * Create an instance of {@link Fearful} Create an instance of {@link Fearful}
     * 
     * @param name
     *     the name of this Object
     */
    public Fearful createFearful() {
        return new FearfulImpl();
    }

    public Fearful createFearful(String name) {
        return new FearfulImpl(name);
    }

    /**
     * Create an instance of {@link Former_alcoholic} Create an instance of {@link Former_alcoholic}
     * 
     * @param name
     *     the name of this Object
     */
    public Former_alcoholic createFormer_alcoholic() {
        return new Former_alcoholicImpl();
    }

    public Former_alcoholic createFormer_alcoholic(String name) {
        return new Former_alcoholicImpl(name);
    }

    /**
     * Create an instance of {@link One_to_six_drinks_per_week} Create an instance of {@link One_to_six_drinks_per_week}
     * 
     * @param name
     *     the name of this Object
     */
    public One_to_six_drinks_per_week createOne_to_six_drinks_per_week() {
        return new One_to_six_drinks_per_weekImpl();
    }

    public One_to_six_drinks_per_week createOne_to_six_drinks_per_week(String name) {
        return new One_to_six_drinks_per_weekImpl(name);
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
     * Create an instance of {@link Diabetes} Create an instance of {@link Diabetes}
     * 
     * @param name
     *     the name of this Object
     */
    public Diabetes createDiabetes() {
        return new DiabetesImpl();
    }

    public Diabetes createDiabetes(String name) {
        return new DiabetesImpl(name);
    }

}
