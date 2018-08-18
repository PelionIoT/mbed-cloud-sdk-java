package com.arm.pelion.sdk.foundation.generator.model;

import java.io.File;

import com.arm.pelion.sdk.foundation.generator.AbstractGenerator;
import com.arm.pelion.sdk.foundation.generator.CleanException;
import com.arm.pelion.sdk.foundation.generator.PackageInfo;
import com.arm.pelion.sdk.foundation.generator.PackageInfoGenerator;
import com.arm.pelion.sdk.foundation.generator.TranslationException;

public class ModelsGenerator extends AbstractGenerator {

    private final Models models;
    private final boolean forceRegenerateUnitTests;

    /**
     * @param destinationDirectory
     * @param model
     */
    public ModelsGenerator(File sourceDestinationDirectory, File testDestinationDirectory, Models models,
                           boolean forceRegenerateUnitTests) {
        super(sourceDestinationDirectory, testDestinationDirectory);
        this.models = models;
        this.forceRegenerateUnitTests = forceRegenerateUnitTests;
    }

    @Override
    public void generate() throws TranslationException {
        if (models == null) {
            return;
        }
        logger.logInfo("Generating models");
        models.process();
        for (final PackageInfo packageInfo : models.getPackagesInfo()) {
            new PackageInfoGenerator(sourceDestinationDirectory, packageInfo).generate();
        }
        for (final Model model : models.getProcessedModels()) {
            new ModelGenerator(sourceDestinationDirectory, model).generate();
        }
        logger.logInfo("Generating model unit tests");
        for (final ModelTest unittest : models.getUnitTests()) {
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
        if (models == null) {
            return;
        }
        logger.logInfo("Cleaning models");
        for (final Model model : models.getRawModels()) {
            new ModelGenerator(sourceDestinationDirectory, model).clean();
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
