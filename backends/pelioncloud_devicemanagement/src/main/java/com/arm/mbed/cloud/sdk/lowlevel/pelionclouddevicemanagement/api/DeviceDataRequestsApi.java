package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceRequest;

public interface DeviceDataRequestsApi {
    /**
     * Send an asynchronous request to read, write or post to a device resource. This API provides an interface to call
     * CoAP (Constrained Application Protocol) methods on a device and send commands to device resources. As part of the
     * request body, you must specify the CoAP method you want to call on the device: - Use the GET method to read
     * resource values. For example, to read the value of resource &#x60;/3200/0/5501&#x60;, use: &#x60;&#x60;&#x60;
     * curl -X POST https://api.us-east-1.mbedcloud.com/v2/device-requests/{device_id}?async-id&#x3D;{async-response-id}
     * \\ -H &#39;Authorization: Bearer {access_key}&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;{\&quot;method\&quot;: \&quot;GET\&quot;, \&quot;uri\&quot;: \&quot;/3200/0/5501\&quot;}&#39;
     * &#x60;&#x60;&#x60; &gt; For &#x60;GET&#x60; methods, the API may fetch values from an internal cache, instead of
     * contacting the device. &gt; If the value is not in the cache, the read command goes all the way to the device. -
     * Use the PUT method to write [notification
     * rules](https://developer.pelion.com/docs/device-management/current/resources/resource-change-webapp.html) or
     * resource values for a resource. Example payload to write a notification rule: &#x60;&#x60;&#x60; {
     * \&quot;method\&quot;: \&quot;PUT\&quot;, \&quot;uri\&quot;:
     * \&quot;/5/0/1?lt&#x3D;10&amp;gt&#x3D;60&amp;pmax&#x3D;120\&quot; } &#x60;&#x60;&#x60; - Example payload to write
     * a value to resource &#x60;/5/0/1&#x60;: &#x60;&#x60;&#x60; { \&quot;method\&quot;: \&quot;PUT\&quot;,
     * \&quot;uri\&quot;: \&quot;/5/0/1?k1&#x3D;v1&amp;k2&#x3D;v2\&quot;, \&quot;accept\&quot;:
     * \&quot;text/plain\&quot;, \&quot;content-type\&quot;: \&quot;text/plain\&quot;, \&quot;payload-b64\&quot;:
     * \&quot;dmFsdWUxCg&#x3D;&#x3D;\&quot; } &#x60;&#x60;&#x60; - Use the POST method to execute or create a resource
     * on a LWM2M supporting device. When you create a resource, &#x60;uri&#x60; must refer to an object, and
     * &#x60;payload-b64&#x60; must be in LWM2M TLV format for example: &#x60;&#x60;&#x60; { \&quot;method\&quot;:
     * \&quot;POST\&quot;, \&quot;uri\&quot;: \&quot;/123\&quot;, \&quot;content-type\&quot;:
     * \&quot;application/vnd.oma.lwm2m+tlv\&quot;, \&quot;payload-b64\&quot;: \&quot;BwHFAnZhbHVl\&quot; }
     * &#x60;&#x60;&#x60; - Use the POST method to execute resource on a LWM2M supporting device. Example payload to
     * execute LWM2M resource &#x60;/123/1/1&#x60;: &#x60;&#x60;&#x60; { \&quot;method\&quot;: \&quot;POST\&quot;,
     * \&quot;uri\&quot;: \&quot;/123/1/1\&quot; } &#x60;&#x60;&#x60; - Device Management sends responses through the
     * currently configured notification channel as &#x60;AsyncIDResponse&#x60;. Example &#x60;AsyncIDResponse&#x60;
     * delivered through the notification channel: &#x60;&#x60;&#x60; { \&quot;async-responses\&quot;: [ {
     * \&quot;id\&quot;: \&quot;123e4567-e89b-12d3-a456-426655440000\&quot;, \&quot;status\&quot;: 200,
     * \&quot;payload\&quot;: \&quot;dmFsdWUxCg&#x3D;&#x3D;\&quot;, \&quot;ct\&quot;: \&quot;text/plain\&quot;,
     * \&quot;max-age\&quot;: 600 } ] } &#x60;&#x60;&#x60; &#x60;&#x60;&#x60; { \&quot;async-responses\&quot;: [ {
     * \&quot;id\&quot;: \&quot;123e4567-e89b-12d3-a456-426655440000\&quot;, \&quot;status\&quot;: 504,
     * \&quot;error\&quot;: \&quot;TIMEOUT\&quot; } ] } &#x60;&#x60;&#x60; &gt; If it cannot reach the device at the
     * time of the request, Device Management puts the requests in a queue. **Queueing behavior** If Device Management
     * does not reach the device, or the device fails to respond, the server queues the request and retries the
     * delivery, for the period of time defined by &#x60;expiry-seconds&#x60;, the next time the device contacts the
     * server. The queue is limited to 20 requests per device. If the queue is full, subsequent messages will be
     * rejected until some of the existing messages are delivered or expired. Device Management delivers requests from
     * the queue in the order of insertion, one at a time, and not concurrently. Delivery attempts follow
     * protocol-specific retransmission logic. There can be multiple transmissions, depending on the protocol. For CoAP,
     * the retransmissions have an exponential backoff of 2, 4, 8, 16, and up to 64 seconds, taking in total over two
     * minutes. If the device does not respond within this two-minute period, the delivery fails, Device Management
     * performs one retry and then puts the request back into the queue until the retry count reaches its limit. Device
     * Management attempts to redeliver the request when the device next contacts the server. When Device Management
     * reaches the &#x60;retry&#x60; or &#x60;expiry-seconds&#x60; limit, the server discards the request and sends an
     * error in &#x60;AsyncIDResponse&#x60;. For example: - Retries could be exhausted if the device periodically
     * contacts the server and receives the request from the queue, but then fails to respond to the server. - The
     * device may lose its network connectivity, and the requests in the queue may expire and get discarded before the
     * device regains connectivity. When Device Management delivers the request to the device, the status code in
     * &#x60;AsyncIDResponse&#x60; is *2xx* or *4xx*, based on the device&#39;s response. If Device Management could not
     * deliver the request, the server generates a status code of *429* or *5xx*.
     * 
     * @param deviceId
     *            The device ID generated by Device Management. (required)
     * @param asyncId
     *            A client-generated ID that lets the REST client track the end-to-end flow and prevents race conditions
     *            with the notification channel. The &#x60;async-id&#x60; can be, for example, a UUID or the web
     *            application session ID along with the device ID and the resource. (required)
     * @param body
     *            Device request to send. The body element has &#x60;method&#x60;, &#x60;uri&#x60;, &#x60;accept&#x60;,
     *            &#x60;content-type&#x60; and &#x60;payload-b64&#x60; fields. - The &#x60;method&#x60; is one of
     *            &#x60;GET&#x60;, &#x60;PUT&#x60;, &#x60;POST&#x60;, &#x60;DELETE&#x60;. - The &#x60;uri&#x60; field is
     *            the path to the LwM2M object and can include query parameters. This can include key-value pairs, for
     *            example, &#x60;/5/0/1?key1&#x3D;value1;key2&#x3D;value2&#x60;. - The &#x60;accept&#x60; field defines
     *            the content type that the requesting client will accept. - The &#x60;content-type&#x60; describes the
     *            content type of the base-64 encoded &#x60;payload-b64&#x60; field. - The &#x60;payload-b64&#x60; is
     *            the payload to send to the device in base-64 encoded form. (required)
     * @param retry
     *            The number of attempts to deliver the request to the device after the first delivery attempt. For
     *            example, two retries sums up to the total of three delivery attempts. When retries are exhausted,
     *            Device Management discards the request and delivers an error in the AsyncIDResponse. The default
     *            number of retries for a non-queue mode device is &#x60;0&#x60;. The default number of retries for a
     *            queue-mode device is &#x60;2&#x60;. (optional)
     * @param expirySeconds
     *            The time period during which the delivery is attempted, in seconds. If the device is not reachable
     *            within this period, Device Management discards the request and delivers an error in the
     *            AsyncIDResponse. The default time period during which the delivery is attempted is two hours for a
     *            non-queue mode device and three days for a queue-mode device. (optional)
     * @return Call&lt;Void&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v2/device-requests/{device-id}")
    Call<Void> createAsyncRequest(@retrofit2.http.Path(value = "device-id", encoded = true) String deviceId,
                                  @retrofit2.http.Query("async-id") String asyncId,
                                  @retrofit2.http.Body DeviceRequest body, @retrofit2.http.Query("retry") Integer retry,
                                  @retrofit2.http.Query("expiry-seconds") Integer expirySeconds);

}
