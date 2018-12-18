package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class ModelAdapter extends Model {
    public static final String FUNCTION_NAME_GET_MAPPER = "getMapper";
    public static final String FUNCTION_NAME_GET_LIST_MAPPER = "getListMapper";
    public static final String FUNCTION_NAME_GET_SIMPLE_LIST_MAPPER = "getSimpleListMapper";
    public static final String FUNCTION_NAME_MAP_LIST = "mapList";
    public static final String FUNCTION_NAME_MAP_SIMPLE_LIST = "mapSimpleList";
    public static final String FUNCTION_NAME_MAP = "map";
    public static final String FUNCTION_NAME_MAP_ADD = "reverseMapAddRequest";
    public static final String FUNCTION_NAME_MAP_UPDATE = "reverseMapUpdateRequest";
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
        return description == null ? "Adapter for " + Utils.generateDocumentationString(name) + " API module"
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
        super.generateOtherMethods();
        generateMethodsDependingOnParents(null);
        enflateConversions();
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
        final Conversion conversion = new Conversion(from, to, false, false, defaultRenames, null, null, null);
        addConversion(conversion, true);
    }

    private void enflateConversions() {
        new ArrayList<>(conversions.values()).forEach(c -> enflate(c));
    }

    private void enflate(Conversion conversion) {
        if (conversion == null) {
            return;
        }
        enflate(conversion.getAction(), conversion.getFrom(), conversion.getTo(), conversion.getRenames());
    }

    private void enflate(MethodAction action, Model from, Model to, Renames renames) {
        for (Field f : to.getFieldList()) {
            final TypeParameter fType = f.getType();
            final String toFieldName = f.getName();
            final String fromFieldName = renames != null
                                         && renames.containsMappingFor(toFieldName) ? renames.getRenamedField(toFieldName)
                                                                                    : toFieldName;
            final Field fromField = from.fetchField(fromFieldName);
            if (fromField == null) {
                continue;
            }
            final TypeParameter fromFieldType = fromField == null ? null : fromField.getType();
            if (fromFieldType.isEnum() || fromFieldType.isModelEnum() || fType.isEnum() || fType.isModelEnum()) {

                addConversion(new Conversion(fromFieldType.isModelEnum() ? fetcher.fetchModel(fromFieldType)
                                                                         : new Model(fromField.getType().getClazz(),
                                                                                     fromField.getType()),
                                             fType.isModelEnum() ? fetcher.fetchModel(fType)
                                                                 : new Model(f.getType().getClazz(), f.getType()),
                                             false, true, renames, null, null, action),
                              false);
            }

            if (TypeUtils.checkIfCollectionOfModel(fType) || TypeUtils.checkIfCollectionOfModel(fromFieldType)) {
                if (fetcher != null) {
                    fetcher.fetchForCollection((TypeCompose) fromFieldType, (TypeCompose) fType);
                }
            }
            if (TypeUtils.checkIfModel(fType) || TypeUtils.checkIfModel(fromFieldType)) {
                if (fetcher != null) {
                    fetcher.fetch(fromFieldType, fType);
                }
            }
        }
    }

    public void addMethodAdapter(MethodAction action, Model from, Model to, boolean isList, boolean isEnum,
                                 Renames renames, Model fromContent, Model toContent) {
        addConversion(new Conversion(from, to, isList, isEnum, renames, fromContent, toContent, action), true);
    }

    protected boolean needsConversion(Field f) {
        return f.getType().isEnum() || TypeUtils.checkIfModel(f.getType()) || f.getType().isModelEnum();
    }

    private void addConversion(Conversion conversion, boolean enflate) {
        if (conversion != null && conversion.isValid()) {
            conversions.put(conversion.getIdentifier(), conversion);
            if (enflate) {
                enflate(conversion);
            }
        }
    }

    public static class Conversion {
        private final Model from;
        private final Model to;
        private final boolean isList;
        private final boolean isEnum;
        private final Renames renames;
        private final Model fromContent;
        private final Model toContent;
        private final MethodAction action;

        public Conversion(Model from, Model to, boolean isList, boolean isEnum, Renames renames, Model fromContent,
                          Model toContent, MethodAction action) {
            super();
            this.from = from;
            this.to = to;
            this.isList = isList;
            this.isEnum = isEnum;
            this.renames = renames;
            this.fromContent = fromContent;
            this.toContent = toContent;
            this.action = action == null ? MethodAction.READ : action;
        }

        public boolean isValid() {
            return from != null && to != null;
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

        public MethodAction getAction() {
            return action;
        }

        @Override
        public String toString() {
            return "Conversion [from=" + from + ", to=" + to + ", isList=" + isList + ", isEnum=" + isEnum
                   + ", renames=" + renames + ", fromContent=" + fromContent + ", toContent=" + toContent + ", action="
                   + action + "]";
        }

        public void addMethod(ModelAdapter adapter, Renames renames) {
            final TypeParameter fromType = from.toType();
            final TypeParameter toType = to.toType();
            try {
                fromType.translate();
            } catch (TranslationException exception1) {
                // Nothing to do.
                exception1.printStackTrace();
            }
            try {
                toType.translate();
            } catch (TranslationException exception) {
                // Nothing to do.
                exception.printStackTrace();
            }
            if (isEnum) {
                boolean isFromModel = fromType.isModelEnum();

                MethodMapperEnum enumMapping = new MethodMapperEnum((ModelEnum) (isFromModel ? from : to),
                                                                    (isFromModel ? toType : fromType).getClazz(),
                                                                    isFromModel);
                adapter.addMethod(enumMapping);
            } else if (isList) {
                final MethodListMapper listMapping = new MethodListMapper(FUNCTION_NAME_MAP_LIST,
                                                                          FUNCTION_NAME_GET_MAPPER, true, toContent,
                                                                          from, fromContent, adapter);
                adapter.addMethod(listMapping);
                final MethodGetMapper getMapper = new MethodGetMapper(FUNCTION_NAME_GET_LIST_MAPPER, true, adapter,
                                                                      determineListType(to.toType(), toContent),
                                                                      determineListType(fromType, fromContent), false,
                                                                      listMapping.getName());
                adapter.addMethod(getMapper);
            } else if (fromType.isList() && toType.isList()) {
                final TypeParameter fromSubType = ((TypeCompose) fromType).getContentType();
                final TypeParameter toSubType = ((TypeCompose) toType).getContentType();
                final MethodSimpleListMapper listMapping = new MethodSimpleListMapper(FUNCTION_NAME_MAP_SIMPLE_LIST,
                                                                                      FUNCTION_NAME_GET_MAPPER, true,
                                                                                      from, to, toType, adapter);
                adapter.addMethod(listMapping);
                final MethodGetMapper getMapper = new MethodGetMapper(FUNCTION_NAME_GET_SIMPLE_LIST_MAPPER, true,
                                                                      adapter,
                                                                      determineListType(to.toType(), toContent),
                                                                      determineListType(fromType, fromContent), false,
                                                                      listMapping.getName());
                adapter.addMethod(getMapper);
                if (adapter.fetcher != null) {
                    addBasicMappingMethods(adapter,
                                           TypeUtils.checkIfCollectionOfModel(fromSubType) ? adapter.fetcher.fetchModel(fromSubType)
                                                                                           : new Model(fromSubType.getClazz(),
                                                                                                       fromSubType),
                                           TypeUtils.checkIfCollectionOfModel(toSubType) ? adapter.fetcher.fetchModel(toSubType)
                                                                                         : new Model(toSubType.getClazz(),
                                                                                                     toSubType),
                                           renames, fromType);
                }
            } else {// TODO mapping for Hashtable
                addBasicMappingMethods(adapter, from, to, renames, fromType);
            }

        }

        public void addBasicMappingMethods(ModelAdapter adapter, Model from, Model to, Renames renames,
                                           final TypeParameter fromType) {
            boolean isFromModel = fromType.isModel();
            String functionName = null;
            switch (action) {
                case CREATE:
                    functionName = isFromModel ? FUNCTION_NAME_MAP_ADD : FUNCTION_NAME_MAP;
                    break;
                case DELETE:
                    break;
                case READ:
                    functionName = FUNCTION_NAME_MAP;
                    break;
                case UPDATE:
                    functionName = isFromModel ? FUNCTION_NAME_MAP_UPDATE : FUNCTION_NAME_MAP;
                    break;
            }
            final MethodMapper mapping = new MethodMapper(functionName, true, isFromModel ? from : to,
                                                          isFromModel ? to : from, isFromModel,
                                                          this.renames == null ? renames : this.renames,
                                                          adapter.fetcher);
            adapter.addMethod(mapping);
            if (!isFromModel) {
                final MethodGetMapper getMapper = new MethodGetMapper(FUNCTION_NAME_GET_MAPPER, true, adapter,
                                                                      isFromModel ? from : to, isFromModel ? to : from,
                                                                      isFromModel, mapping.getName());
                adapter.addMethod(getMapper);
            }
        }

        public static TypeParameter determineListType(final TypeParameter type, final Model contentType) {
            return type instanceof TypeListResponse ? new TypeListResponse(contentType.toType()) : type;
        }
    }

}
