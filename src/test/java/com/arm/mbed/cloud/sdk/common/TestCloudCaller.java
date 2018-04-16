package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.Error.Field;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import retrofit2.Call;
import retrofit2.http.GET;

public class TestCloudCaller {

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

            ApiClientWrapper clientWrapper = new ApiClientWrapper(
                    new ConnectionOptions("test").host(baseUrl.toString()));
            TestApiService testService = clientWrapper.createService(TestApiService.class);
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

    public interface TestApiService {

        @GET("/a_rest_api_endpoint_of_some_sort")
        Call<String> getEndpointValue();

    }

}
