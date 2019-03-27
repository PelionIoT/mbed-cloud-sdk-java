package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.listing.PageRequester;
import com.squareup.javapoet.TypeName;

public class TypePageRequester extends TypeCompose {

    protected TypePageRequester(Import importPath, Class<?> clazz, TypeName typeName, String type, String format,
                                TypeParameter contentType, boolean concrete) {
        super(importPath, clazz, typeName, type, format, contentType, concrete);
    }

    public TypePageRequester() {
        super();
    }

    public TypePageRequester(boolean concrete) {
        super(concrete);
    }

    public TypePageRequester(Class<?> clazz) {
        super(clazz);
    }

    public TypePageRequester(Import importPath) {
        super(importPath);
    }

    public TypePageRequester(String type, String format) {
        super(type, format);
    }

    public TypePageRequester(TypeParameter contentType, boolean concrete) {
        super(contentType, concrete);
    }

    public TypePageRequester(TypeParameter contentType) {
        super(contentType);
    }

    @Override
    protected Class<?> getCollectionClass() {
        return PageRequester.class;
    }

    @Override
    public String toString() {
        return "TypePageRequester [contentType=" + contentType + "]";
    }

    @Override
    public TypePageRequester clone() {
        return new TypePageRequester(importPath == null ? null : importPath.clone(), clazz, typeName, type, format,
                                     contentType, concreteImplementation);
    }

}
