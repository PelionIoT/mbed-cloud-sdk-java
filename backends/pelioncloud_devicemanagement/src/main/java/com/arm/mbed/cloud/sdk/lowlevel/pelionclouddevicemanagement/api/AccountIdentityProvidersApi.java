package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateGenerationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderCreationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderUpdateReq;

public interface AccountIdentityProvidersApi {
    /**
     * Create a new identity provider. Create a new identity provider.
     * 
     * @param body
     *            Details of the identity provider to create. (required)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/identity-providers")
    Call<IdentityProviderInfo> createIdentityProvider(@retrofit2.http.Body IdentityProviderCreationReq body);

    /**
     * Delete an identity provider by ID. Delete an identity provider by ID.
     * 
     * @param identityProviderId
     *            The ID of the identity provider to delete. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/identity-providers/{identity_provider_id}")
    Call<Void> deleteIdentityProvider(@retrofit2.http.Path(value = "identity_provider_id",
                                                           encoded = true) String identityProviderId);

    /**
     * Delete the service provider certificate. Delete a service provider certificate.
     * 
     * @param identityProviderId
     *            The ID of the identity provider. (required)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/identity-providers/{identity_provider_id}/delete-sp-certificate")
    Call<IdentityProviderInfo> deleteSpCertificate(@retrofit2.http.Path(value = "identity_provider_id",
                                                                        encoded = true) String identityProviderId);

    /**
     * Generate a new service provider certificate. Generate a new service provider certificate.
     * 
     * @param identityProviderId
     *            The ID of the identity provider to generate a certificate for. (required)
     * @param body
     *            Details of the service provider certificate to generate. (optional)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/identity-providers/{identity_provider_id}/generate-sp-certificate")
    Call<IdentityProviderInfo> generateSpCertificate(
                                                     @retrofit2.http.Path(value = "identity_provider_id",
                                                                          encoded = true) String identityProviderId,
                                                     @retrofit2.http.Body CertificateGenerationReq body);

    /**
     * Get all identity providers. Retrieve identity providers in an array.
     * 
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
    @GET("v3/identity-providers")
    Call<IdentityProviderList> getAllIdentityProviders(@retrofit2.http.Query("limit") Integer limit,
                                                       @retrofit2.http.Query("after") String after,
                                                       @retrofit2.http.Query("order") String order,
                                                       @retrofit2.http.Query("include") String include);

    /**
     * Get identity provider by ID. Retrieve by ID.
     * 
     * @param identityProviderId
     *            The ID of the identity provider to retrieve. (required)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @GET("v3/identity-providers/{identity_provider_id}")
    Call<IdentityProviderInfo> getIdentityProvider(@retrofit2.http.Path(value = "identity_provider_id",
                                                                        encoded = true) String identityProviderId);

    /**
     * Update an existing identity provider. Update an existing identity provider.
     * 
     * @param identityProviderId
     *            The ID of the identity provider to update. (required)
     * @param body
     *            Details of the identity provider to update. (required)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/identity-providers/{identity_provider_id}")
    Call<IdentityProviderInfo> updateIdentityProvider(
                                                      @retrofit2.http.Path(value = "identity_provider_id",
                                                                           encoded = true) String identityProviderId,
                                                      @retrofit2.http.Body IdentityProviderUpdateReq body);

}
