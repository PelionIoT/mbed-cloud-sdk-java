package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateGenerationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderCreationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderUpdateReq;

public interface TenantAccountsIdentityProvidersApi {
    /**
     * Create a new identity provider. Create a new identity provider.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param body
     *            Details of the identity provider to create. (required)
     * @param discovery
     *            Indicates that the OpenID Connect endpoints and keys should be set using the OpenID Connect Discovery
     *            mechanism. The following parameters are set automatically: * authorization_endpoint * token_endpoint *
     *            userinfo_endpoint * revocation_endpoint * jwks_uri * keys (optional)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/identity-providers")
    Call<IdentityProviderInfo>
        createAccountIdentityProvider(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                      @retrofit2.http.Body IdentityProviderCreationReq body,
                                      @retrofit2.http.Query("discovery") Boolean discovery);

    /**
     * Delete an identity provider by ID. Delete an identity provider by ID.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param identityProviderId
     *            The ID of the identity provider to delete. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/accounts/{account_id}/identity-providers/{identity_provider_id}")
    Call<Void>
        deleteAccountIdentityProvider(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                      @retrofit2.http.Path(value = "identity_provider_id",
                                                           encoded = true) String identityProviderId);

    /**
     * Delete the service provider certificate. Delete a service provider certificate.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param identityProviderId
     *            The ID of the identity provider whose certificate should be deleted. (required)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/identity-providers/{identity_provider_id}/delete-sp-certificate")
    Call<IdentityProviderInfo>
        deleteAccountSpCertificate(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                   @retrofit2.http.Path(value = "identity_provider_id",
                                                        encoded = true) String identityProviderId);

    /**
     * Generate a new service provider certificate. Generate a new service provider certificate.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param identityProviderId
     *            The ID of the identity provider for which to generate a certificate. (required)
     * @param body
     *            Details of the service provider certificate to be generated. (required)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/identity-providers/{identity_provider_id}/generate-sp-certificate")
    Call<IdentityProviderInfo>
        generateAccountSpCertificate(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                     @retrofit2.http.Path(value = "identity_provider_id",
                                                          encoded = true) String identityProviderId,
                                     @retrofit2.http.Body CertificateGenerationReq body);

    /**
     * Retrieve identity provider by ID. Manage identity providers of a tenant account.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param identityProviderId
     *            The ID of the identity provider to retrieve. (required)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @GET("v3/accounts/{account_id}/identity-providers/{identity_provider_id}")
    Call<IdentityProviderInfo>
        getAccountIdentityProvider(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                   @retrofit2.http.Path(value = "identity_provider_id",
                                                        encoded = true) String identityProviderId);

    /**
     * Get all identity providers. Retrieve identity providers in an array.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param limit
     *            The number of results to return (2-1000). Default 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC. (optional, default to
     *            ASC)
     * @param include
     *            Comma-separated additional data to return. Currently supported: total_count. (optional)
     * @return Call&lt;IdentityProviderList&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @GET("v3/accounts/{account_id}/identity-providers")
    Call<IdentityProviderList>
        getAllAccountIdentityProviders(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                       @retrofit2.http.Query("limit") Integer limit,
                                       @retrofit2.http.Query("after") String after,
                                       @retrofit2.http.Query("order") String order,
                                       @retrofit2.http.Query("include") String include);

    /**
     * Update an existing identity provider. Update an existing identity provider.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param identityProviderId
     *            The ID of the identity provider to update. (required)
     * @param body
     *            Details of the identity provider to update. (required)
     * @param discovery
     *            Indicates that the OpenID Connect endpoints and keys should be set using the OpenID Connect Discovery
     *            mechanism. The following parameters are set automatically: * authorization_endpoint * token_endpoint *
     *            userinfo_endpoint * revocation_endpoint * jwks_uri * keys (optional)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/{account_id}/identity-providers/{identity_provider_id}")
    Call<IdentityProviderInfo>
        updateAccountIdentityProvider(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                      @retrofit2.http.Path(value = "identity_provider_id",
                                                           encoded = true) String identityProviderId,
                                      @retrofit2.http.Body IdentityProviderUpdateReq body,
                                      @retrofit2.http.Query("discovery") Boolean discovery);

}
