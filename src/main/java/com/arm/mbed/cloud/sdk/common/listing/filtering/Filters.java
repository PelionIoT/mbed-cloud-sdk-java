package com.arm.mbed.cloud.sdk.common.listing.filtering;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "filters")
public class Filters {
    private final Map<String, Map<FilterOperator, List<Filter>>> filterList;

    public Filters() {
        filterList = new LinkedHashMap<>();
    }

    /**
     * @return the filters
     */
    public Map<String, Map<FilterOperator, List<Filter>>> getFilters() {
        return filterList;
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
                filterList.put(filter.getFieldName(), map);
            }
            map.put(filter.getOperator(), filtersForField);
        }
    }

    public Map<FilterOperator, List<Filter>> getFiltersForField(String fieldName) {
        return filterList.get(fieldName);
    }

    public List<Filter> get(String fieldName) {
        final Map<FilterOperator, List<Filter>> filtersForField = getFiltersForField(fieldName);
        if (filtersForField == null) {
            return null;
        }
        final List<Filter> filtersForFieldList = new LinkedList<>();
        for (final List<Filter> sublist : filtersForField.values()) {
            filtersForFieldList.addAll(sublist);
        }
        return filtersForFieldList;
    }

    public List<Filter> get() {
        if (filterList.isEmpty()) {
            return null;
        }
        final List<Filter> filtersList = new LinkedList<>();
        for (final String fieldName : filterList.keySet()) {
            filtersList.addAll(get(fieldName));
        }
        return filtersList;
    }

    public boolean hasCustomFilters() {
        if (filterList == null || filterList.isEmpty()) {
            return false;
        }
        for (final Filter filter : get()) {
            if (filter instanceof CustomFilter) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return filterList.isEmpty();
    }

    public boolean hasFilters(String fieldName) {
        return filterList.containsKey(fieldName);
    }

    public boolean hasFilters(String fieldName, FilterOperator operator) {
        return hasFilters(fieldName) ? getFiltersForField(fieldName).containsKey(operator) : false;
    }

    public List<Filter> get(String fieldName, FilterOperator operator) {
        final Map<FilterOperator, List<Filter>> filtersForField = filterList.get(fieldName);
        return filtersForField == null ? null : filtersForField.get(operator);
    }
}
