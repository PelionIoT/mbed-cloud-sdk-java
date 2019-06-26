package com.arm.mbed.cloud.sdk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.DeliveryMethod;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.connect.adapters.PresubscriptionAdapter;
import com.arm.mbed.cloud.sdk.connect.model.Presubscription;
import com.arm.mbed.cloud.sdk.connect.model.Webhook;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.PresubscriptionArray;
import com.google.gson.Gson;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

public class TestConnect {

    private static final int NUMBER_OF_CLEAR_CHANNEL_REQUEST = 3;
    private static final String WEBHOOK_ENDPOINT_PATH = "v2/notification/callback";
    private static final String PRESUBSCRIPTION_ENDPOINT_PATH = "v2/subscriptions";

    @Test
    public void testGetCurrentPresubscriptionRegistry() {
        try {
            int numberOfElements = 15;

            MockWebServer server = new MockWebServer();
            Gson gson = new Gson();
            PresubscriptionArray array = generatePresubscriptions(numberOfElements);
            server.enqueue(new MockResponse().setBody(gson.toJson(array)));
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = new ConnectionOptions("apikey").host(baseUrl.toString()).skipCleanup();

            // opt.setClientLogLevel(CallLogLevel.BODY);
            try (Connect connect = new Connect(opt)) {
                GenericAdapter.MappedObjectRegistry<Presubscription> registry = connect.getCurrentPresubscriptionRegistry("method name");
                RecordedRequest request = server.takeRequest();
                assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());
                assertNotNull(registry);
                assertFalse(registry.isEmpty());
                assertEquals(numberOfElements, registry.size());
                Presubscription aPresubscription = PresubscriptionAdapter.map(array.get(0));
                assertTrue(registry.contains(aPresubscription));
                registry.removeEntry(aPresubscription);
                assertFalse(registry.contains(aPresubscription));
                assertEquals(numberOfElements - 1, registry.size());
            } catch (MbedCloudException | InterruptedException exception) {
                fail(exception.getMessage());
            } finally {
                server.shutdown();
            }
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testListPresubscriptions() {
        try {
            int numberOfElements = 4;
            MockWebServer server = new MockWebServer();
            Gson gson = new Gson();
            PresubscriptionArray array = generatePresubscriptions(numberOfElements);
            server.enqueue(new MockResponse().setBody(gson.toJson(array)));
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = new ConnectionOptions("apikey").host(baseUrl.toString()).skipCleanup();

            // opt.setClientLogLevel(CallLogLevel.BODY);
            try (Connect connect = new Connect(opt)) {
                List<Presubscription> receivedList = connect.listPresubscriptions();
                List<Presubscription> sentList = PresubscriptionAdapter.mapList(array);

                RecordedRequest request = server.takeRequest();
                assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());
                assertNotNull(receivedList);
                assertFalse(receivedList.isEmpty());
                assertEquals(numberOfElements, receivedList.size());
                for (Presubscription aPresubscription : sentList) {
                    assertTrue(receivedList.contains(aPresubscription));
                }
            } catch (Exception exception) {
                fail(exception.getMessage());
            } finally {
                server.shutdown();
            }
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetPresubscription() {
        try {
            int numberOfElements = 4;
            MockWebServer server = new MockWebServer();
            Gson gson = new Gson();
            PresubscriptionArray array = generatePresubscriptions(numberOfElements);
            server.enqueue(new MockResponse().setBody(gson.toJson(array)));
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = new ConnectionOptions("apikey").host(baseUrl.toString()).skipCleanup();
            // opt.setClientLogLevel(CallLogLevel.BODY);
            try (Connect connect = new Connect(opt)) {
                Presubscription aPresubscription = PresubscriptionAdapter.map(array.get(0));
                Presubscription receivedPresubscription = connect.getPresubscription(aPresubscription.getId());

                RecordedRequest request = server.takeRequest();
                assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());
                assertNotNull(receivedPresubscription);
                assertEquals(aPresubscription, receivedPresubscription);
            } catch (Exception exception) {
                fail(exception.getMessage());
            } finally {
                server.shutdown();
            }
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testDeleteNewPresubscription() {
        try {
            int numberOfElements = 4;
            MockWebServer server = new MockWebServer();
            Gson gson = new Gson();
            PresubscriptionArray array = generatePresubscriptions(numberOfElements);
            server.enqueue(new MockResponse().setBody(gson.toJson(array)));
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = new ConnectionOptions("apikey").host(baseUrl.toString()).skipCleanup();
            // opt.setClientLogLevel(CallLogLevel.BODY);
            try (Connect connect = new Connect(opt)) {
                Presubscription aPresubscription = PresubscriptionAdapter.map(array.get(0));
                aPresubscription.setDeviceId("A new ID that cannot be in the list of presubscription");
                connect.deletePresubscription(aPresubscription);
                // Only one call should have been done to the server. No need to update the presubscriptions as the
                // deleted
                // subscription was not initially present.
                assertEquals(1, server.getRequestCount());
                RecordedRequest request = server.takeRequest();
                assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());
            } catch (Exception exception) {
                fail(exception.getMessage());
            } finally {
                server.shutdown();
            }
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testDeleteExistingPresubscription() {
        try {
            int numberOfElements = 4;
            MockWebServer server = new MockWebServer();
            Gson gson = new Gson();
            PresubscriptionArray array = generatePresubscriptions(numberOfElements);
            server.enqueue(new MockResponse().setBody(gson.toJson(array)));
            server.enqueue(new MockResponse());
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = new ConnectionOptions("apikey").host(baseUrl.toString()).skipCleanup();
            // opt.setClientLogLevel(CallLogLevel.BODY);
            try (Connect connect = new Connect(opt)) {
                Presubscription aPresubscription = PresubscriptionAdapter.map(array.get(0));
                connect.deletePresubscription(aPresubscription);
                assertEquals(2, server.getRequestCount());
                RecordedRequest request = server.takeRequest();
                assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());
            } catch (Exception exception) {
                fail(exception.getMessage());
            } finally {
                server.shutdown();
            }
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAddAlreadyExistingPresubscription() {
        try {
            int numberOfElements = 4;
            MockWebServer server = new MockWebServer();
            Gson gson = new Gson();
            PresubscriptionArray array = generatePresubscriptions(numberOfElements);
            server.enqueue(new MockResponse().setBody(gson.toJson(array)));
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = new ConnectionOptions("apikey").host(baseUrl.toString()).skipCleanup();
            // opt.setClientLogLevel(CallLogLevel.BODY);
            try (Connect connect = new Connect(opt)) {
                Presubscription aPresubscription = PresubscriptionAdapter.map(array.get(0));
                connect.addPresubscription(aPresubscription);
                // Only one call should have been done to the server. No need to update the presubscriptions as the
                // added
                // subscription was initially present in the set.
                assertEquals(1, server.getRequestCount());
                RecordedRequest request = server.takeRequest();
                assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());

            } catch (Exception exception) {
                fail(exception.getMessage());
            } finally {
                server.shutdown();
            }
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAddAlreadyNewPresubscription() {
        try {
            int numberOfElements = 4;
            MockWebServer server = new MockWebServer();
            Gson gson = new Gson();
            PresubscriptionArray array = generatePresubscriptions(numberOfElements);
            server.enqueue(new MockResponse().setBody(gson.toJson(array)));
            server.enqueue(new MockResponse());
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = new ConnectionOptions("apikey").host(baseUrl.toString()).skipCleanup();
            // opt.setClientLogLevel(CallLogLevel.BODY);
            try (Connect connect = new Connect(opt)) {
                Presubscription aPresubscription = PresubscriptionAdapter.map(array.get(0));
                aPresubscription.setDeviceId("" + System.currentTimeMillis());
                connect.addPresubscription(aPresubscription);
                assertEquals(2, server.getRequestCount());
                RecordedRequest request = server.takeRequest();
                assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());

            } catch (Exception exception) {
                fail(exception.getMessage());
            } finally {
                server.shutdown();
            }
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAddSomeAlreadyDefinedPresubscriptions() {
        try {
            int numberOfElements = 4;
            MockWebServer server = new MockWebServer();
            Gson gson = new Gson();
            PresubscriptionArray array = generatePresubscriptions(numberOfElements);
            server.enqueue(new MockResponse().setBody(gson.toJson(array)));
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = new ConnectionOptions("apikey").host(baseUrl.toString()).skipCleanup();
            // opt.setClientLogLevel(CallLogLevel.BODY);
            try (Connect connect = new Connect(opt)) {
                List<Presubscription> somePresubscriptions = PresubscriptionAdapter.mapList(array);
                connect.addSomePresubscriptions(somePresubscriptions);
                // Only one call should have been done to the server. No need to update the presubscriptions as the
                // added
                // subscriptions were initially present in the set.
                assertEquals(1, server.getRequestCount());
                RecordedRequest request = server.takeRequest();
                assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());
            } catch (Exception exception) {
                fail(exception.getMessage());
            } finally {
                server.shutdown();
            }
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAddSomeNewPresubscriptions() {
        try {
            int numberOfElements = 4;
            MockWebServer server = new MockWebServer();
            Gson gson = new Gson();
            PresubscriptionArray array = generatePresubscriptions(numberOfElements);
            server.enqueue(new MockResponse().setBody(gson.toJson(array)));
            server.enqueue(new MockResponse());
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = new ConnectionOptions("apikey").host(baseUrl.toString()).skipCleanup();

            // opt.setClientLogLevel(CallLogLevel.BODY);
            try (Connect connect = new Connect(opt)) {
                List<Presubscription> somePresubscriptions = PresubscriptionAdapter.mapList(array);
                // Change the device ids
                for (Presubscription pre : somePresubscriptions) {
                    pre.setDeviceId("" + (Math.random() * System.nanoTime()));
                }
                connect.addSomePresubscriptions(somePresubscriptions);
                // Two calls should have been done to the server. One to get the presubscriptions and one to update the
                // list.
                assertEquals(2, server.getRequestCount());
                RecordedRequest request = server.takeRequest();
                assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());
            } catch (Exception exception) {
                fail(exception.getMessage());
            } finally {
                server.shutdown();
            }
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testDeleteSomeAlreadyDefinedPresubscriptions() {
        try {
            int numberOfElements = 4;
            MockWebServer server = new MockWebServer();
            Gson gson = new Gson();
            PresubscriptionArray array = generatePresubscriptions(numberOfElements);
            server.enqueue(new MockResponse().setBody(gson.toJson(array)));
            server.enqueue(new MockResponse());
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = new ConnectionOptions("apikey").host(baseUrl.toString()).skipCleanup();
            // opt.setClientLogLevel(CallLogLevel.BODY);
            try (Connect connect = new Connect(opt)) {
                List<Presubscription> somePresubscriptions = PresubscriptionAdapter.mapList(array);
                connect.deleteSomePresubscriptions(somePresubscriptions);
                // Two calls should have been done to the server. One to get the presubscriptions and one to update the
                // list with removed presubscriptions.
                assertEquals(2, server.getRequestCount());
                RecordedRequest request = server.takeRequest();
                assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());
            } catch (Exception exception) {
                fail(exception.getMessage());
            } finally {
                server.shutdown();
            }
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testDeleteSomeNewPresubscriptions() {
        try {
            int numberOfElements = 4;
            MockWebServer server = new MockWebServer();
            Gson gson = new Gson();
            PresubscriptionArray array = generatePresubscriptions(numberOfElements);
            server.enqueue(new MockResponse().setBody(gson.toJson(array)));
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = new ConnectionOptions("apikey").host(baseUrl.toString()).skipCleanup();

            // opt.setClientLogLevel(CallLogLevel.BODY);
            try (Connect connect = new Connect(opt)) {
                List<Presubscription> somePresubscriptions = PresubscriptionAdapter.mapList(array);
                // Change the device ids
                for (Presubscription pre : somePresubscriptions) {
                    pre.setDeviceId("" + (Math.random() * System.nanoTime()));
                }
                connect.deleteSomePresubscriptions(somePresubscriptions);
                // Only one call should have been done to the server. No need to update the presubscriptions as the
                // deleted
                // subscriptions were not present in the set.
                assertEquals(1, server.getRequestCount());
                RecordedRequest request = server.takeRequest();
                assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());
            } catch (MbedCloudException e1) {
                fail(e1.getMessage());
            } finally {
                server.shutdown();
            }
        } catch (IOException | InterruptedException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testStopNotifications() {
        try {
            // In normal mode a cleanup should happen on exit.
            int numberOfClearChannelRequest = NUMBER_OF_CLEAR_CHANNEL_REQUEST;
            MockWebServer server = new MockWebServer();
            for (int i = 0; i < numberOfClearChannelRequest; i++) {
                server.enqueue(new MockResponse().setResponseCode(202));
            }
            server.enqueue(new MockResponse());
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = new ConnectionOptions("apikey").host(baseUrl.toString());
            // opt.setClientLogLevel(CallLogLevel.BODY);
            try (Connect connect = new Connect(opt)) {
                // Nothing to do
            }
            assertEquals(numberOfClearChannelRequest + 1, server.getRequestCount());
            for (int i = 0; i < numberOfClearChannelRequest; i++) {
                RecordedRequest request = server.takeRequest();
                assertEquals("DELETE", request.getMethod());
            }
            // Expected a delete pre-subscriptions on exit
            RecordedRequest request = server.takeRequest();
            assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());

            // When skipCleanup mode is set, no clean-up action should take place on exit
            try (Connect connect = new Connect(opt.clone().skipCleanup())) {
                // Nothing to do
            }
            assertEquals(numberOfClearChannelRequest + 1, server.getRequestCount());

            server.shutdown();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testAutoStartNotifications() {
        try {
            MockWebServer server = new MockWebServer();
            server.enqueue(new MockResponse());
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = ConnectionOptions.newConfiguration("apikey", baseUrl.toString()).skipCleanup();
            try (Connect connect = new Connect(opt)) {
                assertEquals(DeliveryMethod.UNDEFINED, connect.deliveryMethod.get());
                connect.autostartDaemonIfNeeded();
                RecordedRequest request = server.takeRequest();
                assertEquals("GET", request.getMethod());
                assertEquals("/" + WEBHOOK_ENDPOINT_PATH, request.getPath());
                assertEquals(DeliveryMethod.CLIENT_INITIATED, connect.deliveryMethod.get());
                assertTrue(connect.handlersStore.isNotificationListenerActive());
                connect.stopNotifications();
                connect.stopNotifications();
                assertFalse(connect.handlersStore.isNotificationListenerActive());
            } catch (MbedCloudException | InterruptedException exception) {
                exception.printStackTrace();
                fail(exception.getMessage());
            }
            server.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStartNotifications() {
        try {
            MockWebServer server = new MockWebServer();
            server.enqueue(new MockResponse());
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = ConnectionOptions.newConfiguration("apikey", baseUrl.toString()).skipCleanup();
            try (Connect connect = new Connect(opt)) {
                assertEquals(DeliveryMethod.UNDEFINED, connect.deliveryMethod.get());
                connect.startNotifications();
                connect.startNotifications();
                RecordedRequest request = server.takeRequest();
                assertEquals("GET", request.getMethod());
                assertEquals("/" + WEBHOOK_ENDPOINT_PATH, request.getPath());
                assertEquals(DeliveryMethod.CLIENT_INITIATED, connect.deliveryMethod.get());
                assertTrue(connect.handlersStore.isNotificationListenerActive());
                connect.stopNotifications();
                assertFalse(connect.handlersStore.isNotificationListenerActive());
            } catch (MbedCloudException | InterruptedException exception) {
                exception.printStackTrace();
                fail(exception.getMessage());
            }
            server.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStartNotificationsAndForceClear() {
        try {
            MockWebServer server = new MockWebServer();
            int numberOfClearChannelRequest = NUMBER_OF_CLEAR_CHANNEL_REQUEST;
            for (int i = 0; i < numberOfClearChannelRequest; i++) {
                server.enqueue(new MockResponse().setResponseCode(202));
            }
            server.enqueue(new MockResponse());
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = ConnectionOptions.newConfiguration("apikey", baseUrl.toString()).skipCleanup()
                                                     .forceClear();
            try (Connect connect = new Connect(opt)) {
                assertEquals(DeliveryMethod.UNDEFINED, connect.deliveryMethod.get());
                connect.startNotifications();
                connect.startNotifications();
                RecordedRequest request = null;
                for (int i = 0; i < numberOfClearChannelRequest; i++) {
                    request = server.takeRequest();
                    assertEquals("DELETE", request.getMethod());
                }
                request = server.takeRequest();
                assertEquals("GET", request.getMethod());
                assertEquals("/" + WEBHOOK_ENDPOINT_PATH, request.getPath());
                assertEquals(DeliveryMethod.CLIENT_INITIATED, connect.deliveryMethod.get());
                assertTrue(connect.handlersStore.isNotificationListenerActive());
                connect.stopNotifications();
                assertFalse(connect.handlersStore.isNotificationListenerActive());
            } catch (MbedCloudException exception) {
                exception.printStackTrace();
                fail(exception.getMessage());
            }
            server.shutdown();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testStartNotificationWithWebhookInPlace() {
        try {
            MockWebServer server = new MockWebServer();
            Gson gson = new Gson();
            Webhook webhook = generateAWebHook();
            server.enqueue(new MockResponse().setBody(gson.toJson(webhook)));
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = ConnectionOptions.newConfiguration("apikey", baseUrl.toString()).skipCleanup();
            try (Connect connect = new Connect(opt)) {
                assertEquals(DeliveryMethod.UNDEFINED, connect.deliveryMethod.get());
                connect.startNotifications();
                fail("An exception should have been raised");
            } catch (MbedCloudException exception) {
                exception.printStackTrace();
                RecordedRequest request = server.takeRequest();
                assertEquals("GET", request.getMethod());
                assertEquals("/" + WEBHOOK_ENDPOINT_PATH, request.getPath());
            }
            server.shutdown();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testStartNotificationWithServerInitiatedInstance() {
        try {
            MockWebServer server = new MockWebServer();
            Gson gson = new Gson();
            Webhook webhook = generateAWebHook();
            server.enqueue(new MockResponse().setBody(gson.toJson(webhook)));
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = ConnectionOptions.newConfiguration("apikey", baseUrl.toString())
                                                     .autostartDaemon(false).skipCleanup();
            try (Connect connect = new Connect(opt)) {
                assertEquals(DeliveryMethod.UNDEFINED, connect.deliveryMethod.get());
                connect.updateWebhook(webhook);
                assertEquals(DeliveryMethod.SERVER_INITIATED, connect.deliveryMethod.get());
                connect.clone().startNotifications();
                fail("An exception should have been raised");
            } catch (MbedCloudException exception) {
                exception.printStackTrace();
            }
            server.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testWebhookSameUrl() {
        try {
            MockWebServer server = new MockWebServer();
            Gson gson = new Gson();
            Webhook webhook = generateAWebHook();
            server.enqueue(new MockResponse().setBody(gson.toJson(webhook)));
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = new ConnectionOptions("apikey").host(baseUrl.toString()).autostartDaemon(false)
                                                                   .skipCleanup();
            // opt.setClientLogLevel(CallLogLevel.BODY);
            try (Connect connect = new Connect(opt)) {
                connect.updateWebhook(webhook.clone());
                assertEquals(1, server.getRequestCount());
                RecordedRequest request = server.takeRequest();
                assertEquals("GET", request.getMethod());
            } catch (MbedCloudException exception) {
                exception.printStackTrace();
                fail(exception.getMessage());
            } finally {
                server.shutdown();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testWebhookSameUrlWithAutostartMode() {
        try {
            MockWebServer server = new MockWebServer();
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = new ConnectionOptions("apikey").host(baseUrl.toString()).skipCleanup();

            // opt.setClientLogLevel(CallLogLevel.BODY);
            try (Connect connect = new Connect(opt)) {
                Webhook webhook = new Webhook(new URL("http://somefakewebhook.com"), null);
                connect.updateWebhook(webhook);
                fail("An exception should have been raised");
            } catch (MbedCloudException exception) {
                exception.printStackTrace();
            } finally {
                server.shutdown();
            }
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testWebhookWithDifferentUrl() {
        try {
            MockWebServer server = new MockWebServer();
            Gson gson = new Gson();
            Webhook webhook = generateAWebHook();
            server.enqueue(new MockResponse().setBody(gson.toJson(webhook)));
            server.enqueue(new MockResponse());
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = new ConnectionOptions("apikey").host(baseUrl.toString()).autostartDaemon(false)
                                                                   .skipCleanup();
            // opt.setClientLogLevel(CallLogLevel.BODY);
            try (Connect connect = new Connect(opt)) {
                Webhook newWebhook = webhook.clone();
                newWebhook.getHeaders().put("HEADER3", "value3");
                connect.updateWebhook(newWebhook);
                assertEquals(2, server.getRequestCount());
                RecordedRequest request = server.takeRequest();
                assertEquals("GET", request.getMethod());
                assertEquals("/" + WEBHOOK_ENDPOINT_PATH, request.getPath());
                request = server.takeRequest();
                assertEquals("PUT", request.getMethod());
                assertEquals("/" + WEBHOOK_ENDPOINT_PATH, request.getPath());
            } catch (MbedCloudException exception) {
                exception.printStackTrace();
                fail(exception.getMessage());
            } finally {
                server.shutdown();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testWebhookWithDifferentUrlAndForceClear() {
        try {
            MockWebServer server = new MockWebServer();
            Gson gson = new Gson();
            Webhook webhook = generateAWebHook();
            server.enqueue(new MockResponse().setBody(gson.toJson(webhook)));
            int numberOfClearChannelRequest = NUMBER_OF_CLEAR_CHANNEL_REQUEST;
            for (int i = 0; i < numberOfClearChannelRequest; i++) {
                server.enqueue(new MockResponse().setResponseCode(202));
            }
            server.enqueue(new MockResponse());
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions opt = new ConnectionOptions("apikey").host(baseUrl.toString()).autostartDaemon(false)
                                                                   .forceClear().skipCleanup();
            // opt.setClientLogLevel(CallLogLevel.BODY);
            try (Connect connect = new Connect(opt)) {
                Webhook newWebhook = webhook.clone();
                newWebhook.getHeaders().put("HEADER3", "value3");
                connect.updateWebhook(newWebhook);
                assertEquals(2 + numberOfClearChannelRequest, server.getRequestCount());
                RecordedRequest request = server.takeRequest();
                assertEquals("GET", request.getMethod());
                assertEquals("/" + WEBHOOK_ENDPOINT_PATH, request.getPath());
                for (int i = 0; i < numberOfClearChannelRequest; i++) {
                    request = server.takeRequest();
                    assertEquals("DELETE", request.getMethod());
                }
                request = server.takeRequest();
                assertEquals("PUT", request.getMethod());
                assertEquals("/" + WEBHOOK_ENDPOINT_PATH, request.getPath());
            } catch (MbedCloudException exception) {
                exception.printStackTrace();
                fail(exception.getMessage());
            } finally {
                server.shutdown();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    private Webhook generateAWebHook() throws MalformedURLException {
        Map<String, String> headers = new HashMap<>(2);
        headers.put("HEADER1", "value1");
        headers.put("HEADER2", "value2");
        Webhook webhook = new Webhook(new URL("http://somefakewebhook.com"), headers);
        return webhook;
    }

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

}
