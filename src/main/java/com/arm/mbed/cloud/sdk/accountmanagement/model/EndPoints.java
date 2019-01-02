package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ServiceRegistry;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

@Preamble(description = "Endpoint for Account management")
@Internal
public class EndPoints extends AbstractEndpoints {

    private final DeveloperApi developer;
    private final AccountAdminApi admin;

    /**
     * Constructor.
     * 
     * @param services
     *            created services {@link ServiceRegistry}.
     */
    public EndPoints(ServiceRegistry services) {
        super(services);
        this.developer = initialiseService(DeveloperApi.class);
        this.admin = initialiseService(AccountAdminApi.class);
    }

    public DeveloperApi getDeveloper() {
        return developer;
    }

    public AccountAdminApi getAdmin() {
        return admin;
    }

    @Override
    public EndPoints clone() {
        return new EndPoints(getRegistryClone());
    }
}
