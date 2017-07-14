package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "This object represents an API key in mbed Cloud")
public class ApiKey {
	/**
	 * Display name for the API key
	 */
	@NonNull
	private String name;
	/**
	 * The owner of this API key, who is the creator by default
	 */
	@NonNull
	private String ownerId;

	/**
	 * @return the name
	 */
	public @NonNull String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(@NonNull String name) {
		this.name = name;
	}

	/**
	 * @return the ownerId
	 */
	public @NonNull String getOwnerId() {
		return ownerId;
	}

	/**
	 * @param ownerId
	 *            the ownerId to set
	 */
	public void setOwnerId(@NonNull String ownerId) {
		this.ownerId = ownerId;
	}

}
