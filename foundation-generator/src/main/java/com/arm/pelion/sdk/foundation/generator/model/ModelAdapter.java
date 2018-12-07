package com.arm.pelion.sdk.foundation.generator.model;

import java.util.LinkedHashMap;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.TranslationException;

public class ModelAdapter extends Model {
    private final ModelAdapterFetcher fetcher;
    private final Map<String, String> defaultToFromRenames;

    private final Map<String, Conversion> conversions;

    public ModelAdapter(Model model, String packageName, String description, ModelAdapterFetcher fetcher,
                        Map<String, String> defaultToFromRenames) {
        super(packageName, generateName(model.getName()), model.getGroup(),
              generateDescription(model.getName(), description), null, false, true);
        setReadOnly(true);
        this.fetcher = fetcher;
        conversions = new LinkedHashMap<>();// Fill
        this.defaultToFromRenames = defaultToFromRenames;
    }

    private static String generateDescription(String name, String description) {
        return description == null ? "Adapter for " + ApiUtils.convertCamelToSnake(name).replace("_", " ").trim()
                                     + " API module"
                                   : description;
    }

    public static String generateName(String modelName) {
        return ApiUtils.convertSnakeToCamel(ApiUtils.convertCamelToSnake(modelName) + "_adapter", true);
    }

    @Override
    protected boolean hasSuperInterface() {
        return false;
    }

    @Override
    protected boolean isSerialisable() {
        return false;
    }

    public Map<String, String> getDefaultToFromRenames() {
        return defaultToFromRenames;
    }

    @Override
    protected void generateMethodsNecessaryAtEachLevel() {
        // Do not generate anything
    }

    @Override
    protected void generateMethodsDependingOnParents(Model theParent) {
        addConstructor(new MethodConstructorEmpty(this, theParent).useParent(true).accessible(false));
        conversions.values().forEach(c -> c.addMethod(this));
    }

    void addDefaultConversion(Model from, Model to) {
        if (from == null || to == null) {
            return;
        }
        final Conversion conversion = new Conversion(from, to, false, false, defaultToFromRenames, null, null);
        addConversion(conversion);
    }

    void addConversion(Conversion conversion) {
        if (conversion != null) {
            conversions.put(conversion.getIdentifier(), conversion);
        }
    }

    public static class Conversion {
        private static final String FUNCTION_NAME_GET_MAPPER = "getMapper";
        private static final String FUNCTION_NAME_GET_LIST_MAPPER = "getListMapper";
        private static final String FUNCTION_NAME_MAP_LIST = "mapList";
        private static final String FUNCTION_NAME_MAP = "map";
        private final Model from;
        private final Model to;
        private final boolean isList;
        private final boolean isEnum;
        private final Map<String, String> toFromRenames;
        private final Model fromContent;
        private final Model toContent;

        public Conversion(Model from, Model to, boolean isList, boolean isEnum, Map<String, String> toFromRenames,
                          Model fromContent, Model toContent) {
            super();
            this.from = from;
            this.to = to;
            this.isList = isList;
            this.isEnum = isEnum;
            this.toFromRenames = toFromRenames;
            this.fromContent = fromContent;
            this.toContent = toContent;
        }

        public String getIdentifier() {
            return to.getIdentifier();
        }

        public void addMethod(ModelAdapter adapter) {
            final ParameterType fromType = from.toType();
            try {
                fromType.translate();
            } catch (TranslationException exception1) {
                // Nothing to do.
                exception1.printStackTrace();
            }
            if (isEnum) {
                boolean isFromModel = fromType.isModelEnum();
                final ParameterType toType = to.toType();
                try {
                    toType.translate();
                } catch (TranslationException exception) {
                    // Nothing to do.
                    exception.printStackTrace();
                }
                MethodMapperEnum enumMapping = new MethodMapperEnum((ModelEnum) (isFromModel ? from : to),
                                                                    (isFromModel ? toType : fromType).getClazz(),
                                                                    isFromModel);
                adapter.addMethod(enumMapping);
            } else if (isList) {
                final MethodListMapper listMapping = new MethodListMapper(FUNCTION_NAME_MAP_LIST, FUNCTION_NAME_MAP,
                                                                          true, toContent, from, fromContent, adapter);
                adapter.addMethod(listMapping);
                final MethodGetMapper getMapper = new MethodGetMapper(FUNCTION_NAME_GET_LIST_MAPPER, true, adapter, to,
                                                                      from, false, listMapping.getName());
                adapter.addMethod(getMapper);
            } else {
                boolean isFromModel = fromType.isModel();
                final MethodMapper mapping = new MethodMapper(FUNCTION_NAME_MAP, true, isFromModel ? from : to,
                                                              isFromModel ? to : from, isFromModel, toFromRenames,
                                                              adapter.fetcher);
                adapter.addMethod(mapping);
                if (!isFromModel) {
                    final MethodGetMapper getMapper = new MethodGetMapper(FUNCTION_NAME_GET_MAPPER, true, adapter,
                                                                          isFromModel ? from : to,
                                                                          isFromModel ? to : from, isFromModel,
                                                                          mapping.getName());
                    adapter.addMethod(getMapper);
                }
            }

        }
    }

}
