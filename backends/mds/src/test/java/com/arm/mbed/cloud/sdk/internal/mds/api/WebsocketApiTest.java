package com.arm.mbed.cloud.sdk.internal.mds.api;

import com.arm.mbed.cloud.sdk.internal.mds.ApiClient;
import com.arm.mbed.cloud.sdk.internal.mds.model.WebsocketChannel;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for WebsocketApi
 */
public class WebsocketApiTest {

    private WebsocketApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(WebsocketApi.class);
    }

    /**
     * Open the websocket.
     *
     * Opens the websocket connection.  A websocket channel can have only one active websocket connection at a time. If a websocket connection for a channel exists and a new connection to the same channel is made the connection is accepted and the older connection will be closed.  
     */
    @Test
    public void connectWebsocketTest() {
        String connection = null;
        String upgrade = null;
        // Void response = api.connectWebsocket(connection, upgrade);

        // TODO: test validations
    }
    /**
     * Delete websocket channel.
     *
     * To delete a notification websocket channel bound to the API key.  This is required to change the channel from websocket to another type.  **Example usage:**      curl -X DELETE https://api.us-east-1.mbedcloud.com/v2/notification/websocket -H &#39;authorization: Bearer {api-key}&#39; 
     */
    @Test
    public void deleteWebsocketTest() {
        // Void response = api.deleteWebsocket();

        // TODO: test validations
    }
    /**
     * Get websocket channel information.
     *
     * Returns 200 with websocket connection status if websocket channel exists.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v2/notification/websocket -H &#39;authorization: Bearer {api-key}&#39; 
     */
    @Test
    public void getWebsocketTest() {
        // WebsocketChannel response = api.getWebsocket();

        // TODO: test validations
    }
    /**
     * Register a websocket channel
     *
     * Register a channel which will use websocket connection to deliver notifications. The websocket channel should be opened by client using &#x60;/v2/notification/websocket-connect&#x60; endpoint. To get notifications pushed, you also need to place  the subscriptions. For more information on notification messages, see [NotificationMessage](#NotificationMessage).  A websocket channel can have only one active websocket connection at a time. If a websocket connection for a channel exists and a new connection to the same channel is made the connection is accepted and the older connection will be closed.   **Expiration of a websocket:**  A websocket channel will be expired if the channel does not have an opened websocket connection for 24 hour period. Channel expiration means the channel will be deleted and any undelivered notifications stored in its internal queue will be removed. As long as the channel has an opened websocket connection or time between successive websocket connections is less than 24 hours, the channel is considered active, notifications are stored in its internal queue and delivered when a websocket connection is active. A channel can be also deleted explicitly by a DELETE call.  More about [notification sending logic](/docs/current/integrate-web-app/event-notification.html#notification-sending-logic).  **Example usage:**      curl -X PUT https://api.us-east-1.mbedcloud.com/v2/notification/websocket -H &#39;authorization: Bearer {api-key}&#39; 
     */
    @Test
    public void registerWebsocketTest() {
        // WebsocketChannel response = api.registerWebsocket();

        // TODO: test validations
    }
}
