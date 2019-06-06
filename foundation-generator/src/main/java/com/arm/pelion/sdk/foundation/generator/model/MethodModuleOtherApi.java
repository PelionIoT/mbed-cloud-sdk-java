package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class MethodModuleOtherApi extends MethodModuleCloudApi {

    public MethodModuleOtherApi(Model currentModel, ModelAdapterFetcher adapterFetcher, String name, String description,
                                String longDescription, boolean needsCustomCode, ModelEndpoints endpoints,
                                String endpointVariableName, Class<?> lowLevelModule, List<Parameter> methodParameters,
                                List<Parameter> allParameters, Renames parameterRenames, Method lowLevelMethod,
                                boolean enforceModelValidity) {
        super(currentModel, adapterFetcher, name, description, longDescription, needsCustomCode, endpoints,
              endpointVariableName, lowLevelModule, methodParameters, allParameters, parameterRenames, lowLevelMethod,
              enforceModelValidity);
    }

    @Override
    protected void translateParameter(String parameterName, String initialParameterName, TypeParameter type,
                                      TypeParameter fromType, StringBuilder builder, List<Object> callElements,
                                      boolean isExternalParameter,
                                      List<Parameter> unusedParameters) throws TranslationException {
        if (type.isLowLevelModel()) {
            MethodModuleModifyApi.dealWithModifiedModel(this, type, false, true, parameterName, builder, callElements,
                                                        unusedParameters);
        } else {
            super.translateParameter(parameterName, initialParameterName, type, fromType, builder, callElements,
                                     isExternalParameter, unusedParameters);
        }
    }

}
