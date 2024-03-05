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
public class MediaFingerprint extends APINode {
  @SerializedName("duration_in_sec")
  private Double mDurationInSec = null;
  @SerializedName("fingerprint_content_type")
  private String mFingerprintContentType = null;
  @SerializedName("fingerprint_type")
  private String mFingerprintType = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("metadata")
  private Object mMetadata = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("universal_content_id")
  private String mUniversalContentId = null;
  protected static Gson gson = null;

  MediaFingerprint() {
  }

  public MediaFingerprint(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public MediaFingerprint(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public MediaFingerprint fetch() throws APIException{
    MediaFingerprint newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static MediaFingerprint fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<MediaFingerprint> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static MediaFingerprint fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<MediaFingerprint> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<MediaFingerprint> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<MediaFingerprint>)(
      new APIRequest<MediaFingerprint>(context, "", "/", "GET", MediaFingerprint.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<MediaFingerprint>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", MediaFingerprint.getParser())
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
  public static MediaFingerprint loadJSON(String json, APIContext context, String header) {
    MediaFingerprint mediaFingerprint = getGson().fromJson(json, MediaFingerprint.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(mediaFingerprint.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    mediaFingerprint.context = context;
    mediaFingerprint.rawValue = json;
    mediaFingerprint.header = header;
    return mediaFingerprint;
  }

  public static APINodeList<MediaFingerprint> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<MediaFingerprint> mediaFingerprints = new APINodeList<MediaFingerprint>(request, json, header);
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
          mediaFingerprints.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return mediaFingerprints;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                mediaFingerprints.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            mediaFingerprints.setPaging(previous, next);
            if (context.hasAppSecret()) {
              mediaFingerprints.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              mediaFingerprints.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  mediaFingerprints.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              mediaFingerprints.add(loadJSON(obj.toString(), context, header));
            }
          }
          return mediaFingerprints;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              mediaFingerprints.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return mediaFingerprints;
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
              mediaFingerprints.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return mediaFingerprints;
          }

          // Sixth, check if it's pure JsonObject
          mediaFingerprints.clear();
          mediaFingerprints.add(loadJSON(json, context, header));
          return mediaFingerprints;
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

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public Double getFieldDurationInSec() {
    return mDurationInSec;
  }

  public String getFieldFingerprintContentType() {
    return mFingerprintContentType;
  }

  public String getFieldFingerprintType() {
    return mFingerprintType;
  }

  public String getFieldId() {
    return mId;
  }

  public Object getFieldMetadata() {
    return mMetadata;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public String getFieldUniversalContentId() {
    return mUniversalContentId;
  }



  public static class APIRequestGet extends APIRequest<MediaFingerprint> {

    MediaFingerprint lastResponse = null;
    @Override
    public MediaFingerprint getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "duration_in_sec",
      "fingerprint_content_type",
      "fingerprint_type",
      "id",
      "metadata",
      "title",
      "universal_content_id",
    };

    @Override
    public MediaFingerprint parseResponse(String response, String header) throws APIException {
      return MediaFingerprint.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public MediaFingerprint execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MediaFingerprint execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<MediaFingerprint> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MediaFingerprint> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, MediaFingerprint>() {
           public MediaFingerprint apply(ResponseWrapper result) {
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

    public APIRequestGet requestDurationInSecField () {
      return this.requestDurationInSecField(true);
    }
    public APIRequestGet requestDurationInSecField (boolean value) {
      this.requestField("duration_in_sec", value);
      return this;
    }
    public APIRequestGet requestFingerprintContentTypeField () {
      return this.requestFingerprintContentTypeField(true);
    }
    public APIRequestGet requestFingerprintContentTypeField (boolean value) {
      this.requestField("fingerprint_content_type", value);
      return this;
    }
    public APIRequestGet requestFingerprintTypeField () {
      return this.requestFingerprintTypeField(true);
    }
    public APIRequestGet requestFingerprintTypeField (boolean value) {
      this.requestField("fingerprint_type", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestMetadataField () {
      return this.requestMetadataField(true);
    }
    public APIRequestGet requestMetadataField (boolean value) {
      this.requestField("metadata", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestUniversalContentIdField () {
      return this.requestUniversalContentIdField(true);
    }
    public APIRequestGet requestUniversalContentIdField (boolean value) {
      this.requestField("universal_content_id", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<MediaFingerprint> {

    MediaFingerprint lastResponse = null;
    @Override
    public MediaFingerprint getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "metadata",
      "source",
      "title",
      "universal_content_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public MediaFingerprint parseResponse(String response, String header) throws APIException {
      return MediaFingerprint.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public MediaFingerprint execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MediaFingerprint execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<MediaFingerprint> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MediaFingerprint> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, MediaFingerprint>() {
           public MediaFingerprint apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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


    public APIRequestUpdate setMetadata (JsonArray metadata) {
      this.setParam("metadata", metadata);
      return this;
    }
    public APIRequestUpdate setMetadata (String metadata) {
      this.setParam("metadata", metadata);
      return this;
    }

    public APIRequestUpdate setSource (File source) {
      this.setParam("source", source);
      return this;
    }
    public APIRequestUpdate setSource (String source) {
      this.setParam("source", source);
      return this;
    }

    public APIRequestUpdate setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestUpdate setUniversalContentId (String universalContentId) {
      this.setParam("universal_content_id", universalContentId);
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

  public static enum EnumFingerprintContentType {
      @SerializedName("AM_SONGTRACK")
      VALUE_AM_SONGTRACK("AM_SONGTRACK"),
      @SerializedName("EPISODE")
      VALUE_EPISODE("EPISODE"),
      @SerializedName("MOVIE")
      VALUE_MOVIE("MOVIE"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("SONGTRACK")
      VALUE_SONGTRACK("SONGTRACK"),
      ;

      private String value;

      private EnumFingerprintContentType(String value) {
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

  public MediaFingerprint copyFrom(MediaFingerprint instance) {
    this.mDurationInSec = instance.mDurationInSec;
    this.mFingerprintContentType = instance.mFingerprintContentType;
    this.mFingerprintType = instance.mFingerprintType;
    this.mId = instance.mId;
    this.mMetadata = instance.mMetadata;
    this.mTitle = instance.mTitle;
    this.mUniversalContentId = instance.mUniversalContentId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MediaFingerprint> getParser() {
    return new APIRequest.ResponseParser<MediaFingerprint>() {
      public APINodeList<MediaFingerprint> parseResponse(String response, APIContext context, APIRequest<MediaFingerprint> request, String header) throws MalformedResponseException {
        return MediaFingerprint.parseResponse(response, context, request, header);
      }
    };
  }
}
