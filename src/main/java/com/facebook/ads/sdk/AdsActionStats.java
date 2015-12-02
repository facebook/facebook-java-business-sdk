/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class AdsActionStats extends APINode {
  @SerializedName("action_carousel_card_id")
  private String mActionCarouselCardId = null;
  @SerializedName("action_carousel_card_name")
  private String mActionCarouselCardName = null;
  @SerializedName("action_destination")
  private String mActionDestination = null;
  @SerializedName("action_device")
  private String mActionDevice = null;
  @SerializedName("action_target_id")
  private String mActionTargetId = null;
  @SerializedName("action_type")
  private String mActionType = null;
  @SerializedName("action_video_type")
  private String mActionVideoType = null;
  @SerializedName("value")
  private Double mValue = null;
  @SerializedName("1d_view")
  private Double m1dView = null;
  @SerializedName("7d_view")
  private Double m7dView = null;
  @SerializedName("28d_view")
  private Double m28dView = null;
  @SerializedName("1d_click")
  private Double m1dClick = null;
  @SerializedName("7d_click")
  private Double m7dClick = null;
  @SerializedName("28d_click")
  private Double m28dClick = null;
  protected static Gson gson = null;

  public AdsActionStats() {
  }

  public String getId() {
    return null;
  }
  public static AdsActionStats loadJSON(String json, APIContext context) {
    AdsActionStats adsActionStats = getGson().fromJson(json, AdsActionStats.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsActionStats.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adsActionStats.mContext = context;
    adsActionStats.rawValue = json;
    return adsActionStats;
  }

  public static APINodeList<AdsActionStats> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<AdsActionStats> adsActionStatss = new APINodeList<AdsActionStats>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adsActionStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adsActionStatss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            adsActionStatss.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsActionStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            adsActionStatss.add(loadJSON(obj.toString(), context));
          }
          return adsActionStatss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsActionStatss.add(loadJSON(entry.getValue().toString(), context));
          }
          return adsActionStatss;
        } else {
          // Fifth, check if it's pure JsonObject
          adsActionStatss.add(loadJSON(json, context));
          return adsActionStatss;
        }
      }
    } catch (Exception e) {
    }
    return null;
  }

  @Override
  public APIContext getContext() {
    return mContext;
  }

  @Override
  public void setContext(APIContext context) {
    mContext = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }


  public String getFieldActionCarouselCardId() {
    return mActionCarouselCardId;
  }

  public AdsActionStats setFieldActionCarouselCardId(String value) {
    this.mActionCarouselCardId = value;
    return this;
  }

  public String getFieldActionCarouselCardName() {
    return mActionCarouselCardName;
  }

  public AdsActionStats setFieldActionCarouselCardName(String value) {
    this.mActionCarouselCardName = value;
    return this;
  }

  public String getFieldActionDestination() {
    return mActionDestination;
  }

  public AdsActionStats setFieldActionDestination(String value) {
    this.mActionDestination = value;
    return this;
  }

  public String getFieldActionDevice() {
    return mActionDevice;
  }

  public AdsActionStats setFieldActionDevice(String value) {
    this.mActionDevice = value;
    return this;
  }

  public String getFieldActionTargetId() {
    return mActionTargetId;
  }

  public AdsActionStats setFieldActionTargetId(String value) {
    this.mActionTargetId = value;
    return this;
  }

  public String getFieldActionType() {
    return mActionType;
  }

  public AdsActionStats setFieldActionType(String value) {
    this.mActionType = value;
    return this;
  }

  public String getFieldActionVideoType() {
    return mActionVideoType;
  }

  public AdsActionStats setFieldActionVideoType(String value) {
    this.mActionVideoType = value;
    return this;
  }

  public Double getFieldValue() {
    return mValue;
  }

  public AdsActionStats setFieldValue(Double value) {
    this.mValue = value;
    return this;
  }

  public Double getField1dView() {
    return m1dView;
  }

  public AdsActionStats setField1dView(Double value) {
    this.m1dView = value;
    return this;
  }

  public Double getField7dView() {
    return m7dView;
  }

  public AdsActionStats setField7dView(Double value) {
    this.m7dView = value;
    return this;
  }

  public Double getField28dView() {
    return m28dView;
  }

  public AdsActionStats setField28dView(Double value) {
    this.m28dView = value;
    return this;
  }

  public Double getField1dClick() {
    return m1dClick;
  }

  public AdsActionStats setField1dClick(Double value) {
    this.m1dClick = value;
    return this;
  }

  public Double getField7dClick() {
    return m7dClick;
  }

  public AdsActionStats setField7dClick(Double value) {
    this.m7dClick = value;
    return this;
  }

  public Double getField28dClick() {
    return m28dClick;
  }

  public AdsActionStats setField28dClick(Double value) {
    this.m28dClick = value;
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

  public AdsActionStats copyFrom(AdsActionStats instance) {
    this.mActionCarouselCardId = instance.mActionCarouselCardId;
    this.mActionCarouselCardName = instance.mActionCarouselCardName;
    this.mActionDestination = instance.mActionDestination;
    this.mActionDevice = instance.mActionDevice;
    this.mActionTargetId = instance.mActionTargetId;
    this.mActionType = instance.mActionType;
    this.mActionVideoType = instance.mActionVideoType;
    this.mValue = instance.mValue;
    this.m1dView = instance.m1dView;
    this.m7dView = instance.m7dView;
    this.m28dView = instance.m28dView;
    this.m1dClick = instance.m1dClick;
    this.m7dClick = instance.m7dClick;
    this.m28dClick = instance.m28dClick;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}