package com.arm.pelion.sdk.foundation.generator.input;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.arm.pelion.sdk.foundation.generator.util.Logger;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class FoundationDataLoader {

    private final Set<File> sources;
    private final IntermediateApiDefinition input;
    protected final Logger logger;

    public FoundationDataLoader() {
        sources = new HashSet<>();
        input = new IntermediateApiDefinition();
        logger = Logger.getLogger();
    }

    public void addSource(String path) {
        if (path == null || path.isEmpty()) {
            return;
        }
        File file = new File(path);
        addSource(file);

    }

    public void addSource(File file) {
        if (file != null && file.exists() && file.isFile() && !sources.contains(file)) {
            sources.add(file);
        }
    }

    public void load() {
        input.clear();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setDefaultMergeable(Boolean.TRUE);
        sources.forEach(f -> {
            try {
                logger.logInfo("Loading definitions from : " + f);
                mapper.readerForUpdating(input).readValue(f);
            } catch (IOException exception) {
                logger.logError("Failed loading " + f.getName(), exception);
            }
        });

    }

    /**
     * @return the input
     */
    public IntermediateApiDefinition getInput() {
        return input;
    }

}
