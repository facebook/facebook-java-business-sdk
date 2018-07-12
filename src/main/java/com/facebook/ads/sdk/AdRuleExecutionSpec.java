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
public class AdRuleExecutionSpec extends APINode {
  @SerializedName("execution_options")
  private List<AdRuleExecutionOptions> mExecutionOptions = null;
  @SerializedName("execution_type")
  private EnumExecutionType mExecutionType = null;
  protected static Gson gson = null;

  public AdRuleExecutionSpec() {
  }

  public String getId() {
    return null;
  }
  public static AdRuleExecutionSpec loadJSON(String json, APIContext context) {
    AdRuleExecutionSpec adRuleExecutionSpec = getGson().fromJson(json, AdRuleExecutionSpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adRuleExecutionSpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adRuleExecutionSpec.context = context;
    adRuleExecutionSpec.rawValue = json;
    return adRuleExecutionSpec;
  }

  public static APINodeList<AdRuleExecutionSpec> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdRuleExecutionSpec> adRuleExecutionSpecs = new APINodeList<AdRuleExecutionSpec>(request, json);
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
          adRuleExecutionSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adRuleExecutionSpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adRuleExecutionSpecs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adRuleExecutionSpecs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adRuleExecutionSpecs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adRuleExecutionSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adRuleExecutionSpecs.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adRuleExecutionSpecs.add(loadJSON(obj.toString(), context));
            }
          }
          return adRuleExecutionSpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adRuleExecutionSpecs.add(loadJSON(entry.getValue().toString(), context));
          }
          return adRuleExecutionSpecs;
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
              adRuleExecutionSpecs.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adRuleExecutionSpecs;
          }

          // Sixth, check if it's pure JsonObject
          adRuleExecutionSpecs.clear();
          adRuleExecutionSpecs.add(loadJSON(json, context));
          return adRuleExecutionSpecs;
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


  public List<AdRuleExecutionOptions> getFieldExecutionOptions() {
    return mExecutionOptions;
  }

  public AdRuleExecutionSpec setFieldExecutionOptions(List<AdRuleExecutionOptions> value) {
    this.mExecutionOptions = value;
    return this;
  }

  public AdRuleExecutionSpec setFieldExecutionOptions(String value) {
    Type type = new TypeToken<List<AdRuleExecutionOptions>>(){}.getType();
    this.mExecutionOptions = AdRuleExecutionOptions.getGson().fromJson(value, type);
    return this;
  }
  public EnumExecutionType getFieldExecutionType() {
    return mExecutionType;
  }

  public AdRuleExecutionSpec setFieldExecutionType(EnumExecutionType value) {
    this.mExecutionType = value;
    return this;
  }



  public static enum EnumExecutionType {
      @SerializedName("PING_ENDPOINT")
      VALUE_PING_ENDPOINT("PING_ENDPOINT"),
      @SerializedName("NOTIFICATION")
      VALUE_NOTIFICATION("NOTIFICATION"),
      @SerializedName("PAUSE")
      VALUE_PAUSE("PAUSE"),
      @SerializedName("REBALANCE_BUDGET")
      VALUE_REBALANCE_BUDGET("REBALANCE_BUDGET"),
      @SerializedName("CHANGE_BUDGET")
      VALUE_CHANGE_BUDGET("CHANGE_BUDGET"),
      @SerializedName("CHANGE_BID")
      VALUE_CHANGE_BID("CHANGE_BID"),
      @SerializedName("ROTATE")
      VALUE_ROTATE("ROTATE"),
      @SerializedName("UNPAUSE")
      VALUE_UNPAUSE("UNPAUSE"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumExecutionType(String value) {
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

  public AdRuleExecutionSpec copyFrom(AdRuleExecutionSpec instance) {
    this.mExecutionOptions = instance.mExecutionOptions;
    this.mExecutionType = instance.mExecutionType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdRuleExecutionSpec> getParser() {
    return new APIRequest.ResponseParser<AdRuleExecutionSpec>() {
      public APINodeList<AdRuleExecutionSpec> parseResponse(String response, APIContext context, APIRequest<AdRuleExecutionSpec> request) throws MalformedResponseException {
        return AdRuleExecutionSpec.parseResponse(response, context, request);
      }
    };
  }
}
