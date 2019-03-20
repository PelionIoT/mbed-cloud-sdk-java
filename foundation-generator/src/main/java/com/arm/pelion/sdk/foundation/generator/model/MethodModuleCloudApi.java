package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.common.AbstractModule;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.adapters.DataFileAdapter;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;
import com.squareup.javapoet.TypeSpec;

import retrofit2.Call;

public class MethodModuleCloudApi extends MethodOverloaded {
    private static final String PARAMETER_NAME_LOW_LEVEL_DEFAULT = "body";
    protected final Model currentModel;
    protected final ModelAdapterFetcher adapterFetcher;
    protected final String endpointVariableName;
    protected final Renames parameterRenames;
    protected final Method lowLevelMethod;
    protected final ModelEndpoints endpoints;
    protected final Class<?> lowLevelModule;
    protected final List<Parameter> allParameters;
    protected List<Parameter> methodParameters;
    protected final List<Field> necessaryConstants;
    protected final boolean enforceModelValidity;

    public MethodModuleCloudApi(Model currentModel, ModelAdapterFetcher adapterFetcher, String name, String description,
                                String longDescription, boolean needsCustomCode, ModelEndpoints endpoints,
                                String endpointVariableName, Class<?> lowLevelModule, List<Parameter> methodParameters,
                                List<Parameter> allParameters, Renames parameterRenames, Method lowLevelMethod,
                                boolean enforceModelValidity) {
        super(false, name, description, longDescription, false, true, false, false, needsCustomCode, false, false,
              false, null);
        this.currentModel = currentModel;
        this.adapterFetcher = adapterFetcher;
        this.endpointVariableName = endpointVariableName;
        this.lowLevelMethod = lowLevelMethod;
        this.parameterRenames = parameterRenames;
        this.methodParameters = methodParameters;
        this.allParameters = allParameters;
        this.endpoints = endpoints;
        this.lowLevelModule = lowLevelModule;
        necessaryConstants = new LinkedList<>();
        this.enforceModelValidity = enforceModelValidity;
        exceptions.add(MbedCloudException.class);
    }

    public void initialise() {
        initialiseCodeBuilder();
        initialiseParameters();
        determineReturnType(currentModel, lowLevelMethod);
    }

    protected void initialiseParameters() {
        necessaryConstants.clear();
        methodParameters = extendParameterList(methodParameters, allParameters, lowLevelMethod, parameterRenames,
                                               currentModel);

        determineNecessaryConstants(methodParameters);
        determineParameters(methodParameters);
    }

    public List<Parameter> getMethodSignature() {
        return methodParameters;
    }

    public List<Field> getNecessaryConstants() {
        return necessaryConstants;
    }

    private void determineNecessaryConstants(List<Parameter> methodParameters) {
        methodParameters.stream().filter(p -> shouldCheckNull(p))
                        .forEach(p -> necessaryConstants.add(generateConstant(p)));
        if (enforceModelValidity) {
            methodParameters.stream().filter(p -> shouldCheckModelValidity(p))
                            .forEach(p -> necessaryConstants.add(generateConstant(p)));
        }
    }

    private Field generateConstant(Parameter p) {
        return new Field(true, TypeFactory.getCorrespondingType(String.class),
                         Utils.generateConstantName("tag", p.getName()), "Parameter name", null, null, null, null, true,
                         false, true, false, null, false).initialiser("\"" + p.getName() + "\"");
    }

    private void determineParameters(List<Parameter> methodParameters) {
        if (methodParameters == null || methodParameters.isEmpty()) {
            return;
        }
        methodParameters.forEach(p -> addParameter(p));
    }

    protected void determineReturnType(Model correspondingModel, Method lowLevelMethod) {
        // TODO override when "not aggregated method"
        if (lowLevelMethod.hasReturn()) {
            final TypeParameter type = lowLevelMethod.getReturnType();
            if (type.isLowLevelModel() || type.isLowLevelModel()) {
                setReturnType(correspondingModel.toType());
            } else if (!type.isVoid()) {
                setReturnType(type);
            }
        }

    }

