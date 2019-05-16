package com.arm.pelion.sdk.foundation.generator.translator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.pelion.sdk.foundation.generator.Configuration;
import com.arm.pelion.sdk.foundation.generator.input.AdditionalProperty;
import com.arm.pelion.sdk.foundation.generator.input.Entity;
import com.arm.pelion.sdk.foundation.generator.input.Enumerator;
import com.arm.pelion.sdk.foundation.generator.input.Field;
import com.arm.pelion.sdk.foundation.generator.input.Filters;
import com.arm.pelion.sdk.foundation.generator.input.Group;
import com.arm.pelion.sdk.foundation.generator.input.IntermediateApiDefinition;
import com.arm.pelion.sdk.foundation.generator.input.Mapping;
import com.arm.pelion.sdk.foundation.generator.input.Method;
import com.arm.pelion.sdk.foundation.generator.lowlevelapis.LowLevelAPIMethod;
import com.arm.pelion.sdk.foundation.generator.lowlevelapis.LowLevelAPIMethodArgument;
import com.arm.pelion.sdk.foundation.generator.lowlevelapis.LowLevelAPIs;
import com.arm.pelion.sdk.foundation.generator.model.ArtifactFetcher;
import com.arm.pelion.sdk.foundation.generator.model.Artifacts;
import com.arm.pelion.sdk.foundation.generator.model.Filter;
import com.arm.pelion.sdk.foundation.generator.model.MethodAction;
import com.arm.pelion.sdk.foundation.generator.model.Model;
import com.arm.pelion.sdk.foundation.generator.model.ModelAdapter;
import com.arm.pelion.sdk.foundation.generator.model.ModelAdapterFetcher;
import com.arm.pelion.sdk.foundation.generator.model.ModelDao;
import com.arm.pelion.sdk.foundation.generator.model.ModelDaoFactory;
import com.arm.pelion.sdk.foundation.generator.model.ModelDaoList;
import com.arm.pelion.sdk.foundation.generator.model.ModelEndpoints;
import com.arm.pelion.sdk.foundation.generator.model.ModelEndpointsFetcher;
import com.arm.pelion.sdk.foundation.generator.model.ModelEnum;
import com.arm.pelion.sdk.foundation.generator.model.ModelListOption;
import com.arm.pelion.sdk.foundation.generator.model.ModelListOptionFetcher;
import com.arm.pelion.sdk.foundation.generator.model.ModelModule;
import com.arm.pelion.sdk.foundation.generator.model.ModelModuleFactory;
import com.arm.pelion.sdk.foundation.generator.model.ModelPojo;
import com.arm.pelion.sdk.foundation.generator.model.Renames;
import com.arm.pelion.sdk.foundation.generator.model.TypeParameter;
import com.arm.pelion.sdk.foundation.generator.util.FoundationGeneratorException;
import com.arm.pelion.sdk.foundation.generator.util.Logger;

public class ArtifactsTranslator {

    private ArtifactsTranslator() {
        // Do something
    }

    private static ModelDaoFactory translateFactory(Configuration config) {
        return new ModelDaoFactory(generateFactoryPackageName(config, null));
    }

    private static ModelModuleFactory translateModuleFactory(Configuration config) {
        return new ModelModuleFactory(generateModuleFactoryPackageName(config, null));
    }

    @SuppressWarnings("unused")
    private static ModelDaoList translateListDao(Model model, ModelModule module, ModelDao correspondingDao,
                                                 ModelListOption listOptions,
                                                 Entity entity) throws FoundationGeneratorException {
        if (!entity.hasMethods() || !entity.hasListMethod()) {
            return null;
        }
        final ModelDaoList dao = new ModelDaoList(model, module, correspondingDao, listOptions,
                                                  module.needsCustomCode());
        for (final Method m : entity.getMethods()) {
            if (m.isListMethod()) {
                dao.addMethods(MethodTranslator.determineMethodAction(m), MethodTranslator.generateMethodName(model, m),
                               m.isCustomCode());
            }
        }
        return dao;
    }

