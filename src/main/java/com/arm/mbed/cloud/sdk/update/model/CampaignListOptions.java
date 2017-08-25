package com.arm.mbed.cloud.sdk.update.model;

import java.net.URL;
import java.util.Date;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;

@Preamble(description = "Options to use when listing campaigns")
public class CampaignListOptions extends ListOptions {
    public static final String CREATED_AT_FILTER = "createdAt";
    public static final String NAME_FILTER = "name";
    public static final String STATE_FILTER = "state";
    public static final String MANIFEST_ID_FILTER = "manifestId";
    public static final String MANIFEST_URL_FILTER = "manifestUrl";
    public static final String START_AT_FILTER = "startedAt";
    public static final String SCHEDULED_AT_FILTER = "scheduledAt";
    public static final String FINISHED_AT_FILTER = "finishedAt";

    public CampaignListOptions() {
        super();
    }

    /**
     * @return the name filter
     */
    public @Nullable List<Filter> getNameFilters() {
        return fetchFilters(NAME_FILTER);
    }

    /**
     * @param nameFilter
     *            the name filter to add
     * @param operator
     *            filter operator
     */
    public void addNameFilter(@Nullable String nameFilter, FilterOperator operator) {
        addFilter(NAME_FILTER, operator, nameFilter);
    }

    /**
     * @return the createdAt filter
     */
    public @Nullable List<Filter> getCreatedAtFilter() {
        return fetchFilters(CREATED_AT_FILTER);
    }

    /**
     * @param createdAtFilter
     *            the createdAt filter to add
     * @param operator
     *            filter operator
     */
    public void addCreatedAtFilter(@Nullable Date createdAtFilter, FilterOperator operator) {
        addFilter(CREATED_AT_FILTER, operator, createdAtFilter);
    }

    /**
     * @return the state filter
     */
    public @Nullable List<Filter> getStateFilters() {
        return fetchFilters(STATE_FILTER);
    }

    /**
     * @param state
     *            the state filter to add
     * @param operator
     *            filter operator
     */
    public void addUpdatedFilter(@Nullable String state, FilterOperator operator) {
        addFilter(STATE_FILTER, operator, state);
    }

    /**
     * @return the manifest id filter
     */
    public @Nullable List<Filter> getManifestIdFilters() {
        return fetchFilters(MANIFEST_ID_FILTER);
    }

    /**
     * @param manifestId
     *            the manifest id filter to add
     * @param operator
     *            filter operator
     */
    public void addTimestampFilter(@Nullable String manifestId, FilterOperator operator) {
        addFilter(MANIFEST_ID_FILTER, operator, manifestId);
    }

    /**
     * @return the manifest url filters
     */
    public @Nullable List<Filter> getManifestUrlFilters() {
        return fetchFilters(MANIFEST_URL_FILTER);
    }

    /**
     * @param manifestUrlFilter
     *            the manifest URL filter to add
     * @param operator
     *            filter operator
     */
    public void addManifestUrlFilter(@Nullable URL manifestUrlFilter, FilterOperator operator) {
        addFilter(MANIFEST_URL_FILTER, operator, manifestUrlFilter);
    }

    /**
     * @return the started at filters
     */
    public @Nullable List<Filter> getStartedAtFilters() {
        return fetchFilters(START_AT_FILTER);
    }

    /**
     * @param startedAtFilter
     *            the started at filter to add
     * @param operator
     *            filter operator
     */
    public void addStartedAtFilter(@Nullable Date startedAtFilter, FilterOperator operator) {
        addFilter(START_AT_FILTER, operator, startedAtFilter);
    }

    /**
     * @return the scheduled at filters
     */
    public @Nullable List<Filter> getScheduledAtFilters() {
        return fetchFilters(SCHEDULED_AT_FILTER);
    }

    /**
     * @param scheduledAtFilter
     *            the scheduled at filter to add
     * @param operator
     *            filter operator
     */
    public void addScheduledAtFilter(@Nullable Date scheduledAtFilter, FilterOperator operator) {
        addFilter(SCHEDULED_AT_FILTER, operator, scheduledAtFilter);
    }

    /**
     * @return the finished at filters
     */
    public @Nullable List<Filter> getFinishedAtFilters() {
        return fetchFilters(FINISHED_AT_FILTER);
    }

    /**
     * @param finishedAtFilter
     *            the finished at filter to add
     * @param operator
     *            filter operator
     */
    public void addFinishedAtFilter(@Nullable Date finishedAtFilter, FilterOperator operator) {
        addFilter(FINISHED_AT_FILTER, operator, finishedAtFilter);
    }

}
