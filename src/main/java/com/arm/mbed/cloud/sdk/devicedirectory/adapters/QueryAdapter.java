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
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceQueryPatchRequest;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceQueryPostPutRequest;

@Preamble(description = "Adapter for query model")
@Internal
public class QueryAdapter {

    public static Query map(DeviceQuery deviceQuery) {
        if (deviceQuery == null) {
            return null;
        }
        Query query = new Query(deviceQuery.getId(), TranslationUtils.toDate(deviceQuery.getCreatedAt()),
                TranslationUtils.toDate(deviceQuery.getUpdatedAt()));
        query.setName(deviceQuery.getName());
        query.setFilter(decodeFilters(deviceQuery.getQuery()));
        return query;
    }

    public static Mapper<DeviceQuery, Query> getMapper() {
        return new Mapper<DeviceQuery, Query>() {

            @Override
            public Query map(DeviceQuery toBeMapped) {
                return QueryAdapter.map(toBeMapped);
            }

        };
    }

    public static ListResponse<Query> mapList(DeviceQueryPage list) {
        final DeviceQueryPage queryList = list;
        RespList<DeviceQuery> respList = new RespList<DeviceQuery>() {

            @Override
            public Boolean getHasMore() {
                return (queryList == null) ? null : queryList.getHasMore();
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

    public static Mapper<DeviceQueryPage, ListResponse<Query>> getListMapper() {
        return new Mapper<DeviceQueryPage, ListResponse<Query>>() {

            @Override
            public ListResponse<Query> map(DeviceQueryPage toBeMapped) {
                return QueryAdapter.mapList(toBeMapped);
            }

        };
    }

    public static DeviceQueryPostPutRequest reverseMapAdd(Query query) {
        if (query == null) {
            return null;
        }
        DeviceQueryPostPutRequest deviceQuery = new DeviceQueryPostPutRequest();
        deviceQuery.setName(query.getName());
        deviceQuery.setQuery(encodeFilters(query.getFilter()));
        return deviceQuery;
    }

    public static DeviceQueryPatchRequest reverseMapUpdate(Query query) {
        if (query == null) {
            return null;
        }
        DeviceQueryPatchRequest deviceQuery = new DeviceQueryPatchRequest();
        deviceQuery.setName(query.getName());
        deviceQuery.setQuery(encodeFilters(query.getFilter()));
        return deviceQuery;
    }

    private static Filters decodeFilters(String query) {
        return DeviceAdapter.FILTERS_MARSHALLER.decode(query);
    }

    private static String encodeFilters(Filters filter) {
        return DeviceAdapter.FILTERS_MARSHALLER.encode(filter);
    }

}