    protected List<Parameter> extendParameterList(List<Parameter> methodParameters, List<Parameter> allParameters,
                                                  Method lowLevelMethod, Renames parameterRenames, Model currentModel) {
        final List<Parameter> extendedMethodParameters = new LinkedList<>(methodParameters);
        if (lowLevelMethod.hasParameters()) {
            lowLevelMethod.getParameters().forEach(p -> {
                final String parameterName = parameterRenames.containsMappingFor(p.getName()) ? parameterRenames.getRenamedField(p.getName())
                                                                                              : p.getName();
                if (!doesParameterExist(extendedMethodParameters, parameterName)) {
                    if (p.getType().isLowLevelModel() || shouldCheckModelValidity(p)) {
                        final Parameter modelParam = currentModel.toParameter(PARAMETER_NAME_LOW_LEVEL_DEFAULT.equals(parameterName.toLowerCase()) ? null
                                                                                                                                                   : parameterName)
                                                                 .setAsNonNull(true);
                        modelParam.setName(ensureParameterNameUniqueness(extendedMethodParameters,
                                                                         modelParam.getName()));
                        parameterRenames.addEntry(parameterName, modelParam.getName());
                        extendedMethodParameters.add(modelParam);
                    } else {
                        final Parameter newP = allParameters.stream()
                                                            .filter(arg -> parameterName.equals(arg.getIdentifier()))
                                                            .findFirst().orElse(p.clone());
                        newP.setAsNullable(!newP.isSetAsNonNull()).setName(parameterName);
                        if (isLowLevelDateType(newP.getType())) {
                            newP.setType(TypeFactory.dateType());
                        }
                        extendedMethodParameters.add(newP);
                    }
                }
            });
        }
        return extendedMethodParameters;
    }

    private static boolean isLowLevelDateType(TypeParameter type) {
        return type.isJodaDate() || type.isJodaTime();
    }

    protected static boolean doesParameterExist(List<Parameter> extendedMethodParameters, final String parameterName) {
        return extendedMethodParameters.stream().anyMatch(arg -> parameterName.equals(arg.getIdentifier()));
    }

    private String ensureParameterNameUniqueness(List<Parameter> extendedMethodParameters, String name) {
        final AtomicInteger count = new AtomicInteger(0);
        String newName = name;
        while (doesParameterExist(extendedMethodParameters, newName)) {
            newName = name + String.valueOf(count.incrementAndGet());
        }
        return newName;
    }

    @Override
    protected void addAnnotations() {
        super.addAnnotations();
        specificationBuilder.addAnnotation(API.class);
        if (hasReturn()) {
            specificationBuilder.addAnnotation(Nullable.class);
        }
    }

    @Override
    protected void translateCode() throws TranslationException {
        super.translateCode();
        generateParameterChecks();
        if (mustParametersBeFinal()) {
            generateVariableInitialisation(methodParameters);
        }
        generateMethodCode();
    }

    protected void generateMethodCode() throws TranslationException {
        code.addStatement((hasReturn() ? "return " : "") + "$T.$L(this, $S,"
                          + (hasReturn() ? "$T." + getMappingMethod() + "()" : "$L") + ",$L )", CloudCaller.class,
                          CloudCaller.METHOD_CALL_CLOUD_API, name + "()", hasReturn() ? getReturnAdapter() : "null",
                          generateCloudCallCode());
    }

    protected Object getReturnAdapter() throws TranslationException {
        return getAdapter(currentModel);
    }

    protected boolean mustParametersBeFinal() {
        return true;
    }

    protected void generateVariableInitialisation(List<Parameter> methodParameters) throws TranslationException {
        if (methodParameters == null || methodParameters.isEmpty()) {
            return;
        }
        for (Parameter p : methodParameters) {
            generateParameterInitialisation(p);
        }
    }

    protected void generateParameterInitialisation(Parameter p) throws TranslationException {
        if (p == null) {
            return;
        }
        TypeParameter type = p.getType();
        type.translate();
        code.addStatement("final $T $L = $L", type.hasClass() ? type.getClazz() : type.getTypeName(),
                          generateFinalVariable(p.getName()), p.getName());
    }

    protected String generateFinalVariable(String variableName) {
        return Utils.combineNames(false, mustParametersBeFinal() ? "final" : "", variableName);
    }

    protected String getMappingMethod() {
        return ModelAdapter.FUNCTION_NAME_GET_MAPPER;
    }

