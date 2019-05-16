package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.FileDownload.Extension;
import com.arm.mbed.cloud.sdk.common.model.DataFile;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestFileDownload {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(FileDownload.class).suppress(Warning.STRICT_INHERITANCE)
                      .suppress(Warning.TRANSIENT_FIELDS)
                      .withPrefabValues(ApiClientWrapper.class,
                                        new ApiClientWrapper(ConnectionOptions.newConfiguration("1")),
                                        new ApiClientWrapper(ConnectionOptions.newConfiguration("2")))
                      .verify();
    }

    @Test
    public void testDownload() {
        final String fileUrl = "http://ipv4.download.thinkbroadband.com/10MB.zip";
        try {
            URL url = new URL(fileUrl);
            ApiClientWrapper client = new ApiClientWrapper(ConnectionOptions.newConfiguration("temp",
                                                                                              url.getProtocol() + "://"
                                                                                                      + url.getHost()));
            // FIXME add a ping test
            FileDownload download = new FileDownload(url);
            download.setClient(client);

            assertFalse(download.isDownloaded());
            download.download();
            DataFile dest1 = download.getDestinationFile();
            assertTrue(download.isDownloaded());
            DataFile dest2 = download.getDestinationFile();
            assertNotNull(dest1);
            assertTrue(dest1.isValid());
            dest1.getFile().deleteOnExit();
            assertEquals(dest1, dest2);
            assertTrue(dest1.exists());
            assertEquals("3aa55f03c298b83cd7708e90d289afbd", dest1.getMd5Checksum());
            assertNotNull(dest1.getFileName());
            assertTrue(dest1.getFileName().contains("10MB"));
            assertEquals(DataFile.BINARY_FILE_MEDIA_TYPE, dest1.getContentType());

        } catch (MalformedURLException | MbedCloudException exception) {
            exception.printStackTrace();
            fail(exception.getMessage());
        }

    }

    @Test
    public void testDataDownload() {
        try {
            FileDownload download = new FileDownload(Extension.TXT);
            assertFalse(download.isDownloaded());
            download.download("this is a test for file download");
            DataFile dest1 = download.getDestinationFile();
            assertTrue(download.isDownloaded());
            DataFile dest2 = download.getDestinationFile();
            assertNotNull(dest1);
            assertTrue(dest1.isValid());
            // dest1.getFile().deleteOnExit();
            assertEquals(dest1, dest2);
            assertTrue(dest1.exists());
            // The MD5 hash is different depending whether the test is run on Windows or Linux due to the different EOL
            // character.
            assertTrue(Arrays.asList("8854e10495f27a8c94eb1f8031328c16", "6c23c0f164d96c320203d97615bc2e66")
                             .contains(dest1.getMd5Checksum()));
            assertNotNull(dest1.getFileName());
            System.out.println(dest1.getFile());
            assertTrue(dest1.getFileName().contains("txt"));
            assertEquals(DataFile.BINARY_FILE_MEDIA_TYPE, dest1.getContentType());

        } catch (MbedCloudException exception) {
            exception.printStackTrace();
            fail(exception.getMessage());
        }

    }

}
