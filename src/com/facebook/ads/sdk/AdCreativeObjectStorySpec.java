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


public class AdCreativeObjectStorySpec extends APINode {
  @SerializedName("page_id")
  private String mPageId = null;
  @SerializedName("instagram_actor_id")
  private String mInstagramActorId = null;
  @SerializedName("photo_data")
  private AdCreativePhotoData mPhotoData = null;
  @SerializedName("text_data")
  private AdCreativeTextData mTextData = null;
  @SerializedName("link_data")
  private AdCreativeLinkData mLinkData = null;
  @SerializedName("template_data")
  private AdCreativeLinkData mTemplateData = null;
  @SerializedName("offer_data")
  private AdCreativeOfferData mOfferData = null;
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
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCreativeObjectStorySpec.mContext = context;
    adCreativeObjectStorySpec.rawValue = json;
    return adCreativeObjectStorySpec;
  }

  public static APINodeList<AdCreativeObjectStorySpec> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<AdCreativeObjectStorySpec> adCreativeObjectStorySpecs = new APINodeList<AdCreativeObjectStorySpec>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
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
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            adCreativeObjectStorySpecs.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
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
            adCreativeObjectStorySpecs.add(loadJSON(obj.toString(), context));
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
          // Fifth, check if it's pure JsonObject
          adCreativeObjectStorySpecs.add(loadJSON(json, context));
          return adCreativeObjectStorySpecs;
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


  public String getFieldPageId() {
    return mPageId;
  }

  public AdCreativeObjectStorySpec setFieldPageId(String value) {
    this.mPageId = value;
    return this;
  }

  public String getFieldInstagramActorId() {
    return mInstagramActorId;
  }

  public AdCreativeObjectStorySpec setFieldInstagramActorId(String value) {
    this.mInstagramActorId = value;
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
  public AdCreativeOfferData getFieldOfferData() {
    return mOfferData;
  }

  public AdCreativeObjectStorySpec setFieldOfferData(AdCreativeOfferData value) {
    this.mOfferData = value;
    return this;
  }

  public AdCreativeObjectStorySpec setFieldOfferData(String value) {
    Type type = new TypeToken<AdCreativeOfferData>(){}.getType();
    this.mOfferData = AdCreativeOfferData.getGson().fromJson(value, type);
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
    this.mPageId = instance.mPageId;
    this.mInstagramActorId = instance.mInstagramActorId;
    this.mPhotoData = instance.mPhotoData;
    this.mTextData = instance.mTextData;
    this.mLinkData = instance.mLinkData;
    this.mTemplateData = instance.mTemplateData;
    this.mOfferData = instance.mOfferData;
    this.mVideoData = instance.mVideoData;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}