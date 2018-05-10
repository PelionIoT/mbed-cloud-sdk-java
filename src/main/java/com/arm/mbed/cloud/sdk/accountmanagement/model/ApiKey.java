package com.arm.mbed.cloud.sdk.accountmanagement.model;

import java.util.Date;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.common.SdkUtils;

@Preamble(description = "This object represents an API key in Arm Mbed Cloud")
public class ApiKey implements SdkModel {
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
    @Required
    private String name;
    /**
     * The owner of this API key, who is the creator by default.
     */
    private String ownerId;
    /**
     * A list of group IDs this API key belongs to.
     */
    private List<String> groups;
    /**
     * The status of the user.
     */
    private ApiKeyStatus status;
    /**
     * Field to keep track of an updated status.
     */
    @Internal
    private transient boolean hasStatusBeenUpdated;
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
     * Note: Should not be used. Use {@link #ApiKey()} or {@link #ApiKey(String)} instead.
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
        this.key = key;
        this.createdAt = createdAt;
        this.creationTime = creationTime;
        this.lastLoginTime = lastLoginTime;
        setName(name);
        setOwnerId(ownerId);
        setGroup(groups);
        setStatus(status);
        hasStatusBeenUpdated = false;
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #ApiKey()} or {@link #ApiKey(String)} instead.
     *
     * @param id
     *            id
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
    public ApiKey(String id, String key, Date createdAt, long creationTime, long lastLoginTime) {
        this(id, null, null, null, ApiKeyStatus.getDefault(), key, createdAt, creationTime, lastLoginTime);
    }

    /**
     * ApiKey constructor.
     * <p>
     * Other constructors with 'Internal' annotation are for internal usage only.
     *
     */
    public ApiKey() {
        this(null, null, new Date(), 0, 0);
    }

    /**
     * ApiKey constructor.
     * <p>
     * Other constructors with 'Internal' annotation are for internal usage only.
     *
     * @param name
     *            API key name.
     */
    public ApiKey(String name) {
        this();
        setName(name);
    }

    /**
     * Gets API key id.
     *
     * @return the id.
     */
    @Override
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
     * Sets the id.
     * <p>
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
    @Required
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
     * Sets the groups the API key belongs to.
     * 
     * @param groups
     *            list of group IDs this API key belongs to.
     */
    public void setGroup(List<String> groups) {
        this.groups = groups;
    }

    /**
     * Sets the groups the API key belongs to.
     * 
     * @param groups
     *            list of group IDs as a string, such as
     *            "[\"015bc8548c8902420a016d0600000000\",\"015bc8548c8902420a016d0600fsdf000\"]" or
     *            "015bc8548c8902420a016d0600000000,015bc8548c8902420a016d0600fsdf000".
     */
    public void setGroupsFromString(String groups) {
        setGroup(SdkUtils.parseListString(groups));
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
     * Sets the status of the API key.
     *
     * @param status
     *            the status.
     */
    public void setStatus(ApiKeyStatus status) {
        this.status = status;
        hasStatusBeenUpdated = true;
    }

    /**
     * Checks whether the status has been modified since creation.
     *
     * @return true if the status has been modified. False otherwise.
     */
    @Internal
    public boolean hasStatusBeenUpdated() {
        return hasStatusBeenUpdated;
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
    public ApiKey clone() {
        return new ApiKey(id, name, ownerId, groups, status, key, createdAt, creationTime, lastLoginTime);
    }

    /**
     * Determines whether all required fields have been set and therefore if the model instance is valid.
     *
     * @return true if instance is valid. False otherwise.
     */
    @Override
    public boolean isValid() {
        return name != null;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ApiKey [id=" + id + ", name=" + name + ", ownerId=" + ownerId + ", groups=" + groups + ", status="
                + status + ", key=" + key + ", createdAt=" + createdAt + ", creationTime=" + creationTime
                + ", lastLoginTime=" + lastLoginTime + "]";
    }

}
