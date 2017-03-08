
package model;

import java.util.List;
import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.classes.OwlSubclassOf;


/**
 * Generated Class from Ontology:
 * Class URI: <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Education</code>
 * 
 * 
 */
@OwlClass(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Education")
@OwlSubclassOf({
    @OwlClass(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#RiskFactor")
})
public interface Education
    extends RiskFactor
{


    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasEducation</code>
     * 
     * @return
     *     a List of hasEducation
     */
    public List<Education> getHasEducation();

    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasEducation</code>
     * 
     */
    public void setHasEducation(List<Education> hasEducation);

}
