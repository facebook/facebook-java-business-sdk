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
public class ReportStatsMetadata extends APINode {
  @SerializedName("cutoff_date_account_data")
  private String mCutoffDateAccountData = null;
  @SerializedName("cutoff_date_actions")
  private String mCutoffDateActions = null;
  @SerializedName("cutoff_date_carousel_action_breakdown")
  private String mCutoffDateCarouselActionBreakdown = null;
  @SerializedName("cutoff_date_carousel_card_name")
  private String mCutoffDateCarouselCardName = null;
  @SerializedName("cutoff_date_demographics")
  private String mCutoffDateDemographics = null;
  @SerializedName("cutoff_date_general")
  private String mCutoffDateGeneral = null;
  @SerializedName("cutoff_date_placement")
  private String mCutoffDatePlacement = null;
  @SerializedName("cutoff_date_relevance_score")
  private String mCutoffDateRelevanceScore = null;
  @SerializedName("cutoff_date_video_type_breakdown")
  private String mCutoffDateVideoTypeBreakdown = null;
  @SerializedName("cutoff_date_website_ctr")
  private String mCutoffDateWebsiteCtr = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  public ReportStatsMetadata() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ReportStatsMetadata loadJSON(String json, APIContext context) {
    ReportStatsMetadata reportStatsMetadata = getGson().fromJson(json, ReportStatsMetadata.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(reportStatsMetadata.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    reportStatsMetadata.context = context;
    reportStatsMetadata.rawValue = json;
    return reportStatsMetadata;
  }

  public static APINodeList<ReportStatsMetadata> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ReportStatsMetadata> reportStatsMetadatas = new APINodeList<ReportStatsMetadata>(request, json);
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
          reportStatsMetadatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return reportStatsMetadatas;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                reportStatsMetadatas.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            reportStatsMetadatas.setPaging(previous, next);
            if (context.hasAppSecret()) {
              reportStatsMetadatas.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              reportStatsMetadatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  reportStatsMetadatas.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              reportStatsMetadatas.add(loadJSON(obj.toString(), context));
            }
          }
          return reportStatsMetadatas;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              reportStatsMetadatas.add(loadJSON(entry.getValue().toString(), context));
          }
          return reportStatsMetadatas;
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
              reportStatsMetadatas.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return reportStatsMetadatas;
          }

          // Sixth, check if it's pure JsonObject
          reportStatsMetadatas.clear();
          reportStatsMetadatas.add(loadJSON(json, context));
          return reportStatsMetadatas;
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


  public String getFieldCutoffDateAccountData() {
    return mCutoffDateAccountData;
  }

  public ReportStatsMetadata setFieldCutoffDateAccountData(String value) {
    this.mCutoffDateAccountData = value;
    return this;
  }

  public String getFieldCutoffDateActions() {
    return mCutoffDateActions;
  }

  public ReportStatsMetadata setFieldCutoffDateActions(String value) {
    this.mCutoffDateActions = value;
    return this;
  }

  public String getFieldCutoffDateCarouselActionBreakdown() {
    return mCutoffDateCarouselActionBreakdown;
  }

  public ReportStatsMetadata setFieldCutoffDateCarouselActionBreakdown(String value) {
    this.mCutoffDateCarouselActionBreakdown = value;
    return this;
  }

  public String getFieldCutoffDateCarouselCardName() {
    return mCutoffDateCarouselCardName;
  }

  public ReportStatsMetadata setFieldCutoffDateCarouselCardName(String value) {
    this.mCutoffDateCarouselCardName = value;
    return this;
  }

  public String getFieldCutoffDateDemographics() {
    return mCutoffDateDemographics;
  }

  public ReportStatsMetadata setFieldCutoffDateDemographics(String value) {
    this.mCutoffDateDemographics = value;
    return this;
  }

  public String getFieldCutoffDateGeneral() {
    return mCutoffDateGeneral;
  }

  public ReportStatsMetadata setFieldCutoffDateGeneral(String value) {
    this.mCutoffDateGeneral = value;
    return this;
  }

  public String getFieldCutoffDatePlacement() {
    return mCutoffDatePlacement;
  }

  public ReportStatsMetadata setFieldCutoffDatePlacement(String value) {
    this.mCutoffDatePlacement = value;
    return this;
  }

  public String getFieldCutoffDateRelevanceScore() {
    return mCutoffDateRelevanceScore;
  }

  public ReportStatsMetadata setFieldCutoffDateRelevanceScore(String value) {
    this.mCutoffDateRelevanceScore = value;
    return this;
  }

  public String getFieldCutoffDateVideoTypeBreakdown() {
    return mCutoffDateVideoTypeBreakdown;
  }

  public ReportStatsMetadata setFieldCutoffDateVideoTypeBreakdown(String value) {
    this.mCutoffDateVideoTypeBreakdown = value;
    return this;
  }

  public String getFieldCutoffDateWebsiteCtr() {
    return mCutoffDateWebsiteCtr;
  }

  public ReportStatsMetadata setFieldCutoffDateWebsiteCtr(String value) {
    this.mCutoffDateWebsiteCtr = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public ReportStatsMetadata setFieldId(String value) {
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

  public ReportStatsMetadata copyFrom(ReportStatsMetadata instance) {
    this.mCutoffDateAccountData = instance.mCutoffDateAccountData;
    this.mCutoffDateActions = instance.mCutoffDateActions;
    this.mCutoffDateCarouselActionBreakdown = instance.mCutoffDateCarouselActionBreakdown;
    this.mCutoffDateCarouselCardName = instance.mCutoffDateCarouselCardName;
    this.mCutoffDateDemographics = instance.mCutoffDateDemographics;
    this.mCutoffDateGeneral = instance.mCutoffDateGeneral;
    this.mCutoffDatePlacement = instance.mCutoffDatePlacement;
    this.mCutoffDateRelevanceScore = instance.mCutoffDateRelevanceScore;
    this.mCutoffDateVideoTypeBreakdown = instance.mCutoffDateVideoTypeBreakdown;
    this.mCutoffDateWebsiteCtr = instance.mCutoffDateWebsiteCtr;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ReportStatsMetadata> getParser() {
    return new APIRequest.ResponseParser<ReportStatsMetadata>() {
      public APINodeList<ReportStatsMetadata> parseResponse(String response, APIContext context, APIRequest<ReportStatsMetadata> request) throws MalformedResponseException {
        return ReportStatsMetadata.parseResponse(response, context, request);
      }
    };
  }
}
