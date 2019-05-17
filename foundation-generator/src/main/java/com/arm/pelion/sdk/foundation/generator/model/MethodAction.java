package com.arm.pelion.sdk.foundation.generator.model;

import java.util.EnumSet;

public enum MethodAction {
    CREATE,
    READ,
    UPDATE,
    DELETE,
    LIST,
    PAGINATION,
    ME,
    LIST_OTHER,
    PAGINATION_OTHER,
    OTHER;

    public EnumSet<MethodAction> forListing() {
        return EnumSet.of(LIST, PAGINATION, LIST_OTHER, PAGINATION_OTHER);
    }

    public EnumSet<MethodAction> forEntityListing() {
        return EnumSet.of(LIST, PAGINATION);
    }

    public EnumSet<MethodAction> forCrud() {
        return EnumSet.of(CREATE, READ, UPDATE, DELETE);
    }

    public boolean isAboutListing() {
        return forListing().contains(this);
    }
}
