package com.arm.pelion.sdk.foundation.generator.model;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;

import retrofit2.Call;

public class TypeFactory {

    public static TypeParameter getCorrespondingType(Class<?> type) {
        if (type == null) {
            return null;
        }
        // type.isArray() ||
        if (List.class.isAssignableFrom(type)) {
            return new TypeList();
        }

        if (Map.class.isAssignableFrom(type)) {
            return new TypeHashtable();
        }
        if (ListResponse.class.isAssignableFrom(type)) {
            return new TypeListResponse();
        }
        if (RespList.class.isAssignableFrom(type)) {
            return new TypeListResponse().respList();
        }
        if (Mapper.class.isAssignableFrom(type)) {
            return new TypeMapper();
        }
        if (Call.class.isAssignableFrom(type)) {
            return new TypeRetrofitCall();
        }
        if (CloudCall.class.isAssignableFrom(type)) {
            return new TypeCloudCall();
        }
        return new TypeParameter(type);
    }

    public static TypeParameter getCorrespondingType(Class<?> type, TypeParameter contentType) {
        final TypeParameter topType = getCorrespondingType(type);
        if (topType instanceof TypeCompose) {
            ((TypeCompose) topType).setContentType(contentType);
        }
        return topType;
    }

    public static TypeParameter getCorrespondingType(Class<?> type, Type genericType) {
        final TypeParameter topType = getCorrespondingType(type);
        if (topType instanceof TypeCompose) {
            int index = 0;
            if (topType.isHashtable()) {
                index = 1;
            }
            ((TypeCompose) topType).setContentType(getCorrespondingType(determineContentClass(genericType, index)));
        }
        return topType;
    }

    public static Class<?> determineContentClass(Type genericType, int index) {
        try {
            return Class.forName(((ParameterizedType) genericType).getActualTypeArguments()[index].getTypeName());
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
            return null;
        }
    }

}
