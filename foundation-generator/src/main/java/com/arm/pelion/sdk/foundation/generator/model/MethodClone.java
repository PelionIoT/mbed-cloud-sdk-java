package com.arm.pelion.sdk.foundation.generator.model;

public class MethodClone extends AbstractMethodBasedOnModel {

    public static final String IDENTIFIER = "clone";

    public MethodClone(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, false, IDENTIFIER, "Clones this instance", "@see java.lang.Object#clone()",
              false, true, false, false, currentModel == null ? false : currentModel.needsFieldCustomisation(), false,
              false, true);
        setReturnDescription("a cloned instance");
        setReturnType(getModelType(currentModel));
        setStatement(generateStatement(determineClassShortName(currentModel)));
        shouldTest(true);
    }

    protected String determineClassShortName(Model currentModel) {
        return getModelType(currentModel).getShortName();
    }

    protected String generateStatement(String shortName) {
        return "return new " + shortName + "(this)";
    }

    private TypeParameter getModelType(Model theCurrentModel) {
        return hasCurrentModel() ? theCurrentModel.toType() : new TypeParameter();
    }

}
