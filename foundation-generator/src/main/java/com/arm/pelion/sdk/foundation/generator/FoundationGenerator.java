package com.arm.pelion.sdk.foundation.generator;

import java.io.File;

import com.arm.pelion.sdk.foundation.generator.input.FoundationDataLoader;
import com.arm.pelion.sdk.foundation.generator.input.IntermediateApiDefinition;
import com.arm.pelion.sdk.foundation.generator.lowlevelapis.LowLevelAPIFinder;
import com.arm.pelion.sdk.foundation.generator.lowlevelapis.LowLevelAPIs;
import com.arm.pelion.sdk.foundation.generator.model.ArtifactsGenerator;
import com.arm.pelion.sdk.foundation.generator.translator.ArtifactsTranslator;
import com.arm.pelion.sdk.foundation.generator.util.CleanException;
import com.arm.pelion.sdk.foundation.generator.util.FoundationGeneratorException;
import com.arm.pelion.sdk.foundation.generator.util.Logger;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class FoundationGenerator {

    private IntermediateApiDefinition definition;
    private LowLevelAPIs lowLevelAPIs;
    private boolean forceRegenerateUnitTests;
    private final Logger logger;
    private final Configuration config;

    public FoundationGenerator() {
        definition = null;
        lowLevelAPIs = null;
        logger = Logger.getLogger();
        forceRegenerateUnitTests = true;
        config = new Configuration();
    }

    public void load() {
        logger.logInfo("Loading low level APIs definition");
        LowLevelAPIFinder apiFinder = new LowLevelAPIFinder(config.getRootPackageName(),
                                                            config.getLowLevelApiModuleNameRegex());
        lowLevelAPIs = apiFinder.find();
        // logger.logInfo(new JsonSerialiser().toJson(lowLevelAPIs));
        logger.logInfo("Loading definitions");
        FoundationDataLoader loader = new FoundationDataLoader();
        loader.addSource("C:\\Users\\adrcab01\\OneDrive - ARM\\Documents\\temp\\test-generation\\inter.yaml");
        // loader.addSource("C:\\Users\\adrcab01\\OneDrive - ARM\\Documents\\temp\\test-generation\\test2.yml");
        loader.load();
        definition = loader.getInput();
    }

    public void generateModels() throws FoundationGeneratorException {
        File directory = new File("C:\\Users\\adrcab01\\OneDrive - ARM\\Documents\\temp\\test-generation\\results");
        File testDirectory = directory;
        logger.logInfo("Translating generic definitions into Java models");
        ArtifactsGenerator generator = new ArtifactsGenerator(directory, testDirectory,
                                                              ArtifactsTranslator.translate(config, definition,
                                                                                            lowLevelAPIs),
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
