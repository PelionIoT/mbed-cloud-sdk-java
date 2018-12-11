package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;
import java.util.List;

import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public class MethodEndpointsConstructorFromOptions extends AbstractMethodConstructor {
    private static final String PARAM_OPTIONS = "options";

    public MethodEndpointsConstructorFromOptions(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, null, null, false);
    }

    @Override
    protected void translateCode() {
        code.addStatement("this(new $T($L))", ApiClientWrapper.class, PARAM_OPTIONS);
    }

    @Override
    public List<String> getSignature() {
        return Arrays.asList(ConnectionOptions.class.getSimpleName());
    }

    @Override
    protected void addConstructorParameters() {
        addParameter(new Parameter(PARAM_OPTIONS, "connection options {@link ConnectionOptions}.", null,
                                   TypeFactory.getCorrespondingType(ConnectionOptions.class), null));
    }
}