    @SuppressWarnings("unused")
    private static ModelDao translateDao(Model model, ModelModule module,
                                         Entity entity) throws FoundationGeneratorException {
        if (!entity.hasMethods()) {
            return null;
        }
        final ModelDao dao = new ModelDao(model, module, module.needsCustomCode());
        for (final Method m : entity.getMethods()) {
            if (!m.isListMethod()) {
                dao.addMethods(MethodTranslator.determineMethodAction(m), MethodTranslator.generateMethodName(model, m),
                               m.getSummary(), m.getDescription(), m.isCustomCode() || m.isCustomMethod());
            }
        }
        return dao;
    }

    private static ModelModule
            translateModuleModel(Logger logger, Configuration config, LowLevelAPIs lowLevelApis, Entity entity,
                                 Model model, ModelAdapterFetcher adapterFetcher,
                                 ModelEndpointsFetcher endpointsFetcher,
                                 ModelListOptionFetcher listOptionFetcher) throws FoundationGeneratorException {
        final ModelModule module = new ModelModule(model, generateModulePackageName(config, entity.getGroupId()), null,
                                                   endpointsFetcher, listOptionFetcher, adapterFetcher);
        for (final Method m : entity.getMethods()) {
            Model returnModel = null;
            if (m.getId() == null) {
                if (m.isCustomMethod()) {
                    continue;
                }
                throw new FoundationGeneratorException("Failed generating module for " + module + " as method ["
                                                       + m.getKey() + " of " + entity.getKey()
                                                       + "] does not have an ID.");
            }
            final LowLevelAPIMethod method = lowLevelApis.getFirstMethod(m.getId());
            if (method == null) {
                throw new FoundationGeneratorException("Failed generating module " + module + " as method [" + m.getId()
                                                       + "] was not found in the backends");
            }
            if (!m.getReturnInformation().doesReturnItSelf()) {
                if (CommonTranslator.isPrimitiveType(m.getReturnInformation().getReturnType())) {
                    logger.logError("Cannot generate adapter for " + m.getKey() + "/" + m.getId(),
                                    new IllegalArgumentException("Primitive return type is currently not supported"));
                    continue;
                }
                returnModel = CommonTranslator.fetchCorrespondingModel(config,
                                                                       m.getReturnInformation().getReturnType());
            }
            module.addCloudCall(MethodTranslator.translate(m, method, model, returnModel));
        }
        return module;
    }

    private static ModelAdapter
            translateAdapterModel(Logger logger, Configuration config, LowLevelAPIs lowLevelApis, Entity entity,
                                  Model model, ModelAdapterFetcher adapterFetcher) throws FoundationGeneratorException {
        final Renames defaultRenames = translateRenames(entity.getRenames());
        ModelAdapter adapter = adapterFetcher.fetchAdapter(model.getIdentifier());
        if (adapter == null) {
            adapter = new ModelAdapter(model, generateAdapterPackageName(config, entity.getGroupId()), null,
                                       adapterFetcher, defaultRenames);
        } else {
            adapter.setDefaultRenames(defaultRenames);
            adapter.setPackageName(generateAdapterPackageName(config, entity.getGroupId()));
        }

        for (final Method m : entity.getMethods()) {
            Model modelToConsider = model;
            boolean isExternal = false;
            if (m.getId() == null) {
                if (m.isCustomMethod()) {
                    continue;
                }
                throw new FoundationGeneratorException("Failed generating adapter for " + model + " as method ["
                                                       + m.getKey() + "] does not have an ID.");
            }
            final Renames methodRenames = translateRenames(m.getRenames());
            final LowLevelAPIMethod method = lowLevelApis.getFirstMethod(m.getId());
            if (method == null) {
                throw new FoundationGeneratorException("Failed generating adapter for " + model + " as method ["
                                                       + m.getId() + "] was not found in the backends");
            }

            if (!m.getReturnInformation().doesReturnItSelf()) {
                // This specifies that a different entity is returned. A mapping method to the corresponding adapter
                // needs to be added.
                isExternal = true;
                if (CommonTranslator.isPrimitiveType(m.getReturnInformation().getReturnType())) {
                    logger.logError("Cannot generate adapter for " + m.getKey() + "/" + m.getId(),
                                    new IllegalArgumentException("Primitive return type is currently not supported"));
                    continue;
                }
                modelToConsider = CommonTranslator.fetchCorrespondingModel(config,
                                                                           m.getReturnInformation().getReturnType());
            }

            if (method.hasToModel()) {
                if (m.isListMethod() || m.hasPaginatedResponse()) {
                    try {
                        adapter.addMethodAdapter(MethodAction.READ, new Model(method.getToModel().determineClass()),
                                                 new Model(ListResponse.class), true, false, methodRenames,
                                                 new Model(method.getToModel().determineContentClass()),
                                                 modelToConsider, isExternal);
                    } catch (ClassNotFoundException exception) {
                        throw new FoundationGeneratorException("Failed generating adapter for " + modelToConsider,
                                                               exception);
                    }

                } else {
                    try {
                        adapter.addMethodAdapter(MethodAction.READ, new Model(method.getToModel().determineClass()),
                                                 modelToConsider, false, false, methodRenames, null, null, isExternal);
                    } catch (ClassNotFoundException exception) {
                        throw new FoundationGeneratorException("Failed generating adapter for " + modelToConsider,
                                                               exception);
                    }

                }
            }
            if (method.hasFromModels()) {
                if (m.isListMethod() || m.hasPaginatedResponse()) {
                    // TODO shout, not handled
                    throw new FoundationGeneratorException("The generator does not handle list method with model parameter such as "
                                                           + m);
                }
                for (LowLevelAPIMethodArgument arg : method.getFromModels()) {
                    try {
                        adapter.addMethodAdapter(m.isCreateMethod() ? MethodAction.CREATE
                                                                    : m.isUpdateMethod() ? MethodAction.UPDATE
                                                                                         : MethodAction.READ,
                                                 model, new Model(arg.determineClass()), false, false, methodRenames,
                                                 null, null);
                    } catch (ClassNotFoundException exception) {
                        throw new FoundationGeneratorException("Failed generating adapter for " + model, exception);
                    }
                }

            }
        }
        return adapter;
    }

