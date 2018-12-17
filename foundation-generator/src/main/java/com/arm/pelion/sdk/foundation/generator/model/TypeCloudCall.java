package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;

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
    public String toString() {
        return "TypeCloudCall [contentType=" + contentType + "]";
    }

}
