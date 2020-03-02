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
public class MeasurementUploadEvent extends APINode {
  @SerializedName("aggregation_level")
  private String mAggregationLevel = null;
  @SerializedName("conversion_end_date")
  private String mConversionEndDate = null;
  @SerializedName("conversion_start_date")
  private String mConversionStartDate = null;
  @SerializedName("event_status")
  private String mEventStatus = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("lookback_window")
  private String mLookbackWindow = null;
  @SerializedName("match_universe")
  private String mMatchUniverse = null;
  @SerializedName("partner")
  private Business mPartner = null;
  @SerializedName("timezone")
  private String mTimezone = null;
  @SerializedName("upload_tag")
  private String mUploadTag = null;
  protected static Gson gson = null;

  MeasurementUploadEvent() {
  }

  public MeasurementUploadEvent(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public MeasurementUploadEvent(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public MeasurementUploadEvent fetch() throws APIException{
    MeasurementUploadEvent newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static MeasurementUploadEvent fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<MeasurementUploadEvent> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static MeasurementUploadEvent fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<MeasurementUploadEvent> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<MeasurementUploadEvent> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<MeasurementUploadEvent>)(
      new APIRequest<MeasurementUploadEvent>(context, "", "/", "GET", MeasurementUploadEvent.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<MeasurementUploadEvent>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", MeasurementUploadEvent.getParser())
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
  public static MeasurementUploadEvent loadJSON(String json, APIContext context, String header) {
    MeasurementUploadEvent measurementUploadEvent = getGson().fromJson(json, MeasurementUploadEvent.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(measurementUploadEvent.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    measurementUploadEvent.context = context;
    measurementUploadEvent.rawValue = json;
    measurementUploadEvent.header = header;
    return measurementUploadEvent;
  }

  public static APINodeList<MeasurementUploadEvent> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<MeasurementUploadEvent> measurementUploadEvents = new APINodeList<MeasurementUploadEvent>(request, json, header);
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
          measurementUploadEvents.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return measurementUploadEvents;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                measurementUploadEvents.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            measurementUploadEvents.setPaging(previous, next);
            if (context.hasAppSecret()) {
              measurementUploadEvents.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              measurementUploadEvents.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  measurementUploadEvents.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              measurementUploadEvents.add(loadJSON(obj.toString(), context, header));
            }
          }
          return measurementUploadEvents;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              measurementUploadEvents.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return measurementUploadEvents;
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
              measurementUploadEvents.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return measurementUploadEvents;
          }

          // Sixth, check if it's pure JsonObject
          measurementUploadEvents.clear();
          measurementUploadEvents.add(loadJSON(json, context, header));
          return measurementUploadEvents;
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


  public String getFieldAggregationLevel() {
    return mAggregationLevel;
  }

  public String getFieldConversionEndDate() {
    return mConversionEndDate;
  }

  public String getFieldConversionStartDate() {
    return mConversionStartDate;
  }

  public String getFieldEventStatus() {
    return mEventStatus;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldLookbackWindow() {
    return mLookbackWindow;
  }

  public String getFieldMatchUniverse() {
    return mMatchUniverse;
  }

  public Business getFieldPartner() {
    if (mPartner != null) {
      mPartner.context = getContext();
    }
    return mPartner;
  }

  public String getFieldTimezone() {
    return mTimezone;
  }

  public String getFieldUploadTag() {
    return mUploadTag;
  }



  public static class APIRequestGet extends APIRequest<MeasurementUploadEvent> {

    MeasurementUploadEvent lastResponse = null;
    @Override
    public MeasurementUploadEvent getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "aggregation_level",
      "conversion_end_date",
      "conversion_start_date",
      "event_status",
      "id",
      "lookback_window",
      "match_universe",
      "partner",
      "timezone",
      "upload_tag",
    };

    @Override
    public MeasurementUploadEvent parseResponse(String response, String header) throws APIException {
      return MeasurementUploadEvent.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public MeasurementUploadEvent execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MeasurementUploadEvent execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<MeasurementUploadEvent> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MeasurementUploadEvent> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, MeasurementUploadEvent>() {
           public MeasurementUploadEvent apply(ResponseWrapper result) {
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

    public APIRequestGet requestAggregationLevelField () {
      return this.requestAggregationLevelField(true);
    }
    public APIRequestGet requestAggregationLevelField (boolean value) {
      this.requestField("aggregation_level", value);
      return this;
    }
    public APIRequestGet requestConversionEndDateField () {
      return this.requestConversionEndDateField(true);
    }
    public APIRequestGet requestConversionEndDateField (boolean value) {
      this.requestField("conversion_end_date", value);
      return this;
    }
    public APIRequestGet requestConversionStartDateField () {
      return this.requestConversionStartDateField(true);
    }
    public APIRequestGet requestConversionStartDateField (boolean value) {
      this.requestField("conversion_start_date", value);
      return this;
    }
    public APIRequestGet requestEventStatusField () {
      return this.requestEventStatusField(true);
    }
    public APIRequestGet requestEventStatusField (boolean value) {
      this.requestField("event_status", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLookbackWindowField () {
      return this.requestLookbackWindowField(true);
    }
    public APIRequestGet requestLookbackWindowField (boolean value) {
      this.requestField("lookback_window", value);
      return this;
    }
    public APIRequestGet requestMatchUniverseField () {
      return this.requestMatchUniverseField(true);
    }
    public APIRequestGet requestMatchUniverseField (boolean value) {
      this.requestField("match_universe", value);
      return this;
    }
    public APIRequestGet requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGet requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGet requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGet requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGet requestUploadTagField () {
      return this.requestUploadTagField(true);
    }
    public APIRequestGet requestUploadTagField (boolean value) {
      this.requestField("upload_tag", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<MeasurementUploadEvent> {

    MeasurementUploadEvent lastResponse = null;
    @Override
    public MeasurementUploadEvent getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "aggregation_level",
      "conversion_end_date",
      "conversion_start_date",
      "event_status",
      "lookback_window",
      "match_universe",
      "partner",
      "timezone",
      "upload_tag",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public MeasurementUploadEvent parseResponse(String response, String header) throws APIException {
      return MeasurementUploadEvent.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public MeasurementUploadEvent execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MeasurementUploadEvent execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<MeasurementUploadEvent> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MeasurementUploadEvent> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, MeasurementUploadEvent>() {
           public MeasurementUploadEvent apply(ResponseWrapper result) {
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


    public APIRequestUpdate setAggregationLevel (MeasurementUploadEvent.EnumAggregationLevel aggregationLevel) {
      this.setParam("aggregation_level", aggregationLevel);
      return this;
    }
    public APIRequestUpdate setAggregationLevel (String aggregationLevel) {
      this.setParam("aggregation_level", aggregationLevel);
      return this;
    }

    public APIRequestUpdate setConversionEndDate (String conversionEndDate) {
      this.setParam("conversion_end_date", conversionEndDate);
      return this;
    }

    public APIRequestUpdate setConversionStartDate (String conversionStartDate) {
      this.setParam("conversion_start_date", conversionStartDate);
      return this;
    }

    public APIRequestUpdate setEventStatus (MeasurementUploadEvent.EnumEventStatus eventStatus) {
      this.setParam("event_status", eventStatus);
      return this;
    }
    public APIRequestUpdate setEventStatus (String eventStatus) {
      this.setParam("event_status", eventStatus);
      return this;
    }

    public APIRequestUpdate setLookbackWindow (MeasurementUploadEvent.EnumLookbackWindow lookbackWindow) {
      this.setParam("lookback_window", lookbackWindow);
      return this;
    }
    public APIRequestUpdate setLookbackWindow (String lookbackWindow) {
      this.setParam("lookback_window", lookbackWindow);
      return this;
    }

    public APIRequestUpdate setMatchUniverse (MeasurementUploadEvent.EnumMatchUniverse matchUniverse) {
      this.setParam("match_universe", matchUniverse);
      return this;
    }
    public APIRequestUpdate setMatchUniverse (String matchUniverse) {
      this.setParam("match_universe", matchUniverse);
      return this;
    }

    public APIRequestUpdate setPartner (String partner) {
      this.setParam("partner", partner);
      return this;
    }

    public APIRequestUpdate setTimezone (MeasurementUploadEvent.EnumTimezone timezone) {
      this.setParam("timezone", timezone);
      return this;
    }
    public APIRequestUpdate setTimezone (String timezone) {
      this.setParam("timezone", timezone);
      return this;
    }

    public APIRequestUpdate setUploadTag (String uploadTag) {
      this.setParam("upload_tag", uploadTag);
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

  public static enum EnumAggregationLevel {
      @SerializedName("DAILY")
      VALUE_DAILY("DAILY"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("WEEKLY")
      VALUE_WEEKLY("WEEKLY"),
      ;

      private String value;

      private EnumAggregationLevel(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumEventStatus {
      @SerializedName("CANCELCOMPLETED")
      VALUE_CANCELCOMPLETED("CANCELCOMPLETED"),
      @SerializedName("CANCELED")
      VALUE_CANCELED("CANCELED"),
      @SerializedName("COMPLETED")
      VALUE_COMPLETED("COMPLETED"),
      @SerializedName("FAILED")
      VALUE_FAILED("FAILED"),
      @SerializedName("STARTED")
      VALUE_STARTED("STARTED"),
      @SerializedName("UPLOADED")
      VALUE_UPLOADED("UPLOADED"),
      ;

      private String value;

      private EnumEventStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumLookbackWindow {
      @SerializedName("DAYS30")
      VALUE_DAYS30("DAYS30"),
      @SerializedName("DAYS45")
      VALUE_DAYS45("DAYS45"),
      @SerializedName("DAYS60")
      VALUE_DAYS60("DAYS60"),
      @SerializedName("DAYS90")
      VALUE_DAYS90("DAYS90"),
      ;

      private String value;

      private EnumLookbackWindow(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMatchUniverse {
      @SerializedName("FULL")
      VALUE_FULL("FULL"),
      @SerializedName("PII")
      VALUE_PII("PII"),
      @SerializedName("PIXEL")
      VALUE_PIXEL("PIXEL"),
      ;

      private String value;

      private EnumMatchUniverse(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumTimezone {
      @SerializedName("TZ_AFRICA_ACCRA")
      VALUE_TZ_AFRICA_ACCRA("TZ_AFRICA_ACCRA"),
      @SerializedName("TZ_AFRICA_CAIRO")
      VALUE_TZ_AFRICA_CAIRO("TZ_AFRICA_CAIRO"),
      @SerializedName("TZ_AFRICA_CASABLANCA")
      VALUE_TZ_AFRICA_CASABLANCA("TZ_AFRICA_CASABLANCA"),
      @SerializedName("TZ_AFRICA_JOHANNESBURG")
      VALUE_TZ_AFRICA_JOHANNESBURG("TZ_AFRICA_JOHANNESBURG"),
      @SerializedName("TZ_AFRICA_LAGOS")
      VALUE_TZ_AFRICA_LAGOS("TZ_AFRICA_LAGOS"),
      @SerializedName("TZ_AFRICA_NAIROBI")
      VALUE_TZ_AFRICA_NAIROBI("TZ_AFRICA_NAIROBI"),
      @SerializedName("TZ_AFRICA_TUNIS")
      VALUE_TZ_AFRICA_TUNIS("TZ_AFRICA_TUNIS"),
      @SerializedName("TZ_AMERICA_ANCHORAGE")
      VALUE_TZ_AMERICA_ANCHORAGE("TZ_AMERICA_ANCHORAGE"),
      @SerializedName("TZ_AMERICA_ARGENTINA_BUENOS_AIRES")
      VALUE_TZ_AMERICA_ARGENTINA_BUENOS_AIRES("TZ_AMERICA_ARGENTINA_BUENOS_AIRES"),
      @SerializedName("TZ_AMERICA_ARGENTINA_SALTA")
      VALUE_TZ_AMERICA_ARGENTINA_SALTA("TZ_AMERICA_ARGENTINA_SALTA"),
      @SerializedName("TZ_AMERICA_ARGENTINA_SAN_LUIS")
      VALUE_TZ_AMERICA_ARGENTINA_SAN_LUIS("TZ_AMERICA_ARGENTINA_SAN_LUIS"),
      @SerializedName("TZ_AMERICA_ASUNCION")
      VALUE_TZ_AMERICA_ASUNCION("TZ_AMERICA_ASUNCION"),
      @SerializedName("TZ_AMERICA_ATIKOKAN")
      VALUE_TZ_AMERICA_ATIKOKAN("TZ_AMERICA_ATIKOKAN"),
      @SerializedName("TZ_AMERICA_BELEM")
      VALUE_TZ_AMERICA_BELEM("TZ_AMERICA_BELEM"),
      @SerializedName("TZ_AMERICA_BLANC_SABLON")
      VALUE_TZ_AMERICA_BLANC_SABLON("TZ_AMERICA_BLANC_SABLON"),
      @SerializedName("TZ_AMERICA_BOGOTA")
      VALUE_TZ_AMERICA_BOGOTA("TZ_AMERICA_BOGOTA"),
      @SerializedName("TZ_AMERICA_CAMPO_GRANDE")
      VALUE_TZ_AMERICA_CAMPO_GRANDE("TZ_AMERICA_CAMPO_GRANDE"),
      @SerializedName("TZ_AMERICA_CARACAS")
      VALUE_TZ_AMERICA_CARACAS("TZ_AMERICA_CARACAS"),
      @SerializedName("TZ_AMERICA_CHICAGO")
      VALUE_TZ_AMERICA_CHICAGO("TZ_AMERICA_CHICAGO"),
      @SerializedName("TZ_AMERICA_COSTA_RICA")
      VALUE_TZ_AMERICA_COSTA_RICA("TZ_AMERICA_COSTA_RICA"),
      @SerializedName("TZ_AMERICA_DAWSON")
      VALUE_TZ_AMERICA_DAWSON("TZ_AMERICA_DAWSON"),
      @SerializedName("TZ_AMERICA_DAWSON_CREEK")
      VALUE_TZ_AMERICA_DAWSON_CREEK("TZ_AMERICA_DAWSON_CREEK"),
      @SerializedName("TZ_AMERICA_DENVER")
      VALUE_TZ_AMERICA_DENVER("TZ_AMERICA_DENVER"),
      @SerializedName("TZ_AMERICA_DETROIT")
      VALUE_TZ_AMERICA_DETROIT("TZ_AMERICA_DETROIT"),
      @SerializedName("TZ_AMERICA_EDMONTON")
      VALUE_TZ_AMERICA_EDMONTON("TZ_AMERICA_EDMONTON"),
      @SerializedName("TZ_AMERICA_EL_SALVADOR")
      VALUE_TZ_AMERICA_EL_SALVADOR("TZ_AMERICA_EL_SALVADOR"),
      @SerializedName("TZ_AMERICA_GUATEMALA")
      VALUE_TZ_AMERICA_GUATEMALA("TZ_AMERICA_GUATEMALA"),
      @SerializedName("TZ_AMERICA_GUAYAQUIL")
      VALUE_TZ_AMERICA_GUAYAQUIL("TZ_AMERICA_GUAYAQUIL"),
      @SerializedName("TZ_AMERICA_HALIFAX")
      VALUE_TZ_AMERICA_HALIFAX("TZ_AMERICA_HALIFAX"),
      @SerializedName("TZ_AMERICA_HERMOSILLO")
      VALUE_TZ_AMERICA_HERMOSILLO("TZ_AMERICA_HERMOSILLO"),
      @SerializedName("TZ_AMERICA_IQALUIT")
      VALUE_TZ_AMERICA_IQALUIT("TZ_AMERICA_IQALUIT"),
      @SerializedName("TZ_AMERICA_JAMAICA")
      VALUE_TZ_AMERICA_JAMAICA("TZ_AMERICA_JAMAICA"),
      @SerializedName("TZ_AMERICA_LA_PAZ")
      VALUE_TZ_AMERICA_LA_PAZ("TZ_AMERICA_LA_PAZ"),
      @SerializedName("TZ_AMERICA_LIMA")
      VALUE_TZ_AMERICA_LIMA("TZ_AMERICA_LIMA"),
      @SerializedName("TZ_AMERICA_LOS_ANGELES")
      VALUE_TZ_AMERICA_LOS_ANGELES("TZ_AMERICA_LOS_ANGELES"),
      @SerializedName("TZ_AMERICA_MANAGUA")
      VALUE_TZ_AMERICA_MANAGUA("TZ_AMERICA_MANAGUA"),
      @SerializedName("TZ_AMERICA_MAZATLAN")
      VALUE_TZ_AMERICA_MAZATLAN("TZ_AMERICA_MAZATLAN"),
      @SerializedName("TZ_AMERICA_MEXICO_CITY")
      VALUE_TZ_AMERICA_MEXICO_CITY("TZ_AMERICA_MEXICO_CITY"),
      @SerializedName("TZ_AMERICA_MONTEVIDEO")
      VALUE_TZ_AMERICA_MONTEVIDEO("TZ_AMERICA_MONTEVIDEO"),
      @SerializedName("TZ_AMERICA_NASSAU")
      VALUE_TZ_AMERICA_NASSAU("TZ_AMERICA_NASSAU"),
      @SerializedName("TZ_AMERICA_NEW_YORK")
      VALUE_TZ_AMERICA_NEW_YORK("TZ_AMERICA_NEW_YORK"),
      @SerializedName("TZ_AMERICA_NORONHA")
      VALUE_TZ_AMERICA_NORONHA("TZ_AMERICA_NORONHA"),
      @SerializedName("TZ_AMERICA_PANAMA")
      VALUE_TZ_AMERICA_PANAMA("TZ_AMERICA_PANAMA"),
      @SerializedName("TZ_AMERICA_PHOENIX")
      VALUE_TZ_AMERICA_PHOENIX("TZ_AMERICA_PHOENIX"),
      @SerializedName("TZ_AMERICA_PORT_OF_SPAIN")
      VALUE_TZ_AMERICA_PORT_OF_SPAIN("TZ_AMERICA_PORT_OF_SPAIN"),
      @SerializedName("TZ_AMERICA_PUERTO_RICO")
      VALUE_TZ_AMERICA_PUERTO_RICO("TZ_AMERICA_PUERTO_RICO"),
      @SerializedName("TZ_AMERICA_RAINY_RIVER")
      VALUE_TZ_AMERICA_RAINY_RIVER("TZ_AMERICA_RAINY_RIVER"),
      @SerializedName("TZ_AMERICA_REGINA")
      VALUE_TZ_AMERICA_REGINA("TZ_AMERICA_REGINA"),
      @SerializedName("TZ_AMERICA_SANTIAGO")
      VALUE_TZ_AMERICA_SANTIAGO("TZ_AMERICA_SANTIAGO"),
      @SerializedName("TZ_AMERICA_SANTO_DOMINGO")
      VALUE_TZ_AMERICA_SANTO_DOMINGO("TZ_AMERICA_SANTO_DOMINGO"),
      @SerializedName("TZ_AMERICA_SAO_PAULO")
      VALUE_TZ_AMERICA_SAO_PAULO("TZ_AMERICA_SAO_PAULO"),
      @SerializedName("TZ_AMERICA_ST_JOHNS")
      VALUE_TZ_AMERICA_ST_JOHNS("TZ_AMERICA_ST_JOHNS"),
      @SerializedName("TZ_AMERICA_TEGUCIGALPA")
      VALUE_TZ_AMERICA_TEGUCIGALPA("TZ_AMERICA_TEGUCIGALPA"),
      @SerializedName("TZ_AMERICA_TIJUANA")
      VALUE_TZ_AMERICA_TIJUANA("TZ_AMERICA_TIJUANA"),
      @SerializedName("TZ_AMERICA_TORONTO")
      VALUE_TZ_AMERICA_TORONTO("TZ_AMERICA_TORONTO"),
      @SerializedName("TZ_AMERICA_VANCOUVER")
      VALUE_TZ_AMERICA_VANCOUVER("TZ_AMERICA_VANCOUVER"),
      @SerializedName("TZ_AMERICA_WINNIPEG")
      VALUE_TZ_AMERICA_WINNIPEG("TZ_AMERICA_WINNIPEG"),
      @SerializedName("TZ_ASIA_AMMAN")
      VALUE_TZ_ASIA_AMMAN("TZ_ASIA_AMMAN"),
      @SerializedName("TZ_ASIA_BAGHDAD")
      VALUE_TZ_ASIA_BAGHDAD("TZ_ASIA_BAGHDAD"),
      @SerializedName("TZ_ASIA_BAHRAIN")
      VALUE_TZ_ASIA_BAHRAIN("TZ_ASIA_BAHRAIN"),
      @SerializedName("TZ_ASIA_BANGKOK")
      VALUE_TZ_ASIA_BANGKOK("TZ_ASIA_BANGKOK"),
      @SerializedName("TZ_ASIA_BEIRUT")
      VALUE_TZ_ASIA_BEIRUT("TZ_ASIA_BEIRUT"),
      @SerializedName("TZ_ASIA_COLOMBO")
      VALUE_TZ_ASIA_COLOMBO("TZ_ASIA_COLOMBO"),
      @SerializedName("TZ_ASIA_DHAKA")
      VALUE_TZ_ASIA_DHAKA("TZ_ASIA_DHAKA"),
      @SerializedName("TZ_ASIA_DUBAI")
      VALUE_TZ_ASIA_DUBAI("TZ_ASIA_DUBAI"),
      @SerializedName("TZ_ASIA_GAZA")
      VALUE_TZ_ASIA_GAZA("TZ_ASIA_GAZA"),
      @SerializedName("TZ_ASIA_HONG_KONG")
      VALUE_TZ_ASIA_HONG_KONG("TZ_ASIA_HONG_KONG"),
      @SerializedName("TZ_ASIA_HO_CHI_MINH")
      VALUE_TZ_ASIA_HO_CHI_MINH("TZ_ASIA_HO_CHI_MINH"),
      @SerializedName("TZ_ASIA_IRKUTSK")
      VALUE_TZ_ASIA_IRKUTSK("TZ_ASIA_IRKUTSK"),
      @SerializedName("TZ_ASIA_JAKARTA")
      VALUE_TZ_ASIA_JAKARTA("TZ_ASIA_JAKARTA"),
      @SerializedName("TZ_ASIA_JAYAPURA")
      VALUE_TZ_ASIA_JAYAPURA("TZ_ASIA_JAYAPURA"),
      @SerializedName("TZ_ASIA_JERUSALEM")
      VALUE_TZ_ASIA_JERUSALEM("TZ_ASIA_JERUSALEM"),
      @SerializedName("TZ_ASIA_KAMCHATKA")
      VALUE_TZ_ASIA_KAMCHATKA("TZ_ASIA_KAMCHATKA"),
      @SerializedName("TZ_ASIA_KARACHI")
      VALUE_TZ_ASIA_KARACHI("TZ_ASIA_KARACHI"),
      @SerializedName("TZ_ASIA_KATHMANDU")
      VALUE_TZ_ASIA_KATHMANDU("TZ_ASIA_KATHMANDU"),
      @SerializedName("TZ_ASIA_KOLKATA")
      VALUE_TZ_ASIA_KOLKATA("TZ_ASIA_KOLKATA"),
      @SerializedName("TZ_ASIA_KRASNOYARSK")
      VALUE_TZ_ASIA_KRASNOYARSK("TZ_ASIA_KRASNOYARSK"),
      @SerializedName("TZ_ASIA_KUALA_LUMPUR")
      VALUE_TZ_ASIA_KUALA_LUMPUR("TZ_ASIA_KUALA_LUMPUR"),
      @SerializedName("TZ_ASIA_KUWAIT")
      VALUE_TZ_ASIA_KUWAIT("TZ_ASIA_KUWAIT"),
      @SerializedName("TZ_ASIA_MAGADAN")
      VALUE_TZ_ASIA_MAGADAN("TZ_ASIA_MAGADAN"),
      @SerializedName("TZ_ASIA_MAKASSAR")
      VALUE_TZ_ASIA_MAKASSAR("TZ_ASIA_MAKASSAR"),
      @SerializedName("TZ_ASIA_MANILA")
      VALUE_TZ_ASIA_MANILA("TZ_ASIA_MANILA"),
      @SerializedName("TZ_ASIA_MUSCAT")
      VALUE_TZ_ASIA_MUSCAT("TZ_ASIA_MUSCAT"),
      @SerializedName("TZ_ASIA_NICOSIA")
      VALUE_TZ_ASIA_NICOSIA("TZ_ASIA_NICOSIA"),
      @SerializedName("TZ_ASIA_OMSK")
      VALUE_TZ_ASIA_OMSK("TZ_ASIA_OMSK"),
      @SerializedName("TZ_ASIA_QATAR")
      VALUE_TZ_ASIA_QATAR("TZ_ASIA_QATAR"),
      @SerializedName("TZ_ASIA_RIYADH")
      VALUE_TZ_ASIA_RIYADH("TZ_ASIA_RIYADH"),
      @SerializedName("TZ_ASIA_SEOUL")
      VALUE_TZ_ASIA_SEOUL("TZ_ASIA_SEOUL"),
      @SerializedName("TZ_ASIA_SHANGHAI")
      VALUE_TZ_ASIA_SHANGHAI("TZ_ASIA_SHANGHAI"),
      @SerializedName("TZ_ASIA_SINGAPORE")
      VALUE_TZ_ASIA_SINGAPORE("TZ_ASIA_SINGAPORE"),
      @SerializedName("TZ_ASIA_TAIPEI")
      VALUE_TZ_ASIA_TAIPEI("TZ_ASIA_TAIPEI"),
      @SerializedName("TZ_ASIA_TOKYO")
      VALUE_TZ_ASIA_TOKYO("TZ_ASIA_TOKYO"),
      @SerializedName("TZ_ASIA_VLADIVOSTOK")
      VALUE_TZ_ASIA_VLADIVOSTOK("TZ_ASIA_VLADIVOSTOK"),
      @SerializedName("TZ_ASIA_YAKUTSK")
      VALUE_TZ_ASIA_YAKUTSK("TZ_ASIA_YAKUTSK"),
      @SerializedName("TZ_ASIA_YEKATERINBURG")
      VALUE_TZ_ASIA_YEKATERINBURG("TZ_ASIA_YEKATERINBURG"),
      @SerializedName("TZ_ATLANTIC_AZORES")
      VALUE_TZ_ATLANTIC_AZORES("TZ_ATLANTIC_AZORES"),
      @SerializedName("TZ_ATLANTIC_CANARY")
      VALUE_TZ_ATLANTIC_CANARY("TZ_ATLANTIC_CANARY"),
      @SerializedName("TZ_ATLANTIC_REYKJAVIK")
      VALUE_TZ_ATLANTIC_REYKJAVIK("TZ_ATLANTIC_REYKJAVIK"),
      @SerializedName("TZ_AUSTRALIA_BROKEN_HILL")
      VALUE_TZ_AUSTRALIA_BROKEN_HILL("TZ_AUSTRALIA_BROKEN_HILL"),
      @SerializedName("TZ_AUSTRALIA_MELBOURNE")
      VALUE_TZ_AUSTRALIA_MELBOURNE("TZ_AUSTRALIA_MELBOURNE"),
      @SerializedName("TZ_AUSTRALIA_PERTH")
      VALUE_TZ_AUSTRALIA_PERTH("TZ_AUSTRALIA_PERTH"),
      @SerializedName("TZ_AUSTRALIA_SYDNEY")
      VALUE_TZ_AUSTRALIA_SYDNEY("TZ_AUSTRALIA_SYDNEY"),
      @SerializedName("TZ_EUROPE_AMSTERDAM")
      VALUE_TZ_EUROPE_AMSTERDAM("TZ_EUROPE_AMSTERDAM"),
      @SerializedName("TZ_EUROPE_ATHENS")
      VALUE_TZ_EUROPE_ATHENS("TZ_EUROPE_ATHENS"),
      @SerializedName("TZ_EUROPE_BELGRADE")
      VALUE_TZ_EUROPE_BELGRADE("TZ_EUROPE_BELGRADE"),
      @SerializedName("TZ_EUROPE_BERLIN")
      VALUE_TZ_EUROPE_BERLIN("TZ_EUROPE_BERLIN"),
      @SerializedName("TZ_EUROPE_BRATISLAVA")
      VALUE_TZ_EUROPE_BRATISLAVA("TZ_EUROPE_BRATISLAVA"),
      @SerializedName("TZ_EUROPE_BRUSSELS")
      VALUE_TZ_EUROPE_BRUSSELS("TZ_EUROPE_BRUSSELS"),
      @SerializedName("TZ_EUROPE_BUCHAREST")
      VALUE_TZ_EUROPE_BUCHAREST("TZ_EUROPE_BUCHAREST"),
      @SerializedName("TZ_EUROPE_BUDAPEST")
      VALUE_TZ_EUROPE_BUDAPEST("TZ_EUROPE_BUDAPEST"),
      @SerializedName("TZ_EUROPE_COPENHAGEN")
      VALUE_TZ_EUROPE_COPENHAGEN("TZ_EUROPE_COPENHAGEN"),
      @SerializedName("TZ_EUROPE_DUBLIN")
      VALUE_TZ_EUROPE_DUBLIN("TZ_EUROPE_DUBLIN"),
      @SerializedName("TZ_EUROPE_HELSINKI")
      VALUE_TZ_EUROPE_HELSINKI("TZ_EUROPE_HELSINKI"),
      @SerializedName("TZ_EUROPE_ISTANBUL")
      VALUE_TZ_EUROPE_ISTANBUL("TZ_EUROPE_ISTANBUL"),
      @SerializedName("TZ_EUROPE_KALININGRAD")
      VALUE_TZ_EUROPE_KALININGRAD("TZ_EUROPE_KALININGRAD"),
      @SerializedName("TZ_EUROPE_KIEV")
      VALUE_TZ_EUROPE_KIEV("TZ_EUROPE_KIEV"),
      @SerializedName("TZ_EUROPE_LISBON")
      VALUE_TZ_EUROPE_LISBON("TZ_EUROPE_LISBON"),
      @SerializedName("TZ_EUROPE_LJUBLJANA")
      VALUE_TZ_EUROPE_LJUBLJANA("TZ_EUROPE_LJUBLJANA"),
      @SerializedName("TZ_EUROPE_LONDON")
      VALUE_TZ_EUROPE_LONDON("TZ_EUROPE_LONDON"),
      @SerializedName("TZ_EUROPE_LUXEMBOURG")
      VALUE_TZ_EUROPE_LUXEMBOURG("TZ_EUROPE_LUXEMBOURG"),
      @SerializedName("TZ_EUROPE_MADRID")
      VALUE_TZ_EUROPE_MADRID("TZ_EUROPE_MADRID"),
      @SerializedName("TZ_EUROPE_MALTA")
      VALUE_TZ_EUROPE_MALTA("TZ_EUROPE_MALTA"),
      @SerializedName("TZ_EUROPE_MOSCOW")
      VALUE_TZ_EUROPE_MOSCOW("TZ_EUROPE_MOSCOW"),
      @SerializedName("TZ_EUROPE_OSLO")
      VALUE_TZ_EUROPE_OSLO("TZ_EUROPE_OSLO"),
      @SerializedName("TZ_EUROPE_PARIS")
      VALUE_TZ_EUROPE_PARIS("TZ_EUROPE_PARIS"),
      @SerializedName("TZ_EUROPE_PRAGUE")
      VALUE_TZ_EUROPE_PRAGUE("TZ_EUROPE_PRAGUE"),
      @SerializedName("TZ_EUROPE_RIGA")
      VALUE_TZ_EUROPE_RIGA("TZ_EUROPE_RIGA"),
      @SerializedName("TZ_EUROPE_ROME")
      VALUE_TZ_EUROPE_ROME("TZ_EUROPE_ROME"),
      @SerializedName("TZ_EUROPE_SAMARA")
      VALUE_TZ_EUROPE_SAMARA("TZ_EUROPE_SAMARA"),
      @SerializedName("TZ_EUROPE_SARAJEVO")
      VALUE_TZ_EUROPE_SARAJEVO("TZ_EUROPE_SARAJEVO"),
      @SerializedName("TZ_EUROPE_SKOPJE")
      VALUE_TZ_EUROPE_SKOPJE("TZ_EUROPE_SKOPJE"),
      @SerializedName("TZ_EUROPE_SOFIA")
      VALUE_TZ_EUROPE_SOFIA("TZ_EUROPE_SOFIA"),
      @SerializedName("TZ_EUROPE_STOCKHOLM")
      VALUE_TZ_EUROPE_STOCKHOLM("TZ_EUROPE_STOCKHOLM"),
      @SerializedName("TZ_EUROPE_TALLINN")
      VALUE_TZ_EUROPE_TALLINN("TZ_EUROPE_TALLINN"),
      @SerializedName("TZ_EUROPE_VIENNA")
      VALUE_TZ_EUROPE_VIENNA("TZ_EUROPE_VIENNA"),
      @SerializedName("TZ_EUROPE_VILNIUS")
      VALUE_TZ_EUROPE_VILNIUS("TZ_EUROPE_VILNIUS"),
      @SerializedName("TZ_EUROPE_WARSAW")
      VALUE_TZ_EUROPE_WARSAW("TZ_EUROPE_WARSAW"),
      @SerializedName("TZ_EUROPE_ZAGREB")
      VALUE_TZ_EUROPE_ZAGREB("TZ_EUROPE_ZAGREB"),
      @SerializedName("TZ_EUROPE_ZURICH")
      VALUE_TZ_EUROPE_ZURICH("TZ_EUROPE_ZURICH"),
      @SerializedName("TZ_INDIAN_MALDIVES")
      VALUE_TZ_INDIAN_MALDIVES("TZ_INDIAN_MALDIVES"),
      @SerializedName("TZ_INDIAN_MAURITIUS")
      VALUE_TZ_INDIAN_MAURITIUS("TZ_INDIAN_MAURITIUS"),
      @SerializedName("TZ_NUM_TIMEZONES")
      VALUE_TZ_NUM_TIMEZONES("TZ_NUM_TIMEZONES"),
      @SerializedName("TZ_PACIFIC_AUCKLAND")
      VALUE_TZ_PACIFIC_AUCKLAND("TZ_PACIFIC_AUCKLAND"),
      @SerializedName("TZ_PACIFIC_EASTER")
      VALUE_TZ_PACIFIC_EASTER("TZ_PACIFIC_EASTER"),
      @SerializedName("TZ_PACIFIC_GALAPAGOS")
      VALUE_TZ_PACIFIC_GALAPAGOS("TZ_PACIFIC_GALAPAGOS"),
      @SerializedName("TZ_PACIFIC_HONOLULU")
      VALUE_TZ_PACIFIC_HONOLULU("TZ_PACIFIC_HONOLULU"),
      ;

      private String value;

      private EnumTimezone(String value) {
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

  public MeasurementUploadEvent copyFrom(MeasurementUploadEvent instance) {
    this.mAggregationLevel = instance.mAggregationLevel;
    this.mConversionEndDate = instance.mConversionEndDate;
    this.mConversionStartDate = instance.mConversionStartDate;
    this.mEventStatus = instance.mEventStatus;
    this.mId = instance.mId;
    this.mLookbackWindow = instance.mLookbackWindow;
    this.mMatchUniverse = instance.mMatchUniverse;
    this.mPartner = instance.mPartner;
    this.mTimezone = instance.mTimezone;
    this.mUploadTag = instance.mUploadTag;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MeasurementUploadEvent> getParser() {
    return new APIRequest.ResponseParser<MeasurementUploadEvent>() {
      public APINodeList<MeasurementUploadEvent> parseResponse(String response, APIContext context, APIRequest<MeasurementUploadEvent> request, String header) throws MalformedResponseException {
        return MeasurementUploadEvent.parseResponse(response, context, request, header);
      }
    };
  }
}
