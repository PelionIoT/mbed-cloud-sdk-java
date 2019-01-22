package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.arm.mbed.cloud.sdk.testutils.ReflectionUtils;

public class SDK {
    private final TestedItemDefinitions<APIModule> moduleDefinitions;
    private final TestedItemDefinitions<Entity> entityDefinitions;
    private String packageName;

    public SDK(String packageName) {
        super();
        moduleDefinitions = new TestedItemDefinitions<>(TestedItemType.MODULE);
        entityDefinitions = new TestedItemDefinitions<>(TestedItemType.ENTITY);
        setPackageName(packageName);
    }

    public SDK() {
        this(null);
    }

    /**
     * @return the packageName
     */
    public String getPackageName() {
        return packageName;
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
                // TODO
            default:
                return null;
        }
    }

    public TestedItem getItem(TestedItemType type, String itemName) {
        if (type == null) {
            return null;
        }
        switch (type) {
            case ENTITY:
                return entityDefinitions.getItem(itemName);
            case MODULE:
                return moduleDefinitions.getItem(itemName);
            case SDK:
                // TODO
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
                if (item.getType() == entityDefinitions.getType()) {
                    entityDefinitions.addItem((Entity) item);
                }
                break;
            case MODULE:
                if (item.getType() == moduleDefinitions.getType()) {
                    moduleDefinitions.addItem((APIModule) item);
                }
                break;
            case SDK:
                // TODO
            default:
                return;
        }
    }

    private static class TestedItemDefinitions<T extends TestedItem> {
        private TestedItemType type;
        private Map<String, T> items;

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

    }
}
