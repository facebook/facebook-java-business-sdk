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
public class BrandedContentShadowIGMediaID extends APINode {
  @SerializedName("eligibility_errors")
  private List<String> mEligibilityErrors = null;
  @SerializedName("has_permission_for_partnership_ad")
  private Boolean mHasPermissionForPartnershipAd = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("owner_id")
  private String mOwnerId = null;
  @SerializedName("permalink")
  private String mPermalink = null;
  protected static Gson gson = null;

  public BrandedContentShadowIGMediaID() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static BrandedContentShadowIGMediaID loadJSON(String json, APIContext context, String header) {
    BrandedContentShadowIGMediaID brandedContentShadowIGMediaID = getGson().fromJson(json, BrandedContentShadowIGMediaID.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(brandedContentShadowIGMediaID.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    brandedContentShadowIGMediaID.context = context;
    brandedContentShadowIGMediaID.rawValue = json;
    brandedContentShadowIGMediaID.header = header;
    return brandedContentShadowIGMediaID;
  }

  public static APINodeList<BrandedContentShadowIGMediaID> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BrandedContentShadowIGMediaID> brandedContentShadowIGMediaIDs = new APINodeList<BrandedContentShadowIGMediaID>(request, json, header);
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
          brandedContentShadowIGMediaIDs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return brandedContentShadowIGMediaIDs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                brandedContentShadowIGMediaIDs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            brandedContentShadowIGMediaIDs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              brandedContentShadowIGMediaIDs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              brandedContentShadowIGMediaIDs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  brandedContentShadowIGMediaIDs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              brandedContentShadowIGMediaIDs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return brandedContentShadowIGMediaIDs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              brandedContentShadowIGMediaIDs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return brandedContentShadowIGMediaIDs;
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
              brandedContentShadowIGMediaIDs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return brandedContentShadowIGMediaIDs;
          }

          // Sixth, check if it's pure JsonObject
          brandedContentShadowIGMediaIDs.clear();
          brandedContentShadowIGMediaIDs.add(loadJSON(json, context, header));
          return brandedContentShadowIGMediaIDs;
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


  public List<String> getFieldEligibilityErrors() {
    return mEligibilityErrors;
  }

  public BrandedContentShadowIGMediaID setFieldEligibilityErrors(List<String> value) {
    this.mEligibilityErrors = value;
    return this;
  }

  public Boolean getFieldHasPermissionForPartnershipAd() {
    return mHasPermissionForPartnershipAd;
  }

  public BrandedContentShadowIGMediaID setFieldHasPermissionForPartnershipAd(Boolean value) {
    this.mHasPermissionForPartnershipAd = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public BrandedContentShadowIGMediaID setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldOwnerId() {
    return mOwnerId;
  }

  public BrandedContentShadowIGMediaID setFieldOwnerId(String value) {
    this.mOwnerId = value;
    return this;
  }

  public String getFieldPermalink() {
    return mPermalink;
  }

  public BrandedContentShadowIGMediaID setFieldPermalink(String value) {
    this.mPermalink = value;
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

  public BrandedContentShadowIGMediaID copyFrom(BrandedContentShadowIGMediaID instance) {
    this.mEligibilityErrors = instance.mEligibilityErrors;
    this.mHasPermissionForPartnershipAd = instance.mHasPermissionForPartnershipAd;
    this.mId = instance.mId;
    this.mOwnerId = instance.mOwnerId;
    this.mPermalink = instance.mPermalink;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BrandedContentShadowIGMediaID> getParser() {
    return new APIRequest.ResponseParser<BrandedContentShadowIGMediaID>() {
      public APINodeList<BrandedContentShadowIGMediaID> parseResponse(String response, APIContext context, APIRequest<BrandedContentShadowIGMediaID> request, String header) throws MalformedResponseException {
        return BrandedContentShadowIGMediaID.parseResponse(response, context, request, header);
      }
    };
  }
}
