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
public class BusinessActivityLogEvent extends APINode {
  @SerializedName("acted_upon_business_id")
  private String mActedUponBusinessId = null;
  @SerializedName("acted_upon_business_name")
  private String mActedUponBusinessName = null;
  @SerializedName("acted_upon_business_object_id")
  private String mActedUponBusinessObjectId = null;
  @SerializedName("acted_upon_business_object_name")
  private String mActedUponBusinessObjectName = null;
  @SerializedName("acted_upon_business_object_type")
  private String mActedUponBusinessObjectType = null;
  @SerializedName("acted_upon_user_id")
  private String mActedUponUserId = null;
  @SerializedName("acted_upon_user_name")
  private String mActedUponUserName = null;
  @SerializedName("acting_business_id")
  private String mActingBusinessId = null;
  @SerializedName("acting_business_name")
  private String mActingBusinessName = null;
  @SerializedName("acting_user_id")
  private String mActingUserId = null;
  @SerializedName("acting_user_name")
  private String mActingUserName = null;
  @SerializedName("event_time")
  private Long mEventTime = null;
  @SerializedName("event_type")
  private String mEventType = null;
  @SerializedName("extra_data")
  private List<Object> mExtraData = null;
  @SerializedName("target_business_id")
  private String mTargetBusinessId = null;
  @SerializedName("target_business_name")
  private String mTargetBusinessName = null;
  @SerializedName("target_business_object_id")
  private String mTargetBusinessObjectId = null;
  @SerializedName("target_business_object_name")
  private String mTargetBusinessObjectName = null;
  @SerializedName("target_business_object_type")
  private String mTargetBusinessObjectType = null;
  protected static Gson gson = null;

  public BusinessActivityLogEvent() {
  }

