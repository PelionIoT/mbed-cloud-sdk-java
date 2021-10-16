package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateGenerationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderCreationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderUpdateReq;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for TenantAccountsIdentityProvidersApi
 */
public class TenantAccountsIdentityProvidersApiTest {

    private TenantAccountsIdentityProvidersApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TenantAccountsIdentityProvidersApi.class);
    }

    /**
     * Create a new identity provider.
     *
     * Create a new identity provider. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     */
    @Test
    public void createAccountIdentityProviderTest() {
        String accountId = null;
        IdentityProviderCreationReq body = null;
        Boolean discovery = null;
        // IdentityProviderInfo response = api.createAccountIdentityProvider(accountId, body, discovery);

        // TODO: test validations
    }

    /**
     * Delete an identity provider by ID.
     *
     * Delete an identity provider by ID. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     */
    @Test
    public void deleteAccountIdentityProviderTest() {
        String accountId = null;
        String identityProviderId = null;
        // Void response = api.deleteAccountIdentityProvider(accountId, identityProviderId);

        // TODO: test validations
    }

    /**
     * Delete the service provider certificate.
     *
     * Delete a service provider certificate. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     */
    @Test
    public void deleteAccountSpCertificateTest() {
        String accountId = null;
        String identityProviderId = null;
        // IdentityProviderInfo response = api.deleteAccountSpCertificate(accountId, identityProviderId);

        // TODO: test validations
    }

    /**
     * Generate a new service provider certificate.
     *
     * Generate a new service provider certificate. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators.
     */
    @Test
    public void generateAccountSpCertificateTest() {
        String accountId = null;
        String identityProviderId = null;
        CertificateGenerationReq body = null;
        // IdentityProviderInfo response = api.generateAccountSpCertificate(accountId, identityProviderId, body);

        // TODO: test validations
    }

    /**
     * Get an identity provider.
     *
     * Retrieve an identity provider. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     */
    @Test
    public void getAccountIdentityProviderTest() {
        String accountId = null;
        String identityProviderId = null;
        // IdentityProviderInfo response = api.getAccountIdentityProvider(accountId, identityProviderId);

        // TODO: test validations
    }

    /**
     * Get all identity providers.
     *
     * Retrieve an array of identity providers. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     */
    @Test
    public void getAllAccountIdentityProvidersTest() {
        String accountId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // IdentityProviderList response = api.getAllAccountIdentityProviders(accountId, limit, after, order, include);

        // TODO: test validations
    }

    /**
     * Refresh the OIDC signing keys.
     *
     * Refresh an OIDC IdP&#39;s signing keys. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     */
    @Test
    public void refreshAccountJwksTest() {
        String accountId = null;
        String identityProviderId = null;
        // IdentityProviderInfo response = api.refreshAccountJwks(accountId, identityProviderId);

        // TODO: test validations
    }

    /**
     * Update an existing identity provider.
     *
     * Update an existing identity provider. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     */
    @Test
    public void updateAccountIdentityProviderTest() {
        String accountId = null;
        String identityProviderId = null;
        IdentityProviderUpdateReq body = null;
        Boolean discovery = null;
        // IdentityProviderInfo response = api.updateAccountIdentityProvider(accountId, identityProviderId, body,
        // discovery);

        // TODO: test validations
    }
}
