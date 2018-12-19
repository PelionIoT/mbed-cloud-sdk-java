package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;

import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodGeneric extends MethodOverloaded {

    public MethodGeneric(java.lang.reflect.Method m, String suffix) {
        super(m, null, null, true, suffix);
        setAbstract(false);
        setNeedsCustomCode(true);
        Arrays.asList(m.getParameters())
              .forEach(arg -> addParameter(new Parameter(arg.getName(),
                                                         Utils.generateDocumentationString(arg.getName()), null,
                                                         TypeFactory.getCorrespondingType(arg.getType()), null)));
    }

    public MethodGeneric(String name, String description, String longDescription, String overloadingSuffix) {
        super(false, name, description, longDescription, false, true, false, false, true, false, false, false,
              overloadingSuffix);
    }

}
