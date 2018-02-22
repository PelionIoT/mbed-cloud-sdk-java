package com.arm.mbed.cloud.sdk.common.listing.filtering;

public class EvaluatorLike implements FilterEvaluator {

    @Override
    public boolean isVerified(Filter filter, Object value) {
        if (filter == null || filter.getOperator() != FilterOperator.LIKE) {
            return false;
        }
        final Object filterValue = filter.getValue();
        if (EvaluatorEqual.verify(value, filterValue)) {
            return true;
        }
        if (filterValue instanceof String || filterValue instanceof Character) {
            final String pattern = String.valueOf(filterValue);
            final String valueString = String.valueOf(value);
            if (valueString.contains(pattern)) {
                return true;
            }
            // TODO add more checks if the pattern is a regex or contains wilcards, etc.
            return false;
        }
        // If not a string "like" is equivalent to equal
        return EvaluatorEqual.verify(value, filterValue);
    }

}
