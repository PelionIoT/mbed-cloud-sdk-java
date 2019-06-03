// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.deviceupdate.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model FirmwareImage.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestFirmwareImage {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            FirmwareImage firmwareimage1 = new FirmwareImage(new Date(1559560666578L),
                                                             "32f9cfab-26be-41e9-87cb-068c83f1d678", 25,
                                                             "d318b52a-554c-461e-b12a-5132d208f4d5",
                                                             "222440bd-ddf3-4374-a19e-799a4ae7e2fc",
                                                             "860e8877-86d4-4cf0-bb61-ae4419783909",
                                                             "c3a18b81-91fd-40bc-bb66-d3b9ef55d4ab",
                                                             new Date(1559560668044L));
            FirmwareImage firmwareimage2 = firmwareimage1.clone();
            assertNotNull(firmwareimage1);
            assertNotNull(firmwareimage2);
            assertNotSame(firmwareimage2, firmwareimage1);
            assertEquals(firmwareimage2, firmwareimage1);
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
            FirmwareImage firmwareimage1 = new FirmwareImage(new Date(1559560668396L),
                                                             "136de8b0-9ec4-4cd5-ae46-49d1d3696921", 52,
                                                             "63773d16-b4ac-412d-97d5-160956a04dbb",
                                                             "b92a565a-7d54-4b21-ac6b-61b0518a1395",
                                                             "25061967-5313-4da8-abc1-b7ac4f16d4f2",
                                                             "2fa2770b-8681-4cd3-86d5-0f1f0c521f67",
                                                             new Date(1559560670867L));
            FirmwareImage firmwareimage2 = new FirmwareImage(new Date(1559560668396L),
                                                             "136de8b0-9ec4-4cd5-ae46-49d1d3696921", 52,
                                                             "63773d16-b4ac-412d-97d5-160956a04dbb",
                                                             "b92a565a-7d54-4b21-ac6b-61b0518a1395",
                                                             "25061967-5313-4da8-abc1-b7ac4f16d4f2",
                                                             "2fa2770b-8681-4cd3-86d5-0f1f0c521f67",
                                                             new Date(1559560670867L));
            assertNotNull(firmwareimage1);
            assertNotNull(firmwareimage2);
            assertNotSame(firmwareimage2, firmwareimage1);
            assertEquals(firmwareimage2, firmwareimage1);
            assertEquals(firmwareimage2.hashCode(), firmwareimage1.hashCode());
            int hashCode = firmwareimage1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, firmwareimage1.hashCode());
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
        FirmwareImage firmwareimage = new FirmwareImage(new Date(1559560665461L),
                                                        "d188ebff-d7c1-4415-b913-564dc8560d54", 65,
                                                        "747770fe-2162-4f9e-b350-02935fceb102",
                                                        "e4dcd041-ae84-4eec-9053-daa39d5f2830",
                                                        "d03d2384-12e5-4748-88dd-2d9f20f3c179",
                                                        "809b7cda-7dba-46d6-a0f8-54c34b9d77c5",
                                                        new Date(1559560663987L));
        assertTrue(firmwareimage.isValid());
        FirmwareImage firmwareimageInvalid = new FirmwareImage(new Date(1559560663986L),
                                                               "1b730caa-c5e9-4a30-bdc5-0f11b1586ff4", -63,
                                                               "4c7c4f1d-dc8f-4b45-8968-6c65bd7ff1ce",
                                                               "1f0f97e1-3d7e-4a6a-a720-a65a14ef4ae27932ba01-0c53-4417-8984-13d7de85b316b2456ae9-1fc7-41b2-ad3a-2b2e619b591c23082755-5b06-40a9-968f-65f458c0b6be6725ab49-2146-45e7-a02d-41fa0168ca14432419cd-bcea-4b4e-abec-644160110db3f166a0a4-5a3f-43af-b515-f60005e0dbf478794953-806b-4568-beb1-b75ea193711c5999ea0e-478b-4110-905a-de5b8237b5043937c73d-aea0-4e8a-a626-ec8052e505f2c22bc2d1-25aa-4dd9-90b1-898ba22966aafec9b7bc-1b58-4dde-b5d8-765593a2624e1007e6a1-eb96-42dc-be00-c269839b4a6cb8df8b81-12c6-4ca6-b669-2a04dc4ddfd6a77615b2-8fb7-4f36-878f-cb2cb40f5baaeeec8f87-50d0-4e18-a9f8-dd8b2f34035a51c22281-9cba-4812-9c36-4943050c14f7cbf902ed-1187-4461-8bc2-5eb4cad947b7546140c9-8659-43df-9505-66a75d49832fa897e1c7-3ad4-4592-b1f6-a4bb8fa10ed6d7fe57b8-72a4-4af8-b529-0748194054dd3aa087c0-fb45-4ed0-8b6f-7a0b7bc40dc5dbe022bc-fa29-4024-bcd2-53c4ba5ea679af5fe302-ebad-4c24-995f-c14f7362948a178328fb-a82f-4cc6-9fe5-cd96a49f7e082798f9a5-647d-4ad5-ae70-0f652e81b0943ebd35fb-729e-4fc0-ad80-a07de81d7a12e9505f25-a293-4581-9ece-b7802c35936dbe0e6db4-8e1d-41df-819a-5ff23148f768e3f41f08-a6fd-422e-93e3-f428a9c811c5e0ba44f5-b4df-4d4d-be5f-ae204a64d3c291d8fcad-cd98-408e-acbe-4dc437556777fc0d6b8f-4528-4299-9653-f30195c252f57e1c6110-29e5-4854-9a02-7b7feb230a449a9456f7-9a8b-41f9-980b-de92525e0e6cc273b0c8-1a38-44c0-bbf9-4f1072ec2f68c5116208-eb73-4342-8777-0700c5fdc4ae851057f6-f8fa-4d4b-a6c9-055a3565102b1af76574-0a68-4ccb-b70e-55a67a7bc2c2673dabd5-dc6f-4483-a4bd-70c570b46661e2d162a0-837e-4a25-a3e5-4730a95fc24bab279b91-eca6-4707-84a6-1c15c377cfcc6958d5ef-77d4-496e-a62b-b478ffa0c35e16ba9e53-13a1-48d0-a0ae-e89302fd37dec4bd0c77-0b15-42a6-9386-3fa69609741aff736f73-630c-4155-a2d7-2d3f9b1e08f87956dcb4-6eae-452e-9b24-77c1889f2515a51ad9cf-bea6-4484-a928-524a4aba1dae64b027a3-80b9-4d57-9644-4f29bd8a6e9b2a2f114b-0291-431c-b119-fcfccd8073d5bdc8a793-aa0a-4a4e-bbf5-6bbd8dac255633ae76f8-5d44-4447-9c20-70065d7948c660415252-68a3-4f21-85db-e9a841bf5c4a2585d116-f513-42a1-93d1-668e7ff2851585e545db-2065-43f8-9f67-195a2eb72521673100ac-bd94-4239-942d-c525c5832e23",
                                                               "de2b754d-3cc5-454d-a1f7-e6ec095e48ca",
                                                               "72e9dc52-afde-4bb1-b0c5-35a2d14e8a5e2318ebc0-9ccc-4b28-95c0-0d54fe6af385620e2837-3f7b-43da-a2e9-9f5b317e1f867f63f54e-93d4-4247-b7e4-b1ebcd08f342",
                                                               new Date(1559560673274L));
        assertFalse(firmwareimageInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            FirmwareImage firmwareimage1 = new FirmwareImage(new Date(1559560668818L),
                                                             "85779654-505b-4457-ad07-7c5d52a6b67f", 82,
                                                             "cde1fd27-c802-4f1c-852a-058a804bbc24",
                                                             "db68de64-8660-4684-9b86-6c12f93305e7",
                                                             "e279fbcf-6893-4132-b4b7-0bd4f808fce0",
                                                             "256ee5ff-6b8f-4e71-82ae-0d4f37f70dd6",
                                                             new Date(1559560671990L));
            FirmwareImage firmwareimage2 = new FirmwareImage(new Date(1559560668818L),
                                                             "85779654-505b-4457-ad07-7c5d52a6b67f", 82,
                                                             "cde1fd27-c802-4f1c-852a-058a804bbc24",
                                                             "db68de64-8660-4684-9b86-6c12f93305e7",
                                                             "e279fbcf-6893-4132-b4b7-0bd4f808fce0",
                                                             "256ee5ff-6b8f-4e71-82ae-0d4f37f70dd6",
                                                             new Date(1559560671990L));
            FirmwareImage firmwareimage3 = new FirmwareImage(new Date(1559560668771L),
                                                             "0b5a37ed-1a78-49e5-b9f9-d58263e4e249", 66,
                                                             "852d1544-8538-4044-9ecc-ada1cdf8bb2d",
                                                             "59fe8156-9839-4630-b168-501f0fdf91d9",
                                                             "1a132580-9934-456a-9310-381eadf87752",
                                                             "5de8885a-b2d7-477f-9484-6860f56b9863",
                                                             new Date(1559560667313L));
            assertNotNull(firmwareimage1);
            assertNotNull(firmwareimage2);
            assertNotNull(firmwareimage3);
            assertNotSame(firmwareimage2, firmwareimage1);
            assertNotSame(firmwareimage3, firmwareimage1);
            assertEquals(firmwareimage2, firmwareimage1);
            assertEquals(firmwareimage2, firmwareimage1);
            assertEquals(firmwareimage1, firmwareimage2);
            assertEquals(firmwareimage1, firmwareimage1);
            assertFalse(firmwareimage1.equals(null));
            assertNotEquals(firmwareimage3, firmwareimage1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
