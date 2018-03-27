package com.arm.mbed.cloud.sdk.subscribe.adapters;

import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.connect.adapters.ResourceAdapter;
import com.arm.mbed.cloud.sdk.internal.mds.model.EndpointData;
import com.arm.mbed.cloud.sdk.internal.mds.model.NotificationMessage;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceState;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateNotification;

@Preamble(description = "Adapter for device state change notifications")
@Internal
public final class DeviceStateNotificationAdapter {

    private DeviceStateNotificationAdapter() {
        super();
    }

    /**
     * Maps device state change notification.
     *
     * @param endpointData
     *            endpoint data.
     * @param state
     *            device state
     * @return a device state change notification.
     */
    public static DeviceStateNotification map(EndpointData endpointData, DeviceState state) {
        if (endpointData == null) {
            return null;
        }
        final DeviceStateNotification notification = new DeviceStateNotification(state, endpointData.getEp());
        notification.setDeviceType(endpointData.getEpt());
        notification
                .setResources(ResourceAdapter.mapResourceDataList(endpointData.getEp(), endpointData.getResources()));

        return notification;
    }

    /**
     * Maps device state change notification.
     *
     * @param deviceId
     *            device id.
     * @param state
     *            device state.
     * @return a device state change notification.
     */
    public static DeviceStateNotification map(String deviceId, DeviceState state) {
        if (deviceId == null) {
            return null;
        }
        final DeviceStateNotification notification = new DeviceStateNotification(state, deviceId);

        return notification;
    }

    /**
     * Gets mapper.
     *
     * @param state
     *            device state.
     * @return a mapper.
     */
    public static Mapper<EndpointData, DeviceStateNotification> getMapper(DeviceState state) {
        final DeviceState finalState = state;
        return new Mapper<EndpointData, DeviceStateNotification>() {
            @Override
            public DeviceStateNotification map(EndpointData toBeMapped) {
                return DeviceStateNotificationAdapter.map(toBeMapped, finalState);
            }
        };
    }

    /**
     * Gets Device Id mapper.
     *
     * @param state
     *            device state.
     * @return a mapper.
     */
    public static Mapper<String, DeviceStateNotification> getDeviceIdMapper(DeviceState state) {
        final DeviceState finalState = state;
        return new Mapper<String, DeviceStateNotification>() {
            @Override
            public DeviceStateNotification map(String toBeMapped) {
                return DeviceStateNotificationAdapter.map(toBeMapped, finalState);
            }
        };
    }

    /**
     * Maps a list of endpoint data.
     *
     * @param list
     *            list of endpoint data.
     * @param state
     *            device state
     * @return list of device state notification.
     */
    public static List<DeviceStateNotification> mapList(List<EndpointData> list, DeviceState state) {
        return GenericAdapter.mapList(list, getMapper(state));
    }

    /**
     * Maps a list of device id strings.
     *
     * @param list
     *            list of device id strings.
     * @param state
     *            device state
     * @return list of device state notification.
     */
    public static List<DeviceStateNotification> mapDeviceIdList(List<String> list, DeviceState state) {
        return GenericAdapter.mapList(list, getDeviceIdMapper(state));
    }

    /**
     * Gets list mapper.
     *
     * @param state
     *            device state
     * @return a list mapper.
     */
    public static Mapper<List<EndpointData>, List<DeviceStateNotification>> getListMapper(DeviceState state) {
        final DeviceState finalState = state;
        return new Mapper<List<EndpointData>, List<DeviceStateNotification>>() {

            @Override
            public List<DeviceStateNotification> map(List<EndpointData> toBeMapped) {
                return DeviceStateNotificationAdapter.mapList(toBeMapped, finalState);
            }

        };
    }

    /**
     * Gets device id list mapper.
     *
     * @param state
     *            device state
     * @return a list mapper.
     */
    public static Mapper<List<String>, List<DeviceStateNotification>> getDeviceIdListMapper(DeviceState state) {
        final DeviceState finalState = state;
        return new Mapper<List<String>, List<DeviceStateNotification>>() {

            @Override
            public List<DeviceStateNotification> map(List<String> toBeMapped) {
                return DeviceStateNotificationAdapter.mapDeviceIdList(toBeMapped, finalState);
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
    public static List<DeviceStateNotification> mapNotificationMessage(NotificationMessage notificationMessage) {
        if (notificationMessage == null) {
            return null;
        }
        final List<DeviceStateNotification> deviceStateNotifications = new LinkedList<>();
        List<DeviceStateNotification> sublist = DeviceStateNotificationAdapter
                .mapList(notificationMessage.getRegistrations(), DeviceState.REGISTRATION);
        if (sublist != null) {
            deviceStateNotifications.addAll(sublist);
        }
        sublist = DeviceStateNotificationAdapter.mapList(notificationMessage.getRegUpdates(),
                DeviceState.REGISTRATION_UPDATE);
        if (sublist != null) {
            deviceStateNotifications.addAll(sublist);
        }
        sublist = DeviceStateNotificationAdapter.mapDeviceIdList(notificationMessage.getDeRegistrations(),
                DeviceState.DEREGISTRATION);
        if (sublist != null) {
            deviceStateNotifications.addAll(sublist);
        }
        sublist = DeviceStateNotificationAdapter.mapDeviceIdList(notificationMessage.getRegistrationsExpired(),
                DeviceState.EXPIRED_REGISTRATION);
        if (sublist != null) {
            deviceStateNotifications.addAll(sublist);
        }
        return deviceStateNotifications.isEmpty() ? null : deviceStateNotifications;
    }

    /**
     * Gets notification message mapper.
     *
     * @return a list mapper.
     */
    public static Mapper<NotificationMessage, List<DeviceStateNotification>> getNotificationMessageMapper() {
        return new Mapper<NotificationMessage, List<DeviceStateNotification>>() {

            @Override
            public List<DeviceStateNotification> map(NotificationMessage toBeMapped) {
                return DeviceStateNotificationAdapter.mapNotificationMessage(toBeMapped);
            }

        };
    }

}
