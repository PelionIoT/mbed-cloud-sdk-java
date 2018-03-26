package com.arm.mbed.cloud.sdk.common.listing.filtering;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Interface defining a filter evaluator in charge of checking that a value matches a specific filter")
public interface FilterEvaluator {
    /**
     * States whether a value verifies the filter condition.
     *
     * @param filter
     *            to consider.
     * @param value
     *            to consider.
     * @return True if the value verifies the filter condition. False otherwise.
     */
    boolean isVerified(@Nullable Filter filter, @Nullable Object value);

}
