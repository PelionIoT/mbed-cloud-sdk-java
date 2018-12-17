package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.listing.Paginator;

public class TypePaginator extends TypeCompose {

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

}
