package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

public interface EdgeProxyApi {
    /**
     * Establish a tunnel connection to connected devices. This WebSocket-based API for clients establishes connections
     * to services on connected gateways. &lt;br&gt; Establish WebSocket connections to the edge-proxy service. After
     * you establish a Websocket connection, the Edge proxy sends data between cloud- and gateway-based services.
     * &lt;br&gt; All communication is byte-based.
     * 
     * @param connection
     *            The websocket connection header. Must be &#39;Upgrade&#39;. (required)
     * @param upgrade
     *            The protocol upgrade header. Must be &#39;websocket&#39;. (required)
     * @param secWebSocketVersion
     *            WebSocket version of the protocol. Must be 13. (required)
     * @param secWebSocketKey
     *            The value of this header field must be a nonce consisting of a randomly selected 16-byte value that
     *            has been base64-encoded (see this section from RFC6455 -
     *            https://tools.ietf.org/html/rfc6455#section-11.3.1). The nonce must be selected randomly for each
     *            connection. An example is \&quot;dGhlIHNhbXBsZSBub25jZQ&#x3D;&#x3D;\&quot;. (required)
     * @param id
     *            The Device ID. (required)
     * @param address
     *            The address of the TCP service listening on a specific port on the gateway. If a TCP service is
     *            listening on localhost with port 5000 and is ready to accept incoming traffic, the value of this
     *            parameter should be &#x60;localhost:5000&#x60;. (required)
     * @param origin
     *            Originating host of the request. (optional)
     * @return Call&lt;Void&gt;
     */
    @GET("v3preview1/devices/{id}/services/{address}/connection")
    Call<Void>
        communicateWithGatewayBasedServices(@retrofit2.http.Header("Connection") String connection,
                                            @retrofit2.http.Header("Upgrade") String upgrade,
                                            @retrofit2.http.Header("Sec-WebSocket-Version") Integer secWebSocketVersion,
                                            @retrofit2.http.Header("Sec-WebSocket-Key") byte[] secWebSocketKey,
                                            @retrofit2.http.Path(value = "id", encoded = true) String id,
                                            @retrofit2.http.Path(value = "address", encoded = true) String address,
                                            @retrofit2.http.Header("Origin") String origin);

}
