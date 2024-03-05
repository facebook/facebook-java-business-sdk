/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
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
import com.google.common.util.concurrent.MoreExecutors;
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
public class MusicVideoCopyright extends APINode {
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("displayed_matches_count")
  private Long mDisplayedMatchesCount = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("in_conflict")
  private Boolean mInConflict = null;
  @SerializedName("isrc")
  private String mIsrc = null;
  @SerializedName("match_rule")
  private VideoCopyrightRule mMatchRule = null;
  @SerializedName("ownership_countries")
  private List<String> mOwnershipCountries = null;
  @SerializedName("reference_file_status")
  private String mReferenceFileStatus = null;
  @SerializedName("ridge_monitoring_status")
  private String mRidgeMonitoringStatus = null;
  @SerializedName("tags")
  private List<String> mTags = null;
  @SerializedName("update_time")
  private String mUpdateTime = null;
  @SerializedName("video_asset")
  private CopyrightReferenceContainer mVideoAsset = null;
  @SerializedName("whitelisted_fb_users")
  private List<Object> mWhitelistedFbUsers = null;
  @SerializedName("whitelisted_ig_users")
  private List<String> mWhitelistedIgUsers = null;
  protected static Gson gson = null;

  MusicVideoCopyright() {
  }

  public MusicVideoCopyright(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public MusicVideoCopyright(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public MusicVideoCopyright fetch() throws APIException{
    MusicVideoCopyright newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static MusicVideoCopyright fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<MusicVideoCopyright> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static MusicVideoCopyright fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<MusicVideoCopyright> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<MusicVideoCopyright> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<MusicVideoCopyright>)(
      new APIRequest<MusicVideoCopyright>(context, "", "/", "GET", MusicVideoCopyright.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<MusicVideoCopyright>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", MusicVideoCopyright.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static MusicVideoCopyright loadJSON(String json, APIContext context, String header) {
    MusicVideoCopyright musicVideoCopyright = getGson().fromJson(json, MusicVideoCopyright.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(musicVideoCopyright.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    musicVideoCopyright.context = context;
    musicVideoCopyright.rawValue = json;
    musicVideoCopyright.header = header;
    return musicVideoCopyright;
  }

  public static APINodeList<MusicVideoCopyright> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<MusicVideoCopyright> musicVideoCopyrights = new APINodeList<MusicVideoCopyright>(request, json, header);
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
          musicVideoCopyrights.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return musicVideoCopyrights;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                musicVideoCopyrights.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            musicVideoCopyrights.setPaging(previous, next);
            if (context.hasAppSecret()) {
              musicVideoCopyrights.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              musicVideoCopyrights.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  musicVideoCopyrights.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              musicVideoCopyrights.add(loadJSON(obj.toString(), context, header));
            }
          }
          return musicVideoCopyrights;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              musicVideoCopyrights.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return musicVideoCopyrights;
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
              musicVideoCopyrights.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return musicVideoCopyrights;
          }

          // Sixth, check if it's pure JsonObject
          musicVideoCopyrights.clear();
          musicVideoCopyrights.add(loadJSON(json, context, header));
          return musicVideoCopyrights;
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public Long getFieldDisplayedMatchesCount() {
    return mDisplayedMatchesCount;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldInConflict() {
    return mInConflict;
  }

  public String getFieldIsrc() {
    return mIsrc;
  }

  public VideoCopyrightRule getFieldMatchRule() {
    if (mMatchRule != null) {
      mMatchRule.context = getContext();
    }
    return mMatchRule;
  }

  public List<String> getFieldOwnershipCountries() {
    return mOwnershipCountries;
  }

  public String getFieldReferenceFileStatus() {
    return mReferenceFileStatus;
  }

  public String getFieldRidgeMonitoringStatus() {
    return mRidgeMonitoringStatus;
  }

  public List<String> getFieldTags() {
    return mTags;
  }

  public String getFieldUpdateTime() {
    return mUpdateTime;
  }

  public CopyrightReferenceContainer getFieldVideoAsset() {
    return mVideoAsset;
  }

  public List<Object> getFieldWhitelistedFbUsers() {
    return mWhitelistedFbUsers;
  }

  public List<String> getFieldWhitelistedIgUsers() {
    return mWhitelistedIgUsers;
  }



  public static class APIRequestGet extends APIRequest<MusicVideoCopyright> {

    MusicVideoCopyright lastResponse = null;
    @Override
    public MusicVideoCopyright getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "creation_time",
      "displayed_matches_count",
      "id",
      "in_conflict",
      "isrc",
      "match_rule",
      "ownership_countries",
      "reference_file_status",
      "ridge_monitoring_status",
      "tags",
      "update_time",
      "video_asset",
      "whitelisted_fb_users",
      "whitelisted_ig_users",
    };

    @Override
    public MusicVideoCopyright parseResponse(String response, String header) throws APIException {
      return MusicVideoCopyright.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public MusicVideoCopyright execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MusicVideoCopyright execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<MusicVideoCopyright> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MusicVideoCopyright> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, MusicVideoCopyright>() {
           public MusicVideoCopyright apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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

    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestDisplayedMatchesCountField () {
      return this.requestDisplayedMatchesCountField(true);
    }
    public APIRequestGet requestDisplayedMatchesCountField (boolean value) {
      this.requestField("displayed_matches_count", value);
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
    public APIRequestGet requestIsrcField () {
      return this.requestIsrcField(true);
    }
    public APIRequestGet requestIsrcField (boolean value) {
      this.requestField("isrc", value);
      return this;
    }
    public APIRequestGet requestMatchRuleField () {
      return this.requestMatchRuleField(true);
    }
    public APIRequestGet requestMatchRuleField (boolean value) {
      this.requestField("match_rule", value);
      return this;
    }
    public APIRequestGet requestOwnershipCountriesField () {
      return this.requestOwnershipCountriesField(true);
    }
    public APIRequestGet requestOwnershipCountriesField (boolean value) {
      this.requestField("ownership_countries", value);
      return this;
    }
    public APIRequestGet requestReferenceFileStatusField () {
      return this.requestReferenceFileStatusField(true);
    }
    public APIRequestGet requestReferenceFileStatusField (boolean value) {
      this.requestField("reference_file_status", value);
      return this;
    }
    public APIRequestGet requestRidgeMonitoringStatusField () {
      return this.requestRidgeMonitoringStatusField(true);
    }
    public APIRequestGet requestRidgeMonitoringStatusField (boolean value) {
      this.requestField("ridge_monitoring_status", value);
      return this;
    }
    public APIRequestGet requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGet requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
    public APIRequestGet requestUpdateTimeField () {
      return this.requestUpdateTimeField(true);
    }
    public APIRequestGet requestUpdateTimeField (boolean value) {
      this.requestField("update_time", value);
      return this;
    }
    public APIRequestGet requestVideoAssetField () {
      return this.requestVideoAssetField(true);
    }
    public APIRequestGet requestVideoAssetField (boolean value) {
      this.requestField("video_asset", value);
      return this;
    }
    public APIRequestGet requestWhitelistedFbUsersField () {
      return this.requestWhitelistedFbUsersField(true);
    }
    public APIRequestGet requestWhitelistedFbUsersField (boolean value) {
      this.requestField("whitelisted_fb_users", value);
      return this;
    }
    public APIRequestGet requestWhitelistedIgUsersField () {
      return this.requestWhitelistedIgUsersField(true);
    }
    public APIRequestGet requestWhitelistedIgUsersField (boolean value) {
      this.requestField("whitelisted_ig_users", value);
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

  public MusicVideoCopyright copyFrom(MusicVideoCopyright instance) {
    this.mCreationTime = instance.mCreationTime;
    this.mDisplayedMatchesCount = instance.mDisplayedMatchesCount;
    this.mId = instance.mId;
    this.mInConflict = instance.mInConflict;
    this.mIsrc = instance.mIsrc;
    this.mMatchRule = instance.mMatchRule;
    this.mOwnershipCountries = instance.mOwnershipCountries;
    this.mReferenceFileStatus = instance.mReferenceFileStatus;
    this.mRidgeMonitoringStatus = instance.mRidgeMonitoringStatus;
    this.mTags = instance.mTags;
    this.mUpdateTime = instance.mUpdateTime;
    this.mVideoAsset = instance.mVideoAsset;
    this.mWhitelistedFbUsers = instance.mWhitelistedFbUsers;
    this.mWhitelistedIgUsers = instance.mWhitelistedIgUsers;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MusicVideoCopyright> getParser() {
    return new APIRequest.ResponseParser<MusicVideoCopyright>() {
      public APINodeList<MusicVideoCopyright> parseResponse(String response, APIContext context, APIRequest<MusicVideoCopyright> request, String header) throws MalformedResponseException {
        return MusicVideoCopyright.parseResponse(response, context, request, header);
      }
    };
  }
}
