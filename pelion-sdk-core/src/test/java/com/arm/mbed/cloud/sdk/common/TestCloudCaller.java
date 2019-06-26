package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.CloudCaller.CloudResponse;
import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.Error.Field;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import retrofit2.Call;
import retrofit2.http.GET;

public class TestCloudCaller {

    private static final String TEST_ENDPOINT_PATH = "a_rest_api_endpoint_of_some_sort";

    @Test
    public void testErrorJsonConverter() {
        String errorBody = "{\"fields\": [{\"name\": \"policy\",\"message\": \"Access denied by policy [PSK agreement].\"}],\"object\": \"error\",\"code\": 403,\"type\": \"access_denied\",\"message\": \"Not authorized to execute the request.\",\"request_id\": \"01626653c64b0242ac12000700000000\" }";
        Error error = CloudCaller.ErrorJsonConverter.INSTANCE.convert(errorBody);
        assertNotNull(error);
        assertEquals(403, error.getCode());
        assertEquals("error", error.getObject());
        assertEquals("access_denied", error.getType());
        assertFalse(error.getMessage().isEmpty());
        assertNotNull(error.getFields());
        assertEquals(1, error.getFields().size());
        Field field = error.getFields().get(0);
        assertEquals("policy", field.getName());
        assertNotNull(field.getMessage());
        assertEquals("01626653c64b0242ac12000700000000", error.getRequestId());
    }

