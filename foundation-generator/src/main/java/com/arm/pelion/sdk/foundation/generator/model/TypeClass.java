package com.arm.pelion.sdk.foundation.generator.model;

import com.squareup.javapoet.TypeName;

public class TypeClass extends TypeCompose {

    public TypeClass() {
        super();
    }

    protected TypeClass(Import importPath, Class<?> clazz, TypeName typeName, String type, String format,
                        TypeParameter contentType, boolean concrete) {
        super(importPath, clazz, typeName, type, format, contentType, concrete);
    }

    public TypeClass(TypeParameter contentType) {
        super(contentType);
    }

    public TypeClass(String type, String format) {
        super(type, format);
    }

    public TypeClass(Class<?> clazz) {
        super(clazz);
    }

    public TypeClass(Import importPath) {
        super(importPath);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.ParameterType#getShortName()
     */
    @Override
    public String getShortName() {
        return Class.class.getSimpleName();
    }

    @Override
    public String getFullyQualifiedName() {
        return Class.class.getName();
    }

    @Override
    public String toString() {
        return "TypeClass [contentType=" + contentType + ", concreteImplementation=" + concreteImplementation + "]";
    }

    @Override
    protected Class<?> getCollectionClass() {
        return Class.class;
    }

    @Override
    public TypeClass clone() {
        return new TypeClass(importPath == null ? null : importPath.clone(), clazz, typeName, type, format, contentType,
                             concreteImplementation);
    }
}
