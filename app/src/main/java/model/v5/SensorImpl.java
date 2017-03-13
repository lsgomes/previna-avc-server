
package model.v5;

import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlIndividualId;

@OwlClassImplementation({
    Sensor.class
})
public abstract class SensorImpl
    implements Sensor
{

    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String name;

    public SensorImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public SensorImpl(String name) {
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
