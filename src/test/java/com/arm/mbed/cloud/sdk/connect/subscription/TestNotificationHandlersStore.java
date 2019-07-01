package com.arm.mbed.cloud.sdk.connect.subscription;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Arrays;
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

import com.arm.mbed.cloud.sdk.Connect;
import com.arm.mbed.cloud.sdk.common.CallLogLevel;
import com.arm.mbed.cloud.sdk.common.Callback;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EndpointData;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationData;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationMessage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.PresubscriptionArray;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ResourcesData;
import com.arm.mbed.cloud.sdk.subscribe.NotificationCallback;
import com.arm.mbed.cloud.sdk.subscribe.model.AllNotifications;
import com.arm.mbed.cloud.sdk.subscribe.model.AllNotificationsObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceState;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateFilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateNotification;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;
import com.google.gson.Gson;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

public class TestNotificationHandlersStore {

    @SuppressWarnings("boxing")
    @Test
    public void testNotifyNotificationMessage() {
        Future<?> handle = null;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        String[] payloads = { "MQ==", "Mg==", "Mw==", "NA==", "NQ==" };
        try (NotificationHandlersStore store = new NotificationHandlersStore(null, null, executor, null);) {
            List<Integer> receivedNotificationsUsingObservers = new LinkedList<>();
            List<Integer> receivedNotificationsUsingCallbacks = new LinkedList<>();
            List<Throwable> receivedErrorsUsingCallbacks = new LinkedList<>();
            String deviceId = "015f4ac587f500000000000100100249";
            String resourcePath = "/3200/0/5501";
            Resource resource = new Resource(deviceId, resourcePath);
            store.createResourceSubscriptionObserver(resource, BackpressureStrategy.BUFFER)
                 .subscribe(object -> receivedNotificationsUsingObservers.add(Integer.parseInt(String.valueOf(object.getRawValue()))));
            store.registerSubscriptionCallback(resource, new Callback<Object>() {

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
            store.deregisterNotificationSubscriptionCallback(new Resource(deviceId, "/3200/0/5502"));
            store.removeResourceSubscriptionObserver(new Resource(deviceId, "/3200/0/5503"));

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
                        store.notify(null);
                        store.notify(notifications);
                        i++;
                    }
                }
            }, 0, Interval, TimeUnit.MILLISECONDS);
            Thread.sleep((payloads.length + 1) * Interval);
            assertTrue(receivedErrorsUsingCallbacks.isEmpty());
            assertFalse(receivedNotificationsUsingCallbacks.isEmpty());
            assertFalse(receivedNotificationsUsingObservers.isEmpty());
            for (int i = 0; i < payloads.length; i++) {
                assertEquals(i + 1, receivedNotificationsUsingCallbacks.get(i), 0);
                assertEquals(i + 1, receivedNotificationsUsingObservers.get(i), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        assertNotNull(handle);
        assertTrue(handle.isCancelled());
    }

    private static final String PRESUBSCRIPTION_ENDPOINT_PATH = "v2/subscriptions";

    private PresubscriptionArray generatePresubscriptions(int number) {
        PresubscriptionArray array = new PresubscriptionArray();
        for (int j = 0; j < number; j++) {
            com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Presubscription presubscription = new com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Presubscription();
            for (int i = 0; i <= j; i++) {
                presubscription.addResourcePathItem(i + "/" + (i + j) + "/" + j);
            }
            presubscription.endpointName(Math.random() >= 0.5 ? "*" : Math.random() >= 0.5 ? null : "" + j);
            presubscription.endpointType(Math.random() >= 0.5 ? "*" : null);
            array.add(presubscription);
        }
        return array;
    }

    @SuppressWarnings("boxing")
    @Test
    public void testNotifyNotificationMessageWithSubscriptionActions() {
        Future<?> handle = null;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        String[] payloads = { "MQ==", "Mg==", "Mw==", "NA==", "NQ==" };
        int numberOfPresubscriptions = 4;
        MockWebServer server = new MockWebServer();
        Gson gson = new Gson();
        PresubscriptionArray array = generatePresubscriptions(numberOfPresubscriptions);
        for (int i = 0; i < 10; i++) {
            server.enqueue(new MockResponse().setBody(gson.toJson(array)));
        }
        try {
            server.start();
        } catch (IOException exception) {
            exception.printStackTrace();
            fail(exception.getMessage());
        }
        HttpUrl baseUrl = server.url("");
        ConnectionOptions opt = new ConnectionOptions("apikey").host(baseUrl.toString()).logLevel(CallLogLevel.BODY);
        try (Connect connect = new Connect(opt);
             NotificationHandlersStore store = new NotificationHandlersStore(connect, null, executor, null)) {

            List<Integer> receivedNotificationsUsingCallbacks = new LinkedList<>();
            List<Throwable> receivedErrorsUsingCallbacks = new LinkedList<>();
            String deviceId = "015f4ac587f500000000000100100249";
            String resourcePath = "/3200/0/5501";
            Resource resource = new Resource(deviceId, resourcePath);
            store.registerSubscriptionCallback(resource, new Callback<Object>() {

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
            }, FirstValue.ON_REGISTRATION);

            // Expecting two calls to the the server. one for getting presubscription and one for updating the list
            assertEquals(2, server.getRequestCount());
            RecordedRequest request = server.takeRequest();
            assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());
            assertEquals("GET", request.getMethod());
            request = server.takeRequest();
            assertEquals("PUT", request.getMethod());
            assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());
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
                        store.notify(null);
                        store.notify(notifications);
                        i++;
                    }
                }
            }, 0, Interval, TimeUnit.MILLISECONDS);
            Thread.sleep((payloads.length + 1) * Interval);
            assertTrue(receivedErrorsUsingCallbacks.isEmpty());
            assertFalse(receivedNotificationsUsingCallbacks.isEmpty());
            for (int i = 0; i < payloads.length; i++) {
                assertEquals(i + 1, receivedNotificationsUsingCallbacks.get(i), 0);
            }

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        // Expecting one call to the server. one for getting the presubscription list. No update should be done
        // as the added presubscription was not persisted into the server (Mocking).
        RecordedRequest request = null;
        try {
            request = server.takeRequest();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
            fail(exception.getMessage());
        }
        assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());
        assertEquals("GET", request.getMethod());

        assertNotNull(handle);
        assertTrue(handle.isCancelled());
    }

    /**
     * Tests subscriptions to device state changes
     */
    @Test
    public void testDeviceState() {
        Future<?> handle = null;
        List<DeviceStateNotification> receivedNotifications = new LinkedList<>();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        try (NotificationHandlersStore store = new NotificationHandlersStore(null, null, executor, null)) {

            DeviceStateObserver obs1 = store.getSubscriptionManager()
                                            .deviceStateChanges(new DeviceStateFilterOptions().likeDevice("016%33e")
                                                                                              .equalDeviceState(DeviceState.REGISTRATION_UPDATE),
                                                                BackpressureStrategy.BUFFER);
            // Generating notifications
            @SuppressWarnings("boxing")
            List<NotificationMessage> notifications = Stream.iterate(0, n -> n + 1).limit(32).map(i -> {
                NotificationMessage message = new NotificationMessage();
                EndpointData data = new EndpointData();
                if (i % 5 == 0) {
                    data.setEp("0161661e9ce10000000000010010033e");
                } else {
                    data.setEp("0161661edbab000000000001001002b7");
                }
                data.setEpt("random");
                data.setQ(false);
                data.setResources(Stream.iterate(0, n -> n + 1).limit(50).map(v -> {
                    final ResourcesData resource = new ResourcesData();
                    resource.setPath("/" + v);
                    resource.setObs(true);
                    return resource;
                }).collect(Collectors.toList()));

                if (i % 2 == 0) {
                    message.addRegUpdatesItem(data);
                } else {
                    message.addRegistrationsItem(data);
                }
                return message;
            }).collect(Collectors.toList());

            obs1.addCallback(new NotificationCallback<>(new Callback<DeviceStateNotification>() {

                @Override
                public void execute(DeviceStateNotification arg) {
                    receivedNotifications.add(arg);
                }
            }, null));
            int Interval = 300;
            handle = executor.scheduleWithFixedDelay(new Runnable() {

                private int i = 0;

                @Override
                public void run() {
                    if (i < notifications.size()) {
                        store.notify(notifications.get(i));
                        i++;
                    }
                }
            }, 0, Interval, TimeUnit.MILLISECONDS);
            // Waiting for all notifications to be emitted
            Thread.sleep((notifications.size() + 1) * Interval);

            assertFalse(receivedNotifications.isEmpty());
            // Only multiples of 10 between 0 and 32
            assertEquals(4, receivedNotifications.size());
            // Observer only cares about changes related to devices like 016%33e and REGISTRATION_UPDATE state
            receivedNotifications.forEach(n -> {
                assertEquals("0161661e9ce10000000000010010033e", n.getDeviceId());
                assertEquals(DeviceState.REGISTRATION_UPDATE, n.getEvent());
            });
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        assertNotNull(handle);
        assertTrue(handle.isCancelled());
    }

    /**
     * Tests subscriptions to all notifications
     */
    @Test
    public void testAllNotifications() {
        Future<?> handle = null;
        List<AllNotifications> receivedNotifications = new LinkedList<>();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        try (NotificationHandlersStore store = new NotificationHandlersStore(null, null, executor, null)) {

            AllNotificationsObserver obs1 = store.getSubscriptionManager()
                                                 .allNotifications(BackpressureStrategy.BUFFER);
            int numberOfNotifications = 32;
            // Generating notifications
            @SuppressWarnings("boxing")
            List<NotificationMessage> notifications = Stream.iterate(0, n -> n + 1).limit(numberOfNotifications)
                                                            .map(i -> {
                                                                NotificationMessage message = new NotificationMessage();
                                                                EndpointData data = new EndpointData();
                                                                if (i % 5 == 0) {
                                                                    data.setEp("0161661e9ce10000000000010010033e");
                                                                } else {
                                                                    data.setEp("0161661edbab000000000001001002b7");
                                                                }
                                                                data.setEpt("random");
                                                                data.setQ(false);
                                                                data.setResources(Stream.iterate(0, n -> n + 1)
                                                                                        .limit(50).map(v -> {
                                                                                            final ResourcesData resource = new ResourcesData();
                                                                                            resource.setPath("/" + v);
                                                                                            resource.setObs(true);
                                                                                            return resource;
                                                                                        })
                                                                                        .collect(Collectors.toList()));

                                                                if (i % 2 == 0) {
                                                                    message.addRegUpdatesItem(data);
                                                                } else {
                                                                    message.addRegistrationsItem(data);
                                                                }
                                                                return message;
                                                            }).collect(Collectors.toList());

            obs1.addCallback(new NotificationCallback<>(new Callback<AllNotifications>() {

                @Override
                public void execute(AllNotifications arg) {
                    receivedNotifications.add(arg);
                }
            }, null));
            int Interval = 300;
            handle = executor.scheduleWithFixedDelay(new Runnable() {

                private int i = 0;

                @Override
                public void run() {
                    if (i < notifications.size()) {
                        store.notify(notifications.get(i));
                        i++;
                    }
                }
            }, 0, Interval, TimeUnit.MILLISECONDS);
            // Waiting for all notifications to be emitted
            Thread.sleep((notifications.size() + 1) * Interval);

            assertFalse(receivedNotifications.isEmpty());

            assertEquals(numberOfNotifications, receivedNotifications.size());
            receivedNotifications.forEach(n -> {
                assertTrue(n.hasDeviceStateNotifications());
                assertFalse(n.hasAsynchronousResponseNotifications());
                assertFalse(n.hasResourceValueNotifications());
            });
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        assertNotNull(handle);
        assertTrue(handle.isCancelled());
    }
}
