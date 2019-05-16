package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.accounts.model.AccountsEndpoints;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ServiceRegistry;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountPolicyGroupsApi;

@Preamble(description = "Endpoint for Account management")
@Internal
@Deprecated
public class EndPoints extends AccountsEndpoints {

    @Internal
    private final AccountPolicyGroupsApi accountPolicyGroupApi;

    /**
     * Constructor.
     * 
     * @param services
     *            created services {@link ServiceRegistry}.
     */
    public EndPoints(ServiceRegistry services) {
        super(services);
        this.accountPolicyGroupApi = initialiseService(AccountPolicyGroupsApi.class);
    }

    /**
     * Clones this instance.
     * 
     * <p>
     * 
     * @see java.lang.Object#clone()
     * @return a cloned instance
     */
    @Override
    public EndPoints clone() {
        return new EndPoints(getRegistryClone());
    }

    /**
     * Gets low level endpoints for account policy group apis.
     * 
     * @return accountPolicyGroupApi
     */
    @Internal
    public AccountPolicyGroupsApi getAccountPolicyGroupApi() {
        return accountPolicyGroupApi;
    }

}
