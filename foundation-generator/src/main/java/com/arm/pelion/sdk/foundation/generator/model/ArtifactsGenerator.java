package com.arm.pelion.sdk.foundation.generator.model;

import java.io.File;

import com.arm.pelion.sdk.foundation.generator.util.CleanException;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class ArtifactsGenerator extends AbstractGenerator {

    private final Artifacts artifacts;
    private final boolean forceRegenerateUnitTests;
    protected final File modelSourceDestinationDirectory;
    protected final File modelTestDestinationDirectory;

    /**
     * @param destinationDirectory
     * @param model
     */
    public ArtifactsGenerator(File sourceDestinationDirectory, File testDestinationDirectory,
                              File modelSourceDestinationDirectory, File modelTestDestinationDirectory,
                              Artifacts artifacts, boolean forceRegenerateUnitTests) {
        super(sourceDestinationDirectory, testDestinationDirectory);
        this.artifacts = artifacts;
        this.forceRegenerateUnitTests = forceRegenerateUnitTests;
        this.modelSourceDestinationDirectory = modelSourceDestinationDirectory;
        this.modelTestDestinationDirectory = modelTestDestinationDirectory;

    }

    @Override
    public void generate() throws TranslationException {
        if (artifacts == null) {
            return;
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
        logger.logInfo("Generating unit tests");
        for (final ModelTest unittest : artifacts.getNonPojoUnitTests()) {
            unittest.generateTests();
            new ModelTestGenerator(testDestinationDirectory, unittest, forceRegenerateUnitTests).generate();
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

    // public static void main(String[] args) {
    // List<Model> models = new LinkedList<>();
    // // for (int i = 0; i < 9; i++) {
    // // Model model = new Model("package.test.models", "test" + String.valueOf((int) (Math.random() * 100)), "tag",
    // // "some description", "some more description", Math.random() >= 0.5,
    // // Math.random() >= 0.5);
    // // model.field(new Field(true, new ParameterType("string", null), "id", "ID", null, null, false, false, false,
    // // false, null));
    // // for (int j = 0; j < (int) (Math.random() * 100); j++) {
    // // model.field(new Field(Math.random() >= 0.5, new ParameterType("string", null),
    // // "field" + (int) (Math.random() * 100), "a field of some sort",
    // // "Some more description",
    // // Math.random() >= 0.9 ? "/^Some regex of some sort" : null, Math.random() >= 0.5,
    // // Math.random() >= 0.9, Math.random() >= 0.5, Math.random() >= 0.5,
    // // Math.random() >= 0.5 ? "some default value" : null));
    // //
    // // }
    // // model.generateMethods();
    // // models.add(model);
    // // }
    // Enum enumerator = new Enum("package.test.models", "AnEntity", "state", "tmp", "Enumerator",
    // Arrays.asList("unenrolled", "cloud_enrolling", "bootstrapped", "registered",
    // "deregistered"),
    // "deregistered");
    // enumerator.generateMethods();
    // models.add(enumerator);
    // File directory = new File("C:\\Users\\adrcab01\\OneDrive - ARM\\Documents\\temp\\test-generation");
    // ModelsGenerator generator = new ModelsGenerator(directory, new Models(models));
    // try {
    // generator.clean();
    // generator.generate();
    // } catch (TranslationException | CleanException exception) {
    // // TODO Auto-generated catch block
    // exception.printStackTrace();
    // }
    // }
}
