package com.arm.pelion.sdk.foundation.generator.model;

import com.squareup.javapoet.CodeBlock;

public class MethodListOptionsSetDefault extends AbstractMethodBasedOnModel {

    public static final String IDENTIFIER = "setDefault";

    public MethodListOptionsSetDefault(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, false, IDENTIFIER, "Sets default option values", null, false, false, false,
              false, currentModel == null ? false : currentModel.needsFieldCustomisation(), true, false, true);
        setCode(CodeBlock.builder());
    }

    @Override
    protected void translateCode() {
        super.translateCode();
        code.addStatement("super.$L();", IDENTIFIER);
        currentModel.getFieldList().stream().filter(f -> !f.isAlreadyDefined())
                    .forEach(f -> code.addStatement("$L($L)", new MethodSetter(f).getName(), f.getDefaultValue()));
    }
}
