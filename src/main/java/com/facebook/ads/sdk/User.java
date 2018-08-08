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
public class User extends APINode {
  @SerializedName("about")
  private String mAbout = null;
  @SerializedName("address")
  private Location mAddress = null;
  @SerializedName("admin_notes")
  private List<PageAdminNote> mAdminNotes = null;
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
  private Page mHometown = null;
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
  @SerializedName("is_famedeeplinkinguser")
  private Boolean mIsFamedeeplinkinguser = null;
  @SerializedName("is_shared_login")
  private Boolean mIsSharedLogin = null;
  @SerializedName("is_verified")
  private Boolean mIsVerified = null;
  @SerializedName("labels")
  private List<PageLabel> mLabels = null;
  @SerializedName("languages")
  private List<Object> mLanguages = null;
  @SerializedName("last_name")
  private String mLastName = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("local_news_megaphone_dismiss_status")
  private Boolean mLocalNewsMegaphoneDismissStatus = null;
  @SerializedName("local_news_subscription_status")
  private Boolean mLocalNewsSubscriptionStatus = null;
  @SerializedName("locale")
  private String mLocale = null;
  @SerializedName("location")
  private Page mLocation = null;
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
  @SerializedName("profile_pic")
  private String mProfilePic = null;
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

  public static ListenableFuture<User> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static User fetchById(String id, APIContext context) throws APIException {
    User user =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return user;
  }

  public static ListenableFuture<User> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<User> user =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
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

