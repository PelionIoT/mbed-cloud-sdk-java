package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.dao.AbstractModelListDao;
import com.arm.mbed.cloud.sdk.common.dao.ModelListDao;

public class TypeModelListDao extends TypeCompose {

    public TypeModelListDao() {
        super();
    }

    public TypeModelListDao(boolean concrete) {
        super(concrete);
    }

    public TypeModelListDao(TypeParameter contentType) {
        super(contentType);
    }

    public TypeModelListDao(String type, String format) {
        super(type, format);
    }

    public TypeModelListDao(TypeParameter contentType, boolean concrete) {
        super(contentType, concrete);
    }

    public TypeModelListDao(Import importPath) {
        super(importPath);
    }

    public TypeModelListDao(Class<?> clazz) {
        super(clazz);
    }

    @Override
    protected Class<?> getCollectionClass() {
        return concreteImplementation ? AbstractModelListDao.class : ModelListDao.class;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.ParameterType#getShortName()
     */
    @Override
    public String getShortName() {
        return ModelListDao.class.getSimpleName();
    }
}
