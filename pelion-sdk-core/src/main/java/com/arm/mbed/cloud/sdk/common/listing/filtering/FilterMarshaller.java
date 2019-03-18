package com.arm.mbed.cloud.sdk.common.listing.filtering;

import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.JsonSerialiser;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.common.SdkUtils;
import com.arm.mbed.cloud.sdk.common.SdkUtils.CaseConversion;
import com.arm.mbed.cloud.sdk.common.SdkUtils.CaseConverter;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;

@Preamble(description = "Filters marshaller for serialisation/deserialisation")
public class FilterMarshaller {
    private static final String CUSTOM_ATTRIBUTES_FIELD_NAME = "custom_attributes";
    private static final CaseConverter SNAKE_TO_CAMEL_CONVERTER = SdkUtils.getCaseConverter(CaseConversion.SNAKE_TO_CAMEL);
    private static final String CUSTOM_ATTRIBUTES_FIELD_NAME_CAMEL_CASE = SNAKE_TO_CAMEL_CONVERTER.convert(CUSTOM_ATTRIBUTES_FIELD_NAME,
                                                                                                           false);

    private static final String FILTER_KEY_VALUE_SEPARATOR = "=";

    private static final String FILTER_SEPARATOR = "&";

    public static final String SUFFIX_SEPARATOR = "__";

    private final Map<String, String> fieldNameMapping;
    private final Map<String, String> fieldNameReverseMapping;

    /**
     * Constructor.
     *
     * @param fieldNameMapping
     *            filter field mapping.
     */
    public FilterMarshaller(Map<String, String> fieldNameMapping) {
        super();
        this.fieldNameMapping = fieldNameMapping;
        fieldNameReverseMapping = createReverseMapping(fieldNameMapping);
    }

    /**
     * Encodes all filters.
     *
     * @param filters
     *            filters to encode
     * @return URL String containing all filter definitions
     */
    public @Nullable String encode(@Nullable Filters filters) {
        return (filters == null) ? null : encodeList(filters.get());
    }

    /**
     * Encodes all filters related to one field name.
     *
     * @param fieldName
     *            field name of interest
     * @param filters
     *            filters to encode
     * @return URL String containing all filter definitions
     */
    public @Nullable String encode(@Nullable String fieldName, @Nullable Filters filters) {
        if (filters == null) {
            return null;
        }
        return (fieldName == null) ? encode(filters) : encodeList(filters.get(fieldName));
    }

    /**
     * Decodes a URL String containing filter definitions.
     *
     * @param filtersString
     *            URL string containing filter definitions
     * @return corresponding filters
     */
    public @Nullable Filters decode(@Nullable String filtersString) {
        if (filtersString == null || filtersString.isEmpty()) {
            return null;
        }
        String[] filterStrings = filtersString.split(FILTER_SEPARATOR);
        Filters filters = null;
        for (String filterString : filterStrings) {
            Filter filter = decodeFilter(filterString);
            if (filter != null && filter.isValid()) {
                if (filters == null) {
                    filters = new Filters();
                }
                filters.add(filter);
            }
        }
        return filters;
    }

    /**
     * Serialises filters to Json string.
     *
     * @param filters
     *            Filters to serialise
     * @return Json string
     */
    public static @Nullable String toJson(@Nullable Filters filters) {
        if (filters == null || filters.isEmpty()) {
            return null;
        }
        JsonObject obj = new JsonObject();
        for (Filter filter : filters.get()) {
            obj.putFilter(filter);
        }
        return obj.encode();
    }

    /**
     * Deserialises filters from a Json string.
     * <p>
     * Such string must be of the following form:
     * <p>
     * {@code { fieldname:{ operator: value}}}
     * <p>
     * { 'device_id': {'$eq': str(uuid.uuid4())},
     *
     * 'auto_update': {'$eq': True},
     *
     * 'state': {'$eq': 'bootstrapped'},
     *
     * 'device_class': {'$eq': 'embedded'},
     *
     * 'serial_number': {'$eq': '1234'},
     *
     * 'vendor_id': {'$eq': 'Arm'},
     *
     * 'description': {'$eq': 'Loreum ipsum'},
     *
     * 'device_name': {'$eq': 'DeviceName'},
     *
     * 'custom_attributes': {
     *
     * 'customA': {'$eq': 'SomethingA'},
     *
     * 'customB': {'$eq': 'Something B'} }
     * <p>
     * dates/times must be expressed as strings following RFC3339. @see
     * <a href="https://tools.ietf.org/html/rfc3339#page-7">(RFC)</a>.
     *
     * @param json
     *            Json string defining filters
     * @return corresponding filters
     */
    public static @Nullable Filters fromJson(@Nullable String json) {
        if (json == null || json.isEmpty()) {
            return null;
        }
        JsonObject obj = new JsonObject(json);
        return convertJsonObjectToFilters(obj);
    }

