package com.arm.pelion.sdk.foundation.generator;

import java.io.File;

import com.arm.pelion.sdk.foundation.generator.util.Logger;

public abstract class AbstractGenerator {

    protected final File destinationDirectory;
    protected final Logger logger;

    /**
     * @param destinationDirectory
     */
    public AbstractGenerator(File destinationDirectory) {
        super();
        this.destinationDirectory = destinationDirectory;
        this.logger = Logger.getLogger();
    }

    public abstract void generate() throws TranslationException;

    public abstract void clean() throws CleanException;
}
