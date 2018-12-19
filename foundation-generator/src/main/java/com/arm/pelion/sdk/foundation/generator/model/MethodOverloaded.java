package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MethodOverloaded extends Method {

    private static final String OVERLOAD_SEPARATOR = "#";
    private static final String RAW_GROUP = "raw";
    private static final String SUFFIX_GROUP = "suffix";

    private static final String REGEX = "^(?<" + RAW_GROUP + ">[\\w$]+)" + OVERLOAD_SEPARATOR + "(?<" + SUFFIX_GROUP
                                        + ">[\\w$]+)$";
    private static final Pattern REGEX_PATTERN = Pattern.compile(REGEX);
    private String overloadingSuffix;

    public MethodOverloaded(boolean isReadOnly, String name, String description, String longDescription,
                            boolean isStatic, boolean isAccessible, boolean isAbstract, boolean containsCustomCode,
                            boolean needsCustomCode, boolean isInternal, boolean isRequired, boolean isAnOverride,
                            String overloadingSuffix) {
        super(isReadOnly, name, description, longDescription, isStatic, isAccessible, isAbstract, containsCustomCode,
              needsCustomCode, isInternal, isRequired, isAnOverride);
        this.overloadingSuffix = overloadingSuffix;
    }

    public MethodOverloaded(java.lang.reflect.Method method, String description, String longDescription,
                            boolean isAnOverride, String overloadingSuffix) {
        super(method, description, longDescription, isAnOverride);
        this.overloadingSuffix = overloadingSuffix;
    }

    @Override
    public String getIdentifier() {
        return generateIdentifier(super.getIdentifier(), overloadingSuffix);
    }

    public void generateSuffix() {
        overloadingSuffix = generateOverloadSuffix(this);
    }

    public static String generateIdentifier(String methodIdentifier, String overloadingSuffix) {
        if (methodIdentifier == null || methodIdentifier.trim().isEmpty() || overloadingSuffix == null
            || overloadingSuffix.trim().isEmpty()) {
            return methodIdentifier;
        }
        return methodIdentifier.trim() + OVERLOAD_SEPARATOR + overloadingSuffix.trim();
    }

    public static String fetchMethodRawIdentifier(String methodIdentifier) {
        if (!isOverloadedMethod(methodIdentifier)) {
            return null;
        }
        final Matcher m = REGEX_PATTERN.matcher(methodIdentifier);
        m.find();
        return m.group(RAW_GROUP);
    }

    public static String fetchMethodIdentifierSuffix(String methodIdentifier) {
        if (!isOverloadedMethod(methodIdentifier)) {
            return null;
        }
        final Matcher m = REGEX_PATTERN.matcher(methodIdentifier);
        m.find();
        return m.group(SUFFIX_GROUP);
    }

    public static boolean isOverloadedMethod(Method method) {
        return method == null ? null : method instanceof MethodOverloaded || isOverloadedMethod(method.getIdentifier());
    }

    public static boolean isOverloadedMethod(String methodIdentifier) {
        if (methodIdentifier == null) {
            return false;
        }
        final Matcher m = REGEX_PATTERN.matcher(methodIdentifier);
        return m.matches();
    }

    public static String generateOverloadSuffix(java.lang.reflect.Method method) {
        if (method == null) {
            return null;
        }
        return String.join("_", Arrays.asList(method.getParameters()).stream().map(p -> p.getType().getSimpleName())
                                      .collect(Collectors.toList()));
    }

    public static String generateOverloadSuffix(Method method) {
        if (method == null || !method.hasParameters()) {
            return null;
        }
        return String.join("_", method.getParameters().stream().map(p -> p.getType().getShortName())
                                      .collect(Collectors.toList()));
    }

}
