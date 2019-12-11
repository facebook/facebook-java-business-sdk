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
public class OpenGraphContext extends APINode {
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  OpenGraphContext() {
  }

  public OpenGraphContext(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public OpenGraphContext(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public OpenGraphContext fetch() throws APIException{
    OpenGraphContext newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static OpenGraphContext fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<OpenGraphContext> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static OpenGraphContext fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<OpenGraphContext> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<OpenGraphContext> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<OpenGraphContext>)(
      new APIRequest<OpenGraphContext>(context, "", "/", "GET", OpenGraphContext.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<OpenGraphContext>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", OpenGraphContext.getParser())
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
  public static OpenGraphContext loadJSON(String json, APIContext context, String header) {
    OpenGraphContext openGraphContext = getGson().fromJson(json, OpenGraphContext.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(openGraphContext.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    openGraphContext.context = context;
    openGraphContext.rawValue = json;
    openGraphContext.header = header;
    return openGraphContext;
  }

  public static APINodeList<OpenGraphContext> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<OpenGraphContext> openGraphContexts = new APINodeList<OpenGraphContext>(request, json, header);
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
          openGraphContexts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return openGraphContexts;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                openGraphContexts.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            openGraphContexts.setPaging(previous, next);
            if (context.hasAppSecret()) {
              openGraphContexts.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              openGraphContexts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  openGraphContexts.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              openGraphContexts.add(loadJSON(obj.toString(), context, header));
            }
          }
          return openGraphContexts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              openGraphContexts.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return openGraphContexts;
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
              openGraphContexts.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return openGraphContexts;
          }

          // Sixth, check if it's pure JsonObject
          openGraphContexts.clear();
          openGraphContexts.add(loadJSON(json, context, header));
          return openGraphContexts;
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

  public APIRequestGetFriendsTaggedAt getFriendsTaggedAt() {
    return new APIRequestGetFriendsTaggedAt(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMusicListenFriends getMusicListenFriends() {
    return new APIRequestGetMusicListenFriends(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetVideoWatchFriends getVideoWatchFriends() {
    return new APIRequestGetVideoWatchFriends(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGetFriendsTaggedAt extends APIRequest<User> {

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
               return APIRequestGetFriendsTaggedAt.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetFriendsTaggedAt(String nodeId, APIContext context) {
      super(context, nodeId, "/friends_tagged_at", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetFriendsTaggedAt setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetFriendsTaggedAt setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetFriendsTaggedAt requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetFriendsTaggedAt requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetFriendsTaggedAt requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetFriendsTaggedAt requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetFriendsTaggedAt requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetFriendsTaggedAt requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetFriendsTaggedAt requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetFriendsTaggedAt requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetFriendsTaggedAt requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestAdminNotesField () {
      return this.requestAdminNotesField(true);
    }
    public APIRequestGetFriendsTaggedAt requestAdminNotesField (boolean value) {
      this.requestField("admin_notes", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestAgeRangeField () {
      return this.requestAgeRangeField(true);
    }
    public APIRequestGetFriendsTaggedAt requestAgeRangeField (boolean value) {
      this.requestField("age_range", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestAuthMethodField () {
      return this.requestAuthMethodField(true);
    }
    public APIRequestGetFriendsTaggedAt requestAuthMethodField (boolean value) {
      this.requestField("auth_method", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetFriendsTaggedAt requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestCanReviewMeasurementRequestField () {
      return this.requestCanReviewMeasurementRequestField(true);
    }
    public APIRequestGetFriendsTaggedAt requestCanReviewMeasurementRequestField (boolean value) {
      this.requestField("can_review_measurement_request", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetFriendsTaggedAt requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetFriendsTaggedAt requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestDevicesField () {
      return this.requestDevicesField(true);
    }
    public APIRequestGetFriendsTaggedAt requestDevicesField (boolean value) {
      this.requestField("devices", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestEducationField () {
      return this.requestEducationField(true);
    }
    public APIRequestGetFriendsTaggedAt requestEducationField (boolean value) {
      this.requestField("education", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetFriendsTaggedAt requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestFavoriteAthletesField () {
      return this.requestFavoriteAthletesField(true);
    }
    public APIRequestGetFriendsTaggedAt requestFavoriteAthletesField (boolean value) {
      this.requestField("favorite_athletes", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestFavoriteTeamsField () {
      return this.requestFavoriteTeamsField(true);
    }
    public APIRequestGetFriendsTaggedAt requestFavoriteTeamsField (boolean value) {
      this.requestField("favorite_teams", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetFriendsTaggedAt requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetFriendsTaggedAt requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetFriendsTaggedAt requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetFriendsTaggedAt requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestInspirationalPeopleField () {
      return this.requestInspirationalPeopleField(true);
    }
    public APIRequestGetFriendsTaggedAt requestInspirationalPeopleField (boolean value) {
      this.requestField("inspirational_people", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestInstallTypeField () {
      return this.requestInstallTypeField(true);
    }
    public APIRequestGetFriendsTaggedAt requestInstallTypeField (boolean value) {
      this.requestField("install_type", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestInstalledField () {
      return this.requestInstalledField(true);
    }
    public APIRequestGetFriendsTaggedAt requestInstalledField (boolean value) {
      this.requestField("installed", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestInterestedInField () {
      return this.requestInterestedInField(true);
    }
    public APIRequestGetFriendsTaggedAt requestInterestedInField (boolean value) {
      this.requestField("interested_in", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestIsFamedeeplinkinguserField () {
      return this.requestIsFamedeeplinkinguserField(true);
    }
    public APIRequestGetFriendsTaggedAt requestIsFamedeeplinkinguserField (boolean value) {
      this.requestField("is_famedeeplinkinguser", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestIsGuestUserField () {
      return this.requestIsGuestUserField(true);
    }
    public APIRequestGetFriendsTaggedAt requestIsGuestUserField (boolean value) {
      this.requestField("is_guest_user", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestIsSharedLoginField () {
      return this.requestIsSharedLoginField(true);
    }
    public APIRequestGetFriendsTaggedAt requestIsSharedLoginField (boolean value) {
      this.requestField("is_shared_login", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetFriendsTaggedAt requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestLanguagesField () {
      return this.requestLanguagesField(true);
    }
    public APIRequestGetFriendsTaggedAt requestLanguagesField (boolean value) {
      this.requestField("languages", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetFriendsTaggedAt requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetFriendsTaggedAt requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestLocalNewsMegaphoneDismissStatusField () {
      return this.requestLocalNewsMegaphoneDismissStatusField(true);
    }
    public APIRequestGetFriendsTaggedAt requestLocalNewsMegaphoneDismissStatusField (boolean value) {
      this.requestField("local_news_megaphone_dismiss_status", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestLocalNewsSubscriptionStatusField () {
      return this.requestLocalNewsSubscriptionStatusField(true);
    }
    public APIRequestGetFriendsTaggedAt requestLocalNewsSubscriptionStatusField (boolean value) {
      this.requestField("local_news_subscription_status", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetFriendsTaggedAt requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetFriendsTaggedAt requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestMeetingForField () {
      return this.requestMeetingForField(true);
    }
    public APIRequestGetFriendsTaggedAt requestMeetingForField (boolean value) {
      this.requestField("meeting_for", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestMiddleNameField () {
      return this.requestMiddleNameField(true);
    }
    public APIRequestGetFriendsTaggedAt requestMiddleNameField (boolean value) {
      this.requestField("middle_name", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetFriendsTaggedAt requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestNameFormatField () {
      return this.requestNameFormatField(true);
    }
    public APIRequestGetFriendsTaggedAt requestNameFormatField (boolean value) {
      this.requestField("name_format", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestPaymentPricepointsField () {
      return this.requestPaymentPricepointsField(true);
    }
    public APIRequestGetFriendsTaggedAt requestPaymentPricepointsField (boolean value) {
      this.requestField("payment_pricepoints", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestPoliticalField () {
      return this.requestPoliticalField(true);
    }
    public APIRequestGetFriendsTaggedAt requestPoliticalField (boolean value) {
      this.requestField("political", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetFriendsTaggedAt requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestPublicKeyField () {
      return this.requestPublicKeyField(true);
    }
    public APIRequestGetFriendsTaggedAt requestPublicKeyField (boolean value) {
      this.requestField("public_key", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestQuotesField () {
      return this.requestQuotesField(true);
    }
    public APIRequestGetFriendsTaggedAt requestQuotesField (boolean value) {
      this.requestField("quotes", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestRelationshipStatusField () {
      return this.requestRelationshipStatusField(true);
    }
    public APIRequestGetFriendsTaggedAt requestRelationshipStatusField (boolean value) {
      this.requestField("relationship_status", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestReligionField () {
      return this.requestReligionField(true);
    }
    public APIRequestGetFriendsTaggedAt requestReligionField (boolean value) {
      this.requestField("religion", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestSecuritySettingsField () {
      return this.requestSecuritySettingsField(true);
    }
    public APIRequestGetFriendsTaggedAt requestSecuritySettingsField (boolean value) {
      this.requestField("security_settings", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestSharedLoginUpgradeRequiredByField () {
      return this.requestSharedLoginUpgradeRequiredByField(true);
    }
    public APIRequestGetFriendsTaggedAt requestSharedLoginUpgradeRequiredByField (boolean value) {
      this.requestField("shared_login_upgrade_required_by", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestShortNameField () {
      return this.requestShortNameField(true);
    }
    public APIRequestGetFriendsTaggedAt requestShortNameField (boolean value) {
      this.requestField("short_name", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestSignificantOtherField () {
      return this.requestSignificantOtherField(true);
    }
    public APIRequestGetFriendsTaggedAt requestSignificantOtherField (boolean value) {
      this.requestField("significant_other", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestSportsField () {
      return this.requestSportsField(true);
    }
    public APIRequestGetFriendsTaggedAt requestSportsField (boolean value) {
      this.requestField("sports", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestTestGroupField () {
      return this.requestTestGroupField(true);
    }
    public APIRequestGetFriendsTaggedAt requestTestGroupField (boolean value) {
      this.requestField("test_group", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestThirdPartyIdField () {
      return this.requestThirdPartyIdField(true);
    }
    public APIRequestGetFriendsTaggedAt requestThirdPartyIdField (boolean value) {
      this.requestField("third_party_id", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetFriendsTaggedAt requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestTokenForBusinessField () {
      return this.requestTokenForBusinessField(true);
    }
    public APIRequestGetFriendsTaggedAt requestTokenForBusinessField (boolean value) {
      this.requestField("token_for_business", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetFriendsTaggedAt requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestVerifiedField () {
      return this.requestVerifiedField(true);
    }
    public APIRequestGetFriendsTaggedAt requestVerifiedField (boolean value) {
      this.requestField("verified", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestVideoUploadLimitsField () {
      return this.requestVideoUploadLimitsField(true);
    }
    public APIRequestGetFriendsTaggedAt requestVideoUploadLimitsField (boolean value) {
      this.requestField("video_upload_limits", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestViewerCanSendGiftField () {
      return this.requestViewerCanSendGiftField(true);
    }
    public APIRequestGetFriendsTaggedAt requestViewerCanSendGiftField (boolean value) {
      this.requestField("viewer_can_send_gift", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetFriendsTaggedAt requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetFriendsTaggedAt requestWorkField () {
      return this.requestWorkField(true);
    }
    public APIRequestGetFriendsTaggedAt requestWorkField (boolean value) {
      this.requestField("work", value);
      return this;
    }
  }

  public static class APIRequestGetMusicListenFriends extends APIRequest<User> {

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
               return APIRequestGetMusicListenFriends.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetMusicListenFriends(String nodeId, APIContext context) {
      super(context, nodeId, "/music_listen_friends", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMusicListenFriends setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMusicListenFriends setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMusicListenFriends requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMusicListenFriends requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMusicListenFriends requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMusicListenFriends requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMusicListenFriends requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMusicListenFriends requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetMusicListenFriends requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetMusicListenFriends requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetMusicListenFriends requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestAdminNotesField () {
      return this.requestAdminNotesField(true);
    }
    public APIRequestGetMusicListenFriends requestAdminNotesField (boolean value) {
      this.requestField("admin_notes", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestAgeRangeField () {
      return this.requestAgeRangeField(true);
    }
    public APIRequestGetMusicListenFriends requestAgeRangeField (boolean value) {
      this.requestField("age_range", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestAuthMethodField () {
      return this.requestAuthMethodField(true);
    }
    public APIRequestGetMusicListenFriends requestAuthMethodField (boolean value) {
      this.requestField("auth_method", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetMusicListenFriends requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestCanReviewMeasurementRequestField () {
      return this.requestCanReviewMeasurementRequestField(true);
    }
    public APIRequestGetMusicListenFriends requestCanReviewMeasurementRequestField (boolean value) {
      this.requestField("can_review_measurement_request", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetMusicListenFriends requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetMusicListenFriends requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestDevicesField () {
      return this.requestDevicesField(true);
    }
    public APIRequestGetMusicListenFriends requestDevicesField (boolean value) {
      this.requestField("devices", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestEducationField () {
      return this.requestEducationField(true);
    }
    public APIRequestGetMusicListenFriends requestEducationField (boolean value) {
      this.requestField("education", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetMusicListenFriends requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestFavoriteAthletesField () {
      return this.requestFavoriteAthletesField(true);
    }
    public APIRequestGetMusicListenFriends requestFavoriteAthletesField (boolean value) {
      this.requestField("favorite_athletes", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestFavoriteTeamsField () {
      return this.requestFavoriteTeamsField(true);
    }
    public APIRequestGetMusicListenFriends requestFavoriteTeamsField (boolean value) {
      this.requestField("favorite_teams", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetMusicListenFriends requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetMusicListenFriends requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetMusicListenFriends requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetMusicListenFriends requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestInspirationalPeopleField () {
      return this.requestInspirationalPeopleField(true);
    }
    public APIRequestGetMusicListenFriends requestInspirationalPeopleField (boolean value) {
      this.requestField("inspirational_people", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestInstallTypeField () {
      return this.requestInstallTypeField(true);
    }
    public APIRequestGetMusicListenFriends requestInstallTypeField (boolean value) {
      this.requestField("install_type", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestInstalledField () {
      return this.requestInstalledField(true);
    }
    public APIRequestGetMusicListenFriends requestInstalledField (boolean value) {
      this.requestField("installed", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestInterestedInField () {
      return this.requestInterestedInField(true);
    }
    public APIRequestGetMusicListenFriends requestInterestedInField (boolean value) {
      this.requestField("interested_in", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestIsFamedeeplinkinguserField () {
      return this.requestIsFamedeeplinkinguserField(true);
    }
    public APIRequestGetMusicListenFriends requestIsFamedeeplinkinguserField (boolean value) {
      this.requestField("is_famedeeplinkinguser", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestIsGuestUserField () {
      return this.requestIsGuestUserField(true);
    }
    public APIRequestGetMusicListenFriends requestIsGuestUserField (boolean value) {
      this.requestField("is_guest_user", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestIsSharedLoginField () {
      return this.requestIsSharedLoginField(true);
    }
    public APIRequestGetMusicListenFriends requestIsSharedLoginField (boolean value) {
      this.requestField("is_shared_login", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetMusicListenFriends requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestLanguagesField () {
      return this.requestLanguagesField(true);
    }
    public APIRequestGetMusicListenFriends requestLanguagesField (boolean value) {
      this.requestField("languages", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetMusicListenFriends requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetMusicListenFriends requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestLocalNewsMegaphoneDismissStatusField () {
      return this.requestLocalNewsMegaphoneDismissStatusField(true);
    }
    public APIRequestGetMusicListenFriends requestLocalNewsMegaphoneDismissStatusField (boolean value) {
      this.requestField("local_news_megaphone_dismiss_status", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestLocalNewsSubscriptionStatusField () {
      return this.requestLocalNewsSubscriptionStatusField(true);
    }
    public APIRequestGetMusicListenFriends requestLocalNewsSubscriptionStatusField (boolean value) {
      this.requestField("local_news_subscription_status", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetMusicListenFriends requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetMusicListenFriends requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestMeetingForField () {
      return this.requestMeetingForField(true);
    }
    public APIRequestGetMusicListenFriends requestMeetingForField (boolean value) {
      this.requestField("meeting_for", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestMiddleNameField () {
      return this.requestMiddleNameField(true);
    }
    public APIRequestGetMusicListenFriends requestMiddleNameField (boolean value) {
      this.requestField("middle_name", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetMusicListenFriends requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestNameFormatField () {
      return this.requestNameFormatField(true);
    }
    public APIRequestGetMusicListenFriends requestNameFormatField (boolean value) {
      this.requestField("name_format", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestPaymentPricepointsField () {
      return this.requestPaymentPricepointsField(true);
    }
    public APIRequestGetMusicListenFriends requestPaymentPricepointsField (boolean value) {
      this.requestField("payment_pricepoints", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestPoliticalField () {
      return this.requestPoliticalField(true);
    }
    public APIRequestGetMusicListenFriends requestPoliticalField (boolean value) {
      this.requestField("political", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetMusicListenFriends requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestPublicKeyField () {
      return this.requestPublicKeyField(true);
    }
    public APIRequestGetMusicListenFriends requestPublicKeyField (boolean value) {
      this.requestField("public_key", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestQuotesField () {
      return this.requestQuotesField(true);
    }
    public APIRequestGetMusicListenFriends requestQuotesField (boolean value) {
      this.requestField("quotes", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestRelationshipStatusField () {
      return this.requestRelationshipStatusField(true);
    }
    public APIRequestGetMusicListenFriends requestRelationshipStatusField (boolean value) {
      this.requestField("relationship_status", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestReligionField () {
      return this.requestReligionField(true);
    }
    public APIRequestGetMusicListenFriends requestReligionField (boolean value) {
      this.requestField("religion", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestSecuritySettingsField () {
      return this.requestSecuritySettingsField(true);
    }
    public APIRequestGetMusicListenFriends requestSecuritySettingsField (boolean value) {
      this.requestField("security_settings", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestSharedLoginUpgradeRequiredByField () {
      return this.requestSharedLoginUpgradeRequiredByField(true);
    }
    public APIRequestGetMusicListenFriends requestSharedLoginUpgradeRequiredByField (boolean value) {
      this.requestField("shared_login_upgrade_required_by", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestShortNameField () {
      return this.requestShortNameField(true);
    }
    public APIRequestGetMusicListenFriends requestShortNameField (boolean value) {
      this.requestField("short_name", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestSignificantOtherField () {
      return this.requestSignificantOtherField(true);
    }
    public APIRequestGetMusicListenFriends requestSignificantOtherField (boolean value) {
      this.requestField("significant_other", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestSportsField () {
      return this.requestSportsField(true);
    }
    public APIRequestGetMusicListenFriends requestSportsField (boolean value) {
      this.requestField("sports", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestTestGroupField () {
      return this.requestTestGroupField(true);
    }
    public APIRequestGetMusicListenFriends requestTestGroupField (boolean value) {
      this.requestField("test_group", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestThirdPartyIdField () {
      return this.requestThirdPartyIdField(true);
    }
    public APIRequestGetMusicListenFriends requestThirdPartyIdField (boolean value) {
      this.requestField("third_party_id", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetMusicListenFriends requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestTokenForBusinessField () {
      return this.requestTokenForBusinessField(true);
    }
    public APIRequestGetMusicListenFriends requestTokenForBusinessField (boolean value) {
      this.requestField("token_for_business", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetMusicListenFriends requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestVerifiedField () {
      return this.requestVerifiedField(true);
    }
    public APIRequestGetMusicListenFriends requestVerifiedField (boolean value) {
      this.requestField("verified", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestVideoUploadLimitsField () {
      return this.requestVideoUploadLimitsField(true);
    }
    public APIRequestGetMusicListenFriends requestVideoUploadLimitsField (boolean value) {
      this.requestField("video_upload_limits", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestViewerCanSendGiftField () {
      return this.requestViewerCanSendGiftField(true);
    }
    public APIRequestGetMusicListenFriends requestViewerCanSendGiftField (boolean value) {
      this.requestField("viewer_can_send_gift", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetMusicListenFriends requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetMusicListenFriends requestWorkField () {
      return this.requestWorkField(true);
    }
    public APIRequestGetMusicListenFriends requestWorkField (boolean value) {
      this.requestField("work", value);
      return this;
    }
  }

  public static class APIRequestGetVideoWatchFriends extends APIRequest<User> {

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
               return APIRequestGetVideoWatchFriends.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetVideoWatchFriends(String nodeId, APIContext context) {
      super(context, nodeId, "/video_watch_friends", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetVideoWatchFriends setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetVideoWatchFriends setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetVideoWatchFriends requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetVideoWatchFriends requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideoWatchFriends requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetVideoWatchFriends requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideoWatchFriends requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetVideoWatchFriends requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetVideoWatchFriends requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetVideoWatchFriends requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetVideoWatchFriends requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestAdminNotesField () {
      return this.requestAdminNotesField(true);
    }
    public APIRequestGetVideoWatchFriends requestAdminNotesField (boolean value) {
      this.requestField("admin_notes", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestAgeRangeField () {
      return this.requestAgeRangeField(true);
    }
    public APIRequestGetVideoWatchFriends requestAgeRangeField (boolean value) {
      this.requestField("age_range", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestAuthMethodField () {
      return this.requestAuthMethodField(true);
    }
    public APIRequestGetVideoWatchFriends requestAuthMethodField (boolean value) {
      this.requestField("auth_method", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetVideoWatchFriends requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestCanReviewMeasurementRequestField () {
      return this.requestCanReviewMeasurementRequestField(true);
    }
    public APIRequestGetVideoWatchFriends requestCanReviewMeasurementRequestField (boolean value) {
      this.requestField("can_review_measurement_request", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetVideoWatchFriends requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetVideoWatchFriends requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestDevicesField () {
      return this.requestDevicesField(true);
    }
    public APIRequestGetVideoWatchFriends requestDevicesField (boolean value) {
      this.requestField("devices", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestEducationField () {
      return this.requestEducationField(true);
    }
    public APIRequestGetVideoWatchFriends requestEducationField (boolean value) {
      this.requestField("education", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetVideoWatchFriends requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestFavoriteAthletesField () {
      return this.requestFavoriteAthletesField(true);
    }
    public APIRequestGetVideoWatchFriends requestFavoriteAthletesField (boolean value) {
      this.requestField("favorite_athletes", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestFavoriteTeamsField () {
      return this.requestFavoriteTeamsField(true);
    }
    public APIRequestGetVideoWatchFriends requestFavoriteTeamsField (boolean value) {
      this.requestField("favorite_teams", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetVideoWatchFriends requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetVideoWatchFriends requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetVideoWatchFriends requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetVideoWatchFriends requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestInspirationalPeopleField () {
      return this.requestInspirationalPeopleField(true);
    }
    public APIRequestGetVideoWatchFriends requestInspirationalPeopleField (boolean value) {
      this.requestField("inspirational_people", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestInstallTypeField () {
      return this.requestInstallTypeField(true);
    }
    public APIRequestGetVideoWatchFriends requestInstallTypeField (boolean value) {
      this.requestField("install_type", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestInstalledField () {
      return this.requestInstalledField(true);
    }
    public APIRequestGetVideoWatchFriends requestInstalledField (boolean value) {
      this.requestField("installed", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestInterestedInField () {
      return this.requestInterestedInField(true);
    }
    public APIRequestGetVideoWatchFriends requestInterestedInField (boolean value) {
      this.requestField("interested_in", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestIsFamedeeplinkinguserField () {
      return this.requestIsFamedeeplinkinguserField(true);
    }
    public APIRequestGetVideoWatchFriends requestIsFamedeeplinkinguserField (boolean value) {
      this.requestField("is_famedeeplinkinguser", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestIsGuestUserField () {
      return this.requestIsGuestUserField(true);
    }
    public APIRequestGetVideoWatchFriends requestIsGuestUserField (boolean value) {
      this.requestField("is_guest_user", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestIsSharedLoginField () {
      return this.requestIsSharedLoginField(true);
    }
    public APIRequestGetVideoWatchFriends requestIsSharedLoginField (boolean value) {
      this.requestField("is_shared_login", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetVideoWatchFriends requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestLanguagesField () {
      return this.requestLanguagesField(true);
    }
    public APIRequestGetVideoWatchFriends requestLanguagesField (boolean value) {
      this.requestField("languages", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetVideoWatchFriends requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetVideoWatchFriends requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestLocalNewsMegaphoneDismissStatusField () {
      return this.requestLocalNewsMegaphoneDismissStatusField(true);
    }
    public APIRequestGetVideoWatchFriends requestLocalNewsMegaphoneDismissStatusField (boolean value) {
      this.requestField("local_news_megaphone_dismiss_status", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestLocalNewsSubscriptionStatusField () {
      return this.requestLocalNewsSubscriptionStatusField(true);
    }
    public APIRequestGetVideoWatchFriends requestLocalNewsSubscriptionStatusField (boolean value) {
      this.requestField("local_news_subscription_status", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetVideoWatchFriends requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetVideoWatchFriends requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestMeetingForField () {
      return this.requestMeetingForField(true);
    }
    public APIRequestGetVideoWatchFriends requestMeetingForField (boolean value) {
      this.requestField("meeting_for", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestMiddleNameField () {
      return this.requestMiddleNameField(true);
    }
    public APIRequestGetVideoWatchFriends requestMiddleNameField (boolean value) {
      this.requestField("middle_name", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetVideoWatchFriends requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestNameFormatField () {
      return this.requestNameFormatField(true);
    }
    public APIRequestGetVideoWatchFriends requestNameFormatField (boolean value) {
      this.requestField("name_format", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestPaymentPricepointsField () {
      return this.requestPaymentPricepointsField(true);
    }
    public APIRequestGetVideoWatchFriends requestPaymentPricepointsField (boolean value) {
      this.requestField("payment_pricepoints", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestPoliticalField () {
      return this.requestPoliticalField(true);
    }
    public APIRequestGetVideoWatchFriends requestPoliticalField (boolean value) {
      this.requestField("political", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetVideoWatchFriends requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestPublicKeyField () {
      return this.requestPublicKeyField(true);
    }
    public APIRequestGetVideoWatchFriends requestPublicKeyField (boolean value) {
      this.requestField("public_key", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestQuotesField () {
      return this.requestQuotesField(true);
    }
    public APIRequestGetVideoWatchFriends requestQuotesField (boolean value) {
      this.requestField("quotes", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestRelationshipStatusField () {
      return this.requestRelationshipStatusField(true);
    }
    public APIRequestGetVideoWatchFriends requestRelationshipStatusField (boolean value) {
      this.requestField("relationship_status", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestReligionField () {
      return this.requestReligionField(true);
    }
    public APIRequestGetVideoWatchFriends requestReligionField (boolean value) {
      this.requestField("religion", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestSecuritySettingsField () {
      return this.requestSecuritySettingsField(true);
    }
    public APIRequestGetVideoWatchFriends requestSecuritySettingsField (boolean value) {
      this.requestField("security_settings", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestSharedLoginUpgradeRequiredByField () {
      return this.requestSharedLoginUpgradeRequiredByField(true);
    }
    public APIRequestGetVideoWatchFriends requestSharedLoginUpgradeRequiredByField (boolean value) {
      this.requestField("shared_login_upgrade_required_by", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestShortNameField () {
      return this.requestShortNameField(true);
    }
    public APIRequestGetVideoWatchFriends requestShortNameField (boolean value) {
      this.requestField("short_name", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestSignificantOtherField () {
      return this.requestSignificantOtherField(true);
    }
    public APIRequestGetVideoWatchFriends requestSignificantOtherField (boolean value) {
      this.requestField("significant_other", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestSportsField () {
      return this.requestSportsField(true);
    }
    public APIRequestGetVideoWatchFriends requestSportsField (boolean value) {
      this.requestField("sports", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestTestGroupField () {
      return this.requestTestGroupField(true);
    }
    public APIRequestGetVideoWatchFriends requestTestGroupField (boolean value) {
      this.requestField("test_group", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestThirdPartyIdField () {
      return this.requestThirdPartyIdField(true);
    }
    public APIRequestGetVideoWatchFriends requestThirdPartyIdField (boolean value) {
      this.requestField("third_party_id", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetVideoWatchFriends requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestTokenForBusinessField () {
      return this.requestTokenForBusinessField(true);
    }
    public APIRequestGetVideoWatchFriends requestTokenForBusinessField (boolean value) {
      this.requestField("token_for_business", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetVideoWatchFriends requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestVerifiedField () {
      return this.requestVerifiedField(true);
    }
    public APIRequestGetVideoWatchFriends requestVerifiedField (boolean value) {
      this.requestField("verified", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestVideoUploadLimitsField () {
      return this.requestVideoUploadLimitsField(true);
    }
    public APIRequestGetVideoWatchFriends requestVideoUploadLimitsField (boolean value) {
      this.requestField("video_upload_limits", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestViewerCanSendGiftField () {
      return this.requestViewerCanSendGiftField(true);
    }
    public APIRequestGetVideoWatchFriends requestViewerCanSendGiftField (boolean value) {
      this.requestField("viewer_can_send_gift", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetVideoWatchFriends requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetVideoWatchFriends requestWorkField () {
      return this.requestWorkField(true);
    }
    public APIRequestGetVideoWatchFriends requestWorkField (boolean value) {
      this.requestField("work", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<OpenGraphContext> {

    OpenGraphContext lastResponse = null;
    @Override
    public OpenGraphContext getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
    };

    @Override
    public OpenGraphContext parseResponse(String response, String header) throws APIException {
      return OpenGraphContext.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public OpenGraphContext execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OpenGraphContext execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<OpenGraphContext> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<OpenGraphContext> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, OpenGraphContext>() {
           public OpenGraphContext apply(ResponseWrapper result) {
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

  public OpenGraphContext copyFrom(OpenGraphContext instance) {
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<OpenGraphContext> getParser() {
    return new APIRequest.ResponseParser<OpenGraphContext>() {
      public APINodeList<OpenGraphContext> parseResponse(String response, APIContext context, APIRequest<OpenGraphContext> request, String header) throws MalformedResponseException {
        return OpenGraphContext.parseResponse(response, context, request, header);
      }
    };
  }
}
