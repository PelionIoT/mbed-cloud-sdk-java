package com.arm.mbed.cloud.sdk.common;

import java.util.UUID;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Generator of Universal Unique Identifier")
@Internal
public class UUIDGenerator {
    /**
     * Generates a UUID.
     * 
     * @return UUID
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    };

}
