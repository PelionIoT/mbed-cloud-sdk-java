package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class Renames {

    private final Map<String, String> fromTo;
    private final Map<String, String> toFrom;

    public Renames(Map<String, String> fromToRenames) {
        super();
        fromTo = new LinkedHashMap<>();
        toFrom = new LinkedHashMap<>();
        if (fromToRenames != null) {
            fromToRenames.forEach((k, v) -> addEntry(k, v));
        }

    }

    public Renames() {
        this(new Hashtable<>());
    }

    public String getRenamedField(String fieldName) {
        if (!containsMappingFor(fieldName)) {
            return null;
        }
        final String result = fromTo.get(fieldName);
        return result == null ? toFrom.get(fieldName) : result;
    }

    public boolean containsMappingFor(String fieldName) {
        return fieldName == null ? false : fromTo.containsKey(fieldName) || toFrom.containsKey(fieldName);
    }

    public int numberOfRenames() {
        return fromTo.size();
    }

    public boolean isEmpty() {
        return fromTo.isEmpty();
    }

    public Map<String, String> getToFrom() {
        return toFrom;
    }

    public void addEntry(String from, String to) {
        if (from == null || to == null) {
            return;
        }
        if (from.equals(to)) {
            return;
        }
        fromTo.put(from, to);
        if (from.toLowerCase(Locale.UK) != to.toLowerCase(Locale.UK)) {
            toFrom.put(to, from);
        }
    }

    @Override
    public String toString() {
        return "Renames [fromTo=" + fromTo + ", toFrom=" + toFrom + "]";
    }

}
