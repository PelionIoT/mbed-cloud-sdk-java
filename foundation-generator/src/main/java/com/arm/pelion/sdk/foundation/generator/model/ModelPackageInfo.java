package com.arm.pelion.sdk.foundation.generator.model;

public class ModelPackageInfo extends PackageInfo {

    /**
     * @param packageName
     * @param description
     * @param longDescription
     * @param group
     */
    public ModelPackageInfo(String packageName, String group) {
        super(packageName, "Model objects for " + group + " module", null, group);
    }

}
