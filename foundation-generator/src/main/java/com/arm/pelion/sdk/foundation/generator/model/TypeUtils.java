package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class TypeUtils {

    public static boolean checkIfLowLevelModel(final TypeParameter fType) {
        if (fType == null) {
            return false;
        }
        return fType.isLowLevelModel();
    }

    public static boolean checkIfFundationModel(final TypeParameter fType) {
        if (fType == null) {
            return false;
        }
        return fType.isModel();
    }

    public static boolean checkIfModel(final TypeParameter fType) {
        return checkIfLowLevelModel(fType) || checkIfFundationModel(fType);
    }

    public static boolean checkIfCollectionOfModel(TypeParameter fType) {
        if (fType == null || (!fType.isList() && !fType.isHashtable())) {
            return false;
        }
        final TypeParameter contentType = ((TypeCompose) fType).getContentType();
        return checkIfModel(contentType);
    }

    public static boolean checkIfCollectionOfFundationModel(TypeParameter fType) {
        if (fType == null || (!fType.isList() && !fType.isHashtable())) {
            return false;
        }
        final TypeParameter contentType = ((TypeCompose) fType).getContentType();
        return checkIfFundationModel(contentType);
    }

    public static boolean areSame(TypeParameter type1, TypeParameter type2) {
        if (type1 == null) {
            return type2 == null;
        }
        if (type1.equals(type2)) {
            return true;
        }
        try {
            type1.translate();
            type2.translate();
        } catch (@SuppressWarnings("unused") TranslationException exception) {
        }
        if (type1.hasClazz() && (type1.getClazz() == type2.getClazz())) {
            return true;
        }
        if (!type1.hasClazz() && (type1.getTypeName() == type2.getTypeName())) {
            return true;
        }
        return false;

    }

}
