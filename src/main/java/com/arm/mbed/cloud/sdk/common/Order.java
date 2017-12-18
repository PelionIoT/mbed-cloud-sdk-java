package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Ordering options")
public enum Order implements SdkEnum {
    ASC("ASC"), DESC("DESC");

    private final String value;

    /**
     * Constructor.
     * 
     * @param value
     *            string representation
     */
    Order(String value) {
        this.value = value;
    }

    /**
     * toString.
     * 
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Gets order from its string representation.
     * 
     * @param str
     *            string
     * @return corresponding order or default if not recognised
     */
    public static Order getOrder(String str) {
        if (str == null || str.isEmpty()) {
            return getDefault();
        }
        if (ASC.toString().equalsIgnoreCase(str)) {
            return ASC;
        }
        if (DESC.toString().equalsIgnoreCase(str)) {
            return DESC;
        }
        return getDefault();
    }

    /**
     * Gets default order.
     * 
     * @return default order.
     */
    public static Order getDefault() {
        return ASC;
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
     * Merges two orders.
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
