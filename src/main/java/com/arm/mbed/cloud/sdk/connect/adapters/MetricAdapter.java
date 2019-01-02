package com.arm.mbed.cloud.sdk.connect.adapters;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.IncludeField;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.connect.model.Metric;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.SuccessfulResponse;

@Preamble(description = "Adapter for metric model")
public final class MetricAdapter {

    private MetricAdapter() {
        super();
    }

    /**
     * Maps metrics.
     *
     * @param apiMetric
     *            metrics to map
     * @return metrics
     */
    public static Metric map(com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Metric apiMetric) {
        if (apiMetric == null) {
            return null;
        }
        return new Metric(apiMetric.getId(), TranslationUtils.toDate(apiMetric.getTimestamp()),
                          TranslationUtils.toLong(apiMetric.getTransactions()),
                          TranslationUtils.toLong(apiMetric.getConnectRestApiSuccess()),
                          TranslationUtils.toLong(apiMetric.getConnectRestApiError()),
                          TranslationUtils.toLong(apiMetric.getHandshakesSuccessful()),
                          TranslationUtils.toLong(apiMetric.getBootstrapsPending()),
                          TranslationUtils.toLong(apiMetric.getBootstrapsSuccessful()),
                          TranslationUtils.toLong(apiMetric.getBootstrapsFailed()),
                          TranslationUtils.toLong(apiMetric.getFullRegistrations()),
                          TranslationUtils.toLong(apiMetric.getRegistrationUpdates()),
                          TranslationUtils.toLong(apiMetric.getExpiredRegistrations()),
                          TranslationUtils.toLong(apiMetric.getDeletedRegistrations()),
                          TranslationUtils.toLong(apiMetric.getDeviceProxyRequestSuccess()),
                          TranslationUtils.toLong(apiMetric.getDeviceProxyRequestError()),
                          TranslationUtils.toLong(apiMetric.getDeviceSubscriptionRequestSuccess()),
                          TranslationUtils.toLong(apiMetric.getDeviceSubscriptionRequestError()),
                          TranslationUtils.toLong(apiMetric.getDeviceObservations())

        );

    }

    /**
     * Gets a mapper.
     *
     * @return a mapper
     */
    public static Mapper<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Metric, Metric> getMapper() {
        return new Mapper<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Metric, Metric>() {

            @Override
            public Metric map(com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Metric toBeMapped) {
                return MetricAdapter.map(toBeMapped);
            }

        };
    }

    /**
     * Maps a list of metrics.
     *
     * @param list
     *            of metrics.
     * @return list of metrics
     */
    public static ListResponse<Metric> mapList(SuccessfulResponse list) {
        final SuccessfulResponse metricsList = list;
        final RespList<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Metric> respList = new RespList<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Metric>() {

            @Override
            public Boolean getHasMore() {
                return (metricsList == null) ? null : metricsList.isHasMore();
            }

            @Override
            public Integer getTotalCount() {
                return (metricsList == null) ? null : metricsList.getTotalCount();
            }

            @Override
            public String getAfter() {
                return (metricsList == null) ? null : metricsList.getAfter();
            }

            @Override
            public Integer getLimit() {
                return (metricsList == null) ? null : metricsList.getLimit();
            }

            @Override
            public String getOrder() {
                return Order.getDefault().getString();
            }

            @Override
            public List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Metric> getData() {
                return (metricsList == null) ? null : metricsList.getData();
            }

            @Override
            public String getContinuationMarker() {
                return null;
            }
        };
        return GenericAdapter.mapList(respList, getMapper());
    }

    /**
     * Gets list mapper.
     *
     * @return a list mapper
     */
    public static Mapper<SuccessfulResponse, ListResponse<Metric>> getListMapper() {
        return new Mapper<SuccessfulResponse, ListResponse<Metric>>() {

            @Override
            public ListResponse<Metric> map(SuccessfulResponse toBeMapped) {
                return MetricAdapter.mapList(toBeMapped);
            }

        };
    }

    /**
     * Maps include fields
     *
     * @param includeFields
     *            include fields to encode.
     * @return a string containing all include fields
     */
    public static String mapIncludes(List<IncludeField> includeFields) {
        final IncludeMapping mapping = IncludeMappingHolder.INSTANCE;
        // In case no field is specified, default includes are used
        if (includeFields == null) {
            return mapping.getDefaultIncludes();
        }
        final StringBuilder builder = new StringBuilder();
        boolean start = true;
        int numberOfIncludedFields = 0;
        for (final IncludeField field : includeFields) {
            if (!start) {
                builder.append(',');
            }
            final String mappedValue = mapping.getMappedValue(field.toString());
            if (mappedValue == null) {
                continue;
            }
            builder.append(mappedValue);
            numberOfIncludedFields++;
            start = false;
        }
        // In case no field could be mapped, default includes are used
        if (numberOfIncludedFields == 0) {
            return mapping.getDefaultIncludes();
        }
        return builder.toString();
    }

    private static class IncludeMappingHolder {
        public static final IncludeMapping INSTANCE = new IncludeMapping();
    }

    private static class IncludeMapping {

        private final Map<String, String> mapping;
        private final String defaultIncludes;

        public IncludeMapping() {
            super();
            mapping = new Hashtable<>(6);
            mapping.put("transactions", "transactions");
            mapping.put("successfulApiCalls", "connect_rest_api_success");
            mapping.put("failedApiCalls", "connect_rest_api_error");
            mapping.put("handshakes", "handshakes_successful");
            mapping.put("pendingBootstraps", "bootstraps_pending");
            mapping.put("successfulBootstraps", "bootstraps_successful");
            mapping.put("failedBootstraps", "bootstraps_failed");
            mapping.put("fullRegistrations", "full_registrations");
            mapping.put("updatedRegistrations", "registration_updates");
            mapping.put("expiredRegistrations", "expired_registrations");
            mapping.put("deletedRegistrations", "deleted_registrations");
            mapping.put("successfulProxyRequests", "device_proxy_request_success");
            mapping.put("failedProxyRequests", "device_proxy_request_error");
            mapping.put("successfulSubscriptionRequests", "device_subscription_request_success");
            mapping.put("failedSubscriptionRequests", "device_subscription_request_error");
            mapping.put("observations", "device_observations");

            boolean start = true;
            final StringBuilder builder = new StringBuilder();
            for (final String field : mapping.values()) {
                if (!start) {
                    builder.append(',');
                }
                builder.append(field);
                start = false;
            }
            defaultIncludes = builder.toString();
        }

        public String getDefaultIncludes() {
            return defaultIncludes;
        }

        public String getMappedValue(String value) {
            if (value == null) {
                return null;
            }
            return mapping.get(value);
        }

    }
}
