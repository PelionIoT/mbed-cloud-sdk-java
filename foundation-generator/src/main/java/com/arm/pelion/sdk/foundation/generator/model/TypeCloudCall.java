package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;

public class TypeCloudCall extends TypeCompose {

    public TypeCloudCall() {
        super();
    }

    public TypeCloudCall(boolean concrete) {
        super(concrete);
    }

    public TypeCloudCall(Class<?> clazz) {
        super(clazz);
    }

    public TypeCloudCall(Import importPath) {
        super(importPath);
    }

    public TypeCloudCall(String type, String format) {
        super(type, format);
    }

    public TypeCloudCall(TypeParameter contentType, boolean concrete) {
        super(contentType, concrete);
    }

    public TypeCloudCall(TypeParameter contentType) {
        super(contentType);
    }

    @Override
    protected Class<?> getCollectionClass() {
        return CloudCall.class;
    }

    @Override
    protected void TranslateTypeNameBasedOnContentType() {
        setTypeName(contentType.hasClass() ? ParameterizedTypeName.get(CloudCall.class, contentType.getClazz())
                                           : ParameterizedTypeName.get(ClassName.get(CloudCall.class),
                                                                       contentType.getTypeName()));

    }

    @Override
    public String getShortName() {
        return CloudCall.class.getSimpleName();
    }

    @Override
    public String toString() {
        return "TypeCloudCall [contentType=" + contentType + "]";
    }

}
