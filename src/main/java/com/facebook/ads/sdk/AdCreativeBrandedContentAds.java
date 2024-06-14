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
public class AdCreativeBrandedContentAds extends APINode {
  @SerializedName("ad_format")
  private Long mAdFormat = null;
  @SerializedName("content_search_input")
  private String mContentSearchInput = null;
  @SerializedName("creator_ad_permission_type")
  private String mCreatorAdPermissionType = null;
  @SerializedName("facebook_boost_post_access_token")
  private String mFacebookBoostPostAccessToken = null;
  @SerializedName("instagram_boost_post_access_token")
  private String mInstagramBoostPostAccessToken = null;
  @SerializedName("is_mca_internal")
  private Boolean mIsMcaInternal = null;
  @SerializedName("partners")
  private List<AdCreativeBrandedContentAdsPartners> mPartners = null;
  @SerializedName("promoted_page_id")
  private String mPromotedPageId = null;
  @SerializedName("ui_version")
  private Long mUiVersion = null;
  protected static Gson gson = null;

  public AdCreativeBrandedContentAds() {
  }

  public String getId() {
    return null;
  }
  public static AdCreativeBrandedContentAds loadJSON(String json, APIContext context, String header) {
    AdCreativeBrandedContentAds adCreativeBrandedContentAds = getGson().fromJson(json, AdCreativeBrandedContentAds.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeBrandedContentAds.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCreativeBrandedContentAds.context = context;
    adCreativeBrandedContentAds.rawValue = json;
    adCreativeBrandedContentAds.header = header;
    return adCreativeBrandedContentAds;
  }

  public static APINodeList<AdCreativeBrandedContentAds> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCreativeBrandedContentAds> adCreativeBrandedContentAdss = new APINodeList<AdCreativeBrandedContentAds>(request, json, header);
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
          adCreativeBrandedContentAdss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCreativeBrandedContentAdss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeBrandedContentAdss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeBrandedContentAdss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeBrandedContentAdss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeBrandedContentAdss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCreativeBrandedContentAdss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeBrandedContentAdss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCreativeBrandedContentAdss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeBrandedContentAdss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCreativeBrandedContentAdss;
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
              adCreativeBrandedContentAdss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeBrandedContentAdss;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeBrandedContentAdss.clear();
          adCreativeBrandedContentAdss.add(loadJSON(json, context, header));
          return adCreativeBrandedContentAdss;
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


  public Long getFieldAdFormat() {
    return mAdFormat;
  }

  public AdCreativeBrandedContentAds setFieldAdFormat(Long value) {
    this.mAdFormat = value;
    return this;
  }

  public String getFieldContentSearchInput() {
    return mContentSearchInput;
  }

  public AdCreativeBrandedContentAds setFieldContentSearchInput(String value) {
    this.mContentSearchInput = value;
    return this;
  }

  public String getFieldCreatorAdPermissionType() {
    return mCreatorAdPermissionType;
  }

  public AdCreativeBrandedContentAds setFieldCreatorAdPermissionType(String value) {
    this.mCreatorAdPermissionType = value;
    return this;
  }

  public String getFieldFacebookBoostPostAccessToken() {
    return mFacebookBoostPostAccessToken;
  }

  public AdCreativeBrandedContentAds setFieldFacebookBoostPostAccessToken(String value) {
    this.mFacebookBoostPostAccessToken = value;
    return this;
  }

  public String getFieldInstagramBoostPostAccessToken() {
    return mInstagramBoostPostAccessToken;
  }

  public AdCreativeBrandedContentAds setFieldInstagramBoostPostAccessToken(String value) {
    this.mInstagramBoostPostAccessToken = value;
    return this;
  }

  public Boolean getFieldIsMcaInternal() {
    return mIsMcaInternal;
  }

  public AdCreativeBrandedContentAds setFieldIsMcaInternal(Boolean value) {
    this.mIsMcaInternal = value;
    return this;
  }

  public List<AdCreativeBrandedContentAdsPartners> getFieldPartners() {
    return mPartners;
  }

  public AdCreativeBrandedContentAds setFieldPartners(List<AdCreativeBrandedContentAdsPartners> value) {
    this.mPartners = value;
    return this;
  }

  public AdCreativeBrandedContentAds setFieldPartners(String value) {
    Type type = new TypeToken<List<AdCreativeBrandedContentAdsPartners>>(){}.getType();
    this.mPartners = AdCreativeBrandedContentAdsPartners.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldPromotedPageId() {
    return mPromotedPageId;
  }

  public AdCreativeBrandedContentAds setFieldPromotedPageId(String value) {
    this.mPromotedPageId = value;
    return this;
  }

  public Long getFieldUiVersion() {
    return mUiVersion;
  }

  public AdCreativeBrandedContentAds setFieldUiVersion(Long value) {
    this.mUiVersion = value;
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

  public AdCreativeBrandedContentAds copyFrom(AdCreativeBrandedContentAds instance) {
    this.mAdFormat = instance.mAdFormat;
    this.mContentSearchInput = instance.mContentSearchInput;
    this.mCreatorAdPermissionType = instance.mCreatorAdPermissionType;
    this.mFacebookBoostPostAccessToken = instance.mFacebookBoostPostAccessToken;
    this.mInstagramBoostPostAccessToken = instance.mInstagramBoostPostAccessToken;
    this.mIsMcaInternal = instance.mIsMcaInternal;
    this.mPartners = instance.mPartners;
    this.mPromotedPageId = instance.mPromotedPageId;
    this.mUiVersion = instance.mUiVersion;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeBrandedContentAds> getParser() {
    return new APIRequest.ResponseParser<AdCreativeBrandedContentAds>() {
      public APINodeList<AdCreativeBrandedContentAds> parseResponse(String response, APIContext context, APIRequest<AdCreativeBrandedContentAds> request, String header) throws MalformedResponseException {
        return AdCreativeBrandedContentAds.parseResponse(response, context, request, header);
      }
    };
  }
}
