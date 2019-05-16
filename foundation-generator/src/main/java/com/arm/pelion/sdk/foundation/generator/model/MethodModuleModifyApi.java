package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodModuleModifyApi extends MethodModuleCloudApi {
    protected final boolean isForCreation;

    public MethodModuleModifyApi(boolean isForCreation, Model currentModel, ModelAdapterFetcher adapterFetcher,
                                 String name, String description, String longDescription, boolean needsCustomCode,
                                 ModelEndpoints endpoints, String endpointVariableName, Class<?> lowLevelModule,
                                 List<Parameter> methodParameters, List<Parameter> allParameters,
                                 Renames parameterRenames, Method lowLevelMethod, boolean enforceModelValidity) {
        super(currentModel, adapterFetcher, name, description, longDescription, needsCustomCode, endpoints,
              endpointVariableName, lowLevelModule, methodParameters, allParameters, parameterRenames, lowLevelMethod,
              enforceModelValidity);
        this.isForCreation = isForCreation;
    }

    @Override
    protected void determineReturnType(Model currentModel, Method lowLevelMethod) {
        super.determineReturnType(currentModel, lowLevelMethod);
        setReturnDescription(Utils.generateDocumentationString(isForCreation ? "added" : "updated",
                                                               currentModel.getIdentifier(), false));
    }

    @Override
    protected void translateParameter(String parameterName, String initialParameterName, TypeParameter type,
                                      TypeParameter fromType, StringBuilder builder, List<Object> callElements,
                                      boolean isExternalParameter,
                                      List<Parameter> unusedParameters) throws TranslationException {
        if (type.isLowLevelModel()) {
            dealWithModifiedModel(this, type, isForCreation, parameterName, builder, callElements, unusedParameters);
        } else {
            super.translateParameter(parameterName, initialParameterName, type, fromType, builder, callElements,
                                     isExternalParameter, unusedParameters);
        }
    }

    public static void dealWithModifiedModel(MethodModuleCloudApi method, TypeParameter type, boolean isForCreation,
                                             String parameterName, StringBuilder builder, List<Object> callElements,
                                             List<Parameter> unusedParameters) throws TranslationException {
        translateModifiedModel(method.getAdapter(method.currentModel), isForCreation, parameterName, builder,
                               callElements);
        if (!unusedParameters.isEmpty()) {
            method.addUnusedParametersToBodyParameter(type, unusedParameters, builder, callElements);
        }
    }

    private static void translateModifiedModel(Object adapter, boolean isForCreation, String parameterName,
                                               StringBuilder builder, List<Object> callElements) {
        builder.append("$T.$L($L)");
        callElements.add(adapter);
        callElements.add(isForCreation ? ModelAdapter.FUNCTION_NAME_MAP_ADD : ModelAdapter.FUNCTION_NAME_MAP_UPDATE);
        callElements.add(parameterName);
    }
}
