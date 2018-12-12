package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

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
            // e.printStackTrace();
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (concreteImplementation ? 1231 : 1237);
        result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        TypeCollection other = (TypeCollection) obj;
        if (concreteImplementation != other.concreteImplementation)
            return false;
        if (contentType == null) {
            if (other.contentType != null)
                return false;
        } else if (!contentType.equals(other.contentType))
            return false;
        return true;
    }

    protected abstract Class<?> getCollectionClass();

    protected abstract void TranslateTypeNameBasedOnContentType();
}
