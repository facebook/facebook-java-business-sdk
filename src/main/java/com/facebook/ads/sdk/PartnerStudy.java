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
public class PartnerStudy extends APINode {
  @SerializedName("additional_info")
  private String mAdditionalInfo = null;
  @SerializedName("brand")
  private String mBrand = null;
  @SerializedName("client_name")
  private String mClientName = null;
  @SerializedName("emails")
  private String mEmails = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("input_ids")
  private List<String> mInputIds = null;
  @SerializedName("is_export")
  private Boolean mIsExport = null;
  @SerializedName("lift_study")
  private AdStudy mLiftStudy = null;
  @SerializedName("location")
  private String mLocation = null;
  @SerializedName("match_file_ds")
  private String mMatchFileDs = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("partner_defined_id")
  private String mPartnerDefinedId = null;
  @SerializedName("partner_household_graph_dataset_id")
  private String mPartnerHouseholdGraphDatasetId = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("study_end_date")
  private String mStudyEndDate = null;
  @SerializedName("study_start_date")
  private String mStudyStartDate = null;
  @SerializedName("study_type")
  private String mStudyType = null;
  @SerializedName("submit_date")
  private String mSubmitDate = null;
  protected static Gson gson = null;

  PartnerStudy() {
  }

  public PartnerStudy(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PartnerStudy(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public PartnerStudy fetch() throws APIException{
    PartnerStudy newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PartnerStudy fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PartnerStudy> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PartnerStudy fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PartnerStudy> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<PartnerStudy> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PartnerStudy>)(
      new APIRequest<PartnerStudy>(context, "", "/", "GET", PartnerStudy.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PartnerStudy>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", PartnerStudy.getParser())
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
  public static PartnerStudy loadJSON(String json, APIContext context, String header) {
    PartnerStudy partnerStudy = getGson().fromJson(json, PartnerStudy.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(partnerStudy.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    partnerStudy.context = context;
    partnerStudy.rawValue = json;
    partnerStudy.header = header;
    return partnerStudy;
  }

  public static APINodeList<PartnerStudy> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PartnerStudy> partnerStudys = new APINodeList<PartnerStudy>(request, json, header);
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
          partnerStudys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return partnerStudys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                partnerStudys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            partnerStudys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              partnerStudys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              partnerStudys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  partnerStudys.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              partnerStudys.add(loadJSON(obj.toString(), context, header));
            }
          }
          return partnerStudys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              partnerStudys.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return partnerStudys;
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
              partnerStudys.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return partnerStudys;
          }

          // Sixth, check if it's pure JsonObject
          partnerStudys.clear();
          partnerStudys.add(loadJSON(json, context, header));
          return partnerStudys;
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

  public APIRequestGetSubmitters getSubmitters() {
    return new APIRequestGetSubmitters(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldAdditionalInfo() {
    return mAdditionalInfo;
  }

  public String getFieldBrand() {
    return mBrand;
  }

  public String getFieldClientName() {
    return mClientName;
  }

  public String getFieldEmails() {
    return mEmails;
  }

  public String getFieldId() {
    return mId;
  }

  public List<String> getFieldInputIds() {
    return mInputIds;
  }

  public Boolean getFieldIsExport() {
    return mIsExport;
  }

  public AdStudy getFieldLiftStudy() {
    if (mLiftStudy != null) {
      mLiftStudy.context = getContext();
    }
    return mLiftStudy;
  }

  public String getFieldLocation() {
    return mLocation;
  }

  public String getFieldMatchFileDs() {
    return mMatchFileDs;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldPartnerDefinedId() {
    return mPartnerDefinedId;
  }

  public String getFieldPartnerHouseholdGraphDatasetId() {
    return mPartnerHouseholdGraphDatasetId;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldStudyEndDate() {
    return mStudyEndDate;
  }

  public String getFieldStudyStartDate() {
    return mStudyStartDate;
  }

  public String getFieldStudyType() {
    return mStudyType;
  }

  public String getFieldSubmitDate() {
    return mSubmitDate;
  }



  public static class APIRequestGetSubmitters extends APIRequest<User> {

    APINodeList<User> lastResponse = null;
    @Override
    public APINodeList<User> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "about",
      "address",
      "admin_notes",
      "age_range",
      "auth_method",
      "birthday",
      "can_review_measurement_request",
      "cover",
      "currency",
      "devices",
      "education",
      "email",
      "favorite_athletes",
      "favorite_teams",
      "first_name",
      "gender",
      "hometown",
      "id",
      "inspirational_people",
      "install_type",
      "installed",
      "interested_in",
      "is_famedeeplinkinguser",
      "is_guest_user",
      "is_shared_login",
      "is_verified",
      "languages",
      "last_name",
      "link",
      "local_news_megaphone_dismiss_status",
      "local_news_subscription_status",
      "locale",
      "location",
      "meeting_for",
      "middle_name",
      "name",
      "name_format",
      "payment_pricepoints",
      "political",
      "profile_pic",
      "public_key",
      "quotes",
      "relationship_status",
      "religion",
      "security_settings",
      "shared_login_upgrade_required_by",
      "short_name",
      "significant_other",
      "sports",
      "supports_donate_button_in_live_video",
      "test_group",
      "third_party_id",
      "timezone",
      "token_for_business",
      "updated_time",
      "verified",
      "video_upload_limits",
      "viewer_can_send_gift",
      "website",
      "work",
    };

    @Override
    public APINodeList<User> parseResponse(String response, String header) throws APIException {
      return User.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<User> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<User> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<User>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<User>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<User>>() {
           public APINodeList<User> apply(ResponseWrapper result) {
             try {
               return APIRequestGetSubmitters.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetSubmitters(String nodeId, APIContext context) {
      super(context, nodeId, "/submitters", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSubmitters setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSubmitters setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSubmitters requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSubmitters requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSubmitters requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSubmitters requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSubmitters requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSubmitters requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSubmitters requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetSubmitters requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetSubmitters requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetSubmitters requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetSubmitters requestAdminNotesField () {
      return this.requestAdminNotesField(true);
    }
    public APIRequestGetSubmitters requestAdminNotesField (boolean value) {
      this.requestField("admin_notes", value);
      return this;
    }
    public APIRequestGetSubmitters requestAgeRangeField () {
      return this.requestAgeRangeField(true);
    }
    public APIRequestGetSubmitters requestAgeRangeField (boolean value) {
      this.requestField("age_range", value);
      return this;
    }
    public APIRequestGetSubmitters requestAuthMethodField () {
      return this.requestAuthMethodField(true);
    }
    public APIRequestGetSubmitters requestAuthMethodField (boolean value) {
      this.requestField("auth_method", value);
      return this;
    }
    public APIRequestGetSubmitters requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetSubmitters requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetSubmitters requestCanReviewMeasurementRequestField () {
      return this.requestCanReviewMeasurementRequestField(true);
    }
    public APIRequestGetSubmitters requestCanReviewMeasurementRequestField (boolean value) {
      this.requestField("can_review_measurement_request", value);
      return this;
    }
    public APIRequestGetSubmitters requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetSubmitters requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetSubmitters requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetSubmitters requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetSubmitters requestDevicesField () {
      return this.requestDevicesField(true);
    }
    public APIRequestGetSubmitters requestDevicesField (boolean value) {
      this.requestField("devices", value);
      return this;
    }
    public APIRequestGetSubmitters requestEducationField () {
      return this.requestEducationField(true);
    }
    public APIRequestGetSubmitters requestEducationField (boolean value) {
      this.requestField("education", value);
      return this;
    }
    public APIRequestGetSubmitters requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetSubmitters requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetSubmitters requestFavoriteAthletesField () {
      return this.requestFavoriteAthletesField(true);
    }
    public APIRequestGetSubmitters requestFavoriteAthletesField (boolean value) {
      this.requestField("favorite_athletes", value);
      return this;
    }
    public APIRequestGetSubmitters requestFavoriteTeamsField () {
      return this.requestFavoriteTeamsField(true);
    }
    public APIRequestGetSubmitters requestFavoriteTeamsField (boolean value) {
      this.requestField("favorite_teams", value);
      return this;
    }
    public APIRequestGetSubmitters requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetSubmitters requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetSubmitters requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetSubmitters requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetSubmitters requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetSubmitters requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetSubmitters requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetSubmitters requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetSubmitters requestInspirationalPeopleField () {
      return this.requestInspirationalPeopleField(true);
    }
    public APIRequestGetSubmitters requestInspirationalPeopleField (boolean value) {
      this.requestField("inspirational_people", value);
      return this;
    }
    public APIRequestGetSubmitters requestInstallTypeField () {
      return this.requestInstallTypeField(true);
    }
    public APIRequestGetSubmitters requestInstallTypeField (boolean value) {
      this.requestField("install_type", value);
      return this;
    }
    public APIRequestGetSubmitters requestInstalledField () {
      return this.requestInstalledField(true);
    }
    public APIRequestGetSubmitters requestInstalledField (boolean value) {
      this.requestField("installed", value);
      return this;
    }
    public APIRequestGetSubmitters requestInterestedInField () {
      return this.requestInterestedInField(true);
    }
    public APIRequestGetSubmitters requestInterestedInField (boolean value) {
      this.requestField("interested_in", value);
      return this;
    }
    public APIRequestGetSubmitters requestIsFamedeeplinkinguserField () {
      return this.requestIsFamedeeplinkinguserField(true);
    }
    public APIRequestGetSubmitters requestIsFamedeeplinkinguserField (boolean value) {
      this.requestField("is_famedeeplinkinguser", value);
      return this;
    }
    public APIRequestGetSubmitters requestIsGuestUserField () {
      return this.requestIsGuestUserField(true);
    }
    public APIRequestGetSubmitters requestIsGuestUserField (boolean value) {
      this.requestField("is_guest_user", value);
      return this;
    }
    public APIRequestGetSubmitters requestIsSharedLoginField () {
      return this.requestIsSharedLoginField(true);
    }
    public APIRequestGetSubmitters requestIsSharedLoginField (boolean value) {
      this.requestField("is_shared_login", value);
      return this;
    }
    public APIRequestGetSubmitters requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetSubmitters requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetSubmitters requestLanguagesField () {
      return this.requestLanguagesField(true);
    }
    public APIRequestGetSubmitters requestLanguagesField (boolean value) {
      this.requestField("languages", value);
      return this;
    }
    public APIRequestGetSubmitters requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetSubmitters requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetSubmitters requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetSubmitters requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetSubmitters requestLocalNewsMegaphoneDismissStatusField () {
      return this.requestLocalNewsMegaphoneDismissStatusField(true);
    }
    public APIRequestGetSubmitters requestLocalNewsMegaphoneDismissStatusField (boolean value) {
      this.requestField("local_news_megaphone_dismiss_status", value);
      return this;
    }
    public APIRequestGetSubmitters requestLocalNewsSubscriptionStatusField () {
      return this.requestLocalNewsSubscriptionStatusField(true);
    }
    public APIRequestGetSubmitters requestLocalNewsSubscriptionStatusField (boolean value) {
      this.requestField("local_news_subscription_status", value);
      return this;
    }
    public APIRequestGetSubmitters requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetSubmitters requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetSubmitters requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetSubmitters requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetSubmitters requestMeetingForField () {
      return this.requestMeetingForField(true);
    }
    public APIRequestGetSubmitters requestMeetingForField (boolean value) {
      this.requestField("meeting_for", value);
      return this;
    }
    public APIRequestGetSubmitters requestMiddleNameField () {
      return this.requestMiddleNameField(true);
    }
    public APIRequestGetSubmitters requestMiddleNameField (boolean value) {
      this.requestField("middle_name", value);
      return this;
    }
    public APIRequestGetSubmitters requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetSubmitters requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetSubmitters requestNameFormatField () {
      return this.requestNameFormatField(true);
    }
    public APIRequestGetSubmitters requestNameFormatField (boolean value) {
      this.requestField("name_format", value);
      return this;
    }
    public APIRequestGetSubmitters requestPaymentPricepointsField () {
      return this.requestPaymentPricepointsField(true);
    }
    public APIRequestGetSubmitters requestPaymentPricepointsField (boolean value) {
      this.requestField("payment_pricepoints", value);
      return this;
    }
    public APIRequestGetSubmitters requestPoliticalField () {
      return this.requestPoliticalField(true);
    }
    public APIRequestGetSubmitters requestPoliticalField (boolean value) {
      this.requestField("political", value);
      return this;
    }
    public APIRequestGetSubmitters requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetSubmitters requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetSubmitters requestPublicKeyField () {
      return this.requestPublicKeyField(true);
    }
    public APIRequestGetSubmitters requestPublicKeyField (boolean value) {
      this.requestField("public_key", value);
      return this;
    }
    public APIRequestGetSubmitters requestQuotesField () {
      return this.requestQuotesField(true);
    }
    public APIRequestGetSubmitters requestQuotesField (boolean value) {
      this.requestField("quotes", value);
      return this;
    }
    public APIRequestGetSubmitters requestRelationshipStatusField () {
      return this.requestRelationshipStatusField(true);
    }
    public APIRequestGetSubmitters requestRelationshipStatusField (boolean value) {
      this.requestField("relationship_status", value);
      return this;
    }
    public APIRequestGetSubmitters requestReligionField () {
      return this.requestReligionField(true);
    }
    public APIRequestGetSubmitters requestReligionField (boolean value) {
      this.requestField("religion", value);
      return this;
    }
    public APIRequestGetSubmitters requestSecuritySettingsField () {
      return this.requestSecuritySettingsField(true);
    }
    public APIRequestGetSubmitters requestSecuritySettingsField (boolean value) {
      this.requestField("security_settings", value);
      return this;
    }
    public APIRequestGetSubmitters requestSharedLoginUpgradeRequiredByField () {
      return this.requestSharedLoginUpgradeRequiredByField(true);
    }
    public APIRequestGetSubmitters requestSharedLoginUpgradeRequiredByField (boolean value) {
      this.requestField("shared_login_upgrade_required_by", value);
      return this;
    }
    public APIRequestGetSubmitters requestShortNameField () {
      return this.requestShortNameField(true);
    }
    public APIRequestGetSubmitters requestShortNameField (boolean value) {
      this.requestField("short_name", value);
      return this;
    }
    public APIRequestGetSubmitters requestSignificantOtherField () {
      return this.requestSignificantOtherField(true);
    }
    public APIRequestGetSubmitters requestSignificantOtherField (boolean value) {
      this.requestField("significant_other", value);
      return this;
    }
    public APIRequestGetSubmitters requestSportsField () {
      return this.requestSportsField(true);
    }
    public APIRequestGetSubmitters requestSportsField (boolean value) {
      this.requestField("sports", value);
      return this;
    }
    public APIRequestGetSubmitters requestSupportsDonateButtonInLiveVideoField () {
      return this.requestSupportsDonateButtonInLiveVideoField(true);
    }
    public APIRequestGetSubmitters requestSupportsDonateButtonInLiveVideoField (boolean value) {
      this.requestField("supports_donate_button_in_live_video", value);
      return this;
    }
    public APIRequestGetSubmitters requestTestGroupField () {
      return this.requestTestGroupField(true);
    }
    public APIRequestGetSubmitters requestTestGroupField (boolean value) {
      this.requestField("test_group", value);
      return this;
    }
    public APIRequestGetSubmitters requestThirdPartyIdField () {
      return this.requestThirdPartyIdField(true);
    }
    public APIRequestGetSubmitters requestThirdPartyIdField (boolean value) {
      this.requestField("third_party_id", value);
      return this;
    }
    public APIRequestGetSubmitters requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetSubmitters requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetSubmitters requestTokenForBusinessField () {
      return this.requestTokenForBusinessField(true);
    }
    public APIRequestGetSubmitters requestTokenForBusinessField (boolean value) {
      this.requestField("token_for_business", value);
      return this;
    }
    public APIRequestGetSubmitters requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetSubmitters requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetSubmitters requestVerifiedField () {
      return this.requestVerifiedField(true);
    }
    public APIRequestGetSubmitters requestVerifiedField (boolean value) {
      this.requestField("verified", value);
      return this;
    }
    public APIRequestGetSubmitters requestVideoUploadLimitsField () {
      return this.requestVideoUploadLimitsField(true);
    }
    public APIRequestGetSubmitters requestVideoUploadLimitsField (boolean value) {
      this.requestField("video_upload_limits", value);
      return this;
    }
    public APIRequestGetSubmitters requestViewerCanSendGiftField () {
      return this.requestViewerCanSendGiftField(true);
    }
    public APIRequestGetSubmitters requestViewerCanSendGiftField (boolean value) {
      this.requestField("viewer_can_send_gift", value);
      return this;
    }
    public APIRequestGetSubmitters requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetSubmitters requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetSubmitters requestWorkField () {
      return this.requestWorkField(true);
    }
    public APIRequestGetSubmitters requestWorkField (boolean value) {
      this.requestField("work", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<PartnerStudy> {

    PartnerStudy lastResponse = null;
    @Override
    public PartnerStudy getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "additional_info",
      "brand",
      "client_name",
      "emails",
      "id",
      "input_ids",
      "is_export",
      "lift_study",
      "location",
      "match_file_ds",
      "name",
      "partner_defined_id",
      "partner_household_graph_dataset_id",
      "status",
      "study_end_date",
      "study_start_date",
      "study_type",
      "submit_date",
    };

    @Override
    public PartnerStudy parseResponse(String response, String header) throws APIException {
      return PartnerStudy.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PartnerStudy execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PartnerStudy execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PartnerStudy> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PartnerStudy> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PartnerStudy>() {
           public PartnerStudy apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdditionalInfoField () {
      return this.requestAdditionalInfoField(true);
    }
    public APIRequestGet requestAdditionalInfoField (boolean value) {
      this.requestField("additional_info", value);
      return this;
    }
    public APIRequestGet requestBrandField () {
      return this.requestBrandField(true);
    }
    public APIRequestGet requestBrandField (boolean value) {
      this.requestField("brand", value);
      return this;
    }
    public APIRequestGet requestClientNameField () {
      return this.requestClientNameField(true);
    }
    public APIRequestGet requestClientNameField (boolean value) {
      this.requestField("client_name", value);
      return this;
    }
    public APIRequestGet requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGet requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInputIdsField () {
      return this.requestInputIdsField(true);
    }
    public APIRequestGet requestInputIdsField (boolean value) {
      this.requestField("input_ids", value);
      return this;
    }
    public APIRequestGet requestIsExportField () {
      return this.requestIsExportField(true);
    }
    public APIRequestGet requestIsExportField (boolean value) {
      this.requestField("is_export", value);
      return this;
    }
    public APIRequestGet requestLiftStudyField () {
      return this.requestLiftStudyField(true);
    }
    public APIRequestGet requestLiftStudyField (boolean value) {
      this.requestField("lift_study", value);
      return this;
    }
    public APIRequestGet requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGet requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGet requestMatchFileDsField () {
      return this.requestMatchFileDsField(true);
    }
    public APIRequestGet requestMatchFileDsField (boolean value) {
      this.requestField("match_file_ds", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPartnerDefinedIdField () {
      return this.requestPartnerDefinedIdField(true);
    }
    public APIRequestGet requestPartnerDefinedIdField (boolean value) {
      this.requestField("partner_defined_id", value);
      return this;
    }
    public APIRequestGet requestPartnerHouseholdGraphDatasetIdField () {
      return this.requestPartnerHouseholdGraphDatasetIdField(true);
    }
    public APIRequestGet requestPartnerHouseholdGraphDatasetIdField (boolean value) {
      this.requestField("partner_household_graph_dataset_id", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestStudyEndDateField () {
      return this.requestStudyEndDateField(true);
    }
    public APIRequestGet requestStudyEndDateField (boolean value) {
      this.requestField("study_end_date", value);
      return this;
    }
    public APIRequestGet requestStudyStartDateField () {
      return this.requestStudyStartDateField(true);
    }
    public APIRequestGet requestStudyStartDateField (boolean value) {
      this.requestField("study_start_date", value);
      return this;
    }
    public APIRequestGet requestStudyTypeField () {
      return this.requestStudyTypeField(true);
    }
    public APIRequestGet requestStudyTypeField (boolean value) {
      this.requestField("study_type", value);
      return this;
    }
    public APIRequestGet requestSubmitDateField () {
      return this.requestSubmitDateField(true);
    }
    public APIRequestGet requestSubmitDateField (boolean value) {
      this.requestField("submit_date", value);
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

  public PartnerStudy copyFrom(PartnerStudy instance) {
    this.mAdditionalInfo = instance.mAdditionalInfo;
    this.mBrand = instance.mBrand;
    this.mClientName = instance.mClientName;
    this.mEmails = instance.mEmails;
    this.mId = instance.mId;
    this.mInputIds = instance.mInputIds;
    this.mIsExport = instance.mIsExport;
    this.mLiftStudy = instance.mLiftStudy;
    this.mLocation = instance.mLocation;
    this.mMatchFileDs = instance.mMatchFileDs;
    this.mName = instance.mName;
    this.mPartnerDefinedId = instance.mPartnerDefinedId;
    this.mPartnerHouseholdGraphDatasetId = instance.mPartnerHouseholdGraphDatasetId;
    this.mStatus = instance.mStatus;
    this.mStudyEndDate = instance.mStudyEndDate;
    this.mStudyStartDate = instance.mStudyStartDate;
    this.mStudyType = instance.mStudyType;
    this.mSubmitDate = instance.mSubmitDate;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PartnerStudy> getParser() {
    return new APIRequest.ResponseParser<PartnerStudy>() {
      public APINodeList<PartnerStudy> parseResponse(String response, APIContext context, APIRequest<PartnerStudy> request, String header) throws MalformedResponseException {
        return PartnerStudy.parseResponse(response, context, request, header);
      }
    };
  }
}
