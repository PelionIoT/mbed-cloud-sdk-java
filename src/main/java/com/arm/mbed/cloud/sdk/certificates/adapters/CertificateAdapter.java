package com.arm.mbed.cloud.sdk.certificates.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.certificates.model.Certificate;
import com.arm.mbed.cloud.sdk.certificates.model.CertificateStatus;
import com.arm.mbed.cloud.sdk.certificates.model.CertificateType;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.DeveloperCertificateRequestData;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.DeveloperCertificateResponseData;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.ServerCredentialsResponseData;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateResp.ServiceEnum;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateResp.StatusEnum;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateUpdateReq;

@Preamble(description = "Adapter for certificate")
@Internal
public final class CertificateAdapter {

    private CertificateAdapter() {
        super();
    }

    /**
     * Maps certificate.
     *
     * @param iamCertificate
     *            response from Mbed Cloud.
     * @return a partial certificate.
     */
    public static Certificate map(TrustedCertificateResp iamCertificate) {
        if (iamCertificate == null) {
            return null;
        }
        final Certificate certificate = new Certificate(iamCertificate.getId(), iamCertificate.getAccountId(),
                iamCertificate.getSubject(), TranslationUtils.toDate(iamCertificate.getValidity()),
                iamCertificate.getIssuer(), TranslationUtils.toDate(iamCertificate.getCreatedAt()), null, null, null,
                null, null, iamCertificate.getOwnerId());
        certificate.setCertificateData(iamCertificate.getCertificate());
        certificate.setDescription(iamCertificate.getDescription());
        certificate.setName(iamCertificate.getName());
        certificate.setStatus(toStatus(iamCertificate.getStatus()));
        certificate.setType(toType(iamCertificate.getDeviceExecutionMode(), iamCertificate.getService()));
        certificate.setEnrollmentMode(
                TranslationUtils.toBool(iamCertificate.isEnrollmentMode(), Certificate.DEFAULT_ENROLMENT_MODE));
        return certificate;
    }

    /**
     * Maps data regarding server credentials.
     *
     * @param serverResponse
     *            response from Mbed Cloud.
     * @return a partial certificate.
     */
    public static Certificate mapServer(ServerCredentialsResponseData serverResponse) {
        if (serverResponse == null) {
            return null;
        }
        return new Certificate(null, null, null, null, null, null, serverResponse.getServerUri(),
                serverResponse.getServerCertificate(), null, null, null, null);
    }

    /**
     * Maps a developer certificate.
     *
     * @param developerData
     *            response from Mbed Cloud.
     * @return a partial certificate.
     */
    public static Certificate mapDeveloper(DeveloperCertificateResponseData developerData) {
        if (developerData == null) {
            return null;
        }
        return new Certificate(developerData.getId(), null, null, null, null, null, null, null,
                developerData.getSecurityFileContent(), developerData.getDeveloperCertificate(),
                developerData.getDeveloperPrivateKey(), null);
    }

    /**
     * Gets a mapper.
     *
     * @return a mapper.
     */
    public static Mapper<TrustedCertificateResp, Certificate> getMapper() {
        return new Mapper<TrustedCertificateResp, Certificate>() {

            @Override
            public Certificate map(TrustedCertificateResp toBeMapped) {
                return CertificateAdapter.map(toBeMapped);
            }

        };
    }

    /**
     * Gets a mapper for server data.
     *
     * @return a mapper.
     */
    public static Mapper<ServerCredentialsResponseData, Certificate> getServerMapper() {
        return new Mapper<ServerCredentialsResponseData, Certificate>() {

            @Override
            public Certificate map(ServerCredentialsResponseData toBeMapped) {
                return CertificateAdapter.mapServer(toBeMapped);
            }

        };
    }

    /**
     * Gets a mapper for developer data.
     *
     * @return a mapper.
     */
    public static Mapper<DeveloperCertificateResponseData, Certificate> getDeveloperMapper() {
        return new Mapper<DeveloperCertificateResponseData, Certificate>() {

            @Override
            public Certificate map(DeveloperCertificateResponseData toBeMapped) {
                return CertificateAdapter.mapDeveloper(toBeMapped);
            }

        };
    }

    /**
     * Reverses mapping for a new certificate.
     *
     * @param certificate
     *            certificate to add.
     * @return a new certificate request.
     */
    @SuppressWarnings("boxing")
    public static TrustedCertificateReq reverseMapAdd(Certificate certificate) {
        if (certificate == null) {
            return null;
        }
        final TrustedCertificateReq request = new TrustedCertificateReq();
        request.setCertificate(certificate.getCertificateData());
        request.setName(certificate.getName());
        request.setService(reverseAddRequestServiceType(certificate.getType()));
        request.setStatus(reverseAddRequestStatus(certificate.getStatus()));
        request.setSignature(certificate.getSignature());
        request.setDescription(certificate.getDescription());
        request.setEnrollmentMode(certificate.isEnrollmentMode());
        return request;
    }

