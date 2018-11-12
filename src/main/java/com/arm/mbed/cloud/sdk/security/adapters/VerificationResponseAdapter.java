package com.arm.mbed.cloud.sdk.security.adapters;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerVerifyResponse;
import com.arm.mbed.cloud.sdk.security.model.VerificationResponse;

@Preamble(description = "Adapter for verification response model")
@Internal
public final class VerificationResponseAdapter {

    private VerificationResponseAdapter() {
        super();
    }

    /**
     * Maps verification response.
     * 
     * @param response
     *            response to map.
     * @return response.
     */
    public static VerificationResponse map(CertificateIssuerVerifyResponse response) {
        if (response == null) {
            return null;
        }
        return new VerificationResponse(TranslationUtils.toBool(response.isSuccessful(), false), response.getMessage());
    }

    /**
     * Gets a mapper.
     * 
     * @return a mapper.
     */
    public static Mapper<CertificateIssuerVerifyResponse, VerificationResponse> getMapper() {
        return new Mapper<CertificateIssuerVerifyResponse, VerificationResponse>() {

            @Override
            public VerificationResponse map(CertificateIssuerVerifyResponse toBeMapped) {
                return VerificationResponseAdapter.map(toBeMapped);
            }

        };
    }

}
