package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class ModelAdapter extends Model {
    public static final String FUNCTION_NAME_GET_MAPPER = "getMapper";
    public static final String FUNCTION_NAME_GET_LIST_MAPPER = "getListMapper";
    public static final String FUNCTION_NAME_GET_MAPPER_ADD = "getAddMapper";
    public static final String FUNCTION_NAME_GET_MAPPER_UPDATE = "getUpdateMapper";
    public static final String FUNCTION_NAME_GET_SIMPLE_LIST_MAPPER = "getSimpleListMapper";
    public static final String FUNCTION_NAME_MAP_LIST = "mapList";
    public static final String FUNCTION_NAME_MAP_SIMPLE_LIST = "mapSimpleList";
    public static final String FUNCTION_NAME_MAP_SIMPLE_LIST_ADD = "reverseMapAddSimpleList";
    public static final String FUNCTION_NAME_MAP_SIMPLE_LIST_UPDATE = "reverseMapUpdateSimpleList";
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
        setMayHaveLongLines(true);
        setFinal(true);
    }

    private static String generateDescription(String name, String description) {
        return description == null ? "Adapter for " + Utils.generateDocumentationString(name, true) : description;
    }

    public static String generateName(String modelName) {
        return Utils.combineNames(true, modelName, "adapter");
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
        addConstructor(new MethodConstructorEmpty(this, theParent).useParent(true).forcePrivate().accessible(false));
    }

    public void addDefaultConversion(Model from, Model to, MethodAction action) {
        if (from == null || to == null) {
            return;
        }
        final Conversion conversion = new Conversion(from, to, false, false, defaultRenames, null, null, action);
        addConversion(conversion, true);
    }

    public void addDefaultConversion(Model from, Model to, Model fromContent, Model toContent, boolean isList,
                                     MethodAction action) {
        if (from == null || to == null || fromContent == null || toContent == null) {
            return;
        }
        addDefaultConversion(from, to, action);
        final Conversion conversion = new Conversion(from, to, isList, false, defaultRenames, fromContent, toContent,
                                                     action);
        addConversion(conversion, true);
    }

    private void enflateConversions() {
        new ArrayList<>(conversions.values()).forEach(c -> enflate(c));
    }

    private void enflate(Conversion conversion) {
        if (conversion == null) {
            return;
        }
        if (conversion.isExternal()) {
            if (fetcher != null) {
                fetcher.fetch(conversion.getFrom().toType(), conversion.getTo().toType(), conversion.getAction());
                if (conversion.isList()
                    || conversion.getFrom().toType().isList() && conversion.getTo().toType().isList()) {
                    fetcher.fetchForCollection(conversion.getFrom(), conversion.getTo(), conversion.getFromContent(),
                                               conversion.getToContent(), conversion.isList(), conversion.getAction());

                    // TODO hashtables
                }
            }
        } else {
            enflate(conversion.getAction(), conversion.getFrom(), conversion.getTo(), conversion.getRenames());
        }
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
            final TypeParameter fromFieldType = fromField.getType();
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
                    fetcher.fetchForCollection((TypeCompose) fromFieldType, (TypeCompose) fType, action);
                }
            }
            if (TypeUtils.checkIfModel(fType) || TypeUtils.checkIfModel(fromFieldType)) {
                if (fetcher != null) {
                    fetcher.fetch(fromFieldType, fType, action);
                }
            }
        }
    }

    public void addMethodAdapter(MethodAction action, Model from, Model to, boolean isList, boolean isEnum,
                                 Renames renames, Model fromContent, Model toContent, boolean external) {
        addConversion(new Conversion(from, to, isList, isEnum, renames, fromContent, toContent, action, external),
                      true);
    }

    public void addMethodAdapter(MethodAction action, Model from, Model to, boolean isList, boolean isEnum,
                                 Renames renames, Model fromContent, Model toContent) {
        addMethodAdapter(action, from, to, isList, isEnum, renames, fromContent, toContent, false);
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
        private final boolean external;

        public Conversion(Model from, Model to, boolean isList, boolean isEnum, Renames renames, Model fromContent,
                          Model toContent, MethodAction action, boolean external) {
            super();
            this.from = from;
            this.to = to;
            this.isList = isList;
            this.isEnum = isEnum;
            this.renames = renames;
            this.fromContent = fromContent;
            this.toContent = toContent;
            this.action = action == null ? MethodAction.READ : action;
            this.external = external;
        }

        public Conversion(Model from, Model to, boolean isList, boolean isEnum, Renames renames, Model fromContent,
                          Model toContent, MethodAction action) {
            this(from, to, isList, isEnum, renames, fromContent, toContent, action, false);
        }

        public boolean isExternal() {
            return external;
        }

        public boolean isValid() {
            return from != null && to != null;
        }

        public String getIdentifier() {
            return action + ":" + to.getIdentifier() + "#" + from.getIdentifier();
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
            if (external) {
                return;
            }
            final Model fromToConsider = FetchUtils.getLatestModelDefinition(from, adapter.fetcher);
            final Model toToConsider = FetchUtils.getLatestModelDefinition(to, adapter.fetcher);
            final Model fromContentToConsider = FetchUtils.getLatestModelDefinition(fromContent, adapter.fetcher);
            final Model toContentToConsider = FetchUtils.getLatestModelDefinition(toContent, adapter.fetcher);
            final TypeParameter fromType = fromToConsider.toType();
            final TypeParameter toType = toToConsider.toType();
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

                MethodMapperEnum enumMapping = new MethodMapperEnum((ModelEnum) (isFromModel ? fromToConsider
                                                                                             : toToConsider),
                                                                    (isFromModel ? toType : fromType).getClazz(),
                                                                    isFromModel);
                adapter.addMethod(enumMapping);
            } else if (isList) {
                final MethodListMapper listMapping = new MethodListMapper(FUNCTION_NAME_MAP_LIST,
                                                                          FUNCTION_NAME_GET_MAPPER, true,
                                                                          toContentToConsider, fromToConsider,
                                                                          fromContentToConsider, adapter);
                adapter.addMethod(listMapping);
                final MethodGetMapper getMapper = new MethodGetMapper(FUNCTION_NAME_GET_LIST_MAPPER, true, adapter,
                                                                      determineListType(toToConsider.toType(),
                                                                                        toContentToConsider),
                                                                      determineListType(fromType,
                                                                                        fromContentToConsider),
                                                                      false, listMapping.getName());
                adapter.addMethod(getMapper);
            } else if (fromType.isList() && toType.isList()) {
                final TypeParameter fromSubType = ((TypeCompose) fromType).getContentType();
                final TypeParameter toSubType = ((TypeCompose) toType).getContentType();
                addSimpleListMethods(adapter, fromToConsider, toToConsider, fromContentToConsider, toContentToConsider,
                                     fromType, toType, fromSubType.isModel());
                if (adapter.fetcher != null) {
                    addBasicMappingMethods(adapter,
                                           TypeUtils.checkIfCollectionOfModel(fromSubType) ? adapter.fetcher.fetchModel(fromSubType)
                                                                                           : new Model(fromSubType.getClazz(),
                                                                                                       fromSubType),
                                           TypeUtils.checkIfCollectionOfModel(toSubType) ? adapter.fetcher.fetchModel(toSubType)
                                                                                         : new Model(toSubType.getClazz(),
                                                                                                     toSubType),
                                           renames, fromSubType,
                                           action == MethodAction.CREATE || action == MethodAction.UPDATE);
                }
            } else {// TODO mapping for Hashtable
                addBasicMappingMethods(adapter, fromToConsider, toToConsider, renames, fromType, false);
            }

        }

        private void addSimpleListMethods(ModelAdapter adapter, final Model fromToConsider, final Model toToConsider,
                                          final Model fromContentToConsider, final Model toContentToConsider,
                                          final TypeParameter fromType, final TypeParameter toType,
                                          boolean isFromModel) {
            String functionName = null;
            String getMapperName = null;
            String getListMapperName = null;
            if (isFromModel) {
                switch (action) {
                    case CREATE:
                        functionName = FUNCTION_NAME_MAP_SIMPLE_LIST_ADD;
                        getMapperName = FUNCTION_NAME_GET_MAPPER_ADD;
                        break;
                    case UPDATE:
                        functionName = FUNCTION_NAME_MAP_SIMPLE_LIST_UPDATE;
                        getMapperName = FUNCTION_NAME_GET_MAPPER_UPDATE;
                        break;
                    default:
                        throw new IllegalArgumentException("There cannot be a reverse mapper other than for Create/Update");
                }
            } else {
                functionName = FUNCTION_NAME_MAP_SIMPLE_LIST;
                getMapperName = FUNCTION_NAME_GET_MAPPER;
                getListMapperName = FUNCTION_NAME_GET_SIMPLE_LIST_MAPPER;
            }
            final MethodSimpleListMapper listMapping = new MethodSimpleListMapper(functionName, getMapperName, true,
                                                                                  fromToConsider, toToConsider,
                                                                                  isFromModel, fromType, toType,
                                                                                  adapter);
            adapter.addMethod(listMapping);
            if (getListMapperName != null) {
                final MethodGetMapper getMapper = new MethodGetMapper(getListMapperName, true, adapter,
                                                                      isFromModel ? fromType : toType,
                                                                      isFromModel ? toType : fromType, isFromModel,
                                                                      listMapping.getName());
                adapter.addMethod(getMapper);
            }
        }

        @SuppressWarnings("incomplete-switch")
        private void addBasicMappingMethods(ModelAdapter adapter, Model from, Model to, Renames renames,
                                            final TypeParameter fromType, boolean addReverseGetMapper) {
            final boolean isFromModel = fromType.isModel();
            String functionName = null;
            switch (action) {
                case CREATE:
                    functionName = isFromModel ? FUNCTION_NAME_MAP_ADD : FUNCTION_NAME_MAP;
                    break;
                case READ:
                    functionName = FUNCTION_NAME_MAP;
                    break;
                case UPDATE:
                    functionName = isFromModel ? FUNCTION_NAME_MAP_UPDATE : FUNCTION_NAME_MAP;
                    break;
            }
            final MethodMapper mapping = new MethodMapper(functionName, action, true, isFromModel ? from : to,
                                                          isFromModel ? to : from, isFromModel,
                                                          this.renames == null ? renames : this.renames,
                                                          adapter.fetcher);
            adapter.addMethod(mapping);
            if (!isFromModel || addReverseGetMapper) {
                String getMapperName = null;
                switch (action) {
                    case CREATE:
                        getMapperName = isFromModel ? FUNCTION_NAME_GET_MAPPER_ADD : FUNCTION_NAME_GET_MAPPER;
                        break;
                    case UPDATE:
                        getMapperName = isFromModel ? FUNCTION_NAME_GET_MAPPER_UPDATE : FUNCTION_NAME_GET_MAPPER;
                        break;
                    default:
                        getMapperName = FUNCTION_NAME_GET_MAPPER;
                        break;
                }
                final MethodGetMapper getMapper = new MethodGetMapper(getMapperName, true, adapter,
                                                                      isFromModel || addReverseGetMapper ? from : to,
                                                                      isFromModel || addReverseGetMapper ? to : from,
                                                                      isFromModel || addReverseGetMapper, functionName);
                adapter.addMethod(getMapper);
            }
        }

        public static TypeParameter determineListType(final TypeParameter type, final Model contentType) {
            return type instanceof TypeListResponse ? new TypeListResponse(contentType.toType()) : type;
        }
    }

}
