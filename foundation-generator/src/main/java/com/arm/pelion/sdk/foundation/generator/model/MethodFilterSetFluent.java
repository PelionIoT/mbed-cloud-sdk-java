package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodFilterSetFluent extends MethodFilterSet {

    private final Method equivalentMethod;

    public MethodFilterSetFluent(Filter filter, TypeParameter inputType, Model listOptionModel, Method equivalentMethod,
                                 boolean containsCustomCode, boolean plural) {
        super(filter, inputType, generateFluentName(filter, plural), generateDescription(filter), containsCustomCode);
        this.equivalentMethod = equivalentMethod;
        setLongDescription(Utils.generateDocumentationMethodLink(listOptionModel, equivalentMethod));
        setReturnType(new TypeGenericParameter(listOptionModel.toImport()));
        setReturnDescription("These list options");
        setUnchecked(true);
        initialiseCodeBuilder();
    }

    public MethodFilterSetFluent(Filter filter, Model listOptionModel, Method equivalentMethod,
                                 boolean containsCustomCode, boolean plural) {
        this(filter, null, listOptionModel, equivalentMethod, containsCustomCode, plural);
    }

    public static String generateFluentName(Filter filter, boolean plural) {
        return Utils.combineNames(false, getFilterOperatorName(filter),
                                  plural ? Utils.generatePlural(filter.getFieldName()) : filter.getFieldName());
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.Method#translateCode()
     */
    @Override
    protected void translateCode() throws TranslationException {
        code.addStatement("$L($L)", equivalentMethod.getName(), parameterName);
        code.addStatement("return (T) this");
    }

}
