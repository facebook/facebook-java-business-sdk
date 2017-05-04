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
public class Lead extends APINode {
  @SerializedName("ad_id")
  private String mAdId = null;
  @SerializedName("ad_name")
  private String mAdName = null;
  @SerializedName("adset_id")
  private String mAdsetId = null;
  @SerializedName("adset_name")
  private String mAdsetName = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("campaign_name")
  private String mCampaignName = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("custom_disclaimer_responses")
  private List<UserLeadGenDisclaimerResponse> mCustomDisclaimerResponses = null;
  @SerializedName("field_data")
  private List<UserLeadGenFieldData> mFieldData = null;
  @SerializedName("form_id")
  private String mFormId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_organic")
  private Boolean mIsOrganic = null;
  @SerializedName("post")
  private Object mPost = null;
  @SerializedName("retailer_item_id")
  private String mRetailerItemId = null;
  protected static Gson gson = null;

  Lead() {
  }

  public Lead(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Lead(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public Lead fetch() throws APIException{
    Lead newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Lead fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static Lead fetchById(String id, APIContext context) throws APIException {
    Lead lead =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return lead;
  }

  public static APINodeList<Lead> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Lead>)(
      new APIRequest<Lead>(context, "", "/", "GET", Lead.getParser())
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
  public static Lead loadJSON(String json, APIContext context) {
    Lead lead = getGson().fromJson(json, Lead.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(lead.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    lead.context = context;
    lead.rawValue = json;
    return lead;
  }

  public static APINodeList<Lead> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<Lead> leads = new APINodeList<Lead>(request, json);
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
          leads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return leads;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            leads.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              leads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  leads.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              leads.add(loadJSON(obj.toString(), context));
            }
          }
          return leads;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              leads.add(loadJSON(entry.getValue().toString(), context));
          }
          return leads;
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
              leads.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return leads;
          }

          // Sixth, check if it's pure JsonObject
          leads.clear();
          leads.add(loadJSON(json, context));
          return leads;
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

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldAdId() {
    return mAdId;
  }

  public String getFieldAdName() {
    return mAdName;
  }

  public String getFieldAdsetId() {
    return mAdsetId;
  }

  public String getFieldAdsetName() {
    return mAdsetName;
  }

  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public String getFieldCampaignName() {
    return mCampaignName;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public List<UserLeadGenDisclaimerResponse> getFieldCustomDisclaimerResponses() {
    return mCustomDisclaimerResponses;
  }

  public List<UserLeadGenFieldData> getFieldFieldData() {
    return mFieldData;
  }

  public String getFieldFormId() {
    return mFormId;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsOrganic() {
    return mIsOrganic;
  }

  public Object getFieldPost() {
    return mPost;
  }

  public String getFieldRetailerItemId() {
    return mRetailerItemId;
  }



  public static class APIRequestDelete extends APIRequest<APINode> {

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

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<Lead> {

    Lead lastResponse = null;
    @Override
    public Lead getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_id",
      "ad_name",
      "adset_id",
      "adset_name",
      "campaign_id",
      "campaign_name",
      "created_time",
      "custom_disclaimer_responses",
      "field_data",
      "form_id",
      "id",
      "is_organic",
      "post",
      "retailer_item_id",
    };

    @Override
    public Lead parseResponse(String response) throws APIException {
      return Lead.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Lead execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Lead execute(Map<String, Object> extraParams) throws APIException {
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

    public APIRequestGet requestAdIdField () {
      return this.requestAdIdField(true);
    }
    public APIRequestGet requestAdIdField (boolean value) {
      this.requestField("ad_id", value);
      return this;
    }
    public APIRequestGet requestAdNameField () {
      return this.requestAdNameField(true);
    }
    public APIRequestGet requestAdNameField (boolean value) {
      this.requestField("ad_name", value);
      return this;
    }
    public APIRequestGet requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGet requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGet requestAdsetNameField () {
      return this.requestAdsetNameField(true);
    }
    public APIRequestGet requestAdsetNameField (boolean value) {
      this.requestField("adset_name", value);
      return this;
    }
    public APIRequestGet requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGet requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGet requestCampaignNameField () {
      return this.requestCampaignNameField(true);
    }
    public APIRequestGet requestCampaignNameField (boolean value) {
      this.requestField("campaign_name", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestCustomDisclaimerResponsesField () {
      return this.requestCustomDisclaimerResponsesField(true);
    }
    public APIRequestGet requestCustomDisclaimerResponsesField (boolean value) {
      this.requestField("custom_disclaimer_responses", value);
      return this;
    }
    public APIRequestGet requestFieldDataField () {
      return this.requestFieldDataField(true);
    }
    public APIRequestGet requestFieldDataField (boolean value) {
      this.requestField("field_data", value);
      return this;
    }
    public APIRequestGet requestFormIdField () {
      return this.requestFormIdField(true);
    }
    public APIRequestGet requestFormIdField (boolean value) {
      this.requestField("form_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsOrganicField () {
      return this.requestIsOrganicField(true);
    }
    public APIRequestGet requestIsOrganicField (boolean value) {
      this.requestField("is_organic", value);
      return this;
    }
    public APIRequestGet requestPostField () {
      return this.requestPostField(true);
    }
    public APIRequestGet requestPostField (boolean value) {
      this.requestField("post", value);
      return this;
    }
    public APIRequestGet requestRetailerItemIdField () {
      return this.requestRetailerItemIdField(true);
    }
    public APIRequestGet requestRetailerItemIdField (boolean value) {
      this.requestField("retailer_item_id", value);
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

  public Lead copyFrom(Lead instance) {
    this.mAdId = instance.mAdId;
    this.mAdName = instance.mAdName;
    this.mAdsetId = instance.mAdsetId;
    this.mAdsetName = instance.mAdsetName;
    this.mCampaignId = instance.mCampaignId;
    this.mCampaignName = instance.mCampaignName;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCustomDisclaimerResponses = instance.mCustomDisclaimerResponses;
    this.mFieldData = instance.mFieldData;
    this.mFormId = instance.mFormId;
    this.mId = instance.mId;
    this.mIsOrganic = instance.mIsOrganic;
    this.mPost = instance.mPost;
    this.mRetailerItemId = instance.mRetailerItemId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Lead> getParser() {
    return new APIRequest.ResponseParser<Lead>() {
      public APINodeList<Lead> parseResponse(String response, APIContext context, APIRequest<Lead> request) throws MalformedResponseException {
        return Lead.parseResponse(response, context, request);
      }
    };
  }
}
