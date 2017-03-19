
package model.v6;

import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlDataProperty;
import com.yoshtec.owl.annotations.OwlDataType;
import com.yoshtec.owl.annotations.OwlIndividualId;
import com.yoshtec.owl.annotations.dprop.OwlFunctionalDataProperty;

@OwlClassImplementation({
    Sex.class
})
public class SexImpl
    implements Sex
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
    protected String id;

    public SexImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public SexImpl(String id) {
        this.id = id;
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
        return id;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setUri(String uri) {
        this.id = uri;
    }

}
