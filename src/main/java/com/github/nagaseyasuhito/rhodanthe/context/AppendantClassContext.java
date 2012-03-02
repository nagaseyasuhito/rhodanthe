package com.github.nagaseyasuhito.rhodanthe.context;

import javax.lang.model.element.TypeElement;

public class AppendantClassContext extends ClassContext {
    private CharSequence appendantPackageName;

    private CharSequence appendantClassName;

    public AppendantClassContext(TypeElement element, CharSequence appendantPackageName, CharSequence appendantClassName) {
        super(element);
        this.appendantPackageName = appendantPackageName;
        this.appendantClassName = appendantClassName;
    }

    @Override
    public CharSequence getPackageName() {
        return super.getPackageName() + (this.appendantPackageName == null ? "" : "." + this.appendantPackageName);
    }

    @Override
    public CharSequence getClassName() {
        return super.getClassName() + (this.appendantClassName == null ? "" : "" + this.appendantClassName);
    }
}
