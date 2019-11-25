package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for AccountLimitationsApi
 */
public class AccountLimitationsApiTest {

    private AccountLimitationsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AccountLimitationsApi.class);
    }

    /**
     * Get a limitation of an account.
     *
     * An endpoint for retrieving a limitation of an account.
     */
    @Test
    public void getAccountLimitationTest() {
        String limitationId = null;
        // AccountLimitation response = api.getAccountLimitation(limitationId);

        // TODO: test validations
    }

    /**
     * Get all limitations of an account.
     *
     * An endpoint for retrieving all limitations of an account.
     */
    @Test
    public void getAccountLimitationsTest() {
        String inheritedEq = null;
        // AccountLimitationList response = api.getAccountLimitations(inheritedEq);

        // TODO: test validations
    }
}
