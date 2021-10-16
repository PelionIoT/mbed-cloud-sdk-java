package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateGenerationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderCreationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderUpdateReq;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for AccountIdentityProvidersApi
 */
public class AccountIdentityProvidersApiTest {

    private AccountIdentityProvidersApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AccountIdentityProvidersApi.class);
    }

    /**
     * Create a new identity provider.
     *
     * Create a new identity provider. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     */
    @Test
    public void createIdentityProviderTest() {
        IdentityProviderCreationReq body = null;
        Boolean discovery = null;
        // IdentityProviderInfo response = api.createIdentityProvider(body, discovery);

        // TODO: test validations
    }

    /**
     * Delete an identity provider by ID.
     *
     * Delete an identity provider by ID. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     */
    @Test
    public void deleteIdentityProviderTest() {
        String identityProviderId = null;
        // Void response = api.deleteIdentityProvider(identityProviderId);

        // TODO: test validations
    }

    /**
     * Delete the service provider certificate.
     *
     * Delete a service provider certificate. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     */
    @Test
    public void deleteSpCertificateTest() {
        String identityProviderId = null;
        // IdentityProviderInfo response = api.deleteSpCertificate(identityProviderId);

        // TODO: test validations
    }

    /**
     * Generate a new service provider certificate.
     *
     * Generate a new service provider certificate. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators.
     */
    @Test
    public void generateSpCertificateTest() {
        String identityProviderId = null;
        CertificateGenerationReq body = null;
        // IdentityProviderInfo response = api.generateSpCertificate(identityProviderId, body);

        // TODO: test validations
    }

    /**
     * Get all identity providers.
     *
     * Retrieve an array of identity providers. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     */
    @Test
    public void getAllIdentityProvidersTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // IdentityProviderList response = api.getAllIdentityProviders(limit, after, order, include);

        // TODO: test validations
    }

    /**
     * Get identity provider.
     *
     * Retrieve an identity provider. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     */
    @Test
    public void getIdentityProviderTest() {
        String identityProviderId = null;
        // IdentityProviderInfo response = api.getIdentityProvider(identityProviderId);

        // TODO: test validations
    }

    /**
     * Refreshes the OIDC signing keys.
     *
     * Refreshes an OIDC IdP&#39;s signing keys. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     */
    @Test
    public void refreshJwksTest() {
        String identityProviderId = null;
        // IdentityProviderInfo response = api.refreshJwks(identityProviderId);

        // TODO: test validations
    }

    /**
     * Update an existing identity provider.
     *
     * Update an existing identity provider. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     */
    @Test
    public void updateIdentityProviderTest() {
        String identityProviderId = null;
        IdentityProviderUpdateReq body = null;
        Boolean discovery = null;
        // IdentityProviderInfo response = api.updateIdentityProvider(identityProviderId, body, discovery);

        // TODO: test validations
    }
}
