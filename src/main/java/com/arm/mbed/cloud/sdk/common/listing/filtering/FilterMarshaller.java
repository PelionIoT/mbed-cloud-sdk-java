package com.arm.mbed.cloud.sdk.common.listing.filtering;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.JSONSerialiser;

@Preamble(description = "Filters marshaller for serialisation/deserialisation")
public class FilterMarshaller {
    private static final String CUSTOM_ATTRIBUTES_FIELD_NAME = "custom_attributes";

    private static final String FILTER_KEY_VALUE_SEPARATOR = "=";

    private static final String FILTER_SEPARATOR = "&";

    public static final String SUFFIX_SEPARATOR = "__";

    private static final DateTimeFormatter DATE_ISO_FORMATTER = ISODateTimeFormat.dateTime();
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
     * @return URL String containing all filters definition
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
     * @return URL String containing all filters definition
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
        Filters filters = new Filters();
        for (String fieldName : obj.fieldNames()) {
            if (CUSTOM_ATTRIBUTES_FIELD_NAME.equalsIgnoreCase(fieldName)) {
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

    protected String encodeFilter(Filter filter, String fieldName) {
        if (filter == null || !filter.isValid()) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        if (filter.hasPrefix()) {
            builder.append(filter.getPrefix());
        }
        builder.append(ApiUtils.convertCamelToSnake((fieldName == null) ? filter.getFieldName() : fieldName));
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
        if (key != null && key.contains(CustomFilter.CUSTOM_ATTRIBUTES_PREFIX)) {
            key = key.replace(CustomFilter.CUSTOM_ATTRIBUTES_PREFIX, "");
            isCustom = true;
        }
        FilterOperator operator = FilterOperator.getFromSuffix(fetchSuffix(key));
        Filter filter = (isCustom) ? new CustomFilter(fetchFieldName(key, operator), operator, parts[1])
                : new Filter(fetchFieldName(key, operator), operator, parts[1]);
        return (filter.isValid()) ? filter : null;
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

    @SuppressWarnings("cast")
    private static String formatFilterValue(Object value) {
        if (value instanceof Date) {
            // Moving dates/Times to UTC and formatting them according to rfc3339
            return DATE_ISO_FORMATTER.print(new DateTime((Date) value).toDateTime(DateTimeZone.UTC));
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
        return ApiUtils.convertSnakeToCamel(fieldName, false);
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
        String filterValue = obj.getString(fieldName);
        Filter filter = new Filter(fieldName, FilterOperator.getDefault(), filterValue);
        filters.add(filter);
    }

    private static void parseFilterAsJsonObject(JsonObject obj, String fieldName, Filters filters, boolean isCustom) {
        JsonObject filterJson = obj.getJsonObject(fieldName);
        if (filterJson == null || filterJson.isEmpty()) {
            return;
        }
        for (String operator : filterJson.fieldNames()) {
            Filter filter = (isCustom)
                    ? new CustomFilter(fieldName, FilterOperator.getFromSymbol(operator),
                            filterJson.getString(operator))
                    : new Filter(fieldName, FilterOperator.getFromSymbol(operator), filterJson.getString(operator));
            filters.add(filter);
        }
    }

    private static class JsonObject {

        private final JSONSerialiser jsonSerialiser = new JSONSerialiser();
        private Map<String, Object> map;

        public JsonObject(Map<String, Object> map) {
            setMap(map);
        }

        public JsonObject() {
            setMap(null);
        }

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

        public String getString(String fieldName) {
            if (fieldName == null || fieldName.isEmpty()) {
                return null;
            }
            CharSequence cs = (CharSequence) map.get(fieldName);
            return cs == null ? null : cs.toString();
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

        public JsonObject getJsonObject(String fieldName) {
            if (fieldName == null || fieldName.isEmpty()) {
                return null;
            }
            Object val = map.get(fieldName);
            if (val == null) {
                return null;
            }
            if (val instanceof Map) {
                @SuppressWarnings("unchecked")
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

    }

}
