package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;
import java.util.List;

import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;

public class MethodEndpointsConstructorFromClient extends AbstractMethodConstructor {
    private static final String PARAM_CLIENT = "client";
    protected List<Field> fields;

    public MethodEndpointsConstructorFromClient(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, null, null, false);
    }

    @Override
    protected void translateCode() {

        code.addStatement("super($L)", PARAM_CLIENT);
        currentModel.getFieldList().stream()
                    .forEach(f -> code.addStatement("this.$L = $L.createService($T.class)", f.getName(), PARAM_CLIENT,
                                                    f.getType().hasClazz() ? f.getType().getClazz()
                                                                           : f.getType().getTypeName()));

    }

    @Override
    public List<String> getSignature() {
        return Arrays.asList(ApiClientWrapper.class.getSimpleName());
    }

    @Override
    protected void addConstructorParameters() {
        addParameter(new Parameter(PARAM_CLIENT, "API client {@link ApiClientWrapper}.", null,
                                   new ParameterType(ApiClientWrapper.class), null));
    }
}
