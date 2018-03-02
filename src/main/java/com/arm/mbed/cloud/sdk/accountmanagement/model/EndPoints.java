package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.internal.iam.api.AccountAdminApi;
import com.arm.mbed.cloud.sdk.internal.iam.api.DeveloperApi;

@Preamble(description = "Endpoint for Account management")
@Internal
public class EndPoints extends AbstractEndpoints {

    private final DeveloperApi developer;
    private final AccountAdminApi admin;

    /**
     * Constructor.
     * 
     * @param wrapper
     *            API client {@link ApiClientWrapper}.
     */
    public EndPoints(ApiClientWrapper wrapper) {
        super(wrapper);
        this.developer = initialiseDeveloper(wrapper);
        this.admin = initialiseAdmin(wrapper);
    }

    /**
     * Constructor.
     * 
     * @param options
     *            connection options {@link ConnectionOptions}
     */
    public EndPoints(ConnectionOptions options) {
        this(new ApiClientWrapper(options));
    }

    private AccountAdminApi initialiseAdmin(ApiClientWrapper wrapper) {
        return wrapper.createService(AccountAdminApi.class);
    }

    private DeveloperApi initialiseDeveloper(ApiClientWrapper wrapper) {
        return wrapper.createService(DeveloperApi.class);
    }

    public DeveloperApi getDeveloper() {
        return developer;
    }

    public AccountAdminApi getAdmin() {
        return admin;
    }

}
