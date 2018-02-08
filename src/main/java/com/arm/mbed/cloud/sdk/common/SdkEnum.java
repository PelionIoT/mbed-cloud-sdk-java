package com.arm.mbed.cloud.sdk.common;

import java.io.Serializable;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Generic SDK enum")
@Internal
public interface SdkEnum extends Serializable {
    /**
     * Enumerator value stating that there has been a SDK internal issue when parsing enumerator values from the Cloud.
     * <p>
     * Please report such error as well as corresponding lastAPIMetadata.
     */
    public static String SDK_UNKNOWN_ENUM_VALUE = "enum_unknown";

    /**
     * States whether there has been a SDK internal issue when parsing enumerator values from the Cloud and resulting
     * value is unknown.
     * <p>
     * Please report such error as well as corresponding lastAPIMetadata.
     * 
     * @return true if current value is unknown. false otherwise.
     */
    boolean isUnknownValue();

    /**
     * States if it corresponds to the default value.
     * 
     * @return whether the item is the default value.
     */
    boolean isDefault();

    /**
     * Gets the string representation of the item.
     * 
     * @return a string representing the item.
     */
    String getString();

    /**
     * Gets the merge of two items.
     * 
     * @param obj1
     *            object 1.
     * @param obj2
     *            object 2.
     * @param <T>
     *            type of the enum item.
     * @return the merge of two items.
     */
    @Nullable
    <T extends SdkEnum> T merge(@Nullable T obj1, @Nullable T obj2);
}
