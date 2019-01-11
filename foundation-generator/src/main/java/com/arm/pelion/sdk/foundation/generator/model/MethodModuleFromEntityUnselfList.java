package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        // FIXME change to methodParameters when methodParameters deals with filters in intermediate config.
        List<Parameter> otherParameters = extendParameterList(methodParameters, allParameters, currentModel);
        if (isPaginatedList) {
            otherParameters = MethodModuleListApi.addListOptionParameter(otherParameters, returnModel, fetcher);
        }
        otherParameters = MethodModuleFromEntity.extendParameterList(otherParameters.stream()
                                                                                    .filter(p -> !currentModel.hasFieldInHierachy(p.getName()))
                                                                                    .collect(Collectors.toList()),
                                                                     currentModel);

        return otherParameters;
    }

    public static List<Parameter> extendParameterList(List<Parameter> methodParameters, List<Parameter> allParameters,
                                                      Model currentModel) {
        if (allParameters == null) {
            return new ArrayList<>();
        }
        final List<Parameter> clonedMethodParameters = new ArrayList<>(allParameters.size());
        allParameters.forEach(p -> clonedMethodParameters.add(p.clone()));
        return clonedMethodParameters;
    }

    @Override
    protected void generateVariableInitialisation(List<Parameter> methodParameters) throws TranslationException {
        MethodModuleListApi.generateVariableInitialisation(this, returnModel, fetcher, methodParameters);
    }

    @Override
    protected void determineReturnType(Model returnModel, Method lowLevelMethod) {
        MethodModuleListApi.setReturnType(this, returnModel);
    }

    @Override
    protected boolean shouldCheckModelValidity(Parameter p) {
        if (!super.shouldCheckModelValidity(p)) {
            return false;
        }
        return !p.getType().isListOptions();
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
