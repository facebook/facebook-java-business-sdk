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
public class AudienceSharingAccountValid extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("account_type")
  private String mAccountType = null;
  @SerializedName("business_id")
  private String mBusinessId = null;
  @SerializedName("business_name")
  private String mBusinessName = null;
  @SerializedName("can_ad_account_use_lookalike_container")
  private Boolean mCanAdAccountUseLookalikeContainer = null;
  @SerializedName("sharing_agreement_status")
  private Long mSharingAgreementStatus = null;
  protected static Gson gson = null;

  public AudienceSharingAccountValid() {
  }

  public String getId() {
    return null;
  }
  public static AudienceSharingAccountValid loadJSON(String json, APIContext context, String header) {
    AudienceSharingAccountValid audienceSharingAccountValid = getGson().fromJson(json, AudienceSharingAccountValid.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(audienceSharingAccountValid.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    audienceSharingAccountValid.context = context;
    audienceSharingAccountValid.rawValue = json;
    audienceSharingAccountValid.header = header;
    return audienceSharingAccountValid;
  }

  public static APINodeList<AudienceSharingAccountValid> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AudienceSharingAccountValid> audienceSharingAccountValids = new APINodeList<AudienceSharingAccountValid>(request, json, header);
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
          audienceSharingAccountValids.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return audienceSharingAccountValids;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                audienceSharingAccountValids.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            audienceSharingAccountValids.setPaging(previous, next);
            if (context.hasAppSecret()) {
              audienceSharingAccountValids.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              audienceSharingAccountValids.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  audienceSharingAccountValids.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              audienceSharingAccountValids.add(loadJSON(obj.toString(), context, header));
            }
          }
          return audienceSharingAccountValids;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              audienceSharingAccountValids.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return audienceSharingAccountValids;
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
              audienceSharingAccountValids.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return audienceSharingAccountValids;
          }

          // Sixth, check if it's pure JsonObject
          audienceSharingAccountValids.clear();
          audienceSharingAccountValids.add(loadJSON(json, context, header));
          return audienceSharingAccountValids;
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

  public AudienceSharingAccountValid setFieldAccountId(String value) {
    this.mAccountId = value;
    return this;
  }

  public String getFieldAccountType() {
    return mAccountType;
  }

  public AudienceSharingAccountValid setFieldAccountType(String value) {
    this.mAccountType = value;
    return this;
  }

  public String getFieldBusinessId() {
    return mBusinessId;
  }

  public AudienceSharingAccountValid setFieldBusinessId(String value) {
    this.mBusinessId = value;
    return this;
  }

  public String getFieldBusinessName() {
    return mBusinessName;
  }

  public AudienceSharingAccountValid setFieldBusinessName(String value) {
    this.mBusinessName = value;
    return this;
  }

  public Boolean getFieldCanAdAccountUseLookalikeContainer() {
    return mCanAdAccountUseLookalikeContainer;
  }

  public AudienceSharingAccountValid setFieldCanAdAccountUseLookalikeContainer(Boolean value) {
    this.mCanAdAccountUseLookalikeContainer = value;
    return this;
  }

  public Long getFieldSharingAgreementStatus() {
    return mSharingAgreementStatus;
  }

  public AudienceSharingAccountValid setFieldSharingAgreementStatus(Long value) {
    this.mSharingAgreementStatus = value;
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

  public AudienceSharingAccountValid copyFrom(AudienceSharingAccountValid instance) {
    this.mAccountId = instance.mAccountId;
    this.mAccountType = instance.mAccountType;
    this.mBusinessId = instance.mBusinessId;
    this.mBusinessName = instance.mBusinessName;
    this.mCanAdAccountUseLookalikeContainer = instance.mCanAdAccountUseLookalikeContainer;
    this.mSharingAgreementStatus = instance.mSharingAgreementStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AudienceSharingAccountValid> getParser() {
    return new APIRequest.ResponseParser<AudienceSharingAccountValid>() {
      public APINodeList<AudienceSharingAccountValid> parseResponse(String response, APIContext context, APIRequest<AudienceSharingAccountValid> request, String header) throws MalformedResponseException {
        return AudienceSharingAccountValid.parseResponse(response, context, request, header);
      }
    };
  }
}
