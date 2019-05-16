package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.squareup.javapoet.TypeName;

public class TypeListResponse extends TypeCompose {

    protected TypeListResponse(Import importPath, Class<?> clazz, TypeName typeName, String type, String format,
                               TypeParameter contentType, boolean concrete) {
        super(importPath, clazz, typeName, type, format, contentType, concrete);
    }

    public TypeListResponse() {
        super();
    }

    public TypeListResponse(TypeParameter contentType) {
        super(contentType);
    }

    public TypeListResponse(String type, String format) {
        super(type, format);
    }

    public TypeListResponse(Class<?> clazz) {
        super(clazz);
    }

    public TypeListResponse(Import importPath) {
        super(importPath);
    }

    public boolean isRespList() {
        return isConcreteImplementation();
    }

    public void setRespList(boolean isRespList) {
        setConcreteImplementation(isRespList);
    }

    public TypeListResponse respList() {
        setRespList(true);
        return this;
    }

    @Override
    public boolean isListResponse() {
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.ParameterType#getShortName()
     */
    @Override
    public String getShortName() {
        return ListResponse.class.getSimpleName();
    }

    @Override
    public String toString() {
        return "ListResponseType [contentType=" + contentType + ", isRespList=" + isRespList() + "]";
    }

    @Override
    protected Class<?> getCollectionClass() {
        return isRespList() ? RespList.class : ListResponse.class;
    }

    @Override
    public TypeListResponse clone() {
        return new TypeListResponse(importPath == null ? null : importPath.clone(), clazz, typeName, type, format,
                                    contentType, concreteImplementation);
    }
}
