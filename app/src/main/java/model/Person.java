
package model;

import java.util.List;
import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.classes.OwlObjectIntersectionOf;
import com.yoshtec.owl.annotations.classes.OwlSubclassOf;


/**
 * Generated Class from Ontology:
 * Class URI: <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Person</code>
 * 
 * 
 */
@OwlObjectIntersectionOf(classes = {
    "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Thing"
})
@OwlClass(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Person")
@OwlSubclassOf({
    @OwlClass(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Thing")
})
public interface Person
    extends Thing
{


    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasAge</code>
     * 
     * @return
     *     an Integer of hasAge
     */
    public Integer getHasAge();

    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasAge</code>
     * 
     */
    public void setHasAge(Integer hasAge);

    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasRiskFactor</code>
     * 
     * @return
     *     a List of hasRiskFactor
     */
    public List<RiskFactor> getHasRiskFactor();

    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasRiskFactor</code>
     * 
     */
    public void setHasRiskFactor(List<RiskFactor> hasRiskFactor);

    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasRiskLevel</code>
     * 
     * @return
     *     a List of hasRiskLevel
     */
    public Double getHasRiskLevel();

    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasRiskLevel</code>
     * 
     */
    public void setHasRiskLevel(Double hasRiskLevel);

    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasSex</code>
     * 
     * @return
     *     a List of hasSex
     */
    public Sex getHasSex();

    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasSex</code>
     * 
     */
    public void setHasSex(Sex hasSex);

    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasLogin</code>
     * 
     * @return
     *     a List of hasLogin
     */
    public Login getHasLogin();

    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasLogin</code>
     * 
     */
    public void setHasLogin(Login hasLogin);

    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasDevice</code>
     * 
     * @return
     *     a List of hasDevice
     */
    public List<Device> getHasDevice();

    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasDevice</code>
     * 
     */
    public void setHasDevice(List<Device> hasDevice);

}
