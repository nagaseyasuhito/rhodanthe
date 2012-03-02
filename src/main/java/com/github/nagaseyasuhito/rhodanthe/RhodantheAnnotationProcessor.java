package com.github.nagaseyasuhito.rhodanthe;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

import com.github.nagaseyasuhito.rhodanthe.context.AppendantClassContext;
import com.github.nagaseyasuhito.rhodanthe.context.ClassContext;
import com.github.nagaseyasuhito.rhodanthe.context.SpecifyClassContext;
import com.google.common.collect.ImmutableMap;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes("com.github.nagaseyasuhito.rhodanthe.Rhodanthe")
public class RhodantheAnnotationProcessor extends AbstractProcessor {

    private Configuration configuration;

    public RhodantheAnnotationProcessor() {
        this.configuration = new Configuration();
        this.configuration.setDefaultEncoding("utf-8");
        this.configuration.setClassForTemplateLoading(RhodantheAnnotationProcessor.class, "");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment environment) {
        Set<? extends Element> elements = environment.getElementsAnnotatedWith(Rhodanthe.class);

        for (Element element : elements) {
            try {
                this.processAnnotation((TypeElement) element);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return true;
    }

    protected void processAnnotation(TypeElement element) throws IOException {
        this.write(new AppendantClassContext(element, null, "Filter"), "Filter");
        this.write(new AppendantClassContext(element, null, "WebApplication"), "WebApplication");
        this.write(new SpecifyClassContext(element, "page", "IndexPage"), "IndexPage");
    }

    protected CharSequence processTemplate(CharSequence templateName, ClassContext context) throws IOException {
        Template template = this.configuration.getTemplate(templateName + ".java");
        StringWriter writer = new StringWriter();

        try {
            template.process(ImmutableMap.of("context", context), writer);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }

        return writer.getBuffer();
    }

    protected void write(ClassContext context, CharSequence template) throws IOException {
        CharSequence source = this.processTemplate(template, context);

        JavaFileObject javaFileObject = this.processingEnv.getFiler().createSourceFile(context.getFullyQualifiedClassName());
        Writer javaWriter = javaFileObject.openWriter();
        javaWriter.write(source.toString());
        javaWriter.close();
    }
}
