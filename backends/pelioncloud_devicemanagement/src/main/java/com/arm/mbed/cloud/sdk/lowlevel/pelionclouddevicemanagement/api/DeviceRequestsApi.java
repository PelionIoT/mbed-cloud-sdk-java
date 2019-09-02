package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceRequest;

public interface DeviceRequestsApi {
    /**
     * Send an async request to device This API provides an interface to asynchronously call methods on a device. The
     * &#x60;async-id&#x60; is provided by the client, enabling the client to track the end-to-end flow with an
     * identifier that is relevant to the end application. For example, a web application&#39;s session ID along with
     * the device ID and the resource path could be used as the &#x60;async-id&#x60;. This also avoids any race
     * conditions with [the notification channel](/docs/current/integrate-web-app/event-notification.html). All
     * responses are sent through the currently configured notification channel as an **AsyncIDResponse**. For
     * &#x60;GET&#x60; methods, values may be fetched from an internal cache, instead of contacting the device. The
     * server queues requests if it cannot reach the device at the time of the request. The queue is limited to 20
     * requests. The queueing behaviour is affected by the &#x60;retry&#x60; and the &#x60;expiry-seconds&#x60;
     * parameters. If the device is not reached, or the device fails to respond when the request is made, the server
     * queues the request and retries within the given expiry period the next time the device contacts the server. The
     * requests from the queue are delivered in the order of insertion, one at a time, and not concurrently. One
     * delivery attempt consist from protocol specific retrasmission logic, where is multiple trasmissions. In case of
     * CoAP, the retrasmissions exponential backoff 2, 4, 8, 16 to 64 seconds, taking total over 2 minutes. If the
     * device does not respond within this two-minute period, delivery fails, and the request is put back in the queue
     * so long as the retry count is less than its maximum. For a queue-mode device, the request delivery is not
     * attempted immediately, but only when the device next time contacts the server. If retries are exhausted or the
     * expiry time has passed, then the server discards the request and sends an error in **AsyncIDResponse**. The
     * retries could be exhausted, for example, if the device periodically contacts the server and receives the request
     * from the queue, but then fails to respond back to the server. On the other hand, the device might lose its
     * network connectivity, and the requests in the queue might expire and get discarded before the device regains the
     * connectivity. You can write [Notification Rules](../connecting/resource-change-webapp.html#notification-rules)
     * for a resource with PUT command. Please see example of the payload below. &#x60;&#x60;&#x60; {
     * \&quot;method\&quot;: \&quot;PUT\&quot;, \&quot;uri\&quot;:
     * \&quot;/5/0/1?lt&#x3D;10&amp;gt&#x3D;60&amp;pmax&#x3D;120\&quot; } &#x60;&#x60;&#x60; POST &#x60;method&#x60; can
     * be used to either execute or create resource on a LWM2M supporting device. When creating a resource,
     * &#x60;uri&#x60; must refer to an object, and &#x60;payload-b64&#x60; must be in LWM2M TLV format, as in the
     * following example. &#x60;&#x60;&#x60; { \&quot;method\&quot;: \&quot;POST\&quot;, \&quot;uri\&quot;:
     * \&quot;/123\&quot;, \&quot;content-type\&quot;: \&quot;application/vnd.oma.lwm2m+tlv\&quot;,
     * \&quot;payload-b64\&quot;: \&quot;BwHFAnZhbHVl\&quot; } &#x60;&#x60;&#x60; &#x60;&#x60;&#x60; Example URIs: POST
     * /v2/device-requests/015f2fa34d310000000000010030036c?async-id&#x3D;123e4567-e89b-12d3-a456-426655440000 POST
     * /v2/device-requests/015f2fa34d310000000000010030036c?async-id&#x3D;123e4567-e89b-12d3-a456-426655440000&amp;retry&#x3D;2&amp;expiry-seconds&#x3D;7200
     * Example payload to read value from resource /5/0/1: { \&quot;method\&quot;: \&quot;GET\&quot;, \&quot;uri\&quot;:
     * \&quot;/5/0/1\&quot; } Example payload to set notification rules for resource /5/0/1: { \&quot;method\&quot;:
     * \&quot;PUT\&quot;, \&quot;uri\&quot;: \&quot;/5/0/1?lt&#x3D;10&amp;gt&#x3D;60&amp;pmax&#x3D;120\&quot; } Example
     * payload to write value \&quot;value1\&quot; to resource /5/0/1: { \&quot;method\&quot;: \&quot;PUT\&quot;,
     * \&quot;uri\&quot;: \&quot;/5/0/1%20?k1&#x3D;v1&amp;k2&#x3D;v2%22\&quot;, \&quot;accept\&quot;:
     * \&quot;text/plain\&quot;, \&quot;content-type\&quot;: \&quot;text/plain\&quot;, \&quot;payload-b64\&quot;:
     * \&quot;dmFsdWUxCg&#x3D;&#x3D;\&quot; } Example payload to execute LWM2M resource /123/1/1: {
     * \&quot;method\&quot;: \&quot;POST\&quot;, \&quot;uri\&quot;: \&quot;/123/1/1\&quot; } Immediate response: 202
     * Accepted Examples of AsyncIDResponse, delivered via the notification channel: { \&quot;async-responses\&quot;: [
     * { \&quot;id\&quot;: \&quot;123e4567-e89b-12d3-a456-426655440000\&quot;, \&quot;status\&quot;: 200,
     * \&quot;payload\&quot;: \&quot;dmFsdWUxCg&#x3D;&#x3D;\&quot;, \&quot;ct\&quot;: \&quot;text/plain\&quot;,
     * \&quot;max-age\&quot;: 600 } ] } { \&quot;async-responses\&quot;: [ { \&quot;id\&quot;:
     * \&quot;123e4567-e89b-12d3-a456-426655440000\&quot;, \&quot;status\&quot;: 504, \&quot;error\&quot;:
     * \&quot;TIMEOUT\&quot; } ] } &#x60;&#x60;&#x60;
     * 
     * @param deviceId
     *            The device ID generated by Device Management. (required)
     * @param asyncId
     *            The client-generated ID for matching the correct response delivered by notification. (required)
     * @param body
     *            Device request to send. (required)
     * @param retry
     *            The count of retry transmissions of the request to the device, after initial transmission. For
     *            example, retry of two means three delivery attempts in total. If retries are exhausted, the request is
     *            discarded and an error is delivered in the AsyncIDResponse. Default value of retry is 0 for a
     *            non-queue-mode device and 2 for a queue-mode device. (optional)
     * @param expirySeconds
     *            The time period during which the delivery is attempted, in seconds. If the device is not reachable
     *            within this period, the request is discarded and an error is delivered in the AsyncIDResponse. Default
     *            value of expiry-seconds is 2 hours for a non-queue-mode device and 3 days for a queue-mode device.
     *            (optional)
     * @return Call&lt;Void&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v2/device-requests/{device-id}")
    Call<Void> createAsyncRequest(@retrofit2.http.Path(value = "device-id", encoded = true) String deviceId,
                                  @retrofit2.http.Query("async-id") String asyncId,
                                  @retrofit2.http.Body DeviceRequest body, @retrofit2.http.Query("retry") Integer retry,
                                  @retrofit2.http.Query("expiry-seconds") Integer expirySeconds);

}
