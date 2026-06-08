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
public class AdCreativeAppExperienceSpec extends APINode {
  @SerializedName("reveal_details")
  private Object mRevealDetails = null;
  @SerializedName("show_spotlights")
  private Object mShowSpotlights = null;
  @SerializedName("website_summary")
  private Object mWebsiteSummary = null;
  protected static Gson gson = null;

  public AdCreativeAppExperienceSpec() {
  }

  public String getId() {
    return null;
  }
  public static AdCreativeAppExperienceSpec loadJSON(String json, APIContext context, String header) {
    AdCreativeAppExperienceSpec adCreativeAppExperienceSpec = getGson().fromJson(json, AdCreativeAppExperienceSpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeAppExperienceSpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCreativeAppExperienceSpec.context = context;
    adCreativeAppExperienceSpec.rawValue = json;
    adCreativeAppExperienceSpec.header = header;
    return adCreativeAppExperienceSpec;
  }

  public static APINodeList<AdCreativeAppExperienceSpec> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCreativeAppExperienceSpec> adCreativeAppExperienceSpecs = new APINodeList<AdCreativeAppExperienceSpec>(request, json, header);
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
          adCreativeAppExperienceSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCreativeAppExperienceSpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeAppExperienceSpecs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeAppExperienceSpecs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeAppExperienceSpecs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeAppExperienceSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCreativeAppExperienceSpecs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeAppExperienceSpecs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCreativeAppExperienceSpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeAppExperienceSpecs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCreativeAppExperienceSpecs;
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
              adCreativeAppExperienceSpecs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeAppExperienceSpecs;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeAppExperienceSpecs.clear();
          adCreativeAppExperienceSpecs.add(loadJSON(json, context, header));
          return adCreativeAppExperienceSpecs;
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


  public Object getFieldRevealDetails() {
    return mRevealDetails;
  }

  public AdCreativeAppExperienceSpec setFieldRevealDetails(Object value) {
    this.mRevealDetails = value;
    return this;
  }

  public Object getFieldShowSpotlights() {
    return mShowSpotlights;
  }

  public AdCreativeAppExperienceSpec setFieldShowSpotlights(Object value) {
    this.mShowSpotlights = value;
    return this;
  }

  public Object getFieldWebsiteSummary() {
    return mWebsiteSummary;
  }

  public AdCreativeAppExperienceSpec setFieldWebsiteSummary(Object value) {
    this.mWebsiteSummary = value;
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

  public AdCreativeAppExperienceSpec copyFrom(AdCreativeAppExperienceSpec instance) {
    this.mRevealDetails = instance.mRevealDetails;
    this.mShowSpotlights = instance.mShowSpotlights;
    this.mWebsiteSummary = instance.mWebsiteSummary;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeAppExperienceSpec> getParser() {
    return new APIRequest.ResponseParser<AdCreativeAppExperienceSpec>() {
      public APINodeList<AdCreativeAppExperienceSpec> parseResponse(String response, APIContext context, APIRequest<AdCreativeAppExperienceSpec> request, String header) throws MalformedResponseException {
        return AdCreativeAppExperienceSpec.parseResponse(response, context, request, header);
      }
    };
  }
}
