package com.arm.pelion.sdk.foundation.generator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.model.MergeableArtifact;
import com.arm.pelion.sdk.foundation.generator.model.Method;
import com.arm.pelion.sdk.foundation.generator.model.Model;
import com.arm.pelion.sdk.foundation.generator.model.Parameter;
import com.arm.pelion.sdk.foundation.generator.model.TypeParameter;

public class Utils {
    private static final String LINK_SUFFIX = "}";
    private static final String LINK_PREFIX = "{@link ";
    private static final String PLUS = "+";
    public static final String MY_ARTICLE = "my";
    private static final String HYPHEN = "-";
    private static final String WHITE_SPACE = " ";
    private static final String UNDERSCORE = "_";
    public static final String SERIALISATION_UUID = "serialVersionUID";
    private static final List<String> VOWELS = Arrays.asList("a", "e", "i", "o", "u");
    private static final List<String> WORD_EXCEPTIONS = Arrays.asList("user");// TODO extend if need be
    private static final List<String> WORD_OPPOSITE_EXCEPTIONS = Arrays.asList("sdk");// TODO extend if need be
    private static final List<String> WORD_PLURAL_EXCEPTIONS = Arrays.asList("status");// TODO extend if need be
    private static final List<String> WORD_NON_PLURAL_EXCEPTIONS = Arrays.asList("data", "advice", "sheep");// TODO
                                                                                                            // extend if
                                                                                                            // need be

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

    public static String generateCloudFieldName(String fieldName) {
        return ApiUtils.convertCamelToSnake(fieldName);
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
        return builder.toString().replace(HYPHEN, UNDERSCORE).toUpperCase(Locale.UK);
    }

    public static String generateDocumentationString(String prefix, String modelName, boolean plural) {
        return generateDocumentationString(prefix, modelName, plural, true);
    }

    public static String generateDocumentationString(String prefix, String modelName, boolean plural,
                                                     boolean addArticle) {
        final boolean shouldAddArticle = prefix == null ? true
                                                        : !prefix.toLowerCase(Locale.UK)
                                                                 .contains(WHITE_SPACE + MY_ARTICLE)
                                                          && !prefix.toLowerCase(Locale.UK).startsWith(MY_ARTICLE);
        return generateDocumentationString(prefix == null
                                           || modelName == null ? modelName
                                                                : (prefix.trim() + WHITE_SPACE
                                                                   + modelName.trim()).trim().replace(
                                                                                                      WHITE_SPACE
                                                                                                      + WHITE_SPACE,
                                                                                                      WHITE_SPACE),
                                           plural, shouldAddArticle);
    }

    public static boolean isSameParameter(String parameterName1, String parameterName2) {
        if (parameterName1 == null) {
            return parameterName2 == null;
        }
        if (parameterName1.equals(parameterName2)) {
            return true;
        }
        return ApiUtils.convertCamelToSnake(parameterName1).equals(ApiUtils.convertCamelToSnake(parameterName2));
    }

    public static String generateDocumentationString(String modelName, boolean plural) {
        return generateDocumentationString(modelName, plural, true);
    }

    public static String generateDocumentationString(String modelName, boolean plural, boolean addArticle) {
        if (modelName == null || modelName.trim().isEmpty()) {
            return null;
        }
        final StringBuilder build = new StringBuilder();
        if (!plural && addArticle) {
            final String firstLetter = modelName.trim().substring(0, 1).toLowerCase(Locale.UK);
            if (WORD_OPPOSITE_EXCEPTIONS.stream().anyMatch(w -> modelName.toLowerCase(Locale.UK).startsWith(w))
                || (!WORD_EXCEPTIONS.stream().anyMatch(w -> modelName.toLowerCase(Locale.UK).startsWith(w))
                    && VOWELS.stream().anyMatch(v -> v.equals(firstLetter)))) {
                build.append("an");
            } else {
                build.append("a");
            }
            build.append(WHITE_SPACE);
        }
        String text = generateModelNameAsText(modelName);
        if (plural) {
            text = generatePlural(modelName);
        }
        build.append(text);
        return build.toString();
    }

