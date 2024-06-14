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
public class AdVolume extends APINode {
  @SerializedName("ad_volume_break_down")
  private List<Object> mAdVolumeBreakDown = null;
  @SerializedName("ads_running_or_in_review_count")
  private Long mAdsRunningOrInReviewCount = null;
  @SerializedName("future_limit_activation_date")
  private String mFutureLimitActivationDate = null;
  @SerializedName("future_limit_on_ads_running_or_in_review")
  private Long mFutureLimitOnAdsRunningOrInReview = null;
  @SerializedName("individual_accounts_ad_volume")
  private Long mIndividualAccountsAdVolume = null;
  @SerializedName("is_gpa_page")
  private Boolean mIsGpaPage = null;
  @SerializedName("limit_on_ads_running_or_in_review")
  private Long mLimitOnAdsRunningOrInReview = null;
  @SerializedName("owning_business_ad_volume")
  private Long mOwningBusinessAdVolume = null;
  @SerializedName("partner_business_ad_volume")
  private Long mPartnerBusinessAdVolume = null;
  @SerializedName("user_role")
  private String mUserRole = null;
  protected static Gson gson = null;

  public AdVolume() {
  }

  public String getId() {
    return null;
  }
  public static AdVolume loadJSON(String json, APIContext context, String header) {
    AdVolume adVolume = getGson().fromJson(json, AdVolume.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adVolume.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adVolume.context = context;
    adVolume.rawValue = json;
    adVolume.header = header;
    return adVolume;
  }

  public static APINodeList<AdVolume> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdVolume> adVolumes = new APINodeList<AdVolume>(request, json, header);
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
          adVolumes.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adVolumes;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adVolumes.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adVolumes.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adVolumes.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adVolumes.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adVolumes.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adVolumes.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adVolumes;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adVolumes.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adVolumes;
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
              adVolumes.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adVolumes;
          }

          // Sixth, check if it's pure JsonObject
          adVolumes.clear();
          adVolumes.add(loadJSON(json, context, header));
          return adVolumes;
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


  public List<Object> getFieldAdVolumeBreakDown() {
    return mAdVolumeBreakDown;
  }

  public AdVolume setFieldAdVolumeBreakDown(List<Object> value) {
    this.mAdVolumeBreakDown = value;
    return this;
  }

  public Long getFieldAdsRunningOrInReviewCount() {
    return mAdsRunningOrInReviewCount;
  }

  public AdVolume setFieldAdsRunningOrInReviewCount(Long value) {
    this.mAdsRunningOrInReviewCount = value;
    return this;
  }

  public String getFieldFutureLimitActivationDate() {
    return mFutureLimitActivationDate;
  }

  public AdVolume setFieldFutureLimitActivationDate(String value) {
    this.mFutureLimitActivationDate = value;
    return this;
  }

  public Long getFieldFutureLimitOnAdsRunningOrInReview() {
    return mFutureLimitOnAdsRunningOrInReview;
  }

  public AdVolume setFieldFutureLimitOnAdsRunningOrInReview(Long value) {
    this.mFutureLimitOnAdsRunningOrInReview = value;
    return this;
  }

  public Long getFieldIndividualAccountsAdVolume() {
    return mIndividualAccountsAdVolume;
  }

  public AdVolume setFieldIndividualAccountsAdVolume(Long value) {
    this.mIndividualAccountsAdVolume = value;
    return this;
  }

  public Boolean getFieldIsGpaPage() {
    return mIsGpaPage;
  }

  public AdVolume setFieldIsGpaPage(Boolean value) {
    this.mIsGpaPage = value;
    return this;
  }

  public Long getFieldLimitOnAdsRunningOrInReview() {
    return mLimitOnAdsRunningOrInReview;
  }

  public AdVolume setFieldLimitOnAdsRunningOrInReview(Long value) {
    this.mLimitOnAdsRunningOrInReview = value;
    return this;
  }

  public Long getFieldOwningBusinessAdVolume() {
    return mOwningBusinessAdVolume;
  }

  public AdVolume setFieldOwningBusinessAdVolume(Long value) {
    this.mOwningBusinessAdVolume = value;
    return this;
  }

  public Long getFieldPartnerBusinessAdVolume() {
    return mPartnerBusinessAdVolume;
  }

  public AdVolume setFieldPartnerBusinessAdVolume(Long value) {
    this.mPartnerBusinessAdVolume = value;
    return this;
  }

  public String getFieldUserRole() {
    return mUserRole;
  }

  public AdVolume setFieldUserRole(String value) {
    this.mUserRole = value;
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

  public AdVolume copyFrom(AdVolume instance) {
    this.mAdVolumeBreakDown = instance.mAdVolumeBreakDown;
    this.mAdsRunningOrInReviewCount = instance.mAdsRunningOrInReviewCount;
    this.mFutureLimitActivationDate = instance.mFutureLimitActivationDate;
    this.mFutureLimitOnAdsRunningOrInReview = instance.mFutureLimitOnAdsRunningOrInReview;
    this.mIndividualAccountsAdVolume = instance.mIndividualAccountsAdVolume;
    this.mIsGpaPage = instance.mIsGpaPage;
    this.mLimitOnAdsRunningOrInReview = instance.mLimitOnAdsRunningOrInReview;
    this.mOwningBusinessAdVolume = instance.mOwningBusinessAdVolume;
    this.mPartnerBusinessAdVolume = instance.mPartnerBusinessAdVolume;
    this.mUserRole = instance.mUserRole;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdVolume> getParser() {
    return new APIRequest.ResponseParser<AdVolume>() {
      public APINodeList<AdVolume> parseResponse(String response, APIContext context, APIRequest<AdVolume> request, String header) throws MalformedResponseException {
        return AdVolume.parseResponse(response, context, request, header);
      }
    };
  }
}