    /**
     * Testing that error message parsing works in all cases.
     */
    @Test
    public void testRetrieveErrorDetails() {
        try {
            MockWebServer server = new MockWebServer();
            String requestID = "adfafasgdfgfdsgsdfg";
            String errorBody1 = "{\"fields\": [{\"name\": \"policy\",\"message\": \"Access denied by policy [PSK agreement].\"}],\"object\": \"error\",\"code\": 403,\"type\": \"access_denied\",\"message\": \"Not authorized to execute the request.\",\"request_id\": \"01626653c64b0242ac12000700000000\" }";
            String errorBody2 = "MALFORMED_JSON_CONTENT";
            server.enqueue(new MockResponse().setBody(errorBody1).setResponseCode(403));
            server.enqueue(new MockResponse().setBody(errorBody2).setResponseCode(403)
                                             .setStatus("HTTP/1.1 403 Bad Request")
                                             .addHeader(CloudCaller.REQUEST_ID_HEADER, requestID));
            server.enqueue(new MockResponse().setBody(errorBody2).setResponseCode(403)
                                             .setStatus("HTTP/1.1 403 Bad Request"));

            server.start();
            HttpUrl baseUrl = server.url("");

            TestApiService testService = createTestApiClient(baseUrl.toString());
            // First request
            retrofit2.Response<String> receivedResponse = testService.getEndpointValue().execute();
            assertFalse(receivedResponse.isSuccessful());
            Error error = CloudCaller.retrieveErrorDetails(CloudCaller.retrieveErrorMessageFromBody(new CloudResponse<>(receivedResponse,
                                                                                                                        null)),
                                                           receivedResponse);
            assertNotNull(error);
            assertEquals(403, error.getCode());
            assertEquals("error", error.getObject());
            assertEquals("access_denied", error.getType());
            assertFalse(error.getMessage().isEmpty());
            assertNotNull(error.getFields());
            assertEquals(1, error.getFields().size());
            Field field = error.getFields().get(0);
            assertEquals("policy", field.getName());
            assertNotNull(field.getMessage());
            assertEquals("01626653c64b0242ac12000700000000", error.getRequestId());
            // Second request
            receivedResponse = testService.getEndpointValue().execute();
            assertFalse(receivedResponse.isSuccessful());
            error = CloudCaller.retrieveErrorDetails(CloudCaller.retrieveErrorMessageFromBody(new CloudResponse<>(receivedResponse,
                                                                                                                  null)),
                                                     receivedResponse);
            assertNotNull(error);
            assertEquals(403, error.getCode());
            assertEquals("error", error.getObject());
            assertFalse(error.getMessage().isEmpty());
            assertEquals("Bad Request: MALFORMED_JSON_CONTENT", error.getMessage());
            assertNull(error.getFields());
            assertEquals(requestID, error.getRequestId());
            // Third request
            receivedResponse = testService.getEndpointValue().execute();
            assertFalse(receivedResponse.isSuccessful());
            error = CloudCaller.retrieveErrorDetails(CloudCaller.retrieveErrorMessageFromBody(new CloudResponse<>(receivedResponse,
                                                                                                                  null)),
                                                     receivedResponse);
            RecordedRequest request = server.takeRequest();
            assertNotNull(error);
            assertEquals(403, error.getCode());
            assertEquals("error", error.getObject());
            assertFalse(error.getMessage().isEmpty());
            assertEquals("Bad Request: MALFORMED_JSON_CONTENT", error.getMessage());
            assertNull(error.getFields());
            assertNotNull(error.getRequestId());
            assertTrue(error.getRequestId().contains(request.getPath()));
            server.shutdown();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    /**
     * Testing that calls to Pelion Cloud are carried out as expected.
     */
    @Test
    public void testCloudCaller() {
        try {
            MockWebServer server = new MockWebServer();
            String requestID = "01626653c64b0242ac12000700000000";
            String bodyEtag = "2018-04-13T14:18:56.862996Z";
            String errorBody1 = "{\"fields\": [{\"name\": \"policy\",\"message\": \"Access denied by policy [PSK agreement].\"}],\"object\": \"error\",\"code\": 403,\"type\": \"access_denied\",\"message\": \"Not authorized to execute the request.\",\"request_id\": \""
                                + requestID + "\" }";
            String correctBody = "This request was a success";
            String correctBody2 = "{\"color\": \"black\",\"category\": \"hue\",\"type\": \"primary\",\"rgba\": [255,255,255,1],\"hex\": \"#000\", \"etag\": \""
                                  + bodyEtag + "\"}";
            String errorBody2 = "{\"object\": \"error\",\"code\": 404,\"type\": \"not_found\",\"message\": \"Not Found.\",\"request_id\": \"01626653c64b0242ac12dass000700000000\" }";
            server.enqueue(new MockResponse().setBody(errorBody1).setResponseCode(403)
                                             .setStatus("HTTP/1.1 403 Bad Request"));
            server.enqueue(new MockResponse().setBody(correctBody).setResponseCode(200)
                                             .addHeader(CloudCaller.DATE_HEADER_LOWERCASE,
                                                        "Tue, 17 Apr 2018 11:08:42 GMT")
                                             .addHeader(CloudCaller.REQUEST_ID_HEADER_LOWERCASE, requestID));
            server.enqueue(new MockResponse().setBody(correctBody2).setResponseCode(200)
                                             .addHeader(CloudCaller.DATE_HEADER_LOWERCASE,
                                                        "Tue, 13 Apr 2018 11:08:42 GMT")
                                             .addHeader(CloudCaller.REQUEST_ID_HEADER_LOWERCASE, requestID));
            server.enqueue(new MockResponse().setBody(errorBody2).setResponseCode(404)
                                             .setStatus("HTTP/1.1 404 Not Found")
                                             .addHeader(CloudCaller.REQUEST_ID_HEADER, requestID)
                                             .addHeader(CloudCaller.DATE_HEADER, "Tue, 17 Apr 2018 11:08:42 GMT"));
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions config = new ConnectionOptions("test", baseUrl.toString());
            TestApi api = new TestApi(config);
            // First call - error response
            try {
                api.callTest();
                fail("An error should have been reported");
            } catch (MbedCloudException e) {
                assertNotNull(e.getMessage());
                assertTrue(e.getMessage().contains(TestApi.CALL_TEST_METHOD_NAME));
                ApiMetadata metadata = api.getLastApiMetadata();
                assertNotNull(metadata);
                assertNotNull(metadata.getUrl());
                assertTrue(metadata.getUrl().toString().contains(TEST_ENDPOINT_PATH));
                assertEquals("GET", metadata.getMethod());
                assertEquals(403, metadata.getStatusCode());
                assertNotNull(metadata.getDate());
                assertNotNull(metadata.getObject());
                assertEquals(requestID, metadata.getRequestId());
                assertNotNull(metadata.getErrorMessage());

            } finally {
                api.close();
            }
            // Second call - valid response
            try {
                assertEquals(correctBody, api.callTest());
                ApiMetadata metadata = api.getLastApiMetadata();
                assertNotNull(metadata);
                assertNotNull(metadata.getUrl());
                assertTrue(metadata.getUrl().toString().contains(TEST_ENDPOINT_PATH));
                assertEquals("GET", metadata.getMethod());
                assertEquals(200, metadata.getStatusCode());
                assertNotNull(metadata.getDate());
                Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                calendar.set(2018, 3, 17, 11, 8, 42);
                assertEquals(0, (calendar.getTime().getTime() - metadata.getDate().getTime()) / 1000);
                assertNotNull(metadata.getObject());
                assertEquals(requestID, metadata.getRequestId());
                assertNull(metadata.getErrorMessage());
            } catch (MbedCloudException e) {
                fail(e.getMessage());
            }
            // Third call - valid response
            try {
                BodyTest body = api.bodyCallTest();
                assertNotNull(body);
                ApiMetadata metadata = api.getLastApiMetadata();
                assertNotNull(metadata);
                assertNotNull(metadata.getUrl());
                assertTrue(metadata.getUrl().toString().contains(TEST_ENDPOINT_PATH));
                assertEquals("GET", metadata.getMethod());
                assertEquals(200, metadata.getStatusCode());
                assertNotNull(metadata.getDate());
                Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                calendar.set(2018, 3, 13, 11, 8, 42);
                assertEquals(0, (calendar.getTime().getTime() - metadata.getDate().getTime()) / 1000);
                assertEquals(requestID, metadata.getRequestId());
                assertEquals(bodyEtag, metadata.getEtag());
                assertNull(metadata.getErrorMessage());
            } catch (MbedCloudException e) {
                fail(e.getMessage());
            }
            // Fourth call - not found response
            try {
                assertEquals(null, api.callTest());
                ApiMetadata metadata = api.getLastApiMetadata();
                assertNotNull(metadata);
                assertNotNull(metadata.getUrl());
                assertTrue(metadata.getUrl().toString().contains(TEST_ENDPOINT_PATH));
                assertEquals("GET", metadata.getMethod());
                assertEquals(404, metadata.getStatusCode());
                assertNotNull(metadata.getDate());
                Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                calendar.set(2018, 3, 17, 11, 8, 42);
                assertEquals(0, (calendar.getTime().getTime() - metadata.getDate().getTime()) / 1000);
                assertNotNull(metadata.getObject());
                assertEquals(requestID, metadata.getRequestId());
                assertNotNull(metadata.getErrorMessage());
            } catch (MbedCloudException e) {
                fail(e.getMessage());
            }

            server.shutdown();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testing raw calls.
     */
    @Test
    public void testRawCloudCaller() {
        try {
            MockWebServer server = new MockWebServer();
            String requestID = "01626653c64b0242ac12000700000000";
            String etag = "6423d6bf35fcaff4388bf676e6f24500";

            String errorBody1 = "{\"fields\": [{\"name\": \"policy\",\"message\": \"Access denied by policy [PSK agreement].\"}],\"object\": \"error\",\"code\": 403,\"type\": \"access_denied\",\"message\": \"Not authorized to execute the request.\",\"request_id\": \""
                                + requestID + "\" }";
            String correctBody = "{\"color\": \"black\",\"category\": \"hue\",\"type\": \"primary\",\"code\": {\"rgba\": [255,255,255,1],\"hex\": \"#000\"}";

            String errorBody2 = "{\"object\": \"error\",\"code\": 404,\"type\": \"not_found\",\"message\": \"Not Found.\",\"request_id\": \"01626653c64b0242ac12dass000700000000\" }";
            server.enqueue(new MockResponse().setBody(errorBody1).setResponseCode(403)
                                             .setStatus("HTTP/1.1 403 Bad Request"));
            server.enqueue(new MockResponse().setBody(correctBody).setResponseCode(200)
                                             .addHeader(CloudCaller.DATE_HEADER_LOWERCASE,
                                                        "Tue, 17 Apr 2018 11:08:42 GMT")
                                             .addHeader(CloudCaller.REQUEST_ID_HEADER_LOWERCASE, requestID)
                                             .addHeader(CloudCaller.ETAG_HEADER, etag));
            server.enqueue(new MockResponse().setBody(errorBody2).setResponseCode(404)
                                             .setStatus("HTTP/1.1 404 Not Found")
                                             .addHeader(CloudCaller.REQUEST_ID_HEADER, requestID)
                                             .addHeader(CloudCaller.DATE_HEADER, "Tue, 17 Apr 2018 11:08:42 GMT"));
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions config = new ConnectionOptions("test", baseUrl.toString());
            TestApi api = new TestApi(config);
            // First call - error response
            try {
                api.rawCallTest();
                fail("An error should have been reported");
            } catch (MbedCloudException e) {
                assertNotNull(e.getMessage());
                assertTrue(e.getMessage().contains(TestApi.CALL_TEST_METHOD_NAME));
                ApiMetadata metadata = api.getLastApiMetadata();
                assertNotNull(metadata);
                assertNotNull(metadata.getUrl());
                assertTrue(metadata.getUrl().toString().contains(TEST_ENDPOINT_PATH));
                assertEquals("GET", metadata.getMethod());
                assertEquals(403, metadata.getStatusCode());
                assertNotNull(metadata.getDate());
                assertNotNull(metadata.getObject());
                assertEquals(requestID, metadata.getRequestId());
                assertNotNull(metadata.getErrorMessage());
            } finally {
                api.close();
            }
            // Second call - valid response
            try {
                assertEquals(correctBody, api.rawCallTest());
                ApiMetadata metadata = api.getLastApiMetadata();
                assertNotNull(metadata);
                assertNotNull(metadata.getUrl());
                assertTrue(metadata.getUrl().toString().contains(TEST_ENDPOINT_PATH));
                assertEquals("GET", metadata.getMethod());
                assertEquals(200, metadata.getStatusCode());
                assertNotNull(metadata.getDate());
                Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                calendar.set(2018, 3, 17, 11, 8, 42);
                assertEquals(0, (calendar.getTime().getTime() - metadata.getDate().getTime()) / 1000);
                assertEquals(requestID, metadata.getRequestId());
                assertEquals(etag, metadata.getEtag());
                assertNull(metadata.getErrorMessage());
            } catch (MbedCloudException e) {
                fail(e.getMessage());
            }

            // Third call - not found response
            try {
                assertEquals(null, api.rawCallTest());
                ApiMetadata metadata = api.getLastApiMetadata();
                assertNotNull(metadata);
                assertNotNull(metadata.getUrl());
                assertTrue(metadata.getUrl().toString().contains(TEST_ENDPOINT_PATH));
                assertEquals("GET", metadata.getMethod());
                assertEquals(404, metadata.getStatusCode());
                assertNotNull(metadata.getDate());
                Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                calendar.set(2018, 3, 17, 11, 8, 42);
                assertEquals(0, (calendar.getTime().getTime() - metadata.getDate().getTime()) / 1000);
                assertNotNull(metadata.getObject());
                assertEquals(requestID, metadata.getRequestId());
                assertNotNull(metadata.getErrorMessage());
            } catch (MbedCloudException e) {
                fail(e.getMessage());
            }

            server.shutdown();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testing raw calls.
     */
    @Test
    public void testCloudCallerWithRetries() {
        try {
            MockWebServer server = new MockWebServer();
            String requestID = "01626653c64b0242ac12000700000000";
            String bodyEtag = "2018-04-13T14:18:56.862996Z";
            String errorBody1 = "{\"fields\": [{\"name\": \"policy\",\"message\": \"Access denied by policy [PSK agreement].\"}],\"object\": \"error\",\"code\": 403,\"type\": \"access_denied\",\"message\": \"Not authorized to execute the request.\",\"request_id\": \""
                                + requestID + "\" }";
            String correctBody = "This request was a success";
            String correctBody2 = "{\"color\": \"black\",\"category\": \"hue\",\"type\": \"primary\",\"rgba\": [255,255,255,1],\"hex\": \"#000\", \"etag\": \""
                                  + bodyEtag + "\"}";
            String errorBody2 = "{\"object\": \"error\",\"code\": 404,\"type\": \"not_found\",\"message\": \"Not Found.\",\"request_id\": \"01626653c64b0242ac12dass000700000000\" }";
            server.enqueue(new MockResponse().setBody(errorBody1).setResponseCode(403)
                                             .setStatus("HTTP/1.1 403 Bad Request"));
            server.enqueue(new MockResponse().setBody(errorBody1).setResponseCode(403)
                                             .setStatus("HTTP/1.1 403 Bad Request"));
            server.enqueue(new MockResponse().setBody(correctBody).setResponseCode(200)
                                             .addHeader(CloudCaller.DATE_HEADER_LOWERCASE,
                                                        "Tue, 17 Apr 2018 11:08:42 GMT")
                                             .addHeader(CloudCaller.REQUEST_ID_HEADER_LOWERCASE, requestID));
            server.enqueue(new MockResponse().setBody(correctBody2).setResponseCode(200)
                                             .addHeader(CloudCaller.DATE_HEADER_LOWERCASE,
                                                        "Tue, 13 Apr 2018 11:08:42 GMT")
                                             .addHeader(CloudCaller.REQUEST_ID_HEADER_LOWERCASE, requestID));
            server.enqueue(new MockResponse().setBody(errorBody2).setResponseCode(404)
                                             .setStatus("HTTP/1.1 404 Not Found")
                                             .addHeader(CloudCaller.REQUEST_ID_HEADER, requestID)
                                             .addHeader(CloudCaller.DATE_HEADER, "Tue, 17 Apr 2018 11:08:42 GMT"));
            server.enqueue(new MockResponse().setBody(errorBody2).setResponseCode(404)
                                             .setStatus("HTTP/1.1 404 Not Found")
                                             .addHeader(CloudCaller.REQUEST_ID_HEADER, requestID)
                                             .addHeader(CloudCaller.DATE_HEADER, "Tue, 17 Apr 2018 11:09:01 GMT"));
            server.start();
            HttpUrl baseUrl = server.url("");
            ConnectionOptions config = new ConnectionOptions("test", baseUrl.toString());
            TestApi api = new TestApi(config);
            // first call - valid response
            try {
                assertEquals(correctBody, api.callTestWithRetries(2));
                ApiMetadata metadata = api.getLastApiMetadata();
                assertNotNull(metadata);
                assertNotNull(metadata.getUrl());
                assertTrue(metadata.getUrl().toString().contains(TEST_ENDPOINT_PATH));
                assertEquals("GET", metadata.getMethod());
                assertEquals(200, metadata.getStatusCode());
                assertNotNull(metadata.getDate());
                Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                calendar.set(2018, 3, 17, 11, 8, 42);
                assertEquals(0, (calendar.getTime().getTime() - metadata.getDate().getTime()) / 1000);
                assertNotNull(metadata.getObject());
                assertEquals(requestID, metadata.getRequestId());
                assertNull(metadata.getErrorMessage());
            } catch (MbedCloudException e) {
                fail(e.getMessage());
                api.close();
            }
            // Third call - valid response
            try {
                BodyTest body = api.bodyCallTestWithRetries(0);
                assertNotNull(body);
                ApiMetadata metadata = api.getLastApiMetadata();
                assertNotNull(metadata);
                assertNotNull(metadata.getUrl());
                assertTrue(metadata.getUrl().toString().contains(TEST_ENDPOINT_PATH));
                assertEquals("GET", metadata.getMethod());
                assertEquals(200, metadata.getStatusCode());
                assertNotNull(metadata.getDate());
                Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                calendar.set(2018, 3, 13, 11, 8, 42);
                assertEquals(0, (calendar.getTime().getTime() - metadata.getDate().getTime()) / 1000);
                assertEquals(requestID, metadata.getRequestId());
                assertEquals(bodyEtag, metadata.getEtag());
                assertNull(metadata.getErrorMessage());
            } catch (MbedCloudException e) {
                fail(e.getMessage());
                api.close();
            }
            // Fourth call - not found response
            try {
                assertEquals(null, api.callTestWithRetries(1));
                ApiMetadata metadata = api.getLastApiMetadata();
                assertNotNull(metadata);
                assertNotNull(metadata.getUrl());
                assertTrue(metadata.getUrl().toString().contains(TEST_ENDPOINT_PATH));
                assertEquals("GET", metadata.getMethod());
                assertEquals(404, metadata.getStatusCode());
                assertNotNull(metadata.getDate());
                Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                calendar.set(2018, 3, 17, 11, 8, 42);
                assertEquals(0, (calendar.getTime().getTime() - metadata.getDate().getTime()) / 1000);
                assertNotNull(metadata.getObject());
                assertEquals(requestID, metadata.getRequestId());
                assertNotNull(metadata.getErrorMessage());
            } catch (MbedCloudException e) {
                fail(e.getMessage());
                api.close();
            }
            server.shutdown();
            api.close();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    public static TestApiService createTestApiClient(String baseUrl) {
        @SuppressWarnings("resource")
        ApiClientWrapper clientWrapper = new ApiClientWrapper(new ConnectionOptions("test").host(baseUrl));
        TestApiService testService = clientWrapper.createService(TestApiService.class);
        return testService;
    }

    public interface TestApiService {

        @GET("/a_rest_api_endpoint_of_some_sort")
        Call<String> getEndpointValue();

        @GET("/a_rest_api_endpoint_of_some_sort_with_known_body")
        Call<BodyTest> getEndpointInterpretedValue();

    }

    public static class TestApi extends AbstractModule {

        public static final String CALL_TEST_METHOD_NAME = "callTest()";
        private final TestApiService testService;

        public TestApi(ConnectionOptions options) {
            super(options);
            testService = createTestApiClient(options.getHost());
        }

        public String callTestWithRetries(int retries) throws MbedCloudException {
            return CloudCaller.call(this, CALL_TEST_METHOD_NAME, GenericAdapter.identityMapper(String.class),
                                    new CloudCall<String>() {

                                        @Override
                                        public Call<String> call() {
                                            return testService.getEndpointValue();
                                        }
                                    }, true, false, retries);
        }

        public String rawCallTest() throws MbedCloudException {
            return CloudCaller.callRaw(this, CALL_TEST_METHOD_NAME, new CloudCall<String>() {

                @Override
                public Call<String> call() {
                    return testService.getEndpointValue();
                }
            }, false);
        }

        public String callTest() throws MbedCloudException {
            return CloudCaller.call(this, CALL_TEST_METHOD_NAME, GenericAdapter.identityMapper(String.class),
                                    new CloudCall<String>() {

                                        @Override
                                        public Call<String> call() {
                                            return testService.getEndpointValue();
                                        }
                                    });
        }

        public BodyTest bodyCallTest() throws MbedCloudException {
            return CloudCaller.call(this, CALL_TEST_METHOD_NAME, GenericAdapter.identityMapper(BodyTest.class),
                                    new CloudCall<BodyTest>() {

                                        @Override
                                        public Call<BodyTest> call() {
                                            return testService.getEndpointInterpretedValue();
                                        }
                                    });
        }

        public BodyTest bodyCallTestWithRetries(int retries) throws MbedCloudException {
            return CloudCaller.call(this, CALL_TEST_METHOD_NAME, GenericAdapter.identityMapper(BodyTest.class),
                                    new CloudCall<BodyTest>() {

                                        @Override
                                        public Call<BodyTest> call() {
                                            return testService.getEndpointInterpretedValue();
                                        }
                                    }, true, false, retries);
        }

        @Override
        public String getModuleName() {
            return "TestApi";
        }

        @Override
        public SdkContext clone() {
            return this;
        }

    }

    private static class BodyTest {
        private String color;
        private String category;
        private String type;
        private int[] rgba;
        private String hex;
        private String etag;

        /**
         * @return the color
         */
        @SuppressWarnings("unused")
        public String getColor() {
            return color;
        }

        /**
         * @return the category
         */
        @SuppressWarnings("unused")
        public String getCategory() {
            return category;
        }

        /**
         * @return the type
         */
        @SuppressWarnings("unused")
        public String getType() {
            return type;
        }

        /**
         * @return the rgba
         */
        @SuppressWarnings("unused")
        public int[] getRgba() {
            return rgba;
        }

        /**
         * @return the hex
         */
        @SuppressWarnings("unused")
        public String getHex() {
            return hex;
        }

        /**
         * @return the etag
         */
        @SuppressWarnings("unused")
        public String getEtag() {
            return etag;
        }

        /**
         * @param color
         *            the color to set
         */
        @SuppressWarnings("unused")
        public void setColor(String color) {
            this.color = color;
        }

        /**
         * @param category
         *            the category to set
         */
        @SuppressWarnings("unused")
        public void setCategory(String category) {
            this.category = category;
        }

        /**
         * @param type
         *            the type to set
         */
        @SuppressWarnings("unused")
        public void setType(String type) {
            this.type = type;
        }

        /**
         * @param rgba
         *            the rgba to set
         */
        @SuppressWarnings("unused")
        public void setRgba(int[] rgba) {
            this.rgba = rgba;
        }

        /**
         * @param hex
         *            the hex to set
         */
        @SuppressWarnings("unused")
        public void setHex(String hex) {
            this.hex = hex;
        }

        /**
         * @param etag
         *            the etag to set
         */
        @SuppressWarnings("unused")
        public void setEtag(String etag) {
            this.etag = etag;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "BodyTest [color=" + color + ", category=" + category + ", type=" + type + ", rgba="
                   + Arrays.toString(rgba) + ", hex=" + hex + ", etag=" + etag + "]";
        }

        // String correctBody2 = "{\"color\": \"black\",\"category\": \"hue\",\"type\": \"primary\",\"rgba\":
        // [255,255,255,1],\"hex\": \"#000\", \"etag\": \""
        // + bodyEtag + "\"}";
    }

}
