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
public class AdCreativeSiteLinksSpec extends APINode {
  @SerializedName("is_site_link_sticky")
  private Boolean mIsSiteLinkSticky = null;
  @SerializedName("site_link_hash")
  private String mSiteLinkHash = null;
  @SerializedName("site_link_id")
  private String mSiteLinkId = null;
  @SerializedName("site_link_image_hash")
  private String mSiteLinkImageHash = null;
  @SerializedName("site_link_image_url")
  private String mSiteLinkImageUrl = null;
  @SerializedName("site_link_recommendation_type")
  private String mSiteLinkRecommendationType = null;
  @SerializedName("site_link_title")
  private String mSiteLinkTitle = null;
  @SerializedName("site_link_url")
  private String mSiteLinkUrl = null;
  protected static Gson gson = null;

  public AdCreativeSiteLinksSpec() {
  }

  public String getId() {
    return null;
  }
  public static AdCreativeSiteLinksSpec loadJSON(String json, APIContext context, String header) {
    AdCreativeSiteLinksSpec adCreativeSiteLinksSpec = getGson().fromJson(json, AdCreativeSiteLinksSpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeSiteLinksSpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCreativeSiteLinksSpec.context = context;
    adCreativeSiteLinksSpec.rawValue = json;
    adCreativeSiteLinksSpec.header = header;
    return adCreativeSiteLinksSpec;
  }

  public static APINodeList<AdCreativeSiteLinksSpec> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCreativeSiteLinksSpec> adCreativeSiteLinksSpecs = new APINodeList<AdCreativeSiteLinksSpec>(request, json, header);
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
          adCreativeSiteLinksSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCreativeSiteLinksSpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeSiteLinksSpecs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeSiteLinksSpecs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeSiteLinksSpecs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeSiteLinksSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCreativeSiteLinksSpecs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeSiteLinksSpecs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCreativeSiteLinksSpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeSiteLinksSpecs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCreativeSiteLinksSpecs;
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
              adCreativeSiteLinksSpecs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeSiteLinksSpecs;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeSiteLinksSpecs.clear();
          adCreativeSiteLinksSpecs.add(loadJSON(json, context, header));
          return adCreativeSiteLinksSpecs;
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


  public Boolean getFieldIsSiteLinkSticky() {
    return mIsSiteLinkSticky;
  }

  public AdCreativeSiteLinksSpec setFieldIsSiteLinkSticky(Boolean value) {
    this.mIsSiteLinkSticky = value;
    return this;
  }

  public String getFieldSiteLinkHash() {
    return mSiteLinkHash;
  }

  public AdCreativeSiteLinksSpec setFieldSiteLinkHash(String value) {
    this.mSiteLinkHash = value;
    return this;
  }

  public String getFieldSiteLinkId() {
    return mSiteLinkId;
  }

  public AdCreativeSiteLinksSpec setFieldSiteLinkId(String value) {
    this.mSiteLinkId = value;
    return this;
  }

  public String getFieldSiteLinkImageHash() {
    return mSiteLinkImageHash;
  }

  public AdCreativeSiteLinksSpec setFieldSiteLinkImageHash(String value) {
    this.mSiteLinkImageHash = value;
    return this;
  }

  public String getFieldSiteLinkImageUrl() {
    return mSiteLinkImageUrl;
  }

  public AdCreativeSiteLinksSpec setFieldSiteLinkImageUrl(String value) {
    this.mSiteLinkImageUrl = value;
    return this;
  }

  public String getFieldSiteLinkRecommendationType() {
    return mSiteLinkRecommendationType;
  }

  public AdCreativeSiteLinksSpec setFieldSiteLinkRecommendationType(String value) {
    this.mSiteLinkRecommendationType = value;
    return this;
  }

  public String getFieldSiteLinkTitle() {
    return mSiteLinkTitle;
  }

  public AdCreativeSiteLinksSpec setFieldSiteLinkTitle(String value) {
    this.mSiteLinkTitle = value;
    return this;
  }

  public String getFieldSiteLinkUrl() {
    return mSiteLinkUrl;
  }

  public AdCreativeSiteLinksSpec setFieldSiteLinkUrl(String value) {
    this.mSiteLinkUrl = value;
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

  public AdCreativeSiteLinksSpec copyFrom(AdCreativeSiteLinksSpec instance) {
    this.mIsSiteLinkSticky = instance.mIsSiteLinkSticky;
    this.mSiteLinkHash = instance.mSiteLinkHash;
    this.mSiteLinkId = instance.mSiteLinkId;
    this.mSiteLinkImageHash = instance.mSiteLinkImageHash;
    this.mSiteLinkImageUrl = instance.mSiteLinkImageUrl;
    this.mSiteLinkRecommendationType = instance.mSiteLinkRecommendationType;
    this.mSiteLinkTitle = instance.mSiteLinkTitle;
    this.mSiteLinkUrl = instance.mSiteLinkUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeSiteLinksSpec> getParser() {
    return new APIRequest.ResponseParser<AdCreativeSiteLinksSpec>() {
      public APINodeList<AdCreativeSiteLinksSpec> parseResponse(String response, APIContext context, APIRequest<AdCreativeSiteLinksSpec> request, String header) throws MalformedResponseException {
        return AdCreativeSiteLinksSpec.parseResponse(response, context, request, header);
      }
    };
  }
}
