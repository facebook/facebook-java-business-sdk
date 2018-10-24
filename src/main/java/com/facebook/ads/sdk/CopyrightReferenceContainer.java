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
public class CopyrightReferenceContainer extends APINode {
  @SerializedName("content_type")
  private String mContentType = null;
  @SerializedName("copyright_creation_time")
  private String mCopyrightCreationTime = null;
  @SerializedName("download_hd_url")
  private String mDownloadHdUrl = null;
  @SerializedName("duration_in_sec")
  private Double mDurationInSec = null;
  @SerializedName("fingerprint_validity")
  private String mFingerprintValidity = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("metadata")
  private Object mMetadata = null;
  @SerializedName("published_time")
  private String mPublishedTime = null;
  @SerializedName("thumbnail_url")
  private String mThumbnailUrl = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("universal_content_id")
  private String mUniversalContentId = null;
  protected static Gson gson = null;

  CopyrightReferenceContainer() {
  }

  public CopyrightReferenceContainer(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CopyrightReferenceContainer(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CopyrightReferenceContainer fetch() throws APIException{
    CopyrightReferenceContainer newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CopyrightReferenceContainer fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CopyrightReferenceContainer> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CopyrightReferenceContainer fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CopyrightReferenceContainer> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CopyrightReferenceContainer> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CopyrightReferenceContainer>)(
      new APIRequest<CopyrightReferenceContainer>(context, "", "/", "GET", CopyrightReferenceContainer.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CopyrightReferenceContainer>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CopyrightReferenceContainer.getParser())
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
  public static CopyrightReferenceContainer loadJSON(String json, APIContext context) {
    CopyrightReferenceContainer copyrightReferenceContainer = getGson().fromJson(json, CopyrightReferenceContainer.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(copyrightReferenceContainer.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    copyrightReferenceContainer.context = context;
    copyrightReferenceContainer.rawValue = json;
    return copyrightReferenceContainer;
  }

  public static APINodeList<CopyrightReferenceContainer> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<CopyrightReferenceContainer> copyrightReferenceContainers = new APINodeList<CopyrightReferenceContainer>(request, json);
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
          copyrightReferenceContainers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return copyrightReferenceContainers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                copyrightReferenceContainers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            copyrightReferenceContainers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              copyrightReferenceContainers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              copyrightReferenceContainers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  copyrightReferenceContainers.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              copyrightReferenceContainers.add(loadJSON(obj.toString(), context));
            }
          }
          return copyrightReferenceContainers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              copyrightReferenceContainers.add(loadJSON(entry.getValue().toString(), context));
          }
          return copyrightReferenceContainers;
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
              copyrightReferenceContainers.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return copyrightReferenceContainers;
          }

          // Sixth, check if it's pure JsonObject
          copyrightReferenceContainers.clear();
          copyrightReferenceContainers.add(loadJSON(json, context));
          return copyrightReferenceContainers;
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


  public String getFieldContentType() {
    return mContentType;
  }

  public String getFieldCopyrightCreationTime() {
    return mCopyrightCreationTime;
  }

  public String getFieldDownloadHdUrl() {
    return mDownloadHdUrl;
  }

  public Double getFieldDurationInSec() {
    return mDurationInSec;
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

  public String getFieldPublishedTime() {
    return mPublishedTime;
  }

  public String getFieldThumbnailUrl() {
    return mThumbnailUrl;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public String getFieldUniversalContentId() {
    return mUniversalContentId;
  }



  public static class APIRequestGet extends APIRequest<CopyrightReferenceContainer> {

    CopyrightReferenceContainer lastResponse = null;
    @Override
    public CopyrightReferenceContainer getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "content_type",
      "copyright_creation_time",
      "download_hd_url",
      "duration_in_sec",
      "fingerprint_validity",
      "id",
      "metadata",
      "published_time",
      "thumbnail_url",
      "title",
      "universal_content_id",
    };

    @Override
    public CopyrightReferenceContainer parseResponse(String response) throws APIException {
      return CopyrightReferenceContainer.parseResponse(response, getContext(), this).head();
    }

    @Override
    public CopyrightReferenceContainer execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CopyrightReferenceContainer execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<CopyrightReferenceContainer> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CopyrightReferenceContainer> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, CopyrightReferenceContainer>() {
           public CopyrightReferenceContainer apply(String result) {
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

    public APIRequestGet requestContentTypeField () {
      return this.requestContentTypeField(true);
    }
    public APIRequestGet requestContentTypeField (boolean value) {
      this.requestField("content_type", value);
      return this;
    }
    public APIRequestGet requestCopyrightCreationTimeField () {
      return this.requestCopyrightCreationTimeField(true);
    }
    public APIRequestGet requestCopyrightCreationTimeField (boolean value) {
      this.requestField("copyright_creation_time", value);
      return this;
    }
    public APIRequestGet requestDownloadHdUrlField () {
      return this.requestDownloadHdUrlField(true);
    }
    public APIRequestGet requestDownloadHdUrlField (boolean value) {
      this.requestField("download_hd_url", value);
      return this;
    }
    public APIRequestGet requestDurationInSecField () {
      return this.requestDurationInSecField(true);
    }
    public APIRequestGet requestDurationInSecField (boolean value) {
      this.requestField("duration_in_sec", value);
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
    public APIRequestGet requestPublishedTimeField () {
      return this.requestPublishedTimeField(true);
    }
    public APIRequestGet requestPublishedTimeField (boolean value) {
      this.requestField("published_time", value);
      return this;
    }
    public APIRequestGet requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGet requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
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

  public CopyrightReferenceContainer copyFrom(CopyrightReferenceContainer instance) {
    this.mContentType = instance.mContentType;
    this.mCopyrightCreationTime = instance.mCopyrightCreationTime;
    this.mDownloadHdUrl = instance.mDownloadHdUrl;
    this.mDurationInSec = instance.mDurationInSec;
    this.mFingerprintValidity = instance.mFingerprintValidity;
    this.mId = instance.mId;
    this.mMetadata = instance.mMetadata;
    this.mPublishedTime = instance.mPublishedTime;
    this.mThumbnailUrl = instance.mThumbnailUrl;
    this.mTitle = instance.mTitle;
    this.mUniversalContentId = instance.mUniversalContentId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CopyrightReferenceContainer> getParser() {
    return new APIRequest.ResponseParser<CopyrightReferenceContainer>() {
      public APINodeList<CopyrightReferenceContainer> parseResponse(String response, APIContext context, APIRequest<CopyrightReferenceContainer> request) throws MalformedResponseException {
        return CopyrightReferenceContainer.parseResponse(response, context, request);
      }
    };
  }
}
