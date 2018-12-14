package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;

import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;

public class TypeListResponse extends TypeCompose {

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

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.ParameterType#getShortName()
     */
    @Override
    public String getShortName() {
        return List.class.getSimpleName();
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
    protected void TranslateTypeNameBasedOnContentType() {
        setTypeName(contentType.hasClass() ? ParameterizedTypeName.get(isRespList() ? RespList.class
                                                                                    : ListResponse.class,
                                                                       contentType.getClazz())
                                           : ParameterizedTypeName.get(ClassName.get(isRespList() ? RespList.class
                                                                                                  : ListResponse.class),
                                                                       contentType.getTypeName()));

    }

}
