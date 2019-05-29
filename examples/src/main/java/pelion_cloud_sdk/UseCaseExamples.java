package pelion_cloud_sdk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.stream.StreamSupport;

import com.arm.mbed.cloud.Sdk;
import com.arm.mbed.cloud.sdk.accounts.model.AccountDao;
import com.arm.mbed.cloud.sdk.accounts.model.AccountStatus;
import com.arm.mbed.cloud.sdk.accounts.model.ApiKey;
import com.arm.mbed.cloud.sdk.accounts.model.ApiKeyListDao;
import com.arm.mbed.cloud.sdk.accounts.model.SubtenantUser;
import com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserDao;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.FileDownload;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.common.model.DataFile;
import com.arm.mbed.cloud.sdk.devices.model.DeviceDao;
import com.arm.mbed.cloud.sdk.devices.model.DeviceEnrollmentBulkCreateDao;
import com.arm.mbed.cloud.sdk.devices.model.DeviceEnrollmentBulkCreateStatus;
import com.arm.mbed.cloud.sdk.devices.model.DeviceEnrollmentDenialListOptions;
import com.arm.mbed.cloud.sdk.devices.model.DeviceListOptions;
import com.arm.mbed.cloud.sdk.devices.model.DeviceState;
import com.arm.mbed.cloud.sdk.deviceupdate.model.FirmwareManifest;
import com.arm.mbed.cloud.sdk.deviceupdate.model.FirmwareManifestListDao;
import com.arm.mbed.cloud.sdk.deviceupdate.model.FirmwareManifestListOptions;
import com.arm.mbed.cloud.sdk.deviceupdate.model.UpdateCampaign;
import com.arm.mbed.cloud.sdk.deviceupdate.model.UpdateCampaignDao;
import com.arm.mbed.cloud.sdk.security.model.CertificateIssuerConfig;
import com.arm.mbed.cloud.sdk.security.model.TrustedCertificate;
import com.arm.mbed.cloud.sdk.security.model.TrustedCertificateDao;
import com.arm.mbed.cloud.sdk.security.model.TrustedCertificateListDao;
import com.arm.mbed.cloud.sdk.security.model.TrustedCertificateListOptions;
import com.arm.mbed.cloud.sdk.security.model.TrustedCertificateStatus;

import utils.AbstractExample;
import utils.Configuration;
import utils.Example;
import utils.ExampleLogger;

public class UseCaseExamples extends AbstractExample {
    /**
     * Checks my account status.
     */
    @Example
    public void checkAccountStatus() {
        // an example: checking account status
        try (AccountDao myAccountDao = new AccountDao(Configuration.get())) {
            // Fetch my account
            myAccountDao.me();
            // Print my account details
            log(myAccountDao.getModel());
            boolean isActive = myAccountDao.getModel().getStatus() == AccountStatus.ACTIVE;
            // cloak
            // Checks that the status is active
            assertTrue(isActive);
            // uncloak
        } catch (MbedCloudException | IOException exception) {
            // TODO do something with the exception
            exception.printStackTrace();
            // cloak
            // Fails if an exception happened
            fail(exception.getMessage());
            // uncloak
        }
        // end of example
    }

    /**
     * Lists API keys.
     */
    @Example
    public void listApiKeys() {
        // an example: listing api keys
        try (Sdk sdk = Sdk.createSdk(Configuration.get())) {
            // Iterate over all API keys and print their value
            // In case you do not know the name/class of the DAO to use, you can use the DAO provider which will fetch
            // the corresponding DAO using reflection.
            sdk.foundation().getDaoProvider().getCorrespondingListDao(ApiKey.class, null).paginator()
               .forEach(ExampleLogger::log);
        } catch (MbedCloudException exception) {
            // TODO do something with the exception
            exception.printStackTrace();
            // cloak
            fail(exception.getMessage());
            // uncloak
        }
        // end of example
    }

