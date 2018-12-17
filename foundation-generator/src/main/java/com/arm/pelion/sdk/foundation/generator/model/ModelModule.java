package com.arm.pelion.sdk.foundation.generator.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.AbstractModule;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.squareup.javapoet.AnnotationSpec;

public class ModelModule extends ModelMergeable {

    public static final String ENDPOINTS_FIELD_NAME = "endpoints";
    private final ModelEndpointsFetcher endpointFetcher;
    private final ModelListOptionFetcher listOptionFetcher;
    private final ModelAdapterFetcher adapterFetcher;
    private final Map<String, CloudCall> cloudCalls;

    public ModelModule(Model model, String packageName, String description, ModelEndpointsFetcher endpointFetcher,
                       ModelListOptionFetcher listOptionFetcher, ModelAdapterFetcher adapterFetcher) {
        super(packageName, generateName(model.getGroup()), model.getGroup(),
              generateDescription(model.getGroup(), description),
              generateLongDescription(model.getGroup(), description), false, true);
        setSuperClassType(TypeFactory.getCorrespondingType(AbstractModule.class));
        this.endpointFetcher = endpointFetcher;
        this.listOptionFetcher = listOptionFetcher;
        this.adapterFetcher = adapterFetcher;
        cloudCalls = new LinkedHashMap<>();
        addEndpointField();
    }

    private void addEndpointField() {
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
                                     + ApiUtils.convertCamelToSnake(group).replace("_", " ")
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
    protected void generateHashCodeAndEquals() {
        // Do not generate anything
    }

    @Override
    protected void generateMethodsDependingOnParents(Model theParent) {
        addConstructor(new MethodModuleConstructorFromConnectionOptions(this, theParent));
        addConstructor(new MethodModuleConstructorFromClient(this, theParent));
        addConstructor(new MethodModuleConstructorFromSdkContext(this, theParent));
    }

    @Override
    protected void generateOtherMethods() {
        super.generateOtherMethods();
        cloudCalls.values().forEach(c -> c.addMethod(this));
    }

    @Override
    public boolean hasMethod(String identifier) {
        return super.hasMethod(MethodModuleFromEntity.generateIdentifier(identifier)) || super.hasMethod(identifier);
    }

    @Override
    public Method fetchMethod(String identifier) {
        final Method overloadingMethod = super.fetchMethod(MethodModuleFromEntity.generateIdentifier(identifier));
        return overloadingMethod == null ? super.fetchMethod(identifier) : overloadingMethod;
    }

    public void addCloudCall(CloudCall call) {
        if (call != null) {
            call.setEndpoints(endpointFetcher.fetch(getGroup()));
            cloudCalls.put(call.getIdentifier(), call);
        }
    }

    public static class CloudCall {
        private final MethodAction action;
        private final String methodName;
        private final Model currentModel;
        private final boolean isCustom;
        private final boolean isPaginated;
        private final String description;
        private final String longDescription;
        private final List<Parameter> methodParameters;
        private final List<Parameter> allParameters;
        private final Method lowLevelMethod;
        private final Renames parameterRenames;
        private final Class<?> lowLevelModule;
        private ModelEndpoints endpoints;

        public CloudCall(MethodAction action, String methodName, String description, String longDescription,
                         Model currentModel, boolean custom, boolean isPaginated, List<Parameter> externalParameters,
                         List<Parameter> allParameters, Renames parameterRenames, Method lowLevelMethod,
                         Class<?> lowLevelModule) {
            super();
            this.action = action;
            this.methodName = methodName;
            this.currentModel = currentModel;
            this.isCustom = custom;
            this.description = description;
            this.longDescription = longDescription;
            this.isPaginated = isPaginated;
            this.lowLevelMethod = lowLevelMethod;
            this.parameterRenames = parameterRenames;
            this.methodParameters = externalParameters;
            this.allParameters = allParameters;
            this.lowLevelModule = lowLevelModule;
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

        public void addMethod(ModelModule module) {

            MethodModuleCloudApi method = null;
            switch (action) {

                case DELETE:
                case OTHER:
                case READ:
                    method = new MethodModuleCloudApi(currentModel, module.adapterFetcher, methodName, description,
                                                      longDescription, isCustom, endpoints, ENDPOINTS_FIELD_NAME,
                                                      lowLevelModule, methodParameters, allParameters, parameterRenames,
                                                      lowLevelMethod, true);
                    break;
                case CREATE:
                case UPDATE:
                    method = new MethodModuleModifyApi(action == MethodAction.CREATE, currentModel,
                                                       module.adapterFetcher, methodName, description, longDescription,
                                                       isCustom, endpoints, ENDPOINTS_FIELD_NAME, lowLevelModule,
                                                       methodParameters, allParameters, parameterRenames,
                                                       lowLevelMethod, true);
                    break;
                case LIST:
                    method = new MethodModuleListApi(currentModel, methodName, description, longDescription, isCustom,
                                                     isPaginated, module.listOptionFetcher, module.adapterFetcher,
                                                     endpoints, ENDPOINTS_FIELD_NAME, lowLevelModule, methodParameters,
                                                     allParameters, parameterRenames, lowLevelMethod, true);
                    break;
                default:
                    break;

            }
            method.initialise();
            addMethod(module, method);
            MethodModuleCloudApi overloadedMethod = null;
            switch (action) {

                case DELETE:
                case OTHER:
                case READ:
                    overloadedMethod = new MethodModuleFromEntity(method, methodParameters, false);
                    break;
                case CREATE:
                case UPDATE:
                    overloadedMethod = new MethodModuleFromEntity(method, methodParameters, true);
                    break;
                case LIST:
                    overloadedMethod = new MethodModulePaginationApi((MethodModuleListApi) method, isCustom);
                    break;
                default:
                    break;

            }
            overloadedMethod.initialise();
            if (action == MethodAction.LIST || haveDifferentSignatures(method, overloadedMethod)) {
                addMethod(module, overloadedMethod);
            }

        }

        public void addMethod(ModelModule module, MethodModuleCloudApi method) {

            module.addFields(method.getNecessaryConstants());
            module.addMethod(method);
        }

        private boolean haveDifferentSignatures(MethodModuleCloudApi method, MethodModuleCloudApi overloadedMethod) {
            if (method.getMethodSignature() == null) {
                return overloadedMethod.getMethodSignature() != null;
            }
            if (method.getMethodSignature().equals(overloadedMethod.getMethodSignature())) {
                return false;
            }
            for (Parameter p : method.getMethodSignature()) {
                if (!overloadedMethod.getMethodSignature().stream().anyMatch(arg -> {
                    return arg.equals(p) && arg.getType().equals(p.getType());
                })) {
                    return true;
                }
            }
            return false;
        }

    }

}
