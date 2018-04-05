package com.arm.mbed.cloud.sdk.certificates.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.internal.connectorca.api.DeveloperCertificateApi;
import com.arm.mbed.cloud.sdk.internal.connectorca.api.ServerCredentialsApi;
import com.arm.mbed.cloud.sdk.internal.iam.api.AccountAdminApi;
import com.arm.mbed.cloud.sdk.internal.iam.api.DeveloperApi;

@Preamble(description = "Endpoint for Certificates")
@Internal
public class EndPoints extends AbstractEndpoints {

    private final DeveloperApi accountDeveloper;
    private final AccountAdminApi admin;
    private final ServerCredentialsApi server;
    private final DeveloperCertificateApi certDeveloper;

    /**
     * Constructor.
     *
     * @param wrapper
     *            API client {@link ApiClientWrapper}.
     */
    public EndPoints(ApiClientWrapper wrapper) {
        super(wrapper);
        this.accountDeveloper = initialiseDeveloper(wrapper);
        this.admin = initialiseAdmin(wrapper);
        this.server = initialiseServer(wrapper);
        this.certDeveloper = initialiseCertDeveloper(wrapper);
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

    private DeveloperCertificateApi initialiseCertDeveloper(ApiClientWrapper wrapper) {
        return wrapper.createService(DeveloperCertificateApi.class);
    }

    private ServerCredentialsApi initialiseServer(ApiClientWrapper wrapper) {
        return wrapper.createService(ServerCredentialsApi.class);
    }

    public DeveloperApi getAccountDeveloper() {
        return accountDeveloper;
    }

    public AccountAdminApi getAdmin() {
        return admin;
    }

    public ServerCredentialsApi getServerCredentials() {
        return server;
    }

    public DeveloperCertificateApi getCertDeveloper() {
        return certDeveloper;
    }

}
