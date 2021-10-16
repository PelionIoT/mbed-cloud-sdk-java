package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationEntry;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationEntryList;

public interface TenantAccountsEmailNotificationLogsApi {
    /**
     * Get email notifications. Retrieve an array of email notification logs. &lt;b&gt;Note:&lt;/b&gt; This endpoint is
     * restricted to administrators.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param limit
     *            The number of results to return (2-1000). Default 50. (optional, default to 50)
     * @param after
     *            The entity ID to retrieve after the given one. (optional)
     * @param order
     *            Record order based on creation. Acceptable values: ASC, DESC. Default: ASC. (optional, default to ASC)
     * @return Call&lt;NotificationEntryList&gt;
     */
    @GET("v3/accounts/{account_id}/notifications")
    Call<NotificationEntryList>
        getAccountNofificationEntries(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                      @retrofit2.http.Query("limit") Integer limit,
                                      @retrofit2.http.Query("after") String after,
                                      @retrofit2.http.Query("order") String order);

    /**
     * Get an email notification. Retrieve an email notifications log entry. &lt;b&gt;Note:&lt;/b&gt; This endpoint is
     * restricted to administrators.
     * 
     * @param accountId
     *            The ID of the account for which this notification should be retrieved. (required)
     * @param notificationId
     *            The ID of the notification entry to be retrieved. (required)
     * @return Call&lt;NotificationEntry&gt;
     */
    @GET("v3/accounts/{account_id}/notifications/{notification_id}")
    Call<NotificationEntry>
        getAccountNofificationEntry(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                    @retrofit2.http.Path(value = "notification_id",
                                                         encoded = true) String notificationId);

}
