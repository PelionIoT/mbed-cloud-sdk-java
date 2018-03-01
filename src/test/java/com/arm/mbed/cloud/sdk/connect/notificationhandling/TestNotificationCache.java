package com.arm.mbed.cloud.sdk.connect.notificationhandling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.Callback;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.internal.mds.model.NotificationData;
import com.arm.mbed.cloud.sdk.internal.mds.model.NotificationMessage;

import io.reactivex.BackpressureStrategy;

public class TestNotificationCache {

    @SuppressWarnings("boxing")
    @Test
    public void testNotifyNotificationMessage() {
        Future<?> handle = null;
        ScheduledExecutorService executor = null;
        String[] payloads = { "MQ==", "Mg==", "Mw==", "NA==", "NQ==" };
        try {
            NotificationHandlersStore cache = new NotificationHandlersStore(null, null, null);
            List<Integer> receivedNotificationsUsingObservers = new LinkedList<>();
            List<Integer> receivedNotificationsUsingCallbacks = new LinkedList<>();
            List<Throwable> receivedErrorsUsingCallbacks = new LinkedList<>();
            String deviceId = "015f4ac587f500000000000100100249";
            String resourcePath = "/3200/0/5501";
            Resource resource = new Resource(deviceId, resourcePath);
            cache.createResourceSubscriptionObserver(resource, BackpressureStrategy.BUFFER).subscribe(
                    object -> receivedNotificationsUsingObservers.add(Integer.parseInt(String.valueOf(object))));
            cache.registerSubscriptionCallback(resource, new Callback<Object>() {

                @Override
                public void execute(Object arg) {
                    System.out.println("Received notification: " + arg);
                    receivedNotificationsUsingCallbacks.add(Integer.parseInt(String.valueOf(arg)));
                }
            }, new Callback<Throwable>() {

                @Override
                public void execute(Throwable arg) {
                    System.err.println("Error happened during notification handling: " + arg);
                    receivedErrorsUsingCallbacks.add(arg);

                }
            });
            // The following should not have any impact.
            cache.deregisterNotificationSubscriptionCallback(new Resource(deviceId, "/3200/0/5502"));
            cache.removeResourceSubscriptionObserver(new Resource(deviceId, "/3200/0/5503"));

            executor = Executors.newScheduledThreadPool(1);
            int Interval = 100;
            handle = executor.scheduleWithFixedDelay(new Runnable() {
                List<String> payloadList = Arrays.asList(payloads);
                private int i = 0;

                @Override
                public void run() {
                    if (i < payloadList.size()) {
                        NotificationMessage notifications = new NotificationMessage();
                        NotificationData notification = new NotificationData();
                        notification.setEp(deviceId);
                        notification.setPath(resourcePath);
                        notification.setPayload(payloadList.get(i));
                        notifications.addNotificationsItem(notification);
                        cache.notify(null);
                        cache.notify(notifications);
                        i++;
                    }
                }
            }, 0, Interval, TimeUnit.MILLISECONDS);
            Thread.sleep((payloads.length + 1) * Interval);
            assertTrue(receivedErrorsUsingCallbacks.isEmpty());
            for (int i = 0; i < payloads.length; i++) {
                assertEquals(i + 1, receivedNotificationsUsingCallbacks.get(i), 0);
                assertEquals(i + 1, receivedNotificationsUsingObservers.get(i), 0);
            }
            cache.shutdown();
        } catch (Exception e) {
            if (handle != null) {
                handle.cancel(true);
            }
            if (executor != null) {
                executor.shutdownNow();
            }
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

}
