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
public class LeadGenDataDraft extends APINode {
  @SerializedName("block_display_for_non_targeted_viewer")
  private Boolean mBlockDisplayForNonTargetedViewer = null;
  @SerializedName("context_card")
  private Object mContextCard = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("follow_up_action_url")
  private String mFollowUpActionUrl = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_optimized_for_quality")
  private Boolean mIsOptimizedForQuality = null;
  @SerializedName("legal_content")
  private Object mLegalContent = null;
  @SerializedName("locale")
  private String mLocale = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("page")
  private Page mPage = null;
  @SerializedName("question_page_custom_headline")
  private String mQuestionPageCustomHeadline = null;
  @SerializedName("questions")
  private List<LeadGenDraftQuestion> mQuestions = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("thank_you_page")
  private Object mThankYouPage = null;
  @SerializedName("tracking_parameters")
  private Map<String, String> mTrackingParameters = null;
  protected static Gson gson = null;

  LeadGenDataDraft() {
  }

  public LeadGenDataDraft(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public LeadGenDataDraft(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public LeadGenDataDraft fetch() throws APIException{
    LeadGenDataDraft newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static LeadGenDataDraft fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<LeadGenDataDraft> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static LeadGenDataDraft fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<LeadGenDataDraft> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<LeadGenDataDraft> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<LeadGenDataDraft>)(
      new APIRequest<LeadGenDataDraft>(context, "", "/", "GET", LeadGenDataDraft.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<LeadGenDataDraft>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", LeadGenDataDraft.getParser())
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
  public static LeadGenDataDraft loadJSON(String json, APIContext context, String header) {
    LeadGenDataDraft leadGenDataDraft = getGson().fromJson(json, LeadGenDataDraft.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(leadGenDataDraft.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    leadGenDataDraft.context = context;
    leadGenDataDraft.rawValue = json;
    leadGenDataDraft.header = header;
    return leadGenDataDraft;
  }

  public static APINodeList<LeadGenDataDraft> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<LeadGenDataDraft> leadGenDataDrafts = new APINodeList<LeadGenDataDraft>(request, json, header);
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
          leadGenDataDrafts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return leadGenDataDrafts;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                leadGenDataDrafts.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            leadGenDataDrafts.setPaging(previous, next);
            if (context.hasAppSecret()) {
              leadGenDataDrafts.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              leadGenDataDrafts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  leadGenDataDrafts.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              leadGenDataDrafts.add(loadJSON(obj.toString(), context, header));
            }
          }
          return leadGenDataDrafts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              leadGenDataDrafts.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return leadGenDataDrafts;
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
              leadGenDataDrafts.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return leadGenDataDrafts;
          }

          // Sixth, check if it's pure JsonObject
          leadGenDataDrafts.clear();
          leadGenDataDrafts.add(loadJSON(json, context, header));
          return leadGenDataDrafts;
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


  public Boolean getFieldBlockDisplayForNonTargetedViewer() {
    return mBlockDisplayForNonTargetedViewer;
  }

  public Object getFieldContextCard() {
    return mContextCard;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldFollowUpActionUrl() {
    return mFollowUpActionUrl;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsOptimizedForQuality() {
    return mIsOptimizedForQuality;
  }

  public Object getFieldLegalContent() {
    return mLegalContent;
  }

  public String getFieldLocale() {
    return mLocale;
  }

  public String getFieldName() {
    return mName;
  }

  public Page getFieldPage() {
    if (mPage != null) {
      mPage.context = getContext();
    }
    return mPage;
  }

  public String getFieldQuestionPageCustomHeadline() {
    return mQuestionPageCustomHeadline;
  }

  public List<LeadGenDraftQuestion> getFieldQuestions() {
    return mQuestions;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public Object getFieldThankYouPage() {
    return mThankYouPage;
  }

  public Map<String, String> getFieldTrackingParameters() {
    return mTrackingParameters;
  }



  public static class APIRequestGet extends APIRequest<LeadGenDataDraft> {

    LeadGenDataDraft lastResponse = null;
    @Override
    public LeadGenDataDraft getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "block_display_for_non_targeted_viewer",
      "context_card",
      "created_time",
      "follow_up_action_url",
      "id",
      "is_optimized_for_quality",
      "legal_content",
      "locale",
      "name",
      "page",
      "question_page_custom_headline",
      "questions",
      "status",
      "thank_you_page",
      "tracking_parameters",
    };

    @Override
    public LeadGenDataDraft parseResponse(String response, String header) throws APIException {
      return LeadGenDataDraft.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LeadGenDataDraft execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LeadGenDataDraft execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LeadGenDataDraft> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LeadGenDataDraft> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LeadGenDataDraft>() {
           public LeadGenDataDraft apply(ResponseWrapper result) {
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

    public APIRequestGet requestBlockDisplayForNonTargetedViewerField () {
      return this.requestBlockDisplayForNonTargetedViewerField(true);
    }
    public APIRequestGet requestBlockDisplayForNonTargetedViewerField (boolean value) {
      this.requestField("block_display_for_non_targeted_viewer", value);
      return this;
    }
    public APIRequestGet requestContextCardField () {
      return this.requestContextCardField(true);
    }
    public APIRequestGet requestContextCardField (boolean value) {
      this.requestField("context_card", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestFollowUpActionUrlField () {
      return this.requestFollowUpActionUrlField(true);
    }
    public APIRequestGet requestFollowUpActionUrlField (boolean value) {
      this.requestField("follow_up_action_url", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsOptimizedForQualityField () {
      return this.requestIsOptimizedForQualityField(true);
    }
    public APIRequestGet requestIsOptimizedForQualityField (boolean value) {
      this.requestField("is_optimized_for_quality", value);
      return this;
    }
    public APIRequestGet requestLegalContentField () {
      return this.requestLegalContentField(true);
    }
    public APIRequestGet requestLegalContentField (boolean value) {
      this.requestField("legal_content", value);
      return this;
    }
    public APIRequestGet requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGet requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGet requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
    public APIRequestGet requestQuestionPageCustomHeadlineField () {
      return this.requestQuestionPageCustomHeadlineField(true);
    }
    public APIRequestGet requestQuestionPageCustomHeadlineField (boolean value) {
      this.requestField("question_page_custom_headline", value);
      return this;
    }
    public APIRequestGet requestQuestionsField () {
      return this.requestQuestionsField(true);
    }
    public APIRequestGet requestQuestionsField (boolean value) {
      this.requestField("questions", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestThankYouPageField () {
      return this.requestThankYouPageField(true);
    }
    public APIRequestGet requestThankYouPageField (boolean value) {
      this.requestField("thank_you_page", value);
      return this;
    }
    public APIRequestGet requestTrackingParametersField () {
      return this.requestTrackingParametersField(true);
    }
    public APIRequestGet requestTrackingParametersField (boolean value) {
      this.requestField("tracking_parameters", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<LeadGenDataDraft> {

    LeadGenDataDraft lastResponse = null;
    @Override
    public LeadGenDataDraft getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "block_display_for_non_targeted_viewer",
      "context_card",
      "context_card_id",
      "custom_disclaimer",
      "delete_missing_parameters",
      "follow_up_action_url",
      "is_optimized_for_quality",
      "legal_content_id",
      "locale",
      "name",
      "privacy_policy",
      "question_page_custom_headline",
      "questions",
      "status",
      "thank_you_page",
      "tracking_parameters",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public LeadGenDataDraft parseResponse(String response, String header) throws APIException {
      return LeadGenDataDraft.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LeadGenDataDraft execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LeadGenDataDraft execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LeadGenDataDraft> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LeadGenDataDraft> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LeadGenDataDraft>() {
           public LeadGenDataDraft apply(ResponseWrapper result) {
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


    public APIRequestUpdate setBlockDisplayForNonTargetedViewer (Boolean blockDisplayForNonTargetedViewer) {
      this.setParam("block_display_for_non_targeted_viewer", blockDisplayForNonTargetedViewer);
      return this;
    }
    public APIRequestUpdate setBlockDisplayForNonTargetedViewer (String blockDisplayForNonTargetedViewer) {
      this.setParam("block_display_for_non_targeted_viewer", blockDisplayForNonTargetedViewer);
      return this;
    }

    public APIRequestUpdate setContextCard (Object contextCard) {
      this.setParam("context_card", contextCard);
      return this;
    }
    public APIRequestUpdate setContextCard (String contextCard) {
      this.setParam("context_card", contextCard);
      return this;
    }

    public APIRequestUpdate setContextCardId (String contextCardId) {
      this.setParam("context_card_id", contextCardId);
      return this;
    }

    public APIRequestUpdate setCustomDisclaimer (Object customDisclaimer) {
      this.setParam("custom_disclaimer", customDisclaimer);
      return this;
    }
    public APIRequestUpdate setCustomDisclaimer (String customDisclaimer) {
      this.setParam("custom_disclaimer", customDisclaimer);
      return this;
    }

    public APIRequestUpdate setDeleteMissingParameters (Boolean deleteMissingParameters) {
      this.setParam("delete_missing_parameters", deleteMissingParameters);
      return this;
    }
    public APIRequestUpdate setDeleteMissingParameters (String deleteMissingParameters) {
      this.setParam("delete_missing_parameters", deleteMissingParameters);
      return this;
    }

    public APIRequestUpdate setFollowUpActionUrl (String followUpActionUrl) {
      this.setParam("follow_up_action_url", followUpActionUrl);
      return this;
    }

    public APIRequestUpdate setIsOptimizedForQuality (Boolean isOptimizedForQuality) {
      this.setParam("is_optimized_for_quality", isOptimizedForQuality);
      return this;
    }
    public APIRequestUpdate setIsOptimizedForQuality (String isOptimizedForQuality) {
      this.setParam("is_optimized_for_quality", isOptimizedForQuality);
      return this;
    }

    public APIRequestUpdate setLegalContentId (String legalContentId) {
      this.setParam("legal_content_id", legalContentId);
      return this;
    }

    public APIRequestUpdate setLocale (LeadGenDataDraft.EnumLocale locale) {
      this.setParam("locale", locale);
      return this;
    }
    public APIRequestUpdate setLocale (String locale) {
      this.setParam("locale", locale);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setPrivacyPolicy (Map<String, String> privacyPolicy) {
      this.setParam("privacy_policy", privacyPolicy);
      return this;
    }
    public APIRequestUpdate setPrivacyPolicy (String privacyPolicy) {
      this.setParam("privacy_policy", privacyPolicy);
      return this;
    }

    public APIRequestUpdate setQuestionPageCustomHeadline (String questionPageCustomHeadline) {
      this.setParam("question_page_custom_headline", questionPageCustomHeadline);
      return this;
    }

    public APIRequestUpdate setQuestions (List<Object> questions) {
      this.setParam("questions", questions);
      return this;
    }
    public APIRequestUpdate setQuestions (String questions) {
      this.setParam("questions", questions);
      return this;
    }

    public APIRequestUpdate setStatus (LeadGenDataDraft.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestUpdate setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestUpdate setThankYouPage (Map<String, String> thankYouPage) {
      this.setParam("thank_you_page", thankYouPage);
      return this;
    }
    public APIRequestUpdate setThankYouPage (String thankYouPage) {
      this.setParam("thank_you_page", thankYouPage);
      return this;
    }

    public APIRequestUpdate setTrackingParameters (Map<String, String> trackingParameters) {
      this.setParam("tracking_parameters", trackingParameters);
      return this;
    }
    public APIRequestUpdate setTrackingParameters (String trackingParameters) {
      this.setParam("tracking_parameters", trackingParameters);
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

  public static enum EnumLocale {
      @SerializedName("AR_AR")
      VALUE_AR_AR("AR_AR"),
      @SerializedName("CS_CZ")
      VALUE_CS_CZ("CS_CZ"),
      @SerializedName("DA_DK")
      VALUE_DA_DK("DA_DK"),
      @SerializedName("DE_DE")
      VALUE_DE_DE("DE_DE"),
      @SerializedName("EN_GB")
      VALUE_EN_GB("EN_GB"),
      @SerializedName("EN_US")
      VALUE_EN_US("EN_US"),
      @SerializedName("ES_ES")
      VALUE_ES_ES("ES_ES"),
      @SerializedName("ES_LA")
      VALUE_ES_LA("ES_LA"),
      @SerializedName("FI_FI")
      VALUE_FI_FI("FI_FI"),
      @SerializedName("FR_FR")
      VALUE_FR_FR("FR_FR"),
      @SerializedName("HE_IL")
      VALUE_HE_IL("HE_IL"),
      @SerializedName("HI_IN")
      VALUE_HI_IN("HI_IN"),
      @SerializedName("HU_HU")
      VALUE_HU_HU("HU_HU"),
      @SerializedName("ID_ID")
      VALUE_ID_ID("ID_ID"),
      @SerializedName("IT_IT")
      VALUE_IT_IT("IT_IT"),
      @SerializedName("JA_JP")
      VALUE_JA_JP("JA_JP"),
      @SerializedName("KO_KR")
      VALUE_KO_KR("KO_KR"),
      @SerializedName("NB_NO")
      VALUE_NB_NO("NB_NO"),
      @SerializedName("NL_NL")
      VALUE_NL_NL("NL_NL"),
      @SerializedName("PL_PL")
      VALUE_PL_PL("PL_PL"),
      @SerializedName("PT_BR")
      VALUE_PT_BR("PT_BR"),
      @SerializedName("PT_PT")
      VALUE_PT_PT("PT_PT"),
      @SerializedName("RO_RO")
      VALUE_RO_RO("RO_RO"),
      @SerializedName("RU_RU")
      VALUE_RU_RU("RU_RU"),
      @SerializedName("SV_SE")
      VALUE_SV_SE("SV_SE"),
      @SerializedName("TH_TH")
      VALUE_TH_TH("TH_TH"),
      @SerializedName("TR_TR")
      VALUE_TR_TR("TR_TR"),
      @SerializedName("VI_VN")
      VALUE_VI_VN("VI_VN"),
      @SerializedName("ZH_CN")
      VALUE_ZH_CN("ZH_CN"),
      @SerializedName("ZH_HK")
      VALUE_ZH_HK("ZH_HK"),
      @SerializedName("ZH_TW")
      VALUE_ZH_TW("ZH_TW"),
      ;

      private String value;

      private EnumLocale(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStatus {
      @SerializedName("ACTIVE")
      VALUE_ACTIVE("ACTIVE"),
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("DRAFT")
      VALUE_DRAFT("DRAFT"),
      ;

      private String value;

      private EnumStatus(String value) {
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

  public LeadGenDataDraft copyFrom(LeadGenDataDraft instance) {
    this.mBlockDisplayForNonTargetedViewer = instance.mBlockDisplayForNonTargetedViewer;
    this.mContextCard = instance.mContextCard;
    this.mCreatedTime = instance.mCreatedTime;
    this.mFollowUpActionUrl = instance.mFollowUpActionUrl;
    this.mId = instance.mId;
    this.mIsOptimizedForQuality = instance.mIsOptimizedForQuality;
    this.mLegalContent = instance.mLegalContent;
    this.mLocale = instance.mLocale;
    this.mName = instance.mName;
    this.mPage = instance.mPage;
    this.mQuestionPageCustomHeadline = instance.mQuestionPageCustomHeadline;
    this.mQuestions = instance.mQuestions;
    this.mStatus = instance.mStatus;
    this.mThankYouPage = instance.mThankYouPage;
    this.mTrackingParameters = instance.mTrackingParameters;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LeadGenDataDraft> getParser() {
    return new APIRequest.ResponseParser<LeadGenDataDraft>() {
      public APINodeList<LeadGenDataDraft> parseResponse(String response, APIContext context, APIRequest<LeadGenDataDraft> request, String header) throws MalformedResponseException {
        return LeadGenDataDraft.parseResponse(response, context, request, header);
      }
    };
  }
}
