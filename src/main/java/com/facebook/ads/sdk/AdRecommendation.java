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
public class AdRecommendation extends APINode {
  @SerializedName("blame_field")
  private String mBlameField = null;
  @SerializedName("code")
  private Long mCode = null;
  @SerializedName("confidence")
  private EnumConfidence mConfidence = null;
  @SerializedName("importance")
  private EnumImportance mImportance = null;
  @SerializedName("message")
  private String mMessage = null;
  @SerializedName("recommendation_data")
  private AdRecommendationData mRecommendationData = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdRecommendation() {
  }

  public AdRecommendation(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdRecommendation(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdRecommendation fetch() throws APIException{
    AdRecommendation newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdRecommendation fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdRecommendation> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdRecommendation fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdRecommendation> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdRecommendation> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdRecommendation>)(
      new APIRequest<AdRecommendation>(context, "", "/", "GET", AdRecommendation.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdRecommendation>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdRecommendation.getParser())
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
  public static AdRecommendation loadJSON(String json, APIContext context) {
    AdRecommendation adRecommendation = getGson().fromJson(json, AdRecommendation.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adRecommendation.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adRecommendation.context = context;
    adRecommendation.rawValue = json;
    return adRecommendation;
  }

  public static APINodeList<AdRecommendation> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdRecommendation> adRecommendations = new APINodeList<AdRecommendation>(request, json);
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
          adRecommendations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adRecommendations;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adRecommendations.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adRecommendations.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adRecommendations.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adRecommendations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adRecommendations.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adRecommendations.add(loadJSON(obj.toString(), context));
            }
          }
          return adRecommendations;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adRecommendations.add(loadJSON(entry.getValue().toString(), context));
          }
          return adRecommendations;
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
              adRecommendations.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adRecommendations;
          }

          // Sixth, check if it's pure JsonObject
          adRecommendations.clear();
          adRecommendations.add(loadJSON(json, context));
          return adRecommendations;
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


  public String getFieldBlameField() {
    return mBlameField;
  }

  public Long getFieldCode() {
    return mCode;
  }

  public EnumConfidence getFieldConfidence() {
    return mConfidence;
  }

  public EnumImportance getFieldImportance() {
    return mImportance;
  }

  public String getFieldMessage() {
    return mMessage;
  }

  public AdRecommendationData getFieldRecommendationData() {
    if (mRecommendationData != null) {
      mRecommendationData.context = getContext();
    }
    return mRecommendationData;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdRecommendation> {

    AdRecommendation lastResponse = null;
    @Override
    public AdRecommendation getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "blame_field",
      "code",
      "confidence",
      "importance",
      "message",
      "recommendation_data",
      "title",
      "id",
    };

    @Override
    public AdRecommendation parseResponse(String response) throws APIException {
      return AdRecommendation.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdRecommendation execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdRecommendation execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdRecommendation> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdRecommendation> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdRecommendation>() {
           public AdRecommendation apply(String result) {
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

    public APIRequestGet requestBlameFieldField () {
      return this.requestBlameFieldField(true);
    }
    public APIRequestGet requestBlameFieldField (boolean value) {
      this.requestField("blame_field", value);
      return this;
    }
    public APIRequestGet requestCodeField () {
      return this.requestCodeField(true);
    }
    public APIRequestGet requestCodeField (boolean value) {
      this.requestField("code", value);
      return this;
    }
    public APIRequestGet requestConfidenceField () {
      return this.requestConfidenceField(true);
    }
    public APIRequestGet requestConfidenceField (boolean value) {
      this.requestField("confidence", value);
      return this;
    }
    public APIRequestGet requestImportanceField () {
      return this.requestImportanceField(true);
    }
    public APIRequestGet requestImportanceField (boolean value) {
      this.requestField("importance", value);
      return this;
    }
    public APIRequestGet requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGet requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGet requestRecommendationDataField () {
      return this.requestRecommendationDataField(true);
    }
    public APIRequestGet requestRecommendationDataField (boolean value) {
      this.requestField("recommendation_data", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
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

  public static enum EnumConfidence {
      @SerializedName("HIGH")
      VALUE_HIGH("HIGH"),
      @SerializedName("MEDIUM")
      VALUE_MEDIUM("MEDIUM"),
      @SerializedName("LOW")
      VALUE_LOW("LOW"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumConfidence(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumImportance {
      @SerializedName("HIGH")
      VALUE_HIGH("HIGH"),
      @SerializedName("MEDIUM")
      VALUE_MEDIUM("MEDIUM"),
      @SerializedName("LOW")
      VALUE_LOW("LOW"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumImportance(String value) {
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

  public AdRecommendation copyFrom(AdRecommendation instance) {
    this.mBlameField = instance.mBlameField;
    this.mCode = instance.mCode;
    this.mConfidence = instance.mConfidence;
    this.mImportance = instance.mImportance;
    this.mMessage = instance.mMessage;
    this.mRecommendationData = instance.mRecommendationData;
    this.mTitle = instance.mTitle;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdRecommendation> getParser() {
    return new APIRequest.ResponseParser<AdRecommendation>() {
      public APINodeList<AdRecommendation> parseResponse(String response, APIContext context, APIRequest<AdRecommendation> request) throws MalformedResponseException {
        return AdRecommendation.parseResponse(response, context, request);
      }
    };
  }
}
