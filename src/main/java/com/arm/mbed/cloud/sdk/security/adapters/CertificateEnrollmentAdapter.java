package com.arm.mbed.cloud.sdk.security.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment.EnrollResultEnum;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment.EnrollStatusEnum;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollmentListResponse;
import com.arm.mbed.cloud.sdk.security.model.CertificateEnrollment;
import com.arm.mbed.cloud.sdk.security.model.CertificateEnrollmentEnrollResult;
import com.arm.mbed.cloud.sdk.security.model.CertificateEnrollmentEnrollStatus;

@Preamble(description = "Adapter for certificate enrollment")
@Internal
public class CertificateEnrollmentAdapter {

    /**
     * Constructor.
     */
    private CertificateEnrollmentAdapter() {
        super();
        // Nothing to do
    }

    /**
     * Maps a certificate enrollment.
     * 
     * @param toBeMapped
     *            certificate enrollment to be mapped
     * @return mapped certificate enrollment.
     */
    public static CertificateEnrollment
           map(com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment toBeMapped) {
        if (toBeMapped == null) {
            return null;
        }
        final CertificateEnrollment certificateEnrollment = new CertificateEnrollment();
        certificateEnrollment.setId(toBeMapped.getId());
        certificateEnrollment.setCertificateName(toBeMapped.getCertificateName());
        certificateEnrollment.setCreatedAt(TranslationUtils.toDate(toBeMapped.getCreatedAt()));
        certificateEnrollment.setDeviceId(toBeMapped.getDeviceId());
        certificateEnrollment.setEnrollResult(translateEnrollResult(toBeMapped.getEnrollResult()));
        certificateEnrollment.setEnrollStatus(translateEnrollStatus(toBeMapped.getEnrollStatus()));
        certificateEnrollment.setUpdatedAt(TranslationUtils.toDate(toBeMapped.getUpdatedAt()));
        return certificateEnrollment;
    }

    /**
     * Gets a mapper.
     * 
     * @return a mapper.
     */
    public static
           Mapper<com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment, CertificateEnrollment>
           getMapper() {
        return new Mapper<com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment,
                          CertificateEnrollment>() {

            @Override
            public CertificateEnrollment
                   map(com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment toBeMapped) {
                return CertificateEnrollmentAdapter.map(toBeMapped);
            }

        };
    }

    private static CertificateEnrollmentEnrollStatus translateEnrollStatus(EnrollStatusEnum status) {
        if (status == null) {
            return CertificateEnrollmentEnrollStatus.getUnknownEnum();
        }
        switch (status) {
            case COMPLETED:
                return CertificateEnrollmentEnrollStatus.COMPLETED;
            case NEW:
                return CertificateEnrollmentEnrollStatus.NEW;
            default:
                return CertificateEnrollmentEnrollStatus.getUnknownEnum();
        }
    }

    private static CertificateEnrollmentEnrollResult translateEnrollResult(EnrollResultEnum status) {
        if (status == null) {
            return CertificateEnrollmentEnrollResult.getUnknownEnum();
        }
        switch (status) {
            case FAILURE:
                return CertificateEnrollmentEnrollResult.FAILURE;
            case FORBIDDEN:
                return CertificateEnrollmentEnrollResult.FORBIDDEN;
            case NOT_FOUND:
                return CertificateEnrollmentEnrollResult.NOT_FOUND;
            case SUCCESS:
                return CertificateEnrollmentEnrollResult.SUCCESS;
            default:
                return CertificateEnrollmentEnrollResult.getUnknownEnum();
        }
    }

    /**
     * Maps a list of certificate enrolments.
     *
     * @param list
     *            list of certificate enrolments.
     * @return list of certificate enrolments.
     */
    public static ListResponse<CertificateEnrollment> mapList(CertificateEnrollmentListResponse list) {

        final CertificateEnrollmentListResponse finalList = list;
        final RespList<com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment> respList = new RespList<com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment>() {

            @Override
            public Boolean getHasMore() {
                return (finalList == null) ? null : finalList.isHasMore();
            }

            @Override
            public Integer getTotalCount() {
                return (finalList == null) ? null : finalList.getTotalCount();
            }

            @Override
            public String getAfter() {
                return (finalList == null) ? null : finalList.getAfter();
            }

            @Override
            public Integer getLimit() {
                return (finalList == null) ? null : finalList.getLimit();
            }

            @Override
            public String getOrder() {
                return (finalList == null) ? null : finalList.getOrder().toString();
            }

            @Override
            public List<com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment> getData() {
                return (finalList == null) ? null : finalList.getData();
            }

            @Override
            public String getContinuationMarker() {
                return null;
            }

        };
        return GenericAdapter.mapList(respList, CertificateEnrollmentAdapter.getMapper());
    }

    /**
     * Gets a list mapper.
     * 
     * @return a list mapper
     */
    public static Mapper<CertificateEnrollmentListResponse, ListResponse<CertificateEnrollment>> getListMapper() {
        return new Mapper<CertificateEnrollmentListResponse, ListResponse<CertificateEnrollment>>() {

            @Override
            public ListResponse<CertificateEnrollment> map(CertificateEnrollmentListResponse toBeMapped) {
                return CertificateEnrollmentAdapter.mapList(toBeMapped);
            }
        };
    }

}
