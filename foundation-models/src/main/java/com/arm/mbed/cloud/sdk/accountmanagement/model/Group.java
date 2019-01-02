package com.arm.mbed.cloud.sdk.accountmanagement.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Group")
public class Group implements SdkModel {
    public static final long DEFAULT_LONG_VALLUE = 0;
    private static final String ZERO = "0";
    /**
     * Serialisation Id.
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
    @DefaultValue(value = ZERO)
    private final long userCount;
    /**
     * The number of API keys in this group.
     */
    @DefaultValue(value = ZERO)
    private final long apiKeyCount;
    /**
     * Creation time.
     */
    @DefaultValue(value = "now()")
    private final Date createdAt;
    /**
     * A timestamp of the latest group update, in milliseconds.
     */
    @DefaultValue(value = ZERO)
    private final Date updatedAt;

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #Group()} instead.
     * 
     * @param id
     *            id
     * @param accountId
     *            accountId
     * @param name
     *            name
     * @param userCount
     *            userCount
     * @param apiKeyCount
     *            apiKeyCount
     * @param createdAt
     *            createdAt
     * @param updatedAt
     *            updatedAt
     */
    @Internal
    public Group(String id, String accountId, String name, long userCount, long apiKeyCount, Date createdAt,
                 Date updatedAt) {
        super();
        setId(id);
        this.accountId = accountId;
        this.name = name;
        this.userCount = userCount;
        this.apiKeyCount = apiKeyCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Constructor for a group.
     * <p>
     * Other constructors are for internal usage only.
     */
    public Group() {
        this(null, null, null, DEFAULT_LONG_VALLUE, DEFAULT_LONG_VALLUE, new Date(), new Date());
    }

    /**
     * Sets group id.
     * 
     * @param id
     *            the id to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the id.
     * <p>
     * Similar to {@link #setId(String)}.
     * 
     * @param id
     *            the id to set.
     */
    @Internal
    public void setGroupId(String id) {
        setId(id);
    }

    /**
     * Gets group id.
     * 
     * @return the id.
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Gets account id.
     * 
     * @return the accountId.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Gets the name.
     * 
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the count of users.
     * 
     * @return the userCount
     */
    public long getUserCount() {
        return userCount;
    }

    /**
     * Gets API key count.
     * 
     * @return the apiKeyCount
     */
    public long getApiKeyCount() {
        return apiKeyCount;
    }

    /**
     * Gets when the group was created.
     * 
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets when the group was last updated.
     * 
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Gets a clone.
     * 
     * @return a clone.
     * @see java.lang.Object#clone()
     */
    @Override
    public Group clone() {
        return new Group(id, accountId, name, userCount, apiKeyCount, createdAt, updatedAt);
    }

    /**
     * Determines whether the model instance is valid i.e. all required fields have been set.
     * 
     * @return true if instance is valid. False otherwise.
     */
    @Override
    public boolean isValid() {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Group [id=" + id + ", accountId=" + accountId + ", name=" + name + ", userCount=" + userCount
               + ", apiKeyCount=" + apiKeyCount + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

}
