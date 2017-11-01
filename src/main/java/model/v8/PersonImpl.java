
package model.v8;

import java.util.ArrayList;
import java.util.List;
import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlDataProperty;
import com.yoshtec.owl.annotations.OwlDataType;
import com.yoshtec.owl.annotations.OwlIndividualId;
import com.yoshtec.owl.annotations.OwlObjectProperty;
import com.yoshtec.owl.annotations.dprop.OwlFunctionalDataProperty;

@OwlClassImplementation({
    Person.class
})
public class PersonImpl
    implements Person
{

    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasAge</code>
     * 
     */
    @OwlDataProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasAge")
    @OwlFunctionalDataProperty
    @OwlDataType(uri = "http://www.w3.org/2001/XMLSchema#int")
    protected Integer hasAge;
    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasRiskFactor</code>
     * 
     */
    @OwlObjectProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasRiskFactor")
    @OwlDataType(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#RiskFactor")
    protected List<RiskFactor> hasRiskFactor;
    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasRiskLevel</code>
     * 
     */
    @OwlDataProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasRiskLevel")
    @OwlFunctionalDataProperty
    @OwlDataType(uri = "http://www.w3.org/2001/XMLSchema#double")
    protected Double hasRiskLevel;
    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasPassword</code>
     * 
     */
    @OwlDataProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasPassword")
    @OwlFunctionalDataProperty
    @OwlDataType(uri = "http://www.w3.org/2001/XMLSchema#string")
    protected String hasPassword;
    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasDevice</code>
     * 
     */
    @OwlObjectProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasDevice")
    @OwlDataType(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Device")
    protected List<Device> hasDevice;
    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String uri;
    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasUserName</code>
     * 
     */
    @OwlDataProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasUserName")
    @OwlFunctionalDataProperty
    @OwlDataType(uri = "http://www.w3.org/2001/XMLSchema#string")
    protected String hasUserName;

    @OwlDataProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasBloodGlucose")
    @OwlFunctionalDataProperty
    @OwlDataType(uri = "http://www.w3.org/2001/XMLSchema#string")
    protected String hasBloodGlucose;

    @OwlDataProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasBloodPressure")
    @OwlFunctionalDataProperty
    @OwlDataType(uri = "http://www.w3.org/2001/XMLSchema#string")
    protected String hasBloodPressure;

    @OwlDataProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasBloodAlcoholContent")
    @OwlFunctionalDataProperty
    @OwlDataType(uri = "http://www.w3.org/2001/XMLSchema#string")
    protected String hasBloodAlcoholContent;

    @OwlDataProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasStepsCount")
    @OwlFunctionalDataProperty
    @OwlDataType(uri = "http://www.w3.org/2001/XMLSchema#string")
    protected String hasStepsCount;

    public PersonImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public PersonImpl(String uri) {
        this.uri = uri;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public Integer getHasAge() {
        return hasAge;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasAge(Integer hasAge) {
        this.hasAge = hasAge;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public List<RiskFactor> getHasRiskFactor() {
        if (hasRiskFactor == null) {
            hasRiskFactor = new ArrayList<RiskFactor>();
        }
        return hasRiskFactor;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasRiskFactor(List<RiskFactor> hasRiskFactor) {
        this.hasRiskFactor = hasRiskFactor;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public Double getHasRiskLevel() {
        return hasRiskLevel;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasRiskLevel(Double hasRiskLevel) {
        this.hasRiskLevel = hasRiskLevel;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public String getHasPassword() {
        return hasPassword;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasPassword(String hasPassword) {
        this.hasPassword = hasPassword;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public List<Device> getHasDevice() {
        if (hasDevice == null) {
            hasDevice = new ArrayList<Device>();
        }
        return hasDevice;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasDevice(List<Device> hasDevice) {
        this.hasDevice = hasDevice;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public String getUri() {
        return uri;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public String getHasUserName() {
        return hasUserName;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasUserName(String hasUserName) {
        this.hasUserName = hasUserName;
    }


    public String getHasBloodGlucose() {
        return hasBloodGlucose;
    }

    public void setHasBloodGlucose(String hasBloodGlucose) {
        this.hasBloodGlucose = hasBloodGlucose;
    }

    public String getHasBloodPressure() {
        return hasBloodPressure;
    }

    public void setHasBloodPressure(String hasBloodPressure) {
        this.hasBloodPressure = hasBloodPressure;
    }

    public String getHasBloodAlcoholContent() {
        return hasBloodAlcoholContent;
    }

    public void setHasBloodAlcoholContent(String hasBloodAlcoholContent) {
        this.hasBloodAlcoholContent = hasBloodAlcoholContent;
    }

    public String getHasStepsCount() {
        return hasStepsCount;
    }

    public void setHasStepsCount(String hasStepsCount) {
        this.hasStepsCount = hasStepsCount;
    }

    @Override
    public String toString() {
        return "PersonImpl{" +
                "hasAge=" + hasAge +
                ", hasRiskFactor=" + hasRiskFactor +
                ", hasRiskLevel=" + hasRiskLevel +
                ", hasPassword='" + hasPassword + '\'' +
                ", hasDevice=" + hasDevice +
                ", uri='" + uri + '\'' +
                ", hasUserName='" + hasUserName + '\'' +
                ", hasBloodGlucose='" + hasBloodGlucose + '\'' +
                ", hasBloodPressure='" + hasBloodPressure + '\'' +
                ", hasBloodAlcoholContent='" + hasBloodAlcoholContent + '\'' +
                ", hasStepsCount='" + hasStepsCount + '\'' +
                '}';
    }
}
