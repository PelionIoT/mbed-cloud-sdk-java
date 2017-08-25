package com.arm.mbed.cloud.sdk.common.listing.filtering;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Filters marshaller for serialisation/deserialisation")
public class FilterMarshaller {
    private static final String FILTER_KEY_VALUE_SEPARATOR = "=";

    private static final String FILTER_SEPARATOR = "&";

    public static final String SUFFIX_SEPARATOR = "_";

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    private final Map<String, String> fieldNameMapping;
    private final Map<String, String> fieldNameReverseMapping;

    public FilterMarshaller(Map<String, String> fieldNameMapping) {
        super();
        this.fieldNameMapping = fieldNameMapping;
        fieldNameReverseMapping = createReverseMapping(fieldNameMapping);
    }

    public String encode(Filters filters) {
        return (filters == null) ? null : encodeList(filters.get());
    }

    public String encode(String fieldName, Filters filters) {
        return (filters == null) ? null : encodeList(filters.get(fieldName));
    }

    public String encodeFilter(Filter filter, String fieldName) {
        if (filter == null || !filter.isValid()) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        builder.append((fieldName == null) ? filter.getFieldName() : fieldName);
        String suffix = filter.getOperator().getSuffix();
        if (suffix != null) {
            builder.append(suffix);
        }
        builder.append(FILTER_KEY_VALUE_SEPARATOR);
        builder.append(formatFilterValue(filter.getValue()));
        return builder.toString();
    }

    public Filter decodeFilter(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        String[] parts = string.split(FILTER_KEY_VALUE_SEPARATOR);
        if (parts.length != 2) {
            return null;
        }
        FilterOperator operator = FilterOperator.getFromSuffix(fetchSuffix(parts[0]));
        Filter filter = new Filter(fetchFieldName(parts, operator), operator, parts[1]);
        return (filter.isValid()) ? filter : null;
    }

    private String fetchFieldName(String[] parts, FilterOperator operator) {
        String fieldName = removeSuffix(parts[0], operator);
        if (fieldName == null) {
            return null;
        }
        fieldName = fieldName.trim();
        if (fieldNameReverseMapping != null && fieldNameReverseMapping.containsKey(fieldName)) {
            return fieldNameReverseMapping.get(fieldName);
        }
        return fieldName;
    }

    public Filters decode(String filtersString) {
        if (filtersString == null || filtersString.isEmpty()) {
            return null;
        }
        String[] filterStrings = filtersString.split(FILTER_SEPARATOR);
        Filters filters = null;
        for (String filterString : filterStrings) {
            Filter filter = decodeFilter(filterString);
            if (filter != null && filter.isValid()) {
                if (filters == null) {
                    filters = new Filters();
                }
                filters.add(filter);
            }
        }
        return filters;
    }

    private String encodeList(List<Filter> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        boolean start = true;
        for (Filter filter : list) {
            if (!filter.isValid()) {
                continue;
            }
            if (!start) {
                builder.append(FILTER_SEPARATOR);
            }
            String newFieldName = (fieldNameMapping == null) ? null : fieldNameMapping.get(filter.getFieldName());
            builder.append(encodeFilter(filter, newFieldName));
            start = false;
        }
        return builder.toString();
    }

    private Map<String, String> createReverseMapping(Map<String, String> mapping) {
        if (mapping == null) {
            return null;
        }
        Map<String, String> reverseMapping = new HashMap<>();
        for (Entry<String, String> entry : mapping.entrySet()) {
            reverseMapping.put(entry.getValue(), entry.getKey());
        }
        return reverseMapping;
    }

    private Object formatFilterValue(Object value) {
        if (value instanceof Date) {
            return DATE_FORMAT.format(value);
        }
        return String.valueOf(value);
    }

    private String removeSuffix(String string, FilterOperator operator) {
        String suffix = (operator == null) ? null : operator.getSuffix();
        if (suffix != null) {
            string = string.replace(suffix, "");
        }
        return string;
    }

    private String fetchSuffix(String string) {
        if (string == null) {
            return null;
        }
        if (!string.contains(SUFFIX_SEPARATOR)) {
            return null;
        }
        return string.substring(string.indexOf(SUFFIX_SEPARATOR));
    }

}
