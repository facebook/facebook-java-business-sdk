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
public class AdAssetLinkURL extends APINode {
  @SerializedName("android_deeplink_url")
  private String mAndroidDeeplinkUrl = null;
  @SerializedName("carousel_see_more_url")
  private String mCarouselSeeMoreUrl = null;
  @SerializedName("deeplink_url")
  private String mDeeplinkUrl = null;
  @SerializedName("display_url")
  private String mDisplayUrl = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ipad_deeplink_url")
  private String mIpadDeeplinkUrl = null;
  @SerializedName("iphone_deeplink_url")
  private String mIphoneDeeplinkUrl = null;
  @SerializedName("url_tags")
  private String mUrlTags = null;
  @SerializedName("website_url")
  private String mWebsiteUrl = null;
  protected static Gson gson = null;

  public AdAssetLinkURL() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdAssetLinkURL loadJSON(String json, APIContext context, String header) {
    AdAssetLinkURL adAssetLinkURL = getGson().fromJson(json, AdAssetLinkURL.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAssetLinkURL.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAssetLinkURL.context = context;
    adAssetLinkURL.rawValue = json;
    adAssetLinkURL.header = header;
    return adAssetLinkURL;
  }

  public static APINodeList<AdAssetLinkURL> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAssetLinkURL> adAssetLinkURLs = new APINodeList<AdAssetLinkURL>(request, json, header);
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
          adAssetLinkURLs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAssetLinkURLs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAssetLinkURLs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAssetLinkURLs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAssetLinkURLs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAssetLinkURLs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAssetLinkURLs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAssetLinkURLs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAssetLinkURLs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAssetLinkURLs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAssetLinkURLs;
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
              adAssetLinkURLs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAssetLinkURLs;
          }

          // Sixth, check if it's pure JsonObject
          adAssetLinkURLs.clear();
          adAssetLinkURLs.add(loadJSON(json, context, header));
          return adAssetLinkURLs;
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


  public String getFieldAndroidDeeplinkUrl() {
    return mAndroidDeeplinkUrl;
  }

  public AdAssetLinkURL setFieldAndroidDeeplinkUrl(String value) {
    this.mAndroidDeeplinkUrl = value;
    return this;
  }

  public String getFieldCarouselSeeMoreUrl() {
    return mCarouselSeeMoreUrl;
  }

  public AdAssetLinkURL setFieldCarouselSeeMoreUrl(String value) {
    this.mCarouselSeeMoreUrl = value;
    return this;
  }

  public String getFieldDeeplinkUrl() {
    return mDeeplinkUrl;
  }

  public AdAssetLinkURL setFieldDeeplinkUrl(String value) {
    this.mDeeplinkUrl = value;
    return this;
  }

  public String getFieldDisplayUrl() {
    return mDisplayUrl;
  }

  public AdAssetLinkURL setFieldDisplayUrl(String value) {
    this.mDisplayUrl = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AdAssetLinkURL setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldIpadDeeplinkUrl() {
    return mIpadDeeplinkUrl;
  }

  public AdAssetLinkURL setFieldIpadDeeplinkUrl(String value) {
    this.mIpadDeeplinkUrl = value;
    return this;
  }

  public String getFieldIphoneDeeplinkUrl() {
    return mIphoneDeeplinkUrl;
  }

  public AdAssetLinkURL setFieldIphoneDeeplinkUrl(String value) {
    this.mIphoneDeeplinkUrl = value;
    return this;
  }

  public String getFieldUrlTags() {
    return mUrlTags;
  }

  public AdAssetLinkURL setFieldUrlTags(String value) {
    this.mUrlTags = value;
    return this;
  }

  public String getFieldWebsiteUrl() {
    return mWebsiteUrl;
  }

  public AdAssetLinkURL setFieldWebsiteUrl(String value) {
    this.mWebsiteUrl = value;
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

  public AdAssetLinkURL copyFrom(AdAssetLinkURL instance) {
    this.mAndroidDeeplinkUrl = instance.mAndroidDeeplinkUrl;
    this.mCarouselSeeMoreUrl = instance.mCarouselSeeMoreUrl;
    this.mDeeplinkUrl = instance.mDeeplinkUrl;
    this.mDisplayUrl = instance.mDisplayUrl;
    this.mId = instance.mId;
    this.mIpadDeeplinkUrl = instance.mIpadDeeplinkUrl;
    this.mIphoneDeeplinkUrl = instance.mIphoneDeeplinkUrl;
    this.mUrlTags = instance.mUrlTags;
    this.mWebsiteUrl = instance.mWebsiteUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAssetLinkURL> getParser() {
    return new APIRequest.ResponseParser<AdAssetLinkURL>() {
      public APINodeList<AdAssetLinkURL> parseResponse(String response, APIContext context, APIRequest<AdAssetLinkURL> request, String header) throws MalformedResponseException {
        return AdAssetLinkURL.parseResponse(response, context, request, header);
      }
    };
  }
}
