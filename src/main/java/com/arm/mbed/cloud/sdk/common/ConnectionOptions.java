package com.arm.mbed.cloud.sdk.common;

public class ConnectionOptions {
	private String apiKey;
	private String host;

	public ConnectionOptions(String apiKey, String host) {
		super();
		this.apiKey = apiKey;
		this.host = host;
	}

	/**
	 * @return the apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * @param apiKey
	 *            the apiKey to set
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public boolean isApiKeyEmpty() {
		return apiKey == null || apiKey.isEmpty();
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host
	 *            the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

}
