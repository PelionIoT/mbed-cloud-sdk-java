package com.arm.pelion.sdk.foundation.generator.model;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.squareup.javapoet.CodeBlock;

public class MethodTest extends Method {

    public MethodTest(String name, String description, boolean containsCustomCode) {
        super(false, name, description, null, false, true, false, containsCustomCode, false, false, false, false);
        setCode(CodeBlock.builder());
    }

    public MethodTest(String methodUnderTest, boolean containsCustomCode) {
        this(ApiUtils.convertSnakeToCamel("test_" + processMethodName(methodUnderTest), false),
             "Tests the " + processMethodName(methodUnderTest) + " method", containsCustomCode);
    }

    private static String processMethodName(String methodUnderTest) {
        return String.valueOf(methodUnderTest).trim().toLowerCase();
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
