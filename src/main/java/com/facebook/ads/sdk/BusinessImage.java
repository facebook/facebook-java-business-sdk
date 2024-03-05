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
public class BusinessImage extends APINode {
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("hash")
  private String mHash = null;
  @SerializedName("height")
  private Long mHeight = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("media_library_url")
  private String mMediaLibraryUrl = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("url_128")
  private String mUrl128 = null;
  @SerializedName("width")
  private Long mWidth = null;
  protected static Gson gson = null;

  BusinessImage() {
  }

  public BusinessImage(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public BusinessImage(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public BusinessImage fetch() throws APIException{
    BusinessImage newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static BusinessImage fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<BusinessImage> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static BusinessImage fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<BusinessImage> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<BusinessImage> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<BusinessImage>)(
      new APIRequest<BusinessImage>(context, "", "/", "GET", BusinessImage.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<BusinessImage>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", BusinessImage.getParser())
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
  public static BusinessImage loadJSON(String json, APIContext context, String header) {
    BusinessImage businessImage = getGson().fromJson(json, BusinessImage.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(businessImage.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    businessImage.context = context;
    businessImage.rawValue = json;
    businessImage.header = header;
    return businessImage;
  }

  public static APINodeList<BusinessImage> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BusinessImage> businessImages = new APINodeList<BusinessImage>(request, json, header);
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
          businessImages.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return businessImages;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                businessImages.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            businessImages.setPaging(previous, next);
            if (context.hasAppSecret()) {
              businessImages.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businessImages.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  businessImages.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              businessImages.add(loadJSON(obj.toString(), context, header));
            }
          }
          return businessImages;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businessImages.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return businessImages;
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
              businessImages.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return businessImages;
          }

          // Sixth, check if it's pure JsonObject
          businessImages.clear();
          businessImages.add(loadJSON(json, context, header));
          return businessImages;
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


  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldHash() {
    return mHash;
  }

  public Long getFieldHeight() {
    return mHeight;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldMediaLibraryUrl() {
    return mMediaLibraryUrl;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public String getFieldUrl128() {
    return mUrl128;
  }

  public Long getFieldWidth() {
    return mWidth;
  }



  public static class APIRequestGet extends APIRequest<BusinessImage> {

    BusinessImage lastResponse = null;
    @Override
    public BusinessImage getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "creation_time",
      "hash",
      "height",
      "id",
      "media_library_url",
      "name",
      "url",
      "url_128",
      "width",
    };

    @Override
    public BusinessImage parseResponse(String response, String header) throws APIException {
      return BusinessImage.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public BusinessImage execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessImage execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<BusinessImage> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessImage> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, BusinessImage>() {
           public BusinessImage apply(ResponseWrapper result) {
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

    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestHashField () {
      return this.requestHashField(true);
    }
    public APIRequestGet requestHashField (boolean value) {
      this.requestField("hash", value);
      return this;
    }
    public APIRequestGet requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGet requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestMediaLibraryUrlField () {
      return this.requestMediaLibraryUrlField(true);
    }
    public APIRequestGet requestMediaLibraryUrlField (boolean value) {
      this.requestField("media_library_url", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGet requestUrl128Field () {
      return this.requestUrl128Field(true);
    }
    public APIRequestGet requestUrl128Field (boolean value) {
      this.requestField("url_128", value);
      return this;
    }
    public APIRequestGet requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGet requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
  }

  public static enum EnumValidationAdPlacements {
      @SerializedName("AUDIENCE_NETWORK_INSTREAM_VIDEO")
      VALUE_AUDIENCE_NETWORK_INSTREAM_VIDEO("AUDIENCE_NETWORK_INSTREAM_VIDEO"),
      @SerializedName("AUDIENCE_NETWORK_INSTREAM_VIDEO_MOBILE")
      VALUE_AUDIENCE_NETWORK_INSTREAM_VIDEO_MOBILE("AUDIENCE_NETWORK_INSTREAM_VIDEO_MOBILE"),
      @SerializedName("AUDIENCE_NETWORK_REWARDED_VIDEO")
      VALUE_AUDIENCE_NETWORK_REWARDED_VIDEO("AUDIENCE_NETWORK_REWARDED_VIDEO"),
      @SerializedName("DESKTOP_FEED_STANDARD")
      VALUE_DESKTOP_FEED_STANDARD("DESKTOP_FEED_STANDARD"),
      @SerializedName("FACEBOOK_STORY_MOBILE")
      VALUE_FACEBOOK_STORY_MOBILE("FACEBOOK_STORY_MOBILE"),
      @SerializedName("FACEBOOK_STORY_STICKER_MOBILE")
      VALUE_FACEBOOK_STORY_STICKER_MOBILE("FACEBOOK_STORY_STICKER_MOBILE"),
      @SerializedName("INSTAGRAM_STANDARD")
      VALUE_INSTAGRAM_STANDARD("INSTAGRAM_STANDARD"),
      @SerializedName("INSTAGRAM_STORY")
      VALUE_INSTAGRAM_STORY("INSTAGRAM_STORY"),
      @SerializedName("INSTANT_ARTICLE_STANDARD")
      VALUE_INSTANT_ARTICLE_STANDARD("INSTANT_ARTICLE_STANDARD"),
      @SerializedName("INSTREAM_BANNER_DESKTOP")
      VALUE_INSTREAM_BANNER_DESKTOP("INSTREAM_BANNER_DESKTOP"),
      @SerializedName("INSTREAM_BANNER_MOBILE")
      VALUE_INSTREAM_BANNER_MOBILE("INSTREAM_BANNER_MOBILE"),
      @SerializedName("INSTREAM_VIDEO_DESKTOP")
      VALUE_INSTREAM_VIDEO_DESKTOP("INSTREAM_VIDEO_DESKTOP"),
      @SerializedName("INSTREAM_VIDEO_IMAGE")
      VALUE_INSTREAM_VIDEO_IMAGE("INSTREAM_VIDEO_IMAGE"),
      @SerializedName("INSTREAM_VIDEO_MOBILE")
      VALUE_INSTREAM_VIDEO_MOBILE("INSTREAM_VIDEO_MOBILE"),
      @SerializedName("MESSENGER_MOBILE_INBOX_MEDIA")
      VALUE_MESSENGER_MOBILE_INBOX_MEDIA("MESSENGER_MOBILE_INBOX_MEDIA"),
      @SerializedName("MESSENGER_MOBILE_STORY_MEDIA")
      VALUE_MESSENGER_MOBILE_STORY_MEDIA("MESSENGER_MOBILE_STORY_MEDIA"),
      @SerializedName("MOBILE_FEED_STANDARD")
      VALUE_MOBILE_FEED_STANDARD("MOBILE_FEED_STANDARD"),
      @SerializedName("MOBILE_FULLWIDTH")
      VALUE_MOBILE_FULLWIDTH("MOBILE_FULLWIDTH"),
      @SerializedName("MOBILE_INTERSTITIAL")
      VALUE_MOBILE_INTERSTITIAL("MOBILE_INTERSTITIAL"),
      @SerializedName("MOBILE_MEDIUM_RECTANGLE")
      VALUE_MOBILE_MEDIUM_RECTANGLE("MOBILE_MEDIUM_RECTANGLE"),
      @SerializedName("MOBILE_NATIVE")
      VALUE_MOBILE_NATIVE("MOBILE_NATIVE"),
      @SerializedName("RIGHT_COLUMN_STANDARD")
      VALUE_RIGHT_COLUMN_STANDARD("RIGHT_COLUMN_STANDARD"),
      @SerializedName("SUGGESTED_VIDEO_MOBILE")
      VALUE_SUGGESTED_VIDEO_MOBILE("SUGGESTED_VIDEO_MOBILE"),
      ;

      private String value;

      private EnumValidationAdPlacements(String value) {
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

  public BusinessImage copyFrom(BusinessImage instance) {
    this.mBusiness = instance.mBusiness;
    this.mCreationTime = instance.mCreationTime;
    this.mHash = instance.mHash;
    this.mHeight = instance.mHeight;
    this.mId = instance.mId;
    this.mMediaLibraryUrl = instance.mMediaLibraryUrl;
    this.mName = instance.mName;
    this.mUrl = instance.mUrl;
    this.mUrl128 = instance.mUrl128;
    this.mWidth = instance.mWidth;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BusinessImage> getParser() {
    return new APIRequest.ResponseParser<BusinessImage>() {
      public APINodeList<BusinessImage> parseResponse(String response, APIContext context, APIRequest<BusinessImage> request, String header) throws MalformedResponseException {
        return BusinessImage.parseResponse(response, context, request, header);
      }
    };
  }
}
