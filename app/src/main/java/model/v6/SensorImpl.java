
package model.v6;

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
    protected String id;

    public SensorImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public SensorImpl(String id) {
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
