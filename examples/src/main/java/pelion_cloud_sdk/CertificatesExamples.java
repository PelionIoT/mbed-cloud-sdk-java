package pelion_cloud_sdk;

import static org.junit.Assert.fail;

import java.util.Random;

import com.arm.mbed.cloud.sdk.Certificates;
import com.arm.mbed.cloud.sdk.certificates.model.Certificate;
import com.arm.mbed.cloud.sdk.certificates.model.CertificateListOptions;
import com.arm.mbed.cloud.sdk.certificates.model.CertificateType;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;

import utils.AbstractExample;
import utils.Configuration;
import utils.Example;

public class CertificatesExamples extends AbstractExample {
    /**
     * Creates, updates and deletes a developer certificate.
     */
    @Example
    public void manageCertificates() {
        String certificateId = null;
        ConnectionOptions config = Configuration.get();
        Certificates api = new Certificates(config);
        try {
            String certificateName = generateCertificateName();
            log("Certificate Name", certificateName);
            // Creating and adding a certificate
            Certificate myCertificate = api.addDeveloperCertificate(new Certificate(certificateName,
                                                                                    CertificateType.DEVELOPER, false));
            log("Created developer certificate", myCertificate);
            certificateId = myCertificate.getId();
            String newName = generateCertificateName();
            log("New Certificate Name", newName);
            myCertificate.setName(newName);
            myCertificate.setDescription("my updated certificate");
            // Updating certificate
            myCertificate = api.updateCertificate(myCertificate);
            log("Updated developer certificate", myCertificate);
            certificateId = myCertificate.getId();
            // Deleting certificate
            deleteCreatedCertificate(certificateId, api);
        } catch (Exception e) {
            logError("last API Metadata", api.getLastApiMetadata());
            deleteCreatedCertificate(certificateId, api);
            fail(e.getMessage());
        }
    }

    /**
     * Lists the first 5 certificates.
     */
    @Example
    public void listCertificates() {
        ConnectionOptions config = Configuration.get();
        try (Certificates api = new Certificates(config)) {
            // Defining query options.
            CertificateListOptions options = new CertificateListOptions();
            options.setPageSize(5);
            // Listing certificates.
            Paginator<Certificate> certificates = api.listAllCertificates(options);
            for (Certificate certificate : certificates) {
                log("Certificate", certificate);
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    private void deleteCreatedCertificate(String certificateId, Certificates api) {
        try {
            if (certificateId != null) {
                api.deleteCertificate(certificateId);
            }
        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
    }

    private String generateCertificateName() {
        Random rand = new Random(System.currentTimeMillis());
        return "myNewCertificate-" + rand.nextInt(1000);
    }
}
