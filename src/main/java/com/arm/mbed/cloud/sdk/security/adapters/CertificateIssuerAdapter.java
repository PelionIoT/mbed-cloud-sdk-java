package com.arm.mbed.cloud.sdk.security.adapters;

import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerInfo;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerInfoListResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerRequest;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerUpdateRequest;
import com.arm.mbed.cloud.sdk.security.model.CertificateIssuer;

public class CertificateIssuerAdapter {

    public static Mapper<CertificateIssuerInfo, CertificateIssuer> getMapper() {
        return new Mapper<CertificateIssuerInfo, CertificateIssuer>() {

            @Override
            public CertificateIssuer map(CertificateIssuerInfo toBeMapped) {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }

    public static CertificateIssuerRequest reverseAddMap(CertificateIssuer finalCertificateIssuer) {
        // TODO Auto-generated method stub
        return null;
    }

    public static CertificateIssuerUpdateRequest reverseUpdateMap(CertificateIssuer finalCertificateIssuer) {
        // TODO Auto-generated method stub
        return null;
    }

    public static Mapper<CertificateIssuerInfoListResponse, ListResponse<CertificateIssuer>> getListMapper() {
        return new Mapper<CertificateIssuerInfoListResponse, ListResponse<CertificateIssuer>>() {

            @Override
            public ListResponse<CertificateIssuer> map(CertificateIssuerInfoListResponse toBeMapped) {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }

}
