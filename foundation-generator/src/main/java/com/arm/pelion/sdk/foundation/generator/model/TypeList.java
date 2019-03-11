package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.List;

public class TypeList extends TypeCompose {

    public TypeList() {
        super();
    }

    public TypeList(TypeParameter contentType) {
        super(contentType);
    }

    public TypeList(String type, String format) {
        super(type, format);
    }

    public TypeList(Class<?> clazz) {
        super(clazz);
    }

    public TypeList(Import importPath) {
        super(importPath);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.ParameterType#isList()
     */
    @Override
    public boolean isList() {
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.ParameterType#getShortName()
     */
    @Override
    public String getShortName() {
        return List.class.getSimpleName() + "<" + contentType.getShortName() + ">";
    }

    @Override
    public String getFullyQualifiedName() {
        return List.class.getName() + "<" + contentType.getFullyQualifiedName() + ">";
    }

    @Override
    public String toString() {
        return "ListType [contentType=" + contentType + ", concreteImplementation=" + concreteImplementation + "]";
    }

    @Override
    protected Class<?> getCollectionClass() {
        return concreteImplementation ? getRawClass() : List.class;
    }

    @Override
    public Class<?> getRawClass() {
        return ArrayList.class;
    }
}
