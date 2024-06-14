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
public class AdsCustomPivotsPreview extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("account_name")
  private String mAccountName = null;
  @SerializedName("ad_id")
  private String mAdId = null;
  @SerializedName("ad_name")
  private String mAdName = null;
  @SerializedName("adset_id")
  private String mAdsetId = null;
  @SerializedName("adset_name")
  private String mAdsetName = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("campaign_name")
  private String mCampaignName = null;
  @SerializedName("custom_breakdown")
  private List<String> mCustomBreakdown = null;
  protected static Gson gson = null;

  public AdsCustomPivotsPreview() {
  }

  public String getId() {
    return null;
  }
  public static AdsCustomPivotsPreview loadJSON(String json, APIContext context, String header) {
    AdsCustomPivotsPreview adsCustomPivotsPreview = getGson().fromJson(json, AdsCustomPivotsPreview.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsCustomPivotsPreview.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsCustomPivotsPreview.context = context;
    adsCustomPivotsPreview.rawValue = json;
    adsCustomPivotsPreview.header = header;
    return adsCustomPivotsPreview;
  }

  public static APINodeList<AdsCustomPivotsPreview> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsCustomPivotsPreview> adsCustomPivotsPreviews = new APINodeList<AdsCustomPivotsPreview>(request, json, header);
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
          adsCustomPivotsPreviews.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsCustomPivotsPreviews;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsCustomPivotsPreviews.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsCustomPivotsPreviews.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsCustomPivotsPreviews.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsCustomPivotsPreviews.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsCustomPivotsPreviews.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsCustomPivotsPreviews.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsCustomPivotsPreviews;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsCustomPivotsPreviews.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsCustomPivotsPreviews;
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
              adsCustomPivotsPreviews.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsCustomPivotsPreviews;
          }

          // Sixth, check if it's pure JsonObject
          adsCustomPivotsPreviews.clear();
          adsCustomPivotsPreviews.add(loadJSON(json, context, header));
          return adsCustomPivotsPreviews;
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


  public String getFieldAccountId() {
    return mAccountId;
  }

  public AdsCustomPivotsPreview setFieldAccountId(String value) {
    this.mAccountId = value;
    return this;
  }

  public String getFieldAccountName() {
    return mAccountName;
  }

  public AdsCustomPivotsPreview setFieldAccountName(String value) {
    this.mAccountName = value;
    return this;
  }

  public String getFieldAdId() {
    return mAdId;
  }

  public AdsCustomPivotsPreview setFieldAdId(String value) {
    this.mAdId = value;
    return this;
  }

  public String getFieldAdName() {
    return mAdName;
  }

  public AdsCustomPivotsPreview setFieldAdName(String value) {
    this.mAdName = value;
    return this;
  }

  public String getFieldAdsetId() {
    return mAdsetId;
  }

  public AdsCustomPivotsPreview setFieldAdsetId(String value) {
    this.mAdsetId = value;
    return this;
  }

  public String getFieldAdsetName() {
    return mAdsetName;
  }

  public AdsCustomPivotsPreview setFieldAdsetName(String value) {
    this.mAdsetName = value;
    return this;
  }

  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public AdsCustomPivotsPreview setFieldCampaignId(String value) {
    this.mCampaignId = value;
    return this;
  }

  public String getFieldCampaignName() {
    return mCampaignName;
  }

  public AdsCustomPivotsPreview setFieldCampaignName(String value) {
    this.mCampaignName = value;
    return this;
  }

  public List<String> getFieldCustomBreakdown() {
    return mCustomBreakdown;
  }

  public AdsCustomPivotsPreview setFieldCustomBreakdown(List<String> value) {
    this.mCustomBreakdown = value;
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

  public AdsCustomPivotsPreview copyFrom(AdsCustomPivotsPreview instance) {
    this.mAccountId = instance.mAccountId;
    this.mAccountName = instance.mAccountName;
    this.mAdId = instance.mAdId;
    this.mAdName = instance.mAdName;
    this.mAdsetId = instance.mAdsetId;
    this.mAdsetName = instance.mAdsetName;
    this.mCampaignId = instance.mCampaignId;
    this.mCampaignName = instance.mCampaignName;
    this.mCustomBreakdown = instance.mCustomBreakdown;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsCustomPivotsPreview> getParser() {
    return new APIRequest.ResponseParser<AdsCustomPivotsPreview>() {
      public APINodeList<AdsCustomPivotsPreview> parseResponse(String response, APIContext context, APIRequest<AdsCustomPivotsPreview> request, String header) throws MalformedResponseException {
        return AdsCustomPivotsPreview.parseResponse(response, context, request, header);
      }
    };
  }
}
