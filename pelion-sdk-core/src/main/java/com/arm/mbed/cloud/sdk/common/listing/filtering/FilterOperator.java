package com.arm.mbed.cloud.sdk.common.listing.filtering;

import java.util.EnumSet;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkEnum;

@Preamble(description = "Filter operator")
public enum FilterOperator implements SdkEnum {

    NOT_EQUAL("not equal to", FilterMarshaller.SUFFIX_SEPARATOR + "neq", "$neq"),
    EQUAL("equal to", FilterMarshaller.SUFFIX_SEPARATOR + "eq", "$eq"),
    GREATER_THAN("greater than", FilterMarshaller.SUFFIX_SEPARATOR + "gte", "$gte"),
    LESS_THAN("less than", FilterMarshaller.SUFFIX_SEPARATOR + "lte", "$lte"),
    LIKE("like", FilterMarshaller.SUFFIX_SEPARATOR + "like", "$like"),
    IN("in", FilterMarshaller.SUFFIX_SEPARATOR + "in", "$in"),
    NOT_IN("not in", FilterMarshaller.SUFFIX_SEPARATOR + "nin", "$nin"),
    UNKNOWN_ENUM(SDK_UNKNOWN_ENUM_VALUE, SDK_UNKNOWN_ENUM_VALUE, SDK_UNKNOWN_ENUM_VALUE);

    private final String suffix;
    private final String string;
    private final String symbol;
    private static final EnumSet<FilterOperator> SINGLE_VALUE_FILTERS = EnumSet.of(NOT_EQUAL, EQUAL, GREATER_THAN,
                                                                                   LESS_THAN, LIKE);
    private static final EnumSet<FilterOperator> MULTIPLE_VALUES_FILTERS = EnumSet.of(IN, NOT_IN);

    private FilterOperator(String string, String suffix, String symbol) {
        this.suffix = suffix;
        this.string = string;
        this.symbol = symbol;
    }

    /**
     * Gets filter suffix.
     * 
     * @return the suffix
     */
    @Internal
    public String getSuffix() {
        return suffix;
    }

    /**
     * States whether it is the default value.
     * 
     * @see SdkEnum#isDefault()
     */
    @Override
    public boolean isDefault() {
        return this == getDefault();
    }

    /**
     * States whether the value is unknown and an error happened during parsing.
     * 
     * @see SdkEnum#isUnknownValue()
     */
    @Override
    public boolean isUnknownValue() {
        return this == getUnknownEnum();
    }

    /**
     * Gets default operator.
     * 
     * @return default operator.
     */
    public static FilterOperator getDefault() {
        return EQUAL;
    }

    /**
     * Gets Unknown state value.
     * 
     * @return unknown state.
     */
    public static FilterOperator getUnknownEnum() {
        return UNKNOWN_ENUM;
    }

    /**
     * Gets filter symbol.
     * 
     * @return the symbol
     */
    @Internal
    public String getSymbol() {
        return symbol;
    }

    /**
     * Gets string representation.
     * 
     * @see SdkEnum#getString()
     */
    @Override
    public String getString() {
        return string;
    }

    /**
     * Gets string representation.
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return getString();
    }

    /**
     * Gets a filter from a suffix string.
     * 
     * @param suffix
     *            suffix string
     * @return corresponding operator. Default operator if unfound.
     */
    @Internal
    public static FilterOperator getFromSuffix(String suffix) {
        String cleansedSuffix = suffix;
        if (cleansedSuffix != null) {
            cleansedSuffix = cleansedSuffix.trim();
            cleansedSuffix = cleansedSuffix.replace(FilterMarshaller.SUFFIX_SEPARATOR, "");
        }
        for (final FilterOperator operator : values()) {
            String opSuffix = operator.getSuffix();
            if (opSuffix == null) {
                if (cleansedSuffix == null || cleansedSuffix.isEmpty()) {
                    return operator;
                }
            } else {
                opSuffix = opSuffix.replace(FilterMarshaller.SUFFIX_SEPARATOR, "");
                if (opSuffix.equalsIgnoreCase(cleansedSuffix)) {
                    return operator;
                }
            }
        }
        return getDefault();
    }

    /**
     * Gets a filter from a symbol string.
     * 
     * @param symbol
     *            symbol string
     * @return corresponding operator. Default operator if unfound.
     */
    @Internal
    public static FilterOperator getFromSymbol(String symbol) {
        if (symbol == null) {
            return getDefault();
        }
        final String trimmedSymbol = symbol.trim();
        for (final FilterOperator operator : values()) {
            if (operator.getSymbol().equalsIgnoreCase(trimmedSymbol)) {
                return operator;
            }
        }
        return getDefault();
    }

    /**
     * States whether this operator is used in combination with a single value
     * 
     * @return True if only one value can be used with this operator; False otherwise.
     */
    public boolean isSingleValueOperator() {
        return SINGLE_VALUE_FILTERS.contains(this);
    }

    /**
     * States whether this operator is used in combination with multiple values
     * 
     * @return True if multiple values can be used with this operator; False otherwise.
     */
    public boolean isMultipleValuesOperator() {
        return MULTIPLE_VALUES_FILTERS.contains(this);
    }

    /**
     * Merges two operators.
     * 
     * @see SdkEnum#merge(SdkEnum, SdkEnum)
     */
    @Override
    public <T extends SdkEnum> T merge(T obj1, T obj2) {
        if (obj1 == null) {
            return obj2;
        }
        if (obj2 == null) {
            return obj1;
        }
        if (obj1.isDefault()) {
            return obj2;
        }
        if (obj2.isDefault()) {
            return obj1;
        }
        return obj2;
    }
}
