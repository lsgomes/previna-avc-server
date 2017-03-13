
package model.v5;

import java.util.List;
import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.classes.OwlObjectIntersectionOf;
import com.yoshtec.owl.annotations.classes.OwlSubclassOf;


/**
 * Generated Class from Ontology:
 * Class URI: <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#RiskFactor</code>
 * 
 * 
 */
@OwlObjectIntersectionOf(classes = {
    "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Thing"
})
@OwlClass(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#RiskFactor")
@OwlSubclassOf({
    @OwlClass(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Thing")
})
public interface RiskFactor
    extends Thing
{


    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasWeight</code>
     * 
     * @return
     *     a List of hasWeight
     */
    public List<Integer> getHasWeight();

    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasWeight</code>
     * 
     */
    public void setHasWeight(List<Integer> hasWeight);

}
