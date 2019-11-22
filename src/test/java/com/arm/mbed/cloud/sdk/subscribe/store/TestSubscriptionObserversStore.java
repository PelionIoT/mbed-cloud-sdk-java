package com.arm.mbed.cloud.sdk.subscribe.store;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import io.reactivex.BackpressureStrategy;
import io.reactivex.schedulers.Schedulers;

import com.arm.mbed.cloud.sdk.common.Callback;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.subscribe.NotificationCallback;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;
import com.arm.mbed.cloud.sdk.subscribe.model.AllNotifications;
import com.arm.mbed.cloud.sdk.subscribe.model.AllNotificationsObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceState;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateFilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateNotification;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.ResourceValueNotification;
import com.arm.mbed.cloud.sdk.subscribe.model.ResourceValueObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

public class TestSubscriptionObserversStore {

    /**
     * Tests subscriptions to device state changes
     */
    @Test
    public void testDeviceStateChanges() {
        Future<?> handle = null;
        ScheduledExecutorService executor = null;
        try {
            List<DeviceStateNotification> receivedNotifications = new LinkedList<>();
            SubscriptionObserversStore store = new SubscriptionObserversStore(Schedulers.computation(), null, null,
                                                                              null);
            DeviceStateObserver obs1 = store.deviceStateChanges(new DeviceStateFilterOptions().likeDevice("016%33e")
                                                                                              .equalDeviceState(DeviceState.REGISTRATION_UPDATE),
                                                                BackpressureStrategy.BUFFER);

            // We are only interested in one value of obs1
            Future<DeviceStateNotification> future = obs1.futureOne();

            DeviceStateObserver obs2 = store.deviceStateChanges(DeviceStateFilterOptions.newFilter()
                                                                                        .likeDevice("016%2b7")
                                                                                        .equalDeviceState(DeviceState.REGISTRATION_UPDATE),
                                                                BackpressureStrategy.BUFFER);

            assertTrue(store.hasObservers());
            assertTrue(store.hasObservers(SubscriptionType.DEVICE_STATE_CHANGE));
            assertFalse(store.hasObservers(SubscriptionType.ALL));
            assertFalse(store.hasObservers(SubscriptionType.NOTIFICATION));
            assertEquals(2, store.listAll().size());
            assertEquals(2, store.listAll(SubscriptionType.DEVICE_STATE_CHANGE).size());
            assertNull(store.listAll(SubscriptionType.NOTIFICATION));
            assertNull(store.listAll(SubscriptionType.ALL));
            // Generating notifications
            @SuppressWarnings("boxing")
            List<DeviceStateNotification> notifications = Stream.iterate(0, n -> n + 1).limit(102).map(i -> {
                return (i % 2 == 0)
                                    ? new DeviceStateNotification((i % 5 == 0) ? DeviceState.REGISTRATION_UPDATE
                                                                               : DeviceState.EXPIRED_REGISTRATION,
                                                                  "0161661e9ce10000000000010010033e",
                                                                  "an endpoint name")
                                    : new DeviceStateNotification((i % 5 == 0) ? DeviceState.REGISTRATION_UPDATE
                                                                               : DeviceState.REGISTRATION,
                                                                  "0161661edbab000000000001001002b7",
                                                                  "an endpoint name");
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
            assertEquals(DeviceState.REGISTRATION_UPDATE, receivedNotificationForObs1.getEvent());
            assertFalse(receivedNotifications.isEmpty());
            // odd Multiples of 5 between 0 and 102: 10
            assertEquals(10, receivedNotifications.size());
            // Observer 2 only cares about changes related to devices like 016%2b7 and REGISTRATION_UPDATE state
            receivedNotifications.forEach(n -> {
                assertEquals("0161661edbab000000000001001002b7", n.getDeviceId());
                assertEquals(DeviceState.REGISTRATION_UPDATE, n.getEvent());
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

    /**
     * Tests subscriptions to resource value changes
     */
    @Test
    public void testResourceValueChanges() {
        Future<?> handle = null;
        ScheduledExecutorService executor = null;
        try {
            List<ResourceValueNotification> receivedNotifications = new LinkedList<>();
            SubscriptionObserversStore store = new SubscriptionObserversStore(Schedulers.computation(), null, null,
                                                                              null);
            ResourceValueObserver obs1 = store.resourceValues(SubscriptionFilterOptions.newFilter()
                                                                                       .likeDevice("016%33e")
                                                                                       .equalResourcePath("/1/0/3/"),
                                                              BackpressureStrategy.BUFFER);

            // We are only interested in one value of obs1
            Future<ResourceValueNotification> future = obs1.futureOne();

            ResourceValueObserver obs2 = store.resourceValues(SubscriptionFilterOptions.newFilter()
                                                                                       .likeDevice("016%2b7")
                                                                                       .equalResourcePath("/1/0/3/"),
                                                              BackpressureStrategy.BUFFER);

            assertTrue(store.hasObservers());
            assertTrue(store.hasObservers(SubscriptionType.NOTIFICATION));
            assertFalse(store.hasObservers(SubscriptionType.DEVICE_STATE_CHANGE));
            assertFalse(store.hasObservers(SubscriptionType.ALL));
            assertEquals(2, store.listAll().size());
            assertEquals(2, store.listAll(SubscriptionType.NOTIFICATION).size());
            assertNull(store.listAll(SubscriptionType.DEVICE_STATE_CHANGE));
            assertNull(store.listAll(SubscriptionType.ALL));
            // Generating notifications
            @SuppressWarnings("boxing")
            List<ResourceValueNotification> notifications = Stream.iterate(0, n -> n + 1).limit(102).map(i -> {
                final ResourceValueNotification notification = (i
                                                                % 2 == 0) ? new ResourceValueNotification("0161661e9ce10000000000010010033e",
                                                                                                          (i
                                                                                                           % 5 == 0) ? "/1/0/3/"
                                                                                                                     : "/1/2/3").payload(i)
                                                                          : new ResourceValueNotification("0161661edbab000000000001001002b7",
                                                                                                          (i
                                                                                                           % 5 == 0) ? "/1/0/3/"
                                                                                                                     : "/1/2/3").payload(i);
                return notification;
            }).collect(Collectors.toList());

            obs2.addCallback(new NotificationCallback<>(new Callback<ResourceValueNotification>() {

                @Override
                public void execute(ResourceValueNotification arg) {
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
                            store.notify(SubscriptionType.NOTIFICATION, notifications.get(i));
                        } catch (MbedCloudException e) {
                            e.printStackTrace();
                        }
                        i++;
                    }
                }
            }, 0, Interval, TimeUnit.MILLISECONDS);
            // Waiting for all notifications to be emitted
            Thread.sleep((notifications.size() + 1) * Interval);

            ResourceValueNotification receivedNotificationForObs1 = future.get(2, TimeUnit.SECONDS);
            assertNotNull(receivedNotificationForObs1);
            assertEquals("0161661e9ce10000000000010010033e", receivedNotificationForObs1.getResource().getDeviceId());
            assertEquals("/1/0/3/", receivedNotificationForObs1.getResource().getPath());
            assertFalse(receivedNotifications.isEmpty());
            // odd Multiples of 5 between 0 and 102: 10
            assertEquals(10, receivedNotifications.size());
            // Observer 2 only cares about changes related to devices like 016%2b7 and "/1/0/3/" state
            receivedNotifications.forEach(n -> {
                assertEquals("0161661edbab000000000001001002b7", n.getResource().getDeviceId());
                assertEquals("/1/0/3/", n.getResource().getPath());
                assertNotNull(n.getPayload());
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

    /**
     * Tests subscriptions to all notifications
     */
    @Test
    public void testAllNotifications() {
        Future<?> handle = null;
        ScheduledExecutorService executor = null;
        try {
            List<AllNotifications> receivedNotifications = new LinkedList<>();
            SubscriptionObserversStore store = new SubscriptionObserversStore(Schedulers.computation(), null, null,
                                                                              null);
            AllNotificationsObserver obs1 = store.allNotifications(BackpressureStrategy.BUFFER);

            assertTrue(store.hasObservers());
            assertFalse(store.hasObservers(SubscriptionType.NOTIFICATION));
            assertFalse(store.hasObservers(SubscriptionType.DEVICE_STATE_CHANGE));
            assertTrue(store.hasObservers(SubscriptionType.ALL));
            assertEquals(1, store.listAll().size());
            assertEquals(1, store.listAll(SubscriptionType.ALL).size());
            assertNull(store.listAll(SubscriptionType.DEVICE_STATE_CHANGE));
            assertNull(store.listAll(SubscriptionType.NOTIFICATION));
            int numberOfNotifications = 102;
            // Generating notifications
            @SuppressWarnings("boxing")
            List<ResourceValueNotification> valueNotifications = Stream.iterate(0, n -> n + 1)
                                                                       .limit(numberOfNotifications).map(i -> {
                                                                           final ResourceValueNotification notification = (i
                                                                                                                           % 2 == 0) ? new ResourceValueNotification("0161661e9ce10000000000010010033e",
                                                                                                                                                                     (i
                                                                                                                                                                      % 5 == 0) ? "/1/0/3/"
                                                                                                                                                                                : "/1/2/3").payload(i)
                                                                                                                                     : new ResourceValueNotification("0161661edbab000000000001001002b7",
                                                                                                                                                                     (i
                                                                                                                                                                      % 5 == 0) ? "/1/0/3/"
                                                                                                                                                                                : "/1/2/3").payload(i);
                                                                           return notification;
                                                                       }).collect(Collectors.toList());
            @SuppressWarnings("boxing")
            List<DeviceStateNotification> stateNotifications = Stream.iterate(0, n -> n + 1)
                                                                     .limit(numberOfNotifications).map(i -> {
                                                                         return (i
                                                                                 % 2 == 0) ? new DeviceStateNotification((i % 5 == 0) ? DeviceState.REGISTRATION_UPDATE : DeviceState.EXPIRED_REGISTRATION, "0161661e9ce10000000000010010033e", "an endpoint name") : new DeviceStateNotification((i % 5 == 0) ? DeviceState.REGISTRATION_UPDATE : DeviceState.REGISTRATION, "0161661edbab000000000001001002b7", "another endpoint name");
                                                                     }).collect(Collectors.toList());

            AllNotifications notification = new AllNotifications(valueNotifications, null, stateNotifications);
            List<AllNotifications> notifications = new ArrayList<>(1);
            notifications.add(notification);

            obs1.addCallback(new NotificationCallback<>(new Callback<AllNotifications>() {

                @Override
                public void execute(AllNotifications arg) {
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
                            store.notify(SubscriptionType.ALL, notifications.get(i));
                        } catch (MbedCloudException e) {
                            e.printStackTrace();
                        }
                        i++;
                    }
                }
            }, 0, Interval, TimeUnit.MILLISECONDS);
            // Waiting for all notifications to be emitted
            Thread.sleep((notifications.size() + 1) * Interval);

            assertFalse(receivedNotifications.isEmpty());
            assertEquals(1, receivedNotifications.size());
            AllNotifications receivedNotification = receivedNotifications.get(0);
            assertTrue(receivedNotification.hasResourceValueNotifications());
            assertEquals(numberOfNotifications, receivedNotification.getResourceValueNotifications().size());
            assertTrue(receivedNotification.hasDeviceStateNotifications());
            assertEquals(numberOfNotifications, receivedNotification.getDeviceStateNotifications().size());
            assertFalse(receivedNotification.hasAsynchronousResponseNotifications());
            assertArrayEquals(valueNotifications.toArray(),
                              receivedNotification.getResourceValueNotifications().toArray());
            assertArrayEquals(stateNotifications.toArray(),
                              receivedNotification.getDeviceStateNotifications().toArray());
            assertTrue(store.hasObserver(obs1));
            store.completeAll();
            store.unsubscribeAll();
            assertFalse(store.hasObservers());
            assertFalse(store.hasObserver(obs1));

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
