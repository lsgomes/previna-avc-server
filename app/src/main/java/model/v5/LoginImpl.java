
package model.v5;

import java.util.ArrayList;
import java.util.List;
import com.yoshtec.owl.annotations.OwlClassImplementation;
import com.yoshtec.owl.annotations.OwlDataProperty;
import com.yoshtec.owl.annotations.OwlDataType;
import com.yoshtec.owl.annotations.OwlIndividualId;

@OwlClassImplementation({
    Login.class
})
public class LoginImpl
    implements Login
{

    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasUserPassword</code>
     * 
     */
    @OwlDataProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasUserPassword")
    @OwlDataType(uri = "http://www.w3.org/2001/XMLSchema#string")
    protected List<String> hasUserPassword;
    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String name;
    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasUserName</code>
     * 
     */
    @OwlDataProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasUserName")
    @OwlDataType(uri = "http://www.w3.org/2001/XMLSchema#string")
    protected List<String> hasUserName;

    public LoginImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public LoginImpl(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public List<String> getHasUserPassword() {
        if (hasUserPassword == null) {
            hasUserPassword = new ArrayList<String>();
        }
        return hasUserPassword;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasUserPassword(List<String> hasUserPassword) {
        this.hasUserPassword = hasUserPassword;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public List<String> getHasUserName() {
        if (hasUserName == null) {
            hasUserName = new ArrayList<String>();
        }
        return hasUserName;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasUserName(List<String> hasUserName) {
        this.hasUserName = hasUserName;
    }

}
