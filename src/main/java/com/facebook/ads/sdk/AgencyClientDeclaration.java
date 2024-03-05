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
public class AgencyClientDeclaration extends APINode {
  @SerializedName("agency_representing_client")
  private Long mAgencyRepresentingClient = null;
  @SerializedName("client_based_in_france")
  private Long mClientBasedInFrance = null;
  @SerializedName("client_city")
  private String mClientCity = null;
  @SerializedName("client_country_code")
  private String mClientCountryCode = null;
  @SerializedName("client_email_address")
  private String mClientEmailAddress = null;
  @SerializedName("client_name")
  private String mClientName = null;
  @SerializedName("client_postal_code")
  private String mClientPostalCode = null;
  @SerializedName("client_province")
  private String mClientProvince = null;
  @SerializedName("client_street")
  private String mClientStreet = null;
  @SerializedName("client_street2")
  private String mClientStreet2 = null;
  @SerializedName("has_written_mandate_from_advertiser")
  private Long mHasWrittenMandateFromAdvertiser = null;
  @SerializedName("is_client_paying_invoices")
  private Long mIsClientPayingInvoices = null;
  protected static Gson gson = null;

  public AgencyClientDeclaration() {
  }

  public String getId() {
    return null;
  }
  public static AgencyClientDeclaration loadJSON(String json, APIContext context, String header) {
    AgencyClientDeclaration agencyClientDeclaration = getGson().fromJson(json, AgencyClientDeclaration.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(agencyClientDeclaration.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    agencyClientDeclaration.context = context;
    agencyClientDeclaration.rawValue = json;
    agencyClientDeclaration.header = header;
    return agencyClientDeclaration;
  }

  public static APINodeList<AgencyClientDeclaration> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AgencyClientDeclaration> agencyClientDeclarations = new APINodeList<AgencyClientDeclaration>(request, json, header);
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
          agencyClientDeclarations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return agencyClientDeclarations;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                agencyClientDeclarations.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            agencyClientDeclarations.setPaging(previous, next);
            if (context.hasAppSecret()) {
              agencyClientDeclarations.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              agencyClientDeclarations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  agencyClientDeclarations.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              agencyClientDeclarations.add(loadJSON(obj.toString(), context, header));
            }
          }
          return agencyClientDeclarations;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              agencyClientDeclarations.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return agencyClientDeclarations;
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
              agencyClientDeclarations.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return agencyClientDeclarations;
          }

          // Sixth, check if it's pure JsonObject
          agencyClientDeclarations.clear();
          agencyClientDeclarations.add(loadJSON(json, context, header));
          return agencyClientDeclarations;
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


  public Long getFieldAgencyRepresentingClient() {
    return mAgencyRepresentingClient;
  }

  public AgencyClientDeclaration setFieldAgencyRepresentingClient(Long value) {
    this.mAgencyRepresentingClient = value;
    return this;
  }

  public Long getFieldClientBasedInFrance() {
    return mClientBasedInFrance;
  }

  public AgencyClientDeclaration setFieldClientBasedInFrance(Long value) {
    this.mClientBasedInFrance = value;
    return this;
  }

  public String getFieldClientCity() {
    return mClientCity;
  }

  public AgencyClientDeclaration setFieldClientCity(String value) {
    this.mClientCity = value;
    return this;
  }

  public String getFieldClientCountryCode() {
    return mClientCountryCode;
  }

  public AgencyClientDeclaration setFieldClientCountryCode(String value) {
    this.mClientCountryCode = value;
    return this;
  }

  public String getFieldClientEmailAddress() {
    return mClientEmailAddress;
  }

  public AgencyClientDeclaration setFieldClientEmailAddress(String value) {
    this.mClientEmailAddress = value;
    return this;
  }

  public String getFieldClientName() {
    return mClientName;
  }

  public AgencyClientDeclaration setFieldClientName(String value) {
    this.mClientName = value;
    return this;
  }

  public String getFieldClientPostalCode() {
    return mClientPostalCode;
  }

  public AgencyClientDeclaration setFieldClientPostalCode(String value) {
    this.mClientPostalCode = value;
    return this;
  }

  public String getFieldClientProvince() {
    return mClientProvince;
  }

  public AgencyClientDeclaration setFieldClientProvince(String value) {
    this.mClientProvince = value;
    return this;
  }

  public String getFieldClientStreet() {
    return mClientStreet;
  }

  public AgencyClientDeclaration setFieldClientStreet(String value) {
    this.mClientStreet = value;
    return this;
  }

  public String getFieldClientStreet2() {
    return mClientStreet2;
  }

  public AgencyClientDeclaration setFieldClientStreet2(String value) {
    this.mClientStreet2 = value;
    return this;
  }

  public Long getFieldHasWrittenMandateFromAdvertiser() {
    return mHasWrittenMandateFromAdvertiser;
  }

  public AgencyClientDeclaration setFieldHasWrittenMandateFromAdvertiser(Long value) {
    this.mHasWrittenMandateFromAdvertiser = value;
    return this;
  }

  public Long getFieldIsClientPayingInvoices() {
    return mIsClientPayingInvoices;
  }

  public AgencyClientDeclaration setFieldIsClientPayingInvoices(Long value) {
    this.mIsClientPayingInvoices = value;
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

  public AgencyClientDeclaration copyFrom(AgencyClientDeclaration instance) {
    this.mAgencyRepresentingClient = instance.mAgencyRepresentingClient;
    this.mClientBasedInFrance = instance.mClientBasedInFrance;
    this.mClientCity = instance.mClientCity;
    this.mClientCountryCode = instance.mClientCountryCode;
    this.mClientEmailAddress = instance.mClientEmailAddress;
    this.mClientName = instance.mClientName;
    this.mClientPostalCode = instance.mClientPostalCode;
    this.mClientProvince = instance.mClientProvince;
    this.mClientStreet = instance.mClientStreet;
    this.mClientStreet2 = instance.mClientStreet2;
    this.mHasWrittenMandateFromAdvertiser = instance.mHasWrittenMandateFromAdvertiser;
    this.mIsClientPayingInvoices = instance.mIsClientPayingInvoices;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AgencyClientDeclaration> getParser() {
    return new APIRequest.ResponseParser<AgencyClientDeclaration>() {
      public APINodeList<AgencyClientDeclaration> parseResponse(String response, APIContext context, APIRequest<AgencyClientDeclaration> request, String header) throws MalformedResponseException {
        return AgencyClientDeclaration.parseResponse(response, context, request, header);
      }
    };
  }
}
