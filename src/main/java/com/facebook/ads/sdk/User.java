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
public class User extends APINode {
  @SerializedName("about")
  private String mAbout = null;
  @SerializedName("admin_notes")
  private List<Object> mAdminNotes = null;
  @SerializedName("age_range")
  private Object mAgeRange = null;
  @SerializedName("birthday")
  private String mBirthday = null;
  @SerializedName("can_review_measurement_request")
  private Boolean mCanReviewMeasurementRequest = null;
  @SerializedName("context")
  private Object mContext = null;
  @SerializedName("cover")
  private Object mCover = null;
  @SerializedName("currency")
  private Object mCurrency = null;
  @SerializedName("devices")
  private List<Object> mDevices = null;
  @SerializedName("education")
  private List<Object> mEducation = null;
  @SerializedName("email")
  private String mEmail = null;
  @SerializedName("employee_number")
  private String mEmployeeNumber = null;
  @SerializedName("favorite_athletes")
  private List<Object> mFavoriteAthletes = null;
  @SerializedName("favorite_teams")
  private List<Object> mFavoriteTeams = null;
  @SerializedName("first_name")
  private String mFirstName = null;
  @SerializedName("gender")
  private String mGender = null;
  @SerializedName("hometown")
  private Object mHometown = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("inspirational_people")
  private List<Object> mInspirationalPeople = null;
  @SerializedName("install_type")
  private String mInstallType = null;
  @SerializedName("installed")
  private Boolean mInstalled = null;
  @SerializedName("interested_in")
  private List<String> mInterestedIn = null;
  @SerializedName("is_shared_login")
  private Boolean mIsSharedLogin = null;
  @SerializedName("is_verified")
  private Boolean mIsVerified = null;
  @SerializedName("labels")
  private List<Object> mLabels = null;
  @SerializedName("languages")
  private List<Object> mLanguages = null;
  @SerializedName("last_name")
  private String mLastName = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("locale")
  private String mLocale = null;
  @SerializedName("location")
  private Object mLocation = null;
  @SerializedName("meeting_for")
  private List<String> mMeetingFor = null;
  @SerializedName("middle_name")
  private String mMiddleName = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("name_format")
  private String mNameFormat = null;
  @SerializedName("payment_pricepoints")
  private Object mPaymentPricepoints = null;
  @SerializedName("political")
  private String mPolitical = null;
  @SerializedName("public_key")
  private String mPublicKey = null;
  @SerializedName("quotes")
  private String mQuotes = null;
  @SerializedName("relationship_status")
  private String mRelationshipStatus = null;
  @SerializedName("religion")
  private String mReligion = null;
  @SerializedName("security_settings")
  private Object mSecuritySettings = null;
  @SerializedName("shared_login_upgrade_required_by")
  private String mSharedLoginUpgradeRequiredBy = null;
  @SerializedName("short_name")
  private String mShortName = null;
  @SerializedName("significant_other")
  private User mSignificantOther = null;
  @SerializedName("sports")
  private List<Object> mSports = null;
  @SerializedName("test_group")
  private Long mTestGroup = null;
  @SerializedName("third_party_id")
  private String mThirdPartyId = null;
  @SerializedName("timezone")
  private Double mTimezone = null;
  @SerializedName("token_for_business")
  private String mTokenForBusiness = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("verified")
  private Boolean mVerified = null;
  @SerializedName("video_upload_limits")
  private Object mVideoUploadLimits = null;
  @SerializedName("viewer_can_send_gift")
  private Boolean mViewerCanSendGift = null;
  @SerializedName("website")
  private String mWebsite = null;
  @SerializedName("work")
  private List<Object> mWork = null;
  protected static Gson gson = null;

  User() {
  }

