
package model.v7;

import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlDataProperty;
import com.yoshtec.owl.annotations.OwlDataType;
import com.yoshtec.owl.annotations.OwlIndividualId;
import com.yoshtec.owl.annotations.dprop.OwlFunctionalDataProperty;

@OwlClassImplementation({
    Physical_activity.class
})
public class Physical_activityImpl
    implements Physical_activity
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
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasAchievement</code>
     * 
     */
    @OwlDataProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasAchievement")
    @OwlFunctionalDataProperty
    @OwlDataType(uri = "http://www.w3.org/2001/XMLSchema#string")
    protected String hasAchievement;
    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasTip</code>
     * 
     */
    @OwlDataProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasTip")
    @OwlFunctionalDataProperty
    @OwlDataType(uri = "http://www.w3.org/2001/XMLSchema#string")
    protected String hasTip;
    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String uri;

    public Physical_activityImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public Physical_activityImpl(String uri) {
        this.uri = uri;
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
    public String getHasAchievement() {
        return hasAchievement;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasAchievement(String hasAchievement) {
        this.hasAchievement = hasAchievement;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public String getHasTip() {
        return hasTip;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasTip(String hasTip) {
        this.hasTip = hasTip;
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
