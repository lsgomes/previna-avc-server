
package model;

import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlIndividualId;

@OwlClassImplementation({
    Physical_activity.class
})
public abstract class Physical_activityImpl
    implements Physical_activity
{

    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String individualName;

    public Physical_activityImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public Physical_activityImpl(String individualName) {
        this.individualName = individualName;
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
