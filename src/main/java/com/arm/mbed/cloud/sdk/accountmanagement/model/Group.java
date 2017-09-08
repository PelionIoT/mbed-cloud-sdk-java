package com.arm.mbed.cloud.sdk.accountmanagement.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKModel;

@Preamble(description = "Group")
public class Group implements SDKModel {
    /**
     * 
     */
    private static final long serialVersionUID = -327889596220983325L;
    /**
     * The UUID of the group.
     */
    private String id;
    /**
     * The UUID of the account this group belongs to.
     */
    private final String accountId;
    /**
     * The name of the group.
     */
    private final String name;
    /**
     * The number of users in this group.
     */
    @DefaultValue(value = "0")
    private final long userCount;
    /**
     * The number of API keys in this group.
     */
    @DefaultValue(value = "0")
    private final long apiKeyCount;
    /**
     * Creation time.
     */
    @DefaultValue(value = "now()")
    private final Date createdAt;
    /**
     * A timestamp of the group creation in the storage, in milliseconds.
     */
    @DefaultValue(value = "0")
    private final long creationTime;
    /**
     * A timestamp of the latest group update, in milliseconds.
     */
    @DefaultValue(value = "0")
    private final long lastUpdateTime;

    @Internal
    public Group(String id, String accountId, String name, long userCount, long apiKeyCount, Date createdAt,
            long creationTime, long lastUpdateTime) {
        super();
        setId(id);
        this.accountId = accountId;
        this.name = name;
        this.userCount = userCount;
        this.apiKeyCount = apiKeyCount;
        this.createdAt = createdAt;
        this.creationTime = creationTime;
        this.lastUpdateTime = lastUpdateTime;
    }

    public Group() {
        this(null, null, null, 0, 0, new Date(), 0, 0);
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
    public void setGroupId(String id) {
        setId(id);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the userCount
     */
    public long getUserCount() {
        return userCount;
    }

    /**
     * @return the apiKeyCount
     */
    public long getApiKeyCount() {
        return apiKeyCount;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the creationTime
     */
    public long getCreationTime() {
        return creationTime;
    }

    /**
     * @return the lastUpdateTime
     */
    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Group clone() throws CloneNotSupportedException {
        return new Group(id, accountId, name, userCount, apiKeyCount, createdAt, creationTime, lastUpdateTime);
    }

}
