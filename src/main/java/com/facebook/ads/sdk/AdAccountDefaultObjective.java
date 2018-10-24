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
public class AdAccountDefaultObjective extends APINode {
  @SerializedName("default_objective_for_user")
  private EnumDefaultObjectiveForUser mDefaultObjectiveForUser = null;
  @SerializedName("objective_for_level")
  private EnumObjectiveForLevel mObjectiveForLevel = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdAccountDefaultObjective() {
  }

  public AdAccountDefaultObjective(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAccountDefaultObjective(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdAccountDefaultObjective fetch() throws APIException{
    AdAccountDefaultObjective newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdAccountDefaultObjective fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdAccountDefaultObjective> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdAccountDefaultObjective fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdAccountDefaultObjective> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdAccountDefaultObjective> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdAccountDefaultObjective>)(
      new APIRequest<AdAccountDefaultObjective>(context, "", "/", "GET", AdAccountDefaultObjective.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdAccountDefaultObjective>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdAccountDefaultObjective.getParser())
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
  public static AdAccountDefaultObjective loadJSON(String json, APIContext context) {
    AdAccountDefaultObjective adAccountDefaultObjective = getGson().fromJson(json, AdAccountDefaultObjective.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountDefaultObjective.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAccountDefaultObjective.context = context;
    adAccountDefaultObjective.rawValue = json;
    return adAccountDefaultObjective;
  }

  public static APINodeList<AdAccountDefaultObjective> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdAccountDefaultObjective> adAccountDefaultObjectives = new APINodeList<AdAccountDefaultObjective>(request, json);
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
          adAccountDefaultObjectives.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adAccountDefaultObjectives;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountDefaultObjectives.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountDefaultObjectives.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountDefaultObjectives.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountDefaultObjectives.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adAccountDefaultObjectives.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountDefaultObjectives.add(loadJSON(obj.toString(), context));
            }
          }
          return adAccountDefaultObjectives;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountDefaultObjectives.add(loadJSON(entry.getValue().toString(), context));
          }
          return adAccountDefaultObjectives;
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
              adAccountDefaultObjectives.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountDefaultObjectives;
          }

          // Sixth, check if it's pure JsonObject
          adAccountDefaultObjectives.clear();
          adAccountDefaultObjectives.add(loadJSON(json, context));
          return adAccountDefaultObjectives;
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


  public EnumDefaultObjectiveForUser getFieldDefaultObjectiveForUser() {
    return mDefaultObjectiveForUser;
  }

