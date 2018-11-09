package com.arm.mbed.cloud.sdk.security.adapters;

import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerConfigListResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerConfigRequest;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerConfigResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CreateCertificateIssuerConfig;
import com.arm.mbed.cloud.sdk.security.model.CertificateIssuerConfig;

public class CertificateIssuerConfigAdapter {

    public static Mapper<CertificateIssuerConfigResponse, CertificateIssuerConfig> getMapper() {
        return new Mapper<CertificateIssuerConfigResponse, CertificateIssuerConfig>() {

            @Override
            public CertificateIssuerConfig map(CertificateIssuerConfigResponse toBeMapped) {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }

    public static CreateCertificateIssuerConfig reverseAddMap(CertificateIssuerConfig finalCertificateIssuerConfig) {
        // TODO Auto-generated method stub
        return null;
    }

    public static CertificateIssuerConfigRequest
           reverseUpdateMap(CertificateIssuerConfig finalCertificateIssuerConfig) {
        // TODO Auto-generated method stub
        return null;
    }

    public static Mapper<CertificateIssuerConfigListResponse, ListResponse<CertificateIssuerConfig>> getListMapper() {
        return new Mapper<CertificateIssuerConfigListResponse, ListResponse<CertificateIssuerConfig>>() {

            @Override
            public ListResponse<CertificateIssuerConfig> map(CertificateIssuerConfigListResponse toBeMapped) {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }

}
