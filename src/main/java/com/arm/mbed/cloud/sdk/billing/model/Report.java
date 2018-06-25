package com.arm.mbed.cloud.sdk.billing.model;

import java.util.ArrayList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.internal.billing.model.ReportAccountContactInfo;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageReport;
import com.arm.mbed.cloud.sdk.internal.billing.model.SubtenantAccountReport;
import com.google.gson.annotations.SerializedName;

@Preamble(description = "Billing report")
public class Report implements SdkModel {

    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 4169699140142476988L;

    @SerializedName("account")
    private ReportAccountContactInfo account = null;

    private ReportContent aggregatedReport;

    private ReportContent billingData;

    private String id;

    private String month;

    private ServicePackageReport servicePackage = null;

    @SerializedName("subtenants")
    private List<SubtenantAccountReport> subtenants = new ArrayList<>();

    @Override
    public SdkModel clone() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isValid() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }

}
