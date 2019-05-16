package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodFilterSet extends MethodFilter {

    private static final String METHOD_PREFIX = "add";
    protected final String parameterName;

    public MethodFilterSet(Filter filter, TypeParameter inputType, String name, String description,
                           boolean containsCustomCode) {
        super(filter, name, description, containsCustomCode);
        initialiseCodeBuilder();
        parameterName = Utils.combineNames(false, "filterBy", filter.getFieldName());
        addParameter(new Parameter(parameterName, "filter value", null,
                                   inputType == null ? filter.getFieldType() : inputType, null, null));
        if (inputType != null && inputType.isArray()) {
            shouldUseVarargs(true);
        }
    }

    public MethodFilterSet(Filter filter, TypeParameter inputType, boolean containsCustomCode, boolean plural) {
        this(filter, inputType, generateName(filter, plural), generateDescription(filter), containsCustomCode);
    }

    public MethodFilterSet(Filter filter, boolean containsCustomCode) {
        this(filter, null, containsCustomCode, false);
    }

    protected static String generateDescription(Filter filter2) {
        return "Sets \"" + Utils.generateDocumentationString(getFilterOperatorName(filter2)) + "\" filter by {@code "
               + filter2.getFieldName() + "}";
    }

    protected static String generateName(Filter filter2, boolean plural) {
        return Utils.combineNames(false, METHOD_PREFIX, getFilterOperatorName(filter2),
                                  plural ? Utils.generatePlural(filter2.getFieldName()) : filter2.getFieldName(),
                                  "filter");
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
        final TypeParameter fieldType = filter.getFieldType();
        if (fieldType.isPrimitive()) {
            code.addStatement("$L($L, $T.valueOf($L))", filter.getAddFilterMethodName(), filter.getTag().getName(),
                              MethodMapper.getWrapperEquivalent(fieldType), parameterName);
        } else {
            code.addStatement("$L($L, $L)", filter.getAddFilterMethodName(), filter.getTag().getName(), parameterName);
        }
    }

}
