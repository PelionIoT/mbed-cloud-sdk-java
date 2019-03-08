package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodFilterSet extends MethodFilter {

    protected final String parameterName;

    public MethodFilterSet(Filter filter, TypeParameter inputType, String name, String description,
                           boolean containsCustomCode) {
        super(filter, name, description, containsCustomCode);
        initialiseCodeBuilder();
        parameterName = Utils.combineNames(false, "filterBy", filter.getFieldName());
        addParameter(new Parameter(parameterName, "filter value", null,
                                   inputType == null ? filter.getFieldType() : inputType, null));
    }

    public MethodFilterSet(Filter filter, TypeParameter inputType, boolean containsCustomCode) {
        this(filter, inputType, generateName(filter), generateDescription(filter), containsCustomCode);
    }

    public MethodFilterSet(Filter filter, boolean containsCustomCode) {
        this(filter, null, containsCustomCode);
    }

    protected static String generateDescription(Filter filter2) {
        return "Sets \"" + Utils.generateDocumentationString(getFilterOperatorName(filter2)) + "\" filter by {@code "
               + filter2.getFieldName() + "}";
    }

    protected static String generateName(Filter filter2) {
        return Utils.combineNames(false, "set", getFilterOperatorName(filter2), filter2.getFieldName(), "filter");
    }

    protected static String getFilterOperatorName(Filter filter2) {
        return filter2.getOperator().getString().replace(" ", "_");
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.Method#translateCode()
     */
    @Override
    protected void translateCode() throws TranslationException {
        super.translateCode();
        code.addStatement("$L($L, $L)", filter.getAddFilterMethodName(), filter.getTag().getName(), parameterName);
    }

}
