package com.arm.mbed.cloud.sdk.devicedirectory.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKModel;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;

@Preamble(description = "Query model")
public class Query implements SDKModel {

    /**
     * 
     */
    private static final long serialVersionUID = -262399232521895478L;
    /**
     * The ID of the query
     */
    private String id;
    /**
     * The time the query was created
     */
    @DefaultValue(value = "now()")
    private final Date createdAt;
    /**
     * The time the query was updated
     */
    @DefaultValue(value = "now()")
    private final Date updatedAt;
    /**
     * The name of the query
     */
    private String name;
    /**
     * The device filter
     */
    private Filters filter;

    @Internal
    public Query(String id, Date createdAt, Date updatedAt) {
        super();
        setId(id);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        setName(null);
        setFilter(null);
    }

    public Query() {
        this(null, new Date(), new Date());
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
     * @return the filter
     */
    public Filters getFilter() {
        return filter;
    }

    /**
     * @param filter
     *            the filter to set
     */
    public void setFilter(Filters filter) {
        this.filter = filter;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

}
