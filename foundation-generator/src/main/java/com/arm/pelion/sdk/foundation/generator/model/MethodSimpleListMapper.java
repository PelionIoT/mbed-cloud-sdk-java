package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class MethodSimpleListMapper extends MethodMapper {
    protected static final String PARAMETER_NAME = "toBeMapped";
    private final String getMapperMethodName;
    private final Model adapterModel;

    public MethodSimpleListMapper(String name, String getMapperMethodName, boolean isAccessible, Model from, Model to,
                                  TypeParameter toType, Model adapterModel) {
        super(name, MethodAction.LIST, isAccessible, to, from, false, null, null);
        this.adapterModel = adapterModel;
        this.getMapperMethodName = getMapperMethodName;
        setReturnInfo(toType);
    }

    private void setReturnInfo(TypeParameter toType) {
        setReturnType(toType);
        setReturnDescription("mapped simple list");
    }

    @Override
    protected void translateCode() throws TranslationException {
        final TypeParameter adapterType = adapterModel.toType();
        adapterType.translate();
        code.addStatement("return $T.$L($L,$T.$L())", GenericAdapter.class, GenericAdapter.MAP_LIST_FUNCTION_NAME,
                          PARAMETER_NAME, adapterType.getTypeName(), getMapperMethodName);
    }
}
