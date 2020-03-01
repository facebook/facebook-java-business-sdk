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

import java.lang.reflect.Modifier;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
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
public class Privacy extends APINode {
  @SerializedName("allow")
  private String mAllow = null;
  @SerializedName("deny")
  private String mDeny = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("friends")
  private String mFriends = null;
  @SerializedName("networks")
  private String mNetworks = null;
  @SerializedName("value")
  private String mValue = null;
  protected static Gson gson = null;

  public Privacy() {
  }

  public String getId() {
    return null;
  }
  public static Privacy loadJSON(String json, APIContext context, String header) {
    Privacy privacy = getGson().fromJson(json, Privacy.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(privacy.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    privacy.context = context;
    privacy.rawValue = json;
    privacy.header = header;
    return privacy;
  }

  public static APINodeList<Privacy> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Privacy> privacys = new APINodeList<Privacy>(request, json, header);
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
          privacys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return privacys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                privacys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            privacys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              privacys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              privacys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  privacys.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              privacys.add(loadJSON(obj.toString(), context, header));
            }
          }
          return privacys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              privacys.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return privacys;
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
              privacys.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return privacys;
          }

          // Sixth, check if it's pure JsonObject
          privacys.clear();
          privacys.add(loadJSON(json, context, header));
          return privacys;
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


  public String getFieldAllow() {
    return mAllow;
  }

  public Privacy setFieldAllow(String value) {
    this.mAllow = value;
    return this;
  }

  public String getFieldDeny() {
    return mDeny;
  }

  public Privacy setFieldDeny(String value) {
    this.mDeny = value;
    return this;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public Privacy setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public String getFieldFriends() {
    return mFriends;
  }

  public Privacy setFieldFriends(String value) {
    this.mFriends = value;
    return this;
  }

  public String getFieldNetworks() {
    return mNetworks;
  }

  public Privacy setFieldNetworks(String value) {
    this.mNetworks = value;
    return this;
  }

  public String getFieldValue() {
    return mValue;
  }

  public Privacy setFieldValue(String value) {
    this.mValue = value;
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

  public Privacy copyFrom(Privacy instance) {
    this.mAllow = instance.mAllow;
    this.mDeny = instance.mDeny;
    this.mDescription = instance.mDescription;
    this.mFriends = instance.mFriends;
    this.mNetworks = instance.mNetworks;
    this.mValue = instance.mValue;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Privacy> getParser() {
    return new APIRequest.ResponseParser<Privacy>() {
      public APINodeList<Privacy> parseResponse(String response, APIContext context, APIRequest<Privacy> request, String header) throws MalformedResponseException {
        return Privacy.parseResponse(response, context, request, header);
      }
    };
  }
}
