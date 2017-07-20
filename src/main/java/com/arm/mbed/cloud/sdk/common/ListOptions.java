package com.arm.mbed.cloud.sdk.common;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Options to use when listing objects")
public class ListOptions {

	/**
	 * how many objects to retrieve in the page
	 */
	@DefaultValue(value = "default")
	private Integer limit;
	/**
	 * ASC or DESC
	 */
	@DefaultValue(value = "ASC")
	private Order order;
	/**
	 * the ID of the the item after which to retrieve the next page
	 */
	private String after;
	/**
	 * Optional fields to include
	 */
	private List<IncludeField> include;
	/**
	 * Optional filters
	 */
	private Map<String, Object> filter;

	public ListOptions() {
		super();
		setLimit(null);
		setOrder(Order.ASC);
		setAfter(null);
		setInclude(null);
	}

	/**
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 *            the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the after
	 */
	public String getAfter() {
		return after;
	}

	/**
	 * @param after
	 *            the after to set
	 */
	public void setAfter(String after) {
		this.after = after;
	}

	/**
	 * @return the include
	 */
	public List<IncludeField> getInclude() {
		return include;
	}

	/**
	 * Gets a string comprising all include fields in Snake case
	 * 
	 * @return string
	 */
	public @Nullable String encodeInclude() {
		if (include == null || include.isEmpty()) {
			return null;
		}
		boolean start = true;
		StringBuilder builder = new StringBuilder();
		for (IncludeField includeField : include) {
			if (!start) {
				builder.append(",");
			}
			builder.append(includeField.encode());
			start = false;
		}
		return builder.toString();
	}

	/**
	 * @param include
	 *            the include to set
	 */
	public void setInclude(List<IncludeField> include) {
		this.include = include;
	}

	/**
	 * @return the filter
	 */
	public Map<String, Object> getFilter() {
		return filter;
	}

	/**
	 * @param filter
	 *            the filter to set
	 */
	public void setFilter(Map<String, Object> filter) {
		this.filter = filter;
	}

	public void addFilter(@Nullable String key, @Nullable Object value) {
		if (value == null || key == null) {
			return;
		}
		if (filter == null) {
			filter = new LinkedHashMap<String, Object>();
		}
		filter.put(key, value);
	}

	public Object fetchFilter(@Nullable String key) {
		if (key == null || filter == null) {
			return null;
		}
		return filter.get(key);
	}

	/**
	 * Gets a string describing the filter
	 * 
	 * @param key
	 *            filter key
	 * @return string encoded filter
	 */
	public @Nullable String encodeFilter(@Nullable String key) {
		Object filterObj = fetchFilter(key);
		return (filterObj == null) ? null : filterObj.toString();
	}

}
