/**
 * 
 */
package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkEnum;

@Preamble(description = "The enforcement status of the multi-factor authentication")
public enum MultifactorAuthenticationStatus implements SdkEnum {

    ENFORCED("enforced"), OPTIONAL("optional"), UNKNOWN_ENUM(SDK_UNKNOWN_ENUM_VALUE);

    private final String value;

    /**
     * Constructor.
     * 
     * @param value
     *            string representation.
     */
    private MultifactorAuthenticationStatus(String string) {
        this.value = string;
    }

    /**
     * States if it is the default status.
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
     * Gets default value.
     * 
     * @return default value.
     */
    public static MultifactorAuthenticationStatus getDefault() {
        return MultifactorAuthenticationStatus.OPTIONAL;
    }

    /**
     * Gets Unknown state value.
     * 
     * @return unknown state.
     */
    public static MultifactorAuthenticationStatus getUnknownEnum() {
        return UNKNOWN_ENUM;
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
     * Gets string representation.
     * 
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return getString();
    }

    /**
     * Gets the multi-factor authentication status from its string representation.
     * 
     * @param string
     *            string describing the multi-factor authentication status.
     * @return corresponding multi-factor authentication status. If not found, default status is returned.
     */
    public static MultifactorAuthenticationStatus getStatus(@Nullable String string) {
        if (string == null) {
            return getDefault();
        }
        final String trimmedString = string.trim();
        for (final MultifactorAuthenticationStatus status : values()) {
            if (status.toString().equalsIgnoreCase(trimmedString)) {
                return status;
            }
        }
        return getDefault();
    }

    /**
     * Merges two items.
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
