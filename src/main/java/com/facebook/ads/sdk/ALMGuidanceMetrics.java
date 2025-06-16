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
public class ALMGuidanceMetrics extends APINode {
  @SerializedName("ad_account_id")
  private String mAdAccountId = null;
  @SerializedName("adopted_objects")
  private List<Object> mAdoptedObjects = null;
  @SerializedName("guidance_name")
  private String mGuidanceName = null;
  @SerializedName("guidance_type")
  private String mGuidanceType = null;
  @SerializedName("l28_adoption")
  private Long mL28Adoption = null;
  @SerializedName("l28_available")
  private Long mL28Available = null;
  @SerializedName("l28_click")
  private Long mL28Click = null;
  @SerializedName("l28_conversion")
  private Long mL28Conversion = null;
  @SerializedName("l28_has_click")
  private Boolean mL28HasClick = null;
  @SerializedName("l28_has_impression")
  private Boolean mL28HasImpression = null;
  @SerializedName("l28_impression")
  private Long mL28Impression = null;
  @SerializedName("l28_is_actioned")
  private Boolean mL28IsActioned = null;
  @SerializedName("l28_is_adopted")
  private Boolean mL28IsAdopted = null;
  @SerializedName("l28_is_available")
  private Boolean mL28IsAvailable = null;
  @SerializedName("l28_is_pitched")
  private Boolean mL28IsPitched = null;
  @SerializedName("l28_pitch")
  private Long mL28Pitch = null;
  @SerializedName("l28d_adopted_revenue")
  private Double mL28dAdoptedRevenue = null;
  @SerializedName("last_actioned_ds")
  private String mLastActionedDs = null;
  @SerializedName("last_adopted_ds")
  private String mLastAdoptedDs = null;
  @SerializedName("last_pitch_ds")
  private String mLastPitchDs = null;
  @SerializedName("parent_advertiser_id")
  private String mParentAdvertiserId = null;
  @SerializedName("report_ds")
  private String mReportDs = null;
  protected static Gson gson = null;

  public ALMGuidanceMetrics() {
  }

