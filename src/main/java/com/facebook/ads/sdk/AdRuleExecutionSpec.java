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
public class AdRuleExecutionSpec extends APINode {
  @SerializedName("execution_options")
  private List<AdRuleExecutionOptions> mExecutionOptions = null;
  @SerializedName("execution_type")
  private EnumExecutionType mExecutionType = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdRuleExecutionSpec() {
  }

  public AdRuleExecutionSpec(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdRuleExecutionSpec(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdRuleExecutionSpec fetch() throws APIException{
    AdRuleExecutionSpec newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdRuleExecutionSpec fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdRuleExecutionSpec> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdRuleExecutionSpec fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdRuleExecutionSpec> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdRuleExecutionSpec> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdRuleExecutionSpec>)(
      new APIRequest<AdRuleExecutionSpec>(context, "", "/", "GET", AdRuleExecutionSpec.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdRuleExecutionSpec>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdRuleExecutionSpec.getParser())
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
  public static AdRuleExecutionSpec loadJSON(String json, APIContext context, String header) {
    AdRuleExecutionSpec adRuleExecutionSpec = getGson().fromJson(json, AdRuleExecutionSpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adRuleExecutionSpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adRuleExecutionSpec.context = context;
    adRuleExecutionSpec.rawValue = json;
    adRuleExecutionSpec.header = header;
    return adRuleExecutionSpec;
  }

  public static APINodeList<AdRuleExecutionSpec> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdRuleExecutionSpec> adRuleExecutionSpecs = new APINodeList<AdRuleExecutionSpec>(request, json, header);
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
          adRuleExecutionSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adRuleExecutionSpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adRuleExecutionSpecs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adRuleExecutionSpecs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adRuleExecutionSpecs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adRuleExecutionSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adRuleExecutionSpecs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adRuleExecutionSpecs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adRuleExecutionSpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adRuleExecutionSpecs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adRuleExecutionSpecs;
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
              adRuleExecutionSpecs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adRuleExecutionSpecs;
          }

          // Sixth, check if it's pure JsonObject
          adRuleExecutionSpecs.clear();
          adRuleExecutionSpecs.add(loadJSON(json, context, header));
          return adRuleExecutionSpecs;
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


  public List<AdRuleExecutionOptions> getFieldExecutionOptions() {
    return mExecutionOptions;
  }

  public EnumExecutionType getFieldExecutionType() {
    return mExecutionType;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdRuleExecutionSpec> {

    AdRuleExecutionSpec lastResponse = null;
    @Override
    public AdRuleExecutionSpec getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "execution_options",
      "execution_type",
      "id",
    };

    @Override
    public AdRuleExecutionSpec parseResponse(String response, String header) throws APIException {
      return AdRuleExecutionSpec.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdRuleExecutionSpec execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdRuleExecutionSpec execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdRuleExecutionSpec> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdRuleExecutionSpec> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdRuleExecutionSpec>() {
           public AdRuleExecutionSpec apply(ResponseWrapper result) {
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

    public APIRequestGet requestExecutionOptionsField () {
      return this.requestExecutionOptionsField(true);
    }
    public APIRequestGet requestExecutionOptionsField (boolean value) {
      this.requestField("execution_options", value);
      return this;
    }
    public APIRequestGet requestExecutionTypeField () {
      return this.requestExecutionTypeField(true);
    }
    public APIRequestGet requestExecutionTypeField (boolean value) {
      this.requestField("execution_type", value);
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

  public static enum EnumExecutionType {
      @SerializedName("ADD_INTEREST_RELAXATION")
      VALUE_ADD_INTEREST_RELAXATION("ADD_INTEREST_RELAXATION"),
      @SerializedName("ADD_QUESTIONNAIRE_INTERESTS")
      VALUE_ADD_QUESTIONNAIRE_INTERESTS("ADD_QUESTIONNAIRE_INTERESTS"),
      @SerializedName("AUDIENCE_CONSOLIDATION")
      VALUE_AUDIENCE_CONSOLIDATION("AUDIENCE_CONSOLIDATION"),
      @SerializedName("AUDIENCE_CONSOLIDATION_ASK_FIRST")
      VALUE_AUDIENCE_CONSOLIDATION_ASK_FIRST("AUDIENCE_CONSOLIDATION_ASK_FIRST"),
      @SerializedName("CHANGE_BID")
      VALUE_CHANGE_BID("CHANGE_BID"),
      @SerializedName("CHANGE_BUDGET")
      VALUE_CHANGE_BUDGET("CHANGE_BUDGET"),
      @SerializedName("CHANGE_CAMPAIGN_BUDGET")
      VALUE_CHANGE_CAMPAIGN_BUDGET("CHANGE_CAMPAIGN_BUDGET"),
      @SerializedName("INCREASE_RADIUS")
      VALUE_INCREASE_RADIUS("INCREASE_RADIUS"),
      @SerializedName("NOTIFICATION")
      VALUE_NOTIFICATION("NOTIFICATION"),
      @SerializedName("PAUSE")
      VALUE_PAUSE("PAUSE"),
      @SerializedName("PING_ENDPOINT")
      VALUE_PING_ENDPOINT("PING_ENDPOINT"),
      @SerializedName("REBALANCE_BUDGET")
      VALUE_REBALANCE_BUDGET("REBALANCE_BUDGET"),
      @SerializedName("ROTATE")
      VALUE_ROTATE("ROTATE"),
      @SerializedName("UNPAUSE")
      VALUE_UNPAUSE("UNPAUSE"),
      @SerializedName("UPDATE_CREATIVE")
      VALUE_UPDATE_CREATIVE("UPDATE_CREATIVE"),
      @SerializedName("UPDATE_LAX_BUDGET")
      VALUE_UPDATE_LAX_BUDGET("UPDATE_LAX_BUDGET"),
      @SerializedName("UPDATE_LAX_DURATION")
      VALUE_UPDATE_LAX_DURATION("UPDATE_LAX_DURATION"),
      ;

      private String value;

      private EnumExecutionType(String value) {
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

  public AdRuleExecutionSpec copyFrom(AdRuleExecutionSpec instance) {
    this.mExecutionOptions = instance.mExecutionOptions;
    this.mExecutionType = instance.mExecutionType;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdRuleExecutionSpec> getParser() {
    return new APIRequest.ResponseParser<AdRuleExecutionSpec>() {
      public APINodeList<AdRuleExecutionSpec> parseResponse(String response, APIContext context, APIRequest<AdRuleExecutionSpec> request, String header) throws MalformedResponseException {
        return AdRuleExecutionSpec.parseResponse(response, context, request, header);
      }
    };
  }
}
