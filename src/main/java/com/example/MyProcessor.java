package com.example;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.*;
import java.util.HashSet;
import java.util.Set;


@SupportedAnnotationTypes("com.example.CopyMethods")
public class MyProcessor extends AbstractProcessor {
    private Messager messager;

/*    public MyProcessor() {
    }*/
/*    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> set = new HashSet<>();
        set.add("CopyMethods");
        return set;
    }*/

    //to avoid warnings
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("annotation elo");
        messager.printMessage(Diagnostic.Kind.NOTE,
                "Printing: annotation elo" );

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("the-file-name.txt", "UTF-8");
            writer.println("new File!!!!");
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println("The first line");
        writer.close();
        return true;
        /*
        // Itearate over all @CopyMethods annotated elements
        for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(CopyMethods.class)) {
            // Check if a class has been annotated with @Factory
            if (annotatedElement.getKind() != ElementKind.CLASS) {
                error(annotatedElement, "Only classes can be annotated with @%s", CopyMethods.class.getSimpleName());
                return true;
            }
            else {
                    for (TypeElement te : annotations) {
                        for (Element e : roundEnv.getElementsAnnotatedWith(te)) {

                            messager.printMessage(Diagnostic.Kind.NOTE,
                                    "Printing: " + e.toString());
                        }
                    }
                    return true;
                }
            }
        return true;*/

    }
  /*  private void error(Element e, String msg, Object... args) {
        messager.printMessage(
                Diagnostic.Kind.ERROR,
                String.format(msg, args),
                e);
    }*/

}
