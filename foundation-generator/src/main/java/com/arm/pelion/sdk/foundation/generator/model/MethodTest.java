package com.arm.pelion.sdk.foundation.generator.model;

import org.junit.Test;

import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodTest extends Method {

    public MethodTest(String name, String description, boolean containsCustomCode) {
        super(false, name, description, null, false, true, false, containsCustomCode, false, false, false, false);
        initialiseCodeBuilder();
        setIgnoreResourceClosure(true);
    }

    public MethodTest(String methodUnderTest, boolean containsCustomCode) {
        this(Utils.combineNames(false, "test", processMethodName(methodUnderTest)),
             "Tests the " + processMethodName(methodUnderTest) + " method", containsCustomCode);
    }

    private static String processMethodName(String methodUnderTest) {
        return String.valueOf(methodUnderTest).trim();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.Method#addModifiers()
     */
    @Override
    protected void addModifiers() {
        super.addModifiers();
        specificationBuilder.addAnnotation(Test.class);
    }

}
