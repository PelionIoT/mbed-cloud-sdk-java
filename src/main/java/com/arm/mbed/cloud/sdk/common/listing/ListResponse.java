package com.arm.mbed.cloud.sdk.common.listing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.Order;

@Preamble(description = "List response")
public class ListResponse<T> {

    /**
     * Whether there are more results to display.
     */
    @DefaultValue(value = "false")
    private boolean hasMore;
    /**
     * Total number of records.
     */
    private int totalCount;
    /**
     * Entity id for fetch after it.
     */
    private String after;
    /**
     * The number of results to return.
     */
    private int limit;
    /**
     * Order of returned records.
     */
    @DefaultValue(value = "ASC")
    private Order order;
    /**
     * data list.
     */
    private List<T> data;

    /**
     * Constructor.
     * 
     * @param hasMore
     *            Whether there are more results to display.
     * @param totalCount
     *            Total number of records.
     * @param after
     *            Entity id for fetch after it.
     * @param limit
     *            The number of results to return.
     * @param order
     *            Order of returned records.
     */
    public ListResponse(boolean hasMore, int totalCount, String after, int limit, Order order) {
        super();
        setHasMore(hasMore);
        setTotalCount(totalCount);
        setAfter(after);
        setLimit(limit);
        setOrder(order);
        initialiseData();
    }

    private void initialiseData() {
        if (data == null) {
            setData(new LinkedList<T>());
        }
    }

    /**
     * Constructor with default settings.
     */
    public ListResponse() {
        this(false, 0, null, 0, Order.ASC);
    }

    /**
     * States whether there are more results.
     * 
     * @return the hasMore
     */
    public boolean hasMore() {
        return hasMore;
    }

    /**
     * States whether there are more results.
     * <p>
     * Similar to {@link #hasMore()}
     * 
     * @return the hasMore
     */
    @Internal
    public boolean isHasMore() {
        return hasMore();
    }

    /**
     * Sets whether there are more results.
     * 
     * @param hasMore
     *            the hasMore to set
     */
    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    /**
     * Gets total number of results.
     * 
     * @return the totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * Sets total number of records.
     * 
     * @param totalCount
     *            the totalCount to set
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * Gets the entity id of the next record.
     * 
     * @return the after
     */
    public String getAfter() {
        return after;
    }

    /**
     * Sets the entity id of the next record.
     * 
     * @param after
     *            the after to set
     */
    public void setAfter(String after) {
        this.after = after;
    }

    /**
     * Gets the record limit.
     * 
     * @return the limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Sets the record limit.
     * 
     * @param limit
     *            the limit to set
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * Gets record order.
     * 
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets list sorting order.
     * 
     * @param order
     *            the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Gets records.
     * 
     * @return the data
     */
    public List<T> getData() {
        return data;
    }

    /**
     * Sets records.
     * 
     * @param data
     *            the data to set
     */
    public void setData(List<T> data) {
        this.data = data;
    }

    /**
     * Adds an element to the data list.
     * 
     * @param dataToAdd
     *            the data to add
     */
    public void addData(T dataToAdd) {
        if (dataToAdd == null) {
            return;
        }
        initialiseData();
        this.data.add(dataToAdd);
    }

    /**
     * Iterates over all the objects of the page.
     * 
     * @return the page iterator
     */
    public Iterator<T> iterator() {
        initialiseData();
        return data.iterator();
    }

}
