package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Generic SDK enum")
@Internal
public interface SDKEnum {
    boolean isDefault();

    String getString();

    <T extends SDKEnum> T merge(T obj1, T obj2);
}
