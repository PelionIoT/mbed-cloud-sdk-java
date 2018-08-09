package com.arm.pelion.sdk.foundation.generator.model;

public class MethodClone extends AbstractMethodBasedOnModel {

    public MethodClone(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, false, "clone", "Clones this instance", "@see java.lang.Object#clone()", false,
              true, false, false, currentModel == null ? false : currentModel.needsFieldCustomisation(), false, false,
              true);
        setReturnType(getModelType(currentModel));
        setStatement(generateStatement(getModelType(currentModel).getShortName()));
    }

    private String generateStatement(String shortName) {
        return "return new " + shortName + "(this)";
    }

    private ParameterType getModelType(Model theCurrentModel) {
        return hasCurrentModel() ? theCurrentModel.toType() : new ParameterType();
    }

}
