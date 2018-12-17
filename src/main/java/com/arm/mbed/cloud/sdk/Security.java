package com.arm.mbed.cloud.sdk;

import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.PageRequester;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Device;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollmentListResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerConfigListResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerConfigResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerInfo;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerInfoListResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerVerifyResponse;
import com.arm.mbed.cloud.sdk.security.adapters.CertificateEnrollmentAdapter;
import com.arm.mbed.cloud.sdk.security.adapters.CertificateIssuerAdapter;
import com.arm.mbed.cloud.sdk.security.adapters.CertificateIssuerConfigAdapter;
import com.arm.mbed.cloud.sdk.security.adapters.VerificationResponseAdapter;
import com.arm.mbed.cloud.sdk.security.model.CertificateEnrollment;
import com.arm.mbed.cloud.sdk.security.model.CertificateEnrollmentListOptions;
import com.arm.mbed.cloud.sdk.security.model.CertificateIssuer;
import com.arm.mbed.cloud.sdk.security.model.CertificateIssuerConfig;
import com.arm.mbed.cloud.sdk.security.model.CertificateIssuerConfigListOptions;
import com.arm.mbed.cloud.sdk.security.model.CertificateIssuerListOptions;
import com.arm.mbed.cloud.sdk.security.model.EndPoints;
import com.arm.mbed.cloud.sdk.security.model.VerificationResponse;

import retrofit2.Call;

@Preamble(description = "Specifies Security APIs")
@Module
/**
 * API exposing functionality for dealing with external certificates and their enrolments
 */
public class Security extends AbstractApi {

    private static final String TAG_CERTIFICATE_ISSUER_CONFIG = "certificateIssuerConfig";
    private static final String CERTIFICATE_ISSUER_CONFIG_ID = "certificateIssuerConfigId";
    private static final String TAG_CERTIFICATE_ISSUER_ID = "certificateIssuerId";
    private static final String TAG_ISSUER_CONFIGURATION = "issuerConfiguration";
    private static final String TAG_DEVICE = "device";
    private static final String TAG_ISSUER_CONFIGURATION_REFERENCE = "issuerConfigurationReference";
    private static final String TAG_DEVICE_ID = "deviceId";
    private static final String TAG_CERTIFICATE_ISSUER = "certificateIssuer";
    private final EndPoints endpoint;

    /**
     * Update module constructor.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}.
     */
    public Security(@NonNull ConnectionOptions options) {
        super(options);
        endpoint = new EndPoints(this.serviceRegistry);
    }

