package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Update API key")
public class UpdateApiKey extends ApiKey {
	/**
	 * The UUID of the API key
	 */
	@NonNull
	private String id;

	/**
	 * @return the id
	 */
	public @NonNull String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(@NonNull String id) {
		this.id = id;
	}

}
