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
    /**
     * Tag of filter by creation date.
     */
    public static final String CREATED_AT_FILTER = "createdAt";
    /**
     * Tag of filter by name.
     */
    public static final String NAME_FILTER = "name";
    /**
     * Tag of filter by state.
     */
    public static final String STATE_FILTER = "state";
    /**
     * Tag of filter by manifest id.
     */
    public static final String MANIFEST_ID_FILTER = "manifestId";
    /**
     * Tag of filter by manifest URL.
     */
    public static final String MANIFEST_URL_FILTER = "manifestUrl";
    /**
     * Tag of filter by start date.
     */
    public static final String START_AT_FILTER = "startedAt";
    /**
     * Tag of filter by schedule date.
     */
    public static final String SCHEDULED_AT_FILTER = "scheduledAt";
    /**
     * Tag of filter by finish date.
     */
    public static final String FINISHED_AT_FILTER = "finishedAt";
    /**
     * Tag of filter by update date.
     */
    public static final String UPDATED_AT_FILTER = "updatedAt";

    /**
     * Constructor.
     */
    public CampaignListOptions() {
        super();
    }

    /**
     * Gets device filter based on name field.
     * 
     * @return the name filter
     */
    public @Nullable List<Filter> getNameFilters() {
        return fetchFilters(NAME_FILTER);
    }

    /**
     * Adds a device filter based on name field.
     * 
     * @param nameFilter
     *            the name filter to add
     * @param operator
     *            filter operator
     */
    public void addNameFilter(@Nullable String nameFilter, FilterOperator operator) {
        addFilter(NAME_FILTER, operator, nameFilter);
    }

    /**
     * Gets device filter based on createdAt field.
     * 
     * @return the createdAt filter
     */
    public @Nullable List<Filter> getCreatedAtFilter() {
        return fetchFilters(CREATED_AT_FILTER);
    }

    /**
     * Adds a device filter based on createdAt field.
     * 
     * @param createdAtFilter
     *            the createdAt filter to add
     * @param operator
     *            filter operator
     */
    public void addCreatedAtFilter(@Nullable Date createdAtFilter, FilterOperator operator) {
        addFilter(CREATED_AT_FILTER, operator, createdAtFilter);
    }

    /**
     * Gets device filter based on state field.
     * 
     * @return the state filter
     */
    public @Nullable List<Filter> getStateFilters() {
        return fetchFilters(STATE_FILTER);
    }

    /**
     * Adds a device filter based on state field.
     * 
     * @param state
     *            the state filter to add
     * @param operator
     *            filter operator
     */
    public void addUpdatedFilter(@Nullable String state, FilterOperator operator) {
        addFilter(STATE_FILTER, operator, state);
    }

    /**
     * Gets device filter based on manifest id field.
     * 
     * @return the manifest id filter
     */
    public @Nullable List<Filter> getManifestIdFilters() {
        return fetchFilters(MANIFEST_ID_FILTER);
    }

    /**
     * Adds a device filter based on manifest id field.
     * 
     * @param manifestId
     *            the manifest id filter to add
     * @param operator
     *            filter operator
     */
    public void addTimestampFilter(@Nullable String manifestId, FilterOperator operator) {
        addFilter(MANIFEST_ID_FILTER, operator, manifestId);
    }

    /**
     * Gets device filter based on manifest URL field.
     * 
     * @return the manifest url filters
     */
    public @Nullable List<Filter> getManifestUrlFilters() {
        return fetchFilters(MANIFEST_URL_FILTER);
    }

    /**
     * Adds a device filter based on manifest URL field.
     * 
     * @param manifestUrlFilter
     *            the manifest URL filter to add
     * @param operator
     *            filter operator
     */
    public void addManifestUrlFilter(@Nullable URL manifestUrlFilter, FilterOperator operator) {
        addFilter(MANIFEST_URL_FILTER, operator, manifestUrlFilter);
    }

    /**
     * Gets device filter based on startedAt field.
     * 
     * @return the started at filters
     */
    public @Nullable List<Filter> getStartedAtFilters() {
        return fetchFilters(START_AT_FILTER);
    }

    /**
     * Adds a device filter based on startedAt field.
     * 
     * @param startedAtFilter
     *            the "started at" filter to add
     * @param operator
     *            filter operator
     */
    public void addStartedAtFilter(@Nullable Date startedAtFilter, FilterOperator operator) {
        addFilter(START_AT_FILTER, operator, startedAtFilter);
    }

    /**
     * Gets a device filter based on scheduledAt field.
     * 
     * @return the scheduled at filters
     */
    public @Nullable List<Filter> getScheduledAtFilters() {
        return fetchFilters(SCHEDULED_AT_FILTER);
    }

    /**
     * Adds a device filter based on scheduledAt field.
     * 
     * @param scheduledAtFilter
     *            the "scheduled at" filter to add
     * @param operator
     *            filter operator
     */
    public void addScheduledAtFilter(@Nullable Date scheduledAtFilter, FilterOperator operator) {
        addFilter(SCHEDULED_AT_FILTER, operator, scheduledAtFilter);
    }

    /**
     * Gets device filter based on finishedAt field.
     * 
     * @return the finished at filters
     */
    public @Nullable List<Filter> getFinishedAtFilters() {
        return fetchFilters(FINISHED_AT_FILTER);
    }

    /**
     * Adds a device filter based on finishedAt field.
     * 
     * @param finishedAtFilter
     *            the "finished at" filter to add
     * @param operator
     *            filter operator
     */
    public void addFinishedAtFilter(@Nullable Date finishedAtFilter, FilterOperator operator) {
        addFilter(FINISHED_AT_FILTER, operator, finishedAtFilter);
    }

    /**
     * Adds a device filter based on updatedAt field.
     * 
     * @param updatedAtFilter
     *            the "updated at" filter to add
     * @param operator
     *            filter operator
     */
    public void addUpdatedAtFilter(@Nullable Date updatedAtFilter, FilterOperator operator) {
        addFilter(UPDATED_AT_FILTER, operator, updatedAtFilter);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#clone()
     */
    @Override
    public CampaignListOptions clone() {
        final CampaignListOptions opt = new CampaignListOptions();
        opt.setOptions(this);
        return opt;
    }
}
