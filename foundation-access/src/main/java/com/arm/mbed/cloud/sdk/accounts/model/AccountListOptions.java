// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.IncludeField;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;
import java.util.List;

/**
 * Options to use when listing accounts.
 * <p>
 * Note:
 * <p>
 * <ul>
 * <li>Filters:
 * <p>
 * The list can be filtered server-side on some of the fields of an account.
 * <p>
 * The following filters are currently supported:
 * <p>
 * <table style="border: 2px solid navy; width:100%; border-collapse:collapse;border-spacing:0" summary="Available
 * filters">
 * <caption>Server-side filters</caption>
 * <tr>
 * <th style="background-color:#cbcefb;border-color:inherit;text-align:center" rowspan="2">Field</th>
 * <th style="background-color:#cbcefb;border-color:inherit;text-align:center" rowspan="2">Tag</th>
 * <th style="background-color:#cbcefb;border-color:inherit;text-align:center" colspan="7">Filters</th>
 * </tr>
 * <tr>
 * <td style="background-color:#dae8fc;text-align:center;" width="10%">not equal to</td>
 * <td style="background-color:#dae8fc;text-align:center;" width="10%">equal to</td>
 * <td style="background-color:#dae8fc;text-align:center;" width="10%">greater than</td>
 * <td style="background-color:#dae8fc;text-align:center;" width="10%">less than</td>
 * <td style="background-color:#dae8fc;text-align:center;" width="10%">like</td>
 * <td style="background-color:#dae8fc;text-align:center;" width="10%">in</td>
 * <td style="background-color:#dae8fc;text-align:center;" width="10%">not in</td>
 * </tr>
 * <tr>
 * <td style="border-color:inherit;text-align:left;padding-left:15px;padding-right:15px">status</td>
 * <td style=
 * "border-color:inherit;text-align:left;padding-left:15px;padding-right:15px;font-weight:bold">TAG_FILTER_BY_STATUS</td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold">&bull;</td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold">&bull;</td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold">&bull;</td>
 * </tr>
 * <tr>
 * <td style="border-color:inherit;text-align:left;padding-left:15px;padding-right:15px">tier</td>
 * <td style=
 * "border-color:inherit;text-align:left;padding-left:15px;padding-right:15px;font-weight:bold">TAG_FILTER_BY_TIER</td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold">&bull;</td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * </tr>
 * <tr>
 * <td style="border-color:inherit;text-align:left;padding-left:15px;padding-right:15px">endMarket</td>
 * <td style=
 * "border-color:inherit;text-align:left;padding-left:15px;padding-right:15px;font-weight:bold">TAG_FILTER_BY_END_MARKET</td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold">&bull;</td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * </tr>
 * <tr>
 * <td style="border-color:inherit;text-align:left;padding-left:15px;padding-right:15px">country</td>
 * <td style=
 * "border-color:inherit;text-align:left;padding-left:15px;padding-right:15px;font-weight:bold">TAG_FILTER_BY_COUNTRY</td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold">&bull;</td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * </tr>
 * </table>
 * </li>
 * </ul>
 */
