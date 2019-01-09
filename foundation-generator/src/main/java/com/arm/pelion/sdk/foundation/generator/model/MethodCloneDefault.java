package com.arm.pelion.sdk.foundation.generator.model;

public class MethodCloneDefault extends Method {

    public static final String IDENTIFIER = "clone_default";

    public MethodCloneDefault() {
        super(false, MethodClone.IDENTIFIER, "Clones this instance", "@see java.lang.Object#clone()", false, true,
              false, false, false, false, false, true);
        setReturnDescription("a cloned instance");
        setReturnType(TypeFactory.getCorrespondingType(Object.class));
        initialiseCodeBuilder();
        generateCode();

    }

    protected void generateCode() {
        final String exceptionVariable = "exception";
        code.beginControlFlow("try");
        code.addStatement("return super.clone()");
        code.endControlFlow();
        code.beginControlFlow("catch($T $L)", CloneNotSupportedException.class, exceptionVariable);
        code.addStatement("return null");
        code.endControlFlow();
    }

    @Override
    public String getIdentifier() {
        return IDENTIFIER;
    }

}
