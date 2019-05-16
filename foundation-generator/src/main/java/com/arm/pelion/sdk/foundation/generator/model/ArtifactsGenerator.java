package com.arm.pelion.sdk.foundation.generator.model;

import java.io.File;

import com.arm.pelion.sdk.foundation.generator.util.CleanException;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class ArtifactsGenerator extends AbstractGenerator {

    private final Artifacts artifacts;
    private final boolean forceRegenerateUnitTests;
    protected final File modelSourceDestinationDirectory;
    protected final File primarySourceDestinationDirectory;
    protected final File modelTestDestinationDirectory;
    protected final File primaryTestDestinationDirectory;

    public ArtifactsGenerator(File sourceDestinationDirectory, File testDestinationDirectory,
                              File modelSourceDestinationDirectory, File modelTestDestinationDirectory,
                              File primarySourceDestinationDirectory, File primaryTestDestinationDirectory,
                              Artifacts artifacts, boolean forceRegenerateUnitTests) {
        super(sourceDestinationDirectory, testDestinationDirectory);
        this.artifacts = artifacts;
        this.forceRegenerateUnitTests = forceRegenerateUnitTests;
        this.modelSourceDestinationDirectory = modelSourceDestinationDirectory;
        this.primarySourceDestinationDirectory = primarySourceDestinationDirectory;
        this.modelTestDestinationDirectory = modelTestDestinationDirectory;
        this.primaryTestDestinationDirectory = primaryTestDestinationDirectory;
    }

    @Override
    public void generate() throws TranslationException {
        if (artifacts == null) {
            return;
        }
        if (forceRegenerateUnitTests) {
            logger.logInfo("Unit tests will be regenerated as requested");
        }
        logger.logInfo("Generating foundations");
        artifacts.process();
        logger.logInfo("Generating Models");
        for (final PackageInfo packageInfo : artifacts.getModelPackagesInfo()) {
            new PackageInfoGenerator(modelSourceDestinationDirectory, packageInfo).generate();
        }
        for (final Model model : artifacts.getProcessedPojoModels()) {
            new ModelGenerator(modelSourceDestinationDirectory, model).generate();
        }
        logger.logInfo("Generating model unit tests");
        for (final ModelTest unittest : artifacts.getPojoUnitTests()) {
            unittest.generateTests();
            new ModelTestGenerator(modelTestDestinationDirectory, unittest, forceRegenerateUnitTests).generate();
        }
        logger.logInfo("Generating Pelion Cloud entities");
        for (final PackageInfo packageInfo : artifacts.getNonModelPackagesInfo()) {
            new PackageInfoGenerator(sourceDestinationDirectory, packageInfo).generate();
        }
        logger.logInfo("Generating adapter classes");
        for (final ModelAdapter adapter : artifacts.getAdapterModels()) {
            new ModelGenerator(sourceDestinationDirectory, adapter).generate();
        }
        logger.logInfo("Generating endpoints classes");
        for (final ModelEndpoints endpoints : artifacts.getProcessedEndpoints()) {
            new ModelGenerator(sourceDestinationDirectory, endpoints).generate();
        }
        logger.logInfo("Generating module classes");
        for (final ModelModule endpoints : artifacts.getProcessedModules()) {
            new ModelGenerator(sourceDestinationDirectory, endpoints).generate();
        }
        logger.logInfo("Generating Pelion other classes");
        for (final Model model : artifacts.getProcessedNonPojoModels()) {
            new ModelGenerator(sourceDestinationDirectory, model).generate();
        }
        for (final Model model : artifacts.getModuleFactory()) {
            new ModelGenerator(primarySourceDestinationDirectory, model).generate();
        }
        logger.logInfo("Generating unit tests");
        for (final ModelTest unittest : artifacts.getNonPojoUnitTests()) {
            unittest.generateTests();
            new ModelTestGenerator(testDestinationDirectory, unittest, forceRegenerateUnitTests).generate();
        }
        for (final ModelTest unittest : artifacts.getModuleFactoryUnitTests()) {
            unittest.generateTests();
            new ModelTestGenerator(primaryTestDestinationDirectory, unittest, forceRegenerateUnitTests).generate();
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.AbstractGenerator#clean()
     */
    @Override
    public void clean() throws CleanException {
        if (artifacts == null) {
            return;
        }
        logger.logInfo("Cleaning models");
        for (final Model model : artifacts.getAllRawModels()) {
            new ModelGenerator(sourceDestinationDirectory, model).clean();
            new ModelGenerator(modelSourceDestinationDirectory, model).clean();
        }
    }

}
