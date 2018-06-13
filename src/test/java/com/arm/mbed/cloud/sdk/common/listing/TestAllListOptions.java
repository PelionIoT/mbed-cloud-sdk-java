package com.arm.mbed.cloud.sdk.common.listing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;

import java.util.GregorianCalendar;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.accountmanagement.model.ApiKeyListOptions;
import com.arm.mbed.cloud.sdk.accountmanagement.model.UserListOptions;
import com.arm.mbed.cloud.sdk.certificates.model.CertificateListOptions;
import com.arm.mbed.cloud.sdk.connect.model.MetricsPeriodListOptions;
import com.arm.mbed.cloud.sdk.connect.model.MetricsStartEndListOptions;
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceEventListOptions;
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceListOptions;
import com.arm.mbed.cloud.sdk.devicedirectory.model.QueryListOptions;
import com.arm.mbed.cloud.sdk.update.model.CampaignDevicesStatesListOptions;
import com.arm.mbed.cloud.sdk.update.model.CampaignListOptions;
import com.arm.mbed.cloud.sdk.update.model.FirmwareImageListOptions;
import com.arm.mbed.cloud.sdk.update.model.FirmwareManifestListOptions;

public class TestAllListOptions {

    @Test
    public void testMetricPeriodListOptionsClone() {
        MetricsPeriodListOptions opt1 = new MetricsPeriodListOptions();
        opt1.addEqualFilter("field1", Integer.valueOf(3));
        opt1.includeTotalCount();
        opt1.setMaxResults(Long.valueOf(2));
        opt1.setPageSize(Integer.valueOf(2));
        opt1.setPeriod("30d");
        opt1.setInterval("2d");
        MetricsPeriodListOptions opt2 = new MetricsPeriodListOptions();
        assertNotEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
        opt2 = opt1.clone();
        assertEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
    }

    @Test
    public void testMetricStartEndListOptionsClone() {
        MetricsStartEndListOptions opt1 = new MetricsStartEndListOptions();
        opt1.addEqualFilter("field1", Integer.valueOf(3));
        opt1.includeTotalCount();
        opt1.setMaxResults(Long.valueOf(2));
        opt1.setPageSize(Integer.valueOf(2));
        opt1.setInterval("1d");
        opt1.setStart(new GregorianCalendar(2017, 0, 9).getTime());
        opt1.setEnd(new GregorianCalendar(2018, 0, 9).getTime());
        MetricsStartEndListOptions opt2 = new MetricsStartEndListOptions();
        assertNotEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
        opt2 = opt1.clone();
        assertEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
    }

    @Test
    public void testApiKeyListOptionsClone() {
        ApiKeyListOptions opt1 = new ApiKeyListOptions();
        opt1.addEqualFilter("field1", Integer.valueOf(3));
        opt1.includeTotalCount();
        opt1.setMaxResults(Long.valueOf(2));
        opt1.setPageSize(Integer.valueOf(2));
        ApiKeyListOptions opt2 = new ApiKeyListOptions();
        assertNotEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
        opt2 = opt1.clone();
        assertEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
    }

    @Test
    public void testCampaignDevicesStatesListOptionsClone() {
        CampaignDevicesStatesListOptions opt1 = new CampaignDevicesStatesListOptions();
        opt1.addEqualFilter("field1", Integer.valueOf(3));
        opt1.includeTotalCount();
        opt1.setMaxResults(Long.valueOf(2));
        opt1.setPageSize(Integer.valueOf(2));
        CampaignDevicesStatesListOptions opt2 = new CampaignDevicesStatesListOptions();
        assertNotEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
        opt2 = opt1.clone();
        assertEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
    }

    @Test
    public void testCampaignListOptionsClone() {
        CampaignListOptions opt1 = new CampaignListOptions();
        opt1.addEqualFilter("field1", Integer.valueOf(3));
        opt1.includeTotalCount();
        opt1.setMaxResults(Long.valueOf(2));
        opt1.setPageSize(Integer.valueOf(2));
        CampaignListOptions opt2 = new CampaignListOptions();
        assertNotEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
        opt2 = opt1.clone();
        assertEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
    }

    @Test
    public void testCertificateListOptionsClone() {
        CertificateListOptions opt1 = new CertificateListOptions();
        opt1.addEqualFilter("field1", Integer.valueOf(3));
        opt1.includeTotalCount();
        opt1.setMaxResults(Long.valueOf(2));
        opt1.setPageSize(Integer.valueOf(2));
        CertificateListOptions opt2 = new CertificateListOptions();
        assertNotEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
        opt2 = opt1.clone();
        assertEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
    }

    @Test
    public void testDeviceEventListOptionsClone() {
        DeviceEventListOptions opt1 = new DeviceEventListOptions();
        opt1.addEqualFilter("field1", Integer.valueOf(3));
        opt1.includeTotalCount();
        opt1.setMaxResults(Long.valueOf(2));
        opt1.setPageSize(Integer.valueOf(2));
        DeviceEventListOptions opt2 = new DeviceEventListOptions();
        assertNotEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
        opt2 = opt1.clone();
        assertEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
    }

    @Test
    public void testDeviceListOptionsClone() {
        DeviceListOptions opt1 = new DeviceListOptions();
        opt1.addEqualFilter("field1", Integer.valueOf(3));
        opt1.includeTotalCount();
        opt1.setMaxResults(Long.valueOf(2));
        opt1.setPageSize(Integer.valueOf(2));
        DeviceListOptions opt2 = new DeviceListOptions();
        assertNotEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
        opt2 = opt1.clone();
        assertEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
    }

    @Test
    public void testFirmwareImageListOptionsClone() {
        FirmwareImageListOptions opt1 = new FirmwareImageListOptions();
        opt1.addEqualFilter("field1", Integer.valueOf(3));
        opt1.includeTotalCount();
        opt1.setMaxResults(Long.valueOf(2));
        opt1.setPageSize(Integer.valueOf(2));
        FirmwareImageListOptions opt2 = new FirmwareImageListOptions();
        assertNotEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
        opt2 = opt1.clone();
        assertEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
    }

    @Test
    public void testFirmwareManifestListOptionsClone() {
        FirmwareManifestListOptions opt1 = new FirmwareManifestListOptions();
        opt1.addEqualFilter("field1", Integer.valueOf(3));
        opt1.includeTotalCount();
        opt1.setMaxResults(Long.valueOf(2));
        opt1.setPageSize(Integer.valueOf(2));
        FirmwareManifestListOptions opt2 = new FirmwareManifestListOptions();
        assertNotEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
        opt2 = opt1.clone();
        assertEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
    }

    @Test
    public void testQueryListOptionsClone() {
        QueryListOptions opt1 = new QueryListOptions();
        opt1.addEqualFilter("field1", Integer.valueOf(3));
        opt1.includeTotalCount();
        opt1.setMaxResults(Long.valueOf(2));
        opt1.setPageSize(Integer.valueOf(2));
        QueryListOptions opt2 = new QueryListOptions();
        assertNotEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
        opt2 = opt1.clone();
        assertEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
    }

    @Test
    public void testUserListOptionsClone() {
        UserListOptions opt1 = new UserListOptions();
        opt1.addEqualFilter("field1", Integer.valueOf(3));
        opt1.includeTotalCount();
        opt1.setMaxResults(Long.valueOf(2));
        opt1.setPageSize(Integer.valueOf(2));
        UserListOptions opt2 = new UserListOptions();
        assertNotEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
        opt2 = opt1.clone();
        assertEquals(opt2, opt1);
        assertNotSame(opt2, opt1);
    }
}
