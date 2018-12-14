package com.arm.pelion.sdk.foundation.generator.model;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;

import retrofit2.Call;

public class TypeRetrofitCall extends TypeCompose {

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
    protected void TranslateTypeNameBasedOnContentType() {
        setTypeName(contentType.hasClass() ? ParameterizedTypeName.get(Call.class, contentType.getClazz())
                                           : ParameterizedTypeName.get(ClassName.get(Call.class),
                                                                       contentType.getTypeName()));

    }

    @Override
    public String getShortName() {
        return Call.class.getSimpleName();
    }

    @Override
    public String toString() {
        return "TypeRetrofitCall [contentType=" + contentType + "]";
    }

}
