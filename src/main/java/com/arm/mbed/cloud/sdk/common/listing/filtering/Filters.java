package com.arm.mbed.cloud.sdk.common.listing.filtering;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "filters")
public class Filters {
    private final Map<String, Map<FilterOperator, List<Filter>>> filters;
    private Map<String, String> fieldNameMapping;

    public Filters() {
        filters = new LinkedHashMap<>();
        fieldNameMapping = null;

    }

    public void applyFieldnameMapping(Map<String, String> mapping) {
        fieldNameMapping = mapping;
    }

    public void add(Filter filter) {
        if (filter == null || !filter.isValid()) {
            return;
        }
        List<Filter> filtersForField = get(filter.getFieldName(), filter.getOperator());
        if (filtersForField == null) {
            filtersForField = new LinkedList<>();
        }
        filtersForField.add(filter);
        if (!hasFilters(filter.getFieldName(), filter.getOperator())) {
            Map<FilterOperator, List<Filter>> map = getFiltersForField(filter.getFieldName());
            if (map == null) {
                map = new LinkedHashMap<>();
                filters.put(filter.getFieldName(), map);
            }
            map.put(filter.getOperator(), filtersForField);
        }
    }

    public Map<FilterOperator, List<Filter>> getFiltersForField(String fieldName) {
        return filters.get(fieldName);
    }

    public List<Filter> get(String fieldName) {
        Map<FilterOperator, List<Filter>> filtersForField = getFiltersForField(fieldName);
        if (filtersForField == null) {
            return null;
        }
        List<Filter> filtersForFieldList = new LinkedList<>();
        for (List<Filter> sublist : filtersForField.values()) {
            filtersForFieldList.addAll(sublist);
        }
        return filtersForFieldList;
    }

    public List<Filter> get() {
        if (filters.isEmpty()) {
            return null;
        }
        List<Filter> filtersList = new LinkedList<>();
        for (String fieldName : filters.keySet()) {
            filtersList.addAll(get(fieldName));
        }
        return filtersList;
    }

    public boolean hasFilters(String fieldName) {
        return filters.containsKey(fieldName);
    }

    public boolean hasFilters(String fieldName, FilterOperator operator) {
        return (!hasFilters(fieldName)) ? false : getFiltersForField(fieldName).containsKey(operator);
    }

    public List<Filter> get(String fieldName, FilterOperator operator) {
        Map<FilterOperator, List<Filter>> filtersForField = filters.get(fieldName);
        return (filtersForField == null) ? null : filtersForField.get(operator);
    }

    public String encode() {
        return encodeList(get());
    }

    public String encode(String fieldName) {
        return encodeList(get(fieldName));
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
                builder.append("&");
            }
            String newFieldName = (fieldNameMapping == null) ? null : fieldNameMapping.get(filter.getFieldName());
            builder.append((newFieldName == null) ? filter.encodeFilter() : filter.encodeFilter(newFieldName));
            start = false;
        }
        return builder.toString();
    }

}
