
package model.v7;

import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlIndividualId;

@OwlClassImplementation({
    Sensor.class
})
public class SensorImpl
    implements Sensor
{

    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String uri;

    public SensorImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public SensorImpl(String uri) {
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
