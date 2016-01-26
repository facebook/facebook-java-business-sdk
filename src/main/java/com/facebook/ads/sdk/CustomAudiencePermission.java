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


public class CustomAudiencePermission extends APINode {
  @SerializedName("can_edit")
  private Boolean mCanEdit = null;
  @SerializedName("can_see_insight")
  private Boolean mCanSeeInsight = null;
  @SerializedName("can_share")
  private Boolean mCanShare = null;
  @SerializedName("subtype_supports_lookalike")
  private Boolean mSubtypeSupportsLookalike = null;
  protected static Gson gson = null;

  public CustomAudiencePermission() {
  }

  public String getId() {
    return null;
  }
  public static CustomAudiencePermission loadJSON(String json, APIContext context) {
    CustomAudiencePermission customAudiencePermission = getGson().fromJson(json, CustomAudiencePermission.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(customAudiencePermission.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    customAudiencePermission.mContext = context;
    customAudiencePermission.rawValue = json;
    return customAudiencePermission;
  }

  public static APINodeList<CustomAudiencePermission> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<CustomAudiencePermission> customAudiencePermissions = new APINodeList<CustomAudiencePermission>(request, json);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          customAudiencePermissions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return customAudiencePermissions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            customAudiencePermissions.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              customAudiencePermissions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            customAudiencePermissions.add(loadJSON(obj.toString(), context));
          }
          return customAudiencePermissions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              customAudiencePermissions.add(loadJSON(entry.getValue().toString(), context));
          }
          return customAudiencePermissions;
        } else {
          // Fifth, check if it's pure JsonObject
          customAudiencePermissions.add(loadJSON(json, context));
          return customAudiencePermissions;
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


  public Boolean getFieldCanEdit() {
    return mCanEdit;
  }

  public CustomAudiencePermission setFieldCanEdit(Boolean value) {
    this.mCanEdit = value;
    return this;
  }

  public Boolean getFieldCanSeeInsight() {
    return mCanSeeInsight;
  }

  public CustomAudiencePermission setFieldCanSeeInsight(Boolean value) {
    this.mCanSeeInsight = value;
    return this;
  }

  public Boolean getFieldCanShare() {
    return mCanShare;
  }

  public CustomAudiencePermission setFieldCanShare(Boolean value) {
    this.mCanShare = value;
    return this;
  }

  public Boolean getFieldSubtypeSupportsLookalike() {
    return mSubtypeSupportsLookalike;
  }

  public CustomAudiencePermission setFieldSubtypeSupportsLookalike(Boolean value) {
    this.mSubtypeSupportsLookalike = value;
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

  public CustomAudiencePermission copyFrom(CustomAudiencePermission instance) {
    this.mCanEdit = instance.mCanEdit;
    this.mCanSeeInsight = instance.mCanSeeInsight;
    this.mCanShare = instance.mCanShare;
    this.mSubtypeSupportsLookalike = instance.mSubtypeSupportsLookalike;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CustomAudiencePermission> getParser() {
    return new APIRequest.ResponseParser<CustomAudiencePermission>() {
      public APINodeList<CustomAudiencePermission> parseResponse(String response, APIContext context, APIRequest<CustomAudiencePermission> request) {
        return CustomAudiencePermission.parseResponse(response, context, request);
      }
    };
  }
}