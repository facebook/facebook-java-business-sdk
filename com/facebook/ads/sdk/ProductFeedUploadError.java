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


public class ProductFeedUploadError extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("summary")
  private String mSummary = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("severity")
  private EnumSeverity mSeverity = null;
  @SerializedName("row_number")
  private Long mRowNumber = null;
  @SerializedName("column_number")
  private Long mColumnNumber = null;
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
    this.mContext = context;
  }

  public ProductFeedUploadError fetch() throws APIException{
    ProductFeedUploadError newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
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
      .call();
    return productFeedUploadError;
  }

  private String getPrefixedId() {
    return mId.toString();
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
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    productFeedUploadError.mContext = context;
    productFeedUploadError.rawValue = json;
    return productFeedUploadError;
  }

  public static APINodeList<ProductFeedUploadError> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<ProductFeedUploadError> productFeedUploadErrors = new APINodeList<ProductFeedUploadError>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
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
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            productFeedUploadErrors.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
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
            productFeedUploadErrors.add(loadJSON(obj.toString(), context));
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
          // Fifth, check if it's pure JsonObject
          productFeedUploadErrors.add(loadJSON(json, context));
          return productFeedUploadErrors;
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

  public APIRequestGetSamples getSamples() {
    return new APIRequestGetSamples(this.getPrefixedId().toString(), mContext);
  }


  public String getFieldId() {
    return mId;
  }

  public String getFieldSummary() {
    return mSummary;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public EnumSeverity getFieldSeverity() {
    return mSeverity;
  }

  public Long getFieldRowNumber() {
    return mRowNumber;
  }

  public Long getFieldColumnNumber() {
    return mColumnNumber;
  }

  public Long getFieldTotalCount() {
    return mTotalCount;
  }



  public static class APIRequestGet extends APIRequest<ProductFeedUploadError> {

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
    public ProductFeedUploadError call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public ProductFeedUploadError call(Map<String, Object> extraParams) throws APIException {
      return ProductFeedUploadError.parseResponse(callInternal(extraParams), getContext(), this).head();
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
    public APIRequestGet requestSummaryField () {
      return this.requestSummaryField(true);
    }
    public APIRequestGet requestSummaryField (boolean value) {
      this.requestField("summary", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestSeverityField () {
      return this.requestSeverityField(true);
    }
    public APIRequestGet requestSeverityField (boolean value) {
      this.requestField("severity", value);
      return this;
    }
    public APIRequestGet requestRowNumberField () {
      return this.requestRowNumberField(true);
    }
    public APIRequestGet requestRowNumberField (boolean value) {
      this.requestField("row_number", value);
      return this;
    }
    public APIRequestGet requestColumnNumberField () {
      return this.requestColumnNumberField(true);
    }
    public APIRequestGet requestColumnNumberField (boolean value) {
      this.requestField("column_number", value);
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

  public static class APIRequestGetSamples extends APIRequest<ProductFeedUploadErrorSample> {

    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "retailer_id",
      "row_number",
    };

    @Override
    public APINodeList<ProductFeedUploadErrorSample> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductFeedUploadErrorSample> call(Map<String, Object> extraParams) throws APIException {
      return ProductFeedUploadErrorSample.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetSamples(String nodeId, APIContext context) {
      super(context, nodeId, "/samples", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetSamples setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGetSamples requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetSamples requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

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
    this.mId = instance.mId;
    this.mSummary = instance.mSummary;
    this.mDescription = instance.mDescription;
    this.mSeverity = instance.mSeverity;
    this.mRowNumber = instance.mRowNumber;
    this.mColumnNumber = instance.mColumnNumber;
    this.mTotalCount = instance.mTotalCount;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}