package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.dao.AbstractModelListDao;
import com.arm.mbed.cloud.sdk.common.dao.ModelListDao;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;

public class TypeModelDaoList extends TypeCompose {
    private final TypeParameter optionsType;

    protected TypeModelDaoList(Import importPath, Class<?> clazz, TypeName typeName, String type, String format,
                               TypeParameter contentType, boolean concrete, TypeParameter optionsType) {
        super(importPath, clazz, typeName, type, format, contentType, concrete);
        this.optionsType = optionsType;
    }

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
        return concreteImplementation ? getRawClass() : ModelListDao.class;
    }

    @Override
    public Class<?> getRawClass() {
        return AbstractModelListDao.class;
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

    @Override
    public TypeModelDaoList clone() {
        return new TypeModelDaoList(importPath == null ? null : importPath.clone(), clazz, typeName, type, format,
                                    optionsType, concreteImplementation,
                                    optionsType == null ? null : optionsType.clone());
    }
}