  public User(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public User(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public User fetch() throws APIException{
    User newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static User fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static User fetchById(String id, APIContext context) throws APIException {
    User user =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return user;
  }

  public static APINodeList<User> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<User>)(
      new APIRequest<User>(context, "", "/", "GET", User.getParser())
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
  public static User loadJSON(String json, APIContext context) {
    User user = getGson().fromJson(json, User.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(user.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    user.context = context;
    user.rawValue = json;
    return user;
  }

  public static APINodeList<User> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<User> users = new APINodeList<User>(request, json);
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
          users.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return users;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            users.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              users.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  users.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              users.add(loadJSON(obj.toString(), context));
            }
          }
          return users;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              users.add(loadJSON(entry.getValue().toString(), context));
          }
          return users;
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
              users.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return users;
          }

          // Sixth, check if it's pure JsonObject
          users.clear();
          users.add(loadJSON(json, context));
          return users;
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

  public APIRequestGetAccounts getAccounts() {
    return new APIRequestGetAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdAccounts getAdAccounts() {
    return new APIRequestGetAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLeadGenForms getLeadGenForms() {
    return new APIRequestGetLeadGenForms(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPicture getPicture() {
    return new APIRequestGetPicture(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPromotableDomains getPromotableDomains() {
    return new APIRequestGetPromotableDomains(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPromotableEvents getPromotableEvents() {
    return new APIRequestGetPromotableEvents(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldAbout() {
    return mAbout;
  }

  public List<Object> getFieldAdminNotes() {
    return mAdminNotes;
  }

  public Object getFieldAgeRange() {
    return mAgeRange;
  }

  public String getFieldBirthday() {
    return mBirthday;
  }

  public Boolean getFieldCanReviewMeasurementRequest() {
    return mCanReviewMeasurementRequest;
  }

  public Object getFieldContext() {
    return mContext;
  }

  public Object getFieldCover() {
    return mCover;
  }

  public Object getFieldCurrency() {
    return mCurrency;
  }

  public List<Object> getFieldDevices() {
    return mDevices;
  }

  public List<Object> getFieldEducation() {
    return mEducation;
  }

  public String getFieldEmail() {
    return mEmail;
  }

  public String getFieldEmployeeNumber() {
    return mEmployeeNumber;
  }

  public List<Object> getFieldFavoriteAthletes() {
    return mFavoriteAthletes;
  }

  public List<Object> getFieldFavoriteTeams() {
    return mFavoriteTeams;
  }

  public String getFieldFirstName() {
    return mFirstName;
  }

  public String getFieldGender() {
    return mGender;
  }

  public Object getFieldHometown() {
    return mHometown;
  }

  public String getFieldId() {
    return mId;
  }

  public List<Object> getFieldInspirationalPeople() {
    return mInspirationalPeople;
  }

  public String getFieldInstallType() {
    return mInstallType;
  }

  public Boolean getFieldInstalled() {
    return mInstalled;
  }

  public List<String> getFieldInterestedIn() {
    return mInterestedIn;
  }

  public Boolean getFieldIsSharedLogin() {
    return mIsSharedLogin;
  }

  public Boolean getFieldIsVerified() {
    return mIsVerified;
  }

  public List<Object> getFieldLabels() {
    return mLabels;
  }

  public List<Object> getFieldLanguages() {
    return mLanguages;
  }

  public String getFieldLastName() {
    return mLastName;
  }

  public String getFieldLink() {
    return mLink;
  }

  public String getFieldLocale() {
    return mLocale;
  }

  public Object getFieldLocation() {
    return mLocation;
  }

  public List<String> getFieldMeetingFor() {
    return mMeetingFor;
  }

  public String getFieldMiddleName() {
    return mMiddleName;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldNameFormat() {
    return mNameFormat;
  }

  public Object getFieldPaymentPricepoints() {
    return mPaymentPricepoints;
  }

  public String getFieldPolitical() {
    return mPolitical;
  }

  public String getFieldPublicKey() {
    return mPublicKey;
  }

  public String getFieldQuotes() {
    return mQuotes;
  }

  public String getFieldRelationshipStatus() {
    return mRelationshipStatus;
  }

  public String getFieldReligion() {
    return mReligion;
  }

  public Object getFieldSecuritySettings() {
    return mSecuritySettings;
  }

  public String getFieldSharedLoginUpgradeRequiredBy() {
    return mSharedLoginUpgradeRequiredBy;
  }

  public String getFieldShortName() {
    return mShortName;
  }

  public User getFieldSignificantOther() {
    if (mSignificantOther != null) {
      mSignificantOther.context = getContext();
    }
    return mSignificantOther;
  }

  public List<Object> getFieldSports() {
    return mSports;
  }

  public Long getFieldTestGroup() {
    return mTestGroup;
  }

  public String getFieldThirdPartyId() {
    return mThirdPartyId;
  }

  public Double getFieldTimezone() {
    return mTimezone;
  }

  public String getFieldTokenForBusiness() {
    return mTokenForBusiness;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public Boolean getFieldVerified() {
    return mVerified;
  }

  public Object getFieldVideoUploadLimits() {
    return mVideoUploadLimits;
  }

  public Boolean getFieldViewerCanSendGift() {
    return mViewerCanSendGift;
  }

  public String getFieldWebsite() {
    return mWebsite;
  }

  public List<Object> getFieldWork() {
    return mWork;
  }



  public static class APIRequestGetAccounts extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business_id",
      "is_business",
      "is_place",
      "is_promotable",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAccounts setBusinessId (String businessId) {
      this.setParam("business_id", businessId);
      return this;
    }

    public APIRequestGetAccounts setIsBusiness (Boolean isBusiness) {
      this.setParam("is_business", isBusiness);
      return this;
    }
    public APIRequestGetAccounts setIsBusiness (String isBusiness) {
      this.setParam("is_business", isBusiness);
      return this;
    }

    public APIRequestGetAccounts setIsPlace (Boolean isPlace) {
      this.setParam("is_place", isPlace);
      return this;
    }
    public APIRequestGetAccounts setIsPlace (String isPlace) {
      this.setParam("is_place", isPlace);
      return this;
    }

    public APIRequestGetAccounts setIsPromotable (Boolean isPromotable) {
      this.setParam("is_promotable", isPromotable);
      return this;
    }
    public APIRequestGetAccounts setIsPromotable (String isPromotable) {
      this.setParam("is_promotable", isPromotable);
      return this;
    }

    public APIRequestGetAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdAccounts extends APIRequest<AdAccount> {

    APINodeList<AdAccount> lastResponse = null;
    @Override
    public APINodeList<AdAccount> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "account_status",
      "age",
      "agency_client_declaration",
      "amount_spent",
      "attribution_spec",
      "balance",
      "business",
      "business_city",
      "business_country_code",
      "business_name",
      "business_state",
      "business_street",
      "business_street2",
      "business_zip",
      "capabilities",
      "created_time",
      "currency",
      "disable_reason",
      "end_advertiser",
      "end_advertiser_name",
      "failed_delivery_checks",
      "funding_source",
      "funding_source_details",
      "has_migrated_permissions",
      "id",
      "io_number",
      "is_attribution_spec_system_default",
      "is_notifications_enabled",
      "is_personal",
      "is_prepay_account",
      "is_tax_id_required",
      "line_numbers",
      "media_agency",
      "min_campaign_group_spend_cap",
      "min_daily_budget",
      "name",
      "offsite_pixels_tos_accepted",
      "owner",
      "partner",
      "rf_spec",
      "salesforce_invoice_group_id",
      "show_checkout_experience",
      "spend_cap",
      "tax_id",
      "tax_id_status",
      "tax_id_type",
      "timezone_id",
      "timezone_name",
      "timezone_offset_hours_utc",
      "tos_accepted",
      "user_role",
    };

    @Override
    public APINodeList<AdAccount> parseResponse(String response) throws APIException {
      return AdAccount.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccount> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccount> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdAccounts requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdAccounts requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdAccounts requestAccountStatusField () {
      return this.requestAccountStatusField(true);
    }
    public APIRequestGetAdAccounts requestAccountStatusField (boolean value) {
      this.requestField("account_status", value);
      return this;
    }
    public APIRequestGetAdAccounts requestAgeField () {
      return this.requestAgeField(true);
    }
    public APIRequestGetAdAccounts requestAgeField (boolean value) {
      this.requestField("age", value);
      return this;
    }
    public APIRequestGetAdAccounts requestAgencyClientDeclarationField () {
      return this.requestAgencyClientDeclarationField(true);
    }
    public APIRequestGetAdAccounts requestAgencyClientDeclarationField (boolean value) {
      this.requestField("agency_client_declaration", value);
      return this;
    }
    public APIRequestGetAdAccounts requestAmountSpentField () {
      return this.requestAmountSpentField(true);
    }
    public APIRequestGetAdAccounts requestAmountSpentField (boolean value) {
      this.requestField("amount_spent", value);
      return this;
    }
    public APIRequestGetAdAccounts requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGetAdAccounts requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBalanceField () {
      return this.requestBalanceField(true);
    }
    public APIRequestGetAdAccounts requestBalanceField (boolean value) {
      this.requestField("balance", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAdAccounts requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBusinessCityField () {
      return this.requestBusinessCityField(true);
    }
    public APIRequestGetAdAccounts requestBusinessCityField (boolean value) {
      this.requestField("business_city", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBusinessCountryCodeField () {
      return this.requestBusinessCountryCodeField(true);
    }
    public APIRequestGetAdAccounts requestBusinessCountryCodeField (boolean value) {
      this.requestField("business_country_code", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBusinessNameField () {
      return this.requestBusinessNameField(true);
    }
    public APIRequestGetAdAccounts requestBusinessNameField (boolean value) {
      this.requestField("business_name", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBusinessStateField () {
      return this.requestBusinessStateField(true);
    }
    public APIRequestGetAdAccounts requestBusinessStateField (boolean value) {
      this.requestField("business_state", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBusinessStreetField () {
      return this.requestBusinessStreetField(true);
    }
    public APIRequestGetAdAccounts requestBusinessStreetField (boolean value) {
      this.requestField("business_street", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBusinessStreet2Field () {
      return this.requestBusinessStreet2Field(true);
    }
    public APIRequestGetAdAccounts requestBusinessStreet2Field (boolean value) {
      this.requestField("business_street2", value);
      return this;
    }
    public APIRequestGetAdAccounts requestBusinessZipField () {
      return this.requestBusinessZipField(true);
    }
    public APIRequestGetAdAccounts requestBusinessZipField (boolean value) {
      this.requestField("business_zip", value);
      return this;
    }
    public APIRequestGetAdAccounts requestCapabilitiesField () {
      return this.requestCapabilitiesField(true);
    }
    public APIRequestGetAdAccounts requestCapabilitiesField (boolean value) {
      this.requestField("capabilities", value);
      return this;
    }
    public APIRequestGetAdAccounts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAdAccounts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAdAccounts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetAdAccounts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetAdAccounts requestDisableReasonField () {
      return this.requestDisableReasonField(true);
    }
    public APIRequestGetAdAccounts requestDisableReasonField (boolean value) {
      this.requestField("disable_reason", value);
      return this;
    }
    public APIRequestGetAdAccounts requestEndAdvertiserField () {
      return this.requestEndAdvertiserField(true);
    }
    public APIRequestGetAdAccounts requestEndAdvertiserField (boolean value) {
      this.requestField("end_advertiser", value);
      return this;
    }
    public APIRequestGetAdAccounts requestEndAdvertiserNameField () {
      return this.requestEndAdvertiserNameField(true);
    }
    public APIRequestGetAdAccounts requestEndAdvertiserNameField (boolean value) {
      this.requestField("end_advertiser_name", value);
      return this;
    }
    public APIRequestGetAdAccounts requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetAdAccounts requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGetAdAccounts requestFundingSourceField () {
      return this.requestFundingSourceField(true);
    }
    public APIRequestGetAdAccounts requestFundingSourceField (boolean value) {
      this.requestField("funding_source", value);
      return this;
    }
    public APIRequestGetAdAccounts requestFundingSourceDetailsField () {
      return this.requestFundingSourceDetailsField(true);
    }
    public APIRequestGetAdAccounts requestFundingSourceDetailsField (boolean value) {
      this.requestField("funding_source_details", value);
      return this;
    }
    public APIRequestGetAdAccounts requestHasMigratedPermissionsField () {
      return this.requestHasMigratedPermissionsField(true);
    }
    public APIRequestGetAdAccounts requestHasMigratedPermissionsField (boolean value) {
      this.requestField("has_migrated_permissions", value);
      return this;
    }
    public APIRequestGetAdAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdAccounts requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGetAdAccounts requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGetAdAccounts requestIsAttributionSpecSystemDefaultField () {
      return this.requestIsAttributionSpecSystemDefaultField(true);
    }
    public APIRequestGetAdAccounts requestIsAttributionSpecSystemDefaultField (boolean value) {
      this.requestField("is_attribution_spec_system_default", value);
      return this;
    }
    public APIRequestGetAdAccounts requestIsNotificationsEnabledField () {
      return this.requestIsNotificationsEnabledField(true);
    }
    public APIRequestGetAdAccounts requestIsNotificationsEnabledField (boolean value) {
      this.requestField("is_notifications_enabled", value);
      return this;
    }
    public APIRequestGetAdAccounts requestIsPersonalField () {
      return this.requestIsPersonalField(true);
    }
    public APIRequestGetAdAccounts requestIsPersonalField (boolean value) {
      this.requestField("is_personal", value);
      return this;
    }
    public APIRequestGetAdAccounts requestIsPrepayAccountField () {
      return this.requestIsPrepayAccountField(true);
    }
    public APIRequestGetAdAccounts requestIsPrepayAccountField (boolean value) {
      this.requestField("is_prepay_account", value);
      return this;
    }
    public APIRequestGetAdAccounts requestIsTaxIdRequiredField () {
      return this.requestIsTaxIdRequiredField(true);
    }
    public APIRequestGetAdAccounts requestIsTaxIdRequiredField (boolean value) {
      this.requestField("is_tax_id_required", value);
      return this;
    }
    public APIRequestGetAdAccounts requestLineNumbersField () {
      return this.requestLineNumbersField(true);
    }
    public APIRequestGetAdAccounts requestLineNumbersField (boolean value) {
      this.requestField("line_numbers", value);
      return this;
    }
    public APIRequestGetAdAccounts requestMediaAgencyField () {
      return this.requestMediaAgencyField(true);
    }
    public APIRequestGetAdAccounts requestMediaAgencyField (boolean value) {
      this.requestField("media_agency", value);
      return this;
    }
    public APIRequestGetAdAccounts requestMinCampaignGroupSpendCapField () {
      return this.requestMinCampaignGroupSpendCapField(true);
    }
    public APIRequestGetAdAccounts requestMinCampaignGroupSpendCapField (boolean value) {
      this.requestField("min_campaign_group_spend_cap", value);
      return this;
    }
    public APIRequestGetAdAccounts requestMinDailyBudgetField () {
      return this.requestMinDailyBudgetField(true);
    }
    public APIRequestGetAdAccounts requestMinDailyBudgetField (boolean value) {
      this.requestField("min_daily_budget", value);
      return this;
    }
    public APIRequestGetAdAccounts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdAccounts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdAccounts requestOffsitePixelsTosAcceptedField () {
      return this.requestOffsitePixelsTosAcceptedField(true);
    }
    public APIRequestGetAdAccounts requestOffsitePixelsTosAcceptedField (boolean value) {
      this.requestField("offsite_pixels_tos_accepted", value);
      return this;
    }
    public APIRequestGetAdAccounts requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetAdAccounts requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetAdAccounts requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetAdAccounts requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetAdAccounts requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGetAdAccounts requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
      return this;
    }
    public APIRequestGetAdAccounts requestSalesforceInvoiceGroupIdField () {
      return this.requestSalesforceInvoiceGroupIdField(true);
    }
    public APIRequestGetAdAccounts requestSalesforceInvoiceGroupIdField (boolean value) {
      this.requestField("salesforce_invoice_group_id", value);
      return this;
    }
    public APIRequestGetAdAccounts requestShowCheckoutExperienceField () {
      return this.requestShowCheckoutExperienceField(true);
    }
    public APIRequestGetAdAccounts requestShowCheckoutExperienceField (boolean value) {
      this.requestField("show_checkout_experience", value);
      return this;
    }
    public APIRequestGetAdAccounts requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetAdAccounts requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGetAdAccounts requestTaxIdField () {
      return this.requestTaxIdField(true);
    }
    public APIRequestGetAdAccounts requestTaxIdField (boolean value) {
      this.requestField("tax_id", value);
      return this;
    }
    public APIRequestGetAdAccounts requestTaxIdStatusField () {
      return this.requestTaxIdStatusField(true);
    }
    public APIRequestGetAdAccounts requestTaxIdStatusField (boolean value) {
      this.requestField("tax_id_status", value);
      return this;
    }
    public APIRequestGetAdAccounts requestTaxIdTypeField () {
      return this.requestTaxIdTypeField(true);
    }
    public APIRequestGetAdAccounts requestTaxIdTypeField (boolean value) {
      this.requestField("tax_id_type", value);
      return this;
    }
    public APIRequestGetAdAccounts requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetAdAccounts requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetAdAccounts requestTimezoneNameField () {
      return this.requestTimezoneNameField(true);
    }
    public APIRequestGetAdAccounts requestTimezoneNameField (boolean value) {
      this.requestField("timezone_name", value);
      return this;
    }
    public APIRequestGetAdAccounts requestTimezoneOffsetHoursUtcField () {
      return this.requestTimezoneOffsetHoursUtcField(true);
    }
    public APIRequestGetAdAccounts requestTimezoneOffsetHoursUtcField (boolean value) {
      this.requestField("timezone_offset_hours_utc", value);
      return this;
    }
    public APIRequestGetAdAccounts requestTosAcceptedField () {
      return this.requestTosAcceptedField(true);
    }
    public APIRequestGetAdAccounts requestTosAcceptedField (boolean value) {
      this.requestField("tos_accepted", value);
      return this;
    }
    public APIRequestGetAdAccounts requestUserRoleField () {
      return this.requestUserRoleField(true);
    }
    public APIRequestGetAdAccounts requestUserRoleField (boolean value) {
      this.requestField("user_role", value);
      return this;
    }
  }

  public static class APIRequestGetLeadGenForms extends APIRequest<LeadgenForm> {

    APINodeList<LeadgenForm> lastResponse = null;
    @Override
    public APINodeList<LeadgenForm> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "page_id",
      "query",
    };

    public static final String[] FIELDS = {
      "allow_organic_lead",
      "block_display_for_non_targeted_viewer",
      "context_card",
      "continued_flow_request_method",
      "created_time",
      "creator",
      "creator_id",
      "cusomized_tcpa_content",
      "expired_leads_count",
      "follow_up_action_text",
      "follow_up_action_url",
      "id",
      "is_continued_flow",
      "leadgen_export_csv_url",
      "leads_count",
      "legal_content",
      "locale",
      "messenger_welcome_message",
      "name",
      "organic_leads_count",
      "page",
      "page_id",
      "privacy_policy_url",
      "qualifiers",
      "questions",
      "status",
      "tcpa_compliance",
    };

    @Override
    public APINodeList<LeadgenForm> parseResponse(String response) throws APIException {
      return LeadgenForm.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<LeadgenForm> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<LeadgenForm> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetLeadGenForms(String nodeId, APIContext context) {
      super(context, nodeId, "/leadgen_forms", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLeadGenForms setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLeadGenForms setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLeadGenForms setPageId (String pageId) {
      this.setParam("page_id", pageId);
      return this;
    }

    public APIRequestGetLeadGenForms setQuery (String query) {
      this.setParam("query", query);
      return this;
    }

    public APIRequestGetLeadGenForms requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLeadGenForms requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLeadGenForms requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLeadGenForms requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLeadGenForms requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLeadGenForms requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetLeadGenForms requestAllowOrganicLeadField () {
      return this.requestAllowOrganicLeadField(true);
    }
    public APIRequestGetLeadGenForms requestAllowOrganicLeadField (boolean value) {
      this.requestField("allow_organic_lead", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestBlockDisplayForNonTargetedViewerField () {
      return this.requestBlockDisplayForNonTargetedViewerField(true);
    }
    public APIRequestGetLeadGenForms requestBlockDisplayForNonTargetedViewerField (boolean value) {
      this.requestField("block_display_for_non_targeted_viewer", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestContextCardField () {
      return this.requestContextCardField(true);
    }
    public APIRequestGetLeadGenForms requestContextCardField (boolean value) {
      this.requestField("context_card", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestContinuedFlowRequestMethodField () {
      return this.requestContinuedFlowRequestMethodField(true);
    }
    public APIRequestGetLeadGenForms requestContinuedFlowRequestMethodField (boolean value) {
      this.requestField("continued_flow_request_method", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetLeadGenForms requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetLeadGenForms requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestCreatorIdField () {
      return this.requestCreatorIdField(true);
    }
    public APIRequestGetLeadGenForms requestCreatorIdField (boolean value) {
      this.requestField("creator_id", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestCusomizedTcpaContentField () {
      return this.requestCusomizedTcpaContentField(true);
    }
    public APIRequestGetLeadGenForms requestCusomizedTcpaContentField (boolean value) {
      this.requestField("cusomized_tcpa_content", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestExpiredLeadsCountField () {
      return this.requestExpiredLeadsCountField(true);
    }
    public APIRequestGetLeadGenForms requestExpiredLeadsCountField (boolean value) {
      this.requestField("expired_leads_count", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestFollowUpActionTextField () {
      return this.requestFollowUpActionTextField(true);
    }
    public APIRequestGetLeadGenForms requestFollowUpActionTextField (boolean value) {
      this.requestField("follow_up_action_text", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestFollowUpActionUrlField () {
      return this.requestFollowUpActionUrlField(true);
    }
    public APIRequestGetLeadGenForms requestFollowUpActionUrlField (boolean value) {
      this.requestField("follow_up_action_url", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetLeadGenForms requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestIsContinuedFlowField () {
      return this.requestIsContinuedFlowField(true);
    }
    public APIRequestGetLeadGenForms requestIsContinuedFlowField (boolean value) {
      this.requestField("is_continued_flow", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestLeadgenExportCsvUrlField () {
      return this.requestLeadgenExportCsvUrlField(true);
    }
    public APIRequestGetLeadGenForms requestLeadgenExportCsvUrlField (boolean value) {
      this.requestField("leadgen_export_csv_url", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestLeadsCountField () {
      return this.requestLeadsCountField(true);
    }
    public APIRequestGetLeadGenForms requestLeadsCountField (boolean value) {
      this.requestField("leads_count", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestLegalContentField () {
      return this.requestLegalContentField(true);
    }
    public APIRequestGetLeadGenForms requestLegalContentField (boolean value) {
      this.requestField("legal_content", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetLeadGenForms requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestMessengerWelcomeMessageField () {
      return this.requestMessengerWelcomeMessageField(true);
    }
    public APIRequestGetLeadGenForms requestMessengerWelcomeMessageField (boolean value) {
      this.requestField("messenger_welcome_message", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetLeadGenForms requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestOrganicLeadsCountField () {
      return this.requestOrganicLeadsCountField(true);
    }
    public APIRequestGetLeadGenForms requestOrganicLeadsCountField (boolean value) {
      this.requestField("organic_leads_count", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGetLeadGenForms requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestPageIdField () {
      return this.requestPageIdField(true);
    }
    public APIRequestGetLeadGenForms requestPageIdField (boolean value) {
      this.requestField("page_id", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestPrivacyPolicyUrlField () {
      return this.requestPrivacyPolicyUrlField(true);
    }
    public APIRequestGetLeadGenForms requestPrivacyPolicyUrlField (boolean value) {
      this.requestField("privacy_policy_url", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestQualifiersField () {
      return this.requestQualifiersField(true);
    }
    public APIRequestGetLeadGenForms requestQualifiersField (boolean value) {
      this.requestField("qualifiers", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestQuestionsField () {
      return this.requestQuestionsField(true);
    }
    public APIRequestGetLeadGenForms requestQuestionsField (boolean value) {
      this.requestField("questions", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetLeadGenForms requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestTcpaComplianceField () {
      return this.requestTcpaComplianceField(true);
    }
    public APIRequestGetLeadGenForms requestTcpaComplianceField (boolean value) {
      this.requestField("tcpa_compliance", value);
      return this;
    }
  }

  public static class APIRequestGetPicture extends APIRequest<ProfilePictureSource> {

    APINodeList<ProfilePictureSource> lastResponse = null;
    @Override
    public APINodeList<ProfilePictureSource> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "height",
      "redirect",
      "type",
      "width",
    };

    public static final String[] FIELDS = {
      "bottom",
      "height",
      "is_silhouette",
      "left",
      "right",
      "top",
      "url",
      "width",
    };

    @Override
    public APINodeList<ProfilePictureSource> parseResponse(String response) throws APIException {
      return ProfilePictureSource.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProfilePictureSource> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProfilePictureSource> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetPicture(String nodeId, APIContext context) {
      super(context, nodeId, "/picture", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPicture setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPicture setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPicture setHeight (Long height) {
      this.setParam("height", height);
      return this;
    }
    public APIRequestGetPicture setHeight (String height) {
      this.setParam("height", height);
      return this;
    }

    public APIRequestGetPicture setRedirect (Boolean redirect) {
      this.setParam("redirect", redirect);
      return this;
    }
    public APIRequestGetPicture setRedirect (String redirect) {
      this.setParam("redirect", redirect);
      return this;
    }

    public APIRequestGetPicture setType (ProfilePictureSource.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestGetPicture setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestGetPicture setWidth (Long width) {
      this.setParam("width", width);
      return this;
    }
    public APIRequestGetPicture setWidth (String width) {
      this.setParam("width", width);
      return this;
    }

    public APIRequestGetPicture requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPicture requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPicture requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPicture requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPicture requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPicture requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPicture requestBottomField () {
      return this.requestBottomField(true);
    }
    public APIRequestGetPicture requestBottomField (boolean value) {
      this.requestField("bottom", value);
      return this;
    }
    public APIRequestGetPicture requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetPicture requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetPicture requestIsSilhouetteField () {
      return this.requestIsSilhouetteField(true);
    }
    public APIRequestGetPicture requestIsSilhouetteField (boolean value) {
      this.requestField("is_silhouette", value);
      return this;
    }
    public APIRequestGetPicture requestLeftField () {
      return this.requestLeftField(true);
    }
    public APIRequestGetPicture requestLeftField (boolean value) {
      this.requestField("left", value);
      return this;
    }
    public APIRequestGetPicture requestRightField () {
      return this.requestRightField(true);
    }
    public APIRequestGetPicture requestRightField (boolean value) {
      this.requestField("right", value);
      return this;
    }
    public APIRequestGetPicture requestTopField () {
      return this.requestTopField(true);
    }
    public APIRequestGetPicture requestTopField (boolean value) {
      this.requestField("top", value);
      return this;
    }
    public APIRequestGetPicture requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetPicture requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetPicture requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetPicture requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
  }

  public static class APIRequestGetPromotableDomains extends APIRequest<Domain> {

    APINodeList<Domain> lastResponse = null;
    @Override
    public APINodeList<Domain> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "url",
    };

    @Override
    public APINodeList<Domain> parseResponse(String response) throws APIException {
      return Domain.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Domain> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Domain> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetPromotableDomains(String nodeId, APIContext context) {
      super(context, nodeId, "/promotable_domains", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPromotableDomains setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPromotableDomains setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPromotableDomains requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPromotableDomains requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPromotableDomains requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPromotableDomains requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPromotableDomains requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPromotableDomains requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPromotableDomains requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPromotableDomains requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPromotableDomains requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPromotableDomains requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPromotableDomains requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetPromotableDomains requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
  }

  public static class APIRequestGetPromotableEvents extends APIRequest<Event> {

    APINodeList<Event> lastResponse = null;
    @Override
    public APINodeList<Event> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "include_past_events",
      "is_page_event",
      "page_id",
    };

    public static final String[] FIELDS = {
      "attending_count",
      "can_guests_invite",
      "can_viewer_post",
      "category",
      "cover",
      "declined_count",
      "description",
      "end_time",
      "guest_list_enabled",
      "id",
      "interested_count",
      "is_canceled",
      "is_draft",
      "is_page_owned",
      "is_viewer_admin",
      "maybe_count",
      "name",
      "noreply_count",
      "owner",
      "parent_group",
      "place",
      "start_time",
      "ticket_uri",
      "ticketing_privacy_uri",
      "ticketing_terms_uri",
      "timezone",
      "type",
      "updated_time",
    };

    @Override
    public APINodeList<Event> parseResponse(String response) throws APIException {
      return Event.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Event> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Event> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetPromotableEvents(String nodeId, APIContext context) {
      super(context, nodeId, "/promotable_events", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPromotableEvents setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPromotableEvents setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPromotableEvents setIncludePastEvents (Boolean includePastEvents) {
      this.setParam("include_past_events", includePastEvents);
      return this;
    }
    public APIRequestGetPromotableEvents setIncludePastEvents (String includePastEvents) {
      this.setParam("include_past_events", includePastEvents);
      return this;
    }

    public APIRequestGetPromotableEvents setIsPageEvent (Boolean isPageEvent) {
      this.setParam("is_page_event", isPageEvent);
      return this;
    }
    public APIRequestGetPromotableEvents setIsPageEvent (String isPageEvent) {
      this.setParam("is_page_event", isPageEvent);
      return this;
    }

    public APIRequestGetPromotableEvents setPageId (Long pageId) {
      this.setParam("page_id", pageId);
      return this;
    }
    public APIRequestGetPromotableEvents setPageId (String pageId) {
      this.setParam("page_id", pageId);
      return this;
    }

    public APIRequestGetPromotableEvents requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPromotableEvents requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPromotableEvents requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPromotableEvents requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPromotableEvents requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPromotableEvents requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPromotableEvents requestAttendingCountField () {
      return this.requestAttendingCountField(true);
    }
    public APIRequestGetPromotableEvents requestAttendingCountField (boolean value) {
      this.requestField("attending_count", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestCanGuestsInviteField () {
      return this.requestCanGuestsInviteField(true);
    }
    public APIRequestGetPromotableEvents requestCanGuestsInviteField (boolean value) {
      this.requestField("can_guests_invite", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestCanViewerPostField () {
      return this.requestCanViewerPostField(true);
    }
    public APIRequestGetPromotableEvents requestCanViewerPostField (boolean value) {
      this.requestField("can_viewer_post", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetPromotableEvents requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetPromotableEvents requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestDeclinedCountField () {
      return this.requestDeclinedCountField(true);
    }
    public APIRequestGetPromotableEvents requestDeclinedCountField (boolean value) {
      this.requestField("declined_count", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetPromotableEvents requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetPromotableEvents requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestGuestListEnabledField () {
      return this.requestGuestListEnabledField(true);
    }
    public APIRequestGetPromotableEvents requestGuestListEnabledField (boolean value) {
      this.requestField("guest_list_enabled", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPromotableEvents requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestInterestedCountField () {
      return this.requestInterestedCountField(true);
    }
    public APIRequestGetPromotableEvents requestInterestedCountField (boolean value) {
      this.requestField("interested_count", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestIsCanceledField () {
      return this.requestIsCanceledField(true);
    }
    public APIRequestGetPromotableEvents requestIsCanceledField (boolean value) {
      this.requestField("is_canceled", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestIsDraftField () {
      return this.requestIsDraftField(true);
    }
    public APIRequestGetPromotableEvents requestIsDraftField (boolean value) {
      this.requestField("is_draft", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestIsPageOwnedField () {
      return this.requestIsPageOwnedField(true);
    }
    public APIRequestGetPromotableEvents requestIsPageOwnedField (boolean value) {
      this.requestField("is_page_owned", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestIsViewerAdminField () {
      return this.requestIsViewerAdminField(true);
    }
    public APIRequestGetPromotableEvents requestIsViewerAdminField (boolean value) {
      this.requestField("is_viewer_admin", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestMaybeCountField () {
      return this.requestMaybeCountField(true);
    }
    public APIRequestGetPromotableEvents requestMaybeCountField (boolean value) {
      this.requestField("maybe_count", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPromotableEvents requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestNoreplyCountField () {
      return this.requestNoreplyCountField(true);
    }
    public APIRequestGetPromotableEvents requestNoreplyCountField (boolean value) {
      this.requestField("noreply_count", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetPromotableEvents requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestParentGroupField () {
      return this.requestParentGroupField(true);
    }
    public APIRequestGetPromotableEvents requestParentGroupField (boolean value) {
      this.requestField("parent_group", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGetPromotableEvents requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetPromotableEvents requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestTicketUriField () {
      return this.requestTicketUriField(true);
    }
    public APIRequestGetPromotableEvents requestTicketUriField (boolean value) {
      this.requestField("ticket_uri", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestTicketingPrivacyUriField () {
      return this.requestTicketingPrivacyUriField(true);
    }
    public APIRequestGetPromotableEvents requestTicketingPrivacyUriField (boolean value) {
      this.requestField("ticketing_privacy_uri", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestTicketingTermsUriField () {
      return this.requestTicketingTermsUriField(true);
    }
    public APIRequestGetPromotableEvents requestTicketingTermsUriField (boolean value) {
      this.requestField("ticketing_terms_uri", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetPromotableEvents requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetPromotableEvents requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetPromotableEvents requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<User> {

    User lastResponse = null;
    @Override
    public User getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "about",
      "admin_notes",
      "age_range",
      "birthday",
      "can_review_measurement_request",
      "context",
      "cover",
      "currency",
      "devices",
      "education",
      "email",
      "employee_number",
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
      "is_shared_login",
      "is_verified",
      "labels",
      "languages",
      "last_name",
      "link",
      "locale",
      "location",
      "meeting_for",
      "middle_name",
      "name",
      "name_format",
      "payment_pricepoints",
      "political",
      "public_key",
      "quotes",
      "relationship_status",
      "religion",
      "security_settings",
      "shared_login_upgrade_required_by",
      "short_name",
      "significant_other",
      "sports",
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
    public User parseResponse(String response) throws APIException {
      return User.parseResponse(response, getContext(), this).head();
    }

    @Override
    public User execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public User execute(Map<String, Object> extraParams) throws APIException {
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

    public APIRequestGet requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGet requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGet requestAdminNotesField () {
      return this.requestAdminNotesField(true);
    }
    public APIRequestGet requestAdminNotesField (boolean value) {
      this.requestField("admin_notes", value);
      return this;
    }
    public APIRequestGet requestAgeRangeField () {
      return this.requestAgeRangeField(true);
    }
    public APIRequestGet requestAgeRangeField (boolean value) {
      this.requestField("age_range", value);
      return this;
    }
    public APIRequestGet requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGet requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGet requestCanReviewMeasurementRequestField () {
      return this.requestCanReviewMeasurementRequestField(true);
    }
    public APIRequestGet requestCanReviewMeasurementRequestField (boolean value) {
      this.requestField("can_review_measurement_request", value);
      return this;
    }
    public APIRequestGet requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGet requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGet requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGet requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestDevicesField () {
      return this.requestDevicesField(true);
    }
    public APIRequestGet requestDevicesField (boolean value) {
      this.requestField("devices", value);
      return this;
    }
    public APIRequestGet requestEducationField () {
      return this.requestEducationField(true);
    }
    public APIRequestGet requestEducationField (boolean value) {
      this.requestField("education", value);
      return this;
    }
    public APIRequestGet requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGet requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGet requestEmployeeNumberField () {
      return this.requestEmployeeNumberField(true);
    }
    public APIRequestGet requestEmployeeNumberField (boolean value) {
      this.requestField("employee_number", value);
      return this;
    }
    public APIRequestGet requestFavoriteAthletesField () {
      return this.requestFavoriteAthletesField(true);
    }
    public APIRequestGet requestFavoriteAthletesField (boolean value) {
      this.requestField("favorite_athletes", value);
      return this;
    }
    public APIRequestGet requestFavoriteTeamsField () {
      return this.requestFavoriteTeamsField(true);
    }
    public APIRequestGet requestFavoriteTeamsField (boolean value) {
      this.requestField("favorite_teams", value);
      return this;
    }
    public APIRequestGet requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGet requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGet requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGet requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGet requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGet requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInspirationalPeopleField () {
      return this.requestInspirationalPeopleField(true);
    }
    public APIRequestGet requestInspirationalPeopleField (boolean value) {
      this.requestField("inspirational_people", value);
      return this;
    }
    public APIRequestGet requestInstallTypeField () {
      return this.requestInstallTypeField(true);
    }
    public APIRequestGet requestInstallTypeField (boolean value) {
      this.requestField("install_type", value);
      return this;
    }
    public APIRequestGet requestInstalledField () {
      return this.requestInstalledField(true);
    }
    public APIRequestGet requestInstalledField (boolean value) {
      this.requestField("installed", value);
      return this;
    }
    public APIRequestGet requestInterestedInField () {
      return this.requestInterestedInField(true);
    }
    public APIRequestGet requestInterestedInField (boolean value) {
      this.requestField("interested_in", value);
      return this;
    }
    public APIRequestGet requestIsSharedLoginField () {
      return this.requestIsSharedLoginField(true);
    }
    public APIRequestGet requestIsSharedLoginField (boolean value) {
      this.requestField("is_shared_login", value);
      return this;
    }
    public APIRequestGet requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGet requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGet requestLabelsField () {
      return this.requestLabelsField(true);
    }
    public APIRequestGet requestLabelsField (boolean value) {
      this.requestField("labels", value);
      return this;
    }
    public APIRequestGet requestLanguagesField () {
      return this.requestLanguagesField(true);
    }
    public APIRequestGet requestLanguagesField (boolean value) {
      this.requestField("languages", value);
      return this;
    }
    public APIRequestGet requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGet requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGet requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGet requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGet requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGet requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGet requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGet requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGet requestMeetingForField () {
      return this.requestMeetingForField(true);
    }
    public APIRequestGet requestMeetingForField (boolean value) {
      this.requestField("meeting_for", value);
      return this;
    }
    public APIRequestGet requestMiddleNameField () {
      return this.requestMiddleNameField(true);
    }
    public APIRequestGet requestMiddleNameField (boolean value) {
      this.requestField("middle_name", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestNameFormatField () {
      return this.requestNameFormatField(true);
    }
    public APIRequestGet requestNameFormatField (boolean value) {
      this.requestField("name_format", value);
      return this;
    }
    public APIRequestGet requestPaymentPricepointsField () {
      return this.requestPaymentPricepointsField(true);
    }
    public APIRequestGet requestPaymentPricepointsField (boolean value) {
      this.requestField("payment_pricepoints", value);
      return this;
    }
    public APIRequestGet requestPoliticalField () {
      return this.requestPoliticalField(true);
    }
    public APIRequestGet requestPoliticalField (boolean value) {
      this.requestField("political", value);
      return this;
    }
    public APIRequestGet requestPublicKeyField () {
      return this.requestPublicKeyField(true);
    }
    public APIRequestGet requestPublicKeyField (boolean value) {
      this.requestField("public_key", value);
      return this;
    }
    public APIRequestGet requestQuotesField () {
      return this.requestQuotesField(true);
    }
    public APIRequestGet requestQuotesField (boolean value) {
      this.requestField("quotes", value);
      return this;
    }
    public APIRequestGet requestRelationshipStatusField () {
      return this.requestRelationshipStatusField(true);
    }
    public APIRequestGet requestRelationshipStatusField (boolean value) {
      this.requestField("relationship_status", value);
      return this;
    }
    public APIRequestGet requestReligionField () {
      return this.requestReligionField(true);
    }
    public APIRequestGet requestReligionField (boolean value) {
      this.requestField("religion", value);
      return this;
    }
    public APIRequestGet requestSecuritySettingsField () {
      return this.requestSecuritySettingsField(true);
    }
    public APIRequestGet requestSecuritySettingsField (boolean value) {
      this.requestField("security_settings", value);
      return this;
    }
    public APIRequestGet requestSharedLoginUpgradeRequiredByField () {
      return this.requestSharedLoginUpgradeRequiredByField(true);
    }
    public APIRequestGet requestSharedLoginUpgradeRequiredByField (boolean value) {
      this.requestField("shared_login_upgrade_required_by", value);
      return this;
    }
    public APIRequestGet requestShortNameField () {
      return this.requestShortNameField(true);
    }
    public APIRequestGet requestShortNameField (boolean value) {
      this.requestField("short_name", value);
      return this;
    }
    public APIRequestGet requestSignificantOtherField () {
      return this.requestSignificantOtherField(true);
    }
    public APIRequestGet requestSignificantOtherField (boolean value) {
      this.requestField("significant_other", value);
      return this;
    }
    public APIRequestGet requestSportsField () {
      return this.requestSportsField(true);
    }
    public APIRequestGet requestSportsField (boolean value) {
      this.requestField("sports", value);
      return this;
    }
    public APIRequestGet requestTestGroupField () {
      return this.requestTestGroupField(true);
    }
    public APIRequestGet requestTestGroupField (boolean value) {
      this.requestField("test_group", value);
      return this;
    }
    public APIRequestGet requestThirdPartyIdField () {
      return this.requestThirdPartyIdField(true);
    }
    public APIRequestGet requestThirdPartyIdField (boolean value) {
      this.requestField("third_party_id", value);
      return this;
    }
    public APIRequestGet requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGet requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGet requestTokenForBusinessField () {
      return this.requestTokenForBusinessField(true);
    }
    public APIRequestGet requestTokenForBusinessField (boolean value) {
      this.requestField("token_for_business", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGet requestVerifiedField () {
      return this.requestVerifiedField(true);
    }
    public APIRequestGet requestVerifiedField (boolean value) {
      this.requestField("verified", value);
      return this;
    }
    public APIRequestGet requestVideoUploadLimitsField () {
      return this.requestVideoUploadLimitsField(true);
    }
    public APIRequestGet requestVideoUploadLimitsField (boolean value) {
      this.requestField("video_upload_limits", value);
      return this;
    }
    public APIRequestGet requestViewerCanSendGiftField () {
      return this.requestViewerCanSendGiftField(true);
    }
    public APIRequestGet requestViewerCanSendGiftField (boolean value) {
      this.requestField("viewer_can_send_gift", value);
      return this;
    }
    public APIRequestGet requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGet requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGet requestWorkField () {
      return this.requestWorkField(true);
    }
    public APIRequestGet requestWorkField (boolean value) {
      this.requestField("work", value);
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

  public User copyFrom(User instance) {
    this.mAbout = instance.mAbout;
    this.mAdminNotes = instance.mAdminNotes;
    this.mAgeRange = instance.mAgeRange;
    this.mBirthday = instance.mBirthday;
    this.mCanReviewMeasurementRequest = instance.mCanReviewMeasurementRequest;
    this.mContext = instance.mContext;
    this.mCover = instance.mCover;
    this.mCurrency = instance.mCurrency;
    this.mDevices = instance.mDevices;
    this.mEducation = instance.mEducation;
    this.mEmail = instance.mEmail;
    this.mEmployeeNumber = instance.mEmployeeNumber;
    this.mFavoriteAthletes = instance.mFavoriteAthletes;
    this.mFavoriteTeams = instance.mFavoriteTeams;
    this.mFirstName = instance.mFirstName;
    this.mGender = instance.mGender;
    this.mHometown = instance.mHometown;
    this.mId = instance.mId;
    this.mInspirationalPeople = instance.mInspirationalPeople;
    this.mInstallType = instance.mInstallType;
    this.mInstalled = instance.mInstalled;
    this.mInterestedIn = instance.mInterestedIn;
    this.mIsSharedLogin = instance.mIsSharedLogin;
    this.mIsVerified = instance.mIsVerified;
    this.mLabels = instance.mLabels;
    this.mLanguages = instance.mLanguages;
    this.mLastName = instance.mLastName;
    this.mLink = instance.mLink;
    this.mLocale = instance.mLocale;
    this.mLocation = instance.mLocation;
    this.mMeetingFor = instance.mMeetingFor;
    this.mMiddleName = instance.mMiddleName;
    this.mName = instance.mName;
    this.mNameFormat = instance.mNameFormat;
    this.mPaymentPricepoints = instance.mPaymentPricepoints;
    this.mPolitical = instance.mPolitical;
    this.mPublicKey = instance.mPublicKey;
    this.mQuotes = instance.mQuotes;
    this.mRelationshipStatus = instance.mRelationshipStatus;
    this.mReligion = instance.mReligion;
    this.mSecuritySettings = instance.mSecuritySettings;
    this.mSharedLoginUpgradeRequiredBy = instance.mSharedLoginUpgradeRequiredBy;
    this.mShortName = instance.mShortName;
    this.mSignificantOther = instance.mSignificantOther;
    this.mSports = instance.mSports;
    this.mTestGroup = instance.mTestGroup;
    this.mThirdPartyId = instance.mThirdPartyId;
    this.mTimezone = instance.mTimezone;
    this.mTokenForBusiness = instance.mTokenForBusiness;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mVerified = instance.mVerified;
    this.mVideoUploadLimits = instance.mVideoUploadLimits;
    this.mViewerCanSendGift = instance.mViewerCanSendGift;
    this.mWebsite = instance.mWebsite;
    this.mWork = instance.mWork;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<User> getParser() {
    return new APIRequest.ResponseParser<User>() {
      public APINodeList<User> parseResponse(String response, APIContext context, APIRequest<User> request) throws MalformedResponseException {
        return User.parseResponse(response, context, request);
      }
    };
  }
}
