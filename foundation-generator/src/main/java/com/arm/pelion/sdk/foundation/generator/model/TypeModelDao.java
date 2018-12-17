package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.dao.AbstractModelDao;
import com.arm.mbed.cloud.sdk.common.dao.ModelDao;

public class TypeModelDao extends TypeCompose {

    public TypeModelDao() {
        super();
    }

    public TypeModelDao(boolean concrete) {
        super(concrete);
    }

    public TypeModelDao(TypeParameter contentType) {
        super(contentType);
    }

    public TypeModelDao(String type, String format) {
        super(type, format);
    }

    public TypeModelDao(TypeParameter contentType, boolean concrete) {
        super(contentType, concrete);
    }

    public TypeModelDao(Import importPath) {
        super(importPath);
    }

    public TypeModelDao(Class<?> clazz) {
        super(clazz);
    }

    @Override
    protected Class<?> getCollectionClass() {
        return concreteImplementation ? AbstractModelDao.class : ModelDao.class;
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
}
