/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class CustomAudience extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("approximate_count")
  private Long mApproximateCount = null;
  @SerializedName("data_source")
  private CustomAudienceDataSource mDataSource = null;
  @SerializedName("delivery_status")
  private CustomAudienceStatus mDeliveryStatus = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("excluded_custom_audiences")
  private List<CustomAudience> mExcludedCustomAudiences = null;
  @SerializedName("included_custom_audiences")
  private List<CustomAudience> mIncludedCustomAudiences = null;
  @SerializedName("external_event_source")
  private AdsPixel mExternalEventSource = null;
  @SerializedName("lookalike_audience_ids")
  private List<String> mLookalikeAudienceIds = null;
  @SerializedName("lookalike_spec")
  private LookalikeSpec mLookalikeSpec = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("operation_status")
  private CustomAudienceStatus mOperationStatus = null;
  @SerializedName("opt_out_link")
  private String mOptOutLink = null;
  @SerializedName("permission_for_actions")
  private CustomAudiencePermission mPermissionForActions = null;
  @SerializedName("pixel_id")
  private String mPixelId = null;
  @SerializedName("rule")
  private String mRule = null;
  @SerializedName("retention_days")
  private Long mRetentionDays = null;
  @SerializedName("subtype")
  private String mSubtype = null;
  @SerializedName("time_created")
  private Long mTimeCreated = null;
  @SerializedName("time_updated")
  private Long mTimeUpdated = null;
  @SerializedName("time_content_updated")
  private Long mTimeContentUpdated = null;
  protected static Gson gson = null;

  CustomAudience() {
  }

  public CustomAudience(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CustomAudience(String id, APIContext context) {
    this.mId = id;
    this.mContext = context;
  }

  public CustomAudience fetch() throws APIException{
    CustomAudience newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
    this.copyFrom(newInstance);
    return this;
  }

  public static CustomAudience fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static CustomAudience fetchById(String id, APIContext context) throws APIException {
    CustomAudience customAudience =
      new APIRequestGet(id, context)
      .requestAllFields()
      .call();
    return customAudience;
  }

  private String getPrefixedId() {
    return mId.toString();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static CustomAudience loadJSON(String json, APIContext context) {
    CustomAudience customAudience = getGson().fromJson(json, CustomAudience.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(customAudience.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    customAudience.mContext = context;
    customAudience.rawValue = json;
    return customAudience;
  }

  public static APINodeList<CustomAudience> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<CustomAudience> customAudiences = new APINodeList<CustomAudience>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          customAudiences.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return customAudiences;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            customAudiences.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              customAudiences.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            customAudiences.add(loadJSON(obj.toString(), context));
          }
          return customAudiences;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              customAudiences.add(loadJSON(entry.getValue().toString(), context));
          }
          return customAudiences;
        } else {
          // Fifth, check if it's pure JsonObject
          customAudiences.add(loadJSON(json, context));
          return customAudiences;
        }
      }
    } catch (Exception e) {
    }
    return null;
  }

  @Override
  public APIContext getContext() {
    return mContext;
  }

  @Override
  public void setContext(APIContext context) {
    mContext = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetCapabilities getCapabilities() {
    return new APIRequestGetCapabilities(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetPrefills getPrefills() {
    return new APIRequestGetPrefills(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAds getAds() {
    return new APIRequestGetAds(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetAdAccounts getAdAccounts() {
    return new APIRequestGetAdAccounts(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetSessions getSessions() {
    return new APIRequestGetSessions(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateCapabilitie createCapabilitie() {
    return new APIRequestCreateCapabilitie(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateAdAccount createAdAccount() {
    return new APIRequestCreateAdAccount(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestDeleteCapabilities deleteCapabilities() {
    return new APIRequestDeleteCapabilities(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestDeleteAdAccounts deleteAdAccounts() {
    return new APIRequestDeleteAdAccounts(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateUser createUser() {
    return new APIRequestCreateUser(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestDeleteUsers deleteUsers() {
    return new APIRequestDeleteUsers(this.getPrefixedId().toString(), mContext);
  }


  public String getFieldId() {
    return mId;
  }

  public String getFieldAccountId() {
    return mAccountId;
  }

  public Long getFieldApproximateCount() {
    return mApproximateCount;
  }

  public CustomAudienceDataSource getFieldDataSource() {
    return mDataSource;
  }

  public CustomAudienceStatus getFieldDeliveryStatus() {
    return mDeliveryStatus;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public List<CustomAudience> getFieldExcludedCustomAudiences() {
    return mExcludedCustomAudiences;
  }

  public List<CustomAudience> getFieldIncludedCustomAudiences() {
    return mIncludedCustomAudiences;
  }

  public AdsPixel getFieldExternalEventSource() {
    if (mExternalEventSource != null) {
      mExternalEventSource.mContext = getContext();
    }
    return mExternalEventSource;
  }

  public List<String> getFieldLookalikeAudienceIds() {
    return mLookalikeAudienceIds;
  }

  public LookalikeSpec getFieldLookalikeSpec() {
    return mLookalikeSpec;
  }

  public String getFieldName() {
    return mName;
  }

  public CustomAudienceStatus getFieldOperationStatus() {
    return mOperationStatus;
  }

  public String getFieldOptOutLink() {
    return mOptOutLink;
  }

  public CustomAudiencePermission getFieldPermissionForActions() {
    return mPermissionForActions;
  }

  public String getFieldPixelId() {
    return mPixelId;
  }

  public String getFieldRule() {
    return mRule;
  }

  public Long getFieldRetentionDays() {
    return mRetentionDays;
  }

  public String getFieldSubtype() {
    return mSubtype;
  }

  public Long getFieldTimeCreated() {
    return mTimeCreated;
  }

  public Long getFieldTimeUpdated() {
    return mTimeUpdated;
  }

  public Long getFieldTimeContentUpdated() {
    return mTimeContentUpdated;
  }



  public static class APIRequestGet extends APIRequest<CustomAudience> {

    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "account_id",
      "approximate_count",
      "data_source",
      "delivery_status",
      "description",
      "excluded_custom_audiences",
      "included_custom_audiences",
      "external_event_source",
      "lookalike_audience_ids",
      "lookalike_spec",
      "name",
      "operation_status",
      "opt_out_link",
      "permission_for_actions",
      "pixel_id",
      "rule",
      "retention_days",
      "subtype",
      "time_created",
      "time_updated",
      "time_content_updated",
    };

    @Override
    public CustomAudience call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public CustomAudience call(Map<String, Object> extraParams) throws APIException {
      return CustomAudience.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestApproximateCountField () {
      return this.requestApproximateCountField(true);
    }
    public APIRequestGet requestApproximateCountField (boolean value) {
      this.requestField("approximate_count", value);
      return this;
    }
    public APIRequestGet requestDataSourceField () {
      return this.requestDataSourceField(true);
    }
    public APIRequestGet requestDataSourceField (boolean value) {
      this.requestField("data_source", value);
      return this;
    }
    public APIRequestGet requestDeliveryStatusField () {
      return this.requestDeliveryStatusField(true);
    }
    public APIRequestGet requestDeliveryStatusField (boolean value) {
      this.requestField("delivery_status", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestExcludedCustomAudiencesField () {
      return this.requestExcludedCustomAudiencesField(true);
    }
    public APIRequestGet requestExcludedCustomAudiencesField (boolean value) {
      this.requestField("excluded_custom_audiences", value);
      return this;
    }
    public APIRequestGet requestIncludedCustomAudiencesField () {
      return this.requestIncludedCustomAudiencesField(true);
    }
    public APIRequestGet requestIncludedCustomAudiencesField (boolean value) {
      this.requestField("included_custom_audiences", value);
      return this;
    }
    public APIRequestGet requestExternalEventSourceField () {
      return this.requestExternalEventSourceField(true);
    }
    public APIRequestGet requestExternalEventSourceField (boolean value) {
      this.requestField("external_event_source", value);
      return this;
    }
    public APIRequestGet requestLookalikeAudienceIdsField () {
      return this.requestLookalikeAudienceIdsField(true);
    }
    public APIRequestGet requestLookalikeAudienceIdsField (boolean value) {
      this.requestField("lookalike_audience_ids", value);
      return this;
    }
    public APIRequestGet requestLookalikeSpecField () {
      return this.requestLookalikeSpecField(true);
    }
    public APIRequestGet requestLookalikeSpecField (boolean value) {
      this.requestField("lookalike_spec", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOperationStatusField () {
      return this.requestOperationStatusField(true);
    }
    public APIRequestGet requestOperationStatusField (boolean value) {
      this.requestField("operation_status", value);
      return this;
    }
    public APIRequestGet requestOptOutLinkField () {
      return this.requestOptOutLinkField(true);
    }
    public APIRequestGet requestOptOutLinkField (boolean value) {
      this.requestField("opt_out_link", value);
      return this;
    }
    public APIRequestGet requestPermissionForActionsField () {
      return this.requestPermissionForActionsField(true);
    }
    public APIRequestGet requestPermissionForActionsField (boolean value) {
      this.requestField("permission_for_actions", value);
      return this;
    }
    public APIRequestGet requestPixelIdField () {
      return this.requestPixelIdField(true);
    }
    public APIRequestGet requestPixelIdField (boolean value) {
      this.requestField("pixel_id", value);
      return this;
    }
    public APIRequestGet requestRuleField () {
      return this.requestRuleField(true);
    }
    public APIRequestGet requestRuleField (boolean value) {
      this.requestField("rule", value);
      return this;
    }
    public APIRequestGet requestRetentionDaysField () {
      return this.requestRetentionDaysField(true);
    }
    public APIRequestGet requestRetentionDaysField (boolean value) {
      this.requestField("retention_days", value);
      return this;
    }
    public APIRequestGet requestSubtypeField () {
      return this.requestSubtypeField(true);
    }
    public APIRequestGet requestSubtypeField (boolean value) {
      this.requestField("subtype", value);
      return this;
    }
    public APIRequestGet requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGet requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGet requestTimeUpdatedField () {
      return this.requestTimeUpdatedField(true);
    }
    public APIRequestGet requestTimeUpdatedField (boolean value) {
      this.requestField("time_updated", value);
      return this;
    }
    public APIRequestGet requestTimeContentUpdatedField () {
      return this.requestTimeContentUpdatedField(true);
    }
    public APIRequestGet requestTimeContentUpdatedField (boolean value) {
      this.requestField("time_content_updated", value);
      return this;
    }

  }

  public static class APIRequestUpdate extends APIRequest<APINode> {

    public static final String[] PARAMS = {
      "description",
      "name",
      "opt_out_link",
      "parent_audience_id",
      "lookalike_spec",
      "retention_days",
      "rule",
      "inclusions",
      "exclusions",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINode call(Map<String, Object> extraParams) throws APIException {
      return APINode.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }


    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }


    public APIRequestUpdate setOptOutLink (String optOutLink) {
      this.setParam("opt_out_link", optOutLink);
      return this;
    }


    public APIRequestUpdate setParentAudienceId (Long parentAudienceId) {
      this.setParam("parent_audience_id", parentAudienceId);
      return this;
    }

    public APIRequestUpdate setParentAudienceId (String parentAudienceId) {
      this.setParam("parent_audience_id", parentAudienceId);
      return this;
    }

    public APIRequestUpdate setLookalikeSpec (String lookalikeSpec) {
      this.setParam("lookalike_spec", lookalikeSpec);
      return this;
    }


    public APIRequestUpdate setRetentionDays (Long retentionDays) {
      this.setParam("retention_days", retentionDays);
      return this;
    }

    public APIRequestUpdate setRetentionDays (String retentionDays) {
      this.setParam("retention_days", retentionDays);
      return this;
    }

    public APIRequestUpdate setRule (String rule) {
      this.setParam("rule", rule);
      return this;
    }


    public APIRequestUpdate setInclusions (List<Object> inclusions) {
      this.setParam("inclusions", inclusions);
      return this;
    }

    public APIRequestUpdate setInclusions (String inclusions) {
      this.setParam("inclusions", inclusions);
      return this;
    }

    public APIRequestUpdate setExclusions (List<Object> exclusions) {
      this.setParam("exclusions", exclusions);
      return this;
    }

    public APIRequestUpdate setExclusions (String exclusions) {
      this.setParam("exclusions", exclusions);
      return this;
    }

    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestDelete extends APIRequest<APINode> {

    public static final String[] PARAMS = {
      "id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINode call(Map<String, Object> extraParams) throws APIException {
      return APINode.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete setId (Long id) {
      this.setParam("id", id);
      return this;
    }

    public APIRequestDelete setId (String id) {
      this.setParam("id", id);
      return this;
    }

    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestGetCapabilities extends APIRequest<CustomAudienceCapabilities> {

    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "capabilities",
    };

    @Override
    public APINodeList<CustomAudienceCapabilities> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomAudienceCapabilities> call(Map<String, Object> extraParams) throws APIException {
      return CustomAudienceCapabilities.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetCapabilities(String nodeId, APIContext context) {
      super(context, nodeId, "/capabilities", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetCapabilities setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetCapabilities setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCapabilities requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCapabilities requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetCapabilities requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetCapabilities requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetCapabilities requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCapabilities requestCapabilitiesField () {
      return this.requestCapabilitiesField(true);
    }
    public APIRequestGetCapabilities requestCapabilitiesField (boolean value) {
      this.requestField("capabilities", value);
      return this;
    }

  }

  public static class APIRequestGetPrefills extends APIRequest<CustomAudiencePrefillState> {

    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "status",
      "description",
      "num_added",
    };

    @Override
    public APINodeList<CustomAudiencePrefillState> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomAudiencePrefillState> call(Map<String, Object> extraParams) throws APIException {
      return CustomAudiencePrefillState.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetPrefills(String nodeId, APIContext context) {
      super(context, nodeId, "/prefills", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetPrefills setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetPrefills setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPrefills requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPrefills requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetPrefills requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetPrefills requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetPrefills requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPrefills requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetPrefills requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetPrefills requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetPrefills requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetPrefills requestNumAddedField () {
      return this.requestNumAddedField(true);
    }
    public APIRequestGetPrefills requestNumAddedField (boolean value) {
      this.requestField("num_added", value);
      return this;
    }

  }

  public static class APIRequestGetAds extends APIRequest<Ad> {

    public static final String[] PARAMS = {
      "effective_status",
    };

    public static final String[] FIELDS = {
      "id",
      "account_id",
      "adset",
      "campaign",
      "adlabels",
      "adset_id",
      "bid_amount",
      "bid_info",
      "bid_type",
      "configured_status",
      "conversion_specs",
      "created_time",
      "creative",
      "effective_status",
      "last_updated_by_app_id",
      "name",
      "tracking_specs",
      "updated_time",
      "campaign_id",
      "ad_review_feedback",
    };

    @Override
    public APINodeList<Ad> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Ad> call(Map<String, Object> extraParams) throws APIException {
      return Ad.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetAds(String nodeId, APIContext context) {
      super(context, nodeId, "/ads", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAds setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetAds setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAds setEffectiveStatus (List<String> effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetAds setEffectiveStatus (String effectiveStatus) {
      this.setParam("effective_status", effectiveStatus);
      return this;
    }

    public APIRequestGetAds requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAds requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAds requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAds requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAds requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAds requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAds requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAds requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAds requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAds requestAdsetField () {
      return this.requestAdsetField(true);
    }
    public APIRequestGetAds requestAdsetField (boolean value) {
      this.requestField("adset", value);
      return this;
    }
    public APIRequestGetAds requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGetAds requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGetAds requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAds requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAds requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGetAds requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGetAds requestBidAmountField () {
      return this.requestBidAmountField(true);
    }
    public APIRequestGetAds requestBidAmountField (boolean value) {
      this.requestField("bid_amount", value);
      return this;
    }
    public APIRequestGetAds requestBidInfoField () {
      return this.requestBidInfoField(true);
    }
    public APIRequestGetAds requestBidInfoField (boolean value) {
      this.requestField("bid_info", value);
      return this;
    }
    public APIRequestGetAds requestBidTypeField () {
      return this.requestBidTypeField(true);
    }
    public APIRequestGetAds requestBidTypeField (boolean value) {
      this.requestField("bid_type", value);
      return this;
    }
    public APIRequestGetAds requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGetAds requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGetAds requestConversionSpecsField () {
      return this.requestConversionSpecsField(true);
    }
    public APIRequestGetAds requestConversionSpecsField (boolean value) {
      this.requestField("conversion_specs", value);
      return this;
    }
    public APIRequestGetAds requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAds requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAds requestCreativeField () {
      return this.requestCreativeField(true);
    }
    public APIRequestGetAds requestCreativeField (boolean value) {
      this.requestField("creative", value);
      return this;
    }
    public APIRequestGetAds requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetAds requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetAds requestLastUpdatedByAppIdField () {
      return this.requestLastUpdatedByAppIdField(true);
    }
    public APIRequestGetAds requestLastUpdatedByAppIdField (boolean value) {
      this.requestField("last_updated_by_app_id", value);
      return this;
    }
    public APIRequestGetAds requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAds requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAds requestTrackingSpecsField () {
      return this.requestTrackingSpecsField(true);
    }
    public APIRequestGetAds requestTrackingSpecsField (boolean value) {
      this.requestField("tracking_specs", value);
      return this;
    }
    public APIRequestGetAds requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAds requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetAds requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetAds requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetAds requestAdReviewFeedbackField () {
      return this.requestAdReviewFeedbackField(true);
    }
    public APIRequestGetAds requestAdReviewFeedbackField (boolean value) {
      this.requestField("ad_review_feedback", value);
      return this;
    }

  }

  public static class APIRequestGetAdAccounts extends APIRequest<CustomAudienceAdAccount> {

    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
    };

    @Override
    public APINodeList<CustomAudienceAdAccount> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomAudienceAdAccount> call(Map<String, Object> extraParams) throws APIException {
      return CustomAudienceAdAccount.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccounts", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }

  }

  public static class APIRequestGetSessions extends APIRequest<CustomAudienceSession> {

    public static final String[] PARAMS = {
      "session_id",
    };

    public static final String[] FIELDS = {
      "session_id",
      "start_time",
      "end_time",
      "num_received",
      "num_matched",
      "num_invalid_entries",
      "progress",
      "stage",
    };

    @Override
    public APINodeList<CustomAudienceSession> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomAudienceSession> call(Map<String, Object> extraParams) throws APIException {
      return CustomAudienceSession.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetSessions(String nodeId, APIContext context) {
      super(context, nodeId, "/sessions", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetSessions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetSessions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSessions setSessionId (Long sessionId) {
      this.setParam("session_id", sessionId);
      return this;
    }

    public APIRequestGetSessions setSessionId (String sessionId) {
      this.setParam("session_id", sessionId);
      return this;
    }

    public APIRequestGetSessions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSessions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetSessions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetSessions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetSessions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSessions requestSessionIdField () {
      return this.requestSessionIdField(true);
    }
    public APIRequestGetSessions requestSessionIdField (boolean value) {
      this.requestField("session_id", value);
      return this;
    }
    public APIRequestGetSessions requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetSessions requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetSessions requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetSessions requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetSessions requestNumReceivedField () {
      return this.requestNumReceivedField(true);
    }
    public APIRequestGetSessions requestNumReceivedField (boolean value) {
      this.requestField("num_received", value);
      return this;
    }
    public APIRequestGetSessions requestNumMatchedField () {
      return this.requestNumMatchedField(true);
    }
    public APIRequestGetSessions requestNumMatchedField (boolean value) {
      this.requestField("num_matched", value);
      return this;
    }
    public APIRequestGetSessions requestNumInvalidEntriesField () {
      return this.requestNumInvalidEntriesField(true);
    }
    public APIRequestGetSessions requestNumInvalidEntriesField (boolean value) {
      this.requestField("num_invalid_entries", value);
      return this;
    }
    public APIRequestGetSessions requestProgressField () {
      return this.requestProgressField(true);
    }
    public APIRequestGetSessions requestProgressField (boolean value) {
      this.requestField("progress", value);
      return this;
    }
    public APIRequestGetSessions requestStageField () {
      return this.requestStageField(true);
    }
    public APIRequestGetSessions requestStageField (boolean value) {
      this.requestField("stage", value);
      return this;
    }

  }

  public static class APIRequestCreateCapabilitie extends APIRequest<CustomAudienceCapabilities> {

    public static final String[] PARAMS = {
      "id",
      "accounts_capabilities",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CustomAudienceCapabilities call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public CustomAudienceCapabilities call(Map<String, Object> extraParams) throws APIException {
      return CustomAudienceCapabilities.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestCreateCapabilitie(String nodeId, APIContext context) {
      super(context, nodeId, "/capabilities", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateCapabilitie setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateCapabilitie setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCapabilitie setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestCreateCapabilitie setAccountsCapabilities (String accountsCapabilities) {
      this.setParam("accounts_capabilities", accountsCapabilities);
      return this;
    }


    public APIRequestCreateCapabilitie requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCapabilitie requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateCapabilitie requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateCapabilitie requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateCapabilitie requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestCreateAdAccount extends APIRequest<CustomAudienceAdAccount> {

    public static final String[] PARAMS = {
      "id",
      "adaccounts",
      "replace",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CustomAudienceAdAccount call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public CustomAudienceAdAccount call(Map<String, Object> extraParams) throws APIException {
      return CustomAudienceAdAccount.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestCreateAdAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccounts", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateAdAccount setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateAdAccount setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdAccount setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestCreateAdAccount setAdaccounts (List<String> adaccounts) {
      this.setParam("adaccounts", adaccounts);
      return this;
    }

    public APIRequestCreateAdAccount setAdaccounts (String adaccounts) {
      this.setParam("adaccounts", adaccounts);
      return this;
    }

    public APIRequestCreateAdAccount setReplace (Boolean replace) {
      this.setParam("replace", replace);
      return this;
    }

    public APIRequestCreateAdAccount setReplace (String replace) {
      this.setParam("replace", replace);
      return this;
    }

    public APIRequestCreateAdAccount requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdAccount requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateAdAccount requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateAdAccount requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateAdAccount requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestDeleteCapabilities extends APIRequest<CustomAudienceCapabilities> {

    public static final String[] PARAMS = {
      "id",
      "adaccounts",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<CustomAudienceCapabilities> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomAudienceCapabilities> call(Map<String, Object> extraParams) throws APIException {
      return CustomAudienceCapabilities.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestDeleteCapabilities(String nodeId, APIContext context) {
      super(context, nodeId, "/capabilities", "DELETE", Arrays.asList(PARAMS));
    }

    public APIRequestDeleteCapabilities setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestDeleteCapabilities setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteCapabilities setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestDeleteCapabilities setAdaccounts (List<String> adaccounts) {
      this.setParam("adaccounts", adaccounts);
      return this;
    }

    public APIRequestDeleteCapabilities setAdaccounts (String adaccounts) {
      this.setParam("adaccounts", adaccounts);
      return this;
    }

    public APIRequestDeleteCapabilities requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteCapabilities requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDeleteCapabilities requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestDeleteCapabilities requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDeleteCapabilities requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestDeleteAdAccounts extends APIRequest<CustomAudienceAdAccount> {

    public static final String[] PARAMS = {
      "id",
      "adaccounts",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<CustomAudienceAdAccount> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomAudienceAdAccount> call(Map<String, Object> extraParams) throws APIException {
      return CustomAudienceAdAccount.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestDeleteAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccounts", "DELETE", Arrays.asList(PARAMS));
    }

    public APIRequestDeleteAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestDeleteAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteAdAccounts setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestDeleteAdAccounts setAdaccounts (List<String> adaccounts) {
      this.setParam("adaccounts", adaccounts);
      return this;
    }

    public APIRequestDeleteAdAccounts setAdaccounts (String adaccounts) {
      this.setParam("adaccounts", adaccounts);
      return this;
    }

    public APIRequestDeleteAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDeleteAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestDeleteAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDeleteAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestCreateUser extends APIRequest<APINode> {

    public static final String[] PARAMS = {
      "id",
      "session",
      "payload",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINode call(Map<String, Object> extraParams) throws APIException {
      return APINode.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestCreateUser(String nodeId, APIContext context) {
      super(context, nodeId, "/users", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateUser setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateUser setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateUser setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestCreateUser setSession (Object session) {
      this.setParam("session", session);
      return this;
    }

    public APIRequestCreateUser setSession (String session) {
      this.setParam("session", session);
      return this;
    }

    public APIRequestCreateUser setPayload (Object payload) {
      this.setParam("payload", payload);
      return this;
    }

    public APIRequestCreateUser setPayload (String payload) {
      this.setParam("payload", payload);
      return this;
    }

    public APIRequestCreateUser requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateUser requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateUser requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateUser requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateUser requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestDeleteUsers extends APIRequest<APINode> {

    public static final String[] PARAMS = {
      "id",
      "session",
      "payload",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> call(Map<String, Object> extraParams) throws APIException {
      return APINode.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestDeleteUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/users", "DELETE", Arrays.asList(PARAMS));
    }

    public APIRequestDeleteUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestDeleteUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteUsers setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestDeleteUsers setSession (Object session) {
      this.setParam("session", session);
      return this;
    }

    public APIRequestDeleteUsers setSession (String session) {
      this.setParam("session", session);
      return this;
    }

    public APIRequestDeleteUsers setPayload (Object payload) {
      this.setParam("payload", payload);
      return this;
    }

    public APIRequestDeleteUsers setPayload (String payload) {
      this.setParam("payload", payload);
      return this;
    }

    public APIRequestDeleteUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDeleteUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestDeleteUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDeleteUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }


  synchronized /*package*/ static Gson getGson() {
    if (gson != null) {
      return gson;
    } else {
      gson = new GsonBuilder()
        .excludeFieldsWithModifiers(Modifier.STATIC)
        .excludeFieldsWithModifiers(Modifier.PROTECTED)
        .disableHtmlEscaping()
        .create();
    }
    return gson;
  }

  public CustomAudience copyFrom(CustomAudience instance) {
    this.mId = instance.mId;
    this.mAccountId = instance.mAccountId;
    this.mApproximateCount = instance.mApproximateCount;
    this.mDataSource = instance.mDataSource;
    this.mDeliveryStatus = instance.mDeliveryStatus;
    this.mDescription = instance.mDescription;
    this.mExcludedCustomAudiences = instance.mExcludedCustomAudiences;
    this.mIncludedCustomAudiences = instance.mIncludedCustomAudiences;
    this.mExternalEventSource = instance.mExternalEventSource;
    this.mLookalikeAudienceIds = instance.mLookalikeAudienceIds;
    this.mLookalikeSpec = instance.mLookalikeSpec;
    this.mName = instance.mName;
    this.mOperationStatus = instance.mOperationStatus;
    this.mOptOutLink = instance.mOptOutLink;
    this.mPermissionForActions = instance.mPermissionForActions;
    this.mPixelId = instance.mPixelId;
    this.mRule = instance.mRule;
    this.mRetentionDays = instance.mRetentionDays;
    this.mSubtype = instance.mSubtype;
    this.mTimeCreated = instance.mTimeCreated;
    this.mTimeUpdated = instance.mTimeUpdated;
    this.mTimeContentUpdated = instance.mTimeContentUpdated;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}