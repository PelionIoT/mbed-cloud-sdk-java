package com.arm.pelion.sdk.foundation.generator.model;

public class MethodListOptionsConstructorFromObject extends MethodConstructorFromObject {

    public MethodListOptionsConstructorFromObject(Model currentModel, Model parentModel) {
        super(currentModel, parentModel);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Class<? extends AbstractMethodConstructor> getConstructorType() {
        return (Class<? extends AbstractMethodConstructor>) super.getClass().getSuperclass();
    }

    @Override
    protected void translateCode() {
        final String parameterName = parameter == null ? "unknown" : parameter.getName();
        code.addStatement("this()");
        code.addStatement("$L($L)", MethodListOptionsSetOptions.IDENTIFIER, parameterName);
    }

}
