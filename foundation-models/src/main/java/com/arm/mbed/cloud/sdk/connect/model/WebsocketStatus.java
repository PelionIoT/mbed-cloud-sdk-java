package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkEnum;

@Preamble(description = "Websocket status")
public enum WebsocketStatus implements SdkEnum {
    /**
     * The channel has an active WebSocket bound to it.
     */
    CONNECTED("connected"),
    /**
     * Either the channel or the WebSocket bound to it is closed.
     */
    DISCONNECTED("disconnected"),
    UNKNOWN_ENUM(SDK_UNKNOWN_ENUM_VALUE);

    private final String value;

    /**
     * Constructor.
     * 
     * @param value
     *            string representation.
     */
    private WebsocketStatus(String string) {
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
    public static WebsocketStatus getDefault() {
        return WebsocketStatus.DISCONNECTED;
    }

    /**
     * Gets Unknown state value.
     * 
     * @return unknown state.
     */
    public static WebsocketStatus getUnknownEnum() {
        return UNKNOWN_ENUM;
    }

    /**
     * Gets the websocket status from its string representation.
     * 
     * @param string
     *            string describing the status.
     * @return corresponding status. If not found, default type is returned.
     */
    public static WebsocketStatus getType(@Nullable String string) {
        if (string == null) {
            return getDefault();
        }
        final String trimmedString = string.trim();
        for (final WebsocketStatus type : values()) {
            if (type.getString().equalsIgnoreCase(trimmedString)) {
                return type;
            }
        }
        return getDefault();
    }

    /**
     * Merges two statuses.
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
