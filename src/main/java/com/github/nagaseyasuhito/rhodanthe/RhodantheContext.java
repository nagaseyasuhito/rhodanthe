package com.github.nagaseyasuhito.rhodanthe;

import java.beans.Introspector;

import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

public class RhodantheContext {

    private TypeElement element;

    private CharSequence appendantPackageName;

    private CharSequence appendantClassName;

    public RhodantheContext(TypeElement element, CharSequence appendantPackageName, CharSequence appendantClassName) {
        this.element = element;
        this.appendantPackageName = appendantPackageName;
        this.appendantClassName = appendantClassName;
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

    public CharSequence getDecolatedPackageName() {
        return this.getPackageName() + (this.appendantPackageName == null ? "" : "." + this.appendantPackageName);
    }

    public CharSequence getDecolatedClassName() {
        return this.getClassName() + (this.appendantClassName == null ? "" : "" + this.appendantClassName);
    }

    public CharSequence getDecolatedFullyQualifiedClassName() {
        return this.getDecolatedPackageName() + "." + this.getDecolatedClassName();
    }
}
