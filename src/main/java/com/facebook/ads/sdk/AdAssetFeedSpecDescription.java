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
public class AdAssetFeedSpecDescription extends APINode {
  @SerializedName("adlabels")
  private List<AdAssetFeedSpecAssetLabel> mAdlabels = null;
  @SerializedName("text")
  private String mText = null;
  @SerializedName("url_tags")
  private String mUrlTags = null;
  protected static Gson gson = null;

  public AdAssetFeedSpecDescription() {
  }

  public String getId() {
    return null;
  }
  public static AdAssetFeedSpecDescription loadJSON(String json, APIContext context) {
    AdAssetFeedSpecDescription adAssetFeedSpecDescription = getGson().fromJson(json, AdAssetFeedSpecDescription.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAssetFeedSpecDescription.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAssetFeedSpecDescription.context = context;
    adAssetFeedSpecDescription.rawValue = json;
    return adAssetFeedSpecDescription;
  }

  public static APINodeList<AdAssetFeedSpecDescription> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdAssetFeedSpecDescription> adAssetFeedSpecDescriptions = new APINodeList<AdAssetFeedSpecDescription>(request, json);
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
          adAssetFeedSpecDescriptions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adAssetFeedSpecDescriptions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAssetFeedSpecDescriptions.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAssetFeedSpecDescriptions.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAssetFeedSpecDescriptions.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAssetFeedSpecDescriptions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adAssetFeedSpecDescriptions.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAssetFeedSpecDescriptions.add(loadJSON(obj.toString(), context));
            }
          }
          return adAssetFeedSpecDescriptions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAssetFeedSpecDescriptions.add(loadJSON(entry.getValue().toString(), context));
          }
          return adAssetFeedSpecDescriptions;
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
              adAssetFeedSpecDescriptions.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAssetFeedSpecDescriptions;
          }

          // Sixth, check if it's pure JsonObject
          adAssetFeedSpecDescriptions.clear();
          adAssetFeedSpecDescriptions.add(loadJSON(json, context));
          return adAssetFeedSpecDescriptions;
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


  public List<AdAssetFeedSpecAssetLabel> getFieldAdlabels() {
    return mAdlabels;
  }

  public AdAssetFeedSpecDescription setFieldAdlabels(List<AdAssetFeedSpecAssetLabel> value) {
    this.mAdlabels = value;
    return this;
  }

  public AdAssetFeedSpecDescription setFieldAdlabels(String value) {
    Type type = new TypeToken<List<AdAssetFeedSpecAssetLabel>>(){}.getType();
    this.mAdlabels = AdAssetFeedSpecAssetLabel.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldText() {
    return mText;
  }

  public AdAssetFeedSpecDescription setFieldText(String value) {
    this.mText = value;
    return this;
  }

  public String getFieldUrlTags() {
    return mUrlTags;
  }

  public AdAssetFeedSpecDescription setFieldUrlTags(String value) {
    this.mUrlTags = value;
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

  public AdAssetFeedSpecDescription copyFrom(AdAssetFeedSpecDescription instance) {
    this.mAdlabels = instance.mAdlabels;
    this.mText = instance.mText;
    this.mUrlTags = instance.mUrlTags;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAssetFeedSpecDescription> getParser() {
    return new APIRequest.ResponseParser<AdAssetFeedSpecDescription>() {
      public APINodeList<AdAssetFeedSpecDescription> parseResponse(String response, APIContext context, APIRequest<AdAssetFeedSpecDescription> request) throws MalformedResponseException {
        return AdAssetFeedSpecDescription.parseResponse(response, context, request);
      }
    };
  }
}
