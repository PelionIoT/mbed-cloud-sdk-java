package com.arm.mbed.cloud.sdk.common;

public abstract class AbstractAPI {

	protected final ApiClientWrapper client;

	public AbstractAPI(ConnectionOptions options) {
		super();
		this.client = new ApiClientWrapper(options);
	}

}
