package com.arm.mbed.cloud.sdk.accountmanagement.model;

import java.util.Date;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKModel;

@Preamble(description = "This object represents an API key in Arm Mbed Cloud")
public class ApiKey implements SDKModel {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 6908040952116869470L;
    /**
     * The UUID of the API key.
     */
    private String id;
    /**
     * Display name for the API key.
     */

    private String name;
    /**
     * The owner of this API key, who is the creator by default.
     */
    private String ownerId;
    /**
     * A list of group IDs this API key belongs to.
     */
    private final List<String> groups;
    /**
     * The status of the user. INVITED means that the user has not accepted the invitation request. RESET means that the
     * password must be changed immediately.
     */
    private final ApiKeyStatus status;
    /**
     * The API key.
     */
    private final String key;
    /**
     * Creation time.
     */
    @DefaultValue(value = "now()")
    private final Date createdAt;
    /**
     * The timestamp of the API key creation in the storage, in milliseconds.
     */
    private final long creationTime;
    /**
     * The timestamp of the latest API key usage, in milliseconds.
     */
    private final long lastLoginTime;

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #ApiKey()} instead.
     * 
     * @param id
     *            id
     * @param name
     *            name
     * @param ownerId
     *            owner id
     * @param groups
     *            groups
     * @param status
     *            status
     * @param key
     *            key
     * @param createdAt
     *            createdAt
     * @param creationTime
     *            creationTime
     * @param lastLoginTime
     *            lastLoginTime
     */
    @Internal
    public ApiKey(String id, String name, String ownerId, List<String> groups, ApiKeyStatus status, String key,
            Date createdAt, long creationTime, long lastLoginTime) {
        super();
        setId(id);
        setName(name);
        setOwnerId(ownerId);
        this.groups = groups;
        this.status = status;
        this.key = key;
        this.createdAt = createdAt;
        this.creationTime = creationTime;
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #ApiKey()} instead.
     * 
     * @param id
     *            id
     * @param groups
     *            groups
     * @param status
     *            status
     * @param key
     *            key
     * @param createdAt
     *            createdAt
     * @param creationTime
     *            creationTime
     * @param lastLoginTime
     *            lastLoginTime
     */
    @Internal
    public ApiKey(String id, List<String> groups, ApiKeyStatus status, String key, Date createdAt, long creationTime,
            long lastLoginTime) {
        this(id, null, null, groups, status, key, createdAt, creationTime, lastLoginTime);
    }

    /**
     * ApiKey constructor.
     * <p>
     * Other constructors are for internal usage only.
     * 
     */
    public ApiKey() {
        this(null, null, ApiKeyStatus.getDefault(), null, new Date(), 0, 0);
    }

    /**
     * Gets API key id.
     * 
     * @return the id.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets API key id.
     * 
     * @param id
     *            the id to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Similar to {@link #setId(String)}.
     * 
     * @param id
     *            the id to set.
     */
    @Internal
    public void setApiKeyId(String id) {
        setId(id);
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
     * Sets the name.
     * 
     * @param name
     *            the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the owner id.
     * 
     * @return the ownerId.
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the owner id.
     * 
     * @param ownerId
     *            the ownerId to set.
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Gets the groups.
     * 
     * @return the groups.
     */
    public List<String> getGroups() {
        return groups;
    }

    /**
     * Gets the status.
     * 
     * @return the status.
     */
    public ApiKeyStatus getStatus() {
        return status;
    }

    /**
     * Gets the key.
     * 
     * @return the key.
     */
    public String getKey() {
        return key;
    }

    /**
     * Gets when the API key was created.
     * 
     * @return the createdAt.
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets creation time.
     * 
     * @return the creationTime.
     */
    public long getCreationTime() {
        return creationTime;
    }

    /**
     * Gets last login time.
     * 
     * @return the lastLoginTime.
     */
    public long getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * Gets a clone.
     * 
     * @return a clone.
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public ApiKey clone() throws CloneNotSupportedException {
        return new ApiKey(id, name, ownerId, groups, status, key, createdAt, creationTime, lastLoginTime);
    }

}
