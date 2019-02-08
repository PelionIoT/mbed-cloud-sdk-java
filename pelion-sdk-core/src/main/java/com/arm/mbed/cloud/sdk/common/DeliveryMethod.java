package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;

/**
 * Delivery method for notifications.
 */
@Preamble(description = "Delivery method for notifications")
public enum DeliveryMethod implements SdkEnum {
    /**
     * The server forward any new notification to a given URL (i.e. webhook).
     */
    SERVER_INITIATED("SERVER_INITIATED"),
    /**
     * The client opens a communication channel with the server and asks for notifications
     */
    CLIENT_INITIATED("CLIENT_INITIATED"),
    /**
     * Undefined method.
     */
    UNDEFINED("UNDEFINED"),
    UNKNOWN_ENUM(SDK_UNKNOWN_ENUM_VALUE);

    /**
     * Serialisation Id.
     */

    /**
     * string representation.
     */
    @Internal
    @Required
    @DefaultValue("UNDEFINED")
    private final String string;

    /**
     * Internal constructor.
     * 
     * @param string
     *            string representation.
     */
    @Internal
    DeliveryMethod(@DefaultValue("UNDEFINED") String string) {
        this.string = string;
    }

    /**
     * Gets string representation.
     * 
     * @return string
     */
    @Override
    public String getString() {
        return string;
    }

    /**
     * toString.
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
     * Gets default delivery method.
     * 
     * @return default delivery method.
     */
    public static DeliveryMethod getDefault() {
        return UNDEFINED;
    }

    /**
     * Gets unknown delivery method value.
     * 
     * @return unknown delivery method.
     */
    public static DeliveryMethod getUnknownEnum() {
        return UNKNOWN_ENUM;
    }

    /**
     * Gets delivery method from its string representation.
     * 
     * @param value
     *            string.
     * @return corresponding delivery method or default mode if not recognised.
     */
    public static DeliveryMethod getValue(String value) {
        if (value == null) {
            return getDefault();
        }
        final String trimmedValue = value.trim();
        for (final DeliveryMethod option : values()) {
            if (option.getString().equalsIgnoreCase(trimmedValue)) {
                return option;
            }
        }
        return getDefault();
    }

    /**
     * Merges two modes.
     * <p>
     * 
     * @see SdkEnum#merge(SdkEnum, SdkEnum)
     * @param obj1
     *            a delivery method.
     * @param obj2
     *            a delivery method.
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
