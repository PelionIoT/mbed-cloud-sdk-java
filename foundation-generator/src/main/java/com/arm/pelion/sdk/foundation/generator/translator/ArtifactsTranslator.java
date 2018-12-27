package com.arm.pelion.sdk.foundation.generator.translator;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.pelion.sdk.foundation.generator.Configuration;
import com.arm.pelion.sdk.foundation.generator.input.AdditionalProperty;
import com.arm.pelion.sdk.foundation.generator.input.Entity;
import com.arm.pelion.sdk.foundation.generator.input.Enumerator;
import com.arm.pelion.sdk.foundation.generator.input.Field;
import com.arm.pelion.sdk.foundation.generator.input.IntermediateApiDefinition;
import com.arm.pelion.sdk.foundation.generator.input.Method;
import com.arm.pelion.sdk.foundation.generator.lowlevelapis.LowLevelAPIMethod;
import com.arm.pelion.sdk.foundation.generator.lowlevelapis.LowLevelAPIMethodArgument;
import com.arm.pelion.sdk.foundation.generator.lowlevelapis.LowLevelAPIs;
import com.arm.pelion.sdk.foundation.generator.model.Artifacts;
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
import com.arm.pelion.sdk.foundation.generator.model.ModelPojo;
import com.arm.pelion.sdk.foundation.generator.model.Renames;
import com.arm.pelion.sdk.foundation.generator.model.TypeParameter;
import com.arm.pelion.sdk.foundation.generator.util.FoundationGeneratorException;

public class ArtifactsTranslator {

    private ArtifactsTranslator() {
        // Do something
    }

    private static ModelDaoFactory translateFactory(Configuration config) {
        // TODO CHANGE
        return new ModelDaoFactory(generateFactoryPackageName(config, null));
    }

    private static ModelDaoList translateListDao(Model model, ModelModule module, ModelDao correspondingDao,
                                                 ModelListOption listOptions, Entity entity) {
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
        dao.generateMethods();
        return dao;
    }

    private static ModelDao translateDao(Model model, ModelModule module, Entity entity) {
        if (!entity.hasMethods()) {
            return null;
        }
        final ModelDao dao = new ModelDao(model, module, module.needsCustomCode());
        for (final Method m : entity.getMethods()) {
            if (!m.isListMethod()) {
                dao.addMethods(MethodTranslator.determineMethodAction(m), MethodTranslator.generateMethodName(model, m),
                               m.isCustomCode());
            }
        }
        dao.generateMethods();
        return dao;
    }

    private static ModelModule
            translateModuleModel(Configuration config, LowLevelAPIs lowLevelApis, Entity entity, Model model,
                                 ModelAdapterFetcher adapterFetcher, ModelEndpointsFetcher endpointsFetcher,
                                 ModelListOptionFetcher listOptionFetcher) throws FoundationGeneratorException {
        final ModelModule module = new ModelModule(model, generateModulePackageName(config, entity.getGroupId()), null,
                                                   endpointsFetcher, listOptionFetcher, adapterFetcher);
        for (final Method m : entity.getMethods()) {
            final LowLevelAPIMethod method = lowLevelApis.getFirstMethod(m.getId());
            if (method == null) {
                throw new FoundationGeneratorException("Failed generating module " + module + " as method [" + m.getId()
                                                       + "] was not found in the backends");
            }
            if (m.doesntReturnItself()) {
                // TODO shout
                System.out.println("ERROR! Cannot yet generate method for " + m.getKey() + "/" + m.getId());
            } else {
                module.addCloudCall(MethodTranslator.translate(m, method, model));
            }
        }
        module.generateMethods();
        return module;
    }

