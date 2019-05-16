package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class MethodModulePaginationApiUnself extends MethodModuleListApiUnself {

    private final MethodModuleListApiUnself correspondingMethod;

    public MethodModulePaginationApiUnself(MethodModuleListApiUnself listMethod, boolean needsCustomCode) {
        super(listMethod.currentModel, listMethod.returnModel,
              MethodModulePaginationApi.generatePaginatorName(listMethod),
              MethodModulePaginationApi.generateDescription(listMethod.returnModel),
              MethodModulePaginationApi.generateLongDescription(listMethod), needsCustomCode, false, listMethod.fetcher,
              listMethod.adapterFetcher, listMethod.endpoints, listMethod.endpointVariableName,
              listMethod.lowLevelModule, listMethod.methodParameters, listMethod.allParameters,
              listMethod.parameterRenames, listMethod.lowLevelMethod, listMethod.enforceModelValidity);
        this.correspondingMethod = listMethod;
    }

    @Override
    protected boolean shouldCheckModelValidity(Parameter p) {
        return false;
    }

    @Override
    protected List<Parameter> extendParameterList(List<Parameter> methodParameters, List<Parameter> allParameters,
                                                  Method lowLevelMethod, Renames parameterRenames, Model currentModel) {
        return MethodModulePaginationApi.extendParameterList(methodParameters);
    }

    @Override
    protected void determineReturnType(Model currentModel, Method lowLevelMethod) {
        MethodModulePaginationApi.setReturnType(this, returnModel);
    }

    @Override
    protected void generateMethodCode() throws TranslationException {
        MethodModulePaginationApi.generateMethodCode(returnModel, this, correspondingMethod, false);
    }

    @Override
    public String toString() {
        return "MethodModulePaginationApi [correspondingMethod=" + correspondingMethod + "]";
    }

}
