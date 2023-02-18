/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.donnoe.amanda.annotations;
import java.util.Set;
import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
/**
 *
 * @author joshuadonnoe
 */
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public abstract class MyAbstractProcessor extends AbstractProcessor {
    
    public Map<Class<? extends Annotation>, Object> tags = new HashMap<>();
    
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Class<? extends Annotation> annotationType = getAnnotationType();
        for (Element element: roundEnv.getElementsAnnotatedWith(annotationType)) {
            tags.put(annotationType, getValue(annotationType, element));
        }
        return true;
    }
    
    private Class<? extends Annotation> getAnnotationType() {
        try {
            return (Class) Class.forName(getClass().getAnnotation(SupportedAnnotationTypes.class).value()[0]);
        } catch (ClassNotFoundException x) {
            throw new AssertionError(x);
        }
    }
    
    private Object getValue(Class<? extends Annotation> annotationType, Element element) {
        try {
            return annotationType.getDeclaredMethod("value").invoke(element.getAnnotation(annotationType));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException x) {
            throw new AssertionError(x);
        }
    }
}
