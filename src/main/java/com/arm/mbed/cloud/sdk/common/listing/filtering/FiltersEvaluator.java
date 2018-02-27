package com.arm.mbed.cloud.sdk.common.listing.filtering;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "filters evaluator in charge of checking that a value matches filters")
public final class FiltersEvaluator {

    private FiltersEvaluator() {
        super();
    }

    public static boolean isVerified(Filters filters, String fieldName, Object value) {
        if (fieldName == null) {
            return false;
        }
        if (filters == null) {
            return true;
        }
        final List<Filter> filterList = filters.get(fieldName);
        if (filterList == null) {
            return true;
        }
        boolean isVerified = true;
        for (Filter filter : filterList) {
            isVerified &= FilterEvaluatorFactory.isVerified(filter, value);
        }
        return isVerified;
    }
}
