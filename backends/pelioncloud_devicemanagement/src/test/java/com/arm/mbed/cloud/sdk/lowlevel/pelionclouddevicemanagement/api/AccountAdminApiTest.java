package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for AccountAdminApi
 */
public class AccountAdminApiTest {

    private AccountAdminApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AccountAdminApi.class);
    }

    /**
     * Get notification event details.
     *
     * An endpoint for retrieving notification event details.
     */
    @Test
    public void getNofificationEntryTest() {
        String notificationId = null;
        // NotificationEntry response = api.getNofificationEntry(notificationId);

        // TODO: test validations
    }
}
