package com.arm.mbed.cloud.sdk.common.listing.filtering;

import java.util.Arrays;
import java.util.List;

public class EvaluatorNotIn implements FilterEvaluator {

    @Override
    public boolean isVerified(Filter filter, Object value) {
        if (filter == null || filter.getOperator() != FilterOperator.NOT_IN || filter.getValue() == null) {
            return false;
        }
        try {
            final List<?> filterValues = (filter.getValue() instanceof List) ? (List<?>) filter.getValue()
                    : Arrays.asList(filter.getValue());
            return !EvaluatorIn.verify(value, filterValues);
        } catch (Exception exception) {
            return false;
        }
    }

}
