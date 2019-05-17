package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.PresubscriptionArray;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for SubscriptionsApi
 */
public class SubscriptionsApiTest {

    private SubscriptionsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(SubscriptionsApi.class);
    }

    /**
     * Subscribe to a resource path.
     *
     * The Device Management Connect eventing model consists of observable Resources. This means that endpoints can
     * deliver updated resource content, periodically or with a more sophisticated solution-dependent logic. The OMA
     * LwM2M resource model also supports including objects, object instances, resources, and resource instances.
     * Applications can subscribe to objects, object instances or individual resources to make the device provide value
     * change notifications to Device Management Connect service. An application needs to call a
     * &#x60;/notification/callback&#x60; method to get Device Management Connect to push notifications of the resource
     * changes. **Notification rules** A web application can place dynamic observation rules for individual Object
     * Instances and Resources to define when the device sends observations. More information in [Notification
     * rules](../connecting/resource-change-webapp.html). All manual subscriptions are removed during a full device
     * registration, at which point applications must re-subscribe. To avoid this, you can use
     * &#x60;/subscriptions&#x60; to set a pre-subscription. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v2/subscriptions/{device-id}/{resourcePath} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void addResourceSubscriptionTest() {
        String deviceId = null;
        String resourcePath = null;
        // Void response = api.addResourceSubscription(deviceId, resourcePath);

        // TODO: test validations
    }

    /**
     * Read subscription status
     *
     * 
     */
    @Test
    public void checkResourceSubscriptionTest() {
        String deviceId = null;
        String resourcePath = null;
        // Void response = api.checkResourceSubscription(deviceId, resourcePath);

        // TODO: test validations
    }

    /**
     * Delete subscriptions from an endpoint.
     *
     * Deletes all resource subscriptions in a single endpoint. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v2/subscriptions/{device-id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
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
     * Removes pre-subscriptions. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v2/subscriptions \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
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
     * Remove an existing subscription from a resource path. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v2/subscriptions/{device-id}/{resourcePath} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteResourceSubscriptionTest() {
        String deviceId = null;
        String resourcePath = null;
        // Void response = api.deleteResourceSubscription(deviceId, resourcePath);

        // TODO: test validations
    }

    /**
     * Read endpoints subscriptions
     *
     * Lists all subscribed resources from a single endpoint. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v2/subscriptions/{device-id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getEndpointSubscriptionsTest() {
        String deviceId = null;
        // String response = api.getEndpointSubscriptions(deviceId);

        // TODO: test validations
    }

    /**
     * Get pre-subscriptions.
     *
     * Retrieve pre-subscription data. The server returns a JSON structure. If there are no pre-subscribed resources, it
     * returns an empty array. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v2/subscriptions \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void getPreSubscriptionsTest() {
        // PresubscriptionArray response = api.getPreSubscriptions();

        // TODO: test validations
    }

    /**
     * Set pre-subscriptions
     *
     * Pre-subscription is a set of rules and patterns established by the application. When an endpoint registers and
     * its ID, type, and registered resources match the pre-subscription data, Device Management Connect automatically
     * sends subscription requests to the device. The pattern may include the endpoint ID (optionally having an
     * &#x60;*&#x60; character at the end), endpoint type, a list of resources, or expressions with an &#x60;*&#x60;
     * character at the end. Subscriptions based on pre-subscriptions are done when device registers or does register
     * update. To remove the pre-subscription data, put an empty array as a rule. **Notification rules** A web
     * application can place dynamic observation rules for individual Object Instances and Resources to define when the
     * device sends observations. More information in [Notification rules](../connecting/resource-change-webapp.html).
     * **Limits**: - The maximum length of the endpoint name and endpoint type is 64 characters. - The maximum length of
     * the resource path is 128 characters. - You can listen to 256 separate resource paths. - The maximum number of
     * pre-subscription entries is 1024. **Example request:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v2/subscriptions \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H
     * &#39;content-type: application/json&#39; \\ -d &#39;[ { \&quot;endpoint-name\&quot;: \&quot;node-001\&quot;,
     * \&quot;resource-path\&quot;: [\&quot;/dev\&quot;] }, { \&quot;endpoint-type\&quot;: \&quot;Light\&quot;,
     * \&quot;resource-path\&quot;: [\&quot;/sen/_*\&quot;] }, { \&quot;endpoint-name\&quot;: \&quot;node*\&quot; }, {
     * \&quot;endpoint-type\&quot;: \&quot;Sensor\&quot; }, { \&quot;resource-path\&quot;:
     * [\&quot;/dev/temp\&quot;,\&quot;/dev/hum\&quot;] } ]&#39; &#x60;&#x60;&#x60; - Subscribe to &#x60;/dev&#x60;
     * resource of endpoint named &#x60;node-001&#x60;. - Subscribe to &#x60;Light&#x60; type of endpoints and their
     * resources prefixed with &#x60;/sen/&#x60;. - Subscribe to all observable resources of endpoint names prefixed
     * with &#x60;node&#x60;. - Subscribe to all observable resources of &#x60;Sensor&#x60; type endpoints. - Subscribe
     * to &#x60;/dev/temp&#x60; and &#x60;/dev/hum&#x60; resources of all endpoints. **Note**: For efficiency, you
     * should use resource path patterns in the pre-subscription data. This prevents notification flow from unwanted
     * resources.
     */
    @Test
    public void updatePreSubscriptionsTest() {
        PresubscriptionArray presubsription = null;
        // Void response = api.updatePreSubscriptions(presubsription);

        // TODO: test validations
    }
}
