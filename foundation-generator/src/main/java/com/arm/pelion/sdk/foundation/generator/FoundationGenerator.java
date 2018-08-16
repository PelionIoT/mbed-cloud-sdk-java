package com.arm.pelion.sdk.foundation.generator;

import java.io.File;

import com.arm.pelion.sdk.foundation.generator.input.FoundationDataLoader;
import com.arm.pelion.sdk.foundation.generator.input.IntermediateApiDefinition;
import com.arm.pelion.sdk.foundation.generator.model.ModelsGenerator;
import com.arm.pelion.sdk.foundation.generator.translator.ModelTranslator;
import com.arm.pelion.sdk.foundation.generator.util.FoundationGeneratorException;
import com.arm.pelion.sdk.foundation.generator.util.Logger;

public class FoundationGenerator {

    private IntermediateApiDefinition definition;
    private boolean forceRegenerateUnitTests;
    private final Logger logger;

    public FoundationGenerator() {
        definition = null;
        logger = Logger.getLogger();
        forceRegenerateUnitTests = true;
    }

    public void load() {
        logger.logInfo("Loading definitions");
        FoundationDataLoader loader = new FoundationDataLoader();
        loader.addSource("C:\\Users\\adrcab01\\OneDrive - ARM\\Documents\\temp\\test-generation\\test3.yml");
        // loader.addSource("C:\\Users\\adrcab01\\OneDrive - ARM\\Documents\\temp\\test-generation\\test2.yml");
        loader.load();
        definition = loader.getInput();
    }

    public void generateModels() throws FoundationGeneratorException {
        File directory = new File("C:\\Users\\adrcab01\\OneDrive - ARM\\Documents\\temp\\test-generation");
        File testDirectory = directory;
        logger.logInfo("Translating generic definitions into Java models");
        ModelsGenerator generator = new ModelsGenerator(directory, testDirectory, ModelTranslator.translate(definition),
                                                        forceRegenerateUnitTests);
        try {
            generator.clean();
            generator.generate();
        } catch (TranslationException | CleanException exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FoundationGenerator generator = new FoundationGenerator();
        generator.load();
        try {
            generator.generateModels();
        } catch (FoundationGeneratorException exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();
        }
    }
}
