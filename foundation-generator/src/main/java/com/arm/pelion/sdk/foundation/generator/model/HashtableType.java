package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;

public class HashtableType extends ParameterType {

    private ParameterType contentType;
    private boolean concreteImplementation;

    public HashtableType() {
        this(false);
    }

    public HashtableType(boolean concrete) {
        this(new ParameterType(), concrete);
    }

    public HashtableType(ParameterType contentType, boolean concrete) {
        this.contentType = contentType;
        this.concreteImplementation = concrete;
    }

    public HashtableType(String type, String format) {
        contentType = new ParameterType(type, format);
    }

    public HashtableType(Class<?> clazz) {
        contentType = new ParameterType(clazz);
    }

    public HashtableType(Import importPath) {
        contentType = new ParameterType(importPath);
    }

    @Override
    public boolean isHashtable() {
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.ParameterType#translate()
     */
    @Override
    public void translate() throws TranslationException {
        if (contentType == null) {
            throw new TranslationException("The type definition of the list is unknown ");
        }
        contentType.translate();
        setTypeName(contentType.hasClass() ? ParameterizedTypeName.get(getCollectionClass(), String.class,
                                                                       contentType.getClazz())
                                           : ParameterizedTypeName.get(ClassName.get(getCollectionClass()),
                                                                       TypeName.get(String.class),
                                                                       contentType.getTypeName()));

    }

    private Class<?> getCollectionClass() {
        return concreteImplementation ? Hashtable.class : Map.class;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ListType [contentType=" + contentType + "]";
    }

}
