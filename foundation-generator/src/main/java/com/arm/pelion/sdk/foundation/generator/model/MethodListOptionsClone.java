package com.arm.pelion.sdk.foundation.generator.model;

import com.squareup.javapoet.CodeBlock;

public class MethodListOptionsClone extends MethodClone {

    public MethodListOptionsClone(Model currentModel, Model parentModel) {
        super(currentModel, parentModel);
        setCode(CodeBlock.builder());
    }

    @Override
    protected String generateStatement(String shortName) {
        return null;
    }

    @Override
    protected void translateCode() {
        super.translateCode();
        final String shortName = determineClassShortName(currentModel);
        code.addStatement("final $S opt = new $S()", shortName);
        code.addStatement("opt.$S(this)", MethodListOptionsSetOptions.IDENTIFIER);
        code.addStatement("return opt");
    }

}
