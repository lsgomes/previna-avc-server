
package model.v5;

import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlIndividualId;

@OwlClassImplementation({
    Ambient_light_sensor.class
})
public class Ambient_light_sensorImpl
    implements Ambient_light_sensor
{

    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String name;

    public Ambient_light_sensorImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public Ambient_light_sensorImpl(String name) {
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
