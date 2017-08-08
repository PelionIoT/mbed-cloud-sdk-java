package com.mbed.lwm2m.tlv;

import com.mbed.lwm2m.DecodingException;
import com.mbed.lwm2m.LWM2MObjectInstance;
import com.mbed.lwm2m.LWM2MResource;
import com.mbed.lwm2m.LWM2MResourceInstance;

/**
 *
 * TLV Types
 *
 */
public enum Type {
    /**
     * Object Instance in which case the Value contains one or more Resource TLVs
     */
    OBJECT_INSTANCE(TLV.OBJECT_INSTANCE_BINARY_VALUE, LWM2MObjectInstance.class),
    /**
     * Resource Instance with Value for use within a multiple Resource TLV
     */
    RESOURCE_INSTANCE(TLV.RESOURCE_INSTANCE_BINARY_VALUE, LWM2MResourceInstance.class),
    /**
     * Multiple Resource, in which case the Value contains one or more Resource Instance
     */
    MULTI_RESOURCE(TLV.MULTI_RESOURCE_BINARY_VALUE, LWM2MResource.class),
    /**
     * Resource with Value
     */
    RESOURCE_VALUE(TLV.RESOURCE_VALUE_BINARY_VALUE, LWM2MResource.class);

    private final int binaryRepresentation;
    private final Class<?> objectRepresentation;

    private Type(int binaryRepresentation, Class<?> objectRepresentation) {
        this.binaryRepresentation = binaryRepresentation;
        this.objectRepresentation = objectRepresentation;
    }

    /**
     * @return the binaryRepresentation
     */
    public int getBinaryRepresentation() {
        return binaryRepresentation;
    }

    /**
     * @return the objectRepresentation
     */
    public Class<?> getObjectRepresentation() {
        return objectRepresentation;
    }

    public static Type getType(int typeByte) throws DecodingException {
        int typeValue = typeByte & Mask.ID_TYPE.getBinaryRepresentation();
        switch (typeValue) {
            case TLV.OBJECT_INSTANCE_BINARY_VALUE:
                return OBJECT_INSTANCE;
            case TLV.RESOURCE_INSTANCE_BINARY_VALUE:
                return RESOURCE_INSTANCE;
            case TLV.MULTI_RESOURCE_BINARY_VALUE:
                return MULTI_RESOURCE;
            case TLV.RESOURCE_VALUE_BINARY_VALUE:
                return RESOURCE_VALUE;
            default:
                break;
        }
        throw new DecodingException("Unknown type value: " + String.valueOf(typeValue));

    }

}
