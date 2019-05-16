package com.arm.pelion.sdk.foundation.generator.model;

import com.squareup.javapoet.TypeName;

import retrofit2.Call;

public class TypeRetrofitCall extends TypeCompose {

    protected TypeRetrofitCall(Import importPath, Class<?> clazz, TypeName typeName, String type, String format,
                               TypeParameter contentType, boolean concrete) {
        super(importPath, clazz, typeName, type, format, contentType, concrete);
    }

    public TypeRetrofitCall() {
        super();
    }

    public TypeRetrofitCall(boolean concrete) {
        super(concrete);
    }

    public TypeRetrofitCall(Class<?> clazz) {
        super(clazz);
    }

    public TypeRetrofitCall(Import importPath) {
        super(importPath);
    }

    public TypeRetrofitCall(String type, String format) {
        super(type, format);
    }

    public TypeRetrofitCall(TypeParameter contentType, boolean concrete) {
        super(contentType, concrete);
    }

    public TypeRetrofitCall(TypeParameter contentType) {
        super(contentType);
    }

    @Override
    protected Class<?> getCollectionClass() {
        return Call.class;
    }

    @Override
    public String toString() {
        return "TypeRetrofitCall [contentType=" + contentType + "]";
    }

    @Override
    public TypeRetrofitCall clone() {
        return new TypeRetrofitCall(importPath == null ? null : importPath.clone(), clazz, typeName, type, format,
                                    contentType, concreteImplementation);
    }

}