    /**
     * Uses multiple API keys.
     */
    @Example
    public void useMultipleApiKeys() {
        // an example: using multiple api keys
        try (ApiKeyListDao dao1 = new ApiKeyListDao(ConnectionOptions.newConfiguration("API Key 1 xxxxxx"));
             ApiKeyListDao dao2 = dao1.clone()) {
            // cloak
            assertEquals(dao1, dao2);
            assertNotSame(dao1, dao2);
            assertEquals(dao1.getContext().getConnectionOption(), dao2.getContext().getConnectionOption());
            // uncloak
            dao2.configure(ConnectionOptions.newConfiguration("API Key 2 xxxxxx"));
            // cloak
            assertNotEquals(dao1, dao2);
            assertNotEquals(dao1.getContext().getConnectionOption(), dao2.getContext().getConnectionOption());
            // uncloak
            dao1.paginator().forEach(ExampleLogger::log);
            dao2.paginator().forEach(ExampleLogger::log);
            // cloak
            fail("The host is fake");
            // uncloak
        } catch (MbedCloudException | IOException exception) {
            // TODO do something with the exception
            exception.printStackTrace();
        }
        // end of example
    }

    /**
     * Uses a custom host.
     */
    @Example
    public void useCustomHost() {
        // an example: using custom hosts
        // Configure the SDK to use a specific host.
        try (Sdk sdk = Sdk.createSdk(ConnectionOptions.newConfiguration("an API key xxxxxx", "https://example.host"))) {
            // cloak
            sdk.getClient().setRequestTimeout(new TimePeriod(1));
            // uncloak
            // TODO some action
            sdk.foundation().getDaoProvider().getCorrespondingListDao(ApiKey.class, null).paginator()
               .forEach(ExampleLogger::log);
            // cloak
            fail("The host is fake");
            // uncloak
        } catch (MbedCloudException exception) {
            // TODO do something with the exception
            exception.printStackTrace();
        }
        // end of example
    }

    /**
     * Creates and manages a sub-tenant account.
     */

    @Example
    public void manageSubtenants() {
        // an example: creating and managing a subtenant account
        try (Sdk sdk = Sdk.createSdk(Configuration.get()); AccountDao myAccountDao = sdk.foundation().getAccountDao();
             SubtenantUserDao userDao = sdk.foundation().getSubtenantUserDao();) {
            // Fetch my account
            myAccountDao.me();
            // Create a new User
            SubtenantUser user = new SubtenantUser();
            user.setAccountId(myAccountDao.getId());
            user.setFullName("tommi the wombat");
            user.setEmail("tommi_the_wombat@email.com");
            user.setUsername("tommi_wombat");
            user.setPhoneNumber("0800001066");
            // cloak
            // Perform some account cleanup
            performAccountCleanup(myAccountDao, user, userDao);
            // uncloak
            userDao.create(user);
            // Find this added user in my account user list.
            String createdId = userDao.getId();
            // cloak
            assertNotNull(createdId);
            // uncloak
            // Fetch latest details of the current sub-tenant user.
            userDao.read();
            // Fetching a user from the list of account users
            SubtenantUser correspondingUser = StreamSupport.stream(myAccountDao.allUsers(null).spliterator(), false)
                                                           .filter(u -> u.getId().equals(createdId)).findFirst().get();
            // cloak
            assertEquals(userDao.getModel(), correspondingUser);
            // uncloak
            // Delete the created user.
            userDao.delete();

        } catch (MbedCloudException | IOException exception) {
            // TODO do something with the exception
            exception.printStackTrace();
            // cloak
            fail(exception.getMessage());
            // uncloak
        }
        // end of example
    }

