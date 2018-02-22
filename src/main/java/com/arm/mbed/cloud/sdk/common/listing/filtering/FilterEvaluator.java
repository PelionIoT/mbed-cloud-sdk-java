package com.arm.mbed.cloud.sdk.common.listing.filtering;

public interface FilterEvaluator {

    boolean isVerified(Filter filter, Object value);

}
