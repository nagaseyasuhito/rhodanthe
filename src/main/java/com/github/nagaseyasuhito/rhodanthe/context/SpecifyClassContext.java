package com.github.nagaseyasuhito.rhodanthe.context;

import javax.lang.model.element.TypeElement;

public class SpecifyClassContext extends AppendantClassContext {
    private CharSequence className;

    public SpecifyClassContext(TypeElement element, CharSequence packageName, CharSequence className) {
        super(element, packageName, null);
        this.className = className;
    }

    @Override
    public CharSequence getClassName() {
        return this.className;
    }
}
