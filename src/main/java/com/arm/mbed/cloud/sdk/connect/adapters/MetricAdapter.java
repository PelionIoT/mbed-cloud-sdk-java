package com.arm.mbed.cloud.sdk.connect.adapters;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.IncludeField;
import com.arm.mbed.cloud.sdk.connect.model.Metric;
import com.arm.mbed.cloud.sdk.internal.statistics.model.SuccessfulResponse;

@Preamble(description = "Adapter for metric model")
public class MetricAdapter {

    public static Metric map(com.arm.mbed.cloud.sdk.internal.statistics.model.Metric apiMetric) {
        if (apiMetric == null) {
            return null;
        }
        return new Metric(apiMetric.getId(),
                TranslationUtils.convertRFC3339Timestamp(apiMetric.getTimestamp(), new Date()),
                TranslationUtils.toLong(apiMetric.getTransactions()),
                TranslationUtils.toLong(apiMetric.getDeviceServerRestApiSuccess()),
                TranslationUtils.toLong(apiMetric.getDeviceServerRestApiError()),
                TranslationUtils.toLong(apiMetric.getHandshakesSuccessful()),
                TranslationUtils.toLong(apiMetric.getBootstrapsPending()),
                TranslationUtils.toLong(apiMetric.getBootstrapsSuccessful()),
                TranslationUtils.toLong(apiMetric.getBootstrapsFailed()),
                TranslationUtils.toLong(apiMetric.getFullRegistrations()),
                TranslationUtils.toLong(apiMetric.getRegistrationUpdates()),
                TranslationUtils.toLong(apiMetric.getExpiredRegistrations()),
                TranslationUtils.toLong(apiMetric.getDeletedRegistrations()));
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
        IncludeMapping mapping = IncludeMappingHolder.Instance;
        // In case no field is specified, default includes are used
        if (includeFields == null) {
            return mapping.getDefaultIncludes();
        }
        StringBuilder builder = new StringBuilder();
        boolean start = true;
        int numberOfIncludedFields = 0;
        for (IncludeField field : includeFields) {
            if (!start) {
                builder.append(",");
            }
            String mappedValue = mapping.getMappedValue(field.toString());
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
        public static final IncludeMapping Instance = new IncludeMapping();
    }

    private static class IncludeMapping {

        private final Map<String, String> mapping;
        private final String defaultIncludes;

        public IncludeMapping() {
            super();
            mapping = new Hashtable<>(6);
            mapping.put("transactions", "transactions");
            mapping.put("successfulDeviceRegistrations", "bootstraps_successful");
            mapping.put("pendingDeviceRegistrations", "bootstraps_pending");
            mapping.put("failedDeviceRegistrations", "bootstraps_failed");
            mapping.put("successfulApiCalls", "device_server_rest_api_success");
            mapping.put("failedApiCalls", "device_server_rest_api_error");

            boolean start = true;
            StringBuilder builder = new StringBuilder();
            for (String field : mapping.values()) {
                if (!start) {
                    builder.append(",");
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
