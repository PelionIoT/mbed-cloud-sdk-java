package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class MethodModuleCloudApiUnself extends MethodModuleCloudApi {
    protected final Model returnModel;

    public MethodModuleCloudApiUnself(Model currentModel, Model returnModel, ModelAdapterFetcher adapterFetcher,
                                      String name, String description, String longDescription, boolean needsCustomCode,
                                      ModelEndpoints endpoints, String endpointVariableName, Class<?> lowLevelModule,
                                      List<Parameter> methodParameters, List<Parameter> allParameters,
                                      Renames parameterRenames, Method lowLevelMethod, boolean enforceModelValidity) {
        super(currentModel, adapterFetcher, name, description, longDescription, needsCustomCode, endpoints,
              endpointVariableName, lowLevelModule, methodParameters, allParameters, parameterRenames, lowLevelMethod,
              enforceModelValidity);
        this.returnModel = returnModel;
    }

    @Override
    public void initialise() {
        initialiseCodeBuilder();
        initialiseParameters();
        determineReturnType(returnModel, lowLevelMethod);
    }

    @Override
    protected Object getReturnAdapter() throws TranslationException {
        return getAdapter(returnModel);
    }

}