  public String getId() {
    return null;
  }
  public static BusinessActivityLogEvent loadJSON(String json, APIContext context) {
    BusinessActivityLogEvent businessActivityLogEvent = getGson().fromJson(json, BusinessActivityLogEvent.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(businessActivityLogEvent.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    businessActivityLogEvent.context = context;
    businessActivityLogEvent.rawValue = json;
    return businessActivityLogEvent;
  }

  public static APINodeList<BusinessActivityLogEvent> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<BusinessActivityLogEvent> businessActivityLogEvents = new APINodeList<BusinessActivityLogEvent>(request, json);
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
          businessActivityLogEvents.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return businessActivityLogEvents;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                businessActivityLogEvents.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            businessActivityLogEvents.setPaging(previous, next);
            if (context.hasAppSecret()) {
              businessActivityLogEvents.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businessActivityLogEvents.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  businessActivityLogEvents.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              businessActivityLogEvents.add(loadJSON(obj.toString(), context));
            }
          }
          return businessActivityLogEvents;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businessActivityLogEvents.add(loadJSON(entry.getValue().toString(), context));
          }
          return businessActivityLogEvents;
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
              businessActivityLogEvents.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return businessActivityLogEvents;
          }

          // Sixth, check if it's pure JsonObject
          businessActivityLogEvents.clear();
          businessActivityLogEvents.add(loadJSON(json, context));
          return businessActivityLogEvents;
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


  public String getFieldActedUponBusinessId() {
    return mActedUponBusinessId;
  }

  public BusinessActivityLogEvent setFieldActedUponBusinessId(String value) {
    this.mActedUponBusinessId = value;
    return this;
  }

  public String getFieldActedUponBusinessName() {
    return mActedUponBusinessName;
  }

  public BusinessActivityLogEvent setFieldActedUponBusinessName(String value) {
    this.mActedUponBusinessName = value;
    return this;
  }

  public String getFieldActedUponBusinessObjectId() {
    return mActedUponBusinessObjectId;
  }

  public BusinessActivityLogEvent setFieldActedUponBusinessObjectId(String value) {
    this.mActedUponBusinessObjectId = value;
    return this;
  }

  public String getFieldActedUponBusinessObjectName() {
    return mActedUponBusinessObjectName;
  }

  public BusinessActivityLogEvent setFieldActedUponBusinessObjectName(String value) {
    this.mActedUponBusinessObjectName = value;
    return this;
  }

  public String getFieldActedUponBusinessObjectType() {
    return mActedUponBusinessObjectType;
  }

  public BusinessActivityLogEvent setFieldActedUponBusinessObjectType(String value) {
    this.mActedUponBusinessObjectType = value;
    return this;
  }

  public String getFieldActedUponUserId() {
    return mActedUponUserId;
  }

  public BusinessActivityLogEvent setFieldActedUponUserId(String value) {
    this.mActedUponUserId = value;
    return this;
  }

  public String getFieldActedUponUserName() {
    return mActedUponUserName;
  }

  public BusinessActivityLogEvent setFieldActedUponUserName(String value) {
    this.mActedUponUserName = value;
    return this;
  }

  public String getFieldActingBusinessId() {
    return mActingBusinessId;
  }

  public BusinessActivityLogEvent setFieldActingBusinessId(String value) {
    this.mActingBusinessId = value;
    return this;
  }

  public String getFieldActingBusinessName() {
    return mActingBusinessName;
  }

  public BusinessActivityLogEvent setFieldActingBusinessName(String value) {
    this.mActingBusinessName = value;
    return this;
  }

  public String getFieldActingUserId() {
    return mActingUserId;
  }

  public BusinessActivityLogEvent setFieldActingUserId(String value) {
    this.mActingUserId = value;
    return this;
  }

  public String getFieldActingUserName() {
    return mActingUserName;
  }

  public BusinessActivityLogEvent setFieldActingUserName(String value) {
    this.mActingUserName = value;
    return this;
  }

  public Long getFieldEventTime() {
    return mEventTime;
  }

  public BusinessActivityLogEvent setFieldEventTime(Long value) {
    this.mEventTime = value;
    return this;
  }

  public String getFieldEventType() {
    return mEventType;
  }

  public BusinessActivityLogEvent setFieldEventType(String value) {
    this.mEventType = value;
    return this;
  }

  public List<Object> getFieldExtraData() {
    return mExtraData;
  }

  public BusinessActivityLogEvent setFieldExtraData(List<Object> value) {
    this.mExtraData = value;
    return this;
  }

  public String getFieldTargetBusinessId() {
    return mTargetBusinessId;
  }

  public BusinessActivityLogEvent setFieldTargetBusinessId(String value) {
    this.mTargetBusinessId = value;
    return this;
  }

  public String getFieldTargetBusinessName() {
    return mTargetBusinessName;
  }

  public BusinessActivityLogEvent setFieldTargetBusinessName(String value) {
    this.mTargetBusinessName = value;
    return this;
  }

  public String getFieldTargetBusinessObjectId() {
    return mTargetBusinessObjectId;
  }

  public BusinessActivityLogEvent setFieldTargetBusinessObjectId(String value) {
    this.mTargetBusinessObjectId = value;
    return this;
  }

  public String getFieldTargetBusinessObjectName() {
    return mTargetBusinessObjectName;
  }

  public BusinessActivityLogEvent setFieldTargetBusinessObjectName(String value) {
    this.mTargetBusinessObjectName = value;
    return this;
  }

  public String getFieldTargetBusinessObjectType() {
    return mTargetBusinessObjectType;
  }

  public BusinessActivityLogEvent setFieldTargetBusinessObjectType(String value) {
    this.mTargetBusinessObjectType = value;
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

  public BusinessActivityLogEvent copyFrom(BusinessActivityLogEvent instance) {
    this.mActedUponBusinessId = instance.mActedUponBusinessId;
    this.mActedUponBusinessName = instance.mActedUponBusinessName;
    this.mActedUponBusinessObjectId = instance.mActedUponBusinessObjectId;
    this.mActedUponBusinessObjectName = instance.mActedUponBusinessObjectName;
    this.mActedUponBusinessObjectType = instance.mActedUponBusinessObjectType;
    this.mActedUponUserId = instance.mActedUponUserId;
    this.mActedUponUserName = instance.mActedUponUserName;
    this.mActingBusinessId = instance.mActingBusinessId;
    this.mActingBusinessName = instance.mActingBusinessName;
    this.mActingUserId = instance.mActingUserId;
    this.mActingUserName = instance.mActingUserName;
    this.mEventTime = instance.mEventTime;
    this.mEventType = instance.mEventType;
    this.mExtraData = instance.mExtraData;
    this.mTargetBusinessId = instance.mTargetBusinessId;
    this.mTargetBusinessName = instance.mTargetBusinessName;
    this.mTargetBusinessObjectId = instance.mTargetBusinessObjectId;
    this.mTargetBusinessObjectName = instance.mTargetBusinessObjectName;
    this.mTargetBusinessObjectType = instance.mTargetBusinessObjectType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BusinessActivityLogEvent> getParser() {
    return new APIRequest.ResponseParser<BusinessActivityLogEvent>() {
      public APINodeList<BusinessActivityLogEvent> parseResponse(String response, APIContext context, APIRequest<BusinessActivityLogEvent> request) throws MalformedResponseException {
        return BusinessActivityLogEvent.parseResponse(response, context, request);
      }
    };
  }
}
