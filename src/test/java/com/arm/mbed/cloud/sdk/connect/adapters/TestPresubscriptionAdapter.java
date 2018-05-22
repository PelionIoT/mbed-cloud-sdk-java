package com.arm.mbed.cloud.sdk.connect.adapters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.connect.model.Presubscription;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

public class TestPresubscriptionAdapter {

    @Test
    public void testMapSubscriptionFilter() {
        SubscriptionFilterOptions opt = null;
        List<Presubscription> list = null;
        // Devices - equal filter
        opt = SubscriptionFilterOptions.newFilter().equalResourcePath("/56/435/3/")
                .inResourcePaths("/102/2/3/,/102/2/4/").likeResourcePaths(Arrays.asList("/105/%", "/0/1.*", "/2/5/"))
                .equalDevice("015f361175ae0000000000010010003a");
        list = PresubscriptionAdapter.mapSubscriptionFilter(opt);
        assertNotNull(list);
        assertEquals(1, list.size());
        assertNotNull(list.get(0).getResourcePaths());
        assertEquals("015f361175ae0000000000010010003a", list.get(0).getDeviceId());

        // Devices - like filter
        opt = SubscriptionFilterOptions.newFilter().equalResourcePath("/56/435/3/")
                .inResourcePaths("/102/2/3/,/102/2/4/").likeResourcePaths(Arrays.asList("/105/%", "/0/1.*", "/2/5/"))
                .likeDevice("015f35%");
        list = PresubscriptionAdapter.mapSubscriptionFilter(opt);
        assertNotNull(list);
        assertEquals(1, list.size());
        assertNotNull(list.get(0).getResourcePaths());
        assertEquals("015f35*", list.get(0).getDeviceId());

        // Devices - in filter
        opt = SubscriptionFilterOptions.newFilter().equalResourcePath("/56/435/3/")
                .inResourcePaths("/102/2/3/,/102/2/4/").likeResourcePaths(Arrays.asList("/105/%", "/0/1.*", "/2/5/"))
                .inDeviceIds("015f361175ae0000000000010010003a,015f4d820be900000000000100100040");
        list = PresubscriptionAdapter.mapSubscriptionFilter(opt);
        assertNotNull(list);
        assertEquals(2, list.size());
        assertEquals(list.get(0).getResourcePaths(), list.get(1).getResourcePaths());
        assertEquals("015f361175ae0000000000010010003a", list.get(0).getDeviceId());
        assertEquals("015f4d820be900000000000100100040", list.get(1).getDeviceId());

        // Just resource paths
        opt = SubscriptionFilterOptions.newFilter().equalResourcePath("/56/435/3/")
                .inResourcePaths("/102/2/3/,/102/2/4/").likeResourcePaths(Arrays.asList("/105/%", "/0/1.*", "/2/5/"));
        list = PresubscriptionAdapter.mapSubscriptionFilter(opt);
        assertNotNull(list);
        assertEquals(1, list.size());
        Presubscription presubscription = list.get(0);
        assertEquals(6, presubscription.getResourcePaths().size());
        assertTrue(presubscription.getResourcePaths().contains("/56/435/3/"));
        assertTrue(presubscription.getResourcePaths().contains("/102/2/3/"));
        assertTrue(presubscription.getResourcePaths().contains("/102/2/4/"));
        assertTrue(presubscription.getResourcePaths().contains("/105/*"));
        assertTrue(presubscription.getResourcePaths().contains("/0/1*"));
        assertTrue(presubscription.getResourcePaths().contains("/2/5/*"));

        // Global presubscription
        opt = SubscriptionFilterOptions.newFilter();
        list = PresubscriptionAdapter.mapSubscriptionFilter(opt);
        assertNotNull(list);
        assertEquals(1, list.size());
        assertEquals(Presubscription.TO_EVERYTHING, list.get(0));
        opt = SubscriptionFilterOptions.newFilter().likeResourcePaths(Arrays.asList("/105/%/", "/0/1.*", "/2/5/"));
        list = PresubscriptionAdapter.mapSubscriptionFilter(opt);
        assertNotNull(list);
        assertEquals(1, list.size());
        assertEquals(Presubscription.TO_EVERYTHING, list.get(0));

        // Combination of device filters
        opt = SubscriptionFilterOptions.newFilter().equalResourcePath("/56/435/3/")
                .inResourcePaths("/102/2/3/,/102/2/4/").likeResourcePaths(Arrays.asList("/105/%", "/0/1.*", "/2/5/"))
                .equalDevice("015f361175ae0000000000010010003a").likeDevice("015f35_");
        list = PresubscriptionAdapter.mapSubscriptionFilter(opt);
        assertNotNull(list);
        assertEquals(2, list.size());
        assertEquals(list.get(0).getResourcePaths(), list.get(1).getResourcePaths());
        assertEquals("015f361175ae0000000000010010003a", list.get(0).getDeviceId());
        assertEquals("015f35*", list.get(1).getDeviceId());

    }

