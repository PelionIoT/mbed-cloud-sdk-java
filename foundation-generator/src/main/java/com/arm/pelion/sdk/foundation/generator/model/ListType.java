package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;

import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;

public class ListType extends ParameterType {

    private ParameterType contentType;

    public ListType() {
        this(new ParameterType());
    }

    public ListType(ParameterType contentType) {
        super();
        setContentType(contentType);
    }

    public ListType(String type, String format) {
        this(new ParameterType(type, format));
    }

    public ListType(Class<?> clazz) {
        this(new ParameterType(clazz));
    }

    public ListType(Import importPath) {
        this(new ParameterType(importPath));
    }

    public ParameterType getContentType() {
        return contentType;
    }

    public void setContentType(ParameterType contentType) {
        this.contentType = contentType == null ? new ParameterType() : contentType;
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
     * @see com.arm.pelion.sdk.foundation.generator.model.ParameterType#translate()
     */
    @Override
    public void translate() throws TranslationException {
        if (contentType == null) {
            throw new TranslationException("The type definition of the list is unknown ");
        }
        contentType.translate();
        setTypeName(contentType.hasClass() ? ParameterizedTypeName.get(List.class, contentType.getClazz())
                                           : ParameterizedTypeName.get(ClassName.get(List.class),
                                                                       contentType.getTypeName()));

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
