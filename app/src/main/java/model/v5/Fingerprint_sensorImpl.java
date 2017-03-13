
package model.v5;

import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlIndividualId;

@OwlClassImplementation({
    Fingerprint_sensor.class
})
public class Fingerprint_sensorImpl
    implements Fingerprint_sensor
{

    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String name;

    public Fingerprint_sensorImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public Fingerprint_sensorImpl(String name) {
        this.name = name;
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
