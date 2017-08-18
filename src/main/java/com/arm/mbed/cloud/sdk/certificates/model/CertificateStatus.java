package com.arm.mbed.cloud.sdk.certificates.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKEnum;

@Preamble(description = "Certificate status")
public enum CertificateStatus implements SDKEnum {
    ACTIVE, INACTIVE;

    @Override
    public boolean isDefault() {
        return this == INACTIVE;
    }

    public static CertificateStatus getDefault() {
        return INACTIVE;
    }

    public static CertificateStatus getStatus(String string) {
        if (string == null) {
            return getDefault();
        }
        String trimmedString = string.trim();
        for (CertificateStatus status : values()) {
            if (status.toString().equalsIgnoreCase(trimmedString)) {
                return status;
            }
        }
        return getDefault();
    }

    @Override
    public String getString() {
        return toString();
    }
}
