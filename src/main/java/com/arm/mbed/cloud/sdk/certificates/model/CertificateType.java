package com.arm.mbed.cloud.sdk.certificates.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKEnum;

@Preamble(description = "Certificate type")
public enum CertificateType implements SDKEnum {
    DEVELOPER("developer"), BOOTSTRAP("bootstrap"), LWM2M("lwm2m"), UNKNOWN("unknown");

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
        return CertificateType.UNKNOWN;
    }

    public static boolean isDeveloper(CertificateType type) {
        return type == null || type == CertificateType.DEVELOPER;
    }

    public static CertificateType getType(String string) {
        if (string == null) {
            return getDefault();
        }
        final String trimmedString = string.trim();
        for (final CertificateType type : values()) {
            if (type.getString().equalsIgnoreCase(trimmedString)) {
                return type;
            }
        }
        return getDefault();
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
