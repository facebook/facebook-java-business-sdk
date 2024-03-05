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
public class LookalikeSpec extends APINode {
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("is_financial_service")
  private Boolean mIsFinancialService = null;
  @SerializedName("origin")
  private List<Object> mOrigin = null;
  @SerializedName("origin_event_name")
  private String mOriginEventName = null;
  @SerializedName("origin_event_source_name")
  private String mOriginEventSourceName = null;
  @SerializedName("origin_event_source_type")
  private String mOriginEventSourceType = null;
  @SerializedName("product_set_name")
  private String mProductSetName = null;
  @SerializedName("ratio")
  private Double mRatio = null;
  @SerializedName("starting_ratio")
  private Double mStartingRatio = null;
  @SerializedName("target_countries")
  private List<String> mTargetCountries = null;
  @SerializedName("target_country_names")
  private JsonArray mTargetCountryNames = null;
  @SerializedName("type")
  private String mType = null;
  protected static Gson gson = null;

  public LookalikeSpec() {
  }

  public String getId() {
    return null;
  }
  public static LookalikeSpec loadJSON(String json, APIContext context, String header) {
    LookalikeSpec lookalikeSpec = getGson().fromJson(json, LookalikeSpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(lookalikeSpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    lookalikeSpec.context = context;
    lookalikeSpec.rawValue = json;
    lookalikeSpec.header = header;
    return lookalikeSpec;
  }

  public static APINodeList<LookalikeSpec> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<LookalikeSpec> lookalikeSpecs = new APINodeList<LookalikeSpec>(request, json, header);
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
          lookalikeSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return lookalikeSpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                lookalikeSpecs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            lookalikeSpecs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              lookalikeSpecs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              lookalikeSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  lookalikeSpecs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              lookalikeSpecs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return lookalikeSpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              lookalikeSpecs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return lookalikeSpecs;
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
              lookalikeSpecs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return lookalikeSpecs;
          }

          // Sixth, check if it's pure JsonObject
          lookalikeSpecs.clear();
          lookalikeSpecs.add(loadJSON(json, context, header));
          return lookalikeSpecs;
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


  public String getFieldCountry() {
    return mCountry;
  }

  public LookalikeSpec setFieldCountry(String value) {
    this.mCountry = value;
    return this;
  }

  public Boolean getFieldIsFinancialService() {
    return mIsFinancialService;
  }

  public LookalikeSpec setFieldIsFinancialService(Boolean value) {
    this.mIsFinancialService = value;
    return this;
  }

  public List<Object> getFieldOrigin() {
    return mOrigin;
  }

  public LookalikeSpec setFieldOrigin(List<Object> value) {
    this.mOrigin = value;
    return this;
  }

  public String getFieldOriginEventName() {
    return mOriginEventName;
  }

  public LookalikeSpec setFieldOriginEventName(String value) {
    this.mOriginEventName = value;
    return this;
  }

  public String getFieldOriginEventSourceName() {
    return mOriginEventSourceName;
  }

  public LookalikeSpec setFieldOriginEventSourceName(String value) {
    this.mOriginEventSourceName = value;
    return this;
  }

  public String getFieldOriginEventSourceType() {
    return mOriginEventSourceType;
  }

  public LookalikeSpec setFieldOriginEventSourceType(String value) {
    this.mOriginEventSourceType = value;
    return this;
  }

  public String getFieldProductSetName() {
    return mProductSetName;
  }

  public LookalikeSpec setFieldProductSetName(String value) {
    this.mProductSetName = value;
    return this;
  }

  public Double getFieldRatio() {
    return mRatio;
  }

  public LookalikeSpec setFieldRatio(Double value) {
    this.mRatio = value;
    return this;
  }

  public Double getFieldStartingRatio() {
    return mStartingRatio;
  }

  public LookalikeSpec setFieldStartingRatio(Double value) {
    this.mStartingRatio = value;
    return this;
  }

  public List<String> getFieldTargetCountries() {
    return mTargetCountries;
  }

  public LookalikeSpec setFieldTargetCountries(List<String> value) {
    this.mTargetCountries = value;
    return this;
  }

  public JsonArray getFieldTargetCountryNames() {
    return mTargetCountryNames;
  }

  public LookalikeSpec setFieldTargetCountryNames(JsonArray value) {
    this.mTargetCountryNames = value;
    return this;
  }

  public String getFieldType() {
    return mType;
  }

  public LookalikeSpec setFieldType(String value) {
    this.mType = value;
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

  public LookalikeSpec copyFrom(LookalikeSpec instance) {
    this.mCountry = instance.mCountry;
    this.mIsFinancialService = instance.mIsFinancialService;
    this.mOrigin = instance.mOrigin;
    this.mOriginEventName = instance.mOriginEventName;
    this.mOriginEventSourceName = instance.mOriginEventSourceName;
    this.mOriginEventSourceType = instance.mOriginEventSourceType;
    this.mProductSetName = instance.mProductSetName;
    this.mRatio = instance.mRatio;
    this.mStartingRatio = instance.mStartingRatio;
    this.mTargetCountries = instance.mTargetCountries;
    this.mTargetCountryNames = instance.mTargetCountryNames;
    this.mType = instance.mType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LookalikeSpec> getParser() {
    return new APIRequest.ResponseParser<LookalikeSpec>() {
      public APINodeList<LookalikeSpec> parseResponse(String response, APIContext context, APIRequest<LookalikeSpec> request, String header) throws MalformedResponseException {
        return LookalikeSpec.parseResponse(response, context, request, header);
      }
    };
  }
}
