
package model;

import java.util.List;
import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.classes.OwlSubclassOf;


/**
 * Generated Class from Ontology:
 * Class URI: <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Drinker</code>
 * 
 * 
 */
@OwlClass(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Drinker")
@OwlSubclassOf({
    @OwlClass(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Alcohol_consumption")
})
public interface Drinker
    extends Alcohol_consumption
{


    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasDrinkPerWeekFrequency</code>
     * 
     * @return
     *     a List of hasDrinkPerWeekFrequency
     */
    public List<Drinks_per_week> getHasDrinkPerWeekFrequency();

    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasDrinkPerWeekFrequency</code>
     * 
     */
    public void setHasDrinkPerWeekFrequency(List<Drinks_per_week> hasDrinkPerWeekFrequency);

}