    private void performAccountCleanup(AccountDao myAccountDao, SubtenantUser user,
                                       SubtenantUserDao userDao) throws MbedCloudException {
        StreamSupport.stream(myAccountDao.allUsers(null).spliterator(), false)
                     .filter(u -> user.getUsername().equals(u.getUsername())).forEach(u -> {
                         try {
                             userDao.delete(u);
                         } catch (MbedCloudException exception) {
                             exception.printStackTrace();
                         }
                     });
    }

    /**
     * Renews a device certificate
     */
    @Example
    public void renewCertificate() {
        // an example: certificate renew
        try (Sdk sdk = Sdk.createSdk(Configuration.get()); DeviceDao deviceDao = sdk.foundation().getDeviceDao()) {
            // Find the certificate issuers configuration in use. In this case, it is known that the reference is
            // "LWM2M".
            CertificateIssuerConfig myConfig = StreamSupport.stream(sdk.foundation().getCertificateIssuerConfigListDao()
                                                                       .getPaginator().spliterator(),
                                                                    false)
                                                            .filter(c -> c.getReference().equals("LWM2M")).findFirst()
                                                            .get();
            // Renew the certificate of all connected devices
            StreamSupport.stream(sdk.foundation().getDeviceListDao().paginator().spliterator(), false)
                         .filter(d -> d.getState() == DeviceState.REGISTERED).forEach(d -> {
                             // Configure the DAO with the model of interest
                             try {
                                 deviceDao.setModel(d);
                                 deviceDao.renewCertificate(myConfig.getReference());
                                 log(myConfig + " was renewed on " + d);
                             } catch (@SuppressWarnings("unused") MbedCloudException exception) {
                                 // TODO do something with the exception
                                 log(myConfig + " could not be renewed on " + d);
                             }

                         });

        } catch (MbedCloudException | IOException exception) {
            // TODO do something with the exception
            exception.printStackTrace();
            // cloak
            fail(exception.getMessage());
            // uncloak
        }
        // end of example
    }

    /**
     * Enrols devices in bulk.
     */
    @Example
    public void enrolDevicesInBulk() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = null;
        try {
            file = File.createTempFile("test", ".csv");
            file.deleteOnExit();
            Files.copy(classLoader.getResource("test.csv").openStream(), file.toPath(),
                       StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException exception1) {
            // TODO Auto-generated catch block
            exception1.printStackTrace();
        }
        assertNotNull(file);
        assertTrue(file.exists());
        // an example: device enrollment bulk
        try (Sdk sdk = Sdk.createSdk(Configuration.get());
             DeviceEnrollmentBulkCreateDao enrolmentDao = sdk.foundation().getDeviceEnrollmentBulkCreateDao()) {
            // file is a csv file containing all the devices which need to be enrolled. See test.csv in the /resources
            // folder as example.
            enrolmentDao.create(new DataFile(file));
            // cloak
            assertEquals(DeviceEnrollmentBulkCreateStatus.NEW, enrolmentDao.getModel().getStatus());
            // uncloak
            // read current state of bulk enrollment
            enrolmentDao.read();
            // cloak
            assertTrue(enrolmentDao.getModel().getStatus() == DeviceEnrollmentBulkCreateStatus.PROCESSING
                       || enrolmentDao.getModel().getStatus() == DeviceEnrollmentBulkCreateStatus.COMPLETED);
            // uncloak
            // Wait until the report is ready
            // FIXME this is just a cruddy example of waiting for the bulk operation to complete. Better handling should
            // be performed in production application.
            while (enrolmentDao.getModel().getStatus() != DeviceEnrollmentBulkCreateStatus.COMPLETED) {
                Thread.sleep(1000);
                enrolmentDao.read();
            }
            // Download the enrolment report files
            FileDownload report = enrolmentDao.downloadFullReportFile((String) null);
            log("report", report);
            FileDownload errorReport = enrolmentDao.downloadErrorsReportFile((String) null);
            log("errorReport", errorReport);

        } catch (MbedCloudException | InterruptedException exception) {
            // TODO do something with the exception
            exception.printStackTrace();
            // cloak
            fail(exception.getMessage());
            // uncloak
        }
        // end of example
        catch (IOException exception1) {
            // TODO Auto-generated catch block
            exception1.printStackTrace();
        }
    }

