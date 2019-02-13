package com.mbed.lwm2m.tlv;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mbed.lwm2m.DecodingException;
import com.mbed.lwm2m.LWM2MID;
import com.mbed.lwm2m.LWM2MObjectInstance;
import com.mbed.lwm2m.LWM2MResource;
import com.mbed.lwm2m.LWM2MResourceInstance;
import com.mbed.lwm2m.tlv.TLVDecoder.TILFields;

public class TestTLVDecoder {

    @Test
    public final void testTypeOfIdentifierParsing() {
        byte[] array = { (byte) 0xE3, (byte) 0xA3, (byte) 0x67, (byte) 0b0001_1000 };
        ByteBuffer buffer = ByteBuffer.wrap(array);
        try {
            assertEquals(Type.RESOURCE_VALUE, Type.getType(buffer.get() & 0xFF));
            assertEquals(Type.MULTI_RESOURCE, Type.getType(buffer.get() & 0xFF));
            assertEquals(Type.RESOURCE_INSTANCE, Type.getType(buffer.get() & 0xFF));
            assertEquals(Type.OBJECT_INSTANCE, Type.getType(buffer.get() & 0xFF));
        } catch (DecodingException e) {
            fail("Identifier type could not be retrieved properly. Reason: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public final void testIdentifierLengthParsing() {
        byte[] array = { (byte) 0xE3, (byte) 0xA3, (byte) 0x67, (byte) 0b0001_1000 };
        ByteBuffer buffer = ByteBuffer.wrap(array);
        assertEquals(IdentifierLength.TWO_BYTES, IdentifierLength.determine(buffer.get() & 0xFF));
        assertEquals(IdentifierLength.TWO_BYTES, IdentifierLength.determine(buffer.get() & 0xFF));
        assertEquals(IdentifierLength.TWO_BYTES, IdentifierLength.determine(buffer.get() & 0xFF));
        assertEquals(IdentifierLength.ONE_BYTE, IdentifierLength.determine(buffer.get() & 0xFF));
    }

    @Test
    public final void testTypeOfLengthParsing() {
        byte[] array = { (byte) 0xE3, (byte) 0b0001_0000, (byte) 0b0000_1000, (byte) 0b0001_1000 };
        ByteBuffer buffer = ByteBuffer.wrap(array);
        try {
            assertEquals(Length.THREE_BITS, Length.getType(buffer.get() & 0xFF));
            assertEquals(Length.TWO_BYTES, Length.getType(buffer.get() & 0xFF));
            assertEquals(Length.ONE_BYTE, Length.getType(buffer.get() & 0xFF));
            assertEquals(Length.THREE_BYTE, Length.getType(buffer.get() & 0xFF));
        } catch (DecodingException e) {
            fail("Length type could not be retrieved properly. Reason: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Tests Type field parsing in order to verify all information present in it are correctly retrieved
     */
    @Test
    public final void testTypeFieldParsing_case1() {
        byte[] array = { (byte) 0xE3, (byte) 0x9F, (byte) 0x01 };// 11100011 : resource with value, 16-bit identifier
                                                                 // field, 3 bit value length, value length of 3, id
                                                                 // 40,705
        ByteBuffer buffer = ByteBuffer.wrap(array);
        buffer.order(ByteOrder.BIG_ENDIAN);
        try {
            TLVDecoder.TILFields field = new TILFields(buffer.get() & 0xFF, buffer);
            assertEquals(Type.RESOURCE_VALUE, field.type);
            assertEquals(3, field.length);
            assertEquals(LWM2MID.from(40705), field.id);
        } catch (DecodingException e) {
            fail("Could not parse type field entry " + e.getMessage());
        }
    }

    /**
     * Tests Type field parsing in order to verify all information present in it are correctly retrieved
     */
    @Test
    public final void testTypeFieldParsing_case2() {
        byte[] array = { (byte) 0xFB, (byte) 0x9F, (byte) 0x01, (byte) 0xAD, (byte) 0x7F, (byte) 0x58 };// 11111011 :
                                                                                                        // resource with
                                                                                                        // value, 16-bit
                                                                                                        // identifier
        // field, 3-byte value length, value length of 11,370,328, id
        // 40,705
        ByteBuffer buffer = ByteBuffer.wrap(array);
        buffer.order(ByteOrder.BIG_ENDIAN);
        try {
            TLVDecoder.TILFields field = new TILFields(buffer.get() & 0xFF, buffer);
            assertEquals(Type.RESOURCE_VALUE, field.type);
            assertEquals(11370328, field.length);
            assertEquals(LWM2MID.from(40705), field.id);
        } catch (DecodingException e) {
            fail("Could not parse type field entry " + e.getMessage());
        }
    }

    @Test
    /**
     * First line of example from OMA Lightweight Machine to Machine Technical Specification (08 Feb 2017)
     * <p>
     * Extract from 6.4.3.1 Single Object Instance Request Example
     */
    public final void testSingleResourceTLVDecode() {
        byte[] response = { (byte) 0xC8, (byte) 0x00, (byte) 0x14, (byte) 0x4F, (byte) 0x70, (byte) 0x65, (byte) 0x6E,
                            (byte) 0x20, (byte) 0x4D, (byte) 0x6F, (byte) 0x62, (byte) 0x69, (byte) 0x6C, (byte) 0x65,
                            (byte) 0x20, (byte) 0x41, (byte) 0x6C, (byte) 0x6C, (byte) 0x69, (byte) 0x61, (byte) 0x6E,
                            (byte) 0x63, (byte) 0x65 };
        ByteBuffer buffer = ByteBuffer.wrap(response);
        List<LWM2MResource> resources = null;
        try {
            resources = TLVDecoder.decodeTlv(buffer, LWM2MResource.class);
        } catch (DecodingException e) {
            fail("Failed because " + e.getMessage());
            return;
        }
        assertEquals(1, resources.size());
        LWM2MResource resource = resources.get(0);
        assertEquals(LWM2MID.$0, resource.getId());
        assertFalse(resource.hasNestedInstances());
        assertEquals("Open Mobile Alliance", resource.getStringValue());
        buffer = ByteBuffer.wrap(response);
        try {
            List<?> lwm2mObjects = TLVDecoder.decodeTlv(buffer);
            assertEquals(1, lwm2mObjects.size());
            assertTrue(lwm2mObjects.get(0) instanceof LWM2MResource);
        } catch (DecodingException e) {
            fail("Failed because " + e.getMessage());
        }
    }

    @Test
    /**
     * Example from OMA Lightweight Machine to Machine Technical Specification (08 Feb 2017)
     * <p>
     * 6.4.3.1 Single Object Instance Request Example
     * <p>
     * Note: the example has been fixed as it contains some errors in its original form
     */
    public final void testSingleObjectInstanceTLVDecode() {
        byte[] response = { (byte) 0xC8, (byte) 0x00, (byte) 0x14, (byte) 0x4F, (byte) 0x70, (byte) 0x65, (byte) 0x6E,
                            (byte) 0x20, (byte) 0x4D, (byte) 0x6F, (byte) 0x62, (byte) 0x69, (byte) 0x6C, (byte) 0x65,
                            (byte) 0x20, (byte) 0x41, (byte) 0x6C, (byte) 0x6C, (byte) 0x69, (byte) 0x61, (byte) 0x6E,
                            (byte) 0x63, (byte) 0x65, (byte) 0xC8, (byte) 0x01, (byte) 0x16, (byte) 0x4C, (byte) 0x69,
                            (byte) 0x67, (byte) 0x68, (byte) 0x74, (byte) 0x77, (byte) 0x65, (byte) 0x69, (byte) 0x67,
                            (byte) 0x68, (byte) 0x74, (byte) 0x20, (byte) 0x4D, (byte) 0x32, (byte) 0x4D, (byte) 0x20,
                            (byte) 0x43, (byte) 0x6C, (byte) 0x69, (byte) 0x65, (byte) 0x6E, (byte) 0x74, (byte) 0xC8,
                            (byte) 0x02, (byte) 0x09, (byte) 0x33, (byte) 0x34, (byte) 0x35, (byte) 0x30, (byte) 0x30,
                            (byte) 0x30, (byte) 0x31, (byte) 0x32, (byte) 0x33, (byte) 0xC3, (byte) 0x03, (byte) 0x31,
                            (byte) 0x2E, (byte) 0x30, (byte) 0x86, (byte) 0x06, (byte) 0x41, (byte) 0x00, (byte) 0x01,
                            (byte) 0x41, (byte) 0x01, (byte) 0x05, (byte) 0x88, (byte) 0x07, (byte) 0x08, (byte) 0x42,
                            (byte) 0x00, (byte) 0x0E, (byte) 0xD8, (byte) 0x42, (byte) 0x01, (byte) 0x13, (byte) 0x88,
                            (byte) 0x87, (byte) 0x08, (byte) 0x41, (byte) 0x00, (byte) 0x7D, (byte) 0x42, (byte) 0x01,
                            (byte) 0x03, (byte) 0x84, (byte) 0xC1, (byte) 0x09, (byte) 0x64, (byte) 0xC1, (byte) 0x0A,
                            (byte) 0x0F, (byte) 0x83, (byte) 0x0B, (byte) 0x41, (byte) 0x00, (byte) 0x00, (byte) 0xC4,
                            (byte) 0x0D, (byte) 0x51, (byte) 0x82, (byte) 0x42, (byte) 0x8F, (byte) 0xC6, (byte) 0x0E,
                            (byte) 0x2B, (byte) 0x30, (byte) 0x32, (byte) 0x3A, (byte) 0x30, (byte) 0x30, (byte) 0xC1,
                            (byte) 0x10, (byte) 0x55 };
        ByteBuffer buffer = ByteBuffer.wrap(response);
        List<LWM2MResource> resources = null;
        try {
            resources = TLVDecoder.decodeTlv(buffer, LWM2MResource.class);
        } catch (DecodingException e) {
            fail("Failed because " + e.getMessage());
        }
        assertNotNull(resources);
        assertEquals(13, resources.size());
        List<LWM2MResource> expectedResources = buildFirstOMAExpectedResourcesList();
        assertArrayEquals(expectedResources.toArray(), resources.toArray());
        buffer = ByteBuffer.wrap(response);
        try {
            List<?> lwm2mObjects = TLVDecoder.decodeTlv(buffer);
            assertEquals(13, lwm2mObjects.size());
            assertTrue(lwm2mObjects.get(0) instanceof LWM2MResource);
        } catch (DecodingException e) {
            fail("Failed because " + e.getMessage());
        }
    }

    @Test
    /**
     * Example from OMA Lightweight Machine to Machine Technical Specification (08 Feb 2017)
     * <p>
     * 6.4.3.2.A Multiple Object Instance Request Example: Request on Single-Instance Object
     * <p>
     * Note: the example has been fixed as it contains some errors in its original form
     */
    public final void testSMultipleObjectInstanceTLVDecode_A() {
        byte[] response = { (byte) 0x08, (byte) 0x00, (byte) 0x79, (byte) 0xC8, (byte) 0x00, (byte) 0x14, (byte) 0x4F,
                            (byte) 0x70, (byte) 0x65, (byte) 0x6E, (byte) 0x20, (byte) 0x4D, (byte) 0x6F, (byte) 0x62,
                            (byte) 0x69, (byte) 0x6C, (byte) 0x65, (byte) 0x20, (byte) 0x41, (byte) 0x6C, (byte) 0x6C,
                            (byte) 0x69, (byte) 0x61, (byte) 0x6E, (byte) 0x63, (byte) 0x65, (byte) 0xC8, (byte) 0x01,
                            (byte) 0x16, (byte) 0x4C, (byte) 0x69, (byte) 0x67, (byte) 0x68, (byte) 0x74, (byte) 0x77,
                            (byte) 0x65, (byte) 0x69, (byte) 0x67, (byte) 0x68, (byte) 0x74, (byte) 0x20, (byte) 0x4D,
                            (byte) 0x32, (byte) 0x4D, (byte) 0x20, (byte) 0x43, (byte) 0x6C, (byte) 0x69, (byte) 0x65,
                            (byte) 0x6E, (byte) 0x74, (byte) 0xC8, (byte) 0x02, (byte) 0x09, (byte) 0x33, (byte) 0x34,
                            (byte) 0x35, (byte) 0x30, (byte) 0x30, (byte) 0x30, (byte) 0x31, (byte) 0x32, (byte) 0x33,
                            (byte) 0xC3, (byte) 0x03, (byte) 0x31, (byte) 0x2E, (byte) 0x30, (byte) 0x86, (byte) 0x06,
                            (byte) 0x41, (byte) 0x00, (byte) 0x01, (byte) 0x41, (byte) 0x01, (byte) 0x05, (byte) 0x88,
                            (byte) 0x07, (byte) 0x08, (byte) 0x42, (byte) 0x00, (byte) 0x0E, (byte) 0xD8, (byte) 0x42,
                            (byte) 0x01, (byte) 0x13, (byte) 0x88, (byte) 0x87, (byte) 0x08, (byte) 0x41, (byte) 0x00,
                            (byte) 0x7D, (byte) 0x42, (byte) 0x01, (byte) 0x03, (byte) 0x84, (byte) 0xC1, (byte) 0x09,
                            (byte) 0x64, (byte) 0xC1, (byte) 0x0A, (byte) 0x0F, (byte) 0x83, (byte) 0x0B, (byte) 0x41,
                            (byte) 0x00, (byte) 0x00, (byte) 0xC4, (byte) 0x0D, (byte) 0x51, (byte) 0x82, (byte) 0x42,
                            (byte) 0x8F, (byte) 0xC6, (byte) 0x0E, (byte) 0x2B, (byte) 0x30, (byte) 0x32, (byte) 0x3A,
                            (byte) 0x30, (byte) 0x30, (byte) 0xC1, (byte) 0x10, (byte) 0x55 };
        ByteBuffer buffer = ByteBuffer.wrap(response);
        List<LWM2MObjectInstance> objectInstances = null;
        try {
            objectInstances = TLVDecoder.decodeTlv(buffer, LWM2MObjectInstance.class);
        } catch (DecodingException e) {
            fail("Failed because " + e.getMessage());
        }
        assertNotNull(objectInstances);
        assertEquals(1, objectInstances.size());
        List<LWM2MResource> expectedResources = buildFirstOMAExpectedResourcesList();
        List<LWM2MObjectInstance> expectedObjectInstances = new ArrayList<>(1);
        expectedObjectInstances.add(new LWM2MObjectInstance(LWM2MID.$0, expectedResources));
        assertArrayEquals(expectedObjectInstances.toArray(), objectInstances.toArray());
        buffer = ByteBuffer.wrap(response);
        try {
            List<?> lwm2mObjects = TLVDecoder.decodeTlv(buffer);
            assertEquals(1, lwm2mObjects.size());
            assertTrue(lwm2mObjects.get(0) instanceof LWM2MObjectInstance);
        } catch (DecodingException e) {
            fail("Failed because " + e.getMessage());
        }
    }

    @Test
    /**
     * Example from OMA Lightweight Machine to Machine Technical Specification (08 Feb 2017)
     * <p>
     * 6.4.3.2.B Multiple Object Instance Request Example: Request on Multiple Instances Object having 2 instances
     * <p>
     * Note: the example has been fixed as it contains some errors in its original form
     */
    public final void testSMultipleObjectInstanceTLVDecode_B() {
        byte[] response = { (byte) 0x08, (byte) 0x00, (byte) 0x0E, (byte) 0xC1, (byte) 0x00, (byte) 0x01, (byte) 0xC1,
                            (byte) 0x01, (byte) 0x00, (byte) 0x83, (byte) 0x02, (byte) 0x41, (byte) 0x7F, (byte) 0x07,
                            (byte) 0xC1, (byte) 0x03, (byte) 0x7F, (byte) 0x08, (byte) 0x02, (byte) 0x12, (byte) 0xC1,
                            (byte) 0x00, (byte) 0x03, (byte) 0xC1, (byte) 0x01, (byte) 0x00, (byte) 0x87, (byte) 0x02,
                            (byte) 0x41, (byte) 0x7F, (byte) 0x07, (byte) 0x61, (byte) 0x01, (byte) 0x36, (byte) 0x01,
                            (byte) 0xC1, (byte) 0x03, (byte) 0x7F };
        ByteBuffer buffer = ByteBuffer.wrap(response);
        List<LWM2MObjectInstance> objectInstances = null;
        try {
            objectInstances = TLVDecoder.decodeTlv(buffer, LWM2MObjectInstance.class);
        } catch (DecodingException e) {
            fail("Failed because " + e.getMessage());
        }
        assertNotNull(objectInstances);
        assertEquals(2, objectInstances.size());
        List<LWM2MObjectInstance> expectedObjectInstances = buildSecondOMAExpectedResourcesList();
        assertArrayEquals(expectedObjectInstances.toArray(), objectInstances.toArray());
        buffer = ByteBuffer.wrap(response);
        try {
            List<?> lwm2mObjects = TLVDecoder.decodeTlv(buffer);
            assertEquals(2, lwm2mObjects.size());
            assertTrue(lwm2mObjects.get(0) instanceof LWM2MObjectInstance);
        } catch (DecodingException e) {
            fail("Failed because " + e.getMessage());
        }
    }

    @Test
    /**
     * Example from OMA Lightweight Machine to Machine Technical Specification (08 Feb 2017)
     * <p>
     * 6.4.3.2.C Multiple Object Instance Request Example: Request on Multiple Instances Object having 1 instance only
     * <p>
     * Note: the example has been fixed as it contains some errors in its original form
     */
    public final void testSMultipleObjectInstanceTLVDecode_C() {
        byte[] response = { (byte) 0x08, (byte) 0x00, (byte) 0x0F, (byte) 0xC1, (byte) 0x00, (byte) 0x01, (byte) 0xC4,
                            (byte) 0x01, (byte) 0x00, (byte) 0x01, (byte) 0x51, (byte) 0x80, (byte) 0xC1, (byte) 0x06,
                            (byte) 0x01, (byte) 0xC1, (byte) 0x07, (byte) 0x55 };
        ByteBuffer buffer = ByteBuffer.wrap(response);
        List<LWM2MObjectInstance> objectInstances = null;
        try {
            objectInstances = TLVDecoder.decodeTlv(buffer, LWM2MObjectInstance.class);
        } catch (DecodingException e) {
            fail("Failed because " + e.getMessage());
        }
        assertNotNull(objectInstances);
        assertEquals(1, objectInstances.size());
        List<LWM2MResource> expectedResources = buildThirdOMAExpectedResourcesList();
        List<LWM2MObjectInstance> expectedObjectInstances = new ArrayList<>(1);
        expectedObjectInstances.add(new LWM2MObjectInstance(LWM2MID.$0, expectedResources));
        assertArrayEquals(expectedObjectInstances.toArray(), objectInstances.toArray());
        buffer = ByteBuffer.wrap(response);
        try {
            List<?> lwm2mObjects = TLVDecoder.decodeTlv(buffer);
            assertEquals(1, lwm2mObjects.size());
            assertTrue(lwm2mObjects.get(0) instanceof LWM2MObjectInstance);
        } catch (DecodingException e) {
            fail("Failed because " + e.getMessage());
        }
    }

    /**
     * List of expected {@link LWM2MResource} used in OMA specification examples
     *
     * @returnc list
     */
    private List<LWM2MResource> buildFirstOMAExpectedResourcesList() {
        List<LWM2MResource> expectedResources = new ArrayList<>(13);
        List<LWM2MResourceInstance> resourceInstances = null;
        expectedResources.add(new LWM2MResource(LWM2MID.$0, "Open Mobile Alliance"));
        expectedResources.add(new LWM2MResource(LWM2MID.$1, "Lightweight M2M Client"));
        expectedResources.add(new LWM2MResource(LWM2MID.$2, "345000123"));
        expectedResources.add(new LWM2MResource(LWM2MID.$3, "1.0"));
        resourceInstances = new ArrayList<>(2);
        resourceInstances.add(new LWM2MResourceInstance(LWM2MID.$0, 0x01));
        resourceInstances.add(new LWM2MResourceInstance(LWM2MID.$1, 0x05));
        expectedResources.add(new LWM2MResource(LWM2MID.$6, resourceInstances));
        resourceInstances = new ArrayList<>(2);
        resourceInstances.add(new LWM2MResourceInstance(LWM2MID.$0, 0x0ED8));
        resourceInstances.add(new LWM2MResourceInstance(LWM2MID.$1, 0x1388));
        expectedResources.add(new LWM2MResource(LWM2MID.$7, resourceInstances));
        resourceInstances = new ArrayList<>(2);
        resourceInstances.add(new LWM2MResourceInstance(LWM2MID.$0, 0x7D));
        resourceInstances.add(new LWM2MResourceInstance(LWM2MID.$1, 0x0384));
        expectedResources.add(new LWM2MResource(LWM2MID.$8, resourceInstances));
        expectedResources.add(new LWM2MResource(LWM2MID.$9, 0x64));
        expectedResources.add(new LWM2MResource(LWM2MID.$10, 0x0F));
        resourceInstances = new ArrayList<>(1);
        resourceInstances.add(new LWM2MResourceInstance(LWM2MID.$0, 0x00));
        expectedResources.add(new LWM2MResource(LWM2MID.$11, resourceInstances));
        expectedResources.add(new LWM2MResource(LWM2MID.$13, 0x5182428F));
        expectedResources.add(new LWM2MResource(LWM2MID.$14, "+02:00"));
        expectedResources.add(new LWM2MResource(LWM2MID.$16, "U"));
        return expectedResources;
    }

    /**
     * List of expected {@link LWM2MObjectInstance} used in OMA specification examples
     *
     * @returnc list
     */
    private List<LWM2MObjectInstance> buildSecondOMAExpectedResourcesList() {
        List<LWM2MObjectInstance> expectedObjectInstances = new ArrayList<>(2);
        // first object instance
        List<LWM2MResource> expectedResources = new ArrayList<>(4);
        expectedResources.add(new LWM2MResource(LWM2MID.$0, 0x01));
        expectedResources.add(new LWM2MResource(LWM2MID.$1, 0x00));
        List<LWM2MResourceInstance> resourceInstances = new ArrayList<>(1);
        resourceInstances.add(new LWM2MResourceInstance(LWM2MID.from(127), 0b00000111));
        expectedResources.add(new LWM2MResource(LWM2MID.$2, resourceInstances));
        expectedResources.add(new LWM2MResource(LWM2MID.$3, 0x7F));
        expectedObjectInstances.add(new LWM2MObjectInstance(LWM2MID.$0, expectedResources));
        // Second object instance
        expectedResources = new ArrayList<>(3);
        expectedResources.add(new LWM2MResource(LWM2MID.$0, 0x03));
        expectedResources.add(new LWM2MResource(LWM2MID.$1, 0x00));
        resourceInstances = new ArrayList<>(2);
        resourceInstances.add(new LWM2MResourceInstance(LWM2MID.from(127), 0b00000111));
        resourceInstances.add(new LWM2MResourceInstance(LWM2MID.from(310), 0b00000001));
        expectedResources.add(new LWM2MResource(LWM2MID.$2, resourceInstances));
        expectedResources.add(new LWM2MResource(LWM2MID.$3, 0x7F));
        expectedObjectInstances.add(new LWM2MObjectInstance(LWM2MID.$2, expectedResources));
        return expectedObjectInstances;
    }

    /**
     * List of expected {@link LWM2MResource} used in OMA specification examples
     *
     * @returnc list
     */
    private List<LWM2MResource> buildThirdOMAExpectedResourcesList() {
        List<LWM2MResource> expectedResources = new ArrayList<>(4);
        expectedResources.add(new LWM2MResource(LWM2MID.$0, 0x01));
        expectedResources.add(new LWM2MResource(LWM2MID.$1, 0x00015180));// 86400
        expectedResources.add(new LWM2MResource(LWM2MID.$6, 1));// True
        expectedResources.add(new LWM2MResource(LWM2MID.$7, "U"));
        return expectedResources;
    }

}
