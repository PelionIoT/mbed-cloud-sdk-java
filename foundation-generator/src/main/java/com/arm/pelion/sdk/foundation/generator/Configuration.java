package com.arm.pelion.sdk.foundation.generator;

import java.io.File;
import java.io.IOException;

import com.arm.pelion.sdk.foundation.generator.util.Logger;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Configuration {
    public static final String TOOL_NAME = "Foundation Generator";
    private String rootPackageName;

    private String modelPackage;

    private String adapterPackage;

    private String modulePackage;// "module";

    private String factoryPackage;// "factory"

    private String lowLevelApiModuleNameRegex;

    private boolean forceRegenerateUnitTests;

    public Configuration() {
        rootPackageName = "com.arm.mbed.cloud.sdk";
        modelPackage = "model";
        adapterPackage = "adapters";
        modulePackage = null;// "module";
        factoryPackage = null;// "factory"
        lowLevelApiModuleNameRegex = ".*Api";
        forceRegenerateUnitTests = true;
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

    public String getAdapterPackage() {
        return adapterPackage;
    }

    public void setAdapterPackage(String adapterPackage) {
        this.adapterPackage = adapterPackage;
    }

    public String getModulePackage() {
        return modulePackage;
    }

    public void setModulePackage(String modulePackage) {
        this.modulePackage = modulePackage;
    }

    /**
     * @return the lowLevelApiModuleNameRegex
     */
    public String getLowLevelApiModuleNameRegex() {
        return lowLevelApiModuleNameRegex;
    }

    /**
     * @param lowLevelApiModuleNameRegex
     *            the lowLevelApiModuleNameRegex to set
     */
    public void setLowLevelApiModuleNameRegex(String lowLevelApiModuleNameRegex) {
        this.lowLevelApiModuleNameRegex = lowLevelApiModuleNameRegex;
    }

    public String getFactoryPackage() {
        return factoryPackage;
    }

    public void setFactoryPackage(String factoryPackage) {
        this.factoryPackage = factoryPackage;
    }

    public boolean isForceRegenerateUnitTests() {
        return forceRegenerateUnitTests;
    }

    public void setForceRegenerateUnitTests(boolean forceRegenerateUnitTests) {
        this.forceRegenerateUnitTests = forceRegenerateUnitTests;
    }

    @Override
    public String toString() {
        return "Configuration [rootPackageName=" + rootPackageName + ", modelPackage=" + modelPackage
               + ", adapterPackage=" + adapterPackage + ", modulePackage=" + modulePackage + ", factoryPackage="
               + factoryPackage + ", lowLevelApiModuleNameRegex=" + lowLevelApiModuleNameRegex
               + ", forceRegenerateUnitTests=" + forceRegenerateUnitTests + "]";
    }

    public static Configuration load(Logger logger, File configFile) {
        Configuration config = new Configuration();
        if (configFile == null || !configFile.exists() || !configFile.isFile()) {
            logger.logWarn(TOOL_NAME + " configuration file is invalid: [" + configFile + "]");
            logger.logInfo("Defaulting to " + config);
            return config;
        }
        ObjectMapper mapper = new ObjectMapper(new JsonFactory());
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setDefaultMergeable(Boolean.TRUE);
        try {
            logger.logInfo("Loading " + TOOL_NAME + " configuration from : " + configFile);
            mapper.readerForUpdating(config).readValue(configFile);
        } catch (IOException exception) {
            logger.logError("Failed loading " + configFile, exception);
        }
        return config;
    }
}
