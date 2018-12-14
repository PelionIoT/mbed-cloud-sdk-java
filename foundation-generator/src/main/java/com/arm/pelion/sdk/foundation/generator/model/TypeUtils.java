package com.arm.pelion.sdk.foundation.generator.model;

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

}
