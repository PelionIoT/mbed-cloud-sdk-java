package com.arm.mbed.cloud.sdk.connect.adapters;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.listing.IncludeField;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.connect.model.Metric;
import com.arm.mbed.cloud.sdk.internal.statistics.model.SuccessfulResponse;

@Preamble(description = "Adapter for metric model")
public class MetricAdapter {

    public static Metric map(com.arm.mbed.cloud.sdk.internal.statistics.model.Metric apiMetric) {
        if (apiMetric == null) {
            return null;
        }
        Metric metric = new Metric();
        metric.setFailedApiCalls(TranslationUtils.toLong(apiMetric.getDeviceServerRestApiError()));
        metric.setFailedDeviceRegistrations(TranslationUtils.toLong(apiMetric.getBootstrapsFailed()));
        metric.setFailedHandshakes(TranslationUtils.toLong(apiMetric.getHandshakesFailed()));
        metric.setId(apiMetric.getId());
        metric.setPendingDeviceRegistrations(TranslationUtils.toLong(apiMetric.getBootstrapsPending()));
        metric.setRegisteredDevices(TranslationUtils.toLong(apiMetric.getRegisteredDevices()));
        metric.setSuccessfulApiCalls(TranslationUtils.toLong(apiMetric.getDeviceServerRestApiSuccess()));
        metric.setSuccessfulDeviceRegistrations(TranslationUtils.toLong(apiMetric.getBootstrapsSuccessful()));
        metric.setSuccessfulHandshakes(TranslationUtils.toLong(apiMetric.getHandshakesSuccessful()));
        metric.setTimestamp(TranslationUtils.convertTimestamp(apiMetric.getTimestamp(), new Date()));
        metric.setTransactions(TranslationUtils.toLong(apiMetric.getTransactions()));
        return metric;
    }

    public static Mapper<com.arm.mbed.cloud.sdk.internal.statistics.model.Metric, Metric> getMapper() {
        return new Mapper<com.arm.mbed.cloud.sdk.internal.statistics.model.Metric, Metric>() {

            @Override
            public Metric map(com.arm.mbed.cloud.sdk.internal.statistics.model.Metric toBeMapped) {
                return MetricAdapter.map(toBeMapped);
            }

        };
    }

    public static List<Metric> mapList(List<com.arm.mbed.cloud.sdk.internal.statistics.model.Metric> list) {
        if (list == null) {
            return null;
        }
        return GenericAdapter.mapList(list, getMapper());
    }

    public static Mapper<SuccessfulResponse, List<Metric>> getListMapper() {
        return new Mapper<SuccessfulResponse, List<Metric>>() {

            @Override
            public List<Metric> map(SuccessfulResponse toBeMapped) {
                return MetricAdapter.mapList(toBeMapped.getData());
            }

        };
    }

    public static String mapIncludes(List<IncludeField> includeFields) {
        if (includeFields == null) {
            return null;
        }
        IncludeMapping mapping = IncludeMappingHolder.Instance;
        StringBuilder builder = new StringBuilder();
        boolean start = true;
        for (IncludeField field : includeFields) {
            if (!start) {
                builder.append(",");
            }
            builder.append(mapping.getMappedValue(field.toString()));
            start = false;
        }
        return builder.toString();
    }

    private static class IncludeMappingHolder {
        public static final IncludeMapping Instance = new IncludeMapping();
    }

    private static class IncludeMapping {

        private final Map<String, String> mapping;

        public IncludeMapping() {
            super();
            mapping = new Hashtable<>(6);
            mapping.put("transactions", "transactions");
            mapping.put("successfulDeviceRegistrations", "bootstraps_successful");
            mapping.put("pendingDeviceRegistrations", "bootstraps_pending");
            mapping.put("failedDeviceRegistrations", "bootstraps_failed");
            mapping.put("successfulApiCalls", "device_server_rest_api_success");
            mapping.put("failedApiCalls", "device_server_rest_api_error");

        }

        public String getMappedValue(String value) {
            if (value == null) {
                return null;
            }
            return mapping.get(value);
        }

    }
}
