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
 * Source Class: DefaultMobile_device <br>
 * @version generated on Sun Mar 05 19:13:36 BRT 2017 by dossluca
 */
public class DefaultMobile_device extends WrappedIndividualImpl implements Mobile_device {

    public DefaultMobile_device(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.semanticweb.org/lucas/ontologies/2016/9/stroke#hasSensor
     */
     
    public Collection<? extends Sensor> getHasSensor() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASSENSOR,
                                               DefaultSensor.class);
    }

    public boolean hasHasSensor() {
	   return !getHasSensor().isEmpty();
    }

    public void addHasSensor(Sensor newHasSensor) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASSENSOR,
                                       newHasSensor);
    }

    public void removeHasSensor(Sensor oldHasSensor) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASSENSOR,
                                          oldHasSensor);
    }


}
