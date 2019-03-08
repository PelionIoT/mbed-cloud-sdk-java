package com.arm.pelion.sdk.foundation.generator.input;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("serial")
public class Filters extends Hashtable<String, List<String>> {

    @Override
    public synchronized Enumeration<String> keys() {
        final Enumeration<String> keys = super.keys();
        final List<String> processedKeys = new LinkedList<>();
        while (keys.hasMoreElements()) {
            processedKeys.add(Utils.getKey(keys.nextElement(), true));
        }
        return Collections.enumeration(processedKeys);
    }

    @Override
    public Set<String> keySet() {
        final Set<String> processedKeys = new LinkedHashSet<>();
        for (String key : super.keySet()) {
            processedKeys.add(Utils.getKey(key, true));
        }
        return processedKeys;
    }

    public List<String> getFilters(String fieldName) {
        return entrySet().stream().filter(e -> Utils.getKey(e.getKey(), true).equals(fieldName)).map(e -> e.getValue())
                         .findFirst().orElse(null);
    }

}
