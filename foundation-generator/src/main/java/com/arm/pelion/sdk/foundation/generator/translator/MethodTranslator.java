package com.arm.pelion.sdk.foundation.generator.translator;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.input.Method;
import com.arm.pelion.sdk.foundation.generator.lowlevelapis.LowLevelAPIMethod;
import com.arm.pelion.sdk.foundation.generator.lowlevelapis.LowLevelAPIMethodArgument;
import com.arm.pelion.sdk.foundation.generator.model.MethodAction;
import com.arm.pelion.sdk.foundation.generator.model.Model;
import com.arm.pelion.sdk.foundation.generator.model.ModelModule.CloudCall;
import com.arm.pelion.sdk.foundation.generator.model.Parameter;
import com.arm.pelion.sdk.foundation.generator.model.TypeFactory;
import com.arm.pelion.sdk.foundation.generator.model.TypeParameter;
import com.arm.pelion.sdk.foundation.generator.util.FoundationGeneratorException;

public class MethodTranslator {
    private static final List<String> VOWELS = Arrays.asList("a", "e", "i", "o", "u");
    private static final List<String> WORD_EXCEPTIONS = Arrays.asList("user");// TODO to extend

    private static MethodAction determineMethodAction(Method m) {
        if (m == null) {
            return null;
        }
        if (m.isListMethod()) {
            return MethodAction.LIST;
        }
        if (m.isCreateMethod()) {
            return MethodAction.CREATE;
        }
        if (m.isDeleteMethod()) {
            return MethodAction.DELETE;
        }
        if (m.isReadMethod()) {
            return MethodAction.READ;
        }
        if (m.isUpdateMethod()) {
            return MethodAction.UPDATE;
        }
        return MethodAction.OTHER;
    }

    private static String generateMethodName(MethodAction action, Model currentModel, String name) {
        switch (action) {
            case CREATE:
            case DELETE:
            case LIST:
            case READ:
            case UPDATE:
                return ApiUtils.convertSnakeToCamel(ApiUtils.convertCamelToSnake(name) + "_"
                                                    + ApiUtils.convertCamelToSnake(currentModel.getName()
                                                                                   + (action.equals(MethodAction.LIST) ? "s"
                                                                                                                       : "")),
                                                    false);

            case OTHER:
            default:
                return ApiUtils.convertSnakeToCamel(ApiUtils.convertCamelToSnake(name), false);
        }

    }

    private static String generateMethodLongDescription(String description) {
        // TODO do some processing if needed
        return description;
    }

    @SuppressWarnings("incomplete-switch")
    private static String generateMethodDescription(MethodAction action, Model currentModel, String summary,
                                                    String methodName, boolean hasFilters) {
        if (action == MethodAction.OTHER) {
            if (summary != null) {
                return summary;
            }
            String description = ApiUtils.convertCamelToSnake(methodName).replaceAll("_", " ");
            if (description != null && !description.isEmpty()) {
                description = description.substring(0, 1).toUpperCase(Locale.UK) + description.substring(1);
            }
            return description + ".";
        }
        StringBuilder build = new StringBuilder();
        if (action == MethodAction.LIST) {
            build.append("Lists").append(" ")
                 .append(ApiUtils.convertCamelToSnake(currentModel.getName()).replaceAll("_", " ").trim()).append("s");
            if (hasFilters) {
                build.append(" matching filter options");
            }
            build.append(".");
        } else {
            switch (action) {
                case CREATE:
                    build.append("Adds");
                    break;
                case DELETE:
                    build.append("Deletes");
                    break;
                case READ:
                    build.append("Gets");
                    break;
                case UPDATE:
                    build.append("Modifies");
                    break;
            }
            build.append(" ");
            final String name = currentModel.getName().trim();
            final String firstLetter = currentModel.getName().substring(0, 1).toLowerCase(Locale.UK);
            if (!WORD_EXCEPTIONS.stream().anyMatch(w -> name.toLowerCase(Locale.UK).startsWith(w))
                && VOWELS.stream().anyMatch(v -> v.equals(firstLetter))) {
                build.append("an");
            } else {
                build.append("a");
            }
            build.append(" ").append(ApiUtils.convertCamelToSnake(name).replaceAll("_", " ")).append(".");
        }
        return build.toString();
    }

    public static TypeParameter
           translateMethodReturnType(LowLevelAPIMethod method) throws FoundationGeneratorException {
        final LowLevelAPIMethodArgument returnArgument = method.getReturnArgument();
        return translateParameterType(returnArgument);
    }

    public static TypeParameter
           translateParameterType(final LowLevelAPIMethodArgument returnArgument) throws FoundationGeneratorException {
        TypeParameter returnType;
        try {
            returnType = TypeFactory.getCorrespondingType(returnArgument.determineClass(),
                                                          TypeFactory.getCorrespondingType(returnArgument.determineContentClass()));
        } catch (ClassNotFoundException exception) {
            throw new FoundationGeneratorException(exception);
        }
        return returnType;
    }

    public static com.arm.pelion.sdk.foundation.generator.model.Method
           translateMethod(LowLevelAPIMethod lowLevelMethod) throws FoundationGeneratorException {
        if (lowLevelMethod == null) {
            return null;
        }
        try {
            com.arm.pelion.sdk.foundation.generator.model.Method method = new com.arm.pelion.sdk.foundation.generator.model.Method(lowLevelMethod.fetchMethod(),
                                                                                                                                   null,
                                                                                                                                   null,
                                                                                                                                   false);

            for (final LowLevelAPIMethodArgument param : lowLevelMethod.getArguments()) {
                method.addParameter(new Parameter(param.getName(), null, null, translateParameterType(param), null));
            }
            return method;
        } catch (NoSuchMethodException | SecurityException | ClassNotFoundException exception) {
            throw new FoundationGeneratorException("Could not find corresponding low level API " + lowLevelMethod,
                                                   exception);
        }
    }

    public static CloudCall translate(Method m, LowLevelAPIMethod method,
                                      Model currentModel) throws FoundationGeneratorException {
        final MethodAction action = determineMethodAction(m);
        return new CloudCall(action, generateMethodName(action, currentModel, m.getKey()),
                             generateMethodDescription(action, currentModel, m.getSummary(), m.getKey(),
                                                       m.hasPaginatedResponse()),
                             generateMethodLongDescription(m.getDescription()), currentModel, m.isCustomCode(),
                             m.hasPaginatedResponse(), translateMethodReturnType(method));
    }

}
