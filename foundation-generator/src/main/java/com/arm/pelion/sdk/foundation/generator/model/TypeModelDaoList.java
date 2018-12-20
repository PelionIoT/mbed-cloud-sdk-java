package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.dao.AbstractModelListDao;
import com.arm.mbed.cloud.sdk.common.dao.ModelListDao;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;

public class TypeModelDaoList extends TypeCompose {
    private final TypeParameter optionsType;

    public TypeModelDaoList() {
        super();
        optionsType = null;
    }

    public TypeModelDaoList(boolean concrete) {
        super(concrete);
        optionsType = null;
    }

    public TypeModelDaoList(TypeParameter contentType) {
        super(contentType);
        optionsType = null;
    }

    public TypeModelDaoList(TypeParameter optionsType, TypeParameter contentType) {
        super(contentType);
        this.optionsType = optionsType;
    }

    public TypeModelDaoList(String type, String format) {
        super(type, format);
        optionsType = null;
    }

    public TypeModelDaoList(TypeParameter contentType, boolean concrete) {
        super(contentType, concrete);
        optionsType = null;
    }

    public TypeModelDaoList(Import importPath) {
        super(importPath);
        optionsType = null;
    }

    public TypeModelDaoList(Class<?> clazz) {
        super(clazz);
        optionsType = null;
    }

    @Override
    protected Class<?> getCollectionClass() {
        return concreteImplementation ? AbstractModelListDao.class : ModelListDao.class;
    }

    @Override
    protected void TranslateTypeNameBasedOnContentType() {
        setTypeName(contentType.hasClass()
                    && optionsType.hasClass() ? ParameterizedTypeName.get(getCollectionClass(), contentType.getClazz(), optionsType.getClazz()) : ParameterizedTypeName.get(ClassName.get(getCollectionClass()), contentType.getTypeName(), optionsType.getTypeName()));
    }

    @Override
    public void translate() throws TranslationException {
        if (optionsType == null) {
            throw new TranslationException("The type definition of the list options is unknown ");
        }
        super.translate();
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
