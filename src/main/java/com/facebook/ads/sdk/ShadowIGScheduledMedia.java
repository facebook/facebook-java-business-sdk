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
public class ShadowIGScheduledMedia extends APINode {
  @SerializedName("caption")
  private String mCaption = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("media_type")
  private String mMediaType = null;
  @SerializedName("media_url")
  private String mMediaUrl = null;
  @SerializedName("publish_timestamp")
  private Long mPublishTimestamp = null;
  @SerializedName("thumbnail_url")
  private String mThumbnailUrl = null;
  protected static Gson gson = null;

  ShadowIGScheduledMedia() {
  }

  public ShadowIGScheduledMedia(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ShadowIGScheduledMedia(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ShadowIGScheduledMedia fetch() throws APIException{
    ShadowIGScheduledMedia newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ShadowIGScheduledMedia fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ShadowIGScheduledMedia> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ShadowIGScheduledMedia fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ShadowIGScheduledMedia> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ShadowIGScheduledMedia> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ShadowIGScheduledMedia>)(
      new APIRequest<ShadowIGScheduledMedia>(context, "", "/", "GET", ShadowIGScheduledMedia.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ShadowIGScheduledMedia>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ShadowIGScheduledMedia.getParser())
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
  public static ShadowIGScheduledMedia loadJSON(String json, APIContext context, String header) {
    ShadowIGScheduledMedia shadowIGScheduledMedia = getGson().fromJson(json, ShadowIGScheduledMedia.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(shadowIGScheduledMedia.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    shadowIGScheduledMedia.context = context;
    shadowIGScheduledMedia.rawValue = json;
    shadowIGScheduledMedia.header = header;
    return shadowIGScheduledMedia;
  }

  public static APINodeList<ShadowIGScheduledMedia> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ShadowIGScheduledMedia> shadowIGScheduledMedias = new APINodeList<ShadowIGScheduledMedia>(request, json, header);
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
          shadowIGScheduledMedias.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return shadowIGScheduledMedias;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                shadowIGScheduledMedias.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            shadowIGScheduledMedias.setPaging(previous, next);
            if (context.hasAppSecret()) {
              shadowIGScheduledMedias.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              shadowIGScheduledMedias.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  shadowIGScheduledMedias.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              shadowIGScheduledMedias.add(loadJSON(obj.toString(), context, header));
            }
          }
          return shadowIGScheduledMedias;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              shadowIGScheduledMedias.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return shadowIGScheduledMedias;
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
              shadowIGScheduledMedias.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return shadowIGScheduledMedias;
          }

          // Sixth, check if it's pure JsonObject
          shadowIGScheduledMedias.clear();
          shadowIGScheduledMedias.add(loadJSON(json, context, header));
          return shadowIGScheduledMedias;
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


  public String getFieldCaption() {
    return mCaption;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldMediaType() {
    return mMediaType;
  }

  public String getFieldMediaUrl() {
    return mMediaUrl;
  }

  public Long getFieldPublishTimestamp() {
    return mPublishTimestamp;
  }

  public String getFieldThumbnailUrl() {
    return mThumbnailUrl;
  }



  public static class APIRequestGet extends APIRequest<ShadowIGScheduledMedia> {

    ShadowIGScheduledMedia lastResponse = null;
    @Override
    public ShadowIGScheduledMedia getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "caption",
      "id",
      "media_type",
      "media_url",
      "publish_timestamp",
      "thumbnail_url",
    };

    @Override
    public ShadowIGScheduledMedia parseResponse(String response, String header) throws APIException {
      return ShadowIGScheduledMedia.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ShadowIGScheduledMedia execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ShadowIGScheduledMedia execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ShadowIGScheduledMedia> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ShadowIGScheduledMedia> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ShadowIGScheduledMedia>() {
           public ShadowIGScheduledMedia apply(ResponseWrapper result) {
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

    public APIRequestGet requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGet requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGet requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGet requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGet requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGet requestPublishTimestampField () {
      return this.requestPublishTimestampField(true);
    }
    public APIRequestGet requestPublishTimestampField (boolean value) {
      this.requestField("publish_timestamp", value);
      return this;
    }
    public APIRequestGet requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGet requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
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

  public ShadowIGScheduledMedia copyFrom(ShadowIGScheduledMedia instance) {
    this.mCaption = instance.mCaption;
    this.mId = instance.mId;
    this.mMediaType = instance.mMediaType;
    this.mMediaUrl = instance.mMediaUrl;
    this.mPublishTimestamp = instance.mPublishTimestamp;
    this.mThumbnailUrl = instance.mThumbnailUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ShadowIGScheduledMedia> getParser() {
    return new APIRequest.ResponseParser<ShadowIGScheduledMedia>() {
      public APINodeList<ShadowIGScheduledMedia> parseResponse(String response, APIContext context, APIRequest<ShadowIGScheduledMedia> request, String header) throws MalformedResponseException {
        return ShadowIGScheduledMedia.parseResponse(response, context, request, header);
      }
    };
  }
}
