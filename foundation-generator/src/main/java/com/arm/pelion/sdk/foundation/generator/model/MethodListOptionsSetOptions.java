package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.squareup.javapoet.CodeBlock;

public class MethodListOptionsSetOptions extends AbstractMethodBasedOnModel {
    private static final String OPTIONS_PARAMETER = "options";
    public static final String IDENTIFIER = "setOptions";

    public MethodListOptionsSetOptions(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, false, IDENTIFIER, "Sets the option values", null, false, false, false, false,
              currentModel == null ? false : currentModel.needsFieldCustomisation(), true, false, true);
        addParameter(new Parameter(OPTIONS_PARAMETER, "a options", null, new GenericParameterType(ListOptions.class),
                                   null));
        setCode(CodeBlock.builder());
    }

    protected String determineClassShortName(Model currentModel) {
        return getModelType(currentModel).getShortName();
    }

    private ParameterType getModelType(Model theCurrentModel) {
        return hasCurrentModel() ? theCurrentModel.toType() : new ParameterType();
    }

    @Override
    protected void translateCode() {
        super.translateCode();
        final String shortName = determineClassShortName(currentModel);
        final String castOptionName = "castOptions";
        code.beginControlFlow("if ($S == null)", OPTIONS_PARAMETER);
        code.addStatement("$S", MethodListOptionsSetDefault.IDENTIFIER);
        code.addStatement("return");
        code.endControlFlow();
        code.addStatement("super.$S($S);", IDENTIFIER, OPTIONS_PARAMETER);
        code.beginControlFlow("if ($S.class.isAssignableFrom($S.getClass()))", shortName, OPTIONS_PARAMETER);
        code.addStatement(" final $S $S = ($S) $S;", shortName, castOptionName, shortName, OPTIONS_PARAMETER);
        currentModel.getFieldList().stream()
                    .forEach(f -> code.addStatement("$S($S.$S())", new MethodSetter(f).getName(), castOptionName,
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
