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
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1567417604518L), null,
                                                       "7a49dbe0-4ce3-44d8-bbd4-1d909bd0e599", 13,
                                                       "ae0661bd-afcf-4681-a5b0-29519a1b81f9",
                                                       "6ea3cf32-2f8a-4e96-ab26-7e45d36d9955",
                                                       new Date(1567417608436L));
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
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1567417603222L), null,
                                                       "aee475d8-bb49-4425-ad2f-80ce15cc38a0", -78,
                                                       "f909c785-5e62-4f0f-8cc9-9c7b4c881caf",
                                                       "003e4e26-cb0e-4573-87f5-8d1449b61260",
                                                       new Date(1567417604384L));
            DeviceGroup devicegroup2 = new DeviceGroup(new Date(1567417603222L), null,
                                                       "aee475d8-bb49-4425-ad2f-80ce15cc38a0", -78,
                                                       "f909c785-5e62-4f0f-8cc9-9c7b4c881caf",
                                                       "003e4e26-cb0e-4573-87f5-8d1449b61260",
                                                       new Date(1567417604384L));
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
        DeviceGroup devicegroup = new DeviceGroup(new Date(1567417606787L), null,
                                                  "86490bf7-7be8-40b6-995f-d814cba5fe39", -53,
                                                  "5bbfa6e9-31d5-42ca-9866-3063bdd17f6b",
                                                  "3e6e8c3d-a643-43de-bf2c-82e061d3a893", new Date(1567417602922L));
        assertTrue(devicegroup.isValid());
        DeviceGroup devicegroupInvalid = new DeviceGroup(new Date(1567417603521L), null,
                                                         "a1864786-726e-4421-90eb-619742ae5e19f6d8d580-b02c-4de5-bc71-a32a83abad9d0cefd2dd-93e0-483b-a701-7eff901cfe321c077e5c-2697-4d52-9ecd-e7d31cdab68046157d3f-869b-450e-9005-06b743119f831df65291-8eab-4f97-9328-43b3dede1cf6161b0c8e-281b-4a68-82b6-7a99b839f9a651e52f89-c981-4c14-a56f-65d162bb51e60535e751-98d1-4675-974b-2b2c08d6b9beb26e6010-27f9-4ce0-a646-8c95759a668725c8d05a-7009-4b7a-a64b-010fb6a7a1bb13254fba-0a63-41ec-b79c-2f6c634e77b8f143255c-0c54-4cd7-b864-52666deb1625b8e49901-cba1-4c45-b65d-c295af2ab6610949506c-6b3e-46b0-9302-6f7a350b73ff472190cb-4395-48dd-9bfc-7209c8bb9824f91e940c-60ea-4f59-96b7-c0430cd127e5d17ded82-717b-4a6d-bb03-3124f319321f6146336e-3905-408f-b557-4c242f1c831c3fc95c5b-6d92-4ee1-9a54-211f9f5d664483cf0863-145c-450a-ab3f-f946de02eac958b609fd-fbe6-478c-8469-19e2f49fd21472d86ff7-0903-4ceb-823c-b1b1b476d48c510b83b5-f4b4-4bd2-9386-5f55f54160bc8b539d22-a279-4d3d-87ea-dab650a56921a06df873-e046-4a38-8834-b9babeaf3326116669b5-34f1-4dab-b5c1-b36d800c210185698d2a-396b-4598-adb8-25276782863645f7a512-2f82-4507-9863-87d46bd112b4b8b1b973-4a3c-4d12-824e-6796a8ecf8c917d04460-48e2-4679-88e0-feaef029832bc9903277-aa9b-41f2-b774-fa949fd21eec1a7434e6-776b-4f83-8a32-0130c46c0ad272e0845e-3f62-451f-ba4c-b0397314be1070210ea4-8f2d-4c93-a321-0cc011c2d0a10027c86e-ea0a-406d-bc5f-8bc4c2ef4a97af6e1f17-f3e6-4c89-9871-597aaf669c7db0fd2862-d45f-402d-bcbe-703e436805d21d216fc7-8f59-45cd-bfb1-94a4d7bf32418f0dae72-2a62-42bd-a53c-f2afbf2d222abaa358ac-9f02-4d8f-86d5-eb08ac8482212d85e2ba-9eab-4ffb-8f49-7ba1513bf8c223792bbb-571d-4e61-bf79-cb8a0be259bf6e8dbad7-887b-4895-b7ef-e74e64d250c8e106f9cd-e8d6-4ab7-af4d-04e47effbcf5d0fa2c41-bf9b-4d29-aed4-5c4581b354f4783fb542-0012-4430-abf0-ea490119bfe04fd37312-e11b-4aaf-a130-bbaf55ad867b0d3bf402-5c89-4ea2-8b56-3397178a7667c95eb12b-abb4-4d16-90f6-ba147cdd7be5da2ffa2f-95b1-47eb-9d7a-4527e0d70ee0b38f7da9-8926-495e-831f-69889d6f61718d1f3f8c-ffcc-400d-b5a2-81a2225f2c5bcc6ea2c1-eac8-4675-8593-1d7a366aaeb62b58f74c-bd67-4f43-8955-59b903f7a871ad8c1ea3-5466-4f83-b4a8-f3fcd71c81e7",
                                                         13, "03eae1bb-b4e6-47f5-b1e1-5e814f2084f5",
                                                         "07f74227-8c55-4ca9-bd21-86e481868e729a7900fe-9a44-4031-a5fe-00878c714637e443f016-ae45-45c3-ba56-a9958b12700a2ff0c342-d397-4b04-9233-3f63164560fa",
                                                         new Date(1567417606458L));
        assertFalse(devicegroupInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1567417607278L), null,
                                                       "8d3f4af6-b889-46df-9e8e-cbb248af001e", -65,
                                                       "52ac148e-dea2-45c2-b0ee-4a461a36b199",
                                                       "ef6d7211-80eb-43f6-81e5-9a06d3587a5a",
                                                       new Date(1567417607782L));
            DeviceGroup devicegroup2 = new DeviceGroup(new Date(1567417607278L), null,
                                                       "8d3f4af6-b889-46df-9e8e-cbb248af001e", -65,
                                                       "52ac148e-dea2-45c2-b0ee-4a461a36b199",
                                                       "ef6d7211-80eb-43f6-81e5-9a06d3587a5a",
                                                       new Date(1567417607782L));
            DeviceGroup devicegroup3 = new DeviceGroup(new Date(1567417601818L), null,
                                                       "0ac864b7-a070-445b-99a2-ca8c086010c3", -108,
                                                       "a221d6cd-ad46-4014-b7b9-54505a4d7054",
                                                       "fc6b9936-cf77-4498-bbf2-7501af1ccef0",
                                                       new Date(1567417608031L));
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
