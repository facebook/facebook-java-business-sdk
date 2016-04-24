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
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.facebook.ads.sdk.APIException.MalformedResponseException;

/**
 * This class is auto-genereated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class CustomAudience extends APINode {
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
  @SerializedName("external_event_source")
  private AdsPixel mExternalEventSource = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("included_custom_audiences")
  private List<CustomAudience> mIncludedCustomAudiences = null;
  @SerializedName("last_used_time")
  private String mLastUsedTime = null;
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
  @SerializedName("owner_business")
  private Business mOwnerBusiness = null;
  @SerializedName("permission_for_actions")
  private CustomAudiencePermission mPermissionForActions = null;
  @SerializedName("pixel_id")
  private String mPixelId = null;
  @SerializedName("retention_days")
  private Long mRetentionDays = null;
  @SerializedName("rule")
  private String mRule = null;
  @SerializedName("subtype")
  private String mSubtype = null;
  @SerializedName("time_content_updated")
  private Long mTimeContentUpdated = null;
  @SerializedName("time_created")
  private Long mTimeCreated = null;
  @SerializedName("time_updated")
  private Long mTimeUpdated = null;
  protected static Gson gson = null;

  CustomAudience() {
  }

  public CustomAudience(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CustomAudience(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public CustomAudience fetch() throws APIException{
    CustomAudience newInstance = fetchById(this.getPrefixedId().toString(), this.context);
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
      .execute();
    return customAudience;
  }

  public static APINodeList<CustomAudience> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CustomAudience>)(
      new APIRequest<CustomAudience>(context, "", "/", "GET", CustomAudience.getParser())
        .setParam("ids", String.join(",", ids))
        .requestFields(fields)
        .execute()
    );
  }

  private String getPrefixedId() {
    return getId();
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
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    customAudience.context = context;
    customAudience.rawValue = json;
    return customAudience;
  }

  public static APINodeList<CustomAudience> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<CustomAudience> customAudiences = new APINodeList<CustomAudience>(request, json);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    Exception exception = null;
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
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            customAudiences.setPaging(before, after);
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
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  customAudiences.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              customAudiences.add(loadJSON(obj.toString(), context));
            }
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
          // Fifth, check if it's an array of objects indexed by id
          boolean isIdIndexedArray = true;
          for (Map.Entry entry : obj.entrySet()) {
            String key = (String) entry.getKey();
            if (key.equals("__fb_trace_id__")) {
              continue;
            }
            JsonElement value = (JsonElement) entry.getValue();
            if (
              value != null &&
              value.isJsonObject() &&
              value.getAsJsonObject().has("id") &&
              value.getAsJsonObject().get("id") != null &&
              value.getAsJsonObject().get("id").getAsString().equals(key)
            ) {
              customAudiences.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return customAudiences;
          }

          // Sixth, check if it's pure JsonObject
          customAudiences.clear();
          customAudiences.add(loadJSON(json, context));
          return customAudiences;
        }
      }
    } catch (Exception e) {
      exception = e;
    }
    throw new MalformedResponseException(
      "Invalid response string: " + json,
      exception
    );
  }

  @Override
  public APIContext getContext() {
    return context;
  }

  @Override
  public void setContext(APIContext context) {
    this.context = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }

  public APIRequestDeleteAdAccounts deleteAdAccounts() {
    return new APIRequestDeleteAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdAccounts getAdAccounts() {
    return new APIRequestGetAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdAccount createAdAccount() {
    return new APIRequestCreateAdAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAds getAds() {
    return new APIRequestGetAds(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPrefills getPrefills() {
    return new APIRequestGetPrefills(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSessions getSessions() {
    return new APIRequestGetSessions(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteUsers deleteUsers() {
    return new APIRequestDeleteUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateUser createUser() {
    return new APIRequestCreateUser(this.getPrefixedId().toString(), context);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
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

  public AdsPixel getFieldExternalEventSource() {
    if (mExternalEventSource != null) {
      mExternalEventSource.context = getContext();
    }
    return mExternalEventSource;
  }

  public String getFieldId() {
    return mId;
  }

  public List<CustomAudience> getFieldIncludedCustomAudiences() {
    return mIncludedCustomAudiences;
  }

  public String getFieldLastUsedTime() {
    return mLastUsedTime;
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

  public Business getFieldOwnerBusiness() {
    if (mOwnerBusiness != null) {
      mOwnerBusiness.context = getContext();
    }
    return mOwnerBusiness;
  }

  public CustomAudiencePermission getFieldPermissionForActions() {
    return mPermissionForActions;
  }

  public String getFieldPixelId() {
    return mPixelId;
  }

  public Long getFieldRetentionDays() {
    return mRetentionDays;
  }

  public String getFieldRule() {
    return mRule;
  }

  public String getFieldSubtype() {
    return mSubtype;
  }

  public Long getFieldTimeContentUpdated() {
    return mTimeContentUpdated;
  }

  public Long getFieldTimeCreated() {
    return mTimeCreated;
  }

  public Long getFieldTimeUpdated() {
    return mTimeUpdated;
  }



  public static class APIRequestDeleteAdAccounts extends APIRequest<CustomAudienceAdAccount> {

    APINodeList<CustomAudienceAdAccount> lastResponse = null;
    @Override
    public APINodeList<CustomAudienceAdAccount> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adaccounts",
      "id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<CustomAudienceAdAccount> parseResponse(String response) throws APIException {
      return CustomAudienceAdAccount.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<CustomAudienceAdAccount> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomAudienceAdAccount> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestDeleteAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccounts", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
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

    public APIRequestDeleteAdAccounts setId (String id) {
      this.setParam("id", id);
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

    @Override
    public APIRequestDeleteAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAdAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdAccounts extends APIRequest<CustomAudienceAdAccount> {

    APINodeList<CustomAudienceAdAccount> lastResponse = null;
    @Override
    public APINodeList<CustomAudienceAdAccount> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "permissions",
    };

    public static final String[] FIELDS = {
      "id",
    };

    @Override
    public APINodeList<CustomAudienceAdAccount> parseResponse(String response) throws APIException {
      return CustomAudienceAdAccount.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<CustomAudienceAdAccount> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomAudienceAdAccount> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdAccounts setPermissions (String permissions) {
      this.setParam("permissions", permissions);
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

    @Override
    public APIRequestGetAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
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

  public static class APIRequestCreateAdAccount extends APIRequest<CustomAudienceAdAccount> {

    CustomAudienceAdAccount lastResponse = null;
    @Override
    public CustomAudienceAdAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adaccounts",
      "id",
      "permissions",
      "replace",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CustomAudienceAdAccount parseResponse(String response) throws APIException {
      return CustomAudienceAdAccount.parseResponse(response, getContext(), this).head();
    }

    @Override
    public CustomAudienceAdAccount execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CustomAudienceAdAccount execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateAdAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccounts", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdAccount setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdAccount setParams(Map<String, Object> params) {
      setParamsInternal(params);
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

    public APIRequestCreateAdAccount setId (String id) {
      this.setParam("id", id);
      return this;
    }

    public APIRequestCreateAdAccount setPermissions (String permissions) {
      this.setParam("permissions", permissions);
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

    @Override
    public APIRequestCreateAdAccount requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdAccount requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdAccount requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdAccount requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAds extends APIRequest<Ad> {

    APINodeList<Ad> lastResponse = null;
    @Override
    public APINodeList<Ad> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "effective_status",
    };

    public static final String[] FIELDS = {
      "account_id",
      "ad_review_feedback",
      "adlabels",
      "adset",
      "adset_id",
      "bid_amount",
      "bid_info",
      "bid_type",
      "campaign",
      "campaign_id",
      "configured_status",
      "conversion_specs",
      "created_time",
      "creative",
      "effective_status",
      "id",
      "last_updated_by_app_id",
      "name",
      "recommendations",
      "status",
      "tracking_specs",
      "updated_time",
    };

    @Override
    public APINodeList<Ad> parseResponse(String response) throws APIException {
      return Ad.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Ad> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Ad> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAds(String nodeId, APIContext context) {
      super(context, nodeId, "/ads", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAds setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
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

    @Override
    public APIRequestGetAds requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAds requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAds requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAds requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAds requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAds requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAds requestAdReviewFeedbackField () {
      return this.requestAdReviewFeedbackField(true);
    }
    public APIRequestGetAds requestAdReviewFeedbackField (boolean value) {
      this.requestField("ad_review_feedback", value);
      return this;
    }
    public APIRequestGetAds requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAds requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAds requestAdsetField () {
      return this.requestAdsetField(true);
    }
    public APIRequestGetAds requestAdsetField (boolean value) {
      this.requestField("adset", value);
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
    public APIRequestGetAds requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGetAds requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGetAds requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetAds requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
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
    public APIRequestGetAds requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAds requestIdField (boolean value) {
      this.requestField("id", value);
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
    public APIRequestGetAds requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGetAds requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGetAds requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAds requestStatusField (boolean value) {
      this.requestField("status", value);
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
  }

  public static class APIRequestGetPrefills extends APIRequest<CustomAudiencePrefillState> {

    APINodeList<CustomAudiencePrefillState> lastResponse = null;
    @Override
    public APINodeList<CustomAudiencePrefillState> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "description",
      "num_added",
      "status",
    };

    @Override
    public APINodeList<CustomAudiencePrefillState> parseResponse(String response) throws APIException {
      return CustomAudiencePrefillState.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<CustomAudiencePrefillState> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomAudiencePrefillState> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetPrefills(String nodeId, APIContext context) {
      super(context, nodeId, "/prefills", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPrefills setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
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

    @Override
    public APIRequestGetPrefills requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPrefills requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPrefills requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPrefills requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
    public APIRequestGetPrefills requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetPrefills requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static class APIRequestGetSessions extends APIRequest<CustomAudienceSession> {

    APINodeList<CustomAudienceSession> lastResponse = null;
    @Override
    public APINodeList<CustomAudienceSession> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "session_id",
    };

    public static final String[] FIELDS = {
      "end_time",
      "num_invalid_entries",
      "num_matched",
      "num_received",
      "progress",
      "session_id",
      "stage",
      "start_time",
    };

    @Override
    public APINodeList<CustomAudienceSession> parseResponse(String response) throws APIException {
      return CustomAudienceSession.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<CustomAudienceSession> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomAudienceSession> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetSessions(String nodeId, APIContext context) {
      super(context, nodeId, "/sessions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSessions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
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

    @Override
    public APIRequestGetSessions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSessions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSessions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSessions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSessions requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetSessions requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetSessions requestNumInvalidEntriesField () {
      return this.requestNumInvalidEntriesField(true);
    }
    public APIRequestGetSessions requestNumInvalidEntriesField (boolean value) {
      this.requestField("num_invalid_entries", value);
      return this;
    }
    public APIRequestGetSessions requestNumMatchedField () {
      return this.requestNumMatchedField(true);
    }
    public APIRequestGetSessions requestNumMatchedField (boolean value) {
      this.requestField("num_matched", value);
      return this;
    }
    public APIRequestGetSessions requestNumReceivedField () {
      return this.requestNumReceivedField(true);
    }
    public APIRequestGetSessions requestNumReceivedField (boolean value) {
      this.requestField("num_received", value);
      return this;
    }
    public APIRequestGetSessions requestProgressField () {
      return this.requestProgressField(true);
    }
    public APIRequestGetSessions requestProgressField (boolean value) {
      this.requestField("progress", value);
      return this;
    }
    public APIRequestGetSessions requestSessionIdField () {
      return this.requestSessionIdField(true);
    }
    public APIRequestGetSessions requestSessionIdField (boolean value) {
      this.requestField("session_id", value);
      return this;
    }
    public APIRequestGetSessions requestStageField () {
      return this.requestStageField(true);
    }
    public APIRequestGetSessions requestStageField (boolean value) {
      this.requestField("stage", value);
      return this;
    }
    public APIRequestGetSessions requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetSessions requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
  }

  public static class APIRequestDeleteUsers extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id",
      "payload",
      "session",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestDeleteUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/users", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteUsers setId (String id) {
      this.setParam("id", id);
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

    public APIRequestDeleteUsers setSession (Object session) {
      this.setParam("session", session);
      return this;
    }
    public APIRequestDeleteUsers setSession (String session) {
      this.setParam("session", session);
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

    @Override
    public APIRequestDeleteUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateUser extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id",
      "payload",
      "session",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateUser(String nodeId, APIContext context) {
      super(context, nodeId, "/users", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateUser setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateUser setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateUser setId (String id) {
      this.setParam("id", id);
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

    public APIRequestCreateUser setSession (Object session) {
      this.setParam("session", session);
      return this;
    }
    public APIRequestCreateUser setSession (String session) {
      this.setParam("session", session);
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

    @Override
    public APIRequestCreateUser requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateUser requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUser requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateUser requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
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

    @Override
    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<CustomAudience> {

    CustomAudience lastResponse = null;
    @Override
    public CustomAudience getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "approximate_count",
      "data_source",
      "delivery_status",
      "description",
      "excluded_custom_audiences",
      "external_event_source",
      "id",
      "included_custom_audiences",
      "last_used_time",
      "lookalike_audience_ids",
      "lookalike_spec",
      "name",
      "operation_status",
      "opt_out_link",
      "owner_business",
      "permission_for_actions",
      "pixel_id",
      "retention_days",
      "rule",
      "subtype",
      "time_content_updated",
      "time_created",
      "time_updated",
    };

    @Override
    public CustomAudience parseResponse(String response) throws APIException {
      return CustomAudience.parseResponse(response, getContext(), this).head();
    }

    @Override
    public CustomAudience execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CustomAudience execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
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

    @Override
    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
    public APIRequestGet requestExternalEventSourceField () {
      return this.requestExternalEventSourceField(true);
    }
    public APIRequestGet requestExternalEventSourceField (boolean value) {
      this.requestField("external_event_source", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIncludedCustomAudiencesField () {
      return this.requestIncludedCustomAudiencesField(true);
    }
    public APIRequestGet requestIncludedCustomAudiencesField (boolean value) {
      this.requestField("included_custom_audiences", value);
      return this;
    }
    public APIRequestGet requestLastUsedTimeField () {
      return this.requestLastUsedTimeField(true);
    }
    public APIRequestGet requestLastUsedTimeField (boolean value) {
      this.requestField("last_used_time", value);
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
    public APIRequestGet requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGet requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
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
    public APIRequestGet requestRetentionDaysField () {
      return this.requestRetentionDaysField(true);
    }
    public APIRequestGet requestRetentionDaysField (boolean value) {
      this.requestField("retention_days", value);
      return this;
    }
    public APIRequestGet requestRuleField () {
      return this.requestRuleField(true);
    }
    public APIRequestGet requestRuleField (boolean value) {
      this.requestField("rule", value);
      return this;
    }
    public APIRequestGet requestSubtypeField () {
      return this.requestSubtypeField(true);
    }
    public APIRequestGet requestSubtypeField (boolean value) {
      this.requestField("subtype", value);
      return this;
    }
    public APIRequestGet requestTimeContentUpdatedField () {
      return this.requestTimeContentUpdatedField(true);
    }
    public APIRequestGet requestTimeContentUpdatedField (boolean value) {
      this.requestField("time_content_updated", value);
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
  }

  public static class APIRequestUpdate extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "content_type",
      "description",
      "exclusions",
      "inclusions",
      "lookalike_spec",
      "name",
      "opt_out_link",
      "product_set_id",
      "retention_days",
      "rule",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setContentType (CustomAudience.EnumContentType contentType) {
      this.setParam("content_type", contentType);
      return this;
    }
    public APIRequestUpdate setContentType (String contentType) {
      this.setParam("content_type", contentType);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
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

    public APIRequestUpdate setInclusions (List<Object> inclusions) {
      this.setParam("inclusions", inclusions);
      return this;
    }
    public APIRequestUpdate setInclusions (String inclusions) {
      this.setParam("inclusions", inclusions);
      return this;
    }

    public APIRequestUpdate setLookalikeSpec (String lookalikeSpec) {
      this.setParam("lookalike_spec", lookalikeSpec);
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

    public APIRequestUpdate setProductSetId (String productSetId) {
      this.setParam("product_set_id", productSetId);
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

    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static enum EnumContentType {
      @SerializedName("HOTEL")
      VALUE_HOTEL("HOTEL"),
      @SerializedName("FLIGHT")
      VALUE_FLIGHT("FLIGHT"),
      NULL(null);

      private String value;

      private EnumContentType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSubtype {
      @SerializedName("CUSTOM")
      VALUE_CUSTOM("CUSTOM"),
      @SerializedName("WEBSITE")
      VALUE_WEBSITE("WEBSITE"),
      @SerializedName("APP")
      VALUE_APP("APP"),
      @SerializedName("CLAIM")
      VALUE_CLAIM("CLAIM"),
      @SerializedName("PARTNER")
      VALUE_PARTNER("PARTNER"),
      @SerializedName("MANAGED")
      VALUE_MANAGED("MANAGED"),
      @SerializedName("VIDEO")
      VALUE_VIDEO("VIDEO"),
      @SerializedName("LOOKALIKE")
      VALUE_LOOKALIKE("LOOKALIKE"),
      @SerializedName("ENGAGEMENT")
      VALUE_ENGAGEMENT("ENGAGEMENT"),
      @SerializedName("DATA_SET")
      VALUE_DATA_SET("DATA_SET"),
      @SerializedName("BAG_OF_ACCOUNTS")
      VALUE_BAG_OF_ACCOUNTS("BAG_OF_ACCOUNTS"),
      NULL(null);

      private String value;

      private EnumSubtype(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumFields {
      @SerializedName("id")
      VALUE_ID("id"),
      @SerializedName("account_id")
      VALUE_ACCOUNT_ID("account_id"),
      @SerializedName("approximate_count")
      VALUE_APPROXIMATE_COUNT("approximate_count"),
      @SerializedName("data_source")
      VALUE_DATA_SOURCE("data_source"),
      @SerializedName("delivery_status")
      VALUE_DELIVERY_STATUS("delivery_status"),
      @SerializedName("description")
      VALUE_DESCRIPTION("description"),
      @SerializedName("excluded_custom_audiences")
      VALUE_EXCLUDED_CUSTOM_AUDIENCES("excluded_custom_audiences"),
      @SerializedName("external_event_source")
      VALUE_EXTERNAL_EVENT_SOURCE("external_event_source"),
      @SerializedName("included_custom_audiences")
      VALUE_INCLUDED_CUSTOM_AUDIENCES("included_custom_audiences"),
      @SerializedName("last_used_time")
      VALUE_LAST_USED_TIME("last_used_time"),
      @SerializedName("lookalike_audience_ids")
      VALUE_LOOKALIKE_AUDIENCE_IDS("lookalike_audience_ids"),
      @SerializedName("lookalike_spec")
      VALUE_LOOKALIKE_SPEC("lookalike_spec"),
      @SerializedName("name")
      VALUE_NAME("name"),
      @SerializedName("operation_status")
      VALUE_OPERATION_STATUS("operation_status"),
      @SerializedName("opt_out_link")
      VALUE_OPT_OUT_LINK("opt_out_link"),
      @SerializedName("owner_business")
      VALUE_OWNER_BUSINESS("owner_business"),
      @SerializedName("permission_for_actions")
      VALUE_PERMISSION_FOR_ACTIONS("permission_for_actions"),
      @SerializedName("pixel_id")
      VALUE_PIXEL_ID("pixel_id"),
      @SerializedName("retention_days")
      VALUE_RETENTION_DAYS("retention_days"),
      @SerializedName("rule")
      VALUE_RULE("rule"),
      @SerializedName("subtype")
      VALUE_SUBTYPE("subtype"),
      @SerializedName("time_content_updated")
      VALUE_TIME_CONTENT_UPDATED("time_content_updated"),
      @SerializedName("time_created")
      VALUE_TIME_CREATED("time_created"),
      @SerializedName("time_updated")
      VALUE_TIME_UPDATED("time_updated"),
      NULL(null);

      private String value;

      private EnumFields(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
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
    this.mAccountId = instance.mAccountId;
    this.mApproximateCount = instance.mApproximateCount;
    this.mDataSource = instance.mDataSource;
    this.mDeliveryStatus = instance.mDeliveryStatus;
    this.mDescription = instance.mDescription;
    this.mExcludedCustomAudiences = instance.mExcludedCustomAudiences;
    this.mExternalEventSource = instance.mExternalEventSource;
    this.mId = instance.mId;
    this.mIncludedCustomAudiences = instance.mIncludedCustomAudiences;
    this.mLastUsedTime = instance.mLastUsedTime;
    this.mLookalikeAudienceIds = instance.mLookalikeAudienceIds;
    this.mLookalikeSpec = instance.mLookalikeSpec;
    this.mName = instance.mName;
    this.mOperationStatus = instance.mOperationStatus;
    this.mOptOutLink = instance.mOptOutLink;
    this.mOwnerBusiness = instance.mOwnerBusiness;
    this.mPermissionForActions = instance.mPermissionForActions;
    this.mPixelId = instance.mPixelId;
    this.mRetentionDays = instance.mRetentionDays;
    this.mRule = instance.mRule;
    this.mSubtype = instance.mSubtype;
    this.mTimeContentUpdated = instance.mTimeContentUpdated;
    this.mTimeCreated = instance.mTimeCreated;
    this.mTimeUpdated = instance.mTimeUpdated;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CustomAudience> getParser() {
    return new APIRequest.ResponseParser<CustomAudience>() {
      public APINodeList<CustomAudience> parseResponse(String response, APIContext context, APIRequest<CustomAudience> request) throws MalformedResponseException {
        return CustomAudience.parseResponse(response, context, request);
      }
    };
  }
}