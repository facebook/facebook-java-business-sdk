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
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class AdImage extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("creatives")
  private List<String> mCreatives = null;
  @SerializedName("hash")
  private String mHash = null;
  @SerializedName("height")
  private Long mHeight = null;
  @SerializedName("original_height")
  private Long mOriginalHeight = null;
  @SerializedName("original_width")
  private Long mOriginalWidth = null;
  @SerializedName("permalink_url")
  private String mPermalinkUrl = null;
  @SerializedName("status")
  private EnumStatus mStatus = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("url_128")
  private String mUrl128 = null;
  @SerializedName("width")
  private Long mWidth = null;
  protected static Gson gson = null;

  AdImage() {
  }

  public AdImage(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdImage(String id, APIContext context) {
    this.mId = id;
    this.mContext = context;
  }

  public AdImage fetch() throws APIException{
    AdImage newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdImage fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static AdImage fetchById(String id, APIContext context) throws APIException {
    AdImage adImage =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return adImage;
  }

  private String getPrefixedId() {
    return mId.toString();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdImage loadJSON(String json, APIContext context) {
    AdImage adImage = getGson().fromJson(json, AdImage.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adImage.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adImage.mContext = context;
    adImage.rawValue = json;
    return adImage;
  }

  public static APINodeList<AdImage> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<AdImage> adImages = new APINodeList<AdImage>(request, json);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adImages.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adImages;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            adImages.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adImages.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            adImages.add(loadJSON(obj.toString(), context));
          }
          return adImages;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adImages.add(loadJSON(entry.getValue().toString(), context));
          }
          return adImages;
        } else {
          // Fifth, check if it's pure JsonObject
          adImages.add(loadJSON(json, context));
          return adImages;
        }
      }
    } catch (Exception e) {
    }
    return null;
  }

  @Override
  public APIContext getContext() {
    return mContext;
  }

  @Override
  public void setContext(APIContext context) {
    mContext = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), mContext);
  }


  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldAccountId() {
    return mAccountId;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public List<String> getFieldCreatives() {
    return mCreatives;
  }

  public String getFieldHash() {
    return mHash;
  }

  public Long getFieldHeight() {
    return mHeight;
  }

  public Long getFieldOriginalHeight() {
    return mOriginalHeight;
  }

  public Long getFieldOriginalWidth() {
    return mOriginalWidth;
  }

  public String getFieldPermalinkUrl() {
    return mPermalinkUrl;
  }

  public EnumStatus getFieldStatus() {
    return mStatus;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
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



  public static class APIRequestGet extends APIRequest<AdImage> {

    AdImage lastResponse = null;
    @Override
    public AdImage getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "account_id",
      "created_time",
      "creatives",
      "hash",
      "height",
      "original_height",
      "original_width",
      "permalink_url",
      "status",
      "updated_time",
      "url",
      "url_128",
      "width",
    };

    @Override
    public AdImage parseResponse(String response) throws APIException {
      return AdImage.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdImage execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdImage execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestCreativesField () {
      return this.requestCreativesField(true);
    }
    public APIRequestGet requestCreativesField (boolean value) {
      this.requestField("creatives", value);
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
    public APIRequestGet requestOriginalHeightField () {
      return this.requestOriginalHeightField(true);
    }
    public APIRequestGet requestOriginalHeightField (boolean value) {
      this.requestField("original_height", value);
      return this;
    }
    public APIRequestGet requestOriginalWidthField () {
      return this.requestOriginalWidthField(true);
    }
    public APIRequestGet requestOriginalWidthField (boolean value) {
      this.requestField("original_width", value);
      return this;
    }
    public APIRequestGet requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGet requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
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

  public static enum EnumStatus {
    @SerializedName("ACTIVE")
    VALUE_ACTIVE("ACTIVE"),
    @SerializedName("DELETED")
    VALUE_DELETED("DELETED"),
    NULL(null);

    private String value;

    private EnumStatus(String value) {
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

  public AdImage copyFrom(AdImage instance) {
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mAccountId = instance.mAccountId;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCreatives = instance.mCreatives;
    this.mHash = instance.mHash;
    this.mHeight = instance.mHeight;
    this.mOriginalHeight = instance.mOriginalHeight;
    this.mOriginalWidth = instance.mOriginalWidth;
    this.mPermalinkUrl = instance.mPermalinkUrl;
    this.mStatus = instance.mStatus;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mUrl = instance.mUrl;
    this.mUrl128 = instance.mUrl128;
    this.mWidth = instance.mWidth;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdImage> getParser() {
    return new APIRequest.ResponseParser<AdImage>() {
      public APINodeList<AdImage> parseResponse(String response, APIContext context, APIRequest<AdImage> request) {
        return AdImage.parseResponse(response, context, request);
      }
    };
  }
}