    private static Renames translateRenames(List<Mapping> mapping) {
        if (mapping == null) {
            return null;
        }
        final Renames renames = new Renames();
        mapping.forEach(m -> renames.addEntry(m.getProcessedFrom(), m.getProcessedTo()));
        return renames;
    }

    public static ModelPojo translateModel(Logger logger, Configuration config,
                                           Entity entity) throws FoundationGeneratorException {
        try {
            if (entity == null) {
                return null;
            }
            final String packageName = CommonTranslator.generateModelPackageName(config, entity.getGroupId());
            final Renames renames = translateRenames(entity.getRenames());
            ModelPojo model = new ModelPojo(packageName, generateEntityName(entity.getKey()),
                                            CommonTranslator.generateGoup(entity.getGroupId()), entity.getDescription(),
                                            entity.getLongDescription(), entity.isCustomCode(), entity.isInternal(),
                                            renames);
            if (entity.hasAdditionalProperties()) {
                final AdditionalProperty properties = entity.getAdditionalProperties();
                model.setSuperClassType(properties.hasForeignKey() ? CommonTranslator.FetchNestedEntityType(packageName,
                                                                                                            properties.getForeignKey())
                                                                   : new TypeParameter(properties.getType(),
                                                                                       properties.getFormat()));
            }
            if (entity.hasFields()) {
                for (final Field field : entity.getFields()) {
                    model.addField(FieldTranslator.translate(logger, field, model.getPackageName(), model.getGroup(),
                                                             entity.getPrimaryKey()));
                }
            }
            if (!entity.hasPrimaryKey()) {
                model.addNoIdentifierGetterAndSetter();
            }

            model.generateMethods();
            return model;
        } catch (FoundationGeneratorException exception) {
            logger.logError("Could not translate entity: " + entity, exception);
            throw exception;
        }
    }

    public static ModelListOption
           translateListOptions(Logger logger, Configuration config, Entity entity, Model correspondingModel,
                                ArtifactFetcher<Model> modelFetcher) throws FoundationGeneratorException {
        if (entity == null) {
            return null;
        }
        // change null by description if description is set in the intermediate config.
        final ModelListOption options = new ModelListOption(correspondingModel, modelFetcher, null,
                                                            entity.isCustomCode());

        // Do things regarding filters
        if (entity.hasListMethod() && entity.getListMethod().hasFilters()) {
            translateFilters(logger, options, correspondingModel, entity.getListMethod().getFilters(),
                             translateRenames(entity.getRenames()));
        }

        return options;
    }

