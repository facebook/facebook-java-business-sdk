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
public class ProductEventStat extends APINode {
  @SerializedName("date_start")
  private String mDateStart = null;
  @SerializedName("date_stop")
  private String mDateStop = null;
  @SerializedName("device_type")
  private EnumDeviceType mDeviceType = null;
  @SerializedName("event")
  private EnumEvent mEvent = null;
  @SerializedName("event_source")
  private ExternalEventSource mEventSource = null;
  @SerializedName("total_content_ids_matched_other_catalogs")
  private Long mTotalContentIdsMatchedOtherCatalogs = null;
  @SerializedName("total_matched_content_ids")
  private Long mTotalMatchedContentIds = null;
  @SerializedName("total_unmatched_content_ids")
  private Long mTotalUnmatchedContentIds = null;
  @SerializedName("unique_content_ids_matched_other_catalogs")
  private Long mUniqueContentIdsMatchedOtherCatalogs = null;
  @SerializedName("unique_matched_content_ids")
  private Long mUniqueMatchedContentIds = null;
  @SerializedName("unique_unmatched_content_ids")
  private Long mUniqueUnmatchedContentIds = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  ProductEventStat() {
  }

  public ProductEventStat(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ProductEventStat(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ProductEventStat fetch() throws APIException{
    ProductEventStat newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ProductEventStat fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ProductEventStat> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ProductEventStat fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ProductEventStat> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ProductEventStat> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ProductEventStat>)(
      new APIRequest<ProductEventStat>(context, "", "/", "GET", ProductEventStat.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ProductEventStat>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ProductEventStat.getParser())
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
  public static ProductEventStat loadJSON(String json, APIContext context) {
    ProductEventStat productEventStat = getGson().fromJson(json, ProductEventStat.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productEventStat.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    productEventStat.context = context;
    productEventStat.rawValue = json;
    return productEventStat;
  }

  public static APINodeList<ProductEventStat> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ProductEventStat> productEventStats = new APINodeList<ProductEventStat>(request, json);
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
          productEventStats.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return productEventStats;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productEventStats.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productEventStats.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productEventStats.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productEventStats.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  productEventStats.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              productEventStats.add(loadJSON(obj.toString(), context));
            }
          }
          return productEventStats;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productEventStats.add(loadJSON(entry.getValue().toString(), context));
          }
          return productEventStats;
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
              productEventStats.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productEventStats;
          }

          // Sixth, check if it's pure JsonObject
          productEventStats.clear();
          productEventStats.add(loadJSON(json, context));
          return productEventStats;
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


  public String getFieldDateStart() {
    return mDateStart;
  }

  public String getFieldDateStop() {
    return mDateStop;
  }

  public EnumDeviceType getFieldDeviceType() {
    return mDeviceType;
  }

  public EnumEvent getFieldEvent() {
    return mEvent;
  }

  public ExternalEventSource getFieldEventSource() {
    if (mEventSource != null) {
      mEventSource.context = getContext();
    }
    return mEventSource;
  }

  public Long getFieldTotalContentIdsMatchedOtherCatalogs() {
    return mTotalContentIdsMatchedOtherCatalogs;
  }

  public Long getFieldTotalMatchedContentIds() {
    return mTotalMatchedContentIds;
  }

  public Long getFieldTotalUnmatchedContentIds() {
    return mTotalUnmatchedContentIds;
  }

  public Long getFieldUniqueContentIdsMatchedOtherCatalogs() {
    return mUniqueContentIdsMatchedOtherCatalogs;
  }

  public Long getFieldUniqueMatchedContentIds() {
    return mUniqueMatchedContentIds;
  }

