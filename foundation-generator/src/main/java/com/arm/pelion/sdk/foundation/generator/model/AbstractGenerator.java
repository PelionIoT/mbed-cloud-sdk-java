package com.arm.pelion.sdk.foundation.generator.model;

import java.io.File;

import com.arm.pelion.sdk.foundation.generator.util.CleanException;
import com.arm.pelion.sdk.foundation.generator.util.Logger;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public abstract class AbstractGenerator {

    protected final File sourceDestinationDirectory;
    protected final File testDestinationDirectory;

    protected final Logger logger;

    /**
     * @param destinationDirectory
     */
    public AbstractGenerator(File sourceDestinationDirectory, File testDestinationDirectory) {
        super();
        this.sourceDestinationDirectory = sourceDestinationDirectory;
        this.testDestinationDirectory = testDestinationDirectory;
        this.logger = Logger.getLogger();
    }

    public abstract void generate() throws TranslationException;

    public abstract void clean() throws CleanException;
}
