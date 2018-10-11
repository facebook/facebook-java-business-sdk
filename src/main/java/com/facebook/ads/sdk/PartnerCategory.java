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
public class PartnerCategory extends APINode {
  @SerializedName("approximate_count")
  private Long mApproximateCount = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("details")
  private String mDetails = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_private")
  private Boolean mIsPrivate = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("parent_category")
  private String mParentCategory = null;
  @SerializedName("source")
  private String mSource = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("targeting_type")
  private String mTargetingType = null;
  protected static Gson gson = null;

  PartnerCategory() {
  }

  public PartnerCategory(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PartnerCategory(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public PartnerCategory fetch() throws APIException{
    PartnerCategory newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PartnerCategory fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PartnerCategory> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PartnerCategory fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PartnerCategory> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<PartnerCategory> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PartnerCategory>)(
      new APIRequest<PartnerCategory>(context, "", "/", "GET", PartnerCategory.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PartnerCategory>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", PartnerCategory.getParser())
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
  public static PartnerCategory loadJSON(String json, APIContext context) {
    PartnerCategory partnerCategory = getGson().fromJson(json, PartnerCategory.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(partnerCategory.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    partnerCategory.context = context;
    partnerCategory.rawValue = json;
    return partnerCategory;
  }

  public static APINodeList<PartnerCategory> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<PartnerCategory> partnerCategorys = new APINodeList<PartnerCategory>(request, json);
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
          partnerCategorys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return partnerCategorys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                partnerCategorys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            partnerCategorys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              partnerCategorys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              partnerCategorys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  partnerCategorys.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              partnerCategorys.add(loadJSON(obj.toString(), context));
            }
          }
          return partnerCategorys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              partnerCategorys.add(loadJSON(entry.getValue().toString(), context));
          }
          return partnerCategorys;
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
              partnerCategorys.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return partnerCategorys;
          }

          // Sixth, check if it's pure JsonObject
          partnerCategorys.clear();
          partnerCategorys.add(loadJSON(json, context));
          return partnerCategorys;
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


  public Long getFieldApproximateCount() {
    return mApproximateCount;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldDetails() {
    return mDetails;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsPrivate() {
    return mIsPrivate;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldParentCategory() {
    return mParentCategory;
  }

  public String getFieldSource() {
    return mSource;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldTargetingType() {
    return mTargetingType;
  }



  public static class APIRequestGet extends APIRequest<PartnerCategory> {

    PartnerCategory lastResponse = null;
    @Override
    public PartnerCategory getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "approximate_count",
      "country",
      "description",
      "details",
      "id",
      "is_private",
      "name",
      "parent_category",
      "source",
      "status",
      "targeting_type",
    };

    @Override
    public PartnerCategory parseResponse(String response) throws APIException {
      return PartnerCategory.parseResponse(response, getContext(), this).head();
    }

    @Override
    public PartnerCategory execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PartnerCategory execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<PartnerCategory> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PartnerCategory> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, PartnerCategory>() {
           public PartnerCategory apply(String result) {
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

    public APIRequestGet requestApproximateCountField () {
      return this.requestApproximateCountField(true);
    }
    public APIRequestGet requestApproximateCountField (boolean value) {
      this.requestField("approximate_count", value);
      return this;
    }
    public APIRequestGet requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGet requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestDetailsField () {
      return this.requestDetailsField(true);
    }
    public APIRequestGet requestDetailsField (boolean value) {
      this.requestField("details", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsPrivateField () {
      return this.requestIsPrivateField(true);
    }
    public APIRequestGet requestIsPrivateField (boolean value) {
      this.requestField("is_private", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestParentCategoryField () {
      return this.requestParentCategoryField(true);
    }
    public APIRequestGet requestParentCategoryField (boolean value) {
      this.requestField("parent_category", value);
      return this;
    }
    public APIRequestGet requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGet requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTargetingTypeField () {
      return this.requestTargetingTypeField(true);
    }
    public APIRequestGet requestTargetingTypeField (boolean value) {
      this.requestField("targeting_type", value);
      return this;
    }
  }

  public static enum EnumPrivateOrPublic {
      @SerializedName("PRIVATE")
      VALUE_PRIVATE("PRIVATE"),
      @SerializedName("PUBLIC")
      VALUE_PUBLIC("PUBLIC"),
      NULL(null);

      private String value;

      private EnumPrivateOrPublic(String value) {
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

  public PartnerCategory copyFrom(PartnerCategory instance) {
    this.mApproximateCount = instance.mApproximateCount;
    this.mCountry = instance.mCountry;
    this.mDescription = instance.mDescription;
    this.mDetails = instance.mDetails;
    this.mId = instance.mId;
    this.mIsPrivate = instance.mIsPrivate;
    this.mName = instance.mName;
    this.mParentCategory = instance.mParentCategory;
    this.mSource = instance.mSource;
    this.mStatus = instance.mStatus;
    this.mTargetingType = instance.mTargetingType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PartnerCategory> getParser() {
    return new APIRequest.ResponseParser<PartnerCategory>() {
      public APINodeList<PartnerCategory> parseResponse(String response, APIContext context, APIRequest<PartnerCategory> request) throws MalformedResponseException {
        return PartnerCategory.parseResponse(response, context, request);
      }
    };
  }
}
