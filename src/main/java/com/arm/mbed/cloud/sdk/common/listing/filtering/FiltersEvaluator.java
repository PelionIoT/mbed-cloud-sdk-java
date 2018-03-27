package com.arm.mbed.cloud.sdk.common.listing.filtering;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "filters evaluator in charge of checking that a value matches filters")
public final class FiltersEvaluator {

    private FiltersEvaluator() {
        super();
    }

    /**
     * States whether a specific field filter is verifier by the value.
     *
     * @param filters
     *            filters to consider.
     * @param fieldName
     *            field name on which the filter would be evaluated.
     * @param value
     *            value to consider.
     * @return true if the value verifies the filter corresponding to the specified field name. False otherwise.
     */
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
        for (final Filter filter : filterList) {
            isVerified &= FilterEvaluatorFactory.isVerified(filter, value);
        }
        return isVerified;
    }
}