  public Long getFieldUniqueUnmatchedContentIds() {
    return mUniqueUnmatchedContentIds;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<ProductEventStat> {

    ProductEventStat lastResponse = null;
    @Override
    public ProductEventStat getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "date_start",
      "date_stop",
      "device_type",
      "event",
      "event_source",
      "total_content_ids_matched_other_catalogs",
      "total_matched_content_ids",
      "total_unmatched_content_ids",
      "unique_content_ids_matched_other_catalogs",
      "unique_matched_content_ids",
      "unique_unmatched_content_ids",
      "id",
    };

    @Override
    public ProductEventStat parseResponse(String response) throws APIException {
      return ProductEventStat.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductEventStat execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductEventStat execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductEventStat> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductEventStat> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductEventStat>() {
           public ProductEventStat apply(String result) {
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

    public APIRequestGet requestDateStartField () {
      return this.requestDateStartField(true);
    }
    public APIRequestGet requestDateStartField (boolean value) {
      this.requestField("date_start", value);
      return this;
    }
    public APIRequestGet requestDateStopField () {
      return this.requestDateStopField(true);
    }
    public APIRequestGet requestDateStopField (boolean value) {
      this.requestField("date_stop", value);
      return this;
    }
    public APIRequestGet requestDeviceTypeField () {
      return this.requestDeviceTypeField(true);
    }
    public APIRequestGet requestDeviceTypeField (boolean value) {
      this.requestField("device_type", value);
      return this;
    }
    public APIRequestGet requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGet requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGet requestEventSourceField () {
      return this.requestEventSourceField(true);
    }
    public APIRequestGet requestEventSourceField (boolean value) {
      this.requestField("event_source", value);
      return this;
    }
    public APIRequestGet requestTotalContentIdsMatchedOtherCatalogsField () {
      return this.requestTotalContentIdsMatchedOtherCatalogsField(true);
    }
    public APIRequestGet requestTotalContentIdsMatchedOtherCatalogsField (boolean value) {
      this.requestField("total_content_ids_matched_other_catalogs", value);
      return this;
    }
    public APIRequestGet requestTotalMatchedContentIdsField () {
      return this.requestTotalMatchedContentIdsField(true);
    }
    public APIRequestGet requestTotalMatchedContentIdsField (boolean value) {
      this.requestField("total_matched_content_ids", value);
      return this;
    }
    public APIRequestGet requestTotalUnmatchedContentIdsField () {
      return this.requestTotalUnmatchedContentIdsField(true);
    }
    public APIRequestGet requestTotalUnmatchedContentIdsField (boolean value) {
      this.requestField("total_unmatched_content_ids", value);
      return this;
    }
    public APIRequestGet requestUniqueContentIdsMatchedOtherCatalogsField () {
      return this.requestUniqueContentIdsMatchedOtherCatalogsField(true);
    }
    public APIRequestGet requestUniqueContentIdsMatchedOtherCatalogsField (boolean value) {
      this.requestField("unique_content_ids_matched_other_catalogs", value);
      return this;
    }
    public APIRequestGet requestUniqueMatchedContentIdsField () {
      return this.requestUniqueMatchedContentIdsField(true);
    }
    public APIRequestGet requestUniqueMatchedContentIdsField (boolean value) {
      this.requestField("unique_matched_content_ids", value);
      return this;
    }
    public APIRequestGet requestUniqueUnmatchedContentIdsField () {
      return this.requestUniqueUnmatchedContentIdsField(true);
    }
    public APIRequestGet requestUniqueUnmatchedContentIdsField (boolean value) {
      this.requestField("unique_unmatched_content_ids", value);
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

  public static enum EnumDeviceType {
      @SerializedName("desktop")
      VALUE_DESKTOP("desktop"),
      @SerializedName("mobile_android_phone")
      VALUE_MOBILE_ANDROID_PHONE("mobile_android_phone"),
      @SerializedName("mobile_android_tablet")
      VALUE_MOBILE_ANDROID_TABLET("mobile_android_tablet"),
      @SerializedName("mobile_ipad")
      VALUE_MOBILE_IPAD("mobile_ipad"),
      @SerializedName("mobile_iphone")
      VALUE_MOBILE_IPHONE("mobile_iphone"),
      @SerializedName("mobile_ipod")
      VALUE_MOBILE_IPOD("mobile_ipod"),
      @SerializedName("mobile_phone")
      VALUE_MOBILE_PHONE("mobile_phone"),
      @SerializedName("mobile_tablet")
      VALUE_MOBILE_TABLET("mobile_tablet"),
      @SerializedName("mobile_windows_phone")
      VALUE_MOBILE_WINDOWS_PHONE("mobile_windows_phone"),
      @SerializedName("unknown")
      VALUE_UNKNOWN("unknown"),
      NULL(null);

      private String value;

      private EnumDeviceType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumEvent {
      @SerializedName("ViewContent")
      VALUE_VIEWCONTENT("ViewContent"),
      @SerializedName("AddToCart")
      VALUE_ADDTOCART("AddToCart"),
      @SerializedName("Purchase")
      VALUE_PURCHASE("Purchase"),
      @SerializedName("InitiateCheckout")
      VALUE_INITIATECHECKOUT("InitiateCheckout"),
      @SerializedName("Search")
      VALUE_SEARCH("Search"),
      @SerializedName("Lead")
      VALUE_LEAD("Lead"),
      @SerializedName("AddToWishlist")
      VALUE_ADDTOWISHLIST("AddToWishlist"),
      NULL(null);

      private String value;

      private EnumEvent(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumBreakdowns {
      @SerializedName("DEVICE_TYPE")
      VALUE_DEVICE_TYPE("DEVICE_TYPE"),
      NULL(null);

      private String value;

      private EnumBreakdowns(String value) {
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

  public ProductEventStat copyFrom(ProductEventStat instance) {
    this.mDateStart = instance.mDateStart;
    this.mDateStop = instance.mDateStop;
    this.mDeviceType = instance.mDeviceType;
    this.mEvent = instance.mEvent;
    this.mEventSource = instance.mEventSource;
    this.mTotalContentIdsMatchedOtherCatalogs = instance.mTotalContentIdsMatchedOtherCatalogs;
    this.mTotalMatchedContentIds = instance.mTotalMatchedContentIds;
    this.mTotalUnmatchedContentIds = instance.mTotalUnmatchedContentIds;
    this.mUniqueContentIdsMatchedOtherCatalogs = instance.mUniqueContentIdsMatchedOtherCatalogs;
    this.mUniqueMatchedContentIds = instance.mUniqueMatchedContentIds;
    this.mUniqueUnmatchedContentIds = instance.mUniqueUnmatchedContentIds;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductEventStat> getParser() {
    return new APIRequest.ResponseParser<ProductEventStat>() {
      public APINodeList<ProductEventStat> parseResponse(String response, APIContext context, APIRequest<ProductEventStat> request) throws MalformedResponseException {
        return ProductEventStat.parseResponse(response, context, request);
      }
    };
  }
}
