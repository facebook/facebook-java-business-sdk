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
public class AdCreativePhotoData extends APINode {
  @SerializedName("branded_content_shared_to_sponsor_status")
  private String mBrandedContentSharedToSponsorStatus = null;
  @SerializedName("branded_content_sponsor_page_id")
  private String mBrandedContentSponsorPageId = null;
  @SerializedName("caption")
  private String mCaption = null;
  @SerializedName("image_hash")
  private String mImageHash = null;
  @SerializedName("page_welcome_message")
  private String mPageWelcomeMessage = null;
  @SerializedName("url")
  private String mUrl = null;
  protected static Gson gson = null;

  public AdCreativePhotoData() {
  }

  public String getId() {
    return null;
  }
  public static AdCreativePhotoData loadJSON(String json, APIContext context, String header) {
    AdCreativePhotoData adCreativePhotoData = getGson().fromJson(json, AdCreativePhotoData.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativePhotoData.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCreativePhotoData.context = context;
    adCreativePhotoData.rawValue = json;
    adCreativePhotoData.header = header;
    return adCreativePhotoData;
  }

  public static APINodeList<AdCreativePhotoData> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCreativePhotoData> adCreativePhotoDatas = new APINodeList<AdCreativePhotoData>(request, json, header);
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
          adCreativePhotoDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCreativePhotoDatas;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativePhotoDatas.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativePhotoDatas.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativePhotoDatas.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativePhotoDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCreativePhotoDatas.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativePhotoDatas.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCreativePhotoDatas;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativePhotoDatas.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCreativePhotoDatas;
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
              adCreativePhotoDatas.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativePhotoDatas;
          }

          // Sixth, check if it's pure JsonObject
          adCreativePhotoDatas.clear();
          adCreativePhotoDatas.add(loadJSON(json, context, header));
          return adCreativePhotoDatas;
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


  public String getFieldBrandedContentSharedToSponsorStatus() {
    return mBrandedContentSharedToSponsorStatus;
  }

  public AdCreativePhotoData setFieldBrandedContentSharedToSponsorStatus(String value) {
    this.mBrandedContentSharedToSponsorStatus = value;
    return this;
  }

  public String getFieldBrandedContentSponsorPageId() {
    return mBrandedContentSponsorPageId;
  }

  public AdCreativePhotoData setFieldBrandedContentSponsorPageId(String value) {
    this.mBrandedContentSponsorPageId = value;
    return this;
  }

  public String getFieldCaption() {
    return mCaption;
  }

  public AdCreativePhotoData setFieldCaption(String value) {
    this.mCaption = value;
    return this;
  }

  public String getFieldImageHash() {
    return mImageHash;
  }

  public AdCreativePhotoData setFieldImageHash(String value) {
    this.mImageHash = value;
    return this;
  }

  public String getFieldPageWelcomeMessage() {
    return mPageWelcomeMessage;
  }

  public AdCreativePhotoData setFieldPageWelcomeMessage(String value) {
    this.mPageWelcomeMessage = value;
    return this;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public AdCreativePhotoData setFieldUrl(String value) {
    this.mUrl = value;
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

  public AdCreativePhotoData copyFrom(AdCreativePhotoData instance) {
    this.mBrandedContentSharedToSponsorStatus = instance.mBrandedContentSharedToSponsorStatus;
    this.mBrandedContentSponsorPageId = instance.mBrandedContentSponsorPageId;
    this.mCaption = instance.mCaption;
    this.mImageHash = instance.mImageHash;
    this.mPageWelcomeMessage = instance.mPageWelcomeMessage;
    this.mUrl = instance.mUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativePhotoData> getParser() {
    return new APIRequest.ResponseParser<AdCreativePhotoData>() {
      public APINodeList<AdCreativePhotoData> parseResponse(String response, APIContext context, APIRequest<AdCreativePhotoData> request, String header) throws MalformedResponseException {
        return AdCreativePhotoData.parseResponse(response, context, request, header);
      }
    };
  }
}
