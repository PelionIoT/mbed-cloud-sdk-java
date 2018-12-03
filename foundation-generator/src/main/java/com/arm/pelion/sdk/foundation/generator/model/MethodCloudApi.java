package com.arm.pelion.sdk.foundation.generator.model;

public class MethodCloudApi extends Method {

    public MethodCloudApi(String name, String description, String longDescription, boolean isAccessible,
                          boolean containsCustomCode, boolean needsCustomCode, boolean isInternal, boolean isRequired,
                          boolean isAnOverride) {
        super(false, name, description, longDescription, false, isAccessible, false, containsCustomCode,
              needsCustomCode, isInternal, isRequired, isAnOverride);
    }

}
