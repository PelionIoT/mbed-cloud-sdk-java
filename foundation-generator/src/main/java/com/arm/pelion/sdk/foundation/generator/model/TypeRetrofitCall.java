package com.arm.pelion.sdk.foundation.generator.model;

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
    public String toString() {
        return "TypeRetrofitCall [contentType=" + contentType + "]";
    }

}
