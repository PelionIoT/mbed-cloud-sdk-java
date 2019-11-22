package com.arm.pelion.sdk.foundation.generator.model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.AbstractModule;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;
import com.squareup.javapoet.AnnotationSpec;

public class ModelModule extends ModelMergeable {

    public static final String ENDPOINTS_FIELD_NAME = "endpoints";
    private final ModelEndpointsFetcher endpointFetcher;
    private final ModelListOptionFetcher listOptionFetcher;
    private final ModelAdapterFetcher adapterFetcher;
    private final Map<String, CloudCall> cloudCalls;
    private final MethodRegistry registry;

    public ModelModule(Model model, String packageName, String description, ModelEndpointsFetcher endpointFetcher,
                       ModelListOptionFetcher listOptionFetcher, ModelAdapterFetcher adapterFetcher) {
        this(model.getGroup(), packageName, description, endpointFetcher, listOptionFetcher, adapterFetcher);
    }

    protected ModelModule(String group, String packageName, String description, ModelEndpointsFetcher endpointFetcher,
                          ModelListOptionFetcher listOptionFetcher, ModelAdapterFetcher adapterFetcher) {
        super(packageName, generateName(group), group, generateDescription(group, description),
              generateLongDescription(group, description), false, true);
        setSuperClassType(TypeFactory.getCorrespondingType(AbstractModule.class));
        this.endpointFetcher = endpointFetcher;
        this.listOptionFetcher = listOptionFetcher;
        this.adapterFetcher = adapterFetcher;
        cloudCalls = new LinkedHashMap<>();
        addEndpointField();
        registry = new MethodRegistry();
        setShouldBeSorted(true);
        setIgnoreLiteralDuplicate(true);
    }

    private void addEndpointField() {
        if (endpointFetcher == null) {
            return;
        }
        final ModelEndpoints endpoints = endpointFetcher.fetch(getGroup());
        if (endpoints == null) {
            return;
        }
        addField(new Field(true, endpoints.toType(), ENDPOINTS_FIELD_NAME, "module endpoints", null, null, false, false,
                           true, false, null, false));

    }

    @Override
    protected void translateFields() throws TranslationException {
        addEndpointField();
        super.translateFields();
    }

    private static String generateDescription(String group, String description) {
        return description == null ? "Specifies " + group + " APIs" : description;
    }

    private static String generateLongDescription(String group, String description) {
        return description == null ? " API definitions exposing functionality for dealing with "
                                     + Utils.generateDocumentationString(group, true)
                                   : description;
    }

    @Override
    public void generateAnnotations() {
        super.generateAnnotations();
        specificationBuilder.addAnnotation(AnnotationSpec.builder(com.arm.mbed.cloud.sdk.annotations.Module.class)
                                                         .build());
    }

