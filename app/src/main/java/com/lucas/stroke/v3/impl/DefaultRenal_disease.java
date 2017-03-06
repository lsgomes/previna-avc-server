package com.lucas.stroke.v3.impl;

import com.lucas.stroke.v3.*;


import java.net.URI;
import java.util.Collection;
import javax.xml.datatype.XMLGregorianCalendar;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultRenal_disease <br>
 * @version generated on Sun Mar 05 19:13:36 BRT 2017 by dossluca
 */
public class DefaultRenal_disease extends WrappedIndividualImpl implements Renal_disease {

    public DefaultRenal_disease(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasFrequency
     */
     
    public Collection<? extends WrappedIndividual> getHasFrequency() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASFREQUENCY,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasHasFrequency() {
	   return !getHasFrequency().isEmpty();
    }

    public void addHasFrequency(WrappedIndividual newHasFrequency) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASFREQUENCY,
                                       newHasFrequency);
    }

    public void removeHasFrequency(WrappedIndividual oldHasFrequency) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASFREQUENCY,
                                          oldHasFrequency);
    }


}