    /**
     * Gets filters as a "Json Map".
     *
     * @param filters
     *            filters
     * @return Json Map defining filters
     */
    @Internal
    public static Map<String, Object> toJsonObject(Filters filters) {
        if (filters == null || filters.isEmpty()) {
            return null;
        }
        JsonObject obj = new JsonObject();
        for (Filter filter : filters.get()) {
            obj.putFilter(filter);
        }
        return obj.map;
    }

    /**
     * Gets filters from a "Json Map".
     * <p>
     *
     * @param filtersJson
     *            Json Map defining filters
     * @return corresponding filters
     */
    @Internal
    public static @Nullable Filters fromJsonObject(Map<String, Object> filtersJson) {
        if (filtersJson == null || filtersJson.isEmpty()) {
            return null;
        }
        JsonObject obj = new JsonObject();
        obj.setMap(filtersJson);
        return convertJsonObjectToFilters(obj);
    }

    protected String encodeFilter(Filter filter, String fieldName) {
        if (filter == null || !filter.isValid()) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        if (filter.hasPrefix()) {
            builder.append(filter.getPrefix());
        }
        builder.append(SdkUtils.convertCamelToSnake((fieldName == null) ? filter.getFieldName() : fieldName));
        String suffix = filter.getOperator().getSuffix();
        if (suffix != null) {
            builder.append(suffix);
        }
        builder.append(FILTER_KEY_VALUE_SEPARATOR);
        builder.append(formatFilterValue(filter.getValue()));
        return builder.toString();
    }

    protected Filter decodeFilter(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        String[] parts = string.split(FILTER_KEY_VALUE_SEPARATOR);
        if (parts.length != 2) {
            return null;
        }
        String key = parts[0];
        boolean isCustom = false;
        if (key != null && (key.contains(CustomFilter.CUSTOM_ATTRIBUTES_PREFIX)
                            || key.contains(CustomFilter.INCORRECT_BUT_ACCEPTED_CUSTOM_ATTRIBUTES_PREFIX))) {
            key = key.replace(CustomFilter.CUSTOM_ATTRIBUTES_PREFIX, "")
                     .replace(CustomFilter.INCORRECT_BUT_ACCEPTED_CUSTOM_ATTRIBUTES_PREFIX, "");
            isCustom = true;
        }
        FilterOperator operator = FilterOperator.getFromSuffix(fetchSuffix(key));
        Filter filter = (isCustom) ? new CustomFilter(fetchFieldName(key, operator), operator, parts[1])
                                   : new Filter(fetchFieldName(key, operator), operator, parts[1]);
        return (filter.isValid()) ? filter : null;
    }

    private static Filters convertJsonObjectToFilters(JsonObject obj) {
        Filters filters = new Filters();
        for (String fieldName : obj.fieldNames()) {
            if (CUSTOM_ATTRIBUTES_FIELD_NAME.equalsIgnoreCase(fieldName)
                || CUSTOM_ATTRIBUTES_FIELD_NAME_CAMEL_CASE.equals(fieldName)) {
                JsonObject filterJson = obj.getJsonObject(fieldName);
                for (String subfieldName : filterJson.fieldNames()) {
                    parseFilter(filterJson, subfieldName, filters, true);
                }
            } else {
                parseFilter(obj, fieldName, filters, false);
            }
        }
        return filters;
    }

    private String encodeList(List<Filter> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        boolean start = true;
        for (Filter filter : list) {
            if (!filter.isValid()) {
                continue;
            }
            if (!start) {
                builder.append(FILTER_SEPARATOR);
            }
            String newFieldName = (fieldNameMapping == null) ? null : fieldNameMapping.get(filter.getFieldName());
            builder.append(encodeFilter(filter, newFieldName));
            start = false;
        }
        return builder.toString();
    }

    private static Map<String, String> createReverseMapping(Map<String, String> mapping) {
        if (mapping == null) {
            return null;
        }
        Map<String, String> reverseMapping = new HashMap<>();
        for (Entry<String, String> entry : mapping.entrySet()) {
            reverseMapping.put(entry.getValue(), entry.getKey());
        }
        return reverseMapping;
    }

