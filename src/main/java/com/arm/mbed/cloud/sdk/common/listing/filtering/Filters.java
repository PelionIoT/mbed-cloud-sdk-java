package com.arm.mbed.cloud.sdk.common.listing.filtering;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "filters for Cloud requests")
public class Filters implements Cloneable {
    private final Map<String, Map<FilterOperator, List<Filter>>> filterList;

    /**
     * Constructor.
     */
    public Filters() {
        this(new LinkedHashMap<String, Map<FilterOperator, List<Filter>>>());
    }

    /**
     * Constructor.
     */
    @Internal
    private Filters(Map<String, Map<FilterOperator, List<Filter>>> filterList) {
        super();
        this.filterList = filterList;
    }

    /**
     * Gets filters definition.
     * 
     * @return the filters
     */
    public Map<String, Map<FilterOperator, List<Filter>>> getFilters() {
        return filterList;
    }

    /**
     * Adds a new filter.
     * 
     * @param filter
     *            filter
     */
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

    /**
     * Gets all filters for a particular field.
     * 
     * @param fieldName
     *            name of the field the filters apply to.
     * @return hashtable of corresponding filters
     */
    public Map<FilterOperator, List<Filter>> getFiltersForField(@NonNull String fieldName) {
        return filterList.get(fieldName);
    }

    /**
     * Gets all filters for a particular field.
     * 
     * @param fieldName
     *            name of the field the filters apply to.
     * @return list of corresponding filters
     */
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

    /**
     * Gets all defined filters.
     * 
     * @return list of all defined filters
     */
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

    /**
     * Gets all filters for a particular field and a particular operator {@link FilterOperator}.
     * 
     * @param fieldName
     *            name of the field the filters apply to.
     * @param operator
     *            filter operator {@link FilterOperator} to consider
     * @return list of corresponding filters
     */
    public List<Filter> get(String fieldName, FilterOperator operator) {
        final Map<FilterOperator, List<Filter>> filtersForField = filterList.get(fieldName);
        return filtersForField == null ? null : filtersForField.get(operator);
    }

    /**
     * States whether custom filters were defined.
     * 
     * @see CustomFilter
     * @return true if there are custom filters defined
     */
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

    /**
     * States whether no filters were defined.
     * 
     * @return true if not filters were defined. false otherwise
     */
    public boolean isEmpty() {
        return filterList.isEmpty();
    }

    /**
     * States whether some filters are defined for a particular field.
     * 
     * @param fieldName
     *            name of the field.
     * @return true if such filters are defined.
     */
    public boolean hasFilters(String fieldName) {
        return filterList.containsKey(fieldName);
    }

    /**
     * States whether some filters are defined for a particular field and a particular operator {@link FilterOperator}.
     * 
     * @param fieldName
     *            name of the field.
     * @param operator
     *            filter operator {@link FilterOperator}
     * @return true if such filters are defined.
     */
    public boolean hasFilters(String fieldName, FilterOperator operator) {
        return hasFilters(fieldName) ? getFiltersForField(fieldName).containsKey(operator) : false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Filters clone() {
        return new Filters(filterList);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((filterList == null) ? 0 : filterList.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Filters other = (Filters) obj;
        if (filterList == null) {
            if (other.filterList != null) {
                return false;
            }
        } else if (!filterList.equals(other.filterList)) {
            return false;
        }
        return true;
    }

}
