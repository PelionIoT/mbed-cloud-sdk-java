// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.deviceupdate.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model CampaignDeviceMetadata.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestCampaignDeviceMetadata {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            CampaignDeviceMetadata campaigndevicemetadata1 = new CampaignDeviceMetadata("fd956d2b-a370-4593-bbdb-04e0315affa7",
                                                                                        new Date(1565006431763L),
                                                                                        CampaignDeviceMetadataDeploymentState.getDefault(),
                                                                                        "cc0d3944-9b9f-46dc-8c36-10d712c219b9",
                                                                                        "adc5252d-7b9e-4b7a-9b58-e150252f5489",
                                                                                        "0e207241-13eb-4c39-96e4-a28d57c3b3a2",
                                                                                        "c12b65df-f838-41cf-82fd-95a4a3f3659f",
                                                                                        "41d190cd-55b1-456e-8968-709f9f5208e1",
                                                                                        "f1e78816-5985-466b-877d-3919f3770619",
                                                                                        new Date(1565006430612L));
            CampaignDeviceMetadata campaigndevicemetadata2 = campaigndevicemetadata1.clone();
            assertNotNull(campaigndevicemetadata1);
            assertNotNull(campaigndevicemetadata2);
            assertNotSame(campaigndevicemetadata2, campaigndevicemetadata1);
            assertEquals(campaigndevicemetadata2, campaigndevicemetadata1);
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
            CampaignDeviceMetadata campaigndevicemetadata1 = new CampaignDeviceMetadata("5c48cd37-9124-4c6a-a42e-d013dd211cbe",
                                                                                        new Date(1565006433531L),
                                                                                        CampaignDeviceMetadataDeploymentState.getDefault(),
                                                                                        "069e08f0-5de3-49c8-a284-6a723e881eba",
                                                                                        "b4e41241-ed11-4be4-bd26-75d7be5b8363",
                                                                                        "e2919cd7-cf67-4ffd-ab95-293fe279c3dd",
                                                                                        "422531e8-d50d-4e41-8b31-899894b5763b",
                                                                                        "064631da-8274-4702-973a-0b1c91542af0",
                                                                                        "7de1a682-18c7-4f8d-8f76-8053d1f8418a",
                                                                                        new Date(1565006429802L));
            CampaignDeviceMetadata campaigndevicemetadata2 = new CampaignDeviceMetadata("5c48cd37-9124-4c6a-a42e-d013dd211cbe",
                                                                                        new Date(1565006433531L),
                                                                                        CampaignDeviceMetadataDeploymentState.getDefault(),
                                                                                        "069e08f0-5de3-49c8-a284-6a723e881eba",
                                                                                        "b4e41241-ed11-4be4-bd26-75d7be5b8363",
                                                                                        "e2919cd7-cf67-4ffd-ab95-293fe279c3dd",
                                                                                        "422531e8-d50d-4e41-8b31-899894b5763b",
                                                                                        "064631da-8274-4702-973a-0b1c91542af0",
                                                                                        "7de1a682-18c7-4f8d-8f76-8053d1f8418a",
                                                                                        new Date(1565006429802L));
            assertNotNull(campaigndevicemetadata1);
            assertNotNull(campaigndevicemetadata2);
            assertNotSame(campaigndevicemetadata2, campaigndevicemetadata1);
            assertEquals(campaigndevicemetadata2, campaigndevicemetadata1);
            assertEquals(campaigndevicemetadata2.hashCode(), campaigndevicemetadata1.hashCode());
            int hashCode = campaigndevicemetadata1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, campaigndevicemetadata1.hashCode());
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
        CampaignDeviceMetadata campaigndevicemetadata = new CampaignDeviceMetadata("4efaf62b-7dc4-47c7-acf0-158c94565028",
                                                                                   new Date(1565006431175L),
                                                                                   CampaignDeviceMetadataDeploymentState.getDefault(),
                                                                                   "e4e40a36-84fa-4bd2-93c8-7aed67a8ef6f",
                                                                                   "b2046102-3610-4e1b-af80-8872f08019bc",
                                                                                   "f2aa9faf-88c2-4541-a8ab-4aa2a865a7b4",
                                                                                   "e221fe48-827e-4eaa-9ca5-daf03f6ce218",
                                                                                   "128763cf-b9c6-455b-a866-0f8c9a80ca4c",
                                                                                   "d0fd214f-1f64-4c04-8ac0-cb5a1af3c2fe",
                                                                                   new Date(1565006438573L));
        assertTrue(campaigndevicemetadata.isValid());
        CampaignDeviceMetadata campaigndevicemetadataInvalid = new CampaignDeviceMetadata(null,
                                                                                          new Date(1565006436781L),
                                                                                          CampaignDeviceMetadataDeploymentState.getDefault(),
                                                                                          "20f1ea79-cec4-4ba9-ada9-8b21935fcbe92bd3c067-7bd2-4b2c-9f1f-dae86a39b2d1a216c278-c500-403b-8d1b-19c228c166f5ea22aedd-9828-4ac0-8656-76e1389142c375c75b94-9009-430c-89dd-7557ca04bc653b2a2822-5ead-4a41-9da0-3fdfd67ccc3a2926e777-eba1-401a-adfa-e7c51b40fe6f1510eb09-1cbe-499b-a1fd-01113fb86999085732a9-931b-469a-a4c1-c2b393e8c5397b2b83b1-5315-4280-9cc1-2867314964ef1b099170-937d-437e-850d-0d491c3c95626e9639e0-6371-4bac-854b-02cacaac5b9eb53f6f8d-8356-4fa4-a42a-a9c71ccd5657333abf80-89b8-4922-b996-3a65d65eca417883254f-4ac0-4d7b-8a60-99e5ce67feee59df51ff-8b7a-4f41-8710-73df1ca2f303b30cdb4e-98fe-4a42-a18d-d4a61c33d5db683304a6-bf22-4742-8d7e-fff639d88c139cb4a889-b42b-4401-bed8-ac13aa2960b0997990e3-1af0-4caa-9697-7f017f60593becf4699b-526e-4a23-ad08-189c3cbc2adaaf91d6bf-100c-4c9b-ad97-9a79c238ca72b03a9f72-9fcd-440e-b5cc-7bff4319a717d787139d-ed1a-463b-80ca-4c9801f66cd1ab3fc854-9d32-4991-a298-07cd580dadd695f912c1-b675-45c7-aac2-98945831a967ac542cd7-ad67-4c2a-be90-f24cabf28739a8e9c950-a6ce-4718-910f-47e8e735fad807aaed4b-fd4a-44dd-bcb9-a3d19872f97e73e567ca-a074-492f-a0fb-7dc9638b265aa93bdd89-bad1-457b-b1ba-6fb2f04b75ff2c4810cd-12e6-4c4d-a2b3-bbfa357a20b3ad05e120-2c9d-4172-9a66-c777ef70d456813c9b8a-0758-4024-bab1-8cbb858898e4db8e4671-9512-44b2-bfaa-456c5f0fee8567080a90-a930-4992-844f-085025b458aa0dc53720-9d66-41d1-bc4f-1ad15b3152fda0d63612-3444-4df3-b06f-6c62a158002a54d4adeb-a61f-4959-92c9-72f08413eca31f48c11d-2fd7-4560-88da-c6575451fc7d19d55725-2cbb-4160-8a16-545489376e09bf5a5701-559b-4f9b-ac30-077d9b605d17a8385482-fcbc-4571-8fd0-0a2a97a8354e67fc4a0e-89dd-47b8-85e9-473784d86ed1bbc66f44-15f2-4f7a-8d30-df475520ab29112e22ef-6a4c-4734-bd3c-dca268c0275c094ec749-4c64-416e-9e53-a7f950aa2d08c12b291e-c14d-41fa-923f-c706c9a37f796f3ac8b6-92d6-4da2-87a5-7c81d12a20d401f51138-fff3-4428-ad23-6f389b9b083e84e86151-2666-4441-9ef4-59a1b4c29329e881bb19-22f6-4053-a849-d42151e7134a6547a191-b652-4fc7-9724-00e7df7179e50048ea8b-249f-486c-8cce-04470e6caf098080875a-7a8d-49cf-b696-537a7e78c7d5bd5c9321-22eb-461a-be75-d594e4c679e0",
                                                                                          "caa9fc74-587e-4cf7-bc8f-308777e39194",
                                                                                          "2cd67e18-86fd-40b1-8a65-bc6c7b4bcf2a",
                                                                                          "3a49dd3c-0aaa-4b1b-a32c-4a9b1799f5d9",
                                                                                          "749d0970-5f49-4030-a1aa-155953f8b1d0",
                                                                                          "da29c254-1515-465b-a53f-be535bb322b0720255bf-4aeb-4d42-b4d0-942fcb5b2fba82534cb6-47b8-4a25-9eb4-a720f08a4ee6138ab0d8-8ed5-4fb5-b247-eb82845e6ad3",
                                                                                          new Date(1565006430373L));
        assertFalse(campaigndevicemetadataInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            CampaignDeviceMetadata campaigndevicemetadata1 = new CampaignDeviceMetadata("1761e4f3-f117-4a0c-88f6-eccc1551ed63",
                                                                                        new Date(1565006437278L),
                                                                                        CampaignDeviceMetadataDeploymentState.getDefault(),
                                                                                        "55f0fe58-50c7-47e5-839a-894f7bfd8f6c",
                                                                                        "8c4eaa84-2ece-4b07-bbd4-e08920b48761",
                                                                                        "e592b297-5dbe-4c24-a326-e0e87b1c4246",
                                                                                        "ff0cda4b-18bc-4965-971b-f4afb697d09f",
                                                                                        "5a4f596a-2a3e-4718-9f0e-ae352c35c748",
                                                                                        "b3fe290d-57da-4826-9758-9f9236ef0bab",
                                                                                        new Date(1565006435376L));
            CampaignDeviceMetadata campaigndevicemetadata2 = new CampaignDeviceMetadata("1761e4f3-f117-4a0c-88f6-eccc1551ed63",
                                                                                        new Date(1565006437278L),
                                                                                        CampaignDeviceMetadataDeploymentState.getDefault(),
                                                                                        "55f0fe58-50c7-47e5-839a-894f7bfd8f6c",
                                                                                        "8c4eaa84-2ece-4b07-bbd4-e08920b48761",
                                                                                        "e592b297-5dbe-4c24-a326-e0e87b1c4246",
                                                                                        "ff0cda4b-18bc-4965-971b-f4afb697d09f",
                                                                                        "5a4f596a-2a3e-4718-9f0e-ae352c35c748",
                                                                                        "b3fe290d-57da-4826-9758-9f9236ef0bab",
                                                                                        new Date(1565006435376L));
            CampaignDeviceMetadata campaigndevicemetadata3 = new CampaignDeviceMetadata("70150c34-e76c-4b25-b372-93d23fb1f8eb",
                                                                                        new Date(1565006433847L),
                                                                                        CampaignDeviceMetadataDeploymentState.getDefault(),
                                                                                        "1f139b3d-49ca-4699-ab55-822ada4f6773",
                                                                                        "9e4e9ef3-fae6-4a42-b7b2-afe3ac967dcf",
                                                                                        "63e61f57-a609-4e0d-a08e-1372ca726f26",
                                                                                        "3fb23f75-8d08-4ba8-8a60-33973e74ea38",
                                                                                        "10dff497-d870-4c9f-b5e5-6a0bd8e7e291",
                                                                                        "52b251e0-ee7e-4fec-b241-bac27fde2a25",
                                                                                        new Date(1565006432029L));
            assertNotNull(campaigndevicemetadata1);
            assertNotNull(campaigndevicemetadata2);
            assertNotNull(campaigndevicemetadata3);
            assertNotSame(campaigndevicemetadata2, campaigndevicemetadata1);
            assertNotSame(campaigndevicemetadata3, campaigndevicemetadata1);
            assertEquals(campaigndevicemetadata2, campaigndevicemetadata1);
            assertEquals(campaigndevicemetadata2, campaigndevicemetadata1);
            assertEquals(campaigndevicemetadata1, campaigndevicemetadata2);
            assertEquals(campaigndevicemetadata1, campaigndevicemetadata1);
            assertFalse(campaigndevicemetadata1.equals(null));
            assertNotEquals(campaigndevicemetadata3, campaigndevicemetadata1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
