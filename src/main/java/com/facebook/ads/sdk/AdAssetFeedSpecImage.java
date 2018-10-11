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
public class AdAssetFeedSpecImage extends APINode {
  @SerializedName("adlabels")
  private List<AdAssetFeedSpecAssetLabel> mAdlabels = null;
  @SerializedName("hash")
  private String mHash = null;
  @SerializedName("image_crops")
  private AdsImageCrops mImageCrops = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("url_tags")
  private String mUrlTags = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdAssetFeedSpecImage() {
  }

  public AdAssetFeedSpecImage(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAssetFeedSpecImage(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdAssetFeedSpecImage fetch() throws APIException{
    AdAssetFeedSpecImage newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdAssetFeedSpecImage fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdAssetFeedSpecImage> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdAssetFeedSpecImage fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdAssetFeedSpecImage> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdAssetFeedSpecImage> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdAssetFeedSpecImage>)(
      new APIRequest<AdAssetFeedSpecImage>(context, "", "/", "GET", AdAssetFeedSpecImage.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdAssetFeedSpecImage>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdAssetFeedSpecImage.getParser())
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
  public static AdAssetFeedSpecImage loadJSON(String json, APIContext context) {
    AdAssetFeedSpecImage adAssetFeedSpecImage = getGson().fromJson(json, AdAssetFeedSpecImage.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAssetFeedSpecImage.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAssetFeedSpecImage.context = context;
    adAssetFeedSpecImage.rawValue = json;
    return adAssetFeedSpecImage;
  }

  public static APINodeList<AdAssetFeedSpecImage> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdAssetFeedSpecImage> adAssetFeedSpecImages = new APINodeList<AdAssetFeedSpecImage>(request, json);
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
          adAssetFeedSpecImages.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adAssetFeedSpecImages;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAssetFeedSpecImages.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAssetFeedSpecImages.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAssetFeedSpecImages.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAssetFeedSpecImages.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adAssetFeedSpecImages.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAssetFeedSpecImages.add(loadJSON(obj.toString(), context));
            }
          }
          return adAssetFeedSpecImages;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAssetFeedSpecImages.add(loadJSON(entry.getValue().toString(), context));
          }
          return adAssetFeedSpecImages;
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
              adAssetFeedSpecImages.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAssetFeedSpecImages;
          }

          // Sixth, check if it's pure JsonObject
          adAssetFeedSpecImages.clear();
          adAssetFeedSpecImages.add(loadJSON(json, context));
          return adAssetFeedSpecImages;
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


  public List<AdAssetFeedSpecAssetLabel> getFieldAdlabels() {
    return mAdlabels;
  }

  public String getFieldHash() {
    return mHash;
  }

  public AdsImageCrops getFieldImageCrops() {
    if (mImageCrops != null) {
      mImageCrops.context = getContext();
    }
    return mImageCrops;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public String getFieldUrlTags() {
    return mUrlTags;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdAssetFeedSpecImage> {

    AdAssetFeedSpecImage lastResponse = null;
    @Override
    public AdAssetFeedSpecImage getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "adlabels",
      "hash",
      "image_crops",
      "url",
      "url_tags",
      "id",
    };

    @Override
    public AdAssetFeedSpecImage parseResponse(String response) throws APIException {
      return AdAssetFeedSpecImage.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAssetFeedSpecImage execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAssetFeedSpecImage execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdAssetFeedSpecImage> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAssetFeedSpecImage> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdAssetFeedSpecImage>() {
           public AdAssetFeedSpecImage apply(String result) {
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

    public APIRequestGet requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGet requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGet requestHashField () {
      return this.requestHashField(true);
    }
    public APIRequestGet requestHashField (boolean value) {
      this.requestField("hash", value);
      return this;
    }
    public APIRequestGet requestImageCropsField () {
      return this.requestImageCropsField(true);
    }
    public APIRequestGet requestImageCropsField (boolean value) {
      this.requestField("image_crops", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGet requestUrlTagsField () {
      return this.requestUrlTagsField(true);
    }
    public APIRequestGet requestUrlTagsField (boolean value) {
      this.requestField("url_tags", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
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

  public AdAssetFeedSpecImage copyFrom(AdAssetFeedSpecImage instance) {
    this.mAdlabels = instance.mAdlabels;
    this.mHash = instance.mHash;
    this.mImageCrops = instance.mImageCrops;
    this.mUrl = instance.mUrl;
    this.mUrlTags = instance.mUrlTags;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAssetFeedSpecImage> getParser() {
    return new APIRequest.ResponseParser<AdAssetFeedSpecImage>() {
      public APINodeList<AdAssetFeedSpecImage> parseResponse(String response, APIContext context, APIRequest<AdAssetFeedSpecImage> request) throws MalformedResponseException {
        return AdAssetFeedSpecImage.parseResponse(response, context, request);
      }
    };
  }
}
