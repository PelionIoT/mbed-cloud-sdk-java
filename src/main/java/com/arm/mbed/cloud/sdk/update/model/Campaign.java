package com.arm.mbed.cloud.sdk.update.model;

import java.net.URL;
import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.Filters;

@Preamble(description = "Campaign")
public class Campaign {

    /**
     * The ID of the campaign
     */
    private String id;
    /**
     * The state of the campaign
     */
    private CampaignState state;
    /**
     * URl of the manifest used
     */
    private final URL manifestUrl;
    /**
     * The time the object was created
     */
    @DefaultValue(value = "now()")
    private final Date createdAt;
    /**
     * The timestamp at which update campaign scheduled to start
     */
    @DefaultValue(value = "now()")
    private final Date startedAt;
    /**
     * The timestamp when the update campaign finished
     */
    @DefaultValue(value = "now()")
    private final Date finishedAt;
    /**
     * A name for this campaign
     */
    private String name;
    /**
     * An optional description of the campaign
     */
    private String description;
    /**
     * ID of the manifest to use for update
     */
    private String manifestId;

    /**
     * The timestamp at which update campaign scheduled to start
     */
    @DefaultValue(value = "now()")
    private Date scheduledAt;
    private Filters filters;

    public Campaign(String id, URL manifestUrl, Date createdAt, Date startedAt, Date finishedAt) {
        super();
        setId(id);
        this.manifestUrl = manifestUrl;
        this.createdAt = createdAt;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        setDescription(null);
        setManifestId(null);
        setName(null);
        setScheduledAt(new Date());
        setState(CampaignState.getDefault());
        setFilters(null);
    }

    public Campaign() {
        this(null);
    }

    public Campaign(String id) {
        this(id, null, new Date(), new Date(), new Date());
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the state
     */
    public CampaignState getState() {
        return state;
    }

    /**
     * @param state
     *            the state to set
     */
    public void setState(CampaignState state) {
        this.state = state;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the manifestId
     */
    public String getManifestId() {
        return manifestId;
    }

    /**
     * @param manifestId
     *            the manifestId to set
     */
    public void setManifestId(String manifestId) {
        this.manifestId = manifestId;
    }

    /**
     * @return the scheduledAt
     */
    public Date getScheduledAt() {
        return scheduledAt;
    }

    /**
     * @param scheduledAt
     *            the scheduledAt to set
     */
    public void setScheduledAt(Date scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    /**
     * @return the manifestUrl
     */
    public URL getManifestUrl() {
        return manifestUrl;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the startedAt
     */
    public Date getStartedAt() {
        return startedAt;
    }

    /**
     * @return the finishedAt
     */
    public Date getFinishedAt() {
        return finishedAt;
    }

    /**
     * @return the filters
     */
    public Filters getFilters() {
        return filters;
    }

    /**
     * @param filters
     *            the filters to set
     */
    public void setFilters(Filters filters) {
        this.filters = filters;
    }

}
