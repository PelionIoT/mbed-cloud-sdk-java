package com.arm.mbed.cloud.sdk.notify;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.DeliveryMethod;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.connect.model.WebhookDao;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationMessage;

@Preamble(description = "Definition of the notification manager for Pelion Cloud")
public interface CloudNotificationManager {

    /**
     * Allows notifications (received from the Cloud) to be injected into the notifications system.
     *
     * @param data
     *            The notification data to inject
     */

    void notify(@Nullable NotificationMessage data);

    /**
     * Allows notifications expressed as a JSON string to be injected into the notifications system.
     * <p>
     *
     * @param dataAsJson
     *            The notification data to inject as JSON String.
     */
    @API
    void notify(@Nullable String dataAsJson);

    /**
     * Starts notification pull.
     * <p>
     * this function is mandatory to get or set resources when notifications are fetched by the client. See
     * {@link DeliveryMethod}. Unless {@link ConnectionOptions#setAutostartDaemon(boolean)} has been set to true or left
     * as default.
     *
     * @throws MbedCloudException
     *             if a problem occurred during the process.
     */
    void start() throws MbedCloudException;

    /**
     * Stops notification pull.
     * <p>
     *
     * @throws MbedCloudException
     *             if a problem occurred during the process.
     */
    void stop() throws MbedCloudException;

    /**
     * Gets the webhook entity.
     * 
     * @return the webhook DAO.
     */
    WebhookDao webhook();
}
