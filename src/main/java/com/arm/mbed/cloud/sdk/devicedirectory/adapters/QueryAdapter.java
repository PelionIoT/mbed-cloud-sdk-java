package com.arm.mbed.cloud.sdk.devicedirectory.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Query;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceQuery;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceQueryPage;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceQueryPostPutRequest;

@Preamble(description = "Adapter for query model")
@Internal
public final class QueryAdapter {

    private QueryAdapter() {
        super();
    }

    /**
     * Maps query.
     * 
     * @param deviceQuery
     *            query to map
     * @return a map
     */
    public static Query map(DeviceQuery deviceQuery) {
        if (deviceQuery == null) {
            return null;
        }
        final Query query = new Query(deviceQuery.getId(), TranslationUtils.toDate(deviceQuery.getCreatedAt()),
                TranslationUtils.toDate(deviceQuery.getUpdatedAt()));
        query.setName(deviceQuery.getName());
        query.setFilters(decodeFilters(deviceQuery.getQuery()));
        return query;
    }

    /**
     * Gets a mapper.
     * 
     * @return a mapper
     */
    public static Mapper<DeviceQuery, Query> getMapper() {
        return new Mapper<DeviceQuery, Query>() {

            @Override
            public Query map(DeviceQuery toBeMapped) {
                return QueryAdapter.map(toBeMapped);
            }

        };
    }

    /**
     * Maps a list of query.
     * 
     * @param list
     *            query page.
     * @return a list of queries
     */
    public static ListResponse<Query> mapList(DeviceQueryPage list) {
        final DeviceQueryPage queryList = list;
        final RespList<DeviceQuery> respList = new RespList<DeviceQuery>() {

            @Override
            public Boolean getHasMore() {
                return (queryList == null) ? null : queryList.isHasMore();
            }

            @Override
            public Integer getTotalCount() {
                return (queryList == null) ? null : queryList.getTotalCount();
            }

            @Override
            public String getAfter() {
                return (queryList == null) ? null : queryList.getAfter();
            }

            @Override
            public Integer getLimit() {
                return (queryList == null) ? null : queryList.getLimit();
            }

            @Override
            public String getOrder() {
                return (queryList == null) ? null : queryList.getOrder().toString();
            }

            @Override
            public List<DeviceQuery> getData() {
                return (queryList == null) ? null : queryList.getData();
            }
        };
        return GenericAdapter.mapList(respList, getMapper());
    }

    /**
     * Gets list mapper.
     * 
     * @return list mapper
     */
    public static Mapper<DeviceQueryPage, ListResponse<Query>> getListMapper() {
        return new Mapper<DeviceQueryPage, ListResponse<Query>>() {

            @Override
            public ListResponse<Query> map(DeviceQueryPage toBeMapped) {
                return QueryAdapter.mapList(toBeMapped);
            }

        };
    }

    /**
     * Reverses mapping of a new query.
     * 
     * @param query
     *            query to add
     * @return a new query request
     */
    public static DeviceQueryPostPutRequest reverseMapAdd(Query query) {
        if (query == null) {
            return null;
        }
        final DeviceQueryPostPutRequest deviceQuery = new DeviceQueryPostPutRequest();
        deviceQuery.setName(query.getName());
        deviceQuery.setQuery(encodeFilters(query.fetchFilters()));
        return deviceQuery;
    }

    /**
     * Reverses mapping of an updated query.
     * 
     * @param query
     *            query to update
     * @return a query update request
     */
    public static DeviceQueryPostPutRequest reverseMapUpdate(Query query) {
        if (query == null) {
            return null;
        }
        final DeviceQueryPostPutRequest deviceQuery = new DeviceQueryPostPutRequest();
        deviceQuery.setName(query.getName());
        deviceQuery.setQuery(encodeFilters(query.fetchFilters()));
        return deviceQuery;
    }

    private static Filters decodeFilters(String query) {
        return DeviceAdapter.FILTERS_MARSHALLER.decode(query);
    }

    private static String encodeFilters(Filters filter) {
        return DeviceAdapter.FILTERS_MARSHALLER.encode(filter);
    }

}
