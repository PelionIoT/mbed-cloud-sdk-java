package com.arm.mbed.cloud.sdk.common.listing.filtering;

import java.util.Arrays;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Evaluates whether a value complies to a NOT-IN filter")
@Internal
public class EvaluatorNotIn implements FilterEvaluator {

    @Override
    public boolean isVerified(Filter filter, Object value) {
        if (filter == null || filter.getOperator() != FilterOperator.NOT_IN || filter.getValue() == null) {
            return false;
        }
        try {
            final List<?> filterValues = filter.getValue() instanceof List ? (List<?>) filter.getValue()
                                                                           : Arrays.asList(filter.getValue());
            return !EvaluatorIn.verify(value, filterValues);
        } catch (@SuppressWarnings("unused") Exception exception) {
            return false;
        }
    }

}
