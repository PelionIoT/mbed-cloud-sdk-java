package com.arm.mbed.cloud.sdk.security.adapters;

import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment.EnrollResultEnum;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment.EnrollStatusEnum;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollmentListResponse;
import com.arm.mbed.cloud.sdk.security.model.CertificateEnrollment;
import com.arm.mbed.cloud.sdk.security.model.CertificateEnrollmentEnrollResult;
import com.arm.mbed.cloud.sdk.security.model.CertificateEnrollmentEnrollStatus;

public class CertificateEnrollmentAdapter {

    public static
           Mapper<com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment, CertificateEnrollment>
           getMapper() {
        return new Mapper<com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment,
                          CertificateEnrollment>() {

            @Override
            public CertificateEnrollment
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

            private CertificateEnrollmentEnrollStatus translateEnrollStatus(EnrollStatusEnum enrollStatus) {
                // TODO Auto-generated method stub
                return null;
            }

            private CertificateEnrollmentEnrollResult translateEnrollResult(EnrollResultEnum enrollResult) {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }

    public static Mapper<CertificateEnrollmentListResponse, ListResponse<CertificateEnrollment>> getListMapper() {
        return new Mapper<CertificateEnrollmentListResponse, ListResponse<CertificateEnrollment>>() {

            @Override
            public ListResponse<CertificateEnrollment> map(CertificateEnrollmentListResponse toBeMapped) {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }

}
