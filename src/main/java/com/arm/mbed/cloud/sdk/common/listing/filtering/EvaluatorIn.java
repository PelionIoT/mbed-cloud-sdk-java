package com.arm.mbed.cloud.sdk.common.listing.filtering;

import java.util.Arrays;
import java.util.List;

public class EvaluatorIn implements FilterEvaluator {

    @Override
    public boolean isVerified(Filter filter, Object value) {
        if (filter == null || filter.getOperator() != FilterOperator.IN || filter.getValue() == null) {
            return false;
        }
        try {
            final List<?> filterValues = (filter.getValue() instanceof List) ? (List<?>) filter.getValue()
                    : Arrays.asList(filter.getValue());
            return verify(value, filterValues);
        } catch (Exception exception) {
            return false;
        }
    }

    protected static boolean verify(Object value, final List<?> filterValues) {
        if (value instanceof String && filterValues.size() == 1 && filterValues.get(0) instanceof String) {
            return ((String) filterValues.get(0)).contains((String) value);
        }
        for (Object filterValue : filterValues) {
            if (EvaluatorEqual.verify(value, filterValue)) {
                return true;
            }
        }
        return false;
    }
}
