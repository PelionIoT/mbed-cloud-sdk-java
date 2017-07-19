package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.internal.api.AccountAdminApi;
import com.arm.mbed.cloud.sdk.internal.api.DeveloperApi;

public class EndPoints {

	private final DeveloperApi developer;
	private final AccountAdminApi admin;

	public EndPoints(ConnectionOptions options) {
		super();
		ApiClientWrapper wrapper = new ApiClientWrapper(options);
		this.developer = initialiseDeveloper(wrapper);
		this.admin = initialiseAdmin(wrapper);
	}

	public EndPoints(ApiClientWrapper wrapper) {
		super();
		this.developer = initialiseDeveloper(wrapper);
		this.admin = initialiseAdmin(wrapper);
	}

	private AccountAdminApi initialiseAdmin(ApiClientWrapper wrapper) {
		return wrapper.createService(AccountAdminApi.class);
	}

	private DeveloperApi initialiseDeveloper(ApiClientWrapper wrapper) {
		return wrapper.createService(DeveloperApi.class);
	}

	/**
	 * @return the developer
	 */
	public DeveloperApi getDeveloper() {
		return developer;
	}

	/**
	 * @return the admin
	 */
	public AccountAdminApi getAdmin() {
		return admin;
	}

}
