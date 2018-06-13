package com.arm.mbed.cloud.sdk.enrollment.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.enrollment.model.EnrollmentClaim;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.EnrollmentIdentities;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.EnrollmentIdentity;

@Preamble(description = "Adapter for enrollment claim model")
@Internal
public final class EnrollmentAdapter {

    private EnrollmentAdapter() {
        super();
    }

    /**
     * Maps an enrolment claim.
     *
     * @param enrollmentClaim
     *            enrollment claim
     * @return mapped claim
     */
    public static EnrollmentClaim map(EnrollmentIdentity enrollmentClaim) {
        if (enrollmentClaim == null) {
            return null;
        }
        final EnrollmentClaim claim = new EnrollmentClaim(enrollmentClaim.getId(),
                TranslationUtils.toDate(enrollmentClaim.getCreatedAt()),
                TranslationUtils.toDate(enrollmentClaim.getClaimedAt()),
                TranslationUtils.toDate(enrollmentClaim.getExpiresAt()), enrollmentClaim.getAccountId(),
                enrollmentClaim.getDeviceId());
        claim.setClaimId(enrollmentClaim.getEnrollmentIdentity());
        return claim;
    }

    /**
     * Gets mapper.
     *
     * @return a mapper
     */
    public static Mapper<EnrollmentIdentity, EnrollmentClaim> getMapper() {
        return new Mapper<EnrollmentIdentity, EnrollmentClaim>() {

            @Override
            public EnrollmentClaim map(EnrollmentIdentity toBeMapped) {
                return EnrollmentAdapter.map(toBeMapped);
            }

        };
    }

    /**
     * Maps a list of enrollment identities.
     *
     * @param list
     *            enrollment identities (page).
     * @return a list of enrollment identities
     */
    public static ListResponse<EnrollmentClaim> mapList(EnrollmentIdentities list) {
        final EnrollmentIdentities enrollmentList = list;
        final RespList<EnrollmentIdentity> respList = new RespList<EnrollmentIdentity>() {

            @Override
            public Boolean getHasMore() {
                return (enrollmentList == null) ? null : enrollmentList.isHasMore();
            }

            @Override
            public Integer getTotalCount() {
                return (enrollmentList == null) ? null : enrollmentList.getTotalCount();
            }

            @Override
            public String getAfter() {
                return (enrollmentList == null) ? null : enrollmentList.getAfter();
            }

            @Override
            public Integer getLimit() {
                return (enrollmentList == null) ? null : enrollmentList.getLimit();
            }

            @Override
            public String getOrder() {
                return (enrollmentList == null) ? null : enrollmentList.getOrder().toString();
            }

            @Override
            public List<EnrollmentIdentity> getData() {
                return (enrollmentList == null) ? null : enrollmentList.getData();
            }

            @Override
            public String getContinuationMarker() {
                return null;
            }
        };
        return GenericAdapter.mapList(respList, getMapper());
    }

    /**
     * Gets list mapper.
     *
     * @return list mapper
     */
    public static Mapper<EnrollmentIdentities, ListResponse<EnrollmentClaim>> getListMapper() {
        return new Mapper<EnrollmentIdentities, ListResponse<EnrollmentClaim>>() {
            @Override
            public ListResponse<EnrollmentClaim> map(EnrollmentIdentities toBeMapped) {
                return mapList(toBeMapped);
            }

        };
    }
}
