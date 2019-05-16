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

/**
 * Most listing operations are <a href="https://en.wikipedia.org/wiki/Pagination">paginated</a> and respond with
 * truncated results. This object comprises the information related to one page.
 *
 * @param <T>
 *            element type.
 */
@Preamble(description = "Generic paginated response corresponding to one page.")
public abstract class AbstractListResponse<T> implements Cloneable, Serializable {

    /**
     * Serialisation ID.
     */
    private static final long serialVersionUID = -4003690226011970828L;
    /**
     * Whether there are more results to display.
     */
    @DefaultValue(value = "false")
    protected boolean hasMore;
    /**
     * Total number of records.
     */
    protected long totalCount;
    /**
     * Entity id for fetch after it.
     */
    protected String after;
    /**
     * An offset token for fetching the next page.
     */
    protected String continuationMarker;
    /**
     * The page size.
     */
    protected int pageSize;
    /**
     * Order of returned records.
     */
    @DefaultValue(value = "ASC")
    protected Order order;
    /**
     * data list.
     */
    protected List<T> data;

    /**
     * Constructor.
     *
     * @param hasMore
     *            Whether there are more results to display.
     * @param totalCount
     *            Total number of records.
     * @param continuationMarker
     *            An offset token for fetching the next page.
     * @param after
     *            Entity id for fetch after it.
     * @param pageSize
     *            The number of results to return.
     * @param order
     *            Order of returned records.
     */
    public AbstractListResponse(boolean hasMore, long totalCount, String after, String continuationMarker, int pageSize,
                                Order order) {
        this(hasMore, totalCount, after, continuationMarker, pageSize, order, null);
        initialiseData();
    }

    protected AbstractListResponse(boolean hasMore, long totalCount, String after, String continuationMarker,
                                   int pageSize, Order order, List<T> data) {
        super();
        setHasMore(hasMore);
        setTotalCount(totalCount);
        setAfter(after);
        setContinuationMarker(continuationMarker);
        setPageSize(pageSize);
        setOrder(order);
        this.data = data;
    }

    /**
     * Constructor with default settings.
     */
    public AbstractListResponse() {
        this(false, 0, null, null, 0, Order.ASC);
    }

    private void initialiseData() {
        if (data == null) {
            setData(new LinkedList<T>());
        }
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
    public long getTotalCount() {
        return totalCount;
    }

    /**
     * Sets total number of records.
     *
     * @param totalCount
     *            the totalCount to set
     */
    public void setTotalCount(long totalCount) {
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
     * Gets the offset token for fetching the next page.
     *
     * @return the continuation marker
     */
    public String getContinuationMarker() {
        return continuationMarker;
    }

    /**
     * States whether a continuation marker is specified or not.
     *
     * @return True if the marker is present. False otherwise.
     */
    public boolean hasContinuationMarker() {
        return continuationMarker != null;
    }

    /**
     * Sets the offset token for fetching the next page.
     *
     * @param continuationMarker
     *            the continuation marker to set
     */
    public void setContinuationMarker(String continuationMarker) {
        this.continuationMarker = continuationMarker;
    }

    /**
     * Gets the record limit.
     * <p>
     * Note: Use {@link #getPageSize()}
     *
     * @return the limit
     */
    @Deprecated
    public int getLimit() {
        return getPageSize();
    }

    /**
     * Sets the page size.
     *
     * @param pageSize
     *            the page size to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Gets the page size.
     *
     * @return the page size
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Sets the record limit.
     * <p>
     * Note: Use {@link #setPageSize(int)}
     *
     * @param limit
     *            the limit to set
     */
    @Deprecated
    public void setLimit(int limit) {
        setPageSize(limit);
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
     * Returns the data element at the specified position in this page.
     *
     * @param index
     *            index of the element to retrieve
     * @return data element at the specified position in this page.
     */
    public @Nullable T get(int index) {
        initialiseData();
        if (data.isEmpty()) {
            return null;
        }
        return data.get(index);
    }

    /**
     * Gets the number of elements on this page.
     *
     * @return the number of elements on this page.
     */
    public int getNumberOfElements() {
        return data == null || data.isEmpty() ? 0 : data.size();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ListResponse [hasMore=" + hasMore + ", totalCount=" + totalCount + ", after=" + after
               + ", continuationMarker=" + continuationMarker + ", pageSize=" + pageSize + ", order=" + order
               + ", data=" + data + "]";
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((after == null) ? 0 : after.hashCode());
        result = prime * result + ((continuationMarker == null) ? 0 : continuationMarker.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + (hasMore ? 1231 : 1237);
        result = prime * result + ((order == null) ? 0 : order.hashCode());
        result = prime * result + pageSize;
        result = prime * result + (int) (totalCount ^ (totalCount >>> 32));
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AbstractListResponse)) {
            return false;
        }
        @SuppressWarnings("rawtypes")
        final AbstractListResponse other = (AbstractListResponse) obj;
        if (after == null) {
            if (other.after != null) {
                return false;
            }
        } else if (!after.equals(other.after)) {
            return false;
        }
        if (continuationMarker == null) {
            if (other.continuationMarker != null) {
                return false;
            }
        } else if (!continuationMarker.equals(other.continuationMarker)) {
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
        if (order != other.order) {
            return false;
        }
        if (pageSize != other.pageSize) {
            return false;
        }
        if (totalCount != other.totalCount) {
            return false;
        }
        return true;
    }

    @Override
    public abstract AbstractListResponse<T> clone();
}
