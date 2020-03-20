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
public class BusinessCreativeFolderSharingAgreement extends APINode {
  @SerializedName("folder_id")
  private String mFolderId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("requesting_business")
  private Business mRequestingBusiness = null;
  @SerializedName("status")
  private String mStatus = null;
  protected static Gson gson = null;

  BusinessCreativeFolderSharingAgreement() {
  }

  public BusinessCreativeFolderSharingAgreement(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public BusinessCreativeFolderSharingAgreement(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public BusinessCreativeFolderSharingAgreement fetch() throws APIException{
    BusinessCreativeFolderSharingAgreement newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static BusinessCreativeFolderSharingAgreement fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<BusinessCreativeFolderSharingAgreement> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static BusinessCreativeFolderSharingAgreement fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<BusinessCreativeFolderSharingAgreement> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<BusinessCreativeFolderSharingAgreement> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<BusinessCreativeFolderSharingAgreement>)(
      new APIRequest<BusinessCreativeFolderSharingAgreement>(context, "", "/", "GET", BusinessCreativeFolderSharingAgreement.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<BusinessCreativeFolderSharingAgreement>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", BusinessCreativeFolderSharingAgreement.getParser())
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
  public static BusinessCreativeFolderSharingAgreement loadJSON(String json, APIContext context, String header) {
    BusinessCreativeFolderSharingAgreement businessCreativeFolderSharingAgreement = getGson().fromJson(json, BusinessCreativeFolderSharingAgreement.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(businessCreativeFolderSharingAgreement.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    businessCreativeFolderSharingAgreement.context = context;
    businessCreativeFolderSharingAgreement.rawValue = json;
    businessCreativeFolderSharingAgreement.header = header;
    return businessCreativeFolderSharingAgreement;
  }

  public static APINodeList<BusinessCreativeFolderSharingAgreement> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BusinessCreativeFolderSharingAgreement> businessCreativeFolderSharingAgreements = new APINodeList<BusinessCreativeFolderSharingAgreement>(request, json, header);
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
          businessCreativeFolderSharingAgreements.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return businessCreativeFolderSharingAgreements;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                businessCreativeFolderSharingAgreements.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            businessCreativeFolderSharingAgreements.setPaging(previous, next);
            if (context.hasAppSecret()) {
              businessCreativeFolderSharingAgreements.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businessCreativeFolderSharingAgreements.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  businessCreativeFolderSharingAgreements.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              businessCreativeFolderSharingAgreements.add(loadJSON(obj.toString(), context, header));
            }
          }
          return businessCreativeFolderSharingAgreements;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businessCreativeFolderSharingAgreements.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return businessCreativeFolderSharingAgreements;
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
              businessCreativeFolderSharingAgreements.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return businessCreativeFolderSharingAgreements;
          }

          // Sixth, check if it's pure JsonObject
          businessCreativeFolderSharingAgreements.clear();
          businessCreativeFolderSharingAgreements.add(loadJSON(json, context, header));
          return businessCreativeFolderSharingAgreements;
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


  public String getFieldFolderId() {
    return mFolderId;
  }

  public String getFieldId() {
    return mId;
  }

  public Business getFieldRequestingBusiness() {
    if (mRequestingBusiness != null) {
      mRequestingBusiness.context = getContext();
    }
    return mRequestingBusiness;
  }

  public String getFieldStatus() {
    return mStatus;
  }



  public static class APIRequestGet extends APIRequest<BusinessCreativeFolderSharingAgreement> {

    BusinessCreativeFolderSharingAgreement lastResponse = null;
    @Override
    public BusinessCreativeFolderSharingAgreement getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "folder_id",
      "id",
      "requesting_business",
      "status",
    };

    @Override
    public BusinessCreativeFolderSharingAgreement parseResponse(String response, String header) throws APIException {
      return BusinessCreativeFolderSharingAgreement.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public BusinessCreativeFolderSharingAgreement execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessCreativeFolderSharingAgreement execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<BusinessCreativeFolderSharingAgreement> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessCreativeFolderSharingAgreement> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, BusinessCreativeFolderSharingAgreement>() {
           public BusinessCreativeFolderSharingAgreement apply(ResponseWrapper result) {
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

    public APIRequestGet requestFolderIdField () {
      return this.requestFolderIdField(true);
    }
    public APIRequestGet requestFolderIdField (boolean value) {
      this.requestField("folder_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestRequestingBusinessField () {
      return this.requestRequestingBusinessField(true);
    }
    public APIRequestGet requestRequestingBusinessField (boolean value) {
      this.requestField("requesting_business", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static enum EnumRequestStatus {
      @SerializedName("APPROVE")
      VALUE_APPROVE("APPROVE"),
      @SerializedName("DECLINE")
      VALUE_DECLINE("DECLINE"),
      @SerializedName("EXPIRED")
      VALUE_EXPIRED("EXPIRED"),
      @SerializedName("IN_PROGRESS")
      VALUE_IN_PROGRESS("IN_PROGRESS"),
      @SerializedName("PENDING")
      VALUE_PENDING("PENDING"),
      ;

      private String value;

      private EnumRequestStatus(String value) {
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

  public BusinessCreativeFolderSharingAgreement copyFrom(BusinessCreativeFolderSharingAgreement instance) {
    this.mFolderId = instance.mFolderId;
    this.mId = instance.mId;
    this.mRequestingBusiness = instance.mRequestingBusiness;
    this.mStatus = instance.mStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BusinessCreativeFolderSharingAgreement> getParser() {
    return new APIRequest.ResponseParser<BusinessCreativeFolderSharingAgreement>() {
      public APINodeList<BusinessCreativeFolderSharingAgreement> parseResponse(String response, APIContext context, APIRequest<BusinessCreativeFolderSharingAgreement> request, String header) throws MalformedResponseException {
        return BusinessCreativeFolderSharingAgreement.parseResponse(response, context, request, header);
      }
    };
  }
}
