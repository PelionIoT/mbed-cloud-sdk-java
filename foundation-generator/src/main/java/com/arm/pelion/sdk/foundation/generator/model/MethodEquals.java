package com.arm.pelion.sdk.foundation.generator.model;

import com.squareup.javapoet.CodeBlock;

public class MethodEquals extends AbstractMethodBasedOnModel {

    private static final String PARAMETER_NAME = "obj";

    public MethodEquals(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, false, "equals",
              "Indicates whether some other object is \"equal to\" this one.",
              "@see java.lang.Object#equals(java.lang.Object)", false, true, false, false,
              currentModel == null ? false : currentModel.needsFieldCustomisation(), false, false, true);
        setReturnType(new ParameterType(boolean.class));
        addParameter(new Parameter(PARAMETER_NAME, "an object to compare with this instance", null,
                                   new ParameterType(Object.class), null));
        setReturnDescription("true if this object is the same as the obj argument; false otherwise.");
        setCode(CodeBlock.builder());
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.Method#translateCode()
     */
    @Override
    protected void translateCode() {
        super.translateCode();
        code.beginControlFlow("if (this == " + PARAMETER_NAME + ")");
        code.addStatement("return true");
        code.endControlFlow();
        code.beginControlFlow("if (" + PARAMETER_NAME + " == null)");
        code.addStatement("return false");
        code.endControlFlow();
        if (hasParentModel() || (hasCurrentModel() && currentModel.hasParent())) {
            code.beginControlFlow("if (getClass() != " + PARAMETER_NAME + ".getClass()) ");
        } else {
            code.beginControlFlow("if (!getClass().isAssignableFrom(" + PARAMETER_NAME + ".getClass())) ");
        }
        code.addStatement("return false");
        code.endControlFlow();
        if (hasParentModel() || (hasCurrentModel() && currentModel.hasParent())) {
            code.beginControlFlow("if (!super.equals(" + PARAMETER_NAME + ")) ");
            code.addStatement("return false");
            code.endControlFlow();
        }
        if (!hasCurrentModel() || !currentModel.hasFields()) {
            code.addStatement("return true");
            return;
        }
        code.addStatement("final " + currentModel.getName() + " other = (" + currentModel.getName() + ") "
                          + PARAMETER_NAME);
        currentModel.getFieldList().stream().filter(f -> !f.needsCustomCode()).forEach(f -> {
            if (f.getType().isBoolean() || f.getType().isNumber() || f.getType().isEnum()) {
                code.beginControlFlow("if ($L != other.$L)", f.getName(), f.getName());
                code.addStatement("return false");
                code.endControlFlow();
            } else {
                code.beginControlFlow("if ($L == null)", f.getName());
                code.beginControlFlow("if (other.$L != null)", f.getName());
                code.addStatement("return false");
                code.endControlFlow();
                code.nextControlFlow("else if (!$L.equals(other.$L))", f.getName(), f.getName());
                code.addStatement("return false");
                code.endControlFlow();
            }
        });
        code.addStatement("return true");
    }

}
