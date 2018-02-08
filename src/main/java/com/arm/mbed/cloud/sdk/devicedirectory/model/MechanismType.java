package com.arm.mbed.cloud.sdk.devicedirectory.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkEnum;

@Preamble(description = "The type of channel used to communicate with a device")
public enum MechanismType implements SdkEnum {
    CONNECTOR("connector"), DIRECT("direct"), UNKNOWN_ENUM(SDK_UNKNOWN_ENUM_VALUE);

    private final String value;

    /**
     * Constructor.
     * 
     * @param value
     *            string representation.
     */
    private MechanismType(String string) {
        this.value = string;
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
     * Gets default mechanism type.
     * 
     * @return default mechanism type.
     */
    public static MechanismType getDefault() {
        return MechanismType.DIRECT;
    }

    /**
     * Gets Unknown type value.
     * 
     * @return unknown type.
     */
    public static MechanismType getUnknownEnum() {
        return UNKNOWN_ENUM;
    }

    /**
     * Merges two mechanism types.
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
