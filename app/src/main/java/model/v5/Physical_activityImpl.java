
package model.v5;

import java.util.ArrayList;
import java.util.List;
import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlDataProperty;
import com.yoshtec.owl.annotations.OwlDataType;
import com.yoshtec.owl.annotations.OwlIndividualId;

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
    @OwlDataType(uri = "http://www.w3.org/2001/XMLSchema#int")
    protected List<Integer> hasWeight;
    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String name;

    public Physical_activityImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public Physical_activityImpl(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public List<Integer> getHasWeight() {
        if (hasWeight == null) {
            hasWeight = new ArrayList<Integer>();
        }
        return hasWeight;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasWeight(List<Integer> hasWeight) {
        this.hasWeight = hasWeight;
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

}
