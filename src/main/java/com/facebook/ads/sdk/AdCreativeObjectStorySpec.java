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
public class AdCreativeObjectStorySpec extends APINode {
  @SerializedName("instagram_actor_id")
  private String mInstagramActorId = null;
  @SerializedName("link_data")
  private AdCreativeLinkData mLinkData = null;
  @SerializedName("page_id")
  private String mPageId = null;
  @SerializedName("photo_data")
  private AdCreativePhotoData mPhotoData = null;
  @SerializedName("template_data")
  private AdCreativeLinkData mTemplateData = null;
  @SerializedName("text_data")
  private AdCreativeTextData mTextData = null;
  @SerializedName("video_data")
  private AdCreativeVideoData mVideoData = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  public AdCreativeObjectStorySpec() {
  }

  public AdCreativeObjectStorySpec(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCreativeObjectStorySpec(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdCreativeObjectStorySpec fetch() throws APIException{
    AdCreativeObjectStorySpec newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdCreativeObjectStorySpec fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdCreativeObjectStorySpec> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdCreativeObjectStorySpec fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdCreativeObjectStorySpec> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdCreativeObjectStorySpec> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCreativeObjectStorySpec>)(
      new APIRequest<AdCreativeObjectStorySpec>(context, "", "/", "GET", AdCreativeObjectStorySpec.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdCreativeObjectStorySpec>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdCreativeObjectStorySpec.getParser())
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
  public static AdCreativeObjectStorySpec loadJSON(String json, APIContext context) {
    AdCreativeObjectStorySpec adCreativeObjectStorySpec = getGson().fromJson(json, AdCreativeObjectStorySpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeObjectStorySpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCreativeObjectStorySpec.context = context;
    adCreativeObjectStorySpec.rawValue = json;
    return adCreativeObjectStorySpec;
  }

  public static APINodeList<AdCreativeObjectStorySpec> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdCreativeObjectStorySpec> adCreativeObjectStorySpecs = new APINodeList<AdCreativeObjectStorySpec>(request, json);
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
          adCreativeObjectStorySpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adCreativeObjectStorySpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeObjectStorySpecs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeObjectStorySpecs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeObjectStorySpecs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeObjectStorySpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adCreativeObjectStorySpecs.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeObjectStorySpecs.add(loadJSON(obj.toString(), context));
            }
          }
          return adCreativeObjectStorySpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeObjectStorySpecs.add(loadJSON(entry.getValue().toString(), context));
          }
          return adCreativeObjectStorySpecs;
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
              adCreativeObjectStorySpecs.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeObjectStorySpecs;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeObjectStorySpecs.clear();
          adCreativeObjectStorySpecs.add(loadJSON(json, context));
          return adCreativeObjectStorySpecs;
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


  public String getFieldInstagramActorId() {
    return mInstagramActorId;
  }

  public AdCreativeObjectStorySpec setFieldInstagramActorId(String value) {
    this.mInstagramActorId = value;
    return this;
  }

  public AdCreativeLinkData getFieldLinkData() {
    if (mLinkData != null) {
      mLinkData.context = getContext();
    }
    return mLinkData;
  }

  public AdCreativeObjectStorySpec setFieldLinkData(AdCreativeLinkData value) {
    this.mLinkData = value;
    return this;
  }

  public AdCreativeObjectStorySpec setFieldLinkData(String value) {
    Type type = new TypeToken<AdCreativeLinkData>(){}.getType();
    this.mLinkData = AdCreativeLinkData.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldPageId() {
    return mPageId;
  }

  public AdCreativeObjectStorySpec setFieldPageId(String value) {
    this.mPageId = value;
    return this;
  }

  public AdCreativePhotoData getFieldPhotoData() {
    if (mPhotoData != null) {
      mPhotoData.context = getContext();
    }
    return mPhotoData;
  }

  public AdCreativeObjectStorySpec setFieldPhotoData(AdCreativePhotoData value) {
    this.mPhotoData = value;
    return this;
  }

  public AdCreativeObjectStorySpec setFieldPhotoData(String value) {
    Type type = new TypeToken<AdCreativePhotoData>(){}.getType();
    this.mPhotoData = AdCreativePhotoData.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeLinkData getFieldTemplateData() {
    if (mTemplateData != null) {
      mTemplateData.context = getContext();
    }
    return mTemplateData;
  }

  public AdCreativeObjectStorySpec setFieldTemplateData(AdCreativeLinkData value) {
    this.mTemplateData = value;
    return this;
  }

  public AdCreativeObjectStorySpec setFieldTemplateData(String value) {
    Type type = new TypeToken<AdCreativeLinkData>(){}.getType();
    this.mTemplateData = AdCreativeLinkData.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeTextData getFieldTextData() {
    if (mTextData != null) {
      mTextData.context = getContext();
    }
    return mTextData;
  }

  public AdCreativeObjectStorySpec setFieldTextData(AdCreativeTextData value) {
    this.mTextData = value;
    return this;
  }

  public AdCreativeObjectStorySpec setFieldTextData(String value) {
    Type type = new TypeToken<AdCreativeTextData>(){}.getType();
    this.mTextData = AdCreativeTextData.getGson().fromJson(value, type);
    return this;
  }
  public AdCreativeVideoData getFieldVideoData() {
    if (mVideoData != null) {
      mVideoData.context = getContext();
    }
    return mVideoData;
  }

  public AdCreativeObjectStorySpec setFieldVideoData(AdCreativeVideoData value) {
    this.mVideoData = value;
    return this;
  }

  public AdCreativeObjectStorySpec setFieldVideoData(String value) {
    Type type = new TypeToken<AdCreativeVideoData>(){}.getType();
    this.mVideoData = AdCreativeVideoData.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldId() {
    return mId;
  }

  public AdCreativeObjectStorySpec setFieldId(String value) {
    this.mId = value;
    return this;
  }



  public static class APIRequestGet extends APIRequest<AdCreativeObjectStorySpec> {

    AdCreativeObjectStorySpec lastResponse = null;
    @Override
    public AdCreativeObjectStorySpec getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "instagram_actor_id",
      "link_data",
      "page_id",
      "photo_data",
      "template_data",
      "text_data",
      "video_data",
      "id",
    };

    @Override
    public AdCreativeObjectStorySpec parseResponse(String response) throws APIException {
      return AdCreativeObjectStorySpec.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdCreativeObjectStorySpec execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCreativeObjectStorySpec execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdCreativeObjectStorySpec> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCreativeObjectStorySpec> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdCreativeObjectStorySpec>() {
           public AdCreativeObjectStorySpec apply(String result) {
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

    public APIRequestGet requestInstagramActorIdField () {
      return this.requestInstagramActorIdField(true);
    }
    public APIRequestGet requestInstagramActorIdField (boolean value) {
      this.requestField("instagram_actor_id", value);
      return this;
    }
    public APIRequestGet requestLinkDataField () {
      return this.requestLinkDataField(true);
    }
    public APIRequestGet requestLinkDataField (boolean value) {
      this.requestField("link_data", value);
      return this;
    }
    public APIRequestGet requestPageIdField () {
      return this.requestPageIdField(true);
    }
    public APIRequestGet requestPageIdField (boolean value) {
      this.requestField("page_id", value);
      return this;
    }
    public APIRequestGet requestPhotoDataField () {
      return this.requestPhotoDataField(true);
    }
    public APIRequestGet requestPhotoDataField (boolean value) {
      this.requestField("photo_data", value);
      return this;
    }
    public APIRequestGet requestTemplateDataField () {
      return this.requestTemplateDataField(true);
    }
    public APIRequestGet requestTemplateDataField (boolean value) {
      this.requestField("template_data", value);
      return this;
    }
    public APIRequestGet requestTextDataField () {
      return this.requestTextDataField(true);
    }
    public APIRequestGet requestTextDataField (boolean value) {
      this.requestField("text_data", value);
      return this;
    }
    public APIRequestGet requestVideoDataField () {
      return this.requestVideoDataField(true);
    }
    public APIRequestGet requestVideoDataField (boolean value) {
      this.requestField("video_data", value);
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

  public AdCreativeObjectStorySpec copyFrom(AdCreativeObjectStorySpec instance) {
    this.mInstagramActorId = instance.mInstagramActorId;
    this.mLinkData = instance.mLinkData;
    this.mPageId = instance.mPageId;
    this.mPhotoData = instance.mPhotoData;
    this.mTemplateData = instance.mTemplateData;
    this.mTextData = instance.mTextData;
    this.mVideoData = instance.mVideoData;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeObjectStorySpec> getParser() {
    return new APIRequest.ResponseParser<AdCreativeObjectStorySpec>() {
      public APINodeList<AdCreativeObjectStorySpec> parseResponse(String response, APIContext context, APIRequest<AdCreativeObjectStorySpec> request) throws MalformedResponseException {
        return AdCreativeObjectStorySpec.parseResponse(response, context, request);
      }
    };
  }
}
