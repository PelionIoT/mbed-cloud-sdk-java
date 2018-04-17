package com.arm.mbed.cloud.sdk.common;

import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;

@Preamble(description = "Generic adapter")
@Internal
public class GenericAdapter {

    private GenericAdapter() {
        super();
    }

    /**
     * Mapper interface.
     * <p>
     * Utility in charge of converting an object U into an object T.
     *
     * @param <U>
     *            Type of the object to convert from.
     * @param <T>
     *            Type of the object to convert to.
     */
    public interface Mapper<U, T> {
        T map(U toBeMapped);
    }

    /**
     * Gets an Identity mapper.
     *
     * @param <T>
     *            Type of the object to convert from/to.
     * @return a mapper which maps an object to itself.
     */
    public static <T> Mapper<T, T> identityMapper() {
        return new Mapper<T, T>() {

            @Override
            public T map(T toBeMapped) {
                return toBeMapped;
            }
        };
    }

    /**
     * Paginated response from the server.
     * <p>
     * A typical page returned from server when listing objects.
     *
     * @param <U>
     *            type of objects listed
     */
    public interface RespList<U> {
        Boolean getHasMore();

        Integer getTotalCount();

        String getAfter();

        Integer getLimit();

        String getOrder();

        List<U> getData();
    }

    /**
     * Maps a page of objects U into a list of object T.
     *
     * @param respList
     *            page (i.e. paginated response from server)
     * @param mapper
     *            mapper of each object.
     * @param <U>
     *            type of the object to be mapped from
     * @param <T>
     *            type of the object to be mapped to
     * @return mapped list or null if list is null @see ListResponse
     */
    public static <T extends SdkModel, U> ListResponse<T> mapList(RespList<U> respList, Mapper<U, T> mapper) {
        if (respList == null || mapper == null) {
            return null;
        }
        final ListResponse<T> responseList = new ListResponse<>(TranslationUtils.toBool(respList.getHasMore(), false),
                TranslationUtils.toInt(respList.getTotalCount()), respList.getAfter(),
                TranslationUtils.toInt(respList.getLimit()),
                Order.parseOrder(respList.getOrder(), Order.getUnknownEnum()));
        if (respList.getData() == null || respList.getData().isEmpty()) {
            return responseList;
        }
        for (final U resp : respList.getData()) {
            responseList.addData(mapper.map(resp));
        }
        return responseList;

    }

    /**
     * Maps a list of objects U into a list of object T.
     *
     * @param list
     *            to map.
     * @param mapper
     *            mapper of each object.
     * @param <U>
     *            type of the object to be mapped from
     * @param <T>
     *            type of the object to be mapped to
     * @return mapped list or null if list is null
     */
    public static <T, U> List<T> mapList(List<U> list, Mapper<U, T> mapper) {
        if (list == null || mapper == null) {
            return null;
        }
        return mapList(list, new LinkedList<T>(), mapper);
    }

    /**
     * Maps a list of objects U into a list of object T.
     *
     * @param list
     *            to map.
     * @param mappedList
     *            container of mapped objects
     * @param mapper
     *            mapper of each object.
     * @param <U>
     *            type of the object to be mapped from
     * @param <T>
     *            type of the object to be mapped to
     * @return mapped list
     */
    public static <T, U> List<T> mapList(List<U> list, List<T> mappedList, Mapper<U, T> mapper) {
        if (list == null || mapper == null) {
            return mappedList;
        }
        for (final U element : list) {
            mappedList.add(mapper.map(element));
        }
        return mappedList;
    }
}
