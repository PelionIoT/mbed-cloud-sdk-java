package com.arm.mbed.cloud.sdk.certificates.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKEnum;

@Preamble(description = "Certificate type")
public enum CertificateType implements SDKEnum {
    DEVELOPER("developer"), BOOTSTRAP("bootstrap"), LWM2M("lwm2m");

    private final String value;

    private CertificateType(String string) {
        this.value = string;
    }

    /**
     * @return the string
     */
    @Override
    public String toString() {
        return getString();
    }

    /**
     * @return the string
     */
    @Override
    public String getString() {
        return value;
    }

    @Override
    public boolean isDefault() {
        return this == getDefault();
    }

    public static CertificateType getDefault() {
        return CertificateType.DEVELOPER;
    }

    public static boolean isDeveloper(CertificateType type) {
        return (type == null || type == CertificateType.DEVELOPER);
    }

    public static CertificateType getType(String string) {
        if (string == null) {
            return getDefault();
        }
        String trimmedString = string.trim();
        for (CertificateType type : values()) {
            if (type.getString().equalsIgnoreCase(trimmedString)) {
                return type;
            }
        }
        return getDefault();
    }

}
