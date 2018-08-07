package com.arm.pelion.sdk.foundation.generator.model;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import com.arm.pelion.sdk.foundation.generator.AbstractGenerator;
import com.arm.pelion.sdk.foundation.generator.CleanException;
import com.arm.pelion.sdk.foundation.generator.PackageInfo;
import com.arm.pelion.sdk.foundation.generator.PackageInfoGenerator;
import com.arm.pelion.sdk.foundation.generator.TranslationException;

public class ModelsGenerator extends AbstractGenerator {

    private final Models models;

    /**
     * @param destinationDirectory
     * @param model
     */
    public ModelsGenerator(File destinationDirectory, Models models) {
        super(destinationDirectory);
        this.models = models;
    }

    @Override
    public void generate() throws TranslationException {
        if (models == null) {
            return;
        }
        logger.logInfo("Generating models");
        models.process();
        for (final PackageInfo packageInfo : models.getPackagesInfo()) {
            new PackageInfoGenerator(destinationDirectory, packageInfo).generate();
        }
        for (final Model model : models.getProcessedModels()) {
            new ModelGenerator(destinationDirectory, model).generate();
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
            new ModelGenerator(destinationDirectory, model).clean();
        }
    }

    public static void main(String[] args) {
        List<Model> models = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            Model model = new Model("package.test.models", "test" + String.valueOf((int) (Math.random() * 100)), "tag",
                                    "some description", "some more description", Math.random() >= 0.5,
                                    Math.random() >= 0.5);
            model.field(new Field(true, new ParameterType("string", null), "id", "ID", null, null, false, false, false,
                                  false, null));
            for (int j = 0; j < (int) (Math.random() * 100); j++) {
                model.field(new Field(Math.random() >= 0.5, new ParameterType("string", null),
                                      "field" + (int) (Math.random() * 100), "a field of some sort",
                                      "Some more description", null, Math.random() >= 0.5, false, Math.random() >= 0.5,
                                      Math.random() >= 0.5, Math.random() >= 0.5 ? "some default value" : null));

            }
            model.generateSettersAndGetters();
            models.add(model);
        }
        File directory = new File("C:\\Users\\adrcab01\\OneDrive - ARM\\Documents\\temp\\test-generation");
        ModelsGenerator generator = new ModelsGenerator(directory, new Models(models));
        try {
            generator.clean();
            generator.generate();
        } catch (TranslationException | CleanException exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();
        }
    }

}
