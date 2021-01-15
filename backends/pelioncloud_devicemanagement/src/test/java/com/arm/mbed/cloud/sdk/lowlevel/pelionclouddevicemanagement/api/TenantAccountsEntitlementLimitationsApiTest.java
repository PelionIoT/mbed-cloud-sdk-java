package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for TenantAccountsEntitlementLimitationsApi
 */
public class TenantAccountsEntitlementLimitationsApiTest {

    private TenantAccountsEntitlementLimitationsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TenantAccountsEntitlementLimitationsApi.class);
    }

    /**
     * Get an entitlement limitation.
     *
     * Retrieve an entitlement limitation. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     */
    @Test
    public void aggregatorGetAccountLimitationTest() {
        String accountId = null;
        String limitationId = null;
        // AccountLimitation response = api.aggregatorGetAccountLimitation(accountId, limitationId);

        // TODO: test validations
    }

    /**
     * Get entitlement limitations.
     *
     * Retrieve an array of entitlement limitations. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators.
     */
    @Test
    public void aggregatorGetAccountLimitationsTest() {
        String accountId = null;
        String inheritedEq = null;
        // AccountLimitationList response = api.aggregatorGetAccountLimitations(accountId, inheritedEq);

        // TODO: test validations
    }
}