    private static String generateName(String group) {
        return ApiUtils.convertSnakeToCamel(ApiUtils.convertCamelToSnake(group), true);
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
    protected void generateHashCodeAndEquals(Model theParent) {
        // Do not generate anything
    }

    @Override
    protected void generateMethodsDependingOnParents(Model theParent) {
        addConstructor(new MethodModuleConstructorFromConnectionOptions(this, theParent));
        addConstructor(new MethodModuleConstructorFromClient(this, theParent));
        addConstructor(new MethodModuleConstructorFromSdkContext(this, theParent));
        generateClone(theParent);
    }

    @Override
    protected void generateOtherMethods() {
        super.generateOtherMethods();
        cloudCalls.values().forEach(c -> c.addMethod(this));
        generateGetModuleName();
    }

    private void generateGetModuleName() {
        Method method = new Method(false, AbstractModule.METHOD_GET_MODULE_NAME, "Gets module name", null, false, true,
                                   false, false, false, true, false, true);
        method.setReturnType(TypeFactory.stringType());
        method.setReturnDescription("module name");
        method.initialiseCodeBuilder();
        method.getCode().addStatement("return $S",
                                      ApiUtils.convertSnakeToCamel(Utils.generateModelNameAsText(getName()), true));
        addMethod(method);

    }

    public void addCloudCall(CloudCall call) {
        if (call != null) {
            call.setEndpoints(endpointFetcher.fetch(getGroup()));
            cloudCalls.put(call.getIdentifier(), call);
        }
    }

    public void registerMethod(Model model, MethodAction action, Method method) {
        if (model == null || action == null || method == null) {
            return;
        }
        registry.add(model, action, method);
    }

    public boolean hasMethods(Model model, MethodAction action) {
        if (model == null || action == null) {
            return false;
        }
        return registry.has(model, action);
    }

    public boolean hasMethod(Model model, MethodAction action, String methodName) {
        if (model == null || action == null || methodName == null) {
            return false;
        }
        return registry.has(model, action, methodName);
    }

    public boolean hasMethods(Model model) {
        if (model == null) {
            return false;
        }
        return registry.has(model);
    }

    public List<Method> getAllMethods(Model model, MethodAction action) {
        if (model == null || action == null) {
            return null;
        }
        return registry.get(model, action);
    }

    public List<Method> getAllMethods(Model model, MethodAction action, String methodName) {
        if (model == null || action == null || methodName == null) {
            return null;
        }
        return registry.get(model, action, methodName);
    }

    @Override
    protected Model generateEmptyChildModel() {
        final ModelModule model = new ModelModule(group, packageName, description, endpointFetcher, listOptionFetcher,
                                                  adapterFetcher);
        model.setContainsCustomCode(true);
        return model;
    }

    @Override
    protected Model generateEmptyAbstractModel() {
        final ModelModule model = new ModelModule(group, packageName, null, endpointFetcher, listOptionFetcher,
                                                  adapterFetcher);
        model.setAbstract(true);
        return model;
    }

    public static class CloudCall {
        private final MethodAction action;
        private final String methodName;
        private final Model currentModel;
        private final Model returnModel;
        private final boolean isCustom;
        private final boolean isPaginated;
        private final boolean containsOnlyExternalParameters;
        private final String description;
        private final String longDescription;
        private final List<Parameter> methodParameters;
        private final List<Parameter> allParameters;
        private final Method lowLevelMethod;
        private final Renames parameterRenames;
        private final Class<?> lowLevelModule;
        private Deprecation deprecation;
        private ModelEndpoints endpoints;
        private boolean internal;

        public CloudCall(MethodAction action, String methodName, String description, String longDescription,
                         Model currentModel, Model returnModel, boolean custom, boolean isPaginated,
                         List<Parameter> externalParameters, List<Parameter> allParameters,
                         boolean containsOnlyExternalParameters, Renames parameterRenames, Method lowLevelMethod,
                         Class<?> lowLevelModule, boolean internal) {
            super();
            this.action = action;
            this.methodName = methodName;
            this.currentModel = currentModel;
            this.returnModel = returnModel;
            this.isCustom = custom;
            this.description = description;
            this.longDescription = longDescription;
            this.isPaginated = isPaginated;
            this.lowLevelMethod = lowLevelMethod;
            this.parameterRenames = parameterRenames;
            this.methodParameters = externalParameters;
            this.allParameters = allParameters;
            this.lowLevelModule = lowLevelModule;
            this.internal = internal;
            this.containsOnlyExternalParameters = containsOnlyExternalParameters;
            deprecation = null;
        }

        public ModelEndpoints getEndpoints() {
            return endpoints;
        }

        public void setEndpoints(ModelEndpoints endpoints) {
            this.endpoints = endpoints;
        }

        public String getIdentifier() {
            return methodName;
        }

        public Deprecation getDeprecation() {
            return deprecation;
        }

        public void setDeprecation(Deprecation deprecation) {
            this.deprecation = deprecation;
        }

        public boolean hasDeprecation() {
            return deprecation != null;

        }

        public void addMethod(ModelModule module) {

            final Model currentModelToConsider = FetchUtils.getLatestModelDefinition(currentModel,
                                                                                     module.adapterFetcher);
            final Model returnModelToConsider = FetchUtils.getLatestModelDefinition(returnModel, module.adapterFetcher);
            MethodModuleCloudApi method = null;
            switch (action) {

                case DELETE:
                case ME:
                case READ:
                    method = returnModelToConsider == null ? new MethodModuleCloudApi(currentModelToConsider,
                                                                                      module.adapterFetcher, methodName,
                                                                                      description, longDescription,
                                                                                      isCustom, endpoints,
                                                                                      ENDPOINTS_FIELD_NAME,
                                                                                      lowLevelModule, methodParameters,
                                                                                      allParameters, parameterRenames,
                                                                                      lowLevelMethod, true)
                                                           : new MethodModuleCloudApiUnself(currentModelToConsider,
                                                                                            returnModelToConsider,
                                                                                            module.adapterFetcher,
                                                                                            methodName, description,
                                                                                            longDescription, isCustom,
                                                                                            endpoints,
                                                                                            ENDPOINTS_FIELD_NAME,
                                                                                            lowLevelModule,
                                                                                            methodParameters,
                                                                                            allParameters,
                                                                                            parameterRenames,
                                                                                            lowLevelMethod, true);
                    break;
                case OTHER:
                    method = returnModelToConsider == null ? new MethodModuleOtherApi(currentModelToConsider,
                                                                                      module.adapterFetcher, methodName,
                                                                                      description, longDescription,
                                                                                      isCustom, endpoints,
                                                                                      ENDPOINTS_FIELD_NAME,
                                                                                      lowLevelModule, methodParameters,
                                                                                      allParameters, parameterRenames,
                                                                                      lowLevelMethod, true)
                                                           : new MethodModuleOtherApiUnself(currentModelToConsider,
                                                                                            returnModelToConsider,
                                                                                            module.adapterFetcher,
                                                                                            methodName, description,
                                                                                            longDescription, isCustom,
                                                                                            endpoints,
                                                                                            ENDPOINTS_FIELD_NAME,
                                                                                            lowLevelModule,
                                                                                            methodParameters,
                                                                                            allParameters,
                                                                                            parameterRenames,
                                                                                            lowLevelMethod, true);
                    break;
                case CREATE:
                case UPDATE:
                    method = returnModelToConsider == null ? new MethodModuleModifyApi(action == MethodAction.CREATE,
                                                                                       currentModelToConsider,
                                                                                       module.adapterFetcher,
                                                                                       methodName, description,
                                                                                       longDescription, isCustom,
                                                                                       endpoints, ENDPOINTS_FIELD_NAME,
                                                                                       lowLevelModule, methodParameters,
                                                                                       allParameters, parameterRenames,
                                                                                       lowLevelMethod, true)
                                                           : new MethodModuleModifyApiUnself(action == MethodAction.CREATE,
                                                                                             currentModelToConsider,
                                                                                             returnModelToConsider,
                                                                                             module.adapterFetcher,
                                                                                             methodName, description,
                                                                                             longDescription, isCustom,
                                                                                             endpoints,
                                                                                             ENDPOINTS_FIELD_NAME,
                                                                                             lowLevelModule,
                                                                                             methodParameters,
                                                                                             allParameters,
                                                                                             parameterRenames,
                                                                                             lowLevelMethod, true);
                    break;
                case LIST_OTHER:
                case LIST:
                    method = returnModelToConsider == null ? new MethodModuleListApi(currentModelToConsider, methodName,
                                                                                     description, longDescription,
                                                                                     isCustom, isPaginated,
                                                                                     module.listOptionFetcher,
                                                                                     module.adapterFetcher, endpoints,
                                                                                     ENDPOINTS_FIELD_NAME,
                                                                                     lowLevelModule, methodParameters,
                                                                                     allParameters, parameterRenames,
                                                                                     lowLevelMethod, true)
                                                           : new MethodModuleListApiUnself(currentModelToConsider,
                                                                                           returnModelToConsider,
                                                                                           methodName, description,
                                                                                           longDescription, isCustom,
                                                                                           isPaginated,
                                                                                           module.listOptionFetcher,
                                                                                           module.adapterFetcher,
                                                                                           endpoints,
                                                                                           ENDPOINTS_FIELD_NAME,
                                                                                           lowLevelModule,
                                                                                           methodParameters,
                                                                                           allParameters,
                                                                                           parameterRenames,
                                                                                           lowLevelMethod, true);
                    break;
                default:
                    break;

            }
            switch (action) {
                case DELETE:
                case LIST:
                case LIST_OTHER:
                case PAGINATION:
                case PAGINATION_OTHER:
                case READ:
                    if (method != null) {
                        method.ignore404();
                    }
                    break;
                default:
                    break;

            }
            method.initialise();
            addMethod(module, method, null);
            MethodModuleDefault defaultMethod = new MethodModuleDefault(method);
            defaultMethod.initialise();
            // defaultMethod.generateSuffix();
            // method.generateSuffix();
            if (haveDifferentSignatures(defaultMethod, method)) {
                addMethod(module, defaultMethod, null);
            }
            if (containsOnlyExternalParameters && !action.isAboutListing()) {
                return;
            }
            MethodModuleCloudApi overloadedMethod = null;
            switch (action) {

                case DELETE:
                case OTHER:
                case READ:
                case ME:
                    overloadedMethod = returnModelToConsider == null ? new MethodModuleFromEntity(method,
                                                                                                  methodParameters,
                                                                                                  false)
                                                                     : new MethodModuleFromEntityUnself((MethodModuleCloudApiUnself) method,
                                                                                                        methodParameters,
                                                                                                        false);
                    break;
                case CREATE:
                case UPDATE:
                    overloadedMethod = returnModelToConsider == null ? new MethodModuleFromEntity(method,
                                                                                                  methodParameters,
                                                                                                  true)
                                                                     : new MethodModuleFromEntityUnself((MethodModuleCloudApiUnself) method,
                                                                                                        methodParameters,
                                                                                                        true);
                    break;
                case LIST:
                case LIST_OTHER:
                    overloadedMethod = returnModelToConsider == null ? new MethodModulePaginationApi((MethodModuleListApi) method,
                                                                                                     isCustom)
                                                                     : new MethodModulePaginationApiUnself((MethodModuleListApiUnself) method,
                                                                                                           isCustom);
                    break;
                default:
                    break;

            }
            overloadedMethod.initialise();
            if (action.isAboutListing() || haveDifferentSignatures(method, overloadedMethod)) {
                MethodAction overridingAction = action == MethodAction.LIST ? MethodAction.PAGINATION
                                                                            : action == MethodAction.LIST_OTHER ? MethodAction.PAGINATION_OTHER
                                                                                                                : null;
                addMethod(module, overloadedMethod, overridingAction);

                MethodModuleDefault defaultMethod1 = new MethodModuleDefault(overloadedMethod);
                defaultMethod1.initialise();
                if (haveDifferentSignatures(defaultMethod1, overloadedMethod)) {
                    addMethod(module, defaultMethod1, overridingAction);
                }

            }
            if (action == MethodAction.LIST_OTHER) {
                MethodModuleFromEntityUnselfList overloadedMethod2 = new MethodModuleFromEntityUnselfList((MethodModuleCloudApiUnself) method,
                                                                                                          methodParameters,
                                                                                                          true,
                                                                                                          isPaginated,
                                                                                                          module.listOptionFetcher);
                overloadedMethod2.initialise();
                if (haveDifferentSignatures(method, overloadedMethod2)) {
                    addMethod(module, overloadedMethod2, MethodAction.LIST_OTHER);
                }
                MethodModuleDefault defaultMethod1 = new MethodModuleDefault(overloadedMethod2);
                defaultMethod1.initialise();
                if (haveDifferentSignatures(defaultMethod1, overloadedMethod2)) {
                    addMethod(module, defaultMethod1, MethodAction.LIST_OTHER);
                }

                MethodModuleCloudApi overloadedMethod3 = new MethodModuleFromEntityUnselfPagination(overloadedMethod2,
                                                                                                    isCustom);
                overloadedMethod3.initialise();
                if (haveDifferentSignatures(overloadedMethod, overloadedMethod3)) {
                    addMethod(module, overloadedMethod3, MethodAction.PAGINATION_OTHER);
                }

                MethodModuleDefault defaultMethod2 = new MethodModuleDefault(overloadedMethod3);
                defaultMethod2.initialise();
                if (haveDifferentSignatures(defaultMethod2, overloadedMethod3)) {
                    addMethod(module, defaultMethod2, MethodAction.PAGINATION_OTHER);
                }
            }

        }

        private void addMethod(ModelModule module, MethodModuleCloudApi method, MethodAction overridingAction) {
            method.setDeprecation(deprecation);
            method.setInternal(internal);
            module.addConstants(method.getNecessaryConstants());
            module.addMethod(method);
            module.registerMethod(currentModel, overridingAction == null ? action : overridingAction, method);
        }

        private boolean haveDifferentSignatures(MethodModuleCloudApi method, MethodModuleCloudApi overloadedMethod) {
            return !method.hasSameSignature(overloadedMethod);
        }

    }

    private class MethodRegistry {
        final Map<String, ModelMethodRegistry> store;

        public MethodRegistry() {
            super();
            store = new LinkedHashMap<>();
        }

        public void add(String modelId, MethodAction action, Method method) {
            ModelMethodRegistry registry = get(modelId);
            if (registry == null) {
                registry = new ModelMethodRegistry();
            }
            registry.add(action, method);
            store.put(modelId, registry);
        }

        public void add(Model model, MethodAction action, Method method) {
            add(model.getIdentifier(), action, method);
        }

        public boolean has(Model model, MethodAction action, String methodName) {
            if (!has(model, action) || methodName == null) {
                return false;
            }
            return get(model).has(action, methodName);
        }

        public boolean has(String modelId) {
            return store.containsKey(modelId);
        }

        public boolean has(Model model) {
            return has(model.getIdentifier());
        }

        public boolean has(String modelId, MethodAction action) {
            return has(modelId) ? get(modelId).has(action) : false;
        }

        public boolean has(Model model, MethodAction action) {
            return has(model.getIdentifier(), action);
        }

        public ModelMethodRegistry get(Model model) {
            return store.get(model.getIdentifier());
        }

        public ModelMethodRegistry get(String modelId) {
            return store.get(modelId);
        }

        public List<Method> get(String modelId, MethodAction action) {
            if (!has(modelId)) {
                return null;
            }
            return get(modelId).get(action);
        }

        public List<Method> get(Model model, MethodAction action) {
            return get(model.getIdentifier(), action);
        }

        public List<Method> get(String modelId, MethodAction action, String methodName) {
            if (!has(modelId)) {
                return null;
            }
            return get(modelId).get(action, methodName);
        }

        public List<Method> get(Model model, MethodAction action, String methodName) {
            return get(model.getIdentifier(), action, methodName);
        }
    }

    private class ModelMethodRegistry {
        final Map<MethodAction, List<Method>> store;

        public ModelMethodRegistry() {
            super();
            store = new LinkedHashMap<>();
        }

        public void add(MethodAction action, Method method) {
            List<Method> methods = store.get(action);
            if (methods == null) {
                methods = new LinkedList<>();
            }
            methods.add(method);
            store.put(action, methods);
        }

        public boolean has(MethodAction action, String methodName) {
            if (!has(action) || methodName == null) {
                return false;
            }
            return get(action).stream().anyMatch(m -> methodName.equals(m.getName()));
        }

        public List<Method> get(MethodAction action, String methodName) {
            final List<Method> allMethods = get(action);
            if (allMethods == null) {
                return null;
            }
            return allMethods.stream().filter(m -> methodName.equals(m.getName())).collect(Collectors.toList());
        }

        public boolean has(MethodAction action) {
            return store.containsKey(action);
        }

        public List<Method> get(MethodAction action) {
            return store.get(action);
        }

    }

}
