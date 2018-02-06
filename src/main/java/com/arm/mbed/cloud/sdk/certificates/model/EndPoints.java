package com.arm.mbed.cloud.sdk.certificates.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.internal.connectorca.api.ExternalAPIApi;
import com.arm.mbed.cloud.sdk.internal.iam.api.AccountAdminApi;
import com.arm.mbed.cloud.sdk.internal.iam.api.DeveloperApi;

@Preamble(description = "Endpoint for Certificates")
@Internal
public class EndPoints {

    private final DeveloperApi accountDeveloper;
    private final AccountAdminApi admin;
    private final ExternalAPIApi connector;

    /**
     * Constructor.
     * 
     * @param wrapper
     *            API client {@link ApiClientWrapper}.
     */
    public EndPoints(ApiClientWrapper wrapper) {
        super();
        this.accountDeveloper = initialiseDeveloper(wrapper);
        this.admin = initialiseAdmin(wrapper);
        this.connector = initialiseConnector(wrapper);
    }

    /**
     * Constructor.
     * 
     * @param options
     *            connection options {@link ConnectionOptions}.
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

    private ExternalAPIApi initialiseConnector(ApiClientWrapper wrapper) {
        return wrapper.createService(ExternalAPIApi.class);
    }

    public DeveloperApi getAccountDeveloper() {
        return accountDeveloper;
    }

    public AccountAdminApi getAdmin() {
        return admin;
    }

    public ExternalAPIApi getConnector() {
        return connector;
    }

}
