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
public class NativeOfferView extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("offer")
  private NativeOffer mOffer = null;
  @SerializedName("save_count")
  private Long mSaveCount = null;
  protected static Gson gson = null;

  NativeOfferView() {
  }

  public NativeOfferView(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public NativeOfferView(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public NativeOfferView fetch() throws APIException{
    NativeOfferView newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static NativeOfferView fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<NativeOfferView> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static NativeOfferView fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<NativeOfferView> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<NativeOfferView> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<NativeOfferView>)(
      new APIRequest<NativeOfferView>(context, "", "/", "GET", NativeOfferView.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<NativeOfferView>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", NativeOfferView.getParser())
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
  public static NativeOfferView loadJSON(String json, APIContext context, String header) {
    NativeOfferView nativeOfferView = getGson().fromJson(json, NativeOfferView.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(nativeOfferView.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    nativeOfferView.context = context;
    nativeOfferView.rawValue = json;
    nativeOfferView.header = header;
    return nativeOfferView;
  }

  public static APINodeList<NativeOfferView> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<NativeOfferView> nativeOfferViews = new APINodeList<NativeOfferView>(request, json, header);
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
          nativeOfferViews.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return nativeOfferViews;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                nativeOfferViews.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            nativeOfferViews.setPaging(previous, next);
            if (context.hasAppSecret()) {
              nativeOfferViews.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              nativeOfferViews.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  nativeOfferViews.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              nativeOfferViews.add(loadJSON(obj.toString(), context, header));
            }
          }
          return nativeOfferViews;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              nativeOfferViews.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return nativeOfferViews;
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
              nativeOfferViews.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return nativeOfferViews;
          }

          // Sixth, check if it's pure JsonObject
          nativeOfferViews.clear();
          nativeOfferViews.add(loadJSON(json, context, header));
          return nativeOfferViews;
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

  public APIRequestCreatePhoto createPhoto() {
    return new APIRequestCreatePhoto(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateVideo createVideo() {
    return new APIRequestCreateVideo(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldId() {
    return mId;
  }

  public NativeOffer getFieldOffer() {
    if (mOffer != null) {
      mOffer.context = getContext();
    }
    return mOffer;
  }

  public Long getFieldSaveCount() {
    return mSaveCount;
  }



  public static class APIRequestCreatePhoto extends APIRequest<NativeOfferView> {

    NativeOfferView lastResponse = null;
    @Override
    public NativeOfferView getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_account",
      "ad_image_hashes",
      "image_crops",
      "photos",
      "urls",
      "file",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public NativeOfferView parseResponse(String response, String header) throws APIException {
      return NativeOfferView.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public NativeOfferView execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public NativeOfferView execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<NativeOfferView> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<NativeOfferView> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, NativeOfferView>() {
           public NativeOfferView apply(ResponseWrapper result) {
             try {
               return APIRequestCreatePhoto.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreatePhoto(String nodeId, APIContext context) {
      super(context, nodeId, "/photos", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePhoto setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePhoto setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }

    public APIRequestCreatePhoto addUploadFile (String uploadName, File file) {
      this.setParam(uploadName, file);
      return this;
    }

    public APIRequestCreatePhoto setUseVideoEndpoint(boolean useVideoEndpoint) {
      this.useVideoEndpoint = useVideoEndpoint;
      return this;
    }

    public APIRequestCreatePhoto setAdAccount (String adAccount) {
      this.setParam("ad_account", adAccount);
      return this;
    }

    public APIRequestCreatePhoto setAdImageHashes (List<String> adImageHashes) {
      this.setParam("ad_image_hashes", adImageHashes);
      return this;
    }
    public APIRequestCreatePhoto setAdImageHashes (String adImageHashes) {
      this.setParam("ad_image_hashes", adImageHashes);
      return this;
    }

    public APIRequestCreatePhoto setImageCrops (List<Map<String, String>> imageCrops) {
      this.setParam("image_crops", imageCrops);
      return this;
    }
    public APIRequestCreatePhoto setImageCrops (String imageCrops) {
      this.setParam("image_crops", imageCrops);
      return this;
    }

    public APIRequestCreatePhoto setPhotos (List<String> photos) {
      this.setParam("photos", photos);
      return this;
    }
    public APIRequestCreatePhoto setPhotos (String photos) {
      this.setParam("photos", photos);
      return this;
    }

    public APIRequestCreatePhoto setUrls (List<String> urls) {
      this.setParam("urls", urls);
      return this;
    }
    public APIRequestCreatePhoto setUrls (String urls) {
      this.setParam("urls", urls);
      return this;
    }

    public APIRequestCreatePhoto requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePhoto requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePhoto requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePhoto requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePhoto requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePhoto requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateVideo extends APIRequest<NativeOfferView> {

    NativeOfferView lastResponse = null;
    @Override
    public NativeOfferView getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "videos",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public NativeOfferView parseResponse(String response, String header) throws APIException {
      return NativeOfferView.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public NativeOfferView execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public NativeOfferView execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<NativeOfferView> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<NativeOfferView> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, NativeOfferView>() {
           public NativeOfferView apply(ResponseWrapper result) {
             try {
               return APIRequestCreateVideo.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateVideo(String nodeId, APIContext context) {
      super(context, nodeId, "/videos", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateVideo setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateVideo setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateVideo setVideos (List<String> videos) {
      this.setParam("videos", videos);
      return this;
    }
    public APIRequestCreateVideo setVideos (String videos) {
      this.setParam("videos", videos);
      return this;
    }

    public APIRequestCreateVideo requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateVideo requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideo requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateVideo requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideo requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateVideo requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<NativeOfferView> {

    NativeOfferView lastResponse = null;
    @Override
    public NativeOfferView getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "offer",
      "save_count",
    };

    @Override
    public NativeOfferView parseResponse(String response, String header) throws APIException {
      return NativeOfferView.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public NativeOfferView execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public NativeOfferView execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<NativeOfferView> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<NativeOfferView> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, NativeOfferView>() {
           public NativeOfferView apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
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

    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestOfferField () {
      return this.requestOfferField(true);
    }
    public APIRequestGet requestOfferField (boolean value) {
      this.requestField("offer", value);
      return this;
    }
    public APIRequestGet requestSaveCountField () {
      return this.requestSaveCountField(true);
    }
    public APIRequestGet requestSaveCountField (boolean value) {
      this.requestField("save_count", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<NativeOfferView> {

    NativeOfferView lastResponse = null;
    @Override
    public NativeOfferView getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "message",
      "published",
      "published_ads",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public NativeOfferView parseResponse(String response, String header) throws APIException {
      return NativeOfferView.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public NativeOfferView execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public NativeOfferView execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<NativeOfferView> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<NativeOfferView> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, NativeOfferView>() {
           public NativeOfferView apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestUpdate setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestUpdate setPublished (Boolean published) {
      this.setParam("published", published);
      return this;
    }
    public APIRequestUpdate setPublished (String published) {
      this.setParam("published", published);
      return this;
    }

    public APIRequestUpdate setPublishedAds (Boolean publishedAds) {
      this.setParam("published_ads", publishedAds);
      return this;
    }
    public APIRequestUpdate setPublishedAds (String publishedAds) {
      this.setParam("published_ads", publishedAds);
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

  public NativeOfferView copyFrom(NativeOfferView instance) {
    this.mId = instance.mId;
    this.mOffer = instance.mOffer;
    this.mSaveCount = instance.mSaveCount;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<NativeOfferView> getParser() {
    return new APIRequest.ResponseParser<NativeOfferView>() {
      public APINodeList<NativeOfferView> parseResponse(String response, APIContext context, APIRequest<NativeOfferView> request, String header) throws MalformedResponseException {
        return NativeOfferView.parseResponse(response, context, request, header);
      }
    };
  }
}
