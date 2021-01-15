package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccessKey;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Application;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupIdList;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for AccountApplicationsApi
 */
public class AccountApplicationsApiTest {

    private AccountApplicationsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AccountApplicationsApi.class);
    }

    /**
     * Add application to a list of groups.
     *
     * Add application to groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/groups/add
     * \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void addApplicationToGroupsTest() {
        String applicationId = null;
        GroupIdList body = null;
        // Void response = api.addApplicationToGroups(applicationId, body);

        // TODO: test validations
    }

    /**
     * Create a new application.
     *
     * Create a new application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/applications -d &#39;{\&quot;name\&quot;:
     * \&quot;MyApplication1\&quot;}&#39; \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H
     * &#39;content-type: application/json&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void createApplicationTest() {
        Application body = null;
        // Application response = api.createApplication(body);

        // TODO: test validations
    }

    /**
     * Create a new applicationaccess key.
     *
     * Create a new access key for the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/access-keys -d &#39;{\&quot;name\&quot;:
     * \&quot;MyKey1\&quot;}&#39; \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type:
     * application/json&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void createApplicationAccessKeyTest() {
        String applicationId = null;
        AccessKey body = null;
        // AccessKey response = api.createApplicationAccessKey(applicationId, body);

        // TODO: test validations
    }

    /**
     * Delete application.
     *
     * Delete the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/applications/{application_id} \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteApplicationTest() {
        String applicationId = null;
        // Void response = api.deleteApplication(applicationId);

        // TODO: test validations
    }

    /**
     * Delete access key associated with the application.
     *
     * Delete the access key associated with the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/access-keys/{access_key_id} \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteApplicationAccessKeyTest() {
        String applicationId = null;
        String accessKeyId = null;
        // Void response = api.deleteApplicationAccessKey(applicationId, accessKeyId);

        // TODO: test validations
    }

    /**
     * Get all access keys associated with the application.
     *
     * Retrieve an array of access keys associated with the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is
     * restricted to administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/access-keys \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllApplicationAccessKeysTest() {
        String applicationId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String statusEq = null;
        // AccessKeyList response = api.getAllApplicationAccessKeys(applicationId, limit, after, order, include,
        // statusEq);

        // TODO: test validations
    }

    /**
     * Get all applications.
     *
     * Retrieve an array of applications. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/applications \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllApplicationsTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String statusEq = null;
        // ApplicationList response = api.getAllApplications(limit, after, order, include, statusEq);

        // TODO: test validations
    }

    /**
     * Get application.
     *
     * Retrieve details of an application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}
     * \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getApplicationTest() {
        String applicationId = null;
        // Application response = api.getApplication(applicationId);

        // TODO: test validations
    }

    /**
     * Get access key.
     *
     * Retrieve details of an access key associated with the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is
     * restricted to administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/access-keys/{access_key_id} \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getApplicationAccessKeyTest() {
        String applicationId = null;
        String accessKeyId = null;
        // AccessKey response = api.getApplicationAccessKey(applicationId, accessKeyId);

        // TODO: test validations
    }

    /**
     * Get policy groups of an application.
     *
     * Retrieve an array of policy groups associated with an application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is
     * restricted to administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/groups \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getGroupsOfApplicationTest() {
        String applicationId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // GroupSummaryList response = api.getGroupsOfApplication(applicationId, limit, after, order, include);

        // TODO: test validations
    }

    /**
     * Remove application from groups.
     *
     * Remove application from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/groups/remove \\ -H &#39;Authorization:
     * Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeApplicationFromGroupsTest() {
        String applicationId = null;
        GroupIdList body = null;
        // Void response = api.removeApplicationFromGroups(applicationId, body);

        // TODO: test validations
    }

    /**
     * Update applicationdetails.
     *
     * Update application details. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/applications/{application_id} \\ -H &#39;Authorization:
     * Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;:
     * \&quot;TestApplication25\&quot;}&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void updateApplicationTest() {
        String applicationId = null;
        Application body = null;
        // ApiKeyInfoResp response = api.updateApplication(applicationId, body);

        // TODO: test validations
    }

    /**
     * Update access key details.
     *
     * Update access key details. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/applications/{application_id}/access-keys/{access_key_id} \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;{\&quot;name\&quot;: \&quot;TestAccessKey\&quot;}&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void updateApplicationAccessKeyTest() {
        String applicationId = null;
        String accessKeyId = null;
        AccessKey body = null;
        // AccessKey response = api.updateApplicationAccessKey(applicationId, accessKeyId, body);

        // TODO: test validations
    }
}
