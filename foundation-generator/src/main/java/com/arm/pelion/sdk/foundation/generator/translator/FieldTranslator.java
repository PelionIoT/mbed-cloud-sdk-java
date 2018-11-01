package com.arm.pelion.sdk.foundation.generator.translator;

import com.arm.pelion.sdk.foundation.generator.input.AdditionalProperty;
import com.arm.pelion.sdk.foundation.generator.input.Item;
import com.arm.pelion.sdk.foundation.generator.model.Field;
import com.arm.pelion.sdk.foundation.generator.model.HashtableType;
import com.arm.pelion.sdk.foundation.generator.model.ListType;
import com.arm.pelion.sdk.foundation.generator.model.ParameterType;
import com.arm.pelion.sdk.foundation.generator.util.FoundationGeneratorException;

public class FieldTranslator {
    private static final String ARRAY_TOKEN = "array";
    private static final String OBJECT_TOKEN = "object";
    private static final String HASHTABLE_TOKEN = "hashtable";

    public FieldTranslator() {
        // TODO Auto-generated constructor stub
    }

    public static Field translate(com.arm.pelion.sdk.foundation.generator.input.Field field, String packageName,
                                  String group) throws FoundationGeneratorException {
        if (field == null) {
            return null;
        }
        final Field modelField = new Field(field.isReadOnly(), determineType(field, packageName, group), field.getKey(),
                                           field.getDescription(), field.getLongDescription(),
                                           determinePattern(field.getPattern()), false, field.isCustomCode(),
                                           field.isInternal(), field.isRequired(), field.getDefaultValue());
        // TODO do something if needed
        return modelField;
    }

    private static String determinePattern(String pattern) {
        // FIXME hack because JavaPoet does not handle well "$"
        return pattern == null ? null : pattern.replace("$", "$$");
    }

    private static ParameterType determineType(com.arm.pelion.sdk.foundation.generator.input.Field field,
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
        return determineObjectType(field, packageName);
    }

    private static ParameterType determineHashtableType(com.arm.pelion.sdk.foundation.generator.input.Field field,
                                                        String packageName) throws FoundationGeneratorException {
        final AdditionalProperty mapDef = field.getAdditionalProperties();
        if (mapDef == null) {
            throw new FoundationGeneratorException("The additional properties section of field [" + field
                                                   + "] is missing");
        }
        return mapDef.hasForeignKey() ? new HashtableType(CommonTranslator.FetchNestedEntityType(packageName,
                                                                                                 mapDef.getForeignKey()),
                                                          false)
                                      : new HashtableType((String) mapDef.getType(), (String) mapDef.getFormat());
    }

    private static ParameterType determineObjectType(com.arm.pelion.sdk.foundation.generator.input.Field field,
                                                     String packageName) {
        return field.hasForeignKey() ? CommonTranslator.FetchNestedEntityType(packageName, field.getForeignKey())
                                     : new ParameterType(field.getType(), field.getFormat());
    }

    private static ParameterType determineArrayType(com.arm.pelion.sdk.foundation.generator.input.Field field,
                                                    String packageName,
                                                    String group) throws FoundationGeneratorException {
        final Item itemTypes = field.getItems();
        if (itemTypes == null) {
            throw new FoundationGeneratorException("The item section of field [" + field + "] is missing");
        }
        return itemTypes.hasForeignKey() ? new ListType(CommonTranslator.FetchNestedEntityType(packageName,
                                                                                               itemTypes.getForeignKey()))
                                         : new ListType((String) itemTypes.getType(), (String) itemTypes.getFormat());
    }

}
