package com.previnaavc;

import com.yoshtec.owl.jcodegen.Codegen;
import com.yoshtec.owl.jcodegen.CodegenException;

import com.yoshtec.owl.jcodegen.Codegen;
import com.yoshtec.owl.jcodegen.CodegenException;

import java.io.File;

public class CodegenMain {

    public static void main(String args[]) throws CodegenException {
        Codegen codegen = new Codegen();

        // the java package to create the classes in
        codegen.setJavaPackageName("model.v7");

        codegen.setOntologyIri("http://www.semanticweb.org/lucas/ontologies/2016/9/stroke");
        codegen.setOntologyPhysicalIri( new File("ontology/stroke_v7.owl").toURI().toString());

        codegen.setJavaSourceFolder(new File("ov3test"));

        // will generate "indName" String fields with @OwlIndividualId annotation and implementations
        codegen.setGenerateIdField(true);
        codegen.setIdFieldName("uri");

        // generate code
        codegen.genCode();
    }
}
