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
            SubtenantUser subtenantuser1 = new SubtenantUser("ae7a4e096c0cf61badbe341c63408ff3", null,
                                                             "6185c0ef-a792-432a-82e8-d281f12d68a1",
                                                             new Date(1559148833128L), 121, null,
                                                             "82033.d8016@41e7e.fr", false,
                                                             "2a8bd9b1-952d-49de-aa3f-25adb1930aa6",
                                                             "ae7a4e096c0cf61badbe341c63408ff3", true, true, false, -27,
                                                             null, null, "1e8dc6a3-d1c5-4561-a586-91937c49fbd6", 94,
                                                             "71a959af-62c8-4bc2-b3a0-443aa6ba872f",
                                                             SubtenantUserStatus.getDefault(), null,
                                                             new Date(1559148826047L), "=ZBe_=_.");
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
            SubtenantUser subtenantuser1 = new SubtenantUser("ae7a4e096c0cf61badbe341c63408ff3", null,
                                                             "794b61ee-86dc-4d5e-a277-940ad25b1a96",
                                                             new Date(1559148828515L), 44, null, "bdbbc.aba65@a1e1b.fr",
                                                             false, "d4f92739-3013-4dfb-af8b-7fdf28e98183",
                                                             "ae7a4e096c0cf61badbe341c63408ff3", false, true, true, -14,
                                                             null, null, "616017f5-a473-4ba6-a6f7-ff38835ea989", 19,
                                                             "c95cae6c-18c2-40d8-bf83-70c421904493",
                                                             SubtenantUserStatus.getDefault(), null,
                                                             new Date(1559148828143L), "=ZBe_=_.");
            SubtenantUser subtenantuser2 = new SubtenantUser("ae7a4e096c0cf61badbe341c63408ff3", null,
                                                             "794b61ee-86dc-4d5e-a277-940ad25b1a96",
                                                             new Date(1559148828515L), 44, null, "bdbbc.aba65@a1e1b.fr",
                                                             false, "d4f92739-3013-4dfb-af8b-7fdf28e98183",
                                                             "ae7a4e096c0cf61badbe341c63408ff3", false, true, true, -14,
                                                             null, null, "616017f5-a473-4ba6-a6f7-ff38835ea989", 19,
                                                             "c95cae6c-18c2-40d8-bf83-70c421904493",
                                                             SubtenantUserStatus.getDefault(), null,
                                                             new Date(1559148828143L), "=ZBe_=_.");
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
        SubtenantUser subtenantuser = new SubtenantUser("ae7a4e096c0cf61badbe341c63408ff3", null,
                                                        "e307fa65-6eb0-4047-a09b-1960b8b55dd7",
                                                        new Date(1559148833485L), 75, null, "01b59.9e5a0@360a3.me",
                                                        false, "ab4e930d-4063-4b84-831a-ce7f25f4f1bd",
                                                        "ae7a4e096c0cf61badbe341c63408ff3", true, true, false, -103,
                                                        null, null, "608ab3ad-e790-43d8-bf11-afaf0f254d77", -1,
                                                        "7302e476-9859-423c-99a5-8dc37f40420b",
                                                        SubtenantUserStatus.getDefault(), null,
                                                        new Date(1559148828716L), "=ZBe_=_.");
        assertTrue(subtenantuser.isValid());
        SubtenantUser subtenantuserInvalid = new SubtenantUser(null, null, "dbbb7628-a9f2-4df6-b1d0-be3f9bcd0255",
                                                               new Date(1559148832674L), 122, null, null, false,
                                                               "cedb8cf8-8d4b-48c2-92c4-a138efa9d6c860be8a13-cf70-4d13-83af-9bff64b8f6b0373232e0-665d-4703-b3c0-543bd33ed6ca",
                                                               "52*皆2?\u0015U25B⠢5\u0017궞\u000b5#\b2훹2\u00045HD�?�5O2[25\u0002222`FQﳎED鋂2%㓗5钀522\u0015뢬!H\u0016225茡5㮔2",
                                                               true, false, false, -79, null, null,
                                                               "d041ed65-c3fd-4d6a-b8eb-65a533279182", 49,
                                                               "2291c497-e2cd-4169-bb8f-2b1536c1d877f7a172d2-addf-450e-b6c8-a36d18376dc40c4dc2c9-a211-4100-ac8d-e6452856a49c",
                                                               SubtenantUserStatus.getDefault(), null,
                                                               new Date(1559148827438L),
                                                               ">\\\\\u0015\tc)Y18\u001c$$:\u0012]+I\bS휷JYS*72[>툯[4\\\\O0<\u001dAD@3cF?C[\u0011>d2]T1G1@4\u0003b-꿦1");
        assertFalse(subtenantuserInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            SubtenantUser subtenantuser1 = new SubtenantUser("ae7a4e096c0cf61badbe341c63408ff3", null,
                                                             "3868156e-70a3-45df-a2d3-3a4e949be818",
                                                             new Date(1559148827781L), -46, null,
                                                             "524bd.fc09d@9f100.fr", true,
                                                             "01b2e327-1b70-467a-ab76-3d7433052ab1",
                                                             "ae7a4e096c0cf61badbe341c63408ff3", false, true, false,
                                                             -85, null, null, "e321ff86-1b1d-47a7-a82a-c1b56d261f15",
                                                             -4, "e0bce429-4865-4194-8e68-dd76ab73e302",
                                                             SubtenantUserStatus.getDefault(), null,
                                                             new Date(1559148829149L), "=ZBe_=_.");
            SubtenantUser subtenantuser2 = new SubtenantUser("ae7a4e096c0cf61badbe341c63408ff3", null,
                                                             "3868156e-70a3-45df-a2d3-3a4e949be818",
                                                             new Date(1559148827781L), -46, null,
                                                             "524bd.fc09d@9f100.fr", true,
                                                             "01b2e327-1b70-467a-ab76-3d7433052ab1",
                                                             "ae7a4e096c0cf61badbe341c63408ff3", false, true, false,
                                                             -85, null, null, "e321ff86-1b1d-47a7-a82a-c1b56d261f15",
                                                             -4, "e0bce429-4865-4194-8e68-dd76ab73e302",
                                                             SubtenantUserStatus.getDefault(), null,
                                                             new Date(1559148829149L), "=ZBe_=_.");
            SubtenantUser subtenantuser3 = new SubtenantUser("ae7a4e096c0cf61badbe341c63408ff3", null,
                                                             "255b7ae1-687b-4e1c-8332-93607b8c5943",
                                                             new Date(1559148825798L), -22, null,
                                                             "4c7e1.ceebb@909df.fr", true,
                                                             "ba5706e6-0369-4da4-8796-e4e119c99f50",
                                                             "ae7a4e096c0cf61badbe341c63408ff3", false, true, false, 16,
                                                             null, null, "82d45c35-d278-4e34-a6c2-faaa29937df5", -85,
                                                             "f8faf398-2fdd-4859-b421-137fa3f84ade",
                                                             SubtenantUserStatus.getDefault(), null,
                                                             new Date(1559148827384L), "=ZBe_=_.");
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
