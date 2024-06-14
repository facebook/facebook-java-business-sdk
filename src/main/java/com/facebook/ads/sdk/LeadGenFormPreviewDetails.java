/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
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
import com.google.common.util.concurrent.MoreExecutors;
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
  @SerializedName("contact_information_text")
  private String mContactInformationText = null;
  @SerializedName("creatives_overview_default_text")
  private String mCreativesOverviewDefaultText = null;
  @SerializedName("data_privacy_policy_setting_description")
  private String mDataPrivacyPolicySettingDescription = null;
  @SerializedName("default_appointment_scheduling_inline_context")
  private String mDefaultAppointmentSchedulingInlineContext = null;
  @SerializedName("default_disqualified_end_component")
  private Object mDefaultDisqualifiedEndComponent = null;
  @SerializedName("default_thank_you_page")
  private Object mDefaultThankYouPage = null;
  @SerializedName("disqualified_thank_you_card_transparency_info_text")
  private String mDisqualifiedThankYouCardTransparencyInfoText = null;
  @SerializedName("edit_text")
  private String mEditText = null;
  @SerializedName("email_inline_context_text")
  private String mEmailInlineContextText = null;
  @SerializedName("email_messenger_push_opt_in_disclaimer")
  private String mEmailMessengerPushOptInDisclaimer = null;
  @SerializedName("email_messenger_push_opt_in_transparency_text")
  private String mEmailMessengerPushOptInTransparencyText = null;
  @SerializedName("form_clarity_description_content")
  private String mFormClarityDescriptionContent = null;
  @SerializedName("form_clarity_description_title")
  private String mFormClarityDescriptionTitle = null;
  @SerializedName("form_clarity_headline")
  private String mFormClarityHeadline = null;
  @SerializedName("gated_content_locked_description")
  private String mGatedContentLockedDescription = null;
  @SerializedName("gated_content_locked_headline")
  private String mGatedContentLockedHeadline = null;
  @SerializedName("gated_content_unlocked_description")
  private String mGatedContentUnlockedDescription = null;
  @SerializedName("gated_content_unlocked_headline")
  private String mGatedContentUnlockedHeadline = null;
  @SerializedName("how_it_works_section_headers")
  private List<Map<String, String>> mHowItWorksSectionHeaders = null;
  @SerializedName("next_button_text")
  private String mNextButtonText = null;
  @SerializedName("optional_question_text")
  private String mOptionalQuestionText = null;
  @SerializedName("personal_info_text")
  private String mPersonalInfoText = null;
  @SerializedName("phone_number_inline_context_text")
  private String mPhoneNumberInlineContextText = null;
  @SerializedName("privacy_policy_title_section_title_text")
  private String mPrivacyPolicyTitleSectionTitleText = null;
  @SerializedName("privacy_setting_description")
  private String mPrivacySettingDescription = null;
  @SerializedName("products_section_headers")
  private List<Map<String, String>> mProductsSectionHeaders = null;
  @SerializedName("qualified_thank_you_card_transparency_info_text")
  private String mQualifiedThankYouCardTransparencyInfoText = null;
  @SerializedName("review_your_info_text")
  private String mReviewYourInfoText = null;
  @SerializedName("secure_sharing_text")
  private String mSecureSharingText = null;
  @SerializedName("slide_to_submit_text")
  private String mSlideToSubmitText = null;
  @SerializedName("social_proof_section_headers")
  private List<Map<String, String>> mSocialProofSectionHeaders = null;
  @SerializedName("submit_button_text")
  private String mSubmitButtonText = null;
  protected static Gson gson = null;

  public LeadGenFormPreviewDetails() {
  }

  public String getId() {
    return null;
  }
  public static LeadGenFormPreviewDetails loadJSON(String json, APIContext context, String header) {
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
      }
    }
    leadGenFormPreviewDetails.context = context;
    leadGenFormPreviewDetails.rawValue = json;
    leadGenFormPreviewDetails.header = header;
    return leadGenFormPreviewDetails;
  }

  public static APINodeList<LeadGenFormPreviewDetails> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<LeadGenFormPreviewDetails> leadGenFormPreviewDetailss = new APINodeList<LeadGenFormPreviewDetails>(request, json, header);
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
          leadGenFormPreviewDetailss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
              leadGenFormPreviewDetailss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  leadGenFormPreviewDetailss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              leadGenFormPreviewDetailss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return leadGenFormPreviewDetailss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              leadGenFormPreviewDetailss.add(loadJSON(entry.getValue().toString(), context, header));
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
              leadGenFormPreviewDetailss.add(loadJSON(value.toString(), context, header));
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
          leadGenFormPreviewDetailss.add(loadJSON(json, context, header));
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


  public String getFieldCallToActionTitle() {
    return mCallToActionTitle;
  }

  public LeadGenFormPreviewDetails setFieldCallToActionTitle(String value) {
    this.mCallToActionTitle = value;
    return this;
  }

  public String getFieldContactInformationText() {
    return mContactInformationText;
  }

  public LeadGenFormPreviewDetails setFieldContactInformationText(String value) {
    this.mContactInformationText = value;
    return this;
  }

  public String getFieldCreativesOverviewDefaultText() {
    return mCreativesOverviewDefaultText;
  }

  public LeadGenFormPreviewDetails setFieldCreativesOverviewDefaultText(String value) {
    this.mCreativesOverviewDefaultText = value;
    return this;
  }

  public String getFieldDataPrivacyPolicySettingDescription() {
    return mDataPrivacyPolicySettingDescription;
  }

  public LeadGenFormPreviewDetails setFieldDataPrivacyPolicySettingDescription(String value) {
    this.mDataPrivacyPolicySettingDescription = value;
    return this;
  }

  public String getFieldDefaultAppointmentSchedulingInlineContext() {
    return mDefaultAppointmentSchedulingInlineContext;
  }

  public LeadGenFormPreviewDetails setFieldDefaultAppointmentSchedulingInlineContext(String value) {
    this.mDefaultAppointmentSchedulingInlineContext = value;
    return this;
  }

  public Object getFieldDefaultDisqualifiedEndComponent() {
    return mDefaultDisqualifiedEndComponent;
  }

  public LeadGenFormPreviewDetails setFieldDefaultDisqualifiedEndComponent(Object value) {
    this.mDefaultDisqualifiedEndComponent = value;
    return this;
  }

  public Object getFieldDefaultThankYouPage() {
    return mDefaultThankYouPage;
  }

  public LeadGenFormPreviewDetails setFieldDefaultThankYouPage(Object value) {
    this.mDefaultThankYouPage = value;
    return this;
  }

  public String getFieldDisqualifiedThankYouCardTransparencyInfoText() {
    return mDisqualifiedThankYouCardTransparencyInfoText;
  }

  public LeadGenFormPreviewDetails setFieldDisqualifiedThankYouCardTransparencyInfoText(String value) {
    this.mDisqualifiedThankYouCardTransparencyInfoText = value;
    return this;
  }

  public String getFieldEditText() {
    return mEditText;
  }

  public LeadGenFormPreviewDetails setFieldEditText(String value) {
    this.mEditText = value;
    return this;
  }

  public String getFieldEmailInlineContextText() {
    return mEmailInlineContextText;
  }

  public LeadGenFormPreviewDetails setFieldEmailInlineContextText(String value) {
    this.mEmailInlineContextText = value;
    return this;
  }

  public String getFieldEmailMessengerPushOptInDisclaimer() {
    return mEmailMessengerPushOptInDisclaimer;
  }

  public LeadGenFormPreviewDetails setFieldEmailMessengerPushOptInDisclaimer(String value) {
    this.mEmailMessengerPushOptInDisclaimer = value;
    return this;
  }

  public String getFieldEmailMessengerPushOptInTransparencyText() {
    return mEmailMessengerPushOptInTransparencyText;
  }

  public LeadGenFormPreviewDetails setFieldEmailMessengerPushOptInTransparencyText(String value) {
    this.mEmailMessengerPushOptInTransparencyText = value;
    return this;
  }

  public String getFieldFormClarityDescriptionContent() {
    return mFormClarityDescriptionContent;
  }

  public LeadGenFormPreviewDetails setFieldFormClarityDescriptionContent(String value) {
    this.mFormClarityDescriptionContent = value;
    return this;
  }

  public String getFieldFormClarityDescriptionTitle() {
    return mFormClarityDescriptionTitle;
  }

  public LeadGenFormPreviewDetails setFieldFormClarityDescriptionTitle(String value) {
    this.mFormClarityDescriptionTitle = value;
    return this;
  }

  public String getFieldFormClarityHeadline() {
    return mFormClarityHeadline;
  }

  public LeadGenFormPreviewDetails setFieldFormClarityHeadline(String value) {
    this.mFormClarityHeadline = value;
    return this;
  }

  public String getFieldGatedContentLockedDescription() {
    return mGatedContentLockedDescription;
  }

  public LeadGenFormPreviewDetails setFieldGatedContentLockedDescription(String value) {
    this.mGatedContentLockedDescription = value;
    return this;
  }

  public String getFieldGatedContentLockedHeadline() {
    return mGatedContentLockedHeadline;
  }

  public LeadGenFormPreviewDetails setFieldGatedContentLockedHeadline(String value) {
    this.mGatedContentLockedHeadline = value;
    return this;
  }

  public String getFieldGatedContentUnlockedDescription() {
    return mGatedContentUnlockedDescription;
  }

  public LeadGenFormPreviewDetails setFieldGatedContentUnlockedDescription(String value) {
    this.mGatedContentUnlockedDescription = value;
    return this;
  }

  public String getFieldGatedContentUnlockedHeadline() {
    return mGatedContentUnlockedHeadline;
  }

  public LeadGenFormPreviewDetails setFieldGatedContentUnlockedHeadline(String value) {
    this.mGatedContentUnlockedHeadline = value;
    return this;
  }

  public List<Map<String, String>> getFieldHowItWorksSectionHeaders() {
    return mHowItWorksSectionHeaders;
  }

  public LeadGenFormPreviewDetails setFieldHowItWorksSectionHeaders(List<Map<String, String>> value) {
    this.mHowItWorksSectionHeaders = value;
    return this;
  }

  public String getFieldNextButtonText() {
    return mNextButtonText;
  }

  public LeadGenFormPreviewDetails setFieldNextButtonText(String value) {
    this.mNextButtonText = value;
    return this;
  }

  public String getFieldOptionalQuestionText() {
    return mOptionalQuestionText;
  }

  public LeadGenFormPreviewDetails setFieldOptionalQuestionText(String value) {
    this.mOptionalQuestionText = value;
    return this;
  }

  public String getFieldPersonalInfoText() {
    return mPersonalInfoText;
  }

  public LeadGenFormPreviewDetails setFieldPersonalInfoText(String value) {
    this.mPersonalInfoText = value;
    return this;
  }

  public String getFieldPhoneNumberInlineContextText() {
    return mPhoneNumberInlineContextText;
  }

  public LeadGenFormPreviewDetails setFieldPhoneNumberInlineContextText(String value) {
    this.mPhoneNumberInlineContextText = value;
    return this;
  }

  public String getFieldPrivacyPolicyTitleSectionTitleText() {
    return mPrivacyPolicyTitleSectionTitleText;
  }

  public LeadGenFormPreviewDetails setFieldPrivacyPolicyTitleSectionTitleText(String value) {
    this.mPrivacyPolicyTitleSectionTitleText = value;
    return this;
  }

  public String getFieldPrivacySettingDescription() {
    return mPrivacySettingDescription;
  }

  public LeadGenFormPreviewDetails setFieldPrivacySettingDescription(String value) {
    this.mPrivacySettingDescription = value;
    return this;
  }

  public List<Map<String, String>> getFieldProductsSectionHeaders() {
    return mProductsSectionHeaders;
  }

  public LeadGenFormPreviewDetails setFieldProductsSectionHeaders(List<Map<String, String>> value) {
    this.mProductsSectionHeaders = value;
    return this;
  }

  public String getFieldQualifiedThankYouCardTransparencyInfoText() {
    return mQualifiedThankYouCardTransparencyInfoText;
  }

  public LeadGenFormPreviewDetails setFieldQualifiedThankYouCardTransparencyInfoText(String value) {
    this.mQualifiedThankYouCardTransparencyInfoText = value;
    return this;
  }

  public String getFieldReviewYourInfoText() {
    return mReviewYourInfoText;
  }

  public LeadGenFormPreviewDetails setFieldReviewYourInfoText(String value) {
    this.mReviewYourInfoText = value;
    return this;
  }

  public String getFieldSecureSharingText() {
    return mSecureSharingText;
  }

  public LeadGenFormPreviewDetails setFieldSecureSharingText(String value) {
    this.mSecureSharingText = value;
    return this;
  }

  public String getFieldSlideToSubmitText() {
    return mSlideToSubmitText;
  }

  public LeadGenFormPreviewDetails setFieldSlideToSubmitText(String value) {
    this.mSlideToSubmitText = value;
    return this;
  }

  public List<Map<String, String>> getFieldSocialProofSectionHeaders() {
    return mSocialProofSectionHeaders;
  }

  public LeadGenFormPreviewDetails setFieldSocialProofSectionHeaders(List<Map<String, String>> value) {
    this.mSocialProofSectionHeaders = value;
    return this;
  }

  public String getFieldSubmitButtonText() {
    return mSubmitButtonText;
  }

  public LeadGenFormPreviewDetails setFieldSubmitButtonText(String value) {
    this.mSubmitButtonText = value;
    return this;
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
    this.mContactInformationText = instance.mContactInformationText;
    this.mCreativesOverviewDefaultText = instance.mCreativesOverviewDefaultText;
    this.mDataPrivacyPolicySettingDescription = instance.mDataPrivacyPolicySettingDescription;
    this.mDefaultAppointmentSchedulingInlineContext = instance.mDefaultAppointmentSchedulingInlineContext;
    this.mDefaultDisqualifiedEndComponent = instance.mDefaultDisqualifiedEndComponent;
    this.mDefaultThankYouPage = instance.mDefaultThankYouPage;
    this.mDisqualifiedThankYouCardTransparencyInfoText = instance.mDisqualifiedThankYouCardTransparencyInfoText;
    this.mEditText = instance.mEditText;
    this.mEmailInlineContextText = instance.mEmailInlineContextText;
    this.mEmailMessengerPushOptInDisclaimer = instance.mEmailMessengerPushOptInDisclaimer;
    this.mEmailMessengerPushOptInTransparencyText = instance.mEmailMessengerPushOptInTransparencyText;
    this.mFormClarityDescriptionContent = instance.mFormClarityDescriptionContent;
    this.mFormClarityDescriptionTitle = instance.mFormClarityDescriptionTitle;
    this.mFormClarityHeadline = instance.mFormClarityHeadline;
    this.mGatedContentLockedDescription = instance.mGatedContentLockedDescription;
    this.mGatedContentLockedHeadline = instance.mGatedContentLockedHeadline;
    this.mGatedContentUnlockedDescription = instance.mGatedContentUnlockedDescription;
    this.mGatedContentUnlockedHeadline = instance.mGatedContentUnlockedHeadline;
    this.mHowItWorksSectionHeaders = instance.mHowItWorksSectionHeaders;
    this.mNextButtonText = instance.mNextButtonText;
    this.mOptionalQuestionText = instance.mOptionalQuestionText;
    this.mPersonalInfoText = instance.mPersonalInfoText;
    this.mPhoneNumberInlineContextText = instance.mPhoneNumberInlineContextText;
    this.mPrivacyPolicyTitleSectionTitleText = instance.mPrivacyPolicyTitleSectionTitleText;
    this.mPrivacySettingDescription = instance.mPrivacySettingDescription;
    this.mProductsSectionHeaders = instance.mProductsSectionHeaders;
    this.mQualifiedThankYouCardTransparencyInfoText = instance.mQualifiedThankYouCardTransparencyInfoText;
    this.mReviewYourInfoText = instance.mReviewYourInfoText;
    this.mSecureSharingText = instance.mSecureSharingText;
    this.mSlideToSubmitText = instance.mSlideToSubmitText;
    this.mSocialProofSectionHeaders = instance.mSocialProofSectionHeaders;
    this.mSubmitButtonText = instance.mSubmitButtonText;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LeadGenFormPreviewDetails> getParser() {
    return new APIRequest.ResponseParser<LeadGenFormPreviewDetails>() {
      public APINodeList<LeadGenFormPreviewDetails> parseResponse(String response, APIContext context, APIRequest<LeadGenFormPreviewDetails> request, String header) throws MalformedResponseException {
        return LeadGenFormPreviewDetails.parseResponse(response, context, request, header);
      }
    };
  }
}