@Preamble(description = "Options to use when listing accounts.")
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class AccountListOptions extends ListOptions {
    /**
     * Tag for filter by tier.
     */
    public static final String TAG_FILTER_BY_TIER = "tier";

    /**
     * Tag for filter by status.
     */
    public static final String TAG_FILTER_BY_STATUS = "status";

    /**
     * Tag for filter by endMarket.
     */
    public static final String TAG_FILTER_BY_END_MARKET = "endMarket";

    /**
     * Tag for filter by country.
     */
    public static final String TAG_FILTER_BY_COUNTRY = "country";

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #AccountListOptions()} instead.
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
    public AccountListOptions(Integer pageSize, Long maxResults, Order order, String after, List<IncludeField> include,
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
     * Note: Should not be used. Use {@link #AccountListOptions()} instead.
     * 
     * @param accountListOptions
     *            an account list options.
     */
    @Internal
    public AccountListOptions(AccountListOptions accountListOptions) {
        this();
        setOptions(accountListOptions);
    }

    /**
     * Constructor.
     */
    public AccountListOptions() {
        super();
        setDefault();
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #AccountListOptions()} instead.
     * 
     * @param after
     *            value.
     * @param include
     *            value.
     * @param filter
     *            value.
     */
    @Internal
    public AccountListOptions(String after, List<IncludeField> include, Filters filter) {
        this((Integer) null, (Long) null, Order.getDefault(), after, include, filter);
    }

    /**
     * Gets all the filters defined on field {@code tier}.
     * 
     * @return All the filters by {@code tier}
     */
    public List<Filter> getTierFilters() {
        return fetchFilters(TAG_FILTER_BY_TIER);
    }

    /**
     * Sets "an equal to" filter by {@code tier}.
     * 
     * @param filterByTier
     *            filter value.
     */
    public void addEqualToTierFilter(String filterByTier) {
        addEqualFilter(TAG_FILTER_BY_TIER, filterByTier);
    }

    /**
     * Sets "an equal to" filter by {@code tier}.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.AccountListOptions#addEqualToTierFilter(String)}
     * 
     * @param filterByTier
     *            filter value.
     * @return These list options
     */
    @SuppressWarnings("unchecked")
    public <T extends AccountListOptions> T equalToTier(String filterByTier) {
        addEqualToTierFilter(filterByTier);
        return (T) this;
    }

    /**
     * Gets all the filters defined on field {@code status}.
     * 
     * @return All the filters by {@code status}
     */
    public List<Filter> getStatusFilters() {
        return fetchFilters(TAG_FILTER_BY_STATUS);
    }

    /**
     * Sets "an equal to" filter by {@code status}.
     * 
     * @param filterByStatus
     *            filter value.
     */
    public void addEqualToStatusFilter(AccountStatus filterByStatus) {
        addEqualFilter(TAG_FILTER_BY_STATUS, filterByStatus);
    }

    /**
     * Sets "an equal to" filter by {@code status}.
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.AccountListOptions#addEqualToStatusFilter(com.arm.mbed.cloud.sdk.accounts.model.AccountStatus)}
     * 
     * @param filterByStatus
     *            filter value.
     * @return These list options
     */
    @SuppressWarnings("unchecked")
    public <T extends AccountListOptions> T equalToStatus(AccountStatus filterByStatus) {
        addEqualToStatusFilter(filterByStatus);
        return (T) this;
    }

    /**
     * Sets "an in" filter by {@code status}.
     * <p>
     * Note: In this case, the filter is a string corresponding to a list of values separated by a comma
     * 
     * @param filterByStatus
     *            filter value.
     */
    public void addInStatusesFilter(String filterByStatus) {
        addInFilter(TAG_FILTER_BY_STATUS, filterByStatus);
    }

    /**
     * Sets "an in" filter by {@code status}.
     * 
     * @param filterByStatus
     *            filter value.
     */
    public void addInStatusesFilter(List<AccountStatus> filterByStatus) {
        addInFilter(TAG_FILTER_BY_STATUS, filterByStatus);
    }

    /**
     * Sets "an in" filter by {@code status}.
     * 
     * @param filterByStatus
     *            filter value.
     */
    public void addInStatusesFilter(AccountStatus[] filterByStatus) {
        addInFilter(TAG_FILTER_BY_STATUS, filterByStatus);
    }

    /**
     * Sets "an in" filter by {@code status}.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.AccountListOptions#addInStatusesFilter(String)}
     * 
     * @param filterByStatus
     *            filter value.
     * @return These list options
     */
    @SuppressWarnings("unchecked")
    public <T extends AccountListOptions> T inStatuses(String filterByStatus) {
        addInStatusesFilter(filterByStatus);
        return (T) this;
    }

    /**
     * Sets "an in" filter by {@code status}.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.AccountListOptions#addInStatusesFilter(java.util.List)}
     * 
     * @param filterByStatus
     *            filter value.
     * @return These list options
     */
    @SuppressWarnings("unchecked")
    public <T extends AccountListOptions> T inStatuses(List<AccountStatus> filterByStatus) {
        addInStatusesFilter(filterByStatus);
        return (T) this;
    }

    /**
     * Sets "an in" filter by {@code status}.
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.AccountListOptions#addInStatusesFilter(com.arm.mbed.cloud.sdk.accounts.model.AccountStatus[])}
     * 
     * @param filterByStatus
     *            filter value.
     * @return These list options
     */
    @SuppressWarnings("unchecked")
    public <T extends AccountListOptions> T inStatuses(AccountStatus[] filterByStatus) {
        addInStatusesFilter(filterByStatus);
        return (T) this;
    }

    /**
     * Sets "a not in" filter by {@code status}.
     * <p>
     * Note: In this case, the filter is a string corresponding to a list of values separated by a comma
     * 
     * @param filterByStatus
     *            filter value.
     */
    public void addNotInStatusesFilter(String filterByStatus) {
        addNotInFilter(TAG_FILTER_BY_STATUS, filterByStatus);
    }

    /**
     * Sets "a not in" filter by {@code status}.
     * 
     * @param filterByStatus
     *            filter value.
     */
    public void addNotInStatusesFilter(List<AccountStatus> filterByStatus) {
        addNotInFilter(TAG_FILTER_BY_STATUS, filterByStatus);
    }

    /**
     * Sets "a not in" filter by {@code status}.
     * 
     * @param filterByStatus
     *            filter value.
     */
    public void addNotInStatusesFilter(AccountStatus[] filterByStatus) {
        addNotInFilter(TAG_FILTER_BY_STATUS, filterByStatus);
    }

    /**
     * Sets "a not in" filter by {@code status}.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.AccountListOptions#addNotInStatusesFilter(String)}
     * 
     * @param filterByStatus
     *            filter value.
     * @return These list options
     */
    @SuppressWarnings("unchecked")
    public <T extends AccountListOptions> T notInStatuses(String filterByStatus) {
        addNotInStatusesFilter(filterByStatus);
        return (T) this;
    }

    /**
     * Sets "a not in" filter by {@code status}.
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.AccountListOptions#addNotInStatusesFilter(java.util.List)}
     * 
     * @param filterByStatus
     *            filter value.
     * @return These list options
     */
    @SuppressWarnings("unchecked")
    public <T extends AccountListOptions> T notInStatuses(List<AccountStatus> filterByStatus) {
        addNotInStatusesFilter(filterByStatus);
        return (T) this;
    }

    /**
     * Sets "a not in" filter by {@code status}.
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.AccountListOptions#addNotInStatusesFilter(com.arm.mbed.cloud.sdk.accounts.model.AccountStatus[])}
     * 
     * @param filterByStatus
     *            filter value.
     * @return These list options
     */
    @SuppressWarnings("unchecked")
    public <T extends AccountListOptions> T notInStatuses(AccountStatus[] filterByStatus) {
        addNotInStatusesFilter(filterByStatus);
        return (T) this;
    }

    /**
     * Gets all the filters defined on field {@code endMarket}.
     * 
     * @return All the filters by {@code endMarket}
     */
    public List<Filter> getEndMarketFilters() {
        return fetchFilters(TAG_FILTER_BY_END_MARKET);
    }

    /**
     * Sets "an equal to" filter by {@code endMarket}.
     * 
     * @param filterByEndMarket
     *            filter value.
     */
    public void addEqualToEndMarketFilter(String filterByEndMarket) {
        addEqualFilter(TAG_FILTER_BY_END_MARKET, filterByEndMarket);
    }

    /**
     * Sets "an equal to" filter by {@code endMarket}.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.AccountListOptions#addEqualToEndMarketFilter(String)}
     * 
     * @param filterByEndMarket
     *            filter value.
     * @return These list options
     */
    @SuppressWarnings("unchecked")
    public <T extends AccountListOptions> T equalToEndMarket(String filterByEndMarket) {
        addEqualToEndMarketFilter(filterByEndMarket);
        return (T) this;
    }

    /**
     * Gets all the filters defined on field {@code country}.
     * 
     * @return All the filters by {@code country}
     */
    public List<Filter> getCountryFilters() {
        return fetchFilters(TAG_FILTER_BY_COUNTRY);
    }

    /**
     * Sets "a like" filter by {@code country}.
     * 
     * @param filterByCountry
     *            filter value.
     */
    public void addLikeCountryFilter(String filterByCountry) {
        addLikeFilter(TAG_FILTER_BY_COUNTRY, filterByCountry);
    }

    /**
     * Sets "a like" filter by {@code country}.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.AccountListOptions#addLikeCountryFilter(String)}
     * 
     * @param filterByCountry
     *            filter value.
     * @return These list options
     */
    @SuppressWarnings("unchecked")
    public <T extends AccountListOptions> T likeCountry(String filterByCountry) {
        addLikeCountryFilter(filterByCountry);
        return (T) this;
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
        return other instanceof AccountListOptions;
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
        return "AccountListOptions [pageSize=" + pageSize + ", maxResults=" + maxResults + ", order=" + order
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
    public AccountListOptions clone() {
        final AccountListOptions opt = new AccountListOptions();
        opt.setOptions(this);
        return opt;
    }
}