    /**
     * Renews a certificate.
     * 
     * @param deviceId
     *            device Id.
     * @param issuerConfigurationReference
     *            Certificate issuer configuration.
     * @return the certificate enrolment
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public @Nullable CertificateEnrollment
           renewCertificate(@NonNull String deviceId,
                            @NonNull String issuerConfigurationReference) throws MbedCloudException {
        checkNotNull(deviceId, TAG_DEVICE_ID);
        checkNotNull(issuerConfigurationReference, TAG_ISSUER_CONFIGURATION_REFERENCE);
        final String finalDeviceId = deviceId;
        final String finalIssuerConfigurationReference = issuerConfigurationReference;
        return CloudCaller.call(this, "renewCertificate()", CertificateEnrollmentAdapter.getMapper(),
                                new CloudCall<com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment>() {

                                    @Override
                                    public Call<com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment>
                                           call() {
                                        return endpoint.getCertificateRenewal()
                                                       .requestCertificateRenewal(finalDeviceId,
                                                                                  finalIssuerConfigurationReference);
                                    }

                                });

    }

    /**
     * Renews a certificate.
     * 
     * @param device
     *            device to renew the certificate for.
     * @param issuerConfiguration
     *            Certificate issuer configuration.
     * @return the certificate enrolment
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public @Nullable CertificateEnrollment
           renewCertificate(@NonNull Device device,
                            @NonNull CertificateIssuerConfig issuerConfiguration) throws MbedCloudException {
        checkNotNull(device, TAG_DEVICE);
        checkNotNull(issuerConfiguration, TAG_ISSUER_CONFIGURATION);
        return renewCertificate(device.getId(), issuerConfiguration.getCertificateReference());
    }

    /**
     * Gets a certificate enrolment.
     * 
     * @param certificateEnrollmentId
     *            id.
     * @return corresponding certificate enrolment.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public @Nullable CertificateEnrollment
           getCertificateEnrollment(@NonNull String certificateEnrollmentId) throws MbedCloudException {

        final String finalCertificateEnrollmentId = certificateEnrollmentId;
        return CloudCaller.call(this, "getCertificateEnrollment()", CertificateEnrollmentAdapter.getMapper(),
                                new CloudCall<com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment>() {

                                    @Override
                                    public Call<com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment>
                                           call() {
                                        return endpoint.getCertificateEnrollment()
                                                       .getCertificateEnrollment(finalCertificateEnrollmentId);
                                    }

                                });
    }

    /**
     * Lists all certificate enrolments according to filter options.
     * 
     * @param options
     *            list options
     * @return the list of certificate enrolments corresponding to filter options (One page).
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public @Nullable ListResponse<CertificateEnrollment>
           listCertificateEnrollments(@Nullable CertificateEnrollmentListOptions options) throws MbedCloudException {
        final CertificateEnrollmentListOptions finalOptions = (options == null) ? new CertificateEnrollmentListOptions()
                                                                                : options;

        return CloudCaller.call(this, "listCertificateEnrollments()", CertificateEnrollmentAdapter.getListMapper(),
                                new CloudCall<CertificateEnrollmentListResponse>() {

                                    @Override
                                    public Call<CertificateEnrollmentListResponse> call() {
                                        return endpoint.getCertificateEnrollment()
                                                       .getCertificateEnrollments(finalOptions.encodeSingleEqualFilter(CertificateEnrollmentListOptions.DEVICE_ID_FILTER),
                                                                                  finalOptions.encodeSingleEqualFilter(CertificateEnrollmentListOptions.CERTIFICATE_NAME_FILTER),
                                                                                  finalOptions.getPageSize(),
                                                                                  finalOptions.getAfter(),
                                                                                  finalOptions.getOrder().toString(),
                                                                                  finalOptions.encodeInclude(),
                                                                                  finalOptions.encodeSingleNotEqualFilter(CertificateEnrollmentListOptions.ENROLL_STATUS_FILTER),
                                                                                  finalOptions.encodeSingleEqualFilter(CertificateEnrollmentListOptions.ENROLL_STATUS_FILTER),
                                                                                  finalOptions.encodeSingleNotEqualFilter(CertificateEnrollmentListOptions.ENROLL_RESULT_FILTER),
                                                                                  finalOptions.encodeSingleEqualFilter(CertificateEnrollmentListOptions.ENROLL_RESULT_FILTER),
                                                                                  finalOptions.encodeSingleLessThanFilter(CertificateEnrollmentListOptions.CREATED_AT_FILTER),
                                                                                  finalOptions.encodeSingleGreaterThanFilter(CertificateEnrollmentListOptions.CREATED_AT_FILTER),
                                                                                  finalOptions.encodeSingleLessThanFilter(CertificateEnrollmentListOptions.UPDATED_AT_FILTER),
                                                                                  finalOptions.encodeSingleGreaterThanFilter(CertificateEnrollmentListOptions.UPDATED_AT_FILTER));
                                    }
                                });
    }

    /**
     * Gets an iterator over all certificate enrolment according to filter options.
     * 
     * @param options
     *            list options
     * @return paginator @see {@link Paginator} for the list of certificate enrolment corresponding to filter options.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public @Nullable Paginator<CertificateEnrollment>
           listAllCertificateEnrollments(@Nullable CertificateEnrollmentListOptions options) throws MbedCloudException {
        return new Paginator<>((options == null) ? new CertificateEnrollmentListOptions() : options,
                               new PageRequester<CertificateEnrollment>() {

                                   @Override
                                   public ListResponse<CertificateEnrollment>
                                          requestNewPage(ListOptions opt) throws MbedCloudException {
                                       return listCertificateEnrollments((CertificateEnrollmentListOptions) opt);
                                   }
                               });
    }

    /**
     * Gets a certificate issuer.
     * 
     * @param certificateIssuerId
     *            issuer id.
     * @return corresponding issuer.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public @Nullable CertificateIssuer
           getCertificateIssuer(@NonNull String certificateIssuerId) throws MbedCloudException {
        checkNotNull(certificateIssuerId, TAG_CERTIFICATE_ISSUER_ID);
        final String finalId = certificateIssuerId;
        return CloudCaller.call(this, "getCertificateIssuer()", CertificateIssuerAdapter.getMapper(),
                                new CloudCall<CertificateIssuerInfo>() {

                                    @Override
                                    public Call<CertificateIssuerInfo> call() {
                                        return endpoint.getCertificateIssuers().getCertificateIssuer(finalId);
                                    }

                                });
    }

    /**
     * Adds a certificate issuer.
     * 
     * @param certificateIssuer
     *            an issuer.
     * @param certificateIssuerCredentials
     *            credentials.
     * @return added certificate issuer.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public @Nullable CertificateIssuer
           addCertificateIssuer(@NonNull CertificateIssuer certificateIssuer,
                                @Nullable Map<String, String> certificateIssuerCredentials) throws MbedCloudException {
        checkNotNull(certificateIssuer, TAG_CERTIFICATE_ISSUER);
        checkModelValidity(certificateIssuer, TAG_CERTIFICATE_ISSUER);
        final CertificateIssuer finalCertificateIssuer = certificateIssuer;
        final Map<String, String> finalCertificateIssuerCredentials = certificateIssuerCredentials;
        return CloudCaller.call(this, "addCertificateIssuer()", CertificateIssuerAdapter.getMapper(),
                                new CloudCall<CertificateIssuerInfo>() {

                                    @Override
                                    public Call<CertificateIssuerInfo> call() {
                                        return endpoint.getCertificateIssuers()
                                                       .createCertificateIssuer(CertificateIssuerAdapter.reverseAddMap(finalCertificateIssuerCredentials,
                                                                                                                       finalCertificateIssuer));
                                    }

                                });
    }

    /**
     * 
     * Modifies a certificate issuer.
     * 
     * @param certificateIssuer
     *            an issuer.
     * @param certificateIssuerCredentials
     *            credentials.
     * @return updated certificate issuer.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public @Nullable CertificateIssuer
           updateCertificateIssuer(@NonNull CertificateIssuer certificateIssuer,
                                   @Nullable Map<String,
                                                 String> certificateIssuerCredentials) throws MbedCloudException {
        checkNotNull(certificateIssuer, TAG_CERTIFICATE_ISSUER);
        checkModelValidity(certificateIssuer, TAG_CERTIFICATE_ISSUER);
        final CertificateIssuer finalCertificateIssuer = certificateIssuer;
        final Map<String, String> finalCertificateIssuerCredentials = certificateIssuerCredentials;
        return CloudCaller.call(this, "addCertificateIssuer()", CertificateIssuerAdapter.getMapper(),
                                new CloudCall<CertificateIssuerInfo>() {

                                    @Override
                                    public Call<CertificateIssuerInfo> call() {
                                        return endpoint.getCertificateIssuers()
                                                       .updateCertificateIssuer(finalCertificateIssuer.getId(),
                                                                                CertificateIssuerAdapter.reverseUpdateMap(finalCertificateIssuerCredentials,
                                                                                                                          finalCertificateIssuer));
                                    }

                                });
    }

    /**
     * Deletes a certificate issuer.
     * 
     * @param certificateIssuerId
     *            issuer id.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public void deleteCertificateIssuer(@NonNull String certificateIssuerId) throws MbedCloudException {
        checkNotNull(certificateIssuerId, TAG_CERTIFICATE_ISSUER_ID);
        final String finalId = certificateIssuerId;
        CloudCaller.call(this, "deleteCertificateIssuer()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getCertificateIssuers().deleteCertificateIssuer(finalId);
            }

        });
    }

    /**
     * Deletes a certificate issuer.
     * 
     * @param certificateIssuer
     *            issuer
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public void deleteCertificateIssuer(@NonNull CertificateIssuer certificateIssuer) throws MbedCloudException {
        checkNotNull(certificateIssuer, TAG_CERTIFICATE_ISSUER);
        deleteCertificateIssuer(certificateIssuer.getId());
    }

    /**
     * Verifies certificate issuer.
     * 
     * @param certificateIssuerId
     *            issuer ID.
     * @return a verification response.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public VerificationResponse verifyCertificateIssuer(@NonNull String certificateIssuerId) throws MbedCloudException {
        checkNotNull(certificateIssuerId, TAG_CERTIFICATE_ISSUER_ID);
        final String finalId = certificateIssuerId;
        return CloudCaller.call(this, "verifyCertificateIssuer()", VerificationResponseAdapter.getMapper(),
                                new CloudCall<CertificateIssuerVerifyResponse>() {

                                    @Override
                                    public Call<CertificateIssuerVerifyResponse> call() {
                                        return endpoint.getCertificateIssuers().verifyCertificateIssuer(finalId);
                                    }

                                });
    }

    /**
     * Verifies certificate issuer.
     * 
     * @param certificateIssuer
     *            issuer to verify.
     * @return a verification response.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public VerificationResponse
           verifyCertificateIssuer(@NonNull CertificateIssuer certificateIssuer) throws MbedCloudException {
        checkNotNull(certificateIssuer, TAG_CERTIFICATE_ISSUER);
        return verifyCertificateIssuer(certificateIssuer.getId());
    }

    /**
     * Lists all certificate issuers according to filter options.
     * 
     * @param options
     *            list options
     * @return the list of certificate issuers corresponding to filter options (One page).
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public @Nullable ListResponse<CertificateIssuer>
           listCertificateIssuers(@Nullable CertificateIssuerListOptions options) throws MbedCloudException {
        final CertificateIssuerListOptions finalOptions = (options == null) ? new CertificateIssuerListOptions()
                                                                            : options;
        return CloudCaller.call(this, "listCertificateIssuers()", CertificateIssuerAdapter.getListMapper(),
                                new CloudCall<CertificateIssuerInfoListResponse>() {

                                    @Override
                                    public Call<CertificateIssuerInfoListResponse> call() {
                                        return endpoint.getCertificateIssuers()
                                                       .getCertificateIssuers(finalOptions.getPageSize(),
                                                                              finalOptions.getOrder().toString(),
                                                                              finalOptions.getAfter(),
                                                                              finalOptions.encodeInclude());
                                    }
                                });
    }

    /**
     * 
     * Gets an iterator over all certificate issuers according to filter options.
     * 
     * @param options
     *            list options
     * @return paginator @see {@link Paginator} for the list of certificate issuers corresponding to filter options.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public @Nullable Paginator<CertificateIssuer>
           listAllCertificateIssuers(@Nullable CertificateIssuerListOptions options) throws MbedCloudException {
        return new Paginator<>((options == null) ? new CertificateIssuerListOptions() : options,
                               new PageRequester<CertificateIssuer>() {

                                   @Override
                                   public ListResponse<CertificateIssuer>
                                          requestNewPage(ListOptions opt) throws MbedCloudException {
                                       return listCertificateIssuers((CertificateIssuerListOptions) opt);
                                   }
                               });
    }

    /**
     * Gets a certificate issuer configuration.
     * 
     * @param certificateIssuerConfigId
     *            configuration id.
     * @return corresponding certificate issuer configuration
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public @Nullable CertificateIssuerConfig
           getCertificateIssuerConfig(@NonNull String certificateIssuerConfigId) throws MbedCloudException {
        checkNotNull(certificateIssuerConfigId, CERTIFICATE_ISSUER_CONFIG_ID);
        final String finalId = certificateIssuerConfigId;
        return CloudCaller.call(this, "getCertificateIssuerConfig()", CertificateIssuerConfigAdapter.getMapper(),
                                new CloudCall<CertificateIssuerConfigResponse>() {

                                    @Override
                                    public Call<CertificateIssuerConfigResponse> call() {
                                        return endpoint.getCertificateIssuersActivation()
                                                       .getCertificateIssuerConfigByID(finalId);
                                    }

                                });
    }

    /**
     * Adds a certificate issuer configuration.
     * 
     * @param certificateIssuerConfig
     *            configuration.
     * @return added configuration
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public @Nullable CertificateIssuerConfig
           addCertificateIssuerConfig(@NonNull CertificateIssuerConfig certificateIssuerConfig) throws MbedCloudException {
        checkNotNull(certificateIssuerConfig, TAG_CERTIFICATE_ISSUER_CONFIG);
        checkModelValidity(certificateIssuerConfig, TAG_CERTIFICATE_ISSUER_CONFIG);
        final CertificateIssuerConfig finalCertificateIssuerConfig = certificateIssuerConfig;
        return CloudCaller.call(this, "addCertificateIssuerConfig()", CertificateIssuerConfigAdapter.getMapper(),
                                new CloudCall<CertificateIssuerConfigResponse>() {

                                    @Override
                                    public Call<CertificateIssuerConfigResponse> call() {
                                        return endpoint.getCertificateIssuersActivation()
                                                       .createCertificateIssuerConfig(CertificateIssuerConfigAdapter.reverseAddMap(finalCertificateIssuerConfig));
                                    }

                                });
    }

    /**
     * Modifies a certificate issuer configuration.
     * 
     * @param certificateIssuerConfig
     *            configuration.
     * @return corresponding configuration.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public @Nullable CertificateIssuerConfig
           updateCertificateIssuerConfig(@NonNull CertificateIssuerConfig certificateIssuerConfig) throws MbedCloudException {
        checkNotNull(certificateIssuerConfig, TAG_CERTIFICATE_ISSUER_CONFIG);
        checkModelValidity(certificateIssuerConfig, TAG_CERTIFICATE_ISSUER_CONFIG);
        final CertificateIssuerConfig finalCertificateIssuerConfig = certificateIssuerConfig;
        return CloudCaller.call(this, "updateCertificateIssuerConfig()", CertificateIssuerConfigAdapter.getMapper(),
                                new CloudCall<CertificateIssuerConfigResponse>() {

                                    @Override
                                    public Call<CertificateIssuerConfigResponse> call() {
                                        return endpoint.getCertificateIssuersActivation()
                                                       .updateCertificateIssuerConfigByID(finalCertificateIssuerConfig.getId(),
                                                                                          CertificateIssuerConfigAdapter.reverseUpdateMap(finalCertificateIssuerConfig));
                                    }

                                });
    }

    /**
     * Deletes a certificate issuer configuration.
     * 
     * @param certificateIssuerConfigId
     *            configuration id.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public void deleteCertificateIssuerConfig(@NonNull String certificateIssuerConfigId) throws MbedCloudException {
        checkNotNull(certificateIssuerConfigId, CERTIFICATE_ISSUER_CONFIG_ID);
        final String finalId = certificateIssuerConfigId;
        CloudCaller.call(this, "deleteCertificateIssuerConfig()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getCertificateIssuersActivation().deleteCertificateIssuerConfigByID(finalId);
            }

        });
    }

    /**
     * Deletes a certificate issuer configuration.
     * 
     * @param certificateIssuerConfig
     *            configuration
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public void
           deleteCertificateIssuerConfig(@NonNull CertificateIssuerConfig certificateIssuerConfig) throws MbedCloudException {
        checkNotNull(certificateIssuerConfig, TAG_CERTIFICATE_ISSUER_CONFIG);
        deleteCertificateIssuerConfig(certificateIssuerConfig.getId());
    }

    /**
     * Lists all certificate issuer configurations according to filter options.
     * 
     * @param options
     *            list options
     * @return the list of certificate issuer configurations corresponding to filter options (One page).
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public @Nullable ListResponse<CertificateIssuerConfig>
           listCertificateIssuerConfigs(@Nullable CertificateIssuerConfigListOptions options) throws MbedCloudException {
        final CertificateIssuerConfigListOptions finalOptions = (options == null) ? new CertificateIssuerConfigListOptions()
                                                                                  : options;
        return CloudCaller.call(this, "listCertificateIssuerConfigs()", CertificateIssuerConfigAdapter.getListMapper(),
                                new CloudCall<CertificateIssuerConfigListResponse>() {

                                    @Override
                                    public Call<CertificateIssuerConfigListResponse> call() {
                                        return endpoint.getCertificateIssuersActivation()
                                                       .getCertificateIssuerConfigs(finalOptions.getPageSize(),
                                                                                    finalOptions.getOrder().toString(),
                                                                                    finalOptions.getAfter(),
                                                                                    finalOptions.encodeInclude(),
                                                                                    finalOptions.encodeSingleEqualFilter(CertificateIssuerConfigListOptions.CERTIFICATE_REFERENCE_FILTER));
                                    }
                                });
    }

    /**
     * Gets an iterator over all certificate issuer configurations according to filter options.
     * 
     * @param options
     *            list options
     * @return paginator @see {@link Paginator} for the list of certificate issuer configurations corresponding to
     *         filter options.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @API
    public @Nullable Paginator<CertificateIssuerConfig>
           listAllCertificateIssuerConfigs(@Nullable CertificateIssuerConfigListOptions options) throws MbedCloudException {
        return new Paginator<>((options == null) ? new CertificateIssuerConfigListOptions() : options,
                               new PageRequester<CertificateIssuerConfig>() {

                                   @Override
                                   public ListResponse<CertificateIssuerConfig>
                                          requestNewPage(ListOptions opt) throws MbedCloudException {
                                       return listCertificateIssuerConfigs((CertificateIssuerConfigListOptions) opt);
                                   }
                               });
    }

    /**
     * Retrieves module name.
     *
     * @return module name.
     */
    @Override
    public String getModuleName() {
        return "Security";
    }
}
