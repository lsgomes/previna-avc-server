
package model;

import java.util.List;
import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.classes.OwlSubclassOf;


/**
 * Generated Class from Ontology:
 * Class URI: <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Active</code>
 * 
 * 
 */
@OwlClass(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Active")
@OwlSubclassOf({
    @OwlClass(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Physical_activity")
})
public interface Active
    extends Physical_activity
{


    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasTimesPerWeekFrequency</code>
     * 
     * @return
     *     a List of hasTimesPerWeekFrequency
     */
    public List<Times_per_week> getHasTimesPerWeekFrequency();

    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasTimesPerWeekFrequency</code>
     * 
     */
    public void setHasTimesPerWeekFrequency(List<Times_per_week> hasTimesPerWeekFrequency);

}
