package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;
import java.util.List;

import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public class MethodModuleConstructorFromConnectionOptions extends AbstractMethodConstructor {
    private static final String PARAM_CONNECTION_OPTIONS = "options";
    protected List<Field> fields;

    public MethodModuleConstructorFromConnectionOptions(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, null, null, false);
    }

    @Override
    protected void translateCode() {
        code.addStatement("super($L)", PARAM_CONNECTION_OPTIONS);
        currentModel.getFieldList().stream().filter(f -> ModelModule.ENDPOINTS_FIELD_NAME.equals(f.getName()))
                    .forEach(f -> code.addStatement("this.$L = new $T(this.$L)", f.getName(),
                                                    f.getType().hasClazz() ? f.getType().getClazz()
                                                                           : f.getType().getTypeName(),
                                                    AbstractApi.SERVICE_STORE_FIELD_NAME));

    }

    @Override
    public List<String> getSignature() {
        return Arrays.asList(ConnectionOptions.class.getSimpleName());
    }

    @Override
    protected void addConstructorParameters() {
        addParameter(new Parameter(PARAM_CONNECTION_OPTIONS, "connection options @see {@link ConnectionOptions}.", null,
                                   TypeFactory.getCorrespondingType(ConnectionOptions.class), null));
    }
}
