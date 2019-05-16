package com.arm.pelion.sdk.foundation.generator.model;

public class TypeConnect extends TypeParameter {

    public static final String LEGACY_PACKAGE_NAME = "com.arm.mbed.cloud.sdk";

    public TypeConnect() {
        super(new Import("Connect", LEGACY_PACKAGE_NAME));
    }

}
