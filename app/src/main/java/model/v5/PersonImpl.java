
package model.v5;

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
    protected List<Integer> hasAge;
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
    protected List<Double> hasRiskLevel;
    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasName</code>
     * 
     */
    @OwlDataProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasName")
    @OwlDataType(uri = "http://www.w3.org/2001/XMLSchema#string")
    protected List<String> hasName;
    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String name;
    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasLogin</code>
     * 
     */
    @OwlObjectProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasLogin")
    @OwlDataType(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Login")
    protected List<Login> hasLogin;
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
    public PersonImpl(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public List<Integer> getHasAge() {
        if (hasAge == null) {
            hasAge = new ArrayList<Integer>();
        }
        return hasAge;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasAge(List<Integer> hasAge) {
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
    public List<Double> getHasRiskLevel() {
        if (hasRiskLevel == null) {
            hasRiskLevel = new ArrayList<Double>();
        }
        return hasRiskLevel;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasRiskLevel(List<Double> hasRiskLevel) {
        this.hasRiskLevel = hasRiskLevel;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public List<String> getHasName() {
        if (hasName == null) {
            hasName = new ArrayList<String>();
        }
        return hasName;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasName(List<String> hasName) {
        this.hasName = hasName;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public List<Login> getHasLogin() {
        if (hasLogin == null) {
            hasLogin = new ArrayList<Login>();
        }
        return hasLogin;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasLogin(List<Login> hasLogin) {
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
