package com.arm.mbed.cloud.sdk.certificates.model;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkEnum;

@Preamble(description = "Certificate type")
public enum CertificateType implements SdkEnum {
    DEVELOPER("developer"),
    BOOTSTRAP("bootstrap"),
    LWM2M("lwm2m"),
    UNKNOWN("unknown"),
    UNKNOWN_ENUM(SDK_UNKNOWN_ENUM_VALUE);

    private final String value;

    /**
     * Constructor.
     * 
     * @param value
     *            string representation.
     */
    private CertificateType(String string) {
        this.value = string;
    }

    /**
     * Converts to string.
     * 
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return getString();
    }

    /**
     * Gets string representation.
     * 
     * @see SdkEnum#getString()
     */
    @Override
    public String getString() {
        return value;
    }

    /**
     * States whether it is the default value.
     * 
     * @see SdkEnum#isDefault()
     */
    @Override
    public boolean isDefault() {
        return this == getDefault();
    }

    /**
     * States whether the value is unknown and an error happened during parsing.
     * 
     * @see SdkEnum#isUnknownValue()
     */
    @Override
    public boolean isUnknownValue() {
        return this == getUnknownEnum();
    }

    /**
     * Gets default certificate type.
     * 
     * @return default status.
     */
    public static CertificateType getDefault() {
        return CertificateType.UNKNOWN;
    }

    /**
     * Gets Unknown state value.
     * 
     * @return unknown state.
     */
    public static CertificateType getUnknownEnum() {
        return UNKNOWN_ENUM;
    }

    /**
     * States whether the type corresponds to developer type or not.
     * 
     * @param type
     *            type to test.
     * @return true if the type corresponds to the developer type. false otherwise.
     */
    public static boolean isDeveloper(CertificateType type) {
        return type == null || type == CertificateType.DEVELOPER;
    }

    /**
     * Gets the certificate type from its string representation.
     * 
     * @param string
     *            string describing the certificate type.
     * @return corresponding certificate type. If not found, default type is returned.
     */
    public static CertificateType getType(@Nullable String string) {
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

    /**
     * Merges two types.
     * 
     * @see SdkEnum#merge(SdkEnum, SdkEnum)
     */
    @Override
    public <T extends SdkEnum> T merge(T obj1, T obj2) {
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
