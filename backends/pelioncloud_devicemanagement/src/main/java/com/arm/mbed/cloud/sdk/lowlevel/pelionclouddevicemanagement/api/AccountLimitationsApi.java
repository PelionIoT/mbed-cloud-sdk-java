package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountLimitation;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountLimitationList;

public interface AccountLimitationsApi {
    /**
     * Get a limitation of an account. An endpoint for retrieving a limitation of an account.
     * 
     * @param limitationId
     *            The ID of the limitation to be fetched. (required)
     * @return Call&lt;AccountLimitation&gt;
     */
    @GET("v3/limitations/{limitation_id}")
    Call<AccountLimitation>
        getAccountLimitation(@retrofit2.http.Path(value = "limitation_id", encoded = true) String limitationId);

    /**
     * Get all limitations of an account. An endpoint for retrieving all limitations of an account.
     * 
     * @param inheritedEq
     *            Filter for finding account limitations by inheritance. True returns also inherited limitations. False
     *            returns only non-inherited ones. (optional)
     * @return Call&lt;AccountLimitationList&gt;
     */
    @GET("v3/limitations")
    Call<AccountLimitationList> getAccountLimitations(@retrofit2.http.Query("inherited__eq") String inheritedEq);

}
