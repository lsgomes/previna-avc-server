
package model.v6;

import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlIndividualId;

@OwlClassImplementation({
    Thing.class
})
public class ThingImpl
    implements Thing
{

    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String id;

    public ThingImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public ThingImpl(String id) {
        this.id = id;
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
