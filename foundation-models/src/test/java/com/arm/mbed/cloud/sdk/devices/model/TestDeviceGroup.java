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
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1559762574295L), null,
                                                       "30c7e1f0-24f6-4998-92d2-d07a99925be4", 22,
                                                       "2e94c6d3-7e9b-4a7e-8a49-a6106affa8e7",
                                                       "707dac59-92e7-41da-838e-abce884ca694",
                                                       new Date(1559762577613L));
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
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1559762579545L), null,
                                                       "4b92ce6c-71a9-472c-8dd3-dfcf3a4c67c2", -113,
                                                       "f10b10e3-041b-4b8f-ad82-1de93cefd840",
                                                       "be7e34e6-e85f-4500-9e86-16280d09541a",
                                                       new Date(1559762581845L));
            DeviceGroup devicegroup2 = new DeviceGroup(new Date(1559762579545L), null,
                                                       "4b92ce6c-71a9-472c-8dd3-dfcf3a4c67c2", -113,
                                                       "f10b10e3-041b-4b8f-ad82-1de93cefd840",
                                                       "be7e34e6-e85f-4500-9e86-16280d09541a",
                                                       new Date(1559762581845L));
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
        DeviceGroup devicegroup = new DeviceGroup(new Date(1559762575408L), null,
                                                  "28184620-ffcf-4f10-b9b9-6bcbf8ab48e5", 14,
                                                  "35acdf28-9cc0-4196-9c99-e8df01c7ed45",
                                                  "4685142d-4386-4d32-aa9e-ffbe4dd31e22", new Date(1559762574386L));
        assertTrue(devicegroup.isValid());
        DeviceGroup devicegroupInvalid = new DeviceGroup(new Date(1559762580033L), null,
                                                         "f5098be8-781e-4af4-9b8b-d6bd284580fb0a5ef234-1816-426a-b69b-6ddb6da90137e9087340-aede-40fc-821c-1458a7e29b0a513be09d-6069-4366-8033-8d34fb2f0807a3a1c87c-821c-42b4-b70d-c0647a998a2917e502e5-f85c-47af-9dba-a8f33689d702ffb0284e-44ea-48da-88e7-8d9ef065532c1fa9661b-90e2-4445-ab57-8c93f6c7f1aed4f6e35f-e9b0-4241-af0b-f5548ef129b8b4a829a1-7949-4799-b2cd-0653152330964482894a-92c3-4aaa-8767-7b794a3e225f277e157b-a6ce-4359-a6f3-e095424a591eac2a989c-1c5e-4772-80b7-cc587d26f9df0517ae2b-50dd-4b2e-ad98-bbf1ed6778bb1d612b6c-019b-4351-9909-6991aacd4928df841d5a-79d5-4947-b321-1c4b4215f94622b046a8-1400-450c-848e-bc84f48c2315c03660da-d2f2-4215-b8fd-1110724929af9f8b5c9e-606c-41c1-a3ea-61f6160b545da3cb533b-0085-4a67-90b4-23d559bedd4262301852-4a63-4715-8728-bf0ec420e1d0c1aae3fb-ea56-4061-9dc8-3a7ac02abf24e71d4914-c957-40ab-ad07-28f77ff2637b1051fc06-4539-4e57-a0a2-dd0135f051da1d95a89e-c674-43a4-808e-3f2381588b3d0bac618d-2dd7-47be-a641-c1b98e1de957d9af81f4-8662-4e57-99a4-8af0ad76e75f062fed5a-575b-4587-917c-ae428741fe872160569b-6120-4224-a8b8-203ee7f007216349cfaf-7c41-4978-9327-5621e1944de0ca201f86-e336-4284-9d26-dcac603ad14905fda71d-5df6-409a-a0a0-9e86207d23adc8fb751f-b4a5-4041-adbd-2027ad3f2fac31cc8662-b1f2-40b3-83d5-9838038ab7727a7020db-93d4-4ee0-8fea-83b651b49a7bf74e7cab-de2f-4b7a-a37c-7165d863c1b3dee05e32-9a39-4c4c-866b-2b83c958ceb96248d533-c12d-47c9-9454-c7b6f4011f75d4f98b5e-436b-4cad-81e7-7635782c2e91b0d175fb-dd56-4c03-8d5f-29113b58fae5ee2318ee-ab5d-46d2-ab18-c3d10da2387303d6a2e9-e426-4dc4-a31a-53e90603958d1a534aa6-0a54-4292-87d5-652793c5c6a992bb1ee3-0e78-4a88-a2bc-b0a6e58f261fd7f2a6f7-8f03-49c8-b9a7-de2964a605ab1d783a3f-d8de-4d96-bedf-0703319173d9ecbb4d62-d14e-4ac4-bf68-fc3c51eca95ff08b0b23-0849-4f8c-acc3-581a495a08572a5cece7-0470-491d-a8d4-d2edf03a3323761f2d63-3c21-433e-a08a-81d7f3fa154be39390b9-3b2d-41c4-b01b-2550f44600a237474118-9523-4d95-aad0-a33418738db5aa02a07b-ce3b-4f21-91e9-af2a492139883b7a9e36-126d-4601-854c-55dbaa5f8a3d7cb12545-2980-4564-bc65-285320186a7dcbefa0b7-dc91-4961-8172-0d710be5abf6",
                                                         2, "7931b346-dda4-4eab-b316-0c2d616d2272",
                                                         "b60eb25d-2588-4be0-9ae3-54b77b7dfc26f4d7d1e2-d3c2-4119-ac46-f033a8470217f0c16e15-7bb7-4845-8ff3-497c262e0d1eaea09d92-4821-4529-9760-e8fc2f2c6dd4",
                                                         new Date(1559762577319L));
        assertFalse(devicegroupInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1559762580227L), null,
                                                       "4c98edb3-90b4-48dc-9111-0621f4a59e4a", 108,
                                                       "03d4f815-b944-4513-8fa1-6d690d648d52",
                                                       "7640d860-5d88-4b41-9737-66fdb1d2a57c",
                                                       new Date(1559762580174L));
            DeviceGroup devicegroup2 = new DeviceGroup(new Date(1559762580227L), null,
                                                       "4c98edb3-90b4-48dc-9111-0621f4a59e4a", 108,
                                                       "03d4f815-b944-4513-8fa1-6d690d648d52",
                                                       "7640d860-5d88-4b41-9737-66fdb1d2a57c",
                                                       new Date(1559762580174L));
            DeviceGroup devicegroup3 = new DeviceGroup(new Date(1559762581542L), null,
                                                       "bdd7eff9-1212-4dda-b729-0d6e465e38fb", -93,
                                                       "cf7440ff-0ed1-4cc6-aeb9-1c274b9e729b",
                                                       "122d487f-a7e7-4c2f-8457-ee6d1f6c5776",
                                                       new Date(1559762574456L));
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
