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
        final String trimmedString = string.trim();
        for (final CertificateStatus status : values()) {
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

    @Override
    public <T extends SDKEnum> T merge(T obj1, T obj2) {
        if (obj1 == null) {
            return obj2;
        }
        if (obj2 == null) {
            return obj1;
        }
        if (obj1.isDefault()) {
            return obj2;
        }
        if (obj2.isDefault()) {
            return obj1;
        }
        return obj2;
    }
}
