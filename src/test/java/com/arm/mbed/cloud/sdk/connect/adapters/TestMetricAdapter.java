package com.arm.mbed.cloud.sdk.connect.adapters;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.listing.IncludeField;

public class TestMetricAdapter {

    @Test
    public void testMapIncludes() {
        assertEquals("bootstraps_failed,bootstraps_successful,connect_rest_api_error,device_observations,registration_updates,transactions,full_registrations,connect_rest_api_success,device_proxy_request_success,handshakes_successful,device_proxy_request_error,device_subscription_request_success,deleted_registrations,bootstraps_pending,device_subscription_request_error,expired_registrations",
                     MetricAdapter.mapIncludes(null));

        List<IncludeField> list = new LinkedList<>();
        list.add(new IncludeField("successfulBootstraps"));
        list.add(new IncludeField("successfulProxyRequests"));
        list.add(new IncludeField("expiredRegistrations"));
        list.add(new IncludeField("fullRegistrations"));
        assertEquals("bootstraps_successful,device_proxy_request_success,expired_registrations,full_registrations",
                     MetricAdapter.mapIncludes(list));
    }
}
