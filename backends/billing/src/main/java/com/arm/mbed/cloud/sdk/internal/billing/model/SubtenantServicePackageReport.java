/*
 * Billing API
 * Billing API allows commercial users to retrieve billing reports and service package details.  **Billing Reports:**  Billing reports for the previous month are generated automatically during the third business day of the current month. The reports will be available usually by 02:00 AM UTC.  **Service package:**  A service package can be created for the commercial accounts with a specific number of firmware updates referred to as the service package quota. A customer can only perform device updates equal to the number of firmware updates linked to an active service package. A customer needs to purchase a new service package or renew an active service package if they have consumed all the quota linked to an active service package.  Aggregator customers share their service package quota with their own subtenant accounts. A subtenant can create campaigns utilizing their parent's service package quota. A subtenant cannot create or manage service packages on their own. The quota usage history is recorded separately between the aggregator and its subtenants.  **Service package events:**  The following service package events are included in the API responses:  **reservation:**  A reservation event refers to the creation of a new update campaign with an estimated number of firmware updates.  **reservation_release:**  A reservation_release event refers to closing an update campaign. The unused quota reserved through the update campaign will be added to the active service package quota at this point.  **reservation_termination:**  A reservation_termination event refers to the termination of an update campaign due to the expiration of an active service package. The unused quota reserved through the update campaign cannot be used anymore as the active service package is expired.  **package_creation:**  A package_creation event refers to the creation of a new service package.  **package_renewal:**  A package_renewal event refers to the renewal of an active service package before it expires.  **package_termination:**  A package_termination event refers to the expiration of an active service package. The unused quota linked to the expired service package cannot be used anymore. 
 *
 * OpenAPI spec version: 1.4.9
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.arm.mbed.cloud.sdk.internal.billing.model;

import java.util.Objects;
import com.arm.mbed.cloud.sdk.internal.billing.model.QuotaUsageReport;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * SubtenantServicePackageReport
 */

public class SubtenantServicePackageReport implements Serializable {
  private static final long serialVersionUID = 1L;

  @SerializedName("quota_usage")
  private List<QuotaUsageReport> quotaUsage = new ArrayList<QuotaUsageReport>();

  public SubtenantServicePackageReport quotaUsage(List<QuotaUsageReport> quotaUsage) {
    this.quotaUsage = quotaUsage;
    return this;
  }

  public SubtenantServicePackageReport addQuotaUsageItem(QuotaUsageReport quotaUsageItem) {
    this.quotaUsage.add(quotaUsageItem);
    return this;
  }

   /**
   * Get quotaUsage
   * @return quotaUsage
  **/
  @ApiModelProperty(required = true, value = "")
  public List<QuotaUsageReport> getQuotaUsage() {
    return quotaUsage;
  }

  public void setQuotaUsage(List<QuotaUsageReport> quotaUsage) {
    this.quotaUsage = quotaUsage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubtenantServicePackageReport subtenantServicePackageReport = (SubtenantServicePackageReport) o;
    return Objects.equals(this.quotaUsage, subtenantServicePackageReport.quotaUsage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(quotaUsage);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubtenantServicePackageReport {\n");
    
    sb.append("    quotaUsage: ").append(toIndentedString(quotaUsage)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
