package com.arm.pelion.sdk.foundation.generator.model;

import com.squareup.javapoet.ArrayTypeName;

public class TypeArray extends TypeCompose {

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

}
