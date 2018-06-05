package com.example.viewbinder;

import com.google.auto.service.AutoService;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;

/**
 * Created by mac on 2018/6/5.
 */

@AutoService(Processor.class)
public class ViewBinderProcessor extends AbstractProcessor{

    private Filer mFiler;
    private Messager mMessager;
    private Elements mElementsUtil;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mFiler = processingEnvironment.getFiler();
        mMessager = processingEnvironment.getMessager();
        mElementsUtil = processingEnvironment.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(ViewBinder.class);
        for (Element element : elements) {
            L.d(mMessager, element.getKind().name());
            L.d(mMessager, element.getSimpleName().toString());

            PackageElement packageElement = mElementsUtil.getPackageOf(element);
            L.d(mMessager, packageElement.getQualifiedName().toString());

            TypeElement typeElement = (TypeElement) element.getEnclosingElement();
            L.d(mMessager, "encloseingElement = " + typeElement.getQualifiedName().toString());

            VariableElement variableElement = (VariableElement) element;
            String bindViewFiledClassType = variableElement.asType().toString();
            L.d(mMessager, "bindview type = " + bindViewFiledClassType);

            TypeMirror typeMirror = variableElement.asType();


            ViewBinder viewBinder = element.getAnnotation(ViewBinder.class);
            int id = viewBinder.value();
            L.d(mMessager, "view bind value = " + id);

        }
        return false;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        LinkedHashSet<String> result = new LinkedHashSet<>();
        result.add(ViewBinder.class.getCanonicalName());
        return result;
    }


}
