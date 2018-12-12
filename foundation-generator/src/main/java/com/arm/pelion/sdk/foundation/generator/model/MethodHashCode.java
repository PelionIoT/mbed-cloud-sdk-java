package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Objects;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class MethodHashCode extends AbstractMethodBasedOnModel {

    public static final String IDENTIFIER = "hashCode";

    public MethodHashCode(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, false, IDENTIFIER,
              "Calculates the hash code of this instance based on field values", "@see java.lang.Object#hashCode()",
              false, true, false, false, currentModel == null ? false : currentModel.needsFieldCustomisation(), false,
              false, true);
        setReturnType(TypeFactory.getCorrespondingType(int.class));
        setReturnDescription("hash code");
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
        if (hasCurrentModel() && currentModel.hasFields()) {
            code.addStatement("final int prime = 31");
            if (hasParentModel() || (hasCurrentModel() && currentModel.hasParent())) {
                code.addStatement("int result = super.hashCode()");
            } else {
                code.addStatement("int result = 1");
            }

            currentModel.getFieldList().stream().filter(f -> !f.needsCustomCode() && !f.isAlreadyDefined())
                        .forEach(f -> {
                            if (f.getType().isPrimitive()) {
                                if (f.getType().isCharacter() || f.getType().isString()) {
                                    code.addStatement("result = prime * result + (($L == null) ? 0 : $T.hashCode($L))",
                                                      f.getName(), Objects.class, f.getName());
                                } else {
                                    code.addStatement("result = prime * result +  $T.hashCode($L)", Objects.class,
                                                      f.getName());
                                }
                            } else {
                                code.addStatement("result = prime * result + (($L == null) ? 0 : $L.hashCode())",
                                                  f.getName(), f.getName());
                            }
                        });
            code.addStatement("return result");
        } else {
            if (hasParentModel() || (hasCurrentModel() && currentModel.hasParent())) {
                code.addStatement("return super.hashCode()");
            } else {
                code.addStatement("return 1");
            }
        }
    }

}
