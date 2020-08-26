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
public class AtlasCampaign extends APINode {
  @SerializedName("ad_platform")
  private Object mAdPlatform = null;
  @SerializedName("alias")
  private String mAlias = null;
  @SerializedName("cost_per_1k_impressions")
  private Double mCostPer1kImpressions = null;
  @SerializedName("cost_per_click")
  private Double mCostPerClick = null;
  @SerializedName("cost_per_visit")
  private Double mCostPerVisit = null;
  @SerializedName("created_by")
  private Object mCreatedBy = null;
  @SerializedName("created_date")
  private String mCreatedDate = null;
  @SerializedName("data_driven_convs")
  private Double mDataDrivenConvs = null;
  @SerializedName("data_driven_convs_per_1k_impress")
  private Double mDataDrivenConvsPer1kImpress = null;
  @SerializedName("data_driven_convs_per_click")
  private Double mDataDrivenConvsPerClick = null;
  @SerializedName("data_driven_convs_per_visit")
  private Double mDataDrivenConvsPerVisit = null;
  @SerializedName("data_driven_cpa")
  private Double mDataDrivenCpa = null;
  @SerializedName("data_driven_nullable_convs")
  private Double mDataDrivenNullableConvs = null;
  @SerializedName("data_driven_revenue")
  private Double mDataDrivenRevenue = null;
  @SerializedName("data_driven_roas")
  private Double mDataDrivenRoas = null;
  @SerializedName("even_credit_convs")
  private Double mEvenCreditConvs = null;
  @SerializedName("even_credit_convs_per_1k_impress")
  private Double mEvenCreditConvsPer1kImpress = null;
  @SerializedName("even_credit_convs_per_click")
  private Double mEvenCreditConvsPerClick = null;
  @SerializedName("even_credit_convs_per_visit")
  private Double mEvenCreditConvsPerVisit = null;
  @SerializedName("even_credit_cpa")
  private Double mEvenCreditCpa = null;
  @SerializedName("even_credit_revenue")
  private Double mEvenCreditRevenue = null;
  @SerializedName("even_credit_roas")
  private Double mEvenCreditRoas = null;
  @SerializedName("first_click_convs")
  private Double mFirstClickConvs = null;
  @SerializedName("first_click_convs_per_1k_impress")
  private Double mFirstClickConvsPer1kImpress = null;
  @SerializedName("first_click_convs_per_click")
  private Double mFirstClickConvsPerClick = null;
  @SerializedName("first_click_convs_per_visit")
  private Double mFirstClickConvsPerVisit = null;
  @SerializedName("first_click_cpa")
  private Double mFirstClickCpa = null;
  @SerializedName("first_click_revenue")
  private Double mFirstClickRevenue = null;
  @SerializedName("first_click_roas")
  private Double mFirstClickRoas = null;
  @SerializedName("first_touch_convs")
  private Double mFirstTouchConvs = null;
  @SerializedName("first_touch_convs_per_1k_impress")
  private Double mFirstTouchConvsPer1kImpress = null;
  @SerializedName("first_touch_convs_per_click")
  private Double mFirstTouchConvsPerClick = null;
  @SerializedName("first_touch_convs_per_visit")
  private Double mFirstTouchConvsPerVisit = null;
  @SerializedName("first_touch_cpa")
  private Double mFirstTouchCpa = null;
  @SerializedName("first_touch_revenue")
  private Double mFirstTouchRevenue = null;
  @SerializedName("first_touch_roas")
  private Double mFirstTouchRoas = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_archived")
  private Boolean mIsArchived = null;
  @SerializedName("last_click_convs")
  private Double mLastClickConvs = null;
  @SerializedName("last_click_convs_per_1k_impress")
  private Double mLastClickConvsPer1kImpress = null;
  @SerializedName("last_click_convs_per_click")
  private Double mLastClickConvsPerClick = null;
  @SerializedName("last_click_convs_per_visit")
  private Double mLastClickConvsPerVisit = null;
  @SerializedName("last_click_cpa")
  private Double mLastClickCpa = null;
  @SerializedName("last_click_revenue")
  private Double mLastClickRevenue = null;
  @SerializedName("last_click_roas")
  private Double mLastClickRoas = null;
  @SerializedName("last_click_with_extrapolation_convs")
  private Double mLastClickWithExtrapolationConvs = null;
  @SerializedName("last_click_with_extrapolation_convs_per_100_clicks")
  private Double mLastClickWithExtrapolationConvsPer100Clicks = null;
  @SerializedName("last_click_with_extrapolation_convs_per_1k_impress")
  private Double mLastClickWithExtrapolationConvsPer1kImpress = null;
  @SerializedName("last_click_with_extrapolation_convs_per_click")
  private Double mLastClickWithExtrapolationConvsPerClick = null;
  @SerializedName("last_click_with_extrapolation_convs_per_visit")
  private Double mLastClickWithExtrapolationConvsPerVisit = null;
  @SerializedName("last_click_with_extrapolation_cpa")
  private Double mLastClickWithExtrapolationCpa = null;
  @SerializedName("last_click_with_extrapolation_revenue")
  private Double mLastClickWithExtrapolationRevenue = null;
  @SerializedName("last_click_with_extrapolation_roas")
  private Double mLastClickWithExtrapolationRoas = null;
  @SerializedName("last_click_with_extrapolation_unattributed")
  private Double mLastClickWithExtrapolationUnattributed = null;
  @SerializedName("last_modified_by")
  private Object mLastModifiedBy = null;
  @SerializedName("last_modified_date")
  private String mLastModifiedDate = null;
  @SerializedName("last_touch_convs")
  private Double mLastTouchConvs = null;
  @SerializedName("last_touch_convs_per_1k_impress")
  private Double mLastTouchConvsPer1kImpress = null;
  @SerializedName("last_touch_convs_per_click")
  private Double mLastTouchConvsPerClick = null;
  @SerializedName("last_touch_convs_per_visit")
  private Double mLastTouchConvsPerVisit = null;
  @SerializedName("last_touch_cpa")
  private Double mLastTouchCpa = null;
  @SerializedName("last_touch_revenue")
  private Double mLastTouchRevenue = null;
  @SerializedName("last_touch_roas")
  private Double mLastTouchRoas = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("net_media_cost")
  private Double mNetMediaCost = null;
  @SerializedName("positional_30fl_convs")
  private Double mPositional30flConvs = null;
  @SerializedName("positional_30fl_convs_per_1k_impress")
  private Double mPositional30flConvsPer1kImpress = null;
  @SerializedName("positional_30fl_convs_per_click")
  private Double mPositional30flConvsPerClick = null;
  @SerializedName("positional_30fl_convs_per_visit")
  private Double mPositional30flConvsPerVisit = null;
  @SerializedName("positional_30fl_cpa")
  private Double mPositional30flCpa = null;
  @SerializedName("positional_30fl_revenue")
  private Double mPositional30flRevenue = null;
  @SerializedName("positional_30fl_roas")
  private Double mPositional30flRoas = null;
  @SerializedName("positional_40fl_convs")
  private Double mPositional40flConvs = null;
  @SerializedName("positional_40fl_convs_per_1k_impress")
  private Double mPositional40flConvsPer1kImpress = null;
  @SerializedName("positional_40fl_convs_per_click")
  private Double mPositional40flConvsPerClick = null;
  @SerializedName("positional_40fl_convs_per_visit")
  private Double mPositional40flConvsPerVisit = null;
  @SerializedName("positional_40fl_cpa")
  private Double mPositional40flCpa = null;
  @SerializedName("positional_40fl_revenue")
  private Double mPositional40flRevenue = null;
  @SerializedName("positional_40fl_roas")
  private Double mPositional40flRoas = null;
  @SerializedName("report_click_through_rate")
  private Double mReportClickThroughRate = null;
  @SerializedName("report_clicks")
  private Long mReportClicks = null;
  @SerializedName("report_impressions")
  private Long mReportImpressions = null;
  @SerializedName("report_visits")
  private Long mReportVisits = null;
  @SerializedName("time_decay_1day_convs")
  private Double mTimeDecay1dayConvs = null;
  @SerializedName("time_decay_1day_convs_per_1k_impress")
  private Double mTimeDecay1dayConvsPer1kImpress = null;
  @SerializedName("time_decay_1day_convs_per_click")
  private Double mTimeDecay1dayConvsPerClick = null;
  @SerializedName("time_decay_1day_convs_per_visit")
  private Double mTimeDecay1dayConvsPerVisit = null;
  @SerializedName("time_decay_1day_cpa")
  private Double mTimeDecay1dayCpa = null;
  @SerializedName("time_decay_1day_revenue")
  private Double mTimeDecay1dayRevenue = null;
  @SerializedName("time_decay_1day_roas")
  private Double mTimeDecay1dayRoas = null;
  @SerializedName("time_decay_7day_convs")
  private Double mTimeDecay7dayConvs = null;
  @SerializedName("time_decay_7day_convs_per_1k_impress")
  private Double mTimeDecay7dayConvsPer1kImpress = null;
  @SerializedName("time_decay_7day_convs_per_click")
  private Double mTimeDecay7dayConvsPerClick = null;
  @SerializedName("time_decay_7day_convs_per_visit")
  private Double mTimeDecay7dayConvsPerVisit = null;
  @SerializedName("time_decay_7day_cpa")
  private Double mTimeDecay7dayCpa = null;
  @SerializedName("time_decay_7day_revenue")
  private Double mTimeDecay7dayRevenue = null;
  @SerializedName("time_decay_7day_roas")
  private Double mTimeDecay7dayRoas = null;
  @SerializedName("type")
  private String mType = null;
  protected static Gson gson = null;

