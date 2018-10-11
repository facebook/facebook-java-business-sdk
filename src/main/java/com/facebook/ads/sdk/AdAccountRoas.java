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
public class AdAccountRoas extends APINode {
  @SerializedName("adgroup_id")
  private String mAdgroupId = null;
  @SerializedName("arpu_180d")
  private Double mArpu180d = null;
  @SerializedName("arpu_1d")
  private Double mArpu1d = null;
  @SerializedName("arpu_30d")
  private Double mArpu30d = null;
  @SerializedName("arpu_365d")
  private Double mArpu365d = null;
  @SerializedName("arpu_3d")
  private Double mArpu3d = null;
  @SerializedName("arpu_7d")
  private Double mArpu7d = null;
  @SerializedName("arpu_90d")
  private Double mArpu90d = null;
  @SerializedName("campaign_group_id")
  private String mCampaignGroupId = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("date_start")
  private String mDateStart = null;
  @SerializedName("date_stop")
  private String mDateStop = null;
  @SerializedName("installs")
  private Long mInstalls = null;
  @SerializedName("revenue")
  private Double mRevenue = null;
  @SerializedName("revenue_180d")
  private Double mRevenue180d = null;
  @SerializedName("revenue_1d")
  private Double mRevenue1d = null;
  @SerializedName("revenue_30d")
  private Double mRevenue30d = null;
  @SerializedName("revenue_365d")
  private Double mRevenue365d = null;
  @SerializedName("revenue_3d")
  private Double mRevenue3d = null;
  @SerializedName("revenue_7d")
  private Double mRevenue7d = null;
  @SerializedName("revenue_90d")
  private Double mRevenue90d = null;
  @SerializedName("spend")
  private Double mSpend = null;
  @SerializedName("yield_180d")
  private Double mYield180d = null;
  @SerializedName("yield_1d")
  private Double mYield1d = null;
  @SerializedName("yield_30d")
  private Double mYield30d = null;
  @SerializedName("yield_365d")
  private Double mYield365d = null;
  @SerializedName("yield_3d")
  private Double mYield3d = null;
  @SerializedName("yield_7d")
  private Double mYield7d = null;
  @SerializedName("yield_90d")
  private Double mYield90d = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdAccountRoas() {
  }

  public AdAccountRoas(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAccountRoas(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdAccountRoas fetch() throws APIException{
    AdAccountRoas newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdAccountRoas fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdAccountRoas> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdAccountRoas fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdAccountRoas> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdAccountRoas> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdAccountRoas>)(
      new APIRequest<AdAccountRoas>(context, "", "/", "GET", AdAccountRoas.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdAccountRoas>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdAccountRoas.getParser())
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
  public static AdAccountRoas loadJSON(String json, APIContext context) {
    AdAccountRoas adAccountRoas = getGson().fromJson(json, AdAccountRoas.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountRoas.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAccountRoas.context = context;
    adAccountRoas.rawValue = json;
    return adAccountRoas;
  }

  public static APINodeList<AdAccountRoas> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdAccountRoas> adAccountRoass = new APINodeList<AdAccountRoas>(request, json);
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
          adAccountRoass.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adAccountRoass;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountRoass.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountRoass.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountRoass.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountRoass.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adAccountRoass.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountRoass.add(loadJSON(obj.toString(), context));
            }
          }
          return adAccountRoass;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountRoass.add(loadJSON(entry.getValue().toString(), context));
          }
          return adAccountRoass;
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
              adAccountRoass.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountRoass;
          }

          // Sixth, check if it's pure JsonObject
          adAccountRoass.clear();
          adAccountRoass.add(loadJSON(json, context));
          return adAccountRoass;
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


  public String getFieldAdgroupId() {
    return mAdgroupId;
  }

  public Double getFieldArpu180d() {
    return mArpu180d;
  }

  public Double getFieldArpu1d() {
    return mArpu1d;
  }

  public Double getFieldArpu30d() {
    return mArpu30d;
  }

  public Double getFieldArpu365d() {
    return mArpu365d;
  }

  public Double getFieldArpu3d() {
    return mArpu3d;
  }

  public Double getFieldArpu7d() {
    return mArpu7d;
  }

  public Double getFieldArpu90d() {
    return mArpu90d;
  }

  public String getFieldCampaignGroupId() {
    return mCampaignGroupId;
  }

  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public String getFieldDateStart() {
    return mDateStart;
  }

  public String getFieldDateStop() {
    return mDateStop;
  }

  public Long getFieldInstalls() {
    return mInstalls;
  }

  public Double getFieldRevenue() {
    return mRevenue;
  }

  public Double getFieldRevenue180d() {
    return mRevenue180d;
  }

  public Double getFieldRevenue1d() {
    return mRevenue1d;
  }

  public Double getFieldRevenue30d() {
    return mRevenue30d;
  }

