package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for TenantAccountsLimitationsApi
 */
public class TenantAccountsLimitationsApiTest {

    private TenantAccountsLimitationsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TenantAccountsLimitationsApi.class);
    }

    /**
     * Get a limitation of an account.
     *
     * An endpoint for retrieving a limitation of an account.
     */
    @Test
    public void aggregatorGetAccountLimitationTest() {
        String accountId = null;
        String limitationId = null;
        // AccountLimitation response = api.aggregatorGetAccountLimitation(accountId, limitationId);

        // TODO: test validations
    }

    /**
     * Get all limitations of an account.
     *
     * An endpoint for retrieving all limitations of an account.
     */
    @Test
    public void aggregatorGetAccountLimitationsTest() {
        String accountId = null;
        String inheritedEq = null;
        // AccountLimitationList response = api.aggregatorGetAccountLimitations(accountId, inheritedEq);

        // TODO: test validations
    }
}
