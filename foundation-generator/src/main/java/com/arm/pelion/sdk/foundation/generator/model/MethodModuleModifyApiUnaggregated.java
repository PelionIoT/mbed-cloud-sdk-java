package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodModuleModifyApiUnaggregated extends MethodModuleCloudApiUnaggregated {
    protected final boolean isForCreation;

    public MethodModuleModifyApiUnaggregated(boolean isForCreation, Model currentModel, Model returnModel,
                                             ModelAdapterFetcher adapterFetcher, String name, String description,
                                             String longDescription, boolean needsCustomCode, ModelEndpoints endpoints,
                                             String endpointVariableName, Class<?> lowLevelModule,
                                             List<Parameter> methodParameters, List<Parameter> allParameters,
                                             Renames parameterRenames, Method lowLevelMethod,
                                             boolean enforceModelValidity) {
        super(currentModel, returnModel, adapterFetcher, name, description, longDescription, needsCustomCode, endpoints,
              endpointVariableName, lowLevelModule, methodParameters, allParameters, parameterRenames, lowLevelMethod,
              enforceModelValidity);
        this.isForCreation = isForCreation;
    }

    @Override
    protected void determineReturnType(Model correspondingModel, Method lowLevelMethod) {
        super.determineReturnType(correspondingModel, lowLevelMethod);
        setReturnDescription(Utils.generateDocumentationString(isForCreation ? "added" : "updated",
                                                               correspondingModel.getIdentifier(), false));
    }

    @Override
    protected void translateParameter(String parameterName, TypeParameter type, StringBuilder builder,
                                      List<Object> callElements, boolean isExternalParameter,
                                      List<Parameter> unusedParameters) throws TranslationException {
        if (type.isLowLevelModel()) {
            MethodModuleModifyApi.dealWithModifiedModel(this, isForCreation, parameterName, builder, callElements,
                                                        unusedParameters);
        } else {
            super.translateParameter(parameterName, type, builder, callElements, isExternalParameter, unusedParameters);
        }
    }
}
