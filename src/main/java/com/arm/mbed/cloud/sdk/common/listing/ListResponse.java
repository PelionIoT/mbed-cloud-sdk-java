package com.arm.mbed.cloud.sdk.common.listing;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "List response. Most listing operations are paginated and respond with truncated results. This object comprises the information related to a page.")
public class ListResponse<T extends SdkModel> implements Cloneable, Serializable {

    /**
     * Serialisation ID.
     */
    private static final long serialVersionUID = 2279331989506613851L;
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
        this(hasMore, totalCount, after, limit, order, null);
        initialiseData();
    }

    private ListResponse(boolean hasMore, int totalCount, String after, int limit, Order order, List<T> data) {
        super();
        setHasMore(hasMore);
        setTotalCount(totalCount);
        setAfter(after);
        setLimit(limit);
        setOrder(order);
        this.data = data;
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

    /**
     * Returns the first data element of this page.
     * 
     * @return first element of this page.
     */
    public @Nullable T first() {
        initialiseData();
        if (data.isEmpty()) {
            return null;
        }
        return data.get(0);
    }

    /**
     * Returns the last data element of this page.
     * 
     * @return last element of this page.
     */
    public @Nullable T last() {
        initialiseData();
        if (data.isEmpty()) {
            return null;
        }
        return data.get(data.size() - 1);
    }

    /**
     * Gets the number of elements on this page.
     * 
     * @return the number of elements on this page.
     */
    public int getNumberOfElements() {
        return data == null || data.isEmpty() ? 0 : data.size();
    }

    /**
     * Clones this paginated list.
     * 
     * @return a clone.
     */
    @Override
    public ListResponse<T> clone() {
        return new ListResponse<>(hasMore, totalCount, after, limit, order, new LinkedList<>(data));
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ListResponse [hasMore=" + hasMore + ", totalCount=" + totalCount + ", after=" + after + ", limit="
                + limit + ", order=" + order + ", data=" + data + "]";
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
        result = prime * result + ((after == null) ? 0 : after.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + (hasMore ? 1231 : 1237);
        result = prime * result + limit;
        result = prime * result + ((order == null) ? 0 : order.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @SuppressWarnings("rawtypes")
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
        final ListResponse other = (ListResponse) obj;
        if (after == null) {
            if (other.after != null) {
                return false;
            }
        } else if (!after.equals(other.after)) {
            return false;
        }
        if (data == null) {
            if (other.data != null) {
                return false;
            }
        } else if (!data.equals(other.data)) {
            return false;
        }
        if (hasMore != other.hasMore) {
            return false;
        }
        if (limit != other.limit) {
            return false;
        }
        if (order != other.order) {
            return false;
        }
        return true;
    }

}
