package com.arm.mbed.cloud.sdk.common.listing.filtering;

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
        return (filterValue == null) ? value == null : filterValue.equals(value);
    }

}
