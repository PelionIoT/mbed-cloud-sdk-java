package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodModuleFromEntityUnselfList extends MethodModuleCloudApiUnself {
    protected final boolean isPaginatedList;
    protected final ModelListOptionFetcher fetcher;
    protected final MethodModuleCloudApiUnself methodBasedOn;

    public MethodModuleFromEntityUnselfList(MethodModuleCloudApiUnself methodBasedOn, List<Parameter> methodParameters,
                                            boolean enforceModelValidity, boolean isPaginatedList,
                                            ModelListOptionFetcher listOptionsFetcher) {
        super(methodBasedOn.currentModel, methodBasedOn.returnModel, methodBasedOn.adapterFetcher,
              methodBasedOn.getName(), methodBasedOn.description,
              Utils.generateDocumentationMethodLink(null, methodBasedOn), methodBasedOn.needsCustomCode(),
              methodBasedOn.endpoints, methodBasedOn.endpointVariableName, methodBasedOn.lowLevelModule,
              methodParameters, methodBasedOn.methodParameters, methodBasedOn.parameterRenames,
              methodBasedOn.lowLevelMethod, enforceModelValidity);
        this.isPaginatedList = isPaginatedList;
        this.fetcher = listOptionsFetcher;
        this.methodBasedOn = methodBasedOn;
    }

    @Override
    protected List<Parameter> extendParameterList(List<Parameter> methodParameters, List<Parameter> allParameters,
                                                  Method lowLevelMethod, Renames parameterRenames, Model currentModel) {
        List<Parameter> otherParameters = MethodModuleFromEntity.extendParameterList(methodParameters, currentModel);
        if (isPaginatedList) {
            otherParameters = MethodModuleListApi.addListOptionParameter(otherParameters, returnModel, fetcher);
        }
        return otherParameters;
    }

    @Override
    protected void determineReturnType(Model returnModel, Method lowLevelMethod) {
        MethodModuleListApi.setReturnType(this, returnModel);
    }

    @Override
    protected boolean mustParametersBeFinal() {
        return false;
    }

    @Override
    protected void generateMethodCode() throws TranslationException {
        MethodModuleFromEntity.generateMethodCode(this);
    }

    @Override
    public String toString() {
        return "MethodModuleFromEntity ";
    }

}
