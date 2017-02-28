
package model;

import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlIndividualId;

@OwlClassImplementation({
    Female.class
})
public class FemaleImpl
    implements Female
{

    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String individualName;

    public FemaleImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public FemaleImpl(String individualName) {
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
