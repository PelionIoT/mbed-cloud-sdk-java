package com.arm.pelion.sdk.foundation.generator.translator;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.Configuration;
import com.arm.pelion.sdk.foundation.generator.input.AdditionalProperty;
import com.arm.pelion.sdk.foundation.generator.input.Entity;
import com.arm.pelion.sdk.foundation.generator.input.Enumerator;
import com.arm.pelion.sdk.foundation.generator.input.Field;
import com.arm.pelion.sdk.foundation.generator.input.IntermediateApiDefinition;
import com.arm.pelion.sdk.foundation.generator.model.Enum;
import com.arm.pelion.sdk.foundation.generator.model.Model;
import com.arm.pelion.sdk.foundation.generator.model.Models;
import com.arm.pelion.sdk.foundation.generator.model.ParameterType;
import com.arm.pelion.sdk.foundation.generator.util.FoundationGeneratorException;

public class ModelTranslator {

    private ModelTranslator() {
        // Do something
    }

    public static Model translate(Configuration config, Entity entity) throws FoundationGeneratorException {
        if (entity == null) {
            return null;
        }
        final String packageName = generatePackageName(config, entity.getGroupId());
        Model model = new Model(packageName, generateEntityName(entity.getKey()),
                                CommonTranslator.generateGoup(entity.getGroupId()), entity.getDescription(),
                                entity.getLongDescription(), entity.isCustomCode(), entity.isInternal());
        if (entity.hasAdditionalProperties()) {
            final AdditionalProperty properties = entity.getAdditionalProperties();
            model.setSuperClassType(properties.hasForeignKey() ? CommonTranslator.FetchNestedEntityType(packageName,
                                                                                                        properties.getForeignKey())
                                                               : new ParameterType(properties.getType(),
                                                                                   properties.getFormat()));
        }
        if (entity.hasFields()) {
            for (final Field field : entity.getFields()) {
                model.addField(FieldTranslator.translate(field, model.getPackageName(), model.getGroup()));
            }
        }

        model.generateMethods();
        return model;
    }

    private static Model translate(Configuration config, Enumerator enumerator) {
        if (enumerator == null) {
            return null;
        }
        com.arm.pelion.sdk.foundation.generator.model.Enum javaEnum = new Enum(generatePackageName(config,
                                                                                                   enumerator.getGroupId()),
                                                                               null, enumerator.getName(),
                                                                               CommonTranslator.generateGoup(enumerator.getGroupId()),
                                                                               enumerator.getLongDescription(),
                                                                               enumerator.getValues(),
                                                                               determineDefaultOption(enumerator));
        javaEnum.generateMethods();
        return javaEnum;
    }

    private static String determineDefaultOption(Enumerator enumerator) {
        // FIXME default option should be specified in the intermediate configuration file.
        return enumerator.getValues().iterator().next();
    }

    private static String generateEntityName(String key) {
        return ApiUtils.convertSnakeToCamel(key, true);
    }

    private static String generatePackageName(Configuration config, List<String> groupId) {
        return generatePackageName(config.getRootPackageName(), config.getModelPackage(), groupId);
    }

    private static String generatePackageName(String rootPackageName, String modelPackage, List<String> groupId) {
        StringBuilder builder = new StringBuilder();
        if (rootPackageName != null) {
            builder.append(rootPackageName);
            if (!rootPackageName.endsWith(CommonTranslator.PACKAGE_SEPARATOR)) {
                builder.append(CommonTranslator.PACKAGE_SEPARATOR);
            }
        }
        final String specificPackage = CommonTranslator.generateGoup(groupId);
        if (specificPackage != null) {
            builder.append(specificPackage);
        }
        if (modelPackage != null) {
            if (!modelPackage.startsWith(CommonTranslator.PACKAGE_SEPARATOR)) {
                if (specificPackage != null && !specificPackage.endsWith(CommonTranslator.PACKAGE_SEPARATOR)) {
                    builder.append(CommonTranslator.PACKAGE_SEPARATOR);
                }
            }
            builder.append(modelPackage);
        }
        return builder.toString().replace(CommonTranslator.PACKAGE_SEPARATOR + CommonTranslator.PACKAGE_SEPARATOR,
                                          CommonTranslator.PACKAGE_SEPARATOR)
                      .toLowerCase(Locale.UK);
    }

    public static Models translate(Configuration config,
                                   IntermediateApiDefinition definition) throws FoundationGeneratorException {
        if (definition == null) {
            return null;
        }
        final Models models = new Models();
        if (definition.hasEntities()) {
            // Note: not using streams so that exceptions are raised
            for (final Entity entity : definition.getEntities()) {
                models.addModel(ModelDefinitionStore.get().store(translate(config, entity)));
            }
        }
        if (definition.hasEnums()) {
            List<Enumerator> enums = definition.getEnums().stream()
                                               .filter(e -> e.hasValues() && !e.getName().contains("order_enum"))
                                               .collect(Collectors.toList());
            for (final Enumerator enumerator : enums) {
                models.addModel(ModelDefinitionStore.get().store(translate(config, enumerator)));
            }
        }
        return models;
    }
}
