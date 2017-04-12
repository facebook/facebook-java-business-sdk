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
 * This class is auto-genereated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class LegacyBusinessAdAccountRequest extends APINode {
  @SerializedName("ad_account")
  private AdAccount mAdAccount = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("permitted_roles")
  private List<String> mPermittedRoles = null;
  protected static Gson gson = null;

  public LegacyBusinessAdAccountRequest() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static LegacyBusinessAdAccountRequest loadJSON(String json, APIContext context) {
    LegacyBusinessAdAccountRequest legacyBusinessAdAccountRequest = getGson().fromJson(json, LegacyBusinessAdAccountRequest.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(legacyBusinessAdAccountRequest.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    legacyBusinessAdAccountRequest.context = context;
    legacyBusinessAdAccountRequest.rawValue = json;
    return legacyBusinessAdAccountRequest;
  }

  public static APINodeList<LegacyBusinessAdAccountRequest> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<LegacyBusinessAdAccountRequest> legacyBusinessAdAccountRequests = new APINodeList<LegacyBusinessAdAccountRequest>(request, json);
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
          legacyBusinessAdAccountRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return legacyBusinessAdAccountRequests;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            legacyBusinessAdAccountRequests.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              legacyBusinessAdAccountRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  legacyBusinessAdAccountRequests.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              legacyBusinessAdAccountRequests.add(loadJSON(obj.toString(), context));
            }
          }
          return legacyBusinessAdAccountRequests;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              legacyBusinessAdAccountRequests.add(loadJSON(entry.getValue().toString(), context));
          }
          return legacyBusinessAdAccountRequests;
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
              legacyBusinessAdAccountRequests.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return legacyBusinessAdAccountRequests;
          }

          // Sixth, check if it's pure JsonObject
          legacyBusinessAdAccountRequests.clear();
          legacyBusinessAdAccountRequests.add(loadJSON(json, context));
          return legacyBusinessAdAccountRequests;
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


  public AdAccount getFieldAdAccount() {
    if (mAdAccount != null) {
      mAdAccount.context = getContext();
    }
    return mAdAccount;
  }

  public LegacyBusinessAdAccountRequest setFieldAdAccount(AdAccount value) {
    this.mAdAccount = value;
    return this;
  }

  public LegacyBusinessAdAccountRequest setFieldAdAccount(String value) {
    Type type = new TypeToken<AdAccount>(){}.getType();
    this.mAdAccount = AdAccount.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldId() {
    return mId;
  }

  public LegacyBusinessAdAccountRequest setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public List<String> getFieldPermittedRoles() {
    return mPermittedRoles;
  }

  public LegacyBusinessAdAccountRequest setFieldPermittedRoles(List<String> value) {
    this.mPermittedRoles = value;
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

  public LegacyBusinessAdAccountRequest copyFrom(LegacyBusinessAdAccountRequest instance) {
    this.mAdAccount = instance.mAdAccount;
    this.mId = instance.mId;
    this.mPermittedRoles = instance.mPermittedRoles;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LegacyBusinessAdAccountRequest> getParser() {
    return new APIRequest.ResponseParser<LegacyBusinessAdAccountRequest>() {
      public APINodeList<LegacyBusinessAdAccountRequest> parseResponse(String response, APIContext context, APIRequest<LegacyBusinessAdAccountRequest> request) throws MalformedResponseException {
        return LegacyBusinessAdAccountRequest.parseResponse(response, context, request);
      }
    };
  }
}