  public Double getFieldRevenue365d() {
    return mRevenue365d;
  }

  public Double getFieldRevenue3d() {
    return mRevenue3d;
  }

  public Double getFieldRevenue7d() {
    return mRevenue7d;
  }

  public Double getFieldRevenue90d() {
    return mRevenue90d;
  }

  public Double getFieldSpend() {
    return mSpend;
  }

  public Double getFieldYield180d() {
    return mYield180d;
  }

  public Double getFieldYield1d() {
    return mYield1d;
  }

  public Double getFieldYield30d() {
    return mYield30d;
  }

  public Double getFieldYield365d() {
    return mYield365d;
  }

  public Double getFieldYield3d() {
    return mYield3d;
  }

  public Double getFieldYield7d() {
    return mYield7d;
  }

  public Double getFieldYield90d() {
    return mYield90d;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdAccountRoas> {

    AdAccountRoas lastResponse = null;
    @Override
    public AdAccountRoas getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "adgroup_id",
      "arpu_180d",
      "arpu_1d",
      "arpu_30d",
      "arpu_365d",
      "arpu_3d",
      "arpu_7d",
      "arpu_90d",
      "campaign_group_id",
      "campaign_id",
      "date_start",
      "date_stop",
      "installs",
      "revenue",
      "revenue_180d",
      "revenue_1d",
      "revenue_30d",
      "revenue_365d",
      "revenue_3d",
      "revenue_7d",
      "revenue_90d",
      "spend",
      "yield_180d",
      "yield_1d",
      "yield_30d",
      "yield_365d",
      "yield_3d",
      "yield_7d",
      "yield_90d",
      "id",
    };

    @Override
    public AdAccountRoas parseResponse(String response) throws APIException {
      return AdAccountRoas.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAccountRoas execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccountRoas execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdAccountRoas> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccountRoas> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdAccountRoas>() {
           public AdAccountRoas apply(String result) {
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

    public APIRequestGet requestAdgroupIdField () {
      return this.requestAdgroupIdField(true);
    }
    public APIRequestGet requestAdgroupIdField (boolean value) {
      this.requestField("adgroup_id", value);
      return this;
    }
    public APIRequestGet requestArpu180dField () {
      return this.requestArpu180dField(true);
    }
    public APIRequestGet requestArpu180dField (boolean value) {
      this.requestField("arpu_180d", value);
      return this;
    }
    public APIRequestGet requestArpu1dField () {
      return this.requestArpu1dField(true);
    }
    public APIRequestGet requestArpu1dField (boolean value) {
      this.requestField("arpu_1d", value);
      return this;
    }
    public APIRequestGet requestArpu30dField () {
      return this.requestArpu30dField(true);
    }
    public APIRequestGet requestArpu30dField (boolean value) {
      this.requestField("arpu_30d", value);
      return this;
    }
    public APIRequestGet requestArpu365dField () {
      return this.requestArpu365dField(true);
    }
    public APIRequestGet requestArpu365dField (boolean value) {
      this.requestField("arpu_365d", value);
      return this;
    }
    public APIRequestGet requestArpu3dField () {
      return this.requestArpu3dField(true);
    }
    public APIRequestGet requestArpu3dField (boolean value) {
      this.requestField("arpu_3d", value);
      return this;
    }
    public APIRequestGet requestArpu7dField () {
      return this.requestArpu7dField(true);
    }
    public APIRequestGet requestArpu7dField (boolean value) {
      this.requestField("arpu_7d", value);
      return this;
    }
    public APIRequestGet requestArpu90dField () {
      return this.requestArpu90dField(true);
    }
    public APIRequestGet requestArpu90dField (boolean value) {
      this.requestField("arpu_90d", value);
      return this;
    }
    public APIRequestGet requestCampaignGroupIdField () {
      return this.requestCampaignGroupIdField(true);
    }
    public APIRequestGet requestCampaignGroupIdField (boolean value) {
      this.requestField("campaign_group_id", value);
      return this;
    }
    public APIRequestGet requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGet requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
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
    public APIRequestGet requestInstallsField () {
      return this.requestInstallsField(true);
    }
    public APIRequestGet requestInstallsField (boolean value) {
      this.requestField("installs", value);
      return this;
    }
    public APIRequestGet requestRevenueField () {
      return this.requestRevenueField(true);
    }
    public APIRequestGet requestRevenueField (boolean value) {
      this.requestField("revenue", value);
      return this;
    }
    public APIRequestGet requestRevenue180dField () {
      return this.requestRevenue180dField(true);
    }
    public APIRequestGet requestRevenue180dField (boolean value) {
      this.requestField("revenue_180d", value);
      return this;
    }
    public APIRequestGet requestRevenue1dField () {
      return this.requestRevenue1dField(true);
    }
    public APIRequestGet requestRevenue1dField (boolean value) {
      this.requestField("revenue_1d", value);
      return this;
    }
    public APIRequestGet requestRevenue30dField () {
      return this.requestRevenue30dField(true);
    }
    public APIRequestGet requestRevenue30dField (boolean value) {
      this.requestField("revenue_30d", value);
      return this;
    }
    public APIRequestGet requestRevenue365dField () {
      return this.requestRevenue365dField(true);
    }
    public APIRequestGet requestRevenue365dField (boolean value) {
      this.requestField("revenue_365d", value);
      return this;
    }
    public APIRequestGet requestRevenue3dField () {
      return this.requestRevenue3dField(true);
    }
    public APIRequestGet requestRevenue3dField (boolean value) {
      this.requestField("revenue_3d", value);
      return this;
    }
    public APIRequestGet requestRevenue7dField () {
      return this.requestRevenue7dField(true);
    }
    public APIRequestGet requestRevenue7dField (boolean value) {
      this.requestField("revenue_7d", value);
      return this;
    }
    public APIRequestGet requestRevenue90dField () {
      return this.requestRevenue90dField(true);
    }
    public APIRequestGet requestRevenue90dField (boolean value) {
      this.requestField("revenue_90d", value);
      return this;
    }
    public APIRequestGet requestSpendField () {
      return this.requestSpendField(true);
    }
    public APIRequestGet requestSpendField (boolean value) {
      this.requestField("spend", value);
      return this;
    }
    public APIRequestGet requestYield180dField () {
      return this.requestYield180dField(true);
    }
    public APIRequestGet requestYield180dField (boolean value) {
      this.requestField("yield_180d", value);
      return this;
    }
    public APIRequestGet requestYield1dField () {
      return this.requestYield1dField(true);
    }
    public APIRequestGet requestYield1dField (boolean value) {
      this.requestField("yield_1d", value);
      return this;
    }
    public APIRequestGet requestYield30dField () {
      return this.requestYield30dField(true);
    }
    public APIRequestGet requestYield30dField (boolean value) {
      this.requestField("yield_30d", value);
      return this;
    }
    public APIRequestGet requestYield365dField () {
      return this.requestYield365dField(true);
    }
    public APIRequestGet requestYield365dField (boolean value) {
      this.requestField("yield_365d", value);
      return this;
    }
    public APIRequestGet requestYield3dField () {
      return this.requestYield3dField(true);
    }
    public APIRequestGet requestYield3dField (boolean value) {
      this.requestField("yield_3d", value);
      return this;
    }
    public APIRequestGet requestYield7dField () {
      return this.requestYield7dField(true);
    }
    public APIRequestGet requestYield7dField (boolean value) {
      this.requestField("yield_7d", value);
      return this;
    }
    public APIRequestGet requestYield90dField () {
      return this.requestYield90dField(true);
    }
    public APIRequestGet requestYield90dField (boolean value) {
      this.requestField("yield_90d", value);
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

  public AdAccountRoas copyFrom(AdAccountRoas instance) {
    this.mAdgroupId = instance.mAdgroupId;
    this.mArpu180d = instance.mArpu180d;
    this.mArpu1d = instance.mArpu1d;
    this.mArpu30d = instance.mArpu30d;
    this.mArpu365d = instance.mArpu365d;
    this.mArpu3d = instance.mArpu3d;
    this.mArpu7d = instance.mArpu7d;
    this.mArpu90d = instance.mArpu90d;
    this.mCampaignGroupId = instance.mCampaignGroupId;
    this.mCampaignId = instance.mCampaignId;
    this.mDateStart = instance.mDateStart;
    this.mDateStop = instance.mDateStop;
    this.mInstalls = instance.mInstalls;
    this.mRevenue = instance.mRevenue;
    this.mRevenue180d = instance.mRevenue180d;
    this.mRevenue1d = instance.mRevenue1d;
    this.mRevenue30d = instance.mRevenue30d;
    this.mRevenue365d = instance.mRevenue365d;
    this.mRevenue3d = instance.mRevenue3d;
    this.mRevenue7d = instance.mRevenue7d;
    this.mRevenue90d = instance.mRevenue90d;
    this.mSpend = instance.mSpend;
    this.mYield180d = instance.mYield180d;
    this.mYield1d = instance.mYield1d;
    this.mYield30d = instance.mYield30d;
    this.mYield365d = instance.mYield365d;
    this.mYield3d = instance.mYield3d;
    this.mYield7d = instance.mYield7d;
    this.mYield90d = instance.mYield90d;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountRoas> getParser() {
    return new APIRequest.ResponseParser<AdAccountRoas>() {
      public APINodeList<AdAccountRoas> parseResponse(String response, APIContext context, APIRequest<AdAccountRoas> request) throws MalformedResponseException {
        return AdAccountRoas.parseResponse(response, context, request);
      }
    };
  }
}
