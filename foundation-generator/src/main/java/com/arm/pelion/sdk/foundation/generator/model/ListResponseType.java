package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;

import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;

public class ListResponseType extends ParameterType {

    private ParameterType contentType;
    private boolean isRespList;

    public ListResponseType() {
        this(new ParameterType());
    }

    public ListResponseType(ParameterType contentType) {
        this.contentType = contentType;
        isRespList = false;
    }

    public ListResponseType(String type, String format) {
        this(new ParameterType(type, format));
    }

    public ListResponseType(Class<?> clazz) {
        this(new ParameterType(clazz));
    }

    public ListResponseType(Import importPath) {
        this(new ParameterType(importPath));
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.ParameterType#translate()
     */
    @Override
    public void translate() throws TranslationException {
        if (contentType == null) {
            throw new TranslationException("The type definition of the resp list is unknown ");
        }
        contentType.translate();
        setTypeName(contentType.hasClass() ? ParameterizedTypeName.get(isRespList ? RespList.class : ListResponse.class,
                                                                       contentType.getClazz())
                                           : ParameterizedTypeName.get(ClassName.get(isRespList ? RespList.class
                                                                                                : ListResponse.class),
                                                                       contentType.getTypeName()));

    }

    public boolean isRespList() {
        return isRespList;
    }

    public void setRespList(boolean isRespList) {
        this.isRespList = isRespList;
    }

    public ListResponseType respList() {
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
        return "ListResponseType [contentType=" + contentType + ", isRespList=" + isRespList + "]";
    }

}
