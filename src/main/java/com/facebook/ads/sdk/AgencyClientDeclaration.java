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
public class AgencyClientDeclaration extends APINode {
  @SerializedName("agency_representing_client")
  private Long mAgencyRepresentingClient = null;
  @SerializedName("client_based_in_france")
  private Long mClientBasedInFrance = null;
  @SerializedName("client_city")
  private String mClientCity = null;
  @SerializedName("client_country_code")
  private String mClientCountryCode = null;
  @SerializedName("client_email_address")
  private String mClientEmailAddress = null;
  @SerializedName("client_name")
  private String mClientName = null;
  @SerializedName("client_postal_code")
  private String mClientPostalCode = null;
  @SerializedName("client_province")
  private String mClientProvince = null;
  @SerializedName("client_street")
  private String mClientStreet = null;
  @SerializedName("client_street2")
  private String mClientStreet2 = null;
  @SerializedName("has_written_mandate_from_advertiser")
  private Long mHasWrittenMandateFromAdvertiser = null;
  @SerializedName("is_client_paying_invoices")
  private Long mIsClientPayingInvoices = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AgencyClientDeclaration() {
  }

  public AgencyClientDeclaration(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AgencyClientDeclaration(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AgencyClientDeclaration fetch() throws APIException{
    AgencyClientDeclaration newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AgencyClientDeclaration fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AgencyClientDeclaration> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AgencyClientDeclaration fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AgencyClientDeclaration> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AgencyClientDeclaration> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AgencyClientDeclaration>)(
      new APIRequest<AgencyClientDeclaration>(context, "", "/", "GET", AgencyClientDeclaration.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AgencyClientDeclaration>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AgencyClientDeclaration.getParser())
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
  public static AgencyClientDeclaration loadJSON(String json, APIContext context) {
    AgencyClientDeclaration agencyClientDeclaration = getGson().fromJson(json, AgencyClientDeclaration.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(agencyClientDeclaration.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    agencyClientDeclaration.context = context;
    agencyClientDeclaration.rawValue = json;
    return agencyClientDeclaration;
  }

  public static APINodeList<AgencyClientDeclaration> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AgencyClientDeclaration> agencyClientDeclarations = new APINodeList<AgencyClientDeclaration>(request, json);
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
          agencyClientDeclarations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return agencyClientDeclarations;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                agencyClientDeclarations.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            agencyClientDeclarations.setPaging(previous, next);
            if (context.hasAppSecret()) {
              agencyClientDeclarations.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              agencyClientDeclarations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  agencyClientDeclarations.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              agencyClientDeclarations.add(loadJSON(obj.toString(), context));
            }
          }
          return agencyClientDeclarations;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              agencyClientDeclarations.add(loadJSON(entry.getValue().toString(), context));
          }
          return agencyClientDeclarations;
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
              agencyClientDeclarations.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return agencyClientDeclarations;
          }

          // Sixth, check if it's pure JsonObject
          agencyClientDeclarations.clear();
          agencyClientDeclarations.add(loadJSON(json, context));
          return agencyClientDeclarations;
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


  public Long getFieldAgencyRepresentingClient() {
    return mAgencyRepresentingClient;
  }

  public Long getFieldClientBasedInFrance() {
    return mClientBasedInFrance;
  }

  public String getFieldClientCity() {
    return mClientCity;
  }

  public String getFieldClientCountryCode() {
    return mClientCountryCode;
  }

  public String getFieldClientEmailAddress() {
    return mClientEmailAddress;
  }

  public String getFieldClientName() {
    return mClientName;
  }

  public String getFieldClientPostalCode() {
    return mClientPostalCode;
  }

  public String getFieldClientProvince() {
    return mClientProvince;
  }

  public String getFieldClientStreet() {
    return mClientStreet;
  }

  public String getFieldClientStreet2() {
    return mClientStreet2;
  }

  public Long getFieldHasWrittenMandateFromAdvertiser() {
    return mHasWrittenMandateFromAdvertiser;
  }

  public Long getFieldIsClientPayingInvoices() {
    return mIsClientPayingInvoices;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AgencyClientDeclaration> {

    AgencyClientDeclaration lastResponse = null;
    @Override
    public AgencyClientDeclaration getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "agency_representing_client",
      "client_based_in_france",
      "client_city",
      "client_country_code",
      "client_email_address",
      "client_name",
      "client_postal_code",
      "client_province",
      "client_street",
      "client_street2",
      "has_written_mandate_from_advertiser",
      "is_client_paying_invoices",
      "id",
    };

    @Override
    public AgencyClientDeclaration parseResponse(String response) throws APIException {
      return AgencyClientDeclaration.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AgencyClientDeclaration execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AgencyClientDeclaration execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AgencyClientDeclaration> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AgencyClientDeclaration> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AgencyClientDeclaration>() {
           public AgencyClientDeclaration apply(String result) {
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

    public APIRequestGet requestAgencyRepresentingClientField () {
      return this.requestAgencyRepresentingClientField(true);
    }
    public APIRequestGet requestAgencyRepresentingClientField (boolean value) {
      this.requestField("agency_representing_client", value);
      return this;
    }
    public APIRequestGet requestClientBasedInFranceField () {
      return this.requestClientBasedInFranceField(true);
    }
    public APIRequestGet requestClientBasedInFranceField (boolean value) {
      this.requestField("client_based_in_france", value);
      return this;
    }
    public APIRequestGet requestClientCityField () {
      return this.requestClientCityField(true);
    }
    public APIRequestGet requestClientCityField (boolean value) {
      this.requestField("client_city", value);
      return this;
    }
    public APIRequestGet requestClientCountryCodeField () {
      return this.requestClientCountryCodeField(true);
    }
    public APIRequestGet requestClientCountryCodeField (boolean value) {
      this.requestField("client_country_code", value);
      return this;
    }
    public APIRequestGet requestClientEmailAddressField () {
      return this.requestClientEmailAddressField(true);
    }
    public APIRequestGet requestClientEmailAddressField (boolean value) {
      this.requestField("client_email_address", value);
      return this;
    }
    public APIRequestGet requestClientNameField () {
      return this.requestClientNameField(true);
    }
    public APIRequestGet requestClientNameField (boolean value) {
      this.requestField("client_name", value);
      return this;
    }
    public APIRequestGet requestClientPostalCodeField () {
      return this.requestClientPostalCodeField(true);
    }
    public APIRequestGet requestClientPostalCodeField (boolean value) {
      this.requestField("client_postal_code", value);
      return this;
    }
    public APIRequestGet requestClientProvinceField () {
      return this.requestClientProvinceField(true);
    }
    public APIRequestGet requestClientProvinceField (boolean value) {
      this.requestField("client_province", value);
      return this;
    }
    public APIRequestGet requestClientStreetField () {
      return this.requestClientStreetField(true);
    }
    public APIRequestGet requestClientStreetField (boolean value) {
      this.requestField("client_street", value);
      return this;
    }
    public APIRequestGet requestClientStreet2Field () {
      return this.requestClientStreet2Field(true);
    }
    public APIRequestGet requestClientStreet2Field (boolean value) {
      this.requestField("client_street2", value);
      return this;
    }
    public APIRequestGet requestHasWrittenMandateFromAdvertiserField () {
      return this.requestHasWrittenMandateFromAdvertiserField(true);
    }
    public APIRequestGet requestHasWrittenMandateFromAdvertiserField (boolean value) {
      this.requestField("has_written_mandate_from_advertiser", value);
      return this;
    }
    public APIRequestGet requestIsClientPayingInvoicesField () {
      return this.requestIsClientPayingInvoicesField(true);
    }
    public APIRequestGet requestIsClientPayingInvoicesField (boolean value) {
      this.requestField("is_client_paying_invoices", value);
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

  public AgencyClientDeclaration copyFrom(AgencyClientDeclaration instance) {
    this.mAgencyRepresentingClient = instance.mAgencyRepresentingClient;
    this.mClientBasedInFrance = instance.mClientBasedInFrance;
    this.mClientCity = instance.mClientCity;
    this.mClientCountryCode = instance.mClientCountryCode;
    this.mClientEmailAddress = instance.mClientEmailAddress;
    this.mClientName = instance.mClientName;
    this.mClientPostalCode = instance.mClientPostalCode;
    this.mClientProvince = instance.mClientProvince;
    this.mClientStreet = instance.mClientStreet;
    this.mClientStreet2 = instance.mClientStreet2;
    this.mHasWrittenMandateFromAdvertiser = instance.mHasWrittenMandateFromAdvertiser;
    this.mIsClientPayingInvoices = instance.mIsClientPayingInvoices;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AgencyClientDeclaration> getParser() {
    return new APIRequest.ResponseParser<AgencyClientDeclaration>() {
      public APINodeList<AgencyClientDeclaration> parseResponse(String response, APIContext context, APIRequest<AgencyClientDeclaration> request) throws MalformedResponseException {
        return AgencyClientDeclaration.parseResponse(response, context, request);
      }
    };
  }
}
