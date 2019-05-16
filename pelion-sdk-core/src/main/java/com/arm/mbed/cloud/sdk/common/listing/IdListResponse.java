package com.arm.mbed.cloud.sdk.common.listing;

import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.Order;

/**
 * Most listing operations are <a href="https://en.wikipedia.org/wiki/Pagination">paginated</a> and respond with
 * truncated results. This object comprises the information related to one page of ids.
 */
@Preamble(description = "Paginated response corresponding to one page of ids.")
public class IdListResponse extends AbstractListResponse<String> {

    /**
     * Serialisation ID.
     */
    private static final long serialVersionUID = 2279331989506613851L;

    /**
     * Constructor with default settings.
     */
    public IdListResponse() {
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
    public IdListResponse(boolean hasMore, long totalCount, String after, String continuationMarker, int pageSize,
                          Order order) {
        super(hasMore, totalCount, after, continuationMarker, pageSize, order);
    }

    protected IdListResponse(boolean hasMore, long totalCount, String after, String continuationMarker, int pageSize,
                             Order order, List<String> data) {
        super(hasMore, totalCount, after, continuationMarker, pageSize, order, data);
    }

    /**
     * Clones this paginated list.
     *
     * @return a clone.
     */
    @Override
    public IdListResponse clone() {
        return new IdListResponse(hasMore, totalCount, after, continuationMarker, pageSize, order,
                                  new LinkedList<>(data));
    }

}
