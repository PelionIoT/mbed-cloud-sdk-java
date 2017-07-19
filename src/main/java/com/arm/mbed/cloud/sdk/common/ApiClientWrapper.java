package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.internal.ApiClient;

public class ApiClientWrapper {
	private static final String DEFAULT_AUTH_NAME = "Bearer";
	protected final ApiClient client;

	public ApiClientWrapper(ConnectionOptions options) {
		super();
		this.client = createClient(options);
	}

	private ApiClient createClient(ConnectionOptions options) {
		ApiClient apiClient = new ApiClient(DEFAULT_AUTH_NAME, options.getApiKey());
		if (!options.isHostEmpty()) {
			apiClient.setAdapterBuilder(apiClient.getAdapterBuilder().baseUrl(options.getHost()));
		}
		return apiClient;
	}

	public <S> S createService(Class<S> serviceClass) {
		return client.createService(serviceClass);
	}

}
