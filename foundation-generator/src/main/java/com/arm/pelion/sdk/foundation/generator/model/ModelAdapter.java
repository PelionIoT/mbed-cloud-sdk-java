package com.arm.pelion.sdk.foundation.generator.model;

import java.util.LinkedHashMap;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.TranslationException;

public class ModelAdapter extends Model {
    private final ModelAdapterFetcher fetcher;
    private Renames defaultRenames;

    private final Map<String, Conversion> conversions;

    public ModelAdapter(Model model, String packageName, String description, ModelAdapterFetcher fetcher,
                        Renames renames) {
        super(packageName, generateName(model.getName()), model.getGroup(),
              generateDescription(model.getName(), description), null, false, true);
        setReadOnly(true);
        this.fetcher = fetcher;
        conversions = new LinkedHashMap<>();// Fill
        this.defaultRenames = renames;
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

    @Override
    protected void generateMethodsNecessaryAtEachLevel() {
        // Do not generate anything
    }

    @Override
    protected void generateOtherMethods() {
        System.out.println("generateOtherMethods for " + name);
        System.out.println(conversions);
        super.generateOtherMethods();
        generateMethodsDependingOnParents(null);
        conversions.values().forEach(c -> c.addMethod(this, defaultRenames));

    }

    public void setDefaultRenames(Renames defaultRenames) {
        this.defaultRenames = defaultRenames;
    }

    @Override
    protected void generateMethodsDependingOnParents(Model theParent) {
        addConstructor(new MethodConstructorEmpty(this, theParent).useParent(true).accessible(false));

    }

    public void addDefaultConversion(Model from, Model to) {
        if (from == null || to == null) {
            return;
        }
        final Conversion conversion = new Conversion(from, to, false, false, defaultRenames, null, null);
        addConversion(conversion);
    }

    // public void enflate() {
    // List<Conversion> conversionList=new ArrayList(conversions.values());
    // for(Conversion conversion: conversionList) {
    // final List<Field> list=
    // conversion.getFrom().getFieldList().stream().filter(f->needsConversion(f)).collect(Collectors.toList());
    // for(Field f:list) {
    // addConversion(new Conversion(conversion.getFrom(), conversion.getTo(), false,
    // f.getType().isEnum()||f.getType().isModelEnum(), null, null, null));
    // }
    // }
    //
    // }

    public void addMethodAdapter(Model from, Model to, boolean isList, boolean isEnum, Renames renames,
                                 Model fromContent, Model toContent) {
        addConversion(new Conversion(from, to, isList, isEnum, renames, fromContent, toContent));
    }

    protected boolean needsConversion(Field f) {
        return f.getType().isEnum() || f.getType().isModel() || f.getType().isLowLevelModel()
               || f.getType().isModelEnum();
    }

    private void addConversion(Conversion conversion) {
        System.out.println("adding " + conversion);
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
        private final Renames renames;
        private final Model fromContent;
        private final Model toContent;

        public Conversion(Model from, Model to, boolean isList, boolean isEnum, Renames renames, Model fromContent,
                          Model toContent) {
            super();
            this.from = from;
            this.to = to;
            this.isList = isList;
            this.isEnum = isEnum;
            this.renames = renames;
            this.fromContent = fromContent;
            this.toContent = toContent;
        }

        public String getIdentifier() {
            return to.getIdentifier();
        }

        public Model getFrom() {
            return from;
        }

        public Model getTo() {
            return to;
        }

        public boolean isList() {
            return isList;
        }

        public boolean isEnum() {
            return isEnum;
        }

        public Renames getRenames() {
            return renames;
        }

        public Model getFromContent() {
            return fromContent;
        }

        public Model getToContent() {
            return toContent;
        }

        @Override
        public String toString() {
            return "Conversion [from=" + from + ", to=" + to + ", isList=" + isList + ", isEnum=" + isEnum
                   + ", renames=" + renames + ", fromContent=" + fromContent + ", toContent=" + toContent + "]";
        }

        public void addMethod(ModelAdapter adapter, Renames renames) {
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
                                                              isFromModel ? to : from, isFromModel,
                                                              this.renames == null ? renames : this.renames,
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
