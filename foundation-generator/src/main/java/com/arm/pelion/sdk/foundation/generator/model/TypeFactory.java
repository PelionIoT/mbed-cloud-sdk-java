package com.arm.pelion.sdk.foundation.generator.model;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.dao.ModelDao;
import com.arm.mbed.cloud.sdk.common.dao.ModelListDao;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.PageRequester;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;

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
        if (Paginator.class.isAssignableFrom(type)) {
            return new TypePaginator();
        }
        if (PageRequester.class.isAssignableFrom(type)) {
            return new TypePageRequester();
        }
        if (ModelDao.class.isAssignableFrom(type)) {
            return new TypeModelDao();
        }
        if (ModelListDao.class.isAssignableFrom(type)) {
            return new TypeModelDaoList();
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

    public static TypeParameter dateType() {
        return new TypeParameter(TypePrimitive.SDK_DATE_CLASS);
    }

    public static TypeParameter stringType() {
        return new TypeParameter(String.class);
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

    private static Class<?> determineContentClass(Type genericType, int index) {
        try {
            if (!(genericType instanceof ParameterizedType)) {
                return null;
            }
            final String typeName = ((ParameterizedType) genericType).getActualTypeArguments()[index].getTypeName();
            // Checks whether it is sensible to actually find corresponding class i.e. checks if typeName is actually a
            // potential class name.
            if (typeName == null || typeName.isEmpty() || typeName.length() == 1) {
                return null;
            }
            return Class.forName(typeName);
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
            return null;
        }
    }

}
