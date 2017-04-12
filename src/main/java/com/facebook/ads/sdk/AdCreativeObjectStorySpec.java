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
 * This class is auto-genereated.
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
  protected static Gson gson = null;

  public AdCreativeObjectStorySpec() {
  }

  public String getId() {
    return null;
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
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adCreativeObjectStorySpecs.setPaging(before, after);
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


  public String getFieldInstagramActorId() {
    return mInstagramActorId;
  }

  public AdCreativeObjectStorySpec setFieldInstagramActorId(String value) {
    this.mInstagramActorId = value;
    return this;
  }

  public AdCreativeLinkData getFieldLinkData() {
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