    private void generateParameterChecks() {
        methodParameters.stream().filter(p -> shouldCheckNull(p))
                        .forEach(p -> code.addStatement("$L($L,$L)", AbstractModule.METHOD_CHECK_NOT_NULL, p.getName(),
                                                        Utils.generateConstantName("tag", p.getName())));
        if (enforceModelValidity) {
            methodParameters.stream().filter(p -> shouldCheckModelValidity(p))
                            .forEach(p -> code.addStatement("$L($L,$L)", AbstractModule.METHOD_CHECK_MODEL_VALIDITY,
                                                            p.getName(),
                                                            Utils.generateConstantName("tag", p.getName())));
        }
    }

    protected boolean shouldCheckModelValidity(Parameter p) {
        return p != null && p.getType().isModel();
    }

    private boolean shouldCheckNull(Parameter p) {
        return p != null && p.isSetAsNonNull();
    }

    private Object generateCloudCallCode() throws TranslationException {
        final TypeSpec.Builder cloudCall = TypeSpec.anonymousClassBuilder("");
        final TypeParameter cloudCallType = TypeFactory.getCorrespondingType(CloudCall.class,
                                                                             lowLevelMethod.getReturnType());
        cloudCallType.translate();
        if (cloudCallType.hasClass()) {
            cloudCall.addSuperinterface(cloudCallType.getClazz());
        } else {
            cloudCall.addSuperinterface(cloudCallType.getTypeName());
        }
        for (java.lang.reflect.Method m : Arrays.asList(CloudCall.class.getDeclaredMethods())) {
            // Use for loop for exception reason
            final Method method = new Method(m, "Makes the low level call to the Cloud", null, true, true);
            method.setAbstract(false);
            method.setReturnType(TypeFactory.getCorrespondingType(Call.class, lowLevelMethod.getReturnType()));
            method.setReturnDescription("Corresponding Retrofit2 Call object");
            method.initialiseCodeBuilder();
            generateLowLevelCallCode(endpointVariableName, endpoints, lowLevelModule, method, lowLevelMethod,
                                     parameterRenames);
            method.translate();
            cloudCall.addMethod(method.getSpecificationBuilder().build());

        }

        return cloudCall.build();

    }

    private List<Parameter> determineUnusedParameters(List<Parameter> lowLevelParameters, Renames parameterRenames) {
        // According to the specification, there can be only one body parameter:
        // https://swagger.io/docs/specification/2-0/describing-request-body/. Thus, it is assumed that all unused
        // parameters are fields of the body parameter.

        final List<Parameter> unusedParameters = new LinkedList<>();
        methodParameters.forEach(p -> unusedParameters.add(p.clone()));
        if (lowLevelParameters != null) {
            lowLevelParameters.forEach(p -> {
                final String parameterName = parameterRenames.containsMappingFor(p.getIdentifier()) ? parameterRenames.getRenamedField(p.getIdentifier())
                                                                                                    : p.getName();

                if (doesParameterExist(methodParameters, parameterName)) {
                    unusedParameters.removeIf(param -> parameterName.equals(param.getIdentifier()));
                }
            });
        }
        return unusedParameters;
    }

    private void generateLowLevelCallCode(String endpointVariableName, ModelEndpoints endpoints,
                                          Class<?> lowLevelModule, Method callMethod, Method lowLevelMethod,
                                          Renames parameterRenames) throws TranslationException {
        final List<Object> callElements = new LinkedList<>(Arrays.asList(endpointVariableName));
        StringBuilder builder = new StringBuilder();
        builder.append("return $L");
        if (endpoints == null || lowLevelModule == null) {
            throw new TranslationException("Could not find the endpoint module to use while translating " + this);
        }
        Field moduleField = ModelEndpoints.generateCorrespondingField(lowLevelModule);
        if (!endpoints.hasField(moduleField)) {
            throw new TranslationException("Could not find module field [" + moduleField + "] in endpoints "
                                           + endpoints);
        }
        builder.append(".$L()");
        callElements.add(MethodGetter.generateGetterName(moduleField));
        builder.append(".$L(");
        callElements.add(lowLevelMethod.getName());
        boolean start = true;
        if (lowLevelMethod.hasParameters()) {
            final List<Parameter> unusedParameters = determineUnusedParameters(lowLevelMethod.getParameters(),
                                                                               parameterRenames);
            for (Parameter p : lowLevelMethod.getParameters()) {
                if (!start) {
                    builder.append(", ");
                } else {
                    start = false;
                }
                final String parameterName = parameterRenames.containsMappingFor(p.getIdentifier()) ? parameterRenames.getRenamedField(p.getIdentifier())
                                                                                                    : p.getName();
                String variableName = parameterName;
                boolean isExternalParameter = false;
                if (doesParameterExist(methodParameters, parameterName)) {
                    variableName = generateFinalVariable(parameterName);
                    isExternalParameter = true;
                }
                translateParameter(variableName, parameterName, p.getType(), builder, callElements, isExternalParameter,
                                   unusedParameters);
            }
        }
        builder.append(")");
        callMethod.getCode().addStatement(builder.toString(), callElements.toArray());
    }

