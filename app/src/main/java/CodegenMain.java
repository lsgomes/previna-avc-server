/**
 * Created by dossluca on 27/02/2017.
 */

import com.yoshtec.owl.jcodegen.Codegen;
import com.yoshtec.owl.jcodegen.CodegenException;

import java.io.File;

public class CodegenMain {

    public static void main(String args[]) throws CodegenException {
        Codegen codegen = new Codegen();

        // the java package to create the classes in
        codegen.setJavaPackageName("model");

        codegen.setOntologyIri("http://www.semanticweb.org/lucas/ontologies/2016/9/stroke");
        codegen.setOntologyPhysicalIri( new File("stroke_v2.owl").toURI().toString());

        codegen.setJavaSourceFolder(new File("otest"));

        // will generate "indName" String fields with @OwlIndividualId annotation and implementations
        codegen.setGenerateIdField(true);
        codegen.setIdFieldName("individualName");

        // generate code
        codegen.genCode();
    }
}
