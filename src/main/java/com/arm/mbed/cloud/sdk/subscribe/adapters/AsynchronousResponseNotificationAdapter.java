package com.arm.mbed.cloud.sdk.subscribe.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.internal.mds.model.AsyncIDResponse;
import com.arm.mbed.cloud.sdk.internal.mds.model.NotificationMessage;
import com.arm.mbed.cloud.sdk.subscribe.model.AsynchronousResponseNotification;
import com.arm.mbed.cloud.sdk.subscribe.model.ResourceValueNotification;

@Preamble(description = "Adapter for asynchronous response notifications")
@Internal
public final class AsynchronousResponseNotificationAdapter {

    private AsynchronousResponseNotificationAdapter() {
        super();
    }

    /**
     * Maps an asynchronous response to a resource value notification.
     *
     * @param notificationData
     *            notification data.
     * @return a resource value notification.
     */
    public static ResourceValueNotification
           mapToResourceValueNotification(Resource correspondingResource,
                                          AsynchronousResponseNotification asyncResponse) {
        if (asyncResponse == null) {
            return null;
        }
        final ResourceValueNotification notification = new ResourceValueNotification(correspondingResource);
        notification.setObject(asyncResponse);
        return notification;
    }

    /**
     * Maps an asynchronous response notification.
     *
     * @param asyncResponse
     *            async response.
     * @return an asynchronous response notification.
     */
    public static AsynchronousResponseNotification map(AsyncIDResponse asyncResponse) {
        if (asyncResponse == null) {
            return null;
        }
        final AsynchronousResponseNotification notification = new AsynchronousResponseNotification(asyncResponse.getId(),
                                                                                                   TranslationUtils.toInt(asyncResponse.getStatus(),
                                                                                                                          200));
        notification.setErrorMessage(asyncResponse.getError());
        notification.decodePayload(asyncResponse.getPayload(), asyncResponse.getCt());
        return notification;
    }

    /**
     * Gets a mapper.
     *
     * @return a mapper
     */
    public static Mapper<AsyncIDResponse, AsynchronousResponseNotification> getMapper() {
        return new Mapper<AsyncIDResponse, AsynchronousResponseNotification>() {

            @Override
            public AsynchronousResponseNotification map(AsyncIDResponse toBeMapped) {
                return AsynchronousResponseNotificationAdapter.map(toBeMapped);
            }
        };
    }

    /**
     * Maps a list of async responses.
     *
     * @param list
     *            list of async responses.
     * @return list of asynchronous response notification.
     */
    public static List<AsynchronousResponseNotification> mapList(List<AsyncIDResponse> list) {
        return GenericAdapter.mapList(list, AsynchronousResponseNotificationAdapter.getMapper());
    }

    /**
     * Gets list mapper.
     *
     *
     * @return a list mapper.
     */
    public static Mapper<List<AsyncIDResponse>, List<AsynchronousResponseNotification>> getListMapper() {

        return new Mapper<List<AsyncIDResponse>, List<AsynchronousResponseNotification>>() {

            @Override
            public List<AsynchronousResponseNotification> map(List<AsyncIDResponse> toBeMapped) {
                return AsynchronousResponseNotificationAdapter.mapList(toBeMapped);
            }

        };
    }

    /**
     * Maps asynchronous response notifications.
     *
     * @param notificationMessage
     *            notification message.
     * @return list of asynchronous response notification.
     */
    public static List<AsynchronousResponseNotification>
           mapNotificationMessage(NotificationMessage notificationMessage) {
        if (notificationMessage == null) {
            return null;
        }
        return AsynchronousResponseNotificationAdapter.mapList(notificationMessage.getAsyncResponses());
    }

    /**
     * Gets notification message mapper.
     *
     * @return a list mapper.
     */
    public static Mapper<NotificationMessage, List<AsynchronousResponseNotification>> getNotificationMessageMapper() {
        return new Mapper<NotificationMessage, List<AsynchronousResponseNotification>>() {

            @Override
            public List<AsynchronousResponseNotification> map(NotificationMessage toBeMapped) {
                return AsynchronousResponseNotificationAdapter.mapNotificationMessage(toBeMapped);
            }

        };
    }

}
