// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.IncludeField;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;
import java.util.List;

/**
 * Options to use when listing api keys.
 */
@Preamble(description = "Options to use when listing api keys.")
public class ApiKeyListOptions extends ListOptions {
    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #ApiKeyListOptions()} instead.
     * 
     * @param pageSize
     *            value.
     * @param maxResults
     *            value.
     * @param order
     *            enumerator value.
     * @param after
     *            value.
     * @param include
     *            value.
     * @param filter
     *            value.
     */
    @Internal
    public ApiKeyListOptions(Integer pageSize, Long maxResults, Order order, String after, List<IncludeField> include,
                             Filters filter) {
        super();
        this.pageSize = pageSize;
        this.maxResults = maxResults;
        this.order = order;
        this.after = after;
        this.include = include;
        this.filter = filter;
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #ApiKeyListOptions()} instead.
     * 
     * @param apiKeyListOptions
     *            an api key list options.
     */
    @Internal
    public ApiKeyListOptions(ApiKeyListOptions apiKeyListOptions) {
        this();
        setOptions(apiKeyListOptions);
    }

    /**
     * Constructor.
     */
    public ApiKeyListOptions() {
        super();
        setDefault();
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #ApiKeyListOptions()} instead.
     * 
     * @param after
     *            value.
     * @param include
     *            value.
     * @param filter
     *            value.
     */
    @Internal
    public ApiKeyListOptions(String after, List<IncludeField> include, Filters filter) {
        this(0, 0L, Order.getDefault(), after, include, filter);
    }

    /**
     * Method to ensure {@link #equals(Object)} is correct.
     * <p>
     * Note: see this article: <a href="https://www.artima.com/lejava/articles/equality.html">canEqual()</a>
     * 
     * @param other
     *            another object.
     * @return true if the other object is an instance of the class in which canEqual is (re)defined, false otherwise.
     */
    protected boolean canEqual(Object other) {
        return other instanceof ApiKeyListOptions;
    }

    /**
     * Returns a string representation of the object.
     * <p>
     * 
     * @see java.lang.Object#toString()
     * @return the string representation
     */
    @Override
    public String toString() {
        return "ApiKeyListOptions [pageSize=" + pageSize + ", maxResults=" + maxResults + ", order=" + order
               + ", after=" + after + ", include=" + encodeInclude() + ", filter=" + retrieveFilterAsJson() + "]";
    }

    /**
     * Clones this instance.
     * <p>
     * 
     * @see java.lang.Object#clone()
     * @return a cloned instance
     */
    @Override
    public ApiKeyListOptions clone() {
        final ApiKeyListOptions opt = new ApiKeyListOptions();
        opt.setOptions(this);
        return opt;
    }
}