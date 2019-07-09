package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationEntry;

public interface AggregatorAccountAdminApi {
    /**
     * Get a notification event of an account. An endpoint for retrieving notification event details of an account.
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