  AtlasCampaign() {
  }

  public AtlasCampaign(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AtlasCampaign(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AtlasCampaign fetch() throws APIException{
    AtlasCampaign newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AtlasCampaign fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AtlasCampaign> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AtlasCampaign fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AtlasCampaign> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AtlasCampaign> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AtlasCampaign>)(
      new APIRequest<AtlasCampaign>(context, "", "/", "GET", AtlasCampaign.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AtlasCampaign>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AtlasCampaign.getParser())
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
  public static AtlasCampaign loadJSON(String json, APIContext context, String header) {
    AtlasCampaign atlasCampaign = getGson().fromJson(json, AtlasCampaign.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(atlasCampaign.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    atlasCampaign.context = context;
    atlasCampaign.rawValue = json;
    atlasCampaign.header = header;
    return atlasCampaign;
  }

  public static APINodeList<AtlasCampaign> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AtlasCampaign> atlasCampaigns = new APINodeList<AtlasCampaign>(request, json, header);
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
          atlasCampaigns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return atlasCampaigns;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                atlasCampaigns.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            atlasCampaigns.setPaging(previous, next);
            if (context.hasAppSecret()) {
              atlasCampaigns.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              atlasCampaigns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  atlasCampaigns.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              atlasCampaigns.add(loadJSON(obj.toString(), context, header));
            }
          }
          return atlasCampaigns;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              atlasCampaigns.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return atlasCampaigns;
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
              atlasCampaigns.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return atlasCampaigns;
          }

          // Sixth, check if it's pure JsonObject
          atlasCampaigns.clear();
          atlasCampaigns.add(loadJSON(json, context, header));
          return atlasCampaigns;
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

  public APIRequestGetAdSets getAdSets() {
    return new APIRequestGetAdSets(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBusinessUnit getBusinessUnit() {
    return new APIRequestGetBusinessUnit(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMetricsBreakdown getMetricsBreakdown() {
    return new APIRequestGetMetricsBreakdown(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSources getSources() {
    return new APIRequestGetSources(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Object getFieldAdPlatform() {
    return mAdPlatform;
  }

  public String getFieldAlias() {
    return mAlias;
  }

  public Double getFieldCostPer1kImpressions() {
    return mCostPer1kImpressions;
  }

  public Double getFieldCostPerClick() {
    return mCostPerClick;
  }

  public Double getFieldCostPerVisit() {
    return mCostPerVisit;
  }

  public Object getFieldCreatedBy() {
    return mCreatedBy;
  }

  public String getFieldCreatedDate() {
    return mCreatedDate;
  }

  public Double getFieldDataDrivenConvs() {
    return mDataDrivenConvs;
  }

  public Double getFieldDataDrivenConvsPer1kImpress() {
    return mDataDrivenConvsPer1kImpress;
  }

  public Double getFieldDataDrivenConvsPerClick() {
    return mDataDrivenConvsPerClick;
  }

  public Double getFieldDataDrivenConvsPerVisit() {
    return mDataDrivenConvsPerVisit;
  }

  public Double getFieldDataDrivenCpa() {
    return mDataDrivenCpa;
  }

  public Double getFieldDataDrivenNullableConvs() {
    return mDataDrivenNullableConvs;
  }

  public Double getFieldDataDrivenRevenue() {
    return mDataDrivenRevenue;
  }

  public Double getFieldDataDrivenRoas() {
    return mDataDrivenRoas;
  }

  public Double getFieldEvenCreditConvs() {
    return mEvenCreditConvs;
  }

  public Double getFieldEvenCreditConvsPer1kImpress() {
    return mEvenCreditConvsPer1kImpress;
  }

  public Double getFieldEvenCreditConvsPerClick() {
    return mEvenCreditConvsPerClick;
  }

  public Double getFieldEvenCreditConvsPerVisit() {
    return mEvenCreditConvsPerVisit;
  }

  public Double getFieldEvenCreditCpa() {
    return mEvenCreditCpa;
  }

  public Double getFieldEvenCreditRevenue() {
    return mEvenCreditRevenue;
  }

  public Double getFieldEvenCreditRoas() {
    return mEvenCreditRoas;
  }

  public Double getFieldFirstClickConvs() {
    return mFirstClickConvs;
  }

  public Double getFieldFirstClickConvsPer1kImpress() {
    return mFirstClickConvsPer1kImpress;
  }

  public Double getFieldFirstClickConvsPerClick() {
    return mFirstClickConvsPerClick;
  }

  public Double getFieldFirstClickConvsPerVisit() {
    return mFirstClickConvsPerVisit;
  }

  public Double getFieldFirstClickCpa() {
    return mFirstClickCpa;
  }

  public Double getFieldFirstClickRevenue() {
    return mFirstClickRevenue;
  }

  public Double getFieldFirstClickRoas() {
    return mFirstClickRoas;
  }

  public Double getFieldFirstTouchConvs() {
    return mFirstTouchConvs;
  }

  public Double getFieldFirstTouchConvsPer1kImpress() {
    return mFirstTouchConvsPer1kImpress;
  }

  public Double getFieldFirstTouchConvsPerClick() {
    return mFirstTouchConvsPerClick;
  }

  public Double getFieldFirstTouchConvsPerVisit() {
    return mFirstTouchConvsPerVisit;
  }

  public Double getFieldFirstTouchCpa() {
    return mFirstTouchCpa;
  }

  public Double getFieldFirstTouchRevenue() {
    return mFirstTouchRevenue;
  }

  public Double getFieldFirstTouchRoas() {
    return mFirstTouchRoas;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsArchived() {
    return mIsArchived;
  }

  public Double getFieldLastClickConvs() {
    return mLastClickConvs;
  }

  public Double getFieldLastClickConvsPer1kImpress() {
    return mLastClickConvsPer1kImpress;
  }

  public Double getFieldLastClickConvsPerClick() {
    return mLastClickConvsPerClick;
  }

  public Double getFieldLastClickConvsPerVisit() {
    return mLastClickConvsPerVisit;
  }

  public Double getFieldLastClickCpa() {
    return mLastClickCpa;
  }

  public Double getFieldLastClickRevenue() {
    return mLastClickRevenue;
  }

  public Double getFieldLastClickRoas() {
    return mLastClickRoas;
  }

  public Double getFieldLastClickWithExtrapolationConvs() {
    return mLastClickWithExtrapolationConvs;
  }

  public Double getFieldLastClickWithExtrapolationConvsPer100Clicks() {
    return mLastClickWithExtrapolationConvsPer100Clicks;
  }

  public Double getFieldLastClickWithExtrapolationConvsPer1kImpress() {
    return mLastClickWithExtrapolationConvsPer1kImpress;
  }

  public Double getFieldLastClickWithExtrapolationConvsPerClick() {
    return mLastClickWithExtrapolationConvsPerClick;
  }

  public Double getFieldLastClickWithExtrapolationConvsPerVisit() {
    return mLastClickWithExtrapolationConvsPerVisit;
  }

  public Double getFieldLastClickWithExtrapolationCpa() {
    return mLastClickWithExtrapolationCpa;
  }

  public Double getFieldLastClickWithExtrapolationRevenue() {
    return mLastClickWithExtrapolationRevenue;
  }

  public Double getFieldLastClickWithExtrapolationRoas() {
    return mLastClickWithExtrapolationRoas;
  }

  public Double getFieldLastClickWithExtrapolationUnattributed() {
    return mLastClickWithExtrapolationUnattributed;
  }

  public Object getFieldLastModifiedBy() {
    return mLastModifiedBy;
  }

  public String getFieldLastModifiedDate() {
    return mLastModifiedDate;
  }

  public Double getFieldLastTouchConvs() {
    return mLastTouchConvs;
  }

  public Double getFieldLastTouchConvsPer1kImpress() {
    return mLastTouchConvsPer1kImpress;
  }

  public Double getFieldLastTouchConvsPerClick() {
    return mLastTouchConvsPerClick;
  }

  public Double getFieldLastTouchConvsPerVisit() {
    return mLastTouchConvsPerVisit;
  }

  public Double getFieldLastTouchCpa() {
    return mLastTouchCpa;
  }

  public Double getFieldLastTouchRevenue() {
    return mLastTouchRevenue;
  }

  public Double getFieldLastTouchRoas() {
    return mLastTouchRoas;
  }

  public String getFieldName() {
    return mName;
  }

  public Double getFieldNetMediaCost() {
    return mNetMediaCost;
  }

  public Double getFieldPositional30flConvs() {
    return mPositional30flConvs;
  }

  public Double getFieldPositional30flConvsPer1kImpress() {
    return mPositional30flConvsPer1kImpress;
  }

  public Double getFieldPositional30flConvsPerClick() {
    return mPositional30flConvsPerClick;
  }

  public Double getFieldPositional30flConvsPerVisit() {
    return mPositional30flConvsPerVisit;
  }

  public Double getFieldPositional30flCpa() {
    return mPositional30flCpa;
  }

  public Double getFieldPositional30flRevenue() {
    return mPositional30flRevenue;
  }

  public Double getFieldPositional30flRoas() {
    return mPositional30flRoas;
  }

  public Double getFieldPositional40flConvs() {
    return mPositional40flConvs;
  }

  public Double getFieldPositional40flConvsPer1kImpress() {
    return mPositional40flConvsPer1kImpress;
  }

  public Double getFieldPositional40flConvsPerClick() {
    return mPositional40flConvsPerClick;
  }

  public Double getFieldPositional40flConvsPerVisit() {
    return mPositional40flConvsPerVisit;
  }

  public Double getFieldPositional40flCpa() {
    return mPositional40flCpa;
  }

  public Double getFieldPositional40flRevenue() {
    return mPositional40flRevenue;
  }

  public Double getFieldPositional40flRoas() {
    return mPositional40flRoas;
  }

  public Double getFieldReportClickThroughRate() {
    return mReportClickThroughRate;
  }

  public Long getFieldReportClicks() {
    return mReportClicks;
  }

  public Long getFieldReportImpressions() {
    return mReportImpressions;
  }

  public Long getFieldReportVisits() {
    return mReportVisits;
  }

  public Double getFieldTimeDecay1dayConvs() {
    return mTimeDecay1dayConvs;
  }

  public Double getFieldTimeDecay1dayConvsPer1kImpress() {
    return mTimeDecay1dayConvsPer1kImpress;
  }

  public Double getFieldTimeDecay1dayConvsPerClick() {
    return mTimeDecay1dayConvsPerClick;
  }

  public Double getFieldTimeDecay1dayConvsPerVisit() {
    return mTimeDecay1dayConvsPerVisit;
  }

  public Double getFieldTimeDecay1dayCpa() {
    return mTimeDecay1dayCpa;
  }

  public Double getFieldTimeDecay1dayRevenue() {
    return mTimeDecay1dayRevenue;
  }

  public Double getFieldTimeDecay1dayRoas() {
    return mTimeDecay1dayRoas;
  }

  public Double getFieldTimeDecay7dayConvs() {
    return mTimeDecay7dayConvs;
  }

  public Double getFieldTimeDecay7dayConvsPer1kImpress() {
    return mTimeDecay7dayConvsPer1kImpress;
  }

  public Double getFieldTimeDecay7dayConvsPerClick() {
    return mTimeDecay7dayConvsPerClick;
  }

  public Double getFieldTimeDecay7dayConvsPerVisit() {
    return mTimeDecay7dayConvsPerVisit;
  }

  public Double getFieldTimeDecay7dayCpa() {
    return mTimeDecay7dayCpa;
  }

  public Double getFieldTimeDecay7dayRevenue() {
    return mTimeDecay7dayRevenue;
  }

  public Double getFieldTimeDecay7dayRoas() {
    return mTimeDecay7dayRoas;
  }

  public String getFieldType() {
    return mType;
  }



  public static class APIRequestGetAdSets extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filter_by",
      "metric_scope",
      "order_by",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAdSets.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdSets(String nodeId, APIContext context) {
      super(context, nodeId, "/ad_sets", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdSets setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdSets setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdSets setFilterBy (String filterBy) {
      this.setParam("filter_by", filterBy);
      return this;
    }

    public APIRequestGetAdSets setMetricScope (Map<String, String> metricScope) {
      this.setParam("metric_scope", metricScope);
      return this;
    }
    public APIRequestGetAdSets setMetricScope (String metricScope) {
      this.setParam("metric_scope", metricScope);
      return this;
    }

    public APIRequestGetAdSets setOrderBy (String orderBy) {
      this.setParam("order_by", orderBy);
      return this;
    }

    public APIRequestGetAdSets requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdSets requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdSets requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdSets requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdSets requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdSets requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetBusinessUnit extends APIRequest<BusinessUnit> {

    APINodeList<BusinessUnit> lastResponse = null;
    @Override
    public APINodeList<BusinessUnit> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "creation_time",
      "currency",
      "excluded_sources",
      "id",
      "is_enabled_for_measurement",
      "name",
      "time_zone",
      "visits_available_date",
    };

    @Override
    public APINodeList<BusinessUnit> parseResponse(String response, String header) throws APIException {
      return BusinessUnit.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<BusinessUnit> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessUnit> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessUnit>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessUnit>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<BusinessUnit>>() {
           public APINodeList<BusinessUnit> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBusinessUnit.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetBusinessUnit(String nodeId, APIContext context) {
      super(context, nodeId, "/business_unit", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBusinessUnit setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBusinessUnit setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBusinessUnit requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBusinessUnit requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessUnit requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBusinessUnit requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessUnit requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBusinessUnit requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBusinessUnit requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetBusinessUnit requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetBusinessUnit requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetBusinessUnit requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetBusinessUnit requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetBusinessUnit requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetBusinessUnit requestExcludedSourcesField () {
      return this.requestExcludedSourcesField(true);
    }
    public APIRequestGetBusinessUnit requestExcludedSourcesField (boolean value) {
      this.requestField("excluded_sources", value);
      return this;
    }
    public APIRequestGetBusinessUnit requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBusinessUnit requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBusinessUnit requestIsEnabledForMeasurementField () {
      return this.requestIsEnabledForMeasurementField(true);
    }
    public APIRequestGetBusinessUnit requestIsEnabledForMeasurementField (boolean value) {
      this.requestField("is_enabled_for_measurement", value);
      return this;
    }
    public APIRequestGetBusinessUnit requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetBusinessUnit requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetBusinessUnit requestTimeZoneField () {
      return this.requestTimeZoneField(true);
    }
    public APIRequestGetBusinessUnit requestTimeZoneField (boolean value) {
      this.requestField("time_zone", value);
      return this;
    }
    public APIRequestGetBusinessUnit requestVisitsAvailableDateField () {
      return this.requestVisitsAvailableDateField(true);
    }
    public APIRequestGetBusinessUnit requestVisitsAvailableDateField (boolean value) {
      this.requestField("visits_available_date", value);
      return this;
    }
  }

  public static class APIRequestGetMetricsBreakdown extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "dimensions",
      "granularity",
      "metric_scope",
      "order_by",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetMetricsBreakdown.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetMetricsBreakdown(String nodeId, APIContext context) {
      super(context, nodeId, "/metrics_breakdown", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMetricsBreakdown setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMetricsBreakdown setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMetricsBreakdown setDimensions (List<EnumDimensions> dimensions) {
      this.setParam("dimensions", dimensions);
      return this;
    }
    public APIRequestGetMetricsBreakdown setDimensions (String dimensions) {
      this.setParam("dimensions", dimensions);
      return this;
    }

    public APIRequestGetMetricsBreakdown setGranularity (EnumGranularity granularity) {
      this.setParam("granularity", granularity);
      return this;
    }
    public APIRequestGetMetricsBreakdown setGranularity (String granularity) {
      this.setParam("granularity", granularity);
      return this;
    }

    public APIRequestGetMetricsBreakdown setMetricScope (Map<String, String> metricScope) {
      this.setParam("metric_scope", metricScope);
      return this;
    }
    public APIRequestGetMetricsBreakdown setMetricScope (String metricScope) {
      this.setParam("metric_scope", metricScope);
      return this;
    }

    public APIRequestGetMetricsBreakdown setOrderBy (List<Map<String, String>> orderBy) {
      this.setParam("order_by", orderBy);
      return this;
    }
    public APIRequestGetMetricsBreakdown setOrderBy (String orderBy) {
      this.setParam("order_by", orderBy);
      return this;
    }

    public APIRequestGetMetricsBreakdown requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMetricsBreakdown requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMetricsBreakdown requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMetricsBreakdown requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMetricsBreakdown requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMetricsBreakdown requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetSources extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filter_by",
      "metric_scope",
      "order_by",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetSources.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetSources(String nodeId, APIContext context) {
      super(context, nodeId, "/sources", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSources setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSources setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSources setFilterBy (String filterBy) {
      this.setParam("filter_by", filterBy);
      return this;
    }

    public APIRequestGetSources setMetricScope (Map<String, String> metricScope) {
      this.setParam("metric_scope", metricScope);
      return this;
    }
    public APIRequestGetSources setMetricScope (String metricScope) {
      this.setParam("metric_scope", metricScope);
      return this;
    }

    public APIRequestGetSources setOrderBy (String orderBy) {
      this.setParam("order_by", orderBy);
      return this;
    }

    public APIRequestGetSources requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSources requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSources requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSources requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSources requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSources requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<AtlasCampaign> {

    AtlasCampaign lastResponse = null;
    @Override
    public AtlasCampaign getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "metric_scope",
    };

    public static final String[] FIELDS = {
      "ad_platform",
      "alias",
      "cost_per_1k_impressions",
      "cost_per_click",
      "cost_per_visit",
      "created_by",
      "created_date",
      "data_driven_convs",
      "data_driven_convs_per_1k_impress",
      "data_driven_convs_per_click",
      "data_driven_convs_per_visit",
      "data_driven_cpa",
      "data_driven_nullable_convs",
      "data_driven_revenue",
      "data_driven_roas",
      "even_credit_convs",
      "even_credit_convs_per_1k_impress",
      "even_credit_convs_per_click",
      "even_credit_convs_per_visit",
      "even_credit_cpa",
      "even_credit_revenue",
      "even_credit_roas",
      "first_click_convs",
      "first_click_convs_per_1k_impress",
      "first_click_convs_per_click",
      "first_click_convs_per_visit",
      "first_click_cpa",
      "first_click_revenue",
      "first_click_roas",
      "first_touch_convs",
      "first_touch_convs_per_1k_impress",
      "first_touch_convs_per_click",
      "first_touch_convs_per_visit",
      "first_touch_cpa",
      "first_touch_revenue",
      "first_touch_roas",
      "id",
      "is_archived",
      "last_click_convs",
      "last_click_convs_per_1k_impress",
      "last_click_convs_per_click",
      "last_click_convs_per_visit",
      "last_click_cpa",
      "last_click_revenue",
      "last_click_roas",
      "last_click_with_extrapolation_convs",
      "last_click_with_extrapolation_convs_per_100_clicks",
      "last_click_with_extrapolation_convs_per_1k_impress",
      "last_click_with_extrapolation_convs_per_click",
      "last_click_with_extrapolation_convs_per_visit",
      "last_click_with_extrapolation_cpa",
      "last_click_with_extrapolation_revenue",
      "last_click_with_extrapolation_roas",
      "last_click_with_extrapolation_unattributed",
      "last_modified_by",
      "last_modified_date",
      "last_touch_convs",
      "last_touch_convs_per_1k_impress",
      "last_touch_convs_per_click",
      "last_touch_convs_per_visit",
      "last_touch_cpa",
      "last_touch_revenue",
      "last_touch_roas",
      "name",
      "net_media_cost",
      "positional_30fl_convs",
      "positional_30fl_convs_per_1k_impress",
      "positional_30fl_convs_per_click",
      "positional_30fl_convs_per_visit",
      "positional_30fl_cpa",
      "positional_30fl_revenue",
      "positional_30fl_roas",
      "positional_40fl_convs",
      "positional_40fl_convs_per_1k_impress",
      "positional_40fl_convs_per_click",
      "positional_40fl_convs_per_visit",
      "positional_40fl_cpa",
      "positional_40fl_revenue",
      "positional_40fl_roas",
      "report_click_through_rate",
      "report_clicks",
      "report_impressions",
      "report_visits",
      "time_decay_1day_convs",
      "time_decay_1day_convs_per_1k_impress",
      "time_decay_1day_convs_per_click",
      "time_decay_1day_convs_per_visit",
      "time_decay_1day_cpa",
      "time_decay_1day_revenue",
      "time_decay_1day_roas",
      "time_decay_7day_convs",
      "time_decay_7day_convs_per_1k_impress",
      "time_decay_7day_convs_per_click",
      "time_decay_7day_convs_per_visit",
      "time_decay_7day_cpa",
      "time_decay_7day_revenue",
      "time_decay_7day_roas",
      "type",
    };

    @Override
    public AtlasCampaign parseResponse(String response, String header) throws APIException {
      return AtlasCampaign.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AtlasCampaign execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AtlasCampaign execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AtlasCampaign> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AtlasCampaign> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AtlasCampaign>() {
           public AtlasCampaign apply(ResponseWrapper result) {
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


    public APIRequestGet setMetricScope (Map<String, String> metricScope) {
      this.setParam("metric_scope", metricScope);
      return this;
    }
    public APIRequestGet setMetricScope (String metricScope) {
      this.setParam("metric_scope", metricScope);
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

    public APIRequestGet requestAdPlatformField () {
      return this.requestAdPlatformField(true);
    }
    public APIRequestGet requestAdPlatformField (boolean value) {
      this.requestField("ad_platform", value);
      return this;
    }
    public APIRequestGet requestAliasField () {
      return this.requestAliasField(true);
    }
    public APIRequestGet requestAliasField (boolean value) {
      this.requestField("alias", value);
      return this;
    }
    public APIRequestGet requestCostPer1kImpressionsField () {
      return this.requestCostPer1kImpressionsField(true);
    }
    public APIRequestGet requestCostPer1kImpressionsField (boolean value) {
      this.requestField("cost_per_1k_impressions", value);
      return this;
    }
    public APIRequestGet requestCostPerClickField () {
      return this.requestCostPerClickField(true);
    }
    public APIRequestGet requestCostPerClickField (boolean value) {
      this.requestField("cost_per_click", value);
      return this;
    }
    public APIRequestGet requestCostPerVisitField () {
      return this.requestCostPerVisitField(true);
    }
    public APIRequestGet requestCostPerVisitField (boolean value) {
      this.requestField("cost_per_visit", value);
      return this;
    }
    public APIRequestGet requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGet requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGet requestCreatedDateField () {
      return this.requestCreatedDateField(true);
    }
    public APIRequestGet requestCreatedDateField (boolean value) {
      this.requestField("created_date", value);
      return this;
    }
    public APIRequestGet requestDataDrivenConvsField () {
      return this.requestDataDrivenConvsField(true);
    }
    public APIRequestGet requestDataDrivenConvsField (boolean value) {
      this.requestField("data_driven_convs", value);
      return this;
    }
    public APIRequestGet requestDataDrivenConvsPer1kImpressField () {
      return this.requestDataDrivenConvsPer1kImpressField(true);
    }
    public APIRequestGet requestDataDrivenConvsPer1kImpressField (boolean value) {
      this.requestField("data_driven_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGet requestDataDrivenConvsPerClickField () {
      return this.requestDataDrivenConvsPerClickField(true);
    }
    public APIRequestGet requestDataDrivenConvsPerClickField (boolean value) {
      this.requestField("data_driven_convs_per_click", value);
      return this;
    }
    public APIRequestGet requestDataDrivenConvsPerVisitField () {
      return this.requestDataDrivenConvsPerVisitField(true);
    }
    public APIRequestGet requestDataDrivenConvsPerVisitField (boolean value) {
      this.requestField("data_driven_convs_per_visit", value);
      return this;
    }
    public APIRequestGet requestDataDrivenCpaField () {
      return this.requestDataDrivenCpaField(true);
    }
    public APIRequestGet requestDataDrivenCpaField (boolean value) {
      this.requestField("data_driven_cpa", value);
      return this;
    }
    public APIRequestGet requestDataDrivenNullableConvsField () {
      return this.requestDataDrivenNullableConvsField(true);
    }
    public APIRequestGet requestDataDrivenNullableConvsField (boolean value) {
      this.requestField("data_driven_nullable_convs", value);
      return this;
    }
    public APIRequestGet requestDataDrivenRevenueField () {
      return this.requestDataDrivenRevenueField(true);
    }
    public APIRequestGet requestDataDrivenRevenueField (boolean value) {
      this.requestField("data_driven_revenue", value);
      return this;
    }
    public APIRequestGet requestDataDrivenRoasField () {
      return this.requestDataDrivenRoasField(true);
    }
    public APIRequestGet requestDataDrivenRoasField (boolean value) {
      this.requestField("data_driven_roas", value);
      return this;
    }
    public APIRequestGet requestEvenCreditConvsField () {
      return this.requestEvenCreditConvsField(true);
    }
    public APIRequestGet requestEvenCreditConvsField (boolean value) {
      this.requestField("even_credit_convs", value);
      return this;
    }
    public APIRequestGet requestEvenCreditConvsPer1kImpressField () {
      return this.requestEvenCreditConvsPer1kImpressField(true);
    }
    public APIRequestGet requestEvenCreditConvsPer1kImpressField (boolean value) {
      this.requestField("even_credit_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGet requestEvenCreditConvsPerClickField () {
      return this.requestEvenCreditConvsPerClickField(true);
    }
    public APIRequestGet requestEvenCreditConvsPerClickField (boolean value) {
      this.requestField("even_credit_convs_per_click", value);
      return this;
    }
    public APIRequestGet requestEvenCreditConvsPerVisitField () {
      return this.requestEvenCreditConvsPerVisitField(true);
    }
    public APIRequestGet requestEvenCreditConvsPerVisitField (boolean value) {
      this.requestField("even_credit_convs_per_visit", value);
      return this;
    }
    public APIRequestGet requestEvenCreditCpaField () {
      return this.requestEvenCreditCpaField(true);
    }
    public APIRequestGet requestEvenCreditCpaField (boolean value) {
      this.requestField("even_credit_cpa", value);
      return this;
    }
    public APIRequestGet requestEvenCreditRevenueField () {
      return this.requestEvenCreditRevenueField(true);
    }
    public APIRequestGet requestEvenCreditRevenueField (boolean value) {
      this.requestField("even_credit_revenue", value);
      return this;
    }
    public APIRequestGet requestEvenCreditRoasField () {
      return this.requestEvenCreditRoasField(true);
    }
    public APIRequestGet requestEvenCreditRoasField (boolean value) {
      this.requestField("even_credit_roas", value);
      return this;
    }
    public APIRequestGet requestFirstClickConvsField () {
      return this.requestFirstClickConvsField(true);
    }
    public APIRequestGet requestFirstClickConvsField (boolean value) {
      this.requestField("first_click_convs", value);
      return this;
    }
    public APIRequestGet requestFirstClickConvsPer1kImpressField () {
      return this.requestFirstClickConvsPer1kImpressField(true);
    }
    public APIRequestGet requestFirstClickConvsPer1kImpressField (boolean value) {
      this.requestField("first_click_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGet requestFirstClickConvsPerClickField () {
      return this.requestFirstClickConvsPerClickField(true);
    }
    public APIRequestGet requestFirstClickConvsPerClickField (boolean value) {
      this.requestField("first_click_convs_per_click", value);
      return this;
    }
    public APIRequestGet requestFirstClickConvsPerVisitField () {
      return this.requestFirstClickConvsPerVisitField(true);
    }
    public APIRequestGet requestFirstClickConvsPerVisitField (boolean value) {
      this.requestField("first_click_convs_per_visit", value);
      return this;
    }
    public APIRequestGet requestFirstClickCpaField () {
      return this.requestFirstClickCpaField(true);
    }
    public APIRequestGet requestFirstClickCpaField (boolean value) {
      this.requestField("first_click_cpa", value);
      return this;
    }
    public APIRequestGet requestFirstClickRevenueField () {
      return this.requestFirstClickRevenueField(true);
    }
    public APIRequestGet requestFirstClickRevenueField (boolean value) {
      this.requestField("first_click_revenue", value);
      return this;
    }
    public APIRequestGet requestFirstClickRoasField () {
      return this.requestFirstClickRoasField(true);
    }
    public APIRequestGet requestFirstClickRoasField (boolean value) {
      this.requestField("first_click_roas", value);
      return this;
    }
    public APIRequestGet requestFirstTouchConvsField () {
      return this.requestFirstTouchConvsField(true);
    }
    public APIRequestGet requestFirstTouchConvsField (boolean value) {
      this.requestField("first_touch_convs", value);
      return this;
    }
    public APIRequestGet requestFirstTouchConvsPer1kImpressField () {
      return this.requestFirstTouchConvsPer1kImpressField(true);
    }
    public APIRequestGet requestFirstTouchConvsPer1kImpressField (boolean value) {
      this.requestField("first_touch_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGet requestFirstTouchConvsPerClickField () {
      return this.requestFirstTouchConvsPerClickField(true);
    }
    public APIRequestGet requestFirstTouchConvsPerClickField (boolean value) {
      this.requestField("first_touch_convs_per_click", value);
      return this;
    }
    public APIRequestGet requestFirstTouchConvsPerVisitField () {
      return this.requestFirstTouchConvsPerVisitField(true);
    }
    public APIRequestGet requestFirstTouchConvsPerVisitField (boolean value) {
      this.requestField("first_touch_convs_per_visit", value);
      return this;
    }
    public APIRequestGet requestFirstTouchCpaField () {
      return this.requestFirstTouchCpaField(true);
    }
    public APIRequestGet requestFirstTouchCpaField (boolean value) {
      this.requestField("first_touch_cpa", value);
      return this;
    }
    public APIRequestGet requestFirstTouchRevenueField () {
      return this.requestFirstTouchRevenueField(true);
    }
    public APIRequestGet requestFirstTouchRevenueField (boolean value) {
      this.requestField("first_touch_revenue", value);
      return this;
    }
    public APIRequestGet requestFirstTouchRoasField () {
      return this.requestFirstTouchRoasField(true);
    }
    public APIRequestGet requestFirstTouchRoasField (boolean value) {
      this.requestField("first_touch_roas", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsArchivedField () {
      return this.requestIsArchivedField(true);
    }
    public APIRequestGet requestIsArchivedField (boolean value) {
      this.requestField("is_archived", value);
      return this;
    }
    public APIRequestGet requestLastClickConvsField () {
      return this.requestLastClickConvsField(true);
    }
    public APIRequestGet requestLastClickConvsField (boolean value) {
      this.requestField("last_click_convs", value);
      return this;
    }
    public APIRequestGet requestLastClickConvsPer1kImpressField () {
      return this.requestLastClickConvsPer1kImpressField(true);
    }
    public APIRequestGet requestLastClickConvsPer1kImpressField (boolean value) {
      this.requestField("last_click_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGet requestLastClickConvsPerClickField () {
      return this.requestLastClickConvsPerClickField(true);
    }
    public APIRequestGet requestLastClickConvsPerClickField (boolean value) {
      this.requestField("last_click_convs_per_click", value);
      return this;
    }
    public APIRequestGet requestLastClickConvsPerVisitField () {
      return this.requestLastClickConvsPerVisitField(true);
    }
    public APIRequestGet requestLastClickConvsPerVisitField (boolean value) {
      this.requestField("last_click_convs_per_visit", value);
      return this;
    }
    public APIRequestGet requestLastClickCpaField () {
      return this.requestLastClickCpaField(true);
    }
    public APIRequestGet requestLastClickCpaField (boolean value) {
      this.requestField("last_click_cpa", value);
      return this;
    }
    public APIRequestGet requestLastClickRevenueField () {
      return this.requestLastClickRevenueField(true);
    }
    public APIRequestGet requestLastClickRevenueField (boolean value) {
      this.requestField("last_click_revenue", value);
      return this;
    }
    public APIRequestGet requestLastClickRoasField () {
      return this.requestLastClickRoasField(true);
    }
    public APIRequestGet requestLastClickRoasField (boolean value) {
      this.requestField("last_click_roas", value);
      return this;
    }
    public APIRequestGet requestLastClickWithExtrapolationConvsField () {
      return this.requestLastClickWithExtrapolationConvsField(true);
    }
    public APIRequestGet requestLastClickWithExtrapolationConvsField (boolean value) {
      this.requestField("last_click_with_extrapolation_convs", value);
      return this;
    }
    public APIRequestGet requestLastClickWithExtrapolationConvsPer100ClicksField () {
      return this.requestLastClickWithExtrapolationConvsPer100ClicksField(true);
    }
    public APIRequestGet requestLastClickWithExtrapolationConvsPer100ClicksField (boolean value) {
      this.requestField("last_click_with_extrapolation_convs_per_100_clicks", value);
      return this;
    }
    public APIRequestGet requestLastClickWithExtrapolationConvsPer1kImpressField () {
      return this.requestLastClickWithExtrapolationConvsPer1kImpressField(true);
    }
    public APIRequestGet requestLastClickWithExtrapolationConvsPer1kImpressField (boolean value) {
      this.requestField("last_click_with_extrapolation_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGet requestLastClickWithExtrapolationConvsPerClickField () {
      return this.requestLastClickWithExtrapolationConvsPerClickField(true);
    }
    public APIRequestGet requestLastClickWithExtrapolationConvsPerClickField (boolean value) {
      this.requestField("last_click_with_extrapolation_convs_per_click", value);
      return this;
    }
    public APIRequestGet requestLastClickWithExtrapolationConvsPerVisitField () {
      return this.requestLastClickWithExtrapolationConvsPerVisitField(true);
    }
    public APIRequestGet requestLastClickWithExtrapolationConvsPerVisitField (boolean value) {
      this.requestField("last_click_with_extrapolation_convs_per_visit", value);
      return this;
    }
    public APIRequestGet requestLastClickWithExtrapolationCpaField () {
      return this.requestLastClickWithExtrapolationCpaField(true);
    }
    public APIRequestGet requestLastClickWithExtrapolationCpaField (boolean value) {
      this.requestField("last_click_with_extrapolation_cpa", value);
      return this;
    }
    public APIRequestGet requestLastClickWithExtrapolationRevenueField () {
      return this.requestLastClickWithExtrapolationRevenueField(true);
    }
    public APIRequestGet requestLastClickWithExtrapolationRevenueField (boolean value) {
      this.requestField("last_click_with_extrapolation_revenue", value);
      return this;
    }
    public APIRequestGet requestLastClickWithExtrapolationRoasField () {
      return this.requestLastClickWithExtrapolationRoasField(true);
    }
    public APIRequestGet requestLastClickWithExtrapolationRoasField (boolean value) {
      this.requestField("last_click_with_extrapolation_roas", value);
      return this;
    }
    public APIRequestGet requestLastClickWithExtrapolationUnattributedField () {
      return this.requestLastClickWithExtrapolationUnattributedField(true);
    }
    public APIRequestGet requestLastClickWithExtrapolationUnattributedField (boolean value) {
      this.requestField("last_click_with_extrapolation_unattributed", value);
      return this;
    }
    public APIRequestGet requestLastModifiedByField () {
      return this.requestLastModifiedByField(true);
    }
    public APIRequestGet requestLastModifiedByField (boolean value) {
      this.requestField("last_modified_by", value);
      return this;
    }
    public APIRequestGet requestLastModifiedDateField () {
      return this.requestLastModifiedDateField(true);
    }
    public APIRequestGet requestLastModifiedDateField (boolean value) {
      this.requestField("last_modified_date", value);
      return this;
    }
    public APIRequestGet requestLastTouchConvsField () {
      return this.requestLastTouchConvsField(true);
    }
    public APIRequestGet requestLastTouchConvsField (boolean value) {
      this.requestField("last_touch_convs", value);
      return this;
    }
    public APIRequestGet requestLastTouchConvsPer1kImpressField () {
      return this.requestLastTouchConvsPer1kImpressField(true);
    }
    public APIRequestGet requestLastTouchConvsPer1kImpressField (boolean value) {
      this.requestField("last_touch_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGet requestLastTouchConvsPerClickField () {
      return this.requestLastTouchConvsPerClickField(true);
    }
    public APIRequestGet requestLastTouchConvsPerClickField (boolean value) {
      this.requestField("last_touch_convs_per_click", value);
      return this;
    }
    public APIRequestGet requestLastTouchConvsPerVisitField () {
      return this.requestLastTouchConvsPerVisitField(true);
    }
    public APIRequestGet requestLastTouchConvsPerVisitField (boolean value) {
      this.requestField("last_touch_convs_per_visit", value);
      return this;
    }
    public APIRequestGet requestLastTouchCpaField () {
      return this.requestLastTouchCpaField(true);
    }
    public APIRequestGet requestLastTouchCpaField (boolean value) {
      this.requestField("last_touch_cpa", value);
      return this;
    }
    public APIRequestGet requestLastTouchRevenueField () {
      return this.requestLastTouchRevenueField(true);
    }
    public APIRequestGet requestLastTouchRevenueField (boolean value) {
      this.requestField("last_touch_revenue", value);
      return this;
    }
    public APIRequestGet requestLastTouchRoasField () {
      return this.requestLastTouchRoasField(true);
    }
    public APIRequestGet requestLastTouchRoasField (boolean value) {
      this.requestField("last_touch_roas", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestNetMediaCostField () {
      return this.requestNetMediaCostField(true);
    }
    public APIRequestGet requestNetMediaCostField (boolean value) {
      this.requestField("net_media_cost", value);
      return this;
    }
    public APIRequestGet requestPositional30flConvsField () {
      return this.requestPositional30flConvsField(true);
    }
    public APIRequestGet requestPositional30flConvsField (boolean value) {
      this.requestField("positional_30fl_convs", value);
      return this;
    }
    public APIRequestGet requestPositional30flConvsPer1kImpressField () {
      return this.requestPositional30flConvsPer1kImpressField(true);
    }
    public APIRequestGet requestPositional30flConvsPer1kImpressField (boolean value) {
      this.requestField("positional_30fl_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGet requestPositional30flConvsPerClickField () {
      return this.requestPositional30flConvsPerClickField(true);
    }
    public APIRequestGet requestPositional30flConvsPerClickField (boolean value) {
      this.requestField("positional_30fl_convs_per_click", value);
      return this;
    }
    public APIRequestGet requestPositional30flConvsPerVisitField () {
      return this.requestPositional30flConvsPerVisitField(true);
    }
    public APIRequestGet requestPositional30flConvsPerVisitField (boolean value) {
      this.requestField("positional_30fl_convs_per_visit", value);
      return this;
    }
    public APIRequestGet requestPositional30flCpaField () {
      return this.requestPositional30flCpaField(true);
    }
    public APIRequestGet requestPositional30flCpaField (boolean value) {
      this.requestField("positional_30fl_cpa", value);
      return this;
    }
    public APIRequestGet requestPositional30flRevenueField () {
      return this.requestPositional30flRevenueField(true);
    }
    public APIRequestGet requestPositional30flRevenueField (boolean value) {
      this.requestField("positional_30fl_revenue", value);
      return this;
    }
    public APIRequestGet requestPositional30flRoasField () {
      return this.requestPositional30flRoasField(true);
    }
    public APIRequestGet requestPositional30flRoasField (boolean value) {
      this.requestField("positional_30fl_roas", value);
      return this;
    }
    public APIRequestGet requestPositional40flConvsField () {
      return this.requestPositional40flConvsField(true);
    }
    public APIRequestGet requestPositional40flConvsField (boolean value) {
      this.requestField("positional_40fl_convs", value);
      return this;
    }
    public APIRequestGet requestPositional40flConvsPer1kImpressField () {
      return this.requestPositional40flConvsPer1kImpressField(true);
    }
    public APIRequestGet requestPositional40flConvsPer1kImpressField (boolean value) {
      this.requestField("positional_40fl_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGet requestPositional40flConvsPerClickField () {
      return this.requestPositional40flConvsPerClickField(true);
    }
    public APIRequestGet requestPositional40flConvsPerClickField (boolean value) {
      this.requestField("positional_40fl_convs_per_click", value);
      return this;
    }
    public APIRequestGet requestPositional40flConvsPerVisitField () {
      return this.requestPositional40flConvsPerVisitField(true);
    }
    public APIRequestGet requestPositional40flConvsPerVisitField (boolean value) {
      this.requestField("positional_40fl_convs_per_visit", value);
      return this;
    }
    public APIRequestGet requestPositional40flCpaField () {
      return this.requestPositional40flCpaField(true);
    }
    public APIRequestGet requestPositional40flCpaField (boolean value) {
      this.requestField("positional_40fl_cpa", value);
      return this;
    }
    public APIRequestGet requestPositional40flRevenueField () {
      return this.requestPositional40flRevenueField(true);
    }
    public APIRequestGet requestPositional40flRevenueField (boolean value) {
      this.requestField("positional_40fl_revenue", value);
      return this;
    }
    public APIRequestGet requestPositional40flRoasField () {
      return this.requestPositional40flRoasField(true);
    }
    public APIRequestGet requestPositional40flRoasField (boolean value) {
      this.requestField("positional_40fl_roas", value);
      return this;
    }
    public APIRequestGet requestReportClickThroughRateField () {
      return this.requestReportClickThroughRateField(true);
    }
    public APIRequestGet requestReportClickThroughRateField (boolean value) {
      this.requestField("report_click_through_rate", value);
      return this;
    }
    public APIRequestGet requestReportClicksField () {
      return this.requestReportClicksField(true);
    }
    public APIRequestGet requestReportClicksField (boolean value) {
      this.requestField("report_clicks", value);
      return this;
    }
    public APIRequestGet requestReportImpressionsField () {
      return this.requestReportImpressionsField(true);
    }
    public APIRequestGet requestReportImpressionsField (boolean value) {
      this.requestField("report_impressions", value);
      return this;
    }
    public APIRequestGet requestReportVisitsField () {
      return this.requestReportVisitsField(true);
    }
    public APIRequestGet requestReportVisitsField (boolean value) {
      this.requestField("report_visits", value);
      return this;
    }
    public APIRequestGet requestTimeDecay1dayConvsField () {
      return this.requestTimeDecay1dayConvsField(true);
    }
    public APIRequestGet requestTimeDecay1dayConvsField (boolean value) {
      this.requestField("time_decay_1day_convs", value);
      return this;
    }
    public APIRequestGet requestTimeDecay1dayConvsPer1kImpressField () {
      return this.requestTimeDecay1dayConvsPer1kImpressField(true);
    }
    public APIRequestGet requestTimeDecay1dayConvsPer1kImpressField (boolean value) {
      this.requestField("time_decay_1day_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGet requestTimeDecay1dayConvsPerClickField () {
      return this.requestTimeDecay1dayConvsPerClickField(true);
    }
    public APIRequestGet requestTimeDecay1dayConvsPerClickField (boolean value) {
      this.requestField("time_decay_1day_convs_per_click", value);
      return this;
    }
    public APIRequestGet requestTimeDecay1dayConvsPerVisitField () {
      return this.requestTimeDecay1dayConvsPerVisitField(true);
    }
    public APIRequestGet requestTimeDecay1dayConvsPerVisitField (boolean value) {
      this.requestField("time_decay_1day_convs_per_visit", value);
      return this;
    }
    public APIRequestGet requestTimeDecay1dayCpaField () {
      return this.requestTimeDecay1dayCpaField(true);
    }
    public APIRequestGet requestTimeDecay1dayCpaField (boolean value) {
      this.requestField("time_decay_1day_cpa", value);
      return this;
    }
    public APIRequestGet requestTimeDecay1dayRevenueField () {
      return this.requestTimeDecay1dayRevenueField(true);
    }
    public APIRequestGet requestTimeDecay1dayRevenueField (boolean value) {
      this.requestField("time_decay_1day_revenue", value);
      return this;
    }
    public APIRequestGet requestTimeDecay1dayRoasField () {
      return this.requestTimeDecay1dayRoasField(true);
    }
    public APIRequestGet requestTimeDecay1dayRoasField (boolean value) {
      this.requestField("time_decay_1day_roas", value);
      return this;
    }
    public APIRequestGet requestTimeDecay7dayConvsField () {
      return this.requestTimeDecay7dayConvsField(true);
    }
    public APIRequestGet requestTimeDecay7dayConvsField (boolean value) {
      this.requestField("time_decay_7day_convs", value);
      return this;
    }
    public APIRequestGet requestTimeDecay7dayConvsPer1kImpressField () {
      return this.requestTimeDecay7dayConvsPer1kImpressField(true);
    }
    public APIRequestGet requestTimeDecay7dayConvsPer1kImpressField (boolean value) {
      this.requestField("time_decay_7day_convs_per_1k_impress", value);
      return this;
    }
    public APIRequestGet requestTimeDecay7dayConvsPerClickField () {
      return this.requestTimeDecay7dayConvsPerClickField(true);
    }
    public APIRequestGet requestTimeDecay7dayConvsPerClickField (boolean value) {
      this.requestField("time_decay_7day_convs_per_click", value);
      return this;
    }
    public APIRequestGet requestTimeDecay7dayConvsPerVisitField () {
      return this.requestTimeDecay7dayConvsPerVisitField(true);
    }
    public APIRequestGet requestTimeDecay7dayConvsPerVisitField (boolean value) {
      this.requestField("time_decay_7day_convs_per_visit", value);
      return this;
    }
    public APIRequestGet requestTimeDecay7dayCpaField () {
      return this.requestTimeDecay7dayCpaField(true);
    }
    public APIRequestGet requestTimeDecay7dayCpaField (boolean value) {
      this.requestField("time_decay_7day_cpa", value);
      return this;
    }
    public APIRequestGet requestTimeDecay7dayRevenueField () {
      return this.requestTimeDecay7dayRevenueField(true);
    }
    public APIRequestGet requestTimeDecay7dayRevenueField (boolean value) {
      this.requestField("time_decay_7day_revenue", value);
      return this;
    }
    public APIRequestGet requestTimeDecay7dayRoasField () {
      return this.requestTimeDecay7dayRoasField(true);
    }
    public APIRequestGet requestTimeDecay7dayRoasField (boolean value) {
      this.requestField("time_decay_7day_roas", value);
      return this;
    }
    public APIRequestGet requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGet requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
  }

  public static enum EnumDimensions {
      @SerializedName("AD_ID")
      VALUE_AD_ID("AD_ID"),
      @SerializedName("AD_SET_ID")
      VALUE_AD_SET_ID("AD_SET_ID"),
      @SerializedName("CAMPAIGN_ID")
      VALUE_CAMPAIGN_ID("CAMPAIGN_ID"),
      @SerializedName("DEVICE_TYPE")
      VALUE_DEVICE_TYPE("DEVICE_TYPE"),
      @SerializedName("SOURCE_CHANNEL")
      VALUE_SOURCE_CHANNEL("SOURCE_CHANNEL"),
      ;

      private String value;

      private EnumDimensions(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumGranularity {
      @SerializedName("DAY")
      VALUE_DAY("DAY"),
      @SerializedName("HOUR")
      VALUE_HOUR("HOUR"),
      @SerializedName("MONTH")
      VALUE_MONTH("MONTH"),
      @SerializedName("WEEK_SUNDAY")
      VALUE_WEEK_SUNDAY("WEEK_SUNDAY"),
      @SerializedName("YEAR")
      VALUE_YEAR("YEAR"),
      ;

      private String value;

      private EnumGranularity(String value) {
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

  public AtlasCampaign copyFrom(AtlasCampaign instance) {
    this.mAdPlatform = instance.mAdPlatform;
    this.mAlias = instance.mAlias;
    this.mCostPer1kImpressions = instance.mCostPer1kImpressions;
    this.mCostPerClick = instance.mCostPerClick;
    this.mCostPerVisit = instance.mCostPerVisit;
    this.mCreatedBy = instance.mCreatedBy;
    this.mCreatedDate = instance.mCreatedDate;
    this.mDataDrivenConvs = instance.mDataDrivenConvs;
    this.mDataDrivenConvsPer1kImpress = instance.mDataDrivenConvsPer1kImpress;
    this.mDataDrivenConvsPerClick = instance.mDataDrivenConvsPerClick;
    this.mDataDrivenConvsPerVisit = instance.mDataDrivenConvsPerVisit;
    this.mDataDrivenCpa = instance.mDataDrivenCpa;
    this.mDataDrivenNullableConvs = instance.mDataDrivenNullableConvs;
    this.mDataDrivenRevenue = instance.mDataDrivenRevenue;
    this.mDataDrivenRoas = instance.mDataDrivenRoas;
    this.mEvenCreditConvs = instance.mEvenCreditConvs;
    this.mEvenCreditConvsPer1kImpress = instance.mEvenCreditConvsPer1kImpress;
    this.mEvenCreditConvsPerClick = instance.mEvenCreditConvsPerClick;
    this.mEvenCreditConvsPerVisit = instance.mEvenCreditConvsPerVisit;
    this.mEvenCreditCpa = instance.mEvenCreditCpa;
    this.mEvenCreditRevenue = instance.mEvenCreditRevenue;
    this.mEvenCreditRoas = instance.mEvenCreditRoas;
    this.mFirstClickConvs = instance.mFirstClickConvs;
    this.mFirstClickConvsPer1kImpress = instance.mFirstClickConvsPer1kImpress;
    this.mFirstClickConvsPerClick = instance.mFirstClickConvsPerClick;
    this.mFirstClickConvsPerVisit = instance.mFirstClickConvsPerVisit;
    this.mFirstClickCpa = instance.mFirstClickCpa;
    this.mFirstClickRevenue = instance.mFirstClickRevenue;
    this.mFirstClickRoas = instance.mFirstClickRoas;
    this.mFirstTouchConvs = instance.mFirstTouchConvs;
    this.mFirstTouchConvsPer1kImpress = instance.mFirstTouchConvsPer1kImpress;
    this.mFirstTouchConvsPerClick = instance.mFirstTouchConvsPerClick;
    this.mFirstTouchConvsPerVisit = instance.mFirstTouchConvsPerVisit;
    this.mFirstTouchCpa = instance.mFirstTouchCpa;
    this.mFirstTouchRevenue = instance.mFirstTouchRevenue;
    this.mFirstTouchRoas = instance.mFirstTouchRoas;
    this.mId = instance.mId;
    this.mIsArchived = instance.mIsArchived;
    this.mLastClickConvs = instance.mLastClickConvs;
    this.mLastClickConvsPer1kImpress = instance.mLastClickConvsPer1kImpress;
    this.mLastClickConvsPerClick = instance.mLastClickConvsPerClick;
    this.mLastClickConvsPerVisit = instance.mLastClickConvsPerVisit;
    this.mLastClickCpa = instance.mLastClickCpa;
    this.mLastClickRevenue = instance.mLastClickRevenue;
    this.mLastClickRoas = instance.mLastClickRoas;
    this.mLastClickWithExtrapolationConvs = instance.mLastClickWithExtrapolationConvs;
    this.mLastClickWithExtrapolationConvsPer100Clicks = instance.mLastClickWithExtrapolationConvsPer100Clicks;
    this.mLastClickWithExtrapolationConvsPer1kImpress = instance.mLastClickWithExtrapolationConvsPer1kImpress;
    this.mLastClickWithExtrapolationConvsPerClick = instance.mLastClickWithExtrapolationConvsPerClick;
    this.mLastClickWithExtrapolationConvsPerVisit = instance.mLastClickWithExtrapolationConvsPerVisit;
    this.mLastClickWithExtrapolationCpa = instance.mLastClickWithExtrapolationCpa;
    this.mLastClickWithExtrapolationRevenue = instance.mLastClickWithExtrapolationRevenue;
    this.mLastClickWithExtrapolationRoas = instance.mLastClickWithExtrapolationRoas;
    this.mLastClickWithExtrapolationUnattributed = instance.mLastClickWithExtrapolationUnattributed;
    this.mLastModifiedBy = instance.mLastModifiedBy;
    this.mLastModifiedDate = instance.mLastModifiedDate;
    this.mLastTouchConvs = instance.mLastTouchConvs;
    this.mLastTouchConvsPer1kImpress = instance.mLastTouchConvsPer1kImpress;
    this.mLastTouchConvsPerClick = instance.mLastTouchConvsPerClick;
    this.mLastTouchConvsPerVisit = instance.mLastTouchConvsPerVisit;
    this.mLastTouchCpa = instance.mLastTouchCpa;
    this.mLastTouchRevenue = instance.mLastTouchRevenue;
    this.mLastTouchRoas = instance.mLastTouchRoas;
    this.mName = instance.mName;
    this.mNetMediaCost = instance.mNetMediaCost;
    this.mPositional30flConvs = instance.mPositional30flConvs;
    this.mPositional30flConvsPer1kImpress = instance.mPositional30flConvsPer1kImpress;
    this.mPositional30flConvsPerClick = instance.mPositional30flConvsPerClick;
    this.mPositional30flConvsPerVisit = instance.mPositional30flConvsPerVisit;
    this.mPositional30flCpa = instance.mPositional30flCpa;
    this.mPositional30flRevenue = instance.mPositional30flRevenue;
    this.mPositional30flRoas = instance.mPositional30flRoas;
    this.mPositional40flConvs = instance.mPositional40flConvs;
    this.mPositional40flConvsPer1kImpress = instance.mPositional40flConvsPer1kImpress;
    this.mPositional40flConvsPerClick = instance.mPositional40flConvsPerClick;
    this.mPositional40flConvsPerVisit = instance.mPositional40flConvsPerVisit;
    this.mPositional40flCpa = instance.mPositional40flCpa;
    this.mPositional40flRevenue = instance.mPositional40flRevenue;
    this.mPositional40flRoas = instance.mPositional40flRoas;
    this.mReportClickThroughRate = instance.mReportClickThroughRate;
    this.mReportClicks = instance.mReportClicks;
    this.mReportImpressions = instance.mReportImpressions;
    this.mReportVisits = instance.mReportVisits;
    this.mTimeDecay1dayConvs = instance.mTimeDecay1dayConvs;
    this.mTimeDecay1dayConvsPer1kImpress = instance.mTimeDecay1dayConvsPer1kImpress;
    this.mTimeDecay1dayConvsPerClick = instance.mTimeDecay1dayConvsPerClick;
    this.mTimeDecay1dayConvsPerVisit = instance.mTimeDecay1dayConvsPerVisit;
    this.mTimeDecay1dayCpa = instance.mTimeDecay1dayCpa;
    this.mTimeDecay1dayRevenue = instance.mTimeDecay1dayRevenue;
    this.mTimeDecay1dayRoas = instance.mTimeDecay1dayRoas;
    this.mTimeDecay7dayConvs = instance.mTimeDecay7dayConvs;
    this.mTimeDecay7dayConvsPer1kImpress = instance.mTimeDecay7dayConvsPer1kImpress;
    this.mTimeDecay7dayConvsPerClick = instance.mTimeDecay7dayConvsPerClick;
    this.mTimeDecay7dayConvsPerVisit = instance.mTimeDecay7dayConvsPerVisit;
    this.mTimeDecay7dayCpa = instance.mTimeDecay7dayCpa;
    this.mTimeDecay7dayRevenue = instance.mTimeDecay7dayRevenue;
    this.mTimeDecay7dayRoas = instance.mTimeDecay7dayRoas;
    this.mType = instance.mType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AtlasCampaign> getParser() {
    return new APIRequest.ResponseParser<AtlasCampaign>() {
      public APINodeList<AtlasCampaign> parseResponse(String response, APIContext context, APIRequest<AtlasCampaign> request, String header) throws MalformedResponseException {
        return AtlasCampaign.parseResponse(response, context, request, header);
      }
    };
  }
}
