package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.TranslationException;

public abstract class TypeCollection extends TypeParameter {

    protected TypeParameter contentType;
    protected boolean concreteImplementation;

    public TypeCollection() {
        this(false);
    }

    public TypeCollection(boolean concrete) {
        this(new TypeParameter(), concrete);
    }

    public TypeCollection(TypeParameter contentType) {
        this(contentType, false);
    }

    public TypeCollection(String type, String format) {
        this(new TypeParameter(type, format));
    }

    public TypeCollection(TypeParameter contentType, boolean concrete) {
        super();
        this.contentType = contentType;
        this.concreteImplementation = concrete;
    }

    public TypeCollection(Import importPath) {
        this(new TypeParameter(importPath));
    }

    public TypeCollection(Class<?> clazz) {
        this(new TypeParameter(clazz));
    }

    @Override
    public void translate() throws TranslationException {
        if (contentType == null) {
            throw new TranslationException("The type definition of the map is unknown ");
        }
        try {
            contentType.translate();
            TranslateTypeNameBasedOnContentType();
        } catch (Exception e) {
            e.printStackTrace();
            setClazz(getCollectionClass());
            super.translate();
        }
    }

    public TypeParameter getContentType() {
        return contentType;
    }

    public void setContentType(TypeParameter contentType) {
        this.contentType = contentType == null ? new TypeParameter() : contentType;
    }

    protected boolean isConcreteImplementation() {
        return concreteImplementation;
    }

    protected void setConcreteImplementation(boolean concreteImplementation) {
        this.concreteImplementation = concreteImplementation;
    }

    protected abstract Class<?> getCollectionClass();

    protected abstract void TranslateTypeNameBasedOnContentType();
}
