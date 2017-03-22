
package model.v6;

import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlDataProperty;
import com.yoshtec.owl.annotations.OwlDataType;
import com.yoshtec.owl.annotations.OwlIndividualId;
import com.yoshtec.owl.annotations.dprop.OwlFunctionalDataProperty;

@OwlClassImplementation({
    RiskFactor.class
})
public class RiskFactorImpl
    implements RiskFactor
{

    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasWeight</code>
     * 
     */
    @OwlDataProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasWeight")
    @OwlFunctionalDataProperty
    @OwlDataType(uri = "http://www.w3.org/2001/XMLSchema#int")
    protected Integer hasWeight;
    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String uri;

    public RiskFactorImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public RiskFactorImpl(String uri) {
        this.uri = uri;
    }

    public RiskFactorImpl(String uri, Integer hasWeight) {
        this.uri = uri;
        this.hasWeight = hasWeight;
    }


    /**
     * {@inheritDoc}
     * 
     */
    public Integer getHasWeight() {
        return hasWeight;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasWeight(Integer hasWeight) {
        this.hasWeight = hasWeight;
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

}
