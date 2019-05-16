package com.arm.mbed.cloud.sdk.common.listing;

import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.SdkModel;

/**
 * Most listing operations are <a href="https://en.wikipedia.org/wiki/Pagination">paginated</a> and respond with
 * truncated results. This object comprises the information related to one page of models.
 *
 * @param <T>
 *            model type.
 */
@Preamble(description = "Paginated response corresponding to one page of models.")
public class ListResponse<T extends SdkModel> extends AbstractListResponse<T> {

    /**
     * Serialisation ID.
     */
    private static final long serialVersionUID = 2279331989506613851L;

    /**
     * Constructor with default settings.
     */
    public ListResponse() {
        super();
    }

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
    public ListResponse(boolean hasMore, long totalCount, String after, String continuationMarker, int pageSize,
                        Order order) {
        super(hasMore, totalCount, after, continuationMarker, pageSize, order);
    }

    /**
     * Constructor.
     * <p>
     * Note: use {@link #ListResponse(boolean, long, String, String, int, Order)} instead
     *
     * @param hasMore
     *            Whether there are more results to display.
     * @param totalCount
     *            Total number of records.
     *
     * @param after
     *            Entity id for fetch after it.
     * @param pageSize
     *            The number of results to return.
     * @param order
     *            Order of returned records.
     */
    @Deprecated
    public ListResponse(boolean hasMore, long totalCount, String after, int pageSize, Order order) {
        super(hasMore, totalCount, after, null, pageSize, order);
    }

    protected ListResponse(boolean hasMore, long totalCount, String after, String continuationMarker, int pageSize,
                           Order order, List<T> data) {
        super(hasMore, totalCount, after, continuationMarker, pageSize, order, data);
    }

    /**
     * Clones this paginated list.
     *
     * @return a clone.
     */
    @Override
    public ListResponse<T> clone() {
        return new ListResponse<>(hasMore, totalCount, after, continuationMarker, pageSize, order,
                                  new LinkedList<>(data));
    }

}
