package com.arm.mbed.cloud.sdk;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.PageRequester;
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
public class Enrollment extends AbstractApi {

    private static final String TAG_ENROLLMENT_ID = "device enrollment id";
    private static final String TAG_ENROLLMENT = "device enrollment claim";

    private final EndPoints endpoint;

    /**
     * Enrolment module constructor.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}.
     */
    public Enrollment(@NonNull ConnectionOptions options) {
        super(options);
        endpoint = new EndPoints(this.serviceRegistry);
    }

    /**
     * Lists all device enrolment claims.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     ListOptions options = new ListOptions();
     *      options.setLimit(20);
     *
     *     ListResponse<EnrollmentClaim> enrollments = enrollmentApi.listEnrollmentClaims(options);
     *     for (EnrollmentClaim enrollment : enrollments) {
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
    public @Nullable ListResponse<EnrollmentClaim>
           listEnrollmentClaims(@Nullable ListOptions options) throws MbedCloudException {
        final ListOptions finalOptions = (options == null) ? new ListOptions() : options;

        return CloudCaller.call(this, "listEnrollmentClaims()", EnrollmentAdapter.getListMapper(),
                                new CloudCall<EnrollmentIdentities>() {

                                    @Override
                                    public Call<EnrollmentIdentities> call() {
                                        return endpoint.getEnrollment()
                                                       .getDeviceEnrollments(finalOptions.getPageSize(),
                                                                             finalOptions.getAfter(),
                                                                             finalOptions.getOrder().toString(),
                                                                             finalOptions.encodeInclude());
                                    }
                                });
    }

    /**
     * Gets an iterator over all device enrolment claims.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     ListOptions options = new ListOptions();
     *     Paginator<EnrollmentClaim> enrollments = enrollmentApi.listAllEnrollmentClaims(options);
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
    public @Nullable Paginator<EnrollmentClaim>
           listAllEnrollmentClaims(@Nullable ListOptions options) throws MbedCloudException {
        return new Paginator<>((options == null) ? new ListOptions() : options, new PageRequester<EnrollmentClaim>() {

            @Override
            public ListResponse<EnrollmentClaim> requestNewPage(ListOptions opt) throws MbedCloudException {
                return listEnrollmentClaims(opt);
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
     *     String deviceEnrollmentId = "";
     *     EnrollmentClaim deviceEnrollment = enrollmentApi.getEnrollmentClaim(deviceEnrollmentId);
     *     System.out.println(deviceEnrollment);
     *
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param enrollmentId
     *            the ID of the device enrolment.
     * @return device enrolment details.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable EnrollmentClaim getEnrollmentClaim(@NonNull String enrollmentId) throws MbedCloudException {
        checkNotNull(enrollmentId, TAG_ENROLLMENT_ID);
        final String finalId = enrollmentId;
        return CloudCaller.call(this, "getEnrollmentClaim()", EnrollmentAdapter.getMapper(),
                                new CloudCall<EnrollmentIdentity>() {

                                    @Override
                                    public Call<EnrollmentIdentity> call() {
                                        return endpoint.getEnrollment().getDeviceEnrollment(finalId);
                                    }

                                });
    }

    /**
     * Places an enrolment claim for one or several devices.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     String claimId = "A-35:e7:72:8a:07:50:3b:3d:75:96:57:52:72:41:0d:78:cc:c6:e5:53:48:c6:65:58:5b:fa:af:4d:2d:73:95:c5";
    *     EnrollmentClaim claim = enrollmentApi.addEnrollmentClaim(claimId)
     *     System.out.println(claim);
     *
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param claimId
     *            Claim Id. Pattern: '^[A-Z]{1}-[A-Za-z0-9:]{1, 256}' e.g.
     *            A-35:e7:72:8a:07:50:3b:3d:75:96:57:52:72:41:0d:78:cc:c6:e5:53:48:c6:65:58:5b:fa:af:4d:2d:73:95:c5
     * @return enrollment claim.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable EnrollmentClaim addEnrollmentClaim(@NonNull String claimId) throws MbedCloudException {
        checkNotNull(claimId, TAG_ENROLLMENT_ID);
        final EnrollmentId finalEnrollmentId = new EnrollmentId().enrollmentIdentity(claimId);
        return CloudCaller.call(this, "addEnrollmentClaim()", EnrollmentAdapter.getMapper(),
                                new CloudCall<EnrollmentIdentity>() {

                                    @Override
                                    public Call<EnrollmentIdentity> call() {
                                        return endpoint.getEnrollment().createDeviceEnrollment(finalEnrollmentId);
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
     *       enrollmentApi.deleteEnrollmentClaim("5454");
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param enrollmentId
     *            the ID of the device enrolment.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void deleteEnrollmentClaim(@NonNull String enrollmentId) throws MbedCloudException {
        checkNotNull(enrollmentId, TAG_ENROLLMENT_ID);
        final String finalId = enrollmentId;
        CloudCaller.call(this, "deleteEnrollmentClaim()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getEnrollment().deleteDeviceEnrollment(finalId);
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
     *     EnrollmentClaim enrollmentClaim = enrollmentApi.getEnrollmentClaim("4543");
     *     enrollmentApi.deleteEnrollmentClaim(enrollmentClaim);
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param enrollmentClaim
     *            An enrolment claim to delete
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void deleteEnrollmentClaim(@NonNull EnrollmentClaim enrollmentClaim) throws MbedCloudException {
        checkNotNull(enrollmentClaim, TAG_ENROLLMENT);
        deleteEnrollmentClaim(enrollmentClaim.getId());
    }

    /**
     * Retrieves module name.
     *
     * @return module name.
     */
    @Override
    public String getModuleName() {
        return "Enrollment";
    }
}
