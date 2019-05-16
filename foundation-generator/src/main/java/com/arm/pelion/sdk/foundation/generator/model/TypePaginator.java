package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.squareup.javapoet.TypeName;

public class TypePaginator extends TypeCompose {

    protected TypePaginator(Import importPath, Class<?> clazz, TypeName typeName, String type, String format,
                            TypeParameter contentType, boolean concrete) {
        super(importPath, clazz, typeName, type, format, contentType, concrete);
    }

    public TypePaginator() {
        super();
    }

    public TypePaginator(TypeParameter contentType) {
        super(contentType);
    }

    public TypePaginator(String type, String format) {
        super(type, format);
    }

    public TypePaginator(Class<?> clazz) {
        super(clazz);
    }

    public TypePaginator(Import importPath) {
        super(importPath);
    }

    @Override
    public String toString() {
        return "TypePaginator [contentType=" + contentType + "]";
    }

    @Override
    protected Class<?> getCollectionClass() {
        return Paginator.class;
    }

    @Override
    public TypePaginator clone() {
        return new TypePaginator(importPath == null ? null : importPath.clone(), clazz, typeName, type, format,
                                 contentType, concreteImplementation);
    }
}
