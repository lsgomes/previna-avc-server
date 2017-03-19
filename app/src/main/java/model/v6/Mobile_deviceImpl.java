
package model.v6;

import java.util.ArrayList;
import java.util.List;
import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlDataType;
import com.yoshtec.owl.annotations.OwlIndividualId;
import com.yoshtec.owl.annotations.OwlObjectProperty;

@OwlClassImplementation({
    Mobile_device.class
})
public class Mobile_deviceImpl
    implements Mobile_device
{

    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasSensor</code>
     * 
     */
    @OwlObjectProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasSensor")
    @OwlDataType(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Sensor")
    protected List<Sensor> hasSensor;
    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String id;

    public Mobile_deviceImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public Mobile_deviceImpl(String id) {
        this.id = id;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public List<Sensor> getHasSensor() {
        if (hasSensor == null) {
            hasSensor = new ArrayList<Sensor>();
        }
        return hasSensor;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasSensor(List<Sensor> hasSensor) {
        this.hasSensor = hasSensor;
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