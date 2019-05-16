package com.arm.pelion.sdk.foundation.generator.model;

public class MethodCloneAbstractModel extends Method {

    public static final String IDENTIFIER = "clone_abstract_model";

    public MethodCloneAbstractModel() {
        super(false, MethodClone.IDENTIFIER, "Clones this instance", "@see java.lang.Object#clone()", false, true, true,
              false, false, false, false, true);
        setReturnDescription("a cloned instance");
        setReturnType(TypeFactory.getCorrespondingType(Object.class));// new TypeGenericParameter(SdkModel.class));

    }

    @Override
    public String getIdentifier() {
        return IDENTIFIER;
    }

}
