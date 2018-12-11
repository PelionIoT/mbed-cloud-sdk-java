package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.List;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;

public class TypeList extends TypeCollection {

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
        return List.class.getSimpleName();
    }

    @Override
    public String toString() {
        return "ListType [contentType=" + contentType + ", concreteImplementation=" + concreteImplementation + "]";
    }

    @Override
    protected Class<?> getCollectionClass() {
        return concreteImplementation ? ArrayList.class : List.class;
    }

    @Override
    protected void TranslateTypeNameBasedOnContentType() {
        setTypeName(contentType.hasClass() ? ParameterizedTypeName.get(List.class, contentType.getClazz())
                                           : ParameterizedTypeName.get(ClassName.get(List.class),
                                                                       contentType.getTypeName()));

    }

}
