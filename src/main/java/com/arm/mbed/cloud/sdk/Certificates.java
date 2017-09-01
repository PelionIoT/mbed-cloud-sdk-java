package com.arm.mbed.cloud.sdk;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.certificates.adapters.CertificateAdapter;
import com.arm.mbed.cloud.sdk.certificates.model.Certificate;
import com.arm.mbed.cloud.sdk.certificates.model.CertificateListOptions;
import com.arm.mbed.cloud.sdk.certificates.model.CertificateType;
import com.arm.mbed.cloud.sdk.certificates.model.EndPoints;
import com.arm.mbed.cloud.sdk.common.AbstractAPI;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudCaller.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.PageRequester;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.DeveloperCertificateResponseData;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.ServerCredentialsResponseData;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateRespList;

import retrofit2.Call;

@Preamble(description = "Specifies Certificates API")
@Module
/**
 * API exposing functionality for dealing with certificates
 */
public class Certificates extends AbstractAPI {

    private static final String TAG_CERTIFICATE = "certificate";
    private static final String TAG_CERTIFICATE_ID = "certificateId";
    private final EndPoints endpoint;

    /**
     * 
     * @param options
     *            connection options
     */
    public Certificates(ConnectionOptions options) {
        super(options);
        endpoint = new EndPoints(this.client);
    }

    @Internal
    private Certificate fetchServerInformation(CertificateType type) throws MbedCloudException {

        CloudCall<ServerCredentialsResponseData> caller = null;
        switch (type) {
            case BOOTSTRAP:
                caller = new CloudCall<ServerCredentialsResponseData>() {

                    @Override
                    public Call<ServerCredentialsResponseData> call() {
                        return endpoint.getServer().v3ServerCredentialsBootstrapGet(null);
                    }

                };
                break;
            case LWM2M:
                caller = new CloudCall<ServerCredentialsResponseData>() {

                    @Override
                    public Call<ServerCredentialsResponseData> call() {
                        return endpoint.getServer().v3ServerCredentialsLwm2mGet(null);
                    }

                };
                break;
            case DEVELOPER:
            default:
                break;
        }
        return (caller == null) ? null
                : CloudCaller.call(this, "getServerCredential()", CertificateAdapter.getServerMapper(), caller);
    }

