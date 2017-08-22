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
import com.arm.mbed.cloud.sdk.common.ListResponse;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.DeveloperCertificateRequestData;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.DeveloperCertificateResponseData;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.ServerCredentialsResponseData;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateResp.ServiceEnum;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateResp.StatusEnum;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateRespList;

@Preamble(description = "Adapter for certificate")
@Internal
public class CertificateAdapter {

    public static Certificate map(TrustedCertificateResp iamCertificate) {
        if (iamCertificate == null) {
            return null;
        }
        Certificate certificate = new Certificate(iamCertificate.getId(), iamCertificate.getAccountId(),
                iamCertificate.getSubject(), TranslationUtils.toDate(iamCertificate.getValidity()),
                iamCertificate.getIssuer(), TranslationUtils.toDate(iamCertificate.getCreatedAt()), null, null, null,
                null, null, iamCertificate.getOwnerId());
        certificate.setCertificationData(iamCertificate.getCertificate());
        certificate.setDescription(iamCertificate.getDescription());
        certificate.setName(iamCertificate.getName());
        certificate.setStatus(toStatus(iamCertificate.getStatus()));
        certificate.setType(toType(iamCertificate.getDeviceExecutionMode(), iamCertificate.getService()));

        return certificate;
    }

    public static Certificate mapServer(ServerCredentialsResponseData serverResponse) {
        if (serverResponse == null) {
            return null;
        }
        Certificate certificate = new Certificate(null, null, null, null, null, null, serverResponse.getServerUri(),
                serverResponse.getServerCertificate(), null, null, null, null);
        return certificate;
    }

    public static Certificate mapDeveloper(DeveloperCertificateResponseData developerData) {
        if (developerData == null) {
            return null;
        }
        return new Certificate(developerData.getId(), null, null, null, null, null, developerData.getServerUri(),
                developerData.getServerCertificate(), developerData.getSecurityFileContent(),
                developerData.getDeveloperCertificate(), developerData.getDeveloperPrivateKey(), null);
    }

    public static Mapper<TrustedCertificateResp, Certificate> getMapper() {
        return new Mapper<TrustedCertificateResp, Certificate>() {

            @Override
            public Certificate map(TrustedCertificateResp toBeMapped) {
                return CertificateAdapter.map(toBeMapped);
            }

        };
    }

    public static Mapper<ServerCredentialsResponseData, Certificate> getServerMapper() {
        return new Mapper<ServerCredentialsResponseData, Certificate>() {

            @Override
            public Certificate map(ServerCredentialsResponseData toBeMapped) {
                return CertificateAdapter.mapServer(toBeMapped);
            }

        };
    }

    public static Mapper<DeveloperCertificateResponseData, Certificate> getDeveloperMapper() {
        return new Mapper<DeveloperCertificateResponseData, Certificate>() {

            @Override
            public Certificate map(DeveloperCertificateResponseData toBeMapped) {
                return CertificateAdapter.mapDeveloper(toBeMapped);
            }

        };
    }

    public static TrustedCertificateReq reverseMap(Certificate certificate) {
        if (certificate == null) {
            return null;
        }
        TrustedCertificateReq request = new TrustedCertificateReq();
        request.setCertificate(certificate.getCertificationData());
        request.setName(certificate.getName());
        request.setService(toServiceType(certificate.getType()));
        request.setStatus(reverseStatus(certificate.getStatus()));
        request.setSignature(certificate.getSignature());
        request.setDescription(certificate.getDescription());
        return request;
    }

    public static DeveloperCertificateRequestData reverseDeveloperMap(Certificate certificate) {
        if (certificate == null) {
            return null;
        }
        DeveloperCertificateRequestData request = new DeveloperCertificateRequestData();
        request.setDescription(certificate.getDescription());
        request.setName(certificate.getName());
        return request;
    }

    private static CertificateStatus toStatus(StatusEnum status) {
        CertificateStatus certificateStatus = null;
        switch (status) {
            case ACTIVE:
                certificateStatus = CertificateStatus.ACTIVE;
                break;
            case INACTIVE:
                certificateStatus = CertificateStatus.INACTIVE;
                break;
            default:
                certificateStatus = CertificateStatus.getDefault();
                break;

        }
        return certificateStatus;
    }

    private static TrustedCertificateReq.StatusEnum reverseStatus(CertificateStatus status) {
        switch (status) {
            case ACTIVE:
                return TrustedCertificateReq.StatusEnum.ACTIVE;
            case INACTIVE:
                return TrustedCertificateReq.StatusEnum.INACTIVE;
            default:
                return null;

        }
    }

    @SuppressWarnings("boxing")
    private static CertificateType toType(Integer executionMode, ServiceEnum service) {
        if (executionMode != null && executionMode == 1) {
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
                certificateType = CertificateType.getDefault();
                break;

        }
        return certificateType;
    }

    private static TrustedCertificateReq.ServiceEnum toServiceType(CertificateType service) {
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

    public static ListResponse<Certificate> mapList(TrustedCertificateRespList list) {

        final TrustedCertificateRespList certificateList = list;
        RespList<TrustedCertificateResp> respList = new RespList<TrustedCertificateResp>() {

            @Override
            public Boolean getHasMore() {
                return (certificateList == null) ? null : certificateList.getHasMore();
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
            public List<TrustedCertificateResp> getData() {
                return (certificateList == null) ? null : certificateList.getData();
            }
        };
        return GenericAdapter.mapList(respList, getMapper());
    }

    public static Mapper<TrustedCertificateRespList, ListResponse<Certificate>> getListMapper() {
        return new Mapper<TrustedCertificateRespList, ListResponse<Certificate>>() {

            @Override
            public ListResponse<Certificate> map(TrustedCertificateRespList toBeMapped) {
                return CertificateAdapter.mapList(toBeMapped);
            }

        };
    }

}