    @Test
    public void testMapPresubscriptionResourcePath() {
        Presubscription presubscription = new Presubscription();
        SubscriptionFilterOptions opt = SubscriptionFilterOptions.newFilter().equalResourcePath("/56/435/3/")
                .inResourcePaths("/102/2/3/,/102/2/4/").likeResourcePaths(Arrays.asList("/105/%", "/0/1.*", "/2/5/"));
        PresubscriptionAdapter.mapPresubscriptionResourcePath(opt, presubscription);
        assertNull(presubscription.getDeviceId());
        assertNotNull(presubscription.getResourcePaths());
        assertEquals(6, presubscription.getResourcePaths().size());
        assertTrue(presubscription.getResourcePaths().contains("/56/435/3/"));
        assertTrue(presubscription.getResourcePaths().contains("/102/2/3/"));
        assertTrue(presubscription.getResourcePaths().contains("/102/2/4/"));
        assertTrue(presubscription.getResourcePaths().contains("/105/*"));
        assertTrue(presubscription.getResourcePaths().contains("/0/1*"));
        assertTrue(presubscription.getResourcePaths().contains("/2/5/*"));
        presubscription = new Presubscription();
        opt = SubscriptionFilterOptions.newFilter().likeResourcePaths(Arrays.asList("/105/%/", "/0/1.*", "/2/5/"));
        PresubscriptionAdapter.mapPresubscriptionResourcePath(opt, presubscription);
        assertNull(presubscription.getResourcePaths());
    }

    @Test
    public void testMapLikeResourcePaths() {
        Presubscription presubscription = new Presubscription();
        PresubscriptionAdapter.mapLikeResourcePaths(presubscription, Arrays.asList("/102/2/3/_", "/56/435/3/*"));
        assertNotNull(presubscription.getResourcePaths());
        assertEquals(2, presubscription.getResourcePaths().size());
        assertTrue(presubscription.getResourcePaths().contains("/102/2/3/*"));
        assertTrue(presubscription.getResourcePaths().contains("/56/435/3/*"));
        presubscription = new Presubscription();
        PresubscriptionAdapter.mapLikeResourcePaths(presubscription, Arrays.asList("/102/2/3/_", "/56/_/3/"));
        assertNull(presubscription.getResourcePaths());
    }

    @Test
    public void testMapLikeResourcePath() {
        String presubscription = "/102/2/3/_";
        assertEquals("/102/2/3/*", PresubscriptionAdapter.mapLikeResourcePath(presubscription));
        presubscription = "/102/2/3/%";
        assertEquals("/102/2/3/*", PresubscriptionAdapter.mapLikeResourcePath(presubscription));
        presubscription = "/102/2/3/?";
        assertEquals("/102/2/3/*", PresubscriptionAdapter.mapLikeResourcePath(presubscription));
        presubscription = "/102/2/3/*";
        assertEquals("/102/2/3/*", PresubscriptionAdapter.mapLikeResourcePath(presubscription));
        presubscription = "/102/2/3/.*";
        assertEquals("/102/2/3/*", PresubscriptionAdapter.mapLikeResourcePath(presubscription));
        presubscription = "/102/2/3/";
        assertEquals("/102/2/3/*", PresubscriptionAdapter.mapLikeResourcePath(presubscription));
        presubscription = "/102/*/3/";
        assertNull(PresubscriptionAdapter.mapLikeResourcePath(presubscription));
        presubscription = "/102/.*/3/";
        assertNull(PresubscriptionAdapter.mapLikeResourcePath(presubscription));
        presubscription = "/102/_/3/";
        assertNull(PresubscriptionAdapter.mapLikeResourcePath(presubscription));
        presubscription = "/102/?/3/";
        assertNull(PresubscriptionAdapter.mapLikeResourcePath(presubscription));
        presubscription = "%/102/12/3/";
        assertNull(PresubscriptionAdapter.mapLikeResourcePath(presubscription));
    }

    @Test
    public void testMapLikeDeviceIdPath() {
        String presubscription = "015d713ef1640_";
        assertEquals("015d713ef1640*", PresubscriptionAdapter.mapLikeDeviceIdPath(presubscription));
        presubscription = "015d713ef1640%";
        assertEquals("015d713ef1640*", PresubscriptionAdapter.mapLikeDeviceIdPath(presubscription));
        presubscription = "015d713ef1640?";
        assertEquals("015d713ef1640*", PresubscriptionAdapter.mapLikeDeviceIdPath(presubscription));
        presubscription = "015d713ef1640*";
        assertEquals("015d713ef1640*", PresubscriptionAdapter.mapLikeDeviceIdPath(presubscription));
        presubscription = "015d713ef1640.*";
        assertEquals("015d713ef1640*", PresubscriptionAdapter.mapLikeDeviceIdPath(presubscription));
        presubscription = "015d713ef1640";
        assertEquals("015d713ef1640*", PresubscriptionAdapter.mapLikeDeviceIdPath(presubscription));
        presubscription = "015d71*168";
        assertNull(PresubscriptionAdapter.mapLikeDeviceIdPath(presubscription));
        presubscription = "015d71.*168";
        assertNull(PresubscriptionAdapter.mapLikeDeviceIdPath(presubscription));
        presubscription = "015d71_168";
        assertNull(PresubscriptionAdapter.mapLikeDeviceIdPath(presubscription));
        presubscription = "015d71?168";
        assertNull(PresubscriptionAdapter.mapLikeDeviceIdPath(presubscription));
        presubscription = "%00100168";
        assertNull(PresubscriptionAdapter.mapLikeDeviceIdPath(presubscription));
    }

}
