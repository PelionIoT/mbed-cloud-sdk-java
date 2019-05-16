package com.arm.pelion.sdk.foundation.generator.model;

public class PackageInfoModel extends PackageInfo {

    /**
     * @param packageName
     * @param description
     * @param longDescription
     * @param group
     */
    public PackageInfoModel(String packageName, String group) {
        super(packageName, "Model objects for " + group + " module", null, group);
    }

}
