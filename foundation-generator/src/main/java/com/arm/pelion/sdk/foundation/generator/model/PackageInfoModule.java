package com.arm.pelion.sdk.foundation.generator.model;

public class PackageInfoModule extends PackageInfo {

    /**
     * @param packageName
     * @param description
     * @param longDescription
     * @param group
     */
    public PackageInfoModule(String packageName, String group) {
        super(packageName, "Modules", null, group);
    }

}
