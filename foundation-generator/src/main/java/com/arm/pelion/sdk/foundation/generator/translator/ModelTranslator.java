package com.arm.pelion.sdk.foundation.generator.translator;

import java.util.List;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.input.Entity;
import com.arm.pelion.sdk.foundation.generator.input.Field;
import com.arm.pelion.sdk.foundation.generator.input.IntermediateApiDefinition;
import com.arm.pelion.sdk.foundation.generator.model.Model;
import com.arm.pelion.sdk.foundation.generator.model.Models;
import com.arm.pelion.sdk.foundation.generator.util.FoundationGeneratorException;

public class ModelTranslator {

    private ModelTranslator() {
        // TODO Auto-generated constructor stub
    }

    public static Model translate(Entity entity) throws FoundationGeneratorException {
        if (entity == null) {
            return null;
        }
        Model model = new Model(generatePackageName(entity.getGroupId()), generateEntityName(entity.getKey()),
                                generateGoup(entity.getGroupId()), entity.getDescription(), entity.getLongDescription(),
                                entity.isCustomCode(), entity.isInternal());
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

    private static String generatePackageName(List<String> groupId) {
        final String specificPackage = generateGoup(groupId);
        return "com.arm.mbed.cloud.sdk." + String.valueOf(specificPackage == null ? "" : specificPackage + ".")
               + "model";
    }

    private static String generateGoup(List<String> groupId) {
        return groupId == null ? null : String.join(".", groupId);
    }

    public static Models translate(IntermediateApiDefinition definition) throws FoundationGeneratorException {
        if (definition == null) {
            return null;
        }
        final Models models = new Models();
        if (definition.hasEntities()) {
            for (final Entity entity : definition.getEntities()) {
                models.addModel(ModelDefinitionStore.get().store(translate(entity)));
            }
        }
        return models;
    }

}
