// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model ApiKey.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestApiKey {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            ApiKey apikey1 = new ApiKey("ebb6e571ba299e09d8e8859accae6efa", new Date(1558003275802L), -128,
                                        "ebb6e571ba299e09d8e8859accae6efa", "b94bae15-eb85-4f0b-98d7-1a0e7b6b8424", 86,
                                        "34d7be1c-7273-4166-8872-8d00ff09c5c1", "ebb6e571ba299e09d8e8859accae6efa",
                                        ApiKeyStatus.getDefault(), new Date(1558003279786L));
            ApiKey apikey2 = apikey1.clone();
            assertNotNull(apikey1);
            assertNotNull(apikey2);
            assertNotSame(apikey2, apikey1);
            assertEquals(apikey2, apikey1);
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
            ApiKey apikey1 = new ApiKey("ebb6e571ba299e09d8e8859accae6efa", new Date(1558003281460L), 78,
                                        "ebb6e571ba299e09d8e8859accae6efa", "80c116c6-0baa-4cc2-ba50-0832633363ab", -97,
                                        "87939600-977a-4d38-8e95-63387c20210a", "ebb6e571ba299e09d8e8859accae6efa",
                                        ApiKeyStatus.getDefault(), new Date(1558003279634L));
            ApiKey apikey2 = new ApiKey("ebb6e571ba299e09d8e8859accae6efa", new Date(1558003281460L), 78,
                                        "ebb6e571ba299e09d8e8859accae6efa", "80c116c6-0baa-4cc2-ba50-0832633363ab", -97,
                                        "87939600-977a-4d38-8e95-63387c20210a", "ebb6e571ba299e09d8e8859accae6efa",
                                        ApiKeyStatus.getDefault(), new Date(1558003279634L));
            assertNotNull(apikey1);
            assertNotNull(apikey2);
            assertNotSame(apikey2, apikey1);
            assertEquals(apikey2, apikey1);
            assertEquals(apikey2.hashCode(), apikey1.hashCode());
            int hashCode = apikey1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, apikey1.hashCode());
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
        ApiKey apikey = new ApiKey("ebb6e571ba299e09d8e8859accae6efa", new Date(1558003275406L), 42,
                                   "ebb6e571ba299e09d8e8859accae6efa", "d13345ff-addc-4d1f-b42f-f7962bc04fbd", 15,
                                   "e7409c8f-6213-45db-ad03-b0b920155b92", "ebb6e571ba299e09d8e8859accae6efa",
                                   ApiKeyStatus.getDefault(), new Date(1558003281665L));
        assertTrue(apikey.isValid());
        ApiKey apikeyInvalid = new ApiKey("\u000143兲ᥢ3& ][[枠34P\u0006[43=44V44覠뺔ຫ&\b㘒\u001e\u001f餆S.4:F\t333!?3,!4Wᰓ(3O\u0004綱骾B3\u0012",
                                          new Date(1558003277788L), -57,
                                          "\u000143兲ᥢ3& ][[枠34P\u0006[43=44V44覠뺔ຫ&\b㘒\u001e\u001f餆S.4:F\t333!?3,!4Wᰓ(3O\u0004綱骾B3\u0012",
                                          "1dc50e69-a768-48c7-a2d9-ef6c51397262", -120, null,
                                          "\u000143兲ᥢ3& ][[枠34P\u0006[43=44V44覠뺔ຫ&\b㘒\u001e\u001f餆S.4:F\t333!?3,!4Wᰓ(3O\u0004綱骾B3\u0012",
                                          ApiKeyStatus.getDefault(), new Date(1558003273967L));
        assertFalse(apikeyInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            ApiKey apikey1 = new ApiKey("ebb6e571ba299e09d8e8859accae6efa", new Date(1558003273845L), 17,
                                        "ebb6e571ba299e09d8e8859accae6efa", "eff8ce92-e3bc-456a-8c2f-baf5a3e506d1", -80,
                                        "dbcb4ed0-3821-45a3-9a38-ca3d3cf22764", "ebb6e571ba299e09d8e8859accae6efa",
                                        ApiKeyStatus.getDefault(), new Date(1558003279265L));
            ApiKey apikey2 = new ApiKey("ebb6e571ba299e09d8e8859accae6efa", new Date(1558003273845L), 17,
                                        "ebb6e571ba299e09d8e8859accae6efa", "eff8ce92-e3bc-456a-8c2f-baf5a3e506d1", -80,
                                        "dbcb4ed0-3821-45a3-9a38-ca3d3cf22764", "ebb6e571ba299e09d8e8859accae6efa",
                                        ApiKeyStatus.getDefault(), new Date(1558003279265L));
            ApiKey apikey3 = new ApiKey("ebb6e571ba299e09d8e8859accae6efa", new Date(1558003281326L), 78,
                                        "ebb6e571ba299e09d8e8859accae6efa", "465918af-4d5e-4811-b9d6-9b79e06d4151", 35,
                                        "ea9793db-8e84-4d93-89ff-23c7a3b774f5", "ebb6e571ba299e09d8e8859accae6efa",
                                        ApiKeyStatus.getDefault(), new Date(1558003278811L));
            assertNotNull(apikey1);
            assertNotNull(apikey2);
            assertNotNull(apikey3);
            assertNotSame(apikey2, apikey1);
            assertNotSame(apikey3, apikey1);
            assertEquals(apikey2, apikey1);
            assertEquals(apikey2, apikey1);
            assertEquals(apikey1, apikey2);
            assertEquals(apikey1, apikey1);
            assertFalse(apikey1.equals(null));
            assertNotEquals(apikey3, apikey1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
