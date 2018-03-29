package com.arm.mbed.cloud.sdk.common.listing.filtering;

import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Evaluates whether a value complies to a LIKE filter")
@Internal
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
        if (value == null && filterValue != null || value != null && filterValue == null) {
            return false;
        }
        if (filterValue instanceof String || filterValue instanceof CharSequence) {
            final String pattern = String.valueOf(filterValue);
            final String valueString = String.valueOf(value).toLowerCase(Locale.getDefault());
            if (valueString.contains(pattern) || valueString.contains(pattern.toLowerCase(Locale.getDefault()))) {
                return true;
            }
            // If filterValue is a Java Regex.
            try {
                if (Pattern.matches(pattern, valueString)) {
                    return true;
                }
            } catch (PatternSyntaxException exception) {
                // Nothing to do
            }
            // If filterValue is a SQL like entry i.e.
            final String javaPattern = pattern.toLowerCase(Locale.getDefault()).replace(".", "\\.").replace("*", "\\*")
                    .replace("?", ".").replace("_", ".").replace("%", ".*");
            try {
                return Pattern.matches(javaPattern, valueString);
            } catch (PatternSyntaxException exception) {
                return false;
            }
        }
        // If not a string "like" is equivalent to equal
        return EvaluatorEqual.verify(value, filterValue);
    }

}