    private static ModelAdapter
            translateAdapterModel(Configuration config, LowLevelAPIs lowLevelApis, Entity entity, Model model,
                                  ModelAdapterFetcher adapterFetcher) throws FoundationGeneratorException {
        final Renames defaultRenames = new Renames();
        entity.getRenames().forEach(m -> defaultRenames.addEntry(m.getProcessedFrom(), m.getProcessedTo()));
        final ModelAdapter adapter = new ModelAdapter(model, generateAdapterPackageName(config, entity.getGroupId()),
                                                      null, adapterFetcher, defaultRenames);

        for (final Method m : entity.getMethods()) {
            final Renames methodRenames = new Renames();
            m.getRenames().forEach(f -> methodRenames.addEntry(f.getProcessedFrom(), f.getProcessedTo()));
            final LowLevelAPIMethod method = lowLevelApis.getFirstMethod(m.getId());
            if (method == null) {
                throw new FoundationGeneratorException("Failed generating adapter for " + model + " as method ["
                                                       + m.getId() + "] was not found in the backends");
            }
            if (m.doesntReturnItself()) {
                // TODO shout
                System.out.println("ERROR! Cannot yet generate adapter for " + m.getKey() + "/" + m.getId());
            } else {

                if (method.hasToModel()) {
                    if (m.isListMethod()) {
                        try {
                            adapter.addMethodAdapter(MethodAction.READ, new Model(method.getToModel().determineClass()),
                                                     new Model(ListResponse.class), true, false, methodRenames,
                                                     new Model(method.getToModel().determineContentClass()), model);
                        } catch (ClassNotFoundException exception) {
                            throw new FoundationGeneratorException("Failed generating adapter for " + model, exception);
                        }

                    } else {
                        try {
                            adapter.addMethodAdapter(MethodAction.READ, new Model(method.getToModel().determineClass()),
                                                     model, false, false, methodRenames, null, null);
                        } catch (ClassNotFoundException exception) {
                            throw new FoundationGeneratorException("Failed generating adapter for " + model, exception);
                        }

                    }
                }
                if (method.hasFromModels()) {
                    if (m.isListMethod()) {
                        // TODO shout, not handled
                        throw new FoundationGeneratorException("The generator does not handle list method with model parameter such as "
                                                               + m);
                    } else {
                        for (LowLevelAPIMethodArgument arg : method.getFromModels()) {
                            try {
                                adapter.addMethodAdapter(m.isCreateMethod() ? MethodAction.CREATE
                                                                            : m.isUpdateMethod() ? MethodAction.UPDATE
                                                                                                 : MethodAction.READ,
                                                         model, new Model(arg.determineClass()), false, false,
                                                         methodRenames, null, null);
                            } catch (ClassNotFoundException exception) {
                                throw new FoundationGeneratorException("Failed generating adapter for " + model,
                                                                       exception);
                            }
                        }
                    }

                }

            }
        }
        adapter.generateMethods();
        return adapter;
    }

    public static ModelPojo translate(Configuration config, Entity entity) throws FoundationGeneratorException {
        if (entity == null) {
            return null;
        }
        final String packageName = generateModelPackageName(config, entity.getGroupId());
        ModelPojo model = new ModelPojo(packageName, generateEntityName(entity.getKey()),
                                        CommonTranslator.generateGoup(entity.getGroupId()), entity.getDescription(),
                                        entity.getLongDescription(), entity.isCustomCode(), entity.isInternal());
        if (entity.hasAdditionalProperties()) {
            final AdditionalProperty properties = entity.getAdditionalProperties();
            model.setSuperClassType(properties.hasForeignKey() ? CommonTranslator.FetchNestedEntityType(packageName,
                                                                                                        properties.getForeignKey())
                                                               : new TypeParameter(properties.getType(),
                                                                                   properties.getFormat()));
        }
        if (entity.hasFields()) {
            for (final Field field : entity.getFields()) {
                model.addField(FieldTranslator.translate(field, model.getPackageName(), model.getGroup(),
                                                         entity.getPrimaryKey()));
            }
        }
        if (!entity.hasPrimaryKey()) {
            model.addNoIdentifierGetterAndSetter();
        }

        model.generateMethods();
        return model;
    }

    public static ModelListOption translateListOptions(Configuration config, Entity entity,
                                                       Model correspondingModel) throws FoundationGeneratorException {
        if (entity == null) {
            return null;
        }
        // change null by description if description is set in the intermediate config.
        final ModelListOption options = new ModelListOption(correspondingModel, null, entity.isCustomCode());

        // Do things regarding filters

        options.generateMethods();
        return options;
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
        endpoints.generateMethods();
        return endpoints;
    }

