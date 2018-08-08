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
public class AdStudyObjective extends APINode {
  @SerializedName("custom_attributes")
  private List<String> mCustomAttributes = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_primary")
  private Boolean mIsPrimary = null;
  @SerializedName("last_updated_results")
  private String mLastUpdatedResults = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("results")
  private List<String> mResults = null;
  @SerializedName("type")
  private String mType = null;
  protected static Gson gson = null;

  AdStudyObjective() {
  }

  public AdStudyObjective(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdStudyObjective(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public AdStudyObjective fetch() throws APIException{
    AdStudyObjective newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdStudyObjective fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdStudyObjective> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdStudyObjective fetchById(String id, APIContext context) throws APIException {
    AdStudyObjective adStudyObjective =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return adStudyObjective;
  }

  public static ListenableFuture<AdStudyObjective> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<AdStudyObjective> adStudyObjective =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return adStudyObjective;
  }

  public static APINodeList<AdStudyObjective> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdStudyObjective>)(
      new APIRequest<AdStudyObjective>(context, "", "/", "GET", AdStudyObjective.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdStudyObjective>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<AdStudyObjective>> adStudyObjective =
      new APIRequest(context, "", "/", "GET", AdStudyObjective.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return adStudyObjective;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdStudyObjective loadJSON(String json, APIContext context) {
    AdStudyObjective adStudyObjective = getGson().fromJson(json, AdStudyObjective.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adStudyObjective.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adStudyObjective.context = context;
    adStudyObjective.rawValue = json;
    return adStudyObjective;
  }

  public static APINodeList<AdStudyObjective> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdStudyObjective> adStudyObjectives = new APINodeList<AdStudyObjective>(request, json);
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
          adStudyObjectives.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adStudyObjectives;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adStudyObjectives.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adStudyObjectives.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adStudyObjectives.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adStudyObjectives.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adStudyObjectives.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adStudyObjectives.add(loadJSON(obj.toString(), context));
            }
          }
          return adStudyObjectives;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adStudyObjectives.add(loadJSON(entry.getValue().toString(), context));
          }
          return adStudyObjectives;
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
              adStudyObjectives.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adStudyObjectives;
          }

          // Sixth, check if it's pure JsonObject
          adStudyObjectives.clear();
          adStudyObjectives.add(loadJSON(json, context));
          return adStudyObjectives;
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

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public List<String> getFieldCustomAttributes() {
    return mCustomAttributes;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsPrimary() {
    return mIsPrimary;
  }

  public String getFieldLastUpdatedResults() {
    return mLastUpdatedResults;
  }

  public String getFieldName() {
    return mName;
  }

  public List<String> getFieldResults() {
    return mResults;
  }

  public String getFieldType() {
    return mType;
  }



  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINode>() {
           public APINode apply(String result) {
             try {
               return APIRequestDelete.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<AdStudyObjective> {

    AdStudyObjective lastResponse = null;
    @Override
    public AdStudyObjective getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "breakdowns",
    };

    public static final String[] FIELDS = {
      "custom_attributes",
      "id",
      "is_primary",
      "last_updated_results",
      "name",
      "results",
      "type",
    };

    @Override
    public AdStudyObjective parseResponse(String response) throws APIException {
      return AdStudyObjective.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdStudyObjective execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudyObjective execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdStudyObjective> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdStudyObjective> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdStudyObjective>() {
           public AdStudyObjective apply(String result) {
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


    public APIRequestGet setBreakdowns (List<EnumBreakdowns> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }
    public APIRequestGet setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
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

    public APIRequestGet requestCustomAttributesField () {
      return this.requestCustomAttributesField(true);
    }
    public APIRequestGet requestCustomAttributesField (boolean value) {
      this.requestField("custom_attributes", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsPrimaryField () {
      return this.requestIsPrimaryField(true);
    }
    public APIRequestGet requestIsPrimaryField (boolean value) {
      this.requestField("is_primary", value);
      return this;
    }
    public APIRequestGet requestLastUpdatedResultsField () {
      return this.requestLastUpdatedResultsField(true);
    }
    public APIRequestGet requestLastUpdatedResultsField (boolean value) {
      this.requestField("last_updated_results", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestResultsField () {
      return this.requestResultsField(true);
    }
    public APIRequestGet requestResultsField (boolean value) {
      this.requestField("results", value);
      return this;
    }
    public APIRequestGet requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGet requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<AdStudyObjective> {

    AdStudyObjective lastResponse = null;
    @Override
    public AdStudyObjective getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adspixels",
      "applications",
      "customconversions",
      "is_primary",
      "name",
      "offline_conversion_data_sets",
      "offsitepixels",
      "type",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdStudyObjective parseResponse(String response) throws APIException {
      return AdStudyObjective.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdStudyObjective execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudyObjective execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdStudyObjective> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdStudyObjective> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdStudyObjective>() {
           public AdStudyObjective apply(String result) {
             try {
               return APIRequestUpdate.this.parseResponse(result);
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


    public APIRequestUpdate setAdspixels (List<Object> adspixels) {
      this.setParam("adspixels", adspixels);
      return this;
    }
    public APIRequestUpdate setAdspixels (String adspixels) {
      this.setParam("adspixels", adspixels);
      return this;
    }

    public APIRequestUpdate setApplications (List<Object> applications) {
      this.setParam("applications", applications);
      return this;
    }
    public APIRequestUpdate setApplications (String applications) {
      this.setParam("applications", applications);
      return this;
    }

    public APIRequestUpdate setCustomconversions (List<Object> customconversions) {
      this.setParam("customconversions", customconversions);
      return this;
    }
    public APIRequestUpdate setCustomconversions (String customconversions) {
      this.setParam("customconversions", customconversions);
      return this;
    }

    public APIRequestUpdate setIsPrimary (Boolean isPrimary) {
      this.setParam("is_primary", isPrimary);
      return this;
    }
    public APIRequestUpdate setIsPrimary (String isPrimary) {
      this.setParam("is_primary", isPrimary);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setOfflineConversionDataSets (List<Object> offlineConversionDataSets) {
      this.setParam("offline_conversion_data_sets", offlineConversionDataSets);
      return this;
    }
    public APIRequestUpdate setOfflineConversionDataSets (String offlineConversionDataSets) {
      this.setParam("offline_conversion_data_sets", offlineConversionDataSets);
      return this;
    }

    public APIRequestUpdate setOffsitepixels (List<Object> offsitepixels) {
      this.setParam("offsitepixels", offsitepixels);
      return this;
    }
    public APIRequestUpdate setOffsitepixels (String offsitepixels) {
      this.setParam("offsitepixels", offsitepixels);
      return this;
    }

    public APIRequestUpdate setType (AdStudyObjective.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestUpdate setType (String type) {
      this.setParam("type", type);
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

  public static enum EnumBreakdowns {
      @SerializedName("age")
      VALUE_AGE("age"),
      @SerializedName("cell_id")
      VALUE_CELL_ID("cell_id"),
      @SerializedName("gender")
      VALUE_GENDER("gender"),
      @SerializedName("country")
      VALUE_COUNTRY("country"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumBreakdowns(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumType {
      @SerializedName("SALES")
      VALUE_SALES("SALES"),
      @SerializedName("NONSALES")
      VALUE_NONSALES("NONSALES"),
      @SerializedName("MAE")
      VALUE_MAE("MAE"),
      @SerializedName("TELCO")
      VALUE_TELCO("TELCO"),
      @SerializedName("FTL")
      VALUE_FTL("FTL"),
      @SerializedName("MAI")
      VALUE_MAI("MAI"),
      @SerializedName("PARTNER")
      VALUE_PARTNER("PARTNER"),
      @SerializedName("BRANDLIFT")
      VALUE_BRANDLIFT("BRANDLIFT"),
      @SerializedName("BRAND")
      VALUE_BRAND("BRAND"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumType(String value) {
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

  public AdStudyObjective copyFrom(AdStudyObjective instance) {
    this.mCustomAttributes = instance.mCustomAttributes;
    this.mId = instance.mId;
    this.mIsPrimary = instance.mIsPrimary;
    this.mLastUpdatedResults = instance.mLastUpdatedResults;
    this.mName = instance.mName;
    this.mResults = instance.mResults;
    this.mType = instance.mType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdStudyObjective> getParser() {
    return new APIRequest.ResponseParser<AdStudyObjective>() {
      public APINodeList<AdStudyObjective> parseResponse(String response, APIContext context, APIRequest<AdStudyObjective> request) throws MalformedResponseException {
        return AdStudyObjective.parseResponse(response, context, request);
      }
    };
  }
}
