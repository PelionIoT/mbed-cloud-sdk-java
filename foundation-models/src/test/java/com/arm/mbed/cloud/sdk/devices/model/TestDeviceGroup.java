// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model DeviceGroup.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDeviceGroup {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1566477452780L), null,
                                                       "681cd50e-0631-402a-ae79-13ef395154a7", -76,
                                                       "f9e6b987-a88c-4993-b463-ae4fabb12dbf",
                                                       "6924ff0c-9fc9-43ab-9764-2be9d139ff01",
                                                       new Date(1566477460194L));
            DeviceGroup devicegroup2 = devicegroup1.clone();
            assertNotNull(devicegroup1);
            assertNotNull(devicegroup2);
            assertNotSame(devicegroup2, devicegroup1);
            assertEquals(devicegroup2, devicegroup1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the hashCode method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testHashCode() {
        try {
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1566477458386L), null,
                                                       "c2985d32-87e2-4420-8336-147acfc41d0f", 100,
                                                       "afb0aaf9-0f4a-42fd-bb43-b184ce671a51",
                                                       "dd9257c5-f914-4b59-be03-95550a0c75a8",
                                                       new Date(1566477453499L));
            DeviceGroup devicegroup2 = new DeviceGroup(new Date(1566477458386L), null,
                                                       "c2985d32-87e2-4420-8336-147acfc41d0f", 100,
                                                       "afb0aaf9-0f4a-42fd-bb43-b184ce671a51",
                                                       "dd9257c5-f914-4b59-be03-95550a0c75a8",
                                                       new Date(1566477453499L));
            assertNotNull(devicegroup1);
            assertNotNull(devicegroup2);
            assertNotSame(devicegroup2, devicegroup1);
            assertEquals(devicegroup2, devicegroup1);
            assertEquals(devicegroup2.hashCode(), devicegroup1.hashCode());
            int hashCode = devicegroup1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, devicegroup1.hashCode());
            }
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the isValid method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testIsValid() {
        DeviceGroup devicegroup = new DeviceGroup(new Date(1566477459709L), null,
                                                  "094fc93a-9000-4eb8-ba58-fcbc887e92d4", 2,
                                                  "f5bd572d-ee1d-44fe-8158-cd60c14d7f03",
                                                  "6e023f90-08cc-41ab-8561-6dc943991421", new Date(1566477452702L));
        assertTrue(devicegroup.isValid());
        DeviceGroup devicegroupInvalid = new DeviceGroup(new Date(1566477454110L), null,
                                                         "fe43eb56-2d89-46b0-bd68-efa26757a990918c3a86-a95c-44e0-a146-8014b8f4a5ba814eb4bc-3dee-4049-bb5e-92cda8de257e1add05f0-1300-4ff1-bd1d-19931fdb240c7fd31ba9-fd5f-4d3c-8e34-c015f98b9c653ca14632-ed1b-486e-800e-a54b22cc60faa27e7cc2-048d-461a-918a-4687f76298ff3ef1e600-dff3-4426-adb9-8d25a1de4c5249e4ad5e-2955-494f-888a-2a277859da9e8bca3fcc-f1dd-4ad4-abcd-06d071e0d10f3880aba1-6dc7-4f54-8b27-c80c14cdaaf1eda44834-83f3-4d87-8fc1-843ef5f3745d3dbfefed-a8fb-48ea-af82-51f6a3f3427909966e0f-e1fa-4a51-9db0-3dac2bc8fe00360e76fb-c6f4-49ae-9536-b84ff0ee278b197fa4a4-be8b-465d-9aa5-23208f5b748d154fa058-5361-44c7-bf51-170925fe2de6726da7bd-9d70-4859-ad3b-a2d108c6d7b94aa33640-9950-4d06-96e1-22885c860d40ebd036ad-5bcf-45b2-a022-d15c74ca5b80d0d148ea-7dc9-4fd9-8f89-3cc6b009f67a1e9d3a33-01c2-4f3b-9c41-0ec72b3279591a92d8c4-ac0d-41c9-8765-b8c6ab0c56688a8cd7d4-5cad-4c6c-8b56-66cdfee1852048c4f50d-ad9f-46a2-9460-4c40c2b3a06f843ee680-baee-4f3e-9454-f5ed0395b612f91024e9-513c-48e9-b76b-cb776680afddc26b328f-3429-4918-a180-471d453aca4a9be47403-61cb-44e1-93eb-7c3d9dfe39c5f36d16ce-7618-47c0-b694-e8921f3123eac0180b3d-e360-4cee-8975-2084a8554533fd285fcc-dab4-4f1d-835e-8fd62c6c14d62ee82783-50d6-4a13-a3b8-b05871eee5bf8ecf6ab3-38f2-4ea8-a020-a40067ceb36f73fa8ef3-e393-4625-8241-27d43c7553d10423d879-91a1-41e0-91bf-1628be520709530f5e5c-1bbb-4fb9-a888-0738a71f791883573cd4-affe-4a82-8b69-2d814571377bdae33c85-ec63-4186-99fc-aa7fda3532bd5c564700-66e6-42a4-9c1c-0bd492e649ffe27e3c40-330c-42bd-b9a2-58b03fb594df142339b0-8eb8-41ff-9843-f59f3742f9811d12487a-0bb8-4697-a88c-051c18d2dfbe65571b52-aa2d-46d1-bb6c-f3364a60bfb666cb66e3-e1b7-4ef6-bfbf-82e69fdeddbd1aa25bbd-af72-4f16-a706-fc74e73148ba13b54dd3-91b5-4dc0-bf87-c3c33864a32aa1bf60d8-59f5-4eb2-b47e-6e465ae12d7d12c03dd7-981a-44d3-b17a-84fd72e4ff116ed43689-6937-4d77-bef4-b45b5bf03a86784b908d-1f5c-488b-97e5-dfea84eba2c25580bd8b-a2bf-4609-9870-a97e3ba790d70d1b44e4-d6d6-462d-9c3a-40c855d1c59af541ec0c-1f14-47c9-8f7f-517d960e772a4fdec82d-1221-48dc-9fe7-e43c87c87f4a99e773ed-1dbc-4492-903e-dd710bedb15b",
                                                         72, "38525a8b-7a20-4fd6-84c3-929428b11ef6",
                                                         "2f22bca8-9043-4315-873b-094d75fcc4a73fa65c30-19a3-4c27-970e-6b7768a158961fb40e1f-6b84-41fd-92d8-7f4f3a07d84754548e86-27b7-4ffe-80ec-d9d417b7348a",
                                                         new Date(1566477453925L));
        assertFalse(devicegroupInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1566477460081L), null,
                                                       "9283a17a-765d-4198-adaa-3f8d64429eb7", 62,
                                                       "27df4052-22c0-4d13-9a4b-77401eb75df5",
                                                       "22fbdc90-7086-4197-82cd-7ec7de5824ea",
                                                       new Date(1566477461575L));
            DeviceGroup devicegroup2 = new DeviceGroup(new Date(1566477460081L), null,
                                                       "9283a17a-765d-4198-adaa-3f8d64429eb7", 62,
                                                       "27df4052-22c0-4d13-9a4b-77401eb75df5",
                                                       "22fbdc90-7086-4197-82cd-7ec7de5824ea",
                                                       new Date(1566477461575L));
            DeviceGroup devicegroup3 = new DeviceGroup(new Date(1566477456933L), null,
                                                       "8713ee23-9034-4286-948c-6f20f9f1a063", 61,
                                                       "8d30a381-f59f-45a0-8ad9-05a33fdfcb59",
                                                       "fcf76dd0-872c-4558-bd6c-3416c8484ce9",
                                                       new Date(1566477454265L));
            assertNotNull(devicegroup1);
            assertNotNull(devicegroup2);
            assertNotNull(devicegroup3);
            assertNotSame(devicegroup2, devicegroup1);
            assertNotSame(devicegroup3, devicegroup1);
            assertEquals(devicegroup2, devicegroup1);
            assertEquals(devicegroup2, devicegroup1);
            assertEquals(devicegroup1, devicegroup2);
            assertEquals(devicegroup1, devicegroup1);
            assertFalse(devicegroup1.equals(null));
            assertNotEquals(devicegroup3, devicegroup1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
