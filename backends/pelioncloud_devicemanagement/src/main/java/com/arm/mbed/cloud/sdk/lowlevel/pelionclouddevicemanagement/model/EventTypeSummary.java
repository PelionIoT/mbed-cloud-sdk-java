/*
 * Pelion Device Management API
 * Pelion Device Management API build from the publicly defined API definitions.
 *
 * OpenAPI spec version: 3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.joda.time.DateTime;
import java.io.Serializable;

/**
 * EventTypeSummary
 */

public class EventTypeSummary implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("campaign_id")
    private String campaignId = null;

    @SerializedName("count")
    private Integer count = null;

    @SerializedName("created_at")
    private DateTime createdAt = null;

    /**
     * ID of the event type description.
     */
    @JsonAdapter(IdEnum.Adapter.class)
    public enum IdEnum {
        FAIL("fail"),

        SUCCESS("success"),

        INFO("info"),

        SKIPPED("skipped");

        private String value;

        IdEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static IdEnum fromValue(String text) {
            for (IdEnum b : IdEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<IdEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final IdEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public IdEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return IdEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("id")
    private IdEnum id = null;

    @SerializedName("object")
    private String object = null;

    /**
     * The event type description.
     */
    @JsonAdapter(SummaryStatusEnum.Adapter.class)
    public enum SummaryStatusEnum {
        FAIL("FAIL"),

        SUCCESS("SUCCESS"),

        INFO("INFO"),

        SKIPPED("SKIPPED");

        private String value;

        SummaryStatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static SummaryStatusEnum fromValue(String text) {
            for (SummaryStatusEnum b : SummaryStatusEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<SummaryStatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final SummaryStatusEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public SummaryStatusEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return SummaryStatusEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("summary_status")
    private SummaryStatusEnum summaryStatus = null;

    public EventTypeSummary campaignId(String campaignId) {
        this.campaignId = campaignId;
        return this;
    }

    /**
     * ID of the associated campaign.
     * 
     * @return campaignId
     **/
    @ApiModelProperty(example = "016e652be6710000000000010010013d", value = "ID of the associated campaign.")
    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public EventTypeSummary count(Integer count) {
        this.count = count;
        return this;
    }

    /**
     * Get count
     * 
     * @return count
     **/
    @ApiModelProperty(example = "10", value = "")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public EventTypeSummary createdAt(DateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     * 
     * @return createdAt
     **/
    @ApiModelProperty(example = "2017-05-22T12:37:55.576563Z", value = "")
    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public EventTypeSummary id(IdEnum id) {
        this.id = id;
        return this;
    }

    /**
     * ID of the event type description.
     * 
     * @return id
     **/
    @ApiModelProperty(example = "fail", value = "ID of the event type description.")
    public IdEnum getId() {
        return id;
    }

    public void setId(IdEnum id) {
        this.id = id;
    }

    public EventTypeSummary object(String object) {
        this.object = object;
        return this;
    }

    /**
     * Entity name: always &#39;summary_status&#39;.
     * 
     * @return object
     **/
    @ApiModelProperty(example = "summary_status", value = "Entity name: always 'summary_status'.")
    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public EventTypeSummary summaryStatus(SummaryStatusEnum summaryStatus) {
        this.summaryStatus = summaryStatus;
        return this;
    }

    /**
     * The event type description.
     * 
     * @return summaryStatus
     **/
    @ApiModelProperty(example = "FAIL", value = "The event type description.")
    public SummaryStatusEnum getSummaryStatus() {
        return summaryStatus;
    }

    public void setSummaryStatus(SummaryStatusEnum summaryStatus) {
        this.summaryStatus = summaryStatus;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EventTypeSummary eventTypeSummary = (EventTypeSummary) o;
        return Objects.equals(this.campaignId, eventTypeSummary.campaignId)
               && Objects.equals(this.count, eventTypeSummary.count)
               && Objects.equals(this.createdAt, eventTypeSummary.createdAt)
               && Objects.equals(this.id, eventTypeSummary.id) && Objects.equals(this.object, eventTypeSummary.object)
               && Objects.equals(this.summaryStatus, eventTypeSummary.summaryStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(campaignId, count, createdAt, id, object, summaryStatus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EventTypeSummary {\n");

        sb.append("    campaignId: ").append(toIndentedString(campaignId)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    object: ").append(toIndentedString(object)).append("\n");
        sb.append("    summaryStatus: ").append(toIndentedString(summaryStatus)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
