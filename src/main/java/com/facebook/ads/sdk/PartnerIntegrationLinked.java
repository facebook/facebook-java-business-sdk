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
public class PartnerIntegrationLinked extends APINode {
  @SerializedName("ads_pixel")
  private AdsPixel mAdsPixel = null;
  @SerializedName("application")
  private Object mApplication = null;
  @SerializedName("completed_integration_types")
  private List<String> mCompletedIntegrationTypes = null;
  @SerializedName("external_id")
  private String mExternalId = null;
  @SerializedName("has_oauth_token")
  private Boolean mHasOauthToken = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("offline_conversion_data_set")
  private OfflineConversionDataSet mOfflineConversionDataSet = null;
  @SerializedName("partner")
  private String mPartner = null;
  @SerializedName("partner_profile")
  private Object mPartnerProfile = null;
  @SerializedName("product_catalog")
  private ProductCatalog mProductCatalog = null;
  @SerializedName("setup_status")
  private String mSetupStatus = null;
  protected static Gson gson = null;

  PartnerIntegrationLinked() {
  }

  public PartnerIntegrationLinked(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PartnerIntegrationLinked(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public PartnerIntegrationLinked fetch() throws APIException{
    PartnerIntegrationLinked newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PartnerIntegrationLinked fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PartnerIntegrationLinked> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PartnerIntegrationLinked fetchById(String id, APIContext context) throws APIException {
    PartnerIntegrationLinked partnerIntegrationLinked =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return partnerIntegrationLinked;
  }

  public static ListenableFuture<PartnerIntegrationLinked> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<PartnerIntegrationLinked> partnerIntegrationLinked =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return partnerIntegrationLinked;
  }

  public static APINodeList<PartnerIntegrationLinked> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PartnerIntegrationLinked>)(
      new APIRequest<PartnerIntegrationLinked>(context, "", "/", "GET", PartnerIntegrationLinked.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PartnerIntegrationLinked>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<PartnerIntegrationLinked>> partnerIntegrationLinked =
      new APIRequest(context, "", "/", "GET", PartnerIntegrationLinked.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return partnerIntegrationLinked;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static PartnerIntegrationLinked loadJSON(String json, APIContext context) {
    PartnerIntegrationLinked partnerIntegrationLinked = getGson().fromJson(json, PartnerIntegrationLinked.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(partnerIntegrationLinked.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    partnerIntegrationLinked.context = context;
    partnerIntegrationLinked.rawValue = json;
    return partnerIntegrationLinked;
  }

  public static APINodeList<PartnerIntegrationLinked> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<PartnerIntegrationLinked> partnerIntegrationLinkeds = new APINodeList<PartnerIntegrationLinked>(request, json);
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
          partnerIntegrationLinkeds.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return partnerIntegrationLinkeds;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                partnerIntegrationLinkeds.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            partnerIntegrationLinkeds.setPaging(previous, next);
            if (context.hasAppSecret()) {
              partnerIntegrationLinkeds.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              partnerIntegrationLinkeds.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  partnerIntegrationLinkeds.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              partnerIntegrationLinkeds.add(loadJSON(obj.toString(), context));
            }
          }
          return partnerIntegrationLinkeds;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              partnerIntegrationLinkeds.add(loadJSON(entry.getValue().toString(), context));
          }
          return partnerIntegrationLinkeds;
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
              partnerIntegrationLinkeds.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return partnerIntegrationLinkeds;
          }

          // Sixth, check if it's pure JsonObject
          partnerIntegrationLinkeds.clear();
          partnerIntegrationLinkeds.add(loadJSON(json, context));
          return partnerIntegrationLinkeds;
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


  public AdsPixel getFieldAdsPixel() {
    if (mAdsPixel != null) {
      mAdsPixel.context = getContext();
    }
    return mAdsPixel;
  }

  public Object getFieldApplication() {
    return mApplication;
  }

  public List<String> getFieldCompletedIntegrationTypes() {
    return mCompletedIntegrationTypes;
  }

  public String getFieldExternalId() {
    return mExternalId;
  }

  public Boolean getFieldHasOauthToken() {
    return mHasOauthToken;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }

  public OfflineConversionDataSet getFieldOfflineConversionDataSet() {
    if (mOfflineConversionDataSet != null) {
      mOfflineConversionDataSet.context = getContext();
    }
    return mOfflineConversionDataSet;
  }

  public String getFieldPartner() {
    return mPartner;
  }

  public Object getFieldPartnerProfile() {
    return mPartnerProfile;
  }

  public ProductCatalog getFieldProductCatalog() {
    if (mProductCatalog != null) {
      mProductCatalog.context = getContext();
    }
    return mProductCatalog;
  }

  public String getFieldSetupStatus() {
    return mSetupStatus;
  }



  public static class APIRequestGet extends APIRequest<PartnerIntegrationLinked> {

    PartnerIntegrationLinked lastResponse = null;
    @Override
    public PartnerIntegrationLinked getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ads_pixel",
      "application",
      "completed_integration_types",
      "external_id",
      "has_oauth_token",
      "id",
      "name",
      "offline_conversion_data_set",
      "partner",
      "partner_profile",
      "product_catalog",
      "setup_status",
    };

    @Override
    public PartnerIntegrationLinked parseResponse(String response) throws APIException {
      return PartnerIntegrationLinked.parseResponse(response, getContext(), this).head();
    }

    @Override
    public PartnerIntegrationLinked execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PartnerIntegrationLinked execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<PartnerIntegrationLinked> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PartnerIntegrationLinked> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, PartnerIntegrationLinked>() {
           public PartnerIntegrationLinked apply(String result) {
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

    public APIRequestGet requestAdsPixelField () {
      return this.requestAdsPixelField(true);
    }
    public APIRequestGet requestAdsPixelField (boolean value) {
      this.requestField("ads_pixel", value);
      return this;
    }
    public APIRequestGet requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGet requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGet requestCompletedIntegrationTypesField () {
      return this.requestCompletedIntegrationTypesField(true);
    }
    public APIRequestGet requestCompletedIntegrationTypesField (boolean value) {
      this.requestField("completed_integration_types", value);
      return this;
    }
    public APIRequestGet requestExternalIdField () {
      return this.requestExternalIdField(true);
    }
    public APIRequestGet requestExternalIdField (boolean value) {
      this.requestField("external_id", value);
      return this;
    }
    public APIRequestGet requestHasOauthTokenField () {
      return this.requestHasOauthTokenField(true);
    }
    public APIRequestGet requestHasOauthTokenField (boolean value) {
      this.requestField("has_oauth_token", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOfflineConversionDataSetField () {
      return this.requestOfflineConversionDataSetField(true);
    }
    public APIRequestGet requestOfflineConversionDataSetField (boolean value) {
      this.requestField("offline_conversion_data_set", value);
      return this;
    }
    public APIRequestGet requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGet requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGet requestPartnerProfileField () {
      return this.requestPartnerProfileField(true);
    }
    public APIRequestGet requestPartnerProfileField (boolean value) {
      this.requestField("partner_profile", value);
      return this;
    }
    public APIRequestGet requestProductCatalogField () {
      return this.requestProductCatalogField(true);
    }
    public APIRequestGet requestProductCatalogField (boolean value) {
      this.requestField("product_catalog", value);
      return this;
    }
    public APIRequestGet requestSetupStatusField () {
      return this.requestSetupStatusField(true);
    }
    public APIRequestGet requestSetupStatusField (boolean value) {
      this.requestField("setup_status", value);
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

  public PartnerIntegrationLinked copyFrom(PartnerIntegrationLinked instance) {
    this.mAdsPixel = instance.mAdsPixel;
    this.mApplication = instance.mApplication;
    this.mCompletedIntegrationTypes = instance.mCompletedIntegrationTypes;
    this.mExternalId = instance.mExternalId;
    this.mHasOauthToken = instance.mHasOauthToken;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mOfflineConversionDataSet = instance.mOfflineConversionDataSet;
    this.mPartner = instance.mPartner;
    this.mPartnerProfile = instance.mPartnerProfile;
    this.mProductCatalog = instance.mProductCatalog;
    this.mSetupStatus = instance.mSetupStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PartnerIntegrationLinked> getParser() {
    return new APIRequest.ResponseParser<PartnerIntegrationLinked>() {
      public APINodeList<PartnerIntegrationLinked> parseResponse(String response, APIContext context, APIRequest<PartnerIntegrationLinked> request) throws MalformedResponseException {
        return PartnerIntegrationLinked.parseResponse(response, context, request);
      }
    };
  }
}
