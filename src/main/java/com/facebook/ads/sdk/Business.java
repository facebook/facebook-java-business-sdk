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
public class Business extends APINode {
  @SerializedName("block_offline_analytics")
  private Boolean mBlockOfflineAnalytics = null;
  @SerializedName("created_by")
  private Object mCreatedBy = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("payment_account_id")
  private String mPaymentAccountId = null;
  @SerializedName("primary_page")
  private Page mPrimaryPage = null;
  @SerializedName("profile_picture_uri")
  private String mProfilePictureUri = null;
  @SerializedName("timezone_id")
  private Long mTimezoneId = null;
  @SerializedName("two_factor_type")
  private String mTwoFactorType = null;
  @SerializedName("updated_by")
  private Object mUpdatedBy = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("vertical")
  private String mVertical = null;
  protected static Gson gson = null;

  Business() {
  }

  public Business(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Business(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public Business fetch() throws APIException{
    Business newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Business fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Business> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Business fetchById(String id, APIContext context) throws APIException {
    Business business =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return business;
  }

  public static ListenableFuture<Business> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<Business> business =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return business;
  }

  public static APINodeList<Business> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Business>)(
      new APIRequest<Business>(context, "", "/", "GET", Business.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Business>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<Business>> business =
      new APIRequest(context, "", "/", "GET", Business.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return business;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static Business loadJSON(String json, APIContext context) {
    Business business = getGson().fromJson(json, Business.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(business.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    business.context = context;
    business.rawValue = json;
    return business;
  }

  public static APINodeList<Business> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<Business> businesss = new APINodeList<Business>(request, json);
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
          businesss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return businesss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                businesss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            businesss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              businesss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businesss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  businesss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              businesss.add(loadJSON(obj.toString(), context));
            }
          }
          return businesss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businesss.add(loadJSON(entry.getValue().toString(), context));
          }
          return businesss;
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
              businesss.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return businesss;
          }

          // Sixth, check if it's pure JsonObject
          businesss.clear();
          businesss.add(loadJSON(json, context));
          return businesss;
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

  public APIRequestCreateAccessToken createAccessToken() {
    return new APIRequestCreateAccessToken(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdStudy createAdStudy() {
    return new APIRequestCreateAdStudy(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdAccount createAdAccount() {
    return new APIRequestCreateAdAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdAccountCreationRequests getAdAccountCreationRequests() {
    return new APIRequestGetAdAccountCreationRequests(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdAccountCreationRequest createAdAccountCreationRequest() {
    return new APIRequestCreateAdAccountCreationRequest(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteAdAccounts deleteAdAccounts() {
    return new APIRequestDeleteAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdNetworkAnalytics getAdNetworkAnalytics() {
    return new APIRequestGetAdNetworkAnalytics(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdNetworkAnalytic createAdNetworkAnalytic() {
    return new APIRequestCreateAdNetworkAnalytic(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdNetworkAnalyticsResults getAdNetworkAnalyticsResults() {
    return new APIRequestGetAdNetworkAnalyticsResults(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdsPixels getAdsPixels() {
    return new APIRequestGetAdsPixels(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdsPixel createAdsPixel() {
    return new APIRequestCreateAdsPixel(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdvertisableApplications getAdvertisableApplications() {
    return new APIRequestGetAdvertisableApplications(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteAgencies deleteAgencies() {
    return new APIRequestDeleteAgencies(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAgencyPages getAgencyPages() {
    return new APIRequestGetAgencyPages(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteApps deleteApps() {
    return new APIRequestDeleteApps(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateApp createApp() {
    return new APIRequestCreateApp(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBusinessActivities getBusinessActivities() {
    return new APIRequestGetBusinessActivities(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBusinessInvoices getBusinessInvoices() {
    return new APIRequestGetBusinessInvoices(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBusinessUsers getBusinessUsers() {
    return new APIRequestGetBusinessUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateBusinessUser createBusinessUser() {
    return new APIRequestCreateBusinessUser(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBusinessProjects getBusinessProjects() {
    return new APIRequestGetBusinessProjects(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetClientAdAccounts getClientAdAccounts() {
    return new APIRequestGetClientAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateClientAdAccount createClientAdAccount() {
    return new APIRequestCreateClientAdAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetClientApps getClientApps() {
    return new APIRequestGetClientApps(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateClientApp createClientApp() {
    return new APIRequestCreateClientApp(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetClientPages getClientPages() {
    return new APIRequestGetClientPages(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetClientPixels getClientPixels() {
    return new APIRequestGetClientPixels(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetClientProductCatalogs getClientProductCatalogs() {
    return new APIRequestGetClientProductCatalogs(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteClients deleteClients() {
    return new APIRequestDeleteClients(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDirectDeals getDirectDeals() {
    return new APIRequestGetDirectDeals(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetEventSourceGroups getEventSourceGroups() {
    return new APIRequestGetEventSourceGroups(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateEventSourceGroup createEventSourceGroup() {
    return new APIRequestCreateEventSourceGroup(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetExtendedCredits getExtendedCredits() {
    return new APIRequestGetExtendedCredits(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetGrpPlans getGrpPlans() {
    return new APIRequestGetGrpPlans(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInstagramAccounts getInstagramAccounts() {
    return new APIRequestGetInstagramAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMatchedSearchApplications getMatchedSearchApplications() {
    return new APIRequestGetMatchedSearchApplications(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMeasurementReports getMeasurementReports() {
    return new APIRequestGetMeasurementReports(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMeasurementReport createMeasurementReport() {
    return new APIRequestCreateMeasurementReport(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOfflineConversionDataSets getOfflineConversionDataSets() {
    return new APIRequestGetOfflineConversionDataSets(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOfflineConversionDataSet createOfflineConversionDataSet() {
    return new APIRequestCreateOfflineConversionDataSet(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwnedAdAccounts getOwnedAdAccounts() {
    return new APIRequestGetOwnedAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOwnedAdAccount createOwnedAdAccount() {
    return new APIRequestCreateOwnedAdAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwnedApps getOwnedApps() {
    return new APIRequestGetOwnedApps(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOwnedApp createOwnedApp() {
    return new APIRequestCreateOwnedApp(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteOwnedBusinesses deleteOwnedBusinesses() {
    return new APIRequestDeleteOwnedBusinesses(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwnedBusinesses getOwnedBusinesses() {
    return new APIRequestGetOwnedBusinesses(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOwnedBusiness createOwnedBusiness() {
    return new APIRequestCreateOwnedBusiness(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOwnedDomain createOwnedDomain() {
    return new APIRequestCreateOwnedDomain(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwnedInstagramAccounts getOwnedInstagramAccounts() {
    return new APIRequestGetOwnedInstagramAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwnedPages getOwnedPages() {
    return new APIRequestGetOwnedPages(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOwnedPage createOwnedPage() {
    return new APIRequestCreateOwnedPage(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwnedPixels getOwnedPixels() {
    return new APIRequestGetOwnedPixels(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetOwnedProductCatalogs getOwnedProductCatalogs() {
    return new APIRequestGetOwnedProductCatalogs(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateOwnedProductCatalog createOwnedProductCatalog() {
    return new APIRequestCreateOwnedProductCatalog(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeletePages deletePages() {
    return new APIRequestDeletePages(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPartners getPartners() {
    return new APIRequestGetPartners(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingClientAdAccounts getPendingClientAdAccounts() {
    return new APIRequestGetPendingClientAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingClientApps getPendingClientApps() {
    return new APIRequestGetPendingClientApps(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingClientPages getPendingClientPages() {
    return new APIRequestGetPendingClientPages(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingOwnedAdAccounts getPendingOwnedAdAccounts() {
    return new APIRequestGetPendingOwnedAdAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingOwnedPages getPendingOwnedPages() {
    return new APIRequestGetPendingOwnedPages(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingUsers getPendingUsers() {
    return new APIRequestGetPendingUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPicture getPicture() {
    return new APIRequestGetPicture(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetReceivedAudiencePermissions getReceivedAudiencePermissions() {
    return new APIRequestGetReceivedAudiencePermissions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSharedAudiencePermissions getSharedAudiencePermissions() {
    return new APIRequestGetSharedAudiencePermissions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSystemUsers getSystemUsers() {
    return new APIRequestGetSystemUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSystemUser createSystemUser() {
    return new APIRequestCreateSystemUser(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteUserInvitations deleteUserInvitations() {
    return new APIRequestDeleteUserInvitations(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetUserInvitations getUserInvitations() {
    return new APIRequestGetUserInvitations(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteUserPermissions deleteUserPermissions() {
    return new APIRequestDeleteUserPermissions(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateUserPermission createUserPermission() {
    return new APIRequestCreateUserPermission(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Boolean getFieldBlockOfflineAnalytics() {
    return mBlockOfflineAnalytics;
  }

  public Object getFieldCreatedBy() {
    return mCreatedBy;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldLink() {
    return mLink;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldPaymentAccountId() {
    return mPaymentAccountId;
  }

  public Page getFieldPrimaryPage() {
    if (mPrimaryPage != null) {
      mPrimaryPage.context = getContext();
    }
    return mPrimaryPage;
  }

  public String getFieldProfilePictureUri() {
    return mProfilePictureUri;
  }

  public Long getFieldTimezoneId() {
    return mTimezoneId;
  }

  public String getFieldTwoFactorType() {
    return mTwoFactorType;
  }

  public Object getFieldUpdatedBy() {
    return mUpdatedBy;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public String getFieldVertical() {
    return mVertical;
  }



  public static class APIRequestCreateAccessToken extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_id",
      "scope",
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
               return APIRequestCreateAccessToken.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAccessToken(String nodeId, APIContext context) {
      super(context, nodeId, "/access_token", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAccessToken setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAccessToken setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAccessToken setAppId (Object appId) {
      this.setParam("app_id", appId);
      return this;
    }
    public APIRequestCreateAccessToken setAppId (String appId) {
      this.setParam("app_id", appId);
      return this;
    }

    public APIRequestCreateAccessToken setScope (Object scope) {
      this.setParam("scope", scope);
      return this;
    }
    public APIRequestCreateAccessToken setScope (String scope) {
      this.setParam("scope", scope);
      return this;
    }

    public APIRequestCreateAccessToken requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAccessToken requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAccessToken requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAccessToken requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAccessToken requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAccessToken requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAdStudy extends APIRequest<AdStudy> {

    AdStudy lastResponse = null;
    @Override
    public AdStudy getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "cells",
      "client_business",
      "confidence_level",
      "cooldown_start_time",
      "description",
      "end_time",
      "name",
      "objectives",
      "observation_end_time",
      "start_time",
      "type",
      "viewers",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdStudy parseResponse(String response) throws APIException {
      return AdStudy.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdStudy execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudy execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdStudy> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdStudy> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdStudy>() {
           public AdStudy apply(String result) {
             try {
               return APIRequestCreateAdStudy.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAdStudy(String nodeId, APIContext context) {
      super(context, nodeId, "/ad_studies", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdStudy setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdStudy setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdStudy setCells (List<Object> cells) {
      this.setParam("cells", cells);
      return this;
    }
    public APIRequestCreateAdStudy setCells (String cells) {
      this.setParam("cells", cells);
      return this;
    }

    public APIRequestCreateAdStudy setClientBusiness (String clientBusiness) {
      this.setParam("client_business", clientBusiness);
      return this;
    }

    public APIRequestCreateAdStudy setConfidenceLevel (Double confidenceLevel) {
      this.setParam("confidence_level", confidenceLevel);
      return this;
    }
    public APIRequestCreateAdStudy setConfidenceLevel (String confidenceLevel) {
      this.setParam("confidence_level", confidenceLevel);
      return this;
    }

    public APIRequestCreateAdStudy setCooldownStartTime (Long cooldownStartTime) {
      this.setParam("cooldown_start_time", cooldownStartTime);
      return this;
    }
    public APIRequestCreateAdStudy setCooldownStartTime (String cooldownStartTime) {
      this.setParam("cooldown_start_time", cooldownStartTime);
      return this;
    }

    public APIRequestCreateAdStudy setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateAdStudy setEndTime (Long endTime) {
      this.setParam("end_time", endTime);
      return this;
    }
    public APIRequestCreateAdStudy setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestCreateAdStudy setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAdStudy setObjectives (List<Object> objectives) {
      this.setParam("objectives", objectives);
      return this;
    }
    public APIRequestCreateAdStudy setObjectives (String objectives) {
      this.setParam("objectives", objectives);
      return this;
    }

    public APIRequestCreateAdStudy setObservationEndTime (Long observationEndTime) {
      this.setParam("observation_end_time", observationEndTime);
      return this;
    }
    public APIRequestCreateAdStudy setObservationEndTime (String observationEndTime) {
      this.setParam("observation_end_time", observationEndTime);
      return this;
    }

    public APIRequestCreateAdStudy setStartTime (Long startTime) {
      this.setParam("start_time", startTime);
      return this;
    }
    public APIRequestCreateAdStudy setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestCreateAdStudy setType (AdStudy.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestCreateAdStudy setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestCreateAdStudy setViewers (List<Long> viewers) {
      this.setParam("viewers", viewers);
      return this;
    }
    public APIRequestCreateAdStudy setViewers (String viewers) {
      this.setParam("viewers", viewers);
      return this;
    }

    public APIRequestCreateAdStudy requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdStudy requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdStudy requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdStudy requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdStudy requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdStudy requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAdAccount extends APIRequest<AdAccount> {

    AdAccount lastResponse = null;
    @Override
    public AdAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "billing_address_id",
      "currency",
      "end_advertiser",
      "funding_id",
      "invoice",
      "invoice_group_id",
      "io",
      "liable_address_id",
      "media_agency",
      "name",
      "partner",
      "po_number",
      "sold_to_address_id",
      "timezone_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdAccount parseResponse(String response) throws APIException {
      return AdAccount.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAccount execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccount execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdAccount> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccount> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdAccount>() {
           public AdAccount apply(String result) {
             try {
               return APIRequestCreateAdAccount.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAdAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccount", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdAccount setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdAccount setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdAccount setBillingAddressId (Object billingAddressId) {
      this.setParam("billing_address_id", billingAddressId);
      return this;
    }
    public APIRequestCreateAdAccount setBillingAddressId (String billingAddressId) {
      this.setParam("billing_address_id", billingAddressId);
      return this;
    }

    public APIRequestCreateAdAccount setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestCreateAdAccount setEndAdvertiser (Object endAdvertiser) {
      this.setParam("end_advertiser", endAdvertiser);
      return this;
    }
    public APIRequestCreateAdAccount setEndAdvertiser (String endAdvertiser) {
      this.setParam("end_advertiser", endAdvertiser);
      return this;
    }

    public APIRequestCreateAdAccount setFundingId (String fundingId) {
      this.setParam("funding_id", fundingId);
      return this;
    }

    public APIRequestCreateAdAccount setInvoice (Boolean invoice) {
      this.setParam("invoice", invoice);
      return this;
    }
    public APIRequestCreateAdAccount setInvoice (String invoice) {
      this.setParam("invoice", invoice);
      return this;
    }

    public APIRequestCreateAdAccount setInvoiceGroupId (Object invoiceGroupId) {
      this.setParam("invoice_group_id", invoiceGroupId);
      return this;
    }
    public APIRequestCreateAdAccount setInvoiceGroupId (String invoiceGroupId) {
      this.setParam("invoice_group_id", invoiceGroupId);
      return this;
    }

    public APIRequestCreateAdAccount setIo (Boolean io) {
      this.setParam("io", io);
      return this;
    }
    public APIRequestCreateAdAccount setIo (String io) {
      this.setParam("io", io);
      return this;
    }

    public APIRequestCreateAdAccount setLiableAddressId (Object liableAddressId) {
      this.setParam("liable_address_id", liableAddressId);
      return this;
    }
    public APIRequestCreateAdAccount setLiableAddressId (String liableAddressId) {
      this.setParam("liable_address_id", liableAddressId);
      return this;
    }

    public APIRequestCreateAdAccount setMediaAgency (String mediaAgency) {
      this.setParam("media_agency", mediaAgency);
      return this;
    }

    public APIRequestCreateAdAccount setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAdAccount setPartner (String partner) {
      this.setParam("partner", partner);
      return this;
    }

    public APIRequestCreateAdAccount setPoNumber (String poNumber) {
      this.setParam("po_number", poNumber);
      return this;
    }

    public APIRequestCreateAdAccount setSoldToAddressId (Object soldToAddressId) {
      this.setParam("sold_to_address_id", soldToAddressId);
      return this;
    }
    public APIRequestCreateAdAccount setSoldToAddressId (String soldToAddressId) {
      this.setParam("sold_to_address_id", soldToAddressId);
      return this;
    }

    public APIRequestCreateAdAccount setTimezoneId (Long timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }
    public APIRequestCreateAdAccount setTimezoneId (String timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }

    public APIRequestCreateAdAccount requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdAccount requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdAccount requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdAccount requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdAccount requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdAccount requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdAccountCreationRequests extends APIRequest<AdAccountCreationRequest> {

    APINodeList<AdAccountCreationRequest> lastResponse = null;
    @Override
    public APINodeList<AdAccountCreationRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "status",
    };

    public static final String[] FIELDS = {
      "ad_accounts_info",
      "additional_comment",
      "address_in_chinese",
      "address_in_english",
      "advertiser_business",
      "appeal_reason",
      "business",
      "business_registration_id",
      "chinese_legal_entity_name",
      "contact",
      "creator",
      "disapproval_reasons",
      "english_legal_entity_name",
      "extended_credit_id",
      "id",
      "is_smb",
      "is_test",
      "is_under_authorization",
      "official_website_url",
      "planning_agency_business",
      "planning_agency_business_id",
      "promotable_app_ids",
      "promotable_page_ids",
      "promotable_urls",
      "request_change_reasons",
      "status",
      "subvertical",
      "time_created",
      "vertical",
    };

    @Override
    public APINodeList<AdAccountCreationRequest> parseResponse(String response) throws APIException {
      return AdAccountCreationRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccountCreationRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccountCreationRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdAccountCreationRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAccountCreationRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdAccountCreationRequest>>() {
           public APINodeList<AdAccountCreationRequest> apply(String result) {
             try {
               return APIRequestGetAdAccountCreationRequests.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdAccountCreationRequests(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccountcreationrequests", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdAccountCreationRequests setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdAccountCreationRequests setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdAccountCreationRequests setStatus (List<AdAccountCreationRequest.EnumStatus> status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestGetAdAccountCreationRequests requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdAccountCreationRequests requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdAccountCreationRequests requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdAccountCreationRequests requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdAccountCreationRequests requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdAccountCreationRequests requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdAccountCreationRequests requestAdAccountsInfoField () {
      return this.requestAdAccountsInfoField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestAdAccountsInfoField (boolean value) {
      this.requestField("ad_accounts_info", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestAdditionalCommentField () {
      return this.requestAdditionalCommentField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestAdditionalCommentField (boolean value) {
      this.requestField("additional_comment", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestAddressInChineseField () {
      return this.requestAddressInChineseField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestAddressInChineseField (boolean value) {
      this.requestField("address_in_chinese", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestAddressInEnglishField () {
      return this.requestAddressInEnglishField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestAddressInEnglishField (boolean value) {
      this.requestField("address_in_english", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestAdvertiserBusinessField () {
      return this.requestAdvertiserBusinessField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestAdvertiserBusinessField (boolean value) {
      this.requestField("advertiser_business", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestAppealReasonField () {
      return this.requestAppealReasonField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestAppealReasonField (boolean value) {
      this.requestField("appeal_reason", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestBusinessRegistrationIdField () {
      return this.requestBusinessRegistrationIdField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestBusinessRegistrationIdField (boolean value) {
      this.requestField("business_registration_id", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestChineseLegalEntityNameField () {
      return this.requestChineseLegalEntityNameField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestChineseLegalEntityNameField (boolean value) {
      this.requestField("chinese_legal_entity_name", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestContactField () {
      return this.requestContactField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestContactField (boolean value) {
      this.requestField("contact", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestDisapprovalReasonsField () {
      return this.requestDisapprovalReasonsField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestDisapprovalReasonsField (boolean value) {
      this.requestField("disapproval_reasons", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestEnglishLegalEntityNameField () {
      return this.requestEnglishLegalEntityNameField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestEnglishLegalEntityNameField (boolean value) {
      this.requestField("english_legal_entity_name", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestExtendedCreditIdField () {
      return this.requestExtendedCreditIdField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestExtendedCreditIdField (boolean value) {
      this.requestField("extended_credit_id", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestIsSmbField () {
      return this.requestIsSmbField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestIsSmbField (boolean value) {
      this.requestField("is_smb", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestIsTestField () {
      return this.requestIsTestField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestIsTestField (boolean value) {
      this.requestField("is_test", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestIsUnderAuthorizationField () {
      return this.requestIsUnderAuthorizationField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestIsUnderAuthorizationField (boolean value) {
      this.requestField("is_under_authorization", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestOfficialWebsiteUrlField () {
      return this.requestOfficialWebsiteUrlField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestOfficialWebsiteUrlField (boolean value) {
      this.requestField("official_website_url", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestPlanningAgencyBusinessField () {
      return this.requestPlanningAgencyBusinessField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestPlanningAgencyBusinessField (boolean value) {
      this.requestField("planning_agency_business", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestPlanningAgencyBusinessIdField () {
      return this.requestPlanningAgencyBusinessIdField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestPlanningAgencyBusinessIdField (boolean value) {
      this.requestField("planning_agency_business_id", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestPromotableAppIdsField () {
      return this.requestPromotableAppIdsField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestPromotableAppIdsField (boolean value) {
      this.requestField("promotable_app_ids", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestPromotablePageIdsField () {
      return this.requestPromotablePageIdsField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestPromotablePageIdsField (boolean value) {
      this.requestField("promotable_page_ids", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestPromotableUrlsField () {
      return this.requestPromotableUrlsField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestPromotableUrlsField (boolean value) {
      this.requestField("promotable_urls", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestRequestChangeReasonsField () {
      return this.requestRequestChangeReasonsField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestRequestChangeReasonsField (boolean value) {
      this.requestField("request_change_reasons", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestSubverticalField () {
      return this.requestSubverticalField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestSubverticalField (boolean value) {
      this.requestField("subvertical", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGetAdAccountCreationRequests requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetAdAccountCreationRequests requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
  }

  public static class APIRequestCreateAdAccountCreationRequest extends APIRequest<AdAccountCreationRequest> {

    AdAccountCreationRequest lastResponse = null;
    @Override
    public AdAccountCreationRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_accounts_info",
      "additional_comment",
      "address_in_chinese",
      "address_in_english",
      "advertiser_business_id",
      "business_registration",
      "business_registration_id",
      "chinese_legal_entity_name",
      "contact",
      "english_legal_entity_name",
      "extended_credit_id",
      "is_smb",
      "is_test",
      "official_website_url",
      "planning_agency_business_id",
      "promotable_app_ids",
      "promotable_page_ids",
      "promotable_page_urls",
      "promotable_urls",
      "subvertical",
      "vertical",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdAccountCreationRequest parseResponse(String response) throws APIException {
      return AdAccountCreationRequest.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAccountCreationRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccountCreationRequest execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdAccountCreationRequest> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccountCreationRequest> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdAccountCreationRequest>() {
           public AdAccountCreationRequest apply(String result) {
             try {
               return APIRequestCreateAdAccountCreationRequest.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAdAccountCreationRequest(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccountcreationrequests", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdAccountCreationRequest setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdAccountCreationRequest setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdAccountCreationRequest setAdAccountsInfo (List<Object> adAccountsInfo) {
      this.setParam("ad_accounts_info", adAccountsInfo);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setAdAccountsInfo (String adAccountsInfo) {
      this.setParam("ad_accounts_info", adAccountsInfo);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setAdditionalComment (String additionalComment) {
      this.setParam("additional_comment", additionalComment);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setAddressInChinese (String addressInChinese) {
      this.setParam("address_in_chinese", addressInChinese);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setAddressInEnglish (Object addressInEnglish) {
      this.setParam("address_in_english", addressInEnglish);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setAddressInEnglish (String addressInEnglish) {
      this.setParam("address_in_english", addressInEnglish);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setAdvertiserBusinessId (String advertiserBusinessId) {
      this.setParam("advertiser_business_id", advertiserBusinessId);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setBusinessRegistration (File businessRegistration) {
      this.setParam("business_registration", businessRegistration);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setBusinessRegistration (String businessRegistration) {
      this.setParam("business_registration", businessRegistration);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setBusinessRegistrationId (String businessRegistrationId) {
      this.setParam("business_registration_id", businessRegistrationId);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setChineseLegalEntityName (String chineseLegalEntityName) {
      this.setParam("chinese_legal_entity_name", chineseLegalEntityName);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setContact (Object contact) {
      this.setParam("contact", contact);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setContact (String contact) {
      this.setParam("contact", contact);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setEnglishLegalEntityName (String englishLegalEntityName) {
      this.setParam("english_legal_entity_name", englishLegalEntityName);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setExtendedCreditId (Object extendedCreditId) {
      this.setParam("extended_credit_id", extendedCreditId);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setExtendedCreditId (String extendedCreditId) {
      this.setParam("extended_credit_id", extendedCreditId);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setIsSmb (Boolean isSmb) {
      this.setParam("is_smb", isSmb);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setIsSmb (String isSmb) {
      this.setParam("is_smb", isSmb);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setIsTest (Boolean isTest) {
      this.setParam("is_test", isTest);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setIsTest (String isTest) {
      this.setParam("is_test", isTest);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setOfficialWebsiteUrl (Object officialWebsiteUrl) {
      this.setParam("official_website_url", officialWebsiteUrl);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setOfficialWebsiteUrl (String officialWebsiteUrl) {
      this.setParam("official_website_url", officialWebsiteUrl);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setPlanningAgencyBusinessId (String planningAgencyBusinessId) {
      this.setParam("planning_agency_business_id", planningAgencyBusinessId);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setPromotableAppIds (List<String> promotableAppIds) {
      this.setParam("promotable_app_ids", promotableAppIds);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setPromotableAppIds (String promotableAppIds) {
      this.setParam("promotable_app_ids", promotableAppIds);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setPromotablePageIds (List<String> promotablePageIds) {
      this.setParam("promotable_page_ids", promotablePageIds);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setPromotablePageIds (String promotablePageIds) {
      this.setParam("promotable_page_ids", promotablePageIds);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setPromotablePageUrls (List<Object> promotablePageUrls) {
      this.setParam("promotable_page_urls", promotablePageUrls);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setPromotablePageUrls (String promotablePageUrls) {
      this.setParam("promotable_page_urls", promotablePageUrls);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setPromotableUrls (List<Object> promotableUrls) {
      this.setParam("promotable_urls", promotableUrls);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setPromotableUrls (String promotableUrls) {
      this.setParam("promotable_urls", promotableUrls);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setSubvertical (AdAccountCreationRequest.EnumSubvertical subvertical) {
      this.setParam("subvertical", subvertical);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setSubvertical (String subvertical) {
      this.setParam("subvertical", subvertical);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest setVertical (AdAccountCreationRequest.EnumVertical vertical) {
      this.setParam("vertical", vertical);
      return this;
    }
    public APIRequestCreateAdAccountCreationRequest setVertical (String vertical) {
      this.setParam("vertical", vertical);
      return this;
    }

    public APIRequestCreateAdAccountCreationRequest requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdAccountCreationRequest requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdAccountCreationRequest requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdAccountCreationRequest requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdAccountCreationRequest requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdAccountCreationRequest requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteAdAccounts extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adaccount_id",
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
               return APIRequestDeleteAdAccounts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/adaccounts", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteAdAccounts setAdaccountId (String adaccountId) {
      this.setParam("adaccount_id", adaccountId);
      return this;
    }

    public APIRequestDeleteAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAdAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdNetworkAnalytics extends APIRequest<AdNetworkAnalyticsSyncQueryResult> {

    APINodeList<AdNetworkAnalyticsSyncQueryResult> lastResponse = null;
    @Override
    public APINodeList<AdNetworkAnalyticsSyncQueryResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "aggregation_period",
      "breakdowns",
      "filters",
      "metrics",
      "ordering_column",
      "ordering_type",
      "since",
      "until",
    };

    public static final String[] FIELDS = {
      "query_id",
      "results",
    };

    @Override
    public APINodeList<AdNetworkAnalyticsSyncQueryResult> parseResponse(String response) throws APIException {
      return AdNetworkAnalyticsSyncQueryResult.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdNetworkAnalyticsSyncQueryResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdNetworkAnalyticsSyncQueryResult> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdNetworkAnalyticsSyncQueryResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdNetworkAnalyticsSyncQueryResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdNetworkAnalyticsSyncQueryResult>>() {
           public APINodeList<AdNetworkAnalyticsSyncQueryResult> apply(String result) {
             try {
               return APIRequestGetAdNetworkAnalytics.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdNetworkAnalytics(String nodeId, APIContext context) {
      super(context, nodeId, "/adnetworkanalytics", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdNetworkAnalytics setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdNetworkAnalytics setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdNetworkAnalytics setAggregationPeriod (EnumAggregationPeriod aggregationPeriod) {
      this.setParam("aggregation_period", aggregationPeriod);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics setAggregationPeriod (String aggregationPeriod) {
      this.setParam("aggregation_period", aggregationPeriod);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics setBreakdowns (List<EnumBreakdowns> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics setFilters (List<Map<String, String>> filters) {
      this.setParam("filters", filters);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics setFilters (String filters) {
      this.setParam("filters", filters);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics setMetrics (List<EnumMetrics> metrics) {
      this.setParam("metrics", metrics);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics setMetrics (String metrics) {
      this.setParam("metrics", metrics);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics setOrderingColumn (EnumOrderingColumn orderingColumn) {
      this.setParam("ordering_column", orderingColumn);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics setOrderingColumn (String orderingColumn) {
      this.setParam("ordering_column", orderingColumn);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics setOrderingType (EnumOrderingType orderingType) {
      this.setParam("ordering_type", orderingType);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics setOrderingType (String orderingType) {
      this.setParam("ordering_type", orderingType);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics setSince (Object since) {
      this.setParam("since", since);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics setUntil (Object until) {
      this.setParam("until", until);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdNetworkAnalytics requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdNetworkAnalytics requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdNetworkAnalytics requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdNetworkAnalytics requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdNetworkAnalytics requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdNetworkAnalytics requestQueryIdField () {
      return this.requestQueryIdField(true);
    }
    public APIRequestGetAdNetworkAnalytics requestQueryIdField (boolean value) {
      this.requestField("query_id", value);
      return this;
    }
    public APIRequestGetAdNetworkAnalytics requestResultsField () {
      return this.requestResultsField(true);
    }
    public APIRequestGetAdNetworkAnalytics requestResultsField (boolean value) {
      this.requestField("results", value);
      return this;
    }
  }

  public static class APIRequestCreateAdNetworkAnalytic extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "aggregation_period",
      "breakdowns",
      "filters",
      "metrics",
      "ordering_column",
      "ordering_type",
      "since",
      "until",
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
               return APIRequestCreateAdNetworkAnalytic.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAdNetworkAnalytic(String nodeId, APIContext context) {
      super(context, nodeId, "/adnetworkanalytics", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdNetworkAnalytic setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdNetworkAnalytic setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdNetworkAnalytic setAggregationPeriod (EnumAggregationPeriod aggregationPeriod) {
      this.setParam("aggregation_period", aggregationPeriod);
      return this;
    }
    public APIRequestCreateAdNetworkAnalytic setAggregationPeriod (String aggregationPeriod) {
      this.setParam("aggregation_period", aggregationPeriod);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic setBreakdowns (List<EnumBreakdowns> breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }
    public APIRequestCreateAdNetworkAnalytic setBreakdowns (String breakdowns) {
      this.setParam("breakdowns", breakdowns);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic setFilters (List<Object> filters) {
      this.setParam("filters", filters);
      return this;
    }
    public APIRequestCreateAdNetworkAnalytic setFilters (String filters) {
      this.setParam("filters", filters);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic setMetrics (List<EnumMetrics> metrics) {
      this.setParam("metrics", metrics);
      return this;
    }
    public APIRequestCreateAdNetworkAnalytic setMetrics (String metrics) {
      this.setParam("metrics", metrics);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic setOrderingColumn (EnumOrderingColumn orderingColumn) {
      this.setParam("ordering_column", orderingColumn);
      return this;
    }
    public APIRequestCreateAdNetworkAnalytic setOrderingColumn (String orderingColumn) {
      this.setParam("ordering_column", orderingColumn);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic setOrderingType (EnumOrderingType orderingType) {
      this.setParam("ordering_type", orderingType);
      return this;
    }
    public APIRequestCreateAdNetworkAnalytic setOrderingType (String orderingType) {
      this.setParam("ordering_type", orderingType);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic setSince (Object since) {
      this.setParam("since", since);
      return this;
    }
    public APIRequestCreateAdNetworkAnalytic setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic setUntil (Object until) {
      this.setParam("until", until);
      return this;
    }
    public APIRequestCreateAdNetworkAnalytic setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestCreateAdNetworkAnalytic requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdNetworkAnalytic requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdNetworkAnalytic requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdNetworkAnalytic requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdNetworkAnalytic requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdNetworkAnalytic requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdNetworkAnalyticsResults extends APIRequest<AdNetworkAnalyticsAsyncQueryResult> {

    APINodeList<AdNetworkAnalyticsAsyncQueryResult> lastResponse = null;
    @Override
    public APINodeList<AdNetworkAnalyticsAsyncQueryResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "query_ids",
    };

    public static final String[] FIELDS = {
      "data",
      "error",
      "query_id",
      "results",
      "status",
    };

    @Override
    public APINodeList<AdNetworkAnalyticsAsyncQueryResult> parseResponse(String response) throws APIException {
      return AdNetworkAnalyticsAsyncQueryResult.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdNetworkAnalyticsAsyncQueryResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdNetworkAnalyticsAsyncQueryResult> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdNetworkAnalyticsAsyncQueryResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdNetworkAnalyticsAsyncQueryResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdNetworkAnalyticsAsyncQueryResult>>() {
           public APINodeList<AdNetworkAnalyticsAsyncQueryResult> apply(String result) {
             try {
               return APIRequestGetAdNetworkAnalyticsResults.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdNetworkAnalyticsResults(String nodeId, APIContext context) {
      super(context, nodeId, "/adnetworkanalytics_results", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdNetworkAnalyticsResults setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdNetworkAnalyticsResults setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdNetworkAnalyticsResults setQueryIds (List<String> queryIds) {
      this.setParam("query_ids", queryIds);
      return this;
    }
    public APIRequestGetAdNetworkAnalyticsResults setQueryIds (String queryIds) {
      this.setParam("query_ids", queryIds);
      return this;
    }

    public APIRequestGetAdNetworkAnalyticsResults requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdNetworkAnalyticsResults requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdNetworkAnalyticsResults requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdNetworkAnalyticsResults requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdNetworkAnalyticsResults requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdNetworkAnalyticsResults requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdNetworkAnalyticsResults requestDataField () {
      return this.requestDataField(true);
    }
    public APIRequestGetAdNetworkAnalyticsResults requestDataField (boolean value) {
      this.requestField("data", value);
      return this;
    }
    public APIRequestGetAdNetworkAnalyticsResults requestErrorField () {
      return this.requestErrorField(true);
    }
    public APIRequestGetAdNetworkAnalyticsResults requestErrorField (boolean value) {
      this.requestField("error", value);
      return this;
    }
    public APIRequestGetAdNetworkAnalyticsResults requestQueryIdField () {
      return this.requestQueryIdField(true);
    }
    public APIRequestGetAdNetworkAnalyticsResults requestQueryIdField (boolean value) {
      this.requestField("query_id", value);
      return this;
    }
    public APIRequestGetAdNetworkAnalyticsResults requestResultsField () {
      return this.requestResultsField(true);
    }
    public APIRequestGetAdNetworkAnalyticsResults requestResultsField (boolean value) {
      this.requestField("results", value);
      return this;
    }
    public APIRequestGetAdNetworkAnalyticsResults requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdNetworkAnalyticsResults requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static class APIRequestGetAdsPixels extends APIRequest<AdsPixel> {

    APINodeList<AdsPixel> lastResponse = null;
    @Override
    public APINodeList<AdsPixel> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "id_filter",
      "name_filter",
    };

    public static final String[] FIELDS = {
      "can_proxy",
      "code",
      "creation_time",
      "creator",
      "id",
      "is_created_by_business",
      "last_fired_time",
      "name",
      "owner_ad_account",
      "owner_business",
    };

    @Override
    public APINodeList<AdsPixel> parseResponse(String response) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdsPixel> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsPixel> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdsPixel>>() {
           public APINodeList<AdsPixel> apply(String result) {
             try {
               return APIRequestGetAdsPixels.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdsPixels(String nodeId, APIContext context) {
      super(context, nodeId, "/adspixels", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdsPixels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdsPixels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdsPixels setIdFilter (String idFilter) {
      this.setParam("id_filter", idFilter);
      return this;
    }

    public APIRequestGetAdsPixels setNameFilter (String nameFilter) {
      this.setParam("name_filter", nameFilter);
      return this;
    }

    public APIRequestGetAdsPixels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdsPixels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdsPixels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdsPixels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdsPixels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdsPixels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdsPixels requestCanProxyField () {
      return this.requestCanProxyField(true);
    }
    public APIRequestGetAdsPixels requestCanProxyField (boolean value) {
      this.requestField("can_proxy", value);
      return this;
    }
    public APIRequestGetAdsPixels requestCodeField () {
      return this.requestCodeField(true);
    }
    public APIRequestGetAdsPixels requestCodeField (boolean value) {
      this.requestField("code", value);
      return this;
    }
    public APIRequestGetAdsPixels requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetAdsPixels requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetAdsPixels requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetAdsPixels requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetAdsPixels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdsPixels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdsPixels requestIsCreatedByBusinessField () {
      return this.requestIsCreatedByBusinessField(true);
    }
    public APIRequestGetAdsPixels requestIsCreatedByBusinessField (boolean value) {
      this.requestField("is_created_by_business", value);
      return this;
    }
    public APIRequestGetAdsPixels requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetAdsPixels requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGetAdsPixels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdsPixels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdsPixels requestOwnerAdAccountField () {
      return this.requestOwnerAdAccountField(true);
    }
    public APIRequestGetAdsPixels requestOwnerAdAccountField (boolean value) {
      this.requestField("owner_ad_account", value);
      return this;
    }
    public APIRequestGetAdsPixels requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetAdsPixels requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
  }

  public static class APIRequestCreateAdsPixel extends APIRequest<AdsPixel> {

    AdsPixel lastResponse = null;
    @Override
    public AdsPixel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdsPixel parseResponse(String response) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdsPixel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsPixel execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdsPixel> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsPixel> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdsPixel>() {
           public AdsPixel apply(String result) {
             try {
               return APIRequestCreateAdsPixel.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateAdsPixel(String nodeId, APIContext context) {
      super(context, nodeId, "/adspixels", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdsPixel setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdsPixel setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdsPixel setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateAdsPixel requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdsPixel requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdsPixel requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdsPixel requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdsPixel requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdsPixel requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAdvertisableApplications extends APIRequest<BusinessAdvertisableApplicationsResult> {

    APINodeList<BusinessAdvertisableApplicationsResult> lastResponse = null;
    @Override
    public APINodeList<BusinessAdvertisableApplicationsResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adaccount_id",
    };

    public static final String[] FIELDS = {
      "has_insight_permission",
      "id",
      "name",
    };

    @Override
    public APINodeList<BusinessAdvertisableApplicationsResult> parseResponse(String response) throws APIException {
      return BusinessAdvertisableApplicationsResult.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessAdvertisableApplicationsResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessAdvertisableApplicationsResult> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessAdvertisableApplicationsResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessAdvertisableApplicationsResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessAdvertisableApplicationsResult>>() {
           public APINodeList<BusinessAdvertisableApplicationsResult> apply(String result) {
             try {
               return APIRequestGetAdvertisableApplications.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAdvertisableApplications(String nodeId, APIContext context) {
      super(context, nodeId, "/advertisable_applications", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdvertisableApplications setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdvertisableApplications setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdvertisableApplications setAdaccountId (Long adaccountId) {
      this.setParam("adaccount_id", adaccountId);
      return this;
    }
    public APIRequestGetAdvertisableApplications setAdaccountId (String adaccountId) {
      this.setParam("adaccount_id", adaccountId);
      return this;
    }

    public APIRequestGetAdvertisableApplications requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdvertisableApplications requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdvertisableApplications requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdvertisableApplications requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdvertisableApplications requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdvertisableApplications requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdvertisableApplications requestHasInsightPermissionField () {
      return this.requestHasInsightPermissionField(true);
    }
    public APIRequestGetAdvertisableApplications requestHasInsightPermissionField (boolean value) {
      this.requestField("has_insight_permission", value);
      return this;
    }
    public APIRequestGetAdvertisableApplications requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdvertisableApplications requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdvertisableApplications requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdvertisableApplications requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
  }

  public static class APIRequestDeleteAgencies extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business",
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
               return APIRequestDeleteAgencies.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteAgencies(String nodeId, APIContext context) {
      super(context, nodeId, "/agencies", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteAgencies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteAgencies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteAgencies setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestDeleteAgencies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteAgencies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAgencies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteAgencies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAgencies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteAgencies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAgencyPages extends APIRequest<Page> {

    APINodeList<Page> lastResponse = null;
    @Override
    public APINodeList<Page> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "agency_id",
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
               return APIRequestGetAgencyPages.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAgencyPages(String nodeId, APIContext context) {
      super(context, nodeId, "/agency_pages", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAgencyPages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAgencyPages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAgencyPages setAgencyId (String agencyId) {
      this.setParam("agency_id", agencyId);
      return this;
    }

    public APIRequestGetAgencyPages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAgencyPages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAgencyPages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAgencyPages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAgencyPages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAgencyPages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAgencyPages requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetAgencyPages requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetAgencyPages requestAccessTokenField () {
      return this.requestAccessTokenField(true);
    }
    public APIRequestGetAgencyPages requestAccessTokenField (boolean value) {
      this.requestField("access_token", value);
      return this;
    }
    public APIRequestGetAgencyPages requestAdCampaignField () {
      return this.requestAdCampaignField(true);
    }
    public APIRequestGetAgencyPages requestAdCampaignField (boolean value) {
      this.requestField("ad_campaign", value);
      return this;
    }
    public APIRequestGetAgencyPages requestAffiliationField () {
      return this.requestAffiliationField(true);
    }
    public APIRequestGetAgencyPages requestAffiliationField (boolean value) {
      this.requestField("affiliation", value);
      return this;
    }
    public APIRequestGetAgencyPages requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetAgencyPages requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetAgencyPages requestAppLinksField () {
      return this.requestAppLinksField(true);
    }
    public APIRequestGetAgencyPages requestAppLinksField (boolean value) {
      this.requestField("app_links", value);
      return this;
    }
    public APIRequestGetAgencyPages requestArtistsWeLikeField () {
      return this.requestArtistsWeLikeField(true);
    }
    public APIRequestGetAgencyPages requestArtistsWeLikeField (boolean value) {
      this.requestField("artists_we_like", value);
      return this;
    }
    public APIRequestGetAgencyPages requestAttireField () {
      return this.requestAttireField(true);
    }
    public APIRequestGetAgencyPages requestAttireField (boolean value) {
      this.requestField("attire", value);
      return this;
    }
    public APIRequestGetAgencyPages requestAwardsField () {
      return this.requestAwardsField(true);
    }
    public APIRequestGetAgencyPages requestAwardsField (boolean value) {
      this.requestField("awards", value);
      return this;
    }
    public APIRequestGetAgencyPages requestBandInterestsField () {
      return this.requestBandInterestsField(true);
    }
    public APIRequestGetAgencyPages requestBandInterestsField (boolean value) {
      this.requestField("band_interests", value);
      return this;
    }
    public APIRequestGetAgencyPages requestBandMembersField () {
      return this.requestBandMembersField(true);
    }
    public APIRequestGetAgencyPages requestBandMembersField (boolean value) {
      this.requestField("band_members", value);
      return this;
    }
    public APIRequestGetAgencyPages requestBestPageField () {
      return this.requestBestPageField(true);
    }
    public APIRequestGetAgencyPages requestBestPageField (boolean value) {
      this.requestField("best_page", value);
      return this;
    }
    public APIRequestGetAgencyPages requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetAgencyPages requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetAgencyPages requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetAgencyPages requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetAgencyPages requestBookingAgentField () {
      return this.requestBookingAgentField(true);
    }
    public APIRequestGetAgencyPages requestBookingAgentField (boolean value) {
      this.requestField("booking_agent", value);
      return this;
    }
    public APIRequestGetAgencyPages requestBuiltField () {
      return this.requestBuiltField(true);
    }
    public APIRequestGetAgencyPages requestBuiltField (boolean value) {
      this.requestField("built", value);
      return this;
    }
    public APIRequestGetAgencyPages requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAgencyPages requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCanCheckinField () {
      return this.requestCanCheckinField(true);
    }
    public APIRequestGetAgencyPages requestCanCheckinField (boolean value) {
      this.requestField("can_checkin", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetAgencyPages requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetAgencyPages requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCategoryListField () {
      return this.requestCategoryListField(true);
    }
    public APIRequestGetAgencyPages requestCategoryListField (boolean value) {
      this.requestField("category_list", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCheckinsField () {
      return this.requestCheckinsField(true);
    }
    public APIRequestGetAgencyPages requestCheckinsField (boolean value) {
      this.requestField("checkins", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCompanyOverviewField () {
      return this.requestCompanyOverviewField(true);
    }
    public APIRequestGetAgencyPages requestCompanyOverviewField (boolean value) {
      this.requestField("company_overview", value);
      return this;
    }
    public APIRequestGetAgencyPages requestConnectedInstagramAccountField () {
      return this.requestConnectedInstagramAccountField(true);
    }
    public APIRequestGetAgencyPages requestConnectedInstagramAccountField (boolean value) {
      this.requestField("connected_instagram_account", value);
      return this;
    }
    public APIRequestGetAgencyPages requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetAgencyPages requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetAgencyPages requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetAgencyPages requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCopyrightAttributionInsightsField () {
      return this.requestCopyrightAttributionInsightsField(true);
    }
    public APIRequestGetAgencyPages requestCopyrightAttributionInsightsField (boolean value) {
      this.requestField("copyright_attribution_insights", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCopyrightWhitelistedIgPartnersField () {
      return this.requestCopyrightWhitelistedIgPartnersField(true);
    }
    public APIRequestGetAgencyPages requestCopyrightWhitelistedIgPartnersField (boolean value) {
      this.requestField("copyright_whitelisted_ig_partners", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCountryPageLikesField () {
      return this.requestCountryPageLikesField(true);
    }
    public APIRequestGetAgencyPages requestCountryPageLikesField (boolean value) {
      this.requestField("country_page_likes", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetAgencyPages requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCulinaryTeamField () {
      return this.requestCulinaryTeamField(true);
    }
    public APIRequestGetAgencyPages requestCulinaryTeamField (boolean value) {
      this.requestField("culinary_team", value);
      return this;
    }
    public APIRequestGetAgencyPages requestCurrentLocationField () {
      return this.requestCurrentLocationField(true);
    }
    public APIRequestGetAgencyPages requestCurrentLocationField (boolean value) {
      this.requestField("current_location", value);
      return this;
    }
    public APIRequestGetAgencyPages requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetAgencyPages requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetAgencyPages requestDescriptionHtmlField () {
      return this.requestDescriptionHtmlField(true);
    }
    public APIRequestGetAgencyPages requestDescriptionHtmlField (boolean value) {
      this.requestField("description_html", value);
      return this;
    }
    public APIRequestGetAgencyPages requestDirectedByField () {
      return this.requestDirectedByField(true);
    }
    public APIRequestGetAgencyPages requestDirectedByField (boolean value) {
      this.requestField("directed_by", value);
      return this;
    }
    public APIRequestGetAgencyPages requestDisplaySubtextField () {
      return this.requestDisplaySubtextField(true);
    }
    public APIRequestGetAgencyPages requestDisplaySubtextField (boolean value) {
      this.requestField("display_subtext", value);
      return this;
    }
    public APIRequestGetAgencyPages requestDisplayedMessageResponseTimeField () {
      return this.requestDisplayedMessageResponseTimeField(true);
    }
    public APIRequestGetAgencyPages requestDisplayedMessageResponseTimeField (boolean value) {
      this.requestField("displayed_message_response_time", value);
      return this;
    }
    public APIRequestGetAgencyPages requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetAgencyPages requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetAgencyPages requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGetAgencyPages requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGetAgencyPages requestFanCountField () {
      return this.requestFanCountField(true);
    }
    public APIRequestGetAgencyPages requestFanCountField (boolean value) {
      this.requestField("fan_count", value);
      return this;
    }
    public APIRequestGetAgencyPages requestFeaturedVideoField () {
      return this.requestFeaturedVideoField(true);
    }
    public APIRequestGetAgencyPages requestFeaturedVideoField (boolean value) {
      this.requestField("featured_video", value);
      return this;
    }
    public APIRequestGetAgencyPages requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetAgencyPages requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetAgencyPages requestFoodStylesField () {
      return this.requestFoodStylesField(true);
    }
    public APIRequestGetAgencyPages requestFoodStylesField (boolean value) {
      this.requestField("food_styles", value);
      return this;
    }
    public APIRequestGetAgencyPages requestFoundedField () {
      return this.requestFoundedField(true);
    }
    public APIRequestGetAgencyPages requestFoundedField (boolean value) {
      this.requestField("founded", value);
      return this;
    }
    public APIRequestGetAgencyPages requestGeneralInfoField () {
      return this.requestGeneralInfoField(true);
    }
    public APIRequestGetAgencyPages requestGeneralInfoField (boolean value) {
      this.requestField("general_info", value);
      return this;
    }
    public APIRequestGetAgencyPages requestGeneralManagerField () {
      return this.requestGeneralManagerField(true);
    }
    public APIRequestGetAgencyPages requestGeneralManagerField (boolean value) {
      this.requestField("general_manager", value);
      return this;
    }
    public APIRequestGetAgencyPages requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGetAgencyPages requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGetAgencyPages requestGlobalBrandPageNameField () {
      return this.requestGlobalBrandPageNameField(true);
    }
    public APIRequestGetAgencyPages requestGlobalBrandPageNameField (boolean value) {
      this.requestField("global_brand_page_name", value);
      return this;
    }
    public APIRequestGetAgencyPages requestGlobalBrandRootIdField () {
      return this.requestGlobalBrandRootIdField(true);
    }
    public APIRequestGetAgencyPages requestGlobalBrandRootIdField (boolean value) {
      this.requestField("global_brand_root_id", value);
      return this;
    }
    public APIRequestGetAgencyPages requestHasAddedAppField () {
      return this.requestHasAddedAppField(true);
    }
    public APIRequestGetAgencyPages requestHasAddedAppField (boolean value) {
      this.requestField("has_added_app", value);
      return this;
    }
    public APIRequestGetAgencyPages requestHasWhatsappNumberField () {
      return this.requestHasWhatsappNumberField(true);
    }
    public APIRequestGetAgencyPages requestHasWhatsappNumberField (boolean value) {
      this.requestField("has_whatsapp_number", value);
      return this;
    }
    public APIRequestGetAgencyPages requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetAgencyPages requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetAgencyPages requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGetAgencyPages requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAgencyPages requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAgencyPages requestImpressumField () {
      return this.requestImpressumField(true);
    }
    public APIRequestGetAgencyPages requestImpressumField (boolean value) {
      this.requestField("impressum", value);
      return this;
    }
    public APIRequestGetAgencyPages requestInfluencesField () {
      return this.requestInfluencesField(true);
    }
    public APIRequestGetAgencyPages requestInfluencesField (boolean value) {
      this.requestField("influences", value);
      return this;
    }
    public APIRequestGetAgencyPages requestInstagramBusinessAccountField () {
      return this.requestInstagramBusinessAccountField(true);
    }
    public APIRequestGetAgencyPages requestInstagramBusinessAccountField (boolean value) {
      this.requestField("instagram_business_account", value);
      return this;
    }
    public APIRequestGetAgencyPages requestInstantArticlesReviewStatusField () {
      return this.requestInstantArticlesReviewStatusField(true);
    }
    public APIRequestGetAgencyPages requestInstantArticlesReviewStatusField (boolean value) {
      this.requestField("instant_articles_review_status", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetAgencyPages requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsChainField () {
      return this.requestIsChainField(true);
    }
    public APIRequestGetAgencyPages requestIsChainField (boolean value) {
      this.requestField("is_chain", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsCommunityPageField () {
      return this.requestIsCommunityPageField(true);
    }
    public APIRequestGetAgencyPages requestIsCommunityPageField (boolean value) {
      this.requestField("is_community_page", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsEligibleForBrandedContentField () {
      return this.requestIsEligibleForBrandedContentField(true);
    }
    public APIRequestGetAgencyPages requestIsEligibleForBrandedContentField (boolean value) {
      this.requestField("is_eligible_for_branded_content", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsMessengerBotGetStartedEnabledField () {
      return this.requestIsMessengerBotGetStartedEnabledField(true);
    }
    public APIRequestGetAgencyPages requestIsMessengerBotGetStartedEnabledField (boolean value) {
      this.requestField("is_messenger_bot_get_started_enabled", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsMessengerPlatformBotField () {
      return this.requestIsMessengerPlatformBotField(true);
    }
    public APIRequestGetAgencyPages requestIsMessengerPlatformBotField (boolean value) {
      this.requestField("is_messenger_platform_bot", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsOwnedField () {
      return this.requestIsOwnedField(true);
    }
    public APIRequestGetAgencyPages requestIsOwnedField (boolean value) {
      this.requestField("is_owned", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsPermanentlyClosedField () {
      return this.requestIsPermanentlyClosedField(true);
    }
    public APIRequestGetAgencyPages requestIsPermanentlyClosedField (boolean value) {
      this.requestField("is_permanently_closed", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetAgencyPages requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsUnclaimedField () {
      return this.requestIsUnclaimedField(true);
    }
    public APIRequestGetAgencyPages requestIsUnclaimedField (boolean value) {
      this.requestField("is_unclaimed", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetAgencyPages requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetAgencyPages requestIsWebhooksSubscribedField () {
      return this.requestIsWebhooksSubscribedField(true);
    }
    public APIRequestGetAgencyPages requestIsWebhooksSubscribedField (boolean value) {
      this.requestField("is_webhooks_subscribed", value);
      return this;
    }
    public APIRequestGetAgencyPages requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGetAgencyPages requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGetAgencyPages requestLeadgenFormPreviewDetailsField () {
      return this.requestLeadgenFormPreviewDetailsField(true);
    }
    public APIRequestGetAgencyPages requestLeadgenFormPreviewDetailsField (boolean value) {
      this.requestField("leadgen_form_preview_details", value);
      return this;
    }
    public APIRequestGetAgencyPages requestLeadgenHasCrmIntegrationField () {
      return this.requestLeadgenHasCrmIntegrationField(true);
    }
    public APIRequestGetAgencyPages requestLeadgenHasCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_crm_integration", value);
      return this;
    }
    public APIRequestGetAgencyPages requestLeadgenHasFatPingCrmIntegrationField () {
      return this.requestLeadgenHasFatPingCrmIntegrationField(true);
    }
    public APIRequestGetAgencyPages requestLeadgenHasFatPingCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_fat_ping_crm_integration", value);
      return this;
    }
    public APIRequestGetAgencyPages requestLeadgenTosAcceptanceTimeField () {
      return this.requestLeadgenTosAcceptanceTimeField(true);
    }
    public APIRequestGetAgencyPages requestLeadgenTosAcceptanceTimeField (boolean value) {
      this.requestField("leadgen_tos_acceptance_time", value);
      return this;
    }
    public APIRequestGetAgencyPages requestLeadgenTosAcceptedField () {
      return this.requestLeadgenTosAcceptedField(true);
    }
    public APIRequestGetAgencyPages requestLeadgenTosAcceptedField (boolean value) {
      this.requestField("leadgen_tos_accepted", value);
      return this;
    }
    public APIRequestGetAgencyPages requestLeadgenTosAcceptingUserField () {
      return this.requestLeadgenTosAcceptingUserField(true);
    }
    public APIRequestGetAgencyPages requestLeadgenTosAcceptingUserField (boolean value) {
      this.requestField("leadgen_tos_accepting_user", value);
      return this;
    }
    public APIRequestGetAgencyPages requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetAgencyPages requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetAgencyPages requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetAgencyPages requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMembersField () {
      return this.requestMembersField(true);
    }
    public APIRequestGetAgencyPages requestMembersField (boolean value) {
      this.requestField("members", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetAgencyPages requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMerchantReviewStatusField () {
      return this.requestMerchantReviewStatusField(true);
    }
    public APIRequestGetAgencyPages requestMerchantReviewStatusField (boolean value) {
      this.requestField("merchant_review_status", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetAgencyPages requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMessengerAdsDefaultPageWelcomeMessageField () {
      return this.requestMessengerAdsDefaultPageWelcomeMessageField(true);
    }
    public APIRequestGetAgencyPages requestMessengerAdsDefaultPageWelcomeMessageField (boolean value) {
      this.requestField("messenger_ads_default_page_welcome_message", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMessengerAdsDefaultQuickRepliesField () {
      return this.requestMessengerAdsDefaultQuickRepliesField(true);
    }
    public APIRequestGetAgencyPages requestMessengerAdsDefaultQuickRepliesField (boolean value) {
      this.requestField("messenger_ads_default_quick_replies", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMessengerAdsQuickRepliesTypeField () {
      return this.requestMessengerAdsQuickRepliesTypeField(true);
    }
    public APIRequestGetAgencyPages requestMessengerAdsQuickRepliesTypeField (boolean value) {
      this.requestField("messenger_ads_quick_replies_type", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMissionField () {
      return this.requestMissionField(true);
    }
    public APIRequestGetAgencyPages requestMissionField (boolean value) {
      this.requestField("mission", value);
      return this;
    }
    public APIRequestGetAgencyPages requestMpgField () {
      return this.requestMpgField(true);
    }
    public APIRequestGetAgencyPages requestMpgField (boolean value) {
      this.requestField("mpg", value);
      return this;
    }
    public APIRequestGetAgencyPages requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAgencyPages requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAgencyPages requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGetAgencyPages requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGetAgencyPages requestNetworkField () {
      return this.requestNetworkField(true);
    }
    public APIRequestGetAgencyPages requestNetworkField (boolean value) {
      this.requestField("network", value);
      return this;
    }
    public APIRequestGetAgencyPages requestNewLikeCountField () {
      return this.requestNewLikeCountField(true);
    }
    public APIRequestGetAgencyPages requestNewLikeCountField (boolean value) {
      this.requestField("new_like_count", value);
      return this;
    }
    public APIRequestGetAgencyPages requestOfferEligibleField () {
      return this.requestOfferEligibleField(true);
    }
    public APIRequestGetAgencyPages requestOfferEligibleField (boolean value) {
      this.requestField("offer_eligible", value);
      return this;
    }
    public APIRequestGetAgencyPages requestOverallStarRatingField () {
      return this.requestOverallStarRatingField(true);
    }
    public APIRequestGetAgencyPages requestOverallStarRatingField (boolean value) {
      this.requestField("overall_star_rating", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPageTokenField () {
      return this.requestPageTokenField(true);
    }
    public APIRequestGetAgencyPages requestPageTokenField (boolean value) {
      this.requestField("page_token", value);
      return this;
    }
    public APIRequestGetAgencyPages requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetAgencyPages requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGetAgencyPages requestParkingField () {
      return this.requestParkingField(true);
    }
    public APIRequestGetAgencyPages requestParkingField (boolean value) {
      this.requestField("parking", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPaymentOptionsField () {
      return this.requestPaymentOptionsField(true);
    }
    public APIRequestGetAgencyPages requestPaymentOptionsField (boolean value) {
      this.requestField("payment_options", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPersonalInfoField () {
      return this.requestPersonalInfoField(true);
    }
    public APIRequestGetAgencyPages requestPersonalInfoField (boolean value) {
      this.requestField("personal_info", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPersonalInterestsField () {
      return this.requestPersonalInterestsField(true);
    }
    public APIRequestGetAgencyPages requestPersonalInterestsField (boolean value) {
      this.requestField("personal_interests", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPharmaSafetyInfoField () {
      return this.requestPharmaSafetyInfoField(true);
    }
    public APIRequestGetAgencyPages requestPharmaSafetyInfoField (boolean value) {
      this.requestField("pharma_safety_info", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetAgencyPages requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPlaceTypeField () {
      return this.requestPlaceTypeField(true);
    }
    public APIRequestGetAgencyPages requestPlaceTypeField (boolean value) {
      this.requestField("place_type", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPlotOutlineField () {
      return this.requestPlotOutlineField(true);
    }
    public APIRequestGetAgencyPages requestPlotOutlineField (boolean value) {
      this.requestField("plot_outline", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPreferredAudienceField () {
      return this.requestPreferredAudienceField(true);
    }
    public APIRequestGetAgencyPages requestPreferredAudienceField (boolean value) {
      this.requestField("preferred_audience", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPressContactField () {
      return this.requestPressContactField(true);
    }
    public APIRequestGetAgencyPages requestPressContactField (boolean value) {
      this.requestField("press_contact", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGetAgencyPages requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGetAgencyPages requestProducedByField () {
      return this.requestProducedByField(true);
    }
    public APIRequestGetAgencyPages requestProducedByField (boolean value) {
      this.requestField("produced_by", value);
      return this;
    }
    public APIRequestGetAgencyPages requestProductsField () {
      return this.requestProductsField(true);
    }
    public APIRequestGetAgencyPages requestProductsField (boolean value) {
      this.requestField("products", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPromotionEligibleField () {
      return this.requestPromotionEligibleField(true);
    }
    public APIRequestGetAgencyPages requestPromotionEligibleField (boolean value) {
      this.requestField("promotion_eligible", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPromotionIneligibleReasonField () {
      return this.requestPromotionIneligibleReasonField(true);
    }
    public APIRequestGetAgencyPages requestPromotionIneligibleReasonField (boolean value) {
      this.requestField("promotion_ineligible_reason", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPublicTransitField () {
      return this.requestPublicTransitField(true);
    }
    public APIRequestGetAgencyPages requestPublicTransitField (boolean value) {
      this.requestField("public_transit", value);
      return this;
    }
    public APIRequestGetAgencyPages requestPublisherSpaceField () {
      return this.requestPublisherSpaceField(true);
    }
    public APIRequestGetAgencyPages requestPublisherSpaceField (boolean value) {
      this.requestField("publisher_space", value);
      return this;
    }
    public APIRequestGetAgencyPages requestRatingCountField () {
      return this.requestRatingCountField(true);
    }
    public APIRequestGetAgencyPages requestRatingCountField (boolean value) {
      this.requestField("rating_count", value);
      return this;
    }
    public APIRequestGetAgencyPages requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetAgencyPages requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetAgencyPages requestRecordLabelField () {
      return this.requestRecordLabelField(true);
    }
    public APIRequestGetAgencyPages requestRecordLabelField (boolean value) {
      this.requestField("record_label", value);
      return this;
    }
    public APIRequestGetAgencyPages requestReleaseDateField () {
      return this.requestReleaseDateField(true);
    }
    public APIRequestGetAgencyPages requestReleaseDateField (boolean value) {
      this.requestField("release_date", value);
      return this;
    }
    public APIRequestGetAgencyPages requestRestaurantServicesField () {
      return this.requestRestaurantServicesField(true);
    }
    public APIRequestGetAgencyPages requestRestaurantServicesField (boolean value) {
      this.requestField("restaurant_services", value);
      return this;
    }
    public APIRequestGetAgencyPages requestRestaurantSpecialtiesField () {
      return this.requestRestaurantSpecialtiesField(true);
    }
    public APIRequestGetAgencyPages requestRestaurantSpecialtiesField (boolean value) {
      this.requestField("restaurant_specialties", value);
      return this;
    }
    public APIRequestGetAgencyPages requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetAgencyPages requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGetAgencyPages requestScreenplayByField () {
      return this.requestScreenplayByField(true);
    }
    public APIRequestGetAgencyPages requestScreenplayByField (boolean value) {
      this.requestField("screenplay_by", value);
      return this;
    }
    public APIRequestGetAgencyPages requestSeasonField () {
      return this.requestSeasonField(true);
    }
    public APIRequestGetAgencyPages requestSeasonField (boolean value) {
      this.requestField("season", value);
      return this;
    }
    public APIRequestGetAgencyPages requestSingleLineAddressField () {
      return this.requestSingleLineAddressField(true);
    }
    public APIRequestGetAgencyPages requestSingleLineAddressField (boolean value) {
      this.requestField("single_line_address", value);
      return this;
    }
    public APIRequestGetAgencyPages requestStarringField () {
      return this.requestStarringField(true);
    }
    public APIRequestGetAgencyPages requestStarringField (boolean value) {
      this.requestField("starring", value);
      return this;
    }
    public APIRequestGetAgencyPages requestStartInfoField () {
      return this.requestStartInfoField(true);
    }
    public APIRequestGetAgencyPages requestStartInfoField (boolean value) {
      this.requestField("start_info", value);
      return this;
    }
    public APIRequestGetAgencyPages requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGetAgencyPages requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGetAgencyPages requestStoreLocationDescriptorField () {
      return this.requestStoreLocationDescriptorField(true);
    }
    public APIRequestGetAgencyPages requestStoreLocationDescriptorField (boolean value) {
      this.requestField("store_location_descriptor", value);
      return this;
    }
    public APIRequestGetAgencyPages requestStoreNumberField () {
      return this.requestStoreNumberField(true);
    }
    public APIRequestGetAgencyPages requestStoreNumberField (boolean value) {
      this.requestField("store_number", value);
      return this;
    }
    public APIRequestGetAgencyPages requestStudioField () {
      return this.requestStudioField(true);
    }
    public APIRequestGetAgencyPages requestStudioField (boolean value) {
      this.requestField("studio", value);
      return this;
    }
    public APIRequestGetAgencyPages requestSupportsInstantArticlesField () {
      return this.requestSupportsInstantArticlesField(true);
    }
    public APIRequestGetAgencyPages requestSupportsInstantArticlesField (boolean value) {
      this.requestField("supports_instant_articles", value);
      return this;
    }
    public APIRequestGetAgencyPages requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetAgencyPages requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
      return this;
    }
    public APIRequestGetAgencyPages requestUnreadMessageCountField () {
      return this.requestUnreadMessageCountField(true);
    }
    public APIRequestGetAgencyPages requestUnreadMessageCountField (boolean value) {
      this.requestField("unread_message_count", value);
      return this;
    }
    public APIRequestGetAgencyPages requestUnreadNotifCountField () {
      return this.requestUnreadNotifCountField(true);
    }
    public APIRequestGetAgencyPages requestUnreadNotifCountField (boolean value) {
      this.requestField("unread_notif_count", value);
      return this;
    }
    public APIRequestGetAgencyPages requestUnseenMessageCountField () {
      return this.requestUnseenMessageCountField(true);
    }
    public APIRequestGetAgencyPages requestUnseenMessageCountField (boolean value) {
      this.requestField("unseen_message_count", value);
      return this;
    }
    public APIRequestGetAgencyPages requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetAgencyPages requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetAgencyPages requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetAgencyPages requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetAgencyPages requestVoipInfoField () {
      return this.requestVoipInfoField(true);
    }
    public APIRequestGetAgencyPages requestVoipInfoField (boolean value) {
      this.requestField("voip_info", value);
      return this;
    }
    public APIRequestGetAgencyPages requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetAgencyPages requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetAgencyPages requestWereHereCountField () {
      return this.requestWereHereCountField(true);
    }
    public APIRequestGetAgencyPages requestWereHereCountField (boolean value) {
      this.requestField("were_here_count", value);
      return this;
    }
    public APIRequestGetAgencyPages requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGetAgencyPages requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
      return this;
    }
    public APIRequestGetAgencyPages requestWrittenByField () {
      return this.requestWrittenByField(true);
    }
    public APIRequestGetAgencyPages requestWrittenByField (boolean value) {
      this.requestField("written_by", value);
      return this;
    }
  }

  public static class APIRequestDeleteApps extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_id",
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
               return APIRequestDeleteApps.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteApps(String nodeId, APIContext context) {
      super(context, nodeId, "/apps", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteApps setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteApps setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteApps setAppId (Long appId) {
      this.setParam("app_id", appId);
      return this;
    }
    public APIRequestDeleteApps setAppId (String appId) {
      this.setParam("app_id", appId);
      return this;
    }

    public APIRequestDeleteApps requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteApps requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteApps requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteApps requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteApps requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteApps requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateApp extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "access_type",
      "app_id",
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
               return APIRequestCreateApp.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateApp(String nodeId, APIContext context) {
      super(context, nodeId, "/apps", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateApp setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateApp setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateApp setAccessType (EnumAccessType accessType) {
      this.setParam("access_type", accessType);
      return this;
    }
    public APIRequestCreateApp setAccessType (String accessType) {
      this.setParam("access_type", accessType);
      return this;
    }

    public APIRequestCreateApp setAppId (Object appId) {
      this.setParam("app_id", appId);
      return this;
    }
    public APIRequestCreateApp setAppId (String appId) {
      this.setParam("app_id", appId);
      return this;
    }

    public APIRequestCreateApp requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateApp requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateApp requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateApp requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateApp requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateApp requestField (String field, boolean value) {
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

  public static class APIRequestGetBusinessInvoices extends APIRequest<OracleTransaction> {

    APINodeList<OracleTransaction> lastResponse = null;
    @Override
    public APINodeList<OracleTransaction> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "end_date",
      "start_date",
    };

    public static final String[] FIELDS = {
      "ad_account_ids",
      "amount",
      "amount_due",
      "billed_amount_details",
      "billing_period",
      "currency",
      "download_uri",
      "due_date",
      "entity",
      "id",
      "invoice_date",
      "invoice_id",
      "invoice_type",
      "liability_type",
      "payment_status",
      "payment_term",
      "type",
    };

    @Override
    public APINodeList<OracleTransaction> parseResponse(String response) throws APIException {
      return OracleTransaction.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<OracleTransaction> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<OracleTransaction> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<OracleTransaction>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<OracleTransaction>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<OracleTransaction>>() {
           public APINodeList<OracleTransaction> apply(String result) {
             try {
               return APIRequestGetBusinessInvoices.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetBusinessInvoices(String nodeId, APIContext context) {
      super(context, nodeId, "/business_invoices", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBusinessInvoices setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBusinessInvoices setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBusinessInvoices setEndDate (String endDate) {
      this.setParam("end_date", endDate);
      return this;
    }

    public APIRequestGetBusinessInvoices setStartDate (String startDate) {
      this.setParam("start_date", startDate);
      return this;
    }

    public APIRequestGetBusinessInvoices requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBusinessInvoices requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessInvoices requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBusinessInvoices requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessInvoices requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBusinessInvoices requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBusinessInvoices requestAdAccountIdsField () {
      return this.requestAdAccountIdsField(true);
    }
    public APIRequestGetBusinessInvoices requestAdAccountIdsField (boolean value) {
      this.requestField("ad_account_ids", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestAmountField () {
      return this.requestAmountField(true);
    }
    public APIRequestGetBusinessInvoices requestAmountField (boolean value) {
      this.requestField("amount", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestAmountDueField () {
      return this.requestAmountDueField(true);
    }
    public APIRequestGetBusinessInvoices requestAmountDueField (boolean value) {
      this.requestField("amount_due", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestBilledAmountDetailsField () {
      return this.requestBilledAmountDetailsField(true);
    }
    public APIRequestGetBusinessInvoices requestBilledAmountDetailsField (boolean value) {
      this.requestField("billed_amount_details", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestBillingPeriodField () {
      return this.requestBillingPeriodField(true);
    }
    public APIRequestGetBusinessInvoices requestBillingPeriodField (boolean value) {
      this.requestField("billing_period", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetBusinessInvoices requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestDownloadUriField () {
      return this.requestDownloadUriField(true);
    }
    public APIRequestGetBusinessInvoices requestDownloadUriField (boolean value) {
      this.requestField("download_uri", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestDueDateField () {
      return this.requestDueDateField(true);
    }
    public APIRequestGetBusinessInvoices requestDueDateField (boolean value) {
      this.requestField("due_date", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestEntityField () {
      return this.requestEntityField(true);
    }
    public APIRequestGetBusinessInvoices requestEntityField (boolean value) {
      this.requestField("entity", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBusinessInvoices requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestInvoiceDateField () {
      return this.requestInvoiceDateField(true);
    }
    public APIRequestGetBusinessInvoices requestInvoiceDateField (boolean value) {
      this.requestField("invoice_date", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestInvoiceIdField () {
      return this.requestInvoiceIdField(true);
    }
    public APIRequestGetBusinessInvoices requestInvoiceIdField (boolean value) {
      this.requestField("invoice_id", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestInvoiceTypeField () {
      return this.requestInvoiceTypeField(true);
    }
    public APIRequestGetBusinessInvoices requestInvoiceTypeField (boolean value) {
      this.requestField("invoice_type", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestLiabilityTypeField () {
      return this.requestLiabilityTypeField(true);
    }
    public APIRequestGetBusinessInvoices requestLiabilityTypeField (boolean value) {
      this.requestField("liability_type", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestPaymentStatusField () {
      return this.requestPaymentStatusField(true);
    }
    public APIRequestGetBusinessInvoices requestPaymentStatusField (boolean value) {
      this.requestField("payment_status", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestPaymentTermField () {
      return this.requestPaymentTermField(true);
    }
    public APIRequestGetBusinessInvoices requestPaymentTermField (boolean value) {
      this.requestField("payment_term", value);
      return this;
    }
    public APIRequestGetBusinessInvoices requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetBusinessInvoices requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
  }

  public static class APIRequestGetBusinessUsers extends APIRequest<BusinessUser> {

    APINodeList<BusinessUser> lastResponse = null;
    @Override
    public APINodeList<BusinessUser> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "email",
      "finance_permission",
      "first_name",
      "id",
      "ip_permission",
      "last_name",
      "marked_for_removal",
      "name",
      "pending_email",
      "role",
      "title",
      "two_fac_status",
    };

    @Override
    public APINodeList<BusinessUser> parseResponse(String response) throws APIException {
      return BusinessUser.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessUser> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessUser> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessUser>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessUser>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessUser>>() {
           public APINodeList<BusinessUser> apply(String result) {
             try {
               return APIRequestGetBusinessUsers.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetBusinessUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/business_users", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBusinessUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBusinessUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBusinessUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBusinessUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBusinessUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBusinessUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBusinessUsers requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetBusinessUsers requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetBusinessUsers requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestFinancePermissionField () {
      return this.requestFinancePermissionField(true);
    }
    public APIRequestGetBusinessUsers requestFinancePermissionField (boolean value) {
      this.requestField("finance_permission", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetBusinessUsers requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBusinessUsers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestIpPermissionField () {
      return this.requestIpPermissionField(true);
    }
    public APIRequestGetBusinessUsers requestIpPermissionField (boolean value) {
      this.requestField("ip_permission", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetBusinessUsers requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestMarkedForRemovalField () {
      return this.requestMarkedForRemovalField(true);
    }
    public APIRequestGetBusinessUsers requestMarkedForRemovalField (boolean value) {
      this.requestField("marked_for_removal", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetBusinessUsers requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestPendingEmailField () {
      return this.requestPendingEmailField(true);
    }
    public APIRequestGetBusinessUsers requestPendingEmailField (boolean value) {
      this.requestField("pending_email", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestRoleField () {
      return this.requestRoleField(true);
    }
    public APIRequestGetBusinessUsers requestRoleField (boolean value) {
      this.requestField("role", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetBusinessUsers requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetBusinessUsers requestTwoFacStatusField () {
      return this.requestTwoFacStatusField(true);
    }
    public APIRequestGetBusinessUsers requestTwoFacStatusField (boolean value) {
      this.requestField("two_fac_status", value);
      return this;
    }
  }

  public static class APIRequestCreateBusinessUser extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "email",
      "role",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestCreateBusinessUser.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateBusinessUser(String nodeId, APIContext context) {
      super(context, nodeId, "/business_users", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateBusinessUser setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateBusinessUser setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateBusinessUser setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestCreateBusinessUser setRole (Business.EnumRole role) {
      this.setParam("role", role);
      return this;
    }
    public APIRequestCreateBusinessUser setRole (String role) {
      this.setParam("role", role);
      return this;
    }

    public APIRequestCreateBusinessUser requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateBusinessUser requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBusinessUser requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateBusinessUser requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateBusinessUser requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateBusinessUser requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetBusinessProjects extends APIRequest<BusinessProject> {

    APINodeList<BusinessProject> lastResponse = null;
    @Override
    public APINodeList<BusinessProject> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "created_time",
      "creator",
      "id",
      "name",
    };

    @Override
    public APINodeList<BusinessProject> parseResponse(String response) throws APIException {
      return BusinessProject.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessProject> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessProject> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessProject>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessProject>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessProject>>() {
           public APINodeList<BusinessProject> apply(String result) {
             try {
               return APIRequestGetBusinessProjects.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetBusinessProjects(String nodeId, APIContext context) {
      super(context, nodeId, "/businessprojects", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBusinessProjects setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBusinessProjects setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBusinessProjects requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBusinessProjects requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessProjects requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBusinessProjects requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessProjects requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBusinessProjects requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBusinessProjects requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetBusinessProjects requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetBusinessProjects requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetBusinessProjects requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetBusinessProjects requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetBusinessProjects requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetBusinessProjects requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBusinessProjects requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBusinessProjects requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetBusinessProjects requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
  }

  public static class APIRequestGetClientAdAccounts extends APIRequest<AdAccount> {

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
               return APIRequestGetClientAdAccounts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetClientAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/client_ad_accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetClientAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetClientAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetClientAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetClientAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetClientAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientAdAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetClientAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetClientAdAccounts requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetClientAdAccounts requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAccountStatusField () {
      return this.requestAccountStatusField(true);
    }
    public APIRequestGetClientAdAccounts requestAccountStatusField (boolean value) {
      this.requestField("account_status", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAgeField () {
      return this.requestAgeField(true);
    }
    public APIRequestGetClientAdAccounts requestAgeField (boolean value) {
      this.requestField("age", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAgencyClientDeclarationField () {
      return this.requestAgencyClientDeclarationField(true);
    }
    public APIRequestGetClientAdAccounts requestAgencyClientDeclarationField (boolean value) {
      this.requestField("agency_client_declaration", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAmountSpentField () {
      return this.requestAmountSpentField(true);
    }
    public APIRequestGetClientAdAccounts requestAmountSpentField (boolean value) {
      this.requestField("amount_spent", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGetClientAdAccounts requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBalanceField () {
      return this.requestBalanceField(true);
    }
    public APIRequestGetClientAdAccounts requestBalanceField (boolean value) {
      this.requestField("balance", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessCityField () {
      return this.requestBusinessCityField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessCityField (boolean value) {
      this.requestField("business_city", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessCountryCodeField () {
      return this.requestBusinessCountryCodeField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessCountryCodeField (boolean value) {
      this.requestField("business_country_code", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessNameField () {
      return this.requestBusinessNameField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessNameField (boolean value) {
      this.requestField("business_name", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessStateField () {
      return this.requestBusinessStateField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessStateField (boolean value) {
      this.requestField("business_state", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessStreetField () {
      return this.requestBusinessStreetField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessStreetField (boolean value) {
      this.requestField("business_street", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessStreet2Field () {
      return this.requestBusinessStreet2Field(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessStreet2Field (boolean value) {
      this.requestField("business_street2", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestBusinessZipField () {
      return this.requestBusinessZipField(true);
    }
    public APIRequestGetClientAdAccounts requestBusinessZipField (boolean value) {
      this.requestField("business_zip", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestCapabilitiesField () {
      return this.requestCapabilitiesField(true);
    }
    public APIRequestGetClientAdAccounts requestCapabilitiesField (boolean value) {
      this.requestField("capabilities", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetClientAdAccounts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetClientAdAccounts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestDisableReasonField () {
      return this.requestDisableReasonField(true);
    }
    public APIRequestGetClientAdAccounts requestDisableReasonField (boolean value) {
      this.requestField("disable_reason", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestEndAdvertiserField () {
      return this.requestEndAdvertiserField(true);
    }
    public APIRequestGetClientAdAccounts requestEndAdvertiserField (boolean value) {
      this.requestField("end_advertiser", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestEndAdvertiserNameField () {
      return this.requestEndAdvertiserNameField(true);
    }
    public APIRequestGetClientAdAccounts requestEndAdvertiserNameField (boolean value) {
      this.requestField("end_advertiser_name", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestExtendedCreditInvoiceGroupField () {
      return this.requestExtendedCreditInvoiceGroupField(true);
    }
    public APIRequestGetClientAdAccounts requestExtendedCreditInvoiceGroupField (boolean value) {
      this.requestField("extended_credit_invoice_group", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetClientAdAccounts requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestFundingSourceField () {
      return this.requestFundingSourceField(true);
    }
    public APIRequestGetClientAdAccounts requestFundingSourceField (boolean value) {
      this.requestField("funding_source", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestFundingSourceDetailsField () {
      return this.requestFundingSourceDetailsField(true);
    }
    public APIRequestGetClientAdAccounts requestFundingSourceDetailsField (boolean value) {
      this.requestField("funding_source_details", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestHasMigratedPermissionsField () {
      return this.requestHasMigratedPermissionsField(true);
    }
    public APIRequestGetClientAdAccounts requestHasMigratedPermissionsField (boolean value) {
      this.requestField("has_migrated_permissions", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestHasPageAuthorizedAdaccountField () {
      return this.requestHasPageAuthorizedAdaccountField(true);
    }
    public APIRequestGetClientAdAccounts requestHasPageAuthorizedAdaccountField (boolean value) {
      this.requestField("has_page_authorized_adaccount", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClientAdAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGetClientAdAccounts requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsAttributionSpecSystemDefaultField () {
      return this.requestIsAttributionSpecSystemDefaultField(true);
    }
    public APIRequestGetClientAdAccounts requestIsAttributionSpecSystemDefaultField (boolean value) {
      this.requestField("is_attribution_spec_system_default", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsDirectDealsEnabledField () {
      return this.requestIsDirectDealsEnabledField(true);
    }
    public APIRequestGetClientAdAccounts requestIsDirectDealsEnabledField (boolean value) {
      this.requestField("is_direct_deals_enabled", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsInMiddleOfLocalEntityMigrationField () {
      return this.requestIsInMiddleOfLocalEntityMigrationField(true);
    }
    public APIRequestGetClientAdAccounts requestIsInMiddleOfLocalEntityMigrationField (boolean value) {
      this.requestField("is_in_middle_of_local_entity_migration", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsNotificationsEnabledField () {
      return this.requestIsNotificationsEnabledField(true);
    }
    public APIRequestGetClientAdAccounts requestIsNotificationsEnabledField (boolean value) {
      this.requestField("is_notifications_enabled", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsPersonalField () {
      return this.requestIsPersonalField(true);
    }
    public APIRequestGetClientAdAccounts requestIsPersonalField (boolean value) {
      this.requestField("is_personal", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsPrepayAccountField () {
      return this.requestIsPrepayAccountField(true);
    }
    public APIRequestGetClientAdAccounts requestIsPrepayAccountField (boolean value) {
      this.requestField("is_prepay_account", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestIsTaxIdRequiredField () {
      return this.requestIsTaxIdRequiredField(true);
    }
    public APIRequestGetClientAdAccounts requestIsTaxIdRequiredField (boolean value) {
      this.requestField("is_tax_id_required", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestLineNumbersField () {
      return this.requestLineNumbersField(true);
    }
    public APIRequestGetClientAdAccounts requestLineNumbersField (boolean value) {
      this.requestField("line_numbers", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestMediaAgencyField () {
      return this.requestMediaAgencyField(true);
    }
    public APIRequestGetClientAdAccounts requestMediaAgencyField (boolean value) {
      this.requestField("media_agency", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestMinCampaignGroupSpendCapField () {
      return this.requestMinCampaignGroupSpendCapField(true);
    }
    public APIRequestGetClientAdAccounts requestMinCampaignGroupSpendCapField (boolean value) {
      this.requestField("min_campaign_group_spend_cap", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestMinDailyBudgetField () {
      return this.requestMinDailyBudgetField(true);
    }
    public APIRequestGetClientAdAccounts requestMinDailyBudgetField (boolean value) {
      this.requestField("min_daily_budget", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetClientAdAccounts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestOffsitePixelsTosAcceptedField () {
      return this.requestOffsitePixelsTosAcceptedField(true);
    }
    public APIRequestGetClientAdAccounts requestOffsitePixelsTosAcceptedField (boolean value) {
      this.requestField("offsite_pixels_tos_accepted", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetClientAdAccounts requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetClientAdAccounts requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestRateLimitResetTimeField () {
      return this.requestRateLimitResetTimeField(true);
    }
    public APIRequestGetClientAdAccounts requestRateLimitResetTimeField (boolean value) {
      this.requestField("rate_limit_reset_time", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGetClientAdAccounts requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestShowCheckoutExperienceField () {
      return this.requestShowCheckoutExperienceField(true);
    }
    public APIRequestGetClientAdAccounts requestShowCheckoutExperienceField (boolean value) {
      this.requestField("show_checkout_experience", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetClientAdAccounts requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTaxIdField () {
      return this.requestTaxIdField(true);
    }
    public APIRequestGetClientAdAccounts requestTaxIdField (boolean value) {
      this.requestField("tax_id", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTaxIdStatusField () {
      return this.requestTaxIdStatusField(true);
    }
    public APIRequestGetClientAdAccounts requestTaxIdStatusField (boolean value) {
      this.requestField("tax_id_status", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTaxIdTypeField () {
      return this.requestTaxIdTypeField(true);
    }
    public APIRequestGetClientAdAccounts requestTaxIdTypeField (boolean value) {
      this.requestField("tax_id_type", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetClientAdAccounts requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTimezoneNameField () {
      return this.requestTimezoneNameField(true);
    }
    public APIRequestGetClientAdAccounts requestTimezoneNameField (boolean value) {
      this.requestField("timezone_name", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTimezoneOffsetHoursUtcField () {
      return this.requestTimezoneOffsetHoursUtcField(true);
    }
    public APIRequestGetClientAdAccounts requestTimezoneOffsetHoursUtcField (boolean value) {
      this.requestField("timezone_offset_hours_utc", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestTosAcceptedField () {
      return this.requestTosAcceptedField(true);
    }
    public APIRequestGetClientAdAccounts requestTosAcceptedField (boolean value) {
      this.requestField("tos_accepted", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestUserRoleField () {
      return this.requestUserRoleField(true);
    }
    public APIRequestGetClientAdAccounts requestUserRoleField (boolean value) {
      this.requestField("user_role", value);
      return this;
    }
    public APIRequestGetClientAdAccounts requestUserTosAcceptedField () {
      return this.requestUserTosAcceptedField(true);
    }
    public APIRequestGetClientAdAccounts requestUserTosAcceptedField (boolean value) {
      this.requestField("user_tos_accepted", value);
      return this;
    }
  }

  public static class APIRequestCreateClientAdAccount extends APIRequest<AdAccount> {

    AdAccount lastResponse = null;
    @Override
    public AdAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adaccount_id",
      "permitted_tasks",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdAccount parseResponse(String response) throws APIException {
      return AdAccount.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAccount execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccount execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdAccount> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccount> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdAccount>() {
           public AdAccount apply(String result) {
             try {
               return APIRequestCreateClientAdAccount.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateClientAdAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/client_ad_accounts", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateClientAdAccount setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateClientAdAccount setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateClientAdAccount setAdaccountId (String adaccountId) {
      this.setParam("adaccount_id", adaccountId);
      return this;
    }

    public APIRequestCreateClientAdAccount setPermittedTasks (List<AdAccount.EnumPermittedTasks> permittedTasks) {
      this.setParam("permitted_tasks", permittedTasks);
      return this;
    }
    public APIRequestCreateClientAdAccount setPermittedTasks (String permittedTasks) {
      this.setParam("permitted_tasks", permittedTasks);
      return this;
    }

    public APIRequestCreateClientAdAccount requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateClientAdAccount requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateClientAdAccount requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateClientAdAccount requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateClientAdAccount requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateClientAdAccount requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetClientApps extends APIRequest<APINode> {

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
               return APIRequestGetClientApps.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetClientApps(String nodeId, APIContext context) {
      super(context, nodeId, "/client_apps", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetClientApps setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetClientApps setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetClientApps requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetClientApps requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientApps requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetClientApps requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientApps requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetClientApps requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateClientApp extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_id",
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
               return APIRequestCreateClientApp.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateClientApp(String nodeId, APIContext context) {
      super(context, nodeId, "/client_apps", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateClientApp setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateClientApp setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateClientApp setAppId (Object appId) {
      this.setParam("app_id", appId);
      return this;
    }
    public APIRequestCreateClientApp setAppId (String appId) {
      this.setParam("app_id", appId);
      return this;
    }

    public APIRequestCreateClientApp requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateClientApp requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateClientApp requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateClientApp requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateClientApp requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateClientApp requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetClientPages extends APIRequest<Page> {

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
               return APIRequestGetClientPages.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetClientPages(String nodeId, APIContext context) {
      super(context, nodeId, "/client_pages", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetClientPages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetClientPages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetClientPages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetClientPages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientPages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetClientPages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientPages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetClientPages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetClientPages requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetClientPages requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetClientPages requestAccessTokenField () {
      return this.requestAccessTokenField(true);
    }
    public APIRequestGetClientPages requestAccessTokenField (boolean value) {
      this.requestField("access_token", value);
      return this;
    }
    public APIRequestGetClientPages requestAdCampaignField () {
      return this.requestAdCampaignField(true);
    }
    public APIRequestGetClientPages requestAdCampaignField (boolean value) {
      this.requestField("ad_campaign", value);
      return this;
    }
    public APIRequestGetClientPages requestAffiliationField () {
      return this.requestAffiliationField(true);
    }
    public APIRequestGetClientPages requestAffiliationField (boolean value) {
      this.requestField("affiliation", value);
      return this;
    }
    public APIRequestGetClientPages requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetClientPages requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetClientPages requestAppLinksField () {
      return this.requestAppLinksField(true);
    }
    public APIRequestGetClientPages requestAppLinksField (boolean value) {
      this.requestField("app_links", value);
      return this;
    }
    public APIRequestGetClientPages requestArtistsWeLikeField () {
      return this.requestArtistsWeLikeField(true);
    }
    public APIRequestGetClientPages requestArtistsWeLikeField (boolean value) {
      this.requestField("artists_we_like", value);
      return this;
    }
    public APIRequestGetClientPages requestAttireField () {
      return this.requestAttireField(true);
    }
    public APIRequestGetClientPages requestAttireField (boolean value) {
      this.requestField("attire", value);
      return this;
    }
    public APIRequestGetClientPages requestAwardsField () {
      return this.requestAwardsField(true);
    }
    public APIRequestGetClientPages requestAwardsField (boolean value) {
      this.requestField("awards", value);
      return this;
    }
    public APIRequestGetClientPages requestBandInterestsField () {
      return this.requestBandInterestsField(true);
    }
    public APIRequestGetClientPages requestBandInterestsField (boolean value) {
      this.requestField("band_interests", value);
      return this;
    }
    public APIRequestGetClientPages requestBandMembersField () {
      return this.requestBandMembersField(true);
    }
    public APIRequestGetClientPages requestBandMembersField (boolean value) {
      this.requestField("band_members", value);
      return this;
    }
    public APIRequestGetClientPages requestBestPageField () {
      return this.requestBestPageField(true);
    }
    public APIRequestGetClientPages requestBestPageField (boolean value) {
      this.requestField("best_page", value);
      return this;
    }
    public APIRequestGetClientPages requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetClientPages requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetClientPages requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetClientPages requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetClientPages requestBookingAgentField () {
      return this.requestBookingAgentField(true);
    }
    public APIRequestGetClientPages requestBookingAgentField (boolean value) {
      this.requestField("booking_agent", value);
      return this;
    }
    public APIRequestGetClientPages requestBuiltField () {
      return this.requestBuiltField(true);
    }
    public APIRequestGetClientPages requestBuiltField (boolean value) {
      this.requestField("built", value);
      return this;
    }
    public APIRequestGetClientPages requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetClientPages requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetClientPages requestCanCheckinField () {
      return this.requestCanCheckinField(true);
    }
    public APIRequestGetClientPages requestCanCheckinField (boolean value) {
      this.requestField("can_checkin", value);
      return this;
    }
    public APIRequestGetClientPages requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetClientPages requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetClientPages requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetClientPages requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetClientPages requestCategoryListField () {
      return this.requestCategoryListField(true);
    }
    public APIRequestGetClientPages requestCategoryListField (boolean value) {
      this.requestField("category_list", value);
      return this;
    }
    public APIRequestGetClientPages requestCheckinsField () {
      return this.requestCheckinsField(true);
    }
    public APIRequestGetClientPages requestCheckinsField (boolean value) {
      this.requestField("checkins", value);
      return this;
    }
    public APIRequestGetClientPages requestCompanyOverviewField () {
      return this.requestCompanyOverviewField(true);
    }
    public APIRequestGetClientPages requestCompanyOverviewField (boolean value) {
      this.requestField("company_overview", value);
      return this;
    }
    public APIRequestGetClientPages requestConnectedInstagramAccountField () {
      return this.requestConnectedInstagramAccountField(true);
    }
    public APIRequestGetClientPages requestConnectedInstagramAccountField (boolean value) {
      this.requestField("connected_instagram_account", value);
      return this;
    }
    public APIRequestGetClientPages requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetClientPages requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetClientPages requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetClientPages requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetClientPages requestCopyrightAttributionInsightsField () {
      return this.requestCopyrightAttributionInsightsField(true);
    }
    public APIRequestGetClientPages requestCopyrightAttributionInsightsField (boolean value) {
      this.requestField("copyright_attribution_insights", value);
      return this;
    }
    public APIRequestGetClientPages requestCopyrightWhitelistedIgPartnersField () {
      return this.requestCopyrightWhitelistedIgPartnersField(true);
    }
    public APIRequestGetClientPages requestCopyrightWhitelistedIgPartnersField (boolean value) {
      this.requestField("copyright_whitelisted_ig_partners", value);
      return this;
    }
    public APIRequestGetClientPages requestCountryPageLikesField () {
      return this.requestCountryPageLikesField(true);
    }
    public APIRequestGetClientPages requestCountryPageLikesField (boolean value) {
      this.requestField("country_page_likes", value);
      return this;
    }
    public APIRequestGetClientPages requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetClientPages requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetClientPages requestCulinaryTeamField () {
      return this.requestCulinaryTeamField(true);
    }
    public APIRequestGetClientPages requestCulinaryTeamField (boolean value) {
      this.requestField("culinary_team", value);
      return this;
    }
    public APIRequestGetClientPages requestCurrentLocationField () {
      return this.requestCurrentLocationField(true);
    }
    public APIRequestGetClientPages requestCurrentLocationField (boolean value) {
      this.requestField("current_location", value);
      return this;
    }
    public APIRequestGetClientPages requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetClientPages requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetClientPages requestDescriptionHtmlField () {
      return this.requestDescriptionHtmlField(true);
    }
    public APIRequestGetClientPages requestDescriptionHtmlField (boolean value) {
      this.requestField("description_html", value);
      return this;
    }
    public APIRequestGetClientPages requestDirectedByField () {
      return this.requestDirectedByField(true);
    }
    public APIRequestGetClientPages requestDirectedByField (boolean value) {
      this.requestField("directed_by", value);
      return this;
    }
    public APIRequestGetClientPages requestDisplaySubtextField () {
      return this.requestDisplaySubtextField(true);
    }
    public APIRequestGetClientPages requestDisplaySubtextField (boolean value) {
      this.requestField("display_subtext", value);
      return this;
    }
    public APIRequestGetClientPages requestDisplayedMessageResponseTimeField () {
      return this.requestDisplayedMessageResponseTimeField(true);
    }
    public APIRequestGetClientPages requestDisplayedMessageResponseTimeField (boolean value) {
      this.requestField("displayed_message_response_time", value);
      return this;
    }
    public APIRequestGetClientPages requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetClientPages requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetClientPages requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGetClientPages requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGetClientPages requestFanCountField () {
      return this.requestFanCountField(true);
    }
    public APIRequestGetClientPages requestFanCountField (boolean value) {
      this.requestField("fan_count", value);
      return this;
    }
    public APIRequestGetClientPages requestFeaturedVideoField () {
      return this.requestFeaturedVideoField(true);
    }
    public APIRequestGetClientPages requestFeaturedVideoField (boolean value) {
      this.requestField("featured_video", value);
      return this;
    }
    public APIRequestGetClientPages requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetClientPages requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetClientPages requestFoodStylesField () {
      return this.requestFoodStylesField(true);
    }
    public APIRequestGetClientPages requestFoodStylesField (boolean value) {
      this.requestField("food_styles", value);
      return this;
    }
    public APIRequestGetClientPages requestFoundedField () {
      return this.requestFoundedField(true);
    }
    public APIRequestGetClientPages requestFoundedField (boolean value) {
      this.requestField("founded", value);
      return this;
    }
    public APIRequestGetClientPages requestGeneralInfoField () {
      return this.requestGeneralInfoField(true);
    }
    public APIRequestGetClientPages requestGeneralInfoField (boolean value) {
      this.requestField("general_info", value);
      return this;
    }
    public APIRequestGetClientPages requestGeneralManagerField () {
      return this.requestGeneralManagerField(true);
    }
    public APIRequestGetClientPages requestGeneralManagerField (boolean value) {
      this.requestField("general_manager", value);
      return this;
    }
    public APIRequestGetClientPages requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGetClientPages requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGetClientPages requestGlobalBrandPageNameField () {
      return this.requestGlobalBrandPageNameField(true);
    }
    public APIRequestGetClientPages requestGlobalBrandPageNameField (boolean value) {
      this.requestField("global_brand_page_name", value);
      return this;
    }
    public APIRequestGetClientPages requestGlobalBrandRootIdField () {
      return this.requestGlobalBrandRootIdField(true);
    }
    public APIRequestGetClientPages requestGlobalBrandRootIdField (boolean value) {
      this.requestField("global_brand_root_id", value);
      return this;
    }
    public APIRequestGetClientPages requestHasAddedAppField () {
      return this.requestHasAddedAppField(true);
    }
    public APIRequestGetClientPages requestHasAddedAppField (boolean value) {
      this.requestField("has_added_app", value);
      return this;
    }
    public APIRequestGetClientPages requestHasWhatsappNumberField () {
      return this.requestHasWhatsappNumberField(true);
    }
    public APIRequestGetClientPages requestHasWhatsappNumberField (boolean value) {
      this.requestField("has_whatsapp_number", value);
      return this;
    }
    public APIRequestGetClientPages requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetClientPages requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetClientPages requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGetClientPages requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGetClientPages requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClientPages requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetClientPages requestImpressumField () {
      return this.requestImpressumField(true);
    }
    public APIRequestGetClientPages requestImpressumField (boolean value) {
      this.requestField("impressum", value);
      return this;
    }
    public APIRequestGetClientPages requestInfluencesField () {
      return this.requestInfluencesField(true);
    }
    public APIRequestGetClientPages requestInfluencesField (boolean value) {
      this.requestField("influences", value);
      return this;
    }
    public APIRequestGetClientPages requestInstagramBusinessAccountField () {
      return this.requestInstagramBusinessAccountField(true);
    }
    public APIRequestGetClientPages requestInstagramBusinessAccountField (boolean value) {
      this.requestField("instagram_business_account", value);
      return this;
    }
    public APIRequestGetClientPages requestInstantArticlesReviewStatusField () {
      return this.requestInstantArticlesReviewStatusField(true);
    }
    public APIRequestGetClientPages requestInstantArticlesReviewStatusField (boolean value) {
      this.requestField("instant_articles_review_status", value);
      return this;
    }
    public APIRequestGetClientPages requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetClientPages requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
      return this;
    }
    public APIRequestGetClientPages requestIsChainField () {
      return this.requestIsChainField(true);
    }
    public APIRequestGetClientPages requestIsChainField (boolean value) {
      this.requestField("is_chain", value);
      return this;
    }
    public APIRequestGetClientPages requestIsCommunityPageField () {
      return this.requestIsCommunityPageField(true);
    }
    public APIRequestGetClientPages requestIsCommunityPageField (boolean value) {
      this.requestField("is_community_page", value);
      return this;
    }
    public APIRequestGetClientPages requestIsEligibleForBrandedContentField () {
      return this.requestIsEligibleForBrandedContentField(true);
    }
    public APIRequestGetClientPages requestIsEligibleForBrandedContentField (boolean value) {
      this.requestField("is_eligible_for_branded_content", value);
      return this;
    }
    public APIRequestGetClientPages requestIsMessengerBotGetStartedEnabledField () {
      return this.requestIsMessengerBotGetStartedEnabledField(true);
    }
    public APIRequestGetClientPages requestIsMessengerBotGetStartedEnabledField (boolean value) {
      this.requestField("is_messenger_bot_get_started_enabled", value);
      return this;
    }
    public APIRequestGetClientPages requestIsMessengerPlatformBotField () {
      return this.requestIsMessengerPlatformBotField(true);
    }
    public APIRequestGetClientPages requestIsMessengerPlatformBotField (boolean value) {
      this.requestField("is_messenger_platform_bot", value);
      return this;
    }
    public APIRequestGetClientPages requestIsOwnedField () {
      return this.requestIsOwnedField(true);
    }
    public APIRequestGetClientPages requestIsOwnedField (boolean value) {
      this.requestField("is_owned", value);
      return this;
    }
    public APIRequestGetClientPages requestIsPermanentlyClosedField () {
      return this.requestIsPermanentlyClosedField(true);
    }
    public APIRequestGetClientPages requestIsPermanentlyClosedField (boolean value) {
      this.requestField("is_permanently_closed", value);
      return this;
    }
    public APIRequestGetClientPages requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetClientPages requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetClientPages requestIsUnclaimedField () {
      return this.requestIsUnclaimedField(true);
    }
    public APIRequestGetClientPages requestIsUnclaimedField (boolean value) {
      this.requestField("is_unclaimed", value);
      return this;
    }
    public APIRequestGetClientPages requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetClientPages requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetClientPages requestIsWebhooksSubscribedField () {
      return this.requestIsWebhooksSubscribedField(true);
    }
    public APIRequestGetClientPages requestIsWebhooksSubscribedField (boolean value) {
      this.requestField("is_webhooks_subscribed", value);
      return this;
    }
    public APIRequestGetClientPages requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGetClientPages requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGetClientPages requestLeadgenFormPreviewDetailsField () {
      return this.requestLeadgenFormPreviewDetailsField(true);
    }
    public APIRequestGetClientPages requestLeadgenFormPreviewDetailsField (boolean value) {
      this.requestField("leadgen_form_preview_details", value);
      return this;
    }
    public APIRequestGetClientPages requestLeadgenHasCrmIntegrationField () {
      return this.requestLeadgenHasCrmIntegrationField(true);
    }
    public APIRequestGetClientPages requestLeadgenHasCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_crm_integration", value);
      return this;
    }
    public APIRequestGetClientPages requestLeadgenHasFatPingCrmIntegrationField () {
      return this.requestLeadgenHasFatPingCrmIntegrationField(true);
    }
    public APIRequestGetClientPages requestLeadgenHasFatPingCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_fat_ping_crm_integration", value);
      return this;
    }
    public APIRequestGetClientPages requestLeadgenTosAcceptanceTimeField () {
      return this.requestLeadgenTosAcceptanceTimeField(true);
    }
    public APIRequestGetClientPages requestLeadgenTosAcceptanceTimeField (boolean value) {
      this.requestField("leadgen_tos_acceptance_time", value);
      return this;
    }
    public APIRequestGetClientPages requestLeadgenTosAcceptedField () {
      return this.requestLeadgenTosAcceptedField(true);
    }
    public APIRequestGetClientPages requestLeadgenTosAcceptedField (boolean value) {
      this.requestField("leadgen_tos_accepted", value);
      return this;
    }
    public APIRequestGetClientPages requestLeadgenTosAcceptingUserField () {
      return this.requestLeadgenTosAcceptingUserField(true);
    }
    public APIRequestGetClientPages requestLeadgenTosAcceptingUserField (boolean value) {
      this.requestField("leadgen_tos_accepting_user", value);
      return this;
    }
    public APIRequestGetClientPages requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetClientPages requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetClientPages requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetClientPages requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetClientPages requestMembersField () {
      return this.requestMembersField(true);
    }
    public APIRequestGetClientPages requestMembersField (boolean value) {
      this.requestField("members", value);
      return this;
    }
    public APIRequestGetClientPages requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetClientPages requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetClientPages requestMerchantReviewStatusField () {
      return this.requestMerchantReviewStatusField(true);
    }
    public APIRequestGetClientPages requestMerchantReviewStatusField (boolean value) {
      this.requestField("merchant_review_status", value);
      return this;
    }
    public APIRequestGetClientPages requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetClientPages requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetClientPages requestMessengerAdsDefaultPageWelcomeMessageField () {
      return this.requestMessengerAdsDefaultPageWelcomeMessageField(true);
    }
    public APIRequestGetClientPages requestMessengerAdsDefaultPageWelcomeMessageField (boolean value) {
      this.requestField("messenger_ads_default_page_welcome_message", value);
      return this;
    }
    public APIRequestGetClientPages requestMessengerAdsDefaultQuickRepliesField () {
      return this.requestMessengerAdsDefaultQuickRepliesField(true);
    }
    public APIRequestGetClientPages requestMessengerAdsDefaultQuickRepliesField (boolean value) {
      this.requestField("messenger_ads_default_quick_replies", value);
      return this;
    }
    public APIRequestGetClientPages requestMessengerAdsQuickRepliesTypeField () {
      return this.requestMessengerAdsQuickRepliesTypeField(true);
    }
    public APIRequestGetClientPages requestMessengerAdsQuickRepliesTypeField (boolean value) {
      this.requestField("messenger_ads_quick_replies_type", value);
      return this;
    }
    public APIRequestGetClientPages requestMissionField () {
      return this.requestMissionField(true);
    }
    public APIRequestGetClientPages requestMissionField (boolean value) {
      this.requestField("mission", value);
      return this;
    }
    public APIRequestGetClientPages requestMpgField () {
      return this.requestMpgField(true);
    }
    public APIRequestGetClientPages requestMpgField (boolean value) {
      this.requestField("mpg", value);
      return this;
    }
    public APIRequestGetClientPages requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetClientPages requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetClientPages requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGetClientPages requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGetClientPages requestNetworkField () {
      return this.requestNetworkField(true);
    }
    public APIRequestGetClientPages requestNetworkField (boolean value) {
      this.requestField("network", value);
      return this;
    }
    public APIRequestGetClientPages requestNewLikeCountField () {
      return this.requestNewLikeCountField(true);
    }
    public APIRequestGetClientPages requestNewLikeCountField (boolean value) {
      this.requestField("new_like_count", value);
      return this;
    }
    public APIRequestGetClientPages requestOfferEligibleField () {
      return this.requestOfferEligibleField(true);
    }
    public APIRequestGetClientPages requestOfferEligibleField (boolean value) {
      this.requestField("offer_eligible", value);
      return this;
    }
    public APIRequestGetClientPages requestOverallStarRatingField () {
      return this.requestOverallStarRatingField(true);
    }
    public APIRequestGetClientPages requestOverallStarRatingField (boolean value) {
      this.requestField("overall_star_rating", value);
      return this;
    }
    public APIRequestGetClientPages requestPageTokenField () {
      return this.requestPageTokenField(true);
    }
    public APIRequestGetClientPages requestPageTokenField (boolean value) {
      this.requestField("page_token", value);
      return this;
    }
    public APIRequestGetClientPages requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetClientPages requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGetClientPages requestParkingField () {
      return this.requestParkingField(true);
    }
    public APIRequestGetClientPages requestParkingField (boolean value) {
      this.requestField("parking", value);
      return this;
    }
    public APIRequestGetClientPages requestPaymentOptionsField () {
      return this.requestPaymentOptionsField(true);
    }
    public APIRequestGetClientPages requestPaymentOptionsField (boolean value) {
      this.requestField("payment_options", value);
      return this;
    }
    public APIRequestGetClientPages requestPersonalInfoField () {
      return this.requestPersonalInfoField(true);
    }
    public APIRequestGetClientPages requestPersonalInfoField (boolean value) {
      this.requestField("personal_info", value);
      return this;
    }
    public APIRequestGetClientPages requestPersonalInterestsField () {
      return this.requestPersonalInterestsField(true);
    }
    public APIRequestGetClientPages requestPersonalInterestsField (boolean value) {
      this.requestField("personal_interests", value);
      return this;
    }
    public APIRequestGetClientPages requestPharmaSafetyInfoField () {
      return this.requestPharmaSafetyInfoField(true);
    }
    public APIRequestGetClientPages requestPharmaSafetyInfoField (boolean value) {
      this.requestField("pharma_safety_info", value);
      return this;
    }
    public APIRequestGetClientPages requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetClientPages requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetClientPages requestPlaceTypeField () {
      return this.requestPlaceTypeField(true);
    }
    public APIRequestGetClientPages requestPlaceTypeField (boolean value) {
      this.requestField("place_type", value);
      return this;
    }
    public APIRequestGetClientPages requestPlotOutlineField () {
      return this.requestPlotOutlineField(true);
    }
    public APIRequestGetClientPages requestPlotOutlineField (boolean value) {
      this.requestField("plot_outline", value);
      return this;
    }
    public APIRequestGetClientPages requestPreferredAudienceField () {
      return this.requestPreferredAudienceField(true);
    }
    public APIRequestGetClientPages requestPreferredAudienceField (boolean value) {
      this.requestField("preferred_audience", value);
      return this;
    }
    public APIRequestGetClientPages requestPressContactField () {
      return this.requestPressContactField(true);
    }
    public APIRequestGetClientPages requestPressContactField (boolean value) {
      this.requestField("press_contact", value);
      return this;
    }
    public APIRequestGetClientPages requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGetClientPages requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGetClientPages requestProducedByField () {
      return this.requestProducedByField(true);
    }
    public APIRequestGetClientPages requestProducedByField (boolean value) {
      this.requestField("produced_by", value);
      return this;
    }
    public APIRequestGetClientPages requestProductsField () {
      return this.requestProductsField(true);
    }
    public APIRequestGetClientPages requestProductsField (boolean value) {
      this.requestField("products", value);
      return this;
    }
    public APIRequestGetClientPages requestPromotionEligibleField () {
      return this.requestPromotionEligibleField(true);
    }
    public APIRequestGetClientPages requestPromotionEligibleField (boolean value) {
      this.requestField("promotion_eligible", value);
      return this;
    }
    public APIRequestGetClientPages requestPromotionIneligibleReasonField () {
      return this.requestPromotionIneligibleReasonField(true);
    }
    public APIRequestGetClientPages requestPromotionIneligibleReasonField (boolean value) {
      this.requestField("promotion_ineligible_reason", value);
      return this;
    }
    public APIRequestGetClientPages requestPublicTransitField () {
      return this.requestPublicTransitField(true);
    }
    public APIRequestGetClientPages requestPublicTransitField (boolean value) {
      this.requestField("public_transit", value);
      return this;
    }
    public APIRequestGetClientPages requestPublisherSpaceField () {
      return this.requestPublisherSpaceField(true);
    }
    public APIRequestGetClientPages requestPublisherSpaceField (boolean value) {
      this.requestField("publisher_space", value);
      return this;
    }
    public APIRequestGetClientPages requestRatingCountField () {
      return this.requestRatingCountField(true);
    }
    public APIRequestGetClientPages requestRatingCountField (boolean value) {
      this.requestField("rating_count", value);
      return this;
    }
    public APIRequestGetClientPages requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetClientPages requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetClientPages requestRecordLabelField () {
      return this.requestRecordLabelField(true);
    }
    public APIRequestGetClientPages requestRecordLabelField (boolean value) {
      this.requestField("record_label", value);
      return this;
    }
    public APIRequestGetClientPages requestReleaseDateField () {
      return this.requestReleaseDateField(true);
    }
    public APIRequestGetClientPages requestReleaseDateField (boolean value) {
      this.requestField("release_date", value);
      return this;
    }
    public APIRequestGetClientPages requestRestaurantServicesField () {
      return this.requestRestaurantServicesField(true);
    }
    public APIRequestGetClientPages requestRestaurantServicesField (boolean value) {
      this.requestField("restaurant_services", value);
      return this;
    }
    public APIRequestGetClientPages requestRestaurantSpecialtiesField () {
      return this.requestRestaurantSpecialtiesField(true);
    }
    public APIRequestGetClientPages requestRestaurantSpecialtiesField (boolean value) {
      this.requestField("restaurant_specialties", value);
      return this;
    }
    public APIRequestGetClientPages requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetClientPages requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGetClientPages requestScreenplayByField () {
      return this.requestScreenplayByField(true);
    }
    public APIRequestGetClientPages requestScreenplayByField (boolean value) {
      this.requestField("screenplay_by", value);
      return this;
    }
    public APIRequestGetClientPages requestSeasonField () {
      return this.requestSeasonField(true);
    }
    public APIRequestGetClientPages requestSeasonField (boolean value) {
      this.requestField("season", value);
      return this;
    }
    public APIRequestGetClientPages requestSingleLineAddressField () {
      return this.requestSingleLineAddressField(true);
    }
    public APIRequestGetClientPages requestSingleLineAddressField (boolean value) {
      this.requestField("single_line_address", value);
      return this;
    }
    public APIRequestGetClientPages requestStarringField () {
      return this.requestStarringField(true);
    }
    public APIRequestGetClientPages requestStarringField (boolean value) {
      this.requestField("starring", value);
      return this;
    }
    public APIRequestGetClientPages requestStartInfoField () {
      return this.requestStartInfoField(true);
    }
    public APIRequestGetClientPages requestStartInfoField (boolean value) {
      this.requestField("start_info", value);
      return this;
    }
    public APIRequestGetClientPages requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGetClientPages requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGetClientPages requestStoreLocationDescriptorField () {
      return this.requestStoreLocationDescriptorField(true);
    }
    public APIRequestGetClientPages requestStoreLocationDescriptorField (boolean value) {
      this.requestField("store_location_descriptor", value);
      return this;
    }
    public APIRequestGetClientPages requestStoreNumberField () {
      return this.requestStoreNumberField(true);
    }
    public APIRequestGetClientPages requestStoreNumberField (boolean value) {
      this.requestField("store_number", value);
      return this;
    }
    public APIRequestGetClientPages requestStudioField () {
      return this.requestStudioField(true);
    }
    public APIRequestGetClientPages requestStudioField (boolean value) {
      this.requestField("studio", value);
      return this;
    }
    public APIRequestGetClientPages requestSupportsInstantArticlesField () {
      return this.requestSupportsInstantArticlesField(true);
    }
    public APIRequestGetClientPages requestSupportsInstantArticlesField (boolean value) {
      this.requestField("supports_instant_articles", value);
      return this;
    }
    public APIRequestGetClientPages requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetClientPages requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
      return this;
    }
    public APIRequestGetClientPages requestUnreadMessageCountField () {
      return this.requestUnreadMessageCountField(true);
    }
    public APIRequestGetClientPages requestUnreadMessageCountField (boolean value) {
      this.requestField("unread_message_count", value);
      return this;
    }
    public APIRequestGetClientPages requestUnreadNotifCountField () {
      return this.requestUnreadNotifCountField(true);
    }
    public APIRequestGetClientPages requestUnreadNotifCountField (boolean value) {
      this.requestField("unread_notif_count", value);
      return this;
    }
    public APIRequestGetClientPages requestUnseenMessageCountField () {
      return this.requestUnseenMessageCountField(true);
    }
    public APIRequestGetClientPages requestUnseenMessageCountField (boolean value) {
      this.requestField("unseen_message_count", value);
      return this;
    }
    public APIRequestGetClientPages requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetClientPages requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetClientPages requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetClientPages requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetClientPages requestVoipInfoField () {
      return this.requestVoipInfoField(true);
    }
    public APIRequestGetClientPages requestVoipInfoField (boolean value) {
      this.requestField("voip_info", value);
      return this;
    }
    public APIRequestGetClientPages requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetClientPages requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetClientPages requestWereHereCountField () {
      return this.requestWereHereCountField(true);
    }
    public APIRequestGetClientPages requestWereHereCountField (boolean value) {
      this.requestField("were_here_count", value);
      return this;
    }
    public APIRequestGetClientPages requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGetClientPages requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
      return this;
    }
    public APIRequestGetClientPages requestWrittenByField () {
      return this.requestWrittenByField(true);
    }
    public APIRequestGetClientPages requestWrittenByField (boolean value) {
      this.requestField("written_by", value);
      return this;
    }
  }

  public static class APIRequestGetClientPixels extends APIRequest<AdsPixel> {

    APINodeList<AdsPixel> lastResponse = null;
    @Override
    public APINodeList<AdsPixel> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "can_proxy",
      "code",
      "creation_time",
      "creator",
      "id",
      "is_created_by_business",
      "last_fired_time",
      "name",
      "owner_ad_account",
      "owner_business",
    };

    @Override
    public APINodeList<AdsPixel> parseResponse(String response) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdsPixel> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsPixel> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdsPixel>>() {
           public APINodeList<AdsPixel> apply(String result) {
             try {
               return APIRequestGetClientPixels.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetClientPixels(String nodeId, APIContext context) {
      super(context, nodeId, "/client_pixels", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetClientPixels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetClientPixels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetClientPixels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetClientPixels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientPixels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetClientPixels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientPixels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetClientPixels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetClientPixels requestCanProxyField () {
      return this.requestCanProxyField(true);
    }
    public APIRequestGetClientPixels requestCanProxyField (boolean value) {
      this.requestField("can_proxy", value);
      return this;
    }
    public APIRequestGetClientPixels requestCodeField () {
      return this.requestCodeField(true);
    }
    public APIRequestGetClientPixels requestCodeField (boolean value) {
      this.requestField("code", value);
      return this;
    }
    public APIRequestGetClientPixels requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetClientPixels requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetClientPixels requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetClientPixels requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetClientPixels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClientPixels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetClientPixels requestIsCreatedByBusinessField () {
      return this.requestIsCreatedByBusinessField(true);
    }
    public APIRequestGetClientPixels requestIsCreatedByBusinessField (boolean value) {
      this.requestField("is_created_by_business", value);
      return this;
    }
    public APIRequestGetClientPixels requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetClientPixels requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGetClientPixels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetClientPixels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetClientPixels requestOwnerAdAccountField () {
      return this.requestOwnerAdAccountField(true);
    }
    public APIRequestGetClientPixels requestOwnerAdAccountField (boolean value) {
      this.requestField("owner_ad_account", value);
      return this;
    }
    public APIRequestGetClientPixels requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetClientPixels requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
  }

  public static class APIRequestGetClientProductCatalogs extends APIRequest<ProductCatalog> {

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
               return APIRequestGetClientProductCatalogs.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetClientProductCatalogs(String nodeId, APIContext context) {
      super(context, nodeId, "/client_product_catalogs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetClientProductCatalogs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetClientProductCatalogs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetClientProductCatalogs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetClientProductCatalogs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientProductCatalogs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetClientProductCatalogs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetClientProductCatalogs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetClientProductCatalogs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetClientProductCatalogs requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetClientProductCatalogs requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestDaDisplaySettingsField () {
      return this.requestDaDisplaySettingsField(true);
    }
    public APIRequestGetClientProductCatalogs requestDaDisplaySettingsField (boolean value) {
      this.requestField("da_display_settings", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestDefaultImageUrlField () {
      return this.requestDefaultImageUrlField(true);
    }
    public APIRequestGetClientProductCatalogs requestDefaultImageUrlField (boolean value) {
      this.requestField("default_image_url", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestFallbackImageUrlField () {
      return this.requestFallbackImageUrlField(true);
    }
    public APIRequestGetClientProductCatalogs requestFallbackImageUrlField (boolean value) {
      this.requestField("fallback_image_url", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestFeedCountField () {
      return this.requestFeedCountField(true);
    }
    public APIRequestGetClientProductCatalogs requestFeedCountField (boolean value) {
      this.requestField("feed_count", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestFlightCatalogSettingsField () {
      return this.requestFlightCatalogSettingsField(true);
    }
    public APIRequestGetClientProductCatalogs requestFlightCatalogSettingsField (boolean value) {
      this.requestField("flight_catalog_settings", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetClientProductCatalogs requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetClientProductCatalogs requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGetClientProductCatalogs requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestQualifiedProductCountField () {
      return this.requestQualifiedProductCountField(true);
    }
    public APIRequestGetClientProductCatalogs requestQualifiedProductCountField (boolean value) {
      this.requestField("qualified_product_count", value);
      return this;
    }
    public APIRequestGetClientProductCatalogs requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetClientProductCatalogs requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
  }

  public static class APIRequestDeleteClients extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business",
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
               return APIRequestDeleteClients.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteClients(String nodeId, APIContext context) {
      super(context, nodeId, "/clients", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteClients setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteClients setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteClients setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestDeleteClients requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteClients requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteClients requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteClients requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteClients requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteClients requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetDirectDeals extends APIRequest<DirectDeal> {

    APINodeList<DirectDeal> lastResponse = null;
    @Override
    public APINodeList<DirectDeal> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "status",
    };

    public static final String[] FIELDS = {
      "adbreaks_enabled",
      "adset",
      "advertiser",
      "advertiser_lead_email",
      "advertiser_page",
      "cpe_amount",
      "cpe_currency",
      "end_time",
      "id",
      "lifetime_budget_amount",
      "lifetime_budget_currency",
      "lifetime_impressions",
      "name",
      "pages",
      "placements",
      "priced_by",
      "publisher_name",
      "review_requirement",
      "sales_lead_email",
      "start_time",
      "status",
      "targeting",
    };

    @Override
    public APINodeList<DirectDeal> parseResponse(String response) throws APIException {
      return DirectDeal.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<DirectDeal> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<DirectDeal> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<DirectDeal>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<DirectDeal>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<DirectDeal>>() {
           public APINodeList<DirectDeal> apply(String result) {
             try {
               return APIRequestGetDirectDeals.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetDirectDeals(String nodeId, APIContext context) {
      super(context, nodeId, "/direct_deals", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDirectDeals setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDirectDeals setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDirectDeals setStatus (DirectDeal.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestGetDirectDeals setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestGetDirectDeals requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDirectDeals requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDirectDeals requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDirectDeals requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDirectDeals requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDirectDeals requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetDirectDeals requestAdbreaksEnabledField () {
      return this.requestAdbreaksEnabledField(true);
    }
    public APIRequestGetDirectDeals requestAdbreaksEnabledField (boolean value) {
      this.requestField("adbreaks_enabled", value);
      return this;
    }
    public APIRequestGetDirectDeals requestAdsetField () {
      return this.requestAdsetField(true);
    }
    public APIRequestGetDirectDeals requestAdsetField (boolean value) {
      this.requestField("adset", value);
      return this;
    }
    public APIRequestGetDirectDeals requestAdvertiserField () {
      return this.requestAdvertiserField(true);
    }
    public APIRequestGetDirectDeals requestAdvertiserField (boolean value) {
      this.requestField("advertiser", value);
      return this;
    }
    public APIRequestGetDirectDeals requestAdvertiserLeadEmailField () {
      return this.requestAdvertiserLeadEmailField(true);
    }
    public APIRequestGetDirectDeals requestAdvertiserLeadEmailField (boolean value) {
      this.requestField("advertiser_lead_email", value);
      return this;
    }
    public APIRequestGetDirectDeals requestAdvertiserPageField () {
      return this.requestAdvertiserPageField(true);
    }
    public APIRequestGetDirectDeals requestAdvertiserPageField (boolean value) {
      this.requestField("advertiser_page", value);
      return this;
    }
    public APIRequestGetDirectDeals requestCpeAmountField () {
      return this.requestCpeAmountField(true);
    }
    public APIRequestGetDirectDeals requestCpeAmountField (boolean value) {
      this.requestField("cpe_amount", value);
      return this;
    }
    public APIRequestGetDirectDeals requestCpeCurrencyField () {
      return this.requestCpeCurrencyField(true);
    }
    public APIRequestGetDirectDeals requestCpeCurrencyField (boolean value) {
      this.requestField("cpe_currency", value);
      return this;
    }
    public APIRequestGetDirectDeals requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetDirectDeals requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetDirectDeals requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetDirectDeals requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetDirectDeals requestLifetimeBudgetAmountField () {
      return this.requestLifetimeBudgetAmountField(true);
    }
    public APIRequestGetDirectDeals requestLifetimeBudgetAmountField (boolean value) {
      this.requestField("lifetime_budget_amount", value);
      return this;
    }
    public APIRequestGetDirectDeals requestLifetimeBudgetCurrencyField () {
      return this.requestLifetimeBudgetCurrencyField(true);
    }
    public APIRequestGetDirectDeals requestLifetimeBudgetCurrencyField (boolean value) {
      this.requestField("lifetime_budget_currency", value);
      return this;
    }
    public APIRequestGetDirectDeals requestLifetimeImpressionsField () {
      return this.requestLifetimeImpressionsField(true);
    }
    public APIRequestGetDirectDeals requestLifetimeImpressionsField (boolean value) {
      this.requestField("lifetime_impressions", value);
      return this;
    }
    public APIRequestGetDirectDeals requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetDirectDeals requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetDirectDeals requestPagesField () {
      return this.requestPagesField(true);
    }
    public APIRequestGetDirectDeals requestPagesField (boolean value) {
      this.requestField("pages", value);
      return this;
    }
    public APIRequestGetDirectDeals requestPlacementsField () {
      return this.requestPlacementsField(true);
    }
    public APIRequestGetDirectDeals requestPlacementsField (boolean value) {
      this.requestField("placements", value);
      return this;
    }
    public APIRequestGetDirectDeals requestPricedByField () {
      return this.requestPricedByField(true);
    }
    public APIRequestGetDirectDeals requestPricedByField (boolean value) {
      this.requestField("priced_by", value);
      return this;
    }
    public APIRequestGetDirectDeals requestPublisherNameField () {
      return this.requestPublisherNameField(true);
    }
    public APIRequestGetDirectDeals requestPublisherNameField (boolean value) {
      this.requestField("publisher_name", value);
      return this;
    }
    public APIRequestGetDirectDeals requestReviewRequirementField () {
      return this.requestReviewRequirementField(true);
    }
    public APIRequestGetDirectDeals requestReviewRequirementField (boolean value) {
      this.requestField("review_requirement", value);
      return this;
    }
    public APIRequestGetDirectDeals requestSalesLeadEmailField () {
      return this.requestSalesLeadEmailField(true);
    }
    public APIRequestGetDirectDeals requestSalesLeadEmailField (boolean value) {
      this.requestField("sales_lead_email", value);
      return this;
    }
    public APIRequestGetDirectDeals requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetDirectDeals requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetDirectDeals requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetDirectDeals requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetDirectDeals requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetDirectDeals requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
  }

  public static class APIRequestGetEventSourceGroups extends APIRequest<EventSourceGroup> {

    APINodeList<EventSourceGroup> lastResponse = null;
    @Override
    public APINodeList<EventSourceGroup> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "event_sources",
      "id",
      "name",
    };

    @Override
    public APINodeList<EventSourceGroup> parseResponse(String response) throws APIException {
      return EventSourceGroup.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<EventSourceGroup> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<EventSourceGroup> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<EventSourceGroup>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<EventSourceGroup>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<EventSourceGroup>>() {
           public APINodeList<EventSourceGroup> apply(String result) {
             try {
               return APIRequestGetEventSourceGroups.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetEventSourceGroups(String nodeId, APIContext context) {
      super(context, nodeId, "/event_source_groups", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetEventSourceGroups setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetEventSourceGroups setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetEventSourceGroups requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetEventSourceGroups requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetEventSourceGroups requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetEventSourceGroups requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetEventSourceGroups requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetEventSourceGroups requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetEventSourceGroups requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetEventSourceGroups requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetEventSourceGroups requestEventSourcesField () {
      return this.requestEventSourcesField(true);
    }
    public APIRequestGetEventSourceGroups requestEventSourcesField (boolean value) {
      this.requestField("event_sources", value);
      return this;
    }
    public APIRequestGetEventSourceGroups requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetEventSourceGroups requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetEventSourceGroups requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetEventSourceGroups requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
  }

  public static class APIRequestCreateEventSourceGroup extends APIRequest<EventSourceGroup> {

    EventSourceGroup lastResponse = null;
    @Override
    public EventSourceGroup getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "event_sources",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public EventSourceGroup parseResponse(String response) throws APIException {
      return EventSourceGroup.parseResponse(response, getContext(), this).head();
    }

    @Override
    public EventSourceGroup execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public EventSourceGroup execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<EventSourceGroup> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<EventSourceGroup> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, EventSourceGroup>() {
           public EventSourceGroup apply(String result) {
             try {
               return APIRequestCreateEventSourceGroup.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateEventSourceGroup(String nodeId, APIContext context) {
      super(context, nodeId, "/event_source_groups", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateEventSourceGroup setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateEventSourceGroup setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateEventSourceGroup setEventSources (List<String> eventSources) {
      this.setParam("event_sources", eventSources);
      return this;
    }
    public APIRequestCreateEventSourceGroup setEventSources (String eventSources) {
      this.setParam("event_sources", eventSources);
      return this;
    }

    public APIRequestCreateEventSourceGroup setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateEventSourceGroup requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateEventSourceGroup requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateEventSourceGroup requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateEventSourceGroup requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateEventSourceGroup requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateEventSourceGroup requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetExtendedCredits extends APIRequest<ExtendedCredit> {

    APINodeList<ExtendedCredit> lastResponse = null;
    @Override
    public APINodeList<ExtendedCredit> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "allocated_amount",
      "balance",
      "credit_available",
      "credit_type",
      "id",
      "is_automated_experience",
      "last_payment_time",
      "legal_entity_name",
      "liable_biz_name",
      "max_balance",
      "online_max_balance",
      "owner_business",
      "owner_business_name",
      "partition_from",
      "receiving_credit_allocation_config",
      "send_bill_to_biz_name",
    };

    @Override
    public APINodeList<ExtendedCredit> parseResponse(String response) throws APIException {
      return ExtendedCredit.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ExtendedCredit> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ExtendedCredit> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ExtendedCredit>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ExtendedCredit>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ExtendedCredit>>() {
           public APINodeList<ExtendedCredit> apply(String result) {
             try {
               return APIRequestGetExtendedCredits.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetExtendedCredits(String nodeId, APIContext context) {
      super(context, nodeId, "/extendedcredits", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetExtendedCredits setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetExtendedCredits setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetExtendedCredits requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetExtendedCredits requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetExtendedCredits requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetExtendedCredits requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetExtendedCredits requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetExtendedCredits requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetExtendedCredits requestAllocatedAmountField () {
      return this.requestAllocatedAmountField(true);
    }
    public APIRequestGetExtendedCredits requestAllocatedAmountField (boolean value) {
      this.requestField("allocated_amount", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestBalanceField () {
      return this.requestBalanceField(true);
    }
    public APIRequestGetExtendedCredits requestBalanceField (boolean value) {
      this.requestField("balance", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestCreditAvailableField () {
      return this.requestCreditAvailableField(true);
    }
    public APIRequestGetExtendedCredits requestCreditAvailableField (boolean value) {
      this.requestField("credit_available", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestCreditTypeField () {
      return this.requestCreditTypeField(true);
    }
    public APIRequestGetExtendedCredits requestCreditTypeField (boolean value) {
      this.requestField("credit_type", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetExtendedCredits requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestIsAutomatedExperienceField () {
      return this.requestIsAutomatedExperienceField(true);
    }
    public APIRequestGetExtendedCredits requestIsAutomatedExperienceField (boolean value) {
      this.requestField("is_automated_experience", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestLastPaymentTimeField () {
      return this.requestLastPaymentTimeField(true);
    }
    public APIRequestGetExtendedCredits requestLastPaymentTimeField (boolean value) {
      this.requestField("last_payment_time", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestLegalEntityNameField () {
      return this.requestLegalEntityNameField(true);
    }
    public APIRequestGetExtendedCredits requestLegalEntityNameField (boolean value) {
      this.requestField("legal_entity_name", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestLiableBizNameField () {
      return this.requestLiableBizNameField(true);
    }
    public APIRequestGetExtendedCredits requestLiableBizNameField (boolean value) {
      this.requestField("liable_biz_name", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestMaxBalanceField () {
      return this.requestMaxBalanceField(true);
    }
    public APIRequestGetExtendedCredits requestMaxBalanceField (boolean value) {
      this.requestField("max_balance", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestOnlineMaxBalanceField () {
      return this.requestOnlineMaxBalanceField(true);
    }
    public APIRequestGetExtendedCredits requestOnlineMaxBalanceField (boolean value) {
      this.requestField("online_max_balance", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetExtendedCredits requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestOwnerBusinessNameField () {
      return this.requestOwnerBusinessNameField(true);
    }
    public APIRequestGetExtendedCredits requestOwnerBusinessNameField (boolean value) {
      this.requestField("owner_business_name", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestPartitionFromField () {
      return this.requestPartitionFromField(true);
    }
    public APIRequestGetExtendedCredits requestPartitionFromField (boolean value) {
      this.requestField("partition_from", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestReceivingCreditAllocationConfigField () {
      return this.requestReceivingCreditAllocationConfigField(true);
    }
    public APIRequestGetExtendedCredits requestReceivingCreditAllocationConfigField (boolean value) {
      this.requestField("receiving_credit_allocation_config", value);
      return this;
    }
    public APIRequestGetExtendedCredits requestSendBillToBizNameField () {
      return this.requestSendBillToBizNameField(true);
    }
    public APIRequestGetExtendedCredits requestSendBillToBizNameField (boolean value) {
      this.requestField("send_bill_to_biz_name", value);
      return this;
    }
  }

  public static class APIRequestGetGrpPlans extends APIRequest<ReachFrequencyPrediction> {

    APINodeList<ReachFrequencyPrediction> lastResponse = null;
    @Override
    public APINodeList<ReachFrequencyPrediction> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "status",
    };

    public static final String[] FIELDS = {
      "account_id",
      "campaign_group_id",
      "campaign_id",
      "campaign_time_start",
      "campaign_time_stop",
      "curve_budget_reach",
      "daily_impression_curve",
      "destination_id",
      "expiration_time",
      "external_budget",
      "external_impression",
      "external_maximum_budget",
      "external_maximum_impression",
      "external_maximum_reach",
      "external_minimum_budget",
      "external_minimum_impression",
      "external_minimum_reach",
      "external_reach",
      "frequency_cap",
      "frequency_distribution",
      "frequency_distribution_map",
      "frequency_distribution_map_agg",
      "grp_dmas_audience_size",
      "holdout_percentage",
      "id",
      "instagram_destination_id",
      "interval_frequency_cap",
      "interval_frequency_cap_reset_period",
      "is_io",
      "name",
      "pause_periods",
      "placement_breakdown",
      "prediction_mode",
      "prediction_progress",
      "reservation_status",
      "status",
      "story_event_type",
      "target_audience_size",
      "target_spec",
      "time_created",
      "time_updated",
    };

    @Override
    public APINodeList<ReachFrequencyPrediction> parseResponse(String response) throws APIException {
      return ReachFrequencyPrediction.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ReachFrequencyPrediction> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ReachFrequencyPrediction> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ReachFrequencyPrediction>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ReachFrequencyPrediction>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ReachFrequencyPrediction>>() {
           public APINodeList<ReachFrequencyPrediction> apply(String result) {
             try {
               return APIRequestGetGrpPlans.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetGrpPlans(String nodeId, APIContext context) {
      super(context, nodeId, "/grp_plans", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetGrpPlans setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetGrpPlans setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetGrpPlans setStatus (ReachFrequencyPrediction.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestGetGrpPlans setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestGetGrpPlans requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetGrpPlans requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetGrpPlans requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetGrpPlans requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetGrpPlans requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetGrpPlans requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetGrpPlans requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetGrpPlans requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestCampaignGroupIdField () {
      return this.requestCampaignGroupIdField(true);
    }
    public APIRequestGetGrpPlans requestCampaignGroupIdField (boolean value) {
      this.requestField("campaign_group_id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetGrpPlans requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestCampaignTimeStartField () {
      return this.requestCampaignTimeStartField(true);
    }
    public APIRequestGetGrpPlans requestCampaignTimeStartField (boolean value) {
      this.requestField("campaign_time_start", value);
      return this;
    }
    public APIRequestGetGrpPlans requestCampaignTimeStopField () {
      return this.requestCampaignTimeStopField(true);
    }
    public APIRequestGetGrpPlans requestCampaignTimeStopField (boolean value) {
      this.requestField("campaign_time_stop", value);
      return this;
    }
    public APIRequestGetGrpPlans requestCurveBudgetReachField () {
      return this.requestCurveBudgetReachField(true);
    }
    public APIRequestGetGrpPlans requestCurveBudgetReachField (boolean value) {
      this.requestField("curve_budget_reach", value);
      return this;
    }
    public APIRequestGetGrpPlans requestDailyImpressionCurveField () {
      return this.requestDailyImpressionCurveField(true);
    }
    public APIRequestGetGrpPlans requestDailyImpressionCurveField (boolean value) {
      this.requestField("daily_impression_curve", value);
      return this;
    }
    public APIRequestGetGrpPlans requestDestinationIdField () {
      return this.requestDestinationIdField(true);
    }
    public APIRequestGetGrpPlans requestDestinationIdField (boolean value) {
      this.requestField("destination_id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGetGrpPlans requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalBudgetField () {
      return this.requestExternalBudgetField(true);
    }
    public APIRequestGetGrpPlans requestExternalBudgetField (boolean value) {
      this.requestField("external_budget", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalImpressionField () {
      return this.requestExternalImpressionField(true);
    }
    public APIRequestGetGrpPlans requestExternalImpressionField (boolean value) {
      this.requestField("external_impression", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMaximumBudgetField () {
      return this.requestExternalMaximumBudgetField(true);
    }
    public APIRequestGetGrpPlans requestExternalMaximumBudgetField (boolean value) {
      this.requestField("external_maximum_budget", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMaximumImpressionField () {
      return this.requestExternalMaximumImpressionField(true);
    }
    public APIRequestGetGrpPlans requestExternalMaximumImpressionField (boolean value) {
      this.requestField("external_maximum_impression", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMaximumReachField () {
      return this.requestExternalMaximumReachField(true);
    }
    public APIRequestGetGrpPlans requestExternalMaximumReachField (boolean value) {
      this.requestField("external_maximum_reach", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMinimumBudgetField () {
      return this.requestExternalMinimumBudgetField(true);
    }
    public APIRequestGetGrpPlans requestExternalMinimumBudgetField (boolean value) {
      this.requestField("external_minimum_budget", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMinimumImpressionField () {
      return this.requestExternalMinimumImpressionField(true);
    }
    public APIRequestGetGrpPlans requestExternalMinimumImpressionField (boolean value) {
      this.requestField("external_minimum_impression", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalMinimumReachField () {
      return this.requestExternalMinimumReachField(true);
    }
    public APIRequestGetGrpPlans requestExternalMinimumReachField (boolean value) {
      this.requestField("external_minimum_reach", value);
      return this;
    }
    public APIRequestGetGrpPlans requestExternalReachField () {
      return this.requestExternalReachField(true);
    }
    public APIRequestGetGrpPlans requestExternalReachField (boolean value) {
      this.requestField("external_reach", value);
      return this;
    }
    public APIRequestGetGrpPlans requestFrequencyCapField () {
      return this.requestFrequencyCapField(true);
    }
    public APIRequestGetGrpPlans requestFrequencyCapField (boolean value) {
      this.requestField("frequency_cap", value);
      return this;
    }
    public APIRequestGetGrpPlans requestFrequencyDistributionField () {
      return this.requestFrequencyDistributionField(true);
    }
    public APIRequestGetGrpPlans requestFrequencyDistributionField (boolean value) {
      this.requestField("frequency_distribution", value);
      return this;
    }
    public APIRequestGetGrpPlans requestFrequencyDistributionMapField () {
      return this.requestFrequencyDistributionMapField(true);
    }
    public APIRequestGetGrpPlans requestFrequencyDistributionMapField (boolean value) {
      this.requestField("frequency_distribution_map", value);
      return this;
    }
    public APIRequestGetGrpPlans requestFrequencyDistributionMapAggField () {
      return this.requestFrequencyDistributionMapAggField(true);
    }
    public APIRequestGetGrpPlans requestFrequencyDistributionMapAggField (boolean value) {
      this.requestField("frequency_distribution_map_agg", value);
      return this;
    }
    public APIRequestGetGrpPlans requestGrpDmasAudienceSizeField () {
      return this.requestGrpDmasAudienceSizeField(true);
    }
    public APIRequestGetGrpPlans requestGrpDmasAudienceSizeField (boolean value) {
      this.requestField("grp_dmas_audience_size", value);
      return this;
    }
    public APIRequestGetGrpPlans requestHoldoutPercentageField () {
      return this.requestHoldoutPercentageField(true);
    }
    public APIRequestGetGrpPlans requestHoldoutPercentageField (boolean value) {
      this.requestField("holdout_percentage", value);
      return this;
    }
    public APIRequestGetGrpPlans requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetGrpPlans requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestInstagramDestinationIdField () {
      return this.requestInstagramDestinationIdField(true);
    }
    public APIRequestGetGrpPlans requestInstagramDestinationIdField (boolean value) {
      this.requestField("instagram_destination_id", value);
      return this;
    }
    public APIRequestGetGrpPlans requestIntervalFrequencyCapField () {
      return this.requestIntervalFrequencyCapField(true);
    }
    public APIRequestGetGrpPlans requestIntervalFrequencyCapField (boolean value) {
      this.requestField("interval_frequency_cap", value);
      return this;
    }
    public APIRequestGetGrpPlans requestIntervalFrequencyCapResetPeriodField () {
      return this.requestIntervalFrequencyCapResetPeriodField(true);
    }
    public APIRequestGetGrpPlans requestIntervalFrequencyCapResetPeriodField (boolean value) {
      this.requestField("interval_frequency_cap_reset_period", value);
      return this;
    }
    public APIRequestGetGrpPlans requestIsIoField () {
      return this.requestIsIoField(true);
    }
    public APIRequestGetGrpPlans requestIsIoField (boolean value) {
      this.requestField("is_io", value);
      return this;
    }
    public APIRequestGetGrpPlans requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetGrpPlans requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetGrpPlans requestPausePeriodsField () {
      return this.requestPausePeriodsField(true);
    }
    public APIRequestGetGrpPlans requestPausePeriodsField (boolean value) {
      this.requestField("pause_periods", value);
      return this;
    }
    public APIRequestGetGrpPlans requestPlacementBreakdownField () {
      return this.requestPlacementBreakdownField(true);
    }
    public APIRequestGetGrpPlans requestPlacementBreakdownField (boolean value) {
      this.requestField("placement_breakdown", value);
      return this;
    }
    public APIRequestGetGrpPlans requestPredictionModeField () {
      return this.requestPredictionModeField(true);
    }
    public APIRequestGetGrpPlans requestPredictionModeField (boolean value) {
      this.requestField("prediction_mode", value);
      return this;
    }
    public APIRequestGetGrpPlans requestPredictionProgressField () {
      return this.requestPredictionProgressField(true);
    }
    public APIRequestGetGrpPlans requestPredictionProgressField (boolean value) {
      this.requestField("prediction_progress", value);
      return this;
    }
    public APIRequestGetGrpPlans requestReservationStatusField () {
      return this.requestReservationStatusField(true);
    }
    public APIRequestGetGrpPlans requestReservationStatusField (boolean value) {
      this.requestField("reservation_status", value);
      return this;
    }
    public APIRequestGetGrpPlans requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetGrpPlans requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetGrpPlans requestStoryEventTypeField () {
      return this.requestStoryEventTypeField(true);
    }
    public APIRequestGetGrpPlans requestStoryEventTypeField (boolean value) {
      this.requestField("story_event_type", value);
      return this;
    }
    public APIRequestGetGrpPlans requestTargetAudienceSizeField () {
      return this.requestTargetAudienceSizeField(true);
    }
    public APIRequestGetGrpPlans requestTargetAudienceSizeField (boolean value) {
      this.requestField("target_audience_size", value);
      return this;
    }
    public APIRequestGetGrpPlans requestTargetSpecField () {
      return this.requestTargetSpecField(true);
    }
    public APIRequestGetGrpPlans requestTargetSpecField (boolean value) {
      this.requestField("target_spec", value);
      return this;
    }
    public APIRequestGetGrpPlans requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGetGrpPlans requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGetGrpPlans requestTimeUpdatedField () {
      return this.requestTimeUpdatedField(true);
    }
    public APIRequestGetGrpPlans requestTimeUpdatedField (boolean value) {
      this.requestField("time_updated", value);
      return this;
    }
  }

  public static class APIRequestGetInstagramAccounts extends APIRequest<APINode> {

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
               return APIRequestGetInstagramAccounts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetInstagramAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/instagram_accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInstagramAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInstagramAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInstagramAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInstagramAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInstagramAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInstagramAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInstagramAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInstagramAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetMatchedSearchApplications extends APIRequest<BusinessMatchedSearchApplicationsEdgeData> {

    APINodeList<BusinessMatchedSearchApplicationsEdgeData> lastResponse = null;
    @Override
    public APINodeList<BusinessMatchedSearchApplicationsEdgeData> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "allow_incomplete_app",
      "app_store",
      "app_store_country",
      "query_term",
    };

    public static final String[] FIELDS = {
      "app_id",
      "icon_url",
      "name",
      "search_source_store",
      "store",
      "unique_id",
      "url",
    };

    @Override
    public APINodeList<BusinessMatchedSearchApplicationsEdgeData> parseResponse(String response) throws APIException {
      return BusinessMatchedSearchApplicationsEdgeData.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessMatchedSearchApplicationsEdgeData> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessMatchedSearchApplicationsEdgeData> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessMatchedSearchApplicationsEdgeData>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessMatchedSearchApplicationsEdgeData>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessMatchedSearchApplicationsEdgeData>>() {
           public APINodeList<BusinessMatchedSearchApplicationsEdgeData> apply(String result) {
             try {
               return APIRequestGetMatchedSearchApplications.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetMatchedSearchApplications(String nodeId, APIContext context) {
      super(context, nodeId, "/matched_search_applications", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMatchedSearchApplications setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMatchedSearchApplications setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMatchedSearchApplications setAllowIncompleteApp (Boolean allowIncompleteApp) {
      this.setParam("allow_incomplete_app", allowIncompleteApp);
      return this;
    }
    public APIRequestGetMatchedSearchApplications setAllowIncompleteApp (String allowIncompleteApp) {
      this.setParam("allow_incomplete_app", allowIncompleteApp);
      return this;
    }

    public APIRequestGetMatchedSearchApplications setAppStore (BusinessMatchedSearchApplicationsEdgeData.EnumAppStore appStore) {
      this.setParam("app_store", appStore);
      return this;
    }
    public APIRequestGetMatchedSearchApplications setAppStore (String appStore) {
      this.setParam("app_store", appStore);
      return this;
    }

    public APIRequestGetMatchedSearchApplications setAppStoreCountry (String appStoreCountry) {
      this.setParam("app_store_country", appStoreCountry);
      return this;
    }

    public APIRequestGetMatchedSearchApplications setQueryTerm (String queryTerm) {
      this.setParam("query_term", queryTerm);
      return this;
    }

    public APIRequestGetMatchedSearchApplications requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMatchedSearchApplications requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMatchedSearchApplications requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMatchedSearchApplications requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMatchedSearchApplications requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMatchedSearchApplications requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetMatchedSearchApplications requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetMatchedSearchApplications requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetMatchedSearchApplications requestIconUrlField () {
      return this.requestIconUrlField(true);
    }
    public APIRequestGetMatchedSearchApplications requestIconUrlField (boolean value) {
      this.requestField("icon_url", value);
      return this;
    }
    public APIRequestGetMatchedSearchApplications requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetMatchedSearchApplications requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetMatchedSearchApplications requestSearchSourceStoreField () {
      return this.requestSearchSourceStoreField(true);
    }
    public APIRequestGetMatchedSearchApplications requestSearchSourceStoreField (boolean value) {
      this.requestField("search_source_store", value);
      return this;
    }
    public APIRequestGetMatchedSearchApplications requestStoreField () {
      return this.requestStoreField(true);
    }
    public APIRequestGetMatchedSearchApplications requestStoreField (boolean value) {
      this.requestField("store", value);
      return this;
    }
    public APIRequestGetMatchedSearchApplications requestUniqueIdField () {
      return this.requestUniqueIdField(true);
    }
    public APIRequestGetMatchedSearchApplications requestUniqueIdField (boolean value) {
      this.requestField("unique_id", value);
      return this;
    }
    public APIRequestGetMatchedSearchApplications requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetMatchedSearchApplications requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
  }

  public static class APIRequestGetMeasurementReports extends APIRequest<MeasurementReport> {

    APINodeList<MeasurementReport> lastResponse = null;
    @Override
    public APINodeList<MeasurementReport> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filters",
      "report_type",
    };

    public static final String[] FIELDS = {
      "download_urls",
      "id",
      "metadata",
      "report_type",
      "status",
      "upload_urls",
    };

    @Override
    public APINodeList<MeasurementReport> parseResponse(String response) throws APIException {
      return MeasurementReport.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<MeasurementReport> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<MeasurementReport> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<MeasurementReport>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<MeasurementReport>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<MeasurementReport>>() {
           public APINodeList<MeasurementReport> apply(String result) {
             try {
               return APIRequestGetMeasurementReports.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetMeasurementReports(String nodeId, APIContext context) {
      super(context, nodeId, "/measurement_reports", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMeasurementReports setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMeasurementReports setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMeasurementReports setFilters (List<Object> filters) {
      this.setParam("filters", filters);
      return this;
    }
    public APIRequestGetMeasurementReports setFilters (String filters) {
      this.setParam("filters", filters);
      return this;
    }

    public APIRequestGetMeasurementReports setReportType (MeasurementReport.EnumReportType reportType) {
      this.setParam("report_type", reportType);
      return this;
    }
    public APIRequestGetMeasurementReports setReportType (String reportType) {
      this.setParam("report_type", reportType);
      return this;
    }

    public APIRequestGetMeasurementReports requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMeasurementReports requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMeasurementReports requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMeasurementReports requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMeasurementReports requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMeasurementReports requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetMeasurementReports requestDownloadUrlsField () {
      return this.requestDownloadUrlsField(true);
    }
    public APIRequestGetMeasurementReports requestDownloadUrlsField (boolean value) {
      this.requestField("download_urls", value);
      return this;
    }
    public APIRequestGetMeasurementReports requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetMeasurementReports requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetMeasurementReports requestMetadataField () {
      return this.requestMetadataField(true);
    }
    public APIRequestGetMeasurementReports requestMetadataField (boolean value) {
      this.requestField("metadata", value);
      return this;
    }
    public APIRequestGetMeasurementReports requestReportTypeField () {
      return this.requestReportTypeField(true);
    }
    public APIRequestGetMeasurementReports requestReportTypeField (boolean value) {
      this.requestField("report_type", value);
      return this;
    }
    public APIRequestGetMeasurementReports requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetMeasurementReports requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetMeasurementReports requestUploadUrlsField () {
      return this.requestUploadUrlsField(true);
    }
    public APIRequestGetMeasurementReports requestUploadUrlsField (boolean value) {
      this.requestField("upload_urls", value);
      return this;
    }
  }

  public static class APIRequestCreateMeasurementReport extends APIRequest<MeasurementReport> {

    MeasurementReport lastResponse = null;
    @Override
    public MeasurementReport getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "metadata",
      "report_type",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public MeasurementReport parseResponse(String response) throws APIException {
      return MeasurementReport.parseResponse(response, getContext(), this).head();
    }

    @Override
    public MeasurementReport execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MeasurementReport execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<MeasurementReport> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MeasurementReport> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, MeasurementReport>() {
           public MeasurementReport apply(String result) {
             try {
               return APIRequestCreateMeasurementReport.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateMeasurementReport(String nodeId, APIContext context) {
      super(context, nodeId, "/measurement_reports", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMeasurementReport setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMeasurementReport setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMeasurementReport setMetadata (String metadata) {
      this.setParam("metadata", metadata);
      return this;
    }

    public APIRequestCreateMeasurementReport setReportType (MeasurementReport.EnumReportType reportType) {
      this.setParam("report_type", reportType);
      return this;
    }
    public APIRequestCreateMeasurementReport setReportType (String reportType) {
      this.setParam("report_type", reportType);
      return this;
    }

    public APIRequestCreateMeasurementReport requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMeasurementReport requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMeasurementReport requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMeasurementReport requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMeasurementReport requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMeasurementReport requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetOfflineConversionDataSets extends APIRequest<OfflineConversionDataSet> {

    APINodeList<OfflineConversionDataSet> lastResponse = null;
    @Override
    public APINodeList<OfflineConversionDataSet> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "config",
      "creation_time",
      "data_origin",
      "description",
      "duplicate_entries",
      "enable_auto_assign_to_accounts",
      "event_stats",
      "event_time_max",
      "event_time_min",
      "id",
      "is_restricted_use",
      "last_upload_app",
      "match_rate_approx",
      "matched_entries",
      "name",
      "usage",
      "valid_entries",
    };

    @Override
    public APINodeList<OfflineConversionDataSet> parseResponse(String response) throws APIException {
      return OfflineConversionDataSet.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<OfflineConversionDataSet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<OfflineConversionDataSet> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<OfflineConversionDataSet>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<OfflineConversionDataSet>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<OfflineConversionDataSet>>() {
           public APINodeList<OfflineConversionDataSet> apply(String result) {
             try {
               return APIRequestGetOfflineConversionDataSets.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetOfflineConversionDataSets(String nodeId, APIContext context) {
      super(context, nodeId, "/offline_conversion_data_sets", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOfflineConversionDataSets setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOfflineConversionDataSets setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOfflineConversionDataSets requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOfflineConversionDataSets requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOfflineConversionDataSets requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOfflineConversionDataSets requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOfflineConversionDataSets requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOfflineConversionDataSets requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOfflineConversionDataSets requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestConfigField () {
      return this.requestConfigField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestConfigField (boolean value) {
      this.requestField("config", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestDataOriginField () {
      return this.requestDataOriginField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestDataOriginField (boolean value) {
      this.requestField("data_origin", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestDuplicateEntriesField () {
      return this.requestDuplicateEntriesField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestDuplicateEntriesField (boolean value) {
      this.requestField("duplicate_entries", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestEnableAutoAssignToAccountsField () {
      return this.requestEnableAutoAssignToAccountsField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestEnableAutoAssignToAccountsField (boolean value) {
      this.requestField("enable_auto_assign_to_accounts", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestEventStatsField () {
      return this.requestEventStatsField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestEventStatsField (boolean value) {
      this.requestField("event_stats", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestEventTimeMaxField () {
      return this.requestEventTimeMaxField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestEventTimeMaxField (boolean value) {
      this.requestField("event_time_max", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestEventTimeMinField () {
      return this.requestEventTimeMinField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestEventTimeMinField (boolean value) {
      this.requestField("event_time_min", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestIsRestrictedUseField () {
      return this.requestIsRestrictedUseField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestIsRestrictedUseField (boolean value) {
      this.requestField("is_restricted_use", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestLastUploadAppField () {
      return this.requestLastUploadAppField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestLastUploadAppField (boolean value) {
      this.requestField("last_upload_app", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestMatchRateApproxField () {
      return this.requestMatchRateApproxField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestMatchRateApproxField (boolean value) {
      this.requestField("match_rate_approx", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestMatchedEntriesField () {
      return this.requestMatchedEntriesField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestMatchedEntriesField (boolean value) {
      this.requestField("matched_entries", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestUsageField () {
      return this.requestUsageField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestUsageField (boolean value) {
      this.requestField("usage", value);
      return this;
    }
    public APIRequestGetOfflineConversionDataSets requestValidEntriesField () {
      return this.requestValidEntriesField(true);
    }
    public APIRequestGetOfflineConversionDataSets requestValidEntriesField (boolean value) {
      this.requestField("valid_entries", value);
      return this;
    }
  }

  public static class APIRequestCreateOfflineConversionDataSet extends APIRequest<OfflineConversionDataSet> {

    OfflineConversionDataSet lastResponse = null;
    @Override
    public OfflineConversionDataSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "auto_assign_to_new_accounts_only",
      "data_origin",
      "description",
      "enable_auto_assign_to_accounts",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public OfflineConversionDataSet parseResponse(String response) throws APIException {
      return OfflineConversionDataSet.parseResponse(response, getContext(), this).head();
    }

    @Override
    public OfflineConversionDataSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OfflineConversionDataSet execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<OfflineConversionDataSet> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<OfflineConversionDataSet> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, OfflineConversionDataSet>() {
           public OfflineConversionDataSet apply(String result) {
             try {
               return APIRequestCreateOfflineConversionDataSet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateOfflineConversionDataSet(String nodeId, APIContext context) {
      super(context, nodeId, "/offline_conversion_data_sets", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOfflineConversionDataSet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOfflineConversionDataSet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOfflineConversionDataSet setAutoAssignToNewAccountsOnly (Boolean autoAssignToNewAccountsOnly) {
      this.setParam("auto_assign_to_new_accounts_only", autoAssignToNewAccountsOnly);
      return this;
    }
    public APIRequestCreateOfflineConversionDataSet setAutoAssignToNewAccountsOnly (String autoAssignToNewAccountsOnly) {
      this.setParam("auto_assign_to_new_accounts_only", autoAssignToNewAccountsOnly);
      return this;
    }

    public APIRequestCreateOfflineConversionDataSet setDataOrigin (OfflineConversionDataSet.EnumDataOrigin dataOrigin) {
      this.setParam("data_origin", dataOrigin);
      return this;
    }
    public APIRequestCreateOfflineConversionDataSet setDataOrigin (String dataOrigin) {
      this.setParam("data_origin", dataOrigin);
      return this;
    }

    public APIRequestCreateOfflineConversionDataSet setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestCreateOfflineConversionDataSet setEnableAutoAssignToAccounts (Boolean enableAutoAssignToAccounts) {
      this.setParam("enable_auto_assign_to_accounts", enableAutoAssignToAccounts);
      return this;
    }
    public APIRequestCreateOfflineConversionDataSet setEnableAutoAssignToAccounts (String enableAutoAssignToAccounts) {
      this.setParam("enable_auto_assign_to_accounts", enableAutoAssignToAccounts);
      return this;
    }

    public APIRequestCreateOfflineConversionDataSet setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateOfflineConversionDataSet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOfflineConversionDataSet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOfflineConversionDataSet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOfflineConversionDataSet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOfflineConversionDataSet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOfflineConversionDataSet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetOwnedAdAccounts extends APIRequest<AdAccount> {

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
               return APIRequestGetOwnedAdAccounts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetOwnedAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_ad_accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedAdAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedAdAccounts requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAccountStatusField () {
      return this.requestAccountStatusField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAccountStatusField (boolean value) {
      this.requestField("account_status", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAgeField () {
      return this.requestAgeField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAgeField (boolean value) {
      this.requestField("age", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAgencyClientDeclarationField () {
      return this.requestAgencyClientDeclarationField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAgencyClientDeclarationField (boolean value) {
      this.requestField("agency_client_declaration", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAmountSpentField () {
      return this.requestAmountSpentField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAmountSpentField (boolean value) {
      this.requestField("amount_spent", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGetOwnedAdAccounts requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBalanceField () {
      return this.requestBalanceField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBalanceField (boolean value) {
      this.requestField("balance", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessCityField () {
      return this.requestBusinessCityField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessCityField (boolean value) {
      this.requestField("business_city", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessCountryCodeField () {
      return this.requestBusinessCountryCodeField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessCountryCodeField (boolean value) {
      this.requestField("business_country_code", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessNameField () {
      return this.requestBusinessNameField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessNameField (boolean value) {
      this.requestField("business_name", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStateField () {
      return this.requestBusinessStateField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStateField (boolean value) {
      this.requestField("business_state", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStreetField () {
      return this.requestBusinessStreetField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStreetField (boolean value) {
      this.requestField("business_street", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStreet2Field () {
      return this.requestBusinessStreet2Field(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessStreet2Field (boolean value) {
      this.requestField("business_street2", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestBusinessZipField () {
      return this.requestBusinessZipField(true);
    }
    public APIRequestGetOwnedAdAccounts requestBusinessZipField (boolean value) {
      this.requestField("business_zip", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestCapabilitiesField () {
      return this.requestCapabilitiesField(true);
    }
    public APIRequestGetOwnedAdAccounts requestCapabilitiesField (boolean value) {
      this.requestField("capabilities", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetOwnedAdAccounts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetOwnedAdAccounts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestDisableReasonField () {
      return this.requestDisableReasonField(true);
    }
    public APIRequestGetOwnedAdAccounts requestDisableReasonField (boolean value) {
      this.requestField("disable_reason", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestEndAdvertiserField () {
      return this.requestEndAdvertiserField(true);
    }
    public APIRequestGetOwnedAdAccounts requestEndAdvertiserField (boolean value) {
      this.requestField("end_advertiser", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestEndAdvertiserNameField () {
      return this.requestEndAdvertiserNameField(true);
    }
    public APIRequestGetOwnedAdAccounts requestEndAdvertiserNameField (boolean value) {
      this.requestField("end_advertiser_name", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestExtendedCreditInvoiceGroupField () {
      return this.requestExtendedCreditInvoiceGroupField(true);
    }
    public APIRequestGetOwnedAdAccounts requestExtendedCreditInvoiceGroupField (boolean value) {
      this.requestField("extended_credit_invoice_group", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetOwnedAdAccounts requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestFundingSourceField () {
      return this.requestFundingSourceField(true);
    }
    public APIRequestGetOwnedAdAccounts requestFundingSourceField (boolean value) {
      this.requestField("funding_source", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestFundingSourceDetailsField () {
      return this.requestFundingSourceDetailsField(true);
    }
    public APIRequestGetOwnedAdAccounts requestFundingSourceDetailsField (boolean value) {
      this.requestField("funding_source_details", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestHasMigratedPermissionsField () {
      return this.requestHasMigratedPermissionsField(true);
    }
    public APIRequestGetOwnedAdAccounts requestHasMigratedPermissionsField (boolean value) {
      this.requestField("has_migrated_permissions", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestHasPageAuthorizedAdaccountField () {
      return this.requestHasPageAuthorizedAdaccountField(true);
    }
    public APIRequestGetOwnedAdAccounts requestHasPageAuthorizedAdaccountField (boolean value) {
      this.requestField("has_page_authorized_adaccount", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsAttributionSpecSystemDefaultField () {
      return this.requestIsAttributionSpecSystemDefaultField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsAttributionSpecSystemDefaultField (boolean value) {
      this.requestField("is_attribution_spec_system_default", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsDirectDealsEnabledField () {
      return this.requestIsDirectDealsEnabledField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsDirectDealsEnabledField (boolean value) {
      this.requestField("is_direct_deals_enabled", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsInMiddleOfLocalEntityMigrationField () {
      return this.requestIsInMiddleOfLocalEntityMigrationField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsInMiddleOfLocalEntityMigrationField (boolean value) {
      this.requestField("is_in_middle_of_local_entity_migration", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsNotificationsEnabledField () {
      return this.requestIsNotificationsEnabledField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsNotificationsEnabledField (boolean value) {
      this.requestField("is_notifications_enabled", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsPersonalField () {
      return this.requestIsPersonalField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsPersonalField (boolean value) {
      this.requestField("is_personal", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsPrepayAccountField () {
      return this.requestIsPrepayAccountField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsPrepayAccountField (boolean value) {
      this.requestField("is_prepay_account", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestIsTaxIdRequiredField () {
      return this.requestIsTaxIdRequiredField(true);
    }
    public APIRequestGetOwnedAdAccounts requestIsTaxIdRequiredField (boolean value) {
      this.requestField("is_tax_id_required", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestLineNumbersField () {
      return this.requestLineNumbersField(true);
    }
    public APIRequestGetOwnedAdAccounts requestLineNumbersField (boolean value) {
      this.requestField("line_numbers", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestMediaAgencyField () {
      return this.requestMediaAgencyField(true);
    }
    public APIRequestGetOwnedAdAccounts requestMediaAgencyField (boolean value) {
      this.requestField("media_agency", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestMinCampaignGroupSpendCapField () {
      return this.requestMinCampaignGroupSpendCapField(true);
    }
    public APIRequestGetOwnedAdAccounts requestMinCampaignGroupSpendCapField (boolean value) {
      this.requestField("min_campaign_group_spend_cap", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestMinDailyBudgetField () {
      return this.requestMinDailyBudgetField(true);
    }
    public APIRequestGetOwnedAdAccounts requestMinDailyBudgetField (boolean value) {
      this.requestField("min_daily_budget", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOwnedAdAccounts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestOffsitePixelsTosAcceptedField () {
      return this.requestOffsitePixelsTosAcceptedField(true);
    }
    public APIRequestGetOwnedAdAccounts requestOffsitePixelsTosAcceptedField (boolean value) {
      this.requestField("offsite_pixels_tos_accepted", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetOwnedAdAccounts requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetOwnedAdAccounts requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestRateLimitResetTimeField () {
      return this.requestRateLimitResetTimeField(true);
    }
    public APIRequestGetOwnedAdAccounts requestRateLimitResetTimeField (boolean value) {
      this.requestField("rate_limit_reset_time", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGetOwnedAdAccounts requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestShowCheckoutExperienceField () {
      return this.requestShowCheckoutExperienceField(true);
    }
    public APIRequestGetOwnedAdAccounts requestShowCheckoutExperienceField (boolean value) {
      this.requestField("show_checkout_experience", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetOwnedAdAccounts requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdField () {
      return this.requestTaxIdField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdField (boolean value) {
      this.requestField("tax_id", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdStatusField () {
      return this.requestTaxIdStatusField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdStatusField (boolean value) {
      this.requestField("tax_id_status", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdTypeField () {
      return this.requestTaxIdTypeField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTaxIdTypeField (boolean value) {
      this.requestField("tax_id_type", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneNameField () {
      return this.requestTimezoneNameField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneNameField (boolean value) {
      this.requestField("timezone_name", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneOffsetHoursUtcField () {
      return this.requestTimezoneOffsetHoursUtcField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTimezoneOffsetHoursUtcField (boolean value) {
      this.requestField("timezone_offset_hours_utc", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestTosAcceptedField () {
      return this.requestTosAcceptedField(true);
    }
    public APIRequestGetOwnedAdAccounts requestTosAcceptedField (boolean value) {
      this.requestField("tos_accepted", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestUserRoleField () {
      return this.requestUserRoleField(true);
    }
    public APIRequestGetOwnedAdAccounts requestUserRoleField (boolean value) {
      this.requestField("user_role", value);
      return this;
    }
    public APIRequestGetOwnedAdAccounts requestUserTosAcceptedField () {
      return this.requestUserTosAcceptedField(true);
    }
    public APIRequestGetOwnedAdAccounts requestUserTosAcceptedField (boolean value) {
      this.requestField("user_tos_accepted", value);
      return this;
    }
  }

  public static class APIRequestCreateOwnedAdAccount extends APIRequest<AdAccount> {

    AdAccount lastResponse = null;
    @Override
    public AdAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adaccount_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdAccount parseResponse(String response) throws APIException {
      return AdAccount.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAccount execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccount execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdAccount> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccount> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdAccount>() {
           public AdAccount apply(String result) {
             try {
               return APIRequestCreateOwnedAdAccount.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateOwnedAdAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_ad_accounts", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOwnedAdAccount setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOwnedAdAccount setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOwnedAdAccount setAdaccountId (String adaccountId) {
      this.setParam("adaccount_id", adaccountId);
      return this;
    }

    public APIRequestCreateOwnedAdAccount requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOwnedAdAccount requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedAdAccount requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOwnedAdAccount requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedAdAccount requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOwnedAdAccount requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetOwnedApps extends APIRequest<APINode> {

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
               return APIRequestGetOwnedApps.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetOwnedApps(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_apps", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedApps setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedApps setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedApps requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedApps requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedApps requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedApps requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedApps requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedApps requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateOwnedApp extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_id",
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
               return APIRequestCreateOwnedApp.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateOwnedApp(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_apps", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOwnedApp setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOwnedApp setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOwnedApp setAppId (Object appId) {
      this.setParam("app_id", appId);
      return this;
    }
    public APIRequestCreateOwnedApp setAppId (String appId) {
      this.setParam("app_id", appId);
      return this;
    }

    public APIRequestCreateOwnedApp requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOwnedApp requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedApp requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOwnedApp requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedApp requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOwnedApp requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteOwnedBusinesses extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "client_id",
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
               return APIRequestDeleteOwnedBusinesses.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteOwnedBusinesses(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_businesses", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteOwnedBusinesses setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteOwnedBusinesses setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteOwnedBusinesses setClientId (Object clientId) {
      this.setParam("client_id", clientId);
      return this;
    }
    public APIRequestDeleteOwnedBusinesses setClientId (String clientId) {
      this.setParam("client_id", clientId);
      return this;
    }

    public APIRequestDeleteOwnedBusinesses requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteOwnedBusinesses requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteOwnedBusinesses requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteOwnedBusinesses requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteOwnedBusinesses requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteOwnedBusinesses requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetOwnedBusinesses extends APIRequest<Business> {

    APINodeList<Business> lastResponse = null;
    @Override
    public APINodeList<Business> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "client_user_id",
    };

    public static final String[] FIELDS = {
      "block_offline_analytics",
      "created_by",
      "created_time",
      "id",
      "link",
      "name",
      "primary_page",
      "profile_picture_uri",
      "timezone_id",
      "two_factor_type",
      "updated_by",
      "updated_time",
      "vertical",
    };

    @Override
    public APINodeList<Business> parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Business> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Business> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Business>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Business>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Business>>() {
           public APINodeList<Business> apply(String result) {
             try {
               return APIRequestGetOwnedBusinesses.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetOwnedBusinesses(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_businesses", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedBusinesses setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedBusinesses setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedBusinesses setClientUserId (Object clientUserId) {
      this.setParam("client_user_id", clientUserId);
      return this;
    }
    public APIRequestGetOwnedBusinesses setClientUserId (String clientUserId) {
      this.setParam("client_user_id", clientUserId);
      return this;
    }

    public APIRequestGetOwnedBusinesses requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedBusinesses requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedBusinesses requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedBusinesses requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedBusinesses requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedBusinesses requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedBusinesses requestBlockOfflineAnalyticsField () {
      return this.requestBlockOfflineAnalyticsField(true);
    }
    public APIRequestGetOwnedBusinesses requestBlockOfflineAnalyticsField (boolean value) {
      this.requestField("block_offline_analytics", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetOwnedBusinesses requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetOwnedBusinesses requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedBusinesses requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetOwnedBusinesses requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOwnedBusinesses requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestPrimaryPageField () {
      return this.requestPrimaryPageField(true);
    }
    public APIRequestGetOwnedBusinesses requestPrimaryPageField (boolean value) {
      this.requestField("primary_page", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestProfilePictureUriField () {
      return this.requestProfilePictureUriField(true);
    }
    public APIRequestGetOwnedBusinesses requestProfilePictureUriField (boolean value) {
      this.requestField("profile_picture_uri", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetOwnedBusinesses requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestTwoFactorTypeField () {
      return this.requestTwoFactorTypeField(true);
    }
    public APIRequestGetOwnedBusinesses requestTwoFactorTypeField (boolean value) {
      this.requestField("two_factor_type", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetOwnedBusinesses requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetOwnedBusinesses requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetOwnedBusinesses requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetOwnedBusinesses requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
  }

  public static class APIRequestCreateOwnedBusiness extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
      "page_permitted_roles",
      "sales_rep_email",
      "shared_page_id",
      "survey_business_type",
      "survey_num_assets",
      "survey_num_people",
      "timezone_id",
      "vertical",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
             try {
               return APIRequestCreateOwnedBusiness.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateOwnedBusiness(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_businesses", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOwnedBusiness setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOwnedBusiness setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOwnedBusiness setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateOwnedBusiness setPagePermittedRoles (List<Business.EnumPagePermittedRoles> pagePermittedRoles) {
      this.setParam("page_permitted_roles", pagePermittedRoles);
      return this;
    }
    public APIRequestCreateOwnedBusiness setPagePermittedRoles (String pagePermittedRoles) {
      this.setParam("page_permitted_roles", pagePermittedRoles);
      return this;
    }

    public APIRequestCreateOwnedBusiness setSalesRepEmail (String salesRepEmail) {
      this.setParam("sales_rep_email", salesRepEmail);
      return this;
    }

    public APIRequestCreateOwnedBusiness setSharedPageId (Object sharedPageId) {
      this.setParam("shared_page_id", sharedPageId);
      return this;
    }
    public APIRequestCreateOwnedBusiness setSharedPageId (String sharedPageId) {
      this.setParam("shared_page_id", sharedPageId);
      return this;
    }

    public APIRequestCreateOwnedBusiness setSurveyBusinessType (Business.EnumSurveyBusinessType surveyBusinessType) {
      this.setParam("survey_business_type", surveyBusinessType);
      return this;
    }
    public APIRequestCreateOwnedBusiness setSurveyBusinessType (String surveyBusinessType) {
      this.setParam("survey_business_type", surveyBusinessType);
      return this;
    }

    public APIRequestCreateOwnedBusiness setSurveyNumAssets (Long surveyNumAssets) {
      this.setParam("survey_num_assets", surveyNumAssets);
      return this;
    }
    public APIRequestCreateOwnedBusiness setSurveyNumAssets (String surveyNumAssets) {
      this.setParam("survey_num_assets", surveyNumAssets);
      return this;
    }

    public APIRequestCreateOwnedBusiness setSurveyNumPeople (Long surveyNumPeople) {
      this.setParam("survey_num_people", surveyNumPeople);
      return this;
    }
    public APIRequestCreateOwnedBusiness setSurveyNumPeople (String surveyNumPeople) {
      this.setParam("survey_num_people", surveyNumPeople);
      return this;
    }

    public APIRequestCreateOwnedBusiness setTimezoneId (Long timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }
    public APIRequestCreateOwnedBusiness setTimezoneId (String timezoneId) {
      this.setParam("timezone_id", timezoneId);
      return this;
    }

    public APIRequestCreateOwnedBusiness setVertical (Business.EnumVertical vertical) {
      this.setParam("vertical", vertical);
      return this;
    }
    public APIRequestCreateOwnedBusiness setVertical (String vertical) {
      this.setParam("vertical", vertical);
      return this;
    }

    public APIRequestCreateOwnedBusiness requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOwnedBusiness requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedBusiness requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOwnedBusiness requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedBusiness requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOwnedBusiness requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateOwnedDomain extends APIRequest<OwnedDomain> {

    OwnedDomain lastResponse = null;
    @Override
    public OwnedDomain getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "domain_name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public OwnedDomain parseResponse(String response) throws APIException {
      return OwnedDomain.parseResponse(response, getContext(), this).head();
    }

    @Override
    public OwnedDomain execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OwnedDomain execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<OwnedDomain> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<OwnedDomain> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, OwnedDomain>() {
           public OwnedDomain apply(String result) {
             try {
               return APIRequestCreateOwnedDomain.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateOwnedDomain(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_domains", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOwnedDomain setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOwnedDomain setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOwnedDomain setDomainName (String domainName) {
      this.setParam("domain_name", domainName);
      return this;
    }

    public APIRequestCreateOwnedDomain requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOwnedDomain requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedDomain requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOwnedDomain requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedDomain requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOwnedDomain requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetOwnedInstagramAccounts extends APIRequest<APINode> {

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
               return APIRequestGetOwnedInstagramAccounts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetOwnedInstagramAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_instagram_accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedInstagramAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedInstagramAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedInstagramAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedInstagramAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedInstagramAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedInstagramAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedInstagramAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedInstagramAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetOwnedPages extends APIRequest<Page> {

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
               return APIRequestGetOwnedPages.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetOwnedPages(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_pages", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedPages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedPages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedPages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedPages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedPages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedPages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedPages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedPages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedPages requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetOwnedPages requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetOwnedPages requestAccessTokenField () {
      return this.requestAccessTokenField(true);
    }
    public APIRequestGetOwnedPages requestAccessTokenField (boolean value) {
      this.requestField("access_token", value);
      return this;
    }
    public APIRequestGetOwnedPages requestAdCampaignField () {
      return this.requestAdCampaignField(true);
    }
    public APIRequestGetOwnedPages requestAdCampaignField (boolean value) {
      this.requestField("ad_campaign", value);
      return this;
    }
    public APIRequestGetOwnedPages requestAffiliationField () {
      return this.requestAffiliationField(true);
    }
    public APIRequestGetOwnedPages requestAffiliationField (boolean value) {
      this.requestField("affiliation", value);
      return this;
    }
    public APIRequestGetOwnedPages requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetOwnedPages requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetOwnedPages requestAppLinksField () {
      return this.requestAppLinksField(true);
    }
    public APIRequestGetOwnedPages requestAppLinksField (boolean value) {
      this.requestField("app_links", value);
      return this;
    }
    public APIRequestGetOwnedPages requestArtistsWeLikeField () {
      return this.requestArtistsWeLikeField(true);
    }
    public APIRequestGetOwnedPages requestArtistsWeLikeField (boolean value) {
      this.requestField("artists_we_like", value);
      return this;
    }
    public APIRequestGetOwnedPages requestAttireField () {
      return this.requestAttireField(true);
    }
    public APIRequestGetOwnedPages requestAttireField (boolean value) {
      this.requestField("attire", value);
      return this;
    }
    public APIRequestGetOwnedPages requestAwardsField () {
      return this.requestAwardsField(true);
    }
    public APIRequestGetOwnedPages requestAwardsField (boolean value) {
      this.requestField("awards", value);
      return this;
    }
    public APIRequestGetOwnedPages requestBandInterestsField () {
      return this.requestBandInterestsField(true);
    }
    public APIRequestGetOwnedPages requestBandInterestsField (boolean value) {
      this.requestField("band_interests", value);
      return this;
    }
    public APIRequestGetOwnedPages requestBandMembersField () {
      return this.requestBandMembersField(true);
    }
    public APIRequestGetOwnedPages requestBandMembersField (boolean value) {
      this.requestField("band_members", value);
      return this;
    }
    public APIRequestGetOwnedPages requestBestPageField () {
      return this.requestBestPageField(true);
    }
    public APIRequestGetOwnedPages requestBestPageField (boolean value) {
      this.requestField("best_page", value);
      return this;
    }
    public APIRequestGetOwnedPages requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetOwnedPages requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetOwnedPages requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetOwnedPages requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetOwnedPages requestBookingAgentField () {
      return this.requestBookingAgentField(true);
    }
    public APIRequestGetOwnedPages requestBookingAgentField (boolean value) {
      this.requestField("booking_agent", value);
      return this;
    }
    public APIRequestGetOwnedPages requestBuiltField () {
      return this.requestBuiltField(true);
    }
    public APIRequestGetOwnedPages requestBuiltField (boolean value) {
      this.requestField("built", value);
      return this;
    }
    public APIRequestGetOwnedPages requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetOwnedPages requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCanCheckinField () {
      return this.requestCanCheckinField(true);
    }
    public APIRequestGetOwnedPages requestCanCheckinField (boolean value) {
      this.requestField("can_checkin", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetOwnedPages requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetOwnedPages requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCategoryListField () {
      return this.requestCategoryListField(true);
    }
    public APIRequestGetOwnedPages requestCategoryListField (boolean value) {
      this.requestField("category_list", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCheckinsField () {
      return this.requestCheckinsField(true);
    }
    public APIRequestGetOwnedPages requestCheckinsField (boolean value) {
      this.requestField("checkins", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCompanyOverviewField () {
      return this.requestCompanyOverviewField(true);
    }
    public APIRequestGetOwnedPages requestCompanyOverviewField (boolean value) {
      this.requestField("company_overview", value);
      return this;
    }
    public APIRequestGetOwnedPages requestConnectedInstagramAccountField () {
      return this.requestConnectedInstagramAccountField(true);
    }
    public APIRequestGetOwnedPages requestConnectedInstagramAccountField (boolean value) {
      this.requestField("connected_instagram_account", value);
      return this;
    }
    public APIRequestGetOwnedPages requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetOwnedPages requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetOwnedPages requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetOwnedPages requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCopyrightAttributionInsightsField () {
      return this.requestCopyrightAttributionInsightsField(true);
    }
    public APIRequestGetOwnedPages requestCopyrightAttributionInsightsField (boolean value) {
      this.requestField("copyright_attribution_insights", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCopyrightWhitelistedIgPartnersField () {
      return this.requestCopyrightWhitelistedIgPartnersField(true);
    }
    public APIRequestGetOwnedPages requestCopyrightWhitelistedIgPartnersField (boolean value) {
      this.requestField("copyright_whitelisted_ig_partners", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCountryPageLikesField () {
      return this.requestCountryPageLikesField(true);
    }
    public APIRequestGetOwnedPages requestCountryPageLikesField (boolean value) {
      this.requestField("country_page_likes", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetOwnedPages requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCulinaryTeamField () {
      return this.requestCulinaryTeamField(true);
    }
    public APIRequestGetOwnedPages requestCulinaryTeamField (boolean value) {
      this.requestField("culinary_team", value);
      return this;
    }
    public APIRequestGetOwnedPages requestCurrentLocationField () {
      return this.requestCurrentLocationField(true);
    }
    public APIRequestGetOwnedPages requestCurrentLocationField (boolean value) {
      this.requestField("current_location", value);
      return this;
    }
    public APIRequestGetOwnedPages requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetOwnedPages requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetOwnedPages requestDescriptionHtmlField () {
      return this.requestDescriptionHtmlField(true);
    }
    public APIRequestGetOwnedPages requestDescriptionHtmlField (boolean value) {
      this.requestField("description_html", value);
      return this;
    }
    public APIRequestGetOwnedPages requestDirectedByField () {
      return this.requestDirectedByField(true);
    }
    public APIRequestGetOwnedPages requestDirectedByField (boolean value) {
      this.requestField("directed_by", value);
      return this;
    }
    public APIRequestGetOwnedPages requestDisplaySubtextField () {
      return this.requestDisplaySubtextField(true);
    }
    public APIRequestGetOwnedPages requestDisplaySubtextField (boolean value) {
      this.requestField("display_subtext", value);
      return this;
    }
    public APIRequestGetOwnedPages requestDisplayedMessageResponseTimeField () {
      return this.requestDisplayedMessageResponseTimeField(true);
    }
    public APIRequestGetOwnedPages requestDisplayedMessageResponseTimeField (boolean value) {
      this.requestField("displayed_message_response_time", value);
      return this;
    }
    public APIRequestGetOwnedPages requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetOwnedPages requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetOwnedPages requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGetOwnedPages requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGetOwnedPages requestFanCountField () {
      return this.requestFanCountField(true);
    }
    public APIRequestGetOwnedPages requestFanCountField (boolean value) {
      this.requestField("fan_count", value);
      return this;
    }
    public APIRequestGetOwnedPages requestFeaturedVideoField () {
      return this.requestFeaturedVideoField(true);
    }
    public APIRequestGetOwnedPages requestFeaturedVideoField (boolean value) {
      this.requestField("featured_video", value);
      return this;
    }
    public APIRequestGetOwnedPages requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetOwnedPages requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetOwnedPages requestFoodStylesField () {
      return this.requestFoodStylesField(true);
    }
    public APIRequestGetOwnedPages requestFoodStylesField (boolean value) {
      this.requestField("food_styles", value);
      return this;
    }
    public APIRequestGetOwnedPages requestFoundedField () {
      return this.requestFoundedField(true);
    }
    public APIRequestGetOwnedPages requestFoundedField (boolean value) {
      this.requestField("founded", value);
      return this;
    }
    public APIRequestGetOwnedPages requestGeneralInfoField () {
      return this.requestGeneralInfoField(true);
    }
    public APIRequestGetOwnedPages requestGeneralInfoField (boolean value) {
      this.requestField("general_info", value);
      return this;
    }
    public APIRequestGetOwnedPages requestGeneralManagerField () {
      return this.requestGeneralManagerField(true);
    }
    public APIRequestGetOwnedPages requestGeneralManagerField (boolean value) {
      this.requestField("general_manager", value);
      return this;
    }
    public APIRequestGetOwnedPages requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGetOwnedPages requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGetOwnedPages requestGlobalBrandPageNameField () {
      return this.requestGlobalBrandPageNameField(true);
    }
    public APIRequestGetOwnedPages requestGlobalBrandPageNameField (boolean value) {
      this.requestField("global_brand_page_name", value);
      return this;
    }
    public APIRequestGetOwnedPages requestGlobalBrandRootIdField () {
      return this.requestGlobalBrandRootIdField(true);
    }
    public APIRequestGetOwnedPages requestGlobalBrandRootIdField (boolean value) {
      this.requestField("global_brand_root_id", value);
      return this;
    }
    public APIRequestGetOwnedPages requestHasAddedAppField () {
      return this.requestHasAddedAppField(true);
    }
    public APIRequestGetOwnedPages requestHasAddedAppField (boolean value) {
      this.requestField("has_added_app", value);
      return this;
    }
    public APIRequestGetOwnedPages requestHasWhatsappNumberField () {
      return this.requestHasWhatsappNumberField(true);
    }
    public APIRequestGetOwnedPages requestHasWhatsappNumberField (boolean value) {
      this.requestField("has_whatsapp_number", value);
      return this;
    }
    public APIRequestGetOwnedPages requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetOwnedPages requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetOwnedPages requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGetOwnedPages requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedPages requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedPages requestImpressumField () {
      return this.requestImpressumField(true);
    }
    public APIRequestGetOwnedPages requestImpressumField (boolean value) {
      this.requestField("impressum", value);
      return this;
    }
    public APIRequestGetOwnedPages requestInfluencesField () {
      return this.requestInfluencesField(true);
    }
    public APIRequestGetOwnedPages requestInfluencesField (boolean value) {
      this.requestField("influences", value);
      return this;
    }
    public APIRequestGetOwnedPages requestInstagramBusinessAccountField () {
      return this.requestInstagramBusinessAccountField(true);
    }
    public APIRequestGetOwnedPages requestInstagramBusinessAccountField (boolean value) {
      this.requestField("instagram_business_account", value);
      return this;
    }
    public APIRequestGetOwnedPages requestInstantArticlesReviewStatusField () {
      return this.requestInstantArticlesReviewStatusField(true);
    }
    public APIRequestGetOwnedPages requestInstantArticlesReviewStatusField (boolean value) {
      this.requestField("instant_articles_review_status", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetOwnedPages requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsChainField () {
      return this.requestIsChainField(true);
    }
    public APIRequestGetOwnedPages requestIsChainField (boolean value) {
      this.requestField("is_chain", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsCommunityPageField () {
      return this.requestIsCommunityPageField(true);
    }
    public APIRequestGetOwnedPages requestIsCommunityPageField (boolean value) {
      this.requestField("is_community_page", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsEligibleForBrandedContentField () {
      return this.requestIsEligibleForBrandedContentField(true);
    }
    public APIRequestGetOwnedPages requestIsEligibleForBrandedContentField (boolean value) {
      this.requestField("is_eligible_for_branded_content", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsMessengerBotGetStartedEnabledField () {
      return this.requestIsMessengerBotGetStartedEnabledField(true);
    }
    public APIRequestGetOwnedPages requestIsMessengerBotGetStartedEnabledField (boolean value) {
      this.requestField("is_messenger_bot_get_started_enabled", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsMessengerPlatformBotField () {
      return this.requestIsMessengerPlatformBotField(true);
    }
    public APIRequestGetOwnedPages requestIsMessengerPlatformBotField (boolean value) {
      this.requestField("is_messenger_platform_bot", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsOwnedField () {
      return this.requestIsOwnedField(true);
    }
    public APIRequestGetOwnedPages requestIsOwnedField (boolean value) {
      this.requestField("is_owned", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsPermanentlyClosedField () {
      return this.requestIsPermanentlyClosedField(true);
    }
    public APIRequestGetOwnedPages requestIsPermanentlyClosedField (boolean value) {
      this.requestField("is_permanently_closed", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetOwnedPages requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsUnclaimedField () {
      return this.requestIsUnclaimedField(true);
    }
    public APIRequestGetOwnedPages requestIsUnclaimedField (boolean value) {
      this.requestField("is_unclaimed", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetOwnedPages requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetOwnedPages requestIsWebhooksSubscribedField () {
      return this.requestIsWebhooksSubscribedField(true);
    }
    public APIRequestGetOwnedPages requestIsWebhooksSubscribedField (boolean value) {
      this.requestField("is_webhooks_subscribed", value);
      return this;
    }
    public APIRequestGetOwnedPages requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGetOwnedPages requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGetOwnedPages requestLeadgenFormPreviewDetailsField () {
      return this.requestLeadgenFormPreviewDetailsField(true);
    }
    public APIRequestGetOwnedPages requestLeadgenFormPreviewDetailsField (boolean value) {
      this.requestField("leadgen_form_preview_details", value);
      return this;
    }
    public APIRequestGetOwnedPages requestLeadgenHasCrmIntegrationField () {
      return this.requestLeadgenHasCrmIntegrationField(true);
    }
    public APIRequestGetOwnedPages requestLeadgenHasCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_crm_integration", value);
      return this;
    }
    public APIRequestGetOwnedPages requestLeadgenHasFatPingCrmIntegrationField () {
      return this.requestLeadgenHasFatPingCrmIntegrationField(true);
    }
    public APIRequestGetOwnedPages requestLeadgenHasFatPingCrmIntegrationField (boolean value) {
      this.requestField("leadgen_has_fat_ping_crm_integration", value);
      return this;
    }
    public APIRequestGetOwnedPages requestLeadgenTosAcceptanceTimeField () {
      return this.requestLeadgenTosAcceptanceTimeField(true);
    }
    public APIRequestGetOwnedPages requestLeadgenTosAcceptanceTimeField (boolean value) {
      this.requestField("leadgen_tos_acceptance_time", value);
      return this;
    }
    public APIRequestGetOwnedPages requestLeadgenTosAcceptedField () {
      return this.requestLeadgenTosAcceptedField(true);
    }
    public APIRequestGetOwnedPages requestLeadgenTosAcceptedField (boolean value) {
      this.requestField("leadgen_tos_accepted", value);
      return this;
    }
    public APIRequestGetOwnedPages requestLeadgenTosAcceptingUserField () {
      return this.requestLeadgenTosAcceptingUserField(true);
    }
    public APIRequestGetOwnedPages requestLeadgenTosAcceptingUserField (boolean value) {
      this.requestField("leadgen_tos_accepting_user", value);
      return this;
    }
    public APIRequestGetOwnedPages requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetOwnedPages requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetOwnedPages requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetOwnedPages requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMembersField () {
      return this.requestMembersField(true);
    }
    public APIRequestGetOwnedPages requestMembersField (boolean value) {
      this.requestField("members", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetOwnedPages requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMerchantReviewStatusField () {
      return this.requestMerchantReviewStatusField(true);
    }
    public APIRequestGetOwnedPages requestMerchantReviewStatusField (boolean value) {
      this.requestField("merchant_review_status", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetOwnedPages requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMessengerAdsDefaultPageWelcomeMessageField () {
      return this.requestMessengerAdsDefaultPageWelcomeMessageField(true);
    }
    public APIRequestGetOwnedPages requestMessengerAdsDefaultPageWelcomeMessageField (boolean value) {
      this.requestField("messenger_ads_default_page_welcome_message", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMessengerAdsDefaultQuickRepliesField () {
      return this.requestMessengerAdsDefaultQuickRepliesField(true);
    }
    public APIRequestGetOwnedPages requestMessengerAdsDefaultQuickRepliesField (boolean value) {
      this.requestField("messenger_ads_default_quick_replies", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMessengerAdsQuickRepliesTypeField () {
      return this.requestMessengerAdsQuickRepliesTypeField(true);
    }
    public APIRequestGetOwnedPages requestMessengerAdsQuickRepliesTypeField (boolean value) {
      this.requestField("messenger_ads_quick_replies_type", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMissionField () {
      return this.requestMissionField(true);
    }
    public APIRequestGetOwnedPages requestMissionField (boolean value) {
      this.requestField("mission", value);
      return this;
    }
    public APIRequestGetOwnedPages requestMpgField () {
      return this.requestMpgField(true);
    }
    public APIRequestGetOwnedPages requestMpgField (boolean value) {
      this.requestField("mpg", value);
      return this;
    }
    public APIRequestGetOwnedPages requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOwnedPages requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOwnedPages requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGetOwnedPages requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGetOwnedPages requestNetworkField () {
      return this.requestNetworkField(true);
    }
    public APIRequestGetOwnedPages requestNetworkField (boolean value) {
      this.requestField("network", value);
      return this;
    }
    public APIRequestGetOwnedPages requestNewLikeCountField () {
      return this.requestNewLikeCountField(true);
    }
    public APIRequestGetOwnedPages requestNewLikeCountField (boolean value) {
      this.requestField("new_like_count", value);
      return this;
    }
    public APIRequestGetOwnedPages requestOfferEligibleField () {
      return this.requestOfferEligibleField(true);
    }
    public APIRequestGetOwnedPages requestOfferEligibleField (boolean value) {
      this.requestField("offer_eligible", value);
      return this;
    }
    public APIRequestGetOwnedPages requestOverallStarRatingField () {
      return this.requestOverallStarRatingField(true);
    }
    public APIRequestGetOwnedPages requestOverallStarRatingField (boolean value) {
      this.requestField("overall_star_rating", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPageTokenField () {
      return this.requestPageTokenField(true);
    }
    public APIRequestGetOwnedPages requestPageTokenField (boolean value) {
      this.requestField("page_token", value);
      return this;
    }
    public APIRequestGetOwnedPages requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetOwnedPages requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGetOwnedPages requestParkingField () {
      return this.requestParkingField(true);
    }
    public APIRequestGetOwnedPages requestParkingField (boolean value) {
      this.requestField("parking", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPaymentOptionsField () {
      return this.requestPaymentOptionsField(true);
    }
    public APIRequestGetOwnedPages requestPaymentOptionsField (boolean value) {
      this.requestField("payment_options", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPersonalInfoField () {
      return this.requestPersonalInfoField(true);
    }
    public APIRequestGetOwnedPages requestPersonalInfoField (boolean value) {
      this.requestField("personal_info", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPersonalInterestsField () {
      return this.requestPersonalInterestsField(true);
    }
    public APIRequestGetOwnedPages requestPersonalInterestsField (boolean value) {
      this.requestField("personal_interests", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPharmaSafetyInfoField () {
      return this.requestPharmaSafetyInfoField(true);
    }
    public APIRequestGetOwnedPages requestPharmaSafetyInfoField (boolean value) {
      this.requestField("pharma_safety_info", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetOwnedPages requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPlaceTypeField () {
      return this.requestPlaceTypeField(true);
    }
    public APIRequestGetOwnedPages requestPlaceTypeField (boolean value) {
      this.requestField("place_type", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPlotOutlineField () {
      return this.requestPlotOutlineField(true);
    }
    public APIRequestGetOwnedPages requestPlotOutlineField (boolean value) {
      this.requestField("plot_outline", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPreferredAudienceField () {
      return this.requestPreferredAudienceField(true);
    }
    public APIRequestGetOwnedPages requestPreferredAudienceField (boolean value) {
      this.requestField("preferred_audience", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPressContactField () {
      return this.requestPressContactField(true);
    }
    public APIRequestGetOwnedPages requestPressContactField (boolean value) {
      this.requestField("press_contact", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGetOwnedPages requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGetOwnedPages requestProducedByField () {
      return this.requestProducedByField(true);
    }
    public APIRequestGetOwnedPages requestProducedByField (boolean value) {
      this.requestField("produced_by", value);
      return this;
    }
    public APIRequestGetOwnedPages requestProductsField () {
      return this.requestProductsField(true);
    }
    public APIRequestGetOwnedPages requestProductsField (boolean value) {
      this.requestField("products", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPromotionEligibleField () {
      return this.requestPromotionEligibleField(true);
    }
    public APIRequestGetOwnedPages requestPromotionEligibleField (boolean value) {
      this.requestField("promotion_eligible", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPromotionIneligibleReasonField () {
      return this.requestPromotionIneligibleReasonField(true);
    }
    public APIRequestGetOwnedPages requestPromotionIneligibleReasonField (boolean value) {
      this.requestField("promotion_ineligible_reason", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPublicTransitField () {
      return this.requestPublicTransitField(true);
    }
    public APIRequestGetOwnedPages requestPublicTransitField (boolean value) {
      this.requestField("public_transit", value);
      return this;
    }
    public APIRequestGetOwnedPages requestPublisherSpaceField () {
      return this.requestPublisherSpaceField(true);
    }
    public APIRequestGetOwnedPages requestPublisherSpaceField (boolean value) {
      this.requestField("publisher_space", value);
      return this;
    }
    public APIRequestGetOwnedPages requestRatingCountField () {
      return this.requestRatingCountField(true);
    }
    public APIRequestGetOwnedPages requestRatingCountField (boolean value) {
      this.requestField("rating_count", value);
      return this;
    }
    public APIRequestGetOwnedPages requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetOwnedPages requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetOwnedPages requestRecordLabelField () {
      return this.requestRecordLabelField(true);
    }
    public APIRequestGetOwnedPages requestRecordLabelField (boolean value) {
      this.requestField("record_label", value);
      return this;
    }
    public APIRequestGetOwnedPages requestReleaseDateField () {
      return this.requestReleaseDateField(true);
    }
    public APIRequestGetOwnedPages requestReleaseDateField (boolean value) {
      this.requestField("release_date", value);
      return this;
    }
    public APIRequestGetOwnedPages requestRestaurantServicesField () {
      return this.requestRestaurantServicesField(true);
    }
    public APIRequestGetOwnedPages requestRestaurantServicesField (boolean value) {
      this.requestField("restaurant_services", value);
      return this;
    }
    public APIRequestGetOwnedPages requestRestaurantSpecialtiesField () {
      return this.requestRestaurantSpecialtiesField(true);
    }
    public APIRequestGetOwnedPages requestRestaurantSpecialtiesField (boolean value) {
      this.requestField("restaurant_specialties", value);
      return this;
    }
    public APIRequestGetOwnedPages requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetOwnedPages requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGetOwnedPages requestScreenplayByField () {
      return this.requestScreenplayByField(true);
    }
    public APIRequestGetOwnedPages requestScreenplayByField (boolean value) {
      this.requestField("screenplay_by", value);
      return this;
    }
    public APIRequestGetOwnedPages requestSeasonField () {
      return this.requestSeasonField(true);
    }
    public APIRequestGetOwnedPages requestSeasonField (boolean value) {
      this.requestField("season", value);
      return this;
    }
    public APIRequestGetOwnedPages requestSingleLineAddressField () {
      return this.requestSingleLineAddressField(true);
    }
    public APIRequestGetOwnedPages requestSingleLineAddressField (boolean value) {
      this.requestField("single_line_address", value);
      return this;
    }
    public APIRequestGetOwnedPages requestStarringField () {
      return this.requestStarringField(true);
    }
    public APIRequestGetOwnedPages requestStarringField (boolean value) {
      this.requestField("starring", value);
      return this;
    }
    public APIRequestGetOwnedPages requestStartInfoField () {
      return this.requestStartInfoField(true);
    }
    public APIRequestGetOwnedPages requestStartInfoField (boolean value) {
      this.requestField("start_info", value);
      return this;
    }
    public APIRequestGetOwnedPages requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGetOwnedPages requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGetOwnedPages requestStoreLocationDescriptorField () {
      return this.requestStoreLocationDescriptorField(true);
    }
    public APIRequestGetOwnedPages requestStoreLocationDescriptorField (boolean value) {
      this.requestField("store_location_descriptor", value);
      return this;
    }
    public APIRequestGetOwnedPages requestStoreNumberField () {
      return this.requestStoreNumberField(true);
    }
    public APIRequestGetOwnedPages requestStoreNumberField (boolean value) {
      this.requestField("store_number", value);
      return this;
    }
    public APIRequestGetOwnedPages requestStudioField () {
      return this.requestStudioField(true);
    }
    public APIRequestGetOwnedPages requestStudioField (boolean value) {
      this.requestField("studio", value);
      return this;
    }
    public APIRequestGetOwnedPages requestSupportsInstantArticlesField () {
      return this.requestSupportsInstantArticlesField(true);
    }
    public APIRequestGetOwnedPages requestSupportsInstantArticlesField (boolean value) {
      this.requestField("supports_instant_articles", value);
      return this;
    }
    public APIRequestGetOwnedPages requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetOwnedPages requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
      return this;
    }
    public APIRequestGetOwnedPages requestUnreadMessageCountField () {
      return this.requestUnreadMessageCountField(true);
    }
    public APIRequestGetOwnedPages requestUnreadMessageCountField (boolean value) {
      this.requestField("unread_message_count", value);
      return this;
    }
    public APIRequestGetOwnedPages requestUnreadNotifCountField () {
      return this.requestUnreadNotifCountField(true);
    }
    public APIRequestGetOwnedPages requestUnreadNotifCountField (boolean value) {
      this.requestField("unread_notif_count", value);
      return this;
    }
    public APIRequestGetOwnedPages requestUnseenMessageCountField () {
      return this.requestUnseenMessageCountField(true);
    }
    public APIRequestGetOwnedPages requestUnseenMessageCountField (boolean value) {
      this.requestField("unseen_message_count", value);
      return this;
    }
    public APIRequestGetOwnedPages requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetOwnedPages requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetOwnedPages requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetOwnedPages requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetOwnedPages requestVoipInfoField () {
      return this.requestVoipInfoField(true);
    }
    public APIRequestGetOwnedPages requestVoipInfoField (boolean value) {
      this.requestField("voip_info", value);
      return this;
    }
    public APIRequestGetOwnedPages requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetOwnedPages requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetOwnedPages requestWereHereCountField () {
      return this.requestWereHereCountField(true);
    }
    public APIRequestGetOwnedPages requestWereHereCountField (boolean value) {
      this.requestField("were_here_count", value);
      return this;
    }
    public APIRequestGetOwnedPages requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGetOwnedPages requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
      return this;
    }
    public APIRequestGetOwnedPages requestWrittenByField () {
      return this.requestWrittenByField(true);
    }
    public APIRequestGetOwnedPages requestWrittenByField (boolean value) {
      this.requestField("written_by", value);
      return this;
    }
  }

  public static class APIRequestCreateOwnedPage extends APIRequest<Page> {

    Page lastResponse = null;
    @Override
    public Page getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ig_password",
      "page_id",
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
               return APIRequestCreateOwnedPage.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateOwnedPage(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_pages", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOwnedPage setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOwnedPage setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOwnedPage setIgPassword (String igPassword) {
      this.setParam("ig_password", igPassword);
      return this;
    }

    public APIRequestCreateOwnedPage setPageId (Long pageId) {
      this.setParam("page_id", pageId);
      return this;
    }
    public APIRequestCreateOwnedPage setPageId (String pageId) {
      this.setParam("page_id", pageId);
      return this;
    }

    public APIRequestCreateOwnedPage requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOwnedPage requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedPage requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOwnedPage requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedPage requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOwnedPage requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetOwnedPixels extends APIRequest<AdsPixel> {

    APINodeList<AdsPixel> lastResponse = null;
    @Override
    public APINodeList<AdsPixel> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "can_proxy",
      "code",
      "creation_time",
      "creator",
      "id",
      "is_created_by_business",
      "last_fired_time",
      "name",
      "owner_ad_account",
      "owner_business",
    };

    @Override
    public APINodeList<AdsPixel> parseResponse(String response) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdsPixel> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsPixel> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsPixel>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdsPixel>>() {
           public APINodeList<AdsPixel> apply(String result) {
             try {
               return APIRequestGetOwnedPixels.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetOwnedPixels(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_pixels", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedPixels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedPixels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedPixels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedPixels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedPixels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedPixels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedPixels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedPixels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedPixels requestCanProxyField () {
      return this.requestCanProxyField(true);
    }
    public APIRequestGetOwnedPixels requestCanProxyField (boolean value) {
      this.requestField("can_proxy", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestCodeField () {
      return this.requestCodeField(true);
    }
    public APIRequestGetOwnedPixels requestCodeField (boolean value) {
      this.requestField("code", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetOwnedPixels requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetOwnedPixels requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedPixels requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestIsCreatedByBusinessField () {
      return this.requestIsCreatedByBusinessField(true);
    }
    public APIRequestGetOwnedPixels requestIsCreatedByBusinessField (boolean value) {
      this.requestField("is_created_by_business", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetOwnedPixels requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOwnedPixels requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestOwnerAdAccountField () {
      return this.requestOwnerAdAccountField(true);
    }
    public APIRequestGetOwnedPixels requestOwnerAdAccountField (boolean value) {
      this.requestField("owner_ad_account", value);
      return this;
    }
    public APIRequestGetOwnedPixels requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetOwnedPixels requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
  }

  public static class APIRequestGetOwnedProductCatalogs extends APIRequest<ProductCatalog> {

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
               return APIRequestGetOwnedProductCatalogs.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetOwnedProductCatalogs(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_product_catalogs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetOwnedProductCatalogs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetOwnedProductCatalogs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetOwnedProductCatalogs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetOwnedProductCatalogs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedProductCatalogs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetOwnedProductCatalogs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetOwnedProductCatalogs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetOwnedProductCatalogs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetOwnedProductCatalogs requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestDaDisplaySettingsField () {
      return this.requestDaDisplaySettingsField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestDaDisplaySettingsField (boolean value) {
      this.requestField("da_display_settings", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestDefaultImageUrlField () {
      return this.requestDefaultImageUrlField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestDefaultImageUrlField (boolean value) {
      this.requestField("default_image_url", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestFallbackImageUrlField () {
      return this.requestFallbackImageUrlField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestFallbackImageUrlField (boolean value) {
      this.requestField("fallback_image_url", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestFeedCountField () {
      return this.requestFeedCountField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestFeedCountField (boolean value) {
      this.requestField("feed_count", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestFlightCatalogSettingsField () {
      return this.requestFlightCatalogSettingsField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestFlightCatalogSettingsField (boolean value) {
      this.requestField("flight_catalog_settings", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestQualifiedProductCountField () {
      return this.requestQualifiedProductCountField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestQualifiedProductCountField (boolean value) {
      this.requestField("qualified_product_count", value);
      return this;
    }
    public APIRequestGetOwnedProductCatalogs requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetOwnedProductCatalogs requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
  }

  public static class APIRequestCreateOwnedProductCatalog extends APIRequest<ProductCatalog> {

    ProductCatalog lastResponse = null;
    @Override
    public ProductCatalog getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "da_display_settings",
      "destination_catalog_settings",
      "flight_catalog_settings",
      "name",
      "vertical",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductCatalog parseResponse(String response) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProductCatalog execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalog execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProductCatalog> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductCatalog> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProductCatalog>() {
           public ProductCatalog apply(String result) {
             try {
               return APIRequestCreateOwnedProductCatalog.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateOwnedProductCatalog(String nodeId, APIContext context) {
      super(context, nodeId, "/owned_product_catalogs", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateOwnedProductCatalog setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateOwnedProductCatalog setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateOwnedProductCatalog setDaDisplaySettings (Object daDisplaySettings) {
      this.setParam("da_display_settings", daDisplaySettings);
      return this;
    }
    public APIRequestCreateOwnedProductCatalog setDaDisplaySettings (String daDisplaySettings) {
      this.setParam("da_display_settings", daDisplaySettings);
      return this;
    }

    public APIRequestCreateOwnedProductCatalog setDestinationCatalogSettings (Map<String, String> destinationCatalogSettings) {
      this.setParam("destination_catalog_settings", destinationCatalogSettings);
      return this;
    }
    public APIRequestCreateOwnedProductCatalog setDestinationCatalogSettings (String destinationCatalogSettings) {
      this.setParam("destination_catalog_settings", destinationCatalogSettings);
      return this;
    }

    public APIRequestCreateOwnedProductCatalog setFlightCatalogSettings (Map<String, String> flightCatalogSettings) {
      this.setParam("flight_catalog_settings", flightCatalogSettings);
      return this;
    }
    public APIRequestCreateOwnedProductCatalog setFlightCatalogSettings (String flightCatalogSettings) {
      this.setParam("flight_catalog_settings", flightCatalogSettings);
      return this;
    }

    public APIRequestCreateOwnedProductCatalog setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateOwnedProductCatalog setVertical (ProductCatalog.EnumVertical vertical) {
      this.setParam("vertical", vertical);
      return this;
    }
    public APIRequestCreateOwnedProductCatalog setVertical (String vertical) {
      this.setParam("vertical", vertical);
      return this;
    }

    public APIRequestCreateOwnedProductCatalog requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateOwnedProductCatalog requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedProductCatalog requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateOwnedProductCatalog requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateOwnedProductCatalog requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateOwnedProductCatalog requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeletePages extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "page_id",
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
               return APIRequestDeletePages.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeletePages(String nodeId, APIContext context) {
      super(context, nodeId, "/pages", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeletePages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeletePages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeletePages setPageId (Long pageId) {
      this.setParam("page_id", pageId);
      return this;
    }
    public APIRequestDeletePages setPageId (String pageId) {
      this.setParam("page_id", pageId);
      return this;
    }

    public APIRequestDeletePages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeletePages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeletePages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeletePages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeletePages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeletePages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPartners extends APIRequest<Business> {

    APINodeList<Business> lastResponse = null;
    @Override
    public APINodeList<Business> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "block_offline_analytics",
      "created_by",
      "created_time",
      "id",
      "link",
      "name",
      "primary_page",
      "profile_picture_uri",
      "timezone_id",
      "two_factor_type",
      "updated_by",
      "updated_time",
      "vertical",
    };

    @Override
    public APINodeList<Business> parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Business> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Business> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Business>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Business>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Business>>() {
           public APINodeList<Business> apply(String result) {
             try {
               return APIRequestGetPartners.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPartners(String nodeId, APIContext context) {
      super(context, nodeId, "/partners", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPartners setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPartners setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPartners requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPartners requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPartners requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPartners requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPartners requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPartners requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPartners requestBlockOfflineAnalyticsField () {
      return this.requestBlockOfflineAnalyticsField(true);
    }
    public APIRequestGetPartners requestBlockOfflineAnalyticsField (boolean value) {
      this.requestField("block_offline_analytics", value);
      return this;
    }
    public APIRequestGetPartners requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetPartners requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetPartners requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetPartners requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetPartners requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPartners requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPartners requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetPartners requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetPartners requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPartners requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPartners requestPrimaryPageField () {
      return this.requestPrimaryPageField(true);
    }
    public APIRequestGetPartners requestPrimaryPageField (boolean value) {
      this.requestField("primary_page", value);
      return this;
    }
    public APIRequestGetPartners requestProfilePictureUriField () {
      return this.requestProfilePictureUriField(true);
    }
    public APIRequestGetPartners requestProfilePictureUriField (boolean value) {
      this.requestField("profile_picture_uri", value);
      return this;
    }
    public APIRequestGetPartners requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetPartners requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetPartners requestTwoFactorTypeField () {
      return this.requestTwoFactorTypeField(true);
    }
    public APIRequestGetPartners requestTwoFactorTypeField (boolean value) {
      this.requestField("two_factor_type", value);
      return this;
    }
    public APIRequestGetPartners requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetPartners requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetPartners requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetPartners requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetPartners requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetPartners requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
  }

  public static class APIRequestGetPendingClientAdAccounts extends APIRequest<BusinessAdAccountRequest> {

    APINodeList<BusinessAdAccountRequest> lastResponse = null;
    @Override
    public APINodeList<BusinessAdAccountRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account",
      "id",
    };

    @Override
    public APINodeList<BusinessAdAccountRequest> parseResponse(String response) throws APIException {
      return BusinessAdAccountRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessAdAccountRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessAdAccountRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessAdAccountRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessAdAccountRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessAdAccountRequest>>() {
           public APINodeList<BusinessAdAccountRequest> apply(String result) {
             try {
               return APIRequestGetPendingClientAdAccounts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPendingClientAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_client_ad_accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPendingClientAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPendingClientAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPendingClientAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPendingClientAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingClientAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPendingClientAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingClientAdAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPendingClientAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPendingClientAdAccounts requestAdAccountField () {
      return this.requestAdAccountField(true);
    }
    public APIRequestGetPendingClientAdAccounts requestAdAccountField (boolean value) {
      this.requestField("ad_account", value);
      return this;
    }
    public APIRequestGetPendingClientAdAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPendingClientAdAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGetPendingClientApps extends APIRequest<BusinessApplicationRequest> {

    APINodeList<BusinessApplicationRequest> lastResponse = null;
    @Override
    public APINodeList<BusinessApplicationRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "application",
      "id",
    };

    @Override
    public APINodeList<BusinessApplicationRequest> parseResponse(String response) throws APIException {
      return BusinessApplicationRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessApplicationRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessApplicationRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessApplicationRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessApplicationRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessApplicationRequest>>() {
           public APINodeList<BusinessApplicationRequest> apply(String result) {
             try {
               return APIRequestGetPendingClientApps.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPendingClientApps(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_client_apps", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPendingClientApps setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPendingClientApps setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPendingClientApps requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPendingClientApps requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingClientApps requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPendingClientApps requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingClientApps requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPendingClientApps requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPendingClientApps requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGetPendingClientApps requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGetPendingClientApps requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPendingClientApps requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGetPendingClientPages extends APIRequest<BusinessPageRequest> {

    APINodeList<BusinessPageRequest> lastResponse = null;
    @Override
    public APINodeList<BusinessPageRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "page",
    };

    @Override
    public APINodeList<BusinessPageRequest> parseResponse(String response) throws APIException {
      return BusinessPageRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessPageRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessPageRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessPageRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessPageRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessPageRequest>>() {
           public APINodeList<BusinessPageRequest> apply(String result) {
             try {
               return APIRequestGetPendingClientPages.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPendingClientPages(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_client_pages", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPendingClientPages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPendingClientPages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPendingClientPages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPendingClientPages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingClientPages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPendingClientPages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingClientPages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPendingClientPages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPendingClientPages requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPendingClientPages requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPendingClientPages requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGetPendingClientPages requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
  }

  public static class APIRequestGetPendingOwnedAdAccounts extends APIRequest<LegacyBusinessAdAccountRequest> {

    APINodeList<LegacyBusinessAdAccountRequest> lastResponse = null;
    @Override
    public APINodeList<LegacyBusinessAdAccountRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account",
      "id",
      "permitted_roles",
    };

    @Override
    public APINodeList<LegacyBusinessAdAccountRequest> parseResponse(String response) throws APIException {
      return LegacyBusinessAdAccountRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<LegacyBusinessAdAccountRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<LegacyBusinessAdAccountRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<LegacyBusinessAdAccountRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<LegacyBusinessAdAccountRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<LegacyBusinessAdAccountRequest>>() {
           public APINodeList<LegacyBusinessAdAccountRequest> apply(String result) {
             try {
               return APIRequestGetPendingOwnedAdAccounts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPendingOwnedAdAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_owned_ad_accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPendingOwnedAdAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPendingOwnedAdAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPendingOwnedAdAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPendingOwnedAdAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingOwnedAdAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPendingOwnedAdAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingOwnedAdAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPendingOwnedAdAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPendingOwnedAdAccounts requestAdAccountField () {
      return this.requestAdAccountField(true);
    }
    public APIRequestGetPendingOwnedAdAccounts requestAdAccountField (boolean value) {
      this.requestField("ad_account", value);
      return this;
    }
    public APIRequestGetPendingOwnedAdAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPendingOwnedAdAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPendingOwnedAdAccounts requestPermittedRolesField () {
      return this.requestPermittedRolesField(true);
    }
    public APIRequestGetPendingOwnedAdAccounts requestPermittedRolesField (boolean value) {
      this.requestField("permitted_roles", value);
      return this;
    }
  }

  public static class APIRequestGetPendingOwnedPages extends APIRequest<BusinessPageRequest> {

    APINodeList<BusinessPageRequest> lastResponse = null;
    @Override
    public APINodeList<BusinessPageRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "page",
    };

    @Override
    public APINodeList<BusinessPageRequest> parseResponse(String response) throws APIException {
      return BusinessPageRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessPageRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessPageRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessPageRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessPageRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessPageRequest>>() {
           public APINodeList<BusinessPageRequest> apply(String result) {
             try {
               return APIRequestGetPendingOwnedPages.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPendingOwnedPages(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_owned_pages", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPendingOwnedPages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPendingOwnedPages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPendingOwnedPages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPendingOwnedPages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingOwnedPages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPendingOwnedPages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingOwnedPages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPendingOwnedPages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPendingOwnedPages requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPendingOwnedPages requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPendingOwnedPages requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGetPendingOwnedPages requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
  }

  public static class APIRequestGetPendingUsers extends APIRequest<BusinessRoleRequest> {

    APINodeList<BusinessRoleRequest> lastResponse = null;
    @Override
    public APINodeList<BusinessRoleRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "email",
    };

    public static final String[] FIELDS = {
      "created_by",
      "created_time",
      "email",
      "expiration_time",
      "expiry_time",
      "finance_role",
      "id",
      "invite_link",
      "ip_role",
      "owner",
      "role",
      "status",
      "updated_by",
      "updated_time",
    };

    @Override
    public APINodeList<BusinessRoleRequest> parseResponse(String response) throws APIException {
      return BusinessRoleRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessRoleRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessRoleRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessRoleRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessRoleRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessRoleRequest>>() {
           public APINodeList<BusinessRoleRequest> apply(String result) {
             try {
               return APIRequestGetPendingUsers.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPendingUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_users", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPendingUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPendingUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPendingUsers setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestGetPendingUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPendingUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPendingUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPendingUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPendingUsers requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetPendingUsers requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetPendingUsers requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetPendingUsers requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetPendingUsers requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetPendingUsers requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetPendingUsers requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGetPendingUsers requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
      return this;
    }
    public APIRequestGetPendingUsers requestExpiryTimeField () {
      return this.requestExpiryTimeField(true);
    }
    public APIRequestGetPendingUsers requestExpiryTimeField (boolean value) {
      this.requestField("expiry_time", value);
      return this;
    }
    public APIRequestGetPendingUsers requestFinanceRoleField () {
      return this.requestFinanceRoleField(true);
    }
    public APIRequestGetPendingUsers requestFinanceRoleField (boolean value) {
      this.requestField("finance_role", value);
      return this;
    }
    public APIRequestGetPendingUsers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPendingUsers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPendingUsers requestInviteLinkField () {
      return this.requestInviteLinkField(true);
    }
    public APIRequestGetPendingUsers requestInviteLinkField (boolean value) {
      this.requestField("invite_link", value);
      return this;
    }
    public APIRequestGetPendingUsers requestIpRoleField () {
      return this.requestIpRoleField(true);
    }
    public APIRequestGetPendingUsers requestIpRoleField (boolean value) {
      this.requestField("ip_role", value);
      return this;
    }
    public APIRequestGetPendingUsers requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetPendingUsers requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetPendingUsers requestRoleField () {
      return this.requestRoleField(true);
    }
    public APIRequestGetPendingUsers requestRoleField (boolean value) {
      this.requestField("role", value);
      return this;
    }
    public APIRequestGetPendingUsers requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetPendingUsers requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetPendingUsers requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetPendingUsers requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetPendingUsers requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetPendingUsers requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
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

  public static class APIRequestGetReceivedAudiencePermissions extends APIRequest<AudiencePermission> {

    APINodeList<AudiencePermission> lastResponse = null;
    @Override
    public APINodeList<AudiencePermission> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "partner_id",
    };

    public static final String[] FIELDS = {
      "audience",
      "share_account_id",
      "share_account_name",
    };

    @Override
    public APINodeList<AudiencePermission> parseResponse(String response) throws APIException {
      return AudiencePermission.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AudiencePermission> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AudiencePermission> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AudiencePermission>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AudiencePermission>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AudiencePermission>>() {
           public APINodeList<AudiencePermission> apply(String result) {
             try {
               return APIRequestGetReceivedAudiencePermissions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetReceivedAudiencePermissions(String nodeId, APIContext context) {
      super(context, nodeId, "/received_audience_permissions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetReceivedAudiencePermissions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetReceivedAudiencePermissions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetReceivedAudiencePermissions setPartnerId (String partnerId) {
      this.setParam("partner_id", partnerId);
      return this;
    }

    public APIRequestGetReceivedAudiencePermissions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetReceivedAudiencePermissions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReceivedAudiencePermissions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetReceivedAudiencePermissions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReceivedAudiencePermissions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetReceivedAudiencePermissions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetReceivedAudiencePermissions requestAudienceField () {
      return this.requestAudienceField(true);
    }
    public APIRequestGetReceivedAudiencePermissions requestAudienceField (boolean value) {
      this.requestField("audience", value);
      return this;
    }
    public APIRequestGetReceivedAudiencePermissions requestShareAccountIdField () {
      return this.requestShareAccountIdField(true);
    }
    public APIRequestGetReceivedAudiencePermissions requestShareAccountIdField (boolean value) {
      this.requestField("share_account_id", value);
      return this;
    }
    public APIRequestGetReceivedAudiencePermissions requestShareAccountNameField () {
      return this.requestShareAccountNameField(true);
    }
    public APIRequestGetReceivedAudiencePermissions requestShareAccountNameField (boolean value) {
      this.requestField("share_account_name", value);
      return this;
    }
  }

  public static class APIRequestGetSharedAudiencePermissions extends APIRequest<AudiencePermission> {

    APINodeList<AudiencePermission> lastResponse = null;
    @Override
    public APINodeList<AudiencePermission> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "partner_id",
    };

    public static final String[] FIELDS = {
      "audience",
      "share_account_id",
      "share_account_name",
    };

    @Override
    public APINodeList<AudiencePermission> parseResponse(String response) throws APIException {
      return AudiencePermission.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AudiencePermission> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AudiencePermission> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AudiencePermission>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AudiencePermission>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AudiencePermission>>() {
           public APINodeList<AudiencePermission> apply(String result) {
             try {
               return APIRequestGetSharedAudiencePermissions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetSharedAudiencePermissions(String nodeId, APIContext context) {
      super(context, nodeId, "/shared_audience_permissions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSharedAudiencePermissions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSharedAudiencePermissions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSharedAudiencePermissions setPartnerId (String partnerId) {
      this.setParam("partner_id", partnerId);
      return this;
    }

    public APIRequestGetSharedAudiencePermissions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSharedAudiencePermissions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSharedAudiencePermissions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSharedAudiencePermissions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSharedAudiencePermissions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSharedAudiencePermissions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSharedAudiencePermissions requestAudienceField () {
      return this.requestAudienceField(true);
    }
    public APIRequestGetSharedAudiencePermissions requestAudienceField (boolean value) {
      this.requestField("audience", value);
      return this;
    }
    public APIRequestGetSharedAudiencePermissions requestShareAccountIdField () {
      return this.requestShareAccountIdField(true);
    }
    public APIRequestGetSharedAudiencePermissions requestShareAccountIdField (boolean value) {
      this.requestField("share_account_id", value);
      return this;
    }
    public APIRequestGetSharedAudiencePermissions requestShareAccountNameField () {
      return this.requestShareAccountNameField(true);
    }
    public APIRequestGetSharedAudiencePermissions requestShareAccountNameField (boolean value) {
      this.requestField("share_account_name", value);
      return this;
    }
  }

  public static class APIRequestGetSystemUsers extends APIRequest<SystemUser> {

    APINodeList<SystemUser> lastResponse = null;
    @Override
    public APINodeList<SystemUser> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "created_by",
      "created_time",
      "finance_permission",
      "id",
      "ip_permission",
      "name",
    };

    @Override
    public APINodeList<SystemUser> parseResponse(String response) throws APIException {
      return SystemUser.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<SystemUser> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<SystemUser> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<SystemUser>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<SystemUser>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<SystemUser>>() {
           public APINodeList<SystemUser> apply(String result) {
             try {
               return APIRequestGetSystemUsers.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetSystemUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/system_users", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSystemUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSystemUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSystemUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSystemUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSystemUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSystemUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSystemUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSystemUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetSystemUsers requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetSystemUsers requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetSystemUsers requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetSystemUsers requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetSystemUsers requestFinancePermissionField () {
      return this.requestFinancePermissionField(true);
    }
    public APIRequestGetSystemUsers requestFinancePermissionField (boolean value) {
      this.requestField("finance_permission", value);
      return this;
    }
    public APIRequestGetSystemUsers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetSystemUsers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetSystemUsers requestIpPermissionField () {
      return this.requestIpPermissionField(true);
    }
    public APIRequestGetSystemUsers requestIpPermissionField (boolean value) {
      this.requestField("ip_permission", value);
      return this;
    }
    public APIRequestGetSystemUsers requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetSystemUsers requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
  }

  public static class APIRequestCreateSystemUser extends APIRequest<SystemUser> {

    SystemUser lastResponse = null;
    @Override
    public SystemUser getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
      "role",
      "system_user_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public SystemUser parseResponse(String response) throws APIException {
      return SystemUser.parseResponse(response, getContext(), this).head();
    }

    @Override
    public SystemUser execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public SystemUser execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<SystemUser> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<SystemUser> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, SystemUser>() {
           public SystemUser apply(String result) {
             try {
               return APIRequestCreateSystemUser.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateSystemUser(String nodeId, APIContext context) {
      super(context, nodeId, "/system_users", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSystemUser setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSystemUser setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSystemUser setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateSystemUser setRole (SystemUser.EnumRole role) {
      this.setParam("role", role);
      return this;
    }
    public APIRequestCreateSystemUser setRole (String role) {
      this.setParam("role", role);
      return this;
    }

    public APIRequestCreateSystemUser setSystemUserId (Long systemUserId) {
      this.setParam("system_user_id", systemUserId);
      return this;
    }
    public APIRequestCreateSystemUser setSystemUserId (String systemUserId) {
      this.setParam("system_user_id", systemUserId);
      return this;
    }

    public APIRequestCreateSystemUser requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSystemUser requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSystemUser requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSystemUser requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSystemUser requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSystemUser requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteUserInvitations extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "email",
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
               return APIRequestDeleteUserInvitations.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteUserInvitations(String nodeId, APIContext context) {
      super(context, nodeId, "/user_invitations", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteUserInvitations setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteUserInvitations setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteUserInvitations setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestDeleteUserInvitations requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteUserInvitations requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteUserInvitations requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteUserInvitations requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteUserInvitations requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteUserInvitations requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetUserInvitations extends APIRequest<BusinessRoleRequest> {

    APINodeList<BusinessRoleRequest> lastResponse = null;
    @Override
    public APINodeList<BusinessRoleRequest> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "email",
      "status",
    };

    public static final String[] FIELDS = {
      "created_by",
      "created_time",
      "email",
      "expiration_time",
      "expiry_time",
      "finance_role",
      "id",
      "invite_link",
      "ip_role",
      "owner",
      "role",
      "status",
      "updated_by",
      "updated_time",
    };

    @Override
    public APINodeList<BusinessRoleRequest> parseResponse(String response) throws APIException {
      return BusinessRoleRequest.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<BusinessRoleRequest> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<BusinessRoleRequest> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<BusinessRoleRequest>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<BusinessRoleRequest>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<BusinessRoleRequest>>() {
           public APINodeList<BusinessRoleRequest> apply(String result) {
             try {
               return APIRequestGetUserInvitations.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetUserInvitations(String nodeId, APIContext context) {
      super(context, nodeId, "/user_invitations", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetUserInvitations setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetUserInvitations setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetUserInvitations setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestGetUserInvitations setStatus (BusinessRoleRequest.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestGetUserInvitations setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestGetUserInvitations requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetUserInvitations requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUserInvitations requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetUserInvitations requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUserInvitations requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetUserInvitations requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetUserInvitations requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetUserInvitations requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetUserInvitations requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetUserInvitations requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetUserInvitations requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetUserInvitations requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetUserInvitations requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGetUserInvitations requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
      return this;
    }
    public APIRequestGetUserInvitations requestExpiryTimeField () {
      return this.requestExpiryTimeField(true);
    }
    public APIRequestGetUserInvitations requestExpiryTimeField (boolean value) {
      this.requestField("expiry_time", value);
      return this;
    }
    public APIRequestGetUserInvitations requestFinanceRoleField () {
      return this.requestFinanceRoleField(true);
    }
    public APIRequestGetUserInvitations requestFinanceRoleField (boolean value) {
      this.requestField("finance_role", value);
      return this;
    }
    public APIRequestGetUserInvitations requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetUserInvitations requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetUserInvitations requestInviteLinkField () {
      return this.requestInviteLinkField(true);
    }
    public APIRequestGetUserInvitations requestInviteLinkField (boolean value) {
      this.requestField("invite_link", value);
      return this;
    }
    public APIRequestGetUserInvitations requestIpRoleField () {
      return this.requestIpRoleField(true);
    }
    public APIRequestGetUserInvitations requestIpRoleField (boolean value) {
      this.requestField("ip_role", value);
      return this;
    }
    public APIRequestGetUserInvitations requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetUserInvitations requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetUserInvitations requestRoleField () {
      return this.requestRoleField(true);
    }
    public APIRequestGetUserInvitations requestRoleField (boolean value) {
      this.requestField("role", value);
      return this;
    }
    public APIRequestGetUserInvitations requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetUserInvitations requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetUserInvitations requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetUserInvitations requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetUserInvitations requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetUserInvitations requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestDeleteUserPermissions extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "email",
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
               return APIRequestDeleteUserPermissions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteUserPermissions(String nodeId, APIContext context) {
      super(context, nodeId, "/userpermissions", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteUserPermissions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteUserPermissions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteUserPermissions setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestDeleteUserPermissions setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestDeleteUserPermissions setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestDeleteUserPermissions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteUserPermissions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteUserPermissions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteUserPermissions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteUserPermissions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteUserPermissions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateUserPermission extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "email",
      "role",
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
               return APIRequestCreateUserPermission.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateUserPermission(String nodeId, APIContext context) {
      super(context, nodeId, "/userpermissions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateUserPermission setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateUserPermission setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateUserPermission setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestCreateUserPermission setRole (EnumRole role) {
      this.setParam("role", role);
      return this;
    }
    public APIRequestCreateUserPermission setRole (String role) {
      this.setParam("role", role);
      return this;
    }

    public APIRequestCreateUserPermission setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestCreateUserPermission setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestCreateUserPermission requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateUserPermission requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUserPermission requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateUserPermission requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUserPermission requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateUserPermission requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<Business> {

    Business lastResponse = null;
    @Override
    public Business getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "block_offline_analytics",
      "created_by",
      "created_time",
      "id",
      "link",
      "name",
      "primary_page",
      "profile_picture_uri",
      "timezone_id",
      "two_factor_type",
      "updated_by",
      "updated_time",
      "vertical",
    };

    @Override
    public Business parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Business execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Business execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Business> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Business> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Business>() {
           public Business apply(String result) {
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

    public APIRequestGet requestBlockOfflineAnalyticsField () {
      return this.requestBlockOfflineAnalyticsField(true);
    }
    public APIRequestGet requestBlockOfflineAnalyticsField (boolean value) {
      this.requestField("block_offline_analytics", value);
      return this;
    }
    public APIRequestGet requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGet requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGet requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPrimaryPageField () {
      return this.requestPrimaryPageField(true);
    }
    public APIRequestGet requestPrimaryPageField (boolean value) {
      this.requestField("primary_page", value);
      return this;
    }
    public APIRequestGet requestProfilePictureUriField () {
      return this.requestProfilePictureUriField(true);
    }
    public APIRequestGet requestProfilePictureUriField (boolean value) {
      this.requestField("profile_picture_uri", value);
      return this;
    }
    public APIRequestGet requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGet requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGet requestTwoFactorTypeField () {
      return this.requestTwoFactorTypeField(true);
    }
    public APIRequestGet requestTwoFactorTypeField (boolean value) {
      this.requestField("two_factor_type", value);
      return this;
    }
    public APIRequestGet requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGet requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGet requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGet requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
  }

  public static enum EnumRole {
      @SerializedName("FINANCE_EDITOR")
      VALUE_FINANCE_EDITOR("FINANCE_EDITOR"),
      @SerializedName("FINANCE_ANALYST")
      VALUE_FINANCE_ANALYST("FINANCE_ANALYST"),
      @SerializedName("ADS_RIGHTS_REVIEWER")
      VALUE_ADS_RIGHTS_REVIEWER("ADS_RIGHTS_REVIEWER"),
      @SerializedName("ADMIN")
      VALUE_ADMIN("ADMIN"),
      @SerializedName("EMPLOYEE")
      VALUE_EMPLOYEE("EMPLOYEE"),
      @SerializedName("FB_EMPLOYEE_SALES_REP")
      VALUE_FB_EMPLOYEE_SALES_REP("FB_EMPLOYEE_SALES_REP"),
      NULL(null);

      private String value;

      private EnumRole(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPagePermittedRoles {
      @SerializedName("MANAGER")
      VALUE_MANAGER("MANAGER"),
      @SerializedName("CONTENT_CREATOR")
      VALUE_CONTENT_CREATOR("CONTENT_CREATOR"),
      @SerializedName("MODERATOR")
      VALUE_MODERATOR("MODERATOR"),
      @SerializedName("ADVERTISER")
      VALUE_ADVERTISER("ADVERTISER"),
      @SerializedName("INSIGHTS_ANALYST")
      VALUE_INSIGHTS_ANALYST("INSIGHTS_ANALYST"),
      NULL(null);

      private String value;

      private EnumPagePermittedRoles(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSurveyBusinessType {
      @SerializedName("AGENCY")
      VALUE_AGENCY("AGENCY"),
      @SerializedName("ADVERTISER")
      VALUE_ADVERTISER("ADVERTISER"),
      @SerializedName("APP_DEVELOPER")
      VALUE_APP_DEVELOPER("APP_DEVELOPER"),
      @SerializedName("PUBLISHER")
      VALUE_PUBLISHER("PUBLISHER"),
      NULL(null);

      private String value;

      private EnumSurveyBusinessType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumVertical {
      @SerializedName("ADVERTISING")
      VALUE_ADVERTISING("ADVERTISING"),
      @SerializedName("AUTOMOTIVE")
      VALUE_AUTOMOTIVE("AUTOMOTIVE"),
      @SerializedName("CONSUMER_PACKAGED_GOODS")
      VALUE_CONSUMER_PACKAGED_GOODS("CONSUMER_PACKAGED_GOODS"),
      @SerializedName("ECOMMERCE")
      VALUE_ECOMMERCE("ECOMMERCE"),
      @SerializedName("EDUCATION")
      VALUE_EDUCATION("EDUCATION"),
      @SerializedName("ENERGY_AND_UTILITIES")
      VALUE_ENERGY_AND_UTILITIES("ENERGY_AND_UTILITIES"),
      @SerializedName("ENTERTAINMENT_AND_MEDIA")
      VALUE_ENTERTAINMENT_AND_MEDIA("ENTERTAINMENT_AND_MEDIA"),
      @SerializedName("FINANCIAL_SERVICES")
      VALUE_FINANCIAL_SERVICES("FINANCIAL_SERVICES"),
      @SerializedName("GAMING")
      VALUE_GAMING("GAMING"),
      @SerializedName("GOVERNMENT_AND_POLITICS")
      VALUE_GOVERNMENT_AND_POLITICS("GOVERNMENT_AND_POLITICS"),
      @SerializedName("MARKETING")
      VALUE_MARKETING("MARKETING"),
      @SerializedName("ORGANIZATIONS_AND_ASSOCIATIONS")
      VALUE_ORGANIZATIONS_AND_ASSOCIATIONS("ORGANIZATIONS_AND_ASSOCIATIONS"),
      @SerializedName("PROFESSIONAL_SERVICES")
      VALUE_PROFESSIONAL_SERVICES("PROFESSIONAL_SERVICES"),
      @SerializedName("RETAIL")
      VALUE_RETAIL("RETAIL"),
      @SerializedName("TECHNOLOGY")
      VALUE_TECHNOLOGY("TECHNOLOGY"),
      @SerializedName("TELECOM")
      VALUE_TELECOM("TELECOM"),
      @SerializedName("TRAVEL")
      VALUE_TRAVEL("TRAVEL"),
      @SerializedName("NON_PROFIT")
      VALUE_NON_PROFIT("NON_PROFIT"),
      @SerializedName("RESTAURANT")
      VALUE_RESTAURANT("RESTAURANT"),
      @SerializedName("HEALTH")
      VALUE_HEALTH("HEALTH"),
      @SerializedName("LUXURY")
      VALUE_LUXURY("LUXURY"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      NULL(null);

      private String value;

      private EnumVertical(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPermittedRoles {
      @SerializedName("ADMIN")
      VALUE_ADMIN("ADMIN"),
      @SerializedName("UPLOADER")
      VALUE_UPLOADER("UPLOADER"),
      @SerializedName("ADVERTISER")
      VALUE_ADVERTISER("ADVERTISER"),
      NULL(null);

      private String value;

      private EnumPermittedRoles(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumAggregationPeriod {
      @SerializedName("HOUR")
      VALUE_HOUR("HOUR"),
      @SerializedName("DAY")
      VALUE_DAY("DAY"),
      @SerializedName("TOTAL")
      VALUE_TOTAL("TOTAL"),
      NULL(null);

      private String value;

      private EnumAggregationPeriod(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumBreakdowns {
      @SerializedName("AGE")
      VALUE_AGE("AGE"),
      @SerializedName("APP")
      VALUE_APP("APP"),
      @SerializedName("COUNTRY")
      VALUE_COUNTRY("COUNTRY"),
      @SerializedName("DELIVERY_METHOD")
      VALUE_DELIVERY_METHOD("DELIVERY_METHOD"),
      @SerializedName("DISPLAY_FORMAT")
      VALUE_DISPLAY_FORMAT("DISPLAY_FORMAT"),
      @SerializedName("DEAL")
      VALUE_DEAL("DEAL"),
      @SerializedName("DEAL_AD")
      VALUE_DEAL_AD("DEAL_AD"),
      @SerializedName("DEAL_PAGE")
      VALUE_DEAL_PAGE("DEAL_PAGE"),
      @SerializedName("GENDER")
      VALUE_GENDER("GENDER"),
      @SerializedName("PLACEMENT")
      VALUE_PLACEMENT("PLACEMENT"),
      @SerializedName("PLATFORM")
      VALUE_PLATFORM("PLATFORM"),
      @SerializedName("PROPERTY")
      VALUE_PROPERTY("PROPERTY"),
      NULL(null);

      private String value;

      private EnumBreakdowns(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMetrics {
      @SerializedName("FB_AD_NETWORK_BIDDING_REQUEST")
      VALUE_FB_AD_NETWORK_BIDDING_REQUEST("FB_AD_NETWORK_BIDDING_REQUEST"),
      @SerializedName("FB_AD_NETWORK_BIDDING_RESPONSE")
      VALUE_FB_AD_NETWORK_BIDDING_RESPONSE("FB_AD_NETWORK_BIDDING_RESPONSE"),
      @SerializedName("FB_AD_NETWORK_BIDDING_BID_RATE")
      VALUE_FB_AD_NETWORK_BIDDING_BID_RATE("FB_AD_NETWORK_BIDDING_BID_RATE"),
      @SerializedName("FB_AD_NETWORK_BIDDING_WIN_RATE")
      VALUE_FB_AD_NETWORK_BIDDING_WIN_RATE("FB_AD_NETWORK_BIDDING_WIN_RATE"),
      @SerializedName("FB_AD_NETWORK_REQUEST")
      VALUE_FB_AD_NETWORK_REQUEST("FB_AD_NETWORK_REQUEST"),
      @SerializedName("FB_AD_NETWORK_FILLED_REQUEST")
      VALUE_FB_AD_NETWORK_FILLED_REQUEST("FB_AD_NETWORK_FILLED_REQUEST"),
      @SerializedName("FB_AD_NETWORK_FILL_RATE")
      VALUE_FB_AD_NETWORK_FILL_RATE("FB_AD_NETWORK_FILL_RATE"),
      @SerializedName("FB_AD_NETWORK_IMP")
      VALUE_FB_AD_NETWORK_IMP("FB_AD_NETWORK_IMP"),
      @SerializedName("FB_AD_NETWORK_SHOW_RATE")
      VALUE_FB_AD_NETWORK_SHOW_RATE("FB_AD_NETWORK_SHOW_RATE"),
      @SerializedName("FB_AD_NETWORK_CLICK")
      VALUE_FB_AD_NETWORK_CLICK("FB_AD_NETWORK_CLICK"),
      @SerializedName("FB_AD_NETWORK_CTR")
      VALUE_FB_AD_NETWORK_CTR("FB_AD_NETWORK_CTR"),
      @SerializedName("FB_AD_NETWORK_BIDDING_REVENUE")
      VALUE_FB_AD_NETWORK_BIDDING_REVENUE("FB_AD_NETWORK_BIDDING_REVENUE"),
      @SerializedName("FB_AD_NETWORK_REVENUE")
      VALUE_FB_AD_NETWORK_REVENUE("FB_AD_NETWORK_REVENUE"),
      @SerializedName("FB_AD_NETWORK_CPM")
      VALUE_FB_AD_NETWORK_CPM("FB_AD_NETWORK_CPM"),
      @SerializedName("FB_AD_NETWORK_VIDEO_GUARANTEE_REVENUE")
      VALUE_FB_AD_NETWORK_VIDEO_GUARANTEE_REVENUE("FB_AD_NETWORK_VIDEO_GUARANTEE_REVENUE"),
      @SerializedName("FB_AD_NETWORK_VIDEO_VIEW")
      VALUE_FB_AD_NETWORK_VIDEO_VIEW("FB_AD_NETWORK_VIDEO_VIEW"),
      @SerializedName("FB_AD_NETWORK_VIDEO_VIEW_RATE")
      VALUE_FB_AD_NETWORK_VIDEO_VIEW_RATE("FB_AD_NETWORK_VIDEO_VIEW_RATE"),
      @SerializedName("FB_AD_NETWORK_VIDEO_MRC")
      VALUE_FB_AD_NETWORK_VIDEO_MRC("FB_AD_NETWORK_VIDEO_MRC"),
      @SerializedName("FB_AD_NETWORK_VIDEO_MRC_RATE")
      VALUE_FB_AD_NETWORK_VIDEO_MRC_RATE("FB_AD_NETWORK_VIDEO_MRC_RATE"),
      @SerializedName("FB_AD_NETWORK_WIN_RATE")
      VALUE_FB_AD_NETWORK_WIN_RATE("FB_AD_NETWORK_WIN_RATE"),
      @SerializedName("FB_AD_NETWORK_DIRECT_TOTAL_REVENUE")
      VALUE_FB_AD_NETWORK_DIRECT_TOTAL_REVENUE("FB_AD_NETWORK_DIRECT_TOTAL_REVENUE"),
      @SerializedName("FB_AD_NETWORK_DIRECT_PUBLISHER_BILL")
      VALUE_FB_AD_NETWORK_DIRECT_PUBLISHER_BILL("FB_AD_NETWORK_DIRECT_PUBLISHER_BILL"),
      @SerializedName("FB_AD_NETWORK_FAST_CLICK_RATE")
      VALUE_FB_AD_NETWORK_FAST_CLICK_RATE("FB_AD_NETWORK_FAST_CLICK_RATE"),
      @SerializedName("FB_AD_NETWORK_FAST_RETURN_RATE")
      VALUE_FB_AD_NETWORK_FAST_RETURN_RATE("FB_AD_NETWORK_FAST_RETURN_RATE"),
      @SerializedName("FB_AD_NETWORK_CLICK_VALUE_SCORE")
      VALUE_FB_AD_NETWORK_CLICK_VALUE_SCORE("FB_AD_NETWORK_CLICK_VALUE_SCORE"),
      @SerializedName("FB_AD_NETWORK_FAST_CLICK_NUMERATOR")
      VALUE_FB_AD_NETWORK_FAST_CLICK_NUMERATOR("FB_AD_NETWORK_FAST_CLICK_NUMERATOR"),
      @SerializedName("FB_AD_NETWORK_FAST_CLICK_DENOMINATOR")
      VALUE_FB_AD_NETWORK_FAST_CLICK_DENOMINATOR("FB_AD_NETWORK_FAST_CLICK_DENOMINATOR"),
      @SerializedName("FB_AD_NETWORK_FAST_RETURN_NUMERATOR")
      VALUE_FB_AD_NETWORK_FAST_RETURN_NUMERATOR("FB_AD_NETWORK_FAST_RETURN_NUMERATOR"),
      @SerializedName("FB_AD_NETWORK_FAST_RETURN_DENOMINATOR")
      VALUE_FB_AD_NETWORK_FAST_RETURN_DENOMINATOR("FB_AD_NETWORK_FAST_RETURN_DENOMINATOR"),
      @SerializedName("FB_AD_NETWORK_CLICK_VALUE_SCORE_NUMERATOR")
      VALUE_FB_AD_NETWORK_CLICK_VALUE_SCORE_NUMERATOR("FB_AD_NETWORK_CLICK_VALUE_SCORE_NUMERATOR"),
      @SerializedName("FB_AD_NETWORK_CLICK_VALUE_SCORE_DENOMINATOR")
      VALUE_FB_AD_NETWORK_CLICK_VALUE_SCORE_DENOMINATOR("FB_AD_NETWORK_CLICK_VALUE_SCORE_DENOMINATOR"),
      NULL(null);

      private String value;

      private EnumMetrics(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOrderingColumn {
      @SerializedName("TIME")
      VALUE_TIME("TIME"),
      @SerializedName("VALUE")
      VALUE_VALUE("VALUE"),
      @SerializedName("METRIC")
      VALUE_METRIC("METRIC"),
      NULL(null);

      private String value;

      private EnumOrderingColumn(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOrderingType {
      @SerializedName("ASCENDING")
      VALUE_ASCENDING("ASCENDING"),
      @SerializedName("DESCENDING")
      VALUE_DESCENDING("DESCENDING"),
      NULL(null);

      private String value;

      private EnumOrderingType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumAccessType {
      @SerializedName("OWNER")
      VALUE_OWNER("OWNER"),
      @SerializedName("AGENCY")
      VALUE_AGENCY("AGENCY"),
      NULL(null);

      private String value;

      private EnumAccessType(String value) {
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

  public Business copyFrom(Business instance) {
    this.mBlockOfflineAnalytics = instance.mBlockOfflineAnalytics;
    this.mCreatedBy = instance.mCreatedBy;
    this.mCreatedTime = instance.mCreatedTime;
    this.mId = instance.mId;
    this.mLink = instance.mLink;
    this.mName = instance.mName;
    this.mPaymentAccountId = instance.mPaymentAccountId;
    this.mPrimaryPage = instance.mPrimaryPage;
    this.mProfilePictureUri = instance.mProfilePictureUri;
    this.mTimezoneId = instance.mTimezoneId;
    this.mTwoFactorType = instance.mTwoFactorType;
    this.mUpdatedBy = instance.mUpdatedBy;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mVertical = instance.mVertical;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Business> getParser() {
    return new APIRequest.ResponseParser<Business>() {
      public APINodeList<Business> parseResponse(String response, APIContext context, APIRequest<Business> request) throws MalformedResponseException {
        return Business.parseResponse(response, context, request);
      }
    };
  }
}
