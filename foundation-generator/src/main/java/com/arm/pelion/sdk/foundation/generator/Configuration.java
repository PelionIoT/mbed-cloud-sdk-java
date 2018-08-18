package com.arm.pelion.sdk.foundation.generator;

public class Configuration {

    private String rootPackageName = "com.arm.mbed.cloud.sdk";

    private String modelPackage = "model";

    public Configuration() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the rootPackageName
     */
    public String getRootPackageName() {
        return rootPackageName;
    }

    /**
     * @param rootPackageName
     *            the rootPackageName to set
     */
    public void setRootPackageName(String rootPackageName) {
        this.rootPackageName = rootPackageName;
    }

    /**
     * @return the modelPackage
     */
    public String getModelPackage() {
        return modelPackage;
    }

    /**
     * @param modelPackage
     *            the modelPackage to set
     */
    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }

}
