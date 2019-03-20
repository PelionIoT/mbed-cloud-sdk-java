package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class MethodListOptionsSetOptions extends AbstractMethodBasedOnModel {
    private static final String OPTIONS_PARAMETER = "options";
    public static final String IDENTIFIER = "setOptions";

    public MethodListOptionsSetOptions(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, false, IDENTIFIER, "Sets the option values", null, false, false, false, false,
              currentModel == null ? false : currentModel.needsFieldCustomisation(), true, false, true);
        addParameter(new Parameter(OPTIONS_PARAMETER, "an option", null, new TypeGenericParameter(ListOptions.class),
                                   null, null, null));
        initialiseCodeBuilder();
    }

    protected String determineClassShortName(Model currentModel) {
        return getModelType(currentModel).getShortName();
    }

    private TypeParameter getModelType(Model theCurrentModel) {
        return hasCurrentModel() ? theCurrentModel.toType() : new TypeParameter();
    }

    @Override
    protected void translateCode() throws TranslationException {
        super.translateCode();
        final String shortName = determineClassShortName(currentModel);
        final String castOptionName = "castOptions";
        code.beginControlFlow("if ($L == null)", OPTIONS_PARAMETER);
        code.addStatement("$L", MethodListOptionsSetDefault.IDENTIFIER);
        code.addStatement("return");
        code.endControlFlow();
        code.addStatement("super.$L($L);", IDENTIFIER, OPTIONS_PARAMETER);
        code.beginControlFlow("if ($L.class.isAssignableFrom($L.getClass()))", shortName, OPTIONS_PARAMETER);
        code.addStatement(" final $L $L = ($L) $L;", shortName, castOptionName, shortName, OPTIONS_PARAMETER);
        currentModel.getFieldList().stream().filter(f -> !f.isAlreadyDefined())
                    .forEach(f -> code.addStatement("$L($L.$L())", new MethodSetter(f).getName(), castOptionName,
                                                    new MethodGetter(f).getName()));
        code.endControlFlow();
    }

    // @Override
    // protected <T extends ListOptions> void setOptions(T options) {
    // if (options == null) {
    // setDefault();
    // return;
    // }
    // super.setOptions(options);
    // if (AbstractMetricsListOptions.class.isAssignableFrom(options.getClass())) {
    // final AbstractMetricsListOptions abstractMetrics = (AbstractMetricsListOptions) options;
    // setInterval(abstractMetrics.getInterval());
    // }
    // }
}
