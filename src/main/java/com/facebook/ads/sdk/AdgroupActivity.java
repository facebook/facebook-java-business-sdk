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
public class AdgroupActivity extends APINode {
  @SerializedName("ad_creative_id_new")
  private AdCreative mAdCreativeIdNew = null;
  @SerializedName("ad_creative_id_old")
  private AdCreative mAdCreativeIdOld = null;
  @SerializedName("asset_feed_id_new")
  private String mAssetFeedIdNew = null;
  @SerializedName("asset_feed_id_old")
  private String mAssetFeedIdOld = null;
  @SerializedName("bid_amount_new")
  private Long mBidAmountNew = null;
  @SerializedName("bid_amount_old")
  private Long mBidAmountOld = null;
  @SerializedName("bid_info_new")
  private Map<String, Long> mBidInfoNew = null;
  @SerializedName("bid_info_old")
  private Map<String, Long> mBidInfoOld = null;
  @SerializedName("bid_type_new")
  private String mBidTypeNew = null;
  @SerializedName("bid_type_old")
  private String mBidTypeOld = null;
  @SerializedName("conversion_specs_new")
  private List<Object> mConversionSpecsNew = null;
  @SerializedName("conversion_specs_old")
  private List<Object> mConversionSpecsOld = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("display_sequence_new")
  private Long mDisplaySequenceNew = null;
  @SerializedName("display_sequence_old")
  private Long mDisplaySequenceOld = null;
  @SerializedName("engagement_audience_new")
  private Boolean mEngagementAudienceNew = null;
  @SerializedName("engagement_audience_old")
  private Boolean mEngagementAudienceOld = null;
  @SerializedName("event_time")
  private String mEventTime = null;
  @SerializedName("event_type")
  private String mEventType = null;
  @SerializedName("force_run_status_new")
  private Boolean mForceRunStatusNew = null;
  @SerializedName("force_run_status_old")
  private Boolean mForceRunStatusOld = null;
  @SerializedName("friendly_name_new")
  private String mFriendlyNameNew = null;
  @SerializedName("friendly_name_old")
  private String mFriendlyNameOld = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_reviewer_admin_new")
  private Boolean mIsReviewerAdminNew = null;
  @SerializedName("is_reviewer_admin_old")
  private Boolean mIsReviewerAdminOld = null;
  @SerializedName("objective_new")
  private EnumObjectiveNew mObjectiveNew = null;
  @SerializedName("objective_old")
  private EnumObjectiveOld mObjectiveOld = null;
  @SerializedName("objective_source_new")
  private String mObjectiveSourceNew = null;
  @SerializedName("objective_source_old")
  private String mObjectiveSourceOld = null;
  @SerializedName("priority_new")
  private Long mPriorityNew = null;
  @SerializedName("priority_old")
  private Long mPriorityOld = null;
  @SerializedName("reason_new")
  private String mReasonNew = null;
  @SerializedName("reason_old")
  private String mReasonOld = null;
  @SerializedName("run_status_new")
  private String mRunStatusNew = null;
  @SerializedName("run_status_old")
  private String mRunStatusOld = null;
  @SerializedName("source_adgroup_id_new")
  private Ad mSourceAdgroupIdNew = null;
  @SerializedName("source_adgroup_id_old")
  private Ad mSourceAdgroupIdOld = null;
  @SerializedName("start_time_new")
  private String mStartTimeNew = null;
  @SerializedName("start_time_old")
  private String mStartTimeOld = null;
  @SerializedName("stop_time_new")
  private String mStopTimeNew = null;
  @SerializedName("stop_time_old")
  private String mStopTimeOld = null;
  @SerializedName("target_spec_id_new")
  private String mTargetSpecIdNew = null;
  @SerializedName("target_spec_id_old")
  private String mTargetSpecIdOld = null;
  @SerializedName("tracking_pixel_ids_new")
  private List<String> mTrackingPixelIdsNew = null;
  @SerializedName("tracking_pixel_ids_old")
  private List<String> mTrackingPixelIdsOld = null;
  @SerializedName("tracking_specs_new")
  private List<Object> mTrackingSpecsNew = null;
  @SerializedName("tracking_specs_old")
  private List<Object> mTrackingSpecsOld = null;
  @SerializedName("update_time_new")
  private String mUpdateTimeNew = null;
  @SerializedName("update_time_old")
  private String mUpdateTimeOld = null;
  @SerializedName("view_tags_new")
  private List<String> mViewTagsNew = null;
  @SerializedName("view_tags_old")
  private List<String> mViewTagsOld = null;
  protected static Gson gson = null;

