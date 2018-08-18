package com.arm.pelion.sdk.foundation.generator.translator;

import java.util.Map;

import com.arm.pelion.sdk.foundation.generator.model.Field;
import com.arm.pelion.sdk.foundation.generator.model.ListType;
import com.arm.pelion.sdk.foundation.generator.model.Model;
import com.arm.pelion.sdk.foundation.generator.model.ParameterType;
import com.arm.pelion.sdk.foundation.generator.util.FoundationGeneratorException;

public class FieldTranslator {

    private static final String NESTED_ENTITY_TAG = "$ref";

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
        if (field.getType().equals("array")) {
            final Map<String, Object> itemTypes = field.getItems();
            if (itemTypes == null) {
                throw new FoundationGeneratorException("The item section of field [" + field + "] is missing");
            }
            return itemTypes.containsKey(NESTED_ENTITY_TAG) ? new ListType(FetchNestedEntityType((String) itemTypes.get(NESTED_ENTITY_TAG),
                                                                                                 packageName, group))
                                                            : new ListType((String) itemTypes.get("type"),
                                                                           (String) itemTypes.get("format"));
        }
        // TODO
        return field.hasSchema() ? FetchNestedEntityType((String) field.getSchema().get(NESTED_ENTITY_TAG), packageName,
                                                         group)
                                 : new ParameterType(field.getType(), field.getFormat());
    }

    private static ParameterType FetchNestedEntityType(String reference, String packageName, String group) {
        if (reference == null) {
            return null;
        }
        final String actualRef = reference.replace("#/definitions/", "").trim();
        final Model refModel = new Model(packageName, actualRef, group);
        if (ModelDefinitionStore.get().has(refModel)) {
            return ModelDefinitionStore.get().get(refModel).toType();
        }
        return refModel.toType();
    }

}
