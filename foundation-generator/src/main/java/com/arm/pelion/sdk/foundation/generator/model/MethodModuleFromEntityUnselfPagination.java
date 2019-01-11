package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class MethodModuleFromEntityUnselfPagination extends MethodModuleFromEntityUnselfList {

    public MethodModuleFromEntityUnselfPagination(MethodModuleFromEntityUnselfList listMethod,
                                                  boolean needsCustomCode) {
        super(listMethod, listMethod.methodParameters, listMethod.enforceModelValidity, listMethod.isPaginatedList,
              listMethod.fetcher);

        setName(MethodModulePaginationApi.generatePaginatorName(listMethod));
        setDescription(MethodModulePaginationApi.generateDescription(listMethod.returnModel));
    }

    @Override
    protected boolean mustParametersBeFinal() {
        return true;
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
        MethodModulePaginationApi.generateMethodCode(returnModel, this, methodBasedOn, true);
    }

    @Override
    public String toString() {
        return "MethodModuleFromEntityUnselfPagination [correspondingMethod=" + methodBasedOn + "]";
    }

}