  AdgroupActivity() {
  }

  public AdgroupActivity(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdgroupActivity(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdgroupActivity fetch() throws APIException{
    AdgroupActivity newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdgroupActivity fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdgroupActivity> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdgroupActivity fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdgroupActivity> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdgroupActivity> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdgroupActivity>)(
      new APIRequest<AdgroupActivity>(context, "", "/", "GET", AdgroupActivity.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdgroupActivity>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdgroupActivity.getParser())
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
  public static AdgroupActivity loadJSON(String json, APIContext context, String header) {
    AdgroupActivity adgroupActivity = getGson().fromJson(json, AdgroupActivity.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adgroupActivity.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adgroupActivity.context = context;
    adgroupActivity.rawValue = json;
    adgroupActivity.header = header;
    return adgroupActivity;
  }

  public static APINodeList<AdgroupActivity> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdgroupActivity> adgroupActivitys = new APINodeList<AdgroupActivity>(request, json, header);
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
          adgroupActivitys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adgroupActivitys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adgroupActivitys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adgroupActivitys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adgroupActivitys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adgroupActivitys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adgroupActivitys.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adgroupActivitys.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adgroupActivitys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adgroupActivitys.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adgroupActivitys;
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
              adgroupActivitys.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adgroupActivitys;
          }

          // Sixth, check if it's pure JsonObject
          adgroupActivitys.clear();
          adgroupActivitys.add(loadJSON(json, context, header));
          return adgroupActivitys;
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


  public AdCreative getFieldAdCreativeIdNew() {
    if (mAdCreativeIdNew != null) {
      mAdCreativeIdNew.context = getContext();
    }
    return mAdCreativeIdNew;
  }

  public AdCreative getFieldAdCreativeIdOld() {
    if (mAdCreativeIdOld != null) {
      mAdCreativeIdOld.context = getContext();
    }
    return mAdCreativeIdOld;
  }

  public String getFieldAssetFeedIdNew() {
    return mAssetFeedIdNew;
  }

  public String getFieldAssetFeedIdOld() {
    return mAssetFeedIdOld;
  }

  public Long getFieldBidAmountNew() {
    return mBidAmountNew;
  }

  public Long getFieldBidAmountOld() {
    return mBidAmountOld;
  }

  public Map<String, Long> getFieldBidInfoNew() {
    return mBidInfoNew;
  }

  public Map<String, Long> getFieldBidInfoOld() {
    return mBidInfoOld;
  }

  public String getFieldBidTypeNew() {
    return mBidTypeNew;
  }

  public String getFieldBidTypeOld() {
    return mBidTypeOld;
  }

  public List<Object> getFieldConversionSpecsNew() {
    return mConversionSpecsNew;
  }

  public List<Object> getFieldConversionSpecsOld() {
    return mConversionSpecsOld;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public Long getFieldDisplaySequenceNew() {
    return mDisplaySequenceNew;
  }

  public Long getFieldDisplaySequenceOld() {
    return mDisplaySequenceOld;
  }

  public Boolean getFieldEngagementAudienceNew() {
    return mEngagementAudienceNew;
  }

  public Boolean getFieldEngagementAudienceOld() {
    return mEngagementAudienceOld;
  }

  public String getFieldEventTime() {
    return mEventTime;
  }

  public String getFieldEventType() {
    return mEventType;
  }

  public Boolean getFieldForceRunStatusNew() {
    return mForceRunStatusNew;
  }

  public Boolean getFieldForceRunStatusOld() {
    return mForceRunStatusOld;
  }

  public String getFieldFriendlyNameNew() {
    return mFriendlyNameNew;
  }

  public String getFieldFriendlyNameOld() {
    return mFriendlyNameOld;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsReviewerAdminNew() {
    return mIsReviewerAdminNew;
  }

  public Boolean getFieldIsReviewerAdminOld() {
    return mIsReviewerAdminOld;
  }

  public EnumObjectiveNew getFieldObjectiveNew() {
    return mObjectiveNew;
  }

  public EnumObjectiveOld getFieldObjectiveOld() {
    return mObjectiveOld;
  }

  public String getFieldObjectiveSourceNew() {
    return mObjectiveSourceNew;
  }

  public String getFieldObjectiveSourceOld() {
    return mObjectiveSourceOld;
  }

  public Long getFieldPriorityNew() {
    return mPriorityNew;
  }

  public Long getFieldPriorityOld() {
    return mPriorityOld;
  }

  public String getFieldReasonNew() {
    return mReasonNew;
  }

  public String getFieldReasonOld() {
    return mReasonOld;
  }

  public String getFieldRunStatusNew() {
    return mRunStatusNew;
  }

  public String getFieldRunStatusOld() {
    return mRunStatusOld;
  }

  public Ad getFieldSourceAdgroupIdNew() {
    if (mSourceAdgroupIdNew != null) {
      mSourceAdgroupIdNew.context = getContext();
    }
    return mSourceAdgroupIdNew;
  }

  public Ad getFieldSourceAdgroupIdOld() {
    if (mSourceAdgroupIdOld != null) {
      mSourceAdgroupIdOld.context = getContext();
    }
    return mSourceAdgroupIdOld;
  }

  public String getFieldStartTimeNew() {
    return mStartTimeNew;
  }

  public String getFieldStartTimeOld() {
    return mStartTimeOld;
  }

  public String getFieldStopTimeNew() {
    return mStopTimeNew;
  }

  public String getFieldStopTimeOld() {
    return mStopTimeOld;
  }

  public String getFieldTargetSpecIdNew() {
    return mTargetSpecIdNew;
  }

  public String getFieldTargetSpecIdOld() {
    return mTargetSpecIdOld;
  }

  public List<String> getFieldTrackingPixelIdsNew() {
    return mTrackingPixelIdsNew;
  }

  public List<String> getFieldTrackingPixelIdsOld() {
    return mTrackingPixelIdsOld;
  }

  public List<Object> getFieldTrackingSpecsNew() {
    return mTrackingSpecsNew;
  }

  public List<Object> getFieldTrackingSpecsOld() {
    return mTrackingSpecsOld;
  }

  public String getFieldUpdateTimeNew() {
    return mUpdateTimeNew;
  }

  public String getFieldUpdateTimeOld() {
    return mUpdateTimeOld;
  }

  public List<String> getFieldViewTagsNew() {
    return mViewTagsNew;
  }

  public List<String> getFieldViewTagsOld() {
    return mViewTagsOld;
  }



  public static class APIRequestGet extends APIRequest<AdgroupActivity> {

    AdgroupActivity lastResponse = null;
    @Override
    public AdgroupActivity getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_creative_id_new",
      "ad_creative_id_old",
      "asset_feed_id_new",
      "asset_feed_id_old",
      "bid_amount_new",
      "bid_amount_old",
      "bid_info_new",
      "bid_info_old",
      "bid_type_new",
      "bid_type_old",
      "conversion_specs_new",
      "conversion_specs_old",
      "created_time",
      "display_sequence_new",
      "display_sequence_old",
      "engagement_audience_new",
      "engagement_audience_old",
      "event_time",
      "event_type",
      "force_run_status_new",
      "force_run_status_old",
      "friendly_name_new",
      "friendly_name_old",
      "id",
      "is_reviewer_admin_new",
      "is_reviewer_admin_old",
      "objective_new",
      "objective_old",
      "objective_source_new",
      "objective_source_old",
      "priority_new",
      "priority_old",
      "reason_new",
      "reason_old",
      "run_status_new",
      "run_status_old",
      "source_adgroup_id_new",
      "source_adgroup_id_old",
      "start_time_new",
      "start_time_old",
      "stop_time_new",
      "stop_time_old",
      "target_spec_id_new",
      "target_spec_id_old",
      "tracking_pixel_ids_new",
      "tracking_pixel_ids_old",
      "tracking_specs_new",
      "tracking_specs_old",
      "update_time_new",
      "update_time_old",
      "view_tags_new",
      "view_tags_old",
    };

    @Override
    public AdgroupActivity parseResponse(String response, String header) throws APIException {
      return AdgroupActivity.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdgroupActivity execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdgroupActivity execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdgroupActivity> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdgroupActivity> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdgroupActivity>() {
           public AdgroupActivity apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdCreativeIdNewField () {
      return this.requestAdCreativeIdNewField(true);
    }
    public APIRequestGet requestAdCreativeIdNewField (boolean value) {
      this.requestField("ad_creative_id_new", value);
      return this;
    }
    public APIRequestGet requestAdCreativeIdOldField () {
      return this.requestAdCreativeIdOldField(true);
    }
    public APIRequestGet requestAdCreativeIdOldField (boolean value) {
      this.requestField("ad_creative_id_old", value);
      return this;
    }
    public APIRequestGet requestAssetFeedIdNewField () {
      return this.requestAssetFeedIdNewField(true);
    }
    public APIRequestGet requestAssetFeedIdNewField (boolean value) {
      this.requestField("asset_feed_id_new", value);
      return this;
    }
    public APIRequestGet requestAssetFeedIdOldField () {
      return this.requestAssetFeedIdOldField(true);
    }
    public APIRequestGet requestAssetFeedIdOldField (boolean value) {
      this.requestField("asset_feed_id_old", value);
      return this;
    }
    public APIRequestGet requestBidAmountNewField () {
      return this.requestBidAmountNewField(true);
    }
    public APIRequestGet requestBidAmountNewField (boolean value) {
      this.requestField("bid_amount_new", value);
      return this;
    }
    public APIRequestGet requestBidAmountOldField () {
      return this.requestBidAmountOldField(true);
    }
    public APIRequestGet requestBidAmountOldField (boolean value) {
      this.requestField("bid_amount_old", value);
      return this;
    }
    public APIRequestGet requestBidInfoNewField () {
      return this.requestBidInfoNewField(true);
    }
    public APIRequestGet requestBidInfoNewField (boolean value) {
      this.requestField("bid_info_new", value);
      return this;
    }
    public APIRequestGet requestBidInfoOldField () {
      return this.requestBidInfoOldField(true);
    }
    public APIRequestGet requestBidInfoOldField (boolean value) {
      this.requestField("bid_info_old", value);
      return this;
    }
    public APIRequestGet requestBidTypeNewField () {
      return this.requestBidTypeNewField(true);
    }
    public APIRequestGet requestBidTypeNewField (boolean value) {
      this.requestField("bid_type_new", value);
      return this;
    }
    public APIRequestGet requestBidTypeOldField () {
      return this.requestBidTypeOldField(true);
    }
    public APIRequestGet requestBidTypeOldField (boolean value) {
      this.requestField("bid_type_old", value);
      return this;
    }
    public APIRequestGet requestConversionSpecsNewField () {
      return this.requestConversionSpecsNewField(true);
    }
    public APIRequestGet requestConversionSpecsNewField (boolean value) {
      this.requestField("conversion_specs_new", value);
      return this;
    }
    public APIRequestGet requestConversionSpecsOldField () {
      return this.requestConversionSpecsOldField(true);
    }
    public APIRequestGet requestConversionSpecsOldField (boolean value) {
      this.requestField("conversion_specs_old", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestDisplaySequenceNewField () {
      return this.requestDisplaySequenceNewField(true);
    }
    public APIRequestGet requestDisplaySequenceNewField (boolean value) {
      this.requestField("display_sequence_new", value);
      return this;
    }
    public APIRequestGet requestDisplaySequenceOldField () {
      return this.requestDisplaySequenceOldField(true);
    }
    public APIRequestGet requestDisplaySequenceOldField (boolean value) {
      this.requestField("display_sequence_old", value);
      return this;
    }
    public APIRequestGet requestEngagementAudienceNewField () {
      return this.requestEngagementAudienceNewField(true);
    }
    public APIRequestGet requestEngagementAudienceNewField (boolean value) {
      this.requestField("engagement_audience_new", value);
      return this;
    }
    public APIRequestGet requestEngagementAudienceOldField () {
      return this.requestEngagementAudienceOldField(true);
    }
    public APIRequestGet requestEngagementAudienceOldField (boolean value) {
      this.requestField("engagement_audience_old", value);
      return this;
    }
    public APIRequestGet requestEventTimeField () {
      return this.requestEventTimeField(true);
    }
    public APIRequestGet requestEventTimeField (boolean value) {
      this.requestField("event_time", value);
      return this;
    }
    public APIRequestGet requestEventTypeField () {
      return this.requestEventTypeField(true);
    }
    public APIRequestGet requestEventTypeField (boolean value) {
      this.requestField("event_type", value);
      return this;
    }
    public APIRequestGet requestForceRunStatusNewField () {
      return this.requestForceRunStatusNewField(true);
    }
    public APIRequestGet requestForceRunStatusNewField (boolean value) {
      this.requestField("force_run_status_new", value);
      return this;
    }
    public APIRequestGet requestForceRunStatusOldField () {
      return this.requestForceRunStatusOldField(true);
    }
    public APIRequestGet requestForceRunStatusOldField (boolean value) {
      this.requestField("force_run_status_old", value);
      return this;
    }
    public APIRequestGet requestFriendlyNameNewField () {
      return this.requestFriendlyNameNewField(true);
    }
    public APIRequestGet requestFriendlyNameNewField (boolean value) {
      this.requestField("friendly_name_new", value);
      return this;
    }
    public APIRequestGet requestFriendlyNameOldField () {
      return this.requestFriendlyNameOldField(true);
    }
    public APIRequestGet requestFriendlyNameOldField (boolean value) {
      this.requestField("friendly_name_old", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsReviewerAdminNewField () {
      return this.requestIsReviewerAdminNewField(true);
    }
    public APIRequestGet requestIsReviewerAdminNewField (boolean value) {
      this.requestField("is_reviewer_admin_new", value);
      return this;
    }
    public APIRequestGet requestIsReviewerAdminOldField () {
      return this.requestIsReviewerAdminOldField(true);
    }
    public APIRequestGet requestIsReviewerAdminOldField (boolean value) {
      this.requestField("is_reviewer_admin_old", value);
      return this;
    }
    public APIRequestGet requestObjectiveNewField () {
      return this.requestObjectiveNewField(true);
    }
    public APIRequestGet requestObjectiveNewField (boolean value) {
      this.requestField("objective_new", value);
      return this;
    }
    public APIRequestGet requestObjectiveOldField () {
      return this.requestObjectiveOldField(true);
    }
    public APIRequestGet requestObjectiveOldField (boolean value) {
      this.requestField("objective_old", value);
      return this;
    }
    public APIRequestGet requestObjectiveSourceNewField () {
      return this.requestObjectiveSourceNewField(true);
    }
    public APIRequestGet requestObjectiveSourceNewField (boolean value) {
      this.requestField("objective_source_new", value);
      return this;
    }
    public APIRequestGet requestObjectiveSourceOldField () {
      return this.requestObjectiveSourceOldField(true);
    }
    public APIRequestGet requestObjectiveSourceOldField (boolean value) {
      this.requestField("objective_source_old", value);
      return this;
    }
    public APIRequestGet requestPriorityNewField () {
      return this.requestPriorityNewField(true);
    }
    public APIRequestGet requestPriorityNewField (boolean value) {
      this.requestField("priority_new", value);
      return this;
    }
    public APIRequestGet requestPriorityOldField () {
      return this.requestPriorityOldField(true);
    }
    public APIRequestGet requestPriorityOldField (boolean value) {
      this.requestField("priority_old", value);
      return this;
    }
    public APIRequestGet requestReasonNewField () {
      return this.requestReasonNewField(true);
    }
    public APIRequestGet requestReasonNewField (boolean value) {
      this.requestField("reason_new", value);
      return this;
    }
    public APIRequestGet requestReasonOldField () {
      return this.requestReasonOldField(true);
    }
    public APIRequestGet requestReasonOldField (boolean value) {
      this.requestField("reason_old", value);
      return this;
    }
    public APIRequestGet requestRunStatusNewField () {
      return this.requestRunStatusNewField(true);
    }
    public APIRequestGet requestRunStatusNewField (boolean value) {
      this.requestField("run_status_new", value);
      return this;
    }
    public APIRequestGet requestRunStatusOldField () {
      return this.requestRunStatusOldField(true);
    }
    public APIRequestGet requestRunStatusOldField (boolean value) {
      this.requestField("run_status_old", value);
      return this;
    }
    public APIRequestGet requestSourceAdgroupIdNewField () {
      return this.requestSourceAdgroupIdNewField(true);
    }
    public APIRequestGet requestSourceAdgroupIdNewField (boolean value) {
      this.requestField("source_adgroup_id_new", value);
      return this;
    }
    public APIRequestGet requestSourceAdgroupIdOldField () {
      return this.requestSourceAdgroupIdOldField(true);
    }
    public APIRequestGet requestSourceAdgroupIdOldField (boolean value) {
      this.requestField("source_adgroup_id_old", value);
      return this;
    }
    public APIRequestGet requestStartTimeNewField () {
      return this.requestStartTimeNewField(true);
    }
    public APIRequestGet requestStartTimeNewField (boolean value) {
      this.requestField("start_time_new", value);
      return this;
    }
    public APIRequestGet requestStartTimeOldField () {
      return this.requestStartTimeOldField(true);
    }
    public APIRequestGet requestStartTimeOldField (boolean value) {
      this.requestField("start_time_old", value);
      return this;
    }
    public APIRequestGet requestStopTimeNewField () {
      return this.requestStopTimeNewField(true);
    }
    public APIRequestGet requestStopTimeNewField (boolean value) {
      this.requestField("stop_time_new", value);
      return this;
    }
    public APIRequestGet requestStopTimeOldField () {
      return this.requestStopTimeOldField(true);
    }
    public APIRequestGet requestStopTimeOldField (boolean value) {
      this.requestField("stop_time_old", value);
      return this;
    }
    public APIRequestGet requestTargetSpecIdNewField () {
      return this.requestTargetSpecIdNewField(true);
    }
    public APIRequestGet requestTargetSpecIdNewField (boolean value) {
      this.requestField("target_spec_id_new", value);
      return this;
    }
    public APIRequestGet requestTargetSpecIdOldField () {
      return this.requestTargetSpecIdOldField(true);
    }
    public APIRequestGet requestTargetSpecIdOldField (boolean value) {
      this.requestField("target_spec_id_old", value);
      return this;
    }
    public APIRequestGet requestTrackingPixelIdsNewField () {
      return this.requestTrackingPixelIdsNewField(true);
    }
    public APIRequestGet requestTrackingPixelIdsNewField (boolean value) {
      this.requestField("tracking_pixel_ids_new", value);
      return this;
    }
    public APIRequestGet requestTrackingPixelIdsOldField () {
      return this.requestTrackingPixelIdsOldField(true);
    }
    public APIRequestGet requestTrackingPixelIdsOldField (boolean value) {
      this.requestField("tracking_pixel_ids_old", value);
      return this;
    }
    public APIRequestGet requestTrackingSpecsNewField () {
      return this.requestTrackingSpecsNewField(true);
    }
    public APIRequestGet requestTrackingSpecsNewField (boolean value) {
      this.requestField("tracking_specs_new", value);
      return this;
    }
    public APIRequestGet requestTrackingSpecsOldField () {
      return this.requestTrackingSpecsOldField(true);
    }
    public APIRequestGet requestTrackingSpecsOldField (boolean value) {
      this.requestField("tracking_specs_old", value);
      return this;
    }
    public APIRequestGet requestUpdateTimeNewField () {
      return this.requestUpdateTimeNewField(true);
    }
    public APIRequestGet requestUpdateTimeNewField (boolean value) {
      this.requestField("update_time_new", value);
      return this;
    }
    public APIRequestGet requestUpdateTimeOldField () {
      return this.requestUpdateTimeOldField(true);
    }
    public APIRequestGet requestUpdateTimeOldField (boolean value) {
      this.requestField("update_time_old", value);
      return this;
    }
    public APIRequestGet requestViewTagsNewField () {
      return this.requestViewTagsNewField(true);
    }
    public APIRequestGet requestViewTagsNewField (boolean value) {
      this.requestField("view_tags_new", value);
      return this;
    }
    public APIRequestGet requestViewTagsOldField () {
      return this.requestViewTagsOldField(true);
    }
    public APIRequestGet requestViewTagsOldField (boolean value) {
      this.requestField("view_tags_old", value);
      return this;
    }
  }

  public static enum EnumObjectiveNew {
      @SerializedName("APP_INSTALLS")
      VALUE_APP_INSTALLS("APP_INSTALLS"),
      @SerializedName("BRAND_AWARENESS")
      VALUE_BRAND_AWARENESS("BRAND_AWARENESS"),
      @SerializedName("CANVAS_APP_ENGAGEMENT")
      VALUE_CANVAS_APP_ENGAGEMENT("CANVAS_APP_ENGAGEMENT"),
      @SerializedName("CANVAS_APP_INSTALLS")
      VALUE_CANVAS_APP_INSTALLS("CANVAS_APP_INSTALLS"),
      @SerializedName("EVENT_RESPONSES")
      VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
      @SerializedName("LEAD_GENERATION")
      VALUE_LEAD_GENERATION("LEAD_GENERATION"),
      @SerializedName("LINK_CLICKS")
      VALUE_LINK_CLICKS("LINK_CLICKS"),
      @SerializedName("LOCAL_AWARENESS")
      VALUE_LOCAL_AWARENESS("LOCAL_AWARENESS"),
      @SerializedName("MESSAGES")
      VALUE_MESSAGES("MESSAGES"),
      @SerializedName("MOBILE_APP_ENGAGEMENT")
      VALUE_MOBILE_APP_ENGAGEMENT("MOBILE_APP_ENGAGEMENT"),
      @SerializedName("MOBILE_APP_INSTALLS")
      VALUE_MOBILE_APP_INSTALLS("MOBILE_APP_INSTALLS"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OFFER_CLAIMS")
      VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("PRODUCT_CATALOG_SALES")
      VALUE_PRODUCT_CATALOG_SALES("PRODUCT_CATALOG_SALES"),
      @SerializedName("VIDEO_VIEWS")
      VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
      @SerializedName("WEBSITE_CONVERSIONS")
      VALUE_WEBSITE_CONVERSIONS("WEBSITE_CONVERSIONS"),
      ;

      private String value;

      private EnumObjectiveNew(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumObjectiveOld {
      @SerializedName("APP_INSTALLS")
      VALUE_APP_INSTALLS("APP_INSTALLS"),
      @SerializedName("BRAND_AWARENESS")
      VALUE_BRAND_AWARENESS("BRAND_AWARENESS"),
      @SerializedName("CANVAS_APP_ENGAGEMENT")
      VALUE_CANVAS_APP_ENGAGEMENT("CANVAS_APP_ENGAGEMENT"),
      @SerializedName("CANVAS_APP_INSTALLS")
      VALUE_CANVAS_APP_INSTALLS("CANVAS_APP_INSTALLS"),
      @SerializedName("EVENT_RESPONSES")
      VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
      @SerializedName("LEAD_GENERATION")
      VALUE_LEAD_GENERATION("LEAD_GENERATION"),
      @SerializedName("LINK_CLICKS")
      VALUE_LINK_CLICKS("LINK_CLICKS"),
      @SerializedName("LOCAL_AWARENESS")
      VALUE_LOCAL_AWARENESS("LOCAL_AWARENESS"),
      @SerializedName("MESSAGES")
      VALUE_MESSAGES("MESSAGES"),
      @SerializedName("MOBILE_APP_ENGAGEMENT")
      VALUE_MOBILE_APP_ENGAGEMENT("MOBILE_APP_ENGAGEMENT"),
      @SerializedName("MOBILE_APP_INSTALLS")
      VALUE_MOBILE_APP_INSTALLS("MOBILE_APP_INSTALLS"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OFFER_CLAIMS")
      VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("PRODUCT_CATALOG_SALES")
      VALUE_PRODUCT_CATALOG_SALES("PRODUCT_CATALOG_SALES"),
      @SerializedName("VIDEO_VIEWS")
      VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
      @SerializedName("WEBSITE_CONVERSIONS")
      VALUE_WEBSITE_CONVERSIONS("WEBSITE_CONVERSIONS"),
      ;

      private String value;

      private EnumObjectiveOld(String value) {
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

  public AdgroupActivity copyFrom(AdgroupActivity instance) {
    this.mAdCreativeIdNew = instance.mAdCreativeIdNew;
    this.mAdCreativeIdOld = instance.mAdCreativeIdOld;
    this.mAssetFeedIdNew = instance.mAssetFeedIdNew;
    this.mAssetFeedIdOld = instance.mAssetFeedIdOld;
    this.mBidAmountNew = instance.mBidAmountNew;
    this.mBidAmountOld = instance.mBidAmountOld;
    this.mBidInfoNew = instance.mBidInfoNew;
    this.mBidInfoOld = instance.mBidInfoOld;
    this.mBidTypeNew = instance.mBidTypeNew;
    this.mBidTypeOld = instance.mBidTypeOld;
    this.mConversionSpecsNew = instance.mConversionSpecsNew;
    this.mConversionSpecsOld = instance.mConversionSpecsOld;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDisplaySequenceNew = instance.mDisplaySequenceNew;
    this.mDisplaySequenceOld = instance.mDisplaySequenceOld;
    this.mEngagementAudienceNew = instance.mEngagementAudienceNew;
    this.mEngagementAudienceOld = instance.mEngagementAudienceOld;
    this.mEventTime = instance.mEventTime;
    this.mEventType = instance.mEventType;
    this.mForceRunStatusNew = instance.mForceRunStatusNew;
    this.mForceRunStatusOld = instance.mForceRunStatusOld;
    this.mFriendlyNameNew = instance.mFriendlyNameNew;
    this.mFriendlyNameOld = instance.mFriendlyNameOld;
    this.mId = instance.mId;
    this.mIsReviewerAdminNew = instance.mIsReviewerAdminNew;
    this.mIsReviewerAdminOld = instance.mIsReviewerAdminOld;
    this.mObjectiveNew = instance.mObjectiveNew;
    this.mObjectiveOld = instance.mObjectiveOld;
    this.mObjectiveSourceNew = instance.mObjectiveSourceNew;
    this.mObjectiveSourceOld = instance.mObjectiveSourceOld;
    this.mPriorityNew = instance.mPriorityNew;
    this.mPriorityOld = instance.mPriorityOld;
    this.mReasonNew = instance.mReasonNew;
    this.mReasonOld = instance.mReasonOld;
    this.mRunStatusNew = instance.mRunStatusNew;
    this.mRunStatusOld = instance.mRunStatusOld;
    this.mSourceAdgroupIdNew = instance.mSourceAdgroupIdNew;
    this.mSourceAdgroupIdOld = instance.mSourceAdgroupIdOld;
    this.mStartTimeNew = instance.mStartTimeNew;
    this.mStartTimeOld = instance.mStartTimeOld;
    this.mStopTimeNew = instance.mStopTimeNew;
    this.mStopTimeOld = instance.mStopTimeOld;
    this.mTargetSpecIdNew = instance.mTargetSpecIdNew;
    this.mTargetSpecIdOld = instance.mTargetSpecIdOld;
    this.mTrackingPixelIdsNew = instance.mTrackingPixelIdsNew;
    this.mTrackingPixelIdsOld = instance.mTrackingPixelIdsOld;
    this.mTrackingSpecsNew = instance.mTrackingSpecsNew;
    this.mTrackingSpecsOld = instance.mTrackingSpecsOld;
    this.mUpdateTimeNew = instance.mUpdateTimeNew;
    this.mUpdateTimeOld = instance.mUpdateTimeOld;
    this.mViewTagsNew = instance.mViewTagsNew;
    this.mViewTagsOld = instance.mViewTagsOld;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdgroupActivity> getParser() {
    return new APIRequest.ResponseParser<AdgroupActivity>() {
      public APINodeList<AdgroupActivity> parseResponse(String response, APIContext context, APIRequest<AdgroupActivity> request, String header) throws MalformedResponseException {
        return AdgroupActivity.parseResponse(response, context, request, header);
      }
    };
  }
}
