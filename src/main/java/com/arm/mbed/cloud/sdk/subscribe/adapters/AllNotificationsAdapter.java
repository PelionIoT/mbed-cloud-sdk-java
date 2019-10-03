package com.arm.mbed.cloud.sdk.subscribe.adapters;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationMessage;
import com.arm.mbed.cloud.sdk.subscribe.model.AllNotifications;

@Preamble(description = "Adapter for all notifications")
@Internal
public final class AllNotificationsAdapter {

    private AllNotificationsAdapter() {
        super();
    }

    /**
     * Maps resource value change notifications.
     *
     * @param notificationMessage
     *            notification message.
     * @return list of resource value change notification.
     */
    public static AllNotifications mapNotificationMessage(NotificationMessage notificationMessage) {
        if (notificationMessage == null) {
            return null;
        }
        final AllNotifications allNotifications = new AllNotifications();
        allNotifications.setAsynchronousResponseNotifications(AsynchronousResponseNotificationAdapter.mapNotificationMessage(notificationMessage));
        allNotifications.setDeviceStateNotifications(DeviceStateNotificationAdapter.mapNotificationMessage(notificationMessage));
        allNotifications.setResourceValueNotifications(ResourceValueNotificationAdapter.mapNotificationMessage(notificationMessage));
        return allNotifications;
    }

    /**
     * Gets notification message mapper.
     *
     * @return a list mapper.
     */
    public static Mapper<NotificationMessage, AllNotifications> getNotificationMessageMapper() {
        return new Mapper<NotificationMessage, AllNotifications>() {

            @Override
            public AllNotifications map(NotificationMessage toBeMapped) {
                return AllNotificationsAdapter.mapNotificationMessage(toBeMapped);
            }

        };
    }

}