    public static List<ModelListOption>
           translateOtherPaginatedListOptions(Logger logger, Configuration config, Entity entity,
                                              ArtifactFetcher<Model> modelFetcher) throws FoundationGeneratorException {
        if (entity == null) {
            return null;
        }
        final List<ModelListOption> allOptions = new LinkedList<>();
        for (Method otherPaginatedMethod : entity.getOtherPaginatedMethod()) {
            if (CommonTranslator.isPrimitiveType(otherPaginatedMethod.getReturnInformation().getReturnType())) {
                throw new FoundationGeneratorException(new IllegalArgumentException("Paginated response only works on entities: "
                                                                                    + otherPaginatedMethod));
            }
            final Model correspondingModel = CommonTranslator.fetchCorrespondingModel(config,
                                                                                      otherPaginatedMethod.getReturnInformation()
                                                                                                          .getReturnType());
            // change null by description if description is set in the intermediate config.
            final ModelListOption options = new ModelListOption(correspondingModel, modelFetcher, null,
                                                                correspondingModel.needsCustomCode() || correspondingModel.containsCustomCode());

            // Do things regarding filters
            if (otherPaginatedMethod.hasFilters()) {
                translateFilters(logger, options, correspondingModel, otherPaginatedMethod.getFilters(),
                                 translateRenames(entity.getRenames()));
            }

            allOptions.add(options);
        }
        return allOptions;
    }

    @SuppressWarnings("unused")
    private static void translateFilters(Logger logger, ModelListOption options, Model correspondingModel,
                                         Filters filters, Renames renames) throws FoundationGeneratorException {
        for (String fieldName : filters.keySet()) {
            com.arm.pelion.sdk.foundation.generator.model.Field field = correspondingModel.fetchField(fieldName);
            boolean isFound = field != null;
            final List<String> fieldFilters = filters.getFilters(fieldName);
            if (fieldFilters != null) {
                for (String fieldFilter : fieldFilters) {
                    final Filter filter = new Filter();
                    filter.setSpecFieldName(renames.containsMappingFor(fieldName) ? renames.getRenamedField(fieldName)
                                                                                  : fieldName);
                    filter.setOperator(FilterOperator.getFromSuffix(fieldFilter));
                    if (isFound) {
                        filter.setVerified(true);
                        filter.setFieldName(field.getName());
                        filter.setFieldType(field.getType());
                    } else {
                        filter.setVerified(false);
                        filter.setFieldName(fieldName);
                    }
                    options.addFilter(filter);
                }
            }
        }

    }

    private static ModelEndpoints translateEndpointModel(Configuration config, LowLevelAPIs lowLevelApis, Entity entity,
                                                         Model model) {
        if (entity == null || !entity.hasMethods() || lowLevelApis == null) {
            return null;
        }
        final ModelEndpoints endpoints = new ModelEndpoints(model, null, entity.isCustomCode());
        entity.getMethods().forEach(m -> {
            final Class<?> moduleClazz = lowLevelApis.getModuleClazz(m.getId());
            if (moduleClazz != null) {
                endpoints.addModule(moduleClazz);
            }
        });
        return endpoints;
    }

    private static ModelPojo translateEnum(Configuration config, Enumerator enumerator) {
        if (enumerator == null) {
            return null;
        }
        com.arm.pelion.sdk.foundation.generator.model.ModelEnum javaEnum = new ModelEnum(CommonTranslator.generateModelPackageName(config,
                                                                                                                                   enumerator.getGroupId()),
                                                                                         null, enumerator.getName(),
                                                                                         CommonTranslator.generateGoup(enumerator.getGroupId()),
                                                                                         enumerator.getLongDescription(),
                                                                                         enumerator.getValues(),
                                                                                         determineDefaultOption(enumerator));
        javaEnum.generateMethods();
        return javaEnum;
    }

    private static String determineDefaultOption(Enumerator enumerator) {
        // FIXME default option should be specified in the intermediate configuration file.
        return enumerator.getValues().stream().findFirst().orElse(null);
    }

