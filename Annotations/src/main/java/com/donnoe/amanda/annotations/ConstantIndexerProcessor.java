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
@SupportedAnnotationTypes("com.donnoe.amanda.annotations.ConstantIndexer")
public class ConstantIndexerProcessor extends MyAbstractProcessor {
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        try {
            return super.process(annotations, roundEnv);
        } finally {
            System.out.println(tags);
        }
    }
}