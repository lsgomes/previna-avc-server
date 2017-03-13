
package model.v5;

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
     *     the name
     */
    public String getName();

    /**
     * rdf:about or rdf:id, used to generate the individual URI
     * 
     * @param name
     *     the new name value
     */
    public void setName(String name);

}
