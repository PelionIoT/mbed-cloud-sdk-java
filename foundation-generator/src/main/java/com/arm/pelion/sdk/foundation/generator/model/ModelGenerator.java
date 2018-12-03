package com.arm.pelion.sdk.foundation.generator.model;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.Locale;

import com.arm.pelion.sdk.foundation.generator.AbstractGenerator;
import com.arm.pelion.sdk.foundation.generator.CleanException;
import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

public class ModelGenerator extends AbstractGenerator {

    private static final String AUTOGENERATION_COMMENT = "This file was generated by the Pelion SDK foundation code generator.";
    private final Model model;

    /**
     * @param destinationDirectory
     * @param model
     */
    public ModelGenerator(File destinationDirectory, Model model) {
        super(destinationDirectory, null);
        this.model = model;
    }

    @Override
    public void generate() throws TranslationException {
        if (model == null) {
            return;
        }
        logger.logInfo("Generating " + model.getClass().getSimpleName().toLowerCase(Locale.UK) + " ["
                       + model.getFullName() + "]");
        model.translate();
        TypeSpec modelClass = model.getSpecificationBuilder().build();
        JavaFile file = JavaFile.builder(model.getPackageName(), modelClass).addFileComment(generateFileComment(model))
                                .build();
        try {
            File destinationFile = new File(sourceDestinationDirectory, file.toJavaFileObject().getName());
            if (sourceDestinationDirectory == null) {
                logger.logWarn("The destination directory for the generated code was not specified. It will hence only be output in Standard out.");
                file.writeTo(System.out);
            } else {
                logger.logInfo("Generating model file [" + destinationFile.getName() + "]");
                if (model.containsCustomCode() && destinationFile.exists()) {
                    logger.logInfo("The model file is already present and contains some custom code. Therefore, it won't be regenerated.");
                    return;
                }

                file.writeTo(sourceDestinationDirectory);
                logger.logInfo("Model [" + model.getFullName() + "] was generated and can be find there: "
                               + destinationFile.toString());
            }
        } catch (Exception exception) {
            throw new TranslationException(exception);
        }

    }

    private static String generateFileComment(Model model) {
        StringBuilder builder = new StringBuilder();
        builder.append(AUTOGENERATION_COMMENT);
        if (model != null) {
            if (model.isAbstract()) {
                builder.append(System.lineSeparator());
                builder.append("This is an autogenerated abstract class. Do not modify its contents.");
                builder.append(System.lineSeparator());
                builder.append("Code customisation should happen in the child class [" + model.getChildClassName()
                               + "]");
            } else {
                builder.append(System.lineSeparator());
                if (model.containsCustomCode()) {
                    builder.append("This model class was autogenerated on " + new Date()
                                   + ". Feel free to change its contents as you wish.");
                    final String fieldsToDefine = model.getListOfFieldsToDefineManually();
                    if (fieldsToDefine != null && !fieldsToDefine.isEmpty()) {
                        builder.append(System.lineSeparator()).append("TODO The following fields need to be defined:"
                                                                      + System.lineSeparator() + fieldsToDefine.trim());
                    }
                } else {
                    builder.append("This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.");
                }
            }
        }
        return builder.toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.AbstractGenerator#clean()
     */
    @Override
    public void clean() throws CleanException {
        if (model == null) {
            return;
        }
        JavaFile file = JavaFile.builder(model.getPackageName(), TypeSpec.classBuilder("MeaninglessClass").build())
                                .build();

        File classFolder = new File(sourceDestinationDirectory, file.toJavaFileObject().getName()).getParentFile();
        File[] filesToClean = classFolder.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                // TODO can be extended
                final String lowerCase = name == null ? "" : name.toLowerCase().trim();
                // Will remove any created abstract class
                return lowerCase.startsWith("abstract") && lowerCase.endsWith(".java");
            }
        });
        if (filesToClean == null || filesToClean.length == 0) {
            return;
        }
        for (final File fileToDelete : filesToClean) {
            try {
                logger.logInfo("Removing model file [" + fileToDelete.getName() + "]");
                Files.delete(fileToDelete.toPath());
            } catch (IOException exception) {
                throw new CleanException(exception);
            }
        }
    }

}