    /**
     * Lists all certificates according to filter options
     * 
     * @param options
     *            filter options
     * @return The list of certificates corresponding to filter options (One page)
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable ListResponse<Certificate> listCertificates(@Nullable CertificateListOptions options)
            throws MbedCloudException {
        final CertificateListOptions finalOptions = (options == null) ? new CertificateListOptions() : options;
        final String serviceEq = ((CertificateType) finalOptions.getTypeFilter() == CertificateType.DEVELOPER)
                ? CertificateType.BOOTSTRAP.toString()
                : finalOptions.encodeSingleEqualFilter(CertificateListOptions.TYPE_FILTER);
        return CloudCaller.call(this, "listCertificates()", CertificateAdapter.getListMapper(),
                new CloudCall<TrustedCertificateRespList>() {

                    @Override
                    public Call<TrustedCertificateRespList> call() {
                        return endpoint.getAccountDeveloper()
                                .getAllCertificates(finalOptions.getLimit(), finalOptions.getAfter(),
                                        finalOptions.getOrder().toString(), finalOptions.encodeInclude(), serviceEq,
                                        TranslationUtils.convertToInteger(finalOptions
                                                .encodeSingleEqualFilter(CertificateListOptions.EXPIRES_FILTER), null),
                                        finalOptions.getExecutionModeFilter(),
                                        finalOptions.encodeSingleEqualFilter(CertificateListOptions.OWNER_ID_FILTER));
                    }
                });
    }

    /**
     * Gets an iterator over all certificates according to filter options
     * 
     * @param options
     *            filter options
     * @return paginator for the list of certificates corresponding to filter options
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Paginator<Certificate> listAllCertificates(@Nullable CertificateListOptions options)
            throws MbedCloudException {
        final CertificateListOptions finalOptions = options;
        return new Paginator<>(new PageRequester<Certificate>() {

            @Override
            public ListResponse<Certificate> requestNewPage() throws MbedCloudException {
                return listCertificates(finalOptions);
            }
        });
    }

    /**
     * Gets details of a certificate
     * 
     * @param certificateId
     *            The certificate ID
     * @return certificate
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Certificate getCertificate(@NonNull String certificateId) throws MbedCloudException {
        checkNotNull(certificateId, TAG_CERTIFICATE_ID);
        final String id = certificateId;
        final Certificate accountCertificate = CloudCaller.call(this, "getCertificate()",
                CertificateAdapter.getMapper(), new CloudCall<TrustedCertificateResp>() {

                    @Override
                    public Call<TrustedCertificateResp> call() {
                        return endpoint.getAccountDeveloper().getCertificate(id);
                    }
                });
        return Certificate.merge(accountCertificate,
                fetchServerInformation((accountCertificate == null) ? null : accountCertificate.getType()));
    }

    /**
     * Adds a new certificate
     * 
     * @param certificate
     *            Certificate request
     * @return added certificate
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Certificate addCertificate(@NonNull Certificate certificate) throws MbedCloudException {
        checkNotNull(certificate, TAG_CERTIFICATE);
        final Certificate finalCertificate = certificate;
        final Certificate accountCertificate = CloudCaller.call(this, "addCertificate()",
                CertificateAdapter.getMapper(), new CloudCall<TrustedCertificateResp>() {

                    @Override
                    public Call<TrustedCertificateResp> call() {
                        return endpoint.getAdmin().addCertificate(CertificateAdapter.reverseMapAdd(finalCertificate));
                    }
                });
        return Certificate.merge(accountCertificate,
                fetchServerInformation((accountCertificate == null) ? null : accountCertificate.getType()));
    }

    /**
     * Adds a new developper certificate
     * 
     * @param certificate
     *            certificate Certificate request
     * @return added certificate
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public Certificate addDeveloperCertificate(final Certificate certificate) throws MbedCloudException {
        checkNotNull(certificate, TAG_CERTIFICATE);
        final Certificate finalCertificate = certificate;
        final Certificate addedCertificate = CloudCaller.call(this, "addDeveloperCertificate()",
                CertificateAdapter.getDeveloperMapper(), new CloudCall<DeveloperCertificateResponseData>() {

                    @Override
                    public Call<DeveloperCertificateResponseData> call() {
                        return endpoint.getCertDeveloper().v3DeveloperCertificatesPost(null,
                                CertificateAdapter.reverseDeveloperMap(finalCertificate));
                    }
                });
        if (addedCertificate == null) {
            return null;
        }
        Certificate addedCertificate2 = CloudCaller.call(this, "addCertificate()", CertificateAdapter.getMapper(),
                new CloudCall<TrustedCertificateResp>() {

                    @Override
                    public Call<TrustedCertificateResp> call() {
                        return endpoint.getAccountDeveloper().getCertificate(addedCertificate.getId());
                    }
                });
        return Certificate.merge(addedCertificate, addedCertificate2);
    }

    /**
     * Updates a certificate
     * 
     * @param certificate
     *            certificate to update
     * @return updated certificate
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Certificate updateCertificate(@NonNull Certificate certificate) throws MbedCloudException {
        checkNotNull(certificate, TAG_CERTIFICATE);
        final Certificate finalCertificate = certificate;
        return CloudCaller.call(this, "updateCertificate()", CertificateAdapter.getMapper(),
                new CloudCall<TrustedCertificateResp>() {

                    @Override
                    public Call<TrustedCertificateResp> call() {
                        return endpoint.getAccountDeveloper().updateCertificate(finalCertificate.getId(),
                                CertificateAdapter.reverseMapUpdate(finalCertificate));
                    }
                });
    }

    /**
     * Deletes a certificate
     * 
     * @param certificateId
     *            The certificate ID
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public void deleteCertificate(@NonNull String certificateId) throws MbedCloudException {
        checkNotNull(certificateId, TAG_CERTIFICATE_ID);
        final String id = certificateId;
        CloudCaller.call(this, "deleteCertificate()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getAccountDeveloper().deleteCertificate(id);
            }
        });
    }

}
