package com.arm.mbed.cloud.sdk.common.listing.filtering;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Filter evaluator factory")
public final class FilterEvaluatorFactory {

    private FilterEvaluatorFactory() {
        super();
    }

    /**
     * States whether a value verifies the filter condition.
     *
     * @param filter
     *            to consider.
     * @param value
     *            to consider.
     * @return True if the value verifies the filter condition. False otherwise.
     */
    public static boolean isVerified(@Nullable Filter filter, @Nullable Object value) {
        if (filter == null) {
            return true;
        }
        final FilterEvaluator evaluator = generateEvaluator(filter);
        return evaluator == null ? false : evaluator.isVerified(filter, value);

    }

    private static FilterEvaluator generateEvaluator(Filter filter) {
        FilterEvaluator evaluator = null;
        switch (filter.getOperator()) {
            case EQUAL:
                evaluator = new EvaluatorEqual();
                break;
            case GREATER_THAN:
                // TODO create an evaluator
                break;
            case IN:
                evaluator = new EvaluatorIn();
                break;
            case LESS_THAN:
                // TODO create an evaluator
                break;
            case LIKE:
                evaluator = new EvaluatorLike();
                break;
            case NOT_EQUAL:
                evaluator = new EvaluatorNotEqual();
                break;
            case NOT_IN:
                evaluator = new EvaluatorNotIn();
                break;
            case UNKNOWN_ENUM:
                break;
            default:
                break;

        }
        return evaluator;
    }

}