    public static String generatePlural(String modelName) {
        String text = generateModelNameAsText(modelName);
        final String processedName = modelName.trim().toLowerCase(Locale.UK);
        if (!processedName.endsWith("s")) {
            if (processedName.endsWith("y")) {
                if (VOWELS.stream().anyMatch(v -> processedName.endsWith(v + "y"))) {
                    text += "s";
                } else {
                    text = generateModelNameAsText(modelName.trim().substring(0, processedName.length() - 1) + "ies");
                }
            } else {
                if (!WORD_NON_PLURAL_EXCEPTIONS.stream()
                                               .anyMatch(w -> processedName != null && processedName.endsWith(w))) {
                    text += "s";
                }
            }
        } else {
            if (WORD_PLURAL_EXCEPTIONS.stream().anyMatch(w -> w.equals(processedName))) {
                text = processedName + "es";
            }
        }
        return text;
    }

    public static String combineNames(boolean capitalAtStart, String name1, String... names) {
        if (name1 == null && names == null) {
            return null;
        }
        final List<String> strings = new ArrayList<>((name1 == null ? 0 : 1) + (names == null ? 0 : names.length));
        if (name1 != null && !name1.trim().isEmpty()) {
            strings.add(ApiUtils.convertCamelToSnake(name1));
        }
        if (names != null && names.length > 0) {
            Arrays.asList(names).forEach(n -> strings.add(ApiUtils.convertCamelToSnake(n)));
        }
        if (strings.isEmpty()) {
            return null;
        }
        return ApiUtils.convertSnakeToCamel(String.join(UNDERSCORE, strings), capitalAtStart);
    }

    public static String generateDescriptionFromName(String name) {
        return name == null ? null : ApiUtils
                                             .convertSnakeToCamel(ApiUtils.convertCamelToSnake(name)
                                                                          .replace(UNDERSCORE, PLUS),
                                                                  true)
                                             .replace(PLUS, WHITE_SPACE);
    }

    public static String generateModelNameAsText(String modelName) {
        return ApiUtils.convertCamelToSnake(modelName).replaceAll("<(.*)>", " of $1").replace(HYPHEN, UNDERSCORE)
                       .replace(UNDERSCORE, WHITE_SPACE).replace(WHITE_SPACE + WHITE_SPACE, WHITE_SPACE).trim();
    }

    public static String generateDocumentationString(String modelName) {
        return generateDocumentationString(modelName, false);
    }

    public static String generateDocumentationMethodLink(Model model, Method method) {
        if (model == null && method == null) {
            return null;
        }
        final StringBuilder builder = new StringBuilder("Similar to " + LINK_PREFIX);
        if (model != null) {
            builder.append(model.toType().getFullyQualifiedName());
        }
        if (method != null) {
            builder.append("#").append(method.generateSignatureForDocumentation());
        }
        builder.append(LINK_SUFFIX);
        return builder.toString();
    }

    public static String generateLinkToClass(Class<?> clazz) {
        return clazz == null ? null : LINK_PREFIX + clazz.getName() + LINK_SUFFIX;
    }

    public static String generateSignatureForDocumentation(String methodName, List<Parameter> parameters) {
        return (methodName + "(" + (parameters == null ? "" : String.join(", ", parameters.stream().map(p -> {
            final TypeParameter type = p.getType();
            return type.isPrimitiveOrWrapper() ? type.getShortName() : type.getFullyQualifiedName();
        }).collect(Collectors.toList()))) + ")").replaceAll("<(.*)>", "");// See
                                                                          // https://stackoverflow.com/questions/9482309/javadoc-bug-link-cant-handle-generics
    }

    public static String generateNewDocumentationLine() {
        return System.lineSeparator() + "<p>" + System.lineSeparator();
    }

    public static String applyPatternHack(String pattern) {
        // FIXME hack because JavaPoet does not handle well "$"
        return pattern == null ? null : pattern.replace("$", "$$");
    }

    public static String transformRegexIntoValidString(String pattern) {
        // Characters in the regex such as \w, etc. need to be modified so that that the string in Java is valid
        return pattern == null ? null : pattern.replace("\\@", "@").replace("\\", "\\\\");
    }

    public static String applyPatternReverseHack(String pattern) {
        // FIXME hack because JavaPoet does not handle well "$"
        return pattern == null ? null : pattern.replace("$$", "$").replace("\\@", "@");
    }

    public static String transformRegexBackFromValidString(String pattern) {
        return pattern == null ? null : pattern.replace("\\@", "@").replace("\\\\", "\\");
    }

    public static boolean isEmail(String fieldName) {
        return fieldName == null ? false : fieldName.toLowerCase(Locale.UK).contains("email")
                                           || fieldName.toLowerCase(Locale.UK).contains("salescontact");
    }
}
