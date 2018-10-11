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
public class MerchantReport extends APINode {
  @SerializedName("add_to_cart")
  private Long mAddToCart = null;
  @SerializedName("catalog_segment_id")
  private String mCatalogSegmentId = null;
  @SerializedName("catalog_segment_purchase_value")
  private Double mCatalogSegmentPurchaseValue = null;
  @SerializedName("date")
  private String mDate = null;
  @SerializedName("link_clicks")
  private Long mLinkClicks = null;
  @SerializedName("page_id")
  private String mPageId = null;
  @SerializedName("product_id")
  private String mProductId = null;
  @SerializedName("product_quantity")
  private Long mProductQuantity = null;
  @SerializedName("product_total_value")
  private Double mProductTotalValue = null;
  @SerializedName("purchase")
  private Long mPurchase = null;
  @SerializedName("purchase_value")
  private Double mPurchaseValue = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  MerchantReport() {
  }

  public MerchantReport(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public MerchantReport(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public MerchantReport fetch() throws APIException{
    MerchantReport newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static MerchantReport fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<MerchantReport> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static MerchantReport fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<MerchantReport> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<MerchantReport> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<MerchantReport>)(
      new APIRequest<MerchantReport>(context, "", "/", "GET", MerchantReport.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<MerchantReport>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", MerchantReport.getParser())
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
  public static MerchantReport loadJSON(String json, APIContext context) {
    MerchantReport merchantReport = getGson().fromJson(json, MerchantReport.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(merchantReport.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    merchantReport.context = context;
    merchantReport.rawValue = json;
    return merchantReport;
  }

  public static APINodeList<MerchantReport> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<MerchantReport> merchantReports = new APINodeList<MerchantReport>(request, json);
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
          merchantReports.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return merchantReports;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                merchantReports.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            merchantReports.setPaging(previous, next);
            if (context.hasAppSecret()) {
              merchantReports.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              merchantReports.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  merchantReports.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              merchantReports.add(loadJSON(obj.toString(), context));
            }
          }
          return merchantReports;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              merchantReports.add(loadJSON(entry.getValue().toString(), context));
          }
          return merchantReports;
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
              merchantReports.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return merchantReports;
          }

          // Sixth, check if it's pure JsonObject
          merchantReports.clear();
          merchantReports.add(loadJSON(json, context));
          return merchantReports;
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


  public Long getFieldAddToCart() {
    return mAddToCart;
  }

  public String getFieldCatalogSegmentId() {
    return mCatalogSegmentId;
  }

  public Double getFieldCatalogSegmentPurchaseValue() {
    return mCatalogSegmentPurchaseValue;
  }

  public String getFieldDate() {
    return mDate;
  }

  public Long getFieldLinkClicks() {
    return mLinkClicks;
  }

  public String getFieldPageId() {
    return mPageId;
  }

  public String getFieldProductId() {
    return mProductId;
  }

  public Long getFieldProductQuantity() {
    return mProductQuantity;
  }

  public Double getFieldProductTotalValue() {
    return mProductTotalValue;
  }

  public Long getFieldPurchase() {
    return mPurchase;
  }

  public Double getFieldPurchaseValue() {
    return mPurchaseValue;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<MerchantReport> {

    MerchantReport lastResponse = null;
    @Override
    public MerchantReport getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "add_to_cart",
      "catalog_segment_id",
      "catalog_segment_purchase_value",
      "date",
      "link_clicks",
      "page_id",
      "product_id",
      "product_quantity",
      "product_total_value",
      "purchase",
      "purchase_value",
      "id",
    };

    @Override
    public MerchantReport parseResponse(String response) throws APIException {
      return MerchantReport.parseResponse(response, getContext(), this).head();
    }

    @Override
    public MerchantReport execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MerchantReport execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<MerchantReport> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MerchantReport> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, MerchantReport>() {
           public MerchantReport apply(String result) {
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

    public APIRequestGet requestAddToCartField () {
      return this.requestAddToCartField(true);
    }
    public APIRequestGet requestAddToCartField (boolean value) {
      this.requestField("add_to_cart", value);
      return this;
    }
    public APIRequestGet requestCatalogSegmentIdField () {
      return this.requestCatalogSegmentIdField(true);
    }
    public APIRequestGet requestCatalogSegmentIdField (boolean value) {
      this.requestField("catalog_segment_id", value);
      return this;
    }
    public APIRequestGet requestCatalogSegmentPurchaseValueField () {
      return this.requestCatalogSegmentPurchaseValueField(true);
    }
    public APIRequestGet requestCatalogSegmentPurchaseValueField (boolean value) {
      this.requestField("catalog_segment_purchase_value", value);
      return this;
    }
    public APIRequestGet requestDateField () {
      return this.requestDateField(true);
    }
    public APIRequestGet requestDateField (boolean value) {
      this.requestField("date", value);
      return this;
    }
    public APIRequestGet requestLinkClicksField () {
      return this.requestLinkClicksField(true);
    }
    public APIRequestGet requestLinkClicksField (boolean value) {
      this.requestField("link_clicks", value);
      return this;
    }
    public APIRequestGet requestPageIdField () {
      return this.requestPageIdField(true);
    }
    public APIRequestGet requestPageIdField (boolean value) {
      this.requestField("page_id", value);
      return this;
    }
    public APIRequestGet requestProductIdField () {
      return this.requestProductIdField(true);
    }
    public APIRequestGet requestProductIdField (boolean value) {
      this.requestField("product_id", value);
      return this;
    }
    public APIRequestGet requestProductQuantityField () {
      return this.requestProductQuantityField(true);
    }
    public APIRequestGet requestProductQuantityField (boolean value) {
      this.requestField("product_quantity", value);
      return this;
    }
    public APIRequestGet requestProductTotalValueField () {
      return this.requestProductTotalValueField(true);
    }
    public APIRequestGet requestProductTotalValueField (boolean value) {
      this.requestField("product_total_value", value);
      return this;
    }
    public APIRequestGet requestPurchaseField () {
      return this.requestPurchaseField(true);
    }
    public APIRequestGet requestPurchaseField (boolean value) {
      this.requestField("purchase", value);
      return this;
    }
    public APIRequestGet requestPurchaseValueField () {
      return this.requestPurchaseValueField(true);
    }
    public APIRequestGet requestPurchaseValueField (boolean value) {
      this.requestField("purchase_value", value);
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

  public MerchantReport copyFrom(MerchantReport instance) {
    this.mAddToCart = instance.mAddToCart;
    this.mCatalogSegmentId = instance.mCatalogSegmentId;
    this.mCatalogSegmentPurchaseValue = instance.mCatalogSegmentPurchaseValue;
    this.mDate = instance.mDate;
    this.mLinkClicks = instance.mLinkClicks;
    this.mPageId = instance.mPageId;
    this.mProductId = instance.mProductId;
    this.mProductQuantity = instance.mProductQuantity;
    this.mProductTotalValue = instance.mProductTotalValue;
    this.mPurchase = instance.mPurchase;
    this.mPurchaseValue = instance.mPurchaseValue;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MerchantReport> getParser() {
    return new APIRequest.ResponseParser<MerchantReport>() {
      public APINodeList<MerchantReport> parseResponse(String response, APIContext context, APIRequest<MerchantReport> request) throws MalformedResponseException {
        return MerchantReport.parseResponse(response, context, request);
      }
    };
  }
}
