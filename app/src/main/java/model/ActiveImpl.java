
package model;

import java.util.ArrayList;
import java.util.List;
import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlDataType;
import com.yoshtec.owl.annotations.OwlIndividualId;
import com.yoshtec.owl.annotations.OwlObjectProperty;

@OwlClassImplementation({
    Active.class
})
public class ActiveImpl
    implements Active
{

    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasTimesPerWeekFrequency</code>
     * 
     */
    @OwlObjectProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasTimesPerWeekFrequency")
    @OwlDataType(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Times_per_week")
    protected List<Times_per_week> hasTimesPerWeekFrequency;
    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String individualName;

    public ActiveImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public ActiveImpl(String individualName) {
        this.individualName = individualName;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public List<Times_per_week> getHasTimesPerWeekFrequency() {
        if (hasTimesPerWeekFrequency == null) {
            hasTimesPerWeekFrequency = new ArrayList<Times_per_week>();
        }
        return hasTimesPerWeekFrequency;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasTimesPerWeekFrequency(List<Times_per_week> hasTimesPerWeekFrequency) {
        this.hasTimesPerWeekFrequency = hasTimesPerWeekFrequency;
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

}
