package com.arm.mbed.cloud.sdk.common.listing.filtering;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Evaluates whether a value complies to an EQUAL filter")
@Internal
public class EvaluatorEqual implements FilterEvaluator {

    @Override
    public boolean isVerified(Filter filter, Object value) {
        if (filter == null || filter.getOperator() != FilterOperator.EQUAL) {
            return false;
        }
        final Object filterValue = filter.getValue();
        return verify(value, filterValue);
    }

    protected static boolean verify(Object value, final Object filterValue) {
        if (filterValue == null) {
            return value == null;
        }
        if (value == null) {
            return false;
        }
        if (filterValue instanceof Number) {
            if (!(value instanceof Number)) {
                return false;
            }
            if (filterValue instanceof Long || filterValue instanceof Integer || filterValue instanceof Byte
                    || filterValue instanceof Short) {
                if (!(value instanceof Double || value instanceof Float)) {
                    return Long.valueOf(((Number) filterValue).longValue())
                            .equals(Long.valueOf(((Number) value).longValue()));
                }
                return Double.valueOf(((Number) filterValue).doubleValue())
                        .equals(Double.valueOf(((Number) value).doubleValue()));
            }
            if (filterValue instanceof Double || filterValue instanceof Float) {
                return Double.valueOf(((Number) filterValue).doubleValue())
                        .equals(Double.valueOf(((Number) value).doubleValue()));
            }
        }
        return filterValue.equals(value);
    }

}
