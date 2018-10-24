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
public class MediaFingerprint extends APINode {
  @SerializedName("duration_in_sec")
  private Double mDurationInSec = null;
  @SerializedName("expiration_time")
  private String mExpirationTime = null;
  @SerializedName("fingerprint_content_type")
  private String mFingerprintContentType = null;
  @SerializedName("fingerprint_type")
  private String mFingerprintType = null;
  @SerializedName("fingerprint_validity")
  private String mFingerprintValidity = null;
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
  public static MediaFingerprint loadJSON(String json, APIContext context) {
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
      };
    }
    mediaFingerprint.context = context;
    mediaFingerprint.rawValue = json;
    return mediaFingerprint;
  }

  public static APINodeList<MediaFingerprint> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<MediaFingerprint> mediaFingerprints = new APINodeList<MediaFingerprint>(request, json);
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
          mediaFingerprints.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
              mediaFingerprints.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  mediaFingerprints.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              mediaFingerprints.add(loadJSON(obj.toString(), context));
            }
          }
          return mediaFingerprints;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              mediaFingerprints.add(loadJSON(entry.getValue().toString(), context));
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
              mediaFingerprints.add(loadJSON(value.toString(), context));
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
          mediaFingerprints.add(loadJSON(json, context));
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

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
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

  public String getFieldExpirationTime() {
    return mExpirationTime;
  }

  public String getFieldFingerprintContentType() {
    return mFingerprintContentType;
  }

  public String getFieldFingerprintType() {
    return mFingerprintType;
  }

  public String getFieldFingerprintValidity() {
    return mFingerprintValidity;
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
      "expiration_time",
      "fingerprint_content_type",
      "fingerprint_type",
      "fingerprint_validity",
      "id",
      "metadata",
      "title",
      "universal_content_id",
    };

    @Override
    public MediaFingerprint parseResponse(String response) throws APIException {
      return MediaFingerprint.parseResponse(response, getContext(), this).head();
    }

    @Override
    public MediaFingerprint execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MediaFingerprint execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<MediaFingerprint> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MediaFingerprint> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, MediaFingerprint>() {
           public MediaFingerprint apply(String result) {
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

    public APIRequestGet requestDurationInSecField () {
      return this.requestDurationInSecField(true);
    }
    public APIRequestGet requestDurationInSecField (boolean value) {
      this.requestField("duration_in_sec", value);
      return this;
    }
    public APIRequestGet requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGet requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
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
    public APIRequestGet requestFingerprintValidityField () {
      return this.requestFingerprintValidityField(true);
    }
    public APIRequestGet requestFingerprintValidityField (boolean value) {
      this.requestField("fingerprint_validity", value);
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
      "title",
      "metadata",
      "universal_content_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public MediaFingerprint parseResponse(String response) throws APIException {
      return MediaFingerprint.parseResponse(response, getContext(), this).head();
    }

    @Override
    public MediaFingerprint execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MediaFingerprint execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<MediaFingerprint> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MediaFingerprint> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, MediaFingerprint>() {
           public MediaFingerprint apply(String result) {
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


    public APIRequestUpdate setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestUpdate setMetadata (Object metadata) {
      this.setParam("metadata", metadata);
      return this;
    }
    public APIRequestUpdate setMetadata (String metadata) {
      this.setParam("metadata", metadata);
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
      @SerializedName("SONGTRACK")
      VALUE_SONGTRACK("SONGTRACK"),
      @SerializedName("EPISODE")
      VALUE_EPISODE("EPISODE"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("MOVIE")
      VALUE_MOVIE("MOVIE"),
      @SerializedName("AM_SONGTRACK")
      VALUE_AM_SONGTRACK("AM_SONGTRACK"),
      NULL(null);

      private String value;

      private EnumFingerprintContentType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumFingerprintValidity {
      @SerializedName("VALID")
      VALUE_VALID("VALID"),
      @SerializedName("EXPIRING")
      VALUE_EXPIRING("EXPIRING"),
      @SerializedName("EXPIRED")
      VALUE_EXPIRED("EXPIRED"),
      NULL(null);

      private String value;

      private EnumFingerprintValidity(String value) {
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
    this.mExpirationTime = instance.mExpirationTime;
    this.mFingerprintContentType = instance.mFingerprintContentType;
    this.mFingerprintType = instance.mFingerprintType;
    this.mFingerprintValidity = instance.mFingerprintValidity;
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
      public APINodeList<MediaFingerprint> parseResponse(String response, APIContext context, APIRequest<MediaFingerprint> request) throws MalformedResponseException {
        return MediaFingerprint.parseResponse(response, context, request);
      }
    };
  }
}
