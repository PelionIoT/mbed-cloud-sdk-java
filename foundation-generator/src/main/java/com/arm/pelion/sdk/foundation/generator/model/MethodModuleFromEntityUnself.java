package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodModuleFromEntityUnself extends MethodModuleCloudApiUnself {

    public MethodModuleFromEntityUnself(MethodModuleCloudApiUnself methodBasedOn, List<Parameter> methodParameters,
                                        boolean enforceModelValidity) {
        super(methodBasedOn.currentModel, methodBasedOn.returnModel, methodBasedOn.adapterFetcher,
              methodBasedOn.getName(), methodBasedOn.description,
              Utils.generateDocumentationMethodLink(null, methodBasedOn), methodBasedOn.needsCustomCode(),
              methodBasedOn.endpoints, methodBasedOn.endpointVariableName, methodBasedOn.lowLevelModule,
              methodParameters, methodBasedOn.methodParameters, methodBasedOn.parameterRenames,
              methodBasedOn.lowLevelMethod, enforceModelValidity);
    }

    @Override
    protected List<Parameter> extendParameterList(List<Parameter> methodParameters, List<Parameter> allParameters,
                                                  Method lowLevelMethod, Renames parameterRenames, Model currentModel) {
        return MethodModuleFromEntity.extendParameterList(methodParameters, currentModel);
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
        return "MethodModuleFromEntityUnself []";
    }

}
