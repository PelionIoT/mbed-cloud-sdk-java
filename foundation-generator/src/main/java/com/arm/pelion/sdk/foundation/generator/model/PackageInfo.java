package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class PackageInfo implements Artifact {
    private String packageName;
    private String description;
    private String longDescription;
    private String group;

    /**
     * @param packageName
     * @param description
     * @param longDescription
     * @param group
     */
    public PackageInfo(String packageName, String description, String longDescription, String group) {
        super();
        this.packageName = packageName;
        this.description = description;
        this.longDescription = longDescription;
        this.group = group;
    }

    /**
     * @return the packageName
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the longDescription
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param packageName
     *            the packageName to set
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param longDescription
     *            the longDescription to set
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    /**
     * @param group
     *            the group to set
     */
    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public void translate() throws TranslationException {
        // TODO Auto-generated method stub

    }

}
