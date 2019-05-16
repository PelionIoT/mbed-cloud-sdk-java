package com.arm.pelion.sdk.foundation.generator.model;

public class MethodListOptionsConstructorEmpty extends MethodConstructorEmpty {

    public MethodListOptionsConstructorEmpty(Model currentModel, Model parentModel) {
        super(currentModel, parentModel);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Class<? extends AbstractMethodConstructor> getConstructorType() {
        return (Class<? extends AbstractMethodConstructor>) super.getClass().getSuperclass();
    }

    @Override
    protected void translateCode() {
        code.addStatement("super()");
        code.addStatement("$L()", MethodListOptionsSetDefault.IDENTIFIER);
    }

}
