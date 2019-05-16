package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationEntryList;

public interface TenantAccountsEmailNotificationLogsApi {
    /**
     * Get the notification events of an account. Retrieve notifications.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param limit
     *            The number of results to return (2-1000). Default 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC. (optional, default to
     *            ASC)
     * @return Call&lt;NotificationEntryList&gt;
     */
    @GET("v3/accounts/{account_id}/notifications")
    Call<NotificationEntryList>
        getAccountNofificationEntries(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                      @retrofit2.http.Query("limit") Integer limit,
                                      @retrofit2.http.Query("after") String after,
                                      @retrofit2.http.Query("order") String order);

}
