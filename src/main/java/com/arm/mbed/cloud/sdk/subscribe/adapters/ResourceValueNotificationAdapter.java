package com.arm.mbed.cloud.sdk.subscribe.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.internal.mds.model.NotificationData;
import com.arm.mbed.cloud.sdk.internal.mds.model.NotificationMessage;
import com.arm.mbed.cloud.sdk.subscribe.model.ResourceValueNotification;

@Preamble(description = "Adapter for resource value change notifications")
@Internal
public final class ResourceValueNotificationAdapter {

    private ResourceValueNotificationAdapter() {
        super();
    }

    /**
     * Maps resource value notification.
     *
     * @param notificationData
     *            notification data.
     * @return a resource value notification.
     */
    public static ResourceValueNotification map(NotificationData notificationData) {
        if (notificationData == null) {
            return null;
        }
        final ResourceValueNotification notification = new ResourceValueNotification(notificationData.getEp(),
                notificationData.getPath());
        notification.setMaxAge(notificationData.getMaxAge());
        notification.decodePayload(notificationData.getPayload(), notificationData.getCt());
        return notification;
    }

    /**
     * Gets a mapper.
     *
     * @return a mapper
     */
    public static Mapper<NotificationData, ResourceValueNotification> getMapper() {
        return new Mapper<NotificationData, ResourceValueNotification>() {

            @Override
            public ResourceValueNotification map(NotificationData toBeMapped) {
                return ResourceValueNotificationAdapter.map(toBeMapped);
            }
        };
    }

    /**
     * Maps a list of notification data.
     *
     * @param list
     *            list of notification data.
     * @return list of resource value notification.
     */
    public static List<ResourceValueNotification> mapList(List<NotificationData> list) {
        return GenericAdapter.mapList(list, getMapper());
    }

    /**
     * Gets list mapper.
     *
     *
     * @return a list mapper.
     */
    public static Mapper<List<NotificationData>, List<ResourceValueNotification>> getListMapper() {

        return new Mapper<List<NotificationData>, List<ResourceValueNotification>>() {

            @Override
            public List<ResourceValueNotification> map(List<NotificationData> toBeMapped) {
                return ResourceValueNotificationAdapter.mapList(toBeMapped);
            }

        };
    }

    /**
     * Maps device state change notifications.
     *
     * @param notificationMessage
     *            notification message.
     * @return list of device state change notification.
     */
    public static List<ResourceValueNotification> mapNotificationMessage(NotificationMessage notificationMessage) {
        if (notificationMessage == null) {
            return null;
        }
        return ResourceValueNotificationAdapter.mapList(notificationMessage.getNotifications());
    }

    /**
     * Gets notification message mapper.
     *
     * @return a list mapper.
     */
    public static Mapper<NotificationMessage, List<ResourceValueNotification>> getNotificationMessageMapper() {
        return new Mapper<NotificationMessage, List<ResourceValueNotification>>() {

            @Override
            public List<ResourceValueNotification> map(NotificationMessage toBeMapped) {
                return ResourceValueNotificationAdapter.mapNotificationMessage(toBeMapped);
            }

        };
    }

}
