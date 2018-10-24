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
public class NativeOfferDiscount extends APINode {
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("override")
  private String mOverride = null;
  @SerializedName("text")
  private String mText = null;
  @SerializedName("type")
  private String mType = null;
  @SerializedName("value1")
  private Double mValue1 = null;
  @SerializedName("value2")
  private Double mValue2 = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  NativeOfferDiscount() {
  }

  public NativeOfferDiscount(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public NativeOfferDiscount(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public NativeOfferDiscount fetch() throws APIException{
    NativeOfferDiscount newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static NativeOfferDiscount fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<NativeOfferDiscount> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static NativeOfferDiscount fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<NativeOfferDiscount> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<NativeOfferDiscount> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<NativeOfferDiscount>)(
      new APIRequest<NativeOfferDiscount>(context, "", "/", "GET", NativeOfferDiscount.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<NativeOfferDiscount>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", NativeOfferDiscount.getParser())
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
  public static NativeOfferDiscount loadJSON(String json, APIContext context) {
    NativeOfferDiscount nativeOfferDiscount = getGson().fromJson(json, NativeOfferDiscount.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(nativeOfferDiscount.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    nativeOfferDiscount.context = context;
    nativeOfferDiscount.rawValue = json;
    return nativeOfferDiscount;
  }

  public static APINodeList<NativeOfferDiscount> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<NativeOfferDiscount> nativeOfferDiscounts = new APINodeList<NativeOfferDiscount>(request, json);
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
          nativeOfferDiscounts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return nativeOfferDiscounts;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                nativeOfferDiscounts.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            nativeOfferDiscounts.setPaging(previous, next);
            if (context.hasAppSecret()) {
              nativeOfferDiscounts.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              nativeOfferDiscounts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  nativeOfferDiscounts.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              nativeOfferDiscounts.add(loadJSON(obj.toString(), context));
            }
          }
          return nativeOfferDiscounts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              nativeOfferDiscounts.add(loadJSON(entry.getValue().toString(), context));
          }
          return nativeOfferDiscounts;
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
              nativeOfferDiscounts.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return nativeOfferDiscounts;
          }

          // Sixth, check if it's pure JsonObject
          nativeOfferDiscounts.clear();
          nativeOfferDiscounts.add(loadJSON(json, context));
          return nativeOfferDiscounts;
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


  public String getFieldCurrency() {
    return mCurrency;
  }

  public String getFieldOverride() {
    return mOverride;
  }

  public String getFieldText() {
    return mText;
  }

  public String getFieldType() {
    return mType;
  }

  public Double getFieldValue1() {
    return mValue1;
  }

  public Double getFieldValue2() {
    return mValue2;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<NativeOfferDiscount> {

    NativeOfferDiscount lastResponse = null;
    @Override
    public NativeOfferDiscount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "currency",
      "override",
      "text",
      "type",
      "value1",
      "value2",
      "id",
    };

    @Override
    public NativeOfferDiscount parseResponse(String response) throws APIException {
      return NativeOfferDiscount.parseResponse(response, getContext(), this).head();
    }

    @Override
    public NativeOfferDiscount execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public NativeOfferDiscount execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<NativeOfferDiscount> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<NativeOfferDiscount> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, NativeOfferDiscount>() {
           public NativeOfferDiscount apply(String result) {
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

    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestOverrideField () {
      return this.requestOverrideField(true);
    }
    public APIRequestGet requestOverrideField (boolean value) {
      this.requestField("override", value);
      return this;
    }
    public APIRequestGet requestTextField () {
      return this.requestTextField(true);
    }
    public APIRequestGet requestTextField (boolean value) {
      this.requestField("text", value);
      return this;
    }
    public APIRequestGet requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGet requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGet requestValue1Field () {
      return this.requestValue1Field(true);
    }
    public APIRequestGet requestValue1Field (boolean value) {
      this.requestField("value1", value);
      return this;
    }
    public APIRequestGet requestValue2Field () {
      return this.requestValue2Field(true);
    }
    public APIRequestGet requestValue2Field (boolean value) {
      this.requestField("value2", value);
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

  public NativeOfferDiscount copyFrom(NativeOfferDiscount instance) {
    this.mCurrency = instance.mCurrency;
    this.mOverride = instance.mOverride;
    this.mText = instance.mText;
    this.mType = instance.mType;
    this.mValue1 = instance.mValue1;
    this.mValue2 = instance.mValue2;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<NativeOfferDiscount> getParser() {
    return new APIRequest.ResponseParser<NativeOfferDiscount>() {
      public APINodeList<NativeOfferDiscount> parseResponse(String response, APIContext context, APIRequest<NativeOfferDiscount> request) throws MalformedResponseException {
        return NativeOfferDiscount.parseResponse(response, context, request);
      }
    };
  }
}
