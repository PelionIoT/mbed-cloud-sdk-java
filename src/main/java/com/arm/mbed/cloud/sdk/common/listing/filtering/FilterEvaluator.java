package com.arm.mbed.cloud.sdk.common.listing.filtering;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Interface defining a filter evaluator in charge of checking that a value matches a specific filter")
public interface FilterEvaluator {

    boolean isVerified(Filter filter, Object value);

}
