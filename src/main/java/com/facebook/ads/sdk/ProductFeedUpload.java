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
public class ProductFeedUpload extends APINode {
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("id")
  private String mId = null;
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
    this.context = context;
  }

  public ProductFeedUpload fetch() throws APIException{
    ProductFeedUpload newInstance = fetchById(this.getPrefixedId().toString(), this.context);
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

  public static APINodeList<ProductFeedUpload> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ProductFeedUpload>)(
      new APIRequest<ProductFeedUpload>(context, "", "/", "GET", ProductFeedUpload.getParser())
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
  public static ProductFeedUpload loadJSON(String json, APIContext context) {
    ProductFeedUpload productFeedUpload = getGson().fromJson(json, ProductFeedUpload.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productFeedUpload.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    productFeedUpload.context = context;
    productFeedUpload.rawValue = json;
    return productFeedUpload;
  }

  public static APINodeList<ProductFeedUpload> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ProductFeedUpload> productFeedUploads = new APINodeList<ProductFeedUpload>(request, json);
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
          productFeedUploads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return productFeedUploads;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            productFeedUploads.setPaging(before, after);
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
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  productFeedUploads.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              productFeedUploads.add(loadJSON(obj.toString(), context));
            }
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
              productFeedUploads.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productFeedUploads;
          }

          // Sixth, check if it's pure JsonObject
          productFeedUploads.clear();
          productFeedUploads.add(loadJSON(json, context));
          return productFeedUploads;
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

  public APIRequestGetErrors getErrors() {
    return new APIRequestGetErrors(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldEndTime() {
    return mEndTime;
  }

  public String getFieldId() {
    return mId;
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



  public static class APIRequestGetErrors extends APIRequest<ProductFeedUploadError> {

    APINodeList<ProductFeedUploadError> lastResponse = null;
    @Override
    public APINodeList<ProductFeedUploadError> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "description",
      "error_type",
      "id",
      "severity",
      "summary",
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
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetErrors(String nodeId, APIContext context) {
      super(context, nodeId, "/errors", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetErrors setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
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

    @Override
    public APIRequestGetErrors requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetErrors requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetErrors requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetErrors requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetErrors requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetErrors requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetErrors requestErrorTypeField () {
      return this.requestErrorTypeField(true);
    }
    public APIRequestGetErrors requestErrorTypeField (boolean value) {
      this.requestField("error_type", value);
      return this;
    }
    public APIRequestGetErrors requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetErrors requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetErrors requestSeverityField () {
      return this.requestSeverityField(true);
    }
    public APIRequestGetErrors requestSeverityField (boolean value) {
      this.requestField("severity", value);
      return this;
    }
    public APIRequestGetErrors requestSummaryField () {
      return this.requestSummaryField(true);
    }
    public APIRequestGetErrors requestSummaryField (boolean value) {
      this.requestField("summary", value);
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

  public static class APIRequestGet extends APIRequest<ProductFeedUpload> {

    ProductFeedUpload lastResponse = null;
    @Override
    public ProductFeedUpload getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "end_time",
      "id",
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

    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
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
    this.mEndTime = instance.mEndTime;
    this.mId = instance.mId;
    this.mInputMethod = instance.mInputMethod;
    this.mStartTime = instance.mStartTime;
    this.mUrl = instance.mUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductFeedUpload> getParser() {
    return new APIRequest.ResponseParser<ProductFeedUpload>() {
      public APINodeList<ProductFeedUpload> parseResponse(String response, APIContext context, APIRequest<ProductFeedUpload> request) throws MalformedResponseException {
        return ProductFeedUpload.parseResponse(response, context, request);
      }
    };
  }
}
