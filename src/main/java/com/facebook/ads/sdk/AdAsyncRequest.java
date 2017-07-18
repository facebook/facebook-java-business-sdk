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
public class AdAsyncRequest extends APINode {
  @SerializedName("async_request_set")
  private AdAsyncRequestSet mAsyncRequestSet = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("input")
  private Map<String, String> mInput = null;
  @SerializedName("result")
  private Map<String, String> mResult = null;
  @SerializedName("scope_object_id")
  private String mScopeObjectId = null;
  @SerializedName("status")
  private EnumStatus mStatus = null;
  @SerializedName("type")
  private String mType = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  protected static Gson gson = null;

  AdAsyncRequest() {
  }

  public AdAsyncRequest(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAsyncRequest(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public AdAsyncRequest fetch() throws APIException{
    AdAsyncRequest newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdAsyncRequest fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static AdAsyncRequest fetchById(String id, APIContext context) throws APIException {
    AdAsyncRequest adAsyncRequest =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return adAsyncRequest;
  }

  public static APINodeList<AdAsyncRequest> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdAsyncRequest>)(
      new APIRequest<AdAsyncRequest>(context, "", "/", "GET", AdAsyncRequest.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdAsyncRequest loadJSON(String json, APIContext context) {
    AdAsyncRequest adAsyncRequest = getGson().fromJson(json, AdAsyncRequest.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAsyncRequest.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAsyncRequest.context = context;
    adAsyncRequest.rawValue = json;
    return adAsyncRequest;
  }

  public static APINodeList<AdAsyncRequest> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdAsyncRequest> adAsyncRequests = new APINodeList<AdAsyncRequest>(request, json);
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
          adAsyncRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adAsyncRequests;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adAsyncRequests.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAsyncRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adAsyncRequests.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAsyncRequests.add(loadJSON(obj.toString(), context));
            }
          }
          return adAsyncRequests;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAsyncRequests.add(loadJSON(entry.getValue().toString(), context));
          }
          return adAsyncRequests;
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
              adAsyncRequests.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAsyncRequests;
          }

          // Sixth, check if it's pure JsonObject
          adAsyncRequests.clear();
          adAsyncRequests.add(loadJSON(json, context));
          return adAsyncRequests;
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public AdAsyncRequestSet getFieldAsyncRequestSet() {
    if (mAsyncRequestSet != null) {
      mAsyncRequestSet.context = getContext();
    }
    return mAsyncRequestSet;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldId() {
    return mId;
  }

  public Map<String, String> getFieldInput() {
    return mInput;
  }

  public Map<String, String> getFieldResult() {
    return mResult;
  }

  public String getFieldScopeObjectId() {
    return mScopeObjectId;
  }

  public EnumStatus getFieldStatus() {
    return mStatus;
  }

  public String getFieldType() {
    return mType;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }



  public static class APIRequestGet extends APIRequest<AdAsyncRequest> {

    AdAsyncRequest lastResponse = null;
    @Override
    public AdAsyncRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "async_request_set",
      "created_time",
      "id",
      "input",
      "result",
      "scope_object_id",
      "status",
      "type",
      "updated_time",
    };

    @Override
    public AdAsyncRequest parseResponse(String response) throws APIException {
      return AdAsyncRequest.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAsyncRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAsyncRequest execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestAsyncRequestSetField () {
      return this.requestAsyncRequestSetField(true);
    }
    public APIRequestGet requestAsyncRequestSetField (boolean value) {
      this.requestField("async_request_set", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInputField () {
      return this.requestInputField(true);
    }
    public APIRequestGet requestInputField (boolean value) {
      this.requestField("input", value);
      return this;
    }
    public APIRequestGet requestResultField () {
      return this.requestResultField(true);
    }
    public APIRequestGet requestResultField (boolean value) {
      this.requestField("result", value);
      return this;
    }
    public APIRequestGet requestScopeObjectIdField () {
      return this.requestScopeObjectIdField(true);
    }
    public APIRequestGet requestScopeObjectIdField (boolean value) {
      this.requestField("scope_object_id", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGet requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static enum EnumStatus {
      @SerializedName("INITIAL")
      VALUE_INITIAL("INITIAL"),
      @SerializedName("IN_PROGRESS")
      VALUE_IN_PROGRESS("IN_PROGRESS"),
      @SerializedName("SUCCESS")
      VALUE_SUCCESS("SUCCESS"),
      @SerializedName("ERROR")
      VALUE_ERROR("ERROR"),
      @SerializedName("CANCELED")
      VALUE_CANCELED("CANCELED"),
      @SerializedName("PENDING_DEPENDENCY")
      VALUE_PENDING_DEPENDENCY("PENDING_DEPENDENCY"),
      @SerializedName("CANCELED_DEPENDENCY")
      VALUE_CANCELED_DEPENDENCY("CANCELED_DEPENDENCY"),
      @SerializedName("ERROR_DEPENDENCY")
      VALUE_ERROR_DEPENDENCY("ERROR_DEPENDENCY"),
      @SerializedName("ERROR_CONFLICTS")
      VALUE_ERROR_CONFLICTS("ERROR_CONFLICTS"),
      NULL(null);

      private String value;

      private EnumStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStatuses {
      @SerializedName("INITIAL")
      VALUE_INITIAL("INITIAL"),
      @SerializedName("IN_PROGRESS")
      VALUE_IN_PROGRESS("IN_PROGRESS"),
      @SerializedName("SUCCESS")
      VALUE_SUCCESS("SUCCESS"),
      @SerializedName("ERROR")
      VALUE_ERROR("ERROR"),
      @SerializedName("CANCELED")
      VALUE_CANCELED("CANCELED"),
      @SerializedName("PENDING_DEPENDENCY")
      VALUE_PENDING_DEPENDENCY("PENDING_DEPENDENCY"),
      @SerializedName("CANCELED_DEPENDENCY")
      VALUE_CANCELED_DEPENDENCY("CANCELED_DEPENDENCY"),
      @SerializedName("ERROR_DEPENDENCY")
      VALUE_ERROR_DEPENDENCY("ERROR_DEPENDENCY"),
      @SerializedName("ERROR_CONFLICTS")
      VALUE_ERROR_CONFLICTS("ERROR_CONFLICTS"),
      NULL(null);

      private String value;

      private EnumStatuses(String value) {
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

  public AdAsyncRequest copyFrom(AdAsyncRequest instance) {
    this.mAsyncRequestSet = instance.mAsyncRequestSet;
    this.mCreatedTime = instance.mCreatedTime;
    this.mId = instance.mId;
    this.mInput = instance.mInput;
    this.mResult = instance.mResult;
    this.mScopeObjectId = instance.mScopeObjectId;
    this.mStatus = instance.mStatus;
    this.mType = instance.mType;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAsyncRequest> getParser() {
    return new APIRequest.ResponseParser<AdAsyncRequest>() {
      public APINodeList<AdAsyncRequest> parseResponse(String response, APIContext context, APIRequest<AdAsyncRequest> request) throws MalformedResponseException {
        return AdAsyncRequest.parseResponse(response, context, request);
      }
    };
  }
}
