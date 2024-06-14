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
public class WhatsAppBusinessPartnerClientVerificationSubmission extends APINode {
  @SerializedName("client_business_id")
  private String mClientBusinessId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("rejection_reasons")
  private List<EnumRejectionReasons> mRejectionReasons = null;
  @SerializedName("submitted_info")
  private Object mSubmittedInfo = null;
  @SerializedName("submitted_time")
  private String mSubmittedTime = null;
  @SerializedName("update_time")
  private String mUpdateTime = null;
  @SerializedName("verification_status")
  private EnumVerificationStatus mVerificationStatus = null;
  protected static Gson gson = null;

  public WhatsAppBusinessPartnerClientVerificationSubmission() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static WhatsAppBusinessPartnerClientVerificationSubmission loadJSON(String json, APIContext context, String header) {
    WhatsAppBusinessPartnerClientVerificationSubmission whatsAppBusinessPartnerClientVerificationSubmission = getGson().fromJson(json, WhatsAppBusinessPartnerClientVerificationSubmission.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(whatsAppBusinessPartnerClientVerificationSubmission.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    whatsAppBusinessPartnerClientVerificationSubmission.context = context;
    whatsAppBusinessPartnerClientVerificationSubmission.rawValue = json;
    whatsAppBusinessPartnerClientVerificationSubmission.header = header;
    return whatsAppBusinessPartnerClientVerificationSubmission;
  }

  public static APINodeList<WhatsAppBusinessPartnerClientVerificationSubmission> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<WhatsAppBusinessPartnerClientVerificationSubmission> whatsAppBusinessPartnerClientVerificationSubmissions = new APINodeList<WhatsAppBusinessPartnerClientVerificationSubmission>(request, json, header);
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
          whatsAppBusinessPartnerClientVerificationSubmissions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return whatsAppBusinessPartnerClientVerificationSubmissions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                whatsAppBusinessPartnerClientVerificationSubmissions.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            whatsAppBusinessPartnerClientVerificationSubmissions.setPaging(previous, next);
            if (context.hasAppSecret()) {
              whatsAppBusinessPartnerClientVerificationSubmissions.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              whatsAppBusinessPartnerClientVerificationSubmissions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  whatsAppBusinessPartnerClientVerificationSubmissions.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              whatsAppBusinessPartnerClientVerificationSubmissions.add(loadJSON(obj.toString(), context, header));
            }
          }
          return whatsAppBusinessPartnerClientVerificationSubmissions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              whatsAppBusinessPartnerClientVerificationSubmissions.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return whatsAppBusinessPartnerClientVerificationSubmissions;
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
              whatsAppBusinessPartnerClientVerificationSubmissions.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return whatsAppBusinessPartnerClientVerificationSubmissions;
          }

          // Sixth, check if it's pure JsonObject
          whatsAppBusinessPartnerClientVerificationSubmissions.clear();
          whatsAppBusinessPartnerClientVerificationSubmissions.add(loadJSON(json, context, header));
          return whatsAppBusinessPartnerClientVerificationSubmissions;
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


  public String getFieldClientBusinessId() {
    return mClientBusinessId;
  }

  public WhatsAppBusinessPartnerClientVerificationSubmission setFieldClientBusinessId(String value) {
    this.mClientBusinessId = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public WhatsAppBusinessPartnerClientVerificationSubmission setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public List<EnumRejectionReasons> getFieldRejectionReasons() {
    return mRejectionReasons;
  }

  public WhatsAppBusinessPartnerClientVerificationSubmission setFieldRejectionReasons(List<EnumRejectionReasons> value) {
    this.mRejectionReasons = value;
    return this;
  }

  public Object getFieldSubmittedInfo() {
    return mSubmittedInfo;
  }

  public WhatsAppBusinessPartnerClientVerificationSubmission setFieldSubmittedInfo(Object value) {
    this.mSubmittedInfo = value;
    return this;
  }

  public String getFieldSubmittedTime() {
    return mSubmittedTime;
  }

  public WhatsAppBusinessPartnerClientVerificationSubmission setFieldSubmittedTime(String value) {
    this.mSubmittedTime = value;
    return this;
  }

  public String getFieldUpdateTime() {
    return mUpdateTime;
  }

  public WhatsAppBusinessPartnerClientVerificationSubmission setFieldUpdateTime(String value) {
    this.mUpdateTime = value;
    return this;
  }

  public EnumVerificationStatus getFieldVerificationStatus() {
    return mVerificationStatus;
  }

  public WhatsAppBusinessPartnerClientVerificationSubmission setFieldVerificationStatus(EnumVerificationStatus value) {
    this.mVerificationStatus = value;
    return this;
  }



  public static enum EnumRejectionReasons {
      @SerializedName("ADDRESS_NOT_MATCHING")
      VALUE_ADDRESS_NOT_MATCHING("ADDRESS_NOT_MATCHING"),
      @SerializedName("LEGAL_NAME_NOT_MATCHING")
      VALUE_LEGAL_NAME_NOT_MATCHING("LEGAL_NAME_NOT_MATCHING"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("WEBSITE_NOT_MATCHING")
      VALUE_WEBSITE_NOT_MATCHING("WEBSITE_NOT_MATCHING"),
      ;

      private String value;

      private EnumRejectionReasons(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumVerificationStatus {
      @SerializedName("APPROVED")
      VALUE_APPROVED("APPROVED"),
      @SerializedName("FAILED")
      VALUE_FAILED("FAILED"),
      @SerializedName("PENDING")
      VALUE_PENDING("PENDING"),
      @SerializedName("REVOKED")
      VALUE_REVOKED("REVOKED"),
      ;

      private String value;

      private EnumVerificationStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
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

  public WhatsAppBusinessPartnerClientVerificationSubmission copyFrom(WhatsAppBusinessPartnerClientVerificationSubmission instance) {
    this.mClientBusinessId = instance.mClientBusinessId;
    this.mId = instance.mId;
    this.mRejectionReasons = instance.mRejectionReasons;
    this.mSubmittedInfo = instance.mSubmittedInfo;
    this.mSubmittedTime = instance.mSubmittedTime;
    this.mUpdateTime = instance.mUpdateTime;
    this.mVerificationStatus = instance.mVerificationStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<WhatsAppBusinessPartnerClientVerificationSubmission> getParser() {
    return new APIRequest.ResponseParser<WhatsAppBusinessPartnerClientVerificationSubmission>() {
      public APINodeList<WhatsAppBusinessPartnerClientVerificationSubmission> parseResponse(String response, APIContext context, APIRequest<WhatsAppBusinessPartnerClientVerificationSubmission> request, String header) throws MalformedResponseException {
        return WhatsAppBusinessPartnerClientVerificationSubmission.parseResponse(response, context, request, header);
      }
    };
  }
}
