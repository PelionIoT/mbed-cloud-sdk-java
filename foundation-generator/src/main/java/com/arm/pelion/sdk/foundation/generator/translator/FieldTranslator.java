package com.arm.pelion.sdk.foundation.generator.translator;

import com.arm.pelion.sdk.foundation.generator.input.AdditionalProperty;
import com.arm.pelion.sdk.foundation.generator.input.Item;
import com.arm.pelion.sdk.foundation.generator.model.Field;
import com.arm.pelion.sdk.foundation.generator.model.Parameter;
import com.arm.pelion.sdk.foundation.generator.model.TypeHashtable;
import com.arm.pelion.sdk.foundation.generator.model.TypeList;
import com.arm.pelion.sdk.foundation.generator.model.TypeParameter;
import com.arm.pelion.sdk.foundation.generator.model.Validation;
import com.arm.pelion.sdk.foundation.generator.util.FoundationGeneratorException;
import com.arm.pelion.sdk.foundation.generator.util.Logger;

public class FieldTranslator {
    private static final String ARRAY_TOKEN = "array";
    private static final String OBJECT_TOKEN = "object";
    private static final String HASHTABLE_TOKEN = "hashtable";

    public FieldTranslator() {
        // TODO Auto-generated constructor stub
    }

    public static Validation translateValidation(com.arm.pelion.sdk.foundation.generator.input.Field field) {
        final Validation validation = new Validation();
        validation.setPattern(com.arm.pelion.sdk.foundation.generator.util.Utils.transformRegexIntoValidString(com.arm.pelion.sdk.foundation.generator.util.Utils.applyPatternHack(field.getPattern())));
        if (field.hasMinimum()) {
            validation.setMinimum(String.valueOf(field.getMinimum()));
        }
        if (field.hasMaximum()) {
            validation.setMaximum(String.valueOf(field.getMaximum()));
        }
        return validation;
    }

    public static Field translate(Logger logger, com.arm.pelion.sdk.foundation.generator.input.Field field,
                                  String packageName, String group,
                                  String primaryKey) throws FoundationGeneratorException {
        if (field == null) {
            return null;
        }
        try {
            final Field modelField = new Field(field.isReadOnly(), determineType(field, packageName, group),
                                               field.getKey(), field.getDescription(), field.getLongDescription(),
                                               translateValidation(field), false, field.isCustomCode(),
                                               field.isInternal(), field.isRequired(), field.getDefaultValue(), false);
            if (primaryKey != null && primaryKey.equals(field.getKey())) {
                modelField.setAsIdentifier(true);
            }
            if (field.hasDeprecation()) {
                modelField.setDeprecation(CommonTranslator.translateDeprecationNotice(field.getDeprecationNotice(),
                                                                                      true));
            }
            // TODO do something if needed
            return modelField;
        } catch (FoundationGeneratorException exception) {
            logger.logError("Could not translate field " + field + " " + packageName + " " + group, exception);
            throw exception;
        }
    }

    public static Parameter translateToParameter(com.arm.pelion.sdk.foundation.generator.input.Field field,
                                                 String packageName, String group) throws FoundationGeneratorException {
        if (field == null) {
            return null;
        }
        final Parameter parameter = new Parameter(field.getKey(), field.getDescription(), field.getDescription(),
                                                  determineType(field, packageName, group), field.getDefaultValue(),
                                                  translateValidation(field));
        return field.isRequired() ? parameter.setAsNonNull(true) : parameter.setAsNullable(true);
    }

    private static TypeParameter determineType(com.arm.pelion.sdk.foundation.generator.input.Field field,
                                               String packageName, String group) throws FoundationGeneratorException {
        switch (field.getType()) {
            case ARRAY_TOKEN:
                return determineArrayType(field, packageName, group);
            // FIXME do the following properly
            case HASHTABLE_TOKEN:
            case OBJECT_TOKEN:
                break;
        }

        // FIXME the following should be done above
        if (field.hasAdditionalProperties()) {// FIXME replace by field.getType == hashtable when done
            return determineHashtableType(field, packageName);
        }
        // TODO
        return determineObjectType(field, packageName, group);
    }

    private static TypeParameter determineHashtableType(com.arm.pelion.sdk.foundation.generator.input.Field field,
                                                        String packageName) throws FoundationGeneratorException {
        final AdditionalProperty mapDef = field.getAdditionalProperties();
        if (mapDef == null) {
            throw new FoundationGeneratorException("The additional properties section of field [" + field
                                                   + "] is missing");
        }
        return mapDef.hasForeignKey() ? new TypeHashtable(CommonTranslator.FetchNestedEntityType(packageName,
                                                                                                 mapDef.getForeignKey()),
                                                          false)
                                      : new TypeHashtable(mapDef.getType(), mapDef.getFormat());
    }

    private static TypeParameter determineObjectType(com.arm.pelion.sdk.foundation.generator.input.Field field,
                                                     String packageName,
                                                     String group) throws FoundationGeneratorException {
        return field.hasForeignKey() ? CommonTranslator.FetchNestedEntityType(packageName, field.getForeignKey())
                                     : field.hasEnumRef() ? CommonTranslator.FetchNestedEnumType(packageName,
                                                                                                 field.getEnumRef())
                                                          : new TypeParameter(field.getType(), field.getFormat());
    }

    private static TypeParameter determineArrayType(com.arm.pelion.sdk.foundation.generator.input.Field field,
                                                    String packageName,
                                                    String group) throws FoundationGeneratorException {
        final Item itemTypes = field.getItems();
        if (itemTypes == null) {
            throw new FoundationGeneratorException("The item section of field [" + field + "] is missing");
        }
        return itemTypes.hasForeignKey() ? new TypeList(CommonTranslator.FetchNestedEntityType(packageName,
                                                                                               itemTypes.getForeignKey()))
                                         : new TypeList(itemTypes.getType(), itemTypes.getFormat());
    }

}
