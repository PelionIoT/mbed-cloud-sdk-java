package com.arm.pelion.sdk.foundation.generator.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodModuleListApi extends MethodModuleCloudApi {
    protected static final String PARAMETER_NAME_OPTIONS = "options";
    private final boolean isPaginatedList;
    protected final ModelListOptionFetcher fetcher;

    public MethodModuleListApi(Model currentModel, String name, String description, String longDescription,
                               boolean needsCustomCode, boolean isPaginatedList,
                               ModelListOptionFetcher listOptionsFetcher, ModelAdapterFetcher adapterFetcher,
                               ModelEndpoints endpoints, String endpointVariableName, Class<?> lowLevelModule,
                               List<Parameter> methodParameters, List<Parameter> allParameters,
                               Renames parameterRenames, Method lowLevelMethod, boolean enforceModelValidity) {
        super(currentModel, adapterFetcher, name, description, longDescription, needsCustomCode, endpoints,
              endpointVariableName, lowLevelModule, methodParameters, allParameters, extendRenames(parameterRenames),
              lowLevelMethod, enforceModelValidity);
        this.isPaginatedList = isPaginatedList;
        this.fetcher = listOptionsFetcher;
    }

    public static Renames extendRenames(Renames parameterRenames) {
        if (parameterRenames == null) {
            return null;
        }
        parameterRenames.addEntry(ListOptions.FIELD_NAME_FORMER_PAGESIZE, ListOptions.FIELD_NAME_PAGESIZE);
        return parameterRenames;
    }

    @Override
    protected List<Parameter> extendParameterList(List<Parameter> methodParameters, List<Parameter> allParameters,
                                                  Method lowLevelMethod, Renames parameterRenames, Model currentModel) {
        List<Parameter> otherParameters = super.extendParameterList(methodParameters, allParameters, lowLevelMethod,
                                                                    parameterRenames, currentModel);
        if (isPaginatedList) {
            otherParameters = addListOptionParameter(otherParameters, currentModel, fetcher);
        }
        return otherParameters;
    }

    public static List<Parameter> addListOptionParameter(List<Parameter> otherParameters, Model correspondingModel,
                                                         ModelListOptionFetcher fetcher) {
        final ModelListOption correspondingListOptions = determineListOptionModel(correspondingModel, fetcher);
        if (otherParameters == null) {
            otherParameters = new LinkedList<>();
        }
        final Parameter optionParameter = new Parameter(PARAMETER_NAME_OPTIONS, "list options.", null,
                                                        correspondingListOptions.toType(), null).setAsNullable(true);
        if (!doesParameterExist(otherParameters, optionParameter.getName())) {
            otherParameters.add(optionParameter);
        }
        otherParameters = otherParameters.stream()
                                         .filter(p -> !correspondingListOptions.hasFieldInHierachy(p.getIdentifier()))
                                         .collect(Collectors.toList());
        return otherParameters;
    }

    @Override
    protected boolean shouldCheckModelValidity(Parameter p) {
        return super.shouldCheckModelValidity(p) && !PARAMETER_NAME_OPTIONS.equals(p.getIdentifier());
    }

    @Override
    protected void determineReturnType(Model returnModel, Method lowLevelMethod) {
        setReturnType(this, returnModel);
    }

    public static void setReturnType(Method method, Model currentModel) {
        TypeListResponse returnType = new TypeListResponse();
        returnType.setContentType(currentModel.toType());
        method.setReturnType(returnType);
        method.setReturnDescription("the list of " + Utils.generateDocumentationString(currentModel.getName(), true)
                                    + " corresponding to filter options (One page).");
    }

    @Override
    protected String getMappingMethod() {
        return getMappingMethod(isPaginatedList);
    }

    public static String getMappingMethod(boolean isPaginatedList) {
        return isPaginatedList ? ModelAdapter.FUNCTION_NAME_GET_LIST_MAPPER
                               : ModelAdapter.FUNCTION_NAME_GET_SIMPLE_LIST_MAPPER;
    }

    @Override
    protected void generateVariableInitialisation(List<Parameter> methodParameters) throws TranslationException {
        generateVariableInitialisation(this, currentModel, fetcher, methodParameters);
    }

    public static void generateVariableInitialisation(MethodModuleCloudApi method, Model listOptionCorrespondingModel,
                                                      ModelListOptionFetcher fetcher,
                                                      List<Parameter> methodParameters) throws TranslationException {
        if (methodParameters == null || methodParameters.isEmpty()) {
            return;
        }
        for (Parameter p : methodParameters) {
            if (checkIfParameterListOptions(p)) {
                method.code.addStatement("final $T $L = ($L == null)? new $T() : $L",
                                         determineListOptionType(listOptionCorrespondingModel, fetcher),
                                         getOptionLocalVariable(method), p.getName(),
                                         determineListOptionType(listOptionCorrespondingModel, fetcher), p.getName());
            } else {
                method.generateParameterInitialisation(p);
            }
        }
    }

    public static boolean checkIfParameterListOptions(Parameter p) {
        return p == null ? false : PARAMETER_NAME_OPTIONS.equals(p.getName()) || p.getType().isListOptions();
    }

    protected static String getOptionLocalVariable(MethodModuleCloudApi method) {
        return method.generateFinalVariable(PARAMETER_NAME_OPTIONS);
    }

    @Override
    protected void translateParameter(String parameterName, String initialParameterName, TypeParameter type,
                                      StringBuilder builder, List<Object> callElements, boolean isExternalParameter,
                                      List<Parameter> unusedParameters) throws TranslationException {
        if (isPaginatedList) {
            // FIXME refactor the following when filters are supported.
            final ModelListOption correspondingListOptions = determineListOptionModel(currentModel, fetcher);
            if (correspondingListOptions.hasFieldInHierachy(parameterName)) {
                translateListOptionParameter(this, parameterName, type, builder, callElements);
            } else {
                super.translateParameter(parameterName, initialParameterName, type, builder, callElements,
                                         isExternalParameter, unusedParameters);
            }

        } else {
            super.translateParameter(parameterName, initialParameterName, type, builder, callElements,
                                     isExternalParameter, unusedParameters);
        }
    }

    public static void translateListOptionParameter(MethodModuleCloudApi method, String parameterName,
                                                    TypeParameter type, StringBuilder builder,
                                                    List<Object> callElements) {
        switch (parameterName) {
            case ListOptions.FIELD_NAME_INCLUDE:
                builder.append("$L.$L()");
                callElements.add(method.generateFinalVariable(PARAMETER_NAME_OPTIONS));
                callElements.add(ListOptions.METHOD_INCLUDE_TO_STRING);
                break;
            case ListOptions.FIELD_NAME_FILTER:
                // FIXME encode filters when filters are supported.
                builder.append("$L");
                callElements.add("null");
                break;
            default:
                builder.append("$L.$L()");
                callElements.add(method.generateFinalVariable(PARAMETER_NAME_OPTIONS));
                callElements.add(MethodGetter.getCorrespondingGetterMethodName(parameterName, type.isBoolean(), false));
                if (parameterName.equals(ListOptions.FIELD_NAME_ORDER)) {
                    builder.append(".toString()");
                }
        }
    }

    private static Object determineListOptionType(Model correspondingModel,
                                                  ModelListOptionFetcher fetcher) throws TranslationException {
        final ModelListOption correspondingListOptions = determineListOptionModel(correspondingModel, fetcher);
        final TypeParameter type = correspondingListOptions.toType();
        type.translate();
        return type.hasClass() ? type.getClazz() : type.getTypeName();
    }

    public static ModelListOption determineListOptionModel(Model correspondingModel, ModelListOptionFetcher fetcher) {
        ModelListOption correspondingListOptions = fetcher == null ? null
                                                                   : fetcher.fetchFromAssociatedModel(correspondingModel.toType());

        if (correspondingListOptions == null) {
            correspondingListOptions = new ModelListOption();
        }
        return correspondingListOptions;
    }

    @Override
    public String toString() {
        return "MethodModuleListApi [isPaginatedList=" + isPaginatedList + ", " + super.toString() + "]";
    }

}
