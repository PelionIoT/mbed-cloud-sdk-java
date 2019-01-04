package com.arm.pelion.sdk.foundation.generator.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReturnInformation {
    @JsonProperty(InputSchema.METHOD_DOES_RETURN_ITSELF_TAG)
    private boolean doesReturnItSelf;
    @JsonProperty(InputSchema.METHOD_DOES_RETURN_CUSTOM_TAG)
    private boolean doesReturnCustomType;
    @JsonProperty(InputSchema.TYPE_TAG)
    private String returnType;

    public ReturnInformation() {
        doesReturnItSelf = true;
        doesReturnCustomType = false;
        returnType = null;
    }

    public boolean doesReturnItSelf() {
        return doesReturnItSelf;
    }

    public void setDoesReturnItSelf(boolean doesReturnItSelf) {
        this.doesReturnItSelf = doesReturnItSelf;
    }

    public boolean isDoesReturnCustomType() {
        return doesReturnCustomType;
    }

    public void setDoesReturnCustomType(boolean doesReturnCustomType) {
        this.doesReturnCustomType = doesReturnCustomType;
    }

    public boolean hasReturnType() {
        return Utils.has(returnType);
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = Utils.getKey(returnType, false);
    }

    @Override
    public String toString() {
        return "ReturnInformation [doesReturnItSelf=" + doesReturnItSelf + ", doesReturnCustomType="
               + doesReturnCustomType + ", returnType=" + returnType + "]";
    }

}
