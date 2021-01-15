package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for AccountEntitlementLimitationsApi
 */
public class AccountEntitlementLimitationsApiTest {

    private AccountEntitlementLimitationsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AccountEntitlementLimitationsApi.class);
    }

    /**
     * Get an entitlement limitation.
     *
     * Retrieve an entitlement limitation.
     */
    @Test
    public void getAccountLimitationTest() {
        String limitationId = null;
        // AccountLimitation response = api.getAccountLimitation(limitationId);

        // TODO: test validations
    }

    /**
     * Get entitlement limitations.
     *
     * Retrieve an array of entitlement limitations.
     */
    @Test
    public void getAccountLimitationsTest() {
        String inheritedEq = null;
        // AccountLimitationList response = api.getAccountLimitations(inheritedEq);

        // TODO: test validations
    }
}
