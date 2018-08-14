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
public class Page extends APINode {
  @SerializedName("about")
  private String mAbout = null;
  @SerializedName("access_token")
  private String mAccessToken = null;
  @SerializedName("ad_campaign")
  private AdSet mAdCampaign = null;
  @SerializedName("affiliation")
  private String mAffiliation = null;
  @SerializedName("app_id")
  private String mAppId = null;
  @SerializedName("app_links")
  private AppLinks mAppLinks = null;
  @SerializedName("artists_we_like")
  private String mArtistsWeLike = null;
  @SerializedName("attire")
  private String mAttire = null;
  @SerializedName("awards")
  private String mAwards = null;
  @SerializedName("band_interests")
  private String mBandInterests = null;
  @SerializedName("band_members")
  private String mBandMembers = null;
  @SerializedName("best_page")
  private Page mBestPage = null;
  @SerializedName("bio")
  private String mBio = null;
  @SerializedName("birthday")
  private String mBirthday = null;
  @SerializedName("booking_agent")
  private String mBookingAgent = null;
  @SerializedName("built")
  private String mBuilt = null;
  @SerializedName("business")
  private Object mBusiness = null;
  @SerializedName("can_checkin")
  private Boolean mCanCheckin = null;
  @SerializedName("can_post")
  private Boolean mCanPost = null;
  @SerializedName("category")
  private String mCategory = null;
  @SerializedName("category_list")
  private List<PageCategory> mCategoryList = null;
  @SerializedName("checkins")
  private Long mCheckins = null;
  @SerializedName("company_overview")
  private String mCompanyOverview = null;
  @SerializedName("connected_instagram_account")
  private ShadowIGUser mConnectedInstagramAccount = null;
  @SerializedName("contact_address")
  private MailingAddress mContactAddress = null;
  @SerializedName("context")
  private OpenGraphContext mContext = null;
  @SerializedName("copyright_attribution_insights")
  private CopyrightAttributionInsights mCopyrightAttributionInsights = null;
  @SerializedName("copyright_whitelisted_ig_partners")
  private List<String> mCopyrightWhitelistedIgPartners = null;
  @SerializedName("country_page_likes")
  private Long mCountryPageLikes = null;
  @SerializedName("cover")
  private CoverPhoto mCover = null;
  @SerializedName("culinary_team")
  private String mCulinaryTeam = null;
  @SerializedName("current_location")
  private String mCurrentLocation = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("description_html")
  private String mDescriptionHtml = null;
  @SerializedName("directed_by")
  private String mDirectedBy = null;
  @SerializedName("display_subtext")
  private String mDisplaySubtext = null;
  @SerializedName("displayed_message_response_time")
  private String mDisplayedMessageResponseTime = null;
  @SerializedName("emails")
  private List<String> mEmails = null;
  @SerializedName("engagement")
  private Engagement mEngagement = null;
  @SerializedName("fan_count")
  private Long mFanCount = null;
  @SerializedName("featured_video")
  private Object mFeaturedVideo = null;
  @SerializedName("features")
  private String mFeatures = null;
  @SerializedName("food_styles")
  private List<String> mFoodStyles = null;
  @SerializedName("founded")
  private String mFounded = null;
  @SerializedName("general_info")
  private String mGeneralInfo = null;
  @SerializedName("general_manager")
  private String mGeneralManager = null;
  @SerializedName("genre")
  private String mGenre = null;
  @SerializedName("global_brand_page_name")
  private String mGlobalBrandPageName = null;
  @SerializedName("global_brand_root_id")
  private String mGlobalBrandRootId = null;
  @SerializedName("has_added_app")
  private Boolean mHasAddedApp = null;
  @SerializedName("has_whatsapp_number")
  private Boolean mHasWhatsappNumber = null;
  @SerializedName("hometown")
  private String mHometown = null;
  @SerializedName("hours")
  private Map<String, String> mHours = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("impressum")
  private String mImpressum = null;
  @SerializedName("influences")
  private String mInfluences = null;
  @SerializedName("instagram_business_account")
  private ShadowIGUser mInstagramBusinessAccount = null;
  @SerializedName("instant_articles_review_status")
  private String mInstantArticlesReviewStatus = null;
  @SerializedName("is_always_open")
  private Boolean mIsAlwaysOpen = null;
  @SerializedName("is_chain")
  private Boolean mIsChain = null;
  @SerializedName("is_community_page")
  private Boolean mIsCommunityPage = null;
  @SerializedName("is_eligible_for_branded_content")
  private Boolean mIsEligibleForBrandedContent = null;
  @SerializedName("is_messenger_bot_get_started_enabled")
  private Boolean mIsMessengerBotGetStartedEnabled = null;
  @SerializedName("is_messenger_platform_bot")
  private Boolean mIsMessengerPlatformBot = null;
  @SerializedName("is_owned")
  private Boolean mIsOwned = null;
  @SerializedName("is_permanently_closed")
  private Boolean mIsPermanentlyClosed = null;
  @SerializedName("is_published")
  private Boolean mIsPublished = null;
  @SerializedName("is_unclaimed")
  private Boolean mIsUnclaimed = null;
  @SerializedName("is_verified")
  private Boolean mIsVerified = null;
  @SerializedName("is_webhooks_subscribed")
  private Boolean mIsWebhooksSubscribed = null;
  @SerializedName("keywords")
  private Object mKeywords = null;
  @SerializedName("leadgen_form_preview_details")
  private LeadGenFormPreviewDetails mLeadgenFormPreviewDetails = null;
  @SerializedName("leadgen_has_crm_integration")
  private Boolean mLeadgenHasCrmIntegration = null;
  @SerializedName("leadgen_has_fat_ping_crm_integration")
  private Boolean mLeadgenHasFatPingCrmIntegration = null;
  @SerializedName("leadgen_tos_acceptance_time")
  private String mLeadgenTosAcceptanceTime = null;
  @SerializedName("leadgen_tos_accepted")
  private Boolean mLeadgenTosAccepted = null;
  @SerializedName("leadgen_tos_accepting_user")
  private User mLeadgenTosAcceptingUser = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("location")
  private Location mLocation = null;
  @SerializedName("members")
  private String mMembers = null;
  @SerializedName("merchant_id")
  private String mMerchantId = null;
  @SerializedName("merchant_review_status")
  private String mMerchantReviewStatus = null;
  @SerializedName("messenger_ads_default_icebreakers")
  private List<String> mMessengerAdsDefaultIcebreakers = null;
  @SerializedName("messenger_ads_default_page_welcome_message")
  private Object mMessengerAdsDefaultPageWelcomeMessage = null;
  @SerializedName("messenger_ads_default_quick_replies")
  private List<String> mMessengerAdsDefaultQuickReplies = null;
  @SerializedName("messenger_ads_quick_replies_type")
  private String mMessengerAdsQuickRepliesType = null;
  @SerializedName("mission")
  private String mMission = null;
  @SerializedName("mpg")
  private String mMpg = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("name_with_location_descriptor")
  private String mNameWithLocationDescriptor = null;
  @SerializedName("network")
  private String mNetwork = null;
  @SerializedName("new_like_count")
  private Long mNewLikeCount = null;
  @SerializedName("offer_eligible")
  private Boolean mOfferEligible = null;
  @SerializedName("overall_star_rating")
  private Double mOverallStarRating = null;
  @SerializedName("page_token")
  private String mPageToken = null;
  @SerializedName("parent_page")
  private Page mParentPage = null;
  @SerializedName("parking")
  private PageParking mParking = null;
  @SerializedName("payment_options")
  private PagePaymentOptions mPaymentOptions = null;
  @SerializedName("personal_info")
  private String mPersonalInfo = null;
  @SerializedName("personal_interests")
  private String mPersonalInterests = null;
  @SerializedName("pharma_safety_info")
  private String mPharmaSafetyInfo = null;
  @SerializedName("phone")
  private String mPhone = null;
  @SerializedName("place_type")
  private String mPlaceType = null;
  @SerializedName("plot_outline")
  private String mPlotOutline = null;
  @SerializedName("preferred_audience")
  private Targeting mPreferredAudience = null;
  @SerializedName("press_contact")
  private String mPressContact = null;
  @SerializedName("price_range")
  private String mPriceRange = null;
  @SerializedName("produced_by")
  private String mProducedBy = null;
  @SerializedName("products")
  private String mProducts = null;
  @SerializedName("promotion_eligible")
  private Boolean mPromotionEligible = null;
  @SerializedName("promotion_ineligible_reason")
  private String mPromotionIneligibleReason = null;
  @SerializedName("public_transit")
  private String mPublicTransit = null;
  @SerializedName("publisher_space")
  private PublisherSpace mPublisherSpace = null;
  @SerializedName("rating_count")
  private Long mRatingCount = null;
  @SerializedName("recipient")
  private String mRecipient = null;
  @SerializedName("record_label")
  private String mRecordLabel = null;
  @SerializedName("release_date")
  private String mReleaseDate = null;
  @SerializedName("restaurant_services")
  private PageRestaurantServices mRestaurantServices = null;
  @SerializedName("restaurant_specialties")
  private PageRestaurantSpecialties mRestaurantSpecialties = null;
  @SerializedName("schedule")
  private String mSchedule = null;
  @SerializedName("screenplay_by")
  private String mScreenplayBy = null;
  @SerializedName("season")
  private String mSeason = null;
  @SerializedName("single_line_address")
  private String mSingleLineAddress = null;
  @SerializedName("starring")
  private String mStarring = null;
  @SerializedName("start_info")
  private PageStartInfo mStartInfo = null;
  @SerializedName("store_code")
  private String mStoreCode = null;
  @SerializedName("store_location_descriptor")
  private String mStoreLocationDescriptor = null;
  @SerializedName("store_number")
  private Long mStoreNumber = null;
  @SerializedName("studio")
  private String mStudio = null;
  @SerializedName("supports_instant_articles")
  private Boolean mSupportsInstantArticles = null;
  @SerializedName("talking_about_count")
  private Long mTalkingAboutCount = null;
  @SerializedName("unread_message_count")
  private Long mUnreadMessageCount = null;
  @SerializedName("unread_notif_count")
  private Long mUnreadNotifCount = null;
  @SerializedName("unseen_message_count")
  private Long mUnseenMessageCount = null;
  @SerializedName("username")
  private String mUsername = null;
  @SerializedName("verification_status")
  private String mVerificationStatus = null;
  @SerializedName("voip_info")
  private VoipInfo mVoipInfo = null;
  @SerializedName("website")
  private String mWebsite = null;
  @SerializedName("were_here_count")
  private Long mWereHereCount = null;
  @SerializedName("whatsapp_number")
  private String mWhatsappNumber = null;
  @SerializedName("written_by")
  private String mWrittenBy = null;
  protected static Gson gson = null;

  Page() {
  }

  public Page(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Page(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public Page fetch() throws APIException{
    Page newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Page fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Page> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Page fetchById(String id, APIContext context) throws APIException {
    Page page =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return page;
  }

  public static ListenableFuture<Page> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<Page> page =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return page;
  }

  public static APINodeList<Page> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Page>)(
      new APIRequest<Page>(context, "", "/", "GET", Page.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Page>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<Page>> page =
      new APIRequest(context, "", "/", "GET", Page.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return page;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static Page loadJSON(String json, APIContext context) {
    Page page = getGson().fromJson(json, Page.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(page.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    page.context = context;
    page.rawValue = json;
    return page;
  }

  public static APINodeList<Page> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<Page> pages = new APINodeList<Page>(request, json);
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
          pages.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return pages;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                pages.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            pages.setPaging(previous, next);
            if (context.hasAppSecret()) {
              pages.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              pages.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  pages.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              pages.add(loadJSON(obj.toString(), context));
            }
          }
          return pages;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              pages.add(loadJSON(entry.getValue().toString(), context));
          }
          return pages;
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
              pages.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return pages;
          }

          // Sixth, check if it's pure JsonObject
          pages.clear();
          pages.add(loadJSON(json, context));
          return pages;
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

  public APIRequestCreateAdminNote createAdminNote() {
    return new APIRequestCreateAdminNote(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAlbum createAlbum() {
    return new APIRequestCreateAlbum(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteAssignedUsers deleteAssignedUsers() {
    return new APIRequestDeleteAssignedUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAssignedUsers getAssignedUsers() {
    return new APIRequestGetAssignedUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAssignedUser createAssignedUser() {
    return new APIRequestCreateAssignedUser(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAudioCopyrights getAudioCopyrights() {
    return new APIRequestGetAudioCopyrights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAudioMediaCopyrights getAudioMediaCopyrights() {
    return new APIRequestGetAudioMediaCopyrights(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteBlocked deleteBlocked() {
    return new APIRequestDeleteBlocked(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBlocked getBlocked() {
    return new APIRequestGetBlocked(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateBlocked createBlocked() {
    return new APIRequestCreateBlocked(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBusinessActivities getBusinessActivities() {
    return new APIRequestGetBusinessActivities(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCallToAction createCallToAction() {
    return new APIRequestCreateCallToAction(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCanvasElement createCanvasElement() {
    return new APIRequestCreateCanvasElement(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCanvases getCanvases() {
    return new APIRequestGetCanvases(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCanvase createCanvase() {
    return new APIRequestCreateCanvase(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetChangeProposals getChangeProposals() {
    return new APIRequestGetChangeProposals(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteClaimedUrls deleteClaimedUrls() {
    return new APIRequestDeleteClaimedUrls(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateClaimedUrl createClaimedUrl() {
    return new APIRequestCreateClaimedUrl(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetConversations getConversations() {
    return new APIRequestGetConversations(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCopyrightManualClaim createCopyrightManualClaim() {
    return new APIRequestCreateCopyrightManualClaim(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetEvents getEvents() {
    return new APIRequestGetEvents(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetFeed getFeed() {
    return new APIRequestGetFeed(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateFeed createFeed() {
    return new APIRequestCreateFeed(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsightsExports getInsightsExports() {
    return new APIRequestGetInsightsExports(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInstantArticles getInstantArticles() {
    return new APIRequestGetInstantArticles(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateInstantArticle createInstantArticle() {
    return new APIRequestCreateInstantArticle(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInstantArticlesInsights getInstantArticlesInsights() {
    return new APIRequestGetInstantArticlesInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateInstantArticlesPublish createInstantArticlesPublish() {
    return new APIRequestCreateInstantArticlesPublish(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLabel createLabel() {
    return new APIRequestCreateLabel(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLeadGenConditionalQuestionsGroup createLeadGenConditionalQuestionsGroup() {
    return new APIRequestCreateLeadGenConditionalQuestionsGroup(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLeadGenContextCard createLeadGenContextCard() {
    return new APIRequestCreateLeadGenContextCard(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLeadGenDraftForm createLeadGenDraftForm() {
    return new APIRequestCreateLeadGenDraftForm(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLeadGenForm createLeadGenForm() {
    return new APIRequestCreateLeadGenForm(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLeadGenLegalContent createLeadGenLegalContent() {
    return new APIRequestCreateLeadGenLegalContent(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteLeadGenWhitelistedUsers deleteLeadGenWhitelistedUsers() {
    return new APIRequestDeleteLeadGenWhitelistedUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLeadGenWhitelistedUser createLeadGenWhitelistedUser() {
    return new APIRequestCreateLeadGenWhitelistedUser(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLikes getLikes() {
    return new APIRequestGetLikes(this.getPrefixedId().toString(), context);
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

  public APIRequestDeleteLocations deleteLocations() {
    return new APIRequestDeleteLocations(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLocations getLocations() {
    return new APIRequestGetLocations(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLocation createLocation() {
    return new APIRequestCreateLocation(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMediaFingerprint createMediaFingerprint() {
    return new APIRequestCreateMediaFingerprint(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMessageAttachment createMessageAttachment() {
    return new APIRequestCreateMessageAttachment(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMessage createMessage() {
    return new APIRequestCreateMessage(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMessagingFeatureReview getMessagingFeatureReview() {
    return new APIRequestGetMessagingFeatureReview(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMessengerCode createMessengerCode() {
    return new APIRequestCreateMessengerCode(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteMessengerProfile deleteMessengerProfile() {
    return new APIRequestDeleteMessengerProfile(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMessengerProfile createMessengerProfile() {
    return new APIRequestCreateMessengerProfile(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMilestone createMilestone() {
    return new APIRequestCreateMilestone(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetNativeOffers getNativeOffers() {
    return new APIRequestGetNativeOffers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateNativeOffer createNativeOffer() {
    return new APIRequestCreateNativeOffer(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateNlpConfig createNlpConfig() {
    return new APIRequestCreateNlpConfig(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePageBackedInstagramAccount createPageBackedInstagramAccount() {
    return new APIRequestCreatePageBackedInstagramAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePassThreadControl createPassThreadControl() {
    return new APIRequestCreatePassThreadControl(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPhotos getPhotos() {
    return new APIRequestGetPhotos(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePhoto createPhoto() {
    return new APIRequestCreatePhoto(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPicture getPicture() {
    return new APIRequestGetPicture(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePicture createPicture() {
    return new APIRequestCreatePicture(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPlaceTopics getPlaceTopics() {
    return new APIRequestGetPlaceTopics(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPosts getPosts() {
    return new APIRequestGetPosts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetProductCatalogs getProductCatalogs() {
    return new APIRequestGetProductCatalogs(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPromotablePosts getPromotablePosts() {
    return new APIRequestGetPromotablePosts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPublishedPosts getPublishedPosts() {
    return new APIRequestGetPublishedPosts(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateRequestThreadControl createRequestThreadControl() {
    return new APIRequestCreateRequestThreadControl(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetRoles getRoles() {
    return new APIRequestGetRoles(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSavedFilters getSavedFilters() {
    return new APIRequestGetSavedFilters(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSavedMessageResponse createSavedMessageResponse() {
    return new APIRequestCreateSavedMessageResponse(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetScheduledPosts getScheduledPosts() {
    return new APIRequestGetScheduledPosts(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSetting createSetting() {
    return new APIRequestCreateSetting(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteSubscribedApps deleteSubscribedApps() {
    return new APIRequestDeleteSubscribedApps(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSubscribedApp createSubscribedApp() {
    return new APIRequestCreateSubscribedApp(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteTabs deleteTabs() {
    return new APIRequestDeleteTabs(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTabs getTabs() {
    return new APIRequestGetTabs(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateTab createTab() {
    return new APIRequestCreateTab(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTagged getTagged() {
    return new APIRequestGetTagged(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateThreadSetting createThreadSetting() {
    return new APIRequestCreateThreadSetting(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetThreads getThreads() {
    return new APIRequestGetThreads(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetUpcomingChanges getUpcomingChanges() {
    return new APIRequestGetUpcomingChanges(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetVideoCopyrightRules getVideoCopyrightRules() {
    return new APIRequestGetVideoCopyrightRules(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateVideoCopyrightRule createVideoCopyrightRule() {
    return new APIRequestCreateVideoCopyrightRule(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetVideoCopyrights getVideoCopyrights() {
    return new APIRequestGetVideoCopyrights(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateVideoCopyright createVideoCopyright() {
    return new APIRequestCreateVideoCopyright(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteVideoLists deleteVideoLists() {
    return new APIRequestDeleteVideoLists(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateVideoList createVideoList() {
    return new APIRequestCreateVideoList(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetVideoMediaCopyrights getVideoMediaCopyrights() {
    return new APIRequestGetVideoMediaCopyrights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetVideos getVideos() {
    return new APIRequestGetVideos(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateVideo createVideo() {
    return new APIRequestCreateVideo(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetVisitorPosts getVisitorPosts() {
    return new APIRequestGetVisitorPosts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldAbout() {
    return mAbout;
  }

  public String getFieldAccessToken() {
    return mAccessToken;
  }

  public AdSet getFieldAdCampaign() {
    if (mAdCampaign != null) {
      mAdCampaign.context = getContext();
    }
    return mAdCampaign;
  }

  public String getFieldAffiliation() {
    return mAffiliation;
  }

  public String getFieldAppId() {
    return mAppId;
  }

  public AppLinks getFieldAppLinks() {
    if (mAppLinks != null) {
      mAppLinks.context = getContext();
    }
    return mAppLinks;
  }

  public String getFieldArtistsWeLike() {
    return mArtistsWeLike;
  }

  public String getFieldAttire() {
    return mAttire;
  }

  public String getFieldAwards() {
    return mAwards;
  }

  public String getFieldBandInterests() {
    return mBandInterests;
  }

  public String getFieldBandMembers() {
    return mBandMembers;
  }

  public Page getFieldBestPage() {
    if (mBestPage != null) {
      mBestPage.context = getContext();
    }
    return mBestPage;
  }

  public String getFieldBio() {
    return mBio;
  }

  public String getFieldBirthday() {
    return mBirthday;
  }

  public String getFieldBookingAgent() {
    return mBookingAgent;
  }

  public String getFieldBuilt() {
    return mBuilt;
  }

  public Object getFieldBusiness() {
    return mBusiness;
  }

  public Boolean getFieldCanCheckin() {
    return mCanCheckin;
  }

  public Boolean getFieldCanPost() {
    return mCanPost;
  }

  public String getFieldCategory() {
    return mCategory;
  }

  public List<PageCategory> getFieldCategoryList() {
    return mCategoryList;
  }

  public Long getFieldCheckins() {
    return mCheckins;
  }

  public String getFieldCompanyOverview() {
    return mCompanyOverview;
  }

  public ShadowIGUser getFieldConnectedInstagramAccount() {
    if (mConnectedInstagramAccount != null) {
      mConnectedInstagramAccount.context = getContext();
    }
    return mConnectedInstagramAccount;
  }

  public MailingAddress getFieldContactAddress() {
    if (mContactAddress != null) {
      mContactAddress.context = getContext();
    }
    return mContactAddress;
  }

  public OpenGraphContext getFieldContext() {
    if (mContext != null) {
      mContext.context = getContext();
    }
    return mContext;
  }

  public CopyrightAttributionInsights getFieldCopyrightAttributionInsights() {
    return mCopyrightAttributionInsights;
  }

  public List<String> getFieldCopyrightWhitelistedIgPartners() {
    return mCopyrightWhitelistedIgPartners;
  }

  public Long getFieldCountryPageLikes() {
    return mCountryPageLikes;
  }

  public CoverPhoto getFieldCover() {
    return mCover;
  }

  public String getFieldCulinaryTeam() {
    return mCulinaryTeam;
  }

  public String getFieldCurrentLocation() {
    return mCurrentLocation;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldDescriptionHtml() {
    return mDescriptionHtml;
  }

  public String getFieldDirectedBy() {
    return mDirectedBy;
  }

  public String getFieldDisplaySubtext() {
    return mDisplaySubtext;
  }

  public String getFieldDisplayedMessageResponseTime() {
    return mDisplayedMessageResponseTime;
  }

  public List<String> getFieldEmails() {
    return mEmails;
  }

  public Engagement getFieldEngagement() {
    return mEngagement;
  }

  public Long getFieldFanCount() {
    return mFanCount;
  }

  public Object getFieldFeaturedVideo() {
    return mFeaturedVideo;
  }

  public String getFieldFeatures() {
    return mFeatures;
  }

  public List<String> getFieldFoodStyles() {
    return mFoodStyles;
  }

  public String getFieldFounded() {
    return mFounded;
  }

  public String getFieldGeneralInfo() {
    return mGeneralInfo;
  }

  public String getFieldGeneralManager() {
    return mGeneralManager;
  }

  public String getFieldGenre() {
    return mGenre;
  }

  public String getFieldGlobalBrandPageName() {
    return mGlobalBrandPageName;
  }

  public String getFieldGlobalBrandRootId() {
    return mGlobalBrandRootId;
  }

  public Boolean getFieldHasAddedApp() {
    return mHasAddedApp;
  }

  public Boolean getFieldHasWhatsappNumber() {
    return mHasWhatsappNumber;
  }

  public String getFieldHometown() {
    return mHometown;
  }

  public Map<String, String> getFieldHours() {
    return mHours;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldImpressum() {
    return mImpressum;
  }

  public String getFieldInfluences() {
    return mInfluences;
  }

  public ShadowIGUser getFieldInstagramBusinessAccount() {
    if (mInstagramBusinessAccount != null) {
      mInstagramBusinessAccount.context = getContext();
    }
    return mInstagramBusinessAccount;
  }

  public String getFieldInstantArticlesReviewStatus() {
    return mInstantArticlesReviewStatus;
  }

  public Boolean getFieldIsAlwaysOpen() {
    return mIsAlwaysOpen;
  }

  public Boolean getFieldIsChain() {
    return mIsChain;
  }

  public Boolean getFieldIsCommunityPage() {
    return mIsCommunityPage;
  }

  public Boolean getFieldIsEligibleForBrandedContent() {
    return mIsEligibleForBrandedContent;
  }

  public Boolean getFieldIsMessengerBotGetStartedEnabled() {
    return mIsMessengerBotGetStartedEnabled;
  }

  public Boolean getFieldIsMessengerPlatformBot() {
    return mIsMessengerPlatformBot;
  }

  public Boolean getFieldIsOwned() {
    return mIsOwned;
  }

  public Boolean getFieldIsPermanentlyClosed() {
    return mIsPermanentlyClosed;
  }

  public Boolean getFieldIsPublished() {
    return mIsPublished;
  }

  public Boolean getFieldIsUnclaimed() {
    return mIsUnclaimed;
  }

  public Boolean getFieldIsVerified() {
    return mIsVerified;
  }

  public Boolean getFieldIsWebhooksSubscribed() {
    return mIsWebhooksSubscribed;
  }

  public Object getFieldKeywords() {
    return mKeywords;
  }

  public LeadGenFormPreviewDetails getFieldLeadgenFormPreviewDetails() {
    return mLeadgenFormPreviewDetails;
  }

  public Boolean getFieldLeadgenHasCrmIntegration() {
    return mLeadgenHasCrmIntegration;
  }

  public Boolean getFieldLeadgenHasFatPingCrmIntegration() {
    return mLeadgenHasFatPingCrmIntegration;
  }

  public String getFieldLeadgenTosAcceptanceTime() {
    return mLeadgenTosAcceptanceTime;
  }

  public Boolean getFieldLeadgenTosAccepted() {
    return mLeadgenTosAccepted;
  }

  public User getFieldLeadgenTosAcceptingUser() {
    if (mLeadgenTosAcceptingUser != null) {
      mLeadgenTosAcceptingUser.context = getContext();
    }
    return mLeadgenTosAcceptingUser;
  }

  public String getFieldLink() {
    return mLink;
  }

  public Location getFieldLocation() {
    return mLocation;
  }

  public String getFieldMembers() {
    return mMembers;
  }

  public String getFieldMerchantId() {
    return mMerchantId;
  }

  public String getFieldMerchantReviewStatus() {
    return mMerchantReviewStatus;
  }

  public List<String> getFieldMessengerAdsDefaultIcebreakers() {
    return mMessengerAdsDefaultIcebreakers;
  }

  public Object getFieldMessengerAdsDefaultPageWelcomeMessage() {
    return mMessengerAdsDefaultPageWelcomeMessage;
  }

  public List<String> getFieldMessengerAdsDefaultQuickReplies() {
    return mMessengerAdsDefaultQuickReplies;
  }

  public String getFieldMessengerAdsQuickRepliesType() {
    return mMessengerAdsQuickRepliesType;
  }

  public String getFieldMission() {
    return mMission;
  }

  public String getFieldMpg() {
    return mMpg;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldNameWithLocationDescriptor() {
    return mNameWithLocationDescriptor;
  }

  public String getFieldNetwork() {
    return mNetwork;
  }

  public Long getFieldNewLikeCount() {
    return mNewLikeCount;
  }

  public Boolean getFieldOfferEligible() {
    return mOfferEligible;
  }

  public Double getFieldOverallStarRating() {
    return mOverallStarRating;
  }

  public String getFieldPageToken() {
    return mPageToken;
  }

  public Page getFieldParentPage() {
    if (mParentPage != null) {
      mParentPage.context = getContext();
    }
    return mParentPage;
  }

  public PageParking getFieldParking() {
    return mParking;
  }

  public PagePaymentOptions getFieldPaymentOptions() {
    return mPaymentOptions;
  }

  public String getFieldPersonalInfo() {
    return mPersonalInfo;
  }

  public String getFieldPersonalInterests() {
    return mPersonalInterests;
  }

  public String getFieldPharmaSafetyInfo() {
    return mPharmaSafetyInfo;
  }

  public String getFieldPhone() {
    return mPhone;
  }

  public String getFieldPlaceType() {
    return mPlaceType;
  }

  public String getFieldPlotOutline() {
    return mPlotOutline;
  }

  public Targeting getFieldPreferredAudience() {
    return mPreferredAudience;
  }

  public String getFieldPressContact() {
    return mPressContact;
  }

  public String getFieldPriceRange() {
    return mPriceRange;
  }

  public String getFieldProducedBy() {
    return mProducedBy;
  }

  public String getFieldProducts() {
    return mProducts;
  }

  public Boolean getFieldPromotionEligible() {
    return mPromotionEligible;
  }

  public String getFieldPromotionIneligibleReason() {
    return mPromotionIneligibleReason;
  }

  public String getFieldPublicTransit() {
    return mPublicTransit;
  }

  public PublisherSpace getFieldPublisherSpace() {
    if (mPublisherSpace != null) {
      mPublisherSpace.context = getContext();
    }
    return mPublisherSpace;
  }

  public Long getFieldRatingCount() {
    return mRatingCount;
  }

  public String getFieldRecipient() {
    return mRecipient;
  }

  public String getFieldRecordLabel() {
    return mRecordLabel;
  }

  public String getFieldReleaseDate() {
    return mReleaseDate;
  }

  public PageRestaurantServices getFieldRestaurantServices() {
    return mRestaurantServices;
  }

  public PageRestaurantSpecialties getFieldRestaurantSpecialties() {
    return mRestaurantSpecialties;
  }

  public String getFieldSchedule() {
    return mSchedule;
  }

  public String getFieldScreenplayBy() {
    return mScreenplayBy;
  }

  public String getFieldSeason() {
    return mSeason;
  }

  public String getFieldSingleLineAddress() {
    return mSingleLineAddress;
  }

  public String getFieldStarring() {
    return mStarring;
  }

  public PageStartInfo getFieldStartInfo() {
    return mStartInfo;
  }

  public String getFieldStoreCode() {
    return mStoreCode;
  }

  public String getFieldStoreLocationDescriptor() {
    return mStoreLocationDescriptor;
  }

  public Long getFieldStoreNumber() {
    return mStoreNumber;
  }

  public String getFieldStudio() {
    return mStudio;
  }

  public Boolean getFieldSupportsInstantArticles() {
    return mSupportsInstantArticles;
  }

  public Long getFieldTalkingAboutCount() {
    return mTalkingAboutCount;
  }

  public Long getFieldUnreadMessageCount() {
    return mUnreadMessageCount;
  }

  public Long getFieldUnreadNotifCount() {
    return mUnreadNotifCount;
  }

  public Long getFieldUnseenMessageCount() {
    return mUnseenMessageCount;
  }

  public String getFieldUsername() {
    return mUsername;
  }

  public String getFieldVerificationStatus() {
    return mVerificationStatus;
  }

  public VoipInfo getFieldVoipInfo() {
    return mVoipInfo;
  }

  public String getFieldWebsite() {
    return mWebsite;
  }

  public Long getFieldWereHereCount() {
    return mWereHereCount;
  }

  public String getFieldWhatsappNumber() {
    return mWhatsappNumber;
  }

  public String getFieldWrittenBy() {
    return mWrittenBy;
  }



  public static class APIRequestCreateAdminNote extends APIRequest<PageAdminNote> {

    PageAdminNote lastResponse = null;
    @Override
    public PageAdminNote getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "body",
      "user_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public PageAdminNote parseResponse(String response) throws APIException {
      return PageAdminNote.parseResponse(response, getContext(), this).head();
    }

    @Override
    public PageAdminNote execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PageAdminNote execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<PageAdminNote> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PageAdminNote> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, PageAdminNote>() {
           public PageAdminNote apply(String result) {
             try {
               return APIRequestCreateAdminNote.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAdminNote(String nodeId, APIContext context) {
      super(context, nodeId, "/admin_notes", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdminNote setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdminNote setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdminNote setBody (String body) {
      this.setParam("body", body);
      return this;
    }

    public APIRequestCreateAdminNote setUserId (Long userId) {
      this.setParam("user_id", userId);
      return this;
    }
    public APIRequestCreateAdminNote setUserId (String userId) {
      this.setParam("user_id", userId);
      return this;
    }

    public APIRequestCreateAdminNote requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdminNote requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdminNote requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdminNote requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdminNote requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdminNote requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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

  public static class APIRequestDeleteAssignedUsers extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user",
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

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteAssignedUsers.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteAssignedUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/assigned_users", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteAssignedUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteAssignedUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteAssignedUsers setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestDeleteAssignedUsers setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestDeleteAssignedUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteAssignedUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAssignedUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteAssignedUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAssignedUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteAssignedUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAssignedUsers extends APIRequest<AssignedUser> {

    APINodeList<AssignedUser> lastResponse = null;
    @Override
    public APINodeList<AssignedUser> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business",
    };

    public static final String[] FIELDS = {
      "business",
      "id",
      "name",
      "user_type",
    };

    @Override
    public APINodeList<AssignedUser> parseResponse(String response) throws APIException {
      return AssignedUser.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AssignedUser> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AssignedUser> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AssignedUser>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AssignedUser>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AssignedUser>>() {
           public APINodeList<AssignedUser> apply(String result) {
             try {
               return APIRequestGetAssignedUsers.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAssignedUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/assigned_users", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAssignedUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAssignedUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAssignedUsers setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestGetAssignedUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAssignedUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAssignedUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAssignedUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAssignedUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAssignedUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAssignedUsers requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAssignedUsers requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAssignedUsers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAssignedUsers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAssignedUsers requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAssignedUsers requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAssignedUsers requestUserTypeField () {
      return this.requestUserTypeField(true);
    }
    public APIRequestGetAssignedUsers requestUserTypeField (boolean value) {
      this.requestField("user_type", value);
      return this;
    }
  }

  public static class APIRequestCreateAssignedUser extends APIRequest<Page> {

    Page lastResponse = null;
    @Override
    public Page getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "tasks",
      "user",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Page parseResponse(String response) throws APIException {
      return Page.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Page execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Page execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Page> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Page> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Page>() {
           public Page apply(String result) {
             try {
               return APIRequestCreateAssignedUser.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAssignedUser(String nodeId, APIContext context) {
      super(context, nodeId, "/assigned_users", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAssignedUser setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAssignedUser setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAssignedUser setTasks (List<Page.EnumTasks> tasks) {
      this.setParam("tasks", tasks);
      return this;
    }
    public APIRequestCreateAssignedUser setTasks (String tasks) {
      this.setParam("tasks", tasks);
      return this;
    }

    public APIRequestCreateAssignedUser setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestCreateAssignedUser setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestCreateAssignedUser requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAssignedUser requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAssignedUser requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAssignedUser requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAssignedUser requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAssignedUser requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAudioCopyrights extends APIRequest<AudioCopyright> {

    APINodeList<AudioCopyright> lastResponse = null;
    @Override
    public APINodeList<AudioCopyright> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "creation_time",
      "displayed_matches_count",
      "id",
      "in_conflict",
      "isrc",
      "match_rule",
      "ownership_countries",
      "reference_file_status",
      "ridge_monitoring_status",
      "update_time",
      "whitelisted_fb_users",
      "whitelisted_ig_users",
    };

    @Override
    public APINodeList<AudioCopyright> parseResponse(String response) throws APIException {
      return AudioCopyright.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AudioCopyright> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AudioCopyright> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AudioCopyright>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AudioCopyright>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AudioCopyright>>() {
           public APINodeList<AudioCopyright> apply(String result) {
             try {
               return APIRequestGetAudioCopyrights.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAudioCopyrights(String nodeId, APIContext context) {
      super(context, nodeId, "/audio_copyrights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAudioCopyrights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAudioCopyrights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAudioCopyrights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAudioCopyrights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAudioCopyrights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAudioCopyrights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAudioCopyrights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAudioCopyrights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAudioCopyrights requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetAudioCopyrights requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetAudioCopyrights requestDisplayedMatchesCountField () {
      return this.requestDisplayedMatchesCountField(true);
    }
    public APIRequestGetAudioCopyrights requestDisplayedMatchesCountField (boolean value) {
      this.requestField("displayed_matches_count", value);
      return this;
    }
    public APIRequestGetAudioCopyrights requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAudioCopyrights requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAudioCopyrights requestInConflictField () {
      return this.requestInConflictField(true);
    }
    public APIRequestGetAudioCopyrights requestInConflictField (boolean value) {
      this.requestField("in_conflict", value);
      return this;
    }
    public APIRequestGetAudioCopyrights requestIsrcField () {
      return this.requestIsrcField(true);
    }
    public APIRequestGetAudioCopyrights requestIsrcField (boolean value) {
      this.requestField("isrc", value);
      return this;
    }
    public APIRequestGetAudioCopyrights requestMatchRuleField () {
      return this.requestMatchRuleField(true);
    }
    public APIRequestGetAudioCopyrights requestMatchRuleField (boolean value) {
      this.requestField("match_rule", value);
      return this;
    }
    public APIRequestGetAudioCopyrights requestOwnershipCountriesField () {
      return this.requestOwnershipCountriesField(true);
    }
    public APIRequestGetAudioCopyrights requestOwnershipCountriesField (boolean value) {
      this.requestField("ownership_countries", value);
      return this;
    }
    public APIRequestGetAudioCopyrights requestReferenceFileStatusField () {
      return this.requestReferenceFileStatusField(true);
    }
    public APIRequestGetAudioCopyrights requestReferenceFileStatusField (boolean value) {
      this.requestField("reference_file_status", value);
      return this;
    }
    public APIRequestGetAudioCopyrights requestRidgeMonitoringStatusField () {
      return this.requestRidgeMonitoringStatusField(true);
    }
    public APIRequestGetAudioCopyrights requestRidgeMonitoringStatusField (boolean value) {
      this.requestField("ridge_monitoring_status", value);
      return this;
    }
    public APIRequestGetAudioCopyrights requestUpdateTimeField () {
      return this.requestUpdateTimeField(true);
    }
    public APIRequestGetAudioCopyrights requestUpdateTimeField (boolean value) {
      this.requestField("update_time", value);
      return this;
    }
    public APIRequestGetAudioCopyrights requestWhitelistedFbUsersField () {
      return this.requestWhitelistedFbUsersField(true);
    }
    public APIRequestGetAudioCopyrights requestWhitelistedFbUsersField (boolean value) {
      this.requestField("whitelisted_fb_users", value);
      return this;
    }
    public APIRequestGetAudioCopyrights requestWhitelistedIgUsersField () {
      return this.requestWhitelistedIgUsersField(true);
    }
    public APIRequestGetAudioCopyrights requestWhitelistedIgUsersField (boolean value) {
      this.requestField("whitelisted_ig_users", value);
      return this;
    }
  }

  public static class APIRequestGetAudioMediaCopyrights extends APIRequest<AudioCopyright> {

    APINodeList<AudioCopyright> lastResponse = null;
    @Override
    public APINodeList<AudioCopyright> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "creation_time",
      "displayed_matches_count",
      "id",
      "in_conflict",
      "isrc",
      "match_rule",
      "ownership_countries",
      "reference_file_status",
      "ridge_monitoring_status",
      "update_time",
      "whitelisted_fb_users",
      "whitelisted_ig_users",
    };

    @Override
    public APINodeList<AudioCopyright> parseResponse(String response) throws APIException {
      return AudioCopyright.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AudioCopyright> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AudioCopyright> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AudioCopyright>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AudioCopyright>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AudioCopyright>>() {
           public APINodeList<AudioCopyright> apply(String result) {
             try {
               return APIRequestGetAudioMediaCopyrights.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAudioMediaCopyrights(String nodeId, APIContext context) {
      super(context, nodeId, "/audio_media_copyrights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAudioMediaCopyrights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAudioMediaCopyrights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAudioMediaCopyrights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAudioMediaCopyrights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAudioMediaCopyrights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAudioMediaCopyrights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAudioMediaCopyrights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAudioMediaCopyrights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAudioMediaCopyrights requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetAudioMediaCopyrights requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetAudioMediaCopyrights requestDisplayedMatchesCountField () {
      return this.requestDisplayedMatchesCountField(true);
    }
    public APIRequestGetAudioMediaCopyrights requestDisplayedMatchesCountField (boolean value) {
      this.requestField("displayed_matches_count", value);
      return this;
    }
    public APIRequestGetAudioMediaCopyrights requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAudioMediaCopyrights requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAudioMediaCopyrights requestInConflictField () {
      return this.requestInConflictField(true);
    }
    public APIRequestGetAudioMediaCopyrights requestInConflictField (boolean value) {
      this.requestField("in_conflict", value);
      return this;
    }
    public APIRequestGetAudioMediaCopyrights requestIsrcField () {
      return this.requestIsrcField(true);
    }
    public APIRequestGetAudioMediaCopyrights requestIsrcField (boolean value) {
      this.requestField("isrc", value);
      return this;
    }
    public APIRequestGetAudioMediaCopyrights requestMatchRuleField () {
      return this.requestMatchRuleField(true);
    }
    public APIRequestGetAudioMediaCopyrights requestMatchRuleField (boolean value) {
      this.requestField("match_rule", value);
      return this;
    }
    public APIRequestGetAudioMediaCopyrights requestOwnershipCountriesField () {
      return this.requestOwnershipCountriesField(true);
    }
    public APIRequestGetAudioMediaCopyrights requestOwnershipCountriesField (boolean value) {
      this.requestField("ownership_countries", value);
      return this;
    }
    public APIRequestGetAudioMediaCopyrights requestReferenceFileStatusField () {
      return this.requestReferenceFileStatusField(true);
    }
    public APIRequestGetAudioMediaCopyrights requestReferenceFileStatusField (boolean value) {
      this.requestField("reference_file_status", value);
      return this;
    }
    public APIRequestGetAudioMediaCopyrights requestRidgeMonitoringStatusField () {
      return this.requestRidgeMonitoringStatusField(true);
    }
    public APIRequestGetAudioMediaCopyrights requestRidgeMonitoringStatusField (boolean value) {
      this.requestField("ridge_monitoring_status", value);
      return this;
    }
    public APIRequestGetAudioMediaCopyrights requestUpdateTimeField () {
      return this.requestUpdateTimeField(true);
    }
    public APIRequestGetAudioMediaCopyrights requestUpdateTimeField (boolean value) {
      this.requestField("update_time", value);
      return this;
    }
    public APIRequestGetAudioMediaCopyrights requestWhitelistedFbUsersField () {
      return this.requestWhitelistedFbUsersField(true);
    }
    public APIRequestGetAudioMediaCopyrights requestWhitelistedFbUsersField (boolean value) {
      this.requestField("whitelisted_fb_users", value);
      return this;
    }
    public APIRequestGetAudioMediaCopyrights requestWhitelistedIgUsersField () {
      return this.requestWhitelistedIgUsersField(true);
    }
    public APIRequestGetAudioMediaCopyrights requestWhitelistedIgUsersField (boolean value) {
      this.requestField("whitelisted_ig_users", value);
      return this;
    }
  }

  public static class APIRequestDeleteBlocked extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "asid",
      "uid",
      "user",
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

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteBlocked.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteBlocked(String nodeId, APIContext context) {
      super(context, nodeId, "/blocked", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteBlocked setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteBlocked setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteBlocked setAsid (Long asid) {
      this.setParam("asid", asid);
      return this;
    }
    public APIRequestDeleteBlocked setAsid (String asid) {
      this.setParam("asid", asid);
      return this;
    }

    public APIRequestDeleteBlocked setUid (Long uid) {
      this.setParam("uid", uid);
      return this;
    }
    public APIRequestDeleteBlocked setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestDeleteBlocked setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestDeleteBlocked setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestDeleteBlocked requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteBlocked requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteBlocked requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteBlocked requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteBlocked requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteBlocked requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetBlocked extends APIRequest<Profile> {

    APINodeList<Profile> lastResponse = null;
    @Override
    public APINodeList<Profile> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "uid",
      "user",
    };

    public static final String[] FIELDS = {
      "can_post",
      "id",
      "link",
      "name",
      "pic",
      "pic_crop",
      "pic_large",
      "pic_small",
      "pic_square",
      "profile_type",
      "username",
    };

    @Override
    public APINodeList<Profile> parseResponse(String response) throws APIException {
      return Profile.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Profile> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Profile> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Profile>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Profile>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Profile>>() {
           public APINodeList<Profile> apply(String result) {
             try {
               return APIRequestGetBlocked.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetBlocked(String nodeId, APIContext context) {
      super(context, nodeId, "/blocked", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBlocked setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBlocked setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBlocked setUid (Long uid) {
      this.setParam("uid", uid);
      return this;
    }
    public APIRequestGetBlocked setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestGetBlocked setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestGetBlocked setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestGetBlocked requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBlocked requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBlocked requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBlocked requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBlocked requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBlocked requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBlocked requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetBlocked requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetBlocked requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBlocked requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBlocked requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetBlocked requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetBlocked requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetBlocked requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetBlocked requestPicField () {
      return this.requestPicField(true);
    }
    public APIRequestGetBlocked requestPicField (boolean value) {
      this.requestField("pic", value);
      return this;
    }
    public APIRequestGetBlocked requestPicCropField () {
      return this.requestPicCropField(true);
    }
    public APIRequestGetBlocked requestPicCropField (boolean value) {
      this.requestField("pic_crop", value);
      return this;
    }
    public APIRequestGetBlocked requestPicLargeField () {
      return this.requestPicLargeField(true);
    }
    public APIRequestGetBlocked requestPicLargeField (boolean value) {
      this.requestField("pic_large", value);
      return this;
    }
    public APIRequestGetBlocked requestPicSmallField () {
      return this.requestPicSmallField(true);
    }
    public APIRequestGetBlocked requestPicSmallField (boolean value) {
      this.requestField("pic_small", value);
      return this;
    }
    public APIRequestGetBlocked requestPicSquareField () {
      return this.requestPicSquareField(true);
    }
    public APIRequestGetBlocked requestPicSquareField (boolean value) {
      this.requestField("pic_square", value);
      return this;
    }
    public APIRequestGetBlocked requestProfileTypeField () {
      return this.requestProfileTypeField(true);
    }
    public APIRequestGetBlocked requestProfileTypeField (boolean value) {
      this.requestField("profile_type", value);
      return this;
    }
    public APIRequestGetBlocked requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetBlocked requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestCreateBlocked extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "asid",
      "uid",
      "user",
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
               return APIRequestCreateBlocked.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateBlocked(String nodeId, APIContext context) {
      super(context, nodeId, "/blocked", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateBlocked setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateBlocked setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateBlocked setAsid (Object asid) {
      this.setParam("asid", asid);
      return this;
    }
    public APIRequestCreateBlocked setAsid (String asid) {
      this.setParam("asid", asid);
      return this;
    }

    public APIRequestCreateBlocked setUid (List<String> uid) {
      this.setParam("uid", uid);
      return this;
    }
    public APIRequestCreateBlocked setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestCreateBlocked setUser (List<String> user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestCreateBlocked setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestCreateBlocked requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateBlocked requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBlocked requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateBlocked requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBlocked requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateBlocked requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetBusinessActivities extends APIRequest<BusinessActivityLogEvent> {

    APINodeList<BusinessActivityLogEvent> lastResponse = null;
    @Override
    public APINodeList<BusinessActivityLogEvent> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business",
    };

    public static final String[] FIELDS = {
      "acted_upon_business_id",
      "acted_upon_business_name",
      "acted_upon_business_object_id",
      "acted_upon_business_object_name",
      "acted_upon_business_object_type",
      "acted_upon_user_id",
      "acted_upon_user_name",
      "acting_business_id",
      "acting_business_name",
      "acting_user_id",
      "acting_user_name",
      "event_time",
      "event_type",
      "extra_data",
      "target_business_id",
      "target_business_name",
      "target_business_object_id",
      "target_business_object_name",
      "target_business_object_type",
    };

    @Override
    public APINodeList<BusinessActivityLogEvent> parseResponse(String response) throws APIException {
      return BusinessActivityLogEvent.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessActivityLogEvent> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessActivityLogEvent> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessActivityLogEvent>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessActivityLogEvent>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessActivityLogEvent>>() {
           public APINodeList<BusinessActivityLogEvent> apply(String result) {
             try {
               return APIRequestGetBusinessActivities.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetBusinessActivities(String nodeId, APIContext context) {
      super(context, nodeId, "/business_activities", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBusinessActivities setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBusinessActivities setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBusinessActivities setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestGetBusinessActivities requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBusinessActivities requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessActivities requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBusinessActivities requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessActivities requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBusinessActivities requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBusinessActivities requestActedUponBusinessIdField () {
      return this.requestActedUponBusinessIdField(true);
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessIdField (boolean value) {
      this.requestField("acted_upon_business_id", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessNameField () {
      return this.requestActedUponBusinessNameField(true);
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessNameField (boolean value) {
      this.requestField("acted_upon_business_name", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessObjectIdField () {
      return this.requestActedUponBusinessObjectIdField(true);
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessObjectIdField (boolean value) {
      this.requestField("acted_upon_business_object_id", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessObjectNameField () {
      return this.requestActedUponBusinessObjectNameField(true);
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessObjectNameField (boolean value) {
      this.requestField("acted_upon_business_object_name", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessObjectTypeField () {
      return this.requestActedUponBusinessObjectTypeField(true);
    }
    public APIRequestGetBusinessActivities requestActedUponBusinessObjectTypeField (boolean value) {
      this.requestField("acted_upon_business_object_type", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActedUponUserIdField () {
      return this.requestActedUponUserIdField(true);
    }
    public APIRequestGetBusinessActivities requestActedUponUserIdField (boolean value) {
      this.requestField("acted_upon_user_id", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActedUponUserNameField () {
      return this.requestActedUponUserNameField(true);
    }
    public APIRequestGetBusinessActivities requestActedUponUserNameField (boolean value) {
      this.requestField("acted_upon_user_name", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActingBusinessIdField () {
      return this.requestActingBusinessIdField(true);
    }
    public APIRequestGetBusinessActivities requestActingBusinessIdField (boolean value) {
      this.requestField("acting_business_id", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActingBusinessNameField () {
      return this.requestActingBusinessNameField(true);
    }
    public APIRequestGetBusinessActivities requestActingBusinessNameField (boolean value) {
      this.requestField("acting_business_name", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActingUserIdField () {
      return this.requestActingUserIdField(true);
    }
    public APIRequestGetBusinessActivities requestActingUserIdField (boolean value) {
      this.requestField("acting_user_id", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestActingUserNameField () {
      return this.requestActingUserNameField(true);
    }
    public APIRequestGetBusinessActivities requestActingUserNameField (boolean value) {
      this.requestField("acting_user_name", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestEventTimeField () {
      return this.requestEventTimeField(true);
    }
    public APIRequestGetBusinessActivities requestEventTimeField (boolean value) {
      this.requestField("event_time", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestEventTypeField () {
      return this.requestEventTypeField(true);
    }
    public APIRequestGetBusinessActivities requestEventTypeField (boolean value) {
      this.requestField("event_type", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestExtraDataField () {
      return this.requestExtraDataField(true);
    }
    public APIRequestGetBusinessActivities requestExtraDataField (boolean value) {
      this.requestField("extra_data", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestTargetBusinessIdField () {
      return this.requestTargetBusinessIdField(true);
    }
    public APIRequestGetBusinessActivities requestTargetBusinessIdField (boolean value) {
      this.requestField("target_business_id", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestTargetBusinessNameField () {
      return this.requestTargetBusinessNameField(true);
    }
    public APIRequestGetBusinessActivities requestTargetBusinessNameField (boolean value) {
      this.requestField("target_business_name", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestTargetBusinessObjectIdField () {
      return this.requestTargetBusinessObjectIdField(true);
    }
    public APIRequestGetBusinessActivities requestTargetBusinessObjectIdField (boolean value) {
      this.requestField("target_business_object_id", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestTargetBusinessObjectNameField () {
      return this.requestTargetBusinessObjectNameField(true);
    }
    public APIRequestGetBusinessActivities requestTargetBusinessObjectNameField (boolean value) {
      this.requestField("target_business_object_name", value);
      return this;
    }
    public APIRequestGetBusinessActivities requestTargetBusinessObjectTypeField () {
      return this.requestTargetBusinessObjectTypeField(true);
    }
    public APIRequestGetBusinessActivities requestTargetBusinessObjectTypeField (boolean value) {
      this.requestField("target_business_object_type", value);
      return this;
    }
  }

  public static class APIRequestCreateCallToAction extends APIRequest<PageCallToAction> {

    PageCallToAction lastResponse = null;
    @Override
    public PageCallToAction getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "android_app_id",
      "android_deeplink",
      "android_destination_type",
      "android_package_name",
      "android_url",
      "email_address",
      "intl_number_with_plus",
      "iphone_app_id",
      "iphone_deeplink",
      "iphone_destination_type",
      "iphone_url",
      "type",
      "web_destination_type",
      "web_url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public PageCallToAction parseResponse(String response) throws APIException {
      return PageCallToAction.parseResponse(response, getContext(), this).head();
    }

    @Override
    public PageCallToAction execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PageCallToAction execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<PageCallToAction> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PageCallToAction> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, PageCallToAction>() {
           public PageCallToAction apply(String result) {
             try {
               return APIRequestCreateCallToAction.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateCallToAction(String nodeId, APIContext context) {
      super(context, nodeId, "/call_to_actions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCallToAction setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCallToAction setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCallToAction setAndroidAppId (Long androidAppId) {
      this.setParam("android_app_id", androidAppId);
      return this;
    }
    public APIRequestCreateCallToAction setAndroidAppId (String androidAppId) {
      this.setParam("android_app_id", androidAppId);
      return this;
    }

    public APIRequestCreateCallToAction setAndroidDeeplink (String androidDeeplink) {
      this.setParam("android_deeplink", androidDeeplink);
      return this;
    }

    public APIRequestCreateCallToAction setAndroidDestinationType (PageCallToAction.EnumAndroidDestinationType androidDestinationType) {
      this.setParam("android_destination_type", androidDestinationType);
      return this;
    }
    public APIRequestCreateCallToAction setAndroidDestinationType (String androidDestinationType) {
      this.setParam("android_destination_type", androidDestinationType);
      return this;
    }

    public APIRequestCreateCallToAction setAndroidPackageName (String androidPackageName) {
      this.setParam("android_package_name", androidPackageName);
      return this;
    }

    public APIRequestCreateCallToAction setAndroidUrl (String androidUrl) {
      this.setParam("android_url", androidUrl);
      return this;
    }

    public APIRequestCreateCallToAction setEmailAddress (String emailAddress) {
      this.setParam("email_address", emailAddress);
      return this;
    }

    public APIRequestCreateCallToAction setIntlNumberWithPlus (String intlNumberWithPlus) {
      this.setParam("intl_number_with_plus", intlNumberWithPlus);
      return this;
    }

    public APIRequestCreateCallToAction setIphoneAppId (Long iphoneAppId) {
      this.setParam("iphone_app_id", iphoneAppId);
      return this;
    }
    public APIRequestCreateCallToAction setIphoneAppId (String iphoneAppId) {
      this.setParam("iphone_app_id", iphoneAppId);
      return this;
    }

    public APIRequestCreateCallToAction setIphoneDeeplink (String iphoneDeeplink) {
      this.setParam("iphone_deeplink", iphoneDeeplink);
      return this;
    }

    public APIRequestCreateCallToAction setIphoneDestinationType (PageCallToAction.EnumIphoneDestinationType iphoneDestinationType) {
      this.setParam("iphone_destination_type", iphoneDestinationType);
      return this;
    }
    public APIRequestCreateCallToAction setIphoneDestinationType (String iphoneDestinationType) {
      this.setParam("iphone_destination_type", iphoneDestinationType);
      return this;
    }

    public APIRequestCreateCallToAction setIphoneUrl (String iphoneUrl) {
      this.setParam("iphone_url", iphoneUrl);
      return this;
    }

    public APIRequestCreateCallToAction setType (PageCallToAction.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestCreateCallToAction setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestCreateCallToAction setWebDestinationType (PageCallToAction.EnumWebDestinationType webDestinationType) {
      this.setParam("web_destination_type", webDestinationType);
      return this;
    }
    public APIRequestCreateCallToAction setWebDestinationType (String webDestinationType) {
      this.setParam("web_destination_type", webDestinationType);
      return this;
    }

    public APIRequestCreateCallToAction setWebUrl (String webUrl) {
      this.setParam("web_url", webUrl);
      return this;
    }

    public APIRequestCreateCallToAction requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCallToAction requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCallToAction requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCallToAction requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCallToAction requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCallToAction requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateCanvasElement extends APIRequest<CanvasBodyElement> {

    CanvasBodyElement lastResponse = null;
    @Override
    public CanvasBodyElement getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "canvas_button",
      "canvas_carousel",
      "canvas_footer",
      "canvas_header",
      "canvas_photo",
      "canvas_product_list",
      "canvas_product_set",
      "canvas_store_locator",
      "canvas_text",
      "canvas_video",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CanvasBodyElement parseResponse(String response) throws APIException {
      return CanvasBodyElement.parseResponse(response, getContext(), this).head();
    }

    @Override
    public CanvasBodyElement execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CanvasBodyElement execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<CanvasBodyElement> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CanvasBodyElement> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, CanvasBodyElement>() {
           public CanvasBodyElement apply(String result) {
             try {
               return APIRequestCreateCanvasElement.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateCanvasElement(String nodeId, APIContext context) {
      super(context, nodeId, "/canvas_elements", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCanvasElement setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCanvasElement setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCanvasElement setCanvasButton (Object canvasButton) {
      this.setParam("canvas_button", canvasButton);
      return this;
    }
    public APIRequestCreateCanvasElement setCanvasButton (String canvasButton) {
      this.setParam("canvas_button", canvasButton);
      return this;
    }

    public APIRequestCreateCanvasElement setCanvasCarousel (Object canvasCarousel) {
      this.setParam("canvas_carousel", canvasCarousel);
      return this;
    }
    public APIRequestCreateCanvasElement setCanvasCarousel (String canvasCarousel) {
      this.setParam("canvas_carousel", canvasCarousel);
      return this;
    }

    public APIRequestCreateCanvasElement setCanvasFooter (Object canvasFooter) {
      this.setParam("canvas_footer", canvasFooter);
      return this;
    }
    public APIRequestCreateCanvasElement setCanvasFooter (String canvasFooter) {
      this.setParam("canvas_footer", canvasFooter);
      return this;
    }

    public APIRequestCreateCanvasElement setCanvasHeader (Object canvasHeader) {
      this.setParam("canvas_header", canvasHeader);
      return this;
    }
    public APIRequestCreateCanvasElement setCanvasHeader (String canvasHeader) {
      this.setParam("canvas_header", canvasHeader);
      return this;
    }

    public APIRequestCreateCanvasElement setCanvasPhoto (Object canvasPhoto) {
      this.setParam("canvas_photo", canvasPhoto);
      return this;
    }
    public APIRequestCreateCanvasElement setCanvasPhoto (String canvasPhoto) {
      this.setParam("canvas_photo", canvasPhoto);
      return this;
    }

    public APIRequestCreateCanvasElement setCanvasProductList (Object canvasProductList) {
      this.setParam("canvas_product_list", canvasProductList);
      return this;
    }
    public APIRequestCreateCanvasElement setCanvasProductList (String canvasProductList) {
      this.setParam("canvas_product_list", canvasProductList);
      return this;
    }

    public APIRequestCreateCanvasElement setCanvasProductSet (Object canvasProductSet) {
      this.setParam("canvas_product_set", canvasProductSet);
      return this;
    }
    public APIRequestCreateCanvasElement setCanvasProductSet (String canvasProductSet) {
      this.setParam("canvas_product_set", canvasProductSet);
      return this;
    }

    public APIRequestCreateCanvasElement setCanvasStoreLocator (Object canvasStoreLocator) {
      this.setParam("canvas_store_locator", canvasStoreLocator);
      return this;
    }
    public APIRequestCreateCanvasElement setCanvasStoreLocator (String canvasStoreLocator) {
      this.setParam("canvas_store_locator", canvasStoreLocator);
      return this;
    }

    public APIRequestCreateCanvasElement setCanvasText (Object canvasText) {
      this.setParam("canvas_text", canvasText);
      return this;
    }
    public APIRequestCreateCanvasElement setCanvasText (String canvasText) {
      this.setParam("canvas_text", canvasText);
      return this;
    }

    public APIRequestCreateCanvasElement setCanvasVideo (Object canvasVideo) {
      this.setParam("canvas_video", canvasVideo);
      return this;
    }
    public APIRequestCreateCanvasElement setCanvasVideo (String canvasVideo) {
      this.setParam("canvas_video", canvasVideo);
      return this;
    }

    public APIRequestCreateCanvasElement requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCanvasElement requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCanvasElement requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCanvasElement requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCanvasElement requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCanvasElement requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCanvases extends APIRequest<Canvas> {

    APINodeList<Canvas> lastResponse = null;
    @Override
    public APINodeList<Canvas> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "is_published",
    };

    public static final String[] FIELDS = {
      "background_color",
      "body_elements",
      "canvas_link",
      "id",
      "is_hidden",
      "is_published",
      "last_editor",
      "name",
      "owner",
      "update_time",
    };

    @Override
    public APINodeList<Canvas> parseResponse(String response) throws APIException {
      return Canvas.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Canvas> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Canvas> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Canvas>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Canvas>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Canvas>>() {
           public APINodeList<Canvas> apply(String result) {
             try {
               return APIRequestGetCanvases.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCanvases(String nodeId, APIContext context) {
      super(context, nodeId, "/canvases", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCanvases setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCanvases setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCanvases setIsPublished (Boolean isPublished) {
      this.setParam("is_published", isPublished);
      return this;
    }
    public APIRequestGetCanvases setIsPublished (String isPublished) {
      this.setParam("is_published", isPublished);
      return this;
    }

    public APIRequestGetCanvases requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCanvases requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCanvases requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCanvases requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCanvases requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCanvases requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCanvases requestBackgroundColorField () {
      return this.requestBackgroundColorField(true);
    }
    public APIRequestGetCanvases requestBackgroundColorField (boolean value) {
      this.requestField("background_color", value);
      return this;
    }
    public APIRequestGetCanvases requestBodyElementsField () {
      return this.requestBodyElementsField(true);
    }
    public APIRequestGetCanvases requestBodyElementsField (boolean value) {
      this.requestField("body_elements", value);
      return this;
    }
    public APIRequestGetCanvases requestCanvasLinkField () {
      return this.requestCanvasLinkField(true);
    }
    public APIRequestGetCanvases requestCanvasLinkField (boolean value) {
      this.requestField("canvas_link", value);
      return this;
    }
    public APIRequestGetCanvases requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCanvases requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCanvases requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetCanvases requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetCanvases requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetCanvases requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetCanvases requestLastEditorField () {
      return this.requestLastEditorField(true);
    }
    public APIRequestGetCanvases requestLastEditorField (boolean value) {
      this.requestField("last_editor", value);
      return this;
    }
    public APIRequestGetCanvases requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetCanvases requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetCanvases requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetCanvases requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetCanvases requestUpdateTimeField () {
      return this.requestUpdateTimeField(true);
    }
    public APIRequestGetCanvases requestUpdateTimeField (boolean value) {
      this.requestField("update_time", value);
      return this;
    }
  }

  public static class APIRequestCreateCanvase extends APIRequest<Canvas> {

    Canvas lastResponse = null;
    @Override
    public Canvas getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "background_color",
      "body_element_ids",
      "is_hidden",
      "is_published",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Canvas parseResponse(String response) throws APIException {
      return Canvas.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Canvas execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Canvas execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Canvas> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Canvas> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Canvas>() {
           public Canvas apply(String result) {
             try {
               return APIRequestCreateCanvase.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateCanvase(String nodeId, APIContext context) {
      super(context, nodeId, "/canvases", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCanvase setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCanvase setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCanvase setBackgroundColor (String backgroundColor) {
      this.setParam("background_color", backgroundColor);
      return this;
    }

    public APIRequestCreateCanvase setBodyElementIds (List<String> bodyElementIds) {
      this.setParam("body_element_ids", bodyElementIds);
      return this;
    }
    public APIRequestCreateCanvase setBodyElementIds (String bodyElementIds) {
      this.setParam("body_element_ids", bodyElementIds);
      return this;
    }

    public APIRequestCreateCanvase setIsHidden (Boolean isHidden) {
      this.setParam("is_hidden", isHidden);
      return this;
    }
    public APIRequestCreateCanvase setIsHidden (String isHidden) {
      this.setParam("is_hidden", isHidden);
      return this;
    }

    public APIRequestCreateCanvase setIsPublished (Boolean isPublished) {
      this.setParam("is_published", isPublished);
      return this;
    }
    public APIRequestCreateCanvase setIsPublished (String isPublished) {
      this.setParam("is_published", isPublished);
      return this;
    }

    public APIRequestCreateCanvase setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateCanvase requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCanvase requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCanvase requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCanvase requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCanvase requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCanvase requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetChangeProposals extends APIRequest<PageChangeProposal> {

    APINodeList<PageChangeProposal> lastResponse = null;
    @Override
    public APINodeList<PageChangeProposal> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "acceptance_status",
      "category",
      "current_value",
      "id",
      "proposed_value",
      "upcoming_change_info",
    };

    @Override
    public APINodeList<PageChangeProposal> parseResponse(String response) throws APIException {
      return PageChangeProposal.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<PageChangeProposal> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<PageChangeProposal> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<PageChangeProposal>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<PageChangeProposal>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<PageChangeProposal>>() {
           public APINodeList<PageChangeProposal> apply(String result) {
             try {
               return APIRequestGetChangeProposals.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetChangeProposals(String nodeId, APIContext context) {
      super(context, nodeId, "/change_proposals", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetChangeProposals setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetChangeProposals setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetChangeProposals requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetChangeProposals requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetChangeProposals requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetChangeProposals requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetChangeProposals requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetChangeProposals requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetChangeProposals requestAcceptanceStatusField () {
      return this.requestAcceptanceStatusField(true);
    }
    public APIRequestGetChangeProposals requestAcceptanceStatusField (boolean value) {
      this.requestField("acceptance_status", value);
      return this;
    }
    public APIRequestGetChangeProposals requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetChangeProposals requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetChangeProposals requestCurrentValueField () {
      return this.requestCurrentValueField(true);
    }
    public APIRequestGetChangeProposals requestCurrentValueField (boolean value) {
      this.requestField("current_value", value);
      return this;
    }
    public APIRequestGetChangeProposals requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetChangeProposals requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetChangeProposals requestProposedValueField () {
      return this.requestProposedValueField(true);
    }
    public APIRequestGetChangeProposals requestProposedValueField (boolean value) {
      this.requestField("proposed_value", value);
      return this;
    }
    public APIRequestGetChangeProposals requestUpcomingChangeInfoField () {
      return this.requestUpcomingChangeInfoField(true);
    }
    public APIRequestGetChangeProposals requestUpcomingChangeInfoField (boolean value) {
      this.requestField("upcoming_change_info", value);
      return this;
    }
  }

  public static class APIRequestDeleteClaimedUrls extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "url",
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

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteClaimedUrls.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteClaimedUrls(String nodeId, APIContext context) {
      super(context, nodeId, "/claimed_urls", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteClaimedUrls setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteClaimedUrls setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteClaimedUrls setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestDeleteClaimedUrls requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteClaimedUrls requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteClaimedUrls requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteClaimedUrls requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteClaimedUrls requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteClaimedUrls requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateClaimedUrl extends APIRequest<URL> {

    URL lastResponse = null;
    @Override
    public URL getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public URL parseResponse(String response) throws APIException {
      return URL.parseResponse(response, getContext(), this).head();
    }

    @Override
    public URL execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public URL execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<URL> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<URL> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, URL>() {
           public URL apply(String result) {
             try {
               return APIRequestCreateClaimedUrl.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateClaimedUrl(String nodeId, APIContext context) {
      super(context, nodeId, "/claimed_urls", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateClaimedUrl setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateClaimedUrl setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateClaimedUrl setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestCreateClaimedUrl requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateClaimedUrl requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateClaimedUrl requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateClaimedUrl requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateClaimedUrl requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateClaimedUrl requestField (String field, boolean value) {
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

  public static class APIRequestCreateCopyrightManualClaim extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "action",
      "countries",
      "match_content_type",
      "matched_asset_id",
      "reference_asset_id",
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
               return APIRequestCreateCopyrightManualClaim.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateCopyrightManualClaim(String nodeId, APIContext context) {
      super(context, nodeId, "/copyright_manual_claims", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCopyrightManualClaim setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCopyrightManualClaim setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCopyrightManualClaim setAction (EnumAction action) {
      this.setParam("action", action);
      return this;
    }
    public APIRequestCreateCopyrightManualClaim setAction (String action) {
      this.setParam("action", action);
      return this;
    }

    public APIRequestCreateCopyrightManualClaim setCountries (Object countries) {
      this.setParam("countries", countries);
      return this;
    }
    public APIRequestCreateCopyrightManualClaim setCountries (String countries) {
      this.setParam("countries", countries);
      return this;
    }

    public APIRequestCreateCopyrightManualClaim setMatchContentType (EnumMatchContentType matchContentType) {
      this.setParam("match_content_type", matchContentType);
      return this;
    }
    public APIRequestCreateCopyrightManualClaim setMatchContentType (String matchContentType) {
      this.setParam("match_content_type", matchContentType);
      return this;
    }

    public APIRequestCreateCopyrightManualClaim setMatchedAssetId (String matchedAssetId) {
      this.setParam("matched_asset_id", matchedAssetId);
      return this;
    }

    public APIRequestCreateCopyrightManualClaim setReferenceAssetId (String referenceAssetId) {
      this.setParam("reference_asset_id", referenceAssetId);
      return this;
    }

    public APIRequestCreateCopyrightManualClaim requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCopyrightManualClaim requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCopyrightManualClaim requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCopyrightManualClaim requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCopyrightManualClaim requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCopyrightManualClaim requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetEvents extends APIRequest<Event> {

    APINodeList<Event> lastResponse = null;
    @Override
    public APINodeList<Event> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "event_state_filter",
      "include_canceled",
      "time_filter",
      "type",
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
               return APIRequestGetEvents.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetEvents(String nodeId, APIContext context) {
      super(context, nodeId, "/events", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetEvents setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetEvents setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetEvents setEventStateFilter (List<Event.EnumEventStateFilter> eventStateFilter) {
      this.setParam("event_state_filter", eventStateFilter);
      return this;
    }
    public APIRequestGetEvents setEventStateFilter (String eventStateFilter) {
      this.setParam("event_state_filter", eventStateFilter);
      return this;
    }

    public APIRequestGetEvents setIncludeCanceled (Boolean includeCanceled) {
      this.setParam("include_canceled", includeCanceled);
      return this;
    }
    public APIRequestGetEvents setIncludeCanceled (String includeCanceled) {
      this.setParam("include_canceled", includeCanceled);
      return this;
    }

    public APIRequestGetEvents setTimeFilter (Event.EnumTimeFilter timeFilter) {
      this.setParam("time_filter", timeFilter);
      return this;
    }
    public APIRequestGetEvents setTimeFilter (String timeFilter) {
      this.setParam("time_filter", timeFilter);
      return this;
    }

    public APIRequestGetEvents setType (Event.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestGetEvents setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestGetEvents requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetEvents requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetEvents requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetEvents requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetEvents requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetEvents requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetEvents requestAttendingCountField () {
      return this.requestAttendingCountField(true);
    }
    public APIRequestGetEvents requestAttendingCountField (boolean value) {
      this.requestField("attending_count", value);
      return this;
    }
    public APIRequestGetEvents requestCanGuestsInviteField () {
      return this.requestCanGuestsInviteField(true);
    }
    public APIRequestGetEvents requestCanGuestsInviteField (boolean value) {
      this.requestField("can_guests_invite", value);
      return this;
    }
    public APIRequestGetEvents requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetEvents requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetEvents requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetEvents requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetEvents requestDeclinedCountField () {
      return this.requestDeclinedCountField(true);
    }
    public APIRequestGetEvents requestDeclinedCountField (boolean value) {
      this.requestField("declined_count", value);
      return this;
    }
    public APIRequestGetEvents requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetEvents requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetEvents requestDiscountCodeEnabledField () {
      return this.requestDiscountCodeEnabledField(true);
    }
    public APIRequestGetEvents requestDiscountCodeEnabledField (boolean value) {
      this.requestField("discount_code_enabled", value);
      return this;
    }
    public APIRequestGetEvents requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetEvents requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetEvents requestEventTimesField () {
      return this.requestEventTimesField(true);
    }
    public APIRequestGetEvents requestEventTimesField (boolean value) {
      this.requestField("event_times", value);
      return this;
    }
    public APIRequestGetEvents requestGuestListEnabledField () {
      return this.requestGuestListEnabledField(true);
    }
    public APIRequestGetEvents requestGuestListEnabledField (boolean value) {
      this.requestField("guest_list_enabled", value);
      return this;
    }
    public APIRequestGetEvents requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetEvents requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetEvents requestInterestedCountField () {
      return this.requestInterestedCountField(true);
    }
    public APIRequestGetEvents requestInterestedCountField (boolean value) {
      this.requestField("interested_count", value);
      return this;
    }
    public APIRequestGetEvents requestIsCanceledField () {
      return this.requestIsCanceledField(true);
    }
    public APIRequestGetEvents requestIsCanceledField (boolean value) {
      this.requestField("is_canceled", value);
      return this;
    }
    public APIRequestGetEvents requestIsDraftField () {
      return this.requestIsDraftField(true);
    }
    public APIRequestGetEvents requestIsDraftField (boolean value) {
      this.requestField("is_draft", value);
      return this;
    }
    public APIRequestGetEvents requestIsPageOwnedField () {
      return this.requestIsPageOwnedField(true);
    }
    public APIRequestGetEvents requestIsPageOwnedField (boolean value) {
      this.requestField("is_page_owned", value);
      return this;
    }
    public APIRequestGetEvents requestMaybeCountField () {
      return this.requestMaybeCountField(true);
    }
    public APIRequestGetEvents requestMaybeCountField (boolean value) {
      this.requestField("maybe_count", value);
      return this;
    }
    public APIRequestGetEvents requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetEvents requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetEvents requestNoreplyCountField () {
      return this.requestNoreplyCountField(true);
    }
    public APIRequestGetEvents requestNoreplyCountField (boolean value) {
      this.requestField("noreply_count", value);
      return this;
    }
    public APIRequestGetEvents requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetEvents requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetEvents requestParentGroupField () {
      return this.requestParentGroupField(true);
    }
    public APIRequestGetEvents requestParentGroupField (boolean value) {
      this.requestField("parent_group", value);
      return this;
    }
    public APIRequestGetEvents requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGetEvents requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGetEvents requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGetEvents requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
      return this;
    }
    public APIRequestGetEvents requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetEvents requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetEvents requestTicketUriField () {
      return this.requestTicketUriField(true);
    }
    public APIRequestGetEvents requestTicketUriField (boolean value) {
      this.requestField("ticket_uri", value);
      return this;
    }
    public APIRequestGetEvents requestTicketUriStartSalesTimeField () {
      return this.requestTicketUriStartSalesTimeField(true);
    }
    public APIRequestGetEvents requestTicketUriStartSalesTimeField (boolean value) {
      this.requestField("ticket_uri_start_sales_time", value);
      return this;
    }
    public APIRequestGetEvents requestTicketingPrivacyUriField () {
      return this.requestTicketingPrivacyUriField(true);
    }
    public APIRequestGetEvents requestTicketingPrivacyUriField (boolean value) {
      this.requestField("ticketing_privacy_uri", value);
      return this;
    }
    public APIRequestGetEvents requestTicketingTermsUriField () {
      return this.requestTicketingTermsUriField(true);
    }
    public APIRequestGetEvents requestTicketingTermsUriField (boolean value) {
      this.requestField("ticketing_terms_uri", value);
      return this;
    }
    public APIRequestGetEvents requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetEvents requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetEvents requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetEvents requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetEvents requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetEvents requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestGetFeed extends APIRequest<PagePost> {

    APINodeList<PagePost> lastResponse = null;
    @Override
    public APINodeList<PagePost> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "include_hidden",
      "show_expired",
      "with",
    };

    public static final String[] FIELDS = {
      "actions",
      "admin_creator",
      "allowed_advertising_objectives",
      "application",
      "backdated_time",
      "call_to_action",
      "can_reply_privately",
      "caption",
      "child_attachments",
      "comments_mirroring_domain",
      "coordinates",
      "created_time",
      "description",
      "event",
      "expanded_height",
      "expanded_width",
      "feed_targeting",
      "from",
      "full_picture",
      "height",
      "icon",
      "id",
      "instagram_eligibility",
      "is_app_share",
      "is_expired",
      "is_hidden",
      "is_instagram_eligible",
      "is_popular",
      "is_published",
      "is_spherical",
      "link",
      "message",
      "message_tags",
      "multi_share_end_card",
      "multi_share_optimized",
      "name",
      "object_id",
      "parent_id",
      "permalink_url",
      "picture",
      "place",
      "privacy",
      "promotable_id",
      "promotion_status",
      "properties",
      "scheduled_publish_time",
      "shares",
      "source",
      "status_type",
      "story",
      "story_tags",
      "subscribed",
      "target",
      "targeting",
      "timeline_visibility",
      "type",
      "updated_time",
      "via",
      "video_buying_eligibility",
      "width",
    };

    @Override
    public APINodeList<PagePost> parseResponse(String response) throws APIException {
      return PagePost.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<PagePost> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<PagePost> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<PagePost>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<PagePost>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<PagePost>>() {
           public APINodeList<PagePost> apply(String result) {
             try {
               return APIRequestGetFeed.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetFeed(String nodeId, APIContext context) {
      super(context, nodeId, "/feed", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetFeed setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetFeed setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetFeed setIncludeHidden (Boolean includeHidden) {
      this.setParam("include_hidden", includeHidden);
      return this;
    }
    public APIRequestGetFeed setIncludeHidden (String includeHidden) {
      this.setParam("include_hidden", includeHidden);
      return this;
    }

    public APIRequestGetFeed setShowExpired (Boolean showExpired) {
      this.setParam("show_expired", showExpired);
      return this;
    }
    public APIRequestGetFeed setShowExpired (String showExpired) {
      this.setParam("show_expired", showExpired);
      return this;
    }

    public APIRequestGetFeed setWith (PagePost.EnumWith with) {
      this.setParam("with", with);
      return this;
    }
    public APIRequestGetFeed setWith (String with) {
      this.setParam("with", with);
      return this;
    }

    public APIRequestGetFeed requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetFeed requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetFeed requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetFeed requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetFeed requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetFeed requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetFeed requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGetFeed requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGetFeed requestAdminCreatorField () {
      return this.requestAdminCreatorField(true);
    }
    public APIRequestGetFeed requestAdminCreatorField (boolean value) {
      this.requestField("admin_creator", value);
      return this;
    }
    public APIRequestGetFeed requestAllowedAdvertisingObjectivesField () {
      return this.requestAllowedAdvertisingObjectivesField(true);
    }
    public APIRequestGetFeed requestAllowedAdvertisingObjectivesField (boolean value) {
      this.requestField("allowed_advertising_objectives", value);
      return this;
    }
    public APIRequestGetFeed requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGetFeed requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGetFeed requestBackdatedTimeField () {
      return this.requestBackdatedTimeField(true);
    }
    public APIRequestGetFeed requestBackdatedTimeField (boolean value) {
      this.requestField("backdated_time", value);
      return this;
    }
    public APIRequestGetFeed requestCallToActionField () {
      return this.requestCallToActionField(true);
    }
    public APIRequestGetFeed requestCallToActionField (boolean value) {
      this.requestField("call_to_action", value);
      return this;
    }
    public APIRequestGetFeed requestCanReplyPrivatelyField () {
      return this.requestCanReplyPrivatelyField(true);
    }
    public APIRequestGetFeed requestCanReplyPrivatelyField (boolean value) {
      this.requestField("can_reply_privately", value);
      return this;
    }
    public APIRequestGetFeed requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetFeed requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetFeed requestChildAttachmentsField () {
      return this.requestChildAttachmentsField(true);
    }
    public APIRequestGetFeed requestChildAttachmentsField (boolean value) {
      this.requestField("child_attachments", value);
      return this;
    }
    public APIRequestGetFeed requestCommentsMirroringDomainField () {
      return this.requestCommentsMirroringDomainField(true);
    }
    public APIRequestGetFeed requestCommentsMirroringDomainField (boolean value) {
      this.requestField("comments_mirroring_domain", value);
      return this;
    }
    public APIRequestGetFeed requestCoordinatesField () {
      return this.requestCoordinatesField(true);
    }
    public APIRequestGetFeed requestCoordinatesField (boolean value) {
      this.requestField("coordinates", value);
      return this;
    }
    public APIRequestGetFeed requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetFeed requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetFeed requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetFeed requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetFeed requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGetFeed requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGetFeed requestExpandedHeightField () {
      return this.requestExpandedHeightField(true);
    }
    public APIRequestGetFeed requestExpandedHeightField (boolean value) {
      this.requestField("expanded_height", value);
      return this;
    }
    public APIRequestGetFeed requestExpandedWidthField () {
      return this.requestExpandedWidthField(true);
    }
    public APIRequestGetFeed requestExpandedWidthField (boolean value) {
      this.requestField("expanded_width", value);
      return this;
    }
    public APIRequestGetFeed requestFeedTargetingField () {
      return this.requestFeedTargetingField(true);
    }
    public APIRequestGetFeed requestFeedTargetingField (boolean value) {
      this.requestField("feed_targeting", value);
      return this;
    }
    public APIRequestGetFeed requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetFeed requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetFeed requestFullPictureField () {
      return this.requestFullPictureField(true);
    }
    public APIRequestGetFeed requestFullPictureField (boolean value) {
      this.requestField("full_picture", value);
      return this;
    }
    public APIRequestGetFeed requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetFeed requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetFeed requestIconField () {
      return this.requestIconField(true);
    }
    public APIRequestGetFeed requestIconField (boolean value) {
      this.requestField("icon", value);
      return this;
    }
    public APIRequestGetFeed requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetFeed requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetFeed requestInstagramEligibilityField () {
      return this.requestInstagramEligibilityField(true);
    }
    public APIRequestGetFeed requestInstagramEligibilityField (boolean value) {
      this.requestField("instagram_eligibility", value);
      return this;
    }
    public APIRequestGetFeed requestIsAppShareField () {
      return this.requestIsAppShareField(true);
    }
    public APIRequestGetFeed requestIsAppShareField (boolean value) {
      this.requestField("is_app_share", value);
      return this;
    }
    public APIRequestGetFeed requestIsExpiredField () {
      return this.requestIsExpiredField(true);
    }
    public APIRequestGetFeed requestIsExpiredField (boolean value) {
      this.requestField("is_expired", value);
      return this;
    }
    public APIRequestGetFeed requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetFeed requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetFeed requestIsInstagramEligibleField () {
      return this.requestIsInstagramEligibleField(true);
    }
    public APIRequestGetFeed requestIsInstagramEligibleField (boolean value) {
      this.requestField("is_instagram_eligible", value);
      return this;
    }
    public APIRequestGetFeed requestIsPopularField () {
      return this.requestIsPopularField(true);
    }
    public APIRequestGetFeed requestIsPopularField (boolean value) {
      this.requestField("is_popular", value);
      return this;
    }
    public APIRequestGetFeed requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetFeed requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetFeed requestIsSphericalField () {
      return this.requestIsSphericalField(true);
    }
    public APIRequestGetFeed requestIsSphericalField (boolean value) {
      this.requestField("is_spherical", value);
      return this;
    }
    public APIRequestGetFeed requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetFeed requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetFeed requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGetFeed requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGetFeed requestMessageTagsField () {
      return this.requestMessageTagsField(true);
    }
    public APIRequestGetFeed requestMessageTagsField (boolean value) {
      this.requestField("message_tags", value);
      return this;
    }
    public APIRequestGetFeed requestMultiShareEndCardField () {
      return this.requestMultiShareEndCardField(true);
    }
    public APIRequestGetFeed requestMultiShareEndCardField (boolean value) {
      this.requestField("multi_share_end_card", value);
      return this;
    }
    public APIRequestGetFeed requestMultiShareOptimizedField () {
      return this.requestMultiShareOptimizedField(true);
    }
    public APIRequestGetFeed requestMultiShareOptimizedField (boolean value) {
      this.requestField("multi_share_optimized", value);
      return this;
    }
    public APIRequestGetFeed requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetFeed requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetFeed requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetFeed requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetFeed requestParentIdField () {
      return this.requestParentIdField(true);
    }
    public APIRequestGetFeed requestParentIdField (boolean value) {
      this.requestField("parent_id", value);
      return this;
    }
    public APIRequestGetFeed requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGetFeed requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGetFeed requestPictureField () {
      return this.requestPictureField(true);
    }
    public APIRequestGetFeed requestPictureField (boolean value) {
      this.requestField("picture", value);
      return this;
    }
    public APIRequestGetFeed requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGetFeed requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGetFeed requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGetFeed requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
      return this;
    }
    public APIRequestGetFeed requestPromotableIdField () {
      return this.requestPromotableIdField(true);
    }
    public APIRequestGetFeed requestPromotableIdField (boolean value) {
      this.requestField("promotable_id", value);
      return this;
    }
    public APIRequestGetFeed requestPromotionStatusField () {
      return this.requestPromotionStatusField(true);
    }
    public APIRequestGetFeed requestPromotionStatusField (boolean value) {
      this.requestField("promotion_status", value);
      return this;
    }
    public APIRequestGetFeed requestPropertiesField () {
      return this.requestPropertiesField(true);
    }
    public APIRequestGetFeed requestPropertiesField (boolean value) {
      this.requestField("properties", value);
      return this;
    }
    public APIRequestGetFeed requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGetFeed requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
      return this;
    }
    public APIRequestGetFeed requestSharesField () {
      return this.requestSharesField(true);
    }
    public APIRequestGetFeed requestSharesField (boolean value) {
      this.requestField("shares", value);
      return this;
    }
    public APIRequestGetFeed requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetFeed requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetFeed requestStatusTypeField () {
      return this.requestStatusTypeField(true);
    }
    public APIRequestGetFeed requestStatusTypeField (boolean value) {
      this.requestField("status_type", value);
      return this;
    }
    public APIRequestGetFeed requestStoryField () {
      return this.requestStoryField(true);
    }
    public APIRequestGetFeed requestStoryField (boolean value) {
      this.requestField("story", value);
      return this;
    }
    public APIRequestGetFeed requestStoryTagsField () {
      return this.requestStoryTagsField(true);
    }
    public APIRequestGetFeed requestStoryTagsField (boolean value) {
      this.requestField("story_tags", value);
      return this;
    }
    public APIRequestGetFeed requestSubscribedField () {
      return this.requestSubscribedField(true);
    }
    public APIRequestGetFeed requestSubscribedField (boolean value) {
      this.requestField("subscribed", value);
      return this;
    }
    public APIRequestGetFeed requestTargetField () {
      return this.requestTargetField(true);
    }
    public APIRequestGetFeed requestTargetField (boolean value) {
      this.requestField("target", value);
      return this;
    }
    public APIRequestGetFeed requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetFeed requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetFeed requestTimelineVisibilityField () {
      return this.requestTimelineVisibilityField(true);
    }
    public APIRequestGetFeed requestTimelineVisibilityField (boolean value) {
      this.requestField("timeline_visibility", value);
      return this;
    }
    public APIRequestGetFeed requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetFeed requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetFeed requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetFeed requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetFeed requestViaField () {
      return this.requestViaField(true);
    }
    public APIRequestGetFeed requestViaField (boolean value) {
      this.requestField("via", value);
      return this;
    }
    public APIRequestGetFeed requestVideoBuyingEligibilityField () {
      return this.requestVideoBuyingEligibilityField(true);
    }
    public APIRequestGetFeed requestVideoBuyingEligibilityField (boolean value) {
      this.requestField("video_buying_eligibility", value);
      return this;
    }
    public APIRequestGetFeed requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetFeed requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
  }

  public static class APIRequestCreateFeed extends APIRequest<PagePost> {

    PagePost lastResponse = null;
    @Override
    public PagePost getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "actions",
      "adaptive_type",
      "album_id",
      "android_key_hash",
      "animated_effect_id",
      "application_id",
      "asked_fun_fact_prompt_id",
      "asset3d_id",
      "associated_id",
      "attach_place_suggestion",
      "attached_media",
      "audience_exp",
      "backdated_time",
      "backdated_time_granularity",
      "call_to_action",
      "caption",
      "checkin_entry_point",
      "child_attachments",
      "client_mutation_id",
      "composer_entry_picker",
      "composer_entry_point",
      "composer_entry_time",
      "composer_session_events_log",
      "composer_session_id",
      "composer_source_surface",
      "composer_type",
      "connection_class",
      "content_attachment",
      "coordinates",
      "cta_link",
      "cta_type",
      "description",
      "direct_share_status",
      "enforce_link_ownership",
      "expanded_height",
      "expanded_width",
      "feed_targeting",
      "formatting",
      "fun_fact_prompt_id",
      "fun_fact_toastee_id",
      "has_nickname",
      "height",
      "holiday_card",
      "home_checkin_city_id",
      "image_crops",
      "implicit_with_tags",
      "instant_game_entry_point_data",
      "ios_bundle_id",
      "is_backout_draft",
      "is_boost_intended",
      "is_explicit_location",
      "is_explicit_share",
      "is_group_linking_post",
      "is_photo_container",
      "link",
      "location_source_id",
      "manual_privacy",
      "message",
      "multi_share_end_card",
      "multi_share_optimized",
      "name",
      "nectar_module",
      "object_attachment",
      "offer_like_post_id",
      "og_action_type_id",
      "og_hide_object_attachment",
      "og_icon_id",
      "og_object_id",
      "og_phrase",
      "og_set_profile_badge",
      "og_suggestion_mechanism",
      "page_recommendation",
      "picture",
      "place",
      "place_attachment_setting",
      "place_list",
      "place_list_data",
      "post_surfaces_blacklist",
      "posting_to_redspace",
      "privacy",
      "prompt_id",
      "prompt_tracking_string",
      "properties",
      "proxied_app_id",
      "publish_event_id",
      "published",
      "quote",
      "react_mode_metadata",
      "ref",
      "referenceable_image_ids",
      "sales_promo_id",
      "scheduled_publish_time",
      "source",
      "sponsor_id",
      "sponsor_relationship",
      "suggested_place_id",
      "tags",
      "target_surface",
      "targeting",
      "text_format_metadata",
      "text_format_preset_id",
      "text_only_place",
      "throwback_camera_roll_media",
      "thumbnail",
      "time_since_original_post",
      "title",
      "tracking_info",
      "unpublished_content_type",
      "user_selected_tags",
      "video_start_time_ms",
      "viewer_coordinates",
      "width",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public PagePost parseResponse(String response) throws APIException {
      return PagePost.parseResponse(response, getContext(), this).head();
    }

    @Override
    public PagePost execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PagePost execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<PagePost> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PagePost> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, PagePost>() {
           public PagePost apply(String result) {
             try {
               return APIRequestCreateFeed.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateFeed(String nodeId, APIContext context) {
      super(context, nodeId, "/feed", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateFeed setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateFeed setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateFeed setActions (Object actions) {
      this.setParam("actions", actions);
      return this;
    }
    public APIRequestCreateFeed setActions (String actions) {
      this.setParam("actions", actions);
      return this;
    }

    public APIRequestCreateFeed setAdaptiveType (String adaptiveType) {
      this.setParam("adaptive_type", adaptiveType);
      return this;
    }

    public APIRequestCreateFeed setAlbumId (String albumId) {
      this.setParam("album_id", albumId);
      return this;
    }

    public APIRequestCreateFeed setAndroidKeyHash (String androidKeyHash) {
      this.setParam("android_key_hash", androidKeyHash);
      return this;
    }

    public APIRequestCreateFeed setAnimatedEffectId (Long animatedEffectId) {
      this.setParam("animated_effect_id", animatedEffectId);
      return this;
    }
    public APIRequestCreateFeed setAnimatedEffectId (String animatedEffectId) {
      this.setParam("animated_effect_id", animatedEffectId);
      return this;
    }

    public APIRequestCreateFeed setApplicationId (String applicationId) {
      this.setParam("application_id", applicationId);
      return this;
    }

    public APIRequestCreateFeed setAskedFunFactPromptId (Long askedFunFactPromptId) {
      this.setParam("asked_fun_fact_prompt_id", askedFunFactPromptId);
      return this;
    }
    public APIRequestCreateFeed setAskedFunFactPromptId (String askedFunFactPromptId) {
      this.setParam("asked_fun_fact_prompt_id", askedFunFactPromptId);
      return this;
    }

    public APIRequestCreateFeed setAsset3dId (Long asset3dId) {
      this.setParam("asset3d_id", asset3dId);
      return this;
    }
    public APIRequestCreateFeed setAsset3dId (String asset3dId) {
      this.setParam("asset3d_id", asset3dId);
      return this;
    }

    public APIRequestCreateFeed setAssociatedId (String associatedId) {
      this.setParam("associated_id", associatedId);
      return this;
    }

    public APIRequestCreateFeed setAttachPlaceSuggestion (Boolean attachPlaceSuggestion) {
      this.setParam("attach_place_suggestion", attachPlaceSuggestion);
      return this;
    }
    public APIRequestCreateFeed setAttachPlaceSuggestion (String attachPlaceSuggestion) {
      this.setParam("attach_place_suggestion", attachPlaceSuggestion);
      return this;
    }

    public APIRequestCreateFeed setAttachedMedia (List<Object> attachedMedia) {
      this.setParam("attached_media", attachedMedia);
      return this;
    }
    public APIRequestCreateFeed setAttachedMedia (String attachedMedia) {
      this.setParam("attached_media", attachedMedia);
      return this;
    }

    public APIRequestCreateFeed setAudienceExp (Boolean audienceExp) {
      this.setParam("audience_exp", audienceExp);
      return this;
    }
    public APIRequestCreateFeed setAudienceExp (String audienceExp) {
      this.setParam("audience_exp", audienceExp);
      return this;
    }

    public APIRequestCreateFeed setBackdatedTime (String backdatedTime) {
      this.setParam("backdated_time", backdatedTime);
      return this;
    }

    public APIRequestCreateFeed setBackdatedTimeGranularity (PagePost.EnumBackdatedTimeGranularity backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }
    public APIRequestCreateFeed setBackdatedTimeGranularity (String backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }

    public APIRequestCreateFeed setCallToAction (Object callToAction) {
      this.setParam("call_to_action", callToAction);
      return this;
    }
    public APIRequestCreateFeed setCallToAction (String callToAction) {
      this.setParam("call_to_action", callToAction);
      return this;
    }

    public APIRequestCreateFeed setCaption (String caption) {
      this.setParam("caption", caption);
      return this;
    }

    public APIRequestCreateFeed setCheckinEntryPoint (PagePost.EnumCheckinEntryPoint checkinEntryPoint) {
      this.setParam("checkin_entry_point", checkinEntryPoint);
      return this;
    }
    public APIRequestCreateFeed setCheckinEntryPoint (String checkinEntryPoint) {
      this.setParam("checkin_entry_point", checkinEntryPoint);
      return this;
    }

    public APIRequestCreateFeed setChildAttachments (List<Object> childAttachments) {
      this.setParam("child_attachments", childAttachments);
      return this;
    }
    public APIRequestCreateFeed setChildAttachments (String childAttachments) {
      this.setParam("child_attachments", childAttachments);
      return this;
    }

    public APIRequestCreateFeed setClientMutationId (String clientMutationId) {
      this.setParam("client_mutation_id", clientMutationId);
      return this;
    }

    public APIRequestCreateFeed setComposerEntryPicker (String composerEntryPicker) {
      this.setParam("composer_entry_picker", composerEntryPicker);
      return this;
    }

    public APIRequestCreateFeed setComposerEntryPoint (String composerEntryPoint) {
      this.setParam("composer_entry_point", composerEntryPoint);
      return this;
    }

    public APIRequestCreateFeed setComposerEntryTime (Long composerEntryTime) {
      this.setParam("composer_entry_time", composerEntryTime);
      return this;
    }
    public APIRequestCreateFeed setComposerEntryTime (String composerEntryTime) {
      this.setParam("composer_entry_time", composerEntryTime);
      return this;
    }

    public APIRequestCreateFeed setComposerSessionEventsLog (String composerSessionEventsLog) {
      this.setParam("composer_session_events_log", composerSessionEventsLog);
      return this;
    }

    public APIRequestCreateFeed setComposerSessionId (String composerSessionId) {
      this.setParam("composer_session_id", composerSessionId);
      return this;
    }

    public APIRequestCreateFeed setComposerSourceSurface (String composerSourceSurface) {
      this.setParam("composer_source_surface", composerSourceSurface);
      return this;
    }

    public APIRequestCreateFeed setComposerType (String composerType) {
      this.setParam("composer_type", composerType);
      return this;
    }

    public APIRequestCreateFeed setConnectionClass (String connectionClass) {
      this.setParam("connection_class", connectionClass);
      return this;
    }

    public APIRequestCreateFeed setContentAttachment (String contentAttachment) {
      this.setParam("content_attachment", contentAttachment);
      return this;
    }

    public APIRequestCreateFeed setCoordinates (Object coordinates) {
      this.setParam("coordinates", coordinates);
      return this;
    }
    public APIRequestCreateFeed setCoordinates (String coordinates) {
      this.setParam("coordinates", coordinates);
      return this;
    }

    public APIRequestCreateFeed setCtaLink (String ctaLink) {
      this.setParam("cta_link", ctaLink);
      return this;
    }

    public APIRequestCreateFeed setCtaType (String ctaType) {
      this.setParam("cta_type", ctaType);
      return this;
    }

    public APIRequestCreateFeed setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateFeed setDirectShareStatus (Long directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }
    public APIRequestCreateFeed setDirectShareStatus (String directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }

    public APIRequestCreateFeed setEnforceLinkOwnership (Boolean enforceLinkOwnership) {
      this.setParam("enforce_link_ownership", enforceLinkOwnership);
      return this;
    }
    public APIRequestCreateFeed setEnforceLinkOwnership (String enforceLinkOwnership) {
      this.setParam("enforce_link_ownership", enforceLinkOwnership);
      return this;
    }

    public APIRequestCreateFeed setExpandedHeight (Long expandedHeight) {
      this.setParam("expanded_height", expandedHeight);
      return this;
    }
    public APIRequestCreateFeed setExpandedHeight (String expandedHeight) {
      this.setParam("expanded_height", expandedHeight);
      return this;
    }

    public APIRequestCreateFeed setExpandedWidth (Long expandedWidth) {
      this.setParam("expanded_width", expandedWidth);
      return this;
    }
    public APIRequestCreateFeed setExpandedWidth (String expandedWidth) {
      this.setParam("expanded_width", expandedWidth);
      return this;
    }

    public APIRequestCreateFeed setFeedTargeting (Object feedTargeting) {
      this.setParam("feed_targeting", feedTargeting);
      return this;
    }
    public APIRequestCreateFeed setFeedTargeting (String feedTargeting) {
      this.setParam("feed_targeting", feedTargeting);
      return this;
    }

    public APIRequestCreateFeed setFormatting (PagePost.EnumFormatting formatting) {
      this.setParam("formatting", formatting);
      return this;
    }
    public APIRequestCreateFeed setFormatting (String formatting) {
      this.setParam("formatting", formatting);
      return this;
    }

    public APIRequestCreateFeed setFunFactPromptId (String funFactPromptId) {
      this.setParam("fun_fact_prompt_id", funFactPromptId);
      return this;
    }

    public APIRequestCreateFeed setFunFactToasteeId (Long funFactToasteeId) {
      this.setParam("fun_fact_toastee_id", funFactToasteeId);
      return this;
    }
    public APIRequestCreateFeed setFunFactToasteeId (String funFactToasteeId) {
      this.setParam("fun_fact_toastee_id", funFactToasteeId);
      return this;
    }

    public APIRequestCreateFeed setHasNickname (Boolean hasNickname) {
      this.setParam("has_nickname", hasNickname);
      return this;
    }
    public APIRequestCreateFeed setHasNickname (String hasNickname) {
      this.setParam("has_nickname", hasNickname);
      return this;
    }

    public APIRequestCreateFeed setHeight (Long height) {
      this.setParam("height", height);
      return this;
    }
    public APIRequestCreateFeed setHeight (String height) {
      this.setParam("height", height);
      return this;
    }

    public APIRequestCreateFeed setHolidayCard (String holidayCard) {
      this.setParam("holiday_card", holidayCard);
      return this;
    }

    public APIRequestCreateFeed setHomeCheckinCityId (Object homeCheckinCityId) {
      this.setParam("home_checkin_city_id", homeCheckinCityId);
      return this;
    }
    public APIRequestCreateFeed setHomeCheckinCityId (String homeCheckinCityId) {
      this.setParam("home_checkin_city_id", homeCheckinCityId);
      return this;
    }

    public APIRequestCreateFeed setImageCrops (Map<String, String> imageCrops) {
      this.setParam("image_crops", imageCrops);
      return this;
    }
    public APIRequestCreateFeed setImageCrops (String imageCrops) {
      this.setParam("image_crops", imageCrops);
      return this;
    }

    public APIRequestCreateFeed setImplicitWithTags (List<Long> implicitWithTags) {
      this.setParam("implicit_with_tags", implicitWithTags);
      return this;
    }
    public APIRequestCreateFeed setImplicitWithTags (String implicitWithTags) {
      this.setParam("implicit_with_tags", implicitWithTags);
      return this;
    }

    public APIRequestCreateFeed setInstantGameEntryPointData (String instantGameEntryPointData) {
      this.setParam("instant_game_entry_point_data", instantGameEntryPointData);
      return this;
    }

    public APIRequestCreateFeed setIosBundleId (String iosBundleId) {
      this.setParam("ios_bundle_id", iosBundleId);
      return this;
    }

    public APIRequestCreateFeed setIsBackoutDraft (Boolean isBackoutDraft) {
      this.setParam("is_backout_draft", isBackoutDraft);
      return this;
    }
    public APIRequestCreateFeed setIsBackoutDraft (String isBackoutDraft) {
      this.setParam("is_backout_draft", isBackoutDraft);
      return this;
    }

    public APIRequestCreateFeed setIsBoostIntended (Boolean isBoostIntended) {
      this.setParam("is_boost_intended", isBoostIntended);
      return this;
    }
    public APIRequestCreateFeed setIsBoostIntended (String isBoostIntended) {
      this.setParam("is_boost_intended", isBoostIntended);
      return this;
    }

    public APIRequestCreateFeed setIsExplicitLocation (Boolean isExplicitLocation) {
      this.setParam("is_explicit_location", isExplicitLocation);
      return this;
    }
    public APIRequestCreateFeed setIsExplicitLocation (String isExplicitLocation) {
      this.setParam("is_explicit_location", isExplicitLocation);
      return this;
    }

    public APIRequestCreateFeed setIsExplicitShare (Boolean isExplicitShare) {
      this.setParam("is_explicit_share", isExplicitShare);
      return this;
    }
    public APIRequestCreateFeed setIsExplicitShare (String isExplicitShare) {
      this.setParam("is_explicit_share", isExplicitShare);
      return this;
    }

    public APIRequestCreateFeed setIsGroupLinkingPost (Boolean isGroupLinkingPost) {
      this.setParam("is_group_linking_post", isGroupLinkingPost);
      return this;
    }
    public APIRequestCreateFeed setIsGroupLinkingPost (String isGroupLinkingPost) {
      this.setParam("is_group_linking_post", isGroupLinkingPost);
      return this;
    }

    public APIRequestCreateFeed setIsPhotoContainer (Boolean isPhotoContainer) {
      this.setParam("is_photo_container", isPhotoContainer);
      return this;
    }
    public APIRequestCreateFeed setIsPhotoContainer (String isPhotoContainer) {
      this.setParam("is_photo_container", isPhotoContainer);
      return this;
    }

    public APIRequestCreateFeed setLink (String link) {
      this.setParam("link", link);
      return this;
    }

    public APIRequestCreateFeed setLocationSourceId (String locationSourceId) {
      this.setParam("location_source_id", locationSourceId);
      return this;
    }

    public APIRequestCreateFeed setManualPrivacy (Boolean manualPrivacy) {
      this.setParam("manual_privacy", manualPrivacy);
      return this;
    }
    public APIRequestCreateFeed setManualPrivacy (String manualPrivacy) {
      this.setParam("manual_privacy", manualPrivacy);
      return this;
    }

    public APIRequestCreateFeed setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateFeed setMultiShareEndCard (Boolean multiShareEndCard) {
      this.setParam("multi_share_end_card", multiShareEndCard);
      return this;
    }
    public APIRequestCreateFeed setMultiShareEndCard (String multiShareEndCard) {
      this.setParam("multi_share_end_card", multiShareEndCard);
      return this;
    }

    public APIRequestCreateFeed setMultiShareOptimized (Boolean multiShareOptimized) {
      this.setParam("multi_share_optimized", multiShareOptimized);
      return this;
    }
    public APIRequestCreateFeed setMultiShareOptimized (String multiShareOptimized) {
      this.setParam("multi_share_optimized", multiShareOptimized);
      return this;
    }

    public APIRequestCreateFeed setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateFeed setNectarModule (String nectarModule) {
      this.setParam("nectar_module", nectarModule);
      return this;
    }

    public APIRequestCreateFeed setObjectAttachment (String objectAttachment) {
      this.setParam("object_attachment", objectAttachment);
      return this;
    }

    public APIRequestCreateFeed setOfferLikePostId (String offerLikePostId) {
      this.setParam("offer_like_post_id", offerLikePostId);
      return this;
    }

    public APIRequestCreateFeed setOgActionTypeId (String ogActionTypeId) {
      this.setParam("og_action_type_id", ogActionTypeId);
      return this;
    }

    public APIRequestCreateFeed setOgHideObjectAttachment (Boolean ogHideObjectAttachment) {
      this.setParam("og_hide_object_attachment", ogHideObjectAttachment);
      return this;
    }
    public APIRequestCreateFeed setOgHideObjectAttachment (String ogHideObjectAttachment) {
      this.setParam("og_hide_object_attachment", ogHideObjectAttachment);
      return this;
    }

    public APIRequestCreateFeed setOgIconId (String ogIconId) {
      this.setParam("og_icon_id", ogIconId);
      return this;
    }

    public APIRequestCreateFeed setOgObjectId (String ogObjectId) {
      this.setParam("og_object_id", ogObjectId);
      return this;
    }

    public APIRequestCreateFeed setOgPhrase (String ogPhrase) {
      this.setParam("og_phrase", ogPhrase);
      return this;
    }

    public APIRequestCreateFeed setOgSetProfileBadge (Boolean ogSetProfileBadge) {
      this.setParam("og_set_profile_badge", ogSetProfileBadge);
      return this;
    }
    public APIRequestCreateFeed setOgSetProfileBadge (String ogSetProfileBadge) {
      this.setParam("og_set_profile_badge", ogSetProfileBadge);
      return this;
    }

    public APIRequestCreateFeed setOgSuggestionMechanism (String ogSuggestionMechanism) {
      this.setParam("og_suggestion_mechanism", ogSuggestionMechanism);
      return this;
    }

    public APIRequestCreateFeed setPageRecommendation (String pageRecommendation) {
      this.setParam("page_recommendation", pageRecommendation);
      return this;
    }

    public APIRequestCreateFeed setPicture (String picture) {
      this.setParam("picture", picture);
      return this;
    }

    public APIRequestCreateFeed setPlace (Object place) {
      this.setParam("place", place);
      return this;
    }
    public APIRequestCreateFeed setPlace (String place) {
      this.setParam("place", place);
      return this;
    }

    public APIRequestCreateFeed setPlaceAttachmentSetting (PagePost.EnumPlaceAttachmentSetting placeAttachmentSetting) {
      this.setParam("place_attachment_setting", placeAttachmentSetting);
      return this;
    }
    public APIRequestCreateFeed setPlaceAttachmentSetting (String placeAttachmentSetting) {
      this.setParam("place_attachment_setting", placeAttachmentSetting);
      return this;
    }

    public APIRequestCreateFeed setPlaceList (String placeList) {
      this.setParam("place_list", placeList);
      return this;
    }

    public APIRequestCreateFeed setPlaceListData (Object placeListData) {
      this.setParam("place_list_data", placeListData);
      return this;
    }
    public APIRequestCreateFeed setPlaceListData (String placeListData) {
      this.setParam("place_list_data", placeListData);
      return this;
    }

    public APIRequestCreateFeed setPostSurfacesBlacklist (List<PagePost.EnumPostSurfacesBlacklist> postSurfacesBlacklist) {
      this.setParam("post_surfaces_blacklist", postSurfacesBlacklist);
      return this;
    }
    public APIRequestCreateFeed setPostSurfacesBlacklist (String postSurfacesBlacklist) {
      this.setParam("post_surfaces_blacklist", postSurfacesBlacklist);
      return this;
    }

    public APIRequestCreateFeed setPostingToRedspace (PagePost.EnumPostingToRedspace postingToRedspace) {
      this.setParam("posting_to_redspace", postingToRedspace);
      return this;
    }
    public APIRequestCreateFeed setPostingToRedspace (String postingToRedspace) {
      this.setParam("posting_to_redspace", postingToRedspace);
      return this;
    }

    public APIRequestCreateFeed setPrivacy (Object privacy) {
      this.setParam("privacy", privacy);
      return this;
    }
    public APIRequestCreateFeed setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestCreateFeed setPromptId (String promptId) {
      this.setParam("prompt_id", promptId);
      return this;
    }

    public APIRequestCreateFeed setPromptTrackingString (String promptTrackingString) {
      this.setParam("prompt_tracking_string", promptTrackingString);
      return this;
    }

    public APIRequestCreateFeed setProperties (Object properties) {
      this.setParam("properties", properties);
      return this;
    }
    public APIRequestCreateFeed setProperties (String properties) {
      this.setParam("properties", properties);
      return this;
    }

    public APIRequestCreateFeed setProxiedAppId (String proxiedAppId) {
      this.setParam("proxied_app_id", proxiedAppId);
      return this;
    }

    public APIRequestCreateFeed setPublishEventId (Long publishEventId) {
      this.setParam("publish_event_id", publishEventId);
      return this;
    }
    public APIRequestCreateFeed setPublishEventId (String publishEventId) {
      this.setParam("publish_event_id", publishEventId);
      return this;
    }

    public APIRequestCreateFeed setPublished (Boolean published) {
      this.setParam("published", published);
      return this;
    }
    public APIRequestCreateFeed setPublished (String published) {
      this.setParam("published", published);
      return this;
    }

    public APIRequestCreateFeed setQuote (String quote) {
      this.setParam("quote", quote);
      return this;
    }

    public APIRequestCreateFeed setReactModeMetadata (String reactModeMetadata) {
      this.setParam("react_mode_metadata", reactModeMetadata);
      return this;
    }

    public APIRequestCreateFeed setRef (List<String> ref) {
      this.setParam("ref", ref);
      return this;
    }
    public APIRequestCreateFeed setRef (String ref) {
      this.setParam("ref", ref);
      return this;
    }

    public APIRequestCreateFeed setReferenceableImageIds (List<String> referenceableImageIds) {
      this.setParam("referenceable_image_ids", referenceableImageIds);
      return this;
    }
    public APIRequestCreateFeed setReferenceableImageIds (String referenceableImageIds) {
      this.setParam("referenceable_image_ids", referenceableImageIds);
      return this;
    }

    public APIRequestCreateFeed setSalesPromoId (Long salesPromoId) {
      this.setParam("sales_promo_id", salesPromoId);
      return this;
    }
    public APIRequestCreateFeed setSalesPromoId (String salesPromoId) {
      this.setParam("sales_promo_id", salesPromoId);
      return this;
    }

    public APIRequestCreateFeed setScheduledPublishTime (String scheduledPublishTime) {
      this.setParam("scheduled_publish_time", scheduledPublishTime);
      return this;
    }

    public APIRequestCreateFeed setSource (String source) {
      this.setParam("source", source);
      return this;
    }

    public APIRequestCreateFeed setSponsorId (String sponsorId) {
      this.setParam("sponsor_id", sponsorId);
      return this;
    }

    public APIRequestCreateFeed setSponsorRelationship (Long sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }
    public APIRequestCreateFeed setSponsorRelationship (String sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }

    public APIRequestCreateFeed setSuggestedPlaceId (Object suggestedPlaceId) {
      this.setParam("suggested_place_id", suggestedPlaceId);
      return this;
    }
    public APIRequestCreateFeed setSuggestedPlaceId (String suggestedPlaceId) {
      this.setParam("suggested_place_id", suggestedPlaceId);
      return this;
    }

    public APIRequestCreateFeed setTags (List<Long> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestCreateFeed setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestCreateFeed setTargetSurface (PagePost.EnumTargetSurface targetSurface) {
      this.setParam("target_surface", targetSurface);
      return this;
    }
    public APIRequestCreateFeed setTargetSurface (String targetSurface) {
      this.setParam("target_surface", targetSurface);
      return this;
    }

    public APIRequestCreateFeed setTargeting (Object targeting) {
      this.setParam("targeting", targeting);
      return this;
    }
    public APIRequestCreateFeed setTargeting (String targeting) {
      this.setParam("targeting", targeting);
      return this;
    }

    public APIRequestCreateFeed setTextFormatMetadata (String textFormatMetadata) {
      this.setParam("text_format_metadata", textFormatMetadata);
      return this;
    }

    public APIRequestCreateFeed setTextFormatPresetId (String textFormatPresetId) {
      this.setParam("text_format_preset_id", textFormatPresetId);
      return this;
    }

    public APIRequestCreateFeed setTextOnlyPlace (String textOnlyPlace) {
      this.setParam("text_only_place", textOnlyPlace);
      return this;
    }

    public APIRequestCreateFeed setThrowbackCameraRollMedia (String throwbackCameraRollMedia) {
      this.setParam("throwback_camera_roll_media", throwbackCameraRollMedia);
      return this;
    }

    public APIRequestCreateFeed setThumbnail (File thumbnail) {
      this.setParam("thumbnail", thumbnail);
      return this;
    }
    public APIRequestCreateFeed setThumbnail (String thumbnail) {
      this.setParam("thumbnail", thumbnail);
      return this;
    }

    public APIRequestCreateFeed setTimeSinceOriginalPost (Long timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }
    public APIRequestCreateFeed setTimeSinceOriginalPost (String timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }

    public APIRequestCreateFeed setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateFeed setTrackingInfo (String trackingInfo) {
      this.setParam("tracking_info", trackingInfo);
      return this;
    }

    public APIRequestCreateFeed setUnpublishedContentType (PagePost.EnumUnpublishedContentType unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }
    public APIRequestCreateFeed setUnpublishedContentType (String unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }

    public APIRequestCreateFeed setUserSelectedTags (Boolean userSelectedTags) {
      this.setParam("user_selected_tags", userSelectedTags);
      return this;
    }
    public APIRequestCreateFeed setUserSelectedTags (String userSelectedTags) {
      this.setParam("user_selected_tags", userSelectedTags);
      return this;
    }

    public APIRequestCreateFeed setVideoStartTimeMs (Long videoStartTimeMs) {
      this.setParam("video_start_time_ms", videoStartTimeMs);
      return this;
    }
    public APIRequestCreateFeed setVideoStartTimeMs (String videoStartTimeMs) {
      this.setParam("video_start_time_ms", videoStartTimeMs);
      return this;
    }

    public APIRequestCreateFeed setViewerCoordinates (Object viewerCoordinates) {
      this.setParam("viewer_coordinates", viewerCoordinates);
      return this;
    }
    public APIRequestCreateFeed setViewerCoordinates (String viewerCoordinates) {
      this.setParam("viewer_coordinates", viewerCoordinates);
      return this;
    }

    public APIRequestCreateFeed setWidth (Long width) {
      this.setParam("width", width);
      return this;
    }
    public APIRequestCreateFeed setWidth (String width) {
      this.setParam("width", width);
      return this;
    }

    public APIRequestCreateFeed requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateFeed requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateFeed requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateFeed requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateFeed requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateFeed requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetInsights extends APIRequest<InsightsResult> {

    APINodeList<InsightsResult> lastResponse = null;
    @Override
    public APINodeList<InsightsResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "date_preset",
      "metric",
      "period",
      "show_description_from_api_doc",
      "since",
      "until",
    };

    public static final String[] FIELDS = {
      "description",
      "description_from_api_doc",
      "id",
      "name",
      "period",
      "title",
      "values",
    };

    @Override
    public APINodeList<InsightsResult> parseResponse(String response) throws APIException {
      return InsightsResult.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<InsightsResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<InsightsResult> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<InsightsResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<InsightsResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<InsightsResult>>() {
           public APINodeList<InsightsResult> apply(String result) {
             try {
               return APIRequestGetInsights.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetInsights(String nodeId, APIContext context) {
      super(context, nodeId, "/insights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInsights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInsights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInsights setDatePreset (InsightsResult.EnumDatePreset datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }
    public APIRequestGetInsights setDatePreset (String datePreset) {
      this.setParam("date_preset", datePreset);
      return this;
    }

    public APIRequestGetInsights setMetric (List<Object> metric) {
      this.setParam("metric", metric);
      return this;
    }
    public APIRequestGetInsights setMetric (String metric) {
      this.setParam("metric", metric);
      return this;
    }

    public APIRequestGetInsights setPeriod (InsightsResult.EnumPeriod period) {
      this.setParam("period", period);
      return this;
    }
    public APIRequestGetInsights setPeriod (String period) {
      this.setParam("period", period);
      return this;
    }

    public APIRequestGetInsights setShowDescriptionFromApiDoc (Boolean showDescriptionFromApiDoc) {
      this.setParam("show_description_from_api_doc", showDescriptionFromApiDoc);
      return this;
    }
    public APIRequestGetInsights setShowDescriptionFromApiDoc (String showDescriptionFromApiDoc) {
      this.setParam("show_description_from_api_doc", showDescriptionFromApiDoc);
      return this;
    }

    public APIRequestGetInsights setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetInsights setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestGetInsights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetInsights requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetInsights requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetInsights requestDescriptionFromApiDocField () {
      return this.requestDescriptionFromApiDocField(true);
    }
    public APIRequestGetInsights requestDescriptionFromApiDocField (boolean value) {
      this.requestField("description_from_api_doc", value);
      return this;
    }
    public APIRequestGetInsights requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetInsights requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetInsights requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetInsights requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetInsights requestPeriodField () {
      return this.requestPeriodField(true);
    }
    public APIRequestGetInsights requestPeriodField (boolean value) {
      this.requestField("period", value);
      return this;
    }
    public APIRequestGetInsights requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetInsights requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetInsights requestValuesField () {
      return this.requestValuesField(true);
    }
    public APIRequestGetInsights requestValuesField (boolean value) {
      this.requestField("values", value);
      return this;
    }
  }

  public static class APIRequestGetInsightsExports extends APIRequest<PageInsightsAsyncExportRun> {

    APINodeList<PageInsightsAsyncExportRun> lastResponse = null;
    @Override
    public APINodeList<PageInsightsAsyncExportRun> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "data_level",
      "from_creation_date",
    };

    public static final String[] FIELDS = {
      "data_level",
      "filters",
      "format",
      "gen_report_date",
      "id",
      "report_end_date",
      "report_start_date",
      "sorters",
      "status",
    };

    @Override
    public APINodeList<PageInsightsAsyncExportRun> parseResponse(String response) throws APIException {
      return PageInsightsAsyncExportRun.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<PageInsightsAsyncExportRun> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<PageInsightsAsyncExportRun> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<PageInsightsAsyncExportRun>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<PageInsightsAsyncExportRun>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<PageInsightsAsyncExportRun>>() {
           public APINodeList<PageInsightsAsyncExportRun> apply(String result) {
             try {
               return APIRequestGetInsightsExports.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetInsightsExports(String nodeId, APIContext context) {
      super(context, nodeId, "/insights_exports", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInsightsExports setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInsightsExports setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInsightsExports setDataLevel (List<String> dataLevel) {
      this.setParam("data_level", dataLevel);
      return this;
    }
    public APIRequestGetInsightsExports setDataLevel (String dataLevel) {
      this.setParam("data_level", dataLevel);
      return this;
    }

    public APIRequestGetInsightsExports setFromCreationDate (String fromCreationDate) {
      this.setParam("from_creation_date", fromCreationDate);
      return this;
    }

    public APIRequestGetInsightsExports requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsightsExports requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsightsExports requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInsightsExports requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsightsExports requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInsightsExports requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetInsightsExports requestDataLevelField () {
      return this.requestDataLevelField(true);
    }
    public APIRequestGetInsightsExports requestDataLevelField (boolean value) {
      this.requestField("data_level", value);
      return this;
    }
    public APIRequestGetInsightsExports requestFiltersField () {
      return this.requestFiltersField(true);
    }
    public APIRequestGetInsightsExports requestFiltersField (boolean value) {
      this.requestField("filters", value);
      return this;
    }
    public APIRequestGetInsightsExports requestFormatField () {
      return this.requestFormatField(true);
    }
    public APIRequestGetInsightsExports requestFormatField (boolean value) {
      this.requestField("format", value);
      return this;
    }
    public APIRequestGetInsightsExports requestGenReportDateField () {
      return this.requestGenReportDateField(true);
    }
    public APIRequestGetInsightsExports requestGenReportDateField (boolean value) {
      this.requestField("gen_report_date", value);
      return this;
    }
    public APIRequestGetInsightsExports requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetInsightsExports requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetInsightsExports requestReportEndDateField () {
      return this.requestReportEndDateField(true);
    }
    public APIRequestGetInsightsExports requestReportEndDateField (boolean value) {
      this.requestField("report_end_date", value);
      return this;
    }
    public APIRequestGetInsightsExports requestReportStartDateField () {
      return this.requestReportStartDateField(true);
    }
    public APIRequestGetInsightsExports requestReportStartDateField (boolean value) {
      this.requestField("report_start_date", value);
      return this;
    }
    public APIRequestGetInsightsExports requestSortersField () {
      return this.requestSortersField(true);
    }
    public APIRequestGetInsightsExports requestSortersField (boolean value) {
      this.requestField("sorters", value);
      return this;
    }
    public APIRequestGetInsightsExports requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetInsightsExports requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static class APIRequestGetInstantArticles extends APIRequest<InstantArticle> {

    APINodeList<InstantArticle> lastResponse = null;
    @Override
    public APINodeList<InstantArticle> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "development_mode",
    };

    public static final String[] FIELDS = {
      "canonical_url",
      "development_mode",
      "html_source",
      "id",
      "most_recent_import_status",
      "photos",
      "publish_status",
      "published",
      "videos",
    };

    @Override
    public APINodeList<InstantArticle> parseResponse(String response) throws APIException {
      return InstantArticle.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<InstantArticle> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<InstantArticle> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<InstantArticle>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<InstantArticle>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<InstantArticle>>() {
           public APINodeList<InstantArticle> apply(String result) {
             try {
               return APIRequestGetInstantArticles.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetInstantArticles(String nodeId, APIContext context) {
      super(context, nodeId, "/instant_articles", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInstantArticles setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInstantArticles setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInstantArticles setDevelopmentMode (Boolean developmentMode) {
      this.setParam("development_mode", developmentMode);
      return this;
    }
    public APIRequestGetInstantArticles setDevelopmentMode (String developmentMode) {
      this.setParam("development_mode", developmentMode);
      return this;
    }

    public APIRequestGetInstantArticles requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInstantArticles requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInstantArticles requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInstantArticles requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInstantArticles requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInstantArticles requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetInstantArticles requestCanonicalUrlField () {
      return this.requestCanonicalUrlField(true);
    }
    public APIRequestGetInstantArticles requestCanonicalUrlField (boolean value) {
      this.requestField("canonical_url", value);
      return this;
    }
    public APIRequestGetInstantArticles requestDevelopmentModeField () {
      return this.requestDevelopmentModeField(true);
    }
    public APIRequestGetInstantArticles requestDevelopmentModeField (boolean value) {
      this.requestField("development_mode", value);
      return this;
    }
    public APIRequestGetInstantArticles requestHtmlSourceField () {
      return this.requestHtmlSourceField(true);
    }
    public APIRequestGetInstantArticles requestHtmlSourceField (boolean value) {
      this.requestField("html_source", value);
      return this;
    }
    public APIRequestGetInstantArticles requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetInstantArticles requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetInstantArticles requestMostRecentImportStatusField () {
      return this.requestMostRecentImportStatusField(true);
    }
    public APIRequestGetInstantArticles requestMostRecentImportStatusField (boolean value) {
      this.requestField("most_recent_import_status", value);
      return this;
    }
    public APIRequestGetInstantArticles requestPhotosField () {
      return this.requestPhotosField(true);
    }
    public APIRequestGetInstantArticles requestPhotosField (boolean value) {
      this.requestField("photos", value);
      return this;
    }
    public APIRequestGetInstantArticles requestPublishStatusField () {
      return this.requestPublishStatusField(true);
    }
    public APIRequestGetInstantArticles requestPublishStatusField (boolean value) {
      this.requestField("publish_status", value);
      return this;
    }
    public APIRequestGetInstantArticles requestPublishedField () {
      return this.requestPublishedField(true);
    }
    public APIRequestGetInstantArticles requestPublishedField (boolean value) {
      this.requestField("published", value);
      return this;
    }
    public APIRequestGetInstantArticles requestVideosField () {
      return this.requestVideosField(true);
    }
    public APIRequestGetInstantArticles requestVideosField (boolean value) {
      this.requestField("videos", value);
      return this;
    }
  }

  public static class APIRequestCreateInstantArticle extends APIRequest<InstantArticle> {

    InstantArticle lastResponse = null;
    @Override
    public InstantArticle getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "development_mode",
      "html_source",
      "published",
      "take_live",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public InstantArticle parseResponse(String response) throws APIException {
      return InstantArticle.parseResponse(response, getContext(), this).head();
    }

    @Override
    public InstantArticle execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public InstantArticle execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<InstantArticle> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<InstantArticle> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, InstantArticle>() {
           public InstantArticle apply(String result) {
             try {
               return APIRequestCreateInstantArticle.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateInstantArticle(String nodeId, APIContext context) {
      super(context, nodeId, "/instant_articles", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateInstantArticle setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateInstantArticle setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateInstantArticle setDevelopmentMode (Boolean developmentMode) {
      this.setParam("development_mode", developmentMode);
      return this;
    }
    public APIRequestCreateInstantArticle setDevelopmentMode (String developmentMode) {
      this.setParam("development_mode", developmentMode);
      return this;
    }

    public APIRequestCreateInstantArticle setHtmlSource (String htmlSource) {
      this.setParam("html_source", htmlSource);
      return this;
    }

    public APIRequestCreateInstantArticle setPublished (Boolean published) {
      this.setParam("published", published);
      return this;
    }
    public APIRequestCreateInstantArticle setPublished (String published) {
      this.setParam("published", published);
      return this;
    }

    public APIRequestCreateInstantArticle setTakeLive (Boolean takeLive) {
      this.setParam("take_live", takeLive);
      return this;
    }
    public APIRequestCreateInstantArticle setTakeLive (String takeLive) {
      this.setParam("take_live", takeLive);
      return this;
    }

    public APIRequestCreateInstantArticle requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateInstantArticle requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateInstantArticle requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateInstantArticle requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateInstantArticle requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateInstantArticle requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetInstantArticlesInsights extends APIRequest<InstantArticleInsightsQueryResult> {

    APINodeList<InstantArticleInsightsQueryResult> lastResponse = null;
    @Override
    public APINodeList<InstantArticleInsightsQueryResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "breakdown",
      "metric",
      "period",
      "since",
      "until",
    };

    public static final String[] FIELDS = {
      "breakdowns",
      "name",
      "time",
      "value",
    };

    @Override
    public APINodeList<InstantArticleInsightsQueryResult> parseResponse(String response) throws APIException {
      return InstantArticleInsightsQueryResult.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<InstantArticleInsightsQueryResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<InstantArticleInsightsQueryResult> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<InstantArticleInsightsQueryResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<InstantArticleInsightsQueryResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<InstantArticleInsightsQueryResult>>() {
           public APINodeList<InstantArticleInsightsQueryResult> apply(String result) {
             try {
               return APIRequestGetInstantArticlesInsights.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetInstantArticlesInsights(String nodeId, APIContext context) {
      super(context, nodeId, "/instant_articles_insights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInstantArticlesInsights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInstantArticlesInsights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInstantArticlesInsights setBreakdown (InstantArticleInsightsQueryResult.EnumBreakdown breakdown) {
      this.setParam("breakdown", breakdown);
      return this;
    }
    public APIRequestGetInstantArticlesInsights setBreakdown (String breakdown) {
      this.setParam("breakdown", breakdown);
      return this;
    }

    public APIRequestGetInstantArticlesInsights setMetric (List<Object> metric) {
      this.setParam("metric", metric);
      return this;
    }
    public APIRequestGetInstantArticlesInsights setMetric (String metric) {
      this.setParam("metric", metric);
      return this;
    }

    public APIRequestGetInstantArticlesInsights setPeriod (InstantArticleInsightsQueryResult.EnumPeriod period) {
      this.setParam("period", period);
      return this;
    }
    public APIRequestGetInstantArticlesInsights setPeriod (String period) {
      this.setParam("period", period);
      return this;
    }

    public APIRequestGetInstantArticlesInsights setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetInstantArticlesInsights setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestGetInstantArticlesInsights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInstantArticlesInsights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInstantArticlesInsights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInstantArticlesInsights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInstantArticlesInsights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInstantArticlesInsights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetInstantArticlesInsights requestBreakdownsField () {
      return this.requestBreakdownsField(true);
    }
    public APIRequestGetInstantArticlesInsights requestBreakdownsField (boolean value) {
      this.requestField("breakdowns", value);
      return this;
    }
    public APIRequestGetInstantArticlesInsights requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetInstantArticlesInsights requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetInstantArticlesInsights requestTimeField () {
      return this.requestTimeField(true);
    }
    public APIRequestGetInstantArticlesInsights requestTimeField (boolean value) {
      this.requestField("time", value);
      return this;
    }
    public APIRequestGetInstantArticlesInsights requestValueField () {
      return this.requestValueField(true);
    }
    public APIRequestGetInstantArticlesInsights requestValueField (boolean value) {
      this.requestField("value", value);
      return this;
    }
  }

  public static class APIRequestCreateInstantArticlesPublish extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "canonical_url",
      "publish_status",
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
               return APIRequestCreateInstantArticlesPublish.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateInstantArticlesPublish(String nodeId, APIContext context) {
      super(context, nodeId, "/instant_articles_publish", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateInstantArticlesPublish setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateInstantArticlesPublish setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateInstantArticlesPublish setCanonicalUrl (String canonicalUrl) {
      this.setParam("canonical_url", canonicalUrl);
      return this;
    }

    public APIRequestCreateInstantArticlesPublish setPublishStatus (EnumPublishStatus publishStatus) {
      this.setParam("publish_status", publishStatus);
      return this;
    }
    public APIRequestCreateInstantArticlesPublish setPublishStatus (String publishStatus) {
      this.setParam("publish_status", publishStatus);
      return this;
    }

    public APIRequestCreateInstantArticlesPublish requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateInstantArticlesPublish requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateInstantArticlesPublish requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateInstantArticlesPublish requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateInstantArticlesPublish requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateInstantArticlesPublish requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateLabel extends APIRequest<PageLabel> {

    PageLabel lastResponse = null;
    @Override
    public PageLabel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public PageLabel parseResponse(String response) throws APIException {
      return PageLabel.parseResponse(response, getContext(), this).head();
    }

    @Override
    public PageLabel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PageLabel execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<PageLabel> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PageLabel> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, PageLabel>() {
           public PageLabel apply(String result) {
             try {
               return APIRequestCreateLabel.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateLabel(String nodeId, APIContext context) {
      super(context, nodeId, "/labels", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateLabel setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateLabel setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateLabel setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateLabel requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateLabel requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLabel requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateLabel requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLabel requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateLabel requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateLeadGenConditionalQuestionsGroup extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "conditional_questions_group_csv",
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
               return APIRequestCreateLeadGenConditionalQuestionsGroup.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateLeadGenConditionalQuestionsGroup(String nodeId, APIContext context) {
      super(context, nodeId, "/leadgen_conditional_questions_group", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateLeadGenConditionalQuestionsGroup setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateLeadGenConditionalQuestionsGroup setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateLeadGenConditionalQuestionsGroup setConditionalQuestionsGroupCsv (File conditionalQuestionsGroupCsv) {
      this.setParam("conditional_questions_group_csv", conditionalQuestionsGroupCsv);
      return this;
    }
    public APIRequestCreateLeadGenConditionalQuestionsGroup setConditionalQuestionsGroupCsv (String conditionalQuestionsGroupCsv) {
      this.setParam("conditional_questions_group_csv", conditionalQuestionsGroupCsv);
      return this;
    }

    public APIRequestCreateLeadGenConditionalQuestionsGroup requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateLeadGenConditionalQuestionsGroup requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeadGenConditionalQuestionsGroup requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateLeadGenConditionalQuestionsGroup requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeadGenConditionalQuestionsGroup requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateLeadGenConditionalQuestionsGroup requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateLeadGenContextCard extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "button_text",
      "content",
      "cover_photo",
      "cover_photo_id",
      "status",
      "style",
      "title",
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
               return APIRequestCreateLeadGenContextCard.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateLeadGenContextCard(String nodeId, APIContext context) {
      super(context, nodeId, "/leadgen_context_cards", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateLeadGenContextCard setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateLeadGenContextCard setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateLeadGenContextCard setButtonText (String buttonText) {
      this.setParam("button_text", buttonText);
      return this;
    }

    public APIRequestCreateLeadGenContextCard setContent (List<String> content) {
      this.setParam("content", content);
      return this;
    }
    public APIRequestCreateLeadGenContextCard setContent (String content) {
      this.setParam("content", content);
      return this;
    }

    public APIRequestCreateLeadGenContextCard setCoverPhoto (File coverPhoto) {
      this.setParam("cover_photo", coverPhoto);
      return this;
    }
    public APIRequestCreateLeadGenContextCard setCoverPhoto (String coverPhoto) {
      this.setParam("cover_photo", coverPhoto);
      return this;
    }

    public APIRequestCreateLeadGenContextCard setCoverPhotoId (String coverPhotoId) {
      this.setParam("cover_photo_id", coverPhotoId);
      return this;
    }

    public APIRequestCreateLeadGenContextCard setStatus (EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestCreateLeadGenContextCard setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestCreateLeadGenContextCard setStyle (EnumStyle style) {
      this.setParam("style", style);
      return this;
    }
    public APIRequestCreateLeadGenContextCard setStyle (String style) {
      this.setParam("style", style);
      return this;
    }

    public APIRequestCreateLeadGenContextCard setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateLeadGenContextCard requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateLeadGenContextCard requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeadGenContextCard requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateLeadGenContextCard requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeadGenContextCard requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateLeadGenContextCard requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateLeadGenDraftForm extends APIRequest<Page> {

    Page lastResponse = null;
    @Override
    public Page getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "allow_organic_lead_retrieval",
      "block_display_for_non_targeted_viewer",
      "context_card",
      "context_card_id",
      "custom_disclaimer",
      "follow_up_action_url",
      "is_optimized_for_quality",
      "legal_content_id",
      "locale",
      "name",
      "privacy_policy",
      "question_page_custom_headline",
      "questions",
      "thank_you_page",
      "tracking_parameters",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Page parseResponse(String response) throws APIException {
      return Page.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Page execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Page execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Page> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Page> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Page>() {
           public Page apply(String result) {
             try {
               return APIRequestCreateLeadGenDraftForm.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateLeadGenDraftForm(String nodeId, APIContext context) {
      super(context, nodeId, "/leadgen_draft_forms", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateLeadGenDraftForm setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateLeadGenDraftForm setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateLeadGenDraftForm setAllowOrganicLeadRetrieval (Boolean allowOrganicLeadRetrieval) {
      this.setParam("allow_organic_lead_retrieval", allowOrganicLeadRetrieval);
      return this;
    }
    public APIRequestCreateLeadGenDraftForm setAllowOrganicLeadRetrieval (String allowOrganicLeadRetrieval) {
      this.setParam("allow_organic_lead_retrieval", allowOrganicLeadRetrieval);
      return this;
    }

    public APIRequestCreateLeadGenDraftForm setBlockDisplayForNonTargetedViewer (Boolean blockDisplayForNonTargetedViewer) {
      this.setParam("block_display_for_non_targeted_viewer", blockDisplayForNonTargetedViewer);
      return this;
    }
    public APIRequestCreateLeadGenDraftForm setBlockDisplayForNonTargetedViewer (String blockDisplayForNonTargetedViewer) {
      this.setParam("block_display_for_non_targeted_viewer", blockDisplayForNonTargetedViewer);
      return this;
    }

    public APIRequestCreateLeadGenDraftForm setContextCard (Object contextCard) {
      this.setParam("context_card", contextCard);
      return this;
    }
    public APIRequestCreateLeadGenDraftForm setContextCard (String contextCard) {
      this.setParam("context_card", contextCard);
      return this;
    }

    public APIRequestCreateLeadGenDraftForm setContextCardId (String contextCardId) {
      this.setParam("context_card_id", contextCardId);
      return this;
    }

    public APIRequestCreateLeadGenDraftForm setCustomDisclaimer (Object customDisclaimer) {
      this.setParam("custom_disclaimer", customDisclaimer);
      return this;
    }
    public APIRequestCreateLeadGenDraftForm setCustomDisclaimer (String customDisclaimer) {
      this.setParam("custom_disclaimer", customDisclaimer);
      return this;
    }

    public APIRequestCreateLeadGenDraftForm setFollowUpActionUrl (String followUpActionUrl) {
      this.setParam("follow_up_action_url", followUpActionUrl);
      return this;
    }

    public APIRequestCreateLeadGenDraftForm setIsOptimizedForQuality (Boolean isOptimizedForQuality) {
      this.setParam("is_optimized_for_quality", isOptimizedForQuality);
      return this;
    }
    public APIRequestCreateLeadGenDraftForm setIsOptimizedForQuality (String isOptimizedForQuality) {
      this.setParam("is_optimized_for_quality", isOptimizedForQuality);
      return this;
    }

    public APIRequestCreateLeadGenDraftForm setLegalContentId (String legalContentId) {
      this.setParam("legal_content_id", legalContentId);
      return this;
    }

    public APIRequestCreateLeadGenDraftForm setLocale (Page.EnumLocale locale) {
      this.setParam("locale", locale);
      return this;
    }
    public APIRequestCreateLeadGenDraftForm setLocale (String locale) {
      this.setParam("locale", locale);
      return this;
    }

    public APIRequestCreateLeadGenDraftForm setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateLeadGenDraftForm setPrivacyPolicy (Map<String, String> privacyPolicy) {
      this.setParam("privacy_policy", privacyPolicy);
      return this;
    }
    public APIRequestCreateLeadGenDraftForm setPrivacyPolicy (String privacyPolicy) {
      this.setParam("privacy_policy", privacyPolicy);
      return this;
    }

    public APIRequestCreateLeadGenDraftForm setQuestionPageCustomHeadline (String questionPageCustomHeadline) {
      this.setParam("question_page_custom_headline", questionPageCustomHeadline);
      return this;
    }

    public APIRequestCreateLeadGenDraftForm setQuestions (List<Object> questions) {
      this.setParam("questions", questions);
      return this;
    }
    public APIRequestCreateLeadGenDraftForm setQuestions (String questions) {
      this.setParam("questions", questions);
      return this;
    }

    public APIRequestCreateLeadGenDraftForm setThankYouPage (Map<String, String> thankYouPage) {
      this.setParam("thank_you_page", thankYouPage);
      return this;
    }
    public APIRequestCreateLeadGenDraftForm setThankYouPage (String thankYouPage) {
      this.setParam("thank_you_page", thankYouPage);
      return this;
    }

    public APIRequestCreateLeadGenDraftForm setTrackingParameters (Object trackingParameters) {
      this.setParam("tracking_parameters", trackingParameters);
      return this;
    }
    public APIRequestCreateLeadGenDraftForm setTrackingParameters (String trackingParameters) {
      this.setParam("tracking_parameters", trackingParameters);
      return this;
    }

    public APIRequestCreateLeadGenDraftForm requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateLeadGenDraftForm requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeadGenDraftForm requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateLeadGenDraftForm requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeadGenDraftForm requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateLeadGenDraftForm requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateLeadGenForm extends APIRequest<Page> {

    Page lastResponse = null;
    @Override
    public Page getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "allow_organic_lead_retrieval",
      "block_display_for_non_targeted_viewer",
      "context_card",
      "context_card_id",
      "cover_photo",
      "custom_disclaimer",
      "follow_up_action_url",
      "is_optimized_for_quality",
      "legal_content_id",
      "locale",
      "name",
      "privacy_policy",
      "question_page_custom_headline",
      "questions",
      "thank_you_page",
      "thank_you_page_id",
      "tracking_parameters",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Page parseResponse(String response) throws APIException {
      return Page.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Page execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Page execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Page> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Page> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Page>() {
           public Page apply(String result) {
             try {
               return APIRequestCreateLeadGenForm.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateLeadGenForm(String nodeId, APIContext context) {
      super(context, nodeId, "/leadgen_forms", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateLeadGenForm setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateLeadGenForm setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateLeadGenForm setAllowOrganicLeadRetrieval (Boolean allowOrganicLeadRetrieval) {
      this.setParam("allow_organic_lead_retrieval", allowOrganicLeadRetrieval);
      return this;
    }
    public APIRequestCreateLeadGenForm setAllowOrganicLeadRetrieval (String allowOrganicLeadRetrieval) {
      this.setParam("allow_organic_lead_retrieval", allowOrganicLeadRetrieval);
      return this;
    }

    public APIRequestCreateLeadGenForm setBlockDisplayForNonTargetedViewer (Boolean blockDisplayForNonTargetedViewer) {
      this.setParam("block_display_for_non_targeted_viewer", blockDisplayForNonTargetedViewer);
      return this;
    }
    public APIRequestCreateLeadGenForm setBlockDisplayForNonTargetedViewer (String blockDisplayForNonTargetedViewer) {
      this.setParam("block_display_for_non_targeted_viewer", blockDisplayForNonTargetedViewer);
      return this;
    }

    public APIRequestCreateLeadGenForm setContextCard (Object contextCard) {
      this.setParam("context_card", contextCard);
      return this;
    }
    public APIRequestCreateLeadGenForm setContextCard (String contextCard) {
      this.setParam("context_card", contextCard);
      return this;
    }

    public APIRequestCreateLeadGenForm setContextCardId (Object contextCardId) {
      this.setParam("context_card_id", contextCardId);
      return this;
    }
    public APIRequestCreateLeadGenForm setContextCardId (String contextCardId) {
      this.setParam("context_card_id", contextCardId);
      return this;
    }

    public APIRequestCreateLeadGenForm setCoverPhoto (File coverPhoto) {
      this.setParam("cover_photo", coverPhoto);
      return this;
    }
    public APIRequestCreateLeadGenForm setCoverPhoto (String coverPhoto) {
      this.setParam("cover_photo", coverPhoto);
      return this;
    }

    public APIRequestCreateLeadGenForm setCustomDisclaimer (Object customDisclaimer) {
      this.setParam("custom_disclaimer", customDisclaimer);
      return this;
    }
    public APIRequestCreateLeadGenForm setCustomDisclaimer (String customDisclaimer) {
      this.setParam("custom_disclaimer", customDisclaimer);
      return this;
    }

    public APIRequestCreateLeadGenForm setFollowUpActionUrl (Object followUpActionUrl) {
      this.setParam("follow_up_action_url", followUpActionUrl);
      return this;
    }
    public APIRequestCreateLeadGenForm setFollowUpActionUrl (String followUpActionUrl) {
      this.setParam("follow_up_action_url", followUpActionUrl);
      return this;
    }

    public APIRequestCreateLeadGenForm setIsOptimizedForQuality (Boolean isOptimizedForQuality) {
      this.setParam("is_optimized_for_quality", isOptimizedForQuality);
      return this;
    }
    public APIRequestCreateLeadGenForm setIsOptimizedForQuality (String isOptimizedForQuality) {
      this.setParam("is_optimized_for_quality", isOptimizedForQuality);
      return this;
    }

    public APIRequestCreateLeadGenForm setLegalContentId (Object legalContentId) {
      this.setParam("legal_content_id", legalContentId);
      return this;
    }
    public APIRequestCreateLeadGenForm setLegalContentId (String legalContentId) {
      this.setParam("legal_content_id", legalContentId);
      return this;
    }

    public APIRequestCreateLeadGenForm setLocale (Page.EnumLocale locale) {
      this.setParam("locale", locale);
      return this;
    }
    public APIRequestCreateLeadGenForm setLocale (String locale) {
      this.setParam("locale", locale);
      return this;
    }

    public APIRequestCreateLeadGenForm setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateLeadGenForm setPrivacyPolicy (Object privacyPolicy) {
      this.setParam("privacy_policy", privacyPolicy);
      return this;
    }
    public APIRequestCreateLeadGenForm setPrivacyPolicy (String privacyPolicy) {
      this.setParam("privacy_policy", privacyPolicy);
      return this;
    }

    public APIRequestCreateLeadGenForm setQuestionPageCustomHeadline (String questionPageCustomHeadline) {
      this.setParam("question_page_custom_headline", questionPageCustomHeadline);
      return this;
    }

    public APIRequestCreateLeadGenForm setQuestions (List<Object> questions) {
      this.setParam("questions", questions);
      return this;
    }
    public APIRequestCreateLeadGenForm setQuestions (String questions) {
      this.setParam("questions", questions);
      return this;
    }

    public APIRequestCreateLeadGenForm setThankYouPage (Object thankYouPage) {
      this.setParam("thank_you_page", thankYouPage);
      return this;
    }
    public APIRequestCreateLeadGenForm setThankYouPage (String thankYouPage) {
      this.setParam("thank_you_page", thankYouPage);
      return this;
    }

    public APIRequestCreateLeadGenForm setThankYouPageId (Object thankYouPageId) {
      this.setParam("thank_you_page_id", thankYouPageId);
      return this;
    }
    public APIRequestCreateLeadGenForm setThankYouPageId (String thankYouPageId) {
      this.setParam("thank_you_page_id", thankYouPageId);
      return this;
    }

    public APIRequestCreateLeadGenForm setTrackingParameters (Object trackingParameters) {
      this.setParam("tracking_parameters", trackingParameters);
      return this;
    }
    public APIRequestCreateLeadGenForm setTrackingParameters (String trackingParameters) {
      this.setParam("tracking_parameters", trackingParameters);
      return this;
    }

    public APIRequestCreateLeadGenForm requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateLeadGenForm requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeadGenForm requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateLeadGenForm requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeadGenForm requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateLeadGenForm requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateLeadGenLegalContent extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "custom_disclaimer",
      "privacy_policy",
      "status",
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
               return APIRequestCreateLeadGenLegalContent.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateLeadGenLegalContent(String nodeId, APIContext context) {
      super(context, nodeId, "/leadgen_legal_content", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateLeadGenLegalContent setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateLeadGenLegalContent setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateLeadGenLegalContent setCustomDisclaimer (Object customDisclaimer) {
      this.setParam("custom_disclaimer", customDisclaimer);
      return this;
    }
    public APIRequestCreateLeadGenLegalContent setCustomDisclaimer (String customDisclaimer) {
      this.setParam("custom_disclaimer", customDisclaimer);
      return this;
    }

    public APIRequestCreateLeadGenLegalContent setPrivacyPolicy (Object privacyPolicy) {
      this.setParam("privacy_policy", privacyPolicy);
      return this;
    }
    public APIRequestCreateLeadGenLegalContent setPrivacyPolicy (String privacyPolicy) {
      this.setParam("privacy_policy", privacyPolicy);
      return this;
    }

    public APIRequestCreateLeadGenLegalContent setStatus (EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestCreateLeadGenLegalContent setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestCreateLeadGenLegalContent requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateLeadGenLegalContent requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeadGenLegalContent requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateLeadGenLegalContent requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeadGenLegalContent requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateLeadGenLegalContent requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteLeadGenWhitelistedUsers extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user_id",
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

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteLeadGenWhitelistedUsers.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteLeadGenWhitelistedUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/leadgen_whitelisted_users", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteLeadGenWhitelistedUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteLeadGenWhitelistedUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteLeadGenWhitelistedUsers setUserId (String userId) {
      this.setParam("user_id", userId);
      return this;
    }

    public APIRequestDeleteLeadGenWhitelistedUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteLeadGenWhitelistedUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteLeadGenWhitelistedUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteLeadGenWhitelistedUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteLeadGenWhitelistedUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteLeadGenWhitelistedUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateLeadGenWhitelistedUser extends APIRequest<User> {

    User lastResponse = null;
    @Override
    public User getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user_id",
    };

    public static final String[] FIELDS = {
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
               return APIRequestCreateLeadGenWhitelistedUser.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateLeadGenWhitelistedUser(String nodeId, APIContext context) {
      super(context, nodeId, "/leadgen_whitelisted_users", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateLeadGenWhitelistedUser setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateLeadGenWhitelistedUser setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateLeadGenWhitelistedUser setUserId (Long userId) {
      this.setParam("user_id", userId);
      return this;
    }
    public APIRequestCreateLeadGenWhitelistedUser setUserId (String userId) {
      this.setParam("user_id", userId);
      return this;
    }

    public APIRequestCreateLeadGenWhitelistedUser requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateLeadGenWhitelistedUser requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeadGenWhitelistedUser requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateLeadGenWhitelistedUser requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLeadGenWhitelistedUser requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateLeadGenWhitelistedUser requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetLikes extends APIRequest<Page> {

    APINodeList<Page> lastResponse = null;
    @Override
    public APINodeList<Page> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "target_id",
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
               return APIRequestGetLikes.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetLikes(String nodeId, APIContext context) {
      super(context, nodeId, "/likes", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLikes setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLikes setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLikes setTargetId (String targetId) {
      this.setParam("target_id", targetId);
      return this;
    }

    public APIRequestGetLikes requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLikes requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLikes requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLikes requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLikes requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLikes requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetLikes requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetLikes requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetLikes requestAccessTokenField () {
      return this.requestAccessTokenField(true);
    }
    public APIRequestGetLikes requestAccessTokenField (boolean value) {
      this.requestField("access_token", value);
      return this;
    }
    public APIRequestGetLikes requestAdCampaignField () {
      return this.requestAdCampaignField(true);
    }
    public APIRequestGetLikes requestAdCampaignField (boolean value) {
      this.requestField("ad_campaign", value);
      return this;
    }
    public APIRequestGetLikes requestAffiliationField () {
      return this.requestAffiliationField(true);
    }
    public APIRequestGetLikes requestAffiliationField (boolean value) {
      this.requestField("affiliation", value);
      return this;
    }
    public APIRequestGetLikes requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetLikes requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetLikes requestAppLinksField () {
      return this.requestAppLinksField(true);
    }
    public APIRequestGetLikes requestAppLinksField (boolean value) {
      this.requestField("app_links", value);
      return this;
    }
    public APIRequestGetLikes requestArtistsWeLikeField () {
      return this.requestArtistsWeLikeField(true);
    }
    public APIRequestGetLikes requestArtistsWeLikeField (boolean value) {
      this.requestField("artists_we_like", value);
      return this;
    }
    public APIRequestGetLikes requestAttireField () {
      return this.requestAttireField(true);
    }
    public APIRequestGetLikes requestAttireField (boolean value) {
      this.requestField("attire", value);
      return this;
    }
    public APIRequestGetLikes requestAwardsField () {
      return this.requestAwardsField(true);
    }
    public APIRequestGetLikes requestAwardsField (boolean value) {
      this.requestField("awards", value);
      return this;
    }
    public APIRequestGetLikes requestBandInterestsField () {
      return this.requestBandInterestsField(true);
    }
    public APIRequestGetLikes requestBandInterestsField (boolean value) {
      this.requestField("band_interests", value);
      return this;
    }
    public APIRequestGetLikes requestBandMembersField () {
      return this.requestBandMembersField(true);
    }
    public APIRequestGetLikes requestBandMembersField (boolean value) {
      this.requestField("band_members", value);
      return this;
    }
    public APIRequestGetLikes requestBestPageField () {
      return this.requestBestPageField(true);
    }
    public APIRequestGetLikes requestBestPageField (boolean value) {
      this.requestField("best_page", value);
      return this;
    }
    public APIRequestGetLikes requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetLikes requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetLikes requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetLikes requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetLikes requestBookingAgentField () {
      return this.requestBookingAgentField(true);
    }
    public APIRequestGetLikes requestBookingAgentField (boolean value) {
      this.requestField("booking_agent", value);
      return this;
    }
    public APIRequestGetLikes requestBuiltField () {
      return this.requestBuiltField(true);
    }
    public APIRequestGetLikes requestBuiltField (boolean value) {
      this.requestField("built", value);
      return this;
    }
    public APIRequestGetLikes requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetLikes requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetLikes requestCanCheckinField () {
      return this.requestCanCheckinField(true);
    }
    public APIRequestGetLikes requestCanCheckinField (boolean value) {
      this.requestField("can_checkin", value);
      return this;
    }
    public APIRequestGetLikes requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetLikes requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetLikes requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetLikes requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetLikes requestCategoryListField () {
      return this.requestCategoryListField(true);
    }
    public APIRequestGetLikes requestCategoryListField (boolean value) {
      this.requestField("category_list", value);
      return this;
    }
    public APIRequestGetLikes requestCheckinsField () {
      return this.requestCheckinsField(true);
    }
    public APIRequestGetLikes requestCheckinsField (boolean value) {
      this.requestField("checkins", value);
      return this;
    }
    public APIRequestGetLikes requestCompanyOverviewField () {
      return this.requestCompanyOverviewField(true);
    }
    public APIRequestGetLikes requestCompanyOverviewField (boolean value) {
      this.requestField("company_overview", value);
      return this;
    }
    public APIRequestGetLikes requestConnectedInstagramAccountField () {
      return this.requestConnectedInstagramAccountField(true);
    }
    public APIRequestGetLikes requestConnectedInstagramAccountField (boolean value) {
      this.requestField("connected_instagram_account", value);
      return this;
    }
    public APIRequestGetLikes requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetLikes requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetLikes requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetLikes requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetLikes requestCopyrightAttributionInsightsField () {
      return this.requestCopyrightAttributionInsightsField(true);
    }
    public APIRequestGetLikes requestCopyrightAttributionInsightsField (boolean value) {
      this.requestField("copyright_attribution_insights", value);
      return this;
    }
    public APIRequestGetLikes requestCopyrightWhitelistedIgPartnersField () {
      return this.requestCopyrightWhitelistedIgPartnersField(true);
    }
    public APIRequestGetLikes requestCopyrightWhitelistedIgPartnersField (boolean value) {
      this.requestField("copyright_whitelisted_ig_partners", value);
      return this;
    }
    public APIRequestGetLikes requestCountryPageLikesField () {
      return this.requestCountryPageLikesField(true);
    }
    public APIRequestGetLikes requestCountryPageLikesField (boolean value) {
      this.requestField("country_page_likes", value);
      return this;
    }
    public APIRequestGetLikes requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetLikes requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetLikes requestCulinaryTeamField () {
      return this.requestCulinaryTeamField(true);
    }
    public APIRequestGetLikes requestCulinaryTeamField (boolean value) {
      this.requestField("culinary_team", value);
      return this;
    }
    public APIRequestGetLikes requestCurrentLocationField () {
      return this.requestCurrentLocationField(true);
    }
    public APIRequestGetLikes requestCurrentLocationField (boolean value) {
      this.requestField("current_location", value);
      return this;
    }
    public APIRequestGetLikes requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetLikes requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetLikes requestDescriptionHtmlField () {
      return this.requestDescriptionHtmlField(true);
    }
    public APIRequestGetLikes requestDescriptionHtmlField (boolean value) {
      this.requestField("description_html", value);
      return this;
    }
    public APIRequestGetLikes requestDirectedByField () {
      return this.requestDirectedByField(true);
    }
    public APIRequestGetLikes requestDirectedByField (boolean value) {
      this.requestField("directed_by", value);
      return this;
    }
    public APIRequestGetLikes requestDisplaySubtextField () {
      return this.requestDisplaySubtextField(true);
    }
    public APIRequestGetLikes requestDisplaySubtextField (boolean value) {
      this.requestField("display_subtext", value);
      return this;
    }
    public APIRequestGetLikes requestDisplayedMessageResponseTimeField () {
      return this.requestDisplayedMessageResponseTimeField(true);
    }
    public APIRequestGetLikes requestDisplayedMessageResponseTimeField (boolean value) {
      this.requestField("displayed_message_response_time", value);
      return this;
    }
    public APIRequestGetLikes requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetLikes requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetLikes requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGetLikes requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGetLikes requestFanCountField () {
      return this.requestFanCountField(true);
    }
    public APIRequestGetLikes requestFanCountField (boolean value) {
      this.requestField("fan_count", value);
      return this;
    }
    public APIRequestGetLikes requestFeaturedVideoField () {
      return this.requestFeaturedVideoField(true);
    }
    public APIRequestGetLikes requestFeaturedVideoField (boolean value) {
      this.requestField("featured_video", value);
      return this;
    }
    public APIRequestGetLikes requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetLikes requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetLikes requestFoodStylesField () {
      return this.requestFoodStylesField(true);
    }
    public APIRequestGetLikes requestFoodStylesField (boolean value) {
      this.requestField("food_styles", value);
      return this;
    }
    public APIRequestGetLikes requestFoundedField () {
      return this.requestFoundedField(true);
    }
    public APIRequestGetLikes requestFoundedField (boolean value) {
      this.requestField("founded", value);
      return this;
    }
    public APIRequestGetLikes requestGeneralInfoField () {
      return this.requestGeneralInfoField(true);
    }
    public APIRequestGetLikes requestGeneralInfoField (boolean value) {
      this.requestField("general_info", value);
      return this;
    }
    public APIRequestGetLikes requestGeneralManagerField () {
      return this.requestGeneralManagerField(true);
    }
    public APIRequestGetLikes requestGeneralManagerField (boolean value) {
      this.requestField("general_manager", value);
      return this;
    }
    public APIRequestGetLikes requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGetLikes requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGetLikes requestGlobalBrandPageNameField () {
      return this.requestGlobalBrandPageNameField(true);
    }
    public APIRequestGetLikes requestGlobalBrandPageNameField (boolean value) {
      this.requestField("global_brand_page_name", value);
      return this;
    }
    public APIRequestGetLikes requestGlobalBrandRootIdField () {
      return this.requestGlobalBrandRootIdField(true);
    }
    public APIRequestGetLikes requestGlobalBrandRootIdField (boolean value) {
      this.requestField("global_brand_root_id", value);
      return this;
    }
    public APIRequestGetLikes requestHasAddedAppField () {
      return this.requestHasAddedAppField(true);
    }
    public APIRequestGetLikes requestHasAddedAppField (boolean value) {
      this.requestField("has_added_app", value);
      return this;
    }
    public APIRequestGetLikes requestHasWhatsappNumberField () {
      return this.requestHasWhatsappNumberField(true);
    }
    public APIRequestGetLikes requestHasWhatsappNumberField (boolean value) {
      this.requestField("has_whatsapp_number", value);
      return this;
    }
    public APIRequestGetLikes requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetLikes requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetLikes requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGetLikes requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGetLikes requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetLikes requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetLikes requestImpressumField () {
      return this.requestImpressumField(true);
    }
    public APIRequestGetLikes requestImpressumField (boolean value) {
      this.requestField("impressum", value);
      return this;
    }
    public APIRequestGetLikes requestInfluencesField () {
      return this.requestInfluencesField(true);
    }
    public APIRequestGetLikes requestInfluencesField (boolean value) {
      this.requestField("influences", value);
      return this;
    }
    public APIRequestGetLikes requestInstagramBusinessAccountField () {
      return this.requestInstagramBusinessAccountField(true);
    }
    public APIRequestGetLikes requestInstagramBusinessAccountField (boolean value) {
      this.requestField("instagram_business_account", value);
      return this;
    }
    public APIRequestGetLikes requestInstantArticlesReviewStatusField () {
      return this.requestInstantArticlesReviewStatusField(true);
    }
    public APIRequestGetLikes requestInstantArticlesReviewStatusField (boolean value) {
      this.requestField("instant_articles_review_status", value);
      return this;
    }
    public APIRequestGetLikes requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetLikes requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
      return this;
    }
    public APIRequestGetLikes requestIsChainField () {
      return this.requestIsChainField(true);
    }
    public APIRequestGetLikes requestIsChainField (boolean value) {
      this.requestField("is_chain", value);
      return this;
    }
    public APIRequestGetLikes requestIsCommunityPageField () {
      return this.requestIsCommunityPageField(true);
    }
    public APIRequestGetLikes requestIsCommunityPageField (boolean value) {
      this.requestField("is_community_page", value);
      return this;
    }
    public APIRequestGetLikes requestIsEligibleForBrandedContentField () {
      return this.requestIsEligibleForBrandedContentField(true);
    }
    public APIRequestGetLikes requestIsEligibleForBrandedContentField (boolean value) {
      this.requestField("is_eligible_for_branded_content", value);
      return this;
    }
    public APIRequestGetLikes requestIsMessengerBotGetStartedEnabledField () {
      return this.requestIsMessengerBotGetStartedEnabledField(true);
    }
    public APIRequestGetLikes requestIsMessengerBotGetStartedEnabledField (boolean value) {
      this.requestField("is_messenger_bot_get_started_enabled", value);
      return this;
    }
    public APIRequestGetLikes requestIsMessengerPlatformBotField () {
      return this.requestIsMessengerPlatformBotField(true);
    }
    public APIRequestGetLikes requestIsMessengerPlatformBotField (boolean value) {
      this.requestField("is_messenger_platform_bot", value);
      return this;
    }
    public APIRequestGetLikes requestIsOwnedField () {
      return this.requestIsOwnedField(true);
    }
    public APIRequestGetLikes requestIsOwnedField (boolean value) {
      this.requestField("is_owned", value);
      return this;
    }
    public APIRequestGetLikes requestIsPermanentlyClosedField () {
      return this.requestIsPermanentlyClosedField(true);
    }
    public APIRequestGetLikes requestIsPermanentlyClosedField (boolean value) {
      this.requestField("is_permanently_closed", value);
      return this;
    }
    public APIRequestGetLikes requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetLikes requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetLikes requestIsUnclaimedField () {
      return this.requestIsUnclaimedField(true);
    }
    public APIRequestGetLikes requestIsUnclaimedField (boolean value) {
      this.requestField("is_unclaimed", value);
      return this;
    }
    public APIRequestGetLikes requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetLikes requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetLikes requestIsWebhooksSubscribedField () {
      return this.requestIsWebhooksSubscribedField(true);
    }
    public APIRequestGetLikes requestIsWebhooksSubscribedField (boolean value) {
      this.requestField("is_webhooks_subscribed", value);
      return this;
    }
    public APIRequestGetLikes requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGetLikes requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGetLikes requestLeadgenFormPreviewDetailsField () {
      return this.requestLeadgenFormPreviewDetailsField(true);
    }
    public APIRequestGetLikes requestLeadgenFormPreviewDetailsField (boolean value) {
      this.requestField("leadgen_form_preview_details", value);
      return this;
    }
    public APIRequestGetLikes requestLeadgenHasCrmIntegrationField () {
      return this.requestLeadgenHasCrmIntegrationField(true);
    }
    public APIRequestGetLikes requestLeadgenHasCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_crm_integration", value);
      return this;
    }
    public APIRequestGetLikes requestLeadgenHasFatPingCrmIntegrationField () {
      return this.requestLeadgenHasFatPingCrmIntegrationField(true);
    }
    public APIRequestGetLikes requestLeadgenHasFatPingCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_fat_ping_crm_integration", value);
      return this;
    }
    public APIRequestGetLikes requestLeadgenTosAcceptanceTimeField () {
      return this.requestLeadgenTosAcceptanceTimeField(true);
    }
    public APIRequestGetLikes requestLeadgenTosAcceptanceTimeField (boolean value) {
      this.requestField("leadgen_tos_acceptance_time", value);
      return this;
    }
    public APIRequestGetLikes requestLeadgenTosAcceptedField () {
      return this.requestLeadgenTosAcceptedField(true);
    }
    public APIRequestGetLikes requestLeadgenTosAcceptedField (boolean value) {
      this.requestField("leadgen_tos_accepted", value);
      return this;
    }
    public APIRequestGetLikes requestLeadgenTosAcceptingUserField () {
      return this.requestLeadgenTosAcceptingUserField(true);
    }
    public APIRequestGetLikes requestLeadgenTosAcceptingUserField (boolean value) {
      this.requestField("leadgen_tos_accepting_user", value);
      return this;
    }
    public APIRequestGetLikes requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetLikes requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetLikes requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetLikes requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetLikes requestMembersField () {
      return this.requestMembersField(true);
    }
    public APIRequestGetLikes requestMembersField (boolean value) {
      this.requestField("members", value);
      return this;
    }
    public APIRequestGetLikes requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetLikes requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetLikes requestMerchantReviewStatusField () {
      return this.requestMerchantReviewStatusField(true);
    }
    public APIRequestGetLikes requestMerchantReviewStatusField (boolean value) {
      this.requestField("merchant_review_status", value);
      return this;
    }
    public APIRequestGetLikes requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetLikes requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetLikes requestMessengerAdsDefaultPageWelcomeMessageField () {
      return this.requestMessengerAdsDefaultPageWelcomeMessageField(true);
    }
    public APIRequestGetLikes requestMessengerAdsDefaultPageWelcomeMessageField (boolean value) {
      this.requestField("messenger_ads_default_page_welcome_message", value);
      return this;
    }
    public APIRequestGetLikes requestMessengerAdsDefaultQuickRepliesField () {
      return this.requestMessengerAdsDefaultQuickRepliesField(true);
    }
    public APIRequestGetLikes requestMessengerAdsDefaultQuickRepliesField (boolean value) {
      this.requestField("messenger_ads_default_quick_replies", value);
      return this;
    }
    public APIRequestGetLikes requestMessengerAdsQuickRepliesTypeField () {
      return this.requestMessengerAdsQuickRepliesTypeField(true);
    }
    public APIRequestGetLikes requestMessengerAdsQuickRepliesTypeField (boolean value) {
      this.requestField("messenger_ads_quick_replies_type", value);
      return this;
    }
    public APIRequestGetLikes requestMissionField () {
      return this.requestMissionField(true);
    }
    public APIRequestGetLikes requestMissionField (boolean value) {
      this.requestField("mission", value);
      return this;
    }
    public APIRequestGetLikes requestMpgField () {
      return this.requestMpgField(true);
    }
    public APIRequestGetLikes requestMpgField (boolean value) {
      this.requestField("mpg", value);
      return this;
    }
    public APIRequestGetLikes requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetLikes requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetLikes requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGetLikes requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGetLikes requestNetworkField () {
      return this.requestNetworkField(true);
    }
    public APIRequestGetLikes requestNetworkField (boolean value) {
      this.requestField("network", value);
      return this;
    }
    public APIRequestGetLikes requestNewLikeCountField () {
      return this.requestNewLikeCountField(true);
    }
    public APIRequestGetLikes requestNewLikeCountField (boolean value) {
      this.requestField("new_like_count", value);
      return this;
    }
    public APIRequestGetLikes requestOfferEligibleField () {
      return this.requestOfferEligibleField(true);
    }
    public APIRequestGetLikes requestOfferEligibleField (boolean value) {
      this.requestField("offer_eligible", value);
      return this;
    }
    public APIRequestGetLikes requestOverallStarRatingField () {
      return this.requestOverallStarRatingField(true);
    }
    public APIRequestGetLikes requestOverallStarRatingField (boolean value) {
      this.requestField("overall_star_rating", value);
      return this;
    }
    public APIRequestGetLikes requestPageTokenField () {
      return this.requestPageTokenField(true);
    }
    public APIRequestGetLikes requestPageTokenField (boolean value) {
      this.requestField("page_token", value);
      return this;
    }
    public APIRequestGetLikes requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetLikes requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGetLikes requestParkingField () {
      return this.requestParkingField(true);
    }
    public APIRequestGetLikes requestParkingField (boolean value) {
      this.requestField("parking", value);
      return this;
    }
    public APIRequestGetLikes requestPaymentOptionsField () {
      return this.requestPaymentOptionsField(true);
    }
    public APIRequestGetLikes requestPaymentOptionsField (boolean value) {
      this.requestField("payment_options", value);
      return this;
    }
    public APIRequestGetLikes requestPersonalInfoField () {
      return this.requestPersonalInfoField(true);
    }
    public APIRequestGetLikes requestPersonalInfoField (boolean value) {
      this.requestField("personal_info", value);
      return this;
    }
    public APIRequestGetLikes requestPersonalInterestsField () {
      return this.requestPersonalInterestsField(true);
    }
    public APIRequestGetLikes requestPersonalInterestsField (boolean value) {
      this.requestField("personal_interests", value);
      return this;
    }
    public APIRequestGetLikes requestPharmaSafetyInfoField () {
      return this.requestPharmaSafetyInfoField(true);
    }
    public APIRequestGetLikes requestPharmaSafetyInfoField (boolean value) {
      this.requestField("pharma_safety_info", value);
      return this;
    }
    public APIRequestGetLikes requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetLikes requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetLikes requestPlaceTypeField () {
      return this.requestPlaceTypeField(true);
    }
    public APIRequestGetLikes requestPlaceTypeField (boolean value) {
      this.requestField("place_type", value);
      return this;
    }
    public APIRequestGetLikes requestPlotOutlineField () {
      return this.requestPlotOutlineField(true);
    }
    public APIRequestGetLikes requestPlotOutlineField (boolean value) {
      this.requestField("plot_outline", value);
      return this;
    }
    public APIRequestGetLikes requestPreferredAudienceField () {
      return this.requestPreferredAudienceField(true);
    }
    public APIRequestGetLikes requestPreferredAudienceField (boolean value) {
      this.requestField("preferred_audience", value);
      return this;
    }
    public APIRequestGetLikes requestPressContactField () {
      return this.requestPressContactField(true);
    }
    public APIRequestGetLikes requestPressContactField (boolean value) {
      this.requestField("press_contact", value);
      return this;
    }
    public APIRequestGetLikes requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGetLikes requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGetLikes requestProducedByField () {
      return this.requestProducedByField(true);
    }
    public APIRequestGetLikes requestProducedByField (boolean value) {
      this.requestField("produced_by", value);
      return this;
    }
    public APIRequestGetLikes requestProductsField () {
      return this.requestProductsField(true);
    }
    public APIRequestGetLikes requestProductsField (boolean value) {
      this.requestField("products", value);
      return this;
    }
    public APIRequestGetLikes requestPromotionEligibleField () {
      return this.requestPromotionEligibleField(true);
    }
    public APIRequestGetLikes requestPromotionEligibleField (boolean value) {
      this.requestField("promotion_eligible", value);
      return this;
    }
    public APIRequestGetLikes requestPromotionIneligibleReasonField () {
      return this.requestPromotionIneligibleReasonField(true);
    }
    public APIRequestGetLikes requestPromotionIneligibleReasonField (boolean value) {
      this.requestField("promotion_ineligible_reason", value);
      return this;
    }
    public APIRequestGetLikes requestPublicTransitField () {
      return this.requestPublicTransitField(true);
    }
    public APIRequestGetLikes requestPublicTransitField (boolean value) {
      this.requestField("public_transit", value);
      return this;
    }
    public APIRequestGetLikes requestPublisherSpaceField () {
      return this.requestPublisherSpaceField(true);
    }
    public APIRequestGetLikes requestPublisherSpaceField (boolean value) {
      this.requestField("publisher_space", value);
      return this;
    }
    public APIRequestGetLikes requestRatingCountField () {
      return this.requestRatingCountField(true);
    }
    public APIRequestGetLikes requestRatingCountField (boolean value) {
      this.requestField("rating_count", value);
      return this;
    }
    public APIRequestGetLikes requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetLikes requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetLikes requestRecordLabelField () {
      return this.requestRecordLabelField(true);
    }
    public APIRequestGetLikes requestRecordLabelField (boolean value) {
      this.requestField("record_label", value);
      return this;
    }
    public APIRequestGetLikes requestReleaseDateField () {
      return this.requestReleaseDateField(true);
    }
    public APIRequestGetLikes requestReleaseDateField (boolean value) {
      this.requestField("release_date", value);
      return this;
    }
    public APIRequestGetLikes requestRestaurantServicesField () {
      return this.requestRestaurantServicesField(true);
    }
    public APIRequestGetLikes requestRestaurantServicesField (boolean value) {
      this.requestField("restaurant_services", value);
      return this;
    }
    public APIRequestGetLikes requestRestaurantSpecialtiesField () {
      return this.requestRestaurantSpecialtiesField(true);
    }
    public APIRequestGetLikes requestRestaurantSpecialtiesField (boolean value) {
      this.requestField("restaurant_specialties", value);
      return this;
    }
    public APIRequestGetLikes requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetLikes requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGetLikes requestScreenplayByField () {
      return this.requestScreenplayByField(true);
    }
    public APIRequestGetLikes requestScreenplayByField (boolean value) {
      this.requestField("screenplay_by", value);
      return this;
    }
    public APIRequestGetLikes requestSeasonField () {
      return this.requestSeasonField(true);
    }
    public APIRequestGetLikes requestSeasonField (boolean value) {
      this.requestField("season", value);
      return this;
    }
    public APIRequestGetLikes requestSingleLineAddressField () {
      return this.requestSingleLineAddressField(true);
    }
    public APIRequestGetLikes requestSingleLineAddressField (boolean value) {
      this.requestField("single_line_address", value);
      return this;
    }
    public APIRequestGetLikes requestStarringField () {
      return this.requestStarringField(true);
    }
    public APIRequestGetLikes requestStarringField (boolean value) {
      this.requestField("starring", value);
      return this;
    }
    public APIRequestGetLikes requestStartInfoField () {
      return this.requestStartInfoField(true);
    }
    public APIRequestGetLikes requestStartInfoField (boolean value) {
      this.requestField("start_info", value);
      return this;
    }
    public APIRequestGetLikes requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGetLikes requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGetLikes requestStoreLocationDescriptorField () {
      return this.requestStoreLocationDescriptorField(true);
    }
    public APIRequestGetLikes requestStoreLocationDescriptorField (boolean value) {
      this.requestField("store_location_descriptor", value);
      return this;
    }
    public APIRequestGetLikes requestStoreNumberField () {
      return this.requestStoreNumberField(true);
    }
    public APIRequestGetLikes requestStoreNumberField (boolean value) {
      this.requestField("store_number", value);
      return this;
    }
    public APIRequestGetLikes requestStudioField () {
      return this.requestStudioField(true);
    }
    public APIRequestGetLikes requestStudioField (boolean value) {
      this.requestField("studio", value);
      return this;
    }
    public APIRequestGetLikes requestSupportsInstantArticlesField () {
      return this.requestSupportsInstantArticlesField(true);
    }
    public APIRequestGetLikes requestSupportsInstantArticlesField (boolean value) {
      this.requestField("supports_instant_articles", value);
      return this;
    }
    public APIRequestGetLikes requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetLikes requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
      return this;
    }
    public APIRequestGetLikes requestUnreadMessageCountField () {
      return this.requestUnreadMessageCountField(true);
    }
    public APIRequestGetLikes requestUnreadMessageCountField (boolean value) {
      this.requestField("unread_message_count", value);
      return this;
    }
    public APIRequestGetLikes requestUnreadNotifCountField () {
      return this.requestUnreadNotifCountField(true);
    }
    public APIRequestGetLikes requestUnreadNotifCountField (boolean value) {
      this.requestField("unread_notif_count", value);
      return this;
    }
    public APIRequestGetLikes requestUnseenMessageCountField () {
      return this.requestUnseenMessageCountField(true);
    }
    public APIRequestGetLikes requestUnseenMessageCountField (boolean value) {
      this.requestField("unseen_message_count", value);
      return this;
    }
    public APIRequestGetLikes requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetLikes requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetLikes requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetLikes requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetLikes requestVoipInfoField () {
      return this.requestVoipInfoField(true);
    }
    public APIRequestGetLikes requestVoipInfoField (boolean value) {
      this.requestField("voip_info", value);
      return this;
    }
    public APIRequestGetLikes requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetLikes requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetLikes requestWereHereCountField () {
      return this.requestWereHereCountField(true);
    }
    public APIRequestGetLikes requestWereHereCountField (boolean value) {
      this.requestField("were_here_count", value);
      return this;
    }
    public APIRequestGetLikes requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGetLikes requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
      return this;
    }
    public APIRequestGetLikes requestWrittenByField () {
      return this.requestWrittenByField(true);
    }
    public APIRequestGetLikes requestWrittenByField (boolean value) {
      this.requestField("written_by", value);
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
      "crossposting_actions",
      "custom_labels",
      "description",
      "encoding_settings",
      "fisheye_video_cropped",
      "front_z_rotation",
      "game_show",
      "is_spherical",
      "live_encoders",
      "original_fov",
      "planned_start_time",
      "privacy",
      "product_items",
      "projection",
      "published",
      "save_vod",
      "schedule_custom_profile_image",
      "spatial_audio_format",
      "status",
      "stereoscopic_mode",
      "stop_on_delete_stream",
      "stream_type",
      "targeting",
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

    public APIRequestCreateLiveVideo setCrosspostingActions (List<Map<String, String>> crosspostingActions) {
      this.setParam("crossposting_actions", crosspostingActions);
      return this;
    }
    public APIRequestCreateLiveVideo setCrosspostingActions (String crosspostingActions) {
      this.setParam("crossposting_actions", crosspostingActions);
      return this;
    }

    public APIRequestCreateLiveVideo setCustomLabels (List<String> customLabels) {
      this.setParam("custom_labels", customLabels);
      return this;
    }
    public APIRequestCreateLiveVideo setCustomLabels (String customLabels) {
      this.setParam("custom_labels", customLabels);
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

    public APIRequestCreateLiveVideo setGameShow (Map<String, String> gameShow) {
      this.setParam("game_show", gameShow);
      return this;
    }
    public APIRequestCreateLiveVideo setGameShow (String gameShow) {
      this.setParam("game_show", gameShow);
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

    public APIRequestCreateLiveVideo setProductItems (List<String> productItems) {
      this.setParam("product_items", productItems);
      return this;
    }
    public APIRequestCreateLiveVideo setProductItems (String productItems) {
      this.setParam("product_items", productItems);
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

    public APIRequestCreateLiveVideo setTargeting (Object targeting) {
      this.setParam("targeting", targeting);
      return this;
    }
    public APIRequestCreateLiveVideo setTargeting (String targeting) {
      this.setParam("targeting", targeting);
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

  public static class APIRequestDeleteLocations extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "location_page_id",
      "store_number",
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

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteLocations.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteLocations(String nodeId, APIContext context) {
      super(context, nodeId, "/locations", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteLocations setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteLocations setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteLocations setLocationPageId (Object locationPageId) {
      this.setParam("location_page_id", locationPageId);
      return this;
    }
    public APIRequestDeleteLocations setLocationPageId (String locationPageId) {
      this.setParam("location_page_id", locationPageId);
      return this;
    }

    public APIRequestDeleteLocations setStoreNumber (Long storeNumber) {
      this.setParam("store_number", storeNumber);
      return this;
    }
    public APIRequestDeleteLocations setStoreNumber (String storeNumber) {
      this.setParam("store_number", storeNumber);
      return this;
    }

    public APIRequestDeleteLocations requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteLocations requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteLocations requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteLocations requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteLocations requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteLocations requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetLocations extends APIRequest<Page> {

    APINodeList<Page> lastResponse = null;
    @Override
    public APINodeList<Page> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
               return APIRequestGetLocations.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetLocations(String nodeId, APIContext context) {
      super(context, nodeId, "/locations", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLocations setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLocations setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLocations requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLocations requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLocations requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLocations requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLocations requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLocations requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetLocations requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetLocations requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetLocations requestAccessTokenField () {
      return this.requestAccessTokenField(true);
    }
    public APIRequestGetLocations requestAccessTokenField (boolean value) {
      this.requestField("access_token", value);
      return this;
    }
    public APIRequestGetLocations requestAdCampaignField () {
      return this.requestAdCampaignField(true);
    }
    public APIRequestGetLocations requestAdCampaignField (boolean value) {
      this.requestField("ad_campaign", value);
      return this;
    }
    public APIRequestGetLocations requestAffiliationField () {
      return this.requestAffiliationField(true);
    }
    public APIRequestGetLocations requestAffiliationField (boolean value) {
      this.requestField("affiliation", value);
      return this;
    }
    public APIRequestGetLocations requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetLocations requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetLocations requestAppLinksField () {
      return this.requestAppLinksField(true);
    }
    public APIRequestGetLocations requestAppLinksField (boolean value) {
      this.requestField("app_links", value);
      return this;
    }
    public APIRequestGetLocations requestArtistsWeLikeField () {
      return this.requestArtistsWeLikeField(true);
    }
    public APIRequestGetLocations requestArtistsWeLikeField (boolean value) {
      this.requestField("artists_we_like", value);
      return this;
    }
    public APIRequestGetLocations requestAttireField () {
      return this.requestAttireField(true);
    }
    public APIRequestGetLocations requestAttireField (boolean value) {
      this.requestField("attire", value);
      return this;
    }
    public APIRequestGetLocations requestAwardsField () {
      return this.requestAwardsField(true);
    }
    public APIRequestGetLocations requestAwardsField (boolean value) {
      this.requestField("awards", value);
      return this;
    }
    public APIRequestGetLocations requestBandInterestsField () {
      return this.requestBandInterestsField(true);
    }
    public APIRequestGetLocations requestBandInterestsField (boolean value) {
      this.requestField("band_interests", value);
      return this;
    }
    public APIRequestGetLocations requestBandMembersField () {
      return this.requestBandMembersField(true);
    }
    public APIRequestGetLocations requestBandMembersField (boolean value) {
      this.requestField("band_members", value);
      return this;
    }
    public APIRequestGetLocations requestBestPageField () {
      return this.requestBestPageField(true);
    }
    public APIRequestGetLocations requestBestPageField (boolean value) {
      this.requestField("best_page", value);
      return this;
    }
    public APIRequestGetLocations requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetLocations requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetLocations requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetLocations requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetLocations requestBookingAgentField () {
      return this.requestBookingAgentField(true);
    }
    public APIRequestGetLocations requestBookingAgentField (boolean value) {
      this.requestField("booking_agent", value);
      return this;
    }
    public APIRequestGetLocations requestBuiltField () {
      return this.requestBuiltField(true);
    }
    public APIRequestGetLocations requestBuiltField (boolean value) {
      this.requestField("built", value);
      return this;
    }
    public APIRequestGetLocations requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetLocations requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetLocations requestCanCheckinField () {
      return this.requestCanCheckinField(true);
    }
    public APIRequestGetLocations requestCanCheckinField (boolean value) {
      this.requestField("can_checkin", value);
      return this;
    }
    public APIRequestGetLocations requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetLocations requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetLocations requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetLocations requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetLocations requestCategoryListField () {
      return this.requestCategoryListField(true);
    }
    public APIRequestGetLocations requestCategoryListField (boolean value) {
      this.requestField("category_list", value);
      return this;
    }
    public APIRequestGetLocations requestCheckinsField () {
      return this.requestCheckinsField(true);
    }
    public APIRequestGetLocations requestCheckinsField (boolean value) {
      this.requestField("checkins", value);
      return this;
    }
    public APIRequestGetLocations requestCompanyOverviewField () {
      return this.requestCompanyOverviewField(true);
    }
    public APIRequestGetLocations requestCompanyOverviewField (boolean value) {
      this.requestField("company_overview", value);
      return this;
    }
    public APIRequestGetLocations requestConnectedInstagramAccountField () {
      return this.requestConnectedInstagramAccountField(true);
    }
    public APIRequestGetLocations requestConnectedInstagramAccountField (boolean value) {
      this.requestField("connected_instagram_account", value);
      return this;
    }
    public APIRequestGetLocations requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetLocations requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetLocations requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetLocations requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetLocations requestCopyrightAttributionInsightsField () {
      return this.requestCopyrightAttributionInsightsField(true);
    }
    public APIRequestGetLocations requestCopyrightAttributionInsightsField (boolean value) {
      this.requestField("copyright_attribution_insights", value);
      return this;
    }
    public APIRequestGetLocations requestCopyrightWhitelistedIgPartnersField () {
      return this.requestCopyrightWhitelistedIgPartnersField(true);
    }
    public APIRequestGetLocations requestCopyrightWhitelistedIgPartnersField (boolean value) {
      this.requestField("copyright_whitelisted_ig_partners", value);
      return this;
    }
    public APIRequestGetLocations requestCountryPageLikesField () {
      return this.requestCountryPageLikesField(true);
    }
    public APIRequestGetLocations requestCountryPageLikesField (boolean value) {
      this.requestField("country_page_likes", value);
      return this;
    }
    public APIRequestGetLocations requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetLocations requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetLocations requestCulinaryTeamField () {
      return this.requestCulinaryTeamField(true);
    }
    public APIRequestGetLocations requestCulinaryTeamField (boolean value) {
      this.requestField("culinary_team", value);
      return this;
    }
    public APIRequestGetLocations requestCurrentLocationField () {
      return this.requestCurrentLocationField(true);
    }
    public APIRequestGetLocations requestCurrentLocationField (boolean value) {
      this.requestField("current_location", value);
      return this;
    }
    public APIRequestGetLocations requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetLocations requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetLocations requestDescriptionHtmlField () {
      return this.requestDescriptionHtmlField(true);
    }
    public APIRequestGetLocations requestDescriptionHtmlField (boolean value) {
      this.requestField("description_html", value);
      return this;
    }
    public APIRequestGetLocations requestDirectedByField () {
      return this.requestDirectedByField(true);
    }
    public APIRequestGetLocations requestDirectedByField (boolean value) {
      this.requestField("directed_by", value);
      return this;
    }
    public APIRequestGetLocations requestDisplaySubtextField () {
      return this.requestDisplaySubtextField(true);
    }
    public APIRequestGetLocations requestDisplaySubtextField (boolean value) {
      this.requestField("display_subtext", value);
      return this;
    }
    public APIRequestGetLocations requestDisplayedMessageResponseTimeField () {
      return this.requestDisplayedMessageResponseTimeField(true);
    }
    public APIRequestGetLocations requestDisplayedMessageResponseTimeField (boolean value) {
      this.requestField("displayed_message_response_time", value);
      return this;
    }
    public APIRequestGetLocations requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetLocations requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetLocations requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGetLocations requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGetLocations requestFanCountField () {
      return this.requestFanCountField(true);
    }
    public APIRequestGetLocations requestFanCountField (boolean value) {
      this.requestField("fan_count", value);
      return this;
    }
    public APIRequestGetLocations requestFeaturedVideoField () {
      return this.requestFeaturedVideoField(true);
    }
    public APIRequestGetLocations requestFeaturedVideoField (boolean value) {
      this.requestField("featured_video", value);
      return this;
    }
    public APIRequestGetLocations requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetLocations requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetLocations requestFoodStylesField () {
      return this.requestFoodStylesField(true);
    }
    public APIRequestGetLocations requestFoodStylesField (boolean value) {
      this.requestField("food_styles", value);
      return this;
    }
    public APIRequestGetLocations requestFoundedField () {
      return this.requestFoundedField(true);
    }
    public APIRequestGetLocations requestFoundedField (boolean value) {
      this.requestField("founded", value);
      return this;
    }
    public APIRequestGetLocations requestGeneralInfoField () {
      return this.requestGeneralInfoField(true);
    }
    public APIRequestGetLocations requestGeneralInfoField (boolean value) {
      this.requestField("general_info", value);
      return this;
    }
    public APIRequestGetLocations requestGeneralManagerField () {
      return this.requestGeneralManagerField(true);
    }
    public APIRequestGetLocations requestGeneralManagerField (boolean value) {
      this.requestField("general_manager", value);
      return this;
    }
    public APIRequestGetLocations requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGetLocations requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGetLocations requestGlobalBrandPageNameField () {
      return this.requestGlobalBrandPageNameField(true);
    }
    public APIRequestGetLocations requestGlobalBrandPageNameField (boolean value) {
      this.requestField("global_brand_page_name", value);
      return this;
    }
    public APIRequestGetLocations requestGlobalBrandRootIdField () {
      return this.requestGlobalBrandRootIdField(true);
    }
    public APIRequestGetLocations requestGlobalBrandRootIdField (boolean value) {
      this.requestField("global_brand_root_id", value);
      return this;
    }
    public APIRequestGetLocations requestHasAddedAppField () {
      return this.requestHasAddedAppField(true);
    }
    public APIRequestGetLocations requestHasAddedAppField (boolean value) {
      this.requestField("has_added_app", value);
      return this;
    }
    public APIRequestGetLocations requestHasWhatsappNumberField () {
      return this.requestHasWhatsappNumberField(true);
    }
    public APIRequestGetLocations requestHasWhatsappNumberField (boolean value) {
      this.requestField("has_whatsapp_number", value);
      return this;
    }
    public APIRequestGetLocations requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetLocations requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetLocations requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGetLocations requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGetLocations requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetLocations requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetLocations requestImpressumField () {
      return this.requestImpressumField(true);
    }
    public APIRequestGetLocations requestImpressumField (boolean value) {
      this.requestField("impressum", value);
      return this;
    }
    public APIRequestGetLocations requestInfluencesField () {
      return this.requestInfluencesField(true);
    }
    public APIRequestGetLocations requestInfluencesField (boolean value) {
      this.requestField("influences", value);
      return this;
    }
    public APIRequestGetLocations requestInstagramBusinessAccountField () {
      return this.requestInstagramBusinessAccountField(true);
    }
    public APIRequestGetLocations requestInstagramBusinessAccountField (boolean value) {
      this.requestField("instagram_business_account", value);
      return this;
    }
    public APIRequestGetLocations requestInstantArticlesReviewStatusField () {
      return this.requestInstantArticlesReviewStatusField(true);
    }
    public APIRequestGetLocations requestInstantArticlesReviewStatusField (boolean value) {
      this.requestField("instant_articles_review_status", value);
      return this;
    }
    public APIRequestGetLocations requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetLocations requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
      return this;
    }
    public APIRequestGetLocations requestIsChainField () {
      return this.requestIsChainField(true);
    }
    public APIRequestGetLocations requestIsChainField (boolean value) {
      this.requestField("is_chain", value);
      return this;
    }
    public APIRequestGetLocations requestIsCommunityPageField () {
      return this.requestIsCommunityPageField(true);
    }
    public APIRequestGetLocations requestIsCommunityPageField (boolean value) {
      this.requestField("is_community_page", value);
      return this;
    }
    public APIRequestGetLocations requestIsEligibleForBrandedContentField () {
      return this.requestIsEligibleForBrandedContentField(true);
    }
    public APIRequestGetLocations requestIsEligibleForBrandedContentField (boolean value) {
      this.requestField("is_eligible_for_branded_content", value);
      return this;
    }
    public APIRequestGetLocations requestIsMessengerBotGetStartedEnabledField () {
      return this.requestIsMessengerBotGetStartedEnabledField(true);
    }
    public APIRequestGetLocations requestIsMessengerBotGetStartedEnabledField (boolean value) {
      this.requestField("is_messenger_bot_get_started_enabled", value);
      return this;
    }
    public APIRequestGetLocations requestIsMessengerPlatformBotField () {
      return this.requestIsMessengerPlatformBotField(true);
    }
    public APIRequestGetLocations requestIsMessengerPlatformBotField (boolean value) {
      this.requestField("is_messenger_platform_bot", value);
      return this;
    }
    public APIRequestGetLocations requestIsOwnedField () {
      return this.requestIsOwnedField(true);
    }
    public APIRequestGetLocations requestIsOwnedField (boolean value) {
      this.requestField("is_owned", value);
      return this;
    }
    public APIRequestGetLocations requestIsPermanentlyClosedField () {
      return this.requestIsPermanentlyClosedField(true);
    }
    public APIRequestGetLocations requestIsPermanentlyClosedField (boolean value) {
      this.requestField("is_permanently_closed", value);
      return this;
    }
    public APIRequestGetLocations requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetLocations requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetLocations requestIsUnclaimedField () {
      return this.requestIsUnclaimedField(true);
    }
    public APIRequestGetLocations requestIsUnclaimedField (boolean value) {
      this.requestField("is_unclaimed", value);
      return this;
    }
    public APIRequestGetLocations requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetLocations requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetLocations requestIsWebhooksSubscribedField () {
      return this.requestIsWebhooksSubscribedField(true);
    }
    public APIRequestGetLocations requestIsWebhooksSubscribedField (boolean value) {
      this.requestField("is_webhooks_subscribed", value);
      return this;
    }
    public APIRequestGetLocations requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGetLocations requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGetLocations requestLeadgenFormPreviewDetailsField () {
      return this.requestLeadgenFormPreviewDetailsField(true);
    }
    public APIRequestGetLocations requestLeadgenFormPreviewDetailsField (boolean value) {
      this.requestField("leadgen_form_preview_details", value);
      return this;
    }
    public APIRequestGetLocations requestLeadgenHasCrmIntegrationField () {
      return this.requestLeadgenHasCrmIntegrationField(true);
    }
    public APIRequestGetLocations requestLeadgenHasCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_crm_integration", value);
      return this;
    }
    public APIRequestGetLocations requestLeadgenHasFatPingCrmIntegrationField () {
      return this.requestLeadgenHasFatPingCrmIntegrationField(true);
    }
    public APIRequestGetLocations requestLeadgenHasFatPingCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_fat_ping_crm_integration", value);
      return this;
    }
    public APIRequestGetLocations requestLeadgenTosAcceptanceTimeField () {
      return this.requestLeadgenTosAcceptanceTimeField(true);
    }
    public APIRequestGetLocations requestLeadgenTosAcceptanceTimeField (boolean value) {
      this.requestField("leadgen_tos_acceptance_time", value);
      return this;
    }
    public APIRequestGetLocations requestLeadgenTosAcceptedField () {
      return this.requestLeadgenTosAcceptedField(true);
    }
    public APIRequestGetLocations requestLeadgenTosAcceptedField (boolean value) {
      this.requestField("leadgen_tos_accepted", value);
      return this;
    }
    public APIRequestGetLocations requestLeadgenTosAcceptingUserField () {
      return this.requestLeadgenTosAcceptingUserField(true);
    }
    public APIRequestGetLocations requestLeadgenTosAcceptingUserField (boolean value) {
      this.requestField("leadgen_tos_accepting_user", value);
      return this;
    }
    public APIRequestGetLocations requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetLocations requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetLocations requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetLocations requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetLocations requestMembersField () {
      return this.requestMembersField(true);
    }
    public APIRequestGetLocations requestMembersField (boolean value) {
      this.requestField("members", value);
      return this;
    }
    public APIRequestGetLocations requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetLocations requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetLocations requestMerchantReviewStatusField () {
      return this.requestMerchantReviewStatusField(true);
    }
    public APIRequestGetLocations requestMerchantReviewStatusField (boolean value) {
      this.requestField("merchant_review_status", value);
      return this;
    }
    public APIRequestGetLocations requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetLocations requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetLocations requestMessengerAdsDefaultPageWelcomeMessageField () {
      return this.requestMessengerAdsDefaultPageWelcomeMessageField(true);
    }
    public APIRequestGetLocations requestMessengerAdsDefaultPageWelcomeMessageField (boolean value) {
      this.requestField("messenger_ads_default_page_welcome_message", value);
      return this;
    }
    public APIRequestGetLocations requestMessengerAdsDefaultQuickRepliesField () {
      return this.requestMessengerAdsDefaultQuickRepliesField(true);
    }
    public APIRequestGetLocations requestMessengerAdsDefaultQuickRepliesField (boolean value) {
      this.requestField("messenger_ads_default_quick_replies", value);
      return this;
    }
    public APIRequestGetLocations requestMessengerAdsQuickRepliesTypeField () {
      return this.requestMessengerAdsQuickRepliesTypeField(true);
    }
    public APIRequestGetLocations requestMessengerAdsQuickRepliesTypeField (boolean value) {
      this.requestField("messenger_ads_quick_replies_type", value);
      return this;
    }
    public APIRequestGetLocations requestMissionField () {
      return this.requestMissionField(true);
    }
    public APIRequestGetLocations requestMissionField (boolean value) {
      this.requestField("mission", value);
      return this;
    }
    public APIRequestGetLocations requestMpgField () {
      return this.requestMpgField(true);
    }
    public APIRequestGetLocations requestMpgField (boolean value) {
      this.requestField("mpg", value);
      return this;
    }
    public APIRequestGetLocations requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetLocations requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetLocations requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGetLocations requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGetLocations requestNetworkField () {
      return this.requestNetworkField(true);
    }
    public APIRequestGetLocations requestNetworkField (boolean value) {
      this.requestField("network", value);
      return this;
    }
    public APIRequestGetLocations requestNewLikeCountField () {
      return this.requestNewLikeCountField(true);
    }
    public APIRequestGetLocations requestNewLikeCountField (boolean value) {
      this.requestField("new_like_count", value);
      return this;
    }
    public APIRequestGetLocations requestOfferEligibleField () {
      return this.requestOfferEligibleField(true);
    }
    public APIRequestGetLocations requestOfferEligibleField (boolean value) {
      this.requestField("offer_eligible", value);
      return this;
    }
    public APIRequestGetLocations requestOverallStarRatingField () {
      return this.requestOverallStarRatingField(true);
    }
    public APIRequestGetLocations requestOverallStarRatingField (boolean value) {
      this.requestField("overall_star_rating", value);
      return this;
    }
    public APIRequestGetLocations requestPageTokenField () {
      return this.requestPageTokenField(true);
    }
    public APIRequestGetLocations requestPageTokenField (boolean value) {
      this.requestField("page_token", value);
      return this;
    }
    public APIRequestGetLocations requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetLocations requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGetLocations requestParkingField () {
      return this.requestParkingField(true);
    }
    public APIRequestGetLocations requestParkingField (boolean value) {
      this.requestField("parking", value);
      return this;
    }
    public APIRequestGetLocations requestPaymentOptionsField () {
      return this.requestPaymentOptionsField(true);
    }
    public APIRequestGetLocations requestPaymentOptionsField (boolean value) {
      this.requestField("payment_options", value);
      return this;
    }
    public APIRequestGetLocations requestPersonalInfoField () {
      return this.requestPersonalInfoField(true);
    }
    public APIRequestGetLocations requestPersonalInfoField (boolean value) {
      this.requestField("personal_info", value);
      return this;
    }
    public APIRequestGetLocations requestPersonalInterestsField () {
      return this.requestPersonalInterestsField(true);
    }
    public APIRequestGetLocations requestPersonalInterestsField (boolean value) {
      this.requestField("personal_interests", value);
      return this;
    }
    public APIRequestGetLocations requestPharmaSafetyInfoField () {
      return this.requestPharmaSafetyInfoField(true);
    }
    public APIRequestGetLocations requestPharmaSafetyInfoField (boolean value) {
      this.requestField("pharma_safety_info", value);
      return this;
    }
    public APIRequestGetLocations requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetLocations requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetLocations requestPlaceTypeField () {
      return this.requestPlaceTypeField(true);
    }
    public APIRequestGetLocations requestPlaceTypeField (boolean value) {
      this.requestField("place_type", value);
      return this;
    }
    public APIRequestGetLocations requestPlotOutlineField () {
      return this.requestPlotOutlineField(true);
    }
    public APIRequestGetLocations requestPlotOutlineField (boolean value) {
      this.requestField("plot_outline", value);
      return this;
    }
    public APIRequestGetLocations requestPreferredAudienceField () {
      return this.requestPreferredAudienceField(true);
    }
    public APIRequestGetLocations requestPreferredAudienceField (boolean value) {
      this.requestField("preferred_audience", value);
      return this;
    }
    public APIRequestGetLocations requestPressContactField () {
      return this.requestPressContactField(true);
    }
    public APIRequestGetLocations requestPressContactField (boolean value) {
      this.requestField("press_contact", value);
      return this;
    }
    public APIRequestGetLocations requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGetLocations requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGetLocations requestProducedByField () {
      return this.requestProducedByField(true);
    }
    public APIRequestGetLocations requestProducedByField (boolean value) {
      this.requestField("produced_by", value);
      return this;
    }
    public APIRequestGetLocations requestProductsField () {
      return this.requestProductsField(true);
    }
    public APIRequestGetLocations requestProductsField (boolean value) {
      this.requestField("products", value);
      return this;
    }
    public APIRequestGetLocations requestPromotionEligibleField () {
      return this.requestPromotionEligibleField(true);
    }
    public APIRequestGetLocations requestPromotionEligibleField (boolean value) {
      this.requestField("promotion_eligible", value);
      return this;
    }
    public APIRequestGetLocations requestPromotionIneligibleReasonField () {
      return this.requestPromotionIneligibleReasonField(true);
    }
    public APIRequestGetLocations requestPromotionIneligibleReasonField (boolean value) {
      this.requestField("promotion_ineligible_reason", value);
      return this;
    }
    public APIRequestGetLocations requestPublicTransitField () {
      return this.requestPublicTransitField(true);
    }
    public APIRequestGetLocations requestPublicTransitField (boolean value) {
      this.requestField("public_transit", value);
      return this;
    }
    public APIRequestGetLocations requestPublisherSpaceField () {
      return this.requestPublisherSpaceField(true);
    }
    public APIRequestGetLocations requestPublisherSpaceField (boolean value) {
      this.requestField("publisher_space", value);
      return this;
    }
    public APIRequestGetLocations requestRatingCountField () {
      return this.requestRatingCountField(true);
    }
    public APIRequestGetLocations requestRatingCountField (boolean value) {
      this.requestField("rating_count", value);
      return this;
    }
    public APIRequestGetLocations requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetLocations requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetLocations requestRecordLabelField () {
      return this.requestRecordLabelField(true);
    }
    public APIRequestGetLocations requestRecordLabelField (boolean value) {
      this.requestField("record_label", value);
      return this;
    }
    public APIRequestGetLocations requestReleaseDateField () {
      return this.requestReleaseDateField(true);
    }
    public APIRequestGetLocations requestReleaseDateField (boolean value) {
      this.requestField("release_date", value);
      return this;
    }
    public APIRequestGetLocations requestRestaurantServicesField () {
      return this.requestRestaurantServicesField(true);
    }
    public APIRequestGetLocations requestRestaurantServicesField (boolean value) {
      this.requestField("restaurant_services", value);
      return this;
    }
    public APIRequestGetLocations requestRestaurantSpecialtiesField () {
      return this.requestRestaurantSpecialtiesField(true);
    }
    public APIRequestGetLocations requestRestaurantSpecialtiesField (boolean value) {
      this.requestField("restaurant_specialties", value);
      return this;
    }
    public APIRequestGetLocations requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetLocations requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGetLocations requestScreenplayByField () {
      return this.requestScreenplayByField(true);
    }
    public APIRequestGetLocations requestScreenplayByField (boolean value) {
      this.requestField("screenplay_by", value);
      return this;
    }
    public APIRequestGetLocations requestSeasonField () {
      return this.requestSeasonField(true);
    }
    public APIRequestGetLocations requestSeasonField (boolean value) {
      this.requestField("season", value);
      return this;
    }
    public APIRequestGetLocations requestSingleLineAddressField () {
      return this.requestSingleLineAddressField(true);
    }
    public APIRequestGetLocations requestSingleLineAddressField (boolean value) {
      this.requestField("single_line_address", value);
      return this;
    }
    public APIRequestGetLocations requestStarringField () {
      return this.requestStarringField(true);
    }
    public APIRequestGetLocations requestStarringField (boolean value) {
      this.requestField("starring", value);
      return this;
    }
    public APIRequestGetLocations requestStartInfoField () {
      return this.requestStartInfoField(true);
    }
    public APIRequestGetLocations requestStartInfoField (boolean value) {
      this.requestField("start_info", value);
      return this;
    }
    public APIRequestGetLocations requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGetLocations requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGetLocations requestStoreLocationDescriptorField () {
      return this.requestStoreLocationDescriptorField(true);
    }
    public APIRequestGetLocations requestStoreLocationDescriptorField (boolean value) {
      this.requestField("store_location_descriptor", value);
      return this;
    }
    public APIRequestGetLocations requestStoreNumberField () {
      return this.requestStoreNumberField(true);
    }
    public APIRequestGetLocations requestStoreNumberField (boolean value) {
      this.requestField("store_number", value);
      return this;
    }
    public APIRequestGetLocations requestStudioField () {
      return this.requestStudioField(true);
    }
    public APIRequestGetLocations requestStudioField (boolean value) {
      this.requestField("studio", value);
      return this;
    }
    public APIRequestGetLocations requestSupportsInstantArticlesField () {
      return this.requestSupportsInstantArticlesField(true);
    }
    public APIRequestGetLocations requestSupportsInstantArticlesField (boolean value) {
      this.requestField("supports_instant_articles", value);
      return this;
    }
    public APIRequestGetLocations requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetLocations requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
      return this;
    }
    public APIRequestGetLocations requestUnreadMessageCountField () {
      return this.requestUnreadMessageCountField(true);
    }
    public APIRequestGetLocations requestUnreadMessageCountField (boolean value) {
      this.requestField("unread_message_count", value);
      return this;
    }
    public APIRequestGetLocations requestUnreadNotifCountField () {
      return this.requestUnreadNotifCountField(true);
    }
    public APIRequestGetLocations requestUnreadNotifCountField (boolean value) {
      this.requestField("unread_notif_count", value);
      return this;
    }
    public APIRequestGetLocations requestUnseenMessageCountField () {
      return this.requestUnseenMessageCountField(true);
    }
    public APIRequestGetLocations requestUnseenMessageCountField (boolean value) {
      this.requestField("unseen_message_count", value);
      return this;
    }
    public APIRequestGetLocations requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetLocations requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetLocations requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetLocations requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetLocations requestVoipInfoField () {
      return this.requestVoipInfoField(true);
    }
    public APIRequestGetLocations requestVoipInfoField (boolean value) {
      this.requestField("voip_info", value);
      return this;
    }
    public APIRequestGetLocations requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetLocations requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetLocations requestWereHereCountField () {
      return this.requestWereHereCountField(true);
    }
    public APIRequestGetLocations requestWereHereCountField (boolean value) {
      this.requestField("were_here_count", value);
      return this;
    }
    public APIRequestGetLocations requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGetLocations requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
      return this;
    }
    public APIRequestGetLocations requestWrittenByField () {
      return this.requestWrittenByField(true);
    }
    public APIRequestGetLocations requestWrittenByField (boolean value) {
      this.requestField("written_by", value);
      return this;
    }
  }

  public static class APIRequestCreateLocation extends APIRequest<Location> {

    Location lastResponse = null;
    @Override
    public Location getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "always_open",
      "hours",
      "ignore_warnings",
      "location",
      "location_page_id",
      "old_store_number",
      "page_username",
      "permanently_closed",
      "phone",
      "place_topics",
      "price_range",
      "store_code",
      "store_location_descriptor",
      "store_name",
      "store_number",
      "website",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Location parseResponse(String response) throws APIException {
      return Location.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Location execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Location execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Location> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Location> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Location>() {
           public Location apply(String result) {
             try {
               return APIRequestCreateLocation.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateLocation(String nodeId, APIContext context) {
      super(context, nodeId, "/locations", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateLocation setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateLocation setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateLocation setAlwaysOpen (Boolean alwaysOpen) {
      this.setParam("always_open", alwaysOpen);
      return this;
    }
    public APIRequestCreateLocation setAlwaysOpen (String alwaysOpen) {
      this.setParam("always_open", alwaysOpen);
      return this;
    }

    public APIRequestCreateLocation setHours (Map<String, String> hours) {
      this.setParam("hours", hours);
      return this;
    }
    public APIRequestCreateLocation setHours (String hours) {
      this.setParam("hours", hours);
      return this;
    }

    public APIRequestCreateLocation setIgnoreWarnings (Boolean ignoreWarnings) {
      this.setParam("ignore_warnings", ignoreWarnings);
      return this;
    }
    public APIRequestCreateLocation setIgnoreWarnings (String ignoreWarnings) {
      this.setParam("ignore_warnings", ignoreWarnings);
      return this;
    }

    public APIRequestCreateLocation setLocation (Object location) {
      this.setParam("location", location);
      return this;
    }
    public APIRequestCreateLocation setLocation (String location) {
      this.setParam("location", location);
      return this;
    }

    public APIRequestCreateLocation setLocationPageId (Object locationPageId) {
      this.setParam("location_page_id", locationPageId);
      return this;
    }
    public APIRequestCreateLocation setLocationPageId (String locationPageId) {
      this.setParam("location_page_id", locationPageId);
      return this;
    }

    public APIRequestCreateLocation setOldStoreNumber (Long oldStoreNumber) {
      this.setParam("old_store_number", oldStoreNumber);
      return this;
    }
    public APIRequestCreateLocation setOldStoreNumber (String oldStoreNumber) {
      this.setParam("old_store_number", oldStoreNumber);
      return this;
    }

    public APIRequestCreateLocation setPageUsername (String pageUsername) {
      this.setParam("page_username", pageUsername);
      return this;
    }

    public APIRequestCreateLocation setPermanentlyClosed (Boolean permanentlyClosed) {
      this.setParam("permanently_closed", permanentlyClosed);
      return this;
    }
    public APIRequestCreateLocation setPermanentlyClosed (String permanentlyClosed) {
      this.setParam("permanently_closed", permanentlyClosed);
      return this;
    }

    public APIRequestCreateLocation setPhone (String phone) {
      this.setParam("phone", phone);
      return this;
    }

    public APIRequestCreateLocation setPlaceTopics (List<String> placeTopics) {
      this.setParam("place_topics", placeTopics);
      return this;
    }
    public APIRequestCreateLocation setPlaceTopics (String placeTopics) {
      this.setParam("place_topics", placeTopics);
      return this;
    }

    public APIRequestCreateLocation setPriceRange (String priceRange) {
      this.setParam("price_range", priceRange);
      return this;
    }

    public APIRequestCreateLocation setStoreCode (String storeCode) {
      this.setParam("store_code", storeCode);
      return this;
    }

    public APIRequestCreateLocation setStoreLocationDescriptor (String storeLocationDescriptor) {
      this.setParam("store_location_descriptor", storeLocationDescriptor);
      return this;
    }

    public APIRequestCreateLocation setStoreName (String storeName) {
      this.setParam("store_name", storeName);
      return this;
    }

    public APIRequestCreateLocation setStoreNumber (Long storeNumber) {
      this.setParam("store_number", storeNumber);
      return this;
    }
    public APIRequestCreateLocation setStoreNumber (String storeNumber) {
      this.setParam("store_number", storeNumber);
      return this;
    }

    public APIRequestCreateLocation setWebsite (Object website) {
      this.setParam("website", website);
      return this;
    }
    public APIRequestCreateLocation setWebsite (String website) {
      this.setParam("website", website);
      return this;
    }

    public APIRequestCreateLocation requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateLocation requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLocation requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateLocation requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLocation requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateLocation requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMediaFingerprint extends APIRequest<MediaFingerprint> {

    MediaFingerprint lastResponse = null;
    @Override
    public MediaFingerprint getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "fingerprint_content_type",
      "metadata",
      "source",
      "title",
      "universal_content_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public MediaFingerprint parseResponse(String response) throws APIException {
      return MediaFingerprint.parseResponse(response, getContext(), this).head();
    }

    @Override
    public MediaFingerprint execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MediaFingerprint execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<MediaFingerprint> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MediaFingerprint> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, MediaFingerprint>() {
           public MediaFingerprint apply(String result) {
             try {
               return APIRequestCreateMediaFingerprint.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateMediaFingerprint(String nodeId, APIContext context) {
      super(context, nodeId, "/media_fingerprints", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMediaFingerprint setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMediaFingerprint setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMediaFingerprint setFingerprintContentType (MediaFingerprint.EnumFingerprintContentType fingerprintContentType) {
      this.setParam("fingerprint_content_type", fingerprintContentType);
      return this;
    }
    public APIRequestCreateMediaFingerprint setFingerprintContentType (String fingerprintContentType) {
      this.setParam("fingerprint_content_type", fingerprintContentType);
      return this;
    }

    public APIRequestCreateMediaFingerprint setMetadata (Object metadata) {
      this.setParam("metadata", metadata);
      return this;
    }
    public APIRequestCreateMediaFingerprint setMetadata (String metadata) {
      this.setParam("metadata", metadata);
      return this;
    }

    public APIRequestCreateMediaFingerprint setSource (String source) {
      this.setParam("source", source);
      return this;
    }

    public APIRequestCreateMediaFingerprint setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateMediaFingerprint setUniversalContentId (String universalContentId) {
      this.setParam("universal_content_id", universalContentId);
      return this;
    }

    public APIRequestCreateMediaFingerprint requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMediaFingerprint requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMediaFingerprint requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMediaFingerprint requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMediaFingerprint requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMediaFingerprint requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMessageAttachment extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "message",
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
               return APIRequestCreateMessageAttachment.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateMessageAttachment(String nodeId, APIContext context) {
      super(context, nodeId, "/message_attachments", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMessageAttachment setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMessageAttachment setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMessageAttachment setMessage (Object message) {
      this.setParam("message", message);
      return this;
    }
    public APIRequestCreateMessageAttachment setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateMessageAttachment requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMessageAttachment requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMessageAttachment requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMessageAttachment requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMessageAttachment requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMessageAttachment requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMessage extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "message",
      "messaging_type",
      "notification_type",
      "recipient",
      "sender_action",
      "tag",
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
               return APIRequestCreateMessage.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateMessage(String nodeId, APIContext context) {
      super(context, nodeId, "/messages", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMessage setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMessage setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMessage setMessage (Object message) {
      this.setParam("message", message);
      return this;
    }
    public APIRequestCreateMessage setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateMessage setMessagingType (EnumMessagingType messagingType) {
      this.setParam("messaging_type", messagingType);
      return this;
    }
    public APIRequestCreateMessage setMessagingType (String messagingType) {
      this.setParam("messaging_type", messagingType);
      return this;
    }

    public APIRequestCreateMessage setNotificationType (EnumNotificationType notificationType) {
      this.setParam("notification_type", notificationType);
      return this;
    }
    public APIRequestCreateMessage setNotificationType (String notificationType) {
      this.setParam("notification_type", notificationType);
      return this;
    }

    public APIRequestCreateMessage setRecipient (Object recipient) {
      this.setParam("recipient", recipient);
      return this;
    }
    public APIRequestCreateMessage setRecipient (String recipient) {
      this.setParam("recipient", recipient);
      return this;
    }

    public APIRequestCreateMessage setSenderAction (EnumSenderAction senderAction) {
      this.setParam("sender_action", senderAction);
      return this;
    }
    public APIRequestCreateMessage setSenderAction (String senderAction) {
      this.setParam("sender_action", senderAction);
      return this;
    }

    public APIRequestCreateMessage setTag (Object tag) {
      this.setParam("tag", tag);
      return this;
    }
    public APIRequestCreateMessage setTag (String tag) {
      this.setParam("tag", tag);
      return this;
    }

    public APIRequestCreateMessage requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMessage requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMessage requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMessage requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMessage requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMessage requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetMessagingFeatureReview extends APIRequest<MessagingFeatureReview> {

    APINodeList<MessagingFeatureReview> lastResponse = null;
    @Override
    public APINodeList<MessagingFeatureReview> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "feature",
      "status",
    };

    @Override
    public APINodeList<MessagingFeatureReview> parseResponse(String response) throws APIException {
      return MessagingFeatureReview.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<MessagingFeatureReview> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<MessagingFeatureReview> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<MessagingFeatureReview>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<MessagingFeatureReview>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<MessagingFeatureReview>>() {
           public APINodeList<MessagingFeatureReview> apply(String result) {
             try {
               return APIRequestGetMessagingFeatureReview.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetMessagingFeatureReview(String nodeId, APIContext context) {
      super(context, nodeId, "/messaging_feature_review", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMessagingFeatureReview setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMessagingFeatureReview setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMessagingFeatureReview requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMessagingFeatureReview requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMessagingFeatureReview requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMessagingFeatureReview requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMessagingFeatureReview requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMessagingFeatureReview requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetMessagingFeatureReview requestFeatureField () {
      return this.requestFeatureField(true);
    }
    public APIRequestGetMessagingFeatureReview requestFeatureField (boolean value) {
      this.requestField("feature", value);
      return this;
    }
    public APIRequestGetMessagingFeatureReview requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetMessagingFeatureReview requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static class APIRequestCreateMessengerCode extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "data",
      "image_size",
      "type",
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
               return APIRequestCreateMessengerCode.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateMessengerCode(String nodeId, APIContext context) {
      super(context, nodeId, "/messenger_codes", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMessengerCode setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMessengerCode setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMessengerCode setData (String data) {
      this.setParam("data", data);
      return this;
    }

    public APIRequestCreateMessengerCode setImageSize (Long imageSize) {
      this.setParam("image_size", imageSize);
      return this;
    }
    public APIRequestCreateMessengerCode setImageSize (String imageSize) {
      this.setParam("image_size", imageSize);
      return this;
    }

    public APIRequestCreateMessengerCode setType (EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestCreateMessengerCode setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestCreateMessengerCode requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMessengerCode requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMessengerCode requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMessengerCode requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMessengerCode requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMessengerCode requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteMessengerProfile extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "fields",
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

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteMessengerProfile.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteMessengerProfile(String nodeId, APIContext context) {
      super(context, nodeId, "/messenger_profile", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteMessengerProfile setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteMessengerProfile setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteMessengerProfile setFields (List<MessengerProfile.EnumFields> fields) {
      this.setParam("fields", fields);
      return this;
    }
    public APIRequestDeleteMessengerProfile setFields (String fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestDeleteMessengerProfile requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteMessengerProfile requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteMessengerProfile requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteMessengerProfile requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteMessengerProfile requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteMessengerProfile requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMessengerProfile extends APIRequest<MessengerProfile> {

    MessengerProfile lastResponse = null;
    @Override
    public MessengerProfile getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_linking_url",
      "get_started",
      "greeting",
      "home_url",
      "payment_settings",
      "persistent_menu",
      "target_audience",
      "whitelisted_domains",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public MessengerProfile parseResponse(String response) throws APIException {
      return MessengerProfile.parseResponse(response, getContext(), this).head();
    }

    @Override
    public MessengerProfile execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MessengerProfile execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<MessengerProfile> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MessengerProfile> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, MessengerProfile>() {
           public MessengerProfile apply(String result) {
             try {
               return APIRequestCreateMessengerProfile.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateMessengerProfile(String nodeId, APIContext context) {
      super(context, nodeId, "/messenger_profile", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMessengerProfile setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMessengerProfile setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMessengerProfile setAccountLinkingUrl (String accountLinkingUrl) {
      this.setParam("account_linking_url", accountLinkingUrl);
      return this;
    }

    public APIRequestCreateMessengerProfile setGetStarted (Object getStarted) {
      this.setParam("get_started", getStarted);
      return this;
    }
    public APIRequestCreateMessengerProfile setGetStarted (String getStarted) {
      this.setParam("get_started", getStarted);
      return this;
    }

    public APIRequestCreateMessengerProfile setGreeting (List<Object> greeting) {
      this.setParam("greeting", greeting);
      return this;
    }
    public APIRequestCreateMessengerProfile setGreeting (String greeting) {
      this.setParam("greeting", greeting);
      return this;
    }

    public APIRequestCreateMessengerProfile setHomeUrl (Object homeUrl) {
      this.setParam("home_url", homeUrl);
      return this;
    }
    public APIRequestCreateMessengerProfile setHomeUrl (String homeUrl) {
      this.setParam("home_url", homeUrl);
      return this;
    }

    public APIRequestCreateMessengerProfile setPaymentSettings (Object paymentSettings) {
      this.setParam("payment_settings", paymentSettings);
      return this;
    }
    public APIRequestCreateMessengerProfile setPaymentSettings (String paymentSettings) {
      this.setParam("payment_settings", paymentSettings);
      return this;
    }

    public APIRequestCreateMessengerProfile setPersistentMenu (List<Object> persistentMenu) {
      this.setParam("persistent_menu", persistentMenu);
      return this;
    }
    public APIRequestCreateMessengerProfile setPersistentMenu (String persistentMenu) {
      this.setParam("persistent_menu", persistentMenu);
      return this;
    }

    public APIRequestCreateMessengerProfile setTargetAudience (Object targetAudience) {
      this.setParam("target_audience", targetAudience);
      return this;
    }
    public APIRequestCreateMessengerProfile setTargetAudience (String targetAudience) {
      this.setParam("target_audience", targetAudience);
      return this;
    }

    public APIRequestCreateMessengerProfile setWhitelistedDomains (List<String> whitelistedDomains) {
      this.setParam("whitelisted_domains", whitelistedDomains);
      return this;
    }
    public APIRequestCreateMessengerProfile setWhitelistedDomains (String whitelistedDomains) {
      this.setParam("whitelisted_domains", whitelistedDomains);
      return this;
    }

    public APIRequestCreateMessengerProfile requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMessengerProfile requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMessengerProfile requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMessengerProfile requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMessengerProfile requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMessengerProfile requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMilestone extends APIRequest<LifeEvent> {

    LifeEvent lastResponse = null;
    @Override
    public LifeEvent getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "description",
      "start_time",
      "title",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public LifeEvent parseResponse(String response) throws APIException {
      return LifeEvent.parseResponse(response, getContext(), this).head();
    }

    @Override
    public LifeEvent execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LifeEvent execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<LifeEvent> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LifeEvent> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, LifeEvent>() {
           public LifeEvent apply(String result) {
             try {
               return APIRequestCreateMilestone.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateMilestone(String nodeId, APIContext context) {
      super(context, nodeId, "/milestones", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMilestone setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMilestone setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMilestone setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateMilestone setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestCreateMilestone setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateMilestone requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMilestone requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMilestone requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMilestone requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMilestone requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMilestone requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetNativeOffers extends APIRequest<NativeOffer> {

    APINodeList<NativeOffer> lastResponse = null;
    @Override
    public APINodeList<NativeOffer> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "barcode_photo",
      "barcode_photo_uri",
      "barcode_type",
      "barcode_value",
      "details",
      "disable_location",
      "discounts",
      "expiration_time",
      "id",
      "instore_code",
      "location_type",
      "max_save_count",
      "online_code",
      "page",
      "page_set_id",
      "redemption_link",
      "save_count",
      "terms",
      "title",
      "total_unique_codes",
      "unique_codes",
      "unique_codes_file_code_type",
      "unique_codes_file_name",
      "unique_codes_file_upload_status",
    };

    @Override
    public APINodeList<NativeOffer> parseResponse(String response) throws APIException {
      return NativeOffer.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<NativeOffer> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<NativeOffer> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<NativeOffer>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<NativeOffer>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<NativeOffer>>() {
           public APINodeList<NativeOffer> apply(String result) {
             try {
               return APIRequestGetNativeOffers.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetNativeOffers(String nodeId, APIContext context) {
      super(context, nodeId, "/nativeoffers", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetNativeOffers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetNativeOffers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetNativeOffers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetNativeOffers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetNativeOffers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetNativeOffers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetNativeOffers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetNativeOffers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetNativeOffers requestBarcodePhotoField () {
      return this.requestBarcodePhotoField(true);
    }
    public APIRequestGetNativeOffers requestBarcodePhotoField (boolean value) {
      this.requestField("barcode_photo", value);
      return this;
    }
    public APIRequestGetNativeOffers requestBarcodePhotoUriField () {
      return this.requestBarcodePhotoUriField(true);
    }
    public APIRequestGetNativeOffers requestBarcodePhotoUriField (boolean value) {
      this.requestField("barcode_photo_uri", value);
      return this;
    }
    public APIRequestGetNativeOffers requestBarcodeTypeField () {
      return this.requestBarcodeTypeField(true);
    }
    public APIRequestGetNativeOffers requestBarcodeTypeField (boolean value) {
      this.requestField("barcode_type", value);
      return this;
    }
    public APIRequestGetNativeOffers requestBarcodeValueField () {
      return this.requestBarcodeValueField(true);
    }
    public APIRequestGetNativeOffers requestBarcodeValueField (boolean value) {
      this.requestField("barcode_value", value);
      return this;
    }
    public APIRequestGetNativeOffers requestDetailsField () {
      return this.requestDetailsField(true);
    }
    public APIRequestGetNativeOffers requestDetailsField (boolean value) {
      this.requestField("details", value);
      return this;
    }
    public APIRequestGetNativeOffers requestDisableLocationField () {
      return this.requestDisableLocationField(true);
    }
    public APIRequestGetNativeOffers requestDisableLocationField (boolean value) {
      this.requestField("disable_location", value);
      return this;
    }
    public APIRequestGetNativeOffers requestDiscountsField () {
      return this.requestDiscountsField(true);
    }
    public APIRequestGetNativeOffers requestDiscountsField (boolean value) {
      this.requestField("discounts", value);
      return this;
    }
    public APIRequestGetNativeOffers requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGetNativeOffers requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
      return this;
    }
    public APIRequestGetNativeOffers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetNativeOffers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetNativeOffers requestInstoreCodeField () {
      return this.requestInstoreCodeField(true);
    }
    public APIRequestGetNativeOffers requestInstoreCodeField (boolean value) {
      this.requestField("instore_code", value);
      return this;
    }
    public APIRequestGetNativeOffers requestLocationTypeField () {
      return this.requestLocationTypeField(true);
    }
    public APIRequestGetNativeOffers requestLocationTypeField (boolean value) {
      this.requestField("location_type", value);
      return this;
    }
    public APIRequestGetNativeOffers requestMaxSaveCountField () {
      return this.requestMaxSaveCountField(true);
    }
    public APIRequestGetNativeOffers requestMaxSaveCountField (boolean value) {
      this.requestField("max_save_count", value);
      return this;
    }
    public APIRequestGetNativeOffers requestOnlineCodeField () {
      return this.requestOnlineCodeField(true);
    }
    public APIRequestGetNativeOffers requestOnlineCodeField (boolean value) {
      this.requestField("online_code", value);
      return this;
    }
    public APIRequestGetNativeOffers requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGetNativeOffers requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
    public APIRequestGetNativeOffers requestPageSetIdField () {
      return this.requestPageSetIdField(true);
    }
    public APIRequestGetNativeOffers requestPageSetIdField (boolean value) {
      this.requestField("page_set_id", value);
      return this;
    }
    public APIRequestGetNativeOffers requestRedemptionLinkField () {
      return this.requestRedemptionLinkField(true);
    }
    public APIRequestGetNativeOffers requestRedemptionLinkField (boolean value) {
      this.requestField("redemption_link", value);
      return this;
    }
    public APIRequestGetNativeOffers requestSaveCountField () {
      return this.requestSaveCountField(true);
    }
    public APIRequestGetNativeOffers requestSaveCountField (boolean value) {
      this.requestField("save_count", value);
      return this;
    }
    public APIRequestGetNativeOffers requestTermsField () {
      return this.requestTermsField(true);
    }
    public APIRequestGetNativeOffers requestTermsField (boolean value) {
      this.requestField("terms", value);
      return this;
    }
    public APIRequestGetNativeOffers requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetNativeOffers requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetNativeOffers requestTotalUniqueCodesField () {
      return this.requestTotalUniqueCodesField(true);
    }
    public APIRequestGetNativeOffers requestTotalUniqueCodesField (boolean value) {
      this.requestField("total_unique_codes", value);
      return this;
    }
    public APIRequestGetNativeOffers requestUniqueCodesField () {
      return this.requestUniqueCodesField(true);
    }
    public APIRequestGetNativeOffers requestUniqueCodesField (boolean value) {
      this.requestField("unique_codes", value);
      return this;
    }
    public APIRequestGetNativeOffers requestUniqueCodesFileCodeTypeField () {
      return this.requestUniqueCodesFileCodeTypeField(true);
    }
    public APIRequestGetNativeOffers requestUniqueCodesFileCodeTypeField (boolean value) {
      this.requestField("unique_codes_file_code_type", value);
      return this;
    }
    public APIRequestGetNativeOffers requestUniqueCodesFileNameField () {
      return this.requestUniqueCodesFileNameField(true);
    }
    public APIRequestGetNativeOffers requestUniqueCodesFileNameField (boolean value) {
      this.requestField("unique_codes_file_name", value);
      return this;
    }
    public APIRequestGetNativeOffers requestUniqueCodesFileUploadStatusField () {
      return this.requestUniqueCodesFileUploadStatusField(true);
    }
    public APIRequestGetNativeOffers requestUniqueCodesFileUploadStatusField (boolean value) {
      this.requestField("unique_codes_file_upload_status", value);
      return this;
    }
  }

  public static class APIRequestCreateNativeOffer extends APIRequest<NativeOffer> {

    NativeOffer lastResponse = null;
    @Override
    public NativeOffer getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "barcode_type",
      "barcode_value",
      "details",
      "disable_location",
      "discounts",
      "expiration_time",
      "instore_code",
      "location_type",
      "max_save_count",
      "online_code",
      "page_set_id",
      "redemption_link",
      "terms",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public NativeOffer parseResponse(String response) throws APIException {
      return NativeOffer.parseResponse(response, getContext(), this).head();
    }

    @Override
    public NativeOffer execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public NativeOffer execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<NativeOffer> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<NativeOffer> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, NativeOffer>() {
           public NativeOffer apply(String result) {
             try {
               return APIRequestCreateNativeOffer.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateNativeOffer(String nodeId, APIContext context) {
      super(context, nodeId, "/nativeoffers", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateNativeOffer setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateNativeOffer setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateNativeOffer setBarcodeType (NativeOffer.EnumBarcodeType barcodeType) {
      this.setParam("barcode_type", barcodeType);
      return this;
    }
    public APIRequestCreateNativeOffer setBarcodeType (String barcodeType) {
      this.setParam("barcode_type", barcodeType);
      return this;
    }

    public APIRequestCreateNativeOffer setBarcodeValue (String barcodeValue) {
      this.setParam("barcode_value", barcodeValue);
      return this;
    }

    public APIRequestCreateNativeOffer setDetails (String details) {
      this.setParam("details", details);
      return this;
    }

    public APIRequestCreateNativeOffer setDisableLocation (Boolean disableLocation) {
      this.setParam("disable_location", disableLocation);
      return this;
    }
    public APIRequestCreateNativeOffer setDisableLocation (String disableLocation) {
      this.setParam("disable_location", disableLocation);
      return this;
    }

    public APIRequestCreateNativeOffer setDiscounts (List<Object> discounts) {
      this.setParam("discounts", discounts);
      return this;
    }
    public APIRequestCreateNativeOffer setDiscounts (String discounts) {
      this.setParam("discounts", discounts);
      return this;
    }

    public APIRequestCreateNativeOffer setExpirationTime (String expirationTime) {
      this.setParam("expiration_time", expirationTime);
      return this;
    }

    public APIRequestCreateNativeOffer setInstoreCode (String instoreCode) {
      this.setParam("instore_code", instoreCode);
      return this;
    }

    public APIRequestCreateNativeOffer setLocationType (NativeOffer.EnumLocationType locationType) {
      this.setParam("location_type", locationType);
      return this;
    }
    public APIRequestCreateNativeOffer setLocationType (String locationType) {
      this.setParam("location_type", locationType);
      return this;
    }

    public APIRequestCreateNativeOffer setMaxSaveCount (Long maxSaveCount) {
      this.setParam("max_save_count", maxSaveCount);
      return this;
    }
    public APIRequestCreateNativeOffer setMaxSaveCount (String maxSaveCount) {
      this.setParam("max_save_count", maxSaveCount);
      return this;
    }

    public APIRequestCreateNativeOffer setOnlineCode (String onlineCode) {
      this.setParam("online_code", onlineCode);
      return this;
    }

    public APIRequestCreateNativeOffer setPageSetId (String pageSetId) {
      this.setParam("page_set_id", pageSetId);
      return this;
    }

    public APIRequestCreateNativeOffer setRedemptionLink (String redemptionLink) {
      this.setParam("redemption_link", redemptionLink);
      return this;
    }

    public APIRequestCreateNativeOffer setTerms (String terms) {
      this.setParam("terms", terms);
      return this;
    }

    public APIRequestCreateNativeOffer requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateNativeOffer requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateNativeOffer requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateNativeOffer requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateNativeOffer requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateNativeOffer requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateNlpConfig extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "custom_token",
      "model",
      "n_best",
      "nlp_enabled",
      "verbose",
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
               return APIRequestCreateNlpConfig.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateNlpConfig(String nodeId, APIContext context) {
      super(context, nodeId, "/nlp_configs", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateNlpConfig setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateNlpConfig setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateNlpConfig setCustomToken (String customToken) {
      this.setParam("custom_token", customToken);
      return this;
    }

    public APIRequestCreateNlpConfig setModel (EnumModel model) {
      this.setParam("model", model);
      return this;
    }
    public APIRequestCreateNlpConfig setModel (String model) {
      this.setParam("model", model);
      return this;
    }

    public APIRequestCreateNlpConfig setNBest (Long nBest) {
      this.setParam("n_best", nBest);
      return this;
    }
    public APIRequestCreateNlpConfig setNBest (String nBest) {
      this.setParam("n_best", nBest);
      return this;
    }

    public APIRequestCreateNlpConfig setNlpEnabled (Boolean nlpEnabled) {
      this.setParam("nlp_enabled", nlpEnabled);
      return this;
    }
    public APIRequestCreateNlpConfig setNlpEnabled (String nlpEnabled) {
      this.setParam("nlp_enabled", nlpEnabled);
      return this;
    }

    public APIRequestCreateNlpConfig setVerbose (Boolean verbose) {
      this.setParam("verbose", verbose);
      return this;
    }
    public APIRequestCreateNlpConfig setVerbose (String verbose) {
      this.setParam("verbose", verbose);
      return this;
    }

    public APIRequestCreateNlpConfig requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateNlpConfig requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateNlpConfig requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateNlpConfig requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateNlpConfig requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateNlpConfig requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreatePageBackedInstagramAccount extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
               return APIRequestCreatePageBackedInstagramAccount.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreatePageBackedInstagramAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/page_backed_instagram_accounts", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePageBackedInstagramAccount setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePageBackedInstagramAccount setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePageBackedInstagramAccount requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePageBackedInstagramAccount requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePageBackedInstagramAccount requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePageBackedInstagramAccount requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePageBackedInstagramAccount requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePageBackedInstagramAccount requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreatePassThreadControl extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "metadata",
      "recipient",
      "target_app_id",
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
               return APIRequestCreatePassThreadControl.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreatePassThreadControl(String nodeId, APIContext context) {
      super(context, nodeId, "/pass_thread_control", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePassThreadControl setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePassThreadControl setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePassThreadControl setMetadata (String metadata) {
      this.setParam("metadata", metadata);
      return this;
    }

    public APIRequestCreatePassThreadControl setRecipient (Object recipient) {
      this.setParam("recipient", recipient);
      return this;
    }
    public APIRequestCreatePassThreadControl setRecipient (String recipient) {
      this.setParam("recipient", recipient);
      return this;
    }

    public APIRequestCreatePassThreadControl setTargetAppId (Long targetAppId) {
      this.setParam("target_app_id", targetAppId);
      return this;
    }
    public APIRequestCreatePassThreadControl setTargetAppId (String targetAppId) {
      this.setParam("target_app_id", targetAppId);
      return this;
    }

    public APIRequestCreatePassThreadControl requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePassThreadControl requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePassThreadControl requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePassThreadControl requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePassThreadControl requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePassThreadControl requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPhotos extends APIRequest<Photo> {

    APINodeList<Photo> lastResponse = null;
    @Override
    public APINodeList<Photo> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "biz_tag_id",
      "business_id",
      "type",
    };

    public static final String[] FIELDS = {
      "album",
      "backdated_time",
      "backdated_time_granularity",
      "can_backdate",
      "can_delete",
      "can_tag",
      "created_time",
      "event",
      "from",
      "height",
      "icon",
      "id",
      "images",
      "link",
      "name",
      "name_tags",
      "page_story_id",
      "picture",
      "place",
      "position",
      "source",
      "target",
      "updated_time",
      "webp_images",
      "width",
    };

    @Override
    public APINodeList<Photo> parseResponse(String response) throws APIException {
      return Photo.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Photo> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Photo> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Photo>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Photo>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Photo>>() {
           public APINodeList<Photo> apply(String result) {
             try {
               return APIRequestGetPhotos.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPhotos(String nodeId, APIContext context) {
      super(context, nodeId, "/photos", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPhotos setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPhotos setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPhotos setBizTagId (Long bizTagId) {
      this.setParam("biz_tag_id", bizTagId);
      return this;
    }
    public APIRequestGetPhotos setBizTagId (String bizTagId) {
      this.setParam("biz_tag_id", bizTagId);
      return this;
    }

    public APIRequestGetPhotos setBusinessId (String businessId) {
      this.setParam("business_id", businessId);
      return this;
    }

    public APIRequestGetPhotos setType (Photo.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestGetPhotos setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestGetPhotos requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPhotos requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPhotos requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPhotos requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPhotos requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPhotos requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPhotos requestAlbumField () {
      return this.requestAlbumField(true);
    }
    public APIRequestGetPhotos requestAlbumField (boolean value) {
      this.requestField("album", value);
      return this;
    }
    public APIRequestGetPhotos requestBackdatedTimeField () {
      return this.requestBackdatedTimeField(true);
    }
    public APIRequestGetPhotos requestBackdatedTimeField (boolean value) {
      this.requestField("backdated_time", value);
      return this;
    }
    public APIRequestGetPhotos requestBackdatedTimeGranularityField () {
      return this.requestBackdatedTimeGranularityField(true);
    }
    public APIRequestGetPhotos requestBackdatedTimeGranularityField (boolean value) {
      this.requestField("backdated_time_granularity", value);
      return this;
    }
    public APIRequestGetPhotos requestCanBackdateField () {
      return this.requestCanBackdateField(true);
    }
    public APIRequestGetPhotos requestCanBackdateField (boolean value) {
      this.requestField("can_backdate", value);
      return this;
    }
    public APIRequestGetPhotos requestCanDeleteField () {
      return this.requestCanDeleteField(true);
    }
    public APIRequestGetPhotos requestCanDeleteField (boolean value) {
      this.requestField("can_delete", value);
      return this;
    }
    public APIRequestGetPhotos requestCanTagField () {
      return this.requestCanTagField(true);
    }
    public APIRequestGetPhotos requestCanTagField (boolean value) {
      this.requestField("can_tag", value);
      return this;
    }
    public APIRequestGetPhotos requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetPhotos requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetPhotos requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGetPhotos requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGetPhotos requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetPhotos requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetPhotos requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetPhotos requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetPhotos requestIconField () {
      return this.requestIconField(true);
    }
    public APIRequestGetPhotos requestIconField (boolean value) {
      this.requestField("icon", value);
      return this;
    }
    public APIRequestGetPhotos requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPhotos requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPhotos requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGetPhotos requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGetPhotos requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetPhotos requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetPhotos requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPhotos requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPhotos requestNameTagsField () {
      return this.requestNameTagsField(true);
    }
    public APIRequestGetPhotos requestNameTagsField (boolean value) {
      this.requestField("name_tags", value);
      return this;
    }
    public APIRequestGetPhotos requestPageStoryIdField () {
      return this.requestPageStoryIdField(true);
    }
    public APIRequestGetPhotos requestPageStoryIdField (boolean value) {
      this.requestField("page_story_id", value);
      return this;
    }
    public APIRequestGetPhotos requestPictureField () {
      return this.requestPictureField(true);
    }
    public APIRequestGetPhotos requestPictureField (boolean value) {
      this.requestField("picture", value);
      return this;
    }
    public APIRequestGetPhotos requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGetPhotos requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGetPhotos requestPositionField () {
      return this.requestPositionField(true);
    }
    public APIRequestGetPhotos requestPositionField (boolean value) {
      this.requestField("position", value);
      return this;
    }
    public APIRequestGetPhotos requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetPhotos requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetPhotos requestTargetField () {
      return this.requestTargetField(true);
    }
    public APIRequestGetPhotos requestTargetField (boolean value) {
      this.requestField("target", value);
      return this;
    }
    public APIRequestGetPhotos requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetPhotos requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetPhotos requestWebpImagesField () {
      return this.requestWebpImagesField(true);
    }
    public APIRequestGetPhotos requestWebpImagesField (boolean value) {
      this.requestField("webp_images", value);
      return this;
    }
    public APIRequestGetPhotos requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetPhotos requestWidthField (boolean value) {
      this.requestField("width", value);
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
      "attempt",
      "audience_exp",
      "backdated_time",
      "backdated_time_granularity",
      "caption",
      "composer_session_id",
      "direct_share_status",
      "feed_targeting",
      "filter_type",
      "full_res_is_coming_later",
      "initial_view_heading_override_degrees",
      "initial_view_pitch_override_degrees",
      "initial_view_vertical_fov_override_degrees",
      "is_explicit_location",
      "is_explicit_place",
      "location_source_id",
      "manual_privacy",
      "message",
      "name",
      "nectar_module",
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
      "temporary",
      "unpublished_content_type",
      "url",
      "vault_image_id",
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

    public APIRequestCreatePhoto setAttempt (Long attempt) {
      this.setParam("attempt", attempt);
      return this;
    }
    public APIRequestCreatePhoto setAttempt (String attempt) {
      this.setParam("attempt", attempt);
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

    public APIRequestCreatePhoto setFilterType (Long filterType) {
      this.setParam("filter_type", filterType);
      return this;
    }
    public APIRequestCreatePhoto setFilterType (String filterType) {
      this.setParam("filter_type", filterType);
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

    public APIRequestCreatePhoto setLocationSourceId (String locationSourceId) {
      this.setParam("location_source_id", locationSourceId);
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

    public APIRequestCreatePhoto setNectarModule (String nectarModule) {
      this.setParam("nectar_module", nectarModule);
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

    public APIRequestCreatePhoto setTemporary (Boolean temporary) {
      this.setParam("temporary", temporary);
      return this;
    }
    public APIRequestCreatePhoto setTemporary (String temporary) {
      this.setParam("temporary", temporary);
      return this;
    }

    public APIRequestCreatePhoto setUnpublishedContentType (Photo.EnumUnpublishedContentType unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }
    public APIRequestCreatePhoto setUnpublishedContentType (String unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }

    public APIRequestCreatePhoto setUrl (String url) {
      this.setParam("url", url);
      return this;
    }

    public APIRequestCreatePhoto setVaultImageId (String vaultImageId) {
      this.setParam("vault_image_id", vaultImageId);
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

  public static class APIRequestCreatePicture extends APIRequest<ProfilePictureSource> {

    ProfilePictureSource lastResponse = null;
    @Override
    public ProfilePictureSource getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "android_key_hash",
      "caption",
      "composer_session_id",
      "has_umg",
      "height",
      "ios_bundle_id",
      "media_effect_ids",
      "media_effect_source_object_id",
      "msqrd_mask_id",
      "photo",
      "picture",
      "profile_pic_method",
      "profile_pic_source",
      "proxied_app_id",
      "qn",
      "reuse",
      "scaled_crop_rect",
      "set_profile_photo_shield",
      "sticker_id",
      "sticker_source_object_id",
      "width",
      "x",
      "y",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProfilePictureSource parseResponse(String response) throws APIException {
      return ProfilePictureSource.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProfilePictureSource execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProfilePictureSource execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProfilePictureSource> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProfilePictureSource> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProfilePictureSource>() {
           public ProfilePictureSource apply(String result) {
             try {
               return APIRequestCreatePicture.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreatePicture(String nodeId, APIContext context) {
      super(context, nodeId, "/picture", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePicture setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePicture setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePicture setAndroidKeyHash (String androidKeyHash) {
      this.setParam("android_key_hash", androidKeyHash);
      return this;
    }

    public APIRequestCreatePicture setCaption (String caption) {
      this.setParam("caption", caption);
      return this;
    }

    public APIRequestCreatePicture setComposerSessionId (String composerSessionId) {
      this.setParam("composer_session_id", composerSessionId);
      return this;
    }

    public APIRequestCreatePicture setHasUmg (Boolean hasUmg) {
      this.setParam("has_umg", hasUmg);
      return this;
    }
    public APIRequestCreatePicture setHasUmg (String hasUmg) {
      this.setParam("has_umg", hasUmg);
      return this;
    }

    public APIRequestCreatePicture setHeight (Long height) {
      this.setParam("height", height);
      return this;
    }
    public APIRequestCreatePicture setHeight (String height) {
      this.setParam("height", height);
      return this;
    }

    public APIRequestCreatePicture setIosBundleId (String iosBundleId) {
      this.setParam("ios_bundle_id", iosBundleId);
      return this;
    }

    public APIRequestCreatePicture setMediaEffectIds (List<Long> mediaEffectIds) {
      this.setParam("media_effect_ids", mediaEffectIds);
      return this;
    }
    public APIRequestCreatePicture setMediaEffectIds (String mediaEffectIds) {
      this.setParam("media_effect_ids", mediaEffectIds);
      return this;
    }

    public APIRequestCreatePicture setMediaEffectSourceObjectId (Long mediaEffectSourceObjectId) {
      this.setParam("media_effect_source_object_id", mediaEffectSourceObjectId);
      return this;
    }
    public APIRequestCreatePicture setMediaEffectSourceObjectId (String mediaEffectSourceObjectId) {
      this.setParam("media_effect_source_object_id", mediaEffectSourceObjectId);
      return this;
    }

    public APIRequestCreatePicture setMsqrdMaskId (String msqrdMaskId) {
      this.setParam("msqrd_mask_id", msqrdMaskId);
      return this;
    }

    public APIRequestCreatePicture setPhoto (String photo) {
      this.setParam("photo", photo);
      return this;
    }

    public APIRequestCreatePicture setPicture (String picture) {
      this.setParam("picture", picture);
      return this;
    }

    public APIRequestCreatePicture setProfilePicMethod (String profilePicMethod) {
      this.setParam("profile_pic_method", profilePicMethod);
      return this;
    }

    public APIRequestCreatePicture setProfilePicSource (String profilePicSource) {
      this.setParam("profile_pic_source", profilePicSource);
      return this;
    }

    public APIRequestCreatePicture setProxiedAppId (Long proxiedAppId) {
      this.setParam("proxied_app_id", proxiedAppId);
      return this;
    }
    public APIRequestCreatePicture setProxiedAppId (String proxiedAppId) {
      this.setParam("proxied_app_id", proxiedAppId);
      return this;
    }

    public APIRequestCreatePicture setQn (String qn) {
      this.setParam("qn", qn);
      return this;
    }

    public APIRequestCreatePicture setReuse (Boolean reuse) {
      this.setParam("reuse", reuse);
      return this;
    }
    public APIRequestCreatePicture setReuse (String reuse) {
      this.setParam("reuse", reuse);
      return this;
    }

    public APIRequestCreatePicture setScaledCropRect (Object scaledCropRect) {
      this.setParam("scaled_crop_rect", scaledCropRect);
      return this;
    }
    public APIRequestCreatePicture setScaledCropRect (String scaledCropRect) {
      this.setParam("scaled_crop_rect", scaledCropRect);
      return this;
    }

    public APIRequestCreatePicture setSetProfilePhotoShield (String setProfilePhotoShield) {
      this.setParam("set_profile_photo_shield", setProfilePhotoShield);
      return this;
    }

    public APIRequestCreatePicture setStickerId (Long stickerId) {
      this.setParam("sticker_id", stickerId);
      return this;
    }
    public APIRequestCreatePicture setStickerId (String stickerId) {
      this.setParam("sticker_id", stickerId);
      return this;
    }

    public APIRequestCreatePicture setStickerSourceObjectId (Long stickerSourceObjectId) {
      this.setParam("sticker_source_object_id", stickerSourceObjectId);
      return this;
    }
    public APIRequestCreatePicture setStickerSourceObjectId (String stickerSourceObjectId) {
      this.setParam("sticker_source_object_id", stickerSourceObjectId);
      return this;
    }

    public APIRequestCreatePicture setWidth (Long width) {
      this.setParam("width", width);
      return this;
    }
    public APIRequestCreatePicture setWidth (String width) {
      this.setParam("width", width);
      return this;
    }

    public APIRequestCreatePicture setX (Long x) {
      this.setParam("x", x);
      return this;
    }
    public APIRequestCreatePicture setX (String x) {
      this.setParam("x", x);
      return this;
    }

    public APIRequestCreatePicture setY (Long y) {
      this.setParam("y", y);
      return this;
    }
    public APIRequestCreatePicture setY (String y) {
      this.setParam("y", y);
      return this;
    }

    public APIRequestCreatePicture requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePicture requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePicture requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePicture requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePicture requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePicture requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPlaceTopics extends APIRequest<PlaceTopic> {

    APINodeList<PlaceTopic> lastResponse = null;
    @Override
    public APINodeList<PlaceTopic> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "count",
      "has_children",
      "icon_url",
      "id",
      "name",
      "parent_ids",
      "plural_name",
      "top_subtopic_names",
    };

    @Override
    public APINodeList<PlaceTopic> parseResponse(String response) throws APIException {
      return PlaceTopic.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<PlaceTopic> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<PlaceTopic> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<PlaceTopic>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<PlaceTopic>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<PlaceTopic>>() {
           public APINodeList<PlaceTopic> apply(String result) {
             try {
               return APIRequestGetPlaceTopics.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPlaceTopics(String nodeId, APIContext context) {
      super(context, nodeId, "/place_topics", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPlaceTopics setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPlaceTopics setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPlaceTopics requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPlaceTopics requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPlaceTopics requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPlaceTopics requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPlaceTopics requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPlaceTopics requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPlaceTopics requestCountField () {
      return this.requestCountField(true);
    }
    public APIRequestGetPlaceTopics requestCountField (boolean value) {
      this.requestField("count", value);
      return this;
    }
    public APIRequestGetPlaceTopics requestHasChildrenField () {
      return this.requestHasChildrenField(true);
    }
    public APIRequestGetPlaceTopics requestHasChildrenField (boolean value) {
      this.requestField("has_children", value);
      return this;
    }
    public APIRequestGetPlaceTopics requestIconUrlField () {
      return this.requestIconUrlField(true);
    }
    public APIRequestGetPlaceTopics requestIconUrlField (boolean value) {
      this.requestField("icon_url", value);
      return this;
    }
    public APIRequestGetPlaceTopics requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPlaceTopics requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPlaceTopics requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPlaceTopics requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPlaceTopics requestParentIdsField () {
      return this.requestParentIdsField(true);
    }
    public APIRequestGetPlaceTopics requestParentIdsField (boolean value) {
      this.requestField("parent_ids", value);
      return this;
    }
    public APIRequestGetPlaceTopics requestPluralNameField () {
      return this.requestPluralNameField(true);
    }
    public APIRequestGetPlaceTopics requestPluralNameField (boolean value) {
      this.requestField("plural_name", value);
      return this;
    }
    public APIRequestGetPlaceTopics requestTopSubtopicNamesField () {
      return this.requestTopSubtopicNamesField(true);
    }
    public APIRequestGetPlaceTopics requestTopSubtopicNamesField (boolean value) {
      this.requestField("top_subtopic_names", value);
      return this;
    }
  }

  public static class APIRequestGetPosts extends APIRequest<PagePost> {

    APINodeList<PagePost> lastResponse = null;
    @Override
    public APINodeList<PagePost> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "include_hidden",
      "q",
      "show_expired",
      "with",
    };

    public static final String[] FIELDS = {
      "actions",
      "admin_creator",
      "allowed_advertising_objectives",
      "application",
      "backdated_time",
      "call_to_action",
      "can_reply_privately",
      "caption",
      "child_attachments",
      "comments_mirroring_domain",
      "coordinates",
      "created_time",
      "description",
      "event",
      "expanded_height",
      "expanded_width",
      "feed_targeting",
      "from",
      "full_picture",
      "height",
      "icon",
      "id",
      "instagram_eligibility",
      "is_app_share",
      "is_expired",
      "is_hidden",
      "is_instagram_eligible",
      "is_popular",
      "is_published",
      "is_spherical",
      "link",
      "message",
      "message_tags",
      "multi_share_end_card",
      "multi_share_optimized",
      "name",
      "object_id",
      "parent_id",
      "permalink_url",
      "picture",
      "place",
      "privacy",
      "promotable_id",
      "promotion_status",
      "properties",
      "scheduled_publish_time",
      "shares",
      "source",
      "status_type",
      "story",
      "story_tags",
      "subscribed",
      "target",
      "targeting",
      "timeline_visibility",
      "type",
      "updated_time",
      "via",
      "video_buying_eligibility",
      "width",
    };

    @Override
    public APINodeList<PagePost> parseResponse(String response) throws APIException {
      return PagePost.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<PagePost> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<PagePost> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<PagePost>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<PagePost>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<PagePost>>() {
           public APINodeList<PagePost> apply(String result) {
             try {
               return APIRequestGetPosts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPosts(String nodeId, APIContext context) {
      super(context, nodeId, "/posts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPosts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPosts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPosts setIncludeHidden (Boolean includeHidden) {
      this.setParam("include_hidden", includeHidden);
      return this;
    }
    public APIRequestGetPosts setIncludeHidden (String includeHidden) {
      this.setParam("include_hidden", includeHidden);
      return this;
    }

    public APIRequestGetPosts setQ (String q) {
      this.setParam("q", q);
      return this;
    }

    public APIRequestGetPosts setShowExpired (Boolean showExpired) {
      this.setParam("show_expired", showExpired);
      return this;
    }
    public APIRequestGetPosts setShowExpired (String showExpired) {
      this.setParam("show_expired", showExpired);
      return this;
    }

    public APIRequestGetPosts setWith (PagePost.EnumWith with) {
      this.setParam("with", with);
      return this;
    }
    public APIRequestGetPosts setWith (String with) {
      this.setParam("with", with);
      return this;
    }

    public APIRequestGetPosts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPosts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPosts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPosts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPosts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPosts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPosts requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGetPosts requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGetPosts requestAdminCreatorField () {
      return this.requestAdminCreatorField(true);
    }
    public APIRequestGetPosts requestAdminCreatorField (boolean value) {
      this.requestField("admin_creator", value);
      return this;
    }
    public APIRequestGetPosts requestAllowedAdvertisingObjectivesField () {
      return this.requestAllowedAdvertisingObjectivesField(true);
    }
    public APIRequestGetPosts requestAllowedAdvertisingObjectivesField (boolean value) {
      this.requestField("allowed_advertising_objectives", value);
      return this;
    }
    public APIRequestGetPosts requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGetPosts requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGetPosts requestBackdatedTimeField () {
      return this.requestBackdatedTimeField(true);
    }
    public APIRequestGetPosts requestBackdatedTimeField (boolean value) {
      this.requestField("backdated_time", value);
      return this;
    }
    public APIRequestGetPosts requestCallToActionField () {
      return this.requestCallToActionField(true);
    }
    public APIRequestGetPosts requestCallToActionField (boolean value) {
      this.requestField("call_to_action", value);
      return this;
    }
    public APIRequestGetPosts requestCanReplyPrivatelyField () {
      return this.requestCanReplyPrivatelyField(true);
    }
    public APIRequestGetPosts requestCanReplyPrivatelyField (boolean value) {
      this.requestField("can_reply_privately", value);
      return this;
    }
    public APIRequestGetPosts requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetPosts requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetPosts requestChildAttachmentsField () {
      return this.requestChildAttachmentsField(true);
    }
    public APIRequestGetPosts requestChildAttachmentsField (boolean value) {
      this.requestField("child_attachments", value);
      return this;
    }
    public APIRequestGetPosts requestCommentsMirroringDomainField () {
      return this.requestCommentsMirroringDomainField(true);
    }
    public APIRequestGetPosts requestCommentsMirroringDomainField (boolean value) {
      this.requestField("comments_mirroring_domain", value);
      return this;
    }
    public APIRequestGetPosts requestCoordinatesField () {
      return this.requestCoordinatesField(true);
    }
    public APIRequestGetPosts requestCoordinatesField (boolean value) {
      this.requestField("coordinates", value);
      return this;
    }
    public APIRequestGetPosts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetPosts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetPosts requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetPosts requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetPosts requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGetPosts requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGetPosts requestExpandedHeightField () {
      return this.requestExpandedHeightField(true);
    }
    public APIRequestGetPosts requestExpandedHeightField (boolean value) {
      this.requestField("expanded_height", value);
      return this;
    }
    public APIRequestGetPosts requestExpandedWidthField () {
      return this.requestExpandedWidthField(true);
    }
    public APIRequestGetPosts requestExpandedWidthField (boolean value) {
      this.requestField("expanded_width", value);
      return this;
    }
    public APIRequestGetPosts requestFeedTargetingField () {
      return this.requestFeedTargetingField(true);
    }
    public APIRequestGetPosts requestFeedTargetingField (boolean value) {
      this.requestField("feed_targeting", value);
      return this;
    }
    public APIRequestGetPosts requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetPosts requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetPosts requestFullPictureField () {
      return this.requestFullPictureField(true);
    }
    public APIRequestGetPosts requestFullPictureField (boolean value) {
      this.requestField("full_picture", value);
      return this;
    }
    public APIRequestGetPosts requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetPosts requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetPosts requestIconField () {
      return this.requestIconField(true);
    }
    public APIRequestGetPosts requestIconField (boolean value) {
      this.requestField("icon", value);
      return this;
    }
    public APIRequestGetPosts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPosts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPosts requestInstagramEligibilityField () {
      return this.requestInstagramEligibilityField(true);
    }
    public APIRequestGetPosts requestInstagramEligibilityField (boolean value) {
      this.requestField("instagram_eligibility", value);
      return this;
    }
    public APIRequestGetPosts requestIsAppShareField () {
      return this.requestIsAppShareField(true);
    }
    public APIRequestGetPosts requestIsAppShareField (boolean value) {
      this.requestField("is_app_share", value);
      return this;
    }
    public APIRequestGetPosts requestIsExpiredField () {
      return this.requestIsExpiredField(true);
    }
    public APIRequestGetPosts requestIsExpiredField (boolean value) {
      this.requestField("is_expired", value);
      return this;
    }
    public APIRequestGetPosts requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetPosts requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetPosts requestIsInstagramEligibleField () {
      return this.requestIsInstagramEligibleField(true);
    }
    public APIRequestGetPosts requestIsInstagramEligibleField (boolean value) {
      this.requestField("is_instagram_eligible", value);
      return this;
    }
    public APIRequestGetPosts requestIsPopularField () {
      return this.requestIsPopularField(true);
    }
    public APIRequestGetPosts requestIsPopularField (boolean value) {
      this.requestField("is_popular", value);
      return this;
    }
    public APIRequestGetPosts requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetPosts requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetPosts requestIsSphericalField () {
      return this.requestIsSphericalField(true);
    }
    public APIRequestGetPosts requestIsSphericalField (boolean value) {
      this.requestField("is_spherical", value);
      return this;
    }
    public APIRequestGetPosts requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetPosts requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetPosts requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGetPosts requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGetPosts requestMessageTagsField () {
      return this.requestMessageTagsField(true);
    }
    public APIRequestGetPosts requestMessageTagsField (boolean value) {
      this.requestField("message_tags", value);
      return this;
    }
    public APIRequestGetPosts requestMultiShareEndCardField () {
      return this.requestMultiShareEndCardField(true);
    }
    public APIRequestGetPosts requestMultiShareEndCardField (boolean value) {
      this.requestField("multi_share_end_card", value);
      return this;
    }
    public APIRequestGetPosts requestMultiShareOptimizedField () {
      return this.requestMultiShareOptimizedField(true);
    }
    public APIRequestGetPosts requestMultiShareOptimizedField (boolean value) {
      this.requestField("multi_share_optimized", value);
      return this;
    }
    public APIRequestGetPosts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPosts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPosts requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetPosts requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetPosts requestParentIdField () {
      return this.requestParentIdField(true);
    }
    public APIRequestGetPosts requestParentIdField (boolean value) {
      this.requestField("parent_id", value);
      return this;
    }
    public APIRequestGetPosts requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGetPosts requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGetPosts requestPictureField () {
      return this.requestPictureField(true);
    }
    public APIRequestGetPosts requestPictureField (boolean value) {
      this.requestField("picture", value);
      return this;
    }
    public APIRequestGetPosts requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGetPosts requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGetPosts requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGetPosts requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
      return this;
    }
    public APIRequestGetPosts requestPromotableIdField () {
      return this.requestPromotableIdField(true);
    }
    public APIRequestGetPosts requestPromotableIdField (boolean value) {
      this.requestField("promotable_id", value);
      return this;
    }
    public APIRequestGetPosts requestPromotionStatusField () {
      return this.requestPromotionStatusField(true);
    }
    public APIRequestGetPosts requestPromotionStatusField (boolean value) {
      this.requestField("promotion_status", value);
      return this;
    }
    public APIRequestGetPosts requestPropertiesField () {
      return this.requestPropertiesField(true);
    }
    public APIRequestGetPosts requestPropertiesField (boolean value) {
      this.requestField("properties", value);
      return this;
    }
    public APIRequestGetPosts requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGetPosts requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
      return this;
    }
    public APIRequestGetPosts requestSharesField () {
      return this.requestSharesField(true);
    }
    public APIRequestGetPosts requestSharesField (boolean value) {
      this.requestField("shares", value);
      return this;
    }
    public APIRequestGetPosts requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetPosts requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetPosts requestStatusTypeField () {
      return this.requestStatusTypeField(true);
    }
    public APIRequestGetPosts requestStatusTypeField (boolean value) {
      this.requestField("status_type", value);
      return this;
    }
    public APIRequestGetPosts requestStoryField () {
      return this.requestStoryField(true);
    }
    public APIRequestGetPosts requestStoryField (boolean value) {
      this.requestField("story", value);
      return this;
    }
    public APIRequestGetPosts requestStoryTagsField () {
      return this.requestStoryTagsField(true);
    }
    public APIRequestGetPosts requestStoryTagsField (boolean value) {
      this.requestField("story_tags", value);
      return this;
    }
    public APIRequestGetPosts requestSubscribedField () {
      return this.requestSubscribedField(true);
    }
    public APIRequestGetPosts requestSubscribedField (boolean value) {
      this.requestField("subscribed", value);
      return this;
    }
    public APIRequestGetPosts requestTargetField () {
      return this.requestTargetField(true);
    }
    public APIRequestGetPosts requestTargetField (boolean value) {
      this.requestField("target", value);
      return this;
    }
    public APIRequestGetPosts requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetPosts requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetPosts requestTimelineVisibilityField () {
      return this.requestTimelineVisibilityField(true);
    }
    public APIRequestGetPosts requestTimelineVisibilityField (boolean value) {
      this.requestField("timeline_visibility", value);
      return this;
    }
    public APIRequestGetPosts requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetPosts requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetPosts requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetPosts requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetPosts requestViaField () {
      return this.requestViaField(true);
    }
    public APIRequestGetPosts requestViaField (boolean value) {
      this.requestField("via", value);
      return this;
    }
    public APIRequestGetPosts requestVideoBuyingEligibilityField () {
      return this.requestVideoBuyingEligibilityField(true);
    }
    public APIRequestGetPosts requestVideoBuyingEligibilityField (boolean value) {
      this.requestField("video_buying_eligibility", value);
      return this;
    }
    public APIRequestGetPosts requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetPosts requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
  }

  public static class APIRequestGetProductCatalogs extends APIRequest<ProductCatalog> {

    APINodeList<ProductCatalog> lastResponse = null;
    @Override
    public APINodeList<ProductCatalog> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "da_display_settings",
      "default_image_url",
      "fallback_image_url",
      "feed_count",
      "flight_catalog_settings",
      "id",
      "name",
      "product_count",
      "qualified_product_count",
      "vertical",
    };

    @Override
    public APINodeList<ProductCatalog> parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ProductCatalog> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductCatalog> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductCatalog>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductCatalog>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ProductCatalog>>() {
           public APINodeList<ProductCatalog> apply(String result) {
             try {
               return APIRequestGetProductCatalogs.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetProductCatalogs(String nodeId, APIContext context) {
      super(context, nodeId, "/product_catalogs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetProductCatalogs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetProductCatalogs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProductCatalogs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProductCatalogs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductCatalogs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetProductCatalogs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductCatalogs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetProductCatalogs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetProductCatalogs requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetProductCatalogs requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestDaDisplaySettingsField () {
      return this.requestDaDisplaySettingsField(true);
    }
    public APIRequestGetProductCatalogs requestDaDisplaySettingsField (boolean value) {
      this.requestField("da_display_settings", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestDefaultImageUrlField () {
      return this.requestDefaultImageUrlField(true);
    }
    public APIRequestGetProductCatalogs requestDefaultImageUrlField (boolean value) {
      this.requestField("default_image_url", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestFallbackImageUrlField () {
      return this.requestFallbackImageUrlField(true);
    }
    public APIRequestGetProductCatalogs requestFallbackImageUrlField (boolean value) {
      this.requestField("fallback_image_url", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestFeedCountField () {
      return this.requestFeedCountField(true);
    }
    public APIRequestGetProductCatalogs requestFeedCountField (boolean value) {
      this.requestField("feed_count", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestFlightCatalogSettingsField () {
      return this.requestFlightCatalogSettingsField(true);
    }
    public APIRequestGetProductCatalogs requestFlightCatalogSettingsField (boolean value) {
      this.requestField("flight_catalog_settings", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetProductCatalogs requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetProductCatalogs requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGetProductCatalogs requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestQualifiedProductCountField () {
      return this.requestQualifiedProductCountField(true);
    }
    public APIRequestGetProductCatalogs requestQualifiedProductCountField (boolean value) {
      this.requestField("qualified_product_count", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetProductCatalogs requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
  }

  public static class APIRequestGetPromotablePosts extends APIRequest<PagePost> {

    APINodeList<PagePost> lastResponse = null;
    @Override
    public APINodeList<PagePost> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "include_hidden",
      "include_inline",
      "is_published",
      "q",
      "show_expired",
      "with",
    };

    public static final String[] FIELDS = {
      "actions",
      "admin_creator",
      "allowed_advertising_objectives",
      "application",
      "backdated_time",
      "call_to_action",
      "can_reply_privately",
      "caption",
      "child_attachments",
      "comments_mirroring_domain",
      "coordinates",
      "created_time",
      "description",
      "event",
      "expanded_height",
      "expanded_width",
      "feed_targeting",
      "from",
      "full_picture",
      "height",
      "icon",
      "id",
      "instagram_eligibility",
      "is_app_share",
      "is_expired",
      "is_hidden",
      "is_instagram_eligible",
      "is_popular",
      "is_published",
      "is_spherical",
      "link",
      "message",
      "message_tags",
      "multi_share_end_card",
      "multi_share_optimized",
      "name",
      "object_id",
      "parent_id",
      "permalink_url",
      "picture",
      "place",
      "privacy",
      "promotable_id",
      "promotion_status",
      "properties",
      "scheduled_publish_time",
      "shares",
      "source",
      "status_type",
      "story",
      "story_tags",
      "subscribed",
      "target",
      "targeting",
      "timeline_visibility",
      "type",
      "updated_time",
      "via",
      "video_buying_eligibility",
      "width",
    };

    @Override
    public APINodeList<PagePost> parseResponse(String response) throws APIException {
      return PagePost.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<PagePost> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<PagePost> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<PagePost>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<PagePost>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<PagePost>>() {
           public APINodeList<PagePost> apply(String result) {
             try {
               return APIRequestGetPromotablePosts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPromotablePosts(String nodeId, APIContext context) {
      super(context, nodeId, "/promotable_posts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPromotablePosts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPromotablePosts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPromotablePosts setIncludeHidden (Boolean includeHidden) {
      this.setParam("include_hidden", includeHidden);
      return this;
    }
    public APIRequestGetPromotablePosts setIncludeHidden (String includeHidden) {
      this.setParam("include_hidden", includeHidden);
      return this;
    }

    public APIRequestGetPromotablePosts setIncludeInline (Boolean includeInline) {
      this.setParam("include_inline", includeInline);
      return this;
    }
    public APIRequestGetPromotablePosts setIncludeInline (String includeInline) {
      this.setParam("include_inline", includeInline);
      return this;
    }

    public APIRequestGetPromotablePosts setIsPublished (Boolean isPublished) {
      this.setParam("is_published", isPublished);
      return this;
    }
    public APIRequestGetPromotablePosts setIsPublished (String isPublished) {
      this.setParam("is_published", isPublished);
      return this;
    }

    public APIRequestGetPromotablePosts setQ (String q) {
      this.setParam("q", q);
      return this;
    }

    public APIRequestGetPromotablePosts setShowExpired (Boolean showExpired) {
      this.setParam("show_expired", showExpired);
      return this;
    }
    public APIRequestGetPromotablePosts setShowExpired (String showExpired) {
      this.setParam("show_expired", showExpired);
      return this;
    }

    public APIRequestGetPromotablePosts setWith (PagePost.EnumWith with) {
      this.setParam("with", with);
      return this;
    }
    public APIRequestGetPromotablePosts setWith (String with) {
      this.setParam("with", with);
      return this;
    }

    public APIRequestGetPromotablePosts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPromotablePosts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPromotablePosts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPromotablePosts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPromotablePosts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPromotablePosts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPromotablePosts requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGetPromotablePosts requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestAdminCreatorField () {
      return this.requestAdminCreatorField(true);
    }
    public APIRequestGetPromotablePosts requestAdminCreatorField (boolean value) {
      this.requestField("admin_creator", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestAllowedAdvertisingObjectivesField () {
      return this.requestAllowedAdvertisingObjectivesField(true);
    }
    public APIRequestGetPromotablePosts requestAllowedAdvertisingObjectivesField (boolean value) {
      this.requestField("allowed_advertising_objectives", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGetPromotablePosts requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestBackdatedTimeField () {
      return this.requestBackdatedTimeField(true);
    }
    public APIRequestGetPromotablePosts requestBackdatedTimeField (boolean value) {
      this.requestField("backdated_time", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestCallToActionField () {
      return this.requestCallToActionField(true);
    }
    public APIRequestGetPromotablePosts requestCallToActionField (boolean value) {
      this.requestField("call_to_action", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestCanReplyPrivatelyField () {
      return this.requestCanReplyPrivatelyField(true);
    }
    public APIRequestGetPromotablePosts requestCanReplyPrivatelyField (boolean value) {
      this.requestField("can_reply_privately", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetPromotablePosts requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestChildAttachmentsField () {
      return this.requestChildAttachmentsField(true);
    }
    public APIRequestGetPromotablePosts requestChildAttachmentsField (boolean value) {
      this.requestField("child_attachments", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestCommentsMirroringDomainField () {
      return this.requestCommentsMirroringDomainField(true);
    }
    public APIRequestGetPromotablePosts requestCommentsMirroringDomainField (boolean value) {
      this.requestField("comments_mirroring_domain", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestCoordinatesField () {
      return this.requestCoordinatesField(true);
    }
    public APIRequestGetPromotablePosts requestCoordinatesField (boolean value) {
      this.requestField("coordinates", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetPromotablePosts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetPromotablePosts requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGetPromotablePosts requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestExpandedHeightField () {
      return this.requestExpandedHeightField(true);
    }
    public APIRequestGetPromotablePosts requestExpandedHeightField (boolean value) {
      this.requestField("expanded_height", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestExpandedWidthField () {
      return this.requestExpandedWidthField(true);
    }
    public APIRequestGetPromotablePosts requestExpandedWidthField (boolean value) {
      this.requestField("expanded_width", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestFeedTargetingField () {
      return this.requestFeedTargetingField(true);
    }
    public APIRequestGetPromotablePosts requestFeedTargetingField (boolean value) {
      this.requestField("feed_targeting", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetPromotablePosts requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestFullPictureField () {
      return this.requestFullPictureField(true);
    }
    public APIRequestGetPromotablePosts requestFullPictureField (boolean value) {
      this.requestField("full_picture", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetPromotablePosts requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestIconField () {
      return this.requestIconField(true);
    }
    public APIRequestGetPromotablePosts requestIconField (boolean value) {
      this.requestField("icon", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPromotablePosts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestInstagramEligibilityField () {
      return this.requestInstagramEligibilityField(true);
    }
    public APIRequestGetPromotablePosts requestInstagramEligibilityField (boolean value) {
      this.requestField("instagram_eligibility", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestIsAppShareField () {
      return this.requestIsAppShareField(true);
    }
    public APIRequestGetPromotablePosts requestIsAppShareField (boolean value) {
      this.requestField("is_app_share", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestIsExpiredField () {
      return this.requestIsExpiredField(true);
    }
    public APIRequestGetPromotablePosts requestIsExpiredField (boolean value) {
      this.requestField("is_expired", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetPromotablePosts requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestIsInstagramEligibleField () {
      return this.requestIsInstagramEligibleField(true);
    }
    public APIRequestGetPromotablePosts requestIsInstagramEligibleField (boolean value) {
      this.requestField("is_instagram_eligible", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestIsPopularField () {
      return this.requestIsPopularField(true);
    }
    public APIRequestGetPromotablePosts requestIsPopularField (boolean value) {
      this.requestField("is_popular", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetPromotablePosts requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestIsSphericalField () {
      return this.requestIsSphericalField(true);
    }
    public APIRequestGetPromotablePosts requestIsSphericalField (boolean value) {
      this.requestField("is_spherical", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetPromotablePosts requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGetPromotablePosts requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestMessageTagsField () {
      return this.requestMessageTagsField(true);
    }
    public APIRequestGetPromotablePosts requestMessageTagsField (boolean value) {
      this.requestField("message_tags", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestMultiShareEndCardField () {
      return this.requestMultiShareEndCardField(true);
    }
    public APIRequestGetPromotablePosts requestMultiShareEndCardField (boolean value) {
      this.requestField("multi_share_end_card", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestMultiShareOptimizedField () {
      return this.requestMultiShareOptimizedField(true);
    }
    public APIRequestGetPromotablePosts requestMultiShareOptimizedField (boolean value) {
      this.requestField("multi_share_optimized", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPromotablePosts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetPromotablePosts requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestParentIdField () {
      return this.requestParentIdField(true);
    }
    public APIRequestGetPromotablePosts requestParentIdField (boolean value) {
      this.requestField("parent_id", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGetPromotablePosts requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestPictureField () {
      return this.requestPictureField(true);
    }
    public APIRequestGetPromotablePosts requestPictureField (boolean value) {
      this.requestField("picture", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGetPromotablePosts requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGetPromotablePosts requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestPromotableIdField () {
      return this.requestPromotableIdField(true);
    }
    public APIRequestGetPromotablePosts requestPromotableIdField (boolean value) {
      this.requestField("promotable_id", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestPromotionStatusField () {
      return this.requestPromotionStatusField(true);
    }
    public APIRequestGetPromotablePosts requestPromotionStatusField (boolean value) {
      this.requestField("promotion_status", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestPropertiesField () {
      return this.requestPropertiesField(true);
    }
    public APIRequestGetPromotablePosts requestPropertiesField (boolean value) {
      this.requestField("properties", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGetPromotablePosts requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestSharesField () {
      return this.requestSharesField(true);
    }
    public APIRequestGetPromotablePosts requestSharesField (boolean value) {
      this.requestField("shares", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetPromotablePosts requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestStatusTypeField () {
      return this.requestStatusTypeField(true);
    }
    public APIRequestGetPromotablePosts requestStatusTypeField (boolean value) {
      this.requestField("status_type", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestStoryField () {
      return this.requestStoryField(true);
    }
    public APIRequestGetPromotablePosts requestStoryField (boolean value) {
      this.requestField("story", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestStoryTagsField () {
      return this.requestStoryTagsField(true);
    }
    public APIRequestGetPromotablePosts requestStoryTagsField (boolean value) {
      this.requestField("story_tags", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestSubscribedField () {
      return this.requestSubscribedField(true);
    }
    public APIRequestGetPromotablePosts requestSubscribedField (boolean value) {
      this.requestField("subscribed", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestTargetField () {
      return this.requestTargetField(true);
    }
    public APIRequestGetPromotablePosts requestTargetField (boolean value) {
      this.requestField("target", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetPromotablePosts requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestTimelineVisibilityField () {
      return this.requestTimelineVisibilityField(true);
    }
    public APIRequestGetPromotablePosts requestTimelineVisibilityField (boolean value) {
      this.requestField("timeline_visibility", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetPromotablePosts requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetPromotablePosts requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestViaField () {
      return this.requestViaField(true);
    }
    public APIRequestGetPromotablePosts requestViaField (boolean value) {
      this.requestField("via", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestVideoBuyingEligibilityField () {
      return this.requestVideoBuyingEligibilityField(true);
    }
    public APIRequestGetPromotablePosts requestVideoBuyingEligibilityField (boolean value) {
      this.requestField("video_buying_eligibility", value);
      return this;
    }
    public APIRequestGetPromotablePosts requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetPromotablePosts requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
  }

  public static class APIRequestGetPublishedPosts extends APIRequest<PagePost> {

    APINodeList<PagePost> lastResponse = null;
    @Override
    public APINodeList<PagePost> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "since",
      "until",
    };

    public static final String[] FIELDS = {
      "actions",
      "admin_creator",
      "allowed_advertising_objectives",
      "application",
      "backdated_time",
      "call_to_action",
      "can_reply_privately",
      "caption",
      "child_attachments",
      "comments_mirroring_domain",
      "coordinates",
      "created_time",
      "description",
      "event",
      "expanded_height",
      "expanded_width",
      "feed_targeting",
      "from",
      "full_picture",
      "height",
      "icon",
      "id",
      "instagram_eligibility",
      "is_app_share",
      "is_expired",
      "is_hidden",
      "is_instagram_eligible",
      "is_popular",
      "is_published",
      "is_spherical",
      "link",
      "message",
      "message_tags",
      "multi_share_end_card",
      "multi_share_optimized",
      "name",
      "object_id",
      "parent_id",
      "permalink_url",
      "picture",
      "place",
      "privacy",
      "promotable_id",
      "promotion_status",
      "properties",
      "scheduled_publish_time",
      "shares",
      "source",
      "status_type",
      "story",
      "story_tags",
      "subscribed",
      "target",
      "targeting",
      "timeline_visibility",
      "type",
      "updated_time",
      "via",
      "video_buying_eligibility",
      "width",
    };

    @Override
    public APINodeList<PagePost> parseResponse(String response) throws APIException {
      return PagePost.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<PagePost> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<PagePost> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<PagePost>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<PagePost>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<PagePost>>() {
           public APINodeList<PagePost> apply(String result) {
             try {
               return APIRequestGetPublishedPosts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPublishedPosts(String nodeId, APIContext context) {
      super(context, nodeId, "/published_posts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPublishedPosts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPublishedPosts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPublishedPosts setSince (Object since) {
      this.setParam("since", since);
      return this;
    }
    public APIRequestGetPublishedPosts setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetPublishedPosts setUntil (Object until) {
      this.setParam("until", until);
      return this;
    }
    public APIRequestGetPublishedPosts setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestGetPublishedPosts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPublishedPosts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPublishedPosts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPublishedPosts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPublishedPosts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPublishedPosts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPublishedPosts requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGetPublishedPosts requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestAdminCreatorField () {
      return this.requestAdminCreatorField(true);
    }
    public APIRequestGetPublishedPosts requestAdminCreatorField (boolean value) {
      this.requestField("admin_creator", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestAllowedAdvertisingObjectivesField () {
      return this.requestAllowedAdvertisingObjectivesField(true);
    }
    public APIRequestGetPublishedPosts requestAllowedAdvertisingObjectivesField (boolean value) {
      this.requestField("allowed_advertising_objectives", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGetPublishedPosts requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestBackdatedTimeField () {
      return this.requestBackdatedTimeField(true);
    }
    public APIRequestGetPublishedPosts requestBackdatedTimeField (boolean value) {
      this.requestField("backdated_time", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestCallToActionField () {
      return this.requestCallToActionField(true);
    }
    public APIRequestGetPublishedPosts requestCallToActionField (boolean value) {
      this.requestField("call_to_action", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestCanReplyPrivatelyField () {
      return this.requestCanReplyPrivatelyField(true);
    }
    public APIRequestGetPublishedPosts requestCanReplyPrivatelyField (boolean value) {
      this.requestField("can_reply_privately", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetPublishedPosts requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestChildAttachmentsField () {
      return this.requestChildAttachmentsField(true);
    }
    public APIRequestGetPublishedPosts requestChildAttachmentsField (boolean value) {
      this.requestField("child_attachments", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestCommentsMirroringDomainField () {
      return this.requestCommentsMirroringDomainField(true);
    }
    public APIRequestGetPublishedPosts requestCommentsMirroringDomainField (boolean value) {
      this.requestField("comments_mirroring_domain", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestCoordinatesField () {
      return this.requestCoordinatesField(true);
    }
    public APIRequestGetPublishedPosts requestCoordinatesField (boolean value) {
      this.requestField("coordinates", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetPublishedPosts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetPublishedPosts requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGetPublishedPosts requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestExpandedHeightField () {
      return this.requestExpandedHeightField(true);
    }
    public APIRequestGetPublishedPosts requestExpandedHeightField (boolean value) {
      this.requestField("expanded_height", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestExpandedWidthField () {
      return this.requestExpandedWidthField(true);
    }
    public APIRequestGetPublishedPosts requestExpandedWidthField (boolean value) {
      this.requestField("expanded_width", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestFeedTargetingField () {
      return this.requestFeedTargetingField(true);
    }
    public APIRequestGetPublishedPosts requestFeedTargetingField (boolean value) {
      this.requestField("feed_targeting", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetPublishedPosts requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestFullPictureField () {
      return this.requestFullPictureField(true);
    }
    public APIRequestGetPublishedPosts requestFullPictureField (boolean value) {
      this.requestField("full_picture", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetPublishedPosts requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestIconField () {
      return this.requestIconField(true);
    }
    public APIRequestGetPublishedPosts requestIconField (boolean value) {
      this.requestField("icon", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPublishedPosts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestInstagramEligibilityField () {
      return this.requestInstagramEligibilityField(true);
    }
    public APIRequestGetPublishedPosts requestInstagramEligibilityField (boolean value) {
      this.requestField("instagram_eligibility", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestIsAppShareField () {
      return this.requestIsAppShareField(true);
    }
    public APIRequestGetPublishedPosts requestIsAppShareField (boolean value) {
      this.requestField("is_app_share", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestIsExpiredField () {
      return this.requestIsExpiredField(true);
    }
    public APIRequestGetPublishedPosts requestIsExpiredField (boolean value) {
      this.requestField("is_expired", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetPublishedPosts requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestIsInstagramEligibleField () {
      return this.requestIsInstagramEligibleField(true);
    }
    public APIRequestGetPublishedPosts requestIsInstagramEligibleField (boolean value) {
      this.requestField("is_instagram_eligible", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestIsPopularField () {
      return this.requestIsPopularField(true);
    }
    public APIRequestGetPublishedPosts requestIsPopularField (boolean value) {
      this.requestField("is_popular", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetPublishedPosts requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestIsSphericalField () {
      return this.requestIsSphericalField(true);
    }
    public APIRequestGetPublishedPosts requestIsSphericalField (boolean value) {
      this.requestField("is_spherical", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetPublishedPosts requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGetPublishedPosts requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestMessageTagsField () {
      return this.requestMessageTagsField(true);
    }
    public APIRequestGetPublishedPosts requestMessageTagsField (boolean value) {
      this.requestField("message_tags", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestMultiShareEndCardField () {
      return this.requestMultiShareEndCardField(true);
    }
    public APIRequestGetPublishedPosts requestMultiShareEndCardField (boolean value) {
      this.requestField("multi_share_end_card", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestMultiShareOptimizedField () {
      return this.requestMultiShareOptimizedField(true);
    }
    public APIRequestGetPublishedPosts requestMultiShareOptimizedField (boolean value) {
      this.requestField("multi_share_optimized", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPublishedPosts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetPublishedPosts requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestParentIdField () {
      return this.requestParentIdField(true);
    }
    public APIRequestGetPublishedPosts requestParentIdField (boolean value) {
      this.requestField("parent_id", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGetPublishedPosts requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestPictureField () {
      return this.requestPictureField(true);
    }
    public APIRequestGetPublishedPosts requestPictureField (boolean value) {
      this.requestField("picture", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGetPublishedPosts requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGetPublishedPosts requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestPromotableIdField () {
      return this.requestPromotableIdField(true);
    }
    public APIRequestGetPublishedPosts requestPromotableIdField (boolean value) {
      this.requestField("promotable_id", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestPromotionStatusField () {
      return this.requestPromotionStatusField(true);
    }
    public APIRequestGetPublishedPosts requestPromotionStatusField (boolean value) {
      this.requestField("promotion_status", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestPropertiesField () {
      return this.requestPropertiesField(true);
    }
    public APIRequestGetPublishedPosts requestPropertiesField (boolean value) {
      this.requestField("properties", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGetPublishedPosts requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestSharesField () {
      return this.requestSharesField(true);
    }
    public APIRequestGetPublishedPosts requestSharesField (boolean value) {
      this.requestField("shares", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetPublishedPosts requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestStatusTypeField () {
      return this.requestStatusTypeField(true);
    }
    public APIRequestGetPublishedPosts requestStatusTypeField (boolean value) {
      this.requestField("status_type", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestStoryField () {
      return this.requestStoryField(true);
    }
    public APIRequestGetPublishedPosts requestStoryField (boolean value) {
      this.requestField("story", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestStoryTagsField () {
      return this.requestStoryTagsField(true);
    }
    public APIRequestGetPublishedPosts requestStoryTagsField (boolean value) {
      this.requestField("story_tags", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestSubscribedField () {
      return this.requestSubscribedField(true);
    }
    public APIRequestGetPublishedPosts requestSubscribedField (boolean value) {
      this.requestField("subscribed", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestTargetField () {
      return this.requestTargetField(true);
    }
    public APIRequestGetPublishedPosts requestTargetField (boolean value) {
      this.requestField("target", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetPublishedPosts requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestTimelineVisibilityField () {
      return this.requestTimelineVisibilityField(true);
    }
    public APIRequestGetPublishedPosts requestTimelineVisibilityField (boolean value) {
      this.requestField("timeline_visibility", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetPublishedPosts requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetPublishedPosts requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestViaField () {
      return this.requestViaField(true);
    }
    public APIRequestGetPublishedPosts requestViaField (boolean value) {
      this.requestField("via", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestVideoBuyingEligibilityField () {
      return this.requestVideoBuyingEligibilityField(true);
    }
    public APIRequestGetPublishedPosts requestVideoBuyingEligibilityField (boolean value) {
      this.requestField("video_buying_eligibility", value);
      return this;
    }
    public APIRequestGetPublishedPosts requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetPublishedPosts requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
  }

  public static class APIRequestCreateRequestThreadControl extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "metadata",
      "recipient",
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
               return APIRequestCreateRequestThreadControl.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateRequestThreadControl(String nodeId, APIContext context) {
      super(context, nodeId, "/request_thread_control", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateRequestThreadControl setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateRequestThreadControl setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateRequestThreadControl setMetadata (String metadata) {
      this.setParam("metadata", metadata);
      return this;
    }

    public APIRequestCreateRequestThreadControl setRecipient (Object recipient) {
      this.setParam("recipient", recipient);
      return this;
    }
    public APIRequestCreateRequestThreadControl setRecipient (String recipient) {
      this.setParam("recipient", recipient);
      return this;
    }

    public APIRequestCreateRequestThreadControl requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateRequestThreadControl requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateRequestThreadControl requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateRequestThreadControl requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateRequestThreadControl requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateRequestThreadControl requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetRoles extends APIRequest<User> {

    APINodeList<User> lastResponse = null;
    @Override
    public APINodeList<User> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "uid",
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
    public APINodeList<User> parseResponse(String response) throws APIException {
      return User.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<User> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<User> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<User>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<User>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<User>>() {
           public APINodeList<User> apply(String result) {
             try {
               return APIRequestGetRoles.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetRoles(String nodeId, APIContext context) {
      super(context, nodeId, "/roles", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetRoles setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetRoles setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetRoles setUid (Long uid) {
      this.setParam("uid", uid);
      return this;
    }
    public APIRequestGetRoles setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestGetRoles requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetRoles requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRoles requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetRoles requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRoles requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetRoles requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetRoles requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetRoles requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetRoles requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetRoles requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetRoles requestAdminNotesField () {
      return this.requestAdminNotesField(true);
    }
    public APIRequestGetRoles requestAdminNotesField (boolean value) {
      this.requestField("admin_notes", value);
      return this;
    }
    public APIRequestGetRoles requestAgeRangeField () {
      return this.requestAgeRangeField(true);
    }
    public APIRequestGetRoles requestAgeRangeField (boolean value) {
      this.requestField("age_range", value);
      return this;
    }
    public APIRequestGetRoles requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetRoles requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetRoles requestCanReviewMeasurementRequestField () {
      return this.requestCanReviewMeasurementRequestField(true);
    }
    public APIRequestGetRoles requestCanReviewMeasurementRequestField (boolean value) {
      this.requestField("can_review_measurement_request", value);
      return this;
    }
    public APIRequestGetRoles requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetRoles requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetRoles requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetRoles requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetRoles requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetRoles requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetRoles requestDevicesField () {
      return this.requestDevicesField(true);
    }
    public APIRequestGetRoles requestDevicesField (boolean value) {
      this.requestField("devices", value);
      return this;
    }
    public APIRequestGetRoles requestEducationField () {
      return this.requestEducationField(true);
    }
    public APIRequestGetRoles requestEducationField (boolean value) {
      this.requestField("education", value);
      return this;
    }
    public APIRequestGetRoles requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetRoles requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetRoles requestEmployeeNumberField () {
      return this.requestEmployeeNumberField(true);
    }
    public APIRequestGetRoles requestEmployeeNumberField (boolean value) {
      this.requestField("employee_number", value);
      return this;
    }
    public APIRequestGetRoles requestFavoriteAthletesField () {
      return this.requestFavoriteAthletesField(true);
    }
    public APIRequestGetRoles requestFavoriteAthletesField (boolean value) {
      this.requestField("favorite_athletes", value);
      return this;
    }
    public APIRequestGetRoles requestFavoriteTeamsField () {
      return this.requestFavoriteTeamsField(true);
    }
    public APIRequestGetRoles requestFavoriteTeamsField (boolean value) {
      this.requestField("favorite_teams", value);
      return this;
    }
    public APIRequestGetRoles requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetRoles requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetRoles requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetRoles requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetRoles requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetRoles requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetRoles requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetRoles requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetRoles requestInspirationalPeopleField () {
      return this.requestInspirationalPeopleField(true);
    }
    public APIRequestGetRoles requestInspirationalPeopleField (boolean value) {
      this.requestField("inspirational_people", value);
      return this;
    }
    public APIRequestGetRoles requestInstallTypeField () {
      return this.requestInstallTypeField(true);
    }
    public APIRequestGetRoles requestInstallTypeField (boolean value) {
      this.requestField("install_type", value);
      return this;
    }
    public APIRequestGetRoles requestInstalledField () {
      return this.requestInstalledField(true);
    }
    public APIRequestGetRoles requestInstalledField (boolean value) {
      this.requestField("installed", value);
      return this;
    }
    public APIRequestGetRoles requestInterestedInField () {
      return this.requestInterestedInField(true);
    }
    public APIRequestGetRoles requestInterestedInField (boolean value) {
      this.requestField("interested_in", value);
      return this;
    }
    public APIRequestGetRoles requestIsFamedeeplinkinguserField () {
      return this.requestIsFamedeeplinkinguserField(true);
    }
    public APIRequestGetRoles requestIsFamedeeplinkinguserField (boolean value) {
      this.requestField("is_famedeeplinkinguser", value);
      return this;
    }
    public APIRequestGetRoles requestIsSharedLoginField () {
      return this.requestIsSharedLoginField(true);
    }
    public APIRequestGetRoles requestIsSharedLoginField (boolean value) {
      this.requestField("is_shared_login", value);
      return this;
    }
    public APIRequestGetRoles requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetRoles requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetRoles requestLabelsField () {
      return this.requestLabelsField(true);
    }
    public APIRequestGetRoles requestLabelsField (boolean value) {
      this.requestField("labels", value);
      return this;
    }
    public APIRequestGetRoles requestLanguagesField () {
      return this.requestLanguagesField(true);
    }
    public APIRequestGetRoles requestLanguagesField (boolean value) {
      this.requestField("languages", value);
      return this;
    }
    public APIRequestGetRoles requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetRoles requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetRoles requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetRoles requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetRoles requestLocalNewsMegaphoneDismissStatusField () {
      return this.requestLocalNewsMegaphoneDismissStatusField(true);
    }
    public APIRequestGetRoles requestLocalNewsMegaphoneDismissStatusField (boolean value) {
      this.requestField("local_news_megaphone_dismiss_status", value);
      return this;
    }
    public APIRequestGetRoles requestLocalNewsSubscriptionStatusField () {
      return this.requestLocalNewsSubscriptionStatusField(true);
    }
    public APIRequestGetRoles requestLocalNewsSubscriptionStatusField (boolean value) {
      this.requestField("local_news_subscription_status", value);
      return this;
    }
    public APIRequestGetRoles requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetRoles requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetRoles requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetRoles requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetRoles requestMeetingForField () {
      return this.requestMeetingForField(true);
    }
    public APIRequestGetRoles requestMeetingForField (boolean value) {
      this.requestField("meeting_for", value);
      return this;
    }
    public APIRequestGetRoles requestMiddleNameField () {
      return this.requestMiddleNameField(true);
    }
    public APIRequestGetRoles requestMiddleNameField (boolean value) {
      this.requestField("middle_name", value);
      return this;
    }
    public APIRequestGetRoles requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetRoles requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetRoles requestNameFormatField () {
      return this.requestNameFormatField(true);
    }
    public APIRequestGetRoles requestNameFormatField (boolean value) {
      this.requestField("name_format", value);
      return this;
    }
    public APIRequestGetRoles requestPaymentPricepointsField () {
      return this.requestPaymentPricepointsField(true);
    }
    public APIRequestGetRoles requestPaymentPricepointsField (boolean value) {
      this.requestField("payment_pricepoints", value);
      return this;
    }
    public APIRequestGetRoles requestPoliticalField () {
      return this.requestPoliticalField(true);
    }
    public APIRequestGetRoles requestPoliticalField (boolean value) {
      this.requestField("political", value);
      return this;
    }
    public APIRequestGetRoles requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetRoles requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetRoles requestPublicKeyField () {
      return this.requestPublicKeyField(true);
    }
    public APIRequestGetRoles requestPublicKeyField (boolean value) {
      this.requestField("public_key", value);
      return this;
    }
    public APIRequestGetRoles requestQuotesField () {
      return this.requestQuotesField(true);
    }
    public APIRequestGetRoles requestQuotesField (boolean value) {
      this.requestField("quotes", value);
      return this;
    }
    public APIRequestGetRoles requestRelationshipStatusField () {
      return this.requestRelationshipStatusField(true);
    }
    public APIRequestGetRoles requestRelationshipStatusField (boolean value) {
      this.requestField("relationship_status", value);
      return this;
    }
    public APIRequestGetRoles requestReligionField () {
      return this.requestReligionField(true);
    }
    public APIRequestGetRoles requestReligionField (boolean value) {
      this.requestField("religion", value);
      return this;
    }
    public APIRequestGetRoles requestSecuritySettingsField () {
      return this.requestSecuritySettingsField(true);
    }
    public APIRequestGetRoles requestSecuritySettingsField (boolean value) {
      this.requestField("security_settings", value);
      return this;
    }
    public APIRequestGetRoles requestSharedLoginUpgradeRequiredByField () {
      return this.requestSharedLoginUpgradeRequiredByField(true);
    }
    public APIRequestGetRoles requestSharedLoginUpgradeRequiredByField (boolean value) {
      this.requestField("shared_login_upgrade_required_by", value);
      return this;
    }
    public APIRequestGetRoles requestShortNameField () {
      return this.requestShortNameField(true);
    }
    public APIRequestGetRoles requestShortNameField (boolean value) {
      this.requestField("short_name", value);
      return this;
    }
    public APIRequestGetRoles requestSignificantOtherField () {
      return this.requestSignificantOtherField(true);
    }
    public APIRequestGetRoles requestSignificantOtherField (boolean value) {
      this.requestField("significant_other", value);
      return this;
    }
    public APIRequestGetRoles requestSportsField () {
      return this.requestSportsField(true);
    }
    public APIRequestGetRoles requestSportsField (boolean value) {
      this.requestField("sports", value);
      return this;
    }
    public APIRequestGetRoles requestTestGroupField () {
      return this.requestTestGroupField(true);
    }
    public APIRequestGetRoles requestTestGroupField (boolean value) {
      this.requestField("test_group", value);
      return this;
    }
    public APIRequestGetRoles requestThirdPartyIdField () {
      return this.requestThirdPartyIdField(true);
    }
    public APIRequestGetRoles requestThirdPartyIdField (boolean value) {
      this.requestField("third_party_id", value);
      return this;
    }
    public APIRequestGetRoles requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetRoles requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetRoles requestTokenForBusinessField () {
      return this.requestTokenForBusinessField(true);
    }
    public APIRequestGetRoles requestTokenForBusinessField (boolean value) {
      this.requestField("token_for_business", value);
      return this;
    }
    public APIRequestGetRoles requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetRoles requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetRoles requestVerifiedField () {
      return this.requestVerifiedField(true);
    }
    public APIRequestGetRoles requestVerifiedField (boolean value) {
      this.requestField("verified", value);
      return this;
    }
    public APIRequestGetRoles requestVideoUploadLimitsField () {
      return this.requestVideoUploadLimitsField(true);
    }
    public APIRequestGetRoles requestVideoUploadLimitsField (boolean value) {
      this.requestField("video_upload_limits", value);
      return this;
    }
    public APIRequestGetRoles requestViewerCanSendGiftField () {
      return this.requestViewerCanSendGiftField(true);
    }
    public APIRequestGetRoles requestViewerCanSendGiftField (boolean value) {
      this.requestField("viewer_can_send_gift", value);
      return this;
    }
    public APIRequestGetRoles requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetRoles requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetRoles requestWorkField () {
      return this.requestWorkField(true);
    }
    public APIRequestGetRoles requestWorkField (boolean value) {
      this.requestField("work", value);
      return this;
    }
  }

  public static class APIRequestGetSavedFilters extends APIRequest<PageSavedFilter> {

    APINodeList<PageSavedFilter> lastResponse = null;
    @Override
    public APINodeList<PageSavedFilter> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "section",
    };

    public static final String[] FIELDS = {
      "display_name",
      "filters",
      "id",
      "page_id",
      "section",
      "time_created",
      "time_updated",
    };

    @Override
    public APINodeList<PageSavedFilter> parseResponse(String response) throws APIException {
      return PageSavedFilter.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<PageSavedFilter> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<PageSavedFilter> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<PageSavedFilter>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<PageSavedFilter>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<PageSavedFilter>>() {
           public APINodeList<PageSavedFilter> apply(String result) {
             try {
               return APIRequestGetSavedFilters.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetSavedFilters(String nodeId, APIContext context) {
      super(context, nodeId, "/saved_filters", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSavedFilters setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSavedFilters setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSavedFilters setSection (PageSavedFilter.EnumSection section) {
      this.setParam("section", section);
      return this;
    }
    public APIRequestGetSavedFilters setSection (String section) {
      this.setParam("section", section);
      return this;
    }

    public APIRequestGetSavedFilters requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSavedFilters requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSavedFilters requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSavedFilters requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSavedFilters requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSavedFilters requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSavedFilters requestDisplayNameField () {
      return this.requestDisplayNameField(true);
    }
    public APIRequestGetSavedFilters requestDisplayNameField (boolean value) {
      this.requestField("display_name", value);
      return this;
    }
    public APIRequestGetSavedFilters requestFiltersField () {
      return this.requestFiltersField(true);
    }
    public APIRequestGetSavedFilters requestFiltersField (boolean value) {
      this.requestField("filters", value);
      return this;
    }
    public APIRequestGetSavedFilters requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetSavedFilters requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetSavedFilters requestPageIdField () {
      return this.requestPageIdField(true);
    }
    public APIRequestGetSavedFilters requestPageIdField (boolean value) {
      this.requestField("page_id", value);
      return this;
    }
    public APIRequestGetSavedFilters requestSectionField () {
      return this.requestSectionField(true);
    }
    public APIRequestGetSavedFilters requestSectionField (boolean value) {
      this.requestField("section", value);
      return this;
    }
    public APIRequestGetSavedFilters requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGetSavedFilters requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGetSavedFilters requestTimeUpdatedField () {
      return this.requestTimeUpdatedField(true);
    }
    public APIRequestGetSavedFilters requestTimeUpdatedField (boolean value) {
      this.requestField("time_updated", value);
      return this;
    }
  }

  public static class APIRequestCreateSavedMessageResponse extends APIRequest<SavedMessageResponse> {

    SavedMessageResponse lastResponse = null;
    @Override
    public SavedMessageResponse getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "category",
      "image",
      "is_enabled",
      "message",
      "title",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public SavedMessageResponse parseResponse(String response) throws APIException {
      return SavedMessageResponse.parseResponse(response, getContext(), this).head();
    }

    @Override
    public SavedMessageResponse execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public SavedMessageResponse execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<SavedMessageResponse> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<SavedMessageResponse> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, SavedMessageResponse>() {
           public SavedMessageResponse apply(String result) {
             try {
               return APIRequestCreateSavedMessageResponse.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateSavedMessageResponse(String nodeId, APIContext context) {
      super(context, nodeId, "/saved_message_responses", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSavedMessageResponse setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSavedMessageResponse setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSavedMessageResponse setCategory (SavedMessageResponse.EnumCategory category) {
      this.setParam("category", category);
      return this;
    }
    public APIRequestCreateSavedMessageResponse setCategory (String category) {
      this.setParam("category", category);
      return this;
    }

    public APIRequestCreateSavedMessageResponse setImage (String image) {
      this.setParam("image", image);
      return this;
    }

    public APIRequestCreateSavedMessageResponse setIsEnabled (Boolean isEnabled) {
      this.setParam("is_enabled", isEnabled);
      return this;
    }
    public APIRequestCreateSavedMessageResponse setIsEnabled (String isEnabled) {
      this.setParam("is_enabled", isEnabled);
      return this;
    }

    public APIRequestCreateSavedMessageResponse setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateSavedMessageResponse setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateSavedMessageResponse requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSavedMessageResponse requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSavedMessageResponse requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSavedMessageResponse requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSavedMessageResponse requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSavedMessageResponse requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetScheduledPosts extends APIRequest<PagePost> {

    APINodeList<PagePost> lastResponse = null;
    @Override
    public APINodeList<PagePost> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "actions",
      "admin_creator",
      "allowed_advertising_objectives",
      "application",
      "backdated_time",
      "call_to_action",
      "can_reply_privately",
      "caption",
      "child_attachments",
      "comments_mirroring_domain",
      "coordinates",
      "created_time",
      "description",
      "event",
      "expanded_height",
      "expanded_width",
      "feed_targeting",
      "from",
      "full_picture",
      "height",
      "icon",
      "id",
      "instagram_eligibility",
      "is_app_share",
      "is_expired",
      "is_hidden",
      "is_instagram_eligible",
      "is_popular",
      "is_published",
      "is_spherical",
      "link",
      "message",
      "message_tags",
      "multi_share_end_card",
      "multi_share_optimized",
      "name",
      "object_id",
      "parent_id",
      "permalink_url",
      "picture",
      "place",
      "privacy",
      "promotable_id",
      "promotion_status",
      "properties",
      "scheduled_publish_time",
      "shares",
      "source",
      "status_type",
      "story",
      "story_tags",
      "subscribed",
      "target",
      "targeting",
      "timeline_visibility",
      "type",
      "updated_time",
      "via",
      "video_buying_eligibility",
      "width",
    };

    @Override
    public APINodeList<PagePost> parseResponse(String response) throws APIException {
      return PagePost.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<PagePost> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<PagePost> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<PagePost>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<PagePost>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<PagePost>>() {
           public APINodeList<PagePost> apply(String result) {
             try {
               return APIRequestGetScheduledPosts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetScheduledPosts(String nodeId, APIContext context) {
      super(context, nodeId, "/scheduled_posts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetScheduledPosts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetScheduledPosts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetScheduledPosts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetScheduledPosts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetScheduledPosts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetScheduledPosts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetScheduledPosts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetScheduledPosts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetScheduledPosts requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGetScheduledPosts requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestAdminCreatorField () {
      return this.requestAdminCreatorField(true);
    }
    public APIRequestGetScheduledPosts requestAdminCreatorField (boolean value) {
      this.requestField("admin_creator", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestAllowedAdvertisingObjectivesField () {
      return this.requestAllowedAdvertisingObjectivesField(true);
    }
    public APIRequestGetScheduledPosts requestAllowedAdvertisingObjectivesField (boolean value) {
      this.requestField("allowed_advertising_objectives", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGetScheduledPosts requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestBackdatedTimeField () {
      return this.requestBackdatedTimeField(true);
    }
    public APIRequestGetScheduledPosts requestBackdatedTimeField (boolean value) {
      this.requestField("backdated_time", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestCallToActionField () {
      return this.requestCallToActionField(true);
    }
    public APIRequestGetScheduledPosts requestCallToActionField (boolean value) {
      this.requestField("call_to_action", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestCanReplyPrivatelyField () {
      return this.requestCanReplyPrivatelyField(true);
    }
    public APIRequestGetScheduledPosts requestCanReplyPrivatelyField (boolean value) {
      this.requestField("can_reply_privately", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetScheduledPosts requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestChildAttachmentsField () {
      return this.requestChildAttachmentsField(true);
    }
    public APIRequestGetScheduledPosts requestChildAttachmentsField (boolean value) {
      this.requestField("child_attachments", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestCommentsMirroringDomainField () {
      return this.requestCommentsMirroringDomainField(true);
    }
    public APIRequestGetScheduledPosts requestCommentsMirroringDomainField (boolean value) {
      this.requestField("comments_mirroring_domain", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestCoordinatesField () {
      return this.requestCoordinatesField(true);
    }
    public APIRequestGetScheduledPosts requestCoordinatesField (boolean value) {
      this.requestField("coordinates", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetScheduledPosts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetScheduledPosts requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGetScheduledPosts requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestExpandedHeightField () {
      return this.requestExpandedHeightField(true);
    }
    public APIRequestGetScheduledPosts requestExpandedHeightField (boolean value) {
      this.requestField("expanded_height", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestExpandedWidthField () {
      return this.requestExpandedWidthField(true);
    }
    public APIRequestGetScheduledPosts requestExpandedWidthField (boolean value) {
      this.requestField("expanded_width", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestFeedTargetingField () {
      return this.requestFeedTargetingField(true);
    }
    public APIRequestGetScheduledPosts requestFeedTargetingField (boolean value) {
      this.requestField("feed_targeting", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetScheduledPosts requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestFullPictureField () {
      return this.requestFullPictureField(true);
    }
    public APIRequestGetScheduledPosts requestFullPictureField (boolean value) {
      this.requestField("full_picture", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetScheduledPosts requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestIconField () {
      return this.requestIconField(true);
    }
    public APIRequestGetScheduledPosts requestIconField (boolean value) {
      this.requestField("icon", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetScheduledPosts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestInstagramEligibilityField () {
      return this.requestInstagramEligibilityField(true);
    }
    public APIRequestGetScheduledPosts requestInstagramEligibilityField (boolean value) {
      this.requestField("instagram_eligibility", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestIsAppShareField () {
      return this.requestIsAppShareField(true);
    }
    public APIRequestGetScheduledPosts requestIsAppShareField (boolean value) {
      this.requestField("is_app_share", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestIsExpiredField () {
      return this.requestIsExpiredField(true);
    }
    public APIRequestGetScheduledPosts requestIsExpiredField (boolean value) {
      this.requestField("is_expired", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetScheduledPosts requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestIsInstagramEligibleField () {
      return this.requestIsInstagramEligibleField(true);
    }
    public APIRequestGetScheduledPosts requestIsInstagramEligibleField (boolean value) {
      this.requestField("is_instagram_eligible", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestIsPopularField () {
      return this.requestIsPopularField(true);
    }
    public APIRequestGetScheduledPosts requestIsPopularField (boolean value) {
      this.requestField("is_popular", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetScheduledPosts requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestIsSphericalField () {
      return this.requestIsSphericalField(true);
    }
    public APIRequestGetScheduledPosts requestIsSphericalField (boolean value) {
      this.requestField("is_spherical", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetScheduledPosts requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGetScheduledPosts requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestMessageTagsField () {
      return this.requestMessageTagsField(true);
    }
    public APIRequestGetScheduledPosts requestMessageTagsField (boolean value) {
      this.requestField("message_tags", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestMultiShareEndCardField () {
      return this.requestMultiShareEndCardField(true);
    }
    public APIRequestGetScheduledPosts requestMultiShareEndCardField (boolean value) {
      this.requestField("multi_share_end_card", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestMultiShareOptimizedField () {
      return this.requestMultiShareOptimizedField(true);
    }
    public APIRequestGetScheduledPosts requestMultiShareOptimizedField (boolean value) {
      this.requestField("multi_share_optimized", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetScheduledPosts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetScheduledPosts requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestParentIdField () {
      return this.requestParentIdField(true);
    }
    public APIRequestGetScheduledPosts requestParentIdField (boolean value) {
      this.requestField("parent_id", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGetScheduledPosts requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestPictureField () {
      return this.requestPictureField(true);
    }
    public APIRequestGetScheduledPosts requestPictureField (boolean value) {
      this.requestField("picture", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGetScheduledPosts requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGetScheduledPosts requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestPromotableIdField () {
      return this.requestPromotableIdField(true);
    }
    public APIRequestGetScheduledPosts requestPromotableIdField (boolean value) {
      this.requestField("promotable_id", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestPromotionStatusField () {
      return this.requestPromotionStatusField(true);
    }
    public APIRequestGetScheduledPosts requestPromotionStatusField (boolean value) {
      this.requestField("promotion_status", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestPropertiesField () {
      return this.requestPropertiesField(true);
    }
    public APIRequestGetScheduledPosts requestPropertiesField (boolean value) {
      this.requestField("properties", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGetScheduledPosts requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestSharesField () {
      return this.requestSharesField(true);
    }
    public APIRequestGetScheduledPosts requestSharesField (boolean value) {
      this.requestField("shares", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetScheduledPosts requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestStatusTypeField () {
      return this.requestStatusTypeField(true);
    }
    public APIRequestGetScheduledPosts requestStatusTypeField (boolean value) {
      this.requestField("status_type", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestStoryField () {
      return this.requestStoryField(true);
    }
    public APIRequestGetScheduledPosts requestStoryField (boolean value) {
      this.requestField("story", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestStoryTagsField () {
      return this.requestStoryTagsField(true);
    }
    public APIRequestGetScheduledPosts requestStoryTagsField (boolean value) {
      this.requestField("story_tags", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestSubscribedField () {
      return this.requestSubscribedField(true);
    }
    public APIRequestGetScheduledPosts requestSubscribedField (boolean value) {
      this.requestField("subscribed", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestTargetField () {
      return this.requestTargetField(true);
    }
    public APIRequestGetScheduledPosts requestTargetField (boolean value) {
      this.requestField("target", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetScheduledPosts requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestTimelineVisibilityField () {
      return this.requestTimelineVisibilityField(true);
    }
    public APIRequestGetScheduledPosts requestTimelineVisibilityField (boolean value) {
      this.requestField("timeline_visibility", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetScheduledPosts requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetScheduledPosts requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestViaField () {
      return this.requestViaField(true);
    }
    public APIRequestGetScheduledPosts requestViaField (boolean value) {
      this.requestField("via", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestVideoBuyingEligibilityField () {
      return this.requestVideoBuyingEligibilityField(true);
    }
    public APIRequestGetScheduledPosts requestVideoBuyingEligibilityField (boolean value) {
      this.requestField("video_buying_eligibility", value);
      return this;
    }
    public APIRequestGetScheduledPosts requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetScheduledPosts requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
  }

  public static class APIRequestCreateSetting extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "option",
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
               return APIRequestCreateSetting.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateSetting(String nodeId, APIContext context) {
      super(context, nodeId, "/settings", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSetting setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSetting setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSetting setOption (Object option) {
      this.setParam("option", option);
      return this;
    }
    public APIRequestCreateSetting setOption (String option) {
      this.setParam("option", option);
      return this;
    }

    public APIRequestCreateSetting requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSetting requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSetting requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSetting requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSetting requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSetting requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteSubscribedApps extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteSubscribedApps.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteSubscribedApps(String nodeId, APIContext context) {
      super(context, nodeId, "/subscribed_apps", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteSubscribedApps setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteSubscribedApps setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteSubscribedApps requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteSubscribedApps requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteSubscribedApps requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteSubscribedApps requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteSubscribedApps requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteSubscribedApps requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateSubscribedApp extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
               return APIRequestCreateSubscribedApp.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateSubscribedApp(String nodeId, APIContext context) {
      super(context, nodeId, "/subscribed_apps", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSubscribedApp setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSubscribedApp setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSubscribedApp requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSubscribedApp requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSubscribedApp requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSubscribedApp requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSubscribedApp requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSubscribedApp requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteTabs extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "tab",
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

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteTabs.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteTabs(String nodeId, APIContext context) {
      super(context, nodeId, "/tabs", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteTabs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteTabs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteTabs setTab (String tab) {
      this.setParam("tab", tab);
      return this;
    }

    public APIRequestDeleteTabs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteTabs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteTabs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteTabs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteTabs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteTabs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetTabs extends APIRequest<Tab> {

    APINodeList<Tab> lastResponse = null;
    @Override
    public APINodeList<Tab> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "tab",
    };

    public static final String[] FIELDS = {
      "application",
      "custom_image_url",
      "custom_name",
      "id",
      "image_url",
      "is_non_connection_landing_tab",
      "is_permanent",
      "link",
      "name",
      "position",
    };

    @Override
    public APINodeList<Tab> parseResponse(String response) throws APIException {
      return Tab.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Tab> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Tab> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Tab>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Tab>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Tab>>() {
           public APINodeList<Tab> apply(String result) {
             try {
               return APIRequestGetTabs.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetTabs(String nodeId, APIContext context) {
      super(context, nodeId, "/tabs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTabs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTabs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTabs setTab (List<String> tab) {
      this.setParam("tab", tab);
      return this;
    }
    public APIRequestGetTabs setTab (String tab) {
      this.setParam("tab", tab);
      return this;
    }

    public APIRequestGetTabs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTabs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTabs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTabs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTabs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTabs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTabs requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGetTabs requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGetTabs requestCustomImageUrlField () {
      return this.requestCustomImageUrlField(true);
    }
    public APIRequestGetTabs requestCustomImageUrlField (boolean value) {
      this.requestField("custom_image_url", value);
      return this;
    }
    public APIRequestGetTabs requestCustomNameField () {
      return this.requestCustomNameField(true);
    }
    public APIRequestGetTabs requestCustomNameField (boolean value) {
      this.requestField("custom_name", value);
      return this;
    }
    public APIRequestGetTabs requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTabs requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTabs requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGetTabs requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGetTabs requestIsNonConnectionLandingTabField () {
      return this.requestIsNonConnectionLandingTabField(true);
    }
    public APIRequestGetTabs requestIsNonConnectionLandingTabField (boolean value) {
      this.requestField("is_non_connection_landing_tab", value);
      return this;
    }
    public APIRequestGetTabs requestIsPermanentField () {
      return this.requestIsPermanentField(true);
    }
    public APIRequestGetTabs requestIsPermanentField (boolean value) {
      this.requestField("is_permanent", value);
      return this;
    }
    public APIRequestGetTabs requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetTabs requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetTabs requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetTabs requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetTabs requestPositionField () {
      return this.requestPositionField(true);
    }
    public APIRequestGetTabs requestPositionField (boolean value) {
      this.requestField("position", value);
      return this;
    }
  }

  public static class APIRequestCreateTab extends APIRequest<Tab> {

    Tab lastResponse = null;
    @Override
    public Tab getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_id",
      "custom_image_url",
      "custom_name",
      "is_non_connection_landing_tab",
      "position",
      "tab",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Tab parseResponse(String response) throws APIException {
      return Tab.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Tab execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Tab execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Tab> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Tab> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Tab>() {
           public Tab apply(String result) {
             try {
               return APIRequestCreateTab.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateTab(String nodeId, APIContext context) {
      super(context, nodeId, "/tabs", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateTab setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateTab setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateTab setAppId (Long appId) {
      this.setParam("app_id", appId);
      return this;
    }
    public APIRequestCreateTab setAppId (String appId) {
      this.setParam("app_id", appId);
      return this;
    }

    public APIRequestCreateTab setCustomImageUrl (String customImageUrl) {
      this.setParam("custom_image_url", customImageUrl);
      return this;
    }

    public APIRequestCreateTab setCustomName (String customName) {
      this.setParam("custom_name", customName);
      return this;
    }

    public APIRequestCreateTab setIsNonConnectionLandingTab (Boolean isNonConnectionLandingTab) {
      this.setParam("is_non_connection_landing_tab", isNonConnectionLandingTab);
      return this;
    }
    public APIRequestCreateTab setIsNonConnectionLandingTab (String isNonConnectionLandingTab) {
      this.setParam("is_non_connection_landing_tab", isNonConnectionLandingTab);
      return this;
    }

    public APIRequestCreateTab setPosition (Long position) {
      this.setParam("position", position);
      return this;
    }
    public APIRequestCreateTab setPosition (String position) {
      this.setParam("position", position);
      return this;
    }

    public APIRequestCreateTab setTab (String tab) {
      this.setParam("tab", tab);
      return this;
    }

    public APIRequestCreateTab requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateTab requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateTab requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateTab requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateTab requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateTab requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetTagged extends APIRequest<PagePost> {

    APINodeList<PagePost> lastResponse = null;
    @Override
    public APINodeList<PagePost> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "actions",
      "admin_creator",
      "allowed_advertising_objectives",
      "application",
      "backdated_time",
      "call_to_action",
      "can_reply_privately",
      "caption",
      "child_attachments",
      "comments_mirroring_domain",
      "coordinates",
      "created_time",
      "description",
      "event",
      "expanded_height",
      "expanded_width",
      "feed_targeting",
      "from",
      "full_picture",
      "height",
      "icon",
      "id",
      "instagram_eligibility",
      "is_app_share",
      "is_expired",
      "is_hidden",
      "is_instagram_eligible",
      "is_popular",
      "is_published",
      "is_spherical",
      "link",
      "message",
      "message_tags",
      "multi_share_end_card",
      "multi_share_optimized",
      "name",
      "object_id",
      "parent_id",
      "permalink_url",
      "picture",
      "place",
      "privacy",
      "promotable_id",
      "promotion_status",
      "properties",
      "scheduled_publish_time",
      "shares",
      "source",
      "status_type",
      "story",
      "story_tags",
      "subscribed",
      "target",
      "targeting",
      "timeline_visibility",
      "type",
      "updated_time",
      "via",
      "video_buying_eligibility",
      "width",
    };

    @Override
    public APINodeList<PagePost> parseResponse(String response) throws APIException {
      return PagePost.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<PagePost> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<PagePost> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<PagePost>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<PagePost>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<PagePost>>() {
           public APINodeList<PagePost> apply(String result) {
             try {
               return APIRequestGetTagged.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetTagged(String nodeId, APIContext context) {
      super(context, nodeId, "/tagged", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTagged setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTagged setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTagged requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTagged requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTagged requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTagged requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTagged requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTagged requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTagged requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGetTagged requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGetTagged requestAdminCreatorField () {
      return this.requestAdminCreatorField(true);
    }
    public APIRequestGetTagged requestAdminCreatorField (boolean value) {
      this.requestField("admin_creator", value);
      return this;
    }
    public APIRequestGetTagged requestAllowedAdvertisingObjectivesField () {
      return this.requestAllowedAdvertisingObjectivesField(true);
    }
    public APIRequestGetTagged requestAllowedAdvertisingObjectivesField (boolean value) {
      this.requestField("allowed_advertising_objectives", value);
      return this;
    }
    public APIRequestGetTagged requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGetTagged requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGetTagged requestBackdatedTimeField () {
      return this.requestBackdatedTimeField(true);
    }
    public APIRequestGetTagged requestBackdatedTimeField (boolean value) {
      this.requestField("backdated_time", value);
      return this;
    }
    public APIRequestGetTagged requestCallToActionField () {
      return this.requestCallToActionField(true);
    }
    public APIRequestGetTagged requestCallToActionField (boolean value) {
      this.requestField("call_to_action", value);
      return this;
    }
    public APIRequestGetTagged requestCanReplyPrivatelyField () {
      return this.requestCanReplyPrivatelyField(true);
    }
    public APIRequestGetTagged requestCanReplyPrivatelyField (boolean value) {
      this.requestField("can_reply_privately", value);
      return this;
    }
    public APIRequestGetTagged requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetTagged requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetTagged requestChildAttachmentsField () {
      return this.requestChildAttachmentsField(true);
    }
    public APIRequestGetTagged requestChildAttachmentsField (boolean value) {
      this.requestField("child_attachments", value);
      return this;
    }
    public APIRequestGetTagged requestCommentsMirroringDomainField () {
      return this.requestCommentsMirroringDomainField(true);
    }
    public APIRequestGetTagged requestCommentsMirroringDomainField (boolean value) {
      this.requestField("comments_mirroring_domain", value);
      return this;
    }
    public APIRequestGetTagged requestCoordinatesField () {
      return this.requestCoordinatesField(true);
    }
    public APIRequestGetTagged requestCoordinatesField (boolean value) {
      this.requestField("coordinates", value);
      return this;
    }
    public APIRequestGetTagged requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetTagged requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetTagged requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetTagged requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetTagged requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGetTagged requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGetTagged requestExpandedHeightField () {
      return this.requestExpandedHeightField(true);
    }
    public APIRequestGetTagged requestExpandedHeightField (boolean value) {
      this.requestField("expanded_height", value);
      return this;
    }
    public APIRequestGetTagged requestExpandedWidthField () {
      return this.requestExpandedWidthField(true);
    }
    public APIRequestGetTagged requestExpandedWidthField (boolean value) {
      this.requestField("expanded_width", value);
      return this;
    }
    public APIRequestGetTagged requestFeedTargetingField () {
      return this.requestFeedTargetingField(true);
    }
    public APIRequestGetTagged requestFeedTargetingField (boolean value) {
      this.requestField("feed_targeting", value);
      return this;
    }
    public APIRequestGetTagged requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetTagged requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetTagged requestFullPictureField () {
      return this.requestFullPictureField(true);
    }
    public APIRequestGetTagged requestFullPictureField (boolean value) {
      this.requestField("full_picture", value);
      return this;
    }
    public APIRequestGetTagged requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetTagged requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetTagged requestIconField () {
      return this.requestIconField(true);
    }
    public APIRequestGetTagged requestIconField (boolean value) {
      this.requestField("icon", value);
      return this;
    }
    public APIRequestGetTagged requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTagged requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTagged requestInstagramEligibilityField () {
      return this.requestInstagramEligibilityField(true);
    }
    public APIRequestGetTagged requestInstagramEligibilityField (boolean value) {
      this.requestField("instagram_eligibility", value);
      return this;
    }
    public APIRequestGetTagged requestIsAppShareField () {
      return this.requestIsAppShareField(true);
    }
    public APIRequestGetTagged requestIsAppShareField (boolean value) {
      this.requestField("is_app_share", value);
      return this;
    }
    public APIRequestGetTagged requestIsExpiredField () {
      return this.requestIsExpiredField(true);
    }
    public APIRequestGetTagged requestIsExpiredField (boolean value) {
      this.requestField("is_expired", value);
      return this;
    }
    public APIRequestGetTagged requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetTagged requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetTagged requestIsInstagramEligibleField () {
      return this.requestIsInstagramEligibleField(true);
    }
    public APIRequestGetTagged requestIsInstagramEligibleField (boolean value) {
      this.requestField("is_instagram_eligible", value);
      return this;
    }
    public APIRequestGetTagged requestIsPopularField () {
      return this.requestIsPopularField(true);
    }
    public APIRequestGetTagged requestIsPopularField (boolean value) {
      this.requestField("is_popular", value);
      return this;
    }
    public APIRequestGetTagged requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetTagged requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetTagged requestIsSphericalField () {
      return this.requestIsSphericalField(true);
    }
    public APIRequestGetTagged requestIsSphericalField (boolean value) {
      this.requestField("is_spherical", value);
      return this;
    }
    public APIRequestGetTagged requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetTagged requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetTagged requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGetTagged requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGetTagged requestMessageTagsField () {
      return this.requestMessageTagsField(true);
    }
    public APIRequestGetTagged requestMessageTagsField (boolean value) {
      this.requestField("message_tags", value);
      return this;
    }
    public APIRequestGetTagged requestMultiShareEndCardField () {
      return this.requestMultiShareEndCardField(true);
    }
    public APIRequestGetTagged requestMultiShareEndCardField (boolean value) {
      this.requestField("multi_share_end_card", value);
      return this;
    }
    public APIRequestGetTagged requestMultiShareOptimizedField () {
      return this.requestMultiShareOptimizedField(true);
    }
    public APIRequestGetTagged requestMultiShareOptimizedField (boolean value) {
      this.requestField("multi_share_optimized", value);
      return this;
    }
    public APIRequestGetTagged requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetTagged requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetTagged requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetTagged requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetTagged requestParentIdField () {
      return this.requestParentIdField(true);
    }
    public APIRequestGetTagged requestParentIdField (boolean value) {
      this.requestField("parent_id", value);
      return this;
    }
    public APIRequestGetTagged requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGetTagged requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGetTagged requestPictureField () {
      return this.requestPictureField(true);
    }
    public APIRequestGetTagged requestPictureField (boolean value) {
      this.requestField("picture", value);
      return this;
    }
    public APIRequestGetTagged requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGetTagged requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGetTagged requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGetTagged requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
      return this;
    }
    public APIRequestGetTagged requestPromotableIdField () {
      return this.requestPromotableIdField(true);
    }
    public APIRequestGetTagged requestPromotableIdField (boolean value) {
      this.requestField("promotable_id", value);
      return this;
    }
    public APIRequestGetTagged requestPromotionStatusField () {
      return this.requestPromotionStatusField(true);
    }
    public APIRequestGetTagged requestPromotionStatusField (boolean value) {
      this.requestField("promotion_status", value);
      return this;
    }
    public APIRequestGetTagged requestPropertiesField () {
      return this.requestPropertiesField(true);
    }
    public APIRequestGetTagged requestPropertiesField (boolean value) {
      this.requestField("properties", value);
      return this;
    }
    public APIRequestGetTagged requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGetTagged requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
      return this;
    }
    public APIRequestGetTagged requestSharesField () {
      return this.requestSharesField(true);
    }
    public APIRequestGetTagged requestSharesField (boolean value) {
      this.requestField("shares", value);
      return this;
    }
    public APIRequestGetTagged requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetTagged requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetTagged requestStatusTypeField () {
      return this.requestStatusTypeField(true);
    }
    public APIRequestGetTagged requestStatusTypeField (boolean value) {
      this.requestField("status_type", value);
      return this;
    }
    public APIRequestGetTagged requestStoryField () {
      return this.requestStoryField(true);
    }
    public APIRequestGetTagged requestStoryField (boolean value) {
      this.requestField("story", value);
      return this;
    }
    public APIRequestGetTagged requestStoryTagsField () {
      return this.requestStoryTagsField(true);
    }
    public APIRequestGetTagged requestStoryTagsField (boolean value) {
      this.requestField("story_tags", value);
      return this;
    }
    public APIRequestGetTagged requestSubscribedField () {
      return this.requestSubscribedField(true);
    }
    public APIRequestGetTagged requestSubscribedField (boolean value) {
      this.requestField("subscribed", value);
      return this;
    }
    public APIRequestGetTagged requestTargetField () {
      return this.requestTargetField(true);
    }
    public APIRequestGetTagged requestTargetField (boolean value) {
      this.requestField("target", value);
      return this;
    }
    public APIRequestGetTagged requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetTagged requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetTagged requestTimelineVisibilityField () {
      return this.requestTimelineVisibilityField(true);
    }
    public APIRequestGetTagged requestTimelineVisibilityField (boolean value) {
      this.requestField("timeline_visibility", value);
      return this;
    }
    public APIRequestGetTagged requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetTagged requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetTagged requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetTagged requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetTagged requestViaField () {
      return this.requestViaField(true);
    }
    public APIRequestGetTagged requestViaField (boolean value) {
      this.requestField("via", value);
      return this;
    }
    public APIRequestGetTagged requestVideoBuyingEligibilityField () {
      return this.requestVideoBuyingEligibilityField(true);
    }
    public APIRequestGetTagged requestVideoBuyingEligibilityField (boolean value) {
      this.requestField("video_buying_eligibility", value);
      return this;
    }
    public APIRequestGetTagged requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetTagged requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
  }

  public static class APIRequestCreateThreadSetting extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_linking_url",
      "call_to_actions",
      "domain_action_type",
      "greeting",
      "payment_dev_mode_action",
      "payment_privacy_url",
      "payment_public_key",
      "payment_testers",
      "setting_type",
      "thread_state",
      "whitelisted_domains",
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
               return APIRequestCreateThreadSetting.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateThreadSetting(String nodeId, APIContext context) {
      super(context, nodeId, "/thread_settings", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateThreadSetting setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateThreadSetting setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateThreadSetting setAccountLinkingUrl (String accountLinkingUrl) {
      this.setParam("account_linking_url", accountLinkingUrl);
      return this;
    }

    public APIRequestCreateThreadSetting setCallToActions (List<Object> callToActions) {
      this.setParam("call_to_actions", callToActions);
      return this;
    }
    public APIRequestCreateThreadSetting setCallToActions (String callToActions) {
      this.setParam("call_to_actions", callToActions);
      return this;
    }

    public APIRequestCreateThreadSetting setDomainActionType (EnumDomainActionType domainActionType) {
      this.setParam("domain_action_type", domainActionType);
      return this;
    }
    public APIRequestCreateThreadSetting setDomainActionType (String domainActionType) {
      this.setParam("domain_action_type", domainActionType);
      return this;
    }

    public APIRequestCreateThreadSetting setGreeting (Object greeting) {
      this.setParam("greeting", greeting);
      return this;
    }
    public APIRequestCreateThreadSetting setGreeting (String greeting) {
      this.setParam("greeting", greeting);
      return this;
    }

    public APIRequestCreateThreadSetting setPaymentDevModeAction (EnumPaymentDevModeAction paymentDevModeAction) {
      this.setParam("payment_dev_mode_action", paymentDevModeAction);
      return this;
    }
    public APIRequestCreateThreadSetting setPaymentDevModeAction (String paymentDevModeAction) {
      this.setParam("payment_dev_mode_action", paymentDevModeAction);
      return this;
    }

    public APIRequestCreateThreadSetting setPaymentPrivacyUrl (String paymentPrivacyUrl) {
      this.setParam("payment_privacy_url", paymentPrivacyUrl);
      return this;
    }

    public APIRequestCreateThreadSetting setPaymentPublicKey (String paymentPublicKey) {
      this.setParam("payment_public_key", paymentPublicKey);
      return this;
    }

    public APIRequestCreateThreadSetting setPaymentTesters (List<String> paymentTesters) {
      this.setParam("payment_testers", paymentTesters);
      return this;
    }
    public APIRequestCreateThreadSetting setPaymentTesters (String paymentTesters) {
      this.setParam("payment_testers", paymentTesters);
      return this;
    }

    public APIRequestCreateThreadSetting setSettingType (EnumSettingType settingType) {
      this.setParam("setting_type", settingType);
      return this;
    }
    public APIRequestCreateThreadSetting setSettingType (String settingType) {
      this.setParam("setting_type", settingType);
      return this;
    }

    public APIRequestCreateThreadSetting setThreadState (EnumThreadState threadState) {
      this.setParam("thread_state", threadState);
      return this;
    }
    public APIRequestCreateThreadSetting setThreadState (String threadState) {
      this.setParam("thread_state", threadState);
      return this;
    }

    public APIRequestCreateThreadSetting setWhitelistedDomains (List<String> whitelistedDomains) {
      this.setParam("whitelisted_domains", whitelistedDomains);
      return this;
    }
    public APIRequestCreateThreadSetting setWhitelistedDomains (String whitelistedDomains) {
      this.setParam("whitelisted_domains", whitelistedDomains);
      return this;
    }

    public APIRequestCreateThreadSetting requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateThreadSetting requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateThreadSetting requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateThreadSetting requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateThreadSetting requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateThreadSetting requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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

  public static class APIRequestGetUpcomingChanges extends APIRequest<PageUpcomingChange> {

    APINodeList<PageUpcomingChange> lastResponse = null;
    @Override
    public APINodeList<PageUpcomingChange> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "include_inactive",
    };

    public static final String[] FIELDS = {
      "change_type",
      "effective_time",
      "id",
      "page",
      "proposal",
      "timer_status",
    };

    @Override
    public APINodeList<PageUpcomingChange> parseResponse(String response) throws APIException {
      return PageUpcomingChange.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<PageUpcomingChange> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<PageUpcomingChange> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<PageUpcomingChange>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<PageUpcomingChange>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<PageUpcomingChange>>() {
           public APINodeList<PageUpcomingChange> apply(String result) {
             try {
               return APIRequestGetUpcomingChanges.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetUpcomingChanges(String nodeId, APIContext context) {
      super(context, nodeId, "/upcoming_changes", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetUpcomingChanges setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetUpcomingChanges setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetUpcomingChanges setIncludeInactive (Boolean includeInactive) {
      this.setParam("include_inactive", includeInactive);
      return this;
    }
    public APIRequestGetUpcomingChanges setIncludeInactive (String includeInactive) {
      this.setParam("include_inactive", includeInactive);
      return this;
    }

    public APIRequestGetUpcomingChanges requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetUpcomingChanges requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUpcomingChanges requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetUpcomingChanges requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUpcomingChanges requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetUpcomingChanges requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetUpcomingChanges requestChangeTypeField () {
      return this.requestChangeTypeField(true);
    }
    public APIRequestGetUpcomingChanges requestChangeTypeField (boolean value) {
      this.requestField("change_type", value);
      return this;
    }
    public APIRequestGetUpcomingChanges requestEffectiveTimeField () {
      return this.requestEffectiveTimeField(true);
    }
    public APIRequestGetUpcomingChanges requestEffectiveTimeField (boolean value) {
      this.requestField("effective_time", value);
      return this;
    }
    public APIRequestGetUpcomingChanges requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetUpcomingChanges requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetUpcomingChanges requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGetUpcomingChanges requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
    public APIRequestGetUpcomingChanges requestProposalField () {
      return this.requestProposalField(true);
    }
    public APIRequestGetUpcomingChanges requestProposalField (boolean value) {
      this.requestField("proposal", value);
      return this;
    }
    public APIRequestGetUpcomingChanges requestTimerStatusField () {
      return this.requestTimerStatusField(true);
    }
    public APIRequestGetUpcomingChanges requestTimerStatusField (boolean value) {
      this.requestField("timer_status", value);
      return this;
    }
  }

  public static class APIRequestGetVideoCopyrightRules extends APIRequest<VideoCopyrightRule> {

    APINodeList<VideoCopyrightRule> lastResponse = null;
    @Override
    public APINodeList<VideoCopyrightRule> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "selected_rule_id",
      "source",
    };

    public static final String[] FIELDS = {
      "condition_groups",
      "copyrights",
      "created_date",
      "creator",
      "id",
      "is_in_migration",
      "name",
    };

    @Override
    public APINodeList<VideoCopyrightRule> parseResponse(String response) throws APIException {
      return VideoCopyrightRule.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<VideoCopyrightRule> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<VideoCopyrightRule> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<VideoCopyrightRule>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<VideoCopyrightRule>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<VideoCopyrightRule>>() {
           public APINodeList<VideoCopyrightRule> apply(String result) {
             try {
               return APIRequestGetVideoCopyrightRules.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetVideoCopyrightRules(String nodeId, APIContext context) {
      super(context, nodeId, "/video_copyright_rules", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetVideoCopyrightRules setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetVideoCopyrightRules setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetVideoCopyrightRules setSelectedRuleId (String selectedRuleId) {
      this.setParam("selected_rule_id", selectedRuleId);
      return this;
    }

    public APIRequestGetVideoCopyrightRules setSource (VideoCopyrightRule.EnumSource source) {
      this.setParam("source", source);
      return this;
    }
    public APIRequestGetVideoCopyrightRules setSource (String source) {
      this.setParam("source", source);
      return this;
    }

    public APIRequestGetVideoCopyrightRules requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetVideoCopyrightRules requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideoCopyrightRules requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetVideoCopyrightRules requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideoCopyrightRules requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetVideoCopyrightRules requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetVideoCopyrightRules requestConditionGroupsField () {
      return this.requestConditionGroupsField(true);
    }
    public APIRequestGetVideoCopyrightRules requestConditionGroupsField (boolean value) {
      this.requestField("condition_groups", value);
      return this;
    }
    public APIRequestGetVideoCopyrightRules requestCopyrightsField () {
      return this.requestCopyrightsField(true);
    }
    public APIRequestGetVideoCopyrightRules requestCopyrightsField (boolean value) {
      this.requestField("copyrights", value);
      return this;
    }
    public APIRequestGetVideoCopyrightRules requestCreatedDateField () {
      return this.requestCreatedDateField(true);
    }
    public APIRequestGetVideoCopyrightRules requestCreatedDateField (boolean value) {
      this.requestField("created_date", value);
      return this;
    }
    public APIRequestGetVideoCopyrightRules requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetVideoCopyrightRules requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetVideoCopyrightRules requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetVideoCopyrightRules requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetVideoCopyrightRules requestIsInMigrationField () {
      return this.requestIsInMigrationField(true);
    }
    public APIRequestGetVideoCopyrightRules requestIsInMigrationField (boolean value) {
      this.requestField("is_in_migration", value);
      return this;
    }
    public APIRequestGetVideoCopyrightRules requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetVideoCopyrightRules requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
  }

  public static class APIRequestCreateVideoCopyrightRule extends APIRequest<VideoCopyrightRule> {

    VideoCopyrightRule lastResponse = null;
    @Override
    public VideoCopyrightRule getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "condition_groups",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public VideoCopyrightRule parseResponse(String response) throws APIException {
      return VideoCopyrightRule.parseResponse(response, getContext(), this).head();
    }

    @Override
    public VideoCopyrightRule execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public VideoCopyrightRule execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<VideoCopyrightRule> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<VideoCopyrightRule> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, VideoCopyrightRule>() {
           public VideoCopyrightRule apply(String result) {
             try {
               return APIRequestCreateVideoCopyrightRule.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateVideoCopyrightRule(String nodeId, APIContext context) {
      super(context, nodeId, "/video_copyright_rules", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateVideoCopyrightRule setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateVideoCopyrightRule setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateVideoCopyrightRule setConditionGroups (List<Object> conditionGroups) {
      this.setParam("condition_groups", conditionGroups);
      return this;
    }
    public APIRequestCreateVideoCopyrightRule setConditionGroups (String conditionGroups) {
      this.setParam("condition_groups", conditionGroups);
      return this;
    }

    public APIRequestCreateVideoCopyrightRule setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateVideoCopyrightRule requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateVideoCopyrightRule requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideoCopyrightRule requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateVideoCopyrightRule requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideoCopyrightRule requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateVideoCopyrightRule requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetVideoCopyrights extends APIRequest<VideoCopyright> {

    APINodeList<VideoCopyright> lastResponse = null;
    @Override
    public APINodeList<VideoCopyright> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "use_fallback",
    };

    public static final String[] FIELDS = {
      "content_category",
      "copyright_content_id",
      "creator",
      "id",
      "in_conflict",
      "monitoring_status",
      "monitoring_type",
      "ownership_countries",
      "reference_file",
      "reference_file_disabled",
      "reference_file_disabled_by_ops",
      "reference_file_expired",
      "reference_owner_id",
      "rule_ids",
      "whitelisted_ids",
    };

    @Override
    public APINodeList<VideoCopyright> parseResponse(String response) throws APIException {
      return VideoCopyright.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<VideoCopyright> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<VideoCopyright> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<VideoCopyright>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<VideoCopyright>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<VideoCopyright>>() {
           public APINodeList<VideoCopyright> apply(String result) {
             try {
               return APIRequestGetVideoCopyrights.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetVideoCopyrights(String nodeId, APIContext context) {
      super(context, nodeId, "/video_copyrights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetVideoCopyrights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetVideoCopyrights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetVideoCopyrights setUseFallback (Boolean useFallback) {
      this.setParam("use_fallback", useFallback);
      return this;
    }
    public APIRequestGetVideoCopyrights setUseFallback (String useFallback) {
      this.setParam("use_fallback", useFallback);
      return this;
    }

    public APIRequestGetVideoCopyrights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetVideoCopyrights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideoCopyrights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetVideoCopyrights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideoCopyrights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetVideoCopyrights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetVideoCopyrights requestContentCategoryField () {
      return this.requestContentCategoryField(true);
    }
    public APIRequestGetVideoCopyrights requestContentCategoryField (boolean value) {
      this.requestField("content_category", value);
      return this;
    }
    public APIRequestGetVideoCopyrights requestCopyrightContentIdField () {
      return this.requestCopyrightContentIdField(true);
    }
    public APIRequestGetVideoCopyrights requestCopyrightContentIdField (boolean value) {
      this.requestField("copyright_content_id", value);
      return this;
    }
    public APIRequestGetVideoCopyrights requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetVideoCopyrights requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetVideoCopyrights requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetVideoCopyrights requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetVideoCopyrights requestInConflictField () {
      return this.requestInConflictField(true);
    }
    public APIRequestGetVideoCopyrights requestInConflictField (boolean value) {
      this.requestField("in_conflict", value);
      return this;
    }
    public APIRequestGetVideoCopyrights requestMonitoringStatusField () {
      return this.requestMonitoringStatusField(true);
    }
    public APIRequestGetVideoCopyrights requestMonitoringStatusField (boolean value) {
      this.requestField("monitoring_status", value);
      return this;
    }
    public APIRequestGetVideoCopyrights requestMonitoringTypeField () {
      return this.requestMonitoringTypeField(true);
    }
    public APIRequestGetVideoCopyrights requestMonitoringTypeField (boolean value) {
      this.requestField("monitoring_type", value);
      return this;
    }
    public APIRequestGetVideoCopyrights requestOwnershipCountriesField () {
      return this.requestOwnershipCountriesField(true);
    }
    public APIRequestGetVideoCopyrights requestOwnershipCountriesField (boolean value) {
      this.requestField("ownership_countries", value);
      return this;
    }
    public APIRequestGetVideoCopyrights requestReferenceFileField () {
      return this.requestReferenceFileField(true);
    }
    public APIRequestGetVideoCopyrights requestReferenceFileField (boolean value) {
      this.requestField("reference_file", value);
      return this;
    }
    public APIRequestGetVideoCopyrights requestReferenceFileDisabledField () {
      return this.requestReferenceFileDisabledField(true);
    }
    public APIRequestGetVideoCopyrights requestReferenceFileDisabledField (boolean value) {
      this.requestField("reference_file_disabled", value);
      return this;
    }
    public APIRequestGetVideoCopyrights requestReferenceFileDisabledByOpsField () {
      return this.requestReferenceFileDisabledByOpsField(true);
    }
    public APIRequestGetVideoCopyrights requestReferenceFileDisabledByOpsField (boolean value) {
      this.requestField("reference_file_disabled_by_ops", value);
      return this;
    }
    public APIRequestGetVideoCopyrights requestReferenceFileExpiredField () {
      return this.requestReferenceFileExpiredField(true);
    }
    public APIRequestGetVideoCopyrights requestReferenceFileExpiredField (boolean value) {
      this.requestField("reference_file_expired", value);
      return this;
    }
    public APIRequestGetVideoCopyrights requestReferenceOwnerIdField () {
      return this.requestReferenceOwnerIdField(true);
    }
    public APIRequestGetVideoCopyrights requestReferenceOwnerIdField (boolean value) {
      this.requestField("reference_owner_id", value);
      return this;
    }
    public APIRequestGetVideoCopyrights requestRuleIdsField () {
      return this.requestRuleIdsField(true);
    }
    public APIRequestGetVideoCopyrights requestRuleIdsField (boolean value) {
      this.requestField("rule_ids", value);
      return this;
    }
    public APIRequestGetVideoCopyrights requestWhitelistedIdsField () {
      return this.requestWhitelistedIdsField(true);
    }
    public APIRequestGetVideoCopyrights requestWhitelistedIdsField (boolean value) {
      this.requestField("whitelisted_ids", value);
      return this;
    }
  }

  public static class APIRequestCreateVideoCopyright extends APIRequest<VideoCopyright> {

    VideoCopyright lastResponse = null;
    @Override
    public VideoCopyright getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "attribution_id",
      "content_category",
      "copyright_content_id",
      "excluded_ownership_countries",
      "excluded_ownership_segments",
      "fingerprint_id",
      "is_reference_disabled",
      "is_reference_video",
      "monitoring_type",
      "ownership_countries",
      "rule_id",
      "whitelisted_ids",
      "whitelisted_ig_user_ids",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public VideoCopyright parseResponse(String response) throws APIException {
      return VideoCopyright.parseResponse(response, getContext(), this).head();
    }

    @Override
    public VideoCopyright execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public VideoCopyright execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<VideoCopyright> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<VideoCopyright> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, VideoCopyright>() {
           public VideoCopyright apply(String result) {
             try {
               return APIRequestCreateVideoCopyright.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateVideoCopyright(String nodeId, APIContext context) {
      super(context, nodeId, "/video_copyrights", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateVideoCopyright setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateVideoCopyright setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateVideoCopyright setAttributionId (String attributionId) {
      this.setParam("attribution_id", attributionId);
      return this;
    }

    public APIRequestCreateVideoCopyright setContentCategory (VideoCopyright.EnumContentCategory contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }
    public APIRequestCreateVideoCopyright setContentCategory (String contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }

    public APIRequestCreateVideoCopyright setCopyrightContentId (String copyrightContentId) {
      this.setParam("copyright_content_id", copyrightContentId);
      return this;
    }

    public APIRequestCreateVideoCopyright setExcludedOwnershipCountries (List<String> excludedOwnershipCountries) {
      this.setParam("excluded_ownership_countries", excludedOwnershipCountries);
      return this;
    }
    public APIRequestCreateVideoCopyright setExcludedOwnershipCountries (String excludedOwnershipCountries) {
      this.setParam("excluded_ownership_countries", excludedOwnershipCountries);
      return this;
    }

    public APIRequestCreateVideoCopyright setExcludedOwnershipSegments (List<Object> excludedOwnershipSegments) {
      this.setParam("excluded_ownership_segments", excludedOwnershipSegments);
      return this;
    }
    public APIRequestCreateVideoCopyright setExcludedOwnershipSegments (String excludedOwnershipSegments) {
      this.setParam("excluded_ownership_segments", excludedOwnershipSegments);
      return this;
    }

    public APIRequestCreateVideoCopyright setFingerprintId (String fingerprintId) {
      this.setParam("fingerprint_id", fingerprintId);
      return this;
    }

    public APIRequestCreateVideoCopyright setIsReferenceDisabled (Boolean isReferenceDisabled) {
      this.setParam("is_reference_disabled", isReferenceDisabled);
      return this;
    }
    public APIRequestCreateVideoCopyright setIsReferenceDisabled (String isReferenceDisabled) {
      this.setParam("is_reference_disabled", isReferenceDisabled);
      return this;
    }

    public APIRequestCreateVideoCopyright setIsReferenceVideo (Boolean isReferenceVideo) {
      this.setParam("is_reference_video", isReferenceVideo);
      return this;
    }
    public APIRequestCreateVideoCopyright setIsReferenceVideo (String isReferenceVideo) {
      this.setParam("is_reference_video", isReferenceVideo);
      return this;
    }

    public APIRequestCreateVideoCopyright setMonitoringType (VideoCopyright.EnumMonitoringType monitoringType) {
      this.setParam("monitoring_type", monitoringType);
      return this;
    }
    public APIRequestCreateVideoCopyright setMonitoringType (String monitoringType) {
      this.setParam("monitoring_type", monitoringType);
      return this;
    }

    public APIRequestCreateVideoCopyright setOwnershipCountries (List<String> ownershipCountries) {
      this.setParam("ownership_countries", ownershipCountries);
      return this;
    }
    public APIRequestCreateVideoCopyright setOwnershipCountries (String ownershipCountries) {
      this.setParam("ownership_countries", ownershipCountries);
      return this;
    }

    public APIRequestCreateVideoCopyright setRuleId (String ruleId) {
      this.setParam("rule_id", ruleId);
      return this;
    }

    public APIRequestCreateVideoCopyright setWhitelistedIds (List<String> whitelistedIds) {
      this.setParam("whitelisted_ids", whitelistedIds);
      return this;
    }
    public APIRequestCreateVideoCopyright setWhitelistedIds (String whitelistedIds) {
      this.setParam("whitelisted_ids", whitelistedIds);
      return this;
    }

    public APIRequestCreateVideoCopyright setWhitelistedIgUserIds (List<String> whitelistedIgUserIds) {
      this.setParam("whitelisted_ig_user_ids", whitelistedIgUserIds);
      return this;
    }
    public APIRequestCreateVideoCopyright setWhitelistedIgUserIds (String whitelistedIgUserIds) {
      this.setParam("whitelisted_ig_user_ids", whitelistedIgUserIds);
      return this;
    }

    public APIRequestCreateVideoCopyright requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateVideoCopyright requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideoCopyright requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateVideoCopyright requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideoCopyright requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateVideoCopyright requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteVideoLists extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "video_list_id",
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

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteVideoLists.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteVideoLists(String nodeId, APIContext context) {
      super(context, nodeId, "/video_lists", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteVideoLists setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteVideoLists setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteVideoLists setVideoListId (String videoListId) {
      this.setParam("video_list_id", videoListId);
      return this;
    }

    public APIRequestDeleteVideoLists requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteVideoLists requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteVideoLists requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteVideoLists requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteVideoLists requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteVideoLists requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateVideoList extends APIRequest<VideoList> {

    VideoList lastResponse = null;
    @Override
    public VideoList getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "description",
      "title",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public VideoList parseResponse(String response) throws APIException {
      return VideoList.parseResponse(response, getContext(), this).head();
    }

    @Override
    public VideoList execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public VideoList execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<VideoList> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<VideoList> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, VideoList>() {
           public VideoList apply(String result) {
             try {
               return APIRequestCreateVideoList.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateVideoList(String nodeId, APIContext context) {
      super(context, nodeId, "/video_lists", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateVideoList setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateVideoList setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateVideoList setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateVideoList setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateVideoList requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateVideoList requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideoList requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateVideoList requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideoList requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateVideoList requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetVideoMediaCopyrights extends APIRequest<VideoCopyright> {

    APINodeList<VideoCopyright> lastResponse = null;
    @Override
    public APINodeList<VideoCopyright> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "content_category",
      "copyright_content_id",
      "creator",
      "id",
      "in_conflict",
      "monitoring_status",
      "monitoring_type",
      "ownership_countries",
      "reference_file",
      "reference_file_disabled",
      "reference_file_disabled_by_ops",
      "reference_file_expired",
      "reference_owner_id",
      "rule_ids",
      "whitelisted_ids",
    };

    @Override
    public APINodeList<VideoCopyright> parseResponse(String response) throws APIException {
      return VideoCopyright.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<VideoCopyright> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<VideoCopyright> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<VideoCopyright>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<VideoCopyright>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<VideoCopyright>>() {
           public APINodeList<VideoCopyright> apply(String result) {
             try {
               return APIRequestGetVideoMediaCopyrights.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetVideoMediaCopyrights(String nodeId, APIContext context) {
      super(context, nodeId, "/video_media_copyrights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetVideoMediaCopyrights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetVideoMediaCopyrights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetVideoMediaCopyrights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetVideoMediaCopyrights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideoMediaCopyrights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetVideoMediaCopyrights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideoMediaCopyrights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetVideoMediaCopyrights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetVideoMediaCopyrights requestContentCategoryField () {
      return this.requestContentCategoryField(true);
    }
    public APIRequestGetVideoMediaCopyrights requestContentCategoryField (boolean value) {
      this.requestField("content_category", value);
      return this;
    }
    public APIRequestGetVideoMediaCopyrights requestCopyrightContentIdField () {
      return this.requestCopyrightContentIdField(true);
    }
    public APIRequestGetVideoMediaCopyrights requestCopyrightContentIdField (boolean value) {
      this.requestField("copyright_content_id", value);
      return this;
    }
    public APIRequestGetVideoMediaCopyrights requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetVideoMediaCopyrights requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetVideoMediaCopyrights requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetVideoMediaCopyrights requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetVideoMediaCopyrights requestInConflictField () {
      return this.requestInConflictField(true);
    }
    public APIRequestGetVideoMediaCopyrights requestInConflictField (boolean value) {
      this.requestField("in_conflict", value);
      return this;
    }
    public APIRequestGetVideoMediaCopyrights requestMonitoringStatusField () {
      return this.requestMonitoringStatusField(true);
    }
    public APIRequestGetVideoMediaCopyrights requestMonitoringStatusField (boolean value) {
      this.requestField("monitoring_status", value);
      return this;
    }
    public APIRequestGetVideoMediaCopyrights requestMonitoringTypeField () {
      return this.requestMonitoringTypeField(true);
    }
    public APIRequestGetVideoMediaCopyrights requestMonitoringTypeField (boolean value) {
      this.requestField("monitoring_type", value);
      return this;
    }
    public APIRequestGetVideoMediaCopyrights requestOwnershipCountriesField () {
      return this.requestOwnershipCountriesField(true);
    }
    public APIRequestGetVideoMediaCopyrights requestOwnershipCountriesField (boolean value) {
      this.requestField("ownership_countries", value);
      return this;
    }
    public APIRequestGetVideoMediaCopyrights requestReferenceFileField () {
      return this.requestReferenceFileField(true);
    }
    public APIRequestGetVideoMediaCopyrights requestReferenceFileField (boolean value) {
      this.requestField("reference_file", value);
      return this;
    }
    public APIRequestGetVideoMediaCopyrights requestReferenceFileDisabledField () {
      return this.requestReferenceFileDisabledField(true);
    }
    public APIRequestGetVideoMediaCopyrights requestReferenceFileDisabledField (boolean value) {
      this.requestField("reference_file_disabled", value);
      return this;
    }
    public APIRequestGetVideoMediaCopyrights requestReferenceFileDisabledByOpsField () {
      return this.requestReferenceFileDisabledByOpsField(true);
    }
    public APIRequestGetVideoMediaCopyrights requestReferenceFileDisabledByOpsField (boolean value) {
      this.requestField("reference_file_disabled_by_ops", value);
      return this;
    }
    public APIRequestGetVideoMediaCopyrights requestReferenceFileExpiredField () {
      return this.requestReferenceFileExpiredField(true);
    }
    public APIRequestGetVideoMediaCopyrights requestReferenceFileExpiredField (boolean value) {
      this.requestField("reference_file_expired", value);
      return this;
    }
    public APIRequestGetVideoMediaCopyrights requestReferenceOwnerIdField () {
      return this.requestReferenceOwnerIdField(true);
    }
    public APIRequestGetVideoMediaCopyrights requestReferenceOwnerIdField (boolean value) {
      this.requestField("reference_owner_id", value);
      return this;
    }
    public APIRequestGetVideoMediaCopyrights requestRuleIdsField () {
      return this.requestRuleIdsField(true);
    }
    public APIRequestGetVideoMediaCopyrights requestRuleIdsField (boolean value) {
      this.requestField("rule_ids", value);
      return this;
    }
    public APIRequestGetVideoMediaCopyrights requestWhitelistedIdsField () {
      return this.requestWhitelistedIdsField(true);
    }
    public APIRequestGetVideoMediaCopyrights requestWhitelistedIdsField (boolean value) {
      this.requestField("whitelisted_ids", value);
      return this;
    }
  }

  public static class APIRequestGetVideos extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "type",
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

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestGetVideos.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetVideos(String nodeId, APIContext context) {
      super(context, nodeId, "/videos", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetVideos setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetVideos setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetVideos setType (EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestGetVideos setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestGetVideos requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetVideos requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideos requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetVideos requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideos requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetVideos requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateVideo extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_breaks",
      "audio_story_wave_animation_handle",
      "backdated_post",
      "content_category",
      "content_tags",
      "crossposted_video_id",
      "custom_labels",
      "description",
      "direct_share_status",
      "embeddable",
      "end_offset",
      "expiration",
      "feed_targeting",
      "file_size",
      "file_url",
      "fisheye_video_cropped",
      "fov",
      "front_z_rotation",
      "guide",
      "guide_enabled",
      "initial_heading",
      "initial_pitch",
      "is_voice_clip",
      "multilingual_data",
      "no_story",
      "original_fov",
      "original_projection_type",
      "published",
      "react_mode_metadata",
      "reference_only",
      "referenced_sticker_id",
      "replace_video_id",
      "scheduled_publish_time",
      "secret",
      "slideshow_spec",
      "social_actions",
      "source",
      "specified_dialect",
      "spherical",
      "sponsor_id",
      "sponsor_relationship",
      "start_offset",
      "swap_mode",
      "targeting",
      "thumb",
      "title",
      "universal_video_id",
      "unpublished_content_type",
      "upload_phase",
      "upload_session_id",
      "video_file_chunk",
      "xpost_everstore_handle",
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
               return APIRequestCreateVideo.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateVideo(String nodeId, APIContext context) {
      super(context, nodeId, "/videos", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateVideo setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateVideo setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateVideo setAdBreaks (Object adBreaks) {
      this.setParam("ad_breaks", adBreaks);
      return this;
    }
    public APIRequestCreateVideo setAdBreaks (String adBreaks) {
      this.setParam("ad_breaks", adBreaks);
      return this;
    }

    public APIRequestCreateVideo setAudioStoryWaveAnimationHandle (String audioStoryWaveAnimationHandle) {
      this.setParam("audio_story_wave_animation_handle", audioStoryWaveAnimationHandle);
      return this;
    }

    public APIRequestCreateVideo setBackdatedPost (Object backdatedPost) {
      this.setParam("backdated_post", backdatedPost);
      return this;
    }
    public APIRequestCreateVideo setBackdatedPost (String backdatedPost) {
      this.setParam("backdated_post", backdatedPost);
      return this;
    }

    public APIRequestCreateVideo setContentCategory (EnumContentCategory contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }
    public APIRequestCreateVideo setContentCategory (String contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }

    public APIRequestCreateVideo setContentTags (List<String> contentTags) {
      this.setParam("content_tags", contentTags);
      return this;
    }
    public APIRequestCreateVideo setContentTags (String contentTags) {
      this.setParam("content_tags", contentTags);
      return this;
    }

    public APIRequestCreateVideo setCrosspostedVideoId (String crosspostedVideoId) {
      this.setParam("crossposted_video_id", crosspostedVideoId);
      return this;
    }

    public APIRequestCreateVideo setCustomLabels (List<String> customLabels) {
      this.setParam("custom_labels", customLabels);
      return this;
    }
    public APIRequestCreateVideo setCustomLabels (String customLabels) {
      this.setParam("custom_labels", customLabels);
      return this;
    }

    public APIRequestCreateVideo setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateVideo setDirectShareStatus (Long directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }
    public APIRequestCreateVideo setDirectShareStatus (String directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }

    public APIRequestCreateVideo setEmbeddable (Boolean embeddable) {
      this.setParam("embeddable", embeddable);
      return this;
    }
    public APIRequestCreateVideo setEmbeddable (String embeddable) {
      this.setParam("embeddable", embeddable);
      return this;
    }

    public APIRequestCreateVideo setEndOffset (Long endOffset) {
      this.setParam("end_offset", endOffset);
      return this;
    }
    public APIRequestCreateVideo setEndOffset (String endOffset) {
      this.setParam("end_offset", endOffset);
      return this;
    }

    public APIRequestCreateVideo setExpiration (Object expiration) {
      this.setParam("expiration", expiration);
      return this;
    }
    public APIRequestCreateVideo setExpiration (String expiration) {
      this.setParam("expiration", expiration);
      return this;
    }

    public APIRequestCreateVideo setFeedTargeting (Object feedTargeting) {
      this.setParam("feed_targeting", feedTargeting);
      return this;
    }
    public APIRequestCreateVideo setFeedTargeting (String feedTargeting) {
      this.setParam("feed_targeting", feedTargeting);
      return this;
    }

    public APIRequestCreateVideo setFileSize (Long fileSize) {
      this.setParam("file_size", fileSize);
      return this;
    }
    public APIRequestCreateVideo setFileSize (String fileSize) {
      this.setParam("file_size", fileSize);
      return this;
    }

    public APIRequestCreateVideo setFileUrl (String fileUrl) {
      this.setParam("file_url", fileUrl);
      return this;
    }

    public APIRequestCreateVideo setFisheyeVideoCropped (Boolean fisheyeVideoCropped) {
      this.setParam("fisheye_video_cropped", fisheyeVideoCropped);
      return this;
    }
    public APIRequestCreateVideo setFisheyeVideoCropped (String fisheyeVideoCropped) {
      this.setParam("fisheye_video_cropped", fisheyeVideoCropped);
      return this;
    }

    public APIRequestCreateVideo setFov (Long fov) {
      this.setParam("fov", fov);
      return this;
    }
    public APIRequestCreateVideo setFov (String fov) {
      this.setParam("fov", fov);
      return this;
    }

    public APIRequestCreateVideo setFrontZRotation (Double frontZRotation) {
      this.setParam("front_z_rotation", frontZRotation);
      return this;
    }
    public APIRequestCreateVideo setFrontZRotation (String frontZRotation) {
      this.setParam("front_z_rotation", frontZRotation);
      return this;
    }

    public APIRequestCreateVideo setGuide (List<List<Long>> guide) {
      this.setParam("guide", guide);
      return this;
    }
    public APIRequestCreateVideo setGuide (String guide) {
      this.setParam("guide", guide);
      return this;
    }

    public APIRequestCreateVideo setGuideEnabled (Boolean guideEnabled) {
      this.setParam("guide_enabled", guideEnabled);
      return this;
    }
    public APIRequestCreateVideo setGuideEnabled (String guideEnabled) {
      this.setParam("guide_enabled", guideEnabled);
      return this;
    }

    public APIRequestCreateVideo setInitialHeading (Long initialHeading) {
      this.setParam("initial_heading", initialHeading);
      return this;
    }
    public APIRequestCreateVideo setInitialHeading (String initialHeading) {
      this.setParam("initial_heading", initialHeading);
      return this;
    }

    public APIRequestCreateVideo setInitialPitch (Long initialPitch) {
      this.setParam("initial_pitch", initialPitch);
      return this;
    }
    public APIRequestCreateVideo setInitialPitch (String initialPitch) {
      this.setParam("initial_pitch", initialPitch);
      return this;
    }

    public APIRequestCreateVideo setIsVoiceClip (Boolean isVoiceClip) {
      this.setParam("is_voice_clip", isVoiceClip);
      return this;
    }
    public APIRequestCreateVideo setIsVoiceClip (String isVoiceClip) {
      this.setParam("is_voice_clip", isVoiceClip);
      return this;
    }

    public APIRequestCreateVideo setMultilingualData (List<Object> multilingualData) {
      this.setParam("multilingual_data", multilingualData);
      return this;
    }
    public APIRequestCreateVideo setMultilingualData (String multilingualData) {
      this.setParam("multilingual_data", multilingualData);
      return this;
    }

    public APIRequestCreateVideo setNoStory (Boolean noStory) {
      this.setParam("no_story", noStory);
      return this;
    }
    public APIRequestCreateVideo setNoStory (String noStory) {
      this.setParam("no_story", noStory);
      return this;
    }

    public APIRequestCreateVideo setOriginalFov (Long originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }
    public APIRequestCreateVideo setOriginalFov (String originalFov) {
      this.setParam("original_fov", originalFov);
      return this;
    }

    public APIRequestCreateVideo setOriginalProjectionType (EnumOriginalProjectionType originalProjectionType) {
      this.setParam("original_projection_type", originalProjectionType);
      return this;
    }
    public APIRequestCreateVideo setOriginalProjectionType (String originalProjectionType) {
      this.setParam("original_projection_type", originalProjectionType);
      return this;
    }

    public APIRequestCreateVideo setPublished (Boolean published) {
      this.setParam("published", published);
      return this;
    }
    public APIRequestCreateVideo setPublished (String published) {
      this.setParam("published", published);
      return this;
    }

    public APIRequestCreateVideo setReactModeMetadata (String reactModeMetadata) {
      this.setParam("react_mode_metadata", reactModeMetadata);
      return this;
    }

    public APIRequestCreateVideo setReferenceOnly (Boolean referenceOnly) {
      this.setParam("reference_only", referenceOnly);
      return this;
    }
    public APIRequestCreateVideo setReferenceOnly (String referenceOnly) {
      this.setParam("reference_only", referenceOnly);
      return this;
    }

    public APIRequestCreateVideo setReferencedStickerId (String referencedStickerId) {
      this.setParam("referenced_sticker_id", referencedStickerId);
      return this;
    }

    public APIRequestCreateVideo setReplaceVideoId (String replaceVideoId) {
      this.setParam("replace_video_id", replaceVideoId);
      return this;
    }

    public APIRequestCreateVideo setScheduledPublishTime (Long scheduledPublishTime) {
      this.setParam("scheduled_publish_time", scheduledPublishTime);
      return this;
    }
    public APIRequestCreateVideo setScheduledPublishTime (String scheduledPublishTime) {
      this.setParam("scheduled_publish_time", scheduledPublishTime);
      return this;
    }

    public APIRequestCreateVideo setSecret (Boolean secret) {
      this.setParam("secret", secret);
      return this;
    }
    public APIRequestCreateVideo setSecret (String secret) {
      this.setParam("secret", secret);
      return this;
    }

    public APIRequestCreateVideo setSlideshowSpec (Map<String, String> slideshowSpec) {
      this.setParam("slideshow_spec", slideshowSpec);
      return this;
    }
    public APIRequestCreateVideo setSlideshowSpec (String slideshowSpec) {
      this.setParam("slideshow_spec", slideshowSpec);
      return this;
    }

    public APIRequestCreateVideo setSocialActions (Boolean socialActions) {
      this.setParam("social_actions", socialActions);
      return this;
    }
    public APIRequestCreateVideo setSocialActions (String socialActions) {
      this.setParam("social_actions", socialActions);
      return this;
    }

    public APIRequestCreateVideo setSource (String source) {
      this.setParam("source", source);
      return this;
    }

    public APIRequestCreateVideo setSpecifiedDialect (String specifiedDialect) {
      this.setParam("specified_dialect", specifiedDialect);
      return this;
    }

    public APIRequestCreateVideo setSpherical (Boolean spherical) {
      this.setParam("spherical", spherical);
      return this;
    }
    public APIRequestCreateVideo setSpherical (String spherical) {
      this.setParam("spherical", spherical);
      return this;
    }

    public APIRequestCreateVideo setSponsorId (String sponsorId) {
      this.setParam("sponsor_id", sponsorId);
      return this;
    }

    public APIRequestCreateVideo setSponsorRelationship (Long sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }
    public APIRequestCreateVideo setSponsorRelationship (String sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }

    public APIRequestCreateVideo setStartOffset (Long startOffset) {
      this.setParam("start_offset", startOffset);
      return this;
    }
    public APIRequestCreateVideo setStartOffset (String startOffset) {
      this.setParam("start_offset", startOffset);
      return this;
    }

    public APIRequestCreateVideo setSwapMode (EnumSwapMode swapMode) {
      this.setParam("swap_mode", swapMode);
      return this;
    }
    public APIRequestCreateVideo setSwapMode (String swapMode) {
      this.setParam("swap_mode", swapMode);
      return this;
    }

    public APIRequestCreateVideo setTargeting (Object targeting) {
      this.setParam("targeting", targeting);
      return this;
    }
    public APIRequestCreateVideo setTargeting (String targeting) {
      this.setParam("targeting", targeting);
      return this;
    }

    public APIRequestCreateVideo setThumb (File thumb) {
      this.setParam("thumb", thumb);
      return this;
    }
    public APIRequestCreateVideo setThumb (String thumb) {
      this.setParam("thumb", thumb);
      return this;
    }

    public APIRequestCreateVideo setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestCreateVideo setUniversalVideoId (String universalVideoId) {
      this.setParam("universal_video_id", universalVideoId);
      return this;
    }

    public APIRequestCreateVideo setUnpublishedContentType (EnumUnpublishedContentType unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }
    public APIRequestCreateVideo setUnpublishedContentType (String unpublishedContentType) {
      this.setParam("unpublished_content_type", unpublishedContentType);
      return this;
    }

    public APIRequestCreateVideo setUploadPhase (EnumUploadPhase uploadPhase) {
      this.setParam("upload_phase", uploadPhase);
      return this;
    }
    public APIRequestCreateVideo setUploadPhase (String uploadPhase) {
      this.setParam("upload_phase", uploadPhase);
      return this;
    }

    public APIRequestCreateVideo setUploadSessionId (String uploadSessionId) {
      this.setParam("upload_session_id", uploadSessionId);
      return this;
    }

    public APIRequestCreateVideo setVideoFileChunk (String videoFileChunk) {
      this.setParam("video_file_chunk", videoFileChunk);
      return this;
    }

    public APIRequestCreateVideo setXpostEverstoreHandle (String xpostEverstoreHandle) {
      this.setParam("xpost_everstore_handle", xpostEverstoreHandle);
      return this;
    }

    public APIRequestCreateVideo requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateVideo requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideo requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateVideo requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideo requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateVideo requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetVisitorPosts extends APIRequest<PagePost> {

    APINodeList<PagePost> lastResponse = null;
    @Override
    public APINodeList<PagePost> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "include_hidden",
    };

    public static final String[] FIELDS = {
      "actions",
      "admin_creator",
      "allowed_advertising_objectives",
      "application",
      "backdated_time",
      "call_to_action",
      "can_reply_privately",
      "caption",
      "child_attachments",
      "comments_mirroring_domain",
      "coordinates",
      "created_time",
      "description",
      "event",
      "expanded_height",
      "expanded_width",
      "feed_targeting",
      "from",
      "full_picture",
      "height",
      "icon",
      "id",
      "instagram_eligibility",
      "is_app_share",
      "is_expired",
      "is_hidden",
      "is_instagram_eligible",
      "is_popular",
      "is_published",
      "is_spherical",
      "link",
      "message",
      "message_tags",
      "multi_share_end_card",
      "multi_share_optimized",
      "name",
      "object_id",
      "parent_id",
      "permalink_url",
      "picture",
      "place",
      "privacy",
      "promotable_id",
      "promotion_status",
      "properties",
      "scheduled_publish_time",
      "shares",
      "source",
      "status_type",
      "story",
      "story_tags",
      "subscribed",
      "target",
      "targeting",
      "timeline_visibility",
      "type",
      "updated_time",
      "via",
      "video_buying_eligibility",
      "width",
    };

    @Override
    public APINodeList<PagePost> parseResponse(String response) throws APIException {
      return PagePost.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<PagePost> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<PagePost> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<PagePost>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<PagePost>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<PagePost>>() {
           public APINodeList<PagePost> apply(String result) {
             try {
               return APIRequestGetVisitorPosts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetVisitorPosts(String nodeId, APIContext context) {
      super(context, nodeId, "/visitor_posts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetVisitorPosts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetVisitorPosts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetVisitorPosts setIncludeHidden (Boolean includeHidden) {
      this.setParam("include_hidden", includeHidden);
      return this;
    }
    public APIRequestGetVisitorPosts setIncludeHidden (String includeHidden) {
      this.setParam("include_hidden", includeHidden);
      return this;
    }

    public APIRequestGetVisitorPosts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetVisitorPosts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVisitorPosts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetVisitorPosts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVisitorPosts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetVisitorPosts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetVisitorPosts requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGetVisitorPosts requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestAdminCreatorField () {
      return this.requestAdminCreatorField(true);
    }
    public APIRequestGetVisitorPosts requestAdminCreatorField (boolean value) {
      this.requestField("admin_creator", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestAllowedAdvertisingObjectivesField () {
      return this.requestAllowedAdvertisingObjectivesField(true);
    }
    public APIRequestGetVisitorPosts requestAllowedAdvertisingObjectivesField (boolean value) {
      this.requestField("allowed_advertising_objectives", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGetVisitorPosts requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestBackdatedTimeField () {
      return this.requestBackdatedTimeField(true);
    }
    public APIRequestGetVisitorPosts requestBackdatedTimeField (boolean value) {
      this.requestField("backdated_time", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestCallToActionField () {
      return this.requestCallToActionField(true);
    }
    public APIRequestGetVisitorPosts requestCallToActionField (boolean value) {
      this.requestField("call_to_action", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestCanReplyPrivatelyField () {
      return this.requestCanReplyPrivatelyField(true);
    }
    public APIRequestGetVisitorPosts requestCanReplyPrivatelyField (boolean value) {
      this.requestField("can_reply_privately", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetVisitorPosts requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestChildAttachmentsField () {
      return this.requestChildAttachmentsField(true);
    }
    public APIRequestGetVisitorPosts requestChildAttachmentsField (boolean value) {
      this.requestField("child_attachments", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestCommentsMirroringDomainField () {
      return this.requestCommentsMirroringDomainField(true);
    }
    public APIRequestGetVisitorPosts requestCommentsMirroringDomainField (boolean value) {
      this.requestField("comments_mirroring_domain", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestCoordinatesField () {
      return this.requestCoordinatesField(true);
    }
    public APIRequestGetVisitorPosts requestCoordinatesField (boolean value) {
      this.requestField("coordinates", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetVisitorPosts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetVisitorPosts requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGetVisitorPosts requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestExpandedHeightField () {
      return this.requestExpandedHeightField(true);
    }
    public APIRequestGetVisitorPosts requestExpandedHeightField (boolean value) {
      this.requestField("expanded_height", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestExpandedWidthField () {
      return this.requestExpandedWidthField(true);
    }
    public APIRequestGetVisitorPosts requestExpandedWidthField (boolean value) {
      this.requestField("expanded_width", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestFeedTargetingField () {
      return this.requestFeedTargetingField(true);
    }
    public APIRequestGetVisitorPosts requestFeedTargetingField (boolean value) {
      this.requestField("feed_targeting", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetVisitorPosts requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestFullPictureField () {
      return this.requestFullPictureField(true);
    }
    public APIRequestGetVisitorPosts requestFullPictureField (boolean value) {
      this.requestField("full_picture", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGetVisitorPosts requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestIconField () {
      return this.requestIconField(true);
    }
    public APIRequestGetVisitorPosts requestIconField (boolean value) {
      this.requestField("icon", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetVisitorPosts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestInstagramEligibilityField () {
      return this.requestInstagramEligibilityField(true);
    }
    public APIRequestGetVisitorPosts requestInstagramEligibilityField (boolean value) {
      this.requestField("instagram_eligibility", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestIsAppShareField () {
      return this.requestIsAppShareField(true);
    }
    public APIRequestGetVisitorPosts requestIsAppShareField (boolean value) {
      this.requestField("is_app_share", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestIsExpiredField () {
      return this.requestIsExpiredField(true);
    }
    public APIRequestGetVisitorPosts requestIsExpiredField (boolean value) {
      this.requestField("is_expired", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetVisitorPosts requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestIsInstagramEligibleField () {
      return this.requestIsInstagramEligibleField(true);
    }
    public APIRequestGetVisitorPosts requestIsInstagramEligibleField (boolean value) {
      this.requestField("is_instagram_eligible", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestIsPopularField () {
      return this.requestIsPopularField(true);
    }
    public APIRequestGetVisitorPosts requestIsPopularField (boolean value) {
      this.requestField("is_popular", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetVisitorPosts requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestIsSphericalField () {
      return this.requestIsSphericalField(true);
    }
    public APIRequestGetVisitorPosts requestIsSphericalField (boolean value) {
      this.requestField("is_spherical", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetVisitorPosts requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGetVisitorPosts requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestMessageTagsField () {
      return this.requestMessageTagsField(true);
    }
    public APIRequestGetVisitorPosts requestMessageTagsField (boolean value) {
      this.requestField("message_tags", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestMultiShareEndCardField () {
      return this.requestMultiShareEndCardField(true);
    }
    public APIRequestGetVisitorPosts requestMultiShareEndCardField (boolean value) {
      this.requestField("multi_share_end_card", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestMultiShareOptimizedField () {
      return this.requestMultiShareOptimizedField(true);
    }
    public APIRequestGetVisitorPosts requestMultiShareOptimizedField (boolean value) {
      this.requestField("multi_share_optimized", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetVisitorPosts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetVisitorPosts requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestParentIdField () {
      return this.requestParentIdField(true);
    }
    public APIRequestGetVisitorPosts requestParentIdField (boolean value) {
      this.requestField("parent_id", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGetVisitorPosts requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestPictureField () {
      return this.requestPictureField(true);
    }
    public APIRequestGetVisitorPosts requestPictureField (boolean value) {
      this.requestField("picture", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGetVisitorPosts requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestPrivacyField () {
      return this.requestPrivacyField(true);
    }
    public APIRequestGetVisitorPosts requestPrivacyField (boolean value) {
      this.requestField("privacy", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestPromotableIdField () {
      return this.requestPromotableIdField(true);
    }
    public APIRequestGetVisitorPosts requestPromotableIdField (boolean value) {
      this.requestField("promotable_id", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestPromotionStatusField () {
      return this.requestPromotionStatusField(true);
    }
    public APIRequestGetVisitorPosts requestPromotionStatusField (boolean value) {
      this.requestField("promotion_status", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestPropertiesField () {
      return this.requestPropertiesField(true);
    }
    public APIRequestGetVisitorPosts requestPropertiesField (boolean value) {
      this.requestField("properties", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGetVisitorPosts requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestSharesField () {
      return this.requestSharesField(true);
    }
    public APIRequestGetVisitorPosts requestSharesField (boolean value) {
      this.requestField("shares", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGetVisitorPosts requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestStatusTypeField () {
      return this.requestStatusTypeField(true);
    }
    public APIRequestGetVisitorPosts requestStatusTypeField (boolean value) {
      this.requestField("status_type", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestStoryField () {
      return this.requestStoryField(true);
    }
    public APIRequestGetVisitorPosts requestStoryField (boolean value) {
      this.requestField("story", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestStoryTagsField () {
      return this.requestStoryTagsField(true);
    }
    public APIRequestGetVisitorPosts requestStoryTagsField (boolean value) {
      this.requestField("story_tags", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestSubscribedField () {
      return this.requestSubscribedField(true);
    }
    public APIRequestGetVisitorPosts requestSubscribedField (boolean value) {
      this.requestField("subscribed", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestTargetField () {
      return this.requestTargetField(true);
    }
    public APIRequestGetVisitorPosts requestTargetField (boolean value) {
      this.requestField("target", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetVisitorPosts requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestTimelineVisibilityField () {
      return this.requestTimelineVisibilityField(true);
    }
    public APIRequestGetVisitorPosts requestTimelineVisibilityField (boolean value) {
      this.requestField("timeline_visibility", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetVisitorPosts requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetVisitorPosts requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestViaField () {
      return this.requestViaField(true);
    }
    public APIRequestGetVisitorPosts requestViaField (boolean value) {
      this.requestField("via", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestVideoBuyingEligibilityField () {
      return this.requestVideoBuyingEligibilityField(true);
    }
    public APIRequestGetVisitorPosts requestVideoBuyingEligibilityField (boolean value) {
      this.requestField("video_buying_eligibility", value);
      return this;
    }
    public APIRequestGetVisitorPosts requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGetVisitorPosts requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<Page> {

    Page lastResponse = null;
    @Override
    public Page getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_linking_token",
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
    public Page parseResponse(String response) throws APIException {
      return Page.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Page execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Page execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Page> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Page> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Page>() {
           public Page apply(String result) {
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


    public APIRequestGet setAccountLinkingToken (String accountLinkingToken) {
      this.setParam("account_linking_token", accountLinkingToken);
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
    public APIRequestGet requestAccessTokenField () {
      return this.requestAccessTokenField(true);
    }
    public APIRequestGet requestAccessTokenField (boolean value) {
      this.requestField("access_token", value);
      return this;
    }
    public APIRequestGet requestAdCampaignField () {
      return this.requestAdCampaignField(true);
    }
    public APIRequestGet requestAdCampaignField (boolean value) {
      this.requestField("ad_campaign", value);
      return this;
    }
    public APIRequestGet requestAffiliationField () {
      return this.requestAffiliationField(true);
    }
    public APIRequestGet requestAffiliationField (boolean value) {
      this.requestField("affiliation", value);
      return this;
    }
    public APIRequestGet requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGet requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGet requestAppLinksField () {
      return this.requestAppLinksField(true);
    }
    public APIRequestGet requestAppLinksField (boolean value) {
      this.requestField("app_links", value);
      return this;
    }
    public APIRequestGet requestArtistsWeLikeField () {
      return this.requestArtistsWeLikeField(true);
    }
    public APIRequestGet requestArtistsWeLikeField (boolean value) {
      this.requestField("artists_we_like", value);
      return this;
    }
    public APIRequestGet requestAttireField () {
      return this.requestAttireField(true);
    }
    public APIRequestGet requestAttireField (boolean value) {
      this.requestField("attire", value);
      return this;
    }
    public APIRequestGet requestAwardsField () {
      return this.requestAwardsField(true);
    }
    public APIRequestGet requestAwardsField (boolean value) {
      this.requestField("awards", value);
      return this;
    }
    public APIRequestGet requestBandInterestsField () {
      return this.requestBandInterestsField(true);
    }
    public APIRequestGet requestBandInterestsField (boolean value) {
      this.requestField("band_interests", value);
      return this;
    }
    public APIRequestGet requestBandMembersField () {
      return this.requestBandMembersField(true);
    }
    public APIRequestGet requestBandMembersField (boolean value) {
      this.requestField("band_members", value);
      return this;
    }
    public APIRequestGet requestBestPageField () {
      return this.requestBestPageField(true);
    }
    public APIRequestGet requestBestPageField (boolean value) {
      this.requestField("best_page", value);
      return this;
    }
    public APIRequestGet requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGet requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGet requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGet requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGet requestBookingAgentField () {
      return this.requestBookingAgentField(true);
    }
    public APIRequestGet requestBookingAgentField (boolean value) {
      this.requestField("booking_agent", value);
      return this;
    }
    public APIRequestGet requestBuiltField () {
      return this.requestBuiltField(true);
    }
    public APIRequestGet requestBuiltField (boolean value) {
      this.requestField("built", value);
      return this;
    }
    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestCanCheckinField () {
      return this.requestCanCheckinField(true);
    }
    public APIRequestGet requestCanCheckinField (boolean value) {
      this.requestField("can_checkin", value);
      return this;
    }
    public APIRequestGet requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGet requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGet requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGet requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGet requestCategoryListField () {
      return this.requestCategoryListField(true);
    }
    public APIRequestGet requestCategoryListField (boolean value) {
      this.requestField("category_list", value);
      return this;
    }
    public APIRequestGet requestCheckinsField () {
      return this.requestCheckinsField(true);
    }
    public APIRequestGet requestCheckinsField (boolean value) {
      this.requestField("checkins", value);
      return this;
    }
    public APIRequestGet requestCompanyOverviewField () {
      return this.requestCompanyOverviewField(true);
    }
    public APIRequestGet requestCompanyOverviewField (boolean value) {
      this.requestField("company_overview", value);
      return this;
    }
    public APIRequestGet requestConnectedInstagramAccountField () {
      return this.requestConnectedInstagramAccountField(true);
    }
    public APIRequestGet requestConnectedInstagramAccountField (boolean value) {
      this.requestField("connected_instagram_account", value);
      return this;
    }
    public APIRequestGet requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGet requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGet requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGet requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGet requestCopyrightAttributionInsightsField () {
      return this.requestCopyrightAttributionInsightsField(true);
    }
    public APIRequestGet requestCopyrightAttributionInsightsField (boolean value) {
      this.requestField("copyright_attribution_insights", value);
      return this;
    }
    public APIRequestGet requestCopyrightWhitelistedIgPartnersField () {
      return this.requestCopyrightWhitelistedIgPartnersField(true);
    }
    public APIRequestGet requestCopyrightWhitelistedIgPartnersField (boolean value) {
      this.requestField("copyright_whitelisted_ig_partners", value);
      return this;
    }
    public APIRequestGet requestCountryPageLikesField () {
      return this.requestCountryPageLikesField(true);
    }
    public APIRequestGet requestCountryPageLikesField (boolean value) {
      this.requestField("country_page_likes", value);
      return this;
    }
    public APIRequestGet requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGet requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGet requestCulinaryTeamField () {
      return this.requestCulinaryTeamField(true);
    }
    public APIRequestGet requestCulinaryTeamField (boolean value) {
      this.requestField("culinary_team", value);
      return this;
    }
    public APIRequestGet requestCurrentLocationField () {
      return this.requestCurrentLocationField(true);
    }
    public APIRequestGet requestCurrentLocationField (boolean value) {
      this.requestField("current_location", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestDescriptionHtmlField () {
      return this.requestDescriptionHtmlField(true);
    }
    public APIRequestGet requestDescriptionHtmlField (boolean value) {
      this.requestField("description_html", value);
      return this;
    }
    public APIRequestGet requestDirectedByField () {
      return this.requestDirectedByField(true);
    }
    public APIRequestGet requestDirectedByField (boolean value) {
      this.requestField("directed_by", value);
      return this;
    }
    public APIRequestGet requestDisplaySubtextField () {
      return this.requestDisplaySubtextField(true);
    }
    public APIRequestGet requestDisplaySubtextField (boolean value) {
      this.requestField("display_subtext", value);
      return this;
    }
    public APIRequestGet requestDisplayedMessageResponseTimeField () {
      return this.requestDisplayedMessageResponseTimeField(true);
    }
    public APIRequestGet requestDisplayedMessageResponseTimeField (boolean value) {
      this.requestField("displayed_message_response_time", value);
      return this;
    }
    public APIRequestGet requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGet requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGet requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGet requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGet requestFanCountField () {
      return this.requestFanCountField(true);
    }
    public APIRequestGet requestFanCountField (boolean value) {
      this.requestField("fan_count", value);
      return this;
    }
    public APIRequestGet requestFeaturedVideoField () {
      return this.requestFeaturedVideoField(true);
    }
    public APIRequestGet requestFeaturedVideoField (boolean value) {
      this.requestField("featured_video", value);
      return this;
    }
    public APIRequestGet requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGet requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGet requestFoodStylesField () {
      return this.requestFoodStylesField(true);
    }
    public APIRequestGet requestFoodStylesField (boolean value) {
      this.requestField("food_styles", value);
      return this;
    }
    public APIRequestGet requestFoundedField () {
      return this.requestFoundedField(true);
    }
    public APIRequestGet requestFoundedField (boolean value) {
      this.requestField("founded", value);
      return this;
    }
    public APIRequestGet requestGeneralInfoField () {
      return this.requestGeneralInfoField(true);
    }
    public APIRequestGet requestGeneralInfoField (boolean value) {
      this.requestField("general_info", value);
      return this;
    }
    public APIRequestGet requestGeneralManagerField () {
      return this.requestGeneralManagerField(true);
    }
    public APIRequestGet requestGeneralManagerField (boolean value) {
      this.requestField("general_manager", value);
      return this;
    }
    public APIRequestGet requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGet requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGet requestGlobalBrandPageNameField () {
      return this.requestGlobalBrandPageNameField(true);
    }
    public APIRequestGet requestGlobalBrandPageNameField (boolean value) {
      this.requestField("global_brand_page_name", value);
      return this;
    }
    public APIRequestGet requestGlobalBrandRootIdField () {
      return this.requestGlobalBrandRootIdField(true);
    }
    public APIRequestGet requestGlobalBrandRootIdField (boolean value) {
      this.requestField("global_brand_root_id", value);
      return this;
    }
    public APIRequestGet requestHasAddedAppField () {
      return this.requestHasAddedAppField(true);
    }
    public APIRequestGet requestHasAddedAppField (boolean value) {
      this.requestField("has_added_app", value);
      return this;
    }
    public APIRequestGet requestHasWhatsappNumberField () {
      return this.requestHasWhatsappNumberField(true);
    }
    public APIRequestGet requestHasWhatsappNumberField (boolean value) {
      this.requestField("has_whatsapp_number", value);
      return this;
    }
    public APIRequestGet requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGet requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGet requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGet requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestImpressumField () {
      return this.requestImpressumField(true);
    }
    public APIRequestGet requestImpressumField (boolean value) {
      this.requestField("impressum", value);
      return this;
    }
    public APIRequestGet requestInfluencesField () {
      return this.requestInfluencesField(true);
    }
    public APIRequestGet requestInfluencesField (boolean value) {
      this.requestField("influences", value);
      return this;
    }
    public APIRequestGet requestInstagramBusinessAccountField () {
      return this.requestInstagramBusinessAccountField(true);
    }
    public APIRequestGet requestInstagramBusinessAccountField (boolean value) {
      this.requestField("instagram_business_account", value);
      return this;
    }
    public APIRequestGet requestInstantArticlesReviewStatusField () {
      return this.requestInstantArticlesReviewStatusField(true);
    }
    public APIRequestGet requestInstantArticlesReviewStatusField (boolean value) {
      this.requestField("instant_articles_review_status", value);
      return this;
    }
    public APIRequestGet requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGet requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
      return this;
    }
    public APIRequestGet requestIsChainField () {
      return this.requestIsChainField(true);
    }
    public APIRequestGet requestIsChainField (boolean value) {
      this.requestField("is_chain", value);
      return this;
    }
    public APIRequestGet requestIsCommunityPageField () {
      return this.requestIsCommunityPageField(true);
    }
    public APIRequestGet requestIsCommunityPageField (boolean value) {
      this.requestField("is_community_page", value);
      return this;
    }
    public APIRequestGet requestIsEligibleForBrandedContentField () {
      return this.requestIsEligibleForBrandedContentField(true);
    }
    public APIRequestGet requestIsEligibleForBrandedContentField (boolean value) {
      this.requestField("is_eligible_for_branded_content", value);
      return this;
    }
    public APIRequestGet requestIsMessengerBotGetStartedEnabledField () {
      return this.requestIsMessengerBotGetStartedEnabledField(true);
    }
    public APIRequestGet requestIsMessengerBotGetStartedEnabledField (boolean value) {
      this.requestField("is_messenger_bot_get_started_enabled", value);
      return this;
    }
    public APIRequestGet requestIsMessengerPlatformBotField () {
      return this.requestIsMessengerPlatformBotField(true);
    }
    public APIRequestGet requestIsMessengerPlatformBotField (boolean value) {
      this.requestField("is_messenger_platform_bot", value);
      return this;
    }
    public APIRequestGet requestIsOwnedField () {
      return this.requestIsOwnedField(true);
    }
    public APIRequestGet requestIsOwnedField (boolean value) {
      this.requestField("is_owned", value);
      return this;
    }
    public APIRequestGet requestIsPermanentlyClosedField () {
      return this.requestIsPermanentlyClosedField(true);
    }
    public APIRequestGet requestIsPermanentlyClosedField (boolean value) {
      this.requestField("is_permanently_closed", value);
      return this;
    }
    public APIRequestGet requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGet requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGet requestIsUnclaimedField () {
      return this.requestIsUnclaimedField(true);
    }
    public APIRequestGet requestIsUnclaimedField (boolean value) {
      this.requestField("is_unclaimed", value);
      return this;
    }
    public APIRequestGet requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGet requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGet requestIsWebhooksSubscribedField () {
      return this.requestIsWebhooksSubscribedField(true);
    }
    public APIRequestGet requestIsWebhooksSubscribedField (boolean value) {
      this.requestField("is_webhooks_subscribed", value);
      return this;
    }
    public APIRequestGet requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGet requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGet requestLeadgenFormPreviewDetailsField () {
      return this.requestLeadgenFormPreviewDetailsField(true);
    }
    public APIRequestGet requestLeadgenFormPreviewDetailsField (boolean value) {
      this.requestField("leadgen_form_preview_details", value);
      return this;
    }
    public APIRequestGet requestLeadgenHasCrmIntegrationField () {
      return this.requestLeadgenHasCrmIntegrationField(true);
    }
    public APIRequestGet requestLeadgenHasCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_crm_integration", value);
      return this;
    }
    public APIRequestGet requestLeadgenHasFatPingCrmIntegrationField () {
      return this.requestLeadgenHasFatPingCrmIntegrationField(true);
    }
    public APIRequestGet requestLeadgenHasFatPingCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_fat_ping_crm_integration", value);
      return this;
    }
    public APIRequestGet requestLeadgenTosAcceptanceTimeField () {
      return this.requestLeadgenTosAcceptanceTimeField(true);
    }
    public APIRequestGet requestLeadgenTosAcceptanceTimeField (boolean value) {
      this.requestField("leadgen_tos_acceptance_time", value);
      return this;
    }
    public APIRequestGet requestLeadgenTosAcceptedField () {
      return this.requestLeadgenTosAcceptedField(true);
    }
    public APIRequestGet requestLeadgenTosAcceptedField (boolean value) {
      this.requestField("leadgen_tos_accepted", value);
      return this;
    }
    public APIRequestGet requestLeadgenTosAcceptingUserField () {
      return this.requestLeadgenTosAcceptingUserField(true);
    }
    public APIRequestGet requestLeadgenTosAcceptingUserField (boolean value) {
      this.requestField("leadgen_tos_accepting_user", value);
      return this;
    }
    public APIRequestGet requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGet requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGet requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGet requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGet requestMembersField () {
      return this.requestMembersField(true);
    }
    public APIRequestGet requestMembersField (boolean value) {
      this.requestField("members", value);
      return this;
    }
    public APIRequestGet requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGet requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGet requestMerchantReviewStatusField () {
      return this.requestMerchantReviewStatusField(true);
    }
    public APIRequestGet requestMerchantReviewStatusField (boolean value) {
      this.requestField("merchant_review_status", value);
      return this;
    }
    public APIRequestGet requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGet requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGet requestMessengerAdsDefaultPageWelcomeMessageField () {
      return this.requestMessengerAdsDefaultPageWelcomeMessageField(true);
    }
    public APIRequestGet requestMessengerAdsDefaultPageWelcomeMessageField (boolean value) {
      this.requestField("messenger_ads_default_page_welcome_message", value);
      return this;
    }
    public APIRequestGet requestMessengerAdsDefaultQuickRepliesField () {
      return this.requestMessengerAdsDefaultQuickRepliesField(true);
    }
    public APIRequestGet requestMessengerAdsDefaultQuickRepliesField (boolean value) {
      this.requestField("messenger_ads_default_quick_replies", value);
      return this;
    }
    public APIRequestGet requestMessengerAdsQuickRepliesTypeField () {
      return this.requestMessengerAdsQuickRepliesTypeField(true);
    }
    public APIRequestGet requestMessengerAdsQuickRepliesTypeField (boolean value) {
      this.requestField("messenger_ads_quick_replies_type", value);
      return this;
    }
    public APIRequestGet requestMissionField () {
      return this.requestMissionField(true);
    }
    public APIRequestGet requestMissionField (boolean value) {
      this.requestField("mission", value);
      return this;
    }
    public APIRequestGet requestMpgField () {
      return this.requestMpgField(true);
    }
    public APIRequestGet requestMpgField (boolean value) {
      this.requestField("mpg", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGet requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGet requestNetworkField () {
      return this.requestNetworkField(true);
    }
    public APIRequestGet requestNetworkField (boolean value) {
      this.requestField("network", value);
      return this;
    }
    public APIRequestGet requestNewLikeCountField () {
      return this.requestNewLikeCountField(true);
    }
    public APIRequestGet requestNewLikeCountField (boolean value) {
      this.requestField("new_like_count", value);
      return this;
    }
    public APIRequestGet requestOfferEligibleField () {
      return this.requestOfferEligibleField(true);
    }
    public APIRequestGet requestOfferEligibleField (boolean value) {
      this.requestField("offer_eligible", value);
      return this;
    }
    public APIRequestGet requestOverallStarRatingField () {
      return this.requestOverallStarRatingField(true);
    }
    public APIRequestGet requestOverallStarRatingField (boolean value) {
      this.requestField("overall_star_rating", value);
      return this;
    }
    public APIRequestGet requestPageTokenField () {
      return this.requestPageTokenField(true);
    }
    public APIRequestGet requestPageTokenField (boolean value) {
      this.requestField("page_token", value);
      return this;
    }
    public APIRequestGet requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGet requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGet requestParkingField () {
      return this.requestParkingField(true);
    }
    public APIRequestGet requestParkingField (boolean value) {
      this.requestField("parking", value);
      return this;
    }
    public APIRequestGet requestPaymentOptionsField () {
      return this.requestPaymentOptionsField(true);
    }
    public APIRequestGet requestPaymentOptionsField (boolean value) {
      this.requestField("payment_options", value);
      return this;
    }
    public APIRequestGet requestPersonalInfoField () {
      return this.requestPersonalInfoField(true);
    }
    public APIRequestGet requestPersonalInfoField (boolean value) {
      this.requestField("personal_info", value);
      return this;
    }
    public APIRequestGet requestPersonalInterestsField () {
      return this.requestPersonalInterestsField(true);
    }
    public APIRequestGet requestPersonalInterestsField (boolean value) {
      this.requestField("personal_interests", value);
      return this;
    }
    public APIRequestGet requestPharmaSafetyInfoField () {
      return this.requestPharmaSafetyInfoField(true);
    }
    public APIRequestGet requestPharmaSafetyInfoField (boolean value) {
      this.requestField("pharma_safety_info", value);
      return this;
    }
    public APIRequestGet requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGet requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGet requestPlaceTypeField () {
      return this.requestPlaceTypeField(true);
    }
    public APIRequestGet requestPlaceTypeField (boolean value) {
      this.requestField("place_type", value);
      return this;
    }
    public APIRequestGet requestPlotOutlineField () {
      return this.requestPlotOutlineField(true);
    }
    public APIRequestGet requestPlotOutlineField (boolean value) {
      this.requestField("plot_outline", value);
      return this;
    }
    public APIRequestGet requestPreferredAudienceField () {
      return this.requestPreferredAudienceField(true);
    }
    public APIRequestGet requestPreferredAudienceField (boolean value) {
      this.requestField("preferred_audience", value);
      return this;
    }
    public APIRequestGet requestPressContactField () {
      return this.requestPressContactField(true);
    }
    public APIRequestGet requestPressContactField (boolean value) {
      this.requestField("press_contact", value);
      return this;
    }
    public APIRequestGet requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGet requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGet requestProducedByField () {
      return this.requestProducedByField(true);
    }
    public APIRequestGet requestProducedByField (boolean value) {
      this.requestField("produced_by", value);
      return this;
    }
    public APIRequestGet requestProductsField () {
      return this.requestProductsField(true);
    }
    public APIRequestGet requestProductsField (boolean value) {
      this.requestField("products", value);
      return this;
    }
    public APIRequestGet requestPromotionEligibleField () {
      return this.requestPromotionEligibleField(true);
    }
    public APIRequestGet requestPromotionEligibleField (boolean value) {
      this.requestField("promotion_eligible", value);
      return this;
    }
    public APIRequestGet requestPromotionIneligibleReasonField () {
      return this.requestPromotionIneligibleReasonField(true);
    }
    public APIRequestGet requestPromotionIneligibleReasonField (boolean value) {
      this.requestField("promotion_ineligible_reason", value);
      return this;
    }
    public APIRequestGet requestPublicTransitField () {
      return this.requestPublicTransitField(true);
    }
    public APIRequestGet requestPublicTransitField (boolean value) {
      this.requestField("public_transit", value);
      return this;
    }
    public APIRequestGet requestPublisherSpaceField () {
      return this.requestPublisherSpaceField(true);
    }
    public APIRequestGet requestPublisherSpaceField (boolean value) {
      this.requestField("publisher_space", value);
      return this;
    }
    public APIRequestGet requestRatingCountField () {
      return this.requestRatingCountField(true);
    }
    public APIRequestGet requestRatingCountField (boolean value) {
      this.requestField("rating_count", value);
      return this;
    }
    public APIRequestGet requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGet requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGet requestRecordLabelField () {
      return this.requestRecordLabelField(true);
    }
    public APIRequestGet requestRecordLabelField (boolean value) {
      this.requestField("record_label", value);
      return this;
    }
    public APIRequestGet requestReleaseDateField () {
      return this.requestReleaseDateField(true);
    }
    public APIRequestGet requestReleaseDateField (boolean value) {
      this.requestField("release_date", value);
      return this;
    }
    public APIRequestGet requestRestaurantServicesField () {
      return this.requestRestaurantServicesField(true);
    }
    public APIRequestGet requestRestaurantServicesField (boolean value) {
      this.requestField("restaurant_services", value);
      return this;
    }
    public APIRequestGet requestRestaurantSpecialtiesField () {
      return this.requestRestaurantSpecialtiesField(true);
    }
    public APIRequestGet requestRestaurantSpecialtiesField (boolean value) {
      this.requestField("restaurant_specialties", value);
      return this;
    }
    public APIRequestGet requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGet requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGet requestScreenplayByField () {
      return this.requestScreenplayByField(true);
    }
    public APIRequestGet requestScreenplayByField (boolean value) {
      this.requestField("screenplay_by", value);
      return this;
    }
    public APIRequestGet requestSeasonField () {
      return this.requestSeasonField(true);
    }
    public APIRequestGet requestSeasonField (boolean value) {
      this.requestField("season", value);
      return this;
    }
    public APIRequestGet requestSingleLineAddressField () {
      return this.requestSingleLineAddressField(true);
    }
    public APIRequestGet requestSingleLineAddressField (boolean value) {
      this.requestField("single_line_address", value);
      return this;
    }
    public APIRequestGet requestStarringField () {
      return this.requestStarringField(true);
    }
    public APIRequestGet requestStarringField (boolean value) {
      this.requestField("starring", value);
      return this;
    }
    public APIRequestGet requestStartInfoField () {
      return this.requestStartInfoField(true);
    }
    public APIRequestGet requestStartInfoField (boolean value) {
      this.requestField("start_info", value);
      return this;
    }
    public APIRequestGet requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGet requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGet requestStoreLocationDescriptorField () {
      return this.requestStoreLocationDescriptorField(true);
    }
    public APIRequestGet requestStoreLocationDescriptorField (boolean value) {
      this.requestField("store_location_descriptor", value);
      return this;
    }
    public APIRequestGet requestStoreNumberField () {
      return this.requestStoreNumberField(true);
    }
    public APIRequestGet requestStoreNumberField (boolean value) {
      this.requestField("store_number", value);
      return this;
    }
    public APIRequestGet requestStudioField () {
      return this.requestStudioField(true);
    }
    public APIRequestGet requestStudioField (boolean value) {
      this.requestField("studio", value);
      return this;
    }
    public APIRequestGet requestSupportsInstantArticlesField () {
      return this.requestSupportsInstantArticlesField(true);
    }
    public APIRequestGet requestSupportsInstantArticlesField (boolean value) {
      this.requestField("supports_instant_articles", value);
      return this;
    }
    public APIRequestGet requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGet requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
      return this;
    }
    public APIRequestGet requestUnreadMessageCountField () {
      return this.requestUnreadMessageCountField(true);
    }
    public APIRequestGet requestUnreadMessageCountField (boolean value) {
      this.requestField("unread_message_count", value);
      return this;
    }
    public APIRequestGet requestUnreadNotifCountField () {
      return this.requestUnreadNotifCountField(true);
    }
    public APIRequestGet requestUnreadNotifCountField (boolean value) {
      this.requestField("unread_notif_count", value);
      return this;
    }
    public APIRequestGet requestUnseenMessageCountField () {
      return this.requestUnseenMessageCountField(true);
    }
    public APIRequestGet requestUnseenMessageCountField (boolean value) {
      this.requestField("unseen_message_count", value);
      return this;
    }
    public APIRequestGet requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGet requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGet requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGet requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGet requestVoipInfoField () {
      return this.requestVoipInfoField(true);
    }
    public APIRequestGet requestVoipInfoField (boolean value) {
      this.requestField("voip_info", value);
      return this;
    }
    public APIRequestGet requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGet requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGet requestWereHereCountField () {
      return this.requestWereHereCountField(true);
    }
    public APIRequestGet requestWereHereCountField (boolean value) {
      this.requestField("were_here_count", value);
      return this;
    }
    public APIRequestGet requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGet requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
      return this;
    }
    public APIRequestGet requestWrittenByField () {
      return this.requestWrittenByField(true);
    }
    public APIRequestGet requestWrittenByField (boolean value) {
      this.requestField("written_by", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<Page> {

    Page lastResponse = null;
    @Override
    public Page getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "about",
      "accept_crossposting_handshake",
      "allow_spherical_photo",
      "attire",
      "begin_crossposting_handshake",
      "bio",
      "category_list",
      "company_overview",
      "contact_address",
      "cover",
      "crossposting_pages",
      "culinary_team",
      "description",
      "directed_by",
      "displayed_message_response_time",
      "emails",
      "focus_x",
      "focus_y",
      "food_styles",
      "general_info",
      "general_manager",
      "genre",
      "hours",
      "ignore_coordinate_warnings",
      "impressum",
      "instant_articles_submit_for_review",
      "is_always_open",
      "is_permanently_closed",
      "is_published",
      "is_webhooks_subscribed",
      "location",
      "mission",
      "no_feed_story",
      "no_notification",
      "offset_x",
      "offset_y",
      "parking",
      "payment_options",
      "phone",
      "plot_outline",
      "price_range",
      "public_transit",
      "restaurant_services",
      "restaurant_specialties",
      "scrape",
      "service_details",
      "spherical_metadata",
      "start_info",
      "store_location_descriptor",
      "website",
      "zoom_scale_x",
      "zoom_scale_y",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Page parseResponse(String response) throws APIException {
      return Page.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Page execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Page execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Page> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Page> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Page>() {
           public Page apply(String result) {
             try {
               return APIRequestUpdate.this.parseResponse(result);
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


    public APIRequestUpdate setAbout (String about) {
      this.setParam("about", about);
      return this;
    }

    public APIRequestUpdate setAcceptCrosspostingHandshake (List<Map<String, String>> acceptCrosspostingHandshake) {
      this.setParam("accept_crossposting_handshake", acceptCrosspostingHandshake);
      return this;
    }
    public APIRequestUpdate setAcceptCrosspostingHandshake (String acceptCrosspostingHandshake) {
      this.setParam("accept_crossposting_handshake", acceptCrosspostingHandshake);
      return this;
    }

    public APIRequestUpdate setAllowSphericalPhoto (Boolean allowSphericalPhoto) {
      this.setParam("allow_spherical_photo", allowSphericalPhoto);
      return this;
    }
    public APIRequestUpdate setAllowSphericalPhoto (String allowSphericalPhoto) {
      this.setParam("allow_spherical_photo", allowSphericalPhoto);
      return this;
    }

    public APIRequestUpdate setAttire (Page.EnumAttire attire) {
      this.setParam("attire", attire);
      return this;
    }
    public APIRequestUpdate setAttire (String attire) {
      this.setParam("attire", attire);
      return this;
    }

    public APIRequestUpdate setBeginCrosspostingHandshake (List<Map<String, String>> beginCrosspostingHandshake) {
      this.setParam("begin_crossposting_handshake", beginCrosspostingHandshake);
      return this;
    }
    public APIRequestUpdate setBeginCrosspostingHandshake (String beginCrosspostingHandshake) {
      this.setParam("begin_crossposting_handshake", beginCrosspostingHandshake);
      return this;
    }

    public APIRequestUpdate setBio (String bio) {
      this.setParam("bio", bio);
      return this;
    }

    public APIRequestUpdate setCategoryList (List<String> categoryList) {
      this.setParam("category_list", categoryList);
      return this;
    }
    public APIRequestUpdate setCategoryList (String categoryList) {
      this.setParam("category_list", categoryList);
      return this;
    }

    public APIRequestUpdate setCompanyOverview (String companyOverview) {
      this.setParam("company_overview", companyOverview);
      return this;
    }

    public APIRequestUpdate setContactAddress (Object contactAddress) {
      this.setParam("contact_address", contactAddress);
      return this;
    }
    public APIRequestUpdate setContactAddress (String contactAddress) {
      this.setParam("contact_address", contactAddress);
      return this;
    }

    public APIRequestUpdate setCover (String cover) {
      this.setParam("cover", cover);
      return this;
    }

    public APIRequestUpdate setCrosspostingPages (List<Object> crosspostingPages) {
      this.setParam("crossposting_pages", crosspostingPages);
      return this;
    }
    public APIRequestUpdate setCrosspostingPages (String crosspostingPages) {
      this.setParam("crossposting_pages", crosspostingPages);
      return this;
    }

    public APIRequestUpdate setCulinaryTeam (String culinaryTeam) {
      this.setParam("culinary_team", culinaryTeam);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestUpdate setDirectedBy (String directedBy) {
      this.setParam("directed_by", directedBy);
      return this;
    }

    public APIRequestUpdate setDisplayedMessageResponseTime (String displayedMessageResponseTime) {
      this.setParam("displayed_message_response_time", displayedMessageResponseTime);
      return this;
    }

    public APIRequestUpdate setEmails (List<String> emails) {
      this.setParam("emails", emails);
      return this;
    }
    public APIRequestUpdate setEmails (String emails) {
      this.setParam("emails", emails);
      return this;
    }

    public APIRequestUpdate setFocusX (Double focusX) {
      this.setParam("focus_x", focusX);
      return this;
    }
    public APIRequestUpdate setFocusX (String focusX) {
      this.setParam("focus_x", focusX);
      return this;
    }

    public APIRequestUpdate setFocusY (Double focusY) {
      this.setParam("focus_y", focusY);
      return this;
    }
    public APIRequestUpdate setFocusY (String focusY) {
      this.setParam("focus_y", focusY);
      return this;
    }

    public APIRequestUpdate setFoodStyles (List<Page.EnumFoodStyles> foodStyles) {
      this.setParam("food_styles", foodStyles);
      return this;
    }
    public APIRequestUpdate setFoodStyles (String foodStyles) {
      this.setParam("food_styles", foodStyles);
      return this;
    }

    public APIRequestUpdate setGeneralInfo (String generalInfo) {
      this.setParam("general_info", generalInfo);
      return this;
    }

    public APIRequestUpdate setGeneralManager (String generalManager) {
      this.setParam("general_manager", generalManager);
      return this;
    }

    public APIRequestUpdate setGenre (String genre) {
      this.setParam("genre", genre);
      return this;
    }

    public APIRequestUpdate setHours (Map<String, String> hours) {
      this.setParam("hours", hours);
      return this;
    }
    public APIRequestUpdate setHours (String hours) {
      this.setParam("hours", hours);
      return this;
    }

    public APIRequestUpdate setIgnoreCoordinateWarnings (Boolean ignoreCoordinateWarnings) {
      this.setParam("ignore_coordinate_warnings", ignoreCoordinateWarnings);
      return this;
    }
    public APIRequestUpdate setIgnoreCoordinateWarnings (String ignoreCoordinateWarnings) {
      this.setParam("ignore_coordinate_warnings", ignoreCoordinateWarnings);
      return this;
    }

    public APIRequestUpdate setImpressum (String impressum) {
      this.setParam("impressum", impressum);
      return this;
    }

    public APIRequestUpdate setInstantArticlesSubmitForReview (Boolean instantArticlesSubmitForReview) {
      this.setParam("instant_articles_submit_for_review", instantArticlesSubmitForReview);
      return this;
    }
    public APIRequestUpdate setInstantArticlesSubmitForReview (String instantArticlesSubmitForReview) {
      this.setParam("instant_articles_submit_for_review", instantArticlesSubmitForReview);
      return this;
    }

    public APIRequestUpdate setIsAlwaysOpen (Boolean isAlwaysOpen) {
      this.setParam("is_always_open", isAlwaysOpen);
      return this;
    }
    public APIRequestUpdate setIsAlwaysOpen (String isAlwaysOpen) {
      this.setParam("is_always_open", isAlwaysOpen);
      return this;
    }

    public APIRequestUpdate setIsPermanentlyClosed (Boolean isPermanentlyClosed) {
      this.setParam("is_permanently_closed", isPermanentlyClosed);
      return this;
    }
    public APIRequestUpdate setIsPermanentlyClosed (String isPermanentlyClosed) {
      this.setParam("is_permanently_closed", isPermanentlyClosed);
      return this;
    }

    public APIRequestUpdate setIsPublished (Boolean isPublished) {
      this.setParam("is_published", isPublished);
      return this;
    }
    public APIRequestUpdate setIsPublished (String isPublished) {
      this.setParam("is_published", isPublished);
      return this;
    }

    public APIRequestUpdate setIsWebhooksSubscribed (Boolean isWebhooksSubscribed) {
      this.setParam("is_webhooks_subscribed", isWebhooksSubscribed);
      return this;
    }
    public APIRequestUpdate setIsWebhooksSubscribed (String isWebhooksSubscribed) {
      this.setParam("is_webhooks_subscribed", isWebhooksSubscribed);
      return this;
    }

    public APIRequestUpdate setLocation (Object location) {
      this.setParam("location", location);
      return this;
    }
    public APIRequestUpdate setLocation (String location) {
      this.setParam("location", location);
      return this;
    }

    public APIRequestUpdate setMission (String mission) {
      this.setParam("mission", mission);
      return this;
    }

    public APIRequestUpdate setNoFeedStory (Boolean noFeedStory) {
      this.setParam("no_feed_story", noFeedStory);
      return this;
    }
    public APIRequestUpdate setNoFeedStory (String noFeedStory) {
      this.setParam("no_feed_story", noFeedStory);
      return this;
    }

    public APIRequestUpdate setNoNotification (Boolean noNotification) {
      this.setParam("no_notification", noNotification);
      return this;
    }
    public APIRequestUpdate setNoNotification (String noNotification) {
      this.setParam("no_notification", noNotification);
      return this;
    }

    public APIRequestUpdate setOffsetX (Long offsetX) {
      this.setParam("offset_x", offsetX);
      return this;
    }
    public APIRequestUpdate setOffsetX (String offsetX) {
      this.setParam("offset_x", offsetX);
      return this;
    }

    public APIRequestUpdate setOffsetY (Long offsetY) {
      this.setParam("offset_y", offsetY);
      return this;
    }
    public APIRequestUpdate setOffsetY (String offsetY) {
      this.setParam("offset_y", offsetY);
      return this;
    }

    public APIRequestUpdate setParking (Map<String, String> parking) {
      this.setParam("parking", parking);
      return this;
    }
    public APIRequestUpdate setParking (String parking) {
      this.setParam("parking", parking);
      return this;
    }

    public APIRequestUpdate setPaymentOptions (Map<String, String> paymentOptions) {
      this.setParam("payment_options", paymentOptions);
      return this;
    }
    public APIRequestUpdate setPaymentOptions (String paymentOptions) {
      this.setParam("payment_options", paymentOptions);
      return this;
    }

    public APIRequestUpdate setPhone (String phone) {
      this.setParam("phone", phone);
      return this;
    }

    public APIRequestUpdate setPlotOutline (String plotOutline) {
      this.setParam("plot_outline", plotOutline);
      return this;
    }

    public APIRequestUpdate setPriceRange (String priceRange) {
      this.setParam("price_range", priceRange);
      return this;
    }

    public APIRequestUpdate setPublicTransit (String publicTransit) {
      this.setParam("public_transit", publicTransit);
      return this;
    }

    public APIRequestUpdate setRestaurantServices (Map<String, String> restaurantServices) {
      this.setParam("restaurant_services", restaurantServices);
      return this;
    }
    public APIRequestUpdate setRestaurantServices (String restaurantServices) {
      this.setParam("restaurant_services", restaurantServices);
      return this;
    }

    public APIRequestUpdate setRestaurantSpecialties (Map<String, String> restaurantSpecialties) {
      this.setParam("restaurant_specialties", restaurantSpecialties);
      return this;
    }
    public APIRequestUpdate setRestaurantSpecialties (String restaurantSpecialties) {
      this.setParam("restaurant_specialties", restaurantSpecialties);
      return this;
    }

    public APIRequestUpdate setScrape (Boolean scrape) {
      this.setParam("scrape", scrape);
      return this;
    }
    public APIRequestUpdate setScrape (String scrape) {
      this.setParam("scrape", scrape);
      return this;
    }

    public APIRequestUpdate setServiceDetails (String serviceDetails) {
      this.setParam("service_details", serviceDetails);
      return this;
    }

    public APIRequestUpdate setSphericalMetadata (Map<String, String> sphericalMetadata) {
      this.setParam("spherical_metadata", sphericalMetadata);
      return this;
    }
    public APIRequestUpdate setSphericalMetadata (String sphericalMetadata) {
      this.setParam("spherical_metadata", sphericalMetadata);
      return this;
    }

    public APIRequestUpdate setStartInfo (Object startInfo) {
      this.setParam("start_info", startInfo);
      return this;
    }
    public APIRequestUpdate setStartInfo (String startInfo) {
      this.setParam("start_info", startInfo);
      return this;
    }

    public APIRequestUpdate setStoreLocationDescriptor (String storeLocationDescriptor) {
      this.setParam("store_location_descriptor", storeLocationDescriptor);
      return this;
    }

    public APIRequestUpdate setWebsite (String website) {
      this.setParam("website", website);
      return this;
    }

    public APIRequestUpdate setZoomScaleX (Double zoomScaleX) {
      this.setParam("zoom_scale_x", zoomScaleX);
      return this;
    }
    public APIRequestUpdate setZoomScaleX (String zoomScaleX) {
      this.setParam("zoom_scale_x", zoomScaleX);
      return this;
    }

    public APIRequestUpdate setZoomScaleY (Double zoomScaleY) {
      this.setParam("zoom_scale_y", zoomScaleY);
      return this;
    }
    public APIRequestUpdate setZoomScaleY (String zoomScaleY) {
      this.setParam("zoom_scale_y", zoomScaleY);
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

  public static enum EnumAttire {
      @SerializedName("Unspecified")
      VALUE_UNSPECIFIED("Unspecified"),
      @SerializedName("Casual")
      VALUE_CASUAL("Casual"),
      @SerializedName("Dressy")
      VALUE_DRESSY("Dressy"),
      NULL(null);

      private String value;

      private EnumAttire(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumFoodStyles {
      @SerializedName("Afghani")
      VALUE_AFGHANI("Afghani"),
      @SerializedName("American (New)")
      VALUE_AMERICAN_NEW_("American (New)"),
      @SerializedName("American (Traditional)")
      VALUE_AMERICAN_TRADITIONAL_("American (Traditional)"),
      @SerializedName("Asian Fusion")
      VALUE_ASIAN_FUSION("Asian Fusion"),
      @SerializedName("Barbeque")
      VALUE_BARBEQUE("Barbeque"),
      @SerializedName("Brazilian")
      VALUE_BRAZILIAN("Brazilian"),
      @SerializedName("Breakfast")
      VALUE_BREAKFAST("Breakfast"),
      @SerializedName("British")
      VALUE_BRITISH("British"),
      @SerializedName("Brunch")
      VALUE_BRUNCH("Brunch"),
      @SerializedName("Buffets")
      VALUE_BUFFETS("Buffets"),
      @SerializedName("Burgers")
      VALUE_BURGERS("Burgers"),
      @SerializedName("Burmese")
      VALUE_BURMESE("Burmese"),
      @SerializedName("Cajun/Creole")
      VALUE_CAJUN_CREOLE("Cajun/Creole"),
      @SerializedName("Caribbean")
      VALUE_CARIBBEAN("Caribbean"),
      @SerializedName("Chinese")
      VALUE_CHINESE("Chinese"),
      @SerializedName("Creperies")
      VALUE_CREPERIES("Creperies"),
      @SerializedName("Cuban")
      VALUE_CUBAN("Cuban"),
      @SerializedName("Delis")
      VALUE_DELIS("Delis"),
      @SerializedName("Diners")
      VALUE_DINERS("Diners"),
      @SerializedName("Ethiopian")
      VALUE_ETHIOPIAN("Ethiopian"),
      @SerializedName("Fast Food")
      VALUE_FAST_FOOD("Fast Food"),
      @SerializedName("Filipino")
      VALUE_FILIPINO("Filipino"),
      @SerializedName("Fondue")
      VALUE_FONDUE("Fondue"),
      @SerializedName("Food Stands")
      VALUE_FOOD_STANDS("Food Stands"),
      @SerializedName("French")
      VALUE_FRENCH("French"),
      @SerializedName("German")
      VALUE_GERMAN("German"),
      @SerializedName("Greek and Mediterranean")
      VALUE_GREEK_AND_MEDITERRANEAN("Greek and Mediterranean"),
      @SerializedName("Hawaiian")
      VALUE_HAWAIIAN("Hawaiian"),
      @SerializedName("Himalayan/Nepalese")
      VALUE_HIMALAYAN_NEPALESE("Himalayan/Nepalese"),
      @SerializedName("Hot Dogs")
      VALUE_HOT_DOGS("Hot Dogs"),
      @SerializedName("Indian/Pakistani")
      VALUE_INDIAN_PAKISTANI("Indian/Pakistani"),
      @SerializedName("Irish")
      VALUE_IRISH("Irish"),
      @SerializedName("Italian")
      VALUE_ITALIAN("Italian"),
      @SerializedName("Japanese")
      VALUE_JAPANESE("Japanese"),
      @SerializedName("Korean")
      VALUE_KOREAN("Korean"),
      @SerializedName("Latin American")
      VALUE_LATIN_AMERICAN("Latin American"),
      @SerializedName("Mexican")
      VALUE_MEXICAN("Mexican"),
      @SerializedName("Middle Eastern")
      VALUE_MIDDLE_EASTERN("Middle Eastern"),
      @SerializedName("Moroccan")
      VALUE_MOROCCAN("Moroccan"),
      @SerializedName("Pizza")
      VALUE_PIZZA("Pizza"),
      @SerializedName("Russian")
      VALUE_RUSSIAN("Russian"),
      @SerializedName("Sandwiches")
      VALUE_SANDWICHES("Sandwiches"),
      @SerializedName("Seafood")
      VALUE_SEAFOOD("Seafood"),
      @SerializedName("Singaporean")
      VALUE_SINGAPOREAN("Singaporean"),
      @SerializedName("Soul Food")
      VALUE_SOUL_FOOD("Soul Food"),
      @SerializedName("Southern")
      VALUE_SOUTHERN("Southern"),
      @SerializedName("Spanish/Basque")
      VALUE_SPANISH_BASQUE("Spanish/Basque"),
      @SerializedName("Steakhouses")
      VALUE_STEAKHOUSES("Steakhouses"),
      @SerializedName("Sushi Bars")
      VALUE_SUSHI_BARS("Sushi Bars"),
      @SerializedName("Taiwanese")
      VALUE_TAIWANESE("Taiwanese"),
      @SerializedName("Tapas Bars")
      VALUE_TAPAS_BARS("Tapas Bars"),
      @SerializedName("Tex-Mex")
      VALUE_TEX_MEX("Tex-Mex"),
      @SerializedName("Thai")
      VALUE_THAI("Thai"),
      @SerializedName("Turkish")
      VALUE_TURKISH("Turkish"),
      @SerializedName("Vegan")
      VALUE_VEGAN("Vegan"),
      @SerializedName("Vegetarian")
      VALUE_VEGETARIAN("Vegetarian"),
      @SerializedName("Vietnamese")
      VALUE_VIETNAMESE("Vietnamese"),
      NULL(null);

      private String value;

      private EnumFoodStyles(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumTasks {
      @SerializedName("MANAGE")
      VALUE_MANAGE("MANAGE"),
      @SerializedName("CREATE_CONTENT")
      VALUE_CREATE_CONTENT("CREATE_CONTENT"),
      @SerializedName("MODERATE")
      VALUE_MODERATE("MODERATE"),
      @SerializedName("MODERATE_COMMUNITY")
      VALUE_MODERATE_COMMUNITY("MODERATE_COMMUNITY"),
      @SerializedName("ADVERTISE")
      VALUE_ADVERTISE("ADVERTISE"),
      @SerializedName("ANALYZE")
      VALUE_ANALYZE("ANALYZE"),
      @SerializedName("CREATE_LIVE_CONTENT")
      VALUE_CREATE_LIVE_CONTENT("CREATE_LIVE_CONTENT"),
      NULL(null);

      private String value;

      private EnumTasks(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumLocale {
      @SerializedName("EN_US")
      VALUE_EN_US("EN_US"),
      @SerializedName("IT_IT")
      VALUE_IT_IT("IT_IT"),
      @SerializedName("FR_FR")
      VALUE_FR_FR("FR_FR"),
      @SerializedName("ES_ES")
      VALUE_ES_ES("ES_ES"),
      @SerializedName("ES_LA")
      VALUE_ES_LA("ES_LA"),
      @SerializedName("DE_DE")
      VALUE_DE_DE("DE_DE"),
      @SerializedName("EN_GB")
      VALUE_EN_GB("EN_GB"),
      @SerializedName("PT_BR")
      VALUE_PT_BR("PT_BR"),
      @SerializedName("ZH_TW")
      VALUE_ZH_TW("ZH_TW"),
      @SerializedName("ZH_HK")
      VALUE_ZH_HK("ZH_HK"),
      @SerializedName("TR_TR")
      VALUE_TR_TR("TR_TR"),
      @SerializedName("AR_AR")
      VALUE_AR_AR("AR_AR"),
      @SerializedName("CS_CZ")
      VALUE_CS_CZ("CS_CZ"),
      @SerializedName("DA_DK")
      VALUE_DA_DK("DA_DK"),
      @SerializedName("FI_FI")
      VALUE_FI_FI("FI_FI"),
      @SerializedName("HE_IL")
      VALUE_HE_IL("HE_IL"),
      @SerializedName("HI_IN")
      VALUE_HI_IN("HI_IN"),
      @SerializedName("HU_HU")
      VALUE_HU_HU("HU_HU"),
      @SerializedName("ID_ID")
      VALUE_ID_ID("ID_ID"),
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
      @SerializedName("VI_VN")
      VALUE_VI_VN("VI_VN"),
      @SerializedName("ZH_CN")
      VALUE_ZH_CN("ZH_CN"),
      NULL(null);

      private String value;

      private EnumLocale(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumAction {
      @SerializedName("MANUAL_REVIEW")
      VALUE_MANUAL_REVIEW("MANUAL_REVIEW"),
      @SerializedName("MONITOR")
      VALUE_MONITOR("MONITOR"),
      @SerializedName("BLOCK")
      VALUE_BLOCK("BLOCK"),
      @SerializedName("CLAIM_AD_EARNINGS")
      VALUE_CLAIM_AD_EARNINGS("CLAIM_AD_EARNINGS"),
      @SerializedName("REQUEST_TAKEDOWN")
      VALUE_REQUEST_TAKEDOWN("REQUEST_TAKEDOWN"),
      NULL(null);

      private String value;

      private EnumAction(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMatchContentType {
      @SerializedName("VIDEO_AND_AUDIO")
      VALUE_VIDEO_AND_AUDIO("VIDEO_AND_AUDIO"),
      @SerializedName("VIDEO_ONLY")
      VALUE_VIDEO_ONLY("VIDEO_ONLY"),
      @SerializedName("AUDIO_ONLY")
      VALUE_AUDIO_ONLY("AUDIO_ONLY"),
      NULL(null);

      private String value;

      private EnumMatchContentType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPublishStatus {
      @SerializedName("DRAFT")
      VALUE_DRAFT("DRAFT"),
      @SerializedName("LIVE")
      VALUE_LIVE("LIVE"),
      NULL(null);

      private String value;

      private EnumPublishStatus(String value) {
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
      NULL(null);

      private String value;

      private EnumStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStyle {
      @SerializedName("LIST_STYLE")
      VALUE_LIST_STYLE("LIST_STYLE"),
      @SerializedName("PARAGRAPH_STYLE")
      VALUE_PARAGRAPH_STYLE("PARAGRAPH_STYLE"),
      NULL(null);

      private String value;

      private EnumStyle(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMessagingType {
      @SerializedName("RESPONSE")
      VALUE_RESPONSE("RESPONSE"),
      @SerializedName("UPDATE")
      VALUE_UPDATE("UPDATE"),
      @SerializedName("MESSAGE_TAG")
      VALUE_MESSAGE_TAG("MESSAGE_TAG"),
      NULL(null);

      private String value;

      private EnumMessagingType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumNotificationType {
      @SerializedName("REGULAR")
      VALUE_REGULAR("REGULAR"),
      @SerializedName("SILENT_PUSH")
      VALUE_SILENT_PUSH("SILENT_PUSH"),
      @SerializedName("NO_PUSH")
      VALUE_NO_PUSH("NO_PUSH"),
      NULL(null);

      private String value;

      private EnumNotificationType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSenderAction {
      @SerializedName("MARK_SEEN")
      VALUE_MARK_SEEN("MARK_SEEN"),
      @SerializedName("TYPING_ON")
      VALUE_TYPING_ON("TYPING_ON"),
      @SerializedName("TYPING_OFF")
      VALUE_TYPING_OFF("TYPING_OFF"),
      NULL(null);

      private String value;

      private EnumSenderAction(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumType {
      @SerializedName("STANDARD")
      VALUE_STANDARD("STANDARD"),
      @SerializedName("REF")
      VALUE_REF("REF"),
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

  public static enum EnumModel {
      @SerializedName("ARABIC")
      VALUE_ARABIC("ARABIC"),
      @SerializedName("CHINESE")
      VALUE_CHINESE("CHINESE"),
      @SerializedName("CROATIAN")
      VALUE_CROATIAN("CROATIAN"),
      @SerializedName("CUSTOM")
      VALUE_CUSTOM("CUSTOM"),
      @SerializedName("DANISH")
      VALUE_DANISH("DANISH"),
      @SerializedName("DUTCH")
      VALUE_DUTCH("DUTCH"),
      @SerializedName("ENGLISH")
      VALUE_ENGLISH("ENGLISH"),
      @SerializedName("FRENCH_STANDARD")
      VALUE_FRENCH_STANDARD("FRENCH_STANDARD"),
      @SerializedName("GERMAN_STANDARD")
      VALUE_GERMAN_STANDARD("GERMAN_STANDARD"),
      @SerializedName("GREEK")
      VALUE_GREEK("GREEK"),
      @SerializedName("HEBREW")
      VALUE_HEBREW("HEBREW"),
      @SerializedName("HUNGARIAN")
      VALUE_HUNGARIAN("HUNGARIAN"),
      @SerializedName("IRISH")
      VALUE_IRISH("IRISH"),
      @SerializedName("ITALIAN_STANDARD")
      VALUE_ITALIAN_STANDARD("ITALIAN_STANDARD"),
      @SerializedName("KOREAN")
      VALUE_KOREAN("KOREAN"),
      @SerializedName("NORWEGIAN_BOKMAL")
      VALUE_NORWEGIAN_BOKMAL("NORWEGIAN_BOKMAL"),
      @SerializedName("POLISH")
      VALUE_POLISH("POLISH"),
      @SerializedName("PORTUGUESE")
      VALUE_PORTUGUESE("PORTUGUESE"),
      @SerializedName("ROMANIAN")
      VALUE_ROMANIAN("ROMANIAN"),
      @SerializedName("SPANISH")
      VALUE_SPANISH("SPANISH"),
      @SerializedName("SWEDISH")
      VALUE_SWEDISH("SWEDISH"),
      @SerializedName("VIETNAMESE")
      VALUE_VIETNAMESE("VIETNAMESE"),
      NULL(null);

      private String value;

      private EnumModel(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumDomainActionType {
      @SerializedName("ADD")
      VALUE_ADD("ADD"),
      @SerializedName("REMOVE")
      VALUE_REMOVE("REMOVE"),
      NULL(null);

      private String value;

      private EnumDomainActionType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPaymentDevModeAction {
      @SerializedName("ADD")
      VALUE_ADD("ADD"),
      @SerializedName("REMOVE")
      VALUE_REMOVE("REMOVE"),
      NULL(null);

      private String value;

      private EnumPaymentDevModeAction(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSettingType {
      @SerializedName("ACCOUNT_LINKING")
      VALUE_ACCOUNT_LINKING("ACCOUNT_LINKING"),
      @SerializedName("CALL_TO_ACTIONS")
      VALUE_CALL_TO_ACTIONS("CALL_TO_ACTIONS"),
      @SerializedName("GREETING")
      VALUE_GREETING("GREETING"),
      @SerializedName("DOMAIN_WHITELISTING")
      VALUE_DOMAIN_WHITELISTING("DOMAIN_WHITELISTING"),
      @SerializedName("PAYMENT")
      VALUE_PAYMENT("PAYMENT"),
      NULL(null);

      private String value;

      private EnumSettingType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumThreadState {
      @SerializedName("NEW_THREAD")
      VALUE_NEW_THREAD("NEW_THREAD"),
      @SerializedName("EXISTING_THREAD")
      VALUE_EXISTING_THREAD("EXISTING_THREAD"),
      NULL(null);

      private String value;

      private EnumThreadState(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumContentCategory {
      @SerializedName("BEAUTY_FASHION")
      VALUE_BEAUTY_FASHION("BEAUTY_FASHION"),
      @SerializedName("BUSINESS")
      VALUE_BUSINESS("BUSINESS"),
      @SerializedName("CARS_TRUCKS")
      VALUE_CARS_TRUCKS("CARS_TRUCKS"),
      @SerializedName("COMEDY")
      VALUE_COMEDY("COMEDY"),
      @SerializedName("CUTE_ANIMALS")
      VALUE_CUTE_ANIMALS("CUTE_ANIMALS"),
      @SerializedName("ENTERTAINMENT")
      VALUE_ENTERTAINMENT("ENTERTAINMENT"),
      @SerializedName("FAMILY")
      VALUE_FAMILY("FAMILY"),
      @SerializedName("FOOD_HEALTH")
      VALUE_FOOD_HEALTH("FOOD_HEALTH"),
      @SerializedName("HOME")
      VALUE_HOME("HOME"),
      @SerializedName("LIFESTYLE")
      VALUE_LIFESTYLE("LIFESTYLE"),
      @SerializedName("MUSIC")
      VALUE_MUSIC("MUSIC"),
      @SerializedName("NEWS")
      VALUE_NEWS("NEWS"),
      @SerializedName("POLITICS")
      VALUE_POLITICS("POLITICS"),
      @SerializedName("SCIENCE")
      VALUE_SCIENCE("SCIENCE"),
      @SerializedName("SPORTS")
      VALUE_SPORTS("SPORTS"),
      @SerializedName("TECHNOLOGY")
      VALUE_TECHNOLOGY("TECHNOLOGY"),
      @SerializedName("VIDEO_GAMING")
      VALUE_VIDEO_GAMING("VIDEO_GAMING"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      NULL(null);

      private String value;

      private EnumContentCategory(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOriginalProjectionType {
      @SerializedName("equirectangular")
      VALUE_EQUIRECTANGULAR("equirectangular"),
      @SerializedName("cubemap")
      VALUE_CUBEMAP("cubemap"),
      @SerializedName("equiangular_cubemap")
      VALUE_EQUIANGULAR_CUBEMAP("equiangular_cubemap"),
      @SerializedName("half_equirectangular")
      VALUE_HALF_EQUIRECTANGULAR("half_equirectangular"),
      NULL(null);

      private String value;

      private EnumOriginalProjectionType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSwapMode {
      @SerializedName("replace")
      VALUE_REPLACE("replace"),
      NULL(null);

      private String value;

      private EnumSwapMode(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumUnpublishedContentType {
      @SerializedName("SCHEDULED")
      VALUE_SCHEDULED("SCHEDULED"),
      @SerializedName("DRAFT")
      VALUE_DRAFT("DRAFT"),
      @SerializedName("ADS_POST")
      VALUE_ADS_POST("ADS_POST"),
      @SerializedName("INLINE_CREATED")
      VALUE_INLINE_CREATED("INLINE_CREATED"),
      @SerializedName("PUBLISHED")
      VALUE_PUBLISHED("PUBLISHED"),
      NULL(null);

      private String value;

      private EnumUnpublishedContentType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumUploadPhase {
      @SerializedName("start")
      VALUE_START("start"),
      @SerializedName("transfer")
      VALUE_TRANSFER("transfer"),
      @SerializedName("finish")
      VALUE_FINISH("finish"),
      @SerializedName("cancel")
      VALUE_CANCEL("cancel"),
      NULL(null);

      private String value;

      private EnumUploadPhase(String value) {
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

  public Page copyFrom(Page instance) {
    this.mAbout = instance.mAbout;
    this.mAccessToken = instance.mAccessToken;
    this.mAdCampaign = instance.mAdCampaign;
    this.mAffiliation = instance.mAffiliation;
    this.mAppId = instance.mAppId;
    this.mAppLinks = instance.mAppLinks;
    this.mArtistsWeLike = instance.mArtistsWeLike;
    this.mAttire = instance.mAttire;
    this.mAwards = instance.mAwards;
    this.mBandInterests = instance.mBandInterests;
    this.mBandMembers = instance.mBandMembers;
    this.mBestPage = instance.mBestPage;
    this.mBio = instance.mBio;
    this.mBirthday = instance.mBirthday;
    this.mBookingAgent = instance.mBookingAgent;
    this.mBuilt = instance.mBuilt;
    this.mBusiness = instance.mBusiness;
    this.mCanCheckin = instance.mCanCheckin;
    this.mCanPost = instance.mCanPost;
    this.mCategory = instance.mCategory;
    this.mCategoryList = instance.mCategoryList;
    this.mCheckins = instance.mCheckins;
    this.mCompanyOverview = instance.mCompanyOverview;
    this.mConnectedInstagramAccount = instance.mConnectedInstagramAccount;
    this.mContactAddress = instance.mContactAddress;
    this.mContext = instance.mContext;
    this.mCopyrightAttributionInsights = instance.mCopyrightAttributionInsights;
    this.mCopyrightWhitelistedIgPartners = instance.mCopyrightWhitelistedIgPartners;
    this.mCountryPageLikes = instance.mCountryPageLikes;
    this.mCover = instance.mCover;
    this.mCulinaryTeam = instance.mCulinaryTeam;
    this.mCurrentLocation = instance.mCurrentLocation;
    this.mDescription = instance.mDescription;
    this.mDescriptionHtml = instance.mDescriptionHtml;
    this.mDirectedBy = instance.mDirectedBy;
    this.mDisplaySubtext = instance.mDisplaySubtext;
    this.mDisplayedMessageResponseTime = instance.mDisplayedMessageResponseTime;
    this.mEmails = instance.mEmails;
    this.mEngagement = instance.mEngagement;
    this.mFanCount = instance.mFanCount;
    this.mFeaturedVideo = instance.mFeaturedVideo;
    this.mFeatures = instance.mFeatures;
    this.mFoodStyles = instance.mFoodStyles;
    this.mFounded = instance.mFounded;
    this.mGeneralInfo = instance.mGeneralInfo;
    this.mGeneralManager = instance.mGeneralManager;
    this.mGenre = instance.mGenre;
    this.mGlobalBrandPageName = instance.mGlobalBrandPageName;
    this.mGlobalBrandRootId = instance.mGlobalBrandRootId;
    this.mHasAddedApp = instance.mHasAddedApp;
    this.mHasWhatsappNumber = instance.mHasWhatsappNumber;
    this.mHometown = instance.mHometown;
    this.mHours = instance.mHours;
    this.mId = instance.mId;
    this.mImpressum = instance.mImpressum;
    this.mInfluences = instance.mInfluences;
    this.mInstagramBusinessAccount = instance.mInstagramBusinessAccount;
    this.mInstantArticlesReviewStatus = instance.mInstantArticlesReviewStatus;
    this.mIsAlwaysOpen = instance.mIsAlwaysOpen;
    this.mIsChain = instance.mIsChain;
    this.mIsCommunityPage = instance.mIsCommunityPage;
    this.mIsEligibleForBrandedContent = instance.mIsEligibleForBrandedContent;
    this.mIsMessengerBotGetStartedEnabled = instance.mIsMessengerBotGetStartedEnabled;
    this.mIsMessengerPlatformBot = instance.mIsMessengerPlatformBot;
    this.mIsOwned = instance.mIsOwned;
    this.mIsPermanentlyClosed = instance.mIsPermanentlyClosed;
    this.mIsPublished = instance.mIsPublished;
    this.mIsUnclaimed = instance.mIsUnclaimed;
    this.mIsVerified = instance.mIsVerified;
    this.mIsWebhooksSubscribed = instance.mIsWebhooksSubscribed;
    this.mKeywords = instance.mKeywords;
    this.mLeadgenFormPreviewDetails = instance.mLeadgenFormPreviewDetails;
    this.mLeadgenHasCrmIntegration = instance.mLeadgenHasCrmIntegration;
    this.mLeadgenHasFatPingCrmIntegration = instance.mLeadgenHasFatPingCrmIntegration;
    this.mLeadgenTosAcceptanceTime = instance.mLeadgenTosAcceptanceTime;
    this.mLeadgenTosAccepted = instance.mLeadgenTosAccepted;
    this.mLeadgenTosAcceptingUser = instance.mLeadgenTosAcceptingUser;
    this.mLink = instance.mLink;
    this.mLocation = instance.mLocation;
    this.mMembers = instance.mMembers;
    this.mMerchantId = instance.mMerchantId;
    this.mMerchantReviewStatus = instance.mMerchantReviewStatus;
    this.mMessengerAdsDefaultIcebreakers = instance.mMessengerAdsDefaultIcebreakers;
    this.mMessengerAdsDefaultPageWelcomeMessage = instance.mMessengerAdsDefaultPageWelcomeMessage;
    this.mMessengerAdsDefaultQuickReplies = instance.mMessengerAdsDefaultQuickReplies;
    this.mMessengerAdsQuickRepliesType = instance.mMessengerAdsQuickRepliesType;
    this.mMission = instance.mMission;
    this.mMpg = instance.mMpg;
    this.mName = instance.mName;
    this.mNameWithLocationDescriptor = instance.mNameWithLocationDescriptor;
    this.mNetwork = instance.mNetwork;
    this.mNewLikeCount = instance.mNewLikeCount;
    this.mOfferEligible = instance.mOfferEligible;
    this.mOverallStarRating = instance.mOverallStarRating;
    this.mPageToken = instance.mPageToken;
    this.mParentPage = instance.mParentPage;
    this.mParking = instance.mParking;
    this.mPaymentOptions = instance.mPaymentOptions;
    this.mPersonalInfo = instance.mPersonalInfo;
    this.mPersonalInterests = instance.mPersonalInterests;
    this.mPharmaSafetyInfo = instance.mPharmaSafetyInfo;
    this.mPhone = instance.mPhone;
    this.mPlaceType = instance.mPlaceType;
    this.mPlotOutline = instance.mPlotOutline;
    this.mPreferredAudience = instance.mPreferredAudience;
    this.mPressContact = instance.mPressContact;
    this.mPriceRange = instance.mPriceRange;
    this.mProducedBy = instance.mProducedBy;
    this.mProducts = instance.mProducts;
    this.mPromotionEligible = instance.mPromotionEligible;
    this.mPromotionIneligibleReason = instance.mPromotionIneligibleReason;
    this.mPublicTransit = instance.mPublicTransit;
    this.mPublisherSpace = instance.mPublisherSpace;
    this.mRatingCount = instance.mRatingCount;
    this.mRecipient = instance.mRecipient;
    this.mRecordLabel = instance.mRecordLabel;
    this.mReleaseDate = instance.mReleaseDate;
    this.mRestaurantServices = instance.mRestaurantServices;
    this.mRestaurantSpecialties = instance.mRestaurantSpecialties;
    this.mSchedule = instance.mSchedule;
    this.mScreenplayBy = instance.mScreenplayBy;
    this.mSeason = instance.mSeason;
    this.mSingleLineAddress = instance.mSingleLineAddress;
    this.mStarring = instance.mStarring;
    this.mStartInfo = instance.mStartInfo;
    this.mStoreCode = instance.mStoreCode;
    this.mStoreLocationDescriptor = instance.mStoreLocationDescriptor;
    this.mStoreNumber = instance.mStoreNumber;
    this.mStudio = instance.mStudio;
    this.mSupportsInstantArticles = instance.mSupportsInstantArticles;
    this.mTalkingAboutCount = instance.mTalkingAboutCount;
    this.mUnreadMessageCount = instance.mUnreadMessageCount;
    this.mUnreadNotifCount = instance.mUnreadNotifCount;
    this.mUnseenMessageCount = instance.mUnseenMessageCount;
    this.mUsername = instance.mUsername;
    this.mVerificationStatus = instance.mVerificationStatus;
    this.mVoipInfo = instance.mVoipInfo;
    this.mWebsite = instance.mWebsite;
    this.mWereHereCount = instance.mWereHereCount;
    this.mWhatsappNumber = instance.mWhatsappNumber;
    this.mWrittenBy = instance.mWrittenBy;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Page> getParser() {
    return new APIRequest.ResponseParser<Page>() {
      public APINodeList<Page> parseResponse(String response, APIContext context, APIRequest<Page> request) throws MalformedResponseException {
        return Page.parseResponse(response, context, request);
      }
    };
  }
}
