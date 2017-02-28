
package model;

import java.util.ArrayList;
import java.util.List;
import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlDataType;
import com.yoshtec.owl.annotations.OwlIndividualId;
import com.yoshtec.owl.annotations.OwlObjectProperty;

@OwlClassImplementation({
    Cry_easily.class
})
public class Cry_easilyImpl
    implements Cry_easily
{

    /**
     * OWL Object Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasAdverbFrequency</code>
     * 
     */
    @OwlObjectProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasAdverbFrequency")
    @OwlDataType(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Adverb")
    protected List<Adverb> hasAdverbFrequency;
    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String individualName;

    public Cry_easilyImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public Cry_easilyImpl(String individualName) {
        this.individualName = individualName;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public List<Adverb> getHasAdverbFrequency() {
        if (hasAdverbFrequency == null) {
            hasAdverbFrequency = new ArrayList<Adverb>();
        }
        return hasAdverbFrequency;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasAdverbFrequency(List<Adverb> hasAdverbFrequency) {
        this.hasAdverbFrequency = hasAdverbFrequency;
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
