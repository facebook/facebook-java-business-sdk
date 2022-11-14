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
public class InstantArticlesStats extends APINode {
  @SerializedName("error")
  private String mError = null;
  @SerializedName("metadata")
  private Map<String, Object> mMetadata = null;
  @SerializedName("metric")
  private Object mMetric = null;
  @SerializedName("totals")
  private Map<String, Object> mTotals = null;
  @SerializedName("x_axis_breakdown")
  private List<Map<String, Object>> mXAxisBreakdown = null;
  protected static Gson gson = null;

  public InstantArticlesStats() {
  }

  public String getId() {
    return null;
  }
  public static InstantArticlesStats loadJSON(String json, APIContext context, String header) {
    InstantArticlesStats instantArticlesStats = getGson().fromJson(json, InstantArticlesStats.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(instantArticlesStats.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    instantArticlesStats.context = context;
    instantArticlesStats.rawValue = json;
    instantArticlesStats.header = header;
    return instantArticlesStats;
  }

  public static APINodeList<InstantArticlesStats> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<InstantArticlesStats> instantArticlesStatss = new APINodeList<InstantArticlesStats>(request, json, header);
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
          instantArticlesStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return instantArticlesStatss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                instantArticlesStatss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            instantArticlesStatss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              instantArticlesStatss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              instantArticlesStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  instantArticlesStatss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              instantArticlesStatss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return instantArticlesStatss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              instantArticlesStatss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return instantArticlesStatss;
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
              instantArticlesStatss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return instantArticlesStatss;
          }

          // Sixth, check if it's pure JsonObject
          instantArticlesStatss.clear();
          instantArticlesStatss.add(loadJSON(json, context, header));
          return instantArticlesStatss;
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


  public String getFieldError() {
    return mError;
  }

  public InstantArticlesStats setFieldError(String value) {
    this.mError = value;
    return this;
  }

  public Map<String, Object> getFieldMetadata() {
    return mMetadata;
  }

  public InstantArticlesStats setFieldMetadata(Map<String, Object> value) {
    this.mMetadata = value;
    return this;
  }

  public Object getFieldMetric() {
    return mMetric;
  }

  public InstantArticlesStats setFieldMetric(Object value) {
    this.mMetric = value;
    return this;
  }

  public Map<String, Object> getFieldTotals() {
    return mTotals;
  }

  public InstantArticlesStats setFieldTotals(Map<String, Object> value) {
    this.mTotals = value;
    return this;
  }

  public List<Map<String, Object>> getFieldXAxisBreakdown() {
    return mXAxisBreakdown;
  }

  public InstantArticlesStats setFieldXAxisBreakdown(List<Map<String, Object>> value) {
    this.mXAxisBreakdown = value;
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

  public InstantArticlesStats copyFrom(InstantArticlesStats instance) {
    this.mError = instance.mError;
    this.mMetadata = instance.mMetadata;
    this.mMetric = instance.mMetric;
    this.mTotals = instance.mTotals;
    this.mXAxisBreakdown = instance.mXAxisBreakdown;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<InstantArticlesStats> getParser() {
    return new APIRequest.ResponseParser<InstantArticlesStats>() {
      public APINodeList<InstantArticlesStats> parseResponse(String response, APIContext context, APIRequest<InstantArticlesStats> request, String header) throws MalformedResponseException {
        return InstantArticlesStats.parseResponse(response, context, request, header);
      }
    };
  }
}
