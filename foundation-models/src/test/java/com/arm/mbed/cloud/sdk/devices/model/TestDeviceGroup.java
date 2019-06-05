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
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1559754641920L), null,
                                                       "ee1cf747-a252-47b5-9f4c-d4d7ae110c97", 93,
                                                       "dca4591e-3010-494f-b80a-d7afee4aaca0",
                                                       "6cf1cea5-12cb-4b2c-be4a-0377462887f7",
                                                       new Date(1559754642632L));
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
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1559754641362L), null,
                                                       "36eaaaaf-ac9e-411e-9943-085fe6b64e6f", 14,
                                                       "a002c7d2-3cbe-4ab5-97ce-45dbca259f0a",
                                                       "0075f939-0c2d-41a6-9825-f0946a4fdeb1",
                                                       new Date(1559754640992L));
            DeviceGroup devicegroup2 = new DeviceGroup(new Date(1559754641362L), null,
                                                       "36eaaaaf-ac9e-411e-9943-085fe6b64e6f", 14,
                                                       "a002c7d2-3cbe-4ab5-97ce-45dbca259f0a",
                                                       "0075f939-0c2d-41a6-9825-f0946a4fdeb1",
                                                       new Date(1559754640992L));
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
        DeviceGroup devicegroup = new DeviceGroup(new Date(1559754639867L), null,
                                                  "81ad4b72-a888-46f8-8868-fc7a7b4bf90a", 30,
                                                  "c0adda2d-33e7-4278-989a-fb9234052f75",
                                                  "60e886f9-05c4-4a92-8c89-a016d49f108f", new Date(1559754644063L));
        assertTrue(devicegroup.isValid());
        DeviceGroup devicegroupInvalid = new DeviceGroup(new Date(1559754643143L), null,
                                                         "f9057e73-01f9-4abc-a5b3-59d36702fcc38a9ae051-59b6-467b-8728-c01974d02a63b0973151-44d4-4eb2-9ad8-cde5c3f27bf6d5528dbe-6ebe-432d-a313-0de08a826634bcb5b7f4-68b5-48e0-872a-064f69bad8b70fcd1bb6-0fad-40dd-aea7-e80707c6f37faa126072-7180-48f3-8c77-f28f988c23bc6c331a4f-6c7e-4a27-b235-52accf73f98cc96c2227-4cfe-418e-a804-9bde6ab8554208799437-54cc-49ae-9356-ad080cbfeea75271ef28-8953-4206-baa8-30de7d700569162e175f-80ce-42b4-871e-1ef0eaa33aa48a73a86a-63df-4f10-9590-c8603b8060ad32917b90-c530-49c9-be54-45f87f971c405bd1de1f-44b5-4388-8d79-c00757a98239a5126b4d-fb10-4c30-90f9-407db5f4721a695dabf1-b462-40a9-8961-54219cda6f75f47bd5d6-6210-4ba2-bf55-577ff81717f047a1aba6-5163-4b5b-a967-85bec118108a721bb074-57de-4fc4-83fc-ca3669166c491ae04eba-d292-4f15-bb4f-3e4c32f8b133e3b1de27-04e7-41f0-8176-8611f37bde677f10ed53-fefb-45f2-b793-73638e3257294f93dc4e-abd5-40da-9953-8af3f4c24cd84cf0abd4-e906-498e-af85-e74e35c25486333a5ecb-2514-4858-96d0-04e52fabe352879fc4f0-7a9a-4513-b416-cf2765ad2fc37b6263ab-df49-409c-a56a-6cb501cae93810474886-ece2-41ed-8371-45ca32f8c66fde3d814c-6e03-424f-ae67-595714947f1ade81704a-f7fa-4046-8633-ab3a8424ab1d3b1c689e-df88-41df-9fff-4b5a3b35812dbcb67d1d-8a0b-4158-8ff7-36a28f7e09b776516d32-83ad-4e0e-9766-3a46b5a8c306b84ee41a-46e6-4b8e-9130-28b54369c6d269b34c91-32bb-4ede-aed7-5c09b5d2d618e6a98a0a-8fce-4cbc-b500-4caa6195270a8527ab42-47a9-40fc-ab06-a9f51c2f6cdb22304d78-5084-43b4-80d3-9357429cf0744029eb3f-81a2-4265-abdb-032471db0e0de75a7f70-5014-41a1-bede-8921a478eee0357af2c8-d4bb-4bca-b1c2-c12b15900c4f0b5efac4-e912-483f-b46f-7617f573f035c6d3f0f5-bc8d-4afc-b149-734d29acfcb9cd7c2658-77a6-4ce1-854c-719350f3d7180c12b1d3-84e4-43fd-a7d4-264aa9fcb4831a6b8605-f280-4c31-8a52-34201ca6d5c0df5f05ee-ee5c-466b-a719-1a5d72f2dbc9cd61fa67-1526-4033-a6e1-01ba40d8c850fb499802-22a8-4f80-8aae-92c2953835767b6aafd9-641f-4987-96f7-90c6118e22308f1defb8-a59c-454f-8371-e511bd3e5f614f1109d2-4894-47dd-8ed8-72530b36488630f3a9af-6c73-4e8a-b919-393e9594035829698012-f464-4ec0-9896-beed2675c7a6eb28148d-ca19-4bb9-aa44-de6476ccdba8",
                                                         -118, "6b3f36cc-98f3-49fc-8a50-bef862ead6e6",
                                                         "95bbf6a2-c7ea-471b-97aa-55563e1a3ec4c0682ada-63f0-49ed-92e3-614d0f8f6885862fb7fe-a898-40d5-866b-ae3aed74e1e97eddce31-dccc-409b-918d-700848308ecf",
                                                         new Date(1559754640299L));
        assertFalse(devicegroupInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1559754637595L), null,
                                                       "31d1a97b-f488-46cc-9a58-49ab649c8aa3", 117,
                                                       "81aa9cf4-2907-443e-bc79-5441bd6722ac",
                                                       "656e1dd0-a0ea-4dc6-b309-4adbef7b5f8f",
                                                       new Date(1559754638784L));
            DeviceGroup devicegroup2 = new DeviceGroup(new Date(1559754637595L), null,
                                                       "31d1a97b-f488-46cc-9a58-49ab649c8aa3", 117,
                                                       "81aa9cf4-2907-443e-bc79-5441bd6722ac",
                                                       "656e1dd0-a0ea-4dc6-b309-4adbef7b5f8f",
                                                       new Date(1559754638784L));
            DeviceGroup devicegroup3 = new DeviceGroup(new Date(1559754644896L), null,
                                                       "50621899-92f8-4372-9f88-179bcb05c276", 109,
                                                       "4f065847-a887-48f6-a9ad-bb1d237c16d4",
                                                       "abd7dc6d-92b8-4b23-a2ec-33917b00210d",
                                                       new Date(1559754639490L));
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
