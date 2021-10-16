package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.PresubscriptionArray;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for DeviceDataSubscriptionsApi
 */
public class DeviceDataSubscriptionsApiTest {

    private DeviceDataSubscriptionsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DeviceDataSubscriptionsApi.class);
    }

    /**
     * Subscribe to a resource to receive updates about resource changes.
     *
     * Subscribe to a resource to receive updated resource content, periodically or based on a more sophisticated
     * solution-dependent logic. To place dynamic observation rules for individual object instances and resources and
     * define when the device sends observations, set [notification
     * rules](https://developer.pelion.com/docs/device-management/current/resources/resource-change-webapp.html).
     * **Note:** Device Management removes all manual subscriptions during a full device registration, at which point
     * applications must re-subscribe. To avoid this, use &#x60;/subscriptions&#x60; to set a pre-subscription. You can
     * subscribe to resources, objects and object instances. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v2/subscriptions/{device-id}/{resourcePath} \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60; **Important:** You must also call a
     * [&#x60;/notification/callback&#x60;](https://developer.pelion.com/docs/device-management-api/notifications/)
     * method for Device Management Connect to push resource change notifications.
     */
    @Test
    public void addResourceSubscriptionTest() {
        String deviceId = null;
        String resourcePath = null;
        // Void response = api.addResourceSubscription(deviceId, resourcePath);

        // TODO: test validations
    }

    /**
     * Read the subscription status for a specific resource.
     *
     * Check whether you are subscribed to receive resource content updates for a specific resource.
     */
    @Test
    public void checkResourceSubscriptionTest() {
        String deviceId = null;
        String resourcePath = null;
        // Void response = api.checkResourceSubscription(deviceId, resourcePath);

        // TODO: test validations
    }

    /**
     * Delete all subscriptions on a device.
     *
     * Delete all resource subscriptions in a single device. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v2/subscriptions/{device-id} \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteEndpointSubscriptionsTest() {
        String deviceId = null;
        // Void response = api.deleteEndpointSubscriptions(deviceId);

        // TODO: test validations
    }

    /**
     * Remove pre-subscriptions.
     *
     * Remove pre-subscriptions. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v2/subscriptions \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void deletePreSubscriptionsTest() {
        // Void response = api.deletePreSubscriptions();

        // TODO: test validations
    }

    /**
     * Remove a subscription.
     *
     * Remove an existing subscription to a resource. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v2/subscriptions/{device-id}/{resourcePath} \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteResourceSubscriptionTest() {
        String deviceId = null;
        String resourcePath = null;
        // Void response = api.deleteResourceSubscription(deviceId, resourcePath);

        // TODO: test validations
    }

    /**
     * View all subscriptions on a device.
     *
     * Retrieve a list of all subscribed resources on a single device. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v2/subscriptions/{device-id} \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getEndpointSubscriptionsTest() {
        String deviceId = null;
        // String response = api.getEndpointSubscriptions(deviceId);

        // TODO: test validations
    }

    /**
     * View pre-subscriptions.
     *
     * Retrieve pre-subscription data. The server returns a JSON structure. If there are no pre-subscribed resources,
     * the server returns an empty array. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v2/subscriptions \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void getPreSubscriptionsTest() {
        // PresubscriptionArray response = api.getPreSubscriptions();

        // TODO: test validations
    }

    /**
     * Set pre-subscriptions.
     *
     * A pre-subscription is a set of rules you define to subscribe to specific resources automatically when certain
     * devices register or does a register update. You can set subscription rules based on the endpoint ID (optionally
     * having an &#x60;*&#x60; character at the end), endpoint type, a list of resources, or expressions with an
     * &#x60;*&#x60; character at the end. When a device that meets the subscription rules registered, Device Management
     * Connect automatically sends subscription requests to the device for the resources you specify. To remove the
     * pre-subscription data, put an empty array as a rule. To place dynamic observation rules for individual object
     * instances and resources and define when the device sends observations, set [notification
     * rules](https://developer.pelion.com/docs/device-management/current/resources/resource-change-webapp.html).
     * **Note:** The subscription is bound to the application you are using. To get notifications of the resource value
     * changes, you need to create an [event notification
     * channel](https://developer.pelion.com/docs/device-management/current/integrate-web-app/event-notification.html)
     * with an access key of the same application. **Example request:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v2/subscriptions \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\
     * -H &#39;content-type: application/json&#39; \\ -d &#39;[ { \&quot;endpoint-name\&quot;: \&quot;node-001\&quot;,
     * \&quot;resource-path\&quot;: [\&quot;/dev\&quot;] }, { \&quot;endpoint-type\&quot;: \&quot;Light\&quot;,
     * \&quot;resource-path\&quot;: [\&quot;/sen/_*\&quot;] }, { \&quot;endpoint-name\&quot;: \&quot;node*\&quot; }, {
     * \&quot;endpoint-type\&quot;: \&quot;Sensor\&quot; }, { \&quot;resource-path\&quot;:
     * [\&quot;/dev/temp\&quot;,\&quot;/dev/hum\&quot;] } ]&#39; &#x60;&#x60;&#x60; - Subscribe to &#x60;/dev&#x60;
     * resource of endpoint named &#x60;node-001&#x60;. - Subscribe to &#x60;Light&#x60; type of endpoints and their
     * resources prefixed with &#x60;/sen/&#x60;. - Subscribe to all observable resources of endpoint names prefixed
     * with &#x60;node&#x60;. - Subscribe to all observable resources of &#x60;Sensor&#x60; type endpoints. - Subscribe
     * to &#x60;/dev/temp&#x60; and &#x60;/dev/hum&#x60; resources of all endpoints. **Limits**: - The maximum length of
     * the endpoint name and endpoint type is 64 characters. - The maximum length of the resource path is 128
     * characters. - You can subscribe to 256 separate resource paths. - The maximum number of pre-subscription entries
     * is 1024. **Note**: To save bandwidth and avoid unnecessary traffic, use resource path patterns to limit the
     * matching resources in the presubscription data. This prevents your web application from receiving unwanted
     * resource notifications. See [Subscribe only to what you
     * need](https://developer.pelion.com/docs/device-management/current/resources/resource-change-webapp.html).
     */
    @Test
    public void updatePreSubscriptionsTest() {
        PresubscriptionArray presubscription = null;
        // Void response = api.updatePreSubscriptions(presubscription);

        // TODO: test validations
    }
}
