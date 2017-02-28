
package model;

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
    protected String hasUserPassword;
    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     */
    @OwlIndividualId
    protected String individualName;
    /**
     * OWL Data Property:</br>
     * <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasUserName</code>
     * 
     */
    @OwlDataProperty(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasUserName")
    @OwlDataType(uri = "http://www.w3.org/2001/XMLSchema#string")
    protected String hasUserName;

    public LoginImpl() {
    }

    /**
     * Convenience constructor for setting the OWL ID
     * 
     */
    @OwlIndividualId
    public LoginImpl(String individualName) {
        this.individualName = individualName;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public String getHasUserPassword() {
        return hasUserPassword;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasUserPassword(String hasUserPassword) {
        this.hasUserPassword = hasUserPassword;
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

    /**
     * {@inheritDoc}
     * 
     */
    public String getHasUserName() {
        return hasUserName;
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void setHasUserName(String hasUserName) {
        this.hasUserName = hasUserName;
    }

}
