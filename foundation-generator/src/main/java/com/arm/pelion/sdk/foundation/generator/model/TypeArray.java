package com.arm.pelion.sdk.foundation.generator.model;

import com.squareup.javapoet.ArrayTypeName;
import com.squareup.javapoet.TypeName;

public class TypeArray extends TypeCompose {

    protected TypeArray(Import importPath, Class<?> clazz, TypeName typeName, String type, String format,
                        TypeParameter contentType, boolean concrete) {
        super(importPath, clazz, typeName, type, format, contentType, concrete);
    }

    public TypeArray() {
        super();
    }

    public TypeArray(TypeParameter contentType) {
        super(contentType);
    }

    public TypeArray(String type, String format) {
        super(type, format);
    }

    public TypeArray(Class<?> clazz) {
        super(clazz);
    }

    public TypeArray(Import importPath) {
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

    @Override
    public boolean isArray() {
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.ParameterType#getShortName()
     */

    @Override
    public String getShortName() {
        return contentType.getShortName() + "[]";
    }

    @Override
    public String getFullyQualifiedName() {
        return contentType.getFullyQualifiedName() + "[]";
    }

    @Override
    public String toString() {
        return "ArrayType [contentType=" + contentType + ", concreteImplementation=" + concreteImplementation + "]";
    }

    @Override
    protected Class<?> getCollectionClass() {
        return null;
    }

    @Override
    public Class<?> getRawClass() {
        return null;
    }

    @Override
    protected void TranslateTypeNameBasedOnContentType() {
        setTypeName(contentType.hasClass() ? ArrayTypeName.of(contentType.getClazz())
                                           : ArrayTypeName.of(contentType.getTypeName()));

    }

    @Override
    protected void setImportPath() {
        // Nothing to do
    }

    @Override
    public TypeArray clone() {
        return new TypeArray(importPath == null ? null : importPath.clone(), clazz, typeName, type, format, contentType,
                             concreteImplementation);
    }
}