  public EnumObjectiveForLevel getFieldObjectiveForLevel() {
    return mObjectiveForLevel;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdAccountDefaultObjective> {

    AdAccountDefaultObjective lastResponse = null;
    @Override
    public AdAccountDefaultObjective getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adgroup_id",
      "campaign_group_id",
      "campaign_id",
    };

    public static final String[] FIELDS = {
      "default_objective_for_user",
      "objective_for_level",
      "id",
    };

    @Override
    public AdAccountDefaultObjective parseResponse(String response) throws APIException {
      return AdAccountDefaultObjective.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAccountDefaultObjective execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccountDefaultObjective execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdAccountDefaultObjective> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccountDefaultObjective> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdAccountDefaultObjective>() {
           public AdAccountDefaultObjective apply(String result) {
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


    public APIRequestGet setAdgroupId (String adgroupId) {
      this.setParam("adgroup_id", adgroupId);
      return this;
    }

    public APIRequestGet setCampaignGroupId (String campaignGroupId) {
      this.setParam("campaign_group_id", campaignGroupId);
      return this;
    }

    public APIRequestGet setCampaignId (String campaignId) {
      this.setParam("campaign_id", campaignId);
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

    public APIRequestGet requestDefaultObjectiveForUserField () {
      return this.requestDefaultObjectiveForUserField(true);
    }
    public APIRequestGet requestDefaultObjectiveForUserField (boolean value) {
      this.requestField("default_objective_for_user", value);
      return this;
    }
    public APIRequestGet requestObjectiveForLevelField () {
      return this.requestObjectiveForLevelField(true);
    }
    public APIRequestGet requestObjectiveForLevelField (boolean value) {
      this.requestField("objective_for_level", value);
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

  public static enum EnumDefaultObjectiveForUser {
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OFFER_CLAIMS")
      VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("CANVAS_APP_INSTALLS")
      VALUE_CANVAS_APP_INSTALLS("CANVAS_APP_INSTALLS"),
      @SerializedName("EVENT_RESPONSES")
      VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
      @SerializedName("CANVAS_APP_ENGAGEMENT")
      VALUE_CANVAS_APP_ENGAGEMENT("CANVAS_APP_ENGAGEMENT"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("WEBSITE_CONVERSIONS")
      VALUE_WEBSITE_CONVERSIONS("WEBSITE_CONVERSIONS"),
      @SerializedName("MOBILE_APP_INSTALLS")
      VALUE_MOBILE_APP_INSTALLS("MOBILE_APP_INSTALLS"),
      @SerializedName("LINK_CLICKS")
      VALUE_LINK_CLICKS("LINK_CLICKS"),
      @SerializedName("MOBILE_APP_ENGAGEMENT")
      VALUE_MOBILE_APP_ENGAGEMENT("MOBILE_APP_ENGAGEMENT"),
      @SerializedName("VIDEO_VIEWS")
      VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
      @SerializedName("LOCAL_AWARENESS")
      VALUE_LOCAL_AWARENESS("LOCAL_AWARENESS"),
      @SerializedName("PRODUCT_CATALOG_SALES")
      VALUE_PRODUCT_CATALOG_SALES("PRODUCT_CATALOG_SALES"),
      @SerializedName("LEAD_GENERATION")
      VALUE_LEAD_GENERATION("LEAD_GENERATION"),
      @SerializedName("BRAND_AWARENESS")
      VALUE_BRAND_AWARENESS("BRAND_AWARENESS"),
      @SerializedName("APP_INSTALLS")
      VALUE_APP_INSTALLS("APP_INSTALLS"),
      @SerializedName("MESSAGES")
      VALUE_MESSAGES("MESSAGES"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumDefaultObjectiveForUser(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumObjectiveForLevel {
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OFFER_CLAIMS")
      VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("CANVAS_APP_INSTALLS")
      VALUE_CANVAS_APP_INSTALLS("CANVAS_APP_INSTALLS"),
      @SerializedName("EVENT_RESPONSES")
      VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
      @SerializedName("CANVAS_APP_ENGAGEMENT")
      VALUE_CANVAS_APP_ENGAGEMENT("CANVAS_APP_ENGAGEMENT"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("WEBSITE_CONVERSIONS")
      VALUE_WEBSITE_CONVERSIONS("WEBSITE_CONVERSIONS"),
      @SerializedName("MOBILE_APP_INSTALLS")
      VALUE_MOBILE_APP_INSTALLS("MOBILE_APP_INSTALLS"),
      @SerializedName("LINK_CLICKS")
      VALUE_LINK_CLICKS("LINK_CLICKS"),
      @SerializedName("MOBILE_APP_ENGAGEMENT")
      VALUE_MOBILE_APP_ENGAGEMENT("MOBILE_APP_ENGAGEMENT"),
      @SerializedName("VIDEO_VIEWS")
      VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
      @SerializedName("LOCAL_AWARENESS")
      VALUE_LOCAL_AWARENESS("LOCAL_AWARENESS"),
      @SerializedName("PRODUCT_CATALOG_SALES")
      VALUE_PRODUCT_CATALOG_SALES("PRODUCT_CATALOG_SALES"),
      @SerializedName("LEAD_GENERATION")
      VALUE_LEAD_GENERATION("LEAD_GENERATION"),
      @SerializedName("BRAND_AWARENESS")
      VALUE_BRAND_AWARENESS("BRAND_AWARENESS"),
      @SerializedName("APP_INSTALLS")
      VALUE_APP_INSTALLS("APP_INSTALLS"),
      @SerializedName("MESSAGES")
      VALUE_MESSAGES("MESSAGES"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumObjectiveForLevel(String value) {
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

  public AdAccountDefaultObjective copyFrom(AdAccountDefaultObjective instance) {
    this.mDefaultObjectiveForUser = instance.mDefaultObjectiveForUser;
    this.mObjectiveForLevel = instance.mObjectiveForLevel;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountDefaultObjective> getParser() {
    return new APIRequest.ResponseParser<AdAccountDefaultObjective>() {
      public APINodeList<AdAccountDefaultObjective> parseResponse(String response, APIContext context, APIRequest<AdAccountDefaultObjective> request) throws MalformedResponseException {
        return AdAccountDefaultObjective.parseResponse(response, context, request);
      }
    };
  }
}
