package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;

public class MethodEndpointsClone extends MethodClone {

    public MethodEndpointsClone(Model currentModel, Model parentModel) {
        super(currentModel, parentModel);
    }

    @Override
    protected String generateStatement(String shortName) {
        return "return new " + shortName + "(" + AbstractEndpoints.METHOD_CLONE_SERVICE_STORE + "())";
    }

}
