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
        setReturnDescription((isForCreation ? "added" : "updated") + " "
                             + Utils.generateDocumentationString(currentModel.getIdentifier()));
    }

    @Override
    protected void translateParameter(String parameterName, TypeParameter type, StringBuilder builder,
                                      List<Object> callElements,
                                      boolean isExternalParameter) throws TranslationException {
        if (type.isLowLevelModel()) {
            builder.append("$T.$L($L)");
            callElements.add(getAdapter(currentModel));
            callElements.add(isForCreation ? ModelAdapter.FUNCTION_NAME_MAP_ADD
                                           : ModelAdapter.FUNCTION_NAME_MAP_UPDATE);
            callElements.add(parameterName);
        } else {
            super.translateParameter(parameterName, type, builder, callElements, isExternalParameter);
        }
    }
}
