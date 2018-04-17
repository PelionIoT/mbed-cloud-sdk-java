package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.CloudCaller.CloudCall;
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
                    .setStatus("HTTP/1.1 403 Bad Request").addHeader(CloudCaller.REQUEST_ID_HEADER, requestID));
            server.enqueue(
                    new MockResponse().setBody(errorBody2).setResponseCode(403).setStatus("HTTP/1.1 403 Bad Request"));

            server.start();
            HttpUrl baseUrl = server.url("");

            TestApiService testService = createTestApiClient(baseUrl.toString());
            // First request
            retrofit2.Response<String> receivedResponse = testService.getEndpointValue().execute();
            assertFalse(receivedResponse.isSuccessful());
            Error error = CloudCaller.retrieveErrorDetails(CloudCaller.retrieveErrorMessageFromBody(receivedResponse),
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
            error = CloudCaller.retrieveErrorDetails(CloudCaller.retrieveErrorMessageFromBody(receivedResponse),
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
            error = CloudCaller.retrieveErrorDetails(CloudCaller.retrieveErrorMessageFromBody(receivedResponse),
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
     * Testing that calls to Mbed Cloud are carried out as expected.
     */
    @Test
    public void testCloudCaller() {
        try {
            MockWebServer server = new MockWebServer();
            String requestID = "01626653c64b0242ac12000700000000";
            String errorBody1 = "{\"fields\": [{\"name\": \"policy\",\"message\": \"Access denied by policy [PSK agreement].\"}],\"object\": \"error\",\"code\": 403,\"type\": \"access_denied\",\"message\": \"Not authorized to execute the request.\",\"request_id\": \""
                    + requestID + "\" }";
            String correctBody = "This request was a success";
            String errorBody2 = "{\"object\": \"error\",\"code\": 404,\"type\": \"not_found\",\"message\": \"Not Found.\",\"request_id\": \"01626653c64b0242ac12dass000700000000\" }";
            server.enqueue(
                    new MockResponse().setBody(errorBody1).setResponseCode(403).setStatus("HTTP/1.1 403 Bad Request"));
            server.enqueue(new MockResponse().setBody(correctBody).setResponseCode(200)
                    .addHeader(CloudCaller.DATE_HEADER_LOWERCASE, "Tue, 17 Apr 2018 11:08:42 GMT")
                    .addHeader(CloudCaller.REQUEST_ID_HEADER_LOWERCASE, requestID));
            server.enqueue(new MockResponse().setBody(errorBody2).setResponseCode(404)
                    .setStatus("HTTP/1.1 404 Not Found").addHeader(CloudCaller.REQUEST_ID_HEADER, requestID)
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
            // Third call - not found response
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

    public static TestApiService createTestApiClient(String baseUrl) {
        ApiClientWrapper clientWrapper = new ApiClientWrapper(new ConnectionOptions("test").host(baseUrl));
        TestApiService testService = clientWrapper.createService(TestApiService.class);
        return testService;
    }

    public interface TestApiService {

        @GET("/a_rest_api_endpoint_of_some_sort")
        Call<String> getEndpointValue();

    }

    public static class TestApi extends AbstractApi {

        public static final String CALL_TEST_METHOD_NAME = "callTest()";
        private final TestApiService testService;

        public TestApi(ConnectionOptions options) {
            super(options);
            testService = createTestApiClient(options.getHost());
        }

        public String callTest() throws MbedCloudException {
            return CloudCaller.call(this, CALL_TEST_METHOD_NAME, GenericAdapter.identityMapper(),
                    new CloudCall<String>() {

                        @Override
                        public Call<String> call() {
                            return testService.getEndpointValue();
                        }
                    });
        }

        @Override
        public String getModuleName() {
            return "TestApi";
        }

    }

}
