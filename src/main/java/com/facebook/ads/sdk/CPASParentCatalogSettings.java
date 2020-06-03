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
public class CPASParentCatalogSettings extends APINode {
  @SerializedName("attribution_windows")
  private List<String> mAttributionWindows = null;
  @SerializedName("default_currency")
  private String mDefaultCurrency = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  CPASParentCatalogSettings() {
  }

  public CPASParentCatalogSettings(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CPASParentCatalogSettings(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CPASParentCatalogSettings fetch() throws APIException{
    CPASParentCatalogSettings newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CPASParentCatalogSettings fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CPASParentCatalogSettings> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CPASParentCatalogSettings fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CPASParentCatalogSettings> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CPASParentCatalogSettings> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CPASParentCatalogSettings>)(
      new APIRequest<CPASParentCatalogSettings>(context, "", "/", "GET", CPASParentCatalogSettings.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CPASParentCatalogSettings>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CPASParentCatalogSettings.getParser())
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
  public static CPASParentCatalogSettings loadJSON(String json, APIContext context, String header) {
    CPASParentCatalogSettings cpasParentCatalogSettings = getGson().fromJson(json, CPASParentCatalogSettings.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(cpasParentCatalogSettings.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    cpasParentCatalogSettings.context = context;
    cpasParentCatalogSettings.rawValue = json;
    cpasParentCatalogSettings.header = header;
    return cpasParentCatalogSettings;
  }

  public static APINodeList<CPASParentCatalogSettings> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CPASParentCatalogSettings> cpasParentCatalogSettingss = new APINodeList<CPASParentCatalogSettings>(request, json, header);
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
          cpasParentCatalogSettingss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return cpasParentCatalogSettingss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                cpasParentCatalogSettingss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            cpasParentCatalogSettingss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              cpasParentCatalogSettingss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              cpasParentCatalogSettingss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  cpasParentCatalogSettingss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              cpasParentCatalogSettingss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return cpasParentCatalogSettingss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              cpasParentCatalogSettingss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return cpasParentCatalogSettingss;
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
              cpasParentCatalogSettingss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return cpasParentCatalogSettingss;
          }

          // Sixth, check if it's pure JsonObject
          cpasParentCatalogSettingss.clear();
          cpasParentCatalogSettingss.add(loadJSON(json, context, header));
          return cpasParentCatalogSettingss;
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

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public List<String> getFieldAttributionWindows() {
    return mAttributionWindows;
  }

  public String getFieldDefaultCurrency() {
    return mDefaultCurrency;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<CPASParentCatalogSettings> {

    CPASParentCatalogSettings lastResponse = null;
    @Override
    public CPASParentCatalogSettings getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "attribution_windows",
      "default_currency",
      "id",
    };

    @Override
    public CPASParentCatalogSettings parseResponse(String response, String header) throws APIException {
      return CPASParentCatalogSettings.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CPASParentCatalogSettings execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CPASParentCatalogSettings execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CPASParentCatalogSettings> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CPASParentCatalogSettings> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CPASParentCatalogSettings>() {
           public CPASParentCatalogSettings apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
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

    public APIRequestGet requestAttributionWindowsField () {
      return this.requestAttributionWindowsField(true);
    }
    public APIRequestGet requestAttributionWindowsField (boolean value) {
      this.requestField("attribution_windows", value);
      return this;
    }
    public APIRequestGet requestDefaultCurrencyField () {
      return this.requestDefaultCurrencyField(true);
    }
    public APIRequestGet requestDefaultCurrencyField (boolean value) {
      this.requestField("default_currency", value);
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

  public static class APIRequestUpdate extends APIRequest<CPASParentCatalogSettings> {

    CPASParentCatalogSettings lastResponse = null;
    @Override
    public CPASParentCatalogSettings getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "attribution_windows",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CPASParentCatalogSettings parseResponse(String response, String header) throws APIException {
      return CPASParentCatalogSettings.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CPASParentCatalogSettings execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CPASParentCatalogSettings execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CPASParentCatalogSettings> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CPASParentCatalogSettings> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CPASParentCatalogSettings>() {
           public CPASParentCatalogSettings apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setAttributionWindows (List<CPASParentCatalogSettings.EnumAttributionWindows> attributionWindows) {
      this.setParam("attribution_windows", attributionWindows);
      return this;
    }
    public APIRequestUpdate setAttributionWindows (String attributionWindows) {
      this.setParam("attribution_windows", attributionWindows);
      return this;
    }

    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static enum EnumAttributionWindows {
      @SerializedName("DDA")
      VALUE_DDA("DDA"),
      @SerializedName("DEFAULT")
      VALUE_DEFAULT("DEFAULT"),
      @SerializedName("X1D_CLICK")
      VALUE_X1D_CLICK("X1D_CLICK"),
      @SerializedName("X1D_VIEW")
      VALUE_X1D_VIEW("X1D_VIEW"),
      @SerializedName("X28D_CLICK")
      VALUE_X28D_CLICK("X28D_CLICK"),
      @SerializedName("X28D_VIEW")
      VALUE_X28D_VIEW("X28D_VIEW"),
      @SerializedName("X7D_CLICK")
      VALUE_X7D_CLICK("X7D_CLICK"),
      @SerializedName("X7D_VIEW")
      VALUE_X7D_VIEW("X7D_VIEW"),
      ;

      private String value;

      private EnumAttributionWindows(String value) {
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

  public CPASParentCatalogSettings copyFrom(CPASParentCatalogSettings instance) {
    this.mAttributionWindows = instance.mAttributionWindows;
    this.mDefaultCurrency = instance.mDefaultCurrency;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CPASParentCatalogSettings> getParser() {
    return new APIRequest.ResponseParser<CPASParentCatalogSettings>() {
      public APINodeList<CPASParentCatalogSettings> parseResponse(String response, APIContext context, APIRequest<CPASParentCatalogSettings> request, String header) throws MalformedResponseException {
        return CPASParentCatalogSettings.parseResponse(response, context, request, header);
      }
    };
  }
}
