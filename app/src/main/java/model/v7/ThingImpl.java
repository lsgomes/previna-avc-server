
package model.v7;

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
    protected String uri;

    public ThingImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public ThingImpl(String uri) {
        this.uri = uri;
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
