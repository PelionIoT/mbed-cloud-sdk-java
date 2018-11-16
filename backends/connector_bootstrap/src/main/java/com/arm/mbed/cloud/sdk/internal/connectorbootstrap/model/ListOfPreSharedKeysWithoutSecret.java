/*
 * Bootstrap API
 * Bootstrap API allows web applications to control the device bootstrapping process.
 *
 * OpenAPI spec version: 2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.arm.mbed.cloud.sdk.internal.connectorbootstrap.model;

import java.util.Objects;
import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.model.PreSharedKeyWithoutSecret;
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
 * ListOfPreSharedKeysWithoutSecret
 */

public class ListOfPreSharedKeysWithoutSecret implements Serializable {
  private static final long serialVersionUID = 1L;

  @SerializedName("after")
  private String after = null;

  @SerializedName("continuation_marker")
  private String continuationMarker = null;

  @SerializedName("data")
  private List<PreSharedKeyWithoutSecret> data = new ArrayList<PreSharedKeyWithoutSecret>();

  @SerializedName("has_more")
  private Boolean hasMore = null;

  @SerializedName("limit")
  private Integer limit = null;

  @SerializedName("object")
  private String object = null;

  @SerializedName("order")
  private String order = null;

  public ListOfPreSharedKeysWithoutSecret after(String after) {
    this.after = after;
    return this;
  }

   /**
   * An offset token for current page.
   * @return after
  **/
  @ApiModelProperty(example = "001e001000120010fac8f300487f11e8839a459edde8bd42f07fffffebf07fffffebb1219cc7862b64bbaf775dc545e274810004", value = "An offset token for current page.")
  public String getAfter() {
    return after;
  }

  public void setAfter(String after) {
    this.after = after;
  }

  public ListOfPreSharedKeysWithoutSecret continuationMarker(String continuationMarker) {
    this.continuationMarker = continuationMarker;
    return this;
  }

   /**
   * An offset token for fetching the next page. Note that exactly the same limit needs to be used on the request for fetching the subsequent pages.
   * @return continuationMarker
  **/
  @ApiModelProperty(example = "001e001000120010fac8f300487f11e8839a459edde8bd42f07fffffebf07fffffebb1219cc7862b64bbaf775dc545e274810005", value = "An offset token for fetching the next page. Note that exactly the same limit needs to be used on the request for fetching the subsequent pages.")
  public String getContinuationMarker() {
    return continuationMarker;
  }

  public void setContinuationMarker(String continuationMarker) {
    this.continuationMarker = continuationMarker;
  }

  public ListOfPreSharedKeysWithoutSecret data(List<PreSharedKeyWithoutSecret> data) {
    this.data = data;
    return this;
  }

  public ListOfPreSharedKeysWithoutSecret addDataItem(PreSharedKeyWithoutSecret dataItem) {
    this.data.add(dataItem);
    return this;
  }

   /**
   * Array of the pre-shared key entries. The array is empty if there are no pre-shared keys.
   * @return data
  **/
  @ApiModelProperty(required = true, value = "Array of the pre-shared key entries. The array is empty if there are no pre-shared keys.")
  public List<PreSharedKeyWithoutSecret> getData() {
    return data;
  }

  public void setData(List<PreSharedKeyWithoutSecret> data) {
    this.data = data;
  }

  public ListOfPreSharedKeysWithoutSecret hasMore(Boolean hasMore) {
    this.hasMore = hasMore;
    return this;
  }

   /**
   * Are there more results available.
   * @return hasMore
  **/
  @ApiModelProperty(example = "true", required = true, value = "Are there more results available.")
  public Boolean isHasMore() {
    return hasMore;
  }

  public void setHasMore(Boolean hasMore) {
    this.hasMore = hasMore;
  }

  public ListOfPreSharedKeysWithoutSecret limit(Integer limit) {
    this.limit = limit;
    return this;
  }

   /**
   * The value of limit query parameter from the request, or default if not specified.
   * @return limit
  **/
  @ApiModelProperty(example = "50", required = true, value = "The value of limit query parameter from the request, or default if not specified.")
  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public ListOfPreSharedKeysWithoutSecret object(String object) {
    this.object = object;
    return this;
  }

   /**
   * The type of this API object is a \&quot;list\&quot;.
   * @return object
  **/
  @ApiModelProperty(example = "list", required = true, value = "The type of this API object is a \"list\".")
  public String getObject() {
    return object;
  }

  public void setObject(String object) {
    this.object = object;
  }

  public ListOfPreSharedKeysWithoutSecret order(String order) {
    this.order = order;
    return this;
  }

   /**
   * The creation time based order of the entries.
   * @return order
  **/
  @ApiModelProperty(example = "DESC", required = true, value = "The creation time based order of the entries.")
  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListOfPreSharedKeysWithoutSecret listOfPreSharedKeysWithoutSecret = (ListOfPreSharedKeysWithoutSecret) o;
    return Objects.equals(this.after, listOfPreSharedKeysWithoutSecret.after) &&
        Objects.equals(this.continuationMarker, listOfPreSharedKeysWithoutSecret.continuationMarker) &&
        Objects.equals(this.data, listOfPreSharedKeysWithoutSecret.data) &&
        Objects.equals(this.hasMore, listOfPreSharedKeysWithoutSecret.hasMore) &&
        Objects.equals(this.limit, listOfPreSharedKeysWithoutSecret.limit) &&
        Objects.equals(this.object, listOfPreSharedKeysWithoutSecret.object) &&
        Objects.equals(this.order, listOfPreSharedKeysWithoutSecret.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(after, continuationMarker, data, hasMore, limit, object, order);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListOfPreSharedKeysWithoutSecret {\n");
    
    sb.append("    after: ").append(toIndentedString(after)).append("\n");
    sb.append("    continuationMarker: ").append(toIndentedString(continuationMarker)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    hasMore: ").append(toIndentedString(hasMore)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    object: ").append(toIndentedString(object)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
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

