
package model;

import com.yoshtec.owl.annotations.OwlClass;


/**
 * Generated Class from Ontology:
 * Class URI: <code>http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Thing</code>
 * 
 * 
 */
@OwlClass(uri = "http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#Thing")
public interface Thing {


    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     * @return
     *     the individualName
     */
    public String getIndividualName();

    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     * @param individualName
     *     the new individualName value
     */
    public void setIndividualName(String individualName);

}
