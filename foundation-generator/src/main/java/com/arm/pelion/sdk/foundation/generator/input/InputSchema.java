package com.arm.pelion.sdk.foundation.generator.input;

public interface InputSchema {

    // Java use case
    final String CUSTOM_CODE_TAG = "custom_code";
    final String CUSTOM_SETTER_CODE_TAG = "setter_custom_method";
    final String CUSTOM_GETTER_CODE_TAG = "getter_custom_method";
    final String INTERNAL_TAG = "internal";

    final String PRIMARY_KEY_TAG = "primary_key_field";
    final String READ_ONLY_TAG = "readOnly";
    final String API_FIELDNAME_TAG = "api_fieldname";
    final String ENTITY_FIELDNAME_TAG = "entity_fieldname";
    final String PARAMETER_FIELDNAME_TAG = "parameter_fieldname";
    final String KEY_TAG = "_key";
    final String GROUP_ID_TAG = "group_id";
    // FIXME remove
    final String GROUP_ID_REFERENCE_TAG = "group";
    final String METHODS_TAG = "methods";
    final String TYPE_TAG = "type";
    final String FORMAT_TAG = "format";
    final String EXAMPLE_TAG = "example";
    final String ENTITIES_TAG = "entities";
    final String GROUPS_TAG = "groups";
    final String DEFAULT_VALUE_TAG = "default";
    final String DESCRIPTION_TAG = "description";
    final String SUMMARY_TAG = "summary";
    final String LONG_DESCRIPTION_TAG = "long_description";
    final String FIELDS_TAG = "fields";
    final String RENAMES_TAG = "field_renames";
    final String REQUIRED_TAG = "required";
    final String ITEMS_TAG = "items";
    final String PATTERN_TAG = "pattern";
    final String HASHTABLE_TAG = "additionalProperties";
    final String ENUMS_TAG = "enums";
    final String ENUM_REFERENCE_TAG = "enum_reference";
    final String ENUM_VALUES_TAG = "values";
    final String ENTITY_REFERENCE_TAG = "entity_name";
    // FIXME remove
    final String FOREIGN_ENTITY_REFERENCE_TAG = "entity";
    final String ENUM_NAME_TAG = "enum_name";
    final String FIELD_REFERENCE_TAG = "field_name";
    final String FOREIGN_KEY_TAG = "foreign_key";
    final String DROP_FIELDS_TAG = "drop_fields";
    final String PARAMETER_LOCATION_TAG = "in";
    final String METHOD_ID_TAG = "operation_id";
    final String PAGINATED_RESPONSE_TAG = "pagination";
    final String METHOD_PARAMETER_MAP_TAG = "parameter_map";
    final String METHOD_PARAMETER_IS_EXTERNAL = "external_param";
    final String METHOD_RETURN_INFORMATION_TAG = "return_info";
    final String METHOD_DOES_RETURN_ITSELF_TAG = "self";
    final String METHOD_DOES_RETURN_CUSTOM_TAG = "custom";

    // Method types
    final String CUSTOM_METHOD_TAG = "custom_method";
    final String LIST_METHOD_TAG = "list";
    final String CREATE_METHOD_TAG = "create";
    final String READ_METHOD_TAG = "read";
    final String UPDATE_METHOD_TAG = "update";
    final String DELETE_METHOD_TAG = "delete";
    final String ME_METHOD_TAG = "me";

}
