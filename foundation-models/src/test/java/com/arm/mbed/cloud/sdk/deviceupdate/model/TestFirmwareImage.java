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
            FirmwareImage firmwareimage1 = new FirmwareImage(new Date(1559148831655L),
                                                             "3a7bcf58-c3f9-48cd-8f37-b3adcb6b17d8", -73,
                                                             "0368d662-e559-4c56-b03b-bc05649b7970",
                                                             "c973b2e2-4b6e-4328-8abd-59391d7f5a3f",
                                                             "b99ffab9-f5df-43bb-9688-d6d29d871ce5",
                                                             "0e8dea84-6723-4641-b449-92146afb3675",
                                                             new Date(1559148835119L));
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
            FirmwareImage firmwareimage1 = new FirmwareImage(new Date(1559148830763L),
                                                             "87bab3e9-43eb-425a-8e8c-aeaa020c52c5", 13,
                                                             "11c1e37a-f14c-4a1b-ae14-63d90c166cf0",
                                                             "59728d0c-f65e-4697-ac3e-7a309ffbabeb",
                                                             "e940ef42-7f3c-4f91-b57e-e85724ceb981",
                                                             "dcadecf4-e472-4c8e-b377-2daf2695f4ce",
                                                             new Date(1559148828882L));
            FirmwareImage firmwareimage2 = new FirmwareImage(new Date(1559148830763L),
                                                             "87bab3e9-43eb-425a-8e8c-aeaa020c52c5", 13,
                                                             "11c1e37a-f14c-4a1b-ae14-63d90c166cf0",
                                                             "59728d0c-f65e-4697-ac3e-7a309ffbabeb",
                                                             "e940ef42-7f3c-4f91-b57e-e85724ceb981",
                                                             "dcadecf4-e472-4c8e-b377-2daf2695f4ce",
                                                             new Date(1559148828882L));
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
        FirmwareImage firmwareimage = new FirmwareImage(new Date(1559148827187L),
                                                        "50a234a7-3a23-415f-93b2-cf83e16840cf", 94,
                                                        "62799285-12b9-452c-b24e-614cfdb6159c",
                                                        "f22e7a02-9a8c-424b-a93f-d7e7ce4946b4",
                                                        "33d646fa-775d-4570-bb1b-5b9ddfd68666",
                                                        "e250ee02-a5f2-401c-a7d5-2aed993e7ce1",
                                                        new Date(1559148831115L));
        assertTrue(firmwareimage.isValid());
        FirmwareImage firmwareimageInvalid = new FirmwareImage(new Date(1559148832298L),
                                                               "db8d2616-c7cd-4450-b274-864642f89ad6", 13,
                                                               "c783f4e8-f8fa-42c7-9b7f-111056e19f5b",
                                                               "2f931b57-13c6-46dc-8fd1-cf90f3506a455209a34a-675a-41f3-bdae-3c27dcc2c0ea55c1d9ae-66f7-4bc8-b9e0-c8ea49102ba2a793b4a6-016d-4335-b87a-43ef6fb159893e89e1ee-7ad2-4346-91c8-2214fefe1536de4957db-3ddd-47ff-ad25-7fd83d77315e3150c38e-4b65-444f-ade3-cec1867360f578297b4e-679a-4f79-96dd-b5697794e97ce0a0aa23-ed33-4e03-b6f4-f8a885803c7a2287ad21-a0a1-4d8e-914e-252a2fd897a2020a1bad-bbb4-4062-b10d-d9248bf0f88aaf202dde-ee70-49ff-97df-5d136b82487d546041e2-2693-425b-8bc6-fee7fa4e7df688a5afe3-1445-4011-a896-62a31850f39f40574352-9a39-43ca-a35c-9c1d366a36b655ebf7af-a2e1-4e3d-a482-52ac0c3df6032f60607a-5025-4480-9042-23a72c991bb04a84d3a0-8ce2-467a-a659-56196976bc4cc547a414-71ee-4bbb-8d96-1e2f3c3a53041b169e55-faa3-4e1b-8f12-a2da3f02810b4034e527-f856-4149-99a6-92b6b213750e6a695ea3-ca6e-459f-8cd7-563aaefdf222be624ef9-6665-402f-9a1f-6c2e9effcbf0d0529ece-a357-4322-a91f-9943c13c38bbc2a8ff7c-b881-417f-8082-25399e0ef1bb03e23e76-8b95-4eea-bcd7-112f04a61027b81388f4-faa7-402f-b5ef-c511025e66b145d35df9-55e3-42bc-bf44-7a02b7d213cb5bdbdc6f-1f29-48e4-bbd4-1c19e2d398bcd48a386d-cd6d-4988-91f2-b584dfcedb9ddd97620b-1b16-4912-8485-03d2451b654d41638e80-382b-403f-a03b-1537d3e5eeed5393e4ca-9962-431d-8e53-580324513bc8c8a4ac7f-e83a-4b07-be87-16cc12c753e647778b0c-9c8e-432e-a569-9e402a0e947d5bcbc370-daea-4fcc-802d-90a4dc4568b619b967ea-352b-496b-92a2-27b69584ca53c187f406-a007-4ca4-9a55-d7bdd0e129db3a869d6e-982a-4779-91d0-d7f163f080debc0ebcd7-314c-497e-a836-f6bd96a8c260a7f15484-8cbe-46f4-a227-779f656085d1f4b84ac4-9df4-4812-8a0d-9e1791f3179f600ed33b-b870-45b4-af35-b9fb052d6dfd222a1700-bf96-45b1-aa9e-89d1ab543940a67bc6df-d9bf-4742-acc3-0d92c55b1c901857203e-9872-41d2-a052-cb8dd182113181eaf398-4c61-440e-b439-fa7399ec1ead5d784ef7-1f30-4d15-b51e-f58316df3b64912ac3b1-517c-4f0d-9efa-77ddf1eadd6b8b2956d7-bca9-408b-953d-0c0b0b4905d215b2ce17-568b-40f2-9145-5ea0136ce37df7ba9c29-8427-4f4c-947a-b08c865396a4098b2d0b-e023-4ea5-a3c1-e54419016844952157a6-c587-4caa-812f-8c25920070940e2412db-78fe-46b9-a095-8984006989045a934cf7-0192-4fb2-be29-673ae297064d",
                                                               "b0797022-a51f-4627-a95a-8f66123a1e4c",
                                                               "762bc5b9-43dc-46ab-8ff5-65a6aa7300aa43115817-045a-4df5-a171-3cdecef5da8ad3ef0fb0-856e-416b-a62a-c8db70e6d346408bebae-d79a-4f9e-a7ef-6e3cb757f947",
                                                               new Date(1559148825665L));
        assertFalse(firmwareimageInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            FirmwareImage firmwareimage1 = new FirmwareImage(new Date(1559148826522L),
                                                             "b838d823-eaed-4eb9-b3dc-2456ad7f4a5c", -127,
                                                             "99d5cf94-ca36-42bd-abe4-b7d52ae6ee6d",
                                                             "5b9e72aa-f95c-4006-91ba-912ca65b15a4",
                                                             "5b12c696-6155-415a-a13d-4ff68db5c25e",
                                                             "146e6fdc-f633-479c-b6b2-06c80e522a5e",
                                                             new Date(1559148829815L));
            FirmwareImage firmwareimage2 = new FirmwareImage(new Date(1559148826522L),
                                                             "b838d823-eaed-4eb9-b3dc-2456ad7f4a5c", -127,
                                                             "99d5cf94-ca36-42bd-abe4-b7d52ae6ee6d",
                                                             "5b9e72aa-f95c-4006-91ba-912ca65b15a4",
                                                             "5b12c696-6155-415a-a13d-4ff68db5c25e",
                                                             "146e6fdc-f633-479c-b6b2-06c80e522a5e",
                                                             new Date(1559148829815L));
            FirmwareImage firmwareimage3 = new FirmwareImage(new Date(1559148826823L),
                                                             "0466f12a-1190-4071-8dad-c021613ee4b6", -16,
                                                             "afad267a-b366-4006-a973-eae6d71ccc95",
                                                             "2c3513e6-fb30-4258-b0af-38039b821793",
                                                             "01770f45-b8ca-4b9c-8a0d-76be52d9816e",
                                                             "d292c8d1-1e02-4fdb-9427-b502ae6a0ac7",
                                                             new Date(1559148835158L));
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
