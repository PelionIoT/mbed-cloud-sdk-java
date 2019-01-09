package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class MethodListOptionsClone extends MethodClone {

    public MethodListOptionsClone(Model currentModel, Model parentModel) {
        super(currentModel, parentModel);
        initialiseCodeBuilder();
    }

    @Override
    protected String generateStatement(String shortName) {
        return null;
    }

    @Override
    protected void translateCode() throws TranslationException {
        super.translateCode();
        final String shortName = determineClassShortName(currentModel);
        code.addStatement("final $L opt = new $L()", shortName, shortName);
        code.addStatement("opt.$L(this)", MethodListOptionsSetOptions.IDENTIFIER);
        code.addStatement("return opt");
    }

}
