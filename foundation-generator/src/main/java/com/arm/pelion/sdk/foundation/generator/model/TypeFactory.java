package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;

public class TypeFactory {

    public static ParameterType getCorrespondingType(Class<?> type) {
        if (type == null) {
            return null;
        }
        if (type.isArray() || List.class.isAssignableFrom(type)) {
            return new ListType();
        }
        if (Map.class.isAssignableFrom(type)) {
            return new HashtableType();
        }
        if (ListResponse.class.isAssignableFrom(type)) {
            return new ListResponseType();
        }
        if (RespList.class.isAssignableFrom(type)) {
            return new ListResponseType().respList();
        }
        if (Mapper.class.isAssignableFrom(type)) {
            return new MapperType();
        }
        return new ParameterType(type);
    }

}
