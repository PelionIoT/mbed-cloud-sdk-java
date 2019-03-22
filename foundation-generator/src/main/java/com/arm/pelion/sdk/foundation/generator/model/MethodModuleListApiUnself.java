package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class MethodModuleListApiUnself extends MethodModuleCloudApiUnself {
    protected final boolean isPaginatedList;
    protected final ModelListOptionFetcher fetcher;

    public MethodModuleListApiUnself(Model currentModel, Model returnModel, String name, String description,
                                     String longDescription, boolean needsCustomCode, boolean isPaginatedList,
                                     ModelListOptionFetcher listOptionsFetcher, ModelAdapterFetcher adapterFetcher,
                                     ModelEndpoints endpoints, String endpointVariableName, Class<?> lowLevelModule,
                                     List<Parameter> methodParameters, List<Parameter> allParameters,
                                     Renames parameterRenames, Method lowLevelMethod, boolean enforceModelValidity) {
        super(currentModel, returnModel, adapterFetcher, name, description, longDescription, needsCustomCode, endpoints,
              endpointVariableName, lowLevelModule, methodParameters, allParameters,
              MethodModuleListApi.extendRenames(parameterRenames), lowLevelMethod, enforceModelValidity);
        this.isPaginatedList = isPaginatedList;
        this.fetcher = listOptionsFetcher;
    }

    @Override
    protected List<Parameter> extendParameterList(List<Parameter> methodParameters, List<Parameter> allParameters,
                                                  Method lowLevelMethod, Renames parameterRenames, Model currentModel) {
        List<Parameter> otherParameters = super.extendParameterList(methodParameters, allParameters, lowLevelMethod,
                                                                    parameterRenames, currentModel);
        if (isPaginatedList) {
            otherParameters = MethodModuleListApi.addListOptionParameter(otherParameters, returnModel, fetcher);
        }
        return otherParameters;
    }

    @Override
    protected boolean shouldCheckModelValidity(Parameter p) {
        return super.shouldCheckModelValidity(p)
               && !MethodModuleListApi.PARAMETER_NAME_OPTIONS.equals(p.getIdentifier());
    }

    @Override
    protected void determineReturnType(Model returnModel, Method lowLevelMethod) {
        MethodModuleListApi.setReturnType(this, returnModel);
    }

    @Override
    protected String getMappingMethod() {
        return MethodModuleListApi.getMappingMethod(isPaginatedList);
    }

    @Override
    protected void generateVariableInitialisation(List<Parameter> methodParameters) throws TranslationException {
        MethodModuleListApi.generateVariableInitialisation(this, returnModel, fetcher, methodParameters);
    }

    @Override
    protected void translateParameter(String parameterName, String initialParameterName, TypeParameter type,
                                      StringBuilder builder, List<Object> callElements, boolean isExternalParameter,
                                      List<Parameter> unusedParameters) throws TranslationException {
        if (isPaginatedList) {
            final ModelListOption correspondingListOptions = MethodModuleListApi.determineListOptionModel(returnModel,
                                                                                                          fetcher);
            if (correspondingListOptions.hasFieldInHierachy(parameterName)) {
                MethodModuleListApi.translateListOptionParameter(this, correspondingListOptions, parameterName, type,
                                                                 builder, callElements);
            } else {
                super.translateParameter(parameterName, initialParameterName, type, builder, callElements,
                                         isExternalParameter, unusedParameters);
            }

        } else {
            super.translateParameter(parameterName, initialParameterName, type, builder, callElements,
                                     isExternalParameter, unusedParameters);
        }
    }

    @Override
    public String toString() {
        return "MethodModuleListApiUnaggregated [isPaginatedList=" + isPaginatedList + ", " + super.toString() + "]";
    }

}
