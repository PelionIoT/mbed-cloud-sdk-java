package com.arm.mbed.cloud.sdk.internal.mds.api;

import com.arm.mbed.cloud.sdk.internal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.mds.model.AsyncID;
import com.arm.mbed.cloud.sdk.internal.mds.model.PresubscriptionArray;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * Remove all subscriptions
     *
     * Removes subscriptions from every endpoint and resource. Note that this does not remove pre-subscriptions.
     */
    @Test
    public void v2SubscriptionsDeleteTest() {
        // Void response = api.v2SubscriptionsDelete();

        // TODO: test validations
    }
    
    /**
     * Delete subscriptions from an endpoint
     *
     * Deletes all resource subscriptions in a single endpoint.
     */
    @Test
    public void v2SubscriptionsDeviceIdDeleteTest() {
        String deviceId = null;
        // Void response = api.v2SubscriptionsDeviceIdDelete(deviceId);

        // TODO: test validations
    }
    
    /**
     * Read endpoints subscriptions
     *
     * Lists all subscribed resources from a single endpoint.
     */
    @Test
    public void v2SubscriptionsDeviceIdGetTest() {
        String deviceId = null;
        // Void response = api.v2SubscriptionsDeviceIdGet(deviceId);

        // TODO: test validations
    }
    
    /**
     * Remove a subscription
     *
     * To remove an existing subscription from a resource path. 
     */
    @Test
    public void v2SubscriptionsDeviceIdResourcePathDeleteTest() {
        String deviceId = null;
        String resourcePath = null;
        // Void response = api.v2SubscriptionsDeviceIdResourcePathDelete(deviceId, resourcePath);

        // TODO: test validations
    }
    
    /**
     * Read subscription status
     *
     * 
     */
    @Test
    public void v2SubscriptionsDeviceIdResourcePathGetTest() {
        String deviceId = null;
        String resourcePath = null;
        // Void response = api.v2SubscriptionsDeviceIdResourcePathGet(deviceId, resourcePath);

        // TODO: test validations
    }
    
    /**
     * Subscribe to a resource path
     *
     * The mbed Cloud Connect eventing model consists of observable resources.  This means that endpoints can deliver updated resource content, periodically or with a more sophisticated  solution-dependent logic. The OMA LWM2M resource model including objects, object instances,  resources and resource instances is also supported.  Applications can subscribe to objects, object instances or individual resources to make the device  to provide value change notifications to mbed Cloud Connect service. An application needs to call a &#x60;/notification/callback&#x60; method to get mbed Cloud Connect to push notifications of the resource changes.  The manual subscriptions are removed during a full device registration and applications need to  re-subscribe at that point. To avoid this, you can use &#x60;/subscriptions&#x60; to set a pre-subscription. 
     */
    @Test
    public void v2SubscriptionsDeviceIdResourcePathPutTest() {
        String deviceId = null;
        String resourcePath = null;
        // Void response = api.v2SubscriptionsDeviceIdResourcePathPut(deviceId, resourcePath);

        // TODO: test validations
    }
    
    /**
     * Get pre-subscriptions
     *
     * You can retrieve the pre-subscription data by using a GET operation. The server returns with the same JSON structure  as described above. If there are no pre-subscribed resources, it returns with an empty array. 
     */
    @Test
    public void v2SubscriptionsGetTest() {
        // PresubscriptionArray response = api.v2SubscriptionsGet();

        // TODO: test validations
    }
    
    /**
     * Set pre-subscriptions
     *
     * Pre-subscription is a set of rules and patterns put by the application. When an endpoint registers  and its ID, type and registered resources match the pre-subscription data, mbed Cloud Connect sends  subscription requests to the device automatically. The pattern may include the endpoint ID  (optionally having an &#x60;*&#x60; character at the end), endpoint type, a list of resources or expressions with an &#x60;*&#x60; character at the end. Subscriptions based on pre-subscriptions are done when device registers or does register update. To remove the pre-subscription data, put an empty array as a rule.  &#x60;&#x60;&#x60; Example payload: [  {    \&quot;endpoint-name\&quot;: \&quot;node-001\&quot;,    \&quot;resource-path\&quot;: [\&quot;/dev\&quot;]  },  {    \&quot;endpoint-type\&quot;: \&quot;Light\&quot;,    \&quot;resource-path\&quot;: [\&quot;/sen/_*\&quot;]  },  {    \&quot;endpoint-name\&quot;: \&quot;node*\&quot;  },  {    \&quot;endpoint-type\&quot;: \&quot;Sensor\&quot;  },  {    \&quot;resource-path\&quot;: [\&quot;/dev/temp\&quot;,\&quot;/dev/hum\&quot;]  } ] &#x60;&#x60;&#x60; 
     */
    @Test
    public void v2SubscriptionsPutTest() {
        PresubscriptionArray presubsription = null;
        // Void response = api.v2SubscriptionsPut(presubsription);

        // TODO: test validations
    }
    
}
