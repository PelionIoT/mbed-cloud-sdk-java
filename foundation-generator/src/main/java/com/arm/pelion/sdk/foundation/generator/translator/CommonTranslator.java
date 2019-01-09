package com.arm.pelion.sdk.foundation.generator.translator;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.arm.pelion.sdk.foundation.generator.Configuration;
import com.arm.pelion.sdk.foundation.generator.input.ForeignKey;
import com.arm.pelion.sdk.foundation.generator.model.Model;
import com.arm.pelion.sdk.foundation.generator.model.ModelEnum;
import com.arm.pelion.sdk.foundation.generator.model.TypeParameter;
import com.arm.pelion.sdk.foundation.generator.util.FoundationGeneratorException;

public class CommonTranslator {

    public static final String PACKAGE_SEPARATOR = ".";
    public static final List<String> PRIMITIVE_TYPES = Arrays.asList("File", "Integer", "Int", "String");

    public static String generateGoup(List<String> groupId) {
        return groupId == null ? null : String.join(PACKAGE_SEPARATOR, groupId);
    }

    public static TypeParameter FetchNestedEntityType(String packageName,
                                                      ForeignKey key) throws FoundationGeneratorException {
        if (key == null) {
            return null;
        }
        return fetchNestedEntityType(packageName, key.getEntityRef());
    }

    public static TypeParameter fetchNestedEntityType(String packageName,
                                                      String entityName) throws FoundationGeneratorException {
        if (entityName == null) {
            return null;
        }
        final Model refModel = new Model(packageName, entityName, fetchGroup(entityName));
        return fetchNestedType(refModel);
    }

    public static String fetchGroup(String ref) throws FoundationGeneratorException {
        if (ref == null) {
            return null;
        }
        if (!PelionModelDefinitionStore.get().hasRelatedGroup(ref)) {
            throw new FoundationGeneratorException("Cannot find any group definition for the following model [" + ref
                                                   + "]",
                                                   new IllegalArgumentException("Available models: "
                                                                                + PelionModelDefinitionStore.get()
                                                                                                            .availableModels()));
        }
        return CommonTranslator.generateGoup(PelionModelDefinitionStore.get().getRelatedGroup(ref));
    }

    public static boolean isPrimitiveType(String returnType) {
        if (returnType == null) {
            return false;
        }
        return PRIMITIVE_TYPES.stream()
                              .anyMatch(t -> t.trim().toLowerCase(Locale.UK)
                                              .equals(returnType == null ? null
                                                                         : returnType.trim().toLowerCase(Locale.UK)));
    }

    public static Model fetchCorrespondingModel(Configuration config,
                                                String entityName) throws FoundationGeneratorException {
        if (entityName == null) {
            return null;
        }
        final Model refModel = new Model(generateModelPackageName(config,
                                                                  PelionModelDefinitionStore.get()
                                                                                            .getRelatedGroup(entityName)),
                                         entityName, fetchGroup(entityName));
        if (PelionModelDefinitionStore.get().has(refModel)) {
            return PelionModelDefinitionStore.get().get(refModel);
        }
        return refModel;
    }

    public static TypeParameter FetchNestedEnumType(String packageName,
                                                    String enumRef) throws FoundationGeneratorException {
        if (enumRef == null) {
            return null;
        }
        final ModelEnum enumerator = new ModelEnum(packageName, enumRef, fetchGroup(enumRef));
        return fetchNestedType(enumerator);
    }

    protected static TypeParameter fetchNestedType(final Model model) {
        if (PelionModelDefinitionStore.get().has(model)) {
            return PelionModelDefinitionStore.get().get(model).toType();
        }
        return model.toType();
    }

    public static String generateModelPackageName(Configuration config, List<String> groupId) {
        return generatePackageName(config.getRootPackageName(), config.getModelPackage(), groupId);
    }

    public static String generatePackageName(String rootPackageName, String modelPackage, List<String> groupId) {
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
        final String packageName = builder.toString()
                                          .replace(CommonTranslator.PACKAGE_SEPARATOR
                                                   + CommonTranslator.PACKAGE_SEPARATOR,
                                                   CommonTranslator.PACKAGE_SEPARATOR)
                                          .toLowerCase(Locale.UK);
        if (packageName.endsWith(CommonTranslator.PACKAGE_SEPARATOR)) {
            return packageName.substring(0, packageName.length() - 1);
        }
        return packageName;
    }
}
