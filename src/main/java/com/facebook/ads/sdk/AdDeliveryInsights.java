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
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
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
public class AdDeliveryInsights extends APINode {
  @SerializedName("ad_set_id")
  private String mAdSetId = null;
  @SerializedName("auction_competitiveness")
  private Object mAuctionCompetitiveness = null;
  @SerializedName("auction_overlap")
  private Object mAuctionOverlap = null;
  @SerializedName("audience_saturation")
  private Object mAudienceSaturation = null;
  @SerializedName("date_start")
  private String mDateStart = null;
  @SerializedName("date_stop")
  private String mDateStop = null;
  @SerializedName("report_uris")
  private List<String> mReportUris = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  public AdDeliveryInsights() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdDeliveryInsights loadJSON(String json, APIContext context, String header) {
    AdDeliveryInsights adDeliveryInsights = getGson().fromJson(json, AdDeliveryInsights.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adDeliveryInsights.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adDeliveryInsights.context = context;
    adDeliveryInsights.rawValue = json;
    adDeliveryInsights.header = header;
    return adDeliveryInsights;
  }

  public static APINodeList<AdDeliveryInsights> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdDeliveryInsights> adDeliveryInsightss = new APINodeList<AdDeliveryInsights>(request, json, header);
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
          adDeliveryInsightss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adDeliveryInsightss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adDeliveryInsightss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adDeliveryInsightss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adDeliveryInsightss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adDeliveryInsightss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adDeliveryInsightss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adDeliveryInsightss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adDeliveryInsightss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adDeliveryInsightss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adDeliveryInsightss;
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
              adDeliveryInsightss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adDeliveryInsightss;
          }

          // Sixth, check if it's pure JsonObject
          adDeliveryInsightss.clear();
          adDeliveryInsightss.add(loadJSON(json, context, header));
          return adDeliveryInsightss;
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


  public String getFieldAdSetId() {
    return mAdSetId;
  }

  public AdDeliveryInsights setFieldAdSetId(String value) {
    this.mAdSetId = value;
    return this;
  }

  public Object getFieldAuctionCompetitiveness() {
    return mAuctionCompetitiveness;
  }

  public AdDeliveryInsights setFieldAuctionCompetitiveness(Object value) {
    this.mAuctionCompetitiveness = value;
    return this;
  }

  public Object getFieldAuctionOverlap() {
    return mAuctionOverlap;
  }

  public AdDeliveryInsights setFieldAuctionOverlap(Object value) {
    this.mAuctionOverlap = value;
    return this;
  }

  public Object getFieldAudienceSaturation() {
    return mAudienceSaturation;
  }

  public AdDeliveryInsights setFieldAudienceSaturation(Object value) {
    this.mAudienceSaturation = value;
    return this;
  }

  public String getFieldDateStart() {
    return mDateStart;
  }

  public AdDeliveryInsights setFieldDateStart(String value) {
    this.mDateStart = value;
    return this;
  }

  public String getFieldDateStop() {
    return mDateStop;
  }

  public AdDeliveryInsights setFieldDateStop(String value) {
    this.mDateStop = value;
    return this;
  }

  public List<String> getFieldReportUris() {
    return mReportUris;
  }

  public AdDeliveryInsights setFieldReportUris(List<String> value) {
    this.mReportUris = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AdDeliveryInsights setFieldId(String value) {
    this.mId = value;
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

  public AdDeliveryInsights copyFrom(AdDeliveryInsights instance) {
    this.mAdSetId = instance.mAdSetId;
    this.mAuctionCompetitiveness = instance.mAuctionCompetitiveness;
    this.mAuctionOverlap = instance.mAuctionOverlap;
    this.mAudienceSaturation = instance.mAudienceSaturation;
    this.mDateStart = instance.mDateStart;
    this.mDateStop = instance.mDateStop;
    this.mReportUris = instance.mReportUris;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdDeliveryInsights> getParser() {
    return new APIRequest.ResponseParser<AdDeliveryInsights>() {
      public APINodeList<AdDeliveryInsights> parseResponse(String response, APIContext context, APIRequest<AdDeliveryInsights> request, String header) throws MalformedResponseException {
        return AdDeliveryInsights.parseResponse(response, context, request, header);
      }
    };
  }
}
