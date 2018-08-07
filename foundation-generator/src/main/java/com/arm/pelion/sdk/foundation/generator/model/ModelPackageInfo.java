package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.PackageInfo;

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
