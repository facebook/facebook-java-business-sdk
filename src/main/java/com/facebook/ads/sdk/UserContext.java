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
public class UserContext extends APINode {
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  UserContext() {
  }

  public UserContext(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public UserContext(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public UserContext fetch() throws APIException{
    UserContext newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static UserContext fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<UserContext> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static UserContext fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<UserContext> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<UserContext> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<UserContext>)(
      new APIRequest<UserContext>(context, "", "/", "GET", UserContext.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<UserContext>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", UserContext.getParser())
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
  public static UserContext loadJSON(String json, APIContext context) {
    UserContext userContext = getGson().fromJson(json, UserContext.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(userContext.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    userContext.context = context;
    userContext.rawValue = json;
    return userContext;
  }

  public static APINodeList<UserContext> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<UserContext> userContexts = new APINodeList<UserContext>(request, json);
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
          userContexts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return userContexts;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                userContexts.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            userContexts.setPaging(previous, next);
            if (context.hasAppSecret()) {
              userContexts.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              userContexts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  userContexts.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              userContexts.add(loadJSON(obj.toString(), context));
            }
          }
          return userContexts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              userContexts.add(loadJSON(entry.getValue().toString(), context));
          }
          return userContexts;
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
              userContexts.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return userContexts;
          }

          // Sixth, check if it's pure JsonObject
          userContexts.clear();
          userContexts.add(loadJSON(json, context));
          return userContexts;
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

  public APIRequestGetAllMutualFriends getAllMutualFriends() {
    return new APIRequestGetAllMutualFriends(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMutualFriends getMutualFriends() {
    return new APIRequestGetMutualFriends(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMutualLikes getMutualLikes() {
    return new APIRequestGetMutualLikes(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetThreeDegreeMutualFriends getThreeDegreeMutualFriends() {
    return new APIRequestGetThreeDegreeMutualFriends(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGetAllMutualFriends extends APIRequest<APINode> {

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
               return APIRequestGetAllMutualFriends.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAllMutualFriends(String nodeId, APIContext context) {
      super(context, nodeId, "/all_mutual_friends", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAllMutualFriends setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAllMutualFriends setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAllMutualFriends requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAllMutualFriends requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAllMutualFriends requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAllMutualFriends requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAllMutualFriends requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAllMutualFriends requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetMutualFriends extends APIRequest<User> {

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
      "bio",
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
      "username",
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
               return APIRequestGetMutualFriends.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetMutualFriends(String nodeId, APIContext context) {
      super(context, nodeId, "/mutual_friends", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMutualFriends setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMutualFriends setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMutualFriends requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMutualFriends requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMutualFriends requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMutualFriends requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMutualFriends requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMutualFriends requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetMutualFriends requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetMutualFriends requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetMutualFriends requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetMutualFriends requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetMutualFriends requestAdminNotesField () {
      return this.requestAdminNotesField(true);
    }
    public APIRequestGetMutualFriends requestAdminNotesField (boolean value) {
      this.requestField("admin_notes", value);
      return this;
    }
    public APIRequestGetMutualFriends requestAgeRangeField () {
      return this.requestAgeRangeField(true);
    }
    public APIRequestGetMutualFriends requestAgeRangeField (boolean value) {
      this.requestField("age_range", value);
      return this;
    }
    public APIRequestGetMutualFriends requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetMutualFriends requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetMutualFriends requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetMutualFriends requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetMutualFriends requestCanReviewMeasurementRequestField () {
      return this.requestCanReviewMeasurementRequestField(true);
    }
    public APIRequestGetMutualFriends requestCanReviewMeasurementRequestField (boolean value) {
      this.requestField("can_review_measurement_request", value);
      return this;
    }
    public APIRequestGetMutualFriends requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetMutualFriends requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetMutualFriends requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetMutualFriends requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetMutualFriends requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetMutualFriends requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetMutualFriends requestDevicesField () {
      return this.requestDevicesField(true);
    }
    public APIRequestGetMutualFriends requestDevicesField (boolean value) {
      this.requestField("devices", value);
      return this;
    }
    public APIRequestGetMutualFriends requestEducationField () {
      return this.requestEducationField(true);
    }
    public APIRequestGetMutualFriends requestEducationField (boolean value) {
      this.requestField("education", value);
      return this;
    }
    public APIRequestGetMutualFriends requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetMutualFriends requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetMutualFriends requestEmployeeNumberField () {
      return this.requestEmployeeNumberField(true);
    }
    public APIRequestGetMutualFriends requestEmployeeNumberField (boolean value) {
      this.requestField("employee_number", value);
      return this;
    }
    public APIRequestGetMutualFriends requestFavoriteAthletesField () {
      return this.requestFavoriteAthletesField(true);
    }
    public APIRequestGetMutualFriends requestFavoriteAthletesField (boolean value) {
      this.requestField("favorite_athletes", value);
      return this;
    }
    public APIRequestGetMutualFriends requestFavoriteTeamsField () {
      return this.requestFavoriteTeamsField(true);
    }
    public APIRequestGetMutualFriends requestFavoriteTeamsField (boolean value) {
      this.requestField("favorite_teams", value);
      return this;
    }
    public APIRequestGetMutualFriends requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetMutualFriends requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetMutualFriends requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetMutualFriends requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetMutualFriends requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetMutualFriends requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetMutualFriends requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetMutualFriends requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetMutualFriends requestInspirationalPeopleField () {
      return this.requestInspirationalPeopleField(true);
    }
    public APIRequestGetMutualFriends requestInspirationalPeopleField (boolean value) {
      this.requestField("inspirational_people", value);
      return this;
    }
    public APIRequestGetMutualFriends requestInstallTypeField () {
      return this.requestInstallTypeField(true);
    }
    public APIRequestGetMutualFriends requestInstallTypeField (boolean value) {
      this.requestField("install_type", value);
      return this;
    }
    public APIRequestGetMutualFriends requestInstalledField () {
      return this.requestInstalledField(true);
    }
    public APIRequestGetMutualFriends requestInstalledField (boolean value) {
      this.requestField("installed", value);
      return this;
    }
    public APIRequestGetMutualFriends requestInterestedInField () {
      return this.requestInterestedInField(true);
    }
    public APIRequestGetMutualFriends requestInterestedInField (boolean value) {
      this.requestField("interested_in", value);
      return this;
    }
    public APIRequestGetMutualFriends requestIsFamedeeplinkinguserField () {
      return this.requestIsFamedeeplinkinguserField(true);
    }
    public APIRequestGetMutualFriends requestIsFamedeeplinkinguserField (boolean value) {
      this.requestField("is_famedeeplinkinguser", value);
      return this;
    }
    public APIRequestGetMutualFriends requestIsSharedLoginField () {
      return this.requestIsSharedLoginField(true);
    }
    public APIRequestGetMutualFriends requestIsSharedLoginField (boolean value) {
      this.requestField("is_shared_login", value);
      return this;
    }
    public APIRequestGetMutualFriends requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetMutualFriends requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetMutualFriends requestLabelsField () {
      return this.requestLabelsField(true);
    }
    public APIRequestGetMutualFriends requestLabelsField (boolean value) {
      this.requestField("labels", value);
      return this;
    }
    public APIRequestGetMutualFriends requestLanguagesField () {
      return this.requestLanguagesField(true);
    }
    public APIRequestGetMutualFriends requestLanguagesField (boolean value) {
      this.requestField("languages", value);
      return this;
    }
    public APIRequestGetMutualFriends requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetMutualFriends requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetMutualFriends requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetMutualFriends requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetMutualFriends requestLocalNewsMegaphoneDismissStatusField () {
      return this.requestLocalNewsMegaphoneDismissStatusField(true);
    }
    public APIRequestGetMutualFriends requestLocalNewsMegaphoneDismissStatusField (boolean value) {
      this.requestField("local_news_megaphone_dismiss_status", value);
      return this;
    }
    public APIRequestGetMutualFriends requestLocalNewsSubscriptionStatusField () {
      return this.requestLocalNewsSubscriptionStatusField(true);
    }
    public APIRequestGetMutualFriends requestLocalNewsSubscriptionStatusField (boolean value) {
      this.requestField("local_news_subscription_status", value);
      return this;
    }
    public APIRequestGetMutualFriends requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetMutualFriends requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetMutualFriends requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetMutualFriends requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetMutualFriends requestMeetingForField () {
      return this.requestMeetingForField(true);
    }
    public APIRequestGetMutualFriends requestMeetingForField (boolean value) {
      this.requestField("meeting_for", value);
      return this;
    }
    public APIRequestGetMutualFriends requestMiddleNameField () {
      return this.requestMiddleNameField(true);
    }
    public APIRequestGetMutualFriends requestMiddleNameField (boolean value) {
      this.requestField("middle_name", value);
      return this;
    }
    public APIRequestGetMutualFriends requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetMutualFriends requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetMutualFriends requestNameFormatField () {
      return this.requestNameFormatField(true);
    }
    public APIRequestGetMutualFriends requestNameFormatField (boolean value) {
      this.requestField("name_format", value);
      return this;
    }
    public APIRequestGetMutualFriends requestPaymentPricepointsField () {
      return this.requestPaymentPricepointsField(true);
    }
    public APIRequestGetMutualFriends requestPaymentPricepointsField (boolean value) {
      this.requestField("payment_pricepoints", value);
      return this;
    }
    public APIRequestGetMutualFriends requestPoliticalField () {
      return this.requestPoliticalField(true);
    }
    public APIRequestGetMutualFriends requestPoliticalField (boolean value) {
      this.requestField("political", value);
      return this;
    }
    public APIRequestGetMutualFriends requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetMutualFriends requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetMutualFriends requestPublicKeyField () {
      return this.requestPublicKeyField(true);
    }
    public APIRequestGetMutualFriends requestPublicKeyField (boolean value) {
      this.requestField("public_key", value);
      return this;
    }
    public APIRequestGetMutualFriends requestQuotesField () {
      return this.requestQuotesField(true);
    }
    public APIRequestGetMutualFriends requestQuotesField (boolean value) {
      this.requestField("quotes", value);
      return this;
    }
    public APIRequestGetMutualFriends requestRelationshipStatusField () {
      return this.requestRelationshipStatusField(true);
    }
    public APIRequestGetMutualFriends requestRelationshipStatusField (boolean value) {
      this.requestField("relationship_status", value);
      return this;
    }
    public APIRequestGetMutualFriends requestReligionField () {
      return this.requestReligionField(true);
    }
    public APIRequestGetMutualFriends requestReligionField (boolean value) {
      this.requestField("religion", value);
      return this;
    }
    public APIRequestGetMutualFriends requestSecuritySettingsField () {
      return this.requestSecuritySettingsField(true);
    }
    public APIRequestGetMutualFriends requestSecuritySettingsField (boolean value) {
      this.requestField("security_settings", value);
      return this;
    }
    public APIRequestGetMutualFriends requestSharedLoginUpgradeRequiredByField () {
      return this.requestSharedLoginUpgradeRequiredByField(true);
    }
    public APIRequestGetMutualFriends requestSharedLoginUpgradeRequiredByField (boolean value) {
      this.requestField("shared_login_upgrade_required_by", value);
      return this;
    }
    public APIRequestGetMutualFriends requestShortNameField () {
      return this.requestShortNameField(true);
    }
    public APIRequestGetMutualFriends requestShortNameField (boolean value) {
      this.requestField("short_name", value);
      return this;
    }
    public APIRequestGetMutualFriends requestSignificantOtherField () {
      return this.requestSignificantOtherField(true);
    }
    public APIRequestGetMutualFriends requestSignificantOtherField (boolean value) {
      this.requestField("significant_other", value);
      return this;
    }
    public APIRequestGetMutualFriends requestSportsField () {
      return this.requestSportsField(true);
    }
    public APIRequestGetMutualFriends requestSportsField (boolean value) {
      this.requestField("sports", value);
      return this;
    }
    public APIRequestGetMutualFriends requestTestGroupField () {
      return this.requestTestGroupField(true);
    }
    public APIRequestGetMutualFriends requestTestGroupField (boolean value) {
      this.requestField("test_group", value);
      return this;
    }
    public APIRequestGetMutualFriends requestThirdPartyIdField () {
      return this.requestThirdPartyIdField(true);
    }
    public APIRequestGetMutualFriends requestThirdPartyIdField (boolean value) {
      this.requestField("third_party_id", value);
      return this;
    }
    public APIRequestGetMutualFriends requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetMutualFriends requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetMutualFriends requestTokenForBusinessField () {
      return this.requestTokenForBusinessField(true);
    }
    public APIRequestGetMutualFriends requestTokenForBusinessField (boolean value) {
      this.requestField("token_for_business", value);
      return this;
    }
    public APIRequestGetMutualFriends requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetMutualFriends requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetMutualFriends requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetMutualFriends requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetMutualFriends requestVerifiedField () {
      return this.requestVerifiedField(true);
    }
    public APIRequestGetMutualFriends requestVerifiedField (boolean value) {
      this.requestField("verified", value);
      return this;
    }
    public APIRequestGetMutualFriends requestVideoUploadLimitsField () {
      return this.requestVideoUploadLimitsField(true);
    }
    public APIRequestGetMutualFriends requestVideoUploadLimitsField (boolean value) {
      this.requestField("video_upload_limits", value);
      return this;
    }
    public APIRequestGetMutualFriends requestViewerCanSendGiftField () {
      return this.requestViewerCanSendGiftField(true);
    }
    public APIRequestGetMutualFriends requestViewerCanSendGiftField (boolean value) {
      this.requestField("viewer_can_send_gift", value);
      return this;
    }
    public APIRequestGetMutualFriends requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetMutualFriends requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetMutualFriends requestWorkField () {
      return this.requestWorkField(true);
    }
    public APIRequestGetMutualFriends requestWorkField (boolean value) {
      this.requestField("work", value);
      return this;
    }
  }

  public static class APIRequestGetMutualLikes extends APIRequest<Page> {

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
      "global_brand_parent_page",
      "global_brand_root_id",
      "has_added_app",
      "has_whatsapp_business_number",
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
               return APIRequestGetMutualLikes.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetMutualLikes(String nodeId, APIContext context) {
      super(context, nodeId, "/mutual_likes", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMutualLikes setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMutualLikes setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMutualLikes requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMutualLikes requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMutualLikes requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMutualLikes requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMutualLikes requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMutualLikes requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetMutualLikes requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetMutualLikes requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetMutualLikes requestAccessTokenField () {
      return this.requestAccessTokenField(true);
    }
    public APIRequestGetMutualLikes requestAccessTokenField (boolean value) {
      this.requestField("access_token", value);
      return this;
    }
    public APIRequestGetMutualLikes requestAdCampaignField () {
      return this.requestAdCampaignField(true);
    }
    public APIRequestGetMutualLikes requestAdCampaignField (boolean value) {
      this.requestField("ad_campaign", value);
      return this;
    }
    public APIRequestGetMutualLikes requestAffiliationField () {
      return this.requestAffiliationField(true);
    }
    public APIRequestGetMutualLikes requestAffiliationField (boolean value) {
      this.requestField("affiliation", value);
      return this;
    }
    public APIRequestGetMutualLikes requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetMutualLikes requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetMutualLikes requestAppLinksField () {
      return this.requestAppLinksField(true);
    }
    public APIRequestGetMutualLikes requestAppLinksField (boolean value) {
      this.requestField("app_links", value);
      return this;
    }
    public APIRequestGetMutualLikes requestArtistsWeLikeField () {
      return this.requestArtistsWeLikeField(true);
    }
    public APIRequestGetMutualLikes requestArtistsWeLikeField (boolean value) {
      this.requestField("artists_we_like", value);
      return this;
    }
    public APIRequestGetMutualLikes requestAttireField () {
      return this.requestAttireField(true);
    }
    public APIRequestGetMutualLikes requestAttireField (boolean value) {
      this.requestField("attire", value);
      return this;
    }
    public APIRequestGetMutualLikes requestAwardsField () {
      return this.requestAwardsField(true);
    }
    public APIRequestGetMutualLikes requestAwardsField (boolean value) {
      this.requestField("awards", value);
      return this;
    }
    public APIRequestGetMutualLikes requestBandInterestsField () {
      return this.requestBandInterestsField(true);
    }
    public APIRequestGetMutualLikes requestBandInterestsField (boolean value) {
      this.requestField("band_interests", value);
      return this;
    }
    public APIRequestGetMutualLikes requestBandMembersField () {
      return this.requestBandMembersField(true);
    }
    public APIRequestGetMutualLikes requestBandMembersField (boolean value) {
      this.requestField("band_members", value);
      return this;
    }
    public APIRequestGetMutualLikes requestBestPageField () {
      return this.requestBestPageField(true);
    }
    public APIRequestGetMutualLikes requestBestPageField (boolean value) {
      this.requestField("best_page", value);
      return this;
    }
    public APIRequestGetMutualLikes requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetMutualLikes requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetMutualLikes requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetMutualLikes requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetMutualLikes requestBookingAgentField () {
      return this.requestBookingAgentField(true);
    }
    public APIRequestGetMutualLikes requestBookingAgentField (boolean value) {
      this.requestField("booking_agent", value);
      return this;
    }
    public APIRequestGetMutualLikes requestBuiltField () {
      return this.requestBuiltField(true);
    }
    public APIRequestGetMutualLikes requestBuiltField (boolean value) {
      this.requestField("built", value);
      return this;
    }
    public APIRequestGetMutualLikes requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetMutualLikes requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetMutualLikes requestCanCheckinField () {
      return this.requestCanCheckinField(true);
    }
    public APIRequestGetMutualLikes requestCanCheckinField (boolean value) {
      this.requestField("can_checkin", value);
      return this;
    }
    public APIRequestGetMutualLikes requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetMutualLikes requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetMutualLikes requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetMutualLikes requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetMutualLikes requestCategoryListField () {
      return this.requestCategoryListField(true);
    }
    public APIRequestGetMutualLikes requestCategoryListField (boolean value) {
      this.requestField("category_list", value);
      return this;
    }
    public APIRequestGetMutualLikes requestCheckinsField () {
      return this.requestCheckinsField(true);
    }
    public APIRequestGetMutualLikes requestCheckinsField (boolean value) {
      this.requestField("checkins", value);
      return this;
    }
    public APIRequestGetMutualLikes requestCompanyOverviewField () {
      return this.requestCompanyOverviewField(true);
    }
    public APIRequestGetMutualLikes requestCompanyOverviewField (boolean value) {
      this.requestField("company_overview", value);
      return this;
    }
    public APIRequestGetMutualLikes requestConnectedInstagramAccountField () {
      return this.requestConnectedInstagramAccountField(true);
    }
    public APIRequestGetMutualLikes requestConnectedInstagramAccountField (boolean value) {
      this.requestField("connected_instagram_account", value);
      return this;
    }
    public APIRequestGetMutualLikes requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetMutualLikes requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetMutualLikes requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetMutualLikes requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetMutualLikes requestCopyrightAttributionInsightsField () {
      return this.requestCopyrightAttributionInsightsField(true);
    }
    public APIRequestGetMutualLikes requestCopyrightAttributionInsightsField (boolean value) {
      this.requestField("copyright_attribution_insights", value);
      return this;
    }
    public APIRequestGetMutualLikes requestCopyrightWhitelistedIgPartnersField () {
      return this.requestCopyrightWhitelistedIgPartnersField(true);
    }
    public APIRequestGetMutualLikes requestCopyrightWhitelistedIgPartnersField (boolean value) {
      this.requestField("copyright_whitelisted_ig_partners", value);
      return this;
    }
    public APIRequestGetMutualLikes requestCountryPageLikesField () {
      return this.requestCountryPageLikesField(true);
    }
    public APIRequestGetMutualLikes requestCountryPageLikesField (boolean value) {
      this.requestField("country_page_likes", value);
      return this;
    }
    public APIRequestGetMutualLikes requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetMutualLikes requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetMutualLikes requestCulinaryTeamField () {
      return this.requestCulinaryTeamField(true);
    }
    public APIRequestGetMutualLikes requestCulinaryTeamField (boolean value) {
      this.requestField("culinary_team", value);
      return this;
    }
    public APIRequestGetMutualLikes requestCurrentLocationField () {
      return this.requestCurrentLocationField(true);
    }
    public APIRequestGetMutualLikes requestCurrentLocationField (boolean value) {
      this.requestField("current_location", value);
      return this;
    }
    public APIRequestGetMutualLikes requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetMutualLikes requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetMutualLikes requestDescriptionHtmlField () {
      return this.requestDescriptionHtmlField(true);
    }
    public APIRequestGetMutualLikes requestDescriptionHtmlField (boolean value) {
      this.requestField("description_html", value);
      return this;
    }
    public APIRequestGetMutualLikes requestDirectedByField () {
      return this.requestDirectedByField(true);
    }
    public APIRequestGetMutualLikes requestDirectedByField (boolean value) {
      this.requestField("directed_by", value);
      return this;
    }
    public APIRequestGetMutualLikes requestDisplaySubtextField () {
      return this.requestDisplaySubtextField(true);
    }
    public APIRequestGetMutualLikes requestDisplaySubtextField (boolean value) {
      this.requestField("display_subtext", value);
      return this;
    }
    public APIRequestGetMutualLikes requestDisplayedMessageResponseTimeField () {
      return this.requestDisplayedMessageResponseTimeField(true);
    }
    public APIRequestGetMutualLikes requestDisplayedMessageResponseTimeField (boolean value) {
      this.requestField("displayed_message_response_time", value);
      return this;
    }
    public APIRequestGetMutualLikes requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetMutualLikes requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetMutualLikes requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGetMutualLikes requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGetMutualLikes requestFanCountField () {
      return this.requestFanCountField(true);
    }
    public APIRequestGetMutualLikes requestFanCountField (boolean value) {
      this.requestField("fan_count", value);
      return this;
    }
    public APIRequestGetMutualLikes requestFeaturedVideoField () {
      return this.requestFeaturedVideoField(true);
    }
    public APIRequestGetMutualLikes requestFeaturedVideoField (boolean value) {
      this.requestField("featured_video", value);
      return this;
    }
    public APIRequestGetMutualLikes requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetMutualLikes requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetMutualLikes requestFoodStylesField () {
      return this.requestFoodStylesField(true);
    }
    public APIRequestGetMutualLikes requestFoodStylesField (boolean value) {
      this.requestField("food_styles", value);
      return this;
    }
    public APIRequestGetMutualLikes requestFoundedField () {
      return this.requestFoundedField(true);
    }
    public APIRequestGetMutualLikes requestFoundedField (boolean value) {
      this.requestField("founded", value);
      return this;
    }
    public APIRequestGetMutualLikes requestGeneralInfoField () {
      return this.requestGeneralInfoField(true);
    }
    public APIRequestGetMutualLikes requestGeneralInfoField (boolean value) {
      this.requestField("general_info", value);
      return this;
    }
    public APIRequestGetMutualLikes requestGeneralManagerField () {
      return this.requestGeneralManagerField(true);
    }
    public APIRequestGetMutualLikes requestGeneralManagerField (boolean value) {
      this.requestField("general_manager", value);
      return this;
    }
    public APIRequestGetMutualLikes requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGetMutualLikes requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGetMutualLikes requestGlobalBrandPageNameField () {
      return this.requestGlobalBrandPageNameField(true);
    }
    public APIRequestGetMutualLikes requestGlobalBrandPageNameField (boolean value) {
      this.requestField("global_brand_page_name", value);
      return this;
    }
    public APIRequestGetMutualLikes requestGlobalBrandParentPageField () {
      return this.requestGlobalBrandParentPageField(true);
    }
    public APIRequestGetMutualLikes requestGlobalBrandParentPageField (boolean value) {
      this.requestField("global_brand_parent_page", value);
      return this;
    }
    public APIRequestGetMutualLikes requestGlobalBrandRootIdField () {
      return this.requestGlobalBrandRootIdField(true);
    }
    public APIRequestGetMutualLikes requestGlobalBrandRootIdField (boolean value) {
      this.requestField("global_brand_root_id", value);
      return this;
    }
    public APIRequestGetMutualLikes requestHasAddedAppField () {
      return this.requestHasAddedAppField(true);
    }
    public APIRequestGetMutualLikes requestHasAddedAppField (boolean value) {
      this.requestField("has_added_app", value);
      return this;
    }
    public APIRequestGetMutualLikes requestHasWhatsappBusinessNumberField () {
      return this.requestHasWhatsappBusinessNumberField(true);
    }
    public APIRequestGetMutualLikes requestHasWhatsappBusinessNumberField (boolean value) {
      this.requestField("has_whatsapp_business_number", value);
      return this;
    }
    public APIRequestGetMutualLikes requestHasWhatsappNumberField () {
      return this.requestHasWhatsappNumberField(true);
    }
    public APIRequestGetMutualLikes requestHasWhatsappNumberField (boolean value) {
      this.requestField("has_whatsapp_number", value);
      return this;
    }
    public APIRequestGetMutualLikes requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetMutualLikes requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetMutualLikes requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGetMutualLikes requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGetMutualLikes requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetMutualLikes requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetMutualLikes requestImpressumField () {
      return this.requestImpressumField(true);
    }
    public APIRequestGetMutualLikes requestImpressumField (boolean value) {
      this.requestField("impressum", value);
      return this;
    }
    public APIRequestGetMutualLikes requestInfluencesField () {
      return this.requestInfluencesField(true);
    }
    public APIRequestGetMutualLikes requestInfluencesField (boolean value) {
      this.requestField("influences", value);
      return this;
    }
    public APIRequestGetMutualLikes requestInstagramBusinessAccountField () {
      return this.requestInstagramBusinessAccountField(true);
    }
    public APIRequestGetMutualLikes requestInstagramBusinessAccountField (boolean value) {
      this.requestField("instagram_business_account", value);
      return this;
    }
    public APIRequestGetMutualLikes requestInstantArticlesReviewStatusField () {
      return this.requestInstantArticlesReviewStatusField(true);
    }
    public APIRequestGetMutualLikes requestInstantArticlesReviewStatusField (boolean value) {
      this.requestField("instant_articles_review_status", value);
      return this;
    }
    public APIRequestGetMutualLikes requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetMutualLikes requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
      return this;
    }
    public APIRequestGetMutualLikes requestIsChainField () {
      return this.requestIsChainField(true);
    }
    public APIRequestGetMutualLikes requestIsChainField (boolean value) {
      this.requestField("is_chain", value);
      return this;
    }
    public APIRequestGetMutualLikes requestIsCommunityPageField () {
      return this.requestIsCommunityPageField(true);
    }
    public APIRequestGetMutualLikes requestIsCommunityPageField (boolean value) {
      this.requestField("is_community_page", value);
      return this;
    }
    public APIRequestGetMutualLikes requestIsEligibleForBrandedContentField () {
      return this.requestIsEligibleForBrandedContentField(true);
    }
    public APIRequestGetMutualLikes requestIsEligibleForBrandedContentField (boolean value) {
      this.requestField("is_eligible_for_branded_content", value);
      return this;
    }
    public APIRequestGetMutualLikes requestIsMessengerBotGetStartedEnabledField () {
      return this.requestIsMessengerBotGetStartedEnabledField(true);
    }
    public APIRequestGetMutualLikes requestIsMessengerBotGetStartedEnabledField (boolean value) {
      this.requestField("is_messenger_bot_get_started_enabled", value);
      return this;
    }
    public APIRequestGetMutualLikes requestIsMessengerPlatformBotField () {
      return this.requestIsMessengerPlatformBotField(true);
    }
    public APIRequestGetMutualLikes requestIsMessengerPlatformBotField (boolean value) {
      this.requestField("is_messenger_platform_bot", value);
      return this;
    }
    public APIRequestGetMutualLikes requestIsOwnedField () {
      return this.requestIsOwnedField(true);
    }
    public APIRequestGetMutualLikes requestIsOwnedField (boolean value) {
      this.requestField("is_owned", value);
      return this;
    }
    public APIRequestGetMutualLikes requestIsPermanentlyClosedField () {
      return this.requestIsPermanentlyClosedField(true);
    }
    public APIRequestGetMutualLikes requestIsPermanentlyClosedField (boolean value) {
      this.requestField("is_permanently_closed", value);
      return this;
    }
    public APIRequestGetMutualLikes requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetMutualLikes requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetMutualLikes requestIsUnclaimedField () {
      return this.requestIsUnclaimedField(true);
    }
    public APIRequestGetMutualLikes requestIsUnclaimedField (boolean value) {
      this.requestField("is_unclaimed", value);
      return this;
    }
    public APIRequestGetMutualLikes requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetMutualLikes requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetMutualLikes requestIsWebhooksSubscribedField () {
      return this.requestIsWebhooksSubscribedField(true);
    }
    public APIRequestGetMutualLikes requestIsWebhooksSubscribedField (boolean value) {
      this.requestField("is_webhooks_subscribed", value);
      return this;
    }
    public APIRequestGetMutualLikes requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGetMutualLikes requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGetMutualLikes requestLeadgenFormPreviewDetailsField () {
      return this.requestLeadgenFormPreviewDetailsField(true);
    }
    public APIRequestGetMutualLikes requestLeadgenFormPreviewDetailsField (boolean value) {
      this.requestField("leadgen_form_preview_details", value);
      return this;
    }
    public APIRequestGetMutualLikes requestLeadgenHasCrmIntegrationField () {
      return this.requestLeadgenHasCrmIntegrationField(true);
    }
    public APIRequestGetMutualLikes requestLeadgenHasCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_crm_integration", value);
      return this;
    }
    public APIRequestGetMutualLikes requestLeadgenHasFatPingCrmIntegrationField () {
      return this.requestLeadgenHasFatPingCrmIntegrationField(true);
    }
    public APIRequestGetMutualLikes requestLeadgenHasFatPingCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_fat_ping_crm_integration", value);
      return this;
    }
    public APIRequestGetMutualLikes requestLeadgenTosAcceptanceTimeField () {
      return this.requestLeadgenTosAcceptanceTimeField(true);
    }
    public APIRequestGetMutualLikes requestLeadgenTosAcceptanceTimeField (boolean value) {
      this.requestField("leadgen_tos_acceptance_time", value);
      return this;
    }
    public APIRequestGetMutualLikes requestLeadgenTosAcceptedField () {
      return this.requestLeadgenTosAcceptedField(true);
    }
    public APIRequestGetMutualLikes requestLeadgenTosAcceptedField (boolean value) {
      this.requestField("leadgen_tos_accepted", value);
      return this;
    }
    public APIRequestGetMutualLikes requestLeadgenTosAcceptingUserField () {
      return this.requestLeadgenTosAcceptingUserField(true);
    }
    public APIRequestGetMutualLikes requestLeadgenTosAcceptingUserField (boolean value) {
      this.requestField("leadgen_tos_accepting_user", value);
      return this;
    }
    public APIRequestGetMutualLikes requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetMutualLikes requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetMutualLikes requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetMutualLikes requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetMutualLikes requestMembersField () {
      return this.requestMembersField(true);
    }
    public APIRequestGetMutualLikes requestMembersField (boolean value) {
      this.requestField("members", value);
      return this;
    }
    public APIRequestGetMutualLikes requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetMutualLikes requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetMutualLikes requestMerchantReviewStatusField () {
      return this.requestMerchantReviewStatusField(true);
    }
    public APIRequestGetMutualLikes requestMerchantReviewStatusField (boolean value) {
      this.requestField("merchant_review_status", value);
      return this;
    }
    public APIRequestGetMutualLikes requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetMutualLikes requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetMutualLikes requestMessengerAdsDefaultPageWelcomeMessageField () {
      return this.requestMessengerAdsDefaultPageWelcomeMessageField(true);
    }
    public APIRequestGetMutualLikes requestMessengerAdsDefaultPageWelcomeMessageField (boolean value) {
      this.requestField("messenger_ads_default_page_welcome_message", value);
      return this;
    }
    public APIRequestGetMutualLikes requestMessengerAdsDefaultQuickRepliesField () {
      return this.requestMessengerAdsDefaultQuickRepliesField(true);
    }
    public APIRequestGetMutualLikes requestMessengerAdsDefaultQuickRepliesField (boolean value) {
      this.requestField("messenger_ads_default_quick_replies", value);
      return this;
    }
    public APIRequestGetMutualLikes requestMessengerAdsQuickRepliesTypeField () {
      return this.requestMessengerAdsQuickRepliesTypeField(true);
    }
    public APIRequestGetMutualLikes requestMessengerAdsQuickRepliesTypeField (boolean value) {
      this.requestField("messenger_ads_quick_replies_type", value);
      return this;
    }
    public APIRequestGetMutualLikes requestMissionField () {
      return this.requestMissionField(true);
    }
    public APIRequestGetMutualLikes requestMissionField (boolean value) {
      this.requestField("mission", value);
      return this;
    }
    public APIRequestGetMutualLikes requestMpgField () {
      return this.requestMpgField(true);
    }
    public APIRequestGetMutualLikes requestMpgField (boolean value) {
      this.requestField("mpg", value);
      return this;
    }
    public APIRequestGetMutualLikes requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetMutualLikes requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetMutualLikes requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGetMutualLikes requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGetMutualLikes requestNetworkField () {
      return this.requestNetworkField(true);
    }
    public APIRequestGetMutualLikes requestNetworkField (boolean value) {
      this.requestField("network", value);
      return this;
    }
    public APIRequestGetMutualLikes requestNewLikeCountField () {
      return this.requestNewLikeCountField(true);
    }
    public APIRequestGetMutualLikes requestNewLikeCountField (boolean value) {
      this.requestField("new_like_count", value);
      return this;
    }
    public APIRequestGetMutualLikes requestOfferEligibleField () {
      return this.requestOfferEligibleField(true);
    }
    public APIRequestGetMutualLikes requestOfferEligibleField (boolean value) {
      this.requestField("offer_eligible", value);
      return this;
    }
    public APIRequestGetMutualLikes requestOverallStarRatingField () {
      return this.requestOverallStarRatingField(true);
    }
    public APIRequestGetMutualLikes requestOverallStarRatingField (boolean value) {
      this.requestField("overall_star_rating", value);
      return this;
    }
    public APIRequestGetMutualLikes requestPageTokenField () {
      return this.requestPageTokenField(true);
    }
    public APIRequestGetMutualLikes requestPageTokenField (boolean value) {
      this.requestField("page_token", value);
      return this;
    }
    public APIRequestGetMutualLikes requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetMutualLikes requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGetMutualLikes requestParkingField () {
      return this.requestParkingField(true);
    }
    public APIRequestGetMutualLikes requestParkingField (boolean value) {
      this.requestField("parking", value);
      return this;
    }
    public APIRequestGetMutualLikes requestPaymentOptionsField () {
      return this.requestPaymentOptionsField(true);
    }
    public APIRequestGetMutualLikes requestPaymentOptionsField (boolean value) {
      this.requestField("payment_options", value);
      return this;
    }
    public APIRequestGetMutualLikes requestPersonalInfoField () {
      return this.requestPersonalInfoField(true);
    }
    public APIRequestGetMutualLikes requestPersonalInfoField (boolean value) {
      this.requestField("personal_info", value);
      return this;
    }
    public APIRequestGetMutualLikes requestPersonalInterestsField () {
      return this.requestPersonalInterestsField(true);
    }
    public APIRequestGetMutualLikes requestPersonalInterestsField (boolean value) {
      this.requestField("personal_interests", value);
      return this;
    }
    public APIRequestGetMutualLikes requestPharmaSafetyInfoField () {
      return this.requestPharmaSafetyInfoField(true);
    }
    public APIRequestGetMutualLikes requestPharmaSafetyInfoField (boolean value) {
      this.requestField("pharma_safety_info", value);
      return this;
    }
    public APIRequestGetMutualLikes requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetMutualLikes requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetMutualLikes requestPlaceTypeField () {
      return this.requestPlaceTypeField(true);
    }
    public APIRequestGetMutualLikes requestPlaceTypeField (boolean value) {
      this.requestField("place_type", value);
      return this;
    }
    public APIRequestGetMutualLikes requestPlotOutlineField () {
      return this.requestPlotOutlineField(true);
    }
    public APIRequestGetMutualLikes requestPlotOutlineField (boolean value) {
      this.requestField("plot_outline", value);
      return this;
    }
    public APIRequestGetMutualLikes requestPreferredAudienceField () {
      return this.requestPreferredAudienceField(true);
    }
    public APIRequestGetMutualLikes requestPreferredAudienceField (boolean value) {
      this.requestField("preferred_audience", value);
      return this;
    }
    public APIRequestGetMutualLikes requestPressContactField () {
      return this.requestPressContactField(true);
    }
    public APIRequestGetMutualLikes requestPressContactField (boolean value) {
      this.requestField("press_contact", value);
      return this;
    }
    public APIRequestGetMutualLikes requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGetMutualLikes requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGetMutualLikes requestProducedByField () {
      return this.requestProducedByField(true);
    }
    public APIRequestGetMutualLikes requestProducedByField (boolean value) {
      this.requestField("produced_by", value);
      return this;
    }
    public APIRequestGetMutualLikes requestProductsField () {
      return this.requestProductsField(true);
    }
    public APIRequestGetMutualLikes requestProductsField (boolean value) {
      this.requestField("products", value);
      return this;
    }
    public APIRequestGetMutualLikes requestPromotionEligibleField () {
      return this.requestPromotionEligibleField(true);
    }
    public APIRequestGetMutualLikes requestPromotionEligibleField (boolean value) {
      this.requestField("promotion_eligible", value);
      return this;
    }
    public APIRequestGetMutualLikes requestPromotionIneligibleReasonField () {
      return this.requestPromotionIneligibleReasonField(true);
    }
    public APIRequestGetMutualLikes requestPromotionIneligibleReasonField (boolean value) {
      this.requestField("promotion_ineligible_reason", value);
      return this;
    }
    public APIRequestGetMutualLikes requestPublicTransitField () {
      return this.requestPublicTransitField(true);
    }
    public APIRequestGetMutualLikes requestPublicTransitField (boolean value) {
      this.requestField("public_transit", value);
      return this;
    }
    public APIRequestGetMutualLikes requestPublisherSpaceField () {
      return this.requestPublisherSpaceField(true);
    }
    public APIRequestGetMutualLikes requestPublisherSpaceField (boolean value) {
      this.requestField("publisher_space", value);
      return this;
    }
    public APIRequestGetMutualLikes requestRatingCountField () {
      return this.requestRatingCountField(true);
    }
    public APIRequestGetMutualLikes requestRatingCountField (boolean value) {
      this.requestField("rating_count", value);
      return this;
    }
    public APIRequestGetMutualLikes requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetMutualLikes requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetMutualLikes requestRecordLabelField () {
      return this.requestRecordLabelField(true);
    }
    public APIRequestGetMutualLikes requestRecordLabelField (boolean value) {
      this.requestField("record_label", value);
      return this;
    }
    public APIRequestGetMutualLikes requestReleaseDateField () {
      return this.requestReleaseDateField(true);
    }
    public APIRequestGetMutualLikes requestReleaseDateField (boolean value) {
      this.requestField("release_date", value);
      return this;
    }
    public APIRequestGetMutualLikes requestRestaurantServicesField () {
      return this.requestRestaurantServicesField(true);
    }
    public APIRequestGetMutualLikes requestRestaurantServicesField (boolean value) {
      this.requestField("restaurant_services", value);
      return this;
    }
    public APIRequestGetMutualLikes requestRestaurantSpecialtiesField () {
      return this.requestRestaurantSpecialtiesField(true);
    }
    public APIRequestGetMutualLikes requestRestaurantSpecialtiesField (boolean value) {
      this.requestField("restaurant_specialties", value);
      return this;
    }
    public APIRequestGetMutualLikes requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetMutualLikes requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGetMutualLikes requestScreenplayByField () {
      return this.requestScreenplayByField(true);
    }
    public APIRequestGetMutualLikes requestScreenplayByField (boolean value) {
      this.requestField("screenplay_by", value);
      return this;
    }
    public APIRequestGetMutualLikes requestSeasonField () {
      return this.requestSeasonField(true);
    }
    public APIRequestGetMutualLikes requestSeasonField (boolean value) {
      this.requestField("season", value);
      return this;
    }
    public APIRequestGetMutualLikes requestSingleLineAddressField () {
      return this.requestSingleLineAddressField(true);
    }
    public APIRequestGetMutualLikes requestSingleLineAddressField (boolean value) {
      this.requestField("single_line_address", value);
      return this;
    }
    public APIRequestGetMutualLikes requestStarringField () {
      return this.requestStarringField(true);
    }
    public APIRequestGetMutualLikes requestStarringField (boolean value) {
      this.requestField("starring", value);
      return this;
    }
    public APIRequestGetMutualLikes requestStartInfoField () {
      return this.requestStartInfoField(true);
    }
    public APIRequestGetMutualLikes requestStartInfoField (boolean value) {
      this.requestField("start_info", value);
      return this;
    }
    public APIRequestGetMutualLikes requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGetMutualLikes requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGetMutualLikes requestStoreLocationDescriptorField () {
      return this.requestStoreLocationDescriptorField(true);
    }
    public APIRequestGetMutualLikes requestStoreLocationDescriptorField (boolean value) {
      this.requestField("store_location_descriptor", value);
      return this;
    }
    public APIRequestGetMutualLikes requestStoreNumberField () {
      return this.requestStoreNumberField(true);
    }
    public APIRequestGetMutualLikes requestStoreNumberField (boolean value) {
      this.requestField("store_number", value);
      return this;
    }
    public APIRequestGetMutualLikes requestStudioField () {
      return this.requestStudioField(true);
    }
    public APIRequestGetMutualLikes requestStudioField (boolean value) {
      this.requestField("studio", value);
      return this;
    }
    public APIRequestGetMutualLikes requestSupportsInstantArticlesField () {
      return this.requestSupportsInstantArticlesField(true);
    }
    public APIRequestGetMutualLikes requestSupportsInstantArticlesField (boolean value) {
      this.requestField("supports_instant_articles", value);
      return this;
    }
    public APIRequestGetMutualLikes requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetMutualLikes requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
      return this;
    }
    public APIRequestGetMutualLikes requestUnreadMessageCountField () {
      return this.requestUnreadMessageCountField(true);
    }
    public APIRequestGetMutualLikes requestUnreadMessageCountField (boolean value) {
      this.requestField("unread_message_count", value);
      return this;
    }
    public APIRequestGetMutualLikes requestUnreadNotifCountField () {
      return this.requestUnreadNotifCountField(true);
    }
    public APIRequestGetMutualLikes requestUnreadNotifCountField (boolean value) {
      this.requestField("unread_notif_count", value);
      return this;
    }
    public APIRequestGetMutualLikes requestUnseenMessageCountField () {
      return this.requestUnseenMessageCountField(true);
    }
    public APIRequestGetMutualLikes requestUnseenMessageCountField (boolean value) {
      this.requestField("unseen_message_count", value);
      return this;
    }
    public APIRequestGetMutualLikes requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetMutualLikes requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetMutualLikes requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetMutualLikes requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetMutualLikes requestVoipInfoField () {
      return this.requestVoipInfoField(true);
    }
    public APIRequestGetMutualLikes requestVoipInfoField (boolean value) {
      this.requestField("voip_info", value);
      return this;
    }
    public APIRequestGetMutualLikes requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetMutualLikes requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetMutualLikes requestWereHereCountField () {
      return this.requestWereHereCountField(true);
    }
    public APIRequestGetMutualLikes requestWereHereCountField (boolean value) {
      this.requestField("were_here_count", value);
      return this;
    }
    public APIRequestGetMutualLikes requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGetMutualLikes requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
      return this;
    }
    public APIRequestGetMutualLikes requestWrittenByField () {
      return this.requestWrittenByField(true);
    }
    public APIRequestGetMutualLikes requestWrittenByField (boolean value) {
      this.requestField("written_by", value);
      return this;
    }
  }

  public static class APIRequestGetThreeDegreeMutualFriends extends APIRequest<APINode> {

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
               return APIRequestGetThreeDegreeMutualFriends.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetThreeDegreeMutualFriends(String nodeId, APIContext context) {
      super(context, nodeId, "/three_degree_mutual_friends", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetThreeDegreeMutualFriends setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetThreeDegreeMutualFriends setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetThreeDegreeMutualFriends requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetThreeDegreeMutualFriends requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetThreeDegreeMutualFriends requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetThreeDegreeMutualFriends requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetThreeDegreeMutualFriends requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetThreeDegreeMutualFriends requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<UserContext> {

    UserContext lastResponse = null;
    @Override
    public UserContext getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
    };

    @Override
    public UserContext parseResponse(String response) throws APIException {
      return UserContext.parseResponse(response, getContext(), this).head();
    }

    @Override
    public UserContext execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public UserContext execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<UserContext> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<UserContext> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, UserContext>() {
           public UserContext apply(String result) {
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

  public UserContext copyFrom(UserContext instance) {
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<UserContext> getParser() {
    return new APIRequest.ResponseParser<UserContext>() {
      public APINodeList<UserContext> parseResponse(String response, APIContext context, APIRequest<UserContext> request) throws MalformedResponseException {
        return UserContext.parseResponse(response, context, request);
      }
    };
  }
}
