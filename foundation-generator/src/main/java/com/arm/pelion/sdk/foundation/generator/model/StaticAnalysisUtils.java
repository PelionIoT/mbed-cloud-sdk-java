package com.arm.pelion.sdk.foundation.generator.model;

import java.util.LinkedHashSet;
import java.util.Set;

import com.squareup.javapoet.AnnotationSpec;

public class StaticAnalysisUtils {
    public static final int FIELD_LIMIT_FOR_IGNORING_WARNINGS = 7;

    private StaticAnalysisUtils() {
        // Nothing to do
    }

    public static AnnotationRegistry newAnnotationRegistry() {
        return new AnnotationRegistry();
    }

    public static class AnnotationRegistry {
        private final Set<String> annotations;

        private AnnotationRegistry() {
            super();
            annotations = new LinkedHashSet<String>();
        }

        public void ignoreCyclomaticComplexity() {
            annotations.add("\"PMD.CyclomaticComplexity\"");
        }

        public void ignoreExcessiveMethodLength() {

            annotations.add("\"PMD.ExcessiveMethodLength\"");
            annotations.add("\"PMD.NcssMethodCount\"");
        }

        public void ignoreUselessParentheses() {
            annotations.add("\"PMD.UselessParentheses\"");
        }

        public void ignoreAvoidDuplicateLiterals() {
            annotations.add("\"PMD.AvoidDuplicateLiterals\"");
        }

        public void ignoreShortMethodName() {
            annotations.add("\"PMD.ShortMethodName\"");
        }

        public void ignoreLongLines() {
            annotations.add("\"checkstyle:LineLength\"");
        }

        public void ignoreResourceClosure() {
            annotations.add("\"resource\"");
        }

        public void ignoreUnused() {
            annotations.add("\"unused\"");
        }

        public void ignoreBoxing() {
            annotations.add("\"boxing\"");
        }

        public void ignoreUselessOverridingMethod() {
            annotations.add("\"PMD.UselessOverridingMethod\"");
        }

        public void setAsUnchecked() {
            annotations.add("\"unchecked\"");
        }

        public boolean hasAnnotations() {
            return !annotations.isEmpty();
        }

        public AnnotationSpec generateAnnotation() {

            String value = String.join(", ", annotations);
            if (annotations.size() > 1) {
                value = "{" + value + "}";
            }

            return AnnotationSpec.builder(SuppressWarnings.class).addMember("value", value).build();

        }

        public void clear() {
            annotations.clear();
        }
    }

}
