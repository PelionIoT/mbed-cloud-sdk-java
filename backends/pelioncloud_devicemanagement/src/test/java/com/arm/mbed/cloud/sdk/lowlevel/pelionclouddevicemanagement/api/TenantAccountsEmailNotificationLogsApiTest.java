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
     * Get email notifications.
     *
     * Retrieve an array of email notification logs. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators.
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

    /**
     * Get an email notification.
     *
     * Retrieve an email notifications log entry. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators.
     */
    @Test
    public void getAccountNofificationEntryTest() {
        String accountId = null;
        String notificationId = null;
        // NotificationEntry response = api.getAccountNofificationEntry(accountId, notificationId);

        // TODO: test validations
    }
}