    protected void translateParameter(String parameterName, String initialParameterName, TypeParameter type,
                                      StringBuilder builder, List<Object> callElements, boolean isExternalParameter,
                                      List<Parameter> unusedParameters) throws TranslationException {

        if (isExternalParameter) {
            if (MethodMapper.isLowLevelType(type)) {
                builder.append("$T.$L(");
                // TODO extend the list below if necessary
                if (type.isFormPart()) {
                    builder.append("$S, ");
                    callElements.add(DataFileAdapter.class);
                    callElements.add(DataFileAdapter.METHOD_REVERSE_MAP);
                    // Forcing the form part to be named as the parameter name in snake case.
                    callElements.add(ApiUtils.convertCamelToSnake(initialParameterName));
                }
                if (type.isJodaDate()) {
                    callElements.add(TranslationUtils.class);
                    callElements.add(TranslationUtils.METHOD_CONVERT_DATE_TO_LOCALDATE);
                }
                if (type.isJodaTime()) {
                    callElements.add(TranslationUtils.class);
                    callElements.add(TranslationUtils.METHOD_CONVERT_DATE_TO_DATETIME);
                }
                builder.append("$L)");
            } else {
                builder.append("$L");
            }
            callElements.add(parameterName);
            if (type.isLowLevelModel() && !unusedParameters.isEmpty()) {
                addUnusedParametersToBodyParameter(unusedParameters, builder, callElements);
            }
        } else {
            builder.append("$L");
            callElements.add("null");
        }
    }

    protected void addUnusedParametersToBodyParameter(List<Parameter> unusedParameters, StringBuilder builder,
                                                      List<Object> callElements) {
        // If body parameter
        for (Parameter p : unusedParameters) {
            builder.append(".$L($L)");
            callElements.add(MethodSetter.getCorrespondingSetterMethodName(p.getName(), true));
            callElements.add(generateFinalVariable(p.getName()));
        }
        unusedParameters.clear();
    }

    protected Object getAdapter(Model model) throws TranslationException {
        final ModelAdapter adapter = adapterFetcher.fetchAdapter(model.getIdentifier());
        TypeParameter type = adapter == null ? null : adapter.toType();
        if (type == null) {
            return null;
        }
        type.translate();
        return type.hasClass() ? type.getClazz() : type.getTypeName();
    }

    @Override
    public String toString() {
        return "MethodModuleCloudApi [Method=" + super.toString() + ", currentModel=" + currentModel + "]";
    }

    public boolean hasSameSignature(MethodModuleCloudApi otherMethod) {
        otherMethod.generateSuffix();
        generateSuffix();
        if (getIdentifier().equals(otherMethod.getIdentifier())) {
            return true;
        }
        if (getMethodSignature() == null) {
            return otherMethod.getMethodSignature() == null;
        }
        if (getMethodSignature().equals(otherMethod.getMethodSignature())) {
            return true;
        }
        if (getMethodSignature().size() != otherMethod.getMethodSignature().size()) {
            return false;
        }
        // Checking if the parameters are in a different order although this is not perfect.
        for (Parameter p : getMethodSignature()) {
            if (!otherMethod.getMethodSignature().stream().anyMatch(arg -> {
                return arg.equals(p) && arg.getType().equals(p.getType());
            })) {
                return false;
            }
        }
        return true;
    }
}
