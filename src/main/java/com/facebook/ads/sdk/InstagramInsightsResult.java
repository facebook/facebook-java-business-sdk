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
public class InstagramInsightsResult extends APINode {
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("period")
  private String mPeriod = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("values")
  private List<InstagramInsightsValue> mValues = null;
  protected static Gson gson = null;

  public InstagramInsightsResult() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static InstagramInsightsResult loadJSON(String json, APIContext context, String header) {
    InstagramInsightsResult instagramInsightsResult = getGson().fromJson(json, InstagramInsightsResult.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(instagramInsightsResult.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    instagramInsightsResult.context = context;
    instagramInsightsResult.rawValue = json;
    instagramInsightsResult.header = header;
    return instagramInsightsResult;
  }

  public static APINodeList<InstagramInsightsResult> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<InstagramInsightsResult> instagramInsightsResults = new APINodeList<InstagramInsightsResult>(request, json, header);
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
          instagramInsightsResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return instagramInsightsResults;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                instagramInsightsResults.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            instagramInsightsResults.setPaging(previous, next);
            if (context.hasAppSecret()) {
              instagramInsightsResults.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              instagramInsightsResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  instagramInsightsResults.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              instagramInsightsResults.add(loadJSON(obj.toString(), context, header));
            }
          }
          return instagramInsightsResults;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              instagramInsightsResults.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return instagramInsightsResults;
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
              instagramInsightsResults.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return instagramInsightsResults;
          }

          // Sixth, check if it's pure JsonObject
          instagramInsightsResults.clear();
          instagramInsightsResults.add(loadJSON(json, context, header));
          return instagramInsightsResults;
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


  public String getFieldDescription() {
    return mDescription;
  }

  public InstagramInsightsResult setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public InstagramInsightsResult setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public InstagramInsightsResult setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldPeriod() {
    return mPeriod;
  }

  public InstagramInsightsResult setFieldPeriod(String value) {
    this.mPeriod = value;
    return this;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public InstagramInsightsResult setFieldTitle(String value) {
    this.mTitle = value;
    return this;
  }

  public List<InstagramInsightsValue> getFieldValues() {
    return mValues;
  }

  public InstagramInsightsResult setFieldValues(List<InstagramInsightsValue> value) {
    this.mValues = value;
    return this;
  }

  public InstagramInsightsResult setFieldValues(String value) {
    Type type = new TypeToken<List<InstagramInsightsValue>>(){}.getType();
    this.mValues = InstagramInsightsValue.getGson().fromJson(value, type);
    return this;
  }


  public static enum EnumMetric {
      @SerializedName("carousel_album_engagement")
      VALUE_CAROUSEL_ALBUM_ENGAGEMENT("carousel_album_engagement"),
      @SerializedName("carousel_album_impressions")
      VALUE_CAROUSEL_ALBUM_IMPRESSIONS("carousel_album_impressions"),
      @SerializedName("carousel_album_reach")
      VALUE_CAROUSEL_ALBUM_REACH("carousel_album_reach"),
      @SerializedName("carousel_album_saved")
      VALUE_CAROUSEL_ALBUM_SAVED("carousel_album_saved"),
      @SerializedName("carousel_album_video_views")
      VALUE_CAROUSEL_ALBUM_VIDEO_VIEWS("carousel_album_video_views"),
      @SerializedName("engagement")
      VALUE_ENGAGEMENT("engagement"),
      @SerializedName("exits")
      VALUE_EXITS("exits"),
      @SerializedName("impressions")
      VALUE_IMPRESSIONS("impressions"),
      @SerializedName("reach")
      VALUE_REACH("reach"),
      @SerializedName("replies")
      VALUE_REPLIES("replies"),
      @SerializedName("saved")
      VALUE_SAVED("saved"),
      @SerializedName("taps_back")
      VALUE_TAPS_BACK("taps_back"),
      @SerializedName("taps_forward")
      VALUE_TAPS_FORWARD("taps_forward"),
      @SerializedName("video_views")
      VALUE_VIDEO_VIEWS("video_views"),
      ;

      private String value;

      private EnumMetric(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPeriod {
      @SerializedName("day")
      VALUE_DAY("day"),
      @SerializedName("days_28")
      VALUE_DAYS_28("days_28"),
      @SerializedName("lifetime")
      VALUE_LIFETIME("lifetime"),
      @SerializedName("month")
      VALUE_MONTH("month"),
      @SerializedName("week")
      VALUE_WEEK("week"),
      ;

      private String value;

      private EnumPeriod(String value) {
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

  public InstagramInsightsResult copyFrom(InstagramInsightsResult instance) {
    this.mDescription = instance.mDescription;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mPeriod = instance.mPeriod;
    this.mTitle = instance.mTitle;
    this.mValues = instance.mValues;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<InstagramInsightsResult> getParser() {
    return new APIRequest.ResponseParser<InstagramInsightsResult>() {
      public APINodeList<InstagramInsightsResult> parseResponse(String response, APIContext context, APIRequest<InstagramInsightsResult> request, String header) throws MalformedResponseException {
        return InstagramInsightsResult.parseResponse(response, context, request, header);
      }
    };
  }
}
