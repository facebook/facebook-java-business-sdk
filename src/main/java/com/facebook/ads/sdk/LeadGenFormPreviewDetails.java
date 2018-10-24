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
public class LeadGenFormPreviewDetails extends APINode {
  @SerializedName("call_to_action_title")
  private String mCallToActionTitle = null;
  @SerializedName("default_appointment_scheduling_inline_context")
  private String mDefaultAppointmentSchedulingInlineContext = null;
  @SerializedName("default_thank_you_page")
  private Object mDefaultThankYouPage = null;
  @SerializedName("edit_text")
  private String mEditText = null;
  @SerializedName("email_inline_context_text")
  private String mEmailInlineContextText = null;
  @SerializedName("next_button_text")
  private String mNextButtonText = null;
  @SerializedName("personal_info_text")
  private String mPersonalInfoText = null;
  @SerializedName("phone_number_inline_context_text")
  private String mPhoneNumberInlineContextText = null;
  @SerializedName("review_your_info_text")
  private String mReviewYourInfoText = null;
  @SerializedName("slide_to_submit_text")
  private String mSlideToSubmitText = null;
  @SerializedName("submit_button_text")
  private String mSubmitButtonText = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  LeadGenFormPreviewDetails() {
  }

  public LeadGenFormPreviewDetails(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public LeadGenFormPreviewDetails(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public LeadGenFormPreviewDetails fetch() throws APIException{
    LeadGenFormPreviewDetails newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static LeadGenFormPreviewDetails fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<LeadGenFormPreviewDetails> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static LeadGenFormPreviewDetails fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<LeadGenFormPreviewDetails> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<LeadGenFormPreviewDetails> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<LeadGenFormPreviewDetails>)(
      new APIRequest<LeadGenFormPreviewDetails>(context, "", "/", "GET", LeadGenFormPreviewDetails.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<LeadGenFormPreviewDetails>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", LeadGenFormPreviewDetails.getParser())
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
  public static LeadGenFormPreviewDetails loadJSON(String json, APIContext context) {
    LeadGenFormPreviewDetails leadGenFormPreviewDetails = getGson().fromJson(json, LeadGenFormPreviewDetails.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(leadGenFormPreviewDetails.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    leadGenFormPreviewDetails.context = context;
    leadGenFormPreviewDetails.rawValue = json;
    return leadGenFormPreviewDetails;
  }

  public static APINodeList<LeadGenFormPreviewDetails> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<LeadGenFormPreviewDetails> leadGenFormPreviewDetailss = new APINodeList<LeadGenFormPreviewDetails>(request, json);
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
          leadGenFormPreviewDetailss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return leadGenFormPreviewDetailss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                leadGenFormPreviewDetailss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            leadGenFormPreviewDetailss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              leadGenFormPreviewDetailss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              leadGenFormPreviewDetailss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  leadGenFormPreviewDetailss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              leadGenFormPreviewDetailss.add(loadJSON(obj.toString(), context));
            }
          }
          return leadGenFormPreviewDetailss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              leadGenFormPreviewDetailss.add(loadJSON(entry.getValue().toString(), context));
          }
          return leadGenFormPreviewDetailss;
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
              leadGenFormPreviewDetailss.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return leadGenFormPreviewDetailss;
          }

          // Sixth, check if it's pure JsonObject
          leadGenFormPreviewDetailss.clear();
          leadGenFormPreviewDetailss.add(loadJSON(json, context));
          return leadGenFormPreviewDetailss;
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


  public String getFieldCallToActionTitle() {
    return mCallToActionTitle;
  }

  public String getFieldDefaultAppointmentSchedulingInlineContext() {
    return mDefaultAppointmentSchedulingInlineContext;
  }

  public Object getFieldDefaultThankYouPage() {
    return mDefaultThankYouPage;
  }

  public String getFieldEditText() {
    return mEditText;
  }

  public String getFieldEmailInlineContextText() {
    return mEmailInlineContextText;
  }

  public String getFieldNextButtonText() {
    return mNextButtonText;
  }

  public String getFieldPersonalInfoText() {
    return mPersonalInfoText;
  }

  public String getFieldPhoneNumberInlineContextText() {
    return mPhoneNumberInlineContextText;
  }

  public String getFieldReviewYourInfoText() {
    return mReviewYourInfoText;
  }

  public String getFieldSlideToSubmitText() {
    return mSlideToSubmitText;
  }

  public String getFieldSubmitButtonText() {
    return mSubmitButtonText;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<LeadGenFormPreviewDetails> {

    LeadGenFormPreviewDetails lastResponse = null;
    @Override
    public LeadGenFormPreviewDetails getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "call_to_action_title",
      "default_appointment_scheduling_inline_context",
      "default_thank_you_page",
      "edit_text",
      "email_inline_context_text",
      "next_button_text",
      "personal_info_text",
      "phone_number_inline_context_text",
      "review_your_info_text",
      "slide_to_submit_text",
      "submit_button_text",
      "id",
    };

    @Override
    public LeadGenFormPreviewDetails parseResponse(String response) throws APIException {
      return LeadGenFormPreviewDetails.parseResponse(response, getContext(), this).head();
    }

    @Override
    public LeadGenFormPreviewDetails execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LeadGenFormPreviewDetails execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<LeadGenFormPreviewDetails> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LeadGenFormPreviewDetails> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, LeadGenFormPreviewDetails>() {
           public LeadGenFormPreviewDetails apply(String result) {
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

    public APIRequestGet requestCallToActionTitleField () {
      return this.requestCallToActionTitleField(true);
    }
    public APIRequestGet requestCallToActionTitleField (boolean value) {
      this.requestField("call_to_action_title", value);
      return this;
    }
    public APIRequestGet requestDefaultAppointmentSchedulingInlineContextField () {
      return this.requestDefaultAppointmentSchedulingInlineContextField(true);
    }
    public APIRequestGet requestDefaultAppointmentSchedulingInlineContextField (boolean value) {
      this.requestField("default_appointment_scheduling_inline_context", value);
      return this;
    }
    public APIRequestGet requestDefaultThankYouPageField () {
      return this.requestDefaultThankYouPageField(true);
    }
    public APIRequestGet requestDefaultThankYouPageField (boolean value) {
      this.requestField("default_thank_you_page", value);
      return this;
    }
    public APIRequestGet requestEditTextField () {
      return this.requestEditTextField(true);
    }
    public APIRequestGet requestEditTextField (boolean value) {
      this.requestField("edit_text", value);
      return this;
    }
    public APIRequestGet requestEmailInlineContextTextField () {
      return this.requestEmailInlineContextTextField(true);
    }
    public APIRequestGet requestEmailInlineContextTextField (boolean value) {
      this.requestField("email_inline_context_text", value);
      return this;
    }
    public APIRequestGet requestNextButtonTextField () {
      return this.requestNextButtonTextField(true);
    }
    public APIRequestGet requestNextButtonTextField (boolean value) {
      this.requestField("next_button_text", value);
      return this;
    }
    public APIRequestGet requestPersonalInfoTextField () {
      return this.requestPersonalInfoTextField(true);
    }
    public APIRequestGet requestPersonalInfoTextField (boolean value) {
      this.requestField("personal_info_text", value);
      return this;
    }
    public APIRequestGet requestPhoneNumberInlineContextTextField () {
      return this.requestPhoneNumberInlineContextTextField(true);
    }
    public APIRequestGet requestPhoneNumberInlineContextTextField (boolean value) {
      this.requestField("phone_number_inline_context_text", value);
      return this;
    }
    public APIRequestGet requestReviewYourInfoTextField () {
      return this.requestReviewYourInfoTextField(true);
    }
    public APIRequestGet requestReviewYourInfoTextField (boolean value) {
      this.requestField("review_your_info_text", value);
      return this;
    }
    public APIRequestGet requestSlideToSubmitTextField () {
      return this.requestSlideToSubmitTextField(true);
    }
    public APIRequestGet requestSlideToSubmitTextField (boolean value) {
      this.requestField("slide_to_submit_text", value);
      return this;
    }
    public APIRequestGet requestSubmitButtonTextField () {
      return this.requestSubmitButtonTextField(true);
    }
    public APIRequestGet requestSubmitButtonTextField (boolean value) {
      this.requestField("submit_button_text", value);
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

  public LeadGenFormPreviewDetails copyFrom(LeadGenFormPreviewDetails instance) {
    this.mCallToActionTitle = instance.mCallToActionTitle;
    this.mDefaultAppointmentSchedulingInlineContext = instance.mDefaultAppointmentSchedulingInlineContext;
    this.mDefaultThankYouPage = instance.mDefaultThankYouPage;
    this.mEditText = instance.mEditText;
    this.mEmailInlineContextText = instance.mEmailInlineContextText;
    this.mNextButtonText = instance.mNextButtonText;
    this.mPersonalInfoText = instance.mPersonalInfoText;
    this.mPhoneNumberInlineContextText = instance.mPhoneNumberInlineContextText;
    this.mReviewYourInfoText = instance.mReviewYourInfoText;
    this.mSlideToSubmitText = instance.mSlideToSubmitText;
    this.mSubmitButtonText = instance.mSubmitButtonText;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LeadGenFormPreviewDetails> getParser() {
    return new APIRequest.ResponseParser<LeadGenFormPreviewDetails>() {
      public APINodeList<LeadGenFormPreviewDetails> parseResponse(String response, APIContext context, APIRequest<LeadGenFormPreviewDetails> request) throws MalformedResponseException {
        return LeadGenFormPreviewDetails.parseResponse(response, context, request);
      }
    };
  }
}
