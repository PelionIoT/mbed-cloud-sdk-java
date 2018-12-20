package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.dao.AbstractModelListDao;
import com.arm.mbed.cloud.sdk.common.dao.ModelListDao;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;

public class TypeModelDaoList extends TypeCompose {
    private final TypeParameter optionsType;

    public TypeModelDaoList() {
        super();
        optionsType = defaultListOptions();
    }

    public TypeModelDaoList(boolean concrete) {
        super(concrete);
        optionsType = defaultListOptions();
    }

    public TypeModelDaoList(TypeParameter contentType) {
        super(contentType);
        optionsType = defaultListOptions();
    }

    public TypeModelDaoList(TypeParameter optionsType, TypeParameter contentType) {
        super(contentType);
        this.optionsType = optionsType == null ? defaultListOptions() : optionsType;
    }

    public TypeParameter defaultListOptions() {
        return new TypeParameter(new Import(ListOptions.class.getSimpleName(),
                                            ListOptions.class.getPackage().getName()));
    }

    public TypeModelDaoList(String type, String format) {
        super(type, format);
        optionsType = defaultListOptions();
    }

    public TypeModelDaoList(TypeParameter contentType, boolean concrete) {
        super(contentType, concrete);
        optionsType = defaultListOptions();
    }

    public TypeModelDaoList(Import importPath) {
        super(importPath);
        optionsType = defaultListOptions();
    }

    public TypeModelDaoList(Class<?> clazz) {
        super(clazz);
        optionsType = defaultListOptions();
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
        optionsType.translate();
        super.translate();
    }

    @Override
    public String toString() {
        return "TypeModelDaoList [optionsType=" + optionsType + ", contentType=" + contentType
               + ", concreteImplementation=" + concreteImplementation + "]";
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