  public String getId() {
    return null;
  }
  public static ALMGuidanceMetrics loadJSON(String json, APIContext context, String header) {
    ALMGuidanceMetrics almGuidanceMetrics = getGson().fromJson(json, ALMGuidanceMetrics.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(almGuidanceMetrics.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    almGuidanceMetrics.context = context;
    almGuidanceMetrics.rawValue = json;
    almGuidanceMetrics.header = header;
    return almGuidanceMetrics;
  }

  public static APINodeList<ALMGuidanceMetrics> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ALMGuidanceMetrics> almGuidanceMetricss = new APINodeList<ALMGuidanceMetrics>(request, json, header);
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
          almGuidanceMetricss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return almGuidanceMetricss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                almGuidanceMetricss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            almGuidanceMetricss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              almGuidanceMetricss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              almGuidanceMetricss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  almGuidanceMetricss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              almGuidanceMetricss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return almGuidanceMetricss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              almGuidanceMetricss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return almGuidanceMetricss;
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
              almGuidanceMetricss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return almGuidanceMetricss;
          }

          // Sixth, check if it's pure JsonObject
          almGuidanceMetricss.clear();
          almGuidanceMetricss.add(loadJSON(json, context, header));
          return almGuidanceMetricss;
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


  public String getFieldAdAccountId() {
    return mAdAccountId;
  }

  public ALMGuidanceMetrics setFieldAdAccountId(String value) {
    this.mAdAccountId = value;
    return this;
  }

  public List<Object> getFieldAdoptedObjects() {
    return mAdoptedObjects;
  }

  public ALMGuidanceMetrics setFieldAdoptedObjects(List<Object> value) {
    this.mAdoptedObjects = value;
    return this;
  }

  public String getFieldGuidanceName() {
    return mGuidanceName;
  }

  public ALMGuidanceMetrics setFieldGuidanceName(String value) {
    this.mGuidanceName = value;
    return this;
  }

  public String getFieldGuidanceType() {
    return mGuidanceType;
  }

  public ALMGuidanceMetrics setFieldGuidanceType(String value) {
    this.mGuidanceType = value;
    return this;
  }

  public Long getFieldL28Adoption() {
    return mL28Adoption;
  }

  public ALMGuidanceMetrics setFieldL28Adoption(Long value) {
    this.mL28Adoption = value;
    return this;
  }

  public Long getFieldL28Available() {
    return mL28Available;
  }

  public ALMGuidanceMetrics setFieldL28Available(Long value) {
    this.mL28Available = value;
    return this;
  }

  public Long getFieldL28Click() {
    return mL28Click;
  }

  public ALMGuidanceMetrics setFieldL28Click(Long value) {
    this.mL28Click = value;
    return this;
  }

  public Long getFieldL28Conversion() {
    return mL28Conversion;
  }

  public ALMGuidanceMetrics setFieldL28Conversion(Long value) {
    this.mL28Conversion = value;
    return this;
  }

  public Boolean getFieldL28HasClick() {
    return mL28HasClick;
  }

  public ALMGuidanceMetrics setFieldL28HasClick(Boolean value) {
    this.mL28HasClick = value;
    return this;
  }

  public Boolean getFieldL28HasImpression() {
    return mL28HasImpression;
  }

  public ALMGuidanceMetrics setFieldL28HasImpression(Boolean value) {
    this.mL28HasImpression = value;
    return this;
  }

  public Long getFieldL28Impression() {
    return mL28Impression;
  }

  public ALMGuidanceMetrics setFieldL28Impression(Long value) {
    this.mL28Impression = value;
    return this;
  }

  public Boolean getFieldL28IsActioned() {
    return mL28IsActioned;
  }

  public ALMGuidanceMetrics setFieldL28IsActioned(Boolean value) {
    this.mL28IsActioned = value;
    return this;
  }

  public Boolean getFieldL28IsAdopted() {
    return mL28IsAdopted;
  }

  public ALMGuidanceMetrics setFieldL28IsAdopted(Boolean value) {
    this.mL28IsAdopted = value;
    return this;
  }

  public Boolean getFieldL28IsAvailable() {
    return mL28IsAvailable;
  }

  public ALMGuidanceMetrics setFieldL28IsAvailable(Boolean value) {
    this.mL28IsAvailable = value;
    return this;
  }

  public Boolean getFieldL28IsPitched() {
    return mL28IsPitched;
  }

  public ALMGuidanceMetrics setFieldL28IsPitched(Boolean value) {
    this.mL28IsPitched = value;
    return this;
  }

  public Long getFieldL28Pitch() {
    return mL28Pitch;
  }

  public ALMGuidanceMetrics setFieldL28Pitch(Long value) {
    this.mL28Pitch = value;
    return this;
  }

  public Double getFieldL28dAdoptedRevenue() {
    return mL28dAdoptedRevenue;
  }

  public ALMGuidanceMetrics setFieldL28dAdoptedRevenue(Double value) {
    this.mL28dAdoptedRevenue = value;
    return this;
  }

  public String getFieldLastActionedDs() {
    return mLastActionedDs;
  }

  public ALMGuidanceMetrics setFieldLastActionedDs(String value) {
    this.mLastActionedDs = value;
    return this;
  }

  public String getFieldLastAdoptedDs() {
    return mLastAdoptedDs;
  }

  public ALMGuidanceMetrics setFieldLastAdoptedDs(String value) {
    this.mLastAdoptedDs = value;
    return this;
  }

  public String getFieldLastPitchDs() {
    return mLastPitchDs;
  }

  public ALMGuidanceMetrics setFieldLastPitchDs(String value) {
    this.mLastPitchDs = value;
    return this;
  }

  public String getFieldParentAdvertiserId() {
    return mParentAdvertiserId;
  }

  public ALMGuidanceMetrics setFieldParentAdvertiserId(String value) {
    this.mParentAdvertiserId = value;
    return this;
  }

  public String getFieldReportDs() {
    return mReportDs;
  }

  public ALMGuidanceMetrics setFieldReportDs(String value) {
    this.mReportDs = value;
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

  public ALMGuidanceMetrics copyFrom(ALMGuidanceMetrics instance) {
    this.mAdAccountId = instance.mAdAccountId;
    this.mAdoptedObjects = instance.mAdoptedObjects;
    this.mGuidanceName = instance.mGuidanceName;
    this.mGuidanceType = instance.mGuidanceType;
    this.mL28Adoption = instance.mL28Adoption;
    this.mL28Available = instance.mL28Available;
    this.mL28Click = instance.mL28Click;
    this.mL28Conversion = instance.mL28Conversion;
    this.mL28HasClick = instance.mL28HasClick;
    this.mL28HasImpression = instance.mL28HasImpression;
    this.mL28Impression = instance.mL28Impression;
    this.mL28IsActioned = instance.mL28IsActioned;
    this.mL28IsAdopted = instance.mL28IsAdopted;
    this.mL28IsAvailable = instance.mL28IsAvailable;
    this.mL28IsPitched = instance.mL28IsPitched;
    this.mL28Pitch = instance.mL28Pitch;
    this.mL28dAdoptedRevenue = instance.mL28dAdoptedRevenue;
    this.mLastActionedDs = instance.mLastActionedDs;
    this.mLastAdoptedDs = instance.mLastAdoptedDs;
    this.mLastPitchDs = instance.mLastPitchDs;
    this.mParentAdvertiserId = instance.mParentAdvertiserId;
    this.mReportDs = instance.mReportDs;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ALMGuidanceMetrics> getParser() {
    return new APIRequest.ResponseParser<ALMGuidanceMetrics>() {
      public APINodeList<ALMGuidanceMetrics> parseResponse(String response, APIContext context, APIRequest<ALMGuidanceMetrics> request, String header) throws MalformedResponseException {
        return ALMGuidanceMetrics.parseResponse(response, context, request, header);
      }
    };
  }
}
