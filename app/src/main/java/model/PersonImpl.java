
package model;

import java.util.ArrayList;
import java.util.List;
import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlDataProperty;
import com.yoshtec.owl.annotations.OwlDataType;
import com.yoshtec.owl.annotations.OwlIndividualId;
import com.yoshtec.owl.annotations.OwlObjectProperty;

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
    @OwlDataType(uri = "http://www.w3.org/2001/XMLSchema#double")
    protected Double hasRiskLevel;
    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasSex</code>
     * 
     */
    @OwlObjectProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasSex")
    @OwlDataType(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Sex")
    protected Sex hasSex;
    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String individualName;
    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasLogin</code>
     * 
     */
    @OwlObjectProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasLogin")
    @OwlDataType(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Login")
    protected Login hasLogin;
    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasDevice</code>
     * 
     */
    @OwlObjectProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasDevice")
    @OwlDataType(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Device")
    protected List<Device> hasDevice;

    public PersonImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public PersonImpl(String individualName) {
        this.individualName = individualName;
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
    public Sex getHasSex() {
        return hasSex;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasSex(Sex hasSex) {
        this.hasSex = hasSex;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public String getIndividualName() {
        return individualName;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setIndividualName(String individualName) {
        this.individualName = individualName;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public Login getHasLogin() {
        return hasLogin;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasLogin(Login hasLogin) {
        this.hasLogin = hasLogin;
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

}
