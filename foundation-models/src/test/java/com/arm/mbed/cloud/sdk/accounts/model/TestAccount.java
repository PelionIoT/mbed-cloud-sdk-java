// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model Account.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestAccount {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            Account account1 = new Account("08b0733d-cdaf-4d45-8127-07491c89841a",
                                           "d94641bf-a8f1-4686-adcf-0b5c08a74bf5",
                                           "c89c1b26-4c9d-4858-a7ad-034d2cba9991",
                                           "e14f3f8d-3d3f-4f09-b806-13b524fc9766",
                                           "399a3ca1-c50c-4ac9-b5ef-eeb6c94c88e2",
                                           "25ccb184-947b-4fa4-90f8-07dbb311edea",
                                           "956ddf27-2794-4688-8875-97f32240f501",
                                           "15cdb117-4da5-4d8b-a4df-7e2fa7ad6885", null,
                                           "ff0d76f0-e050-4d7e-a01f-aa1ae51d8d65",
                                           "a1319876-de02-47da-8cc6-2a5732c9f815",
                                           "34ea492a-bb16-4716-8f8d-e262c57ebccc",
                                           "308564ef-2e18-422c-b8cb-8cf622f445a0",
                                           "b4fd37aa-753a-4615-8fdb-9e241b42778f", new Date(1553793330583L), null,
                                           "0cb10d43-0ce8-4661-95a1-8bf1603c27e7",
                                           "28eacb73-0478-4e26-8870-f1bbd076b2fd",
                                           "13245c7b-f594-4523-b8e3-f0dce3e13ce1",
                                           "bc4fefb2-4344-47cd-b9e9-5dfe79ed1ef5", new Date(1553793335898L),
                                           "069ac92a-ed0e-4a5d-9a48-8bcc3c84512e",
                                           "8f163a80-6854-4dc8-95c8-eb7da872f2c3",
                                           "3b7799b2-f8f0-4a7c-910d-f0c9d5577168", null, AccountMfaStatus.getDefault(),
                                           null, new ParentAccount(), "e53e2176-f231-4255-b8a8-c752fb82b4c8",
                                           new PasswordPolicy(), 1, "cbae3e4e-1d27-43eb-89be-3c2613050920", null,
                                           "3f888bca-ede5-41c3-8d58-6ae5d1314636",
                                           "248d6a1d-9dd1-49dc-b983-4ff0f4658a1d",
                                           "dc13fed2-0d23-4930-983a-1a5dd0b98425",
                                           "7125e825-ee6a-4867-beb0-10aede06859a",
                                           "77cb2b67-5cee-4a51-ae87-65f6f553301c", AccountStatus.getDefault(),
                                           "312680e8-a075-45c5-ab77-079f04caac2f",
                                           "80c16e9d-6b0e-4650-9497-39c17ee1d69a", new Date(1553793333725L),
                                           new Date(1553793332376L));
            Account account2 = account1.clone();
            assertNotNull(account1);
            assertNotNull(account2);
            assertNotSame(account2, account1);
            assertEquals(account2, account1);
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
            Account account1 = new Account("3b1becf5-bc57-43fe-849c-a86ea3c9c1df",
                                           "8e0ad6f7-74eb-454c-ac92-b6dca9eb41be",
                                           "8f7f2ba4-2468-495e-8079-a95a0f51c3a4",
                                           "3443004e-d29c-4fcf-9364-f1d3bc84803f",
                                           "e076dd14-f359-4ac6-a37a-b1b5a94a2d48",
                                           "3de04881-ffcc-4430-9807-65ea94e6d74e",
                                           "1999c6ed-15eb-4384-837a-8bcab23584ea",
                                           "f4b66cf4-75fc-491a-837f-c2a68de1d4e6", null,
                                           "9d4e1f61-7887-42c6-9afb-dbd5fb4c41b9",
                                           "a591e05a-e843-4966-bdee-23757477319a",
                                           "6d2104a5-1b7a-496a-aa8f-10ee7755554f",
                                           "0025fa92-ba84-4fa3-9f27-89ac34cc7fbe",
                                           "0b6a9ee1-4c64-4c8f-9900-80c5f89745a9", new Date(1553793333703L), null,
                                           "068213f9-12ac-42e2-bd84-cae603e8bbdd",
                                           "97bdae08-d69b-4b4b-845d-dcc77c32538d",
                                           "77e7cdda-4617-4bda-afa7-e3ca5199f641",
                                           "0db75d75-d1c6-4190-8570-56c02aefe76e", new Date(1553793331495L),
                                           "d516b161-ce5f-44d2-ac9f-5baaf3271609",
                                           "c14f17af-eb3e-4a0b-9954-67cfce368cd5",
                                           "e1e68d7f-2e0b-41ce-ba19-9fcd78ba8ace", null, AccountMfaStatus.getDefault(),
                                           null, new ParentAccount(), "5e90011e-ab7f-4ef7-a31f-ff052e4fdf20",
                                           new PasswordPolicy(), 1, "b280bccd-5e61-4104-9eb2-095d55424850", null,
                                           "42c06eb4-9c6f-4589-8e36-84de3699053a",
                                           "d3642cc6-ce56-4a46-94f0-a5e23cc69d81",
                                           "f9a8cf4b-1a41-4248-a161-40c04ef3a509",
                                           "39e4f20c-6e7b-4864-8f1f-6aa67f7e1b1c",
                                           "27fbbb44-2adc-41a5-9667-f046243cd5b0", AccountStatus.getDefault(),
                                           "c3b02e78-1ac7-4edb-8570-6be2159ba88b",
                                           "c462a403-0e10-4724-aba4-6d78bf98b103", new Date(1553793326662L),
                                           new Date(1553793328564L));
            Account account2 = new Account("3b1becf5-bc57-43fe-849c-a86ea3c9c1df",
                                           "8e0ad6f7-74eb-454c-ac92-b6dca9eb41be",
                                           "8f7f2ba4-2468-495e-8079-a95a0f51c3a4",
                                           "3443004e-d29c-4fcf-9364-f1d3bc84803f",
                                           "e076dd14-f359-4ac6-a37a-b1b5a94a2d48",
                                           "3de04881-ffcc-4430-9807-65ea94e6d74e",
                                           "1999c6ed-15eb-4384-837a-8bcab23584ea",
                                           "f4b66cf4-75fc-491a-837f-c2a68de1d4e6", null,
                                           "9d4e1f61-7887-42c6-9afb-dbd5fb4c41b9",
                                           "a591e05a-e843-4966-bdee-23757477319a",
                                           "6d2104a5-1b7a-496a-aa8f-10ee7755554f",
                                           "0025fa92-ba84-4fa3-9f27-89ac34cc7fbe",
                                           "0b6a9ee1-4c64-4c8f-9900-80c5f89745a9", new Date(1553793333703L), null,
                                           "068213f9-12ac-42e2-bd84-cae603e8bbdd",
                                           "97bdae08-d69b-4b4b-845d-dcc77c32538d",
                                           "77e7cdda-4617-4bda-afa7-e3ca5199f641",
                                           "0db75d75-d1c6-4190-8570-56c02aefe76e", new Date(1553793331495L),
                                           "d516b161-ce5f-44d2-ac9f-5baaf3271609",
                                           "c14f17af-eb3e-4a0b-9954-67cfce368cd5",
                                           "e1e68d7f-2e0b-41ce-ba19-9fcd78ba8ace", null, AccountMfaStatus.getDefault(),
                                           null, new ParentAccount(), "5e90011e-ab7f-4ef7-a31f-ff052e4fdf20",
                                           new PasswordPolicy(), 1, "b280bccd-5e61-4104-9eb2-095d55424850", null,
                                           "42c06eb4-9c6f-4589-8e36-84de3699053a",
                                           "d3642cc6-ce56-4a46-94f0-a5e23cc69d81",
                                           "f9a8cf4b-1a41-4248-a161-40c04ef3a509",
                                           "39e4f20c-6e7b-4864-8f1f-6aa67f7e1b1c",
                                           "27fbbb44-2adc-41a5-9667-f046243cd5b0", AccountStatus.getDefault(),
                                           "c3b02e78-1ac7-4edb-8570-6be2159ba88b",
                                           "c462a403-0e10-4724-aba4-6d78bf98b103", new Date(1553793326662L),
                                           new Date(1553793328564L));
            assertNotNull(account1);
            assertNotNull(account2);
            assertNotSame(account2, account1);
            assertEquals(account2, account1);
            assertEquals(account2.hashCode(), account1.hashCode());
            int hashCode = account1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, account1.hashCode());
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
        Account account = new Account("67044a1a-b97e-4fb3-892b-c1e7c5f40635", "e82359ae-e69b-48b6-9245-7ef0be815607",
                                      "b28907aa-ccd2-47d7-8900-43488012422c", "883eeba5-5078-4381-8e4b-a192a35f637c",
                                      "860df363-e826-483b-9af5-778149ff80c8", "e4bbaeda-c8e3-41b0-8057-443574fec527",
                                      "87cd860b-b1fe-4af9-9f6d-962d5fcad0ae", "52577e3c-81f0-4b25-b240-dcd44b3aa697",
                                      null, "0b8e24b4-db0f-48bb-a19f-28f1058bcc76",
                                      "d085468d-32cd-4683-9f5a-e569548a25a2", "ad30bd0a-c6b6-43be-aea4-26fe5d1922b7",
                                      "105a7000-21ce-4a07-97da-0de19c995055", "6da5a30f-ef19-4212-84db-22cc8eac08de",
                                      new Date(1553793336436L), null, "5a620ab1-fe01-4c62-bd35-f1aded05c425",
                                      "c259677d-9713-40f0-a01a-9fc84cbc68b8", "4a5c1028-3952-4967-abff-9be03b2e24d5",
                                      "ccf997a5-a98d-40d6-8492-e12f1c755ca6", new Date(1553793336177L),
                                      "09443b00-233b-40e2-8665-d3bf4ac9d0ca", "5d971bf2-0ae4-4b27-a932-9e75f6c23e3d",
                                      "a8a718d2-d7ed-403d-8040-51581b5042d1", null, AccountMfaStatus.getDefault(), null,
                                      new ParentAccount(), "bbf2437f-35e3-4278-8867-5e6230801550", new PasswordPolicy(),
                                      1, "e2467fee-691d-4e60-8865-c6bbcaadab7d", null,
                                      "143ac62d-51e0-4840-a6bc-4c7eed1b569e", "e65e38c7-adaf-4cae-b132-3229bfdeac6f",
                                      "c6a2f519-09c7-4c6f-81f8-6a0ec7737b21", "6181f2d4-16f6-4a25-bec8-c8185c79be7f",
                                      "845ea31c-db3f-4cb6-b0ce-233add6dfd30", AccountStatus.getDefault(),
                                      "96e9ae22-9ac5-405c-b0a8-8dfd1a88b50b", "128a4dec-bea3-4838-b8f5-b237d4e91fe5",
                                      new Date(1553793335866L), new Date(1553793328429L));
        assertTrue(account.isValid());
        Account accountInvalid = new Account("35e1b465-ac5d-4b05-ba15-f3ff0cf88d34",
                                             "c6110764-e752-4341-8b2e-2924cd6862b6",
                                             "2ff27bc8-c87b-4e6b-9416-919264fae4ff",
                                             "4cbd26ef-d92f-4af5-b3c1-a4234a86e741",
                                             "bc0a4943-5fa4-4596-b141-0a6f4b85837e",
                                             "804cb27e-6b6c-4db2-b36e-b9560d1cf3e4",
                                             "2de972f0-e196-4adc-b79f-8a1df4e9bcbc",
                                             "291a2696-6c8a-4a13-8b30-8eef452ceb3f", null,
                                             "acc683cf-f323-4c79-adf3-0547c54cb475",
                                             "58025169-ee9d-4dcb-9de7-7c1e739db77a",
                                             "6f10cbc7-33b3-4e33-9958-4ab218fb15c7",
                                             "1b50dd0d-0836-4795-9a36-bd63886e8a7b",
                                             "39f1c50d-8697-48ff-8cb2-c0b4d474b168", new Date(1553793334502L), null,
                                             "db664fcb-64b0-428e-a050-eddc47560ed6",
                                             "b0f29d0a-729a-4e02-99af-d48bc1179298",
                                             "a187cc15-9733-4000-9192-a073e7b63450", null, new Date(1553793333689L),
                                             "c96dcd5e-2be6-4f47-b3af-1d427f6dc678",
                                             "7987b742-9834-4055-84c3-1f6154244d52",
                                             "dfc60ae8-5844-4dc2-b87f-2e0dd099f997", null,
                                             AccountMfaStatus.getDefault(), null, new ParentAccount(),
                                             "ab4a8557-8db3-4cdf-8f6d-0ec6d9ebdaff", new PasswordPolicy(), 45 + 1,
                                             "11fb81ac-beb0-443b-973e-5aacfc80928a", null,
                                             "5c56c868-9861-4f62-9936-29d6e5d84b46",
                                             "528174a8-fe1b-4bd6-affc-710445b326fe",
                                             "0ac54922-4e32-4957-889e-105eafdd1851",
                                             "c6ecfe4f-b660-47f2-b026-e01bc13e6782",
                                             "008d4648-5a6b-4fa9-8d1c-ac49ba9473b4", AccountStatus.getDefault(),
                                             "689406e2-a21f-4bcd-9e0b-058e27d477ff",
                                             "01125969-073a-4a5b-b7cd-871310b620c4", new Date(1553793332507L),
                                             new Date(1553793330407L));
        assertFalse(accountInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            Account account1 = new Account("f6e0849c-cffd-4614-9bec-462385f91d65",
                                           "a47c1a6a-1306-4c96-b7b3-1f9815dc9790",
                                           "1499b18d-a78b-40a5-8a28-a89af133ecdb",
                                           "f6952f25-47e8-4c49-9cec-5a4444d9854c",
                                           "89495d7e-b9d1-4117-a0f4-5d8d5e5da850",
                                           "eff85333-3439-44a8-a002-d5ecf807932e",
                                           "ee23fa6a-5d1b-4189-952b-04efd7191cd5",
                                           "6b06ff1d-e0aa-409d-93fd-6a7fcf76879c", null,
                                           "303d228c-1c41-414c-be32-2abe668dac51",
                                           "4e308366-6ea5-4cc8-b8f6-1f59631d9248",
                                           "41997895-0bc6-44e2-b5e0-7f8043319438",
                                           "1e6f22bd-4882-4ff6-9be3-79f404875406",
                                           "dedfd352-8719-4074-85fc-849e7db5f70e", new Date(1553793329784L), null,
                                           "4fb74a38-bd02-476f-8709-f14d7bd2d308",
                                           "a6e5e5be-0367-4349-bb88-3b8c60a1a4ba",
                                           "9cb76ca9-38df-4333-86d6-a660e4e826c0",
                                           "7ae9e996-aec8-4846-a498-0752b2869b2f", new Date(1553793332635L),
                                           "5224d0c6-d57b-438c-ab7d-de6b1b93da89",
                                           "1e4832e9-af64-47b6-b758-94206a6bb24d",
                                           "0d4a965c-95c7-4a01-9cd5-e4e7e530fc9b", null, AccountMfaStatus.getDefault(),
                                           null, new ParentAccount(), "9633743e-36c3-48ef-99f3-ef2cb9e85044",
                                           new PasswordPolicy(), 1, "32f8567e-a507-4887-85c6-0bbc9e034f7c", null,
                                           "7c1cdf36-c746-4af3-a359-797c43fb6eb9",
                                           "551b5d8c-4315-4e01-a86a-26304703dc85",
                                           "dbfba54e-159f-48d3-a3f8-4a7395f8d5c9",
                                           "9918d761-97a7-4650-9c19-de7cfb0f8164",
                                           "9e419cd7-ec78-42ea-acc7-60aaee0e9708", AccountStatus.getDefault(),
                                           "7b835aa3-46f0-4d41-8d51-e6b384d56333",
                                           "c4724c74-e0c2-462c-8ef2-3aa5f1e66fdf", new Date(1553793326858L),
                                           new Date(1553793330720L));
            Account account2 = new Account("f6e0849c-cffd-4614-9bec-462385f91d65",
                                           "a47c1a6a-1306-4c96-b7b3-1f9815dc9790",
                                           "1499b18d-a78b-40a5-8a28-a89af133ecdb",
                                           "f6952f25-47e8-4c49-9cec-5a4444d9854c",
                                           "89495d7e-b9d1-4117-a0f4-5d8d5e5da850",
                                           "eff85333-3439-44a8-a002-d5ecf807932e",
                                           "ee23fa6a-5d1b-4189-952b-04efd7191cd5",
                                           "6b06ff1d-e0aa-409d-93fd-6a7fcf76879c", null,
                                           "303d228c-1c41-414c-be32-2abe668dac51",
                                           "4e308366-6ea5-4cc8-b8f6-1f59631d9248",
                                           "41997895-0bc6-44e2-b5e0-7f8043319438",
                                           "1e6f22bd-4882-4ff6-9be3-79f404875406",
                                           "dedfd352-8719-4074-85fc-849e7db5f70e", new Date(1553793329784L), null,
                                           "4fb74a38-bd02-476f-8709-f14d7bd2d308",
                                           "a6e5e5be-0367-4349-bb88-3b8c60a1a4ba",
                                           "9cb76ca9-38df-4333-86d6-a660e4e826c0",
                                           "7ae9e996-aec8-4846-a498-0752b2869b2f", new Date(1553793332635L),
                                           "5224d0c6-d57b-438c-ab7d-de6b1b93da89",
                                           "1e4832e9-af64-47b6-b758-94206a6bb24d",
                                           "0d4a965c-95c7-4a01-9cd5-e4e7e530fc9b", null, AccountMfaStatus.getDefault(),
                                           null, new ParentAccount(), "9633743e-36c3-48ef-99f3-ef2cb9e85044",
                                           new PasswordPolicy(), 1, "32f8567e-a507-4887-85c6-0bbc9e034f7c", null,
                                           "7c1cdf36-c746-4af3-a359-797c43fb6eb9",
                                           "551b5d8c-4315-4e01-a86a-26304703dc85",
                                           "dbfba54e-159f-48d3-a3f8-4a7395f8d5c9",
                                           "9918d761-97a7-4650-9c19-de7cfb0f8164",
                                           "9e419cd7-ec78-42ea-acc7-60aaee0e9708", AccountStatus.getDefault(),
                                           "7b835aa3-46f0-4d41-8d51-e6b384d56333",
                                           "c4724c74-e0c2-462c-8ef2-3aa5f1e66fdf", new Date(1553793326858L),
                                           new Date(1553793330720L));
            Account account3 = new Account("49981f3b-1ffb-4aa0-b965-856941dd14d1",
                                           "793ef109-f1ab-40d7-a668-9b90affe465b",
                                           "24e0b47b-03ea-46de-a1a7-1e62f56eaeba",
                                           "caccccff-a919-4f47-8337-9ebd638843c0",
                                           "07d71f40-00ae-4268-a0c7-c6d7c9379ff4",
                                           "c045b088-35cc-4ce6-85e8-fc5807860624",
                                           "729efc7a-e0f7-47b2-bbf0-ae653a5124de",
                                           "55c3785a-2388-4c15-8415-babfbded18b6", null,
                                           "1aa41a43-62fa-4f89-92aa-4359004d3086",
                                           "f0bc36bc-5713-4b75-8881-0ff5e4209a04",
                                           "212021cb-5574-4860-9317-8d715dfd2045",
                                           "11b163db-46df-4a68-ad19-6c335b94d930",
                                           "6f917fb9-65c5-458f-9d23-2e826f58aca3", new Date(1553793329070L), null,
                                           "5c07ff1b-7904-4e14-b19f-181b2a967085",
                                           "e584e7c4-d94f-4352-9cdc-c1d95b03b2d4",
                                           "3379133f-c3f6-41fe-a65e-1f0c8680d25f",
                                           "0fb5fb41-91be-42f7-97ac-c4b4cef03111", new Date(1553793333271L),
                                           "6801105e-29fc-44bb-be94-d50f5630a9e1",
                                           "77fdda2e-6da4-4df2-b565-bfc629c8eee4",
                                           "6edb48a8-075f-4fec-b401-18bb6d2946da", null, AccountMfaStatus.getDefault(),
                                           null, new ParentAccount(), "7932bfb1-42c8-4bfd-99f5-a2761be2ab0b",
                                           new PasswordPolicy(), 45, "59eed819-8fe7-4899-b28a-957e1ac1ac3b", null,
                                           "611b16bb-2c01-4b14-8449-8f65282ce5df",
                                           "e90ef4db-9571-40f7-99b3-997c0318b601",
                                           "17d861ec-2465-4d52-867a-8be859decc6b",
                                           "577f8d7f-7cdd-4483-8fdb-6d75ffd72398",
                                           "3c4ffd86-5346-4fa4-a51e-de98237276f5", AccountStatus.getDefault(),
                                           "d5173cff-ec37-4b9d-b20c-5dd4d080b7c7",
                                           "1cb2c26f-2f06-4323-9daa-8e0289d518c4", new Date(1553793328009L),
                                           new Date(1553793328240L));
            assertNotNull(account1);
            assertNotNull(account2);
            assertNotNull(account3);
            assertNotSame(account2, account1);
            assertNotSame(account3, account1);
            assertEquals(account2, account1);
            assertEquals(account2, account1);
            assertEquals(account1, account2);
            assertEquals(account1, account1);
            assertFalse(account1.equals(null));
            assertNotEquals(account3, account1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
