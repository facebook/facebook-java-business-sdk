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
public class LeadGenThankYouPage extends APINode {
  @SerializedName("body")
  private String mBody = null;
  @SerializedName("business_phone_number")
  private String mBusinessPhoneNumber = null;
  @SerializedName("button_text")
  private String mButtonText = null;
  @SerializedName("button_type")
  private String mButtonType = null;
  @SerializedName("country_code")
  private String mCountryCode = null;
  @SerializedName("enable_messenger")
  private Boolean mEnableMessenger = null;
  @SerializedName("gated_file")
  private LeadGenThankYouPageGatedFile mGatedFile = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("lead_gen_use_case")
  private String mLeadGenUseCase = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("website_url")
  private String mWebsiteUrl = null;
  protected static Gson gson = null;

  public LeadGenThankYouPage() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static LeadGenThankYouPage loadJSON(String json, APIContext context, String header) {
    LeadGenThankYouPage leadGenThankYouPage = getGson().fromJson(json, LeadGenThankYouPage.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(leadGenThankYouPage.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    leadGenThankYouPage.context = context;
    leadGenThankYouPage.rawValue = json;
    leadGenThankYouPage.header = header;
    return leadGenThankYouPage;
  }

  public static APINodeList<LeadGenThankYouPage> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<LeadGenThankYouPage> leadGenThankYouPages = new APINodeList<LeadGenThankYouPage>(request, json, header);
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
          leadGenThankYouPages.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return leadGenThankYouPages;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                leadGenThankYouPages.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            leadGenThankYouPages.setPaging(previous, next);
            if (context.hasAppSecret()) {
              leadGenThankYouPages.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              leadGenThankYouPages.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  leadGenThankYouPages.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              leadGenThankYouPages.add(loadJSON(obj.toString(), context, header));
            }
          }
          return leadGenThankYouPages;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              leadGenThankYouPages.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return leadGenThankYouPages;
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
              leadGenThankYouPages.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return leadGenThankYouPages;
          }

          // Sixth, check if it's pure JsonObject
          leadGenThankYouPages.clear();
          leadGenThankYouPages.add(loadJSON(json, context, header));
          return leadGenThankYouPages;
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


  public String getFieldBody() {
    return mBody;
  }

  public LeadGenThankYouPage setFieldBody(String value) {
    this.mBody = value;
    return this;
  }

  public String getFieldBusinessPhoneNumber() {
    return mBusinessPhoneNumber;
  }

  public LeadGenThankYouPage setFieldBusinessPhoneNumber(String value) {
    this.mBusinessPhoneNumber = value;
    return this;
  }

  public String getFieldButtonText() {
    return mButtonText;
  }

  public LeadGenThankYouPage setFieldButtonText(String value) {
    this.mButtonText = value;
    return this;
  }

  public String getFieldButtonType() {
    return mButtonType;
  }

  public LeadGenThankYouPage setFieldButtonType(String value) {
    this.mButtonType = value;
    return this;
  }

  public String getFieldCountryCode() {
    return mCountryCode;
  }

  public LeadGenThankYouPage setFieldCountryCode(String value) {
    this.mCountryCode = value;
    return this;
  }

  public Boolean getFieldEnableMessenger() {
    return mEnableMessenger;
  }

  public LeadGenThankYouPage setFieldEnableMessenger(Boolean value) {
    this.mEnableMessenger = value;
    return this;
  }

  public LeadGenThankYouPageGatedFile getFieldGatedFile() {
    return mGatedFile;
  }

  public LeadGenThankYouPage setFieldGatedFile(LeadGenThankYouPageGatedFile value) {
    this.mGatedFile = value;
    return this;
  }

  public LeadGenThankYouPage setFieldGatedFile(String value) {
    Type type = new TypeToken<LeadGenThankYouPageGatedFile>(){}.getType();
    this.mGatedFile = LeadGenThankYouPageGatedFile.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldId() {
    return mId;
  }

  public LeadGenThankYouPage setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldLeadGenUseCase() {
    return mLeadGenUseCase;
  }

  public LeadGenThankYouPage setFieldLeadGenUseCase(String value) {
    this.mLeadGenUseCase = value;
    return this;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public LeadGenThankYouPage setFieldStatus(String value) {
    this.mStatus = value;
    return this;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public LeadGenThankYouPage setFieldTitle(String value) {
    this.mTitle = value;
    return this;
  }

  public String getFieldWebsiteUrl() {
    return mWebsiteUrl;
  }

  public LeadGenThankYouPage setFieldWebsiteUrl(String value) {
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

  public LeadGenThankYouPage copyFrom(LeadGenThankYouPage instance) {
    this.mBody = instance.mBody;
    this.mBusinessPhoneNumber = instance.mBusinessPhoneNumber;
    this.mButtonText = instance.mButtonText;
    this.mButtonType = instance.mButtonType;
    this.mCountryCode = instance.mCountryCode;
    this.mEnableMessenger = instance.mEnableMessenger;
    this.mGatedFile = instance.mGatedFile;
    this.mId = instance.mId;
    this.mLeadGenUseCase = instance.mLeadGenUseCase;
    this.mStatus = instance.mStatus;
    this.mTitle = instance.mTitle;
    this.mWebsiteUrl = instance.mWebsiteUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LeadGenThankYouPage> getParser() {
    return new APIRequest.ResponseParser<LeadGenThankYouPage>() {
      public APINodeList<LeadGenThankYouPage> parseResponse(String response, APIContext context, APIRequest<LeadGenThankYouPage> request, String header) throws MalformedResponseException {
        return LeadGenThankYouPage.parseResponse(response, context, request, header);
      }
    };
  }
}
