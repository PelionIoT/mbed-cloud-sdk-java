package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for EdgeProxyApi
 */
public class EdgeProxyApiTest {

    private EdgeProxyApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(EdgeProxyApi.class);
    }

    /**
     * Establish a tunnel connection to connected devices.
     *
     * This WebSocket-based API for clients establishes connections to services on connected gateways. &lt;br&gt;
     * Establish WebSocket connections to the edge-proxy service. After you establish a Websocket connection, the Edge
     * proxy sends data between cloud- and gateway-based services. &lt;br&gt; All communication is byte-based.
     */
    @Test
    public void communicateWithGatewayBasedServicesTest() {
        String connection = null;
        String upgrade = null;
        Integer secWebSocketVersion = null;
        byte[] secWebSocketKey = null;
        String id = null;
        String address = null;
        String origin = null;
        // Void response = api.communicateWithGatewayBasedServices(connection, upgrade, secWebSocketVersion,
        // secWebSocketKey, id, address, origin);

        // TODO: test validations
    }
}
