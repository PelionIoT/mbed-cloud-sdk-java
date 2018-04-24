package com.arm.mbed.cloud.sdk.subscribe.store;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.Callback;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.subscribe.NotificationCallback;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceState;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateFilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateNotification;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateObserver;

import io.reactivex.BackpressureStrategy;
import io.reactivex.schedulers.Schedulers;

public class TestSubscriptionObserversStore {

    /**
     * Tests subscriptions to device state changes
     */
    @Test
    public void testDeviceState() {
        Future<?> handle = null;
        ScheduledExecutorService executor = null;
        try {
            List<DeviceStateNotification> receivedNotifications = new LinkedList<>();
            SubscriptionObserversStore store = new SubscriptionObserversStore(Schedulers.computation(), null, null);
            DeviceStateObserver obs1 = store.deviceState(new DeviceStateFilterOptions().likeDevice("016%33e")
                    .equalDeviceState(DeviceState.REGISTRATION_UPDATE), BackpressureStrategy.BUFFER);

            // We are only interested in one value of obs1
            Future<DeviceStateNotification> future = obs1.futureOne();

            DeviceStateObserver obs2 = store.deviceState(DeviceStateFilterOptions.newFilter().likeDevice("016%2b7")
                    .equalDeviceState(DeviceState.REGISTRATION_UPDATE), BackpressureStrategy.BUFFER);

            assertTrue(store.hasObservers());
            assertTrue(store.hasObservers(SubscriptionType.DEVICE_STATE_CHANGE));
            assertFalse(store.hasObservers(SubscriptionType.NOTIFICATION));
            assertEquals(2, store.listAll().size());
            assertEquals(2, store.listAll(SubscriptionType.DEVICE_STATE_CHANGE).size());
            assertNull(store.listAll(SubscriptionType.NOTIFICATION));
            // Generating notifications
            @SuppressWarnings("boxing")
            List<DeviceStateNotification> notifications = Stream.iterate(0, n -> n + 1).limit(102).map(i -> {
                return (i % 2 == 0)
                        ? new DeviceStateNotification(
                                (i % 5 == 0) ? DeviceState.REGISTRATION_UPDATE : DeviceState.EXPIRED_REGISTRATION,
                                "0161661e9ce10000000000010010033e")
                        : new DeviceStateNotification(
                                (i % 5 == 0) ? DeviceState.REGISTRATION_UPDATE : DeviceState.REGISTRATION,
                                "0161661edbab000000000001001002b7");
            }).collect(Collectors.toList());

            obs2.addCallback(new NotificationCallback<>(new Callback<DeviceStateNotification>() {

                @Override
                public void execute(DeviceStateNotification arg) {
                    receivedNotifications.add(arg);
                }
            }, null));
            executor = Executors.newScheduledThreadPool(1);
            int Interval = 300;
            handle = executor.scheduleWithFixedDelay(new Runnable() {

                private int i = 0;

                @Override
                public void run() {
                    if (i < notifications.size()) {
                        try {
                            store.notify(SubscriptionType.DEVICE_STATE_CHANGE, notifications.get(i));
                        } catch (MbedCloudException e) {
                            e.printStackTrace();
                        }
                        i++;
                    }
                }
            }, 0, Interval, TimeUnit.MILLISECONDS);
            // Waiting for all notifications to be emitted
            Thread.sleep((notifications.size() + 1) * Interval);

            DeviceStateNotification receivedNotificationForObs1 = future.get(2, TimeUnit.SECONDS);
            assertNotNull(receivedNotificationForObs1);
            assertEquals("0161661e9ce10000000000010010033e", receivedNotificationForObs1.getDeviceId());
            assertEquals(DeviceState.REGISTRATION_UPDATE, receivedNotificationForObs1.getState());
            assertFalse(receivedNotifications.isEmpty());
            // odd Multiples of 5 between 0 and 102: 10
            assertEquals(10, receivedNotifications.size());
            // Observer 2 only cares about changes related to devices like 016%2b7 and REGISTRATION_UPDATE state
            receivedNotifications.forEach(n -> {
                assertEquals("0161661edbab000000000001001002b7", n.getDeviceId());
                assertEquals(DeviceState.REGISTRATION_UPDATE, n.getState());
            });
            // Observer obs1 should have been unsubscribed after the value had been received whereas obs2 should be
            // still on.
            assertFalse(store.hasObserver(obs1));
            assertTrue(store.hasObserver(obs2));
            store.completeAll();
            store.unsubscribeAll();
            assertFalse(store.hasObservers());
            assertFalse(store.hasObserver(obs2));

            if (handle != null) {
                handle.cancel(true);
            }
            executor.shutdownNow();

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
