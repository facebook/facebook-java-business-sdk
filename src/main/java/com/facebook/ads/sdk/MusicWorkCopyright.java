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
public class MusicWorkCopyright extends APINode {
  @SerializedName("available_ui_actions")
  private List<String> mAvailableUiActions = null;
  @SerializedName("claim_status")
  private String mClaimStatus = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("displayed_fb_matches_count")
  private Long mDisplayedFbMatchesCount = null;
  @SerializedName("displayed_ig_matches_count")
  private Long mDisplayedIgMatchesCount = null;
  @SerializedName("displayed_matches_count")
  private Long mDisplayedMatchesCount = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("match_rule")
  private VideoCopyrightRule mMatchRule = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("tags")
  private List<String> mTags = null;
  @SerializedName("update_time")
  private String mUpdateTime = null;
  protected static Gson gson = null;

  MusicWorkCopyright() {
  }

  public MusicWorkCopyright(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public MusicWorkCopyright(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public MusicWorkCopyright fetch() throws APIException{
    MusicWorkCopyright newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static MusicWorkCopyright fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<MusicWorkCopyright> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static MusicWorkCopyright fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<MusicWorkCopyright> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<MusicWorkCopyright> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<MusicWorkCopyright>)(
      new APIRequest<MusicWorkCopyright>(context, "", "/", "GET", MusicWorkCopyright.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<MusicWorkCopyright>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", MusicWorkCopyright.getParser())
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
  public static MusicWorkCopyright loadJSON(String json, APIContext context, String header) {
    MusicWorkCopyright musicWorkCopyright = getGson().fromJson(json, MusicWorkCopyright.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(musicWorkCopyright.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    musicWorkCopyright.context = context;
    musicWorkCopyright.rawValue = json;
    musicWorkCopyright.header = header;
    return musicWorkCopyright;
  }

  public static APINodeList<MusicWorkCopyright> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<MusicWorkCopyright> musicWorkCopyrights = new APINodeList<MusicWorkCopyright>(request, json, header);
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
          musicWorkCopyrights.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return musicWorkCopyrights;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                musicWorkCopyrights.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            musicWorkCopyrights.setPaging(previous, next);
            if (context.hasAppSecret()) {
              musicWorkCopyrights.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              musicWorkCopyrights.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  musicWorkCopyrights.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              musicWorkCopyrights.add(loadJSON(obj.toString(), context, header));
            }
          }
          return musicWorkCopyrights;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              musicWorkCopyrights.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return musicWorkCopyrights;
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
              musicWorkCopyrights.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return musicWorkCopyrights;
          }

          // Sixth, check if it's pure JsonObject
          musicWorkCopyrights.clear();
          musicWorkCopyrights.add(loadJSON(json, context, header));
          return musicWorkCopyrights;
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


  public List<String> getFieldAvailableUiActions() {
    return mAvailableUiActions;
  }

  public String getFieldClaimStatus() {
    return mClaimStatus;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public Long getFieldDisplayedFbMatchesCount() {
    return mDisplayedFbMatchesCount;
  }

  public Long getFieldDisplayedIgMatchesCount() {
    return mDisplayedIgMatchesCount;
  }

  public Long getFieldDisplayedMatchesCount() {
    return mDisplayedMatchesCount;
  }

  public String getFieldId() {
    return mId;
  }

  public VideoCopyrightRule getFieldMatchRule() {
    if (mMatchRule != null) {
      mMatchRule.context = getContext();
    }
    return mMatchRule;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public List<String> getFieldTags() {
    return mTags;
  }

  public String getFieldUpdateTime() {
    return mUpdateTime;
  }



  public static class APIRequestGet extends APIRequest<MusicWorkCopyright> {

    MusicWorkCopyright lastResponse = null;
    @Override
    public MusicWorkCopyright getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "available_ui_actions",
      "claim_status",
      "creation_time",
      "displayed_fb_matches_count",
      "displayed_ig_matches_count",
      "displayed_matches_count",
      "id",
      "match_rule",
      "status",
      "tags",
      "update_time",
    };

    @Override
    public MusicWorkCopyright parseResponse(String response, String header) throws APIException {
      return MusicWorkCopyright.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public MusicWorkCopyright execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MusicWorkCopyright execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<MusicWorkCopyright> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MusicWorkCopyright> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, MusicWorkCopyright>() {
           public MusicWorkCopyright apply(ResponseWrapper result) {
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

    public APIRequestGet requestAvailableUiActionsField () {
      return this.requestAvailableUiActionsField(true);
    }
    public APIRequestGet requestAvailableUiActionsField (boolean value) {
      this.requestField("available_ui_actions", value);
      return this;
    }
    public APIRequestGet requestClaimStatusField () {
      return this.requestClaimStatusField(true);
    }
    public APIRequestGet requestClaimStatusField (boolean value) {
      this.requestField("claim_status", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestDisplayedFbMatchesCountField () {
      return this.requestDisplayedFbMatchesCountField(true);
    }
    public APIRequestGet requestDisplayedFbMatchesCountField (boolean value) {
      this.requestField("displayed_fb_matches_count", value);
      return this;
    }
    public APIRequestGet requestDisplayedIgMatchesCountField () {
      return this.requestDisplayedIgMatchesCountField(true);
    }
    public APIRequestGet requestDisplayedIgMatchesCountField (boolean value) {
      this.requestField("displayed_ig_matches_count", value);
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
    public APIRequestGet requestMatchRuleField () {
      return this.requestMatchRuleField(true);
    }
    public APIRequestGet requestMatchRuleField (boolean value) {
      this.requestField("match_rule", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
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

  public MusicWorkCopyright copyFrom(MusicWorkCopyright instance) {
    this.mAvailableUiActions = instance.mAvailableUiActions;
    this.mClaimStatus = instance.mClaimStatus;
    this.mCreationTime = instance.mCreationTime;
    this.mDisplayedFbMatchesCount = instance.mDisplayedFbMatchesCount;
    this.mDisplayedIgMatchesCount = instance.mDisplayedIgMatchesCount;
    this.mDisplayedMatchesCount = instance.mDisplayedMatchesCount;
    this.mId = instance.mId;
    this.mMatchRule = instance.mMatchRule;
    this.mStatus = instance.mStatus;
    this.mTags = instance.mTags;
    this.mUpdateTime = instance.mUpdateTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MusicWorkCopyright> getParser() {
    return new APIRequest.ResponseParser<MusicWorkCopyright>() {
      public APINodeList<MusicWorkCopyright> parseResponse(String response, APIContext context, APIRequest<MusicWorkCopyright> request, String header) throws MalformedResponseException {
        return MusicWorkCopyright.parseResponse(response, context, request, header);
      }
    };
  }
}
