package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationEntry;

public interface AccountAdminApi {
    /**
     * Get notification event details. An endpoint for retrieving notification event details.
     * 
     * @param notificationId
     *            The ID of the notification entry to be retrieved. (required)
     * @return Call&lt;NotificationEntry&gt;
     */
    @GET("v3/accounts/me/notifications/{notification_id}")
    Call<NotificationEntry>
        getNofificationEntry(@retrofit2.http.Path(value = "notification_id", encoded = true) String notificationId);

}
