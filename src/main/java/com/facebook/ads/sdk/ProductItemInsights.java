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
public class ProductItemInsights extends APINode {
  @SerializedName("ad_click_count")
  private Long mAdClickCount = null;
  @SerializedName("ad_impression_count")
  private Long mAdImpressionCount = null;
  @SerializedName("add_to_cart_count")
  private Long mAddToCartCount = null;
  @SerializedName("purchase_count")
  private Long mPurchaseCount = null;
  @SerializedName("view_content_count")
  private Long mViewContentCount = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  ProductItemInsights() {
  }

  public ProductItemInsights(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ProductItemInsights(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ProductItemInsights fetch() throws APIException{
    ProductItemInsights newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ProductItemInsights fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ProductItemInsights> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ProductItemInsights fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ProductItemInsights> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ProductItemInsights> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ProductItemInsights>)(
      new APIRequest<ProductItemInsights>(context, "", "/", "GET", ProductItemInsights.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ProductItemInsights>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ProductItemInsights.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ProductItemInsights loadJSON(String json, APIContext context) {
    ProductItemInsights productItemInsights = getGson().fromJson(json, ProductItemInsights.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productItemInsights.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    productItemInsights.context = context;
    productItemInsights.rawValue = json;
    return productItemInsights;
  }

  public static APINodeList<ProductItemInsights> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ProductItemInsights> productItemInsightss = new APINodeList<ProductItemInsights>(request, json);
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
          productItemInsightss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return productItemInsightss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productItemInsightss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productItemInsightss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productItemInsightss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productItemInsightss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  productItemInsightss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              productItemInsightss.add(loadJSON(obj.toString(), context));
            }
          }
          return productItemInsightss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productItemInsightss.add(loadJSON(entry.getValue().toString(), context));
          }
          return productItemInsightss;
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
              productItemInsightss.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productItemInsightss;
          }

          // Sixth, check if it's pure JsonObject
          productItemInsightss.clear();
          productItemInsightss.add(loadJSON(json, context));
          return productItemInsightss;
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


  public Long getFieldAdClickCount() {
    return mAdClickCount;
  }

  public Long getFieldAdImpressionCount() {
    return mAdImpressionCount;
  }

  public Long getFieldAddToCartCount() {
    return mAddToCartCount;
  }

  public Long getFieldPurchaseCount() {
    return mPurchaseCount;
  }

  public Long getFieldViewContentCount() {
    return mViewContentCount;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<ProductItemInsights> {

    ProductItemInsights lastResponse = null;
    @Override
    public ProductItemInsights getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_click_count",
      "ad_impression_count",
      "add_to_cart_count",
      "purchase_count",
      "view_content_count",
      "id",
    };

    @Override
    public ProductItemInsights parseResponse(String response) throws APIException {
      return ProductItemInsights.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductItemInsights execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductItemInsights execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductItemInsights> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductItemInsights> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductItemInsights>() {
           public ProductItemInsights apply(String result) {
             try {
               return APIRequestGet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

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

    public APIRequestGet requestAdClickCountField () {
      return this.requestAdClickCountField(true);
    }
    public APIRequestGet requestAdClickCountField (boolean value) {
      this.requestField("ad_click_count", value);
      return this;
    }
    public APIRequestGet requestAdImpressionCountField () {
      return this.requestAdImpressionCountField(true);
    }
    public APIRequestGet requestAdImpressionCountField (boolean value) {
      this.requestField("ad_impression_count", value);
      return this;
    }
    public APIRequestGet requestAddToCartCountField () {
      return this.requestAddToCartCountField(true);
    }
    public APIRequestGet requestAddToCartCountField (boolean value) {
      this.requestField("add_to_cart_count", value);
      return this;
    }
    public APIRequestGet requestPurchaseCountField () {
      return this.requestPurchaseCountField(true);
    }
    public APIRequestGet requestPurchaseCountField (boolean value) {
      this.requestField("purchase_count", value);
      return this;
    }
    public APIRequestGet requestViewContentCountField () {
      return this.requestViewContentCountField(true);
    }
    public APIRequestGet requestViewContentCountField (boolean value) {
      this.requestField("view_content_count", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
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

  public ProductItemInsights copyFrom(ProductItemInsights instance) {
    this.mAdClickCount = instance.mAdClickCount;
    this.mAdImpressionCount = instance.mAdImpressionCount;
    this.mAddToCartCount = instance.mAddToCartCount;
    this.mPurchaseCount = instance.mPurchaseCount;
    this.mViewContentCount = instance.mViewContentCount;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductItemInsights> getParser() {
    return new APIRequest.ResponseParser<ProductItemInsights>() {
      public APINodeList<ProductItemInsights> parseResponse(String response, APIContext context, APIRequest<ProductItemInsights> request) throws MalformedResponseException {
        return ProductItemInsights.parseResponse(response, context, request);
      }
    };
  }
}
