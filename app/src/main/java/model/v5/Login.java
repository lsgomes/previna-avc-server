
package model.v5;

import java.util.List;
import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.classes.OwlObjectIntersectionOf;
import com.yoshtec.owl.annotations.classes.OwlSubclassOf;


/**
 * Generated Class from Ontology:
 * Class URI: <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Login</code>
 * 
 * 
 */
@OwlObjectIntersectionOf(classes = {
    "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Thing"
})
@OwlClass(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Login")
@OwlSubclassOf({
    @OwlClass(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Thing")
})
public interface Login
    extends Thing
{


    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasUserPassword</code>
     * 
     * @return
     *     a List of hasUserPassword
     */
    public List<String> getHasUserPassword();

    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasUserPassword</code>
     * 
     */
    public void setHasUserPassword(List<String> hasUserPassword);

    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasUserName</code>
     * 
     * @return
     *     a List of hasUserName
     */
    public List<String> getHasUserName();

    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasUserName</code>
     * 
     */
    public void setHasUserName(List<String> hasUserName);

}
