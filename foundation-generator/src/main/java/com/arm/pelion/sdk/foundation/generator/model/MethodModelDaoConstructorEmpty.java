package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.MbedCloudException;

public class MethodModelDaoConstructorEmpty extends MethodConstructorEmpty {

    public MethodModelDaoConstructorEmpty(Model currentModel, Model parentModel) {
        super(currentModel, parentModel);
        addException(MbedCloudException.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Class<? extends AbstractMethodConstructor> getConstructorType() {
        return (Class<? extends AbstractMethodConstructor>) super.getClass().getSuperclass();
    }

    @Override
    protected void translateCode() {
        code.addStatement("super()");
    }

}