    /**
     * Reverses mapping for updating a certificate.
     *
     * @param certificate
     *            certificate to update.
     * @return a certificate update request.
     */
    @SuppressWarnings("boxing")
    public static TrustedCertificateUpdateReq reverseMapUpdate(Certificate certificate) {
        if (certificate == null) {
            return null;
        }
        final TrustedCertificateUpdateReq request = new TrustedCertificateUpdateReq();
        if (certificate.hasCertificateDataBeenUpdated()) {
            request.setCertificate(certificate.getCertificateData());
        }
        request.setName(certificate.getName());
        if (certificate.hasTypeBeenUpdated()) {
            request.setService(reverseUpdateRequestServiceType(certificate.getType()));
        }
        if (certificate.hasStatusBeenUpdated()) {
            request.setStatus(reverseUpdateRequestStatus(certificate.getStatus()));
        }
        request.setSignature(certificate.getSignature());
        request.setDescription(certificate.getDescription());
        request.setEnrollmentMode(certificate.isEnrollmentMode());
        return request;
    }

    /**
     * Reverses mapping for a new developer certificate.
     *
     * @param certificate
     *            certificate to add.
     * @return a new certificate request.
     */
    public static DeveloperCertificateRequestData reverseDeveloperMap(Certificate certificate) {
        if (certificate == null) {
            return null;
        }
        final DeveloperCertificateRequestData request = new DeveloperCertificateRequestData();
        request.setDescription(certificate.getDescription());
        request.setName(certificate.getName());
        return request;
    }

    private static CertificateStatus toStatus(StatusEnum status) {
        if (status == null) {
            return CertificateStatus.getUnknownEnum();
        }
        switch (status) {
            case ACTIVE:
                return CertificateStatus.ACTIVE;
            case INACTIVE:
                return CertificateStatus.INACTIVE;
            default:
                return CertificateStatus.getUnknownEnum();
        }

    }

    private static TrustedCertificateReq.StatusEnum reverseAddRequestStatus(CertificateStatus status) {
        switch (status) {
            case ACTIVE:
                return TrustedCertificateReq.StatusEnum.ACTIVE;
            case INACTIVE:
                return TrustedCertificateReq.StatusEnum.INACTIVE;
            default:
                return null;

        }
    }

    private static TrustedCertificateUpdateReq.StatusEnum reverseUpdateRequestStatus(CertificateStatus status) {
        switch (status) {
            case ACTIVE:
                return TrustedCertificateUpdateReq.StatusEnum.ACTIVE;
            case INACTIVE:
                return TrustedCertificateUpdateReq.StatusEnum.INACTIVE;
            default:
                return null;

        }
    }

    private static CertificateType toType(Integer executionMode, ServiceEnum service) {
        if (executionMode != null && executionMode.intValue() == 1) {
            return CertificateType.DEVELOPER;
        }
        CertificateType certificateType = null;
        switch (service) {
            case BOOTSTRAP:
                certificateType = CertificateType.BOOTSTRAP;
                break;
            case LWM2M:
                certificateType = CertificateType.LWM2M;
                break;
            default:
                certificateType = CertificateType.getUnknownEnum();
                break;

        }
        return certificateType;
    }

    private static TrustedCertificateReq.ServiceEnum reverseAddRequestServiceType(CertificateType service) {
        switch (service) {
            case BOOTSTRAP:
                return TrustedCertificateReq.ServiceEnum.BOOTSTRAP;
            case DEVELOPER:
                return TrustedCertificateReq.ServiceEnum.BOOTSTRAP;
            case LWM2M:
                return TrustedCertificateReq.ServiceEnum.LWM2M;
            default:
                return null;

        }
    }

    private static TrustedCertificateUpdateReq.ServiceEnum reverseUpdateRequestServiceType(CertificateType service) {
        switch (service) {
            case BOOTSTRAP:
                return TrustedCertificateUpdateReq.ServiceEnum.BOOTSTRAP;
            case DEVELOPER:
                return TrustedCertificateUpdateReq.ServiceEnum.BOOTSTRAP;
            case LWM2M:
                return TrustedCertificateUpdateReq.ServiceEnum.LWM2M;
            default:
                return null;

        }
    }

    /**
     * Maps list of certificates.
     *
     * @param list
     *            certificate list to map.
     * @return a list of mapped certificates.
     */
    public static ListResponse<Certificate> mapList(TrustedCertificateRespList list) {

        final TrustedCertificateRespList certificateList = list;
        final RespList<TrustedCertificateResp> respList = new RespList<TrustedCertificateResp>() {

            @Override
            public Boolean getHasMore() {
                return (certificateList == null) ? null : certificateList.isHasMore();
            }

            @Override
            public Integer getTotalCount() {
                return (certificateList == null) ? null : certificateList.getTotalCount();
            }

            @Override
            public String getAfter() {
                return (certificateList == null) ? null : certificateList.getAfter();
            }

            @Override
            public Integer getLimit() {
                return (certificateList == null) ? null : certificateList.getLimit();
            }

            @Override
            public String getOrder() {
                return (certificateList == null) ? null : certificateList.getOrder().toString();
            }

            @Override
            public String getContinuationMarker() {
                return null;
            }

            @Override
            public List<TrustedCertificateResp> getData() {
                return (certificateList == null) ? null : certificateList.getData();
            }
        };
        return GenericAdapter.mapList(respList, getMapper());
    }

    /**
     * Gets a list mapper.
     *
     * @return a list mapper.
     */
    public static Mapper<TrustedCertificateRespList, ListResponse<Certificate>> getListMapper() {
        return new Mapper<TrustedCertificateRespList, ListResponse<Certificate>>() {

            @Override
            public ListResponse<Certificate> map(TrustedCertificateRespList toBeMapped) {
                return CertificateAdapter.mapList(toBeMapped);
            }

        };
    }

}
