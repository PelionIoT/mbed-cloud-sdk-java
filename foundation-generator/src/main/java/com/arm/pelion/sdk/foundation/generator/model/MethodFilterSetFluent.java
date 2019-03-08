package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodFilterSetFluent extends MethodFilterSet {

    private final Method equivalentMethod;

    public MethodFilterSetFluent(Filter filter, TypeParameter inputType, Model listOptionModel, Method equivalentMethod,
                                 boolean containsCustomCode) {
        super(filter, inputType, generateFluentName(filter), generateDescription(filter), containsCustomCode);
        this.equivalentMethod = equivalentMethod;
        setLongDescription(Utils.generateDocumentationMethodLink(listOptionModel, equivalentMethod));
        setReturnType(new TypeGenericParameter(listOptionModel.toImport()));
        setReturnDescription("These list options");
        setUnchecked(true);
        initialiseCodeBuilder();
    }

    public MethodFilterSetFluent(Filter filter, Model listOptionModel, Method equivalentMethod,
                                 boolean containsCustomCode) {
        this(filter, null, listOptionModel, equivalentMethod, containsCustomCode);
    }

    private static String generateFluentName(Filter filter) {
        return Utils.combineNames(false, getFilterOperatorName(filter), filter.getFieldName());
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
