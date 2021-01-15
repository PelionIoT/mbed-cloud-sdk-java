package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationEntry;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationEntryList;

public interface AccountEmailNotificationLogsApi {
    /**
     * Get logs of email notifications. Retrieve an array of email notification logs.
     * 
     * @param limit
     *            The number of results to return (2-1000). Default 50. (optional, default to 50)
     * @param after
     *            The entity ID to retrieve after the given one. (optional)
     * @param order
     *            Record order based on creation. Acceptable values: ASC, DESC. Default: ASC. (optional, default to ASC)
     * @return Call&lt;NotificationEntryList&gt;
     */
    @GET("v3/accounts/me/notifications")
    Call<NotificationEntryList> getNofificationEntries(@retrofit2.http.Query("limit") Integer limit,
                                                       @retrofit2.http.Query("after") String after,
                                                       @retrofit2.http.Query("order") String order);

    /**
     * Get an email notification. Retrieve an email notification log entry.
     * 
     * @param notificationId
     *            The ID of the log entry to be retrieved. (required)
     * @return Call&lt;NotificationEntry&gt;
     */
    @GET("v3/accounts/me/notifications/{notification_id}")
    Call<NotificationEntry>
        getNofificationEntry(@retrofit2.http.Path(value = "notification_id", encoded = true) String notificationId);

}
