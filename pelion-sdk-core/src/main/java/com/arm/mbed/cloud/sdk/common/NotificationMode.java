package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;

/**
 * Notification mode.
 */
@Preamble(description = "Notification mode")
public enum NotificationMode implements SdkEnum {
    /**
     * The server forward any new notification to a given URL (i.e. webhook).
     */
    SERVER_INITIATED("SERVER_INITIATED"),
    /**
     * The client opens a communication channel with the server and asks for notifications
     */
    CLIENT_INITIATED("CLIENT_INITIATED"),
    UNKNOWN_ENUM(SDK_UNKNOWN_ENUM_VALUE);

    /**
     * Serialisation Id.
     */

    /**
     * string representation.
     */
    @Internal
    @Required
    @DefaultValue("CLIENT_INITIATED")
    private final String string;

    /**
     * Internal constructor.
     * 
     * @param string
     *            string representation.
     */
    @Internal
    NotificationMode(@DefaultValue("CLIENT_INITIATED") String string) {
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
     * Gets default notification mode.
     * 
     * @return default notification mode.
     */
    public static NotificationMode getDefault() {
        return CLIENT_INITIATED;
    }

    /**
     * Gets unknown notification mode value.
     * 
     * @return unknown notification mode.
     */
    public static NotificationMode getUnknownEnum() {
        return UNKNOWN_ENUM;
    }

    /**
     * Gets notification mode from its string representation.
     * 
     * @param value
     *            string.
     * @return corresponding notification mode or default mode if not recognised.
     */
    public static NotificationMode getValue(String value) {
        if (value == null) {
            return getDefault();
        }
        final String trimmedValue = value.trim();
        for (final NotificationMode option : values()) {
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
     *            a notification mode.
     * @param obj2
     *            a notification mode.
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