    private static ModelPojo translate(Configuration config, Enumerator enumerator) {
        if (enumerator == null) {
            return null;
        }
        com.arm.pelion.sdk.foundation.generator.model.ModelEnum javaEnum = new ModelEnum(generateModelPackageName(config,
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
        return enumerator.getValues().iterator().next();
    }

    private static String generateEntityName(String key) {
        return ApiUtils.convertSnakeToCamel(key, true);
    }

    private static String generateModelPackageName(Configuration config, List<String> groupId) {
        return generatePackageName(config.getRootPackageName(), config.getModelPackage(), groupId);
    }

    private static String generateAdapterPackageName(Configuration config, List<String> groupId) {
        return generatePackageName(config.getRootPackageName(), config.getAdapterPackage(), groupId);
    }

    private static String generateModulePackageName(Configuration config, List<String> groupId) {
        // TODO Can be changed
        return generatePackageName(config.getRootPackageName(), config.getModulePackage(), null);
    }

    private static String generateFactoryPackageName(Configuration config, List<String> groupId) {
        // TODO Can be changed
        return generatePackageName(config.getRootPackageName(), config.getFactoryPackage(), null);
    }

    private static String generatePackageName(String rootPackageName, String modelPackage, List<String> groupId) {
        StringBuilder builder = new StringBuilder();
        if (rootPackageName != null) {
            builder.append(rootPackageName);
            if (!rootPackageName.endsWith(CommonTranslator.PACKAGE_SEPARATOR)) {
                builder.append(CommonTranslator.PACKAGE_SEPARATOR);
            }
        }
        final String specificPackage = CommonTranslator.generateGoup(groupId);
        if (specificPackage != null) {
            builder.append(specificPackage);
        }
        if (modelPackage != null) {
            if (!modelPackage.startsWith(CommonTranslator.PACKAGE_SEPARATOR)) {
                if (specificPackage != null && !specificPackage.endsWith(CommonTranslator.PACKAGE_SEPARATOR)) {
                    builder.append(CommonTranslator.PACKAGE_SEPARATOR);
                }
            }
            builder.append(modelPackage);
        }
        final String packageName = builder.toString()
                                          .replace(CommonTranslator.PACKAGE_SEPARATOR
                                                   + CommonTranslator.PACKAGE_SEPARATOR,
                                                   CommonTranslator.PACKAGE_SEPARATOR)
                                          .toLowerCase(Locale.UK);
        if (packageName.endsWith(CommonTranslator.PACKAGE_SEPARATOR)) {
            return packageName.substring(0, packageName.length() - 1);
        }
        return packageName;
    }

    public static Artifacts translate(Configuration config, IntermediateApiDefinition definition,
                                      LowLevelAPIs lowLevelApis) throws FoundationGeneratorException {
        if (definition == null) {
            return null;
        }
        // FIXME TO remove
        List<String> avoid = Arrays.asList();// "Account", "DeviceEvents");
        final Artifacts artifacts = new Artifacts();
        if (definition.hasEntities()) {
            ModelDaoFactory factory = translateFactory(config);
            // Note: not using streams so that exceptions are raised
            for (final Entity entity : definition.getEntities()) {
                if (!avoid.stream().anyMatch(n -> n.equals(entity.getKey()))) {
                    final ModelPojo model = PelionModelDefinitionStore.get().store(translate(config, entity));
                    artifacts.addModel(model);
                    artifacts.addEndpoint(translateEndpointModel(config, lowLevelApis, entity, model));
                    artifacts.addAdapter(translateAdapterModel(config, lowLevelApis, entity, model,
                                                               artifacts.getAdapterFetcher()));
                    ModelListOption listOptions = null;
                    if (entity.hasListMethod()) {
                        listOptions = translateListOptions(config, entity, model);
                        artifacts.addModel(listOptions);
                    }
                    final ModelModule module = translateModuleModel(config, lowLevelApis, entity, model,
                                                                    artifacts.getAdapterFetcher(),
                                                                    artifacts.getEndpointsFetcher(),
                                                                    artifacts.getListOptionFetcher());
                    artifacts.addModule(module);
                    final ModelDao dao = translateDao(model, module, entity);
                    artifacts.addModel(dao);
                    factory.addDao(dao);
                    if (entity.hasListMethod()) {
                        final ModelDaoList daoList = translateListDao(model, module, dao, listOptions, entity);
                        artifacts.addModel(daoList);
                        factory.addDao(daoList);
                    }

                }
            }
            factory.generateMethods();
            artifacts.addModel(factory);
        }
        if (definition.hasEnums()) {
            // Order enum is defined globally
            List<Enumerator> enums = definition.getEnums().stream()
                                               .filter(e -> e.hasValues() && !e.getName().contains("order_enum"))
                                               .collect(Collectors.toList());
            for (final Enumerator enumerator : enums) {
                artifacts.addModel(PelionModelDefinitionStore.get().store(translate(config, enumerator)));
            }
        }
        return artifacts;
    }

}
