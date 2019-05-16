package com.arm.pelion.sdk.foundation.generator.model;

public class MethodGeneric extends MethodOverloaded {

    public MethodGeneric(java.lang.reflect.Method m, String suffix) {
        super(m, null, null, true, true, suffix);
        setAbstract(false);
        setNeedsCustomCode(true);

    }

    public MethodGeneric(String name, String description, String longDescription, String overloadingSuffix) {
        super(false, name, description, longDescription, false, true, false, false, true, false, false, false,
              overloadingSuffix);
    }

}
