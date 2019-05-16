package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for AccountEmailNotificationLogsApi
 */
public class AccountEmailNotificationLogsApiTest {

    private AccountEmailNotificationLogsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AccountEmailNotificationLogsApi.class);
    }

    /**
     * Get notification events for an account.
     *
     * Retrieve notifications for an account.
     */
    @Test
    public void getNofificationEntriesTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        // NotificationEntryList response = api.getNofificationEntries(limit, after, order);

        // TODO: test validations
    }
}
