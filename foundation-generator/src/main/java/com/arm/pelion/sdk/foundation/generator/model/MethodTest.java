package com.arm.pelion.sdk.foundation.generator.model;

import junit.framework.Test;

public class MethodTest extends Method {

    public MethodTest(String name, String description, boolean containsCustomCode) {
        super(false, name, description, null, false, true, false, containsCustomCode, false, false, false, false);
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
