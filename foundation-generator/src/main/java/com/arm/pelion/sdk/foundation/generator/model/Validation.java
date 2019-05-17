package com.arm.pelion.sdk.foundation.generator.model;

public class Validation {

    private String pattern;
    private String minimum;
    private String maximum;
    private boolean nullable;
    private boolean isForDate;

    public Validation() {
        this(null, null, null, true, false);
    }

    public Validation(String pattern, String minimum, String maximum, boolean nullable, boolean isForDate) {
        super();
        this.pattern = pattern;
        this.minimum = minimum;
        this.maximum = maximum;
        this.nullable = nullable;
        this.isForDate = isForDate;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public boolean isForDate() {
        return isForDate;
    }

    public void setForDate(boolean isForDate) {
        this.isForDate = isForDate;
    }

    public boolean hasPattern() {
        return AbstractSdkArtifact.has(pattern) && !isForDate;
    }

    /**
     * @return the pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * @param pattern
     *            the pattern to set
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public boolean hasMinimum() {
        return AbstractSdkArtifact.has(minimum) && !isForDate;
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    public boolean hasMaximum() {
        return AbstractSdkArtifact.has(maximum) && !isForDate;
    }

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    public boolean needsValidation() {
        return !isNullable() || hasPattern() || hasMaximum() || hasMinimum();// TODO add more cases where validation is
                                                                             // needed.
    }

    @Override
    public Validation clone() {
        return new Validation(pattern, minimum, maximum, nullable, isForDate);
    }

    @Override
    public String toString() {
        return "Validation [pattern=" + pattern + ", minimum=" + minimum + ", maximum=" + maximum + ", nullable="
               + nullable + ", isForDate=" + isForDate + "]";
    }

}
