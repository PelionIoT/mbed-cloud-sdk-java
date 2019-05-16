package com.arm.pelion.sdk.foundation.generator.model;

public class MethodFilter extends MethodOverloaded {

    protected final Filter filter;

    public MethodFilter(Filter filter, String name, String description, boolean containsCustomCode) {
        super(false, name, description, null, false, true, false, containsCustomCode, false, false, false, false, null);
        this.filter = filter;
    }
}
