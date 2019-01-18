// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.SdkEnum;

/**
 * Device lifecycle status.
 */
@Preamble(description = "Device lifecycle status.")
public enum DeviceLifecycleStatus implements SdkEnum {
    BLOCKED("blocked"),

    ENABLED("enabled"),

    UNKNOWN_ENUM(SDK_UNKNOWN_ENUM_VALUE);

    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -115476746545229L;

    /**
     * string representation.
     */
    @Internal
    @Required
    @DefaultValue("BLOCKED")
    private final String string;

    /**
     * Internal constructor.
     * 
     * @param string
     *            string representation.
     */
    @Internal
    DeviceLifecycleStatus(@DefaultValue("BLOCKED") String string) {
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
     * Gets default device lifecycle status.
     * 
     * @return default device lifecycle status
     */
    public static DeviceLifecycleStatus getDefault() {
        return BLOCKED;
    }

    /**
     * Gets unknown device lifecycle status value.
     * 
     * @return unknown device lifecycle status
     */
    public static DeviceLifecycleStatus getUnknownEnum() {
        return UNKNOWN_ENUM;
    }

    /**
     * Gets device lifecycle status from its string representation.
     * 
     * @param value
     *            string.
     * @return corresponding device lifecycle status or default device lifecycle status if not recognised.
     */
    public static DeviceLifecycleStatus getValue(String value) {
        if (value == null) {
            return getDefault();
        }
        final String trimmedValue = value.trim();
        for (final DeviceLifecycleStatus option : values()) {
            if (option.getString().equalsIgnoreCase(trimmedValue)) {
                return option;
            }
        }
        return getDefault();
    }

    /**
     * Merges two states.
     * <p>
     * 
     * @see SdkEnum#merge(SdkEnum, SdkEnum)
     * @param obj1
     *            a device lifecycle status.
     * @param obj2
     *            a device lifecycle status.
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