package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;

import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodFilterGet extends MethodFilter {

    public MethodFilterGet(Filter filter, boolean containsCustomCode) {
        super(filter, generateName(filter), generateDescription(filter), containsCustomCode);
        setReturnType(TypeFactory.getCorrespondingType(List.class,
                                                       TypeFactory.getCorrespondingType(com.arm.mbed.cloud.sdk.common.listing.filtering.Filter.class)));
        setReturnDescription("All the filters by {@code " + filter.getFieldName() + "}");
        initialiseCodeBuilder();
    }

    private static String generateDescription(Filter filter2) {
        return "Gets all the filters defined on field {@code " + filter2.getFieldName() + "}";

    }

    public static String generateName(Filter filter2) {
        return Utils.combineNames(false, "get", filter2.getFieldName(), "filters");
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.Method#translateCode()
     */
    @Override
    protected void translateCode() throws TranslationException {
        super.translateCode();
        code.addStatement("return $L($L)", FilterOptions.METHOD_FILTER_FETCH, filter.getTag().getName());
    }

}
