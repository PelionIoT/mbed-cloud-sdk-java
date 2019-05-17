package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class MethodEquals extends AbstractMethodBasedOnModel {

    public static final String IDENTIFIER = "equals";
    private static final String PARAMETER_NAME = "obj";

    public MethodEquals(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, false, IDENTIFIER,
              "Indicates whether some other object is \"equal to\" this one.",
              "@see java.lang.Object#equals(java.lang.Object)", false, true, false,
              currentModel == null ? false : currentModel.needsFieldCustomisation(),
              currentModel == null ? false : currentModel.needsFieldCustomisation(), false, false, true);
        setReturnType(TypeFactory.getCorrespondingType(boolean.class));
        addParameter(new Parameter(PARAMETER_NAME, "an object to compare with this instance", null,
                                   TypeFactory.getCorrespondingType(Object.class), null, null));
        setReturnDescription("true if this object is the same as the obj argument; false otherwise.");
        initialiseCodeBuilder();
        shouldTest(true);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.Method#translateCode()
     */
    @Override
    protected void translateCode() throws TranslationException {
        super.translateCode();
        code.beginControlFlow("if (this == " + PARAMETER_NAME + ")");
        code.addStatement("return true");
        code.endControlFlow();
        code.beginControlFlow("if (" + PARAMETER_NAME + " == null)");
        code.addStatement("return false");
        code.endControlFlow();
        if (hasParentModel() || (hasCurrentModel() && currentModel.hasParent())) {
            code.beginControlFlow("if (!super.equals(" + PARAMETER_NAME + ")) ");
            code.addStatement("return false");
            code.endControlFlow();
        }
        if (!hasCurrentModel()) {
            code.addStatement("return true");
            return;
        }
        code.beginControlFlow("if( !($L instanceof $L))", PARAMETER_NAME, currentModel.getName());
        code.addStatement("return false");
        code.endControlFlow();
        final String localVariable = "other";
        code.addStatement("final $L $L = ($L) $L", currentModel.getName(), localVariable, currentModel.getName(),
                          PARAMETER_NAME);
        code.beginControlFlow("if( !$L.$L(this))", localVariable, MethodCanEqual.IDENTIFIER);
        code.addStatement("return false");
        code.endControlFlow();
        if (!currentModel.hasFields()) {
            code.addStatement("return true");
            return;
        }
        currentModel.getFieldList().stream().filter(f -> !f.needsCustomCode() && !f.isAlreadyDefined()).forEach(f -> {
            if (((f.getType().isBoolean() || f.getType().isNumber()) && f.getType().isPrimitive())
                || f.getType().isEnum()) {
                code.beginControlFlow("if ($L != $L.$L)", f.getName(), localVariable, f.getName());
                code.addStatement("return false");
                code.endControlFlow();
            } else {
                code.beginControlFlow("if ($L == null)", f.getName());
                code.beginControlFlow("if ($L.$L != null)", localVariable, f.getName());
                code.addStatement("return false");
                code.endControlFlow();
                code.nextControlFlow("else if (!$L.equals($L.$L))", f.getName(), localVariable, f.getName());
                code.addStatement("return false");
                code.endControlFlow();
            }
        });
        code.addStatement("return true");
    }

    @Override
    protected void addStaticAnalysisAnnotations() {
        if (currentModel.hasFields()
            && currentModel.getFieldList().size() > StaticAnalysisUtils.FIELD_LIMIT_FOR_IGNORING_WARNINGS) {
            annotationRegistry.ignoreExcessiveMethodLength();
        }
        super.addStaticAnalysisAnnotations();
    }

}
