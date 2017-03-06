package com.lucas.stroke.v3;

import java.net.URI;
import java.util.Collection;
import javax.xml.datatype.XMLGregorianCalendar;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: Hypertension <br>
 * @version generated on Sun Mar 05 19:13:36 BRT 2017 by dossluca
 */

public interface Hypertension extends RiskFactor {

    /* ***************************************************
     * Property http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasFrequency
     */
     
    /**
     * Gets all property values for the hasFrequency property.<p>
     * 
     * @returns a collection of values for the hasFrequency property.
     */
    Collection<? extends WrappedIndividual> getHasFrequency();

    /**
     * Checks if the class has a hasFrequency property value.<p>
     * 
     * @return true if there is a hasFrequency property value.
     */
    boolean hasHasFrequency();

    /**
     * Adds a hasFrequency property value.<p>
     * 
     * @param newHasFrequency the hasFrequency property value to be added
     */
    void addHasFrequency(WrappedIndividual newHasFrequency);

    /**
     * Removes a hasFrequency property value.<p>
     * 
     * @param oldHasFrequency the hasFrequency property value to be removed.
     */
    void removeHasFrequency(WrappedIndividual oldHasFrequency);


    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
