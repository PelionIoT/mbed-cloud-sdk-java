// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.SdkEnum;

/**
 * Subtenant trusted certificate status.
 */
@Preamble(description = "Subtenant trusted certificate status.")
public enum SubtenantTrustedCertificateStatus implements SdkEnum {
    ACTIVE("ACTIVE"),

    INACTIVE("INACTIVE"),

    UNKNOWN_ENUM(SDK_UNKNOWN_ENUM_VALUE);

    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 5106542661921220L;

    /**
     * string representation.
     */
    @Internal
    @Required
    @DefaultValue("ACTIVE")
    private final String string;

    /**
     * Internal constructor.
     * 
     * @param string
     *            string representation.
     */
    @Internal
    SubtenantTrustedCertificateStatus(@DefaultValue("ACTIVE") String string) {
        this.string = string;
    }

    /**
     * Gets string representation.
     * 
     * @return string
     */
    @Override
    @Internal
    public String getString() {
        return string;
    }

    /**
     * toString.
     * 
     * <p>
     * 
     * @see java.lang.Enum#toString()
     * @return the string representation of this value
     */
    @Override
    public String toString() {
        return getString();
    }

    /**
     * States whether it is the default value.
     * 
     * <p>
     * 
     * @see SdkEnum#isDefault()
     * @return true if this is the default value; false otherwise
     */
    @Override
    public boolean isDefault() {
        return this == getDefault();
    }

    /**
     * States whether the value is unknown and an error happened during parsing.
     * 
     * <p>
     * 
     * @see SdkEnum#isUnknownValue()
     * @return true if this is an unknown value; false otherwise
     */
    @Override
    public boolean isUnknownValue() {
        return this == getUnknownEnum();
    }

    /**
     * Gets default subtenant trusted certificate status.
     * 
     * @return default subtenant trusted certificate status
     */
    public static SubtenantTrustedCertificateStatus getDefault() {
        return ACTIVE;
    }

    /**
     * Gets unknown subtenant trusted certificate status value.
     * 
     * @return unknown subtenant trusted certificate status
     */
    public static SubtenantTrustedCertificateStatus getUnknownEnum() {
        return UNKNOWN_ENUM;
    }

    /**
     * Gets subtenant trusted certificate status from its string representation.
     * 
     * @param value
     *            string.
     * @return corresponding subtenant trusted certificate status or default subtenant trusted certificate status if not
     *         recognised.
     */
    public static SubtenantTrustedCertificateStatus getValue(String value) {
        if (value == null) {
            return getDefault();
        }
        final String trimmedValue = value.trim();
        for (final SubtenantTrustedCertificateStatus option : values()) {
            if (option.getString().equalsIgnoreCase(trimmedValue)) {
                return option;
            }
        }
        return getDefault();
    }

    /**
     * Merges two states.
     * 
     * <p>
     * 
     * @see SdkEnum#merge(SdkEnum, SdkEnum)
     * @param <T>
     *            type of an sdk enum
     * @param obj1
     *            a subtenant trusted certificate status.
     * @param obj2
     *            a subtenant trusted certificate status.
     * @return the merged enumerator
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
