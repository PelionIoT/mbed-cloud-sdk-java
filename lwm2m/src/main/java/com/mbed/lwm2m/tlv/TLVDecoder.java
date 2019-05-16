package com.mbed.lwm2m.tlv;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;

import com.mbed.lwm2m.DecodingException;
import com.mbed.lwm2m.LWM2MID;
import com.mbed.lwm2m.LWM2MObjectInstance;
import com.mbed.lwm2m.LWM2MResource;
import com.mbed.lwm2m.LWM2MResourceInstance;
import com.mbed.lwm2m.utils.HexArray;

public class TLVDecoder {

    public TLVDecoder() {
        super();
    }

    /**
     * Decodes a LWM2M TLV sequence into a list of LWM2M objects for which the type is not yet know
     *
     * @param buffer
     *            sequence to decode
     * @return List of LWM2M objects (i.e. Object instance, Resource instance, Resource)
     * @throws DecodingException
     *             if an error occurred during parsing
     */
    public static List<?> decodeTlv(ByteBuffer buffer) throws DecodingException {
        if (buffer == null) {
            return null;
        }
        buffer.order(ByteOrder.BIG_ENDIAN);
        int position = buffer.position();
        int limit = buffer.limit();
        TILFields typeField = decodeTypeField(buffer);
        buffer.position(position);
        buffer.limit(limit);
        return decodeTlv(buffer, typeField.type.getObjectRepresentation());
    }

    /**
     * Decodes a LWM2M TLV sequence into a list of LWM2M objects of type T
     *
     * @param buffer
     *            sequence to decode
     * @param <T>
     *            type of LWM2M objects to expect
     * @param clazz
     *            type of LWM2M objects (i.e. Object instance, Resource instance, Resource) expected in sequence
     * @return List of LWM2M objects of type T
     * @throws DecodingException
     *             if an error occurred during parsing
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> decodeTlv(ByteBuffer buffer, Class<T> clazz) throws DecodingException {
        if (buffer == null || clazz == null) {
            return null;
        }
        List<T> decodedObjects = new LinkedList<>();
        buffer.order(ByteOrder.BIG_ENDIAN);
        while (buffer.hasRemaining()) {

            TILFields typeField = decodeTypeField(buffer);
            if (!typeField.type.getObjectRepresentation().equals(clazz)) {
                throw new DecodingException("The TLV data parsed " + typeField
                                            + " does not correspond to expected object type [" + clazz + "]");
            }
            try {
                T decodedObject = null;
                switch (typeField.type) {
                    case MULTI_RESOURCE:
                        List<LWM2MResourceInstance> resourceInstances = decodeChildren(typeField,
                                                                                       LWM2MResourceInstance.class,
                                                                                       buffer);
                        decodedObject = (T) new LWM2MResource(typeField.id, resourceInstances);
                        break;
                    case OBJECT_INSTANCE:
                        List<LWM2MResource> resources = decodeChildren(typeField, LWM2MResource.class, buffer);
                        decodedObject = (T) new LWM2MObjectInstance(typeField.id, resources);
                        break;
                    case RESOURCE_INSTANCE:
                        decodedObject = (T) new LWM2MResourceInstance(typeField.id,
                                                                      getResourceValue(buffer, typeField));
                        break;
                    case RESOURCE_VALUE:
                        decodedObject = (T) new LWM2MResource(typeField.id, getResourceValue(buffer, typeField));
                        break;
                    default:
                        break;

                }
                if (decodedObject != null) {
                    decodedObjects.add(decodedObject);
                }
            } catch (ClassCastException | IllegalArgumentException e) {
                throw new DecodingException("An error occurred while decoding TLV value of " + typeField, e);
            }

        }
        return decodedObjects;

    }

    private static TILFields decodeTypeField(ByteBuffer buffer) throws DecodingException {
        return new TILFields(buffer.get() & 0xFF, buffer);
    }

    private static <T> List<T> decodeChildren(final TILFields typeField, final Class<T> childrenClass,
                                              ByteBuffer buffer) throws DecodingException {
        ByteBuffer childrenBuffer = buffer.slice();
        childrenBuffer.limit(typeField.length);
        buffer.position(buffer.position() + typeField.length);
        // Parse children
        return decodeTlv(childrenBuffer, childrenClass);
    }

    private static byte[] getResourceValue(ByteBuffer payload, TILFields typeField) {
        byte[] value = new byte[typeField.length];
        payload.get(value);
        return value;
    }

    static class TILFields {
        final int typeField;
        final Type type;
        final LWM2MID id;
        final int length;

        public TILFields(int typeField, ByteBuffer buffer) throws DecodingException {
            super();
            try {
                this.typeField = typeField;
                // Bits 7-6: Indicates the type of Identifier
                this.type = Type.getType(typeField);

                // Bit 5: Indicates the length of the Identifier
                IdentifierLength idLength = IdentifierLength.determine(typeField);
                this.id = LWM2MID.from((idLength == IdentifierLength.ONE_BYTE) ? buffer.get() & 0xFF
                                                                               : buffer.getShort() & 0xFFFF);
                // Bits 4-3: Indicates the type of Length
                this.length = decodeLength(typeField, buffer);
            } catch (DecodingException e) {
                throw new DecodingException("Type field [" + getTypeFieldSequence(typeField)
                                            + "] could not be decoded properly. Reason: " + e.getMessage());
            } catch (Exception e) {
                throw new DecodingException("Type field [" + getTypeFieldSequence(typeField)
                                            + "] could not be decoded properly", e);
            }
        }

        private static String getTypeFieldSequence(int typeField) {
            byte[] bytes = ByteBuffer.allocate(4).putInt(typeField).array();
            return HexArray.toHex(bytes);
        }

        private static String getLengthInBytes(int length) {
            if (length > 1000000) {
                return String.valueOf(length / 1000000) + " MBytes";
            }
            if (length > 1000) {
                return String.valueOf(length / 1000) + " KBytes";
            }

            return String.valueOf(length) + " " + String.valueOf((length == 1) ? "Byte" : "Bytes");
        }

        private int decodeLength(int typeField, ByteBuffer payload) throws DecodingException {
            @SuppressWarnings("hiding")
            int length = 0;
            switch (Length.getType(typeField)) {
                case THREE_BITS:
                    // Bits 2-0: A 3-bit unsigned integer indicating the Length of the Value
                    length = typeField & Mask.LENGTH.getBinaryRepresentation();
                    break;
                case ONE_BYTE:
                    length = payload.get() & 0xFF;
                    break;
                case TWO_BYTES:
                    length = payload.getShort() & 0xFFFF;
                    break;
                case THREE_BYTE:
                    length = ((payload.getShort() & 0x0000FFFF) << 8) | (payload.get() & 0x000000FF);
                    break;
                default:
                    break;
            }
            return length;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "TILFields (0x" + getTypeFieldSequence(typeField) + ") [type=" + type + ", id=" + id + " (0x"
                   + getTypeFieldSequence(id.intValue()) + "), length=" + getLengthInBytes(length) + "]";
        }

    }

}
