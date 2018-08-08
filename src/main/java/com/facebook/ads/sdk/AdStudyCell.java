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
public class AdStudyCell extends APINode {
  @SerializedName("ad_entities_count")
  private Long mAdEntitiesCount = null;
  @SerializedName("control_percentage")
  private Double mControlPercentage = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("treatment_percentage")
  private Double mTreatmentPercentage = null;
  protected static Gson gson = null;

  AdStudyCell() {
  }

  public AdStudyCell(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdStudyCell(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public AdStudyCell fetch() throws APIException{
    AdStudyCell newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdStudyCell fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdStudyCell> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdStudyCell fetchById(String id, APIContext context) throws APIException {
    AdStudyCell adStudyCell =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return adStudyCell;
  }

  public static ListenableFuture<AdStudyCell> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<AdStudyCell> adStudyCell =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return adStudyCell;
  }

  public static APINodeList<AdStudyCell> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdStudyCell>)(
      new APIRequest<AdStudyCell>(context, "", "/", "GET", AdStudyCell.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdStudyCell>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<AdStudyCell>> adStudyCell =
      new APIRequest(context, "", "/", "GET", AdStudyCell.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return adStudyCell;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdStudyCell loadJSON(String json, APIContext context) {
    AdStudyCell adStudyCell = getGson().fromJson(json, AdStudyCell.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adStudyCell.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adStudyCell.context = context;
    adStudyCell.rawValue = json;
    return adStudyCell;
  }

  public static APINodeList<AdStudyCell> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdStudyCell> adStudyCells = new APINodeList<AdStudyCell>(request, json);
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
          adStudyCells.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adStudyCells;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adStudyCells.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adStudyCells.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adStudyCells.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adStudyCells.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adStudyCells.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adStudyCells.add(loadJSON(obj.toString(), context));
            }
          }
          return adStudyCells;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adStudyCells.add(loadJSON(entry.getValue().toString(), context));
          }
          return adStudyCells;
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
              adStudyCells.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adStudyCells;
          }

          // Sixth, check if it's pure JsonObject
          adStudyCells.clear();
          adStudyCells.add(loadJSON(json, context));
          return adStudyCells;
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


  public Long getFieldAdEntitiesCount() {
    return mAdEntitiesCount;
  }

  public Double getFieldControlPercentage() {
    return mControlPercentage;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }

  public Double getFieldTreatmentPercentage() {
    return mTreatmentPercentage;
  }



  public static class APIRequestGet extends APIRequest<AdStudyCell> {

    AdStudyCell lastResponse = null;
    @Override
    public AdStudyCell getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_entities_count",
      "control_percentage",
      "id",
      "name",
      "treatment_percentage",
    };

    @Override
    public AdStudyCell parseResponse(String response) throws APIException {
      return AdStudyCell.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdStudyCell execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudyCell execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdStudyCell> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdStudyCell> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdStudyCell>() {
           public AdStudyCell apply(String result) {
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

    public APIRequestGet requestAdEntitiesCountField () {
      return this.requestAdEntitiesCountField(true);
    }
    public APIRequestGet requestAdEntitiesCountField (boolean value) {
      this.requestField("ad_entities_count", value);
      return this;
    }
    public APIRequestGet requestControlPercentageField () {
      return this.requestControlPercentageField(true);
    }
    public APIRequestGet requestControlPercentageField (boolean value) {
      this.requestField("control_percentage", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestTreatmentPercentageField () {
      return this.requestTreatmentPercentageField(true);
    }
    public APIRequestGet requestTreatmentPercentageField (boolean value) {
      this.requestField("treatment_percentage", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<AdStudyCell> {

    AdStudyCell lastResponse = null;
    @Override
    public AdStudyCell getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adaccounts",
      "adsets",
      "campaigns",
      "creation_template",
      "description",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdStudyCell parseResponse(String response) throws APIException {
      return AdStudyCell.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdStudyCell execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudyCell execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdStudyCell> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdStudyCell> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdStudyCell>() {
           public AdStudyCell apply(String result) {
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


    public APIRequestUpdate setAdaccounts (List<Long> adaccounts) {
      this.setParam("adaccounts", adaccounts);
      return this;
    }
    public APIRequestUpdate setAdaccounts (String adaccounts) {
      this.setParam("adaccounts", adaccounts);
      return this;
    }

    public APIRequestUpdate setAdsets (List<String> adsets) {
      this.setParam("adsets", adsets);
      return this;
    }
    public APIRequestUpdate setAdsets (String adsets) {
      this.setParam("adsets", adsets);
      return this;
    }

    public APIRequestUpdate setCampaigns (List<String> campaigns) {
      this.setParam("campaigns", campaigns);
      return this;
    }
    public APIRequestUpdate setCampaigns (String campaigns) {
      this.setParam("campaigns", campaigns);
      return this;
    }

    public APIRequestUpdate setCreationTemplate (AdStudyCell.EnumCreationTemplate creationTemplate) {
      this.setParam("creation_template", creationTemplate);
      return this;
    }
    public APIRequestUpdate setCreationTemplate (String creationTemplate) {
      this.setParam("creation_template", creationTemplate);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
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

  public static enum EnumCreationTemplate {
      @SerializedName("AUTOMATIC_PLACEMENTS")
      VALUE_AUTOMATIC_PLACEMENTS("AUTOMATIC_PLACEMENTS"),
      @SerializedName("BRAND_AWARENESS")
      VALUE_BRAND_AWARENESS("BRAND_AWARENESS"),
      @SerializedName("FACEBOOK")
      VALUE_FACEBOOK("FACEBOOK"),
      @SerializedName("FACEBOOK_AUDIENCE_NETWORK")
      VALUE_FACEBOOK_AUDIENCE_NETWORK("FACEBOOK_AUDIENCE_NETWORK"),
      @SerializedName("FACEBOOK_INSTAGRAM")
      VALUE_FACEBOOK_INSTAGRAM("FACEBOOK_INSTAGRAM"),
      @SerializedName("FACEBOOK_NEWS_FEED")
      VALUE_FACEBOOK_NEWS_FEED("FACEBOOK_NEWS_FEED"),
      @SerializedName("FACEBOOK_NEWS_FEED_IN_STREAM_VIDEO")
      VALUE_FACEBOOK_NEWS_FEED_IN_STREAM_VIDEO("FACEBOOK_NEWS_FEED_IN_STREAM_VIDEO"),
      @SerializedName("IN_STREAM_VIDEO")
      VALUE_IN_STREAM_VIDEO("IN_STREAM_VIDEO"),
      @SerializedName("INSTAGRAM")
      VALUE_INSTAGRAM("INSTAGRAM"),
      @SerializedName("MOBILE_OPTIMIZED_VIDEO")
      VALUE_MOBILE_OPTIMIZED_VIDEO("MOBILE_OPTIMIZED_VIDEO"),
      @SerializedName("PAGE_POST_ENGAGEMENT")
      VALUE_PAGE_POST_ENGAGEMENT("PAGE_POST_ENGAGEMENT"),
      @SerializedName("REACH")
      VALUE_REACH("REACH"),
      @SerializedName("TV_COMMERCIAL")
      VALUE_TV_COMMERCIAL("TV_COMMERCIAL"),
      @SerializedName("TV_FACEBOOK")
      VALUE_TV_FACEBOOK("TV_FACEBOOK"),
      @SerializedName("VIDEO_VIEW_OPTIMIZATION")
      VALUE_VIDEO_VIEW_OPTIMIZATION("VIDEO_VIEW_OPTIMIZATION"),
      @SerializedName("LOW_FREQUENCY")
      VALUE_LOW_FREQUENCY("LOW_FREQUENCY"),
      @SerializedName("MEDIUM_FREQUENCY")
      VALUE_MEDIUM_FREQUENCY("MEDIUM_FREQUENCY"),
      @SerializedName("HIGH_FREQUENCY")
      VALUE_HIGH_FREQUENCY("HIGH_FREQUENCY"),
      NULL(null);

      private String value;

      private EnumCreationTemplate(String value) {
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

  public AdStudyCell copyFrom(AdStudyCell instance) {
    this.mAdEntitiesCount = instance.mAdEntitiesCount;
    this.mControlPercentage = instance.mControlPercentage;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mTreatmentPercentage = instance.mTreatmentPercentage;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdStudyCell> getParser() {
    return new APIRequest.ResponseParser<AdStudyCell>() {
      public APINodeList<AdStudyCell> parseResponse(String response, APIContext context, APIRequest<AdStudyCell> request) throws MalformedResponseException {
        return AdStudyCell.parseResponse(response, context, request);
      }
    };
  }
}
