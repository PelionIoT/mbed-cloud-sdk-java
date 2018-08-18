package com.arm.pelion.sdk.foundation.generator.translator;

import java.util.List;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.Configuration;
import com.arm.pelion.sdk.foundation.generator.input.Entity;
import com.arm.pelion.sdk.foundation.generator.input.Field;
import com.arm.pelion.sdk.foundation.generator.input.IntermediateApiDefinition;
import com.arm.pelion.sdk.foundation.generator.model.Model;
import com.arm.pelion.sdk.foundation.generator.model.Models;
import com.arm.pelion.sdk.foundation.generator.util.FoundationGeneratorException;

public class ModelTranslator {

    private static final String PACKAGE_SEPARATOR = ".";

    private ModelTranslator() {
        // TODO Auto-generated constructor stub
    }

    public static Model translate(Configuration config, Entity entity) throws FoundationGeneratorException {
        if (entity == null) {
            return null;
        }
        Model model = new Model(generatePackageName(config.getRootPackageName(), config.getModelPackage(),
                                                    entity.getGroupId()),
                                generateEntityName(entity.getKey()), generateGoup(entity.getGroupId()),
                                entity.getDescription(), entity.getLongDescription(), entity.isCustomCode(),
                                entity.isInternal());
        if (entity.hasFields()) {
            for (final Field field : entity.getFields()) {
                model.addField(FieldTranslator.translate(field, model.getPackageName(), model.getGroup()));
            }
        }

        model.generateMethods();
        return model;
    }

    private static String generateEntityName(String key) {
        return ApiUtils.convertSnakeToCamel(key, true);
    }

    private static String generatePackageName(String rootPackageName, String modelPackage, List<String> groupId) {
        StringBuilder builder = new StringBuilder();
        if (rootPackageName != null) {
            builder.append(rootPackageName);
            if (!rootPackageName.endsWith(PACKAGE_SEPARATOR)) {
                builder.append(PACKAGE_SEPARATOR);
            }
        }
        final String specificPackage = generateGoup(groupId);
        if (specificPackage != null) {
            builder.append(specificPackage);
        }
        if (modelPackage != null) {
            if (!modelPackage.startsWith(PACKAGE_SEPARATOR)) {
                if (specificPackage != null && !specificPackage.endsWith(PACKAGE_SEPARATOR)) {
                    builder.append(PACKAGE_SEPARATOR);
                }
            }
            builder.append(modelPackage);
        }
        return builder.toString().replace(PACKAGE_SEPARATOR + PACKAGE_SEPARATOR, PACKAGE_SEPARATOR);
    }

    private static String generateGoup(List<String> groupId) {
        return groupId == null ? null : String.join(PACKAGE_SEPARATOR, groupId);
    }

    public static Models translate(Configuration config,
                                   IntermediateApiDefinition definition) throws FoundationGeneratorException {
        if (definition == null) {
            return null;
        }
        final Models models = new Models();
        if (definition.hasEntities()) {
            for (final Entity entity : definition.getEntities()) {
                models.addModel(ModelDefinitionStore.get().store(translate(config, entity)));
            }
        }
        return models;
    }

}
