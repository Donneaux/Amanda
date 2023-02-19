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

@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_17)
@SupportedAnnotationTypes("com.donnoe.amanda.annotations.ConstantIndexer")
public class ConstantIndexerProcessor extends MyAbstractProcessor {
    @Override
    protected void postProcess() {
        System.out.println(tags);
    }
}