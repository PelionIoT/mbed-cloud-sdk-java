package com.arm.mbed.cloud.sdk.devicedirectory.model;

import java.util.Date;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKModel;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterMarshaller;
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
     * similar to setId()
     * 
     * @param id
     *            the id to set
     */
    @Internal
    public void setQueryId(String id) {
        setId(id);
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
     * @param filter
     *            the filter to set
     */
    public void setFilter(Filters filter) {
        this.filter = filter;
    }

    /**
     * @return the filters
     */
    public Filters fetchFilter() {
        return filter;
    }

    /**
     * 
     * @return the filters as a Json object
     */
    @Internal
    public Map<String, Object> getFilter() {
        return FilterMarshaller.toJsonObject(fetchFilter());
    }

    /**
     * Gets the filter as Json String
     * 
     * @return the filters as a Json string
     */
    public String retrieveFilterAsJson() {
        return FilterMarshaller.toJson(fetchFilter());
    }

    /**
     * @param jsonString
     *            Json string defining filter
     */
    public void setFilterFromJson(String jsonString) {
        setFilter(FilterMarshaller.fromJson(jsonString));
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
