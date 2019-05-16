package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.arm.mbed.cloud.sdk.testutils.ReflectionUtils;

public class SdkDefinition implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -3326059859355061080L;
    private final TestedItemDefinitions<APIModule> moduleDefinitions;
    private final TestedItemDefinitions<Entity> entityDefinitions;
    private final TestedItemDefinitions<com.arm.mbed.cloud.sdk.testserver.internal.model.Sdk> sdkDefinitions;
    private String packageName;

    public SdkDefinition(String packageName) {
        super();
        moduleDefinitions = new TestedItemDefinitions<>(TestedItemType.MODULE);
        entityDefinitions = new TestedItemDefinitions<>(TestedItemType.ENTITY);
        sdkDefinitions = new TestedItemDefinitions<>(TestedItemType.SDK);
        setPackageName(packageName);
    }

    public SdkDefinition() {
        this(null);
    }

    /**
     * @return the packageName
     */
    public String getPackageName() {
        return packageName;
    }

    public TestedItemDefinitions<APIModule> getModuleDefinitions() {
        return moduleDefinitions;
    }

    public TestedItemDefinitions<Entity> getEntityDefinitions() {
        return entityDefinitions;
    }

    public TestedItemDefinitions<com.arm.mbed.cloud.sdk.testserver.internal.model.Sdk> getSdkDefinitions() {
        return sdkDefinitions;
    }

    /**
     * @param packageName
     *            the packageName to set
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
        ReflectionUtils.init(packageName);
    }

    public Set<String> fetchItemSet(TestedItemType type) {
        if (type == null) {
            return null;
        }
        switch (type) {
            case ENTITY:
                return entityDefinitions.fetchItemSet();
            case MODULE:
                return moduleDefinitions.fetchItemSet();
            case SDK:
                return sdkDefinitions.fetchItemSet();
            default:
                return null;
        }
    }

    public TestedItem getItem(TestedItemType type, String itemName) {
        if (type == TestedItemType.ENTITY && SdkInstance.REFERENCE.equals(itemName)) {
            type = TestedItemType.SDK;
        }
        if (type == null) {
            return null;
        }
        switch (type) {
            case ENTITY:
                return entityDefinitions.getItem(itemName);
            case MODULE:
                return moduleDefinitions.getItem(itemName);
            case SDK:
                return sdkDefinitions.getItem(itemName);

            default:
                return null;
        }
    }

    public void addItem(TestedItem item) {
        if (item == null) {
            return;
        }
        switch (item.getType()) {
            case ENTITY:
                entityDefinitions.addItem((Entity) item);
                break;
            case MODULE:
                moduleDefinitions.addItem((APIModule) item);
                break;
            case SDK:
                sdkDefinitions.addItem((Sdk) item);
                break;
            default:
                return;
        }
    }

    public static class TestedItemDefinitions<T extends TestedItem> implements Serializable {
        private static final long serialVersionUID = -8492061800848088265L;
        private TestedItemType type;
        private Map<String, T> items;

        public TestedItemDefinitions() {
            this(null, null);
        }

        public TestedItemDefinitions(TestedItemType type, Map<String, T> items) {
            super();
            setType(type);
            this.items = items;
        }

        public TestedItemDefinitions(TestedItemType type) {
            this(type, null);
        }

        public void addItem(T item) {
            if (item == null) {
                return;
            }
            if (items == null) {
                items = new LinkedHashMap<>();
            }
            items.put(item.getSimpleName(), item);
        }

        public T getItem(String simpleName) {
            if (simpleName == null || items == null) {
                return null;
            }
            return items.get(simpleName);

        }

        public Set<String> fetchItemSet() {
            if (items == null) {
                return null;
            }
            return items.keySet();
        }

        public TestedItemType getType() {
            return type;
        }

        public void setType(TestedItemType type) {
            this.type = type;
        }

        public Map<String, T> getItems() {
            return items;
        }

        public void setItems(Map<String, T> items) {
            this.items = items;
        }

    }
}
