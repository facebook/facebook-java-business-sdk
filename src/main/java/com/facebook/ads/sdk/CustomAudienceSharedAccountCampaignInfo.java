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
public class CustomAudienceSharedAccountCampaignInfo extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("account_name")
  private String mAccountName = null;
  @SerializedName("adset_excluding_count")
  private Long mAdsetExcludingCount = null;
  @SerializedName("adset_including_count")
  private Long mAdsetIncludingCount = null;
  @SerializedName("campaign_delivery_status")
  private String mCampaignDeliveryStatus = null;
  @SerializedName("campaign_objective")
  private String mCampaignObjective = null;
  @SerializedName("campaign_pages")
  private List<Object> mCampaignPages = null;
  @SerializedName("campaign_schedule")
  private String mCampaignSchedule = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  CustomAudienceSharedAccountCampaignInfo() {
  }

  public CustomAudienceSharedAccountCampaignInfo(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CustomAudienceSharedAccountCampaignInfo(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CustomAudienceSharedAccountCampaignInfo fetch() throws APIException{
    CustomAudienceSharedAccountCampaignInfo newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CustomAudienceSharedAccountCampaignInfo fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CustomAudienceSharedAccountCampaignInfo> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CustomAudienceSharedAccountCampaignInfo fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CustomAudienceSharedAccountCampaignInfo> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CustomAudienceSharedAccountCampaignInfo> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CustomAudienceSharedAccountCampaignInfo>)(
      new APIRequest<CustomAudienceSharedAccountCampaignInfo>(context, "", "/", "GET", CustomAudienceSharedAccountCampaignInfo.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CustomAudienceSharedAccountCampaignInfo>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CustomAudienceSharedAccountCampaignInfo.getParser())
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
  public static CustomAudienceSharedAccountCampaignInfo loadJSON(String json, APIContext context) {
    CustomAudienceSharedAccountCampaignInfo customAudienceSharedAccountCampaignInfo = getGson().fromJson(json, CustomAudienceSharedAccountCampaignInfo.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(customAudienceSharedAccountCampaignInfo.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    customAudienceSharedAccountCampaignInfo.context = context;
    customAudienceSharedAccountCampaignInfo.rawValue = json;
    return customAudienceSharedAccountCampaignInfo;
  }

  public static APINodeList<CustomAudienceSharedAccountCampaignInfo> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<CustomAudienceSharedAccountCampaignInfo> customAudienceSharedAccountCampaignInfos = new APINodeList<CustomAudienceSharedAccountCampaignInfo>(request, json);
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
          customAudienceSharedAccountCampaignInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return customAudienceSharedAccountCampaignInfos;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                customAudienceSharedAccountCampaignInfos.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            customAudienceSharedAccountCampaignInfos.setPaging(previous, next);
            if (context.hasAppSecret()) {
              customAudienceSharedAccountCampaignInfos.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              customAudienceSharedAccountCampaignInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  customAudienceSharedAccountCampaignInfos.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              customAudienceSharedAccountCampaignInfos.add(loadJSON(obj.toString(), context));
            }
          }
          return customAudienceSharedAccountCampaignInfos;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              customAudienceSharedAccountCampaignInfos.add(loadJSON(entry.getValue().toString(), context));
          }
          return customAudienceSharedAccountCampaignInfos;
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
              customAudienceSharedAccountCampaignInfos.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return customAudienceSharedAccountCampaignInfos;
          }

          // Sixth, check if it's pure JsonObject
          customAudienceSharedAccountCampaignInfos.clear();
          customAudienceSharedAccountCampaignInfos.add(loadJSON(json, context));
          return customAudienceSharedAccountCampaignInfos;
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


  public String getFieldAccountId() {
    return mAccountId;
  }

  public String getFieldAccountName() {
    return mAccountName;
  }

  public Long getFieldAdsetExcludingCount() {
    return mAdsetExcludingCount;
  }

  public Long getFieldAdsetIncludingCount() {
    return mAdsetIncludingCount;
  }

  public String getFieldCampaignDeliveryStatus() {
    return mCampaignDeliveryStatus;
  }

  public String getFieldCampaignObjective() {
    return mCampaignObjective;
  }

  public List<Object> getFieldCampaignPages() {
    return mCampaignPages;
  }

  public String getFieldCampaignSchedule() {
    return mCampaignSchedule;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<CustomAudienceSharedAccountCampaignInfo> {

    CustomAudienceSharedAccountCampaignInfo lastResponse = null;
    @Override
    public CustomAudienceSharedAccountCampaignInfo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "account_name",
      "adset_excluding_count",
      "adset_including_count",
      "campaign_delivery_status",
      "campaign_objective",
      "campaign_pages",
      "campaign_schedule",
      "id",
    };

    @Override
    public CustomAudienceSharedAccountCampaignInfo parseResponse(String response) throws APIException {
      return CustomAudienceSharedAccountCampaignInfo.parseResponse(response, getContext(), this).head();
    }

    @Override
    public CustomAudienceSharedAccountCampaignInfo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CustomAudienceSharedAccountCampaignInfo execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<CustomAudienceSharedAccountCampaignInfo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CustomAudienceSharedAccountCampaignInfo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, CustomAudienceSharedAccountCampaignInfo>() {
           public CustomAudienceSharedAccountCampaignInfo apply(String result) {
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

    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestAccountNameField () {
      return this.requestAccountNameField(true);
    }
    public APIRequestGet requestAccountNameField (boolean value) {
      this.requestField("account_name", value);
      return this;
    }
    public APIRequestGet requestAdsetExcludingCountField () {
      return this.requestAdsetExcludingCountField(true);
    }
    public APIRequestGet requestAdsetExcludingCountField (boolean value) {
      this.requestField("adset_excluding_count", value);
      return this;
    }
    public APIRequestGet requestAdsetIncludingCountField () {
      return this.requestAdsetIncludingCountField(true);
    }
    public APIRequestGet requestAdsetIncludingCountField (boolean value) {
      this.requestField("adset_including_count", value);
      return this;
    }
    public APIRequestGet requestCampaignDeliveryStatusField () {
      return this.requestCampaignDeliveryStatusField(true);
    }
    public APIRequestGet requestCampaignDeliveryStatusField (boolean value) {
      this.requestField("campaign_delivery_status", value);
      return this;
    }
    public APIRequestGet requestCampaignObjectiveField () {
      return this.requestCampaignObjectiveField(true);
    }
    public APIRequestGet requestCampaignObjectiveField (boolean value) {
      this.requestField("campaign_objective", value);
      return this;
    }
    public APIRequestGet requestCampaignPagesField () {
      return this.requestCampaignPagesField(true);
    }
    public APIRequestGet requestCampaignPagesField (boolean value) {
      this.requestField("campaign_pages", value);
      return this;
    }
    public APIRequestGet requestCampaignScheduleField () {
      return this.requestCampaignScheduleField(true);
    }
    public APIRequestGet requestCampaignScheduleField (boolean value) {
      this.requestField("campaign_schedule", value);
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

  public CustomAudienceSharedAccountCampaignInfo copyFrom(CustomAudienceSharedAccountCampaignInfo instance) {
    this.mAccountId = instance.mAccountId;
    this.mAccountName = instance.mAccountName;
    this.mAdsetExcludingCount = instance.mAdsetExcludingCount;
    this.mAdsetIncludingCount = instance.mAdsetIncludingCount;
    this.mCampaignDeliveryStatus = instance.mCampaignDeliveryStatus;
    this.mCampaignObjective = instance.mCampaignObjective;
    this.mCampaignPages = instance.mCampaignPages;
    this.mCampaignSchedule = instance.mCampaignSchedule;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CustomAudienceSharedAccountCampaignInfo> getParser() {
    return new APIRequest.ResponseParser<CustomAudienceSharedAccountCampaignInfo>() {
      public APINodeList<CustomAudienceSharedAccountCampaignInfo> parseResponse(String response, APIContext context, APIRequest<CustomAudienceSharedAccountCampaignInfo> request) throws MalformedResponseException {
        return CustomAudienceSharedAccountCampaignInfo.parseResponse(response, context, request);
      }
    };
  }
}
