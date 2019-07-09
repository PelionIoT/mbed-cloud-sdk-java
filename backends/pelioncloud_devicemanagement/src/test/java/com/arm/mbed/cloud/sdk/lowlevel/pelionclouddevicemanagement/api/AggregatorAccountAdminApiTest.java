package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for AggregatorAccountAdminApi
 */
public class AggregatorAccountAdminApiTest {

    private AggregatorAccountAdminApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AggregatorAccountAdminApi.class);
    }

    /**
     * Get a notification event of an account.
     *
     * An endpoint for retrieving notification event details of an account.
     */
    @Test
    public void getAccountNofificationEntryTest() {
        String accountId = null;
        String notificationId = null;
        // NotificationEntry response = api.getAccountNofificationEntry(accountId, notificationId);

        // TODO: test validations
    }
}
