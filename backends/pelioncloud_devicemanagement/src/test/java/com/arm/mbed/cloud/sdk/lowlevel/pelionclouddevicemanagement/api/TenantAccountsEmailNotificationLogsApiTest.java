package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for TenantAccountsEmailNotificationLogsApi
 */
public class TenantAccountsEmailNotificationLogsApiTest {

    private TenantAccountsEmailNotificationLogsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TenantAccountsEmailNotificationLogsApi.class);
    }

    /**
     * Get the notification events of an account.
     *
     * Retrieve notifications.
     */
    @Test
    public void getAccountNofificationEntriesTest() {
        String accountId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        // NotificationEntryList response = api.getAccountNofificationEntries(accountId, limit, after, order);

        // TODO: test validations
    }
}
