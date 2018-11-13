package com.arm.mbed.cloud.sdk.subscribe.model;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FiltersEvaluator;

@Preamble(description = "Options to filter asynchronous responses")
public class AsynchronousResponseFilterOptions extends FilterOptions {

    /**
     * Tag of filter by asynchronous response id.
     */
    public static final String ASYNC_RESPONSE_ID_FILTER = "asyncId";

    /**
     * Creates a new filter.
     *
     * @return a newly created filter.
     */
    public static AsynchronousResponseFilterOptions newFilter() {
        return new AsynchronousResponseFilterOptions();
    }

    /**
     * Constructor.
     */
    public AsynchronousResponseFilterOptions() {
        this(null);
    }

    /**
     * Constructor.
     *
     * @param filter
     *            the filter to set
     */
    public AsynchronousResponseFilterOptions(Filters filter) {
        super(filter);
    }

    /**
     * Adds an "Equal" filter related to an asynchronous response id.
     *
     * @param asyncId
     *            asynchronous response id to consider.
     */
    public void addEqualAsynchronousResponseIdFilter(@Nullable String asyncId) {
        addEqualFilter(ASYNC_RESPONSE_ID_FILTER, asyncId == null ? null : asyncId);
    }

    /**
     * Creates an "Equal" filter related to an asynchronous response id.
     * <p>
     * Similar to {@link #addEqualAsynchronousResponseIdFilter(String)}
     *
     * @param asyncId
     *            asynchronous response id to consider.
     * @return this filter
     */
    public AsynchronousResponseFilterOptions equalAsynchronousResponseId(@Nullable String asyncId) {
        addEqualAsynchronousResponseIdFilter(asyncId);
        return this;
    }

    /**
     * States whether an asynchronous response verifies the filter created or not.
     *
     * @param asyncId
     *            asyncId to check
     * @return True if the async id verifies the filter. False otherwise.
     */
    public boolean isVerified(String asyncId) {
        if (asyncId == null) {
            return false;
        }

        return FiltersEvaluator.isVerified(filter, ASYNC_RESPONSE_ID_FILTER, asyncId);

    }

    /**
     * States whether an asynchronous response verifies the filter created or not.
     *
     * @param notification
     *            notification
     * @return True if the async id verifies the filter. False otherwise.
     */
    public boolean isVerified(AsynchronousResponseNotification notification) {
        return notification == null ? false : isVerified(notification.getId());
    }

}
