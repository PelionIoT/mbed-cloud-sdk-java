package com.arm.pelion.sdk.foundation.generator.util;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.model.MergeableArtifact;
import com.arm.pelion.sdk.foundation.generator.model.Method;
import com.arm.pelion.sdk.foundation.generator.model.Model;

public class Utils {
    private static final String HYPHEN = "-";
    private static final String WHITE_SPACE = " ";
    private static final String UNDERSCORE = "_";
    public static final String SERIALISATION_UUID = "serialVersionUID";
    private static final List<String> VOWELS = Arrays.asList("a", "e", "i", "o", "u");
    private static final List<String> WORD_EXCEPTIONS = Arrays.asList("user");// TODO to extend
    private static final List<String> WORD_OPPOSITE_EXCEPTIONS = Arrays.asList("sdk");// TODO to extend

    public static <T extends MergeableArtifact> T merge(T artifact1, T artifact2) {
        if (artifact1 == null) {
            return artifact2 == null ? null : artifact2;
        }
        artifact1.merge(artifact2);
        return artifact1;
    }

    public static <T extends MergeableArtifact> T merge(List<T> otherArtifacts) {
        if (otherArtifacts == null || otherArtifacts.isEmpty()) {
            return null;
        }
        T mergedElement = null;
        for (T element : otherArtifacts) {
            mergedElement = merge(mergedElement, element);
        }
        return mergedElement;
    }

    public static String generateConstantName(String prefix, String constantName) {
        if (constantName == null || constantName.isEmpty()) {
            return null;
        }
        if (prefix == null && SERIALISATION_UUID.toLowerCase(Locale.UK).equals(constantName.toLowerCase(Locale.UK))) {
            return SERIALISATION_UUID;
        }
        final StringBuilder builder = new StringBuilder();
        if (prefix != null && !prefix.isEmpty()) {
            builder.append(prefix.toUpperCase(Locale.UK).equals(prefix) ? prefix
                                                                        : ApiUtils.convertCamelToSnake(prefix));
            builder.append(UNDERSCORE);
        }
        builder.append(constantName.toUpperCase(Locale.UK)
                                   .equals(constantName) ? constantName : ApiUtils.convertCamelToSnake(constantName));
        return builder.toString().toUpperCase(Locale.UK);
    }

    public static String generateDocumentationString(String prefix, String modelName, boolean plural) {
        return generateDocumentationString((prefix + " " + modelName).replace("  ", " "), plural);
    }

    public static String generateDocumentationString(String modelName, boolean plural) {
        if (modelName == null || modelName.trim().isEmpty()) {
            return null;
        }
        final StringBuilder build = new StringBuilder();
        if (!plural) {
            final String firstLetter = modelName.trim().substring(0, 1).toLowerCase(Locale.UK);
            if (WORD_OPPOSITE_EXCEPTIONS.stream().anyMatch(w -> modelName.toLowerCase(Locale.UK).startsWith(w))
                || (!WORD_EXCEPTIONS.stream().anyMatch(w -> modelName.toLowerCase(Locale.UK).startsWith(w))
                    && VOWELS.stream().anyMatch(v -> v.equals(firstLetter)))) {
                build.append("an");
            } else {
                build.append("a");
            }
            build.append(" ");
        }
        String text = generateModelNameAsText(modelName);
        if (plural) {
            final String processedName = modelName.trim().toLowerCase(Locale.UK);
            if (!processedName.endsWith("s")) {
                if (processedName.endsWith("y")) {
                    if (VOWELS.stream().anyMatch(v -> processedName.endsWith(v + "y"))) {
                        text += "s";
                    } else {
                        text = generateModelNameAsText(modelName.trim().substring(0, processedName.length() - 1)
                                                       + "ies");
                    }
                } else {
                    text += "s";
                }
            }
        }
        build.append(text);
        return build.toString();
    }

    public static String generateModelNameAsText(String modelName) {
        return ApiUtils.convertCamelToSnake(modelName).replace(HYPHEN, UNDERSCORE).replace(UNDERSCORE, WHITE_SPACE)
                       .trim();
    }

    public static String generateDocumentationString(String modelName) {
        return generateDocumentationString(modelName, false);
    }

    public static String generateDocumentationMethodLink(Model model, Method method) {
        if (model == null && method == null) {
            return null;
        }
        final StringBuilder builder = new StringBuilder("Similar to {@link ");
        if (model != null) {
            builder.append(model.toType().getFullyQualifiedName());
        }
        if (method != null) {
            builder.append("#").append(method.generateSignatureForDocumentation());
        }
        builder.append("}");
        return builder.toString();
    }

    public static String applyPatternHack(String pattern) {
        // FIXME hack because JavaPoet does not handle well "$"
        return pattern == null ? null : pattern.replace("$", "$$");
    }

    public static String applyPatternReverseHack(String pattern) {
        // FIXME hack because JavaPoet does not handle well "$"
        return pattern == null ? null : pattern.replace("$$", "$");
    }
}
