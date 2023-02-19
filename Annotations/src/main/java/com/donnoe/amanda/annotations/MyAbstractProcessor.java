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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.*;
/**
 *
 * @author joshuadonnoe
 */
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public abstract class MyAbstractProcessor extends AbstractProcessor {
    
    public Map<Class<? extends Annotation>, List<Object>> tags = new HashMap<>();
    
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Class<? extends Annotation> annotationType = getAnnotationType();
        for (Element element: roundEnv.getElementsAnnotatedWith(annotationType)) {
            tags.put(annotationType, getValue(annotationType, element));
        }
        postProcess();
        return true;
    }
    
    protected abstract void postProcess();
    
    private Class<? extends Annotation> getAnnotationType() {
        try {
            @SuppressWarnings("unchecked")
            Class<? extends Annotation> clazz = (Class<? extends Annotation>) Class.forName(getClass().getAnnotation(SupportedAnnotationTypes.class).value()[0]);
            return clazz;
        } catch (ClassNotFoundException x) {
            throw new AssertionError(x);
        }
    }
    
    private List<Object> getValue(Class<? extends Annotation> annotationType, Element element) {
        try {
            return convert(annotationType.getDeclaredMethod("value").invoke(element.getAnnotation(annotationType)));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException x) {
            throw new AssertionError(x);
        }
    }
    
    private List<Object> convert(Object value) {
        return switch (value.getClass().componentType().toString()) {
            case "int" -> Arrays.stream((int[]) value).boxed().collect(Collectors.toList());
            default -> Arrays.asList((Object[]) value);
        };
    }
}