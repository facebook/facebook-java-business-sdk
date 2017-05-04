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
public class ProductFeedUploadError extends APINode {
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("error_type")
  private String mErrorType = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("severity")
  private EnumSeverity mSeverity = null;
  @SerializedName("summary")
  private String mSummary = null;
  @SerializedName("total_count")
  private Long mTotalCount = null;
  protected static Gson gson = null;

  ProductFeedUploadError() {
  }

  public ProductFeedUploadError(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ProductFeedUploadError(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public ProductFeedUploadError fetch() throws APIException{
    ProductFeedUploadError newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ProductFeedUploadError fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ProductFeedUploadError fetchById(String id, APIContext context) throws APIException {
    ProductFeedUploadError productFeedUploadError =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return productFeedUploadError;
  }

  public static APINodeList<ProductFeedUploadError> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ProductFeedUploadError>)(
      new APIRequest<ProductFeedUploadError>(context, "", "/", "GET", ProductFeedUploadError.getParser())
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
  public static ProductFeedUploadError loadJSON(String json, APIContext context) {
    ProductFeedUploadError productFeedUploadError = getGson().fromJson(json, ProductFeedUploadError.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productFeedUploadError.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    productFeedUploadError.context = context;
    productFeedUploadError.rawValue = json;
    return productFeedUploadError;
  }

  public static APINodeList<ProductFeedUploadError> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ProductFeedUploadError> productFeedUploadErrors = new APINodeList<ProductFeedUploadError>(request, json);
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
          productFeedUploadErrors.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return productFeedUploadErrors;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            productFeedUploadErrors.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productFeedUploadErrors.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  productFeedUploadErrors.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              productFeedUploadErrors.add(loadJSON(obj.toString(), context));
            }
          }
          return productFeedUploadErrors;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productFeedUploadErrors.add(loadJSON(entry.getValue().toString(), context));
          }
          return productFeedUploadErrors;
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
              productFeedUploadErrors.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productFeedUploadErrors;
          }

          // Sixth, check if it's pure JsonObject
          productFeedUploadErrors.clear();
          productFeedUploadErrors.add(loadJSON(json, context));
          return productFeedUploadErrors;
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

  public APIRequestGetSamples getSamples() {
    return new APIRequestGetSamples(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldErrorType() {
    return mErrorType;
  }

  public String getFieldId() {
    return mId;
  }

  public EnumSeverity getFieldSeverity() {
    return mSeverity;
  }

  public String getFieldSummary() {
    return mSummary;
  }

  public Long getFieldTotalCount() {
    return mTotalCount;
  }



  public static class APIRequestGetSamples extends APIRequest<ProductFeedUploadErrorSample> {

    APINodeList<ProductFeedUploadErrorSample> lastResponse = null;
    @Override
    public APINodeList<ProductFeedUploadErrorSample> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "retailer_id",
      "row_number",
    };

    @Override
    public APINodeList<ProductFeedUploadErrorSample> parseResponse(String response) throws APIException {
      return ProductFeedUploadErrorSample.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductFeedUploadErrorSample> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductFeedUploadErrorSample> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetSamples(String nodeId, APIContext context) {
      super(context, nodeId, "/samples", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSamples setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSamples setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSamples requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSamples requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSamples requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSamples requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSamples requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSamples requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSamples requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetSamples requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetSamples requestRetailerIdField () {
      return this.requestRetailerIdField(true);
    }
    public APIRequestGetSamples requestRetailerIdField (boolean value) {
      this.requestField("retailer_id", value);
      return this;
    }
    public APIRequestGetSamples requestRowNumberField () {
      return this.requestRowNumberField(true);
    }
    public APIRequestGetSamples requestRowNumberField (boolean value) {
      this.requestField("row_number", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<ProductFeedUploadError> {

    ProductFeedUploadError lastResponse = null;
    @Override
    public ProductFeedUploadError getLastResponse() {
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
    public ProductFeedUploadError parseResponse(String response) throws APIException {
      return ProductFeedUploadError.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductFeedUploadError execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductFeedUploadError execute(Map<String, Object> extraParams) throws APIException {
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

    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestErrorTypeField () {
      return this.requestErrorTypeField(true);
    }
    public APIRequestGet requestErrorTypeField (boolean value) {
      this.requestField("error_type", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestSeverityField () {
      return this.requestSeverityField(true);
    }
    public APIRequestGet requestSeverityField (boolean value) {
      this.requestField("severity", value);
      return this;
    }
    public APIRequestGet requestSummaryField () {
      return this.requestSummaryField(true);
    }
    public APIRequestGet requestSummaryField (boolean value) {
      this.requestField("summary", value);
      return this;
    }
    public APIRequestGet requestTotalCountField () {
      return this.requestTotalCountField(true);
    }
    public APIRequestGet requestTotalCountField (boolean value) {
      this.requestField("total_count", value);
      return this;
    }
  }

  public static enum EnumSeverity {
      @SerializedName("fatal")
      VALUE_FATAL("fatal"),
      @SerializedName("warning")
      VALUE_WARNING("warning"),
      NULL(null);

      private String value;

      private EnumSeverity(String value) {
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

  public ProductFeedUploadError copyFrom(ProductFeedUploadError instance) {
    this.mDescription = instance.mDescription;
    this.mErrorType = instance.mErrorType;
    this.mId = instance.mId;
    this.mSeverity = instance.mSeverity;
    this.mSummary = instance.mSummary;
    this.mTotalCount = instance.mTotalCount;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductFeedUploadError> getParser() {
    return new APIRequest.ResponseParser<ProductFeedUploadError>() {
      public APINodeList<ProductFeedUploadError> parseResponse(String response, APIContext context, APIRequest<ProductFeedUploadError> request) throws MalformedResponseException {
        return ProductFeedUploadError.parseResponse(response, context, request);
      }
    };
  }
}
