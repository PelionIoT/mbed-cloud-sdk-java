package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.internal.api.AccountAdminApi;
import com.arm.mbed.cloud.sdk.internal.api.DeveloperApi;

@Preamble(description = "Endpoint for Account management")
@Internal
public class EndPoints {

    private final DeveloperApi developer;
    private final AccountAdminApi admin;

    public EndPoints(ApiClientWrapper wrapper) {
        super();
        this.developer = initialiseDeveloper(wrapper);
        this.admin = initialiseAdmin(wrapper);
    }

    public EndPoints(ConnectionOptions options) {
        this(new ApiClientWrapper(options));
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
