/*
 * Account Management API
 * API for managing accounts, users, creating API keys, uploading trusted certificates
 *
 * OpenAPI spec version: v3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.arm.mbed.cloud.sdk.internal.iam.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;
import java.io.Serializable;

/**
 * This object represents a policy in responses.
 */
@ApiModel(description = "This object represents a policy in responses.")

public class PolicyInfo implements Serializable {
  private static final long serialVersionUID = 1L;

  @SerializedName("account_id")
  private String accountId = null;

  @SerializedName("actions")
  private Map<String, Boolean> actions = new HashMap<String, Boolean>();

  @SerializedName("apikeys")
  private List<String> apikeys = null;

  @SerializedName("conditions")
  private List<String> conditions = new ArrayList<String>();

  @SerializedName("created_at")
  private DateTime createdAt = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("error_message")
  private String errorMessage = null;

  @SerializedName("etag")
  private String etag = null;

  @SerializedName("grant_expires_in")
  private Integer grantExpiresIn = null;

  @SerializedName("groups")
  private List<String> groups = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("notActions")
  private List<String> notActions = new ArrayList<String>();

  @SerializedName("notConditions")
  private List<String> notConditions = new ArrayList<String>();

  @SerializedName("notResources")
  private List<String> notResources = new ArrayList<String>();

  /**
   * Entity name: always &#39;policy&#39;
   */
  @JsonAdapter(ObjectEnum.Adapter.class)
  public enum ObjectEnum {
    POLICY("policy");

    private String value;

    ObjectEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ObjectEnum fromValue(String text) {
      for (ObjectEnum b : ObjectEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ObjectEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ObjectEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ObjectEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ObjectEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("object")
  private ObjectEnum object = null;

  @SerializedName("resources")
  private List<String> resources = new ArrayList<String>();

  /**
   * The status of this policy.
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    ACTIVE("ACTIVE"),
    
    INACTIVE("INACTIVE");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("status")
  private StatusEnum status = null;

  @SerializedName("tag")
  private String tag = null;

  @SerializedName("updated_at")
  private DateTime updatedAt = null;

  @SerializedName("users")
  private List<String> users = null;

  @SerializedName("valid_from")
  private DateTime validFrom = null;

  @SerializedName("valid_until")
  private DateTime validUntil = null;

  public PolicyInfo accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * The UUID of the account.
   * @return accountId
  **/
  @ApiModelProperty(example = "01619571e2e90242ac12000600000000", required = true, value = "The UUID of the account.")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public PolicyInfo actions(Map<String, Boolean> actions) {
    this.actions = actions;
    return this;
  }

  public PolicyInfo putActionsItem(String key, Boolean actionsItem) {
    this.actions.put(key, actionsItem);
    return this;
  }

   /**
   * List of actions.
   * @return actions
  **/
  @ApiModelProperty(required = true, value = "List of actions.")
  public Map<String, Boolean> getActions() {
    return actions;
  }

  public void setActions(Map<String, Boolean> actions) {
    this.actions = actions;
  }

  public PolicyInfo apikeys(List<String> apikeys) {
    this.apikeys = apikeys;
    return this;
  }

  public PolicyInfo addApikeysItem(String apikeysItem) {
    if (this.apikeys == null) {
      this.apikeys = new ArrayList<String>();
    }
    this.apikeys.add(apikeysItem);
    return this;
  }

   /**
   * List of API key IDs this policy is attached to.
   * @return apikeys
  **/
  @ApiModelProperty(value = "List of API key IDs this policy is attached to.")
  public List<String> getApikeys() {
    return apikeys;
  }

  public void setApikeys(List<String> apikeys) {
    this.apikeys = apikeys;
  }

  public PolicyInfo conditions(List<String> conditions) {
    this.conditions = conditions;
    return this;
  }

  public PolicyInfo addConditionsItem(String conditionsItem) {
    this.conditions.add(conditionsItem);
    return this;
  }

   /**
   * List of conditions.
   * @return conditions
  **/
  @ApiModelProperty(required = true, value = "List of conditions.")
  public List<String> getConditions() {
    return conditions;
  }

  public void setConditions(List<String> conditions) {
    this.conditions = conditions;
  }

  public PolicyInfo createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Creation UTC time RFC3339.
   * @return createdAt
  **/
  @ApiModelProperty(example = "2018-02-13T09:35:20Z", value = "Creation UTC time RFC3339.")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    this.createdAt = createdAt;
  }

  public PolicyInfo description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of this policy.
   * @return description
  **/
  @ApiModelProperty(example = "Custom policy for the account", value = "The description of this policy.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PolicyInfo errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

   /**
   * Custom error message returned when this policy matches with not allowed result.
   * @return errorMessage
  **/
  @ApiModelProperty(example = "Accessing resource is forbidden.", value = "Custom error message returned when this policy matches with not allowed result.")
  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public PolicyInfo etag(String etag) {
    this.etag = etag;
    return this;
  }

   /**
   * API resource entity version.
   * @return etag
  **/
  @ApiModelProperty(example = "1", required = true, value = "API resource entity version.")
  public String getEtag() {
    return etag;
  }

  public void setEtag(String etag) {
    this.etag = etag;
  }

  public PolicyInfo grantExpiresIn(Integer grantExpiresIn) {
    this.grantExpiresIn = grantExpiresIn;
    return this;
  }

   /**
   * Specifies the value in seconds for how long an authorization result is valid.
   * @return grantExpiresIn
  **/
  @ApiModelProperty(example = "3600", value = "Specifies the value in seconds for how long an authorization result is valid.")
  public Integer getGrantExpiresIn() {
    return grantExpiresIn;
  }

  public void setGrantExpiresIn(Integer grantExpiresIn) {
    this.grantExpiresIn = grantExpiresIn;
  }

  public PolicyInfo groups(List<String> groups) {
    this.groups = groups;
    return this;
  }

  public PolicyInfo addGroupsItem(String groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<String>();
    }
    this.groups.add(groupsItem);
    return this;
  }

   /**
   * List of group IDs this policy is attached to.
   * @return groups
  **/
  @ApiModelProperty(value = "List of group IDs this policy is attached to.")
  public List<String> getGroups() {
    return groups;
  }

  public void setGroups(List<String> groups) {
    this.groups = groups;
  }

  public PolicyInfo id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Entity ID.
   * @return id
  **/
  @ApiModelProperty(example = "01619571d01d0242ac12000600000000", required = true, value = "Entity ID.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PolicyInfo name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of this policy.
   * @return name
  **/
  @ApiModelProperty(example = "Policy1", required = true, value = "The name of this policy.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PolicyInfo notActions(List<String> notActions) {
    this.notActions = notActions;
    return this;
  }

  public PolicyInfo addNotActionsItem(String notActionsItem) {
    this.notActions.add(notActionsItem);
    return this;
  }

   /**
   * List of not_actions.
   * @return notActions
  **/
  @ApiModelProperty(required = true, value = "List of not_actions.")
  public List<String> getNotActions() {
    return notActions;
  }

  public void setNotActions(List<String> notActions) {
    this.notActions = notActions;
  }

  public PolicyInfo notConditions(List<String> notConditions) {
    this.notConditions = notConditions;
    return this;
  }

  public PolicyInfo addNotConditionsItem(String notConditionsItem) {
    this.notConditions.add(notConditionsItem);
    return this;
  }

   /**
   * List of not_conditions.
   * @return notConditions
  **/
  @ApiModelProperty(required = true, value = "List of not_conditions.")
  public List<String> getNotConditions() {
    return notConditions;
  }

  public void setNotConditions(List<String> notConditions) {
    this.notConditions = notConditions;
  }

  public PolicyInfo notResources(List<String> notResources) {
    this.notResources = notResources;
    return this;
  }

  public PolicyInfo addNotResourcesItem(String notResourcesItem) {
    this.notResources.add(notResourcesItem);
    return this;
  }

   /**
   * List of not_resources.
   * @return notResources
  **/
  @ApiModelProperty(required = true, value = "List of not_resources.")
  public List<String> getNotResources() {
    return notResources;
  }

  public void setNotResources(List<String> notResources) {
    this.notResources = notResources;
  }

  public PolicyInfo object(ObjectEnum object) {
    this.object = object;
    return this;
  }

   /**
   * Entity name: always &#39;policy&#39;
   * @return object
  **/
  @ApiModelProperty(required = true, value = "Entity name: always 'policy'")
  public ObjectEnum getObject() {
    return object;
  }

  public void setObject(ObjectEnum object) {
    this.object = object;
  }

  public PolicyInfo resources(List<String> resources) {
    this.resources = resources;
    return this;
  }

  public PolicyInfo addResourcesItem(String resourcesItem) {
    this.resources.add(resourcesItem);
    return this;
  }

   /**
   * List of resources.
   * @return resources
  **/
  @ApiModelProperty(required = true, value = "List of resources.")
  public List<String> getResources() {
    return resources;
  }

  public void setResources(List<String> resources) {
    this.resources = resources;
  }

  public PolicyInfo status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * The status of this policy.
   * @return status
  **/
  @ApiModelProperty(example = "ACTIVE", required = true, value = "The status of this policy.")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public PolicyInfo tag(String tag) {
    this.tag = tag;
    return this;
  }

   /**
   * Policy tag that can be used for various purposes to be able to distinguish between policies.
   * @return tag
  **/
  @ApiModelProperty(example = "test", value = "Policy tag that can be used for various purposes to be able to distinguish between policies.")
  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public PolicyInfo updatedAt(DateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Last update UTC time RFC3339.
   * @return updatedAt
  **/
  @ApiModelProperty(example = "2018-02-15T15:24:14Z", required = true, value = "Last update UTC time RFC3339.")
  public DateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(DateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public PolicyInfo users(List<String> users) {
    this.users = users;
    return this;
  }

  public PolicyInfo addUsersItem(String usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<String>();
    }
    this.users.add(usersItem);
    return this;
  }

   /**
   * List of user IDs this policy is attached to.
   * @return users
  **/
  @ApiModelProperty(value = "List of user IDs this policy is attached to.")
  public List<String> getUsers() {
    return users;
  }

  public void setUsers(List<String> users) {
    this.users = users;
  }

  public PolicyInfo validFrom(DateTime validFrom) {
    this.validFrom = validFrom;
    return this;
  }

   /**
   * Specifies the date and time when the policy will become valid.
   * @return validFrom
  **/
  @ApiModelProperty(example = "2018-02-14T15:24:14Z", value = "Specifies the date and time when the policy will become valid.")
  public DateTime getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(DateTime validFrom) {
    this.validFrom = validFrom;
  }

  public PolicyInfo validUntil(DateTime validUntil) {
    this.validUntil = validUntil;
    return this;
  }

   /**
   * Specifies the date and time until the policy is valid.
   * @return validUntil
  **/
  @ApiModelProperty(example = "2025-02-14T15:24:14Z", value = "Specifies the date and time until the policy is valid.")
  public DateTime getValidUntil() {
    return validUntil;
  }

  public void setValidUntil(DateTime validUntil) {
    this.validUntil = validUntil;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyInfo policyInfo = (PolicyInfo) o;
    return Objects.equals(this.accountId, policyInfo.accountId) &&
        Objects.equals(this.actions, policyInfo.actions) &&
        Objects.equals(this.apikeys, policyInfo.apikeys) &&
        Objects.equals(this.conditions, policyInfo.conditions) &&
        Objects.equals(this.createdAt, policyInfo.createdAt) &&
        Objects.equals(this.description, policyInfo.description) &&
        Objects.equals(this.errorMessage, policyInfo.errorMessage) &&
        Objects.equals(this.etag, policyInfo.etag) &&
        Objects.equals(this.grantExpiresIn, policyInfo.grantExpiresIn) &&
        Objects.equals(this.groups, policyInfo.groups) &&
        Objects.equals(this.id, policyInfo.id) &&
        Objects.equals(this.name, policyInfo.name) &&
        Objects.equals(this.notActions, policyInfo.notActions) &&
        Objects.equals(this.notConditions, policyInfo.notConditions) &&
        Objects.equals(this.notResources, policyInfo.notResources) &&
        Objects.equals(this.object, policyInfo.object) &&
        Objects.equals(this.resources, policyInfo.resources) &&
        Objects.equals(this.status, policyInfo.status) &&
        Objects.equals(this.tag, policyInfo.tag) &&
        Objects.equals(this.updatedAt, policyInfo.updatedAt) &&
        Objects.equals(this.users, policyInfo.users) &&
        Objects.equals(this.validFrom, policyInfo.validFrom) &&
        Objects.equals(this.validUntil, policyInfo.validUntil);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, actions, apikeys, conditions, createdAt, description, errorMessage, etag, grantExpiresIn, groups, id, name, notActions, notConditions, notResources, object, resources, status, tag, updatedAt, users, validFrom, validUntil);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyInfo {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
    sb.append("    apikeys: ").append(toIndentedString(apikeys)).append("\n");
    sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
    sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
    sb.append("    grantExpiresIn: ").append(toIndentedString(grantExpiresIn)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    notActions: ").append(toIndentedString(notActions)).append("\n");
    sb.append("    notConditions: ").append(toIndentedString(notConditions)).append("\n");
    sb.append("    notResources: ").append(toIndentedString(notResources)).append("\n");
    sb.append("    object: ").append(toIndentedString(object)).append("\n");
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("    validFrom: ").append(toIndentedString(validFrom)).append("\n");
    sb.append("    validUntil: ").append(toIndentedString(validUntil)).append("\n");
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

