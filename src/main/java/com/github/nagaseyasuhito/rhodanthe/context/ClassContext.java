package com.github.nagaseyasuhito.rhodanthe.context;

import java.beans.Introspector;

import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

public class ClassContext {

    private TypeElement element;

    public ClassContext(TypeElement element) {
        this.element = element;
    }

    public CharSequence getClassName() {
        return this.element.getSimpleName();
    }

    public CharSequence getDecapitalizeClassName() {
        return Introspector.decapitalize(this.getClassName().toString());
    }

    public CharSequence getPackageName() {
        return ((PackageElement) this.element.getEnclosingElement()).getQualifiedName();
    }

    public CharSequence getFullyQualifiedClassName() {
        return this.getPackageName() + "." + this.getClassName();
    }
}
