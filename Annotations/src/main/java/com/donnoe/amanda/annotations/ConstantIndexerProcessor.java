/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.donnoe.amanda.annotations;

/**
 *
 * @author joshuadonnoe
 */

import com.google.auto.service.AutoService;
import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import java.util.Set;
import javax.lang.model.element.TypeElement;

@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_17)
@SupportedAnnotationTypes("com.donnoe.amanda.annotations.ConstantIndexer")

public class ConstantIndexerProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println(annotations);
        annotations.forEach(annotation ->
                roundEnv.getElementsAnnotatedWith(annotation)
        );
        return true;
    }
}
