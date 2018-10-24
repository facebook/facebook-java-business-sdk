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
public class AdCampaignLearningStageInfo extends APINode {
  @SerializedName("attribution_windows")
  private List<String> mAttributionWindows = null;
  @SerializedName("conversions")
  private Object mConversions = null;
  @SerializedName("exit_reason")
  private String mExitReason = null;
  @SerializedName("last_sig_edit_ts")
  private Long mLastSigEditTs = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("types")
  private List<String> mTypes = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdCampaignLearningStageInfo() {
  }

  public AdCampaignLearningStageInfo(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCampaignLearningStageInfo(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdCampaignLearningStageInfo fetch() throws APIException{
    AdCampaignLearningStageInfo newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdCampaignLearningStageInfo fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdCampaignLearningStageInfo> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdCampaignLearningStageInfo fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdCampaignLearningStageInfo> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdCampaignLearningStageInfo> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCampaignLearningStageInfo>)(
      new APIRequest<AdCampaignLearningStageInfo>(context, "", "/", "GET", AdCampaignLearningStageInfo.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdCampaignLearningStageInfo>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdCampaignLearningStageInfo.getParser())
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
  public static AdCampaignLearningStageInfo loadJSON(String json, APIContext context) {
    AdCampaignLearningStageInfo adCampaignLearningStageInfo = getGson().fromJson(json, AdCampaignLearningStageInfo.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCampaignLearningStageInfo.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCampaignLearningStageInfo.context = context;
    adCampaignLearningStageInfo.rawValue = json;
    return adCampaignLearningStageInfo;
  }

  public static APINodeList<AdCampaignLearningStageInfo> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdCampaignLearningStageInfo> adCampaignLearningStageInfos = new APINodeList<AdCampaignLearningStageInfo>(request, json);
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
          adCampaignLearningStageInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adCampaignLearningStageInfos;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCampaignLearningStageInfos.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCampaignLearningStageInfos.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCampaignLearningStageInfos.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCampaignLearningStageInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adCampaignLearningStageInfos.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCampaignLearningStageInfos.add(loadJSON(obj.toString(), context));
            }
          }
          return adCampaignLearningStageInfos;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCampaignLearningStageInfos.add(loadJSON(entry.getValue().toString(), context));
          }
          return adCampaignLearningStageInfos;
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
              adCampaignLearningStageInfos.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCampaignLearningStageInfos;
          }

          // Sixth, check if it's pure JsonObject
          adCampaignLearningStageInfos.clear();
          adCampaignLearningStageInfos.add(loadJSON(json, context));
          return adCampaignLearningStageInfos;
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


  public List<String> getFieldAttributionWindows() {
    return mAttributionWindows;
  }

  public Object getFieldConversions() {
    return mConversions;
  }

  public String getFieldExitReason() {
    return mExitReason;
  }

  public Long getFieldLastSigEditTs() {
    return mLastSigEditTs;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public List<String> getFieldTypes() {
    return mTypes;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdCampaignLearningStageInfo> {

    AdCampaignLearningStageInfo lastResponse = null;
    @Override
    public AdCampaignLearningStageInfo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "attribution_windows",
      "conversions",
      "exit_reason",
      "last_sig_edit_ts",
      "status",
      "types",
      "id",
    };

    @Override
    public AdCampaignLearningStageInfo parseResponse(String response) throws APIException {
      return AdCampaignLearningStageInfo.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdCampaignLearningStageInfo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCampaignLearningStageInfo execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdCampaignLearningStageInfo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCampaignLearningStageInfo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdCampaignLearningStageInfo>() {
           public AdCampaignLearningStageInfo apply(String result) {
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

    public APIRequestGet requestAttributionWindowsField () {
      return this.requestAttributionWindowsField(true);
    }
    public APIRequestGet requestAttributionWindowsField (boolean value) {
      this.requestField("attribution_windows", value);
      return this;
    }
    public APIRequestGet requestConversionsField () {
      return this.requestConversionsField(true);
    }
    public APIRequestGet requestConversionsField (boolean value) {
      this.requestField("conversions", value);
      return this;
    }
    public APIRequestGet requestExitReasonField () {
      return this.requestExitReasonField(true);
    }
    public APIRequestGet requestExitReasonField (boolean value) {
      this.requestField("exit_reason", value);
      return this;
    }
    public APIRequestGet requestLastSigEditTsField () {
      return this.requestLastSigEditTsField(true);
    }
    public APIRequestGet requestLastSigEditTsField (boolean value) {
      this.requestField("last_sig_edit_ts", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTypesField () {
      return this.requestTypesField(true);
    }
    public APIRequestGet requestTypesField (boolean value) {
      this.requestField("types", value);
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

  public AdCampaignLearningStageInfo copyFrom(AdCampaignLearningStageInfo instance) {
    this.mAttributionWindows = instance.mAttributionWindows;
    this.mConversions = instance.mConversions;
    this.mExitReason = instance.mExitReason;
    this.mLastSigEditTs = instance.mLastSigEditTs;
    this.mStatus = instance.mStatus;
    this.mTypes = instance.mTypes;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCampaignLearningStageInfo> getParser() {
    return new APIRequest.ResponseParser<AdCampaignLearningStageInfo>() {
      public APINodeList<AdCampaignLearningStageInfo> parseResponse(String response, APIContext context, APIRequest<AdCampaignLearningStageInfo> request) throws MalformedResponseException {
        return AdCampaignLearningStageInfo.parseResponse(response, context, request);
      }
    };
  }
}
