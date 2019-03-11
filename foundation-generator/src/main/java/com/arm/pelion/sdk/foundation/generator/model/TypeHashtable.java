package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Hashtable;
import java.util.Map;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;

public class TypeHashtable extends TypeCompose {

    public TypeHashtable() {
        this(false);
    }

    public TypeHashtable(boolean concrete) {
        this(new TypeParameter(), concrete);
    }

    public TypeHashtable(TypeParameter contentType, boolean concrete) {
        this.contentType = contentType;
        this.concreteImplementation = concrete;
    }

    public TypeHashtable(String type, String format) {
        contentType = new TypeParameter(type, format);
    }

    public TypeHashtable(Class<?> clazz) {
        contentType = new TypeParameter(clazz);
    }

    public TypeHashtable(Import importPath) {
        contentType = new TypeParameter(importPath);
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
            throw new TranslationException("The type definition of the map is unknown ");
        }
        try {
            contentType.translate();
            TranslateTypeNameBasedOnContentType();
        } catch (Exception e) {
            e.printStackTrace();
            setClazz(getCollectionClass());
            super.translate();
        }
    }

    @Override
    protected void TranslateTypeNameBasedOnContentType() {
        setTypeName(contentType.hasClass() ? ParameterizedTypeName.get(getCollectionClass(), String.class,
                                                                       contentType.getClazz())
                                           : ParameterizedTypeName.get(ClassName.get(getCollectionClass()),
                                                                       TypeName.get(String.class),
                                                                       contentType.getTypeName()));
    }

    @Override
    protected Class<?> getCollectionClass() {
        return concreteImplementation ? getRawClass() : Map.class;
    }

    @Override
    public Class<?> getRawClass() {
        return Hashtable.class;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.ParameterType#getShortName()
     */
    @Override
    public String getShortName() {
        return Map.class.getSimpleName() + "<String, " + contentType.getShortName() + ">";
    }

    @Override
    public String getFullyQualifiedName() {
        return Map.class.getName() + "<String, " + contentType.getFullyQualifiedName() + ">";
    }

    @Override
    public String toString() {
        return "HashtableType [contentType=" + contentType + ", concreteImplementation=" + concreteImplementation + "]";
    }

}
