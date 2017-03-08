
package model;

import java.util.List;
import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.classes.OwlSubclassOf;


/**
 * Generated Class from Ontology:
 * Class URI: <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Psychosocial_factors</code>
 * 
 * 
 */
@OwlClass(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Psychosocial_factors")
@OwlSubclassOf({
    @OwlClass(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#RiskFactor")
})
public interface Psychosocial_factors
    extends RiskFactor
{


    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasAdverbFrequency</code>
     * 
     * @return
     *     a List of hasAdverbFrequency
     */
    public List<Adverb> getHasAdverbFrequency();

    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasAdverbFrequency</code>
     * 
     */
    public void setHasAdverbFrequency(List<Adverb> hasAdverbFrequency);

}
