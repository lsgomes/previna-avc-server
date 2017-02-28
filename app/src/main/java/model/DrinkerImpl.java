
package model;

import java.util.ArrayList;
import java.util.List;
import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlDataType;
import com.yoshtec.owl.annotations.OwlIndividualId;
import com.yoshtec.owl.annotations.OwlObjectProperty;

@OwlClassImplementation({
    Drinker.class
})
public class DrinkerImpl
    implements Drinker
{

    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasDrinkPerWeekFrequency</code>
     * 
     */
    @OwlObjectProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasDrinkPerWeekFrequency")
    @OwlDataType(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Drinks_per_week")
    protected List<Drinks_per_week> hasDrinkPerWeekFrequency;
    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String individualName;

    public DrinkerImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public DrinkerImpl(String individualName) {
        this.individualName = individualName;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public List<Drinks_per_week> getHasDrinkPerWeekFrequency() {
        if (hasDrinkPerWeekFrequency == null) {
            hasDrinkPerWeekFrequency = new ArrayList<Drinks_per_week>();
        }
        return hasDrinkPerWeekFrequency;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasDrinkPerWeekFrequency(List<Drinks_per_week> hasDrinkPerWeekFrequency) {
        this.hasDrinkPerWeekFrequency = hasDrinkPerWeekFrequency;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public String getIndividualName() {
        return individualName;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setIndividualName(String individualName) {
        this.individualName = individualName;
    }

}
