package com.arm.mbed.cloud.sdk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.CallLogLevel;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.connect.adapters.PresubscriptionAdapter;
import com.arm.mbed.cloud.sdk.connect.model.Presubscription;
import com.arm.mbed.cloud.sdk.internal.mds.model.PresubscriptionArray;
import com.google.gson.Gson;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

public class TestConnect {

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
            ConnectionOptions opt = new ConnectionOptions("apikey");
            opt.setHost(baseUrl.toString());
            // opt.setClientLogLevel(CallLogLevel.BODY);
            Connect connect = new Connect(opt);
            GenericAdapter.MappedObjectRegistry<Presubscription> registry = connect
                    .getCurrentPresubscriptionRegistry("method name");
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

            server.shutdown();
        } catch (IOException | InterruptedException | MbedCloudException e) {
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
            ConnectionOptions opt = new ConnectionOptions("apikey");
            opt.setHost(baseUrl.toString());
            // opt.setClientLogLevel(CallLogLevel.BODY);
            Connect connect = new Connect(opt);
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
            server.shutdown();
        } catch (IOException | InterruptedException | MbedCloudException e) {
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
            ConnectionOptions opt = new ConnectionOptions("apikey");
            opt.setHost(baseUrl.toString());
            // opt.setClientLogLevel(CallLogLevel.BODY);
            Connect connect = new Connect(opt);
            Presubscription aPresubscription = PresubscriptionAdapter.map(array.get(0));
            Presubscription receivedPresubscription = connect.getPresubscription(aPresubscription.getId());

            RecordedRequest request = server.takeRequest();
            assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());
            assertNotNull(receivedPresubscription);
            assertEquals(aPresubscription, receivedPresubscription);
            server.shutdown();
        } catch (IOException | InterruptedException | MbedCloudException e) {
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
            ConnectionOptions opt = new ConnectionOptions("apikey");
            opt.setHost(baseUrl.toString());
            // opt.setClientLogLevel(CallLogLevel.BODY);
            Connect connect = new Connect(opt);
            Presubscription aPresubscription = PresubscriptionAdapter.map(array.get(0));
            aPresubscription.setDeviceId("A new ID that cannot be in the list of presubscription");
            connect.deletePresubscription(aPresubscription);
            // Only one call should have been done to the server. No need to update the presubscriptions as the deleted
            // subscription was not initially present.
            assertEquals(1, server.getRequestCount());
            RecordedRequest request = server.takeRequest();
            assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());

            server.shutdown();
        } catch (IOException | InterruptedException | MbedCloudException e) {
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
            ConnectionOptions opt = new ConnectionOptions("apikey");
            opt.setHost(baseUrl.toString());
            // opt.setClientLogLevel(CallLogLevel.BODY);
            Connect connect = new Connect(opt);
            Presubscription aPresubscription = PresubscriptionAdapter.map(array.get(0));
            connect.deletePresubscription(aPresubscription);
            assertEquals(2, server.getRequestCount());
            RecordedRequest request = server.takeRequest();
            assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());

            server.shutdown();
        } catch (IOException | InterruptedException | MbedCloudException e) {
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
            ConnectionOptions opt = new ConnectionOptions("apikey");
            opt.setHost(baseUrl.toString());
            // opt.setClientLogLevel(CallLogLevel.BODY);
            Connect connect = new Connect(opt);
            Presubscription aPresubscription = PresubscriptionAdapter.map(array.get(0));
            connect.addPresubscription(aPresubscription);
            // Only one call should have been done to the server. No need to update the presubscriptions as the added
            // subscription was initially present in the set.
            assertEquals(1, server.getRequestCount());
            RecordedRequest request = server.takeRequest();
            assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());

            server.shutdown();
        } catch (IOException | InterruptedException | MbedCloudException e) {
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
            ConnectionOptions opt = new ConnectionOptions("apikey");
            opt.setHost(baseUrl.toString());
            // opt.setClientLogLevel(CallLogLevel.BODY);
            Connect connect = new Connect(opt);
            Presubscription aPresubscription = PresubscriptionAdapter.map(array.get(0));
            aPresubscription.setDeviceId("" + System.currentTimeMillis());
            connect.addPresubscription(aPresubscription);
            assertEquals(2, server.getRequestCount());
            RecordedRequest request = server.takeRequest();
            assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());

            server.shutdown();
        } catch (IOException | InterruptedException | MbedCloudException e) {
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
            ConnectionOptions opt = new ConnectionOptions("apikey");
            opt.setHost(baseUrl.toString());
            // opt.setClientLogLevel(CallLogLevel.BODY);
            Connect connect = new Connect(opt);
            List<Presubscription> somePresubscriptions = PresubscriptionAdapter.mapList(array);
            connect.addSomePresubscriptions(somePresubscriptions);
            // Only one call should have been done to the server. No need to update the presubscriptions as the added
            // subscriptions were initially present in the set.
            assertEquals(1, server.getRequestCount());
            RecordedRequest request = server.takeRequest();
            assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());

            server.shutdown();
        } catch (IOException | InterruptedException | MbedCloudException e) {
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
            ConnectionOptions opt = new ConnectionOptions("apikey");
            opt.setHost(baseUrl.toString());
            opt.setClientLogLevel(CallLogLevel.BODY);
            Connect connect = new Connect(opt);
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

            server.shutdown();
        } catch (IOException | InterruptedException | MbedCloudException e) {
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
            ConnectionOptions opt = new ConnectionOptions("apikey");
            opt.setHost(baseUrl.toString());
            // opt.setClientLogLevel(CallLogLevel.BODY);
            Connect connect = new Connect(opt);
            List<Presubscription> somePresubscriptions = PresubscriptionAdapter.mapList(array);
            connect.deleteSomePresubscriptions(somePresubscriptions);
            // Two calls should have been done to the server. One to get the presubscriptions and one to update the
            // list with removed presubscriptions.
            assertEquals(2, server.getRequestCount());
            RecordedRequest request = server.takeRequest();
            assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());

            server.shutdown();
        } catch (IOException | InterruptedException | MbedCloudException e) {
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
            ConnectionOptions opt = new ConnectionOptions("apikey");
            opt.setHost(baseUrl.toString());
            opt.setClientLogLevel(CallLogLevel.BODY);
            Connect connect = new Connect(opt);
            List<Presubscription> somePresubscriptions = PresubscriptionAdapter.mapList(array);
            // Change the device ids
            for (Presubscription pre : somePresubscriptions) {
                pre.setDeviceId("" + (Math.random() * System.nanoTime()));
            }
            connect.deleteSomePresubscriptions(somePresubscriptions);
            // Only one call should have been done to the server. No need to update the presubscriptions as the deleted
            // subscriptions were not present in the set.
            assertEquals(1, server.getRequestCount());
            RecordedRequest request = server.takeRequest();
            assertEquals("/" + PRESUBSCRIPTION_ENDPOINT_PATH, request.getPath());

            server.shutdown();
        } catch (IOException | InterruptedException | MbedCloudException e) {
            fail(e.getMessage());
        }
    }

    private static final String PRESUBSCRIPTION_ENDPOINT_PATH = "v2/subscriptions";

    private PresubscriptionArray generatePresubscriptions(int number) {
        PresubscriptionArray array = new PresubscriptionArray();
        for (int j = 0; j < number; j++) {
            com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription presubscription = new com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription();
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
