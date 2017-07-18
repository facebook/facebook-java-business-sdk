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
 * This class is auto-genereated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class AdStudy extends APINode {
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("canceled_time")
  private String mCanceledTime = null;
  @SerializedName("cooldown_start_time")
  private String mCooldownStartTime = null;
  @SerializedName("created_by")
  private User mCreatedBy = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("observation_end_time")
  private String mObservationEndTime = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("type")
  private String mType = null;
  @SerializedName("updated_by")
  private User mUpdatedBy = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  protected static Gson gson = null;

  AdStudy() {
  }

  public AdStudy(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdStudy(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public AdStudy fetch() throws APIException{
    AdStudy newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdStudy fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static AdStudy fetchById(String id, APIContext context) throws APIException {
    AdStudy adStudy =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return adStudy;
  }

  public static APINodeList<AdStudy> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdStudy>)(
      new APIRequest<AdStudy>(context, "", "/", "GET", AdStudy.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdStudy loadJSON(String json, APIContext context) {
    AdStudy adStudy = getGson().fromJson(json, AdStudy.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adStudy.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adStudy.context = context;
    adStudy.rawValue = json;
    return adStudy;
  }

  public static APINodeList<AdStudy> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdStudy> adStudys = new APINodeList<AdStudy>(request, json);
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
          adStudys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adStudys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adStudys.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adStudys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adStudys.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adStudys.add(loadJSON(obj.toString(), context));
            }
          }
          return adStudys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adStudys.add(loadJSON(entry.getValue().toString(), context));
          }
          return adStudys;
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
              adStudys.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adStudys;
          }

          // Sixth, check if it's pure JsonObject
          adStudys.clear();
          adStudys.add(loadJSON(json, context));
          return adStudys;
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

  public APIRequestCreateObjective createObjective() {
    return new APIRequestCreateObjective(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public String getFieldCanceledTime() {
    return mCanceledTime;
  }

  public String getFieldCooldownStartTime() {
    return mCooldownStartTime;
  }

  public User getFieldCreatedBy() {
    if (mCreatedBy != null) {
      mCreatedBy.context = getContext();
    }
    return mCreatedBy;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldEndTime() {
    return mEndTime;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldObservationEndTime() {
    return mObservationEndTime;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public String getFieldType() {
    return mType;
  }

  public User getFieldUpdatedBy() {
    if (mUpdatedBy != null) {
      mUpdatedBy.context = getContext();
    }
    return mUpdatedBy;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }



  public static class APIRequestCreateObjective extends APIRequest<AdStudyObjective> {

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

    public APIRequestCreateObjective(String nodeId, APIContext context) {
      super(context, nodeId, "/objectives", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateObjective setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateObjective setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateObjective setAdspixels (List<Object> adspixels) {
      this.setParam("adspixels", adspixels);
      return this;
    }
    public APIRequestCreateObjective setAdspixels (String adspixels) {
      this.setParam("adspixels", adspixels);
      return this;
    }

    public APIRequestCreateObjective setApplications (List<Object> applications) {
      this.setParam("applications", applications);
      return this;
    }
    public APIRequestCreateObjective setApplications (String applications) {
      this.setParam("applications", applications);
      return this;
    }

    public APIRequestCreateObjective setCustomconversions (List<Object> customconversions) {
      this.setParam("customconversions", customconversions);
      return this;
    }
    public APIRequestCreateObjective setCustomconversions (String customconversions) {
      this.setParam("customconversions", customconversions);
      return this;
    }

    public APIRequestCreateObjective setIsPrimary (Boolean isPrimary) {
      this.setParam("is_primary", isPrimary);
      return this;
    }
    public APIRequestCreateObjective setIsPrimary (String isPrimary) {
      this.setParam("is_primary", isPrimary);
      return this;
    }

    public APIRequestCreateObjective setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateObjective setOfflineConversionDataSets (List<Object> offlineConversionDataSets) {
      this.setParam("offline_conversion_data_sets", offlineConversionDataSets);
      return this;
    }
    public APIRequestCreateObjective setOfflineConversionDataSets (String offlineConversionDataSets) {
      this.setParam("offline_conversion_data_sets", offlineConversionDataSets);
      return this;
    }

    public APIRequestCreateObjective setOffsitepixels (List<Object> offsitepixels) {
      this.setParam("offsitepixels", offsitepixels);
      return this;
    }
    public APIRequestCreateObjective setOffsitepixels (String offsitepixels) {
      this.setParam("offsitepixels", offsitepixels);
      return this;
    }

    public APIRequestCreateObjective setType (AdStudyObjective.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestCreateObjective setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestCreateObjective requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateObjective requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateObjective requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateObjective requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateObjective requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateObjective requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<AdStudy> {

    AdStudy lastResponse = null;
    @Override
    public AdStudy getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "canceled_time",
      "cooldown_start_time",
      "created_by",
      "created_time",
      "description",
      "end_time",
      "id",
      "name",
      "observation_end_time",
      "start_time",
      "type",
      "updated_by",
      "updated_time",
    };

    @Override
    public AdStudy parseResponse(String response) throws APIException {
      return AdStudy.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdStudy execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudy execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

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

    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestCanceledTimeField () {
      return this.requestCanceledTimeField(true);
    }
    public APIRequestGet requestCanceledTimeField (boolean value) {
      this.requestField("canceled_time", value);
      return this;
    }
    public APIRequestGet requestCooldownStartTimeField () {
      return this.requestCooldownStartTimeField(true);
    }
    public APIRequestGet requestCooldownStartTimeField (boolean value) {
      this.requestField("cooldown_start_time", value);
      return this;
    }
    public APIRequestGet requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGet requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
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
    public APIRequestGet requestObservationEndTimeField () {
      return this.requestObservationEndTimeField(true);
    }
    public APIRequestGet requestObservationEndTimeField (boolean value) {
      this.requestField("observation_end_time", value);
      return this;
    }
    public APIRequestGet requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGet requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGet requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGet requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGet requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGet requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static enum EnumType {
      @SerializedName("LIFT")
      VALUE_LIFT("LIFT"),
      @SerializedName("SPLIT_TEST")
      VALUE_SPLIT_TEST("SPLIT_TEST"),
      NULL(null);

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

  public AdStudy copyFrom(AdStudy instance) {
    this.mBusiness = instance.mBusiness;
    this.mCanceledTime = instance.mCanceledTime;
    this.mCooldownStartTime = instance.mCooldownStartTime;
    this.mCreatedBy = instance.mCreatedBy;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDescription = instance.mDescription;
    this.mEndTime = instance.mEndTime;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mObservationEndTime = instance.mObservationEndTime;
    this.mStartTime = instance.mStartTime;
    this.mType = instance.mType;
    this.mUpdatedBy = instance.mUpdatedBy;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdStudy> getParser() {
    return new APIRequest.ResponseParser<AdStudy>() {
      public APINodeList<AdStudy> parseResponse(String response, APIContext context, APIRequest<AdStudy> request) throws MalformedResponseException {
        return AdStudy.parseResponse(response, context, request);
      }
    };
  }
}
