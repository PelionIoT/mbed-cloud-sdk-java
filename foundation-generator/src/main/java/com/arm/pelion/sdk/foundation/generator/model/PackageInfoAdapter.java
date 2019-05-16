package com.arm.pelion.sdk.foundation.generator.model;

public class PackageInfoAdapter extends PackageInfo {

    /**
     * @param packageName
     * @param description
     * @param longDescription
     * @param group
     */
    public PackageInfoAdapter(String packageName, String group) {
        super(packageName, "Adapters for " + group + " module", null, group);
    }

}
