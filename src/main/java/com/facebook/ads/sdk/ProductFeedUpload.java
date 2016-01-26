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


public class ProductFeedUpload extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("input_method")
  private EnumInputMethod mInputMethod = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("url")
  private String mUrl = null;
  protected static Gson gson = null;

  ProductFeedUpload() {
  }

  public ProductFeedUpload(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ProductFeedUpload(String id, APIContext context) {
    this.mId = id;
    this.mContext = context;
  }

  public ProductFeedUpload fetch() throws APIException{
    ProductFeedUpload newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
    this.copyFrom(newInstance);
    return this;
  }

  public static ProductFeedUpload fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ProductFeedUpload fetchById(String id, APIContext context) throws APIException {
    ProductFeedUpload productFeedUpload =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return productFeedUpload;
  }

  private String getPrefixedId() {
    return mId.toString();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ProductFeedUpload loadJSON(String json, APIContext context) {
    ProductFeedUpload productFeedUpload = getGson().fromJson(json, ProductFeedUpload.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productFeedUpload.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    productFeedUpload.mContext = context;
    productFeedUpload.rawValue = json;
    return productFeedUpload;
  }

  public static APINodeList<ProductFeedUpload> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<ProductFeedUpload> productFeedUploads = new APINodeList<ProductFeedUpload>(request, json);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          productFeedUploads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return productFeedUploads;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            productFeedUploads.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productFeedUploads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            productFeedUploads.add(loadJSON(obj.toString(), context));
          }
          return productFeedUploads;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productFeedUploads.add(loadJSON(entry.getValue().toString(), context));
          }
          return productFeedUploads;
        } else {
          // Fifth, check if it's pure JsonObject
          productFeedUploads.add(loadJSON(json, context));
          return productFeedUploads;
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetErrors getErrors() {
    return new APIRequestGetErrors(this.getPrefixedId().toString(), mContext);
  }


  public String getFieldId() {
    return mId;
  }

  public String getFieldEndTime() {
    return mEndTime;
  }

  public EnumInputMethod getFieldInputMethod() {
    return mInputMethod;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public String getFieldUrl() {
    return mUrl;
  }



  public static class APIRequestGet extends APIRequest<ProductFeedUpload> {

    ProductFeedUpload lastResponse = null;
    @Override
    public ProductFeedUpload getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "end_time",
      "input_method",
      "start_time",
      "url",
    };

    @Override
    public ProductFeedUpload parseResponse(String response) throws APIException {
      return ProductFeedUpload.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductFeedUpload execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductFeedUpload execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGet requestInputMethodField () {
      return this.requestInputMethodField(true);
    }
    public APIRequestGet requestInputMethodField (boolean value) {
      this.requestField("input_method", value);
      return this;
    }
    public APIRequestGet requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGet requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }

  }

  public static class APIRequestGetErrors extends APIRequest<ProductFeedUploadError> {

    APINodeList<ProductFeedUploadError> lastResponse = null;
    @Override
    public APINodeList<ProductFeedUploadError> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "summary",
      "description",
      "severity",
      "row_number",
      "column_number",
      "total_count",
    };

    @Override
    public APINodeList<ProductFeedUploadError> parseResponse(String response) throws APIException {
      return ProductFeedUploadError.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductFeedUploadError> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductFeedUploadError> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(callInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetErrors(String nodeId, APIContext context) {
      super(context, nodeId, "/errors", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetErrors setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetErrors setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetErrors requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetErrors requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetErrors requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetErrors requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGetErrors requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    public APIRequestGetErrors requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetErrors requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetErrors requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetErrors requestSummaryField () {
      return this.requestSummaryField(true);
    }
    public APIRequestGetErrors requestSummaryField (boolean value) {
      this.requestField("summary", value);
      return this;
    }
    public APIRequestGetErrors requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetErrors requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetErrors requestSeverityField () {
      return this.requestSeverityField(true);
    }
    public APIRequestGetErrors requestSeverityField (boolean value) {
      this.requestField("severity", value);
      return this;
    }
    public APIRequestGetErrors requestRowNumberField () {
      return this.requestRowNumberField(true);
    }
    public APIRequestGetErrors requestRowNumberField (boolean value) {
      this.requestField("row_number", value);
      return this;
    }
    public APIRequestGetErrors requestColumnNumberField () {
      return this.requestColumnNumberField(true);
    }
    public APIRequestGetErrors requestColumnNumberField (boolean value) {
      this.requestField("column_number", value);
      return this;
    }
    public APIRequestGetErrors requestTotalCountField () {
      return this.requestTotalCountField(true);
    }
    public APIRequestGetErrors requestTotalCountField (boolean value) {
      this.requestField("total_count", value);
      return this;
    }

  }

  public static enum EnumInputMethod {
    @SerializedName("Manual Upload")
    VALUE_MANUAL_UPLOAD("Manual Upload"),
    @SerializedName("Server Fetch")
    VALUE_SERVER_FETCH("Server Fetch"),
    NULL(null);

    private String value;

    private EnumInputMethod(String value) {
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

  public ProductFeedUpload copyFrom(ProductFeedUpload instance) {
    this.mId = instance.mId;
    this.mEndTime = instance.mEndTime;
    this.mInputMethod = instance.mInputMethod;
    this.mStartTime = instance.mStartTime;
    this.mUrl = instance.mUrl;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductFeedUpload> getParser() {
    return new APIRequest.ResponseParser<ProductFeedUpload>() {
      public APINodeList<ProductFeedUpload> parseResponse(String response, APIContext context, APIRequest<ProductFeedUpload> request) {
        return ProductFeedUpload.parseResponse(response, context, request);
      }
    };
  }
}