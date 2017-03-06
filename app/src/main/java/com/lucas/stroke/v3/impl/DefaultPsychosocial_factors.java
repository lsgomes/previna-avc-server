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
 * Source Class: DefaultPsychosocial_factors <br>
 * @version generated on Sun Mar 05 19:13:36 BRT 2017 by dossluca
 */
public class DefaultPsychosocial_factors extends WrappedIndividualImpl implements Psychosocial_factors {

    public DefaultPsychosocial_factors(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasAdverbFrequency
     */
     
    public Collection<? extends Adverb> getHasAdverbFrequency() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASADVERBFREQUENCY,
                                               DefaultAdverb.class);
    }

    public boolean hasHasAdverbFrequency() {
	   return !getHasAdverbFrequency().isEmpty();
    }

    public void addHasAdverbFrequency(Adverb newHasAdverbFrequency) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASADVERBFREQUENCY,
                                       newHasAdverbFrequency);
    }

    public void removeHasAdverbFrequency(Adverb oldHasAdverbFrequency) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASADVERBFREQUENCY,
                                          oldHasAdverbFrequency);
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
