package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MethodGeneric extends Method {
    private java.lang.reflect.Method m;

    public MethodGeneric(java.lang.reflect.Method m) {
        super(false, m.getName(), null, null, false, true, false, false, true, false, false, true);
        if (returnsObjects(m)) {
            setReturnType(new ParameterType(m.getReturnType()));
        }
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Arrays.asList(m.getParameterTypes())
              .forEach(arg -> addParameter(new Parameter("arg" + atomicInteger.getAndIncrement(), "an argument", null,
                                                         new ParameterType(arg), null)));
    }

    private static boolean returnsObjects(java.lang.reflect.Method m) {
        return m.getReturnType() != Void.class && m.getReturnType() != void.class;
    }

}