    /**
     * Renews a device certificate
     */
    @Example
    public void blacklistCertificates() {
        try (Sdk sdk = Sdk.createSdk(Configuration.get());
             TrustedCertificateListDao certificateDao = sdk.foundation().getTrustedCertificateListDao()) {
            // Find a production certificate
            TrustedCertificate certificateOfInterest = certificateDao.list(new TrustedCertificateListOptions().notEqualToDeviceExecutionMode(1))
                                                                     .first();
            assertNotNull(certificateOfInterest);
            String myCertId = certificateOfInterest.getId();
            // Record the original status to revert to its original state at the end
            TrustedCertificateStatus originalStatus = certificateDao.getNewModelDao().read(myCertId).getStatus();
            // an example: certificate black listing

            // Set the certificate to inactive
            TrustedCertificateDao myCertificateDao = sdk.foundation().getTrustedCertificateDao();
            myCertificateDao.read(myCertId);
            myCertificateDao.getModel().setStatus(TrustedCertificateStatus.INACTIVE);
            myCertificateDao.update();

            // List all devices which have tried to bootstrap
            sdk.foundation().getDeviceEnrollmentDenialListDao()
               .list(new DeviceEnrollmentDenialListOptions().equalToTrustedCertificateId(myCertId))
               .forEach(d -> log("Device endpoint name: " + d.getEndpointName()));

            // end of example
            myCertificateDao.read();
            assertEquals(TrustedCertificateStatus.INACTIVE, myCertificateDao.getModel().getStatus());
            // Revert the certificate to its original status
            myCertificateDao.getModel().setStatus(originalStatus);
            myCertificateDao.update();
            myCertificateDao.read();
            assertEquals(originalStatus, myCertificateDao.getModel().getStatus());
            myCertificateDao.close();
        } catch (MbedCloudException | IOException exception) {
            // TODO do something with the exception
            exception.printStackTrace();

            fail(exception.getMessage());

        }
    }

    /**
     * Creates and starts a firmware update campaign
     */
    @Example
    public void launchUpdateCampaign() {
        try (Sdk sdk = Sdk.createSdk(Configuration.get());
             FirmwareManifestListDao manifestDao = sdk.foundation().getFirmwareManifestListDao()) {
            // Find a production manifest
            FirmwareManifest manifestOfInterest = manifestDao.list(new FirmwareManifestListOptions().maxResults(2))
                                                             .first();
            assertNotNull(manifestOfInterest);
            String myManifestId = manifestOfInterest.getId();
            // an example: firmware update campaign launch
            UpdateCampaignDao myCampaignDao = sdk.foundation().getUpdateCampaignDao();
            // Define an update campaign
            UpdateCampaign newCampaign = new UpdateCampaign();
            newCampaign.setName("campaign - " + (new Date().toString()));
            newCampaign.setDescription("Update campaign for prior 2019 devices");
            newCampaign.setRootManifestId(myManifestId);
            // All devices created before the 1st of January 2019 will have their firmware replaced by the one defined
            // in the manifest
            newCampaign.setDeviceFiltersHelper(new DeviceListOptions().lessThanCreatedAt(new GregorianCalendar(2019, 0,
                                                                                                               1).getTime())
                                                                      .getFilter());
            // Create the campaign
            myCampaignDao.create(newCampaign);
            // Determine the phase of the campaign
            myCampaignDao.read();
            // Start the campaign
            myCampaignDao.start();
            // Determine the phase of the campaign
            myCampaignDao.read();
            // end of example
            myCampaignDao.close();
        } catch (MbedCloudException | IOException exception) {
            // TODO do something with the exception
            exception.printStackTrace();

            fail(exception.getMessage());

        }
    }
}
