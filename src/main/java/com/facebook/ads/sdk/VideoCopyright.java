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

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
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
 * This class is auto-generated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class VideoCopyright extends APINode {
  @SerializedName("content_category")
  private String mContentCategory = null;
  @SerializedName("copyright_content_id")
  private String mCopyrightContentId = null;
  @SerializedName("creator")
  private User mCreator = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("in_conflict")
  private Boolean mInConflict = null;
  @SerializedName("monitoring_status")
  private String mMonitoringStatus = null;
  @SerializedName("monitoring_type")
  private String mMonitoringType = null;
  @SerializedName("ownership_countries")
  private Object mOwnershipCountries = null;
  @SerializedName("reference_file")
  private Object mReferenceFile = null;
  @SerializedName("reference_file_disabled")
  private Boolean mReferenceFileDisabled = null;
  @SerializedName("reference_file_disabled_by_ops")
  private Boolean mReferenceFileDisabledByOps = null;
  @SerializedName("reference_file_expired")
  private Boolean mReferenceFileExpired = null;
  @SerializedName("reference_owner_id")
  private String mReferenceOwnerId = null;
  @SerializedName("rule_ids")
  private List<VideoCopyrightRule> mRuleIds = null;
  @SerializedName("whitelisted_ids")
  private List<String> mWhitelistedIds = null;
  protected static Gson gson = null;

  VideoCopyright() {
  }

  public VideoCopyright(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public VideoCopyright(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public VideoCopyright fetch() throws APIException{
    VideoCopyright newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static VideoCopyright fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<VideoCopyright> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static VideoCopyright fetchById(String id, APIContext context) throws APIException {
    VideoCopyright videoCopyright =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return videoCopyright;
  }

  public static ListenableFuture<VideoCopyright> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<VideoCopyright> videoCopyright =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return videoCopyright;
  }

  public static APINodeList<VideoCopyright> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<VideoCopyright>)(
      new APIRequest<VideoCopyright>(context, "", "/", "GET", VideoCopyright.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<VideoCopyright>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<VideoCopyright>> videoCopyright =
      new APIRequest(context, "", "/", "GET", VideoCopyright.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return videoCopyright;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static VideoCopyright loadJSON(String json, APIContext context) {
    VideoCopyright videoCopyright = getGson().fromJson(json, VideoCopyright.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(videoCopyright.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    videoCopyright.context = context;
    videoCopyright.rawValue = json;
    return videoCopyright;
  }

  public static APINodeList<VideoCopyright> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<VideoCopyright> videoCopyrights = new APINodeList<VideoCopyright>(request, json);
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
          videoCopyrights.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return videoCopyrights;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                videoCopyrights.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            videoCopyrights.setPaging(previous, next);
            if (context.hasAppSecret()) {
              videoCopyrights.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              videoCopyrights.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  videoCopyrights.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              videoCopyrights.add(loadJSON(obj.toString(), context));
            }
          }
          return videoCopyrights;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              videoCopyrights.add(loadJSON(entry.getValue().toString(), context));
          }
          return videoCopyrights;
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
              videoCopyrights.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return videoCopyrights;
          }

          // Sixth, check if it's pure JsonObject
          videoCopyrights.clear();
          videoCopyrights.add(loadJSON(json, context));
          return videoCopyrights;
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

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldContentCategory() {
    return mContentCategory;
  }

  public String getFieldCopyrightContentId() {
    return mCopyrightContentId;
  }

  public User getFieldCreator() {
    if (mCreator != null) {
      mCreator.context = getContext();
    }
    return mCreator;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldInConflict() {
    return mInConflict;
  }

  public String getFieldMonitoringStatus() {
    return mMonitoringStatus;
  }

  public String getFieldMonitoringType() {
    return mMonitoringType;
  }

  public Object getFieldOwnershipCountries() {
    return mOwnershipCountries;
  }

  public Object getFieldReferenceFile() {
    return mReferenceFile;
  }

  public Boolean getFieldReferenceFileDisabled() {
    return mReferenceFileDisabled;
  }

  public Boolean getFieldReferenceFileDisabledByOps() {
    return mReferenceFileDisabledByOps;
  }

  public Boolean getFieldReferenceFileExpired() {
    return mReferenceFileExpired;
  }

  public String getFieldReferenceOwnerId() {
    return mReferenceOwnerId;
  }

  public List<VideoCopyrightRule> getFieldRuleIds() {
    return mRuleIds;
  }

  public List<String> getFieldWhitelistedIds() {
    return mWhitelistedIds;
  }



  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINode>() {
           public APINode apply(String result) {
             try {
               return APIRequestDelete.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

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

  public static class APIRequestGet extends APIRequest<VideoCopyright> {

    VideoCopyright lastResponse = null;
    @Override
    public VideoCopyright getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "content_category",
      "copyright_content_id",
      "creator",
      "id",
      "in_conflict",
      "monitoring_status",
      "monitoring_type",
      "ownership_countries",
      "reference_file",
      "reference_file_disabled",
      "reference_file_disabled_by_ops",
      "reference_file_expired",
      "reference_owner_id",
      "rule_ids",
      "whitelisted_ids",
    };

    @Override
    public VideoCopyright parseResponse(String response) throws APIException {
      return VideoCopyright.parseResponse(response, getContext(), this).head();
    }

    @Override
    public VideoCopyright execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public VideoCopyright execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<VideoCopyright> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<VideoCopyright> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, VideoCopyright>() {
           public VideoCopyright apply(String result) {
             try {
               return APIRequestGet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

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

    public APIRequestGet requestContentCategoryField () {
      return this.requestContentCategoryField(true);
    }
    public APIRequestGet requestContentCategoryField (boolean value) {
      this.requestField("content_category", value);
      return this;
    }
    public APIRequestGet requestCopyrightContentIdField () {
      return this.requestCopyrightContentIdField(true);
    }
    public APIRequestGet requestCopyrightContentIdField (boolean value) {
      this.requestField("copyright_content_id", value);
      return this;
    }
    public APIRequestGet requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGet requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInConflictField () {
      return this.requestInConflictField(true);
    }
    public APIRequestGet requestInConflictField (boolean value) {
      this.requestField("in_conflict", value);
      return this;
    }
    public APIRequestGet requestMonitoringStatusField () {
      return this.requestMonitoringStatusField(true);
    }
    public APIRequestGet requestMonitoringStatusField (boolean value) {
      this.requestField("monitoring_status", value);
      return this;
    }
    public APIRequestGet requestMonitoringTypeField () {
      return this.requestMonitoringTypeField(true);
    }
    public APIRequestGet requestMonitoringTypeField (boolean value) {
      this.requestField("monitoring_type", value);
      return this;
    }
    public APIRequestGet requestOwnershipCountriesField () {
      return this.requestOwnershipCountriesField(true);
    }
    public APIRequestGet requestOwnershipCountriesField (boolean value) {
      this.requestField("ownership_countries", value);
      return this;
    }
    public APIRequestGet requestReferenceFileField () {
      return this.requestReferenceFileField(true);
    }
    public APIRequestGet requestReferenceFileField (boolean value) {
      this.requestField("reference_file", value);
      return this;
    }
    public APIRequestGet requestReferenceFileDisabledField () {
      return this.requestReferenceFileDisabledField(true);
    }
    public APIRequestGet requestReferenceFileDisabledField (boolean value) {
      this.requestField("reference_file_disabled", value);
      return this;
    }
    public APIRequestGet requestReferenceFileDisabledByOpsField () {
      return this.requestReferenceFileDisabledByOpsField(true);
    }
    public APIRequestGet requestReferenceFileDisabledByOpsField (boolean value) {
      this.requestField("reference_file_disabled_by_ops", value);
      return this;
    }
    public APIRequestGet requestReferenceFileExpiredField () {
      return this.requestReferenceFileExpiredField(true);
    }
    public APIRequestGet requestReferenceFileExpiredField (boolean value) {
      this.requestField("reference_file_expired", value);
      return this;
    }
    public APIRequestGet requestReferenceOwnerIdField () {
      return this.requestReferenceOwnerIdField(true);
    }
    public APIRequestGet requestReferenceOwnerIdField (boolean value) {
      this.requestField("reference_owner_id", value);
      return this;
    }
    public APIRequestGet requestRuleIdsField () {
      return this.requestRuleIdsField(true);
    }
    public APIRequestGet requestRuleIdsField (boolean value) {
      this.requestField("rule_ids", value);
      return this;
    }
    public APIRequestGet requestWhitelistedIdsField () {
      return this.requestWhitelistedIdsField(true);
    }
    public APIRequestGet requestWhitelistedIdsField (boolean value) {
      this.requestField("whitelisted_ids", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<VideoCopyright> {

    VideoCopyright lastResponse = null;
    @Override
    public VideoCopyright getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "append_excluded_ownership_segments",
      "attribution_id",
      "content_category",
      "excluded_ownership_countries",
      "excluded_ownership_segments",
      "is_reference_disabled",
      "monitoring_type",
      "ownership_countries",
      "rule_id",
      "whitelisted_ids",
      "whitelisted_ig_user_ids",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public VideoCopyright parseResponse(String response) throws APIException {
      return VideoCopyright.parseResponse(response, getContext(), this).head();
    }

    @Override
    public VideoCopyright execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public VideoCopyright execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<VideoCopyright> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<VideoCopyright> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, VideoCopyright>() {
           public VideoCopyright apply(String result) {
             try {
               return APIRequestUpdate.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

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


    public APIRequestUpdate setAppendExcludedOwnershipSegments (Boolean appendExcludedOwnershipSegments) {
      this.setParam("append_excluded_ownership_segments", appendExcludedOwnershipSegments);
      return this;
    }
    public APIRequestUpdate setAppendExcludedOwnershipSegments (String appendExcludedOwnershipSegments) {
      this.setParam("append_excluded_ownership_segments", appendExcludedOwnershipSegments);
      return this;
    }

    public APIRequestUpdate setAttributionId (String attributionId) {
      this.setParam("attribution_id", attributionId);
      return this;
    }

    public APIRequestUpdate setContentCategory (VideoCopyright.EnumContentCategory contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }
    public APIRequestUpdate setContentCategory (String contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }

    public APIRequestUpdate setExcludedOwnershipCountries (List<String> excludedOwnershipCountries) {
      this.setParam("excluded_ownership_countries", excludedOwnershipCountries);
      return this;
    }
    public APIRequestUpdate setExcludedOwnershipCountries (String excludedOwnershipCountries) {
      this.setParam("excluded_ownership_countries", excludedOwnershipCountries);
      return this;
    }

    public APIRequestUpdate setExcludedOwnershipSegments (List<Object> excludedOwnershipSegments) {
      this.setParam("excluded_ownership_segments", excludedOwnershipSegments);
      return this;
    }
    public APIRequestUpdate setExcludedOwnershipSegments (String excludedOwnershipSegments) {
      this.setParam("excluded_ownership_segments", excludedOwnershipSegments);
      return this;
    }

    public APIRequestUpdate setIsReferenceDisabled (Boolean isReferenceDisabled) {
      this.setParam("is_reference_disabled", isReferenceDisabled);
      return this;
    }
    public APIRequestUpdate setIsReferenceDisabled (String isReferenceDisabled) {
      this.setParam("is_reference_disabled", isReferenceDisabled);
      return this;
    }

    public APIRequestUpdate setMonitoringType (VideoCopyright.EnumMonitoringType monitoringType) {
      this.setParam("monitoring_type", monitoringType);
      return this;
    }
    public APIRequestUpdate setMonitoringType (String monitoringType) {
      this.setParam("monitoring_type", monitoringType);
      return this;
    }

    public APIRequestUpdate setOwnershipCountries (List<String> ownershipCountries) {
      this.setParam("ownership_countries", ownershipCountries);
      return this;
    }
    public APIRequestUpdate setOwnershipCountries (String ownershipCountries) {
      this.setParam("ownership_countries", ownershipCountries);
      return this;
    }

    public APIRequestUpdate setRuleId (String ruleId) {
      this.setParam("rule_id", ruleId);
      return this;
    }

    public APIRequestUpdate setWhitelistedIds (List<String> whitelistedIds) {
      this.setParam("whitelisted_ids", whitelistedIds);
      return this;
    }
    public APIRequestUpdate setWhitelistedIds (String whitelistedIds) {
      this.setParam("whitelisted_ids", whitelistedIds);
      return this;
    }

    public APIRequestUpdate setWhitelistedIgUserIds (List<String> whitelistedIgUserIds) {
      this.setParam("whitelisted_ig_user_ids", whitelistedIgUserIds);
      return this;
    }
    public APIRequestUpdate setWhitelistedIgUserIds (String whitelistedIgUserIds) {
      this.setParam("whitelisted_ig_user_ids", whitelistedIgUserIds);
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

  public static enum EnumContentCategory {
      @SerializedName("episode")
      VALUE_EPISODE("episode"),
      @SerializedName("movie")
      VALUE_MOVIE("movie"),
      @SerializedName("web")
      VALUE_WEB("web"),
      NULL(null);

      private String value;

      private EnumContentCategory(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMonitoringType {
      @SerializedName("VIDEO_AND_AUDIO")
      VALUE_VIDEO_AND_AUDIO("VIDEO_AND_AUDIO"),
      @SerializedName("VIDEO_ONLY")
      VALUE_VIDEO_ONLY("VIDEO_ONLY"),
      @SerializedName("AUDIO_ONLY")
      VALUE_AUDIO_ONLY("AUDIO_ONLY"),
      NULL(null);

      private String value;

      private EnumMonitoringType(String value) {
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

  public VideoCopyright copyFrom(VideoCopyright instance) {
    this.mContentCategory = instance.mContentCategory;
    this.mCopyrightContentId = instance.mCopyrightContentId;
    this.mCreator = instance.mCreator;
    this.mId = instance.mId;
    this.mInConflict = instance.mInConflict;
    this.mMonitoringStatus = instance.mMonitoringStatus;
    this.mMonitoringType = instance.mMonitoringType;
    this.mOwnershipCountries = instance.mOwnershipCountries;
    this.mReferenceFile = instance.mReferenceFile;
    this.mReferenceFileDisabled = instance.mReferenceFileDisabled;
    this.mReferenceFileDisabledByOps = instance.mReferenceFileDisabledByOps;
    this.mReferenceFileExpired = instance.mReferenceFileExpired;
    this.mReferenceOwnerId = instance.mReferenceOwnerId;
    this.mRuleIds = instance.mRuleIds;
    this.mWhitelistedIds = instance.mWhitelistedIds;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<VideoCopyright> getParser() {
    return new APIRequest.ResponseParser<VideoCopyright>() {
      public APINodeList<VideoCopyright> parseResponse(String response, APIContext context, APIRequest<VideoCopyright> request) throws MalformedResponseException {
        return VideoCopyright.parseResponse(response, context, request);
      }
    };
  }
}
