package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.TranslationException;

public class Module extends AbstractSdkArtifact {

    public Module(String name, String description, String longDescription) {
        super(true, name, description, longDescription, false, true, false, false, false, false);
    }

    @Override
    public void translate() throws TranslationException {
        // TODO Auto-generated method stub

    }

}
