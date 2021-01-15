package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

public interface GatewayTerminalPublicApiApi {
    /**
     * Establish a console session This WebSocket-based API establishes a console session with a gateway device.
     * &lt;br&gt; Use this endpoint to establish a WebSocket connection to the device console. Once the connection is in
     * place, you can use the protocol below to exchange messages related to the console session. You must provide the
     * api key as bearer token to authenticate the request. All messages sent between the server and the client are
     * contained inside a message envelope. The envelope contains a type field describing what format the payload is in
     * and how to interpret the message: &#x60;&#x60;&#x60;json { \&quot;type\&quot;: [string], \&quot;payload\&quot;:
     * [any], \&quot;sessionID\&quot;: [string] } &#x60;&#x60;&#x60; &lt;br&gt; ## Message types and payload formats |
     * Message Type | Payload Format | Description | |:------------- |:------------- |:------------- | | **resize** |
     * &#x60;ResizePayload&#x60; | Can be sent by the client to the server to notify the device that the console window
     * size has changed. | | **input** | &#x60;string&#x60; | Sent from the client to the server when keyboard input is
     * provided to the console. stdin | | **output** | &#x60;string&#x60; | Sent from the server to the client when
     * console output is produced. stdout + stderr | ### &#x60;ResizePayload&#x60; &#x60;&#x60;&#x60;json {
     * \&quot;width\&quot;: [integer], // number of columns \&quot;height\&quot;: [integer] // number of rows }
     * &#x60;&#x60;&#x60; | Field Name | Format | Description | |:------------- |:------------- |:------------- | |
     * width | integer | The width of the console window in columns. | | height | integer | The height of the console
     * window in rows. | &lt;br&gt; ## Protocol Sequence Diagram The diagram shows how messages are passed between the
     * client and the server after initiating a console session: &#x60;&#x60;&#x60; Client Pelion Cloud
     * (/v3/devices/{id}/console) Device | | | | | | |-----------------[Input]------------------&gt;| | |
     * |-----------------[Input]------------------&gt;| | |&lt;----------------[Output]------------------|
     * |&lt;----------------[Output]------------------| | |-----------------[Input]------------------&gt;| | |
     * |-----------------[Input]------------------&gt;| | |&lt;----------------[Output]------------------|
     * |&lt;----------------[Output]------------------| | | | | |-----------------[Resize]-----------------&gt;| | |
     * |-----------------[Resize]-----------------&gt;| | | | | |&lt;----------------[Output]------------------|
     * |&lt;----------------[Output]------------------| | | | | | | | | | | Input is always forwarded from the client to
     * the console session on the relevant device to be passed to the stdin stream. The client does not need to provide
     * a session ID for input messages. Ouptut is forwarded from the device console session&#39;s stdout and stderr
     * streams to the client. Resize messages are forwarded from the client to the console session on the device.
     * &#x60;&#x60;&#x60; &lt;br&gt; If the console session is terminated by the device disconnecting, the WebSocket
     * connection is closed. &lt;br&gt; All communication is text-based. &lt;br&gt; ## Errors and Close Codes - If you
     * send binary data instead of text data over the websocket connection, the socket closes with code 1003. - If you
     * send text data that is not valid JSON, the socket closes with code 1002 and error message &#39;Data could not be
     * parsed as JSON&#39;. - If you send text data that is valid JSON but does not follow a valid message schema, the
     * socket closes with code 1002 and error message &#39;Object format invalid&#39;. - If you try to establish a
     * console session with a device that is not prepared for console, the socket closes with code 1011 and error
     * message &#39;The device console is not working&#39;. - If your client fails to respond to ping messages from the
     * server with a matching pong message, the server disconnects the client, assuming the connection has timed out.
     * 
     * @param id
     *            The id of the device (required)
     * @param connection
     *            The websocket connection header. Must be &#39;Upgrade&#39;. (required)
     * @param upgrade
     *            The protocol upgrade header. Must be &#39;websocket&#39;. (required)
     * @param secWebSocketVersion
     *            WebSocket version. Must be 13. (required)
     * @param secWebSocketKey
     *            The value of this header field must be a nonce consisting of a randomly selected 16-byte value that
     *            has been base64-encoded (see Section 4 of [RFC4648]). The nonce must be selected randomly for each
     *            connection. (required)
     * @param secWebSocketProtocol
     *            Access key or user token must be present in the &#x60;Sec-WebSocket-Protocol&#x60; header **if
     *            Authorization header cannot be provided**:
     *            &#x60;Sec-WebSocket-Protocol:wss,pelion_ak_{access_key}&#x60;. (optional)
     * @param origin
     *            Originating host of the request. (optional)
     * @return Call&lt;Void&gt;
     */
    @GET("v3/devices/{id}/console")
    Call<Void>
        establishGatewayDeviceConsoleSession(@retrofit2.http.Path(value = "id", encoded = true) String id,
                                             @retrofit2.http.Header("Connection") String connection,
                                             @retrofit2.http.Header("Upgrade") String upgrade,
                                             @retrofit2.http.Header("Sec-WebSocket-Version") Integer secWebSocketVersion,
                                             @retrofit2.http.Header("Sec-WebSocket-Key") byte[] secWebSocketKey,
                                             @retrofit2.http.Header("Sec-WebSocket-Protocol") String secWebSocketProtocol,
                                             @retrofit2.http.Header("Origin") String origin);

}
