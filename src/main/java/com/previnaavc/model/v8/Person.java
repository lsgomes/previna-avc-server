
package com.previnaavc.model.v8;

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
     *     the hasAge
     */
    public Integer getHasAge();

    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasAge</code>
     * 
     * @param hasAge
     *     the new hasAge value
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
     *     the hasRiskLevel
     */
    public Double getHasRiskLevel();

    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasRiskLevel</code>
     * 
     * @param hasRiskLevel
     *     the new hasRiskLevel value
     */
    public void setHasRiskLevel(Double hasRiskLevel);

    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasPassword</code>
     * 
     * @return
     *     the hasPassword
     */
    public String getHasPassword();

    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasPassword</code>
     * 
     * @param hasPassword
     *     the new hasPassword value
     */
    public void setHasPassword(String hasPassword);

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

    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasUserName</code>
     * 
     * @return
     *     the hasUserName
     */
    public String getHasUserName();

    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasUserName</code>
     * 
     * @param hasUserName
     *     the new hasUserName value
     */
    public void setHasUserName(String hasUserName);


    public String getHasBloodGlucose();

    public void setHasBloodGlucose(String hasBloodGlucose);

    public String getHasBloodPressure();

    public void setHasBloodPressure(String hasBloodPressure);

    public String getHasBloodAlcoholContent();

    public void setHasBloodAlcoholContent(String hasBloodAlcoholContent);

    public String getHasStepsCount();

    public void setHasStepsCount(String hasStepsCount);
}