    private static String formatFilterValue(Object value) {
        if (value instanceof Date) {
            // Moving dates/Times to UTC and formatting them according to rfc3339
            return ApiUtils.toUtcTimestamp((Date) value);
        }
        return String.valueOf(value);
    }

    private static String removeSuffix(String string, FilterOperator operator) {
        String suffix = (operator == null) ? null : operator.getSuffix();
        if (suffix != null) {
            string = string.replace(suffix, "");
        }
        return string;
    }

    private static String fetchSuffix(String string) {
        if (string == null) {
            return null;
        }
        if (!string.contains(SUFFIX_SEPARATOR)) {
            return null;
        }
        return string.substring(string.lastIndexOf(SUFFIX_SEPARATOR));
    }

    private String fetchFieldName(String key, FilterOperator operator) {
        String fieldName = removeSuffix(key, operator);
        if (fieldName == null) {
            return null;
        }
        fieldName = fieldName.trim();
        if (fieldNameReverseMapping != null && fieldNameReverseMapping.containsKey(fieldName)) {
            return fieldNameReverseMapping.get(fieldName);
        }
        return SdkUtils.convertSnakeToCamel(fieldName, false);
    }

    protected static void parseFilter(String jsonObj, String fieldName, Filters filters, boolean isCustom) {
        JsonObject obj = new JsonObject(jsonObj);
        parseFilter(obj, fieldName, filters, isCustom);
    }

    protected static void parseFilter(JsonObject obj, String fieldName, Filters filters, boolean isCustom) {
        if (obj.isJsonObject(fieldName)) {
            parseFilterAsJsonObject(obj, fieldName, filters, isCustom);
        }
        if (obj.isString(fieldName)) {
            parseFilterAsString(obj, fieldName, filters);
        }
    }

    private static void parseFilterAsString(JsonObject obj, String fieldName, Filters filters) {
        Object filterValue = obj.getValue(fieldName);
        Filter filter = new Filter(SNAKE_TO_CAMEL_CONVERTER.convert(fieldName, false), FilterOperator.getDefault(),
                                   filterValue);
        filters.add(filter);
    }

    private static void parseFilterAsJsonObject(JsonObject obj, String fieldName, Filters filters, boolean isCustom) {
        JsonObject filterJson = obj.getJsonObject(fieldName);
        if (filterJson == null || filterJson.isEmpty()) {
            return;
        }
        for (String operator : filterJson.fieldNames()) {
            Filter filter = (isCustom) ? new CustomFilter(SNAKE_TO_CAMEL_CONVERTER.convert(fieldName, false),
                                                          FilterOperator.getFromSymbol(operator),
                                                          filterJson.getValue(operator))
                                       : new Filter(SNAKE_TO_CAMEL_CONVERTER.convert(fieldName, false),
                                                    FilterOperator.getFromSymbol(operator),
                                                    filterJson.getValue(operator));
            filters.add(filter);
        }
    }

