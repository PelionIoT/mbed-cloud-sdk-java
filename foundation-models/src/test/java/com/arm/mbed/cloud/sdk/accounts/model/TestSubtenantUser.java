// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model SubtenantUser.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantUser {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            SubtenantUser subtenantuser1 = new SubtenantUser("acbf655bdeac77c770ad4964fcb1f81f", null,
                                                             "18a88aa6-6eb2-44aa-a774-e65dc24329e4",
                                                             new Date(1559747928956L), -128, null,
                                                             "fd768.b9379@f274d.fr", false,
                                                             "5d06300a-e12e-44da-bf49-c39c58747cf7",
                                                             "acbf655bdeac77c770ad4964fcb1f81f", false, true, false,
                                                             -75, null, null, "01218470-72a6-4806-8be6-36b546890869",
                                                             -92, "c52af071-fb00-4d09-914b-1402a2ba1312",
                                                             SubtenantUserStatus.getDefault(), null,
                                                             new Date(1559747928627L), "d=X9-");
            SubtenantUser subtenantuser2 = subtenantuser1.clone();
            assertNotNull(subtenantuser1);
            assertNotNull(subtenantuser2);
            assertNotSame(subtenantuser2, subtenantuser1);
            assertEquals(subtenantuser2, subtenantuser1);
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
            SubtenantUser subtenantuser1 = new SubtenantUser("acbf655bdeac77c770ad4964fcb1f81f", null,
                                                             "f494533a-eee1-46b9-876c-4e501b568502",
                                                             new Date(1559747932436L), -49, null,
                                                             "ca450.57e65@01ec3.me", false,
                                                             "78ef13a7-4ba3-49ff-b984-db69daa67e36",
                                                             "acbf655bdeac77c770ad4964fcb1f81f", true, true, false, 120,
                                                             null, null, "14537659-47ac-4d34-bf19-81e8b42c1c41", 66,
                                                             "130b0c59-e83c-4a6c-bab5-f655e1413dea",
                                                             SubtenantUserStatus.getDefault(), null,
                                                             new Date(1559747928371L), "d=X9-");
            SubtenantUser subtenantuser2 = new SubtenantUser("acbf655bdeac77c770ad4964fcb1f81f", null,
                                                             "f494533a-eee1-46b9-876c-4e501b568502",
                                                             new Date(1559747932436L), -49, null,
                                                             "ca450.57e65@01ec3.me", false,
                                                             "78ef13a7-4ba3-49ff-b984-db69daa67e36",
                                                             "acbf655bdeac77c770ad4964fcb1f81f", true, true, false, 120,
                                                             null, null, "14537659-47ac-4d34-bf19-81e8b42c1c41", 66,
                                                             "130b0c59-e83c-4a6c-bab5-f655e1413dea",
                                                             SubtenantUserStatus.getDefault(), null,
                                                             new Date(1559747928371L), "d=X9-");
            assertNotNull(subtenantuser1);
            assertNotNull(subtenantuser2);
            assertNotSame(subtenantuser2, subtenantuser1);
            assertEquals(subtenantuser2, subtenantuser1);
            assertEquals(subtenantuser2.hashCode(), subtenantuser1.hashCode());
            int hashCode = subtenantuser1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, subtenantuser1.hashCode());
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
        SubtenantUser subtenantuser = new SubtenantUser("acbf655bdeac77c770ad4964fcb1f81f", null,
                                                        "72dd23fb-abb4-4c91-82f4-ea31590e87c3",
                                                        new Date(1559747926824L), -85, null, "c3e37.62295@38cb9.fr",
                                                        true, "3aad791f-557b-45b3-95a6-568963e5f478",
                                                        "acbf655bdeac77c770ad4964fcb1f81f", true, true, true, -95, null,
                                                        null, "33588621-dab1-4de3-84df-443f6bf13cd8", 19,
                                                        "71495b3e-1075-49ca-97e9-390bd6f6a3fb",
                                                        SubtenantUserStatus.getDefault(), null,
                                                        new Date(1559747935028L), "d=X9-");
        assertTrue(subtenantuser.isValid());
        SubtenantUser subtenantuserInvalid = new SubtenantUser(null, null, "f5f4b27f-b779-4043-bf57-b2d708363839",
                                                               new Date(1559747931293L), 51, null, null, true,
                                                               "2bf3b9a6-07d2-4aa8-988a-5451a1ab5354be6c9dac-043e-48d3-b49b-c7e4670e979f9c3a5248-0325-40ac-bd9e-2a763c49cced",
                                                               "ꀊ+(褑32\f3X\u0005;\\\\2\u001aA䣽-2ᗜN22&\\\\X\u00023\u00023OJ3\u00012Z*\u000f2\u0007I�?3V3젎3'\u00142Σ뛄\b<XN磀뾆)3.廉",
                                                               true, true, true, 102, null, null,
                                                               "c7a08ef2-f92a-4d06-88b2-e26e8be107c6", -45,
                                                               "d2bc2592-68b8-475c-bba9-2c5e098cdd9825eca262-b66c-4b18-b0b0-05ea13278897dc9f27c1-bb9d-4a03-8ffe-a7e310ae9587",
                                                               SubtenantUserStatus.getDefault(), null,
                                                               new Date(1559747930798L),
                                                               "ꢦ�?�b$$:퇉%婫\bb\u0012(<\u001e;`<::<F඘?<;G%亴R딓PY#\u001fKP⩩:I7a>]᷀Lc;YP2;ﳈ[;:J:%a\u000b:\u0001�?�");
        assertFalse(subtenantuserInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            SubtenantUser subtenantuser1 = new SubtenantUser("acbf655bdeac77c770ad4964fcb1f81f", null,
                                                             "c1f20e8b-d713-4ffa-b2a8-ecbdc4c61167",
                                                             new Date(1559747934813L), -48, null,
                                                             "10149.fb897@1ec5f.fr", true,
                                                             "9ddf6404-de69-49a2-9bc1-6ea1070705f9",
                                                             "acbf655bdeac77c770ad4964fcb1f81f", false, true, false,
                                                             114, null, null, "6cbbda7c-8e8b-4dae-aed3-c4d9459de851",
                                                             79, "afacdbcd-f1e1-45fc-8057-b3c97a504e14",
                                                             SubtenantUserStatus.getDefault(), null,
                                                             new Date(1559747926427L), "d=X9-");
            SubtenantUser subtenantuser2 = new SubtenantUser("acbf655bdeac77c770ad4964fcb1f81f", null,
                                                             "c1f20e8b-d713-4ffa-b2a8-ecbdc4c61167",
                                                             new Date(1559747934813L), -48, null,
                                                             "10149.fb897@1ec5f.fr", true,
                                                             "9ddf6404-de69-49a2-9bc1-6ea1070705f9",
                                                             "acbf655bdeac77c770ad4964fcb1f81f", false, true, false,
                                                             114, null, null, "6cbbda7c-8e8b-4dae-aed3-c4d9459de851",
                                                             79, "afacdbcd-f1e1-45fc-8057-b3c97a504e14",
                                                             SubtenantUserStatus.getDefault(), null,
                                                             new Date(1559747926427L), "d=X9-");
            SubtenantUser subtenantuser3 = new SubtenantUser("acbf655bdeac77c770ad4964fcb1f81f", null,
                                                             "d0df21e6-f287-463c-9933-e09b0b128d3a",
                                                             new Date(1559747926599L), 0, null, "20d5f.3b7b5@14a6c.me",
                                                             true, "e7935dd3-1931-4cb0-aa2a-e41cfa991a01",
                                                             "acbf655bdeac77c770ad4964fcb1f81f", false, true, false,
                                                             -18, null, null, "fb9a5a34-c9e8-4a58-b34e-99d5706cca26",
                                                             69, "42b29c0f-67e5-491e-afc7-e8c90de1f879",
                                                             SubtenantUserStatus.getDefault(), null,
                                                             new Date(1559747929854L), "d=X9-");
            assertNotNull(subtenantuser1);
            assertNotNull(subtenantuser2);
            assertNotNull(subtenantuser3);
            assertNotSame(subtenantuser2, subtenantuser1);
            assertNotSame(subtenantuser3, subtenantuser1);
            assertEquals(subtenantuser2, subtenantuser1);
            assertEquals(subtenantuser2, subtenantuser1);
            assertEquals(subtenantuser1, subtenantuser2);
            assertEquals(subtenantuser1, subtenantuser1);
            assertFalse(subtenantuser1.equals(null));
            assertNotEquals(subtenantuser3, subtenantuser1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
