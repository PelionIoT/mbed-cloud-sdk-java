package com.arm.mbed.cloud.sdk;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudCaller.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.PageRequester;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.enrollment.adapters.EnrollmentAdapter;
import com.arm.mbed.cloud.sdk.enrollment.model.EndPoints;
import com.arm.mbed.cloud.sdk.enrollment.model.EnrollmentClaim;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.EnrollmentId;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.EnrollmentIdentities;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.EnrollmentIdentity;

import retrofit2.Call;

@Preamble(description = "Specifies Enrollment API")
@Module
/**
 * API exposing functionality for dealing with enrolment.
 */
public class EnrollmentManagement extends AbstractApi {

    private static final String TAG_ENROLLMENT_ID = "device enrollment id";
    private static final String TAG_ENROLLMENT = "device enrollment claim";

    private final EndPoints endpoint;

    /**
     * Enrolment module constructor.
     * 
     * @param options
     *            connection options @see {@link ConnectionOptions}.
     */
    public EnrollmentManagement(@NonNull ConnectionOptions options) {
        super(options);
        endpoint = new EndPoints(this.client);
    }

    /**
     * Lists all device enrolments.
     * <p>
     * Example:
     * 
     * <pre>
     * {@code
     * try {
     *     ListOptions options = new ListOptions();
     *      options.setLimit(20);
     *
     *     ListResponse<Enrollment> enrollments = enrollmentApi.listDeviceEnrollments(options);
     *     for (Enrollment enrollment : enrollments) {
     *         System.out.println(enrollment.toString());
     *     }
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     * 
     * @param options
     *            list options.
     * @return The list of enrolments (One page).
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable ListResponse<EnrollmentClaim> listDeviceEnrollments(@Nullable ListOptions options)
            throws MbedCloudException {
        final ListOptions finalOptions = (options == null) ? new ListOptions() : options;

        return CloudCaller.call(this, "listDeviceEnrollments()", EnrollmentAdapter.getListMapper(),
                new CloudCall<EnrollmentIdentities>() {

                    @Override
                    public Call<EnrollmentIdentities> call() {
                        return endpoint.getEnrollment().v3DeviceEnrollmentsGet(finalOptions.getLimit(),
                                finalOptions.getAfter(), finalOptions.getOrder().toString());
                    }
                });
    }

    /**
     * Gets an iterator over all device enrolments.
     * <p>
     * Example:
     * 
     * <pre>
     * {@code
     * try {
     *     ListOptions options = new ListOptions();    
     *     Paginator<Enrollment> enrollments = enrollmentApi.listAllDeviceEnrollments(options);
     *     while (enrollments.hasNext()) {
     *         System.out.println(enrollments.next());
     *     }
     *
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     * 
     * @param options
     *            filter options.
     * @return paginator @see {@link Paginator} for the list of device enrolments corresponding to filter options.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Paginator<EnrollmentClaim> listAllDeviceEnrollments(@Nullable ListOptions options)
            throws MbedCloudException {
        return new Paginator<>((options == null) ? new ListOptions() : options, new PageRequester<EnrollmentClaim>() {

            @Override
            public ListResponse<EnrollmentClaim> requestNewPage(ListOptions opt) throws MbedCloudException {
                return listDeviceEnrollments(opt);
            }
        });
    }

    /**
     * Gets details about a device enrolment.
     * <p>
     * Example:
     * 
     * <pre>
     * {@code
     * try {
     *     String deviceEnrollmentId = "015f4ac587f500000000000100100249";
     *     Enrollment deviceEnrollment = enrollmentApi.getDeviceEnrollment(deviceEnrollmentId);
     *     System.out.println(deviceEnrollment);
     *
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     * 
     * @param deviceEnrollmentId
     *            the ID of the device enrolment.
     * @return device enrolment details.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable EnrollmentClaim getDeviceEnrollment(@NonNull String enrollmentId) throws MbedCloudException {
        checkNotNull(enrollmentId, TAG_ENROLLMENT_ID);
        final String finalId = enrollmentId;
        return CloudCaller.call(this, "getDeviceEnrollment()", EnrollmentAdapter.getMapper(),
                new CloudCall<EnrollmentIdentity>() {

                    @Override
                    public Call<EnrollmentIdentity> call() {
                        return endpoint.getEnrollment().v3DeviceEnrollmentsidGet();// TODO add finalId
                    }

                });
    }

    /**
     * Place an enrolment claim for one or several devices.
     * <p>
     * Example:
     * 
     * <pre>
     * {@code
     * try {
     *     String enrollmentIdentity = "A-35:e7:72:8a:07:50:3b:3d:75:96:57:52:72:41:0d:78:cc:c6:e5:53:48:c6:65:58:5b:fa:af:4d:2d:73:95:c5";
    *     EnrollmentClaim claim = enrollmentApi.placeEnrollmentClaim(enrollmentIdentity0
     *     System.out.println(claim);
     *
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     * 
     * @param enrollmentId
     *            Enrollment identity. Pattern: '^[A-Z]{1}-[A-Za-z0-9:]{1, 256}' e.g.
     *            A-35:e7:72:8a:07:50:3b:3d:75:96:57:52:72:41:0d:78:cc:c6:e5:53:48:c6:65:58:5b:fa:af:4d:2d:73:95:c5
     * @return enrollment claim.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable EnrollmentClaim placeEnrollmentClaim(@NonNull String enrollmentId) throws MbedCloudException {
        checkNotNull(enrollmentId, TAG_ENROLLMENT_ID);
        final EnrollmentId finalEnrollmentId = new EnrollmentId().enrollmentIdentity(enrollmentId);
        return CloudCaller.call(this, "placeEnrollmentClaim()", EnrollmentAdapter.getMapper(),
                new CloudCall<EnrollmentIdentity>() {

                    @Override
                    public Call<EnrollmentIdentity> call() {
                        return endpoint.getEnrollment().v3DeviceEnrollmentsPost(finalEnrollmentId);
                    }

                });
    }

    /**
     * Deletes a device enrolment claim.
     * <p>
     * Example:
     * 
     * <pre>
     * {@code
     * try {
     *       enrollmentApi.deleteDeviceEnrollment("A-35:e7:72:8a:07:50:3b:3d:75:96:57:52:72:41:0d:78:cc:c6:e5:53:48:c6:65:58:5b:fa:af:4d:2d:73:95:c5");
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     * 
     * @param enrollmentId
     *            Enrollment identity of the claim to delete. Pattern: '^[A-Z]{1}-[A-Za-z0-9:]{1, 256}' e.g.
     *            A-35:e7:72:8a:07:50:3b:3d:75:96:57:52:72:41:0d:78:cc:c6:e5:53:48:c6:65:58:5b:fa:af:4d:2d:73:95:c5
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void deleteDeviceEnrollment(@NonNull String enrollmentId) throws MbedCloudException {
        checkNotNull(enrollmentId, TAG_ENROLLMENT_ID);
        final String finalId = enrollmentId;
        CloudCaller.call(this, "deleteDeviceEnrollment()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getEnrollment().v3DeviceEnrollmentsidDelete();// TODO add finalId
            }

        });
    }

    /**
     * Deletes a device enrolment claim.
     * <p>
     * Example:
     * 
     * <pre>
     * {@code
     * try {
     *     EnrollmentClaim enrollmentClaim = enrollmentApi.getDeviceEnrollment("A-35:e7:72:8a:07:50:3b:3d:75:96:57:52:72:41:0d:78:cc:c6:e5:53:48:c6:65:58:5b:fa:af:4d:2d:73:95:c5");
     *     enrollmentApi.deleteDeviceEnrollment(enrollmentClaim);
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     * 
     * @param enrollmentClaim
     *            An enrollment claim to delete
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void deleteDeviceEnrollment(@NonNull EnrollmentClaim enrollmentClaim) throws MbedCloudException {
        checkNotNull(enrollmentClaim, TAG_ENROLLMENT);
        deleteDeviceEnrollment(enrollmentClaim.getId());
    }

    /**
     * Retrieves module name.
     * 
     * @return module name.
     */
    @Override
    public String getModuleName() {
        return "EnrollmentManagement";
    }
}