    /**
     * Encodes a single filter value.
     * 
     * @param filterObj
     *            filter value.
     * @param type
     *            filter value type.
     * @return the encoded filter value.
     */
    @SuppressWarnings({ "unchecked", "PMD.CyclomaticComplexity", "PMD.NPathComplexity", "PMD.ExcessiveMethodLength" })
    public static <T> T encodeSingleFilter(final Object filterObj, Class<T> type) {
        if (filterObj == null || type == null) {
            return null;
        }
        if (String.class.isAssignableFrom(type)) {
            if (filterObj instanceof String) {
                return (T) filterObj;
            }
            if (filterObj instanceof Boolean) {
                return (T) ((Boolean) filterObj).toString();
            }
            if (filterObj instanceof SdkEnum) {
                return (T) ((SdkEnum) filterObj).getString();
            }
            if (filterObj instanceof SdkModel) {
                return (T) ((SdkModel) filterObj).getId();
            }
            if (filterObj instanceof Date) {
                return (T) TranslationUtils.toUtcTimestamp((Date) filterObj);
            }
            if (filterObj instanceof Calendar) {
                return (T) TranslationUtils.toUtcTimestamp(TranslationUtils.toDate((Calendar) filterObj));
            }
            if (filterObj instanceof URL) {
                return (T) ((URL) filterObj).toString();
            }
            return (T) filterObj.toString();
        }
        if (DateTime.class.isAssignableFrom(type)) {
            if (filterObj instanceof DateTime) {
                return (T) filterObj;
            }
            if (filterObj instanceof LocalDate) {
                return (T) TranslationUtils.toDateTime(TranslationUtils.toDate((LocalDate) filterObj));
            }
            if (filterObj instanceof String) {
                try {
                    return (T) TranslationUtils.toDateTime(TranslationUtils.convertStringToDate((String) filterObj));
                } catch (@SuppressWarnings("unused") MbedCloudException exception) {
                    // Nothing to do.
                    return null;
                }
            }
            if (filterObj instanceof Date) {
                return (T) TranslationUtils.toDateTime((Date) filterObj);
            }
            if (filterObj instanceof Number) {
                return (T) TranslationUtils.toDateTime(TranslationUtils.toDate((Number) filterObj));
            }
            return null;
        }
        if (LocalDate.class.isAssignableFrom(type)) {
            if (filterObj instanceof LocalDate) {
                return (T) filterObj;
            }
            if (filterObj instanceof DateTime) {
                return (T) TranslationUtils.toLocalDate(TranslationUtils.toDate((DateTime) filterObj));
            }
            if (filterObj instanceof String) {
                try {
                    return (T) TranslationUtils.toLocalDate(TranslationUtils.convertStringToDate((String) filterObj));
                } catch (@SuppressWarnings("unused") MbedCloudException exception) {
                    // Nothing to do.
                    return null;
                }
            }
            if (filterObj instanceof Date) {
                return (T) TranslationUtils.toLocalDate((Date) filterObj);
            }
            if (filterObj instanceof Number) {
                return (T) TranslationUtils.toLocalDate(TranslationUtils.toDate((Number) filterObj));
            }
            return null;
        }
        if (Boolean.class.isAssignableFrom(type) || boolean.class.isAssignableFrom(type)) {
            if (filterObj instanceof String) {
                return (T) Boolean.valueOf(TranslationUtils.toBool((String) filterObj));
            }
            if (filterObj instanceof Boolean) {
                return (T) filterObj;
            }
            return null;
        }
        if (Integer.class.isAssignableFrom(type) || int.class.isAssignableFrom(type)) {
            if (filterObj instanceof String) {
                return (T) Integer.valueOf(TranslationUtils.toInt((String) filterObj));
            }
            if (filterObj instanceof Number) {
                return (T) Integer.valueOf(TranslationUtils.toInt((Number) filterObj));
            }
            return null;
        }
        if (Long.class.isAssignableFrom(type) || long.class.isAssignableFrom(type)) {
            if (filterObj instanceof String) {
                return (T) Long.valueOf(TranslationUtils.toLong((String) filterObj));
            }
            if (filterObj instanceof Number) {
                return (T) Long.valueOf(TranslationUtils.toLong((Number) filterObj));
            }
            if (filterObj instanceof Date) {
                return (T) Long.valueOf(TranslationUtils.toLong((Date) filterObj));
            }
            return null;
        }
        if (Double.class.isAssignableFrom(type) || double.class.isAssignableFrom(type)) {
            if (filterObj instanceof String) {
                return (T) Double.valueOf(TranslationUtils.toDouble((String) filterObj));
            }
            if (filterObj instanceof Number) {
                return (T) Double.valueOf(TranslationUtils.toDouble((Number) filterObj));
            }
        }

        return null;
    }

    /**
     * Encodes multiple filter values.
     * 
     * @param filterObj
     *            filter values.
     * @param type
     *            filter value type.
     * @return the encoded filter values.
     */
    @SuppressWarnings("rawtypes")
    public static <T> T encodeMultipleFilters(final Object filterObj, Class<T> type) {
        if (filterObj == null) {
            return null;
        }
        if (filterObj instanceof List) {
            return encodeList((List) filterObj, type);
        }
        if (filterObj.getClass().isArray()) {
            return encodeArray(filterObj, type);
        }
        return encodeSingleFilter(filterObj, type);
    }

    private static <T> T encodeArray(Object filterObj, Class<T> type) {
        if (filterObj instanceof String[]) {
            return encodeList(Arrays.asList((String[]) filterObj), type);
        }
        if (filterObj instanceof Object[]) {
            return encodeList(Arrays.asList(((Object[]) filterObj)), type);
        }
        return null;
    }

    @SuppressWarnings({ "unchecked", "PMD.ClassCastExceptionWithToArray" })
    private static <T> T encodeList(List<?> filterObj, Class<T> type) {
        if (String.class.isAssignableFrom(type)) {
            return (T) SdkUtils.joinList(filterObj, ",");
        }
        if (List.class.isAssignableFrom(type)) {
            if (filterObj.getClass().isArray()) {
                return (T) Arrays.asList(filterObj);
            }
            return (T) filterObj;
        }
        if (type.isArray()) {
            return (T) filterObj.toArray();
        }
        return null;
    }

