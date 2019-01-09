package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;
import java.util.List;

import com.arm.mbed.cloud.sdk.common.AbstractModule;
import com.arm.mbed.cloud.sdk.common.SdkContext;

public class MethodModuleConstructorFromSdkContext extends AbstractMethodConstructor {
    private static final String PARAMETER_SDK_CONTEXT = "context";
    protected List<Field> fields;

    public MethodModuleConstructorFromSdkContext(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, null, null, false);
    }

    @Override
    protected void translateCode() {
        code.addStatement("super($L)", PARAMETER_SDK_CONTEXT);
        currentModel.getFieldList().stream().filter(f -> ModelModule.ENDPOINTS_FIELD_NAME.equals(f.getName()))
                    .forEach(f -> code.addStatement("this.$L = new $T(this.$L)", f.getName(),
                                                    f.getType().hasClazz() ? f.getType().getClazz()
                                                                           : f.getType().getTypeName(),
                                                    AbstractModule.FIELD_NAME_SERVICE_REGISTRY));

    }

    @Override
    public List<String> getSignature() {
        return Arrays.asList(getParameterClass().getSimpleName());
    }

    @Override
    protected void addConstructorParameters() {
        addParameter(new Parameter(PARAMETER_SDK_CONTEXT,
                                   "SDK context @see {@link " + getParameterClass().getSimpleName() + "}.", null,
                                   TypeFactory.getCorrespondingType(getParameterClass()), null));
    }

    public Class<?> getParameterClass() {
        return SdkContext.class;
    }
}
