package com.arm.mbed.cloud.sdk.security.adapters;

import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollmentListResponse;
import com.arm.mbed.cloud.sdk.security.model.CertificateEnrollment;

public class CertificateEnrollmentAdapter {

    public static
           Mapper<com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment, CertificateEnrollment>
           getMapper() {
        return new Mapper<com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment,
                          CertificateEnrollment>() {

            @Override
            public CertificateEnrollment
                   map(com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment toBeMapped) {
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
