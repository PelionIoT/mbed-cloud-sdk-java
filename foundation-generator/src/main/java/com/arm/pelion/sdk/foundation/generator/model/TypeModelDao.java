package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.dao.AbstractModelDao;
import com.arm.mbed.cloud.sdk.common.dao.ModelDao;
import com.squareup.javapoet.TypeName;

public class TypeModelDao extends TypeCompose {
    private final Class<?> collectionClass;

    protected TypeModelDao(Import importPath, Class<?> clazz, TypeName typeName, String type, String format,
                           TypeParameter contentType, boolean concrete, Class<?> collectionClass) {
        super(importPath, clazz, typeName, type, format, contentType, concrete);
        this.collectionClass = collectionClass;
    }

    public TypeModelDao() {
        super();
        collectionClass = null;
    }

    public TypeModelDao(boolean concrete) {
        super(concrete);
        collectionClass = null;
    }

    public TypeModelDao(TypeParameter contentType) {
        super(contentType);
        collectionClass = null;
    }

    public TypeModelDao(Class<?> collectionClass, TypeParameter contentType) {
        super(contentType);
        this.collectionClass = collectionClass;
    }

    public TypeModelDao(String type, String format) {
        super(type, format);
        collectionClass = null;
    }

    public TypeModelDao(TypeParameter contentType, boolean concrete) {
        super(contentType, concrete);
        collectionClass = null;
    }

    public TypeModelDao(Import importPath) {
        super(importPath);
        collectionClass = null;
    }

    public TypeModelDao(Class<?> clazz) {
        super(clazz);
        collectionClass = null;
    }

    @Override
    protected Class<?> getCollectionClass() {
        return concreteImplementation ? getRawClass() : collectionClass == null ? ModelDao.class : collectionClass;
    }

    @Override
    public Class<?> getRawClass() {
        return AbstractModelDao.class;
    }

    @Override
    public String toString() {
        return "TypeModelDao [collectionClass=" + collectionClass + ", contentType=" + contentType
               + ", concreteImplementation=" + concreteImplementation + "]";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.ParameterType#getShortName()
     */
    @Override
    public String getShortName() {
        return ModelDao.class.getSimpleName();
    }

    @Override
    public String getFullyQualifiedName() {
        return ModelDao.class.getName();
    }

    @Override
    public TypeModelDao clone() {
        return new TypeModelDao(importPath == null ? null : importPath.clone(), collectionClass, typeName, type, format,
                                contentType, concreteImplementation, collectionClass);
    }
}
