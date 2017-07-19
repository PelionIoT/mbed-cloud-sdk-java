package com.arm.mbed.cloud.sdk.common;

import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "List response")
public class ListResponse<T> {

	/**
	 * Whether there are more results to display
	 */
	@DefaultValue(value = "false")
	private boolean hasMore;
	/**
	 * Total number of records
	 */
	private int totalCount;
	/**
	 * Entity id for fetch after it
	 */
	private String after;
	/**
	 * The number of results to return
	 */
	private int limit;
	/**
	 * Order of returned records
	 */
	@DefaultValue(value = "ASC")
	private Order order;
	/**
	 * data list
	 */
	private List<T> data;

	public ListResponse(boolean hasMore, int totalCount, String after, int limit, Order order) {
		super();
		setHasMore(hasMore);
		setTotalCount(totalCount);
		setAfter(after);
		setLimit(limit);
		setOrder(order);
		setData(null);
	}

	public ListResponse() {
		this(false, 0, null, 0, Order.ASC);
	}

	/**
	 * @return the hasMore
	 */
	public boolean isHasMore() {
		return hasMore;
	}

	/**
	 * @param hasMore
	 *            the hasMore to set
	 */
	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount
	 *            the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
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
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 *            the limit to set
	 */
	public void setLimit(int limit) {
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
	 * @return the data
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(List<T> data) {
		this.data = data;
	}

	/**
	 * Adds an element to the data list
	 * 
	 * @param data
	 *            the data to add
	 */
	public void addData(T data) {
		if (data == null) {
			return;
		}
		if (this.data == null) {
			this.data = new LinkedList<T>();
		}
		this.data.add(data);
	}

}