    private static String generateEntityName(String key) {
        return ApiUtils.convertSnakeToCamel(key, true);
    }

    private static String generateAdapterPackageName(Configuration config, List<String> groupId) {
        return CommonTranslator.generatePackageName(config.getRootPackageName(), config.getAdapterPackage(), groupId);
    }

    private static String generateModulePackageName(Configuration config, List<String> groupId) {
        // TODO Can be changed
        return CommonTranslator.generatePackageName(config.getRootPackageName(), config.getModulePackage(), null);
    }

    private static String generateModuleFactoryPackageName(Configuration config, List<String> groupId) {
        // TODO Can be changed
        return generateModulePackageName(config, groupId);
    }

    private static String generateFactoryPackageName(Configuration config, List<String> groupId) {
        // TODO Can be changed
        return CommonTranslator.generatePackageName(config.getRootPackageName(), config.getFactoryPackage(), null);
    }

    public static Artifacts translate(Logger logger, Configuration config, IntermediateApiDefinition definition,
                                      LowLevelAPIs lowLevelApis) throws FoundationGeneratorException {
        if (definition == null) {
            return null;
        }
        // TODO add any entity to avoid during generation
        List<String> avoid = Arrays.asList();// e.g. "Account", "DeviceEvents");
        final Artifacts artifacts = new Artifacts();
        if (definition.hasGroups()) {
            for (final Group group : definition.getGroups()) {
                PelionModelDefinitionStore.get().storeGroup(group.getGroupId(), group.getEntities());
                PelionModelDefinitionStore.get().storeGroup(group.getGroupId(), group.getEnums());
            }
        }
        if (definition.hasEntities()) {
            ModelDaoFactory factory = translateFactory(config);
            ModelModuleFactory moduleFactory = translateModuleFactory(config);
            // Note: not using streams so that exceptions are raised
            for (final Entity entity : definition.getEntities()) {
                if (!avoid.stream().anyMatch(n -> n.equals(entity.getKey()))) {
                    final ModelPojo model = PelionModelDefinitionStore.get()
                                                                      .store(translateModel(logger, config, entity));
                    artifacts.addModel(model);
                    artifacts.addEndpoint(translateEndpointModel(config, lowLevelApis, entity, model));
                    artifacts.addAdapter(translateAdapterModel(logger, config, lowLevelApis, entity, model,
                                                               artifacts.getAdapterFetcher()));
                    ModelListOption listOptions = null;
                    if (entity.hasListMethod()) {
                        listOptions = translateListOptions(logger, config, entity, model, artifacts.getModelFetcher());
                        artifacts.addListOption(listOptions);
                    }
                    if (entity.hasOtherPaginatedMethod()) {
                        artifacts.addListOptions(translateOtherPaginatedListOptions(logger, config, entity,
                                                                                    artifacts.getModelFetcher()));
                    }
                    final ModelModule module = translateModuleModel(logger, config, lowLevelApis, entity, model,
                                                                    artifacts.getAdapterFetcher(),
                                                                    artifacts.getEndpointsFetcher(),
                                                                    artifacts.getListOptionFetcher());
                    artifacts.addModule(module);
                    moduleFactory.addModule(module);
                    final ModelDao dao = translateDao(model, module, entity);
                    artifacts.addDao(dao);
                    factory.addDao(dao);
                    if (entity.hasListMethod()) {
                        final ModelDaoList daoList = translateListDao(model, module, dao, listOptions, entity);
                        artifacts.addDao(daoList);
                        factory.addDao(daoList);
                    }
                }
            }
            artifacts.addFactory(factory);
            artifacts.addFactory(moduleFactory);
        }
        if (definition.hasEnums()) {
            // Order enum is defined globally
            List<Enumerator> enums = definition.getEnums().stream()
                                               .filter(e -> e.hasValues() && !e.getName().contains("order_enum"))
                                               .collect(Collectors.toList());
            for (final Enumerator enumerator : enums) {
                artifacts.addModel(PelionModelDefinitionStore.get().store(translateEnum(config, enumerator)));
            }
        }
        return artifacts;
    }
}