  public static ListenableFuture<APINodeList<User>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<User>> user =
      new APIRequest(context, "", "/", "GET", User.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return user;
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
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                users.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            users.setPaging(previous, next);
            if (context.hasAppSecret()) {
              users.setAppSecret(context.getAppSecretProof());
            }
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

  public APIRequestCreateAccount createAccount() {
    return new APIRequestCreateAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdAccounts getAdAccounts() {
    return new APIRequestGetAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAlbum createAlbum() {
    return new APIRequestCreateAlbum(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetConversations getConversations() {
    return new APIRequestGetConversations(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLeadGenForms getLeadGenForms() {
    return new APIRequestGetLeadGenForms(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLiveEncoder createLiveEncoder() {
    return new APIRequestCreateLiveEncoder(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLiveVideos getLiveVideos() {
    return new APIRequestGetLiveVideos(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLiveVideo createLiveVideo() {
    return new APIRequestCreateLiveVideo(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePhoto createPhoto() {
    return new APIRequestCreatePhoto(this.getPrefixedId().toString(), context);
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

  public APIRequestGetThreads getThreads() {
    return new APIRequestGetThreads(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldAbout() {
    return mAbout;
  }

  public Location getFieldAddress() {
    return mAddress;
  }

  public List<PageAdminNote> getFieldAdminNotes() {
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

  public Page getFieldHometown() {
    if (mHometown != null) {
      mHometown.context = getContext();
    }
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

  public Boolean getFieldIsFamedeeplinkinguser() {
    return mIsFamedeeplinkinguser;
  }

  public Boolean getFieldIsSharedLogin() {
    return mIsSharedLogin;
  }

  public Boolean getFieldIsVerified() {
    return mIsVerified;
  }

  public List<PageLabel> getFieldLabels() {
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

  public Boolean getFieldLocalNewsMegaphoneDismissStatus() {
    return mLocalNewsMegaphoneDismissStatus;
  }

  public Boolean getFieldLocalNewsSubscriptionStatus() {
    return mLocalNewsSubscriptionStatus;
  }

  public String getFieldLocale() {
    return mLocale;
  }

  public Page getFieldLocation() {
    if (mLocation != null) {
      mLocation.context = getContext();
    }
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

  public String getFieldProfilePic() {
    return mProfilePic;
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



  public static class APIRequestGetAccounts extends APIRequest<Page> {

    APINodeList<Page> lastResponse = null;
    @Override
    public APINodeList<Page> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business_id",
      "is_business",
      "is_place",
      "is_promotable",
    };

    public static final String[] FIELDS = {
      "about",
      "access_token",
      "ad_campaign",
      "affiliation",
      "app_id",
      "app_links",
      "artists_we_like",
      "attire",
      "awards",
      "band_interests",
      "band_members",
      "best_page",
      "bio",
      "birthday",
      "booking_agent",
      "built",
      "business",
      "can_checkin",
      "can_post",
      "category",
      "category_list",
      "checkins",
      "company_overview",
      "connected_instagram_account",
      "contact_address",
      "context",
      "copyright_attribution_insights",
      "copyright_whitelisted_ig_partners",
      "country_page_likes",
      "cover",
      "culinary_team",
      "current_location",
      "description",
      "description_html",
      "directed_by",
      "display_subtext",
      "displayed_message_response_time",
      "emails",
      "engagement",
      "fan_count",
      "featured_video",
      "features",
      "food_styles",
      "founded",
      "general_info",
      "general_manager",
      "genre",
      "global_brand_page_name",
      "global_brand_root_id",
      "has_added_app",
      "has_whatsapp_number",
      "hometown",
      "hours",
      "id",
      "impressum",
      "influences",
      "instagram_business_account",
      "instant_articles_review_status",
      "is_always_open",
      "is_chain",
      "is_community_page",
      "is_eligible_for_branded_content",
      "is_messenger_bot_get_started_enabled",
      "is_messenger_platform_bot",
      "is_owned",
      "is_permanently_closed",
      "is_published",
      "is_unclaimed",
      "is_verified",
      "is_webhooks_subscribed",
      "keywords",
      "leadgen_form_preview_details",
      "leadgen_has_crm_integration",
      "leadgen_has_fat_ping_crm_integration",
      "leadgen_tos_acceptance_time",
      "leadgen_tos_accepted",
      "leadgen_tos_accepting_user",
      "link",
      "location",
      "members",
      "merchant_id",
      "merchant_review_status",
      "messenger_ads_default_icebreakers",
      "messenger_ads_default_page_welcome_message",
      "messenger_ads_default_quick_replies",
      "messenger_ads_quick_replies_type",
      "mission",
      "mpg",
      "name",
      "name_with_location_descriptor",
      "network",
      "new_like_count",
      "offer_eligible",
      "overall_star_rating",
      "page_token",
      "parent_page",
      "parking",
      "payment_options",
      "personal_info",
      "personal_interests",
      "pharma_safety_info",
      "phone",
      "place_type",
      "plot_outline",
      "preferred_audience",
      "press_contact",
      "price_range",
      "produced_by",
      "products",
      "promotion_eligible",
      "promotion_ineligible_reason",
      "public_transit",
      "publisher_space",
      "rating_count",
      "recipient",
      "record_label",
      "release_date",
      "restaurant_services",
      "restaurant_specialties",
      "schedule",
      "screenplay_by",
      "season",
      "single_line_address",
      "starring",
      "start_info",
      "store_code",
      "store_location_descriptor",
      "store_number",
      "studio",
      "supports_instant_articles",
      "talking_about_count",
      "unread_message_count",
      "unread_notif_count",
      "unseen_message_count",
      "username",
      "verification_status",
      "voip_info",
      "website",
      "were_here_count",
      "whatsapp_number",
      "written_by",
    };

    @Override
    public APINodeList<Page> parseResponse(String response) throws APIException {
      return Page.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Page> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Page> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Page>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Page>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Page>>() {
           public APINodeList<Page> apply(String result) {
             try {
               return APIRequestGetAccounts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

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

    public APIRequestGetAccounts requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetAccounts requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetAccounts requestAccessTokenField () {
      return this.requestAccessTokenField(true);
    }
    public APIRequestGetAccounts requestAccessTokenField (boolean value) {
      this.requestField("access_token", value);
      return this;
    }
    public APIRequestGetAccounts requestAdCampaignField () {
      return this.requestAdCampaignField(true);
    }
    public APIRequestGetAccounts requestAdCampaignField (boolean value) {
      this.requestField("ad_campaign", value);
      return this;
    }
    public APIRequestGetAccounts requestAffiliationField () {
      return this.requestAffiliationField(true);
    }
    public APIRequestGetAccounts requestAffiliationField (boolean value) {
      this.requestField("affiliation", value);
      return this;
    }
    public APIRequestGetAccounts requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetAccounts requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetAccounts requestAppLinksField () {
      return this.requestAppLinksField(true);
    }
    public APIRequestGetAccounts requestAppLinksField (boolean value) {
      this.requestField("app_links", value);
      return this;
    }
    public APIRequestGetAccounts requestArtistsWeLikeField () {
      return this.requestArtistsWeLikeField(true);
    }
    public APIRequestGetAccounts requestArtistsWeLikeField (boolean value) {
      this.requestField("artists_we_like", value);
      return this;
    }
    public APIRequestGetAccounts requestAttireField () {
      return this.requestAttireField(true);
    }
    public APIRequestGetAccounts requestAttireField (boolean value) {
      this.requestField("attire", value);
      return this;
    }
    public APIRequestGetAccounts requestAwardsField () {
      return this.requestAwardsField(true);
    }
    public APIRequestGetAccounts requestAwardsField (boolean value) {
      this.requestField("awards", value);
      return this;
    }
    public APIRequestGetAccounts requestBandInterestsField () {
      return this.requestBandInterestsField(true);
    }
    public APIRequestGetAccounts requestBandInterestsField (boolean value) {
      this.requestField("band_interests", value);
      return this;
    }
    public APIRequestGetAccounts requestBandMembersField () {
      return this.requestBandMembersField(true);
    }
    public APIRequestGetAccounts requestBandMembersField (boolean value) {
      this.requestField("band_members", value);
      return this;
    }
    public APIRequestGetAccounts requestBestPageField () {
      return this.requestBestPageField(true);
    }
    public APIRequestGetAccounts requestBestPageField (boolean value) {
      this.requestField("best_page", value);
      return this;
    }
    public APIRequestGetAccounts requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetAccounts requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetAccounts requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetAccounts requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetAccounts requestBookingAgentField () {
      return this.requestBookingAgentField(true);
    }
    public APIRequestGetAccounts requestBookingAgentField (boolean value) {
      this.requestField("booking_agent", value);
      return this;
    }
    public APIRequestGetAccounts requestBuiltField () {
      return this.requestBuiltField(true);
    }
    public APIRequestGetAccounts requestBuiltField (boolean value) {
      this.requestField("built", value);
      return this;
    }
    public APIRequestGetAccounts requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAccounts requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAccounts requestCanCheckinField () {
      return this.requestCanCheckinField(true);
    }
    public APIRequestGetAccounts requestCanCheckinField (boolean value) {
      this.requestField("can_checkin", value);
      return this;
    }
    public APIRequestGetAccounts requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetAccounts requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetAccounts requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetAccounts requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetAccounts requestCategoryListField () {
      return this.requestCategoryListField(true);
    }
    public APIRequestGetAccounts requestCategoryListField (boolean value) {
      this.requestField("category_list", value);
      return this;
    }
    public APIRequestGetAccounts requestCheckinsField () {
      return this.requestCheckinsField(true);
    }
    public APIRequestGetAccounts requestCheckinsField (boolean value) {
      this.requestField("checkins", value);
      return this;
    }
    public APIRequestGetAccounts requestCompanyOverviewField () {
      return this.requestCompanyOverviewField(true);
    }
    public APIRequestGetAccounts requestCompanyOverviewField (boolean value) {
      this.requestField("company_overview", value);
      return this;
    }
    public APIRequestGetAccounts requestConnectedInstagramAccountField () {
      return this.requestConnectedInstagramAccountField(true);
    }
    public APIRequestGetAccounts requestConnectedInstagramAccountField (boolean value) {
      this.requestField("connected_instagram_account", value);
      return this;
    }
    public APIRequestGetAccounts requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetAccounts requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetAccounts requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetAccounts requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetAccounts requestCopyrightAttributionInsightsField () {
      return this.requestCopyrightAttributionInsightsField(true);
    }
    public APIRequestGetAccounts requestCopyrightAttributionInsightsField (boolean value) {
      this.requestField("copyright_attribution_insights", value);
      return this;
    }
    public APIRequestGetAccounts requestCopyrightWhitelistedIgPartnersField () {
      return this.requestCopyrightWhitelistedIgPartnersField(true);
    }
    public APIRequestGetAccounts requestCopyrightWhitelistedIgPartnersField (boolean value) {
      this.requestField("copyright_whitelisted_ig_partners", value);
      return this;
    }
    public APIRequestGetAccounts requestCountryPageLikesField () {
      return this.requestCountryPageLikesField(true);
    }
    public APIRequestGetAccounts requestCountryPageLikesField (boolean value) {
      this.requestField("country_page_likes", value);
      return this;
    }
    public APIRequestGetAccounts requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetAccounts requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetAccounts requestCulinaryTeamField () {
      return this.requestCulinaryTeamField(true);
    }
    public APIRequestGetAccounts requestCulinaryTeamField (boolean value) {
      this.requestField("culinary_team", value);
      return this;
    }
    public APIRequestGetAccounts requestCurrentLocationField () {
      return this.requestCurrentLocationField(true);
    }
    public APIRequestGetAccounts requestCurrentLocationField (boolean value) {
      this.requestField("current_location", value);
      return this;
    }
    public APIRequestGetAccounts requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetAccounts requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetAccounts requestDescriptionHtmlField () {
      return this.requestDescriptionHtmlField(true);
    }
    public APIRequestGetAccounts requestDescriptionHtmlField (boolean value) {
      this.requestField("description_html", value);
      return this;
    }
    public APIRequestGetAccounts requestDirectedByField () {
      return this.requestDirectedByField(true);
    }
    public APIRequestGetAccounts requestDirectedByField (boolean value) {
      this.requestField("directed_by", value);
      return this;
    }
    public APIRequestGetAccounts requestDisplaySubtextField () {
      return this.requestDisplaySubtextField(true);
    }
    public APIRequestGetAccounts requestDisplaySubtextField (boolean value) {
      this.requestField("display_subtext", value);
      return this;
    }
    public APIRequestGetAccounts requestDisplayedMessageResponseTimeField () {
      return this.requestDisplayedMessageResponseTimeField(true);
    }
    public APIRequestGetAccounts requestDisplayedMessageResponseTimeField (boolean value) {
      this.requestField("displayed_message_response_time", value);
      return this;
    }
    public APIRequestGetAccounts requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetAccounts requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetAccounts requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGetAccounts requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGetAccounts requestFanCountField () {
      return this.requestFanCountField(true);
    }
    public APIRequestGetAccounts requestFanCountField (boolean value) {
      this.requestField("fan_count", value);
      return this;
    }
    public APIRequestGetAccounts requestFeaturedVideoField () {
      return this.requestFeaturedVideoField(true);
    }
    public APIRequestGetAccounts requestFeaturedVideoField (boolean value) {
      this.requestField("featured_video", value);
      return this;
    }
    public APIRequestGetAccounts requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetAccounts requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetAccounts requestFoodStylesField () {
      return this.requestFoodStylesField(true);
    }
    public APIRequestGetAccounts requestFoodStylesField (boolean value) {
      this.requestField("food_styles", value);
      return this;
    }
    public APIRequestGetAccounts requestFoundedField () {
      return this.requestFoundedField(true);
    }
    public APIRequestGetAccounts requestFoundedField (boolean value) {
      this.requestField("founded", value);
      return this;
    }
    public APIRequestGetAccounts requestGeneralInfoField () {
      return this.requestGeneralInfoField(true);
    }
    public APIRequestGetAccounts requestGeneralInfoField (boolean value) {
      this.requestField("general_info", value);
      return this;
    }
    public APIRequestGetAccounts requestGeneralManagerField () {
      return this.requestGeneralManagerField(true);
    }
    public APIRequestGetAccounts requestGeneralManagerField (boolean value) {
      this.requestField("general_manager", value);
      return this;
    }
    public APIRequestGetAccounts requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGetAccounts requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGetAccounts requestGlobalBrandPageNameField () {
      return this.requestGlobalBrandPageNameField(true);
    }
    public APIRequestGetAccounts requestGlobalBrandPageNameField (boolean value) {
      this.requestField("global_brand_page_name", value);
      return this;
    }
    public APIRequestGetAccounts requestGlobalBrandRootIdField () {
      return this.requestGlobalBrandRootIdField(true);
    }
    public APIRequestGetAccounts requestGlobalBrandRootIdField (boolean value) {
      this.requestField("global_brand_root_id", value);
      return this;
    }
    public APIRequestGetAccounts requestHasAddedAppField () {
      return this.requestHasAddedAppField(true);
    }
    public APIRequestGetAccounts requestHasAddedAppField (boolean value) {
      this.requestField("has_added_app", value);
      return this;
    }
    public APIRequestGetAccounts requestHasWhatsappNumberField () {
      return this.requestHasWhatsappNumberField(true);
    }
    public APIRequestGetAccounts requestHasWhatsappNumberField (boolean value) {
      this.requestField("has_whatsapp_number", value);
      return this;
    }
    public APIRequestGetAccounts requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetAccounts requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetAccounts requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGetAccounts requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGetAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAccounts requestImpressumField () {
      return this.requestImpressumField(true);
    }
    public APIRequestGetAccounts requestImpressumField (boolean value) {
      this.requestField("impressum", value);
      return this;
    }
    public APIRequestGetAccounts requestInfluencesField () {
      return this.requestInfluencesField(true);
    }
    public APIRequestGetAccounts requestInfluencesField (boolean value) {
      this.requestField("influences", value);
      return this;
    }
    public APIRequestGetAccounts requestInstagramBusinessAccountField () {
      return this.requestInstagramBusinessAccountField(true);
    }
    public APIRequestGetAccounts requestInstagramBusinessAccountField (boolean value) {
      this.requestField("instagram_business_account", value);
      return this;
    }
    public APIRequestGetAccounts requestInstantArticlesReviewStatusField () {
      return this.requestInstantArticlesReviewStatusField(true);
    }
    public APIRequestGetAccounts requestInstantArticlesReviewStatusField (boolean value) {
      this.requestField("instant_articles_review_status", value);
      return this;
    }
    public APIRequestGetAccounts requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetAccounts requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
      return this;
    }
    public APIRequestGetAccounts requestIsChainField () {
      return this.requestIsChainField(true);
    }
    public APIRequestGetAccounts requestIsChainField (boolean value) {
      this.requestField("is_chain", value);
      return this;
    }
    public APIRequestGetAccounts requestIsCommunityPageField () {
      return this.requestIsCommunityPageField(true);
    }
    public APIRequestGetAccounts requestIsCommunityPageField (boolean value) {
      this.requestField("is_community_page", value);
      return this;
    }
    public APIRequestGetAccounts requestIsEligibleForBrandedContentField () {
      return this.requestIsEligibleForBrandedContentField(true);
    }
    public APIRequestGetAccounts requestIsEligibleForBrandedContentField (boolean value) {
      this.requestField("is_eligible_for_branded_content", value);
      return this;
    }
    public APIRequestGetAccounts requestIsMessengerBotGetStartedEnabledField () {
      return this.requestIsMessengerBotGetStartedEnabledField(true);
    }
    public APIRequestGetAccounts requestIsMessengerBotGetStartedEnabledField (boolean value) {
      this.requestField("is_messenger_bot_get_started_enabled", value);
      return this;
    }
    public APIRequestGetAccounts requestIsMessengerPlatformBotField () {
      return this.requestIsMessengerPlatformBotField(true);
    }
    public APIRequestGetAccounts requestIsMessengerPlatformBotField (boolean value) {
      this.requestField("is_messenger_platform_bot", value);
      return this;
    }
    public APIRequestGetAccounts requestIsOwnedField () {
      return this.requestIsOwnedField(true);
    }
    public APIRequestGetAccounts requestIsOwnedField (boolean value) {
      this.requestField("is_owned", value);
      return this;
    }
    public APIRequestGetAccounts requestIsPermanentlyClosedField () {
      return this.requestIsPermanentlyClosedField(true);
    }
    public APIRequestGetAccounts requestIsPermanentlyClosedField (boolean value) {
      this.requestField("is_permanently_closed", value);
      return this;
    }
    public APIRequestGetAccounts requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetAccounts requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetAccounts requestIsUnclaimedField () {
      return this.requestIsUnclaimedField(true);
    }
    public APIRequestGetAccounts requestIsUnclaimedField (boolean value) {
      this.requestField("is_unclaimed", value);
      return this;
    }
    public APIRequestGetAccounts requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetAccounts requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetAccounts requestIsWebhooksSubscribedField () {
      return this.requestIsWebhooksSubscribedField(true);
    }
    public APIRequestGetAccounts requestIsWebhooksSubscribedField (boolean value) {
      this.requestField("is_webhooks_subscribed", value);
      return this;
    }
    public APIRequestGetAccounts requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGetAccounts requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGetAccounts requestLeadgenFormPreviewDetailsField () {
      return this.requestLeadgenFormPreviewDetailsField(true);
    }
    public APIRequestGetAccounts requestLeadgenFormPreviewDetailsField (boolean value) {
      this.requestField("leadgen_form_preview_details", value);
      return this;
    }
    public APIRequestGetAccounts requestLeadgenHasCrmIntegrationField () {
      return this.requestLeadgenHasCrmIntegrationField(true);
    }
    public APIRequestGetAccounts requestLeadgenHasCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_crm_integration", value);
      return this;
    }
    public APIRequestGetAccounts requestLeadgenHasFatPingCrmIntegrationField () {
      return this.requestLeadgenHasFatPingCrmIntegrationField(true);
    }
    public APIRequestGetAccounts requestLeadgenHasFatPingCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_fat_ping_crm_integration", value);
      return this;
    }
    public APIRequestGetAccounts requestLeadgenTosAcceptanceTimeField () {
      return this.requestLeadgenTosAcceptanceTimeField(true);
    }
    public APIRequestGetAccounts requestLeadgenTosAcceptanceTimeField (boolean value) {
      this.requestField("leadgen_tos_acceptance_time", value);
      return this;
    }
    public APIRequestGetAccounts requestLeadgenTosAcceptedField () {
      return this.requestLeadgenTosAcceptedField(true);
    }
    public APIRequestGetAccounts requestLeadgenTosAcceptedField (boolean value) {
      this.requestField("leadgen_tos_accepted", value);
      return this;
    }
    public APIRequestGetAccounts requestLeadgenTosAcceptingUserField () {
      return this.requestLeadgenTosAcceptingUserField(true);
    }
    public APIRequestGetAccounts requestLeadgenTosAcceptingUserField (boolean value) {
      this.requestField("leadgen_tos_accepting_user", value);
      return this;
    }
    public APIRequestGetAccounts requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetAccounts requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetAccounts requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetAccounts requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetAccounts requestMembersField () {
      return this.requestMembersField(true);
    }
    public APIRequestGetAccounts requestMembersField (boolean value) {
      this.requestField("members", value);
      return this;
    }
    public APIRequestGetAccounts requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetAccounts requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetAccounts requestMerchantReviewStatusField () {
      return this.requestMerchantReviewStatusField(true);
    }
    public APIRequestGetAccounts requestMerchantReviewStatusField (boolean value) {
      this.requestField("merchant_review_status", value);
      return this;
    }
    public APIRequestGetAccounts requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetAccounts requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetAccounts requestMessengerAdsDefaultPageWelcomeMessageField () {
      return this.requestMessengerAdsDefaultPageWelcomeMessageField(true);
    }
    public APIRequestGetAccounts requestMessengerAdsDefaultPageWelcomeMessageField (boolean value) {
      this.requestField("messenger_ads_default_page_welcome_message", value);
      return this;
    }
    public APIRequestGetAccounts requestMessengerAdsDefaultQuickRepliesField () {
      return this.requestMessengerAdsDefaultQuickRepliesField(true);
    }
    public APIRequestGetAccounts requestMessengerAdsDefaultQuickRepliesField (boolean value) {
      this.requestField("messenger_ads_default_quick_replies", value);
      return this;
    }
    public APIRequestGetAccounts requestMessengerAdsQuickRepliesTypeField () {
      return this.requestMessengerAdsQuickRepliesTypeField(true);
    }
    public APIRequestGetAccounts requestMessengerAdsQuickRepliesTypeField (boolean value) {
      this.requestField("messenger_ads_quick_replies_type", value);
      return this;
    }
    public APIRequestGetAccounts requestMissionField () {
      return this.requestMissionField(true);
    }
    public APIRequestGetAccounts requestMissionField (boolean value) {
      this.requestField("mission", value);
      return this;
    }
    public APIRequestGetAccounts requestMpgField () {
      return this.requestMpgField(true);
    }
    public APIRequestGetAccounts requestMpgField (boolean value) {
      this.requestField("mpg", value);
      return this;
    }
    public APIRequestGetAccounts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAccounts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAccounts requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGetAccounts requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGetAccounts requestNetworkField () {
      return this.requestNetworkField(true);
    }
    public APIRequestGetAccounts requestNetworkField (boolean value) {
      this.requestField("network", value);
      return this;
    }
    public APIRequestGetAccounts requestNewLikeCountField () {
      return this.requestNewLikeCountField(true);
    }
    public APIRequestGetAccounts requestNewLikeCountField (boolean value) {
      this.requestField("new_like_count", value);
      return this;
    }
    public APIRequestGetAccounts requestOfferEligibleField () {
      return this.requestOfferEligibleField(true);
    }
    public APIRequestGetAccounts requestOfferEligibleField (boolean value) {
      this.requestField("offer_eligible", value);
      return this;
    }
    public APIRequestGetAccounts requestOverallStarRatingField () {
      return this.requestOverallStarRatingField(true);
    }
    public APIRequestGetAccounts requestOverallStarRatingField (boolean value) {
      this.requestField("overall_star_rating", value);
      return this;
    }
    public APIRequestGetAccounts requestPageTokenField () {
      return this.requestPageTokenField(true);
    }
    public APIRequestGetAccounts requestPageTokenField (boolean value) {
      this.requestField("page_token", value);
      return this;
    }
    public APIRequestGetAccounts requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetAccounts requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGetAccounts requestParkingField () {
      return this.requestParkingField(true);
    }
    public APIRequestGetAccounts requestParkingField (boolean value) {
      this.requestField("parking", value);
      return this;
    }
    public APIRequestGetAccounts requestPaymentOptionsField () {
      return this.requestPaymentOptionsField(true);
    }
    public APIRequestGetAccounts requestPaymentOptionsField (boolean value) {
      this.requestField("payment_options", value);
      return this;
    }
    public APIRequestGetAccounts requestPersonalInfoField () {
      return this.requestPersonalInfoField(true);
    }
    public APIRequestGetAccounts requestPersonalInfoField (boolean value) {
      this.requestField("personal_info", value);
      return this;
    }
    public APIRequestGetAccounts requestPersonalInterestsField () {
      return this.requestPersonalInterestsField(true);
    }
    public APIRequestGetAccounts requestPersonalInterestsField (boolean value) {
      this.requestField("personal_interests", value);
      return this;
    }
    public APIRequestGetAccounts requestPharmaSafetyInfoField () {
      return this.requestPharmaSafetyInfoField(true);
    }
    public APIRequestGetAccounts requestPharmaSafetyInfoField (boolean value) {
      this.requestField("pharma_safety_info", value);
      return this;
    }
    public APIRequestGetAccounts requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetAccounts requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetAccounts requestPlaceTypeField () {
      return this.requestPlaceTypeField(true);
    }
    public APIRequestGetAccounts requestPlaceTypeField (boolean value) {
      this.requestField("place_type", value);
      return this;
    }
    public APIRequestGetAccounts requestPlotOutlineField () {
      return this.requestPlotOutlineField(true);
    }
    public APIRequestGetAccounts requestPlotOutlineField (boolean value) {
      this.requestField("plot_outline", value);
      return this;
    }
    public APIRequestGetAccounts requestPreferredAudienceField () {
      return this.requestPreferredAudienceField(true);
    }
    public APIRequestGetAccounts requestPreferredAudienceField (boolean value) {
      this.requestField("preferred_audience", value);
      return this;
    }
    public APIRequestGetAccounts requestPressContactField () {
      return this.requestPressContactField(true);
    }
    public APIRequestGetAccounts requestPressContactField (boolean value) {
      this.requestField("press_contact", value);
      return this;
    }
    public APIRequestGetAccounts requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGetAccounts requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGetAccounts requestProducedByField () {
      return this.requestProducedByField(true);
    }
    public APIRequestGetAccounts requestProducedByField (boolean value) {
      this.requestField("produced_by", value);
      return this;
    }
    public APIRequestGetAccounts requestProductsField () {
      return this.requestProductsField(true);
    }
    public APIRequestGetAccounts requestProductsField (boolean value) {
      this.requestField("products", value);
      return this;
    }
    public APIRequestGetAccounts requestPromotionEligibleField () {
      return this.requestPromotionEligibleField(true);
    }
    public APIRequestGetAccounts requestPromotionEligibleField (boolean value) {
      this.requestField("promotion_eligible", value);
      return this;
    }
    public APIRequestGetAccounts requestPromotionIneligibleReasonField () {
      return this.requestPromotionIneligibleReasonField(true);
    }
    public APIRequestGetAccounts requestPromotionIneligibleReasonField (boolean value) {
      this.requestField("promotion_ineligible_reason", value);
      return this;
    }
    public APIRequestGetAccounts requestPublicTransitField () {
      return this.requestPublicTransitField(true);
    }
    public APIRequestGetAccounts requestPublicTransitField (boolean value) {
      this.requestField("public_transit", value);
      return this;
    }
    public APIRequestGetAccounts requestPublisherSpaceField () {
      return this.requestPublisherSpaceField(true);
    }
    public APIRequestGetAccounts requestPublisherSpaceField (boolean value) {
      this.requestField("publisher_space", value);
      return this;
    }
    public APIRequestGetAccounts requestRatingCountField () {
      return this.requestRatingCountField(true);
    }
    public APIRequestGetAccounts requestRatingCountField (boolean value) {
      this.requestField("rating_count", value);
      return this;
    }
    public APIRequestGetAccounts requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetAccounts requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetAccounts requestRecordLabelField () {
      return this.requestRecordLabelField(true);
    }
    public APIRequestGetAccounts requestRecordLabelField (boolean value) {
      this.requestField("record_label", value);
      return this;
    }
    public APIRequestGetAccounts requestReleaseDateField () {
      return this.requestReleaseDateField(true);
    }
    public APIRequestGetAccounts requestReleaseDateField (boolean value) {
      this.requestField("release_date", value);
      return this;
    }
    public APIRequestGetAccounts requestRestaurantServicesField () {
      return this.requestRestaurantServicesField(true);
    }
    public APIRequestGetAccounts requestRestaurantServicesField (boolean value) {
      this.requestField("restaurant_services", value);
      return this;
    }
    public APIRequestGetAccounts requestRestaurantSpecialtiesField () {
      return this.requestRestaurantSpecialtiesField(true);
    }
    public APIRequestGetAccounts requestRestaurantSpecialtiesField (boolean value) {
      this.requestField("restaurant_specialties", value);
      return this;
    }
    public APIRequestGetAccounts requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetAccounts requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGetAccounts requestScreenplayByField () {
      return this.requestScreenplayByField(true);
    }
    public APIRequestGetAccounts requestScreenplayByField (boolean value) {
      this.requestField("screenplay_by", value);
      return this;
    }
    public APIRequestGetAccounts requestSeasonField () {
      return this.requestSeasonField(true);
    }
    public APIRequestGetAccounts requestSeasonField (boolean value) {
      this.requestField("season", value);
      return this;
    }
    public APIRequestGetAccounts requestSingleLineAddressField () {
      return this.requestSingleLineAddressField(true);
    }
    public APIRequestGetAccounts requestSingleLineAddressField (boolean value) {
      this.requestField("single_line_address", value);
      return this;
    }
    public APIRequestGetAccounts requestStarringField () {
      return this.requestStarringField(true);
    }
    public APIRequestGetAccounts requestStarringField (boolean value) {
      this.requestField("starring", value);
      return this;
    }
    public APIRequestGetAccounts requestStartInfoField () {
      return this.requestStartInfoField(true);
    }
    public APIRequestGetAccounts requestStartInfoField (boolean value) {
      this.requestField("start_info", value);
      return this;
    }
    public APIRequestGetAccounts requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGetAccounts requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGetAccounts requestStoreLocationDescriptorField () {
      return this.requestStoreLocationDescriptorField(true);
    }
    public APIRequestGetAccounts requestStoreLocationDescriptorField (boolean value) {
      this.requestField("store_location_descriptor", value);
      return this;
    }
    public APIRequestGetAccounts requestStoreNumberField () {
      return this.requestStoreNumberField(true);
    }
    public APIRequestGetAccounts requestStoreNumberField (boolean value) {
      this.requestField("store_number", value);
      return this;
    }
    public APIRequestGetAccounts requestStudioField () {
      return this.requestStudioField(true);
    }
    public APIRequestGetAccounts requestStudioField (boolean value) {
      this.requestField("studio", value);
      return this;
    }
    public APIRequestGetAccounts requestSupportsInstantArticlesField () {
      return this.requestSupportsInstantArticlesField(true);
    }
    public APIRequestGetAccounts requestSupportsInstantArticlesField (boolean value) {
      this.requestField("supports_instant_articles", value);
      return this;
    }
    public APIRequestGetAccounts requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetAccounts requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
      return this;
    }
    public APIRequestGetAccounts requestUnreadMessageCountField () {
      return this.requestUnreadMessageCountField(true);
    }
    public APIRequestGetAccounts requestUnreadMessageCountField (boolean value) {
      this.requestField("unread_message_count", value);
      return this;
    }
    public APIRequestGetAccounts requestUnreadNotifCountField () {
      return this.requestUnreadNotifCountField(true);
    }
    public APIRequestGetAccounts requestUnreadNotifCountField (boolean value) {
      this.requestField("unread_notif_count", value);
      return this;
    }
    public APIRequestGetAccounts requestUnseenMessageCountField () {
      return this.requestUnseenMessageCountField(true);
    }
    public APIRequestGetAccounts requestUnseenMessageCountField (boolean value) {
      this.requestField("unseen_message_count", value);
      return this;
    }
    public APIRequestGetAccounts requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetAccounts requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetAccounts requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetAccounts requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetAccounts requestVoipInfoField () {
      return this.requestVoipInfoField(true);
    }
    public APIRequestGetAccounts requestVoipInfoField (boolean value) {
      this.requestField("voip_info", value);
      return this;
    }
    public APIRequestGetAccounts requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetAccounts requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetAccounts requestWereHereCountField () {
      return this.requestWereHereCountField(true);
    }
    public APIRequestGetAccounts requestWereHereCountField (boolean value) {
      this.requestField("were_here_count", value);
      return this;
    }
    public APIRequestGetAccounts requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGetAccounts requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
      return this;
    }
    public APIRequestGetAccounts requestWrittenByField () {
      return this.requestWrittenByField(true);
    }
    public APIRequestGetAccounts requestWrittenByField (boolean value) {
      this.requestField("written_by", value);
      return this;
    }
  }

  public static class APIRequestCreateAccount extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "about",
      "address",
      "category_enum",
      "category_list",
      "city_id",
      "coordinates",
      "cover_photo",
      "description",
      "ignore_coordinate_warnings",
      "location",
      "name",
      "phone",
      "picture",
      "website",
      "zip",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINode>() {
           public APINode apply(String result) {
             try {
               return APIRequestCreateAccount.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/accounts", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAccount setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAccount setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAccount setAbout (String about) {
      this.setParam("about", about);
      return this;
    }

    public APIRequestCreateAccount setAddress (String address) {
      this.setParam("address", address);
      return this;
    }

    public APIRequestCreateAccount setCategoryEnum (String categoryEnum) {
      this.setParam("category_enum", categoryEnum);
      return this;
    }

    public APIRequestCreateAccount setCategoryList (List<String> categoryList) {
      this.setParam("category_list", categoryList);
      return this;
    }
    public APIRequestCreateAccount setCategoryList (String categoryList) {
      this.setParam("category_list", categoryList);
      return this;
    }

    public APIRequestCreateAccount setCityId (Object cityId) {
      this.setParam("city_id", cityId);
      return this;
    }
    public APIRequestCreateAccount setCityId (String cityId) {
      this.setParam("city_id", cityId);
      return this;
    }

    public APIRequestCreateAccount setCoordinates (Object coordinates) {
      this.setParam("coordinates", coordinates);
      return this;
    }
    public APIRequestCreateAccount setCoordinates (String coordinates) {
      this.setParam("coordinates", coordinates);
      return this;
    }

    public APIRequestCreateAccount setCoverPhoto (Object coverPhoto) {
      this.setParam("cover_photo", coverPhoto);
      return this;
    }
    public APIRequestCreateAccount setCoverPhoto (String coverPhoto) {
      this.setParam("cover_photo", coverPhoto);
      return this;
    }

    public APIRequestCreateAccount setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateAccount setIgnoreCoordinateWarnings (Boolean ignoreCoordinateWarnings) {
      this.setParam("ignore_coordinate_warnings", ignoreCoordinateWarnings);
      return this;
    }
    public APIRequestCreateAccount setIgnoreCoordinateWarnings (String ignoreCoordinateWarnings) {
      this.setParam("ignore_coordinate_warnings", ignoreCoordinateWarnings);
      return this;
    }

    public APIRequestCreateAccount setLocation (Object location) {
      this.setParam("location", location);
      return this;
    }
    public APIRequestCreateAccount setLocation (String location) {
      this.setParam("location", location);
      return this;
    }

    public APIRequestCreateAccount setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAccount setPhone (String phone) {
      this.setParam("phone", phone);
      return this;
    }

    public APIRequestCreateAccount setPicture (String picture) {
      this.setParam("picture", picture);
      return this;
    }

    public APIRequestCreateAccount setWebsite (String website) {
      this.setParam("website", website);
      return this;
    }

    public APIRequestCreateAccount setZip (String zip) {
      this.setParam("zip", zip);
      return this;
    }

    public APIRequestCreateAccount requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAccount requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAccount requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAccount requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAccount requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAccount requestField (String field, boolean value) {
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
      "extended_credit_invoice_group",
      "failed_delivery_checks",
      "funding_source",
      "funding_source_details",
      "has_migrated_permissions",
      "has_page_authorized_adaccount",
      "id",
      "io_number",
      "is_attribution_spec_system_default",
      "is_direct_deals_enabled",
      "is_in_middle_of_local_entity_migration",
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
      "rate_limit_reset_time",
      "rf_spec",
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
      "user_tos_accepted",
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

    public ListenableFuture<APINodeList<AdAccount>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAccount>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdAccount>>() {
           public APINodeList<AdAccount> apply(String result) {
             try {
               return APIRequestGetAdAccounts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

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
    public APIRequestGetAdAccounts requestExtendedCreditInvoiceGroupField () {
      return this.requestExtendedCreditInvoiceGroupField(true);
    }
    public APIRequestGetAdAccounts requestExtendedCreditInvoiceGroupField (boolean value) {
      this.requestField("extended_credit_invoice_group", value);
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
    public APIRequestGetAdAccounts requestHasPageAuthorizedAdaccountField () {
      return this.requestHasPageAuthorizedAdaccountField(true);
    }
    public APIRequestGetAdAccounts requestHasPageAuthorizedAdaccountField (boolean value) {
      this.requestField("has_page_authorized_adaccount", value);
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
    public APIRequestGetAdAccounts requestIsDirectDealsEnabledField () {
      return this.requestIsDirectDealsEnabledField(true);
    }
    public APIRequestGetAdAccounts requestIsDirectDealsEnabledField (boolean value) {
      this.requestField("is_direct_deals_enabled", value);
      return this;
    }
    public APIRequestGetAdAccounts requestIsInMiddleOfLocalEntityMigrationField () {
      return this.requestIsInMiddleOfLocalEntityMigrationField(true);
    }
    public APIRequestGetAdAccounts requestIsInMiddleOfLocalEntityMigrationField (boolean value) {
      this.requestField("is_in_middle_of_local_entity_migration", value);
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
    public APIRequestGetAdAccounts requestRateLimitResetTimeField () {
      return this.requestRateLimitResetTimeField(true);
    }
    public APIRequestGetAdAccounts requestRateLimitResetTimeField (boolean value) {
      this.requestField("rate_limit_reset_time", value);
      return this;
    }
    public APIRequestGetAdAccounts requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGetAdAccounts requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
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
    public APIRequestGetAdAccounts requestUserTosAcceptedField () {
      return this.requestUserTosAcceptedField(true);
    }
    public APIRequestGetAdAccounts requestUserTosAcceptedField (boolean value) {
      this.requestField("user_tos_accepted", value);
      return this;
    }
  }

  public static class APIRequestCreateAlbum extends APIRequest<Album> {

    Album lastResponse = null;
    @Override
    public Album getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "contributors",
      "description",
      "is_default",
      "location",
      "make_shared_album",
      "message",
      "name",
      "place",
      "privacy",
      "tags",
      "visible",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Album parseResponse(String response) throws APIException {
      return Album.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Album execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Album execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Album> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Album> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Album>() {
           public Album apply(String result) {
             try {
               return APIRequestCreateAlbum.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAlbum(String nodeId, APIContext context) {
      super(context, nodeId, "/albums", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAlbum setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAlbum setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAlbum setContributors (List<Long> contributors) {
      this.setParam("contributors", contributors);
      return this;
    }
    public APIRequestCreateAlbum setContributors (String contributors) {
      this.setParam("contributors", contributors);
      return this;
    }

    public APIRequestCreateAlbum setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateAlbum setIsDefault (Boolean isDefault) {
      this.setParam("is_default", isDefault);
      return this;
    }
    public APIRequestCreateAlbum setIsDefault (String isDefault) {
      this.setParam("is_default", isDefault);
      return this;
    }

    public APIRequestCreateAlbum setLocation (String location) {
      this.setParam("location", location);
      return this;
    }

    public APIRequestCreateAlbum setMakeSharedAlbum (Boolean makeSharedAlbum) {
      this.setParam("make_shared_album", makeSharedAlbum);
      return this;
    }
    public APIRequestCreateAlbum setMakeSharedAlbum (String makeSharedAlbum) {
      this.setParam("make_shared_album", makeSharedAlbum);
      return this;
    }

    public APIRequestCreateAlbum setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateAlbum setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAlbum setPlace (Object place) {
      this.setParam("place", place);
      return this;
    }
    public APIRequestCreateAlbum setPlace (String place) {
      this.setParam("place", place);
      return this;
    }

    public APIRequestCreateAlbum setPrivacy (Object privacy) {
      this.setParam("privacy", privacy);
      return this;
    }
    public APIRequestCreateAlbum setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestCreateAlbum setTags (List<Long> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestCreateAlbum setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestCreateAlbum setVisible (String visible) {
      this.setParam("visible", visible);
      return this;
    }

    public APIRequestCreateAlbum requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAlbum requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAlbum requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAlbum requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAlbum requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAlbum requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetConversations extends APIRequest<UnifiedThread> {

    APINodeList<UnifiedThread> lastResponse = null;
    @Override
    public APINodeList<UnifiedThread> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "folder",
      "tags",
    };

    public static final String[] FIELDS = {
      "can_reply",
      "former_participants",
      "id",
      "is_subscribed",
      "link",
      "message_count",
      "name",
      "participants",
      "scoped_thread_key",
      "senders",
      "snippet",
      "subject",
      "unread_count",
      "updated_time",
      "wallpaper",
    };

    @Override
    public APINodeList<UnifiedThread> parseResponse(String response) throws APIException {
      return UnifiedThread.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<UnifiedThread> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<UnifiedThread> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<UnifiedThread>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<UnifiedThread>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<UnifiedThread>>() {
           public APINodeList<UnifiedThread> apply(String result) {
             try {
               return APIRequestGetConversations.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetConversations(String nodeId, APIContext context) {
      super(context, nodeId, "/conversations", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetConversations setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetConversations setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetConversations setFolder (String folder) {
      this.setParam("folder", folder);
      return this;
    }

    public APIRequestGetConversations setTags (List<String> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestGetConversations setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestGetConversations requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetConversations requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetConversations requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetConversations requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetConversations requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetConversations requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetConversations requestCanReplyField () {
      return this.requestCanReplyField(true);
    }
    public APIRequestGetConversations requestCanReplyField (boolean value) {
      this.requestField("can_reply", value);
      return this;
    }
    public APIRequestGetConversations requestFormerParticipantsField () {
      return this.requestFormerParticipantsField(true);
    }
    public APIRequestGetConversations requestFormerParticipantsField (boolean value) {
      this.requestField("former_participants", value);
      return this;
    }
    public APIRequestGetConversations requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetConversations requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetConversations requestIsSubscribedField () {
      return this.requestIsSubscribedField(true);
    }
    public APIRequestGetConversations requestIsSubscribedField (boolean value) {
      this.requestField("is_subscribed", value);
      return this;
    }
    public APIRequestGetConversations requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetConversations requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetConversations requestMessageCountField () {
      return this.requestMessageCountField(true);
    }
    public APIRequestGetConversations requestMessageCountField (boolean value) {
      this.requestField("message_count", value);
      return this;
    }
    public APIRequestGetConversations requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetConversations requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetConversations requestParticipantsField () {
      return this.requestParticipantsField(true);
    }
    public APIRequestGetConversations requestParticipantsField (boolean value) {
      this.requestField("participants", value);
      return this;
    }
    public APIRequestGetConversations requestScopedThreadKeyField () {
      return this.requestScopedThreadKeyField(true);
    }
    public APIRequestGetConversations requestScopedThreadKeyField (boolean value) {
      this.requestField("scoped_thread_key", value);
      return this;
    }
    public APIRequestGetConversations requestSendersField () {
      return this.requestSendersField(true);
    }
    public APIRequestGetConversations requestSendersField (boolean value) {
      this.requestField("senders", value);
      return this;
    }
    public APIRequestGetConversations requestSnippetField () {
      return this.requestSnippetField(true);
    }
    public APIRequestGetConversations requestSnippetField (boolean value) {
      this.requestField("snippet", value);
      return this;
    }
    public APIRequestGetConversations requestSubjectField () {
      return this.requestSubjectField(true);
    }
    public APIRequestGetConversations requestSubjectField (boolean value) {
      this.requestField("subject", value);
      return this;
    }
    public APIRequestGetConversations requestUnreadCountField () {
      return this.requestUnreadCountField(true);
    }
    public APIRequestGetConversations requestUnreadCountField (boolean value) {
      this.requestField("unread_count", value);
      return this;
    }
    public APIRequestGetConversations requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetConversations requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetConversations requestWallpaperField () {
      return this.requestWallpaperField(true);
    }
    public APIRequestGetConversations requestWallpaperField (boolean value) {
      this.requestField("wallpaper", value);
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
      "created_time",
      "creator",
      "creator_id",
      "cusomized_tcpa_content",
      "expired_leads_count",
      "extra_details",
      "follow_up_action_text",
      "follow_up_action_url",
      "id",
      "is_optimized_for_quality",
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
      "question_page_custom_headline",
      "questions",
      "status",
      "tcpa_compliance",
      "thank_you_page",
      "tracking_parameters",
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

    public ListenableFuture<APINodeList<LeadgenForm>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<LeadgenForm>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<LeadgenForm>>() {
           public APINodeList<LeadgenForm> apply(String result) {
             try {
               return APIRequestGetLeadGenForms.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

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
    public APIRequestGetLeadGenForms requestExtraDetailsField () {
      return this.requestExtraDetailsField(true);
    }
    public APIRequestGetLeadGenForms requestExtraDetailsField (boolean value) {
      this.requestField("extra_details", value);
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
    public APIRequestGetLeadGenForms requestIsOptimizedForQualityField () {
      return this.requestIsOptimizedForQualityField(true);
    }
    public APIRequestGetLeadGenForms requestIsOptimizedForQualityField (boolean value) {
      this.requestField("is_optimized_for_quality", value);
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
    public APIRequestGetLeadGenForms requestQuestionPageCustomHeadlineField () {
      return this.requestQuestionPageCustomHeadlineField(true);
    }
    public APIRequestGetLeadGenForms requestQuestionPageCustomHeadlineField (boolean value) {
      this.requestField("question_page_custom_headline", value);
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
    public APIRequestGetLeadGenForms requestThankYouPageField () {
      return this.requestThankYouPageField(true);
    }
    public APIRequestGetLeadGenForms requestThankYouPageField (boolean value) {
      this.requestField("thank_you_page", value);
      return this;
    }
    public APIRequestGetLeadGenForms requestTrackingParametersField () {
      return this.requestTrackingParametersField(true);
    }
    public APIRequestGetLeadGenForms requestTrackingParametersField (boolean value) {
      this.requestField("tracking_parameters", value);
      return this;
    }
  }

  public static class APIRequestCreateLiveEncoder extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "brand",
      "device_id",
      "model",
      "name",
      "version",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINode>() {
           public APINode apply(String result) {
             try {
               return APIRequestCreateLiveEncoder.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateLiveEncoder(String nodeId, APIContext context) {
      super(context, nodeId, "/live_encoders", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateLiveEncoder setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateLiveEncoder setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateLiveEncoder setBrand (String brand) {
      this.setParam("brand", brand);
      return this;
    }

    public APIRequestCreateLiveEncoder setDeviceId (String deviceId) {
      this.setParam("device_id", deviceId);
      return this;
    }

    public APIRequestCreateLiveEncoder setModel (String model) {
      this.setParam("model", model);
      return this;
    }

    public APIRequestCreateLiveEncoder setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateLiveEncoder setVersion (String version) {
      this.setParam("version", version);
      return this;
    }

    public APIRequestCreateLiveEncoder requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateLiveEncoder requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLiveEncoder requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateLiveEncoder requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLiveEncoder requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateLiveEncoder requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetLiveVideos extends APIRequest<LiveVideo> {

    APINodeList<LiveVideo> lastResponse = null;
    @Override
    public APINodeList<LiveVideo> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "broadcast_status",
      "source",
    };

    public static final String[] FIELDS = {
      "ad_break_config",
      "ad_break_failure_reason",
      "broadcast_start_time",
      "copyright",
      "creation_time",
      "dash_ingest_url",
      "dash_preview_url",
      "description",
      "embed_html",
      "from",
      "id",
      "is_manual_mode",
      "is_reference_only",
      "live_encoders",
      "live_views",
      "permalink_url",
      "planned_start_time",
      "seconds_left",
      "secure_stream_url",
      "status",
      "stream_url",
      "title",
      "video",
    };

    @Override
    public APINodeList<LiveVideo> parseResponse(String response) throws APIException {
      return LiveVideo.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<LiveVideo> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<LiveVideo> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<LiveVideo>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<LiveVideo>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<LiveVideo>>() {
           public APINodeList<LiveVideo> apply(String result) {
             try {
               return APIRequestGetLiveVideos.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetLiveVideos(String nodeId, APIContext context) {
      super(context, nodeId, "/live_videos", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLiveVideos setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLiveVideos setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLiveVideos setBroadcastStatus (List<LiveVideo.EnumBroadcastStatus> broadcastStatus) {
      this.setParam("broadcast_status", broadcastStatus);
      return this;
    }
    public APIRequestGetLiveVideos setBroadcastStatus (String broadcastStatus) {
      this.setParam("broadcast_status", broadcastStatus);
      return this;
    }

    public APIRequestGetLiveVideos setSource (LiveVideo.EnumSource source) {
      this.setParam("source", source);
      return this;
    }
    public APIRequestGetLiveVideos setSource (String source) {
      this.setParam("source", source);
      return this;
    }

    public APIRequestGetLiveVideos requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLiveVideos requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLiveVideos requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLiveVideos requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLiveVideos requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLiveVideos requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetLiveVideos requestAdBreakConfigField () {
      return this.requestAdBreakConfigField(true);
    }
    public APIRequestGetLiveVideos requestAdBreakConfigField (boolean value) {
      this.requestField("ad_break_config", value);
      return this;
    }
    public APIRequestGetLiveVideos requestAdBreakFailureReasonField () {
      return this.requestAdBreakFailureReasonField(true);
    }
    public APIRequestGetLiveVideos requestAdBreakFailureReasonField (boolean value) {
      this.requestField("ad_break_failure_reason", value);
      return this;
    }
    public APIRequestGetLiveVideos requestBroadcastStartTimeField () {
      return this.requestBroadcastStartTimeField(true);
    }
    public APIRequestGetLiveVideos requestBroadcastStartTimeField (boolean value) {
      this.requestField("broadcast_start_time", value);
      return this;
    }
    public APIRequestGetLiveVideos requestCopyrightField () {
      return this.requestCopyrightField(true);
    }
    public APIRequestGetLiveVideos requestCopyrightField (boolean value) {
      this.requestField("copyright", value);
      return this;
    }
    public APIRequestGetLiveVideos requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetLiveVideos requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetLiveVideos requestDashIngestUrlField () {
      return this.requestDashIngestUrlField(true);
    }
    public APIRequestGetLiveVideos requestDashIngestUrlField (boolean value) {
      this.requestField("dash_ingest_url", value);
      return this;
    }
    public APIRequestGetLiveVideos requestDashPreviewUrlField () {
      return this.requestDashPreviewUrlField(true);
    }
    public APIRequestGetLiveVideos requestDashPreviewUrlField (boolean value) {
      this.requestField("dash_preview_url", value);
      return this;
    }
    public APIRequestGetLiveVideos requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetLiveVideos requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetLiveVideos requestEmbedHtmlField () {
      return this.requestEmbedHtmlField(true);
    }
    public APIRequestGetLiveVideos requestEmbedHtmlField (boolean value) {
      this.requestField("embed_html", value);
      return this;
    }
    public APIRequestGetLiveVideos requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetLiveVideos requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetLiveVideos requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetLiveVideos requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetLiveVideos requestIsManualModeField () {
      return this.requestIsManualModeField(true);
    }
    public APIRequestGetLiveVideos requestIsManualModeField (boolean value) {
      this.requestField("is_manual_mode", value);
      return this;
    }
    public APIRequestGetLiveVideos requestIsReferenceOnlyField () {
      return this.requestIsReferenceOnlyField(true);
    }
    public APIRequestGetLiveVideos requestIsReferenceOnlyField (boolean value) {
      this.requestField("is_reference_only", value);
      return this;
    }
    public APIRequestGetLiveVideos requestLiveEncodersField () {
      return this.requestLiveEncodersField(true);
    }
    public APIRequestGetLiveVideos requestLiveEncodersField (boolean value) {
      this.requestField("live_encoders", value);
      return this;
    }
    public APIRequestGetLiveVideos requestLiveViewsField () {
      return this.requestLiveViewsField(true);
    }
    public APIRequestGetLiveVideos requestLiveViewsField (boolean value) {
      this.requestField("live_views", value);
      return this;
    }
    public APIRequestGetLiveVideos requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGetLiveVideos requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGetLiveVideos requestPlannedStartTimeField () {
      return this.requestPlannedStartTimeField(true);
    }
    public APIRequestGetLiveVideos requestPlannedStartTimeField (boolean value) {
      this.requestField("planned_start_time", value);
      return this;
    }
    public APIRequestGetLiveVideos requestSecondsLeftField () {
      return this.requestSecondsLeftField(true);
    }
    public APIRequestGetLiveVideos requestSecondsLeftField (boolean value) {
      this.requestField("seconds_left", value);
      return this;
    }
    public APIRequestGetLiveVideos requestSecureStreamUrlField () {
      return this.requestSecureStreamUrlField(true);
    }
    public APIRequestGetLiveVideos requestSecureStreamUrlField (boolean value) {
      this.requestField("secure_stream_url", value);
      return this;
    }
    public APIRequestGetLiveVideos requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetLiveVideos requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetLiveVideos requestStreamUrlField () {
      return this.requestStreamUrlField(true);
    }
    public APIRequestGetLiveVideos requestStreamUrlField (boolean value) {
      this.requestField("stream_url", value);
      return this;
    }
    public APIRequestGetLiveVideos requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetLiveVideos requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetLiveVideos requestVideoField () {
      return this.requestVideoField(true);
    }
    public APIRequestGetLiveVideos requestVideoField (boolean value) {
      this.requestField("video", value);
      return this;
    }
  }

  public static class APIRequestCreateLiveVideo extends APIRequest<LiveVideo> {

    LiveVideo lastResponse = null;
    @Override
    public LiveVideo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "attribution_app_id",
      "content_tags",
      "description",
      "encoding_settings",
      "fisheye_video_cropped",
      "front_z_rotation",
      "is_spherical",
      "live_encoders",
      "original_fov",
      "planned_start_time",
      "privacy",
      "projection",
      "published",
      "save_vod",
      "schedule_custom_profile_image",
      "spatial_audio_format",
      "status",
      "stereoscopic_mode",
      "stop_on_delete_stream",
      "stream_type",
      "title",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public LiveVideo parseResponse(String response) throws APIException {
      return LiveVideo.parseResponse(response, getContext(), this).head();
    }

    @Override
    public LiveVideo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LiveVideo execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<LiveVideo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LiveVideo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, LiveVideo>() {
           public LiveVideo apply(String result) {
             try {
               return APIRequestCreateLiveVideo.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateLiveVideo(String nodeId, APIContext context) {
      super(context, nodeId, "/live_videos", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateLiveVideo setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateLiveVideo setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateLiveVideo setAttributionAppId (String attributionAppId) {
      this.setParam("attribution_app_id", attributionAppId);
      return this;
    }

    public APIRequestCreateLiveVideo setContentTags (List<String> contentTags) {
      this.setParam("content_tags", contentTags);
      return this;
    }
    public APIRequestCreateLiveVideo setContentTags (String contentTags) {
      this.setParam("content_tags", contentTags);
      return this;
    }

    public APIRequestCreateLiveVideo setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateLiveVideo setEncodingSettings (String encodingSettings) {
      this.setParam("encoding_settings", encodingSettings);
      return this;
    }

    public APIRequestCreateLiveVideo setFisheyeVideoCropped (Boolean fisheyeVideoCropped) {
      this.setParam("fisheye_video_cropped", fisheyeVideoCropped);
      return this;
    }
    public APIRequestCreateLiveVideo setFisheyeVideoCropped (String fisheyeVideoCropped) {
      this.setParam("fisheye_video_cropped", fisheyeVideoCropped);
      return this;
    }

    public APIRequestCreateLiveVideo setFrontZRotation (Double frontZRotation) {
      this.setParam("front_z_rotation", frontZRotation);
      return this;
    }
    public APIRequestCreateLiveVideo setFrontZRotation (String frontZRotation) {
      this.setParam("front_z_rotation", frontZRotation);
      return this;
    }

    public APIRequestCreateLiveVideo setIsSpherical (Boolean isSpherical) {
      this.setParam("is_spherical", isSpherical);
      return this;
    }
    public APIRequestCreateLiveVideo setIsSpherical (String isSpherical) {
      this.setParam("is_spherical", isSpherical);
      return this;
    }

    public APIRequestCreateLiveVideo setLiveEncoders (List<String> liveEncoders) {
      this.setParam("live_encoders", liveEncoders);
      return this;
    }
    public APIRequestCreateLiveVideo setLiveEncoders (String liveEncoders) {
      this.setParam("live_encoders", liveEncoders);
      return this;
    }

    public APIRequestCreateLiveVideo setOriginalFov (Long originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }
    public APIRequestCreateLiveVideo setOriginalFov (String originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }

    public APIRequestCreateLiveVideo setPlannedStartTime (Long plannedStartTime) {
      this.setParam("planned_start_time", plannedStartTime);
      return this;
    }
    public APIRequestCreateLiveVideo setPlannedStartTime (String plannedStartTime) {
      this.setParam("planned_start_time", plannedStartTime);
      return this;
    }

    public APIRequestCreateLiveVideo setPrivacy (Object privacy) {
      this.setParam("privacy", privacy);
      return this;
    }
    public APIRequestCreateLiveVideo setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestCreateLiveVideo setProjection (LiveVideo.EnumProjection projection) {
      this.setParam("projection", projection);
      return this;
    }
    public APIRequestCreateLiveVideo setProjection (String projection) {
      this.setParam("projection", projection);
      return this;
    }

    public APIRequestCreateLiveVideo setPublished (Boolean published) {
      this.setParam("published", published);
      return this;
    }
    public APIRequestCreateLiveVideo setPublished (String published) {
      this.setParam("published", published);
      return this;
    }

    public APIRequestCreateLiveVideo setSaveVod (Boolean saveVod) {
      this.setParam("save_vod", saveVod);
      return this;
    }
    public APIRequestCreateLiveVideo setSaveVod (String saveVod) {
      this.setParam("save_vod", saveVod);
      return this;
    }

    public APIRequestCreateLiveVideo setScheduleCustomProfileImage (File scheduleCustomProfileImage) {
      this.setParam("schedule_custom_profile_image", scheduleCustomProfileImage);
      return this;
    }
    public APIRequestCreateLiveVideo setScheduleCustomProfileImage (String scheduleCustomProfileImage) {
      this.setParam("schedule_custom_profile_image", scheduleCustomProfileImage);
      return this;
    }

    public APIRequestCreateLiveVideo setSpatialAudioFormat (LiveVideo.EnumSpatialAudioFormat spatialAudioFormat) {
      this.setParam("spatial_audio_format", spatialAudioFormat);
      return this;
    }
    public APIRequestCreateLiveVideo setSpatialAudioFormat (String spatialAudioFormat) {
      this.setParam("spatial_audio_format", spatialAudioFormat);
      return this;
    }

    public APIRequestCreateLiveVideo setStatus (LiveVideo.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestCreateLiveVideo setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestCreateLiveVideo setStereoscopicMode (LiveVideo.EnumStereoscopicMode stereoscopicMode) {
      this.setParam("stereoscopic_mode", stereoscopicMode);
      return this;
    }
    public APIRequestCreateLiveVideo setStereoscopicMode (String stereoscopicMode) {
      this.setParam("stereoscopic_mode", stereoscopicMode);
      return this;
    }

    public APIRequestCreateLiveVideo setStopOnDeleteStream (Boolean stopOnDeleteStream) {
      this.setParam("stop_on_delete_stream", stopOnDeleteStream);
      return this;
    }
    public APIRequestCreateLiveVideo setStopOnDeleteStream (String stopOnDeleteStream) {
      this.setParam("stop_on_delete_stream", stopOnDeleteStream);
      return this;
    }

    public APIRequestCreateLiveVideo setStreamType (LiveVideo.EnumStreamType streamType) {
      this.setParam("stream_type", streamType);
      return this;
    }
    public APIRequestCreateLiveVideo setStreamType (String streamType) {
      this.setParam("stream_type", streamType);
      return this;
    }

    public APIRequestCreateLiveVideo setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateLiveVideo requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateLiveVideo requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLiveVideo requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateLiveVideo requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLiveVideo requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateLiveVideo requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreatePhoto extends APIRequest<Photo> {

    Photo lastResponse = null;
    @Override
    public Photo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "aid",
      "allow_spherical_photo",
      "application_id",
      "audience_exp",
      "backdated_time",
      "backdated_time_granularity",
      "caption",
      "composer_session_id",
      "direct_share_status",
      "feed_targeting",
      "full_res_is_coming_later",
      "initial_view_heading_override_degrees",
      "initial_view_pitch_override_degrees",
      "initial_view_vertical_fov_override_degrees",
      "is_explicit_location",
      "is_explicit_place",
      "manual_privacy",
      "message",
      "name",
      "no_story",
      "offline_id",
      "og_action_type_id",
      "og_icon_id",
      "og_object_id",
      "og_phrase",
      "og_set_profile_badge",
      "og_suggestion_mechanism",
      "place",
      "privacy",
      "profile_id",
      "published",
      "qn",
      "scheduled_publish_time",
      "spherical_metadata",
      "sponsor_id",
      "sponsor_relationship",
      "tags",
      "target_id",
      "targeting",
      "url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Photo parseResponse(String response) throws APIException {
      return Photo.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Photo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Photo execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Photo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Photo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Photo>() {
           public Photo apply(String result) {
             try {
               return APIRequestCreatePhoto.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreatePhoto(String nodeId, APIContext context) {
      super(context, nodeId, "/photos", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePhoto setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePhoto setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePhoto setAid (String aid) {
      this.setParam("aid", aid);
      return this;
    }

    public APIRequestCreatePhoto setAllowSphericalPhoto (Boolean allowSphericalPhoto) {
      this.setParam("allow_spherical_photo", allowSphericalPhoto);
      return this;
    }
    public APIRequestCreatePhoto setAllowSphericalPhoto (String allowSphericalPhoto) {
      this.setParam("allow_spherical_photo", allowSphericalPhoto);
      return this;
    }

    public APIRequestCreatePhoto setApplicationId (String applicationId) {
      this.setParam("application_id", applicationId);
      return this;
    }

    public APIRequestCreatePhoto setAudienceExp (Boolean audienceExp) {
      this.setParam("audience_exp", audienceExp);
      return this;
    }
    public APIRequestCreatePhoto setAudienceExp (String audienceExp) {
      this.setParam("audience_exp", audienceExp);
      return this;
    }

    public APIRequestCreatePhoto setBackdatedTime (String backdatedTime) {
      this.setParam("backdated_time", backdatedTime);
      return this;
    }

    public APIRequestCreatePhoto setBackdatedTimeGranularity (Photo.EnumBackdatedTimeGranularity backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }
    public APIRequestCreatePhoto setBackdatedTimeGranularity (String backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }

    public APIRequestCreatePhoto setCaption (String caption) {
      this.setParam("caption", caption);
      return this;
    }

    public APIRequestCreatePhoto setComposerSessionId (String composerSessionId) {
      this.setParam("composer_session_id", composerSessionId);
      return this;
    }

    public APIRequestCreatePhoto setDirectShareStatus (Long directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }
    public APIRequestCreatePhoto setDirectShareStatus (String directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }

    public APIRequestCreatePhoto setFeedTargeting (Object feedTargeting) {
      this.setParam("feed_targeting", feedTargeting);
      return this;
    }
    public APIRequestCreatePhoto setFeedTargeting (String feedTargeting) {
      this.setParam("feed_targeting", feedTargeting);
      return this;
    }

    public APIRequestCreatePhoto setFullResIsComingLater (Boolean fullResIsComingLater) {
      this.setParam("full_res_is_coming_later", fullResIsComingLater);
      return this;
    }
    public APIRequestCreatePhoto setFullResIsComingLater (String fullResIsComingLater) {
      this.setParam("full_res_is_coming_later", fullResIsComingLater);
      return this;
    }

    public APIRequestCreatePhoto setInitialViewHeadingOverrideDegrees (Long initialViewHeadingOverrideDegrees) {
      this.setParam("initial_view_heading_override_degrees", initialViewHeadingOverrideDegrees);
      return this;
    }
    public APIRequestCreatePhoto setInitialViewHeadingOverrideDegrees (String initialViewHeadingOverrideDegrees) {
      this.setParam("initial_view_heading_override_degrees", initialViewHeadingOverrideDegrees);
      return this;
    }

    public APIRequestCreatePhoto setInitialViewPitchOverrideDegrees (Long initialViewPitchOverrideDegrees) {
      this.setParam("initial_view_pitch_override_degrees", initialViewPitchOverrideDegrees);
      return this;
    }
    public APIRequestCreatePhoto setInitialViewPitchOverrideDegrees (String initialViewPitchOverrideDegrees) {
      this.setParam("initial_view_pitch_override_degrees", initialViewPitchOverrideDegrees);
      return this;
    }

    public APIRequestCreatePhoto setInitialViewVerticalFovOverrideDegrees (Long initialViewVerticalFovOverrideDegrees) {
      this.setParam("initial_view_vertical_fov_override_degrees", initialViewVerticalFovOverrideDegrees);
      return this;
    }
    public APIRequestCreatePhoto setInitialViewVerticalFovOverrideDegrees (String initialViewVerticalFovOverrideDegrees) {
      this.setParam("initial_view_vertical_fov_override_degrees", initialViewVerticalFovOverrideDegrees);
      return this;
    }

    public APIRequestCreatePhoto setIsExplicitLocation (Boolean isExplicitLocation) {
      this.setParam("is_explicit_location", isExplicitLocation);
      return this;
    }
    public APIRequestCreatePhoto setIsExplicitLocation (String isExplicitLocation) {
      this.setParam("is_explicit_location", isExplicitLocation);
      return this;
    }

    public APIRequestCreatePhoto setIsExplicitPlace (Boolean isExplicitPlace) {
      this.setParam("is_explicit_place", isExplicitPlace);
      return this;
    }
    public APIRequestCreatePhoto setIsExplicitPlace (String isExplicitPlace) {
      this.setParam("is_explicit_place", isExplicitPlace);
      return this;
    }

    public APIRequestCreatePhoto setManualPrivacy (Boolean manualPrivacy) {
      this.setParam("manual_privacy", manualPrivacy);
      return this;
    }
    public APIRequestCreatePhoto setManualPrivacy (String manualPrivacy) {
      this.setParam("manual_privacy", manualPrivacy);
      return this;
    }

    public APIRequestCreatePhoto setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreatePhoto setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreatePhoto setNoStory (Boolean noStory) {
      this.setParam("no_story", noStory);
      return this;
    }
    public APIRequestCreatePhoto setNoStory (String noStory) {
      this.setParam("no_story", noStory);
      return this;
    }

    public APIRequestCreatePhoto setOfflineId (Long offlineId) {
      this.setParam("offline_id", offlineId);
      return this;
    }
    public APIRequestCreatePhoto setOfflineId (String offlineId) {
      this.setParam("offline_id", offlineId);
      return this;
    }

    public APIRequestCreatePhoto setOgActionTypeId (String ogActionTypeId) {
      this.setParam("og_action_type_id", ogActionTypeId);
      return this;
    }

    public APIRequestCreatePhoto setOgIconId (String ogIconId) {
      this.setParam("og_icon_id", ogIconId);
      return this;
    }

    public APIRequestCreatePhoto setOgObjectId (String ogObjectId) {
      this.setParam("og_object_id", ogObjectId);
      return this;
    }

    public APIRequestCreatePhoto setOgPhrase (String ogPhrase) {
      this.setParam("og_phrase", ogPhrase);
      return this;
    }

    public APIRequestCreatePhoto setOgSetProfileBadge (Boolean ogSetProfileBadge) {
      this.setParam("og_set_profile_badge", ogSetProfileBadge);
      return this;
    }
    public APIRequestCreatePhoto setOgSetProfileBadge (String ogSetProfileBadge) {
      this.setParam("og_set_profile_badge", ogSetProfileBadge);
      return this;
    }

    public APIRequestCreatePhoto setOgSuggestionMechanism (String ogSuggestionMechanism) {
      this.setParam("og_suggestion_mechanism", ogSuggestionMechanism);
      return this;
    }

    public APIRequestCreatePhoto setPlace (Object place) {
      this.setParam("place", place);
      return this;
    }
    public APIRequestCreatePhoto setPlace (String place) {
      this.setParam("place", place);
      return this;
    }

    public APIRequestCreatePhoto setPrivacy (Object privacy) {
      this.setParam("privacy", privacy);
      return this;
    }
    public APIRequestCreatePhoto setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestCreatePhoto setProfileId (Long profileId) {
      this.setParam("profile_id", profileId);
      return this;
    }
    public APIRequestCreatePhoto setProfileId (String profileId) {
      this.setParam("profile_id", profileId);
      return this;
    }

    public APIRequestCreatePhoto setPublished (Boolean published) {
      this.setParam("published", published);
      return this;
    }
    public APIRequestCreatePhoto setPublished (String published) {
      this.setParam("published", published);
      return this;
    }

    public APIRequestCreatePhoto setQn (String qn) {
      this.setParam("qn", qn);
      return this;
    }

    public APIRequestCreatePhoto setScheduledPublishTime (Long scheduledPublishTime) {
      this.setParam("scheduled_publish_time", scheduledPublishTime);
      return this;
    }
    public APIRequestCreatePhoto setScheduledPublishTime (String scheduledPublishTime) {
      this.setParam("scheduled_publish_time", scheduledPublishTime);
      return this;
    }

    public APIRequestCreatePhoto setSphericalMetadata (Map<String, String> sphericalMetadata) {
      this.setParam("spherical_metadata", sphericalMetadata);
      return this;
    }
    public APIRequestCreatePhoto setSphericalMetadata (String sphericalMetadata) {
      this.setParam("spherical_metadata", sphericalMetadata);
      return this;
    }

    public APIRequestCreatePhoto setSponsorId (String sponsorId) {
      this.setParam("sponsor_id", sponsorId);
      return this;
    }

    public APIRequestCreatePhoto setSponsorRelationship (Long sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }
    public APIRequestCreatePhoto setSponsorRelationship (String sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }

    public APIRequestCreatePhoto setTags (List<Object> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestCreatePhoto setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestCreatePhoto setTargetId (Long targetId) {
      this.setParam("target_id", targetId);
      return this;
    }
    public APIRequestCreatePhoto setTargetId (String targetId) {
      this.setParam("target_id", targetId);
      return this;
    }

    public APIRequestCreatePhoto setTargeting (Object targeting) {
      this.setParam("targeting", targeting);
      return this;
    }
    public APIRequestCreatePhoto setTargeting (String targeting) {
      this.setParam("targeting", targeting);
      return this;
    }

    public APIRequestCreatePhoto setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestCreatePhoto requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePhoto requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePhoto requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePhoto requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePhoto requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePhoto requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "cache_key",
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

    public ListenableFuture<APINodeList<ProfilePictureSource>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProfilePictureSource>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProfilePictureSource>>() {
           public APINodeList<ProfilePictureSource> apply(String result) {
             try {
               return APIRequestGetPicture.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

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
    public APIRequestGetPicture requestCacheKeyField () {
      return this.requestCacheKeyField(true);
    }
    public APIRequestGetPicture requestCacheKeyField (boolean value) {
      this.requestField("cache_key", value);
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

    public ListenableFuture<APINodeList<Domain>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Domain>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Domain>>() {
           public APINodeList<Domain> apply(String result) {
             try {
               return APIRequestGetPromotableDomains.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

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
      "promotable_event_types",
    };

    public static final String[] FIELDS = {
      "attending_count",
      "can_guests_invite",
      "category",
      "cover",
      "declined_count",
      "description",
      "discount_code_enabled",
      "end_time",
      "event_times",
      "guest_list_enabled",
      "id",
      "interested_count",
      "is_canceled",
      "is_draft",
      "is_page_owned",
      "maybe_count",
      "name",
      "noreply_count",
      "owner",
      "parent_group",
      "place",
      "scheduled_publish_time",
      "start_time",
      "ticket_uri",
      "ticket_uri_start_sales_time",
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

    public ListenableFuture<APINodeList<Event>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Event>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Event>>() {
           public APINodeList<Event> apply(String result) {
             try {
               return APIRequestGetPromotableEvents.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

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

    public APIRequestGetPromotableEvents setPromotableEventTypes (List<Event.EnumPromotableEventTypes> promotableEventTypes) {
      this.setParam("promotable_event_types", promotableEventTypes);
      return this;
    }
    public APIRequestGetPromotableEvents setPromotableEventTypes (String promotableEventTypes) {
      this.setParam("promotable_event_types", promotableEventTypes);
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
    public APIRequestGetPromotableEvents requestDiscountCodeEnabledField () {
      return this.requestDiscountCodeEnabledField(true);
    }
    public APIRequestGetPromotableEvents requestDiscountCodeEnabledField (boolean value) {
      this.requestField("discount_code_enabled", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetPromotableEvents requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetPromotableEvents requestEventTimesField () {
      return this.requestEventTimesField(true);
    }
    public APIRequestGetPromotableEvents requestEventTimesField (boolean value) {
      this.requestField("event_times", value);
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
    public APIRequestGetPromotableEvents requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGetPromotableEvents requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
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
    public APIRequestGetPromotableEvents requestTicketUriStartSalesTimeField () {
      return this.requestTicketUriStartSalesTimeField(true);
    }
    public APIRequestGetPromotableEvents requestTicketUriStartSalesTimeField (boolean value) {
      this.requestField("ticket_uri_start_sales_time", value);
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

  public static class APIRequestGetThreads extends APIRequest<UnifiedThread> {

    APINodeList<UnifiedThread> lastResponse = null;
    @Override
    public APINodeList<UnifiedThread> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "folder",
      "tags",
    };

    public static final String[] FIELDS = {
      "can_reply",
      "former_participants",
      "id",
      "is_subscribed",
      "link",
      "message_count",
      "name",
      "participants",
      "scoped_thread_key",
      "senders",
      "snippet",
      "subject",
      "unread_count",
      "updated_time",
      "wallpaper",
    };

    @Override
    public APINodeList<UnifiedThread> parseResponse(String response) throws APIException {
      return UnifiedThread.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<UnifiedThread> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<UnifiedThread> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<UnifiedThread>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<UnifiedThread>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<UnifiedThread>>() {
           public APINodeList<UnifiedThread> apply(String result) {
             try {
               return APIRequestGetThreads.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetThreads(String nodeId, APIContext context) {
      super(context, nodeId, "/threads", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetThreads setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetThreads setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetThreads setFolder (String folder) {
      this.setParam("folder", folder);
      return this;
    }

    public APIRequestGetThreads setTags (List<String> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestGetThreads setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestGetThreads requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetThreads requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetThreads requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetThreads requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetThreads requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetThreads requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetThreads requestCanReplyField () {
      return this.requestCanReplyField(true);
    }
    public APIRequestGetThreads requestCanReplyField (boolean value) {
      this.requestField("can_reply", value);
      return this;
    }
    public APIRequestGetThreads requestFormerParticipantsField () {
      return this.requestFormerParticipantsField(true);
    }
    public APIRequestGetThreads requestFormerParticipantsField (boolean value) {
      this.requestField("former_participants", value);
      return this;
    }
    public APIRequestGetThreads requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetThreads requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetThreads requestIsSubscribedField () {
      return this.requestIsSubscribedField(true);
    }
    public APIRequestGetThreads requestIsSubscribedField (boolean value) {
      this.requestField("is_subscribed", value);
      return this;
    }
    public APIRequestGetThreads requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetThreads requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetThreads requestMessageCountField () {
      return this.requestMessageCountField(true);
    }
    public APIRequestGetThreads requestMessageCountField (boolean value) {
      this.requestField("message_count", value);
      return this;
    }
    public APIRequestGetThreads requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetThreads requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetThreads requestParticipantsField () {
      return this.requestParticipantsField(true);
    }
    public APIRequestGetThreads requestParticipantsField (boolean value) {
      this.requestField("participants", value);
      return this;
    }
    public APIRequestGetThreads requestScopedThreadKeyField () {
      return this.requestScopedThreadKeyField(true);
    }
    public APIRequestGetThreads requestScopedThreadKeyField (boolean value) {
      this.requestField("scoped_thread_key", value);
      return this;
    }
    public APIRequestGetThreads requestSendersField () {
      return this.requestSendersField(true);
    }
    public APIRequestGetThreads requestSendersField (boolean value) {
      this.requestField("senders", value);
      return this;
    }
    public APIRequestGetThreads requestSnippetField () {
      return this.requestSnippetField(true);
    }
    public APIRequestGetThreads requestSnippetField (boolean value) {
      this.requestField("snippet", value);
      return this;
    }
    public APIRequestGetThreads requestSubjectField () {
      return this.requestSubjectField(true);
    }
    public APIRequestGetThreads requestSubjectField (boolean value) {
      this.requestField("subject", value);
      return this;
    }
    public APIRequestGetThreads requestUnreadCountField () {
      return this.requestUnreadCountField(true);
    }
    public APIRequestGetThreads requestUnreadCountField (boolean value) {
      this.requestField("unread_count", value);
      return this;
    }
    public APIRequestGetThreads requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetThreads requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetThreads requestWallpaperField () {
      return this.requestWallpaperField(true);
    }
    public APIRequestGetThreads requestWallpaperField (boolean value) {
      this.requestField("wallpaper", value);
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
      "address",
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
      "is_famedeeplinkinguser",
      "is_shared_login",
      "is_verified",
      "labels",
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

    public ListenableFuture<User> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<User> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, User>() {
           public User apply(String result) {
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

    public APIRequestGet requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGet requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGet requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGet requestAddressField (boolean value) {
      this.requestField("address", value);
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
    public APIRequestGet requestIsFamedeeplinkinguserField () {
      return this.requestIsFamedeeplinkinguserField(true);
    }
    public APIRequestGet requestIsFamedeeplinkinguserField (boolean value) {
      this.requestField("is_famedeeplinkinguser", value);
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
    public APIRequestGet requestLocalNewsMegaphoneDismissStatusField () {
      return this.requestLocalNewsMegaphoneDismissStatusField(true);
    }
    public APIRequestGet requestLocalNewsMegaphoneDismissStatusField (boolean value) {
      this.requestField("local_news_megaphone_dismiss_status", value);
      return this;
    }
    public APIRequestGet requestLocalNewsSubscriptionStatusField () {
      return this.requestLocalNewsSubscriptionStatusField(true);
    }
    public APIRequestGet requestLocalNewsSubscriptionStatusField (boolean value) {
      this.requestField("local_news_subscription_status", value);
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
    public APIRequestGet requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGet requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
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
    this.mAddress = instance.mAddress;
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
    this.mIsFamedeeplinkinguser = instance.mIsFamedeeplinkinguser;
    this.mIsSharedLogin = instance.mIsSharedLogin;
    this.mIsVerified = instance.mIsVerified;
    this.mLabels = instance.mLabels;
    this.mLanguages = instance.mLanguages;
    this.mLastName = instance.mLastName;
    this.mLink = instance.mLink;
    this.mLocalNewsMegaphoneDismissStatus = instance.mLocalNewsMegaphoneDismissStatus;
    this.mLocalNewsSubscriptionStatus = instance.mLocalNewsSubscriptionStatus;
    this.mLocale = instance.mLocale;
    this.mLocation = instance.mLocation;
    this.mMeetingFor = instance.mMeetingFor;
    this.mMiddleName = instance.mMiddleName;
    this.mName = instance.mName;
    this.mNameFormat = instance.mNameFormat;
    this.mPaymentPricepoints = instance.mPaymentPricepoints;
    this.mPolitical = instance.mPolitical;
    this.mProfilePic = instance.mProfilePic;
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
