package com.arm.mbed.cloud.sdk.accountmanagement.model;

import java.util.Date;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "This object represents an API key in mbed Cloud")
public class ApiKey {
	/**
	 * The UUID of the API key
	 */
	private String id;
	/**
	 * Display name for the API key
	 */

	private String name;
	/**
	 * The owner of this API key, who is the creator by default
	 */
	private String ownerId;
	/**
	 * A list of group IDs this API key belongs to.
	 */
	private final List<String> groups;
	/**
	 * The status of the user. INVITED means that the user has not accepted the
	 * invitation request. RESET means that the password must be changed
	 * immediately.
	 */
	@DefaultValue(value = "INACTIVE")
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

	public ApiKey(String id, List<String> groups, ApiKeyStatus status, String key, Date createdAt, long creationTime,
			long lastLoginTime) {
		super();
		setId(id);
		setName(null);
		setOwnerId(null);
		this.groups = groups;
		this.status = status;
		this.key = key;
		this.createdAt = createdAt;
		this.creationTime = creationTime;
		this.lastLoginTime = lastLoginTime;
	}

	public ApiKey() {
		this(null, null, ApiKeyStatus.INACTIVE, null, new Date(), 0, 0);
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
	 * @return the ownerId
	 */
	public String getOwnerId() {
		return ownerId;
	}

	/**
	 * @param ownerId
	 *            the ownerId to set
	 */
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * @return the groups
	 */
	public List<String> getGroups() {
		return groups;
	}

	/**
	 * @return the status
	 */
	public ApiKeyStatus getStatus() {
		return status;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
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
	 * @return the lastLoginTime
	 */
	public long getLastLoginTime() {
		return lastLoginTime;
	}

}
