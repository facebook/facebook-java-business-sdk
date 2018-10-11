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
public class ProductsQualityIssue extends APINode {
  @SerializedName("count")
  private Long mCount = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("issue_type")
  private String mIssueType = null;
  @SerializedName("property_names")
  private List<String> mPropertyNames = null;
  @SerializedName("samples")
  private List<ProductItem> mSamples = null;
  @SerializedName("summary")
  private String mSummary = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  ProductsQualityIssue() {
  }

  public ProductsQualityIssue(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ProductsQualityIssue(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ProductsQualityIssue fetch() throws APIException{
    ProductsQualityIssue newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ProductsQualityIssue fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ProductsQualityIssue> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ProductsQualityIssue fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ProductsQualityIssue> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ProductsQualityIssue> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ProductsQualityIssue>)(
      new APIRequest<ProductsQualityIssue>(context, "", "/", "GET", ProductsQualityIssue.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ProductsQualityIssue>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ProductsQualityIssue.getParser())
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
  public static ProductsQualityIssue loadJSON(String json, APIContext context) {
    ProductsQualityIssue productsQualityIssue = getGson().fromJson(json, ProductsQualityIssue.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productsQualityIssue.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    productsQualityIssue.context = context;
    productsQualityIssue.rawValue = json;
    return productsQualityIssue;
  }

  public static APINodeList<ProductsQualityIssue> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ProductsQualityIssue> productsQualityIssues = new APINodeList<ProductsQualityIssue>(request, json);
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
          productsQualityIssues.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return productsQualityIssues;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productsQualityIssues.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productsQualityIssues.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productsQualityIssues.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productsQualityIssues.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  productsQualityIssues.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              productsQualityIssues.add(loadJSON(obj.toString(), context));
            }
          }
          return productsQualityIssues;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productsQualityIssues.add(loadJSON(entry.getValue().toString(), context));
          }
          return productsQualityIssues;
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
              productsQualityIssues.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productsQualityIssues;
          }

          // Sixth, check if it's pure JsonObject
          productsQualityIssues.clear();
          productsQualityIssues.add(loadJSON(json, context));
          return productsQualityIssues;
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


  public Long getFieldCount() {
    return mCount;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldIssueType() {
    return mIssueType;
  }

  public List<String> getFieldPropertyNames() {
    return mPropertyNames;
  }

  public List<ProductItem> getFieldSamples() {
    return mSamples;
  }

  public String getFieldSummary() {
    return mSummary;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<ProductsQualityIssue> {

    ProductsQualityIssue lastResponse = null;
    @Override
    public ProductsQualityIssue getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "count",
      "description",
      "issue_type",
      "property_names",
      "samples",
      "summary",
      "id",
    };

    @Override
    public ProductsQualityIssue parseResponse(String response) throws APIException {
      return ProductsQualityIssue.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductsQualityIssue execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductsQualityIssue execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductsQualityIssue> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductsQualityIssue> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductsQualityIssue>() {
           public ProductsQualityIssue apply(String result) {
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

    public APIRequestGet requestCountField () {
      return this.requestCountField(true);
    }
    public APIRequestGet requestCountField (boolean value) {
      this.requestField("count", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestIssueTypeField () {
      return this.requestIssueTypeField(true);
    }
    public APIRequestGet requestIssueTypeField (boolean value) {
      this.requestField("issue_type", value);
      return this;
    }
    public APIRequestGet requestPropertyNamesField () {
      return this.requestPropertyNamesField(true);
    }
    public APIRequestGet requestPropertyNamesField (boolean value) {
      this.requestField("property_names", value);
      return this;
    }
    public APIRequestGet requestSamplesField () {
      return this.requestSamplesField(true);
    }
    public APIRequestGet requestSamplesField (boolean value) {
      this.requestField("samples", value);
      return this;
    }
    public APIRequestGet requestSummaryField () {
      return this.requestSummaryField(true);
    }
    public APIRequestGet requestSummaryField (boolean value) {
      this.requestField("summary", value);
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

  public ProductsQualityIssue copyFrom(ProductsQualityIssue instance) {
    this.mCount = instance.mCount;
    this.mDescription = instance.mDescription;
    this.mIssueType = instance.mIssueType;
    this.mPropertyNames = instance.mPropertyNames;
    this.mSamples = instance.mSamples;
    this.mSummary = instance.mSummary;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductsQualityIssue> getParser() {
    return new APIRequest.ResponseParser<ProductsQualityIssue>() {
      public APINodeList<ProductsQualityIssue> parseResponse(String response, APIContext context, APIRequest<ProductsQualityIssue> request) throws MalformedResponseException {
        return ProductsQualityIssue.parseResponse(response, context, request);
      }
    };
  }
}
