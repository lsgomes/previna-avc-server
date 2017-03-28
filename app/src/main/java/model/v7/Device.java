
package model.v7;

import java.util.List;
import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.classes.OwlObjectIntersectionOf;
import com.yoshtec.owl.annotations.classes.OwlSubclassOf;


/**
 * Generated Class from Ontology:
 * Class URI: <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Device</code>
 * 
 * 
 */
@OwlObjectIntersectionOf(classes = {
    "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Thing"
})
@OwlClass(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Device")
@OwlSubclassOf({
    @OwlClass(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Thing")
})
public interface Device
    extends Thing
{


    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasSensor</code>
     * 
     * @return
     *     a List of hasSensor
     */
    public List<Sensor> getHasSensor();

    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasSensor</code>
     * 
     */
    public void setHasSensor(List<Sensor> hasSensor);

}
