package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.PageRequester;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.squareup.javapoet.TypeSpec;

public class MethodModulePaginationApi extends MethodModuleListApi {
    private static final String PAGINATOR_METHOD_IDENTIFIER = "All";
    private static final String PREFIX_LIST_METHOD = "list";
    private final MethodModuleListApi correspondingMethod;

    public MethodModulePaginationApi(MethodModuleListApi listMethod, boolean needsCustomCode) {
        super(listMethod.currentModel, generatePaginatorName(listMethod), generateDescription(listMethod),
              generateLongDescription(listMethod), needsCustomCode, false, listMethod.fetcher,
              listMethod.adapterFetcher, listMethod.endpoints, listMethod.endpointVariableName,
              listMethod.lowLevelModule, listMethod.methodParameters, listMethod.allParameters,
              listMethod.parameterRenames, listMethod.lowLevelMethod, listMethod.enforceModelValidity);
        this.correspondingMethod = listMethod;
    }

    private static String generateLongDescription(MethodModuleListApi listMethod) {
        return "Gets an iterator over all " + generateModelDescription(listMethod.currentModel)
               + " matching filter options.";
    }

    private static String generateDescription(MethodModuleListApi listMethod) {
        return "Creates a {@link Paginator} for the list of " + generateModelDescription(listMethod.currentModel)
               + " matching filter options.";
    }

    private static String generateModelDescription(Model currentModel) {
        return ApiUtils.convertCamelToSnake(currentModel.getName()).replaceAll("_", " ").trim() + "s";
    }

    private static String generatePaginatorName(MethodModuleListApi listMethod) {
        return listMethod.getName().replace(PREFIX_LIST_METHOD, PREFIX_LIST_METHOD + PAGINATOR_METHOD_IDENTIFIER);
    }

    @Override
    protected boolean shouldCheckModelValidity(Parameter p) {
        return false;
    }

    @Override
    protected List<Parameter> extendParameterList(List<Parameter> methodParameters, List<Parameter> allParameters,
                                                  Method lowLevelMethod, Renames parameterRenames, Model currentModel) {
        final List<Parameter> clonedMethodParameters = new ArrayList<>(methodParameters.size());
        methodParameters.forEach(p -> clonedMethodParameters.add(p.clone()));
        return clonedMethodParameters;
    }

    @Override
    protected void determineReturnType(Model currentModel, Method lowLevelMethod) {
        TypePaginator returnType = new TypePaginator();
        returnType.setContentType(currentModel.toType());
        setReturnType(returnType);
        setReturnDescription("paginator over the list of " + generateModelDescription(currentModel));
    }

    @Override
    protected void generateMethodCode() throws TranslationException {
        final TypeParameter paginatorType = TypeFactory.getCorrespondingType(Paginator.class, currentModel.toType());
        paginatorType.translate();
        code.addStatement((hasReturn() ? "return " : "") + "new $T($L, $L)",
                          paginatorType.hasClass() ? paginatorType.getClazz() : paginatorType.getTypeName(),
                          getOptionLocalVariable(), generateOnePageRequest());
    }

    protected Object generateOnePageRequest() throws TranslationException {
        final TypeSpec.Builder pageRequest = TypeSpec.anonymousClassBuilder("");
        final TypeParameter pageRequestType = TypeFactory.getCorrespondingType(PageRequester.class,
                                                                               currentModel.toType());
        pageRequestType.translate();
        if (pageRequestType.hasClass()) {
            pageRequest.addSuperinterface(pageRequestType.getClazz());
        } else {
            pageRequest.addSuperinterface(pageRequestType.getTypeName());
        }
        for (java.lang.reflect.Method m : Arrays.asList(PageRequester.class.getMethods())) {
            // Use for loop for exception reasons
            final Method method = new Method(m, "Makes one page request", null, true);
            if (m.getParameterCount() > 0) {
                Arrays.asList(m.getParameters()).forEach(mp -> method.addParameter(new Parameter(mp)));
            }
            method.setAbstract(false);
            method.setReturnType(TypeFactory.getCorrespondingType(ListResponse.class, currentModel.toType()));
            method.setReturnDescription("Corresponding page requester");
            method.initialiseCodeBuilder();
            final List<Object> callElements = new LinkedList<>();
            final StringBuilder builder = new StringBuilder();
            builder.append("return $L(");
            callElements.add(correspondingMethod.getName());
            boolean start = true;
            for (Parameter p : correspondingMethod.methodParameters) {
                if (start) {
                    start = false;
                } else {
                    builder.append(", ");
                }
                if (PARAMETER_NAME_OPTIONS.equals(p.getName())) {
                    builder.append("($T) $L");
                    final Parameter parameter = method.getParameters().stream().findFirst().get();
                    final TypeParameter pType = p.getType();
                    pType.translate();
                    callElements.add(pType.hasClass() ? pType.getClazz() : pType.getTypeName());
                    callElements.add(parameter == null ? "null" : parameter.getName());
                } else {
                    builder.append("$L");
                    callElements.add(generateFinalVariable(p.getName()));
                }
            }
            builder.append(")");
            method.getCode().addStatement(builder.toString(), callElements.toArray());
            method.translate();
            pageRequest.addMethod(method.getSpecificationBuilder().build());

        }

        return pageRequest.build();

    }

    @Override
    public String toString() {
        return "MethodModulePaginationApi [correspondingMethod=" + correspondingMethod + "]";
    }

}
