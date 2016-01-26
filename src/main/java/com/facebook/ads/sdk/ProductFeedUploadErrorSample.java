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


public class ProductFeedUploadErrorSample extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("retailer_id")
  private String mRetailerId = null;
  @SerializedName("row_number")
  private Long mRowNumber = null;
  protected static Gson gson = null;

  ProductFeedUploadErrorSample() {
  }

  public ProductFeedUploadErrorSample(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ProductFeedUploadErrorSample(String id, APIContext context) {
    this.mId = id;
    this.mContext = context;
  }

  public ProductFeedUploadErrorSample fetch() throws APIException{
    ProductFeedUploadErrorSample newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
    this.copyFrom(newInstance);
    return this;
  }

  public static ProductFeedUploadErrorSample fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ProductFeedUploadErrorSample fetchById(String id, APIContext context) throws APIException {
    ProductFeedUploadErrorSample productFeedUploadErrorSample =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return productFeedUploadErrorSample;
  }

  private String getPrefixedId() {
    return mId.toString();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ProductFeedUploadErrorSample loadJSON(String json, APIContext context) {
    ProductFeedUploadErrorSample productFeedUploadErrorSample = getGson().fromJson(json, ProductFeedUploadErrorSample.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productFeedUploadErrorSample.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    productFeedUploadErrorSample.mContext = context;
    productFeedUploadErrorSample.rawValue = json;
    return productFeedUploadErrorSample;
  }

  public static APINodeList<ProductFeedUploadErrorSample> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<ProductFeedUploadErrorSample> productFeedUploadErrorSamples = new APINodeList<ProductFeedUploadErrorSample>(request, json);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          productFeedUploadErrorSamples.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return productFeedUploadErrorSamples;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            productFeedUploadErrorSamples.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productFeedUploadErrorSamples.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            productFeedUploadErrorSamples.add(loadJSON(obj.toString(), context));
          }
          return productFeedUploadErrorSamples;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productFeedUploadErrorSamples.add(loadJSON(entry.getValue().toString(), context));
          }
          return productFeedUploadErrorSamples;
        } else {
          // Fifth, check if it's pure JsonObject
          productFeedUploadErrorSamples.add(loadJSON(json, context));
          return productFeedUploadErrorSamples;
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


  public String getFieldId() {
    return mId;
  }

  public String getFieldRetailerId() {
    return mRetailerId;
  }

  public Long getFieldRowNumber() {
    return mRowNumber;
  }



  public static class APIRequestGet extends APIRequest<ProductFeedUploadErrorSample> {

    ProductFeedUploadErrorSample lastResponse = null;
    @Override
    public ProductFeedUploadErrorSample getLastResponse() {
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
    public ProductFeedUploadErrorSample parseResponse(String response) throws APIException {
      return ProductFeedUploadErrorSample.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductFeedUploadErrorSample execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductFeedUploadErrorSample execute(Map<String, Object> extraParams) throws APIException {
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
    public APIRequestGet requestRetailerIdField () {
      return this.requestRetailerIdField(true);
    }
    public APIRequestGet requestRetailerIdField (boolean value) {
      this.requestField("retailer_id", value);
      return this;
    }
    public APIRequestGet requestRowNumberField () {
      return this.requestRowNumberField(true);
    }
    public APIRequestGet requestRowNumberField (boolean value) {
      this.requestField("row_number", value);
      return this;
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

  public ProductFeedUploadErrorSample copyFrom(ProductFeedUploadErrorSample instance) {
    this.mId = instance.mId;
    this.mRetailerId = instance.mRetailerId;
    this.mRowNumber = instance.mRowNumber;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductFeedUploadErrorSample> getParser() {
    return new APIRequest.ResponseParser<ProductFeedUploadErrorSample>() {
      public APINodeList<ProductFeedUploadErrorSample> parseResponse(String response, APIContext context, APIRequest<ProductFeedUploadErrorSample> request) {
        return ProductFeedUploadErrorSample.parseResponse(response, context, request);
      }
    };
  }
}