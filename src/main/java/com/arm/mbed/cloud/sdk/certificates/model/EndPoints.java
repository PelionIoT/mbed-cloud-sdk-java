package com.arm.mbed.cloud.sdk.certificates.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ServiceRegistry;
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
     * @param services
     *            created services {@link ServiceStore}.
     */
    public EndPoints(ServiceRegistry services) {
        super(services);
        this.accountDeveloper = initialiseService(DeveloperApi.class);
        this.admin = initialiseService(AccountAdminApi.class);
        this.server = initialiseService(ServerCredentialsApi.class);
        this.certDeveloper = initialiseService(DeveloperCertificateApi.class);
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

    @Override
    public EndPoints clone() {
        return new EndPoints(getServicesClone());
    }
}