    private static class JsonObject {

        private final JsonSerialiser jsonSerialiser = new JsonSerialiser();
        private Map<String, Object> map;

        public JsonObject(Map<String, Object> map) {
            setMap(map);
        }

        public JsonObject() {
            setMap(null);
        }

        @SuppressWarnings("unchecked")
        public JsonObject(String string) {
            super();
            if (string == null || string.isEmpty()) {
                setMap(null);
            } else {
                setMap(jsonSerialiser.fromJson(string, Map.class));
            }

        }

        public Map<String, Object> getMap() {
            return map;
        }

        public void setMap(Map<String, Object> map) {
            this.map = map;
        }

        public Object getValue(String fieldName) {
            if (fieldName == null || fieldName.isEmpty()) {
                return null;
            }
            final Object value = map.get(fieldName);
            if (value instanceof CharSequence) {
                final String valueStr = value.toString();
                if (valueStr == null || valueStr.isEmpty()) {
                    return valueStr;
                }
                // If only numeric values
                if (valueStr.matches("-?[0-9.]+")) {
                    return valueStr;
                }
                try {
                    // Trying to see if it is a date
                    return ApiUtils.convertStringToDate(valueStr);
                } catch (@SuppressWarnings("unused") Exception exception) {
                    return valueStr;
                }
            }
            return value;
        }

        public boolean isJsonObject(String fieldName) {
            if (fieldName == null || fieldName.isEmpty() || isEmpty()) {
                return false;
            }
            Object val = map.get(fieldName);
            if (val == null) {
                return false;
            }
            return (val instanceof Map || val instanceof JsonObject);
        }

        public boolean isString(String fieldName) {
            if (fieldName == null || fieldName.isEmpty() || isEmpty()) {
                return false;
            }
            Object val = map.get(fieldName);
            if (val == null) {
                return false;
            }
            return (val instanceof String || val instanceof CharSequence);
        }

        @SuppressWarnings("unchecked")
        public JsonObject getJsonObject(String fieldName) {
            if (fieldName == null || fieldName.isEmpty()) {
                return null;
            }
            Object val = map.get(fieldName);
            if (val == null) {
                return null;
            }
            if (val instanceof Map) {
                Map<String, Object> valMap = (Map<String, Object>) val;
                val = new JsonObject(valMap);
            }
            return (JsonObject) val;
        }

        public boolean isEmpty() {
            return map == null || map.isEmpty();
        }

        public Set<String> fieldNames() {
            return (map == null) ? null : map.keySet();
        }

        public String encode() {
            return jsonSerialiser.toJson(map);
        }

        public void putFilter(Filter filter) {
            if (filter == null || !filter.isValid()) {
                return;
            }

            if (filter instanceof CustomFilter) {
                if (contains(CUSTOM_ATTRIBUTES_FIELD_NAME)) {
                    JsonObject def = getJsonObject(filter.getFieldName());
                    if (def != null) {
                        def.putFilter(((CustomFilter) filter).getRawFilter());
                    }
                } else {
                    JsonObject def = new JsonObject();
                    def.putFilter(((CustomFilter) filter).getRawFilter());
                    put(CUSTOM_ATTRIBUTES_FIELD_NAME, def);
                }
            } else {
                if (contains(filter.getFieldName())) {
                    JsonObject def = getJsonObject(filter.getFieldName());
                    if (def != null) {
                        def.putFilterDefinition(filter.getOperator(), filter.getValue());
                    }
                } else {
                    JsonObject def = new JsonObject();
                    def.putFilterDefinition(filter.getOperator(), filter.getValue());
                    put(filter.getFieldName(), def);
                }
            }
        }

        private boolean contains(String string) {
            if (isEmpty() || string == null || string.isEmpty()) {
                return false;
            }
            return map.containsKey(string);
        }

        private void put(String string, Object object) {
            if (string == null) {
                return;
            }
            if (map == null) {
                setMap(new LinkedHashMap<String, Object>());
            }
            if (object instanceof JsonObject) {
                JsonObject jsonObject = (JsonObject) object;
                if (!jsonObject.isEmpty()) {
                    map.put(string, jsonObject.getMap());
                }
            } else {
                map.put(string, object);
            }
        }

        private void putFilterDefinition(FilterOperator operator, Object value) {
            put(operator.getSymbol(), value);
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "JsonObject [jsonSerialiser=" + jsonSerialiser + ", map=" + map + "]";
        }

    }

}
