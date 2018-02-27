package com.arm.mbed.cloud.sdk.common.listing.filtering;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Evaluates whether a value complies to a NOT EQUAL filter")
@Internal
public class EvaluatorNotEqual implements FilterEvaluator {

    @Override
    public boolean isVerified(Filter filter, Object value) {
        if (filter == null || filter.getOperator() != FilterOperator.NOT_EQUAL) {
            return false;
        }
        final Object filterValue = filter.getValue();
        return verify(value, filterValue);
    }

    protected static boolean verify(Object value, final Object filterValue) {
        return !EvaluatorEqual.verify(value, filterValue);
    }

}
