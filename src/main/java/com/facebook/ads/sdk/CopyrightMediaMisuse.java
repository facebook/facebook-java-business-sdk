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
public class CopyrightMediaMisuse extends APINode {
  @SerializedName("audio_segments")
  private List<Object> mAudioSegments = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("disabled_audio_segments")
  private List<Object> mDisabledAudioSegments = null;
  @SerializedName("disabled_video_segments")
  private List<Object> mDisabledVideoSegments = null;
  @SerializedName("entire_file_issue")
  private Boolean mEntireFileIssue = null;
  @SerializedName("entire_file_issue_reasons")
  private List<String> mEntireFileIssueReasons = null;
  @SerializedName("expiration_time")
  private String mExpirationTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("media_asset_id")
  private String mMediaAssetId = null;
  @SerializedName("reasons")
  private List<String> mReasons = null;
  @SerializedName("requested_audio_segments")
  private List<Object> mRequestedAudioSegments = null;
  @SerializedName("requested_video_segments")
  private List<Object> mRequestedVideoSegments = null;
  @SerializedName("resolution_type")
  private String mResolutionType = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("update_time")
  private String mUpdateTime = null;
  @SerializedName("video_copyright")
  private VideoCopyright mVideoCopyright = null;
  @SerializedName("video_segments")
  private List<Object> mVideoSegments = null;
  protected static Gson gson = null;

  CopyrightMediaMisuse() {
  }

