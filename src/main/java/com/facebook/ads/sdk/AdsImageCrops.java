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
public class AdsImageCrops extends APINode {
  @SerializedName("100x100")
  private List<JsonArray> m100x100 = null;
  @SerializedName("100x72")
  private List<JsonArray> m100x72 = null;
  @SerializedName("191x100")
  private List<JsonArray> m191x100 = null;
  @SerializedName("400x150")
  private List<JsonArray> m400x150 = null;
  @SerializedName("400x500")
  private List<JsonArray> m400x500 = null;
  @SerializedName("600x360")
  private List<JsonArray> m600x360 = null;
  @SerializedName("90x160")
  private List<JsonArray> m90x160 = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdsImageCrops() {
  }

  public AdsImageCrops(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdsImageCrops(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdsImageCrops fetch() throws APIException{
    AdsImageCrops newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdsImageCrops fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdsImageCrops> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdsImageCrops fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdsImageCrops> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdsImageCrops> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdsImageCrops>)(
      new APIRequest<AdsImageCrops>(context, "", "/", "GET", AdsImageCrops.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdsImageCrops>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdsImageCrops.getParser())
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
  public static AdsImageCrops loadJSON(String json, APIContext context) {
    AdsImageCrops adsImageCrops = getGson().fromJson(json, AdsImageCrops.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsImageCrops.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adsImageCrops.context = context;
    adsImageCrops.rawValue = json;
    return adsImageCrops;
  }

  public static APINodeList<AdsImageCrops> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdsImageCrops> adsImageCropss = new APINodeList<AdsImageCrops>(request, json);
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
          adsImageCropss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adsImageCropss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsImageCropss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsImageCropss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsImageCropss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsImageCropss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adsImageCropss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsImageCropss.add(loadJSON(obj.toString(), context));
            }
          }
          return adsImageCropss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsImageCropss.add(loadJSON(entry.getValue().toString(), context));
          }
          return adsImageCropss;
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
              adsImageCropss.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsImageCropss;
          }

          // Sixth, check if it's pure JsonObject
          adsImageCropss.clear();
          adsImageCropss.add(loadJSON(json, context));
          return adsImageCropss;
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


  public List<JsonArray> getField100x100() {
    return m100x100;
  }

  public List<JsonArray> getField100x72() {
    return m100x72;
  }

  public List<JsonArray> getField191x100() {
    return m191x100;
  }

  public List<JsonArray> getField400x150() {
    return m400x150;
  }

  public List<JsonArray> getField400x500() {
    return m400x500;
  }

  public List<JsonArray> getField600x360() {
    return m600x360;
  }

  public List<JsonArray> getField90x160() {
    return m90x160;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdsImageCrops> {

    AdsImageCrops lastResponse = null;
    @Override
    public AdsImageCrops getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "100x100",
      "100x72",
      "191x100",
      "400x150",
      "400x500",
      "600x360",
      "90x160",
      "id",
    };

    @Override
    public AdsImageCrops parseResponse(String response) throws APIException {
      return AdsImageCrops.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdsImageCrops execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsImageCrops execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdsImageCrops> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsImageCrops> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdsImageCrops>() {
           public AdsImageCrops apply(String result) {
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

    public APIRequestGet request100x100Field () {
      return this.request100x100Field(true);
    }
    public APIRequestGet request100x100Field (boolean value) {
      this.requestField("100x100", value);
      return this;
    }
    public APIRequestGet request100x72Field () {
      return this.request100x72Field(true);
    }
    public APIRequestGet request100x72Field (boolean value) {
      this.requestField("100x72", value);
      return this;
    }
    public APIRequestGet request191x100Field () {
      return this.request191x100Field(true);
    }
    public APIRequestGet request191x100Field (boolean value) {
      this.requestField("191x100", value);
      return this;
    }
    public APIRequestGet request400x150Field () {
      return this.request400x150Field(true);
    }
    public APIRequestGet request400x150Field (boolean value) {
      this.requestField("400x150", value);
      return this;
    }
    public APIRequestGet request400x500Field () {
      return this.request400x500Field(true);
    }
    public APIRequestGet request400x500Field (boolean value) {
      this.requestField("400x500", value);
      return this;
    }
    public APIRequestGet request600x360Field () {
      return this.request600x360Field(true);
    }
    public APIRequestGet request600x360Field (boolean value) {
      this.requestField("600x360", value);
      return this;
    }
    public APIRequestGet request90x160Field () {
      return this.request90x160Field(true);
    }
    public APIRequestGet request90x160Field (boolean value) {
      this.requestField("90x160", value);
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

  public AdsImageCrops copyFrom(AdsImageCrops instance) {
    this.m100x100 = instance.m100x100;
    this.m100x72 = instance.m100x72;
    this.m191x100 = instance.m191x100;
    this.m400x150 = instance.m400x150;
    this.m400x500 = instance.m400x500;
    this.m600x360 = instance.m600x360;
    this.m90x160 = instance.m90x160;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsImageCrops> getParser() {
    return new APIRequest.ResponseParser<AdsImageCrops>() {
      public APINodeList<AdsImageCrops> parseResponse(String response, APIContext context, APIRequest<AdsImageCrops> request) throws MalformedResponseException {
        return AdsImageCrops.parseResponse(response, context, request);
      }
    };
  }
}
