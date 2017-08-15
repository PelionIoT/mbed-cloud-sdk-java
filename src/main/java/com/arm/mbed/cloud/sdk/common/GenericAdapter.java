package com.arm.mbed.cloud.sdk.common;

import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Generic adapter")
@Internal
public class GenericAdapter {
    public interface Mapper<U, T> {
        T map(U toBeMapped);
    }

    public interface RespList<U> {
        Boolean getHasMore();

        Integer getTotalCount();

        String getAfter();

        Integer getLimit();

        String getOrder();

        List<U> getData();
    }

    public static <T, U> ListResponse<T> mapList(RespList<U> respList, Mapper<U, T> mapper) {
        if (respList == null || mapper == null) {
            return null;
        }
        ListResponse<T> responseList = new ListResponse<>(TranslationUtils.toBool(respList.getHasMore(), false),
                TranslationUtils.toInt(respList.getTotalCount()), respList.getAfter(),
                TranslationUtils.toInt(respList.getLimit()), Order.getOrder(respList.getOrder()));
        if (respList.getData() == null || respList.getData().isEmpty()) {
            return responseList;
        }
        for (U resp : respList.getData()) {
            responseList.addData(mapper.map(resp));
        }
        return responseList;

    }

    public static <T, U> List<T> mapList(List<U> list, Mapper<U, T> mapper) {
        if (list == null || mapper == null) {
            return null;
        }
        List<T> mappedList = new LinkedList<>();
        for (U element : list) {
            mappedList.add(mapper.map(element));
        }
        return mappedList;
    }
}