  public CopyrightMediaMisuse(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CopyrightMediaMisuse(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CopyrightMediaMisuse fetch() throws APIException{
    CopyrightMediaMisuse newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CopyrightMediaMisuse fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CopyrightMediaMisuse> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CopyrightMediaMisuse fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CopyrightMediaMisuse> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CopyrightMediaMisuse> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CopyrightMediaMisuse>)(
      new APIRequest<CopyrightMediaMisuse>(context, "", "/", "GET", CopyrightMediaMisuse.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CopyrightMediaMisuse>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CopyrightMediaMisuse.getParser())
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
  public static CopyrightMediaMisuse loadJSON(String json, APIContext context, String header) {
    CopyrightMediaMisuse copyrightMediaMisuse = getGson().fromJson(json, CopyrightMediaMisuse.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(copyrightMediaMisuse.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    copyrightMediaMisuse.context = context;
    copyrightMediaMisuse.rawValue = json;
    copyrightMediaMisuse.header = header;
    return copyrightMediaMisuse;
  }

  public static APINodeList<CopyrightMediaMisuse> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CopyrightMediaMisuse> copyrightMediaMisuses = new APINodeList<CopyrightMediaMisuse>(request, json, header);
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
          copyrightMediaMisuses.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return copyrightMediaMisuses;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                copyrightMediaMisuses.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            copyrightMediaMisuses.setPaging(previous, next);
            if (context.hasAppSecret()) {
              copyrightMediaMisuses.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              copyrightMediaMisuses.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  copyrightMediaMisuses.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              copyrightMediaMisuses.add(loadJSON(obj.toString(), context, header));
            }
          }
          return copyrightMediaMisuses;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              copyrightMediaMisuses.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return copyrightMediaMisuses;
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
              copyrightMediaMisuses.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return copyrightMediaMisuses;
          }

          // Sixth, check if it's pure JsonObject
          copyrightMediaMisuses.clear();
          copyrightMediaMisuses.add(loadJSON(json, context, header));
          return copyrightMediaMisuses;
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


  public List<Object> getFieldAudioSegments() {
    return mAudioSegments;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public List<Object> getFieldDisabledAudioSegments() {
    return mDisabledAudioSegments;
  }

  public List<Object> getFieldDisabledVideoSegments() {
    return mDisabledVideoSegments;
  }

  public Boolean getFieldEntireFileIssue() {
    return mEntireFileIssue;
  }

  public List<String> getFieldEntireFileIssueReasons() {
    return mEntireFileIssueReasons;
  }

  public String getFieldExpirationTime() {
    return mExpirationTime;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldMediaAssetId() {
    return mMediaAssetId;
  }

  public List<String> getFieldReasons() {
    return mReasons;
  }

  public List<Object> getFieldRequestedAudioSegments() {
    return mRequestedAudioSegments;
  }

  public List<Object> getFieldRequestedVideoSegments() {
    return mRequestedVideoSegments;
  }

  public String getFieldResolutionType() {
    return mResolutionType;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldUpdateTime() {
    return mUpdateTime;
  }

  public VideoCopyright getFieldVideoCopyright() {
    if (mVideoCopyright != null) {
      mVideoCopyright.context = getContext();
    }
    return mVideoCopyright;
  }

  public List<Object> getFieldVideoSegments() {
    return mVideoSegments;
  }



  public static class APIRequestGet extends APIRequest<CopyrightMediaMisuse> {

    CopyrightMediaMisuse lastResponse = null;
    @Override
    public CopyrightMediaMisuse getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "audio_segments",
      "creation_time",
      "disabled_audio_segments",
      "disabled_video_segments",
      "entire_file_issue",
      "entire_file_issue_reasons",
      "expiration_time",
      "id",
      "media_asset_id",
      "reasons",
      "requested_audio_segments",
      "requested_video_segments",
      "resolution_type",
      "status",
      "update_time",
      "video_copyright",
      "video_segments",
    };

    @Override
    public CopyrightMediaMisuse parseResponse(String response, String header) throws APIException {
      return CopyrightMediaMisuse.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CopyrightMediaMisuse execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CopyrightMediaMisuse execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CopyrightMediaMisuse> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CopyrightMediaMisuse> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CopyrightMediaMisuse>() {
           public CopyrightMediaMisuse apply(ResponseWrapper result) {
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

    public APIRequestGet requestAudioSegmentsField () {
      return this.requestAudioSegmentsField(true);
    }
    public APIRequestGet requestAudioSegmentsField (boolean value) {
      this.requestField("audio_segments", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestDisabledAudioSegmentsField () {
      return this.requestDisabledAudioSegmentsField(true);
    }
    public APIRequestGet requestDisabledAudioSegmentsField (boolean value) {
      this.requestField("disabled_audio_segments", value);
      return this;
    }
    public APIRequestGet requestDisabledVideoSegmentsField () {
      return this.requestDisabledVideoSegmentsField(true);
    }
    public APIRequestGet requestDisabledVideoSegmentsField (boolean value) {
      this.requestField("disabled_video_segments", value);
      return this;
    }
    public APIRequestGet requestEntireFileIssueField () {
      return this.requestEntireFileIssueField(true);
    }
    public APIRequestGet requestEntireFileIssueField (boolean value) {
      this.requestField("entire_file_issue", value);
      return this;
    }
    public APIRequestGet requestEntireFileIssueReasonsField () {
      return this.requestEntireFileIssueReasonsField(true);
    }
    public APIRequestGet requestEntireFileIssueReasonsField (boolean value) {
      this.requestField("entire_file_issue_reasons", value);
      return this;
    }
    public APIRequestGet requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGet requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestMediaAssetIdField () {
      return this.requestMediaAssetIdField(true);
    }
    public APIRequestGet requestMediaAssetIdField (boolean value) {
      this.requestField("media_asset_id", value);
      return this;
    }
    public APIRequestGet requestReasonsField () {
      return this.requestReasonsField(true);
    }
    public APIRequestGet requestReasonsField (boolean value) {
      this.requestField("reasons", value);
      return this;
    }
    public APIRequestGet requestRequestedAudioSegmentsField () {
      return this.requestRequestedAudioSegmentsField(true);
    }
    public APIRequestGet requestRequestedAudioSegmentsField (boolean value) {
      this.requestField("requested_audio_segments", value);
      return this;
    }
    public APIRequestGet requestRequestedVideoSegmentsField () {
      return this.requestRequestedVideoSegmentsField(true);
    }
    public APIRequestGet requestRequestedVideoSegmentsField (boolean value) {
      this.requestField("requested_video_segments", value);
      return this;
    }
    public APIRequestGet requestResolutionTypeField () {
      return this.requestResolutionTypeField(true);
    }
    public APIRequestGet requestResolutionTypeField (boolean value) {
      this.requestField("resolution_type", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestUpdateTimeField () {
      return this.requestUpdateTimeField(true);
    }
    public APIRequestGet requestUpdateTimeField (boolean value) {
      this.requestField("update_time", value);
      return this;
    }
    public APIRequestGet requestVideoCopyrightField () {
      return this.requestVideoCopyrightField(true);
    }
    public APIRequestGet requestVideoCopyrightField (boolean value) {
      this.requestField("video_copyright", value);
      return this;
    }
    public APIRequestGet requestVideoSegmentsField () {
      return this.requestVideoSegmentsField(true);
    }
    public APIRequestGet requestVideoSegmentsField (boolean value) {
      this.requestField("video_segments", value);
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

  public CopyrightMediaMisuse copyFrom(CopyrightMediaMisuse instance) {
    this.mAudioSegments = instance.mAudioSegments;
    this.mCreationTime = instance.mCreationTime;
    this.mDisabledAudioSegments = instance.mDisabledAudioSegments;
    this.mDisabledVideoSegments = instance.mDisabledVideoSegments;
    this.mEntireFileIssue = instance.mEntireFileIssue;
    this.mEntireFileIssueReasons = instance.mEntireFileIssueReasons;
    this.mExpirationTime = instance.mExpirationTime;
    this.mId = instance.mId;
    this.mMediaAssetId = instance.mMediaAssetId;
    this.mReasons = instance.mReasons;
    this.mRequestedAudioSegments = instance.mRequestedAudioSegments;
    this.mRequestedVideoSegments = instance.mRequestedVideoSegments;
    this.mResolutionType = instance.mResolutionType;
    this.mStatus = instance.mStatus;
    this.mUpdateTime = instance.mUpdateTime;
    this.mVideoCopyright = instance.mVideoCopyright;
    this.mVideoSegments = instance.mVideoSegments;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CopyrightMediaMisuse> getParser() {
    return new APIRequest.ResponseParser<CopyrightMediaMisuse>() {
      public APINodeList<CopyrightMediaMisuse> parseResponse(String response, APIContext context, APIRequest<CopyrightMediaMisuse> request, String header) throws MalformedResponseException {
        return CopyrightMediaMisuse.parseResponse(response, context, request, header);
      }
    };
  }
}
