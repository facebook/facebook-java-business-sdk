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
public class InvoiceCampaign extends APINode {
  @SerializedName("ad_account_id")
  private String mAdAccountId = null;
  @SerializedName("billed_amount_details")
  private BilledAmountDetails mBilledAmountDetails = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("campaign_name")
  private String mCampaignName = null;
  @SerializedName("clicks")
  private Long mClicks = null;
  @SerializedName("conversions")
  private Long mConversions = null;
  @SerializedName("impressions")
  private Long mImpressions = null;
  @SerializedName("tags")
  private List<String> mTags = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  InvoiceCampaign() {
  }

  public InvoiceCampaign(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public InvoiceCampaign(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public InvoiceCampaign fetch() throws APIException{
    InvoiceCampaign newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static InvoiceCampaign fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<InvoiceCampaign> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static InvoiceCampaign fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<InvoiceCampaign> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<InvoiceCampaign> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<InvoiceCampaign>)(
      new APIRequest<InvoiceCampaign>(context, "", "/", "GET", InvoiceCampaign.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<InvoiceCampaign>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", InvoiceCampaign.getParser())
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
  public static InvoiceCampaign loadJSON(String json, APIContext context) {
    InvoiceCampaign invoiceCampaign = getGson().fromJson(json, InvoiceCampaign.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(invoiceCampaign.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    invoiceCampaign.context = context;
    invoiceCampaign.rawValue = json;
    return invoiceCampaign;
  }

  public static APINodeList<InvoiceCampaign> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<InvoiceCampaign> invoiceCampaigns = new APINodeList<InvoiceCampaign>(request, json);
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
          invoiceCampaigns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return invoiceCampaigns;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                invoiceCampaigns.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            invoiceCampaigns.setPaging(previous, next);
            if (context.hasAppSecret()) {
              invoiceCampaigns.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              invoiceCampaigns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  invoiceCampaigns.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              invoiceCampaigns.add(loadJSON(obj.toString(), context));
            }
          }
          return invoiceCampaigns;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              invoiceCampaigns.add(loadJSON(entry.getValue().toString(), context));
          }
          return invoiceCampaigns;
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
              invoiceCampaigns.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return invoiceCampaigns;
          }

          // Sixth, check if it's pure JsonObject
          invoiceCampaigns.clear();
          invoiceCampaigns.add(loadJSON(json, context));
          return invoiceCampaigns;
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


  public String getFieldAdAccountId() {
    return mAdAccountId;
  }

  public BilledAmountDetails getFieldBilledAmountDetails() {
    if (mBilledAmountDetails != null) {
      mBilledAmountDetails.context = getContext();
    }
    return mBilledAmountDetails;
  }

  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public String getFieldCampaignName() {
    return mCampaignName;
  }

  public Long getFieldClicks() {
    return mClicks;
  }

  public Long getFieldConversions() {
    return mConversions;
  }

  public Long getFieldImpressions() {
    return mImpressions;
  }

  public List<String> getFieldTags() {
    return mTags;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<InvoiceCampaign> {

    InvoiceCampaign lastResponse = null;
    @Override
    public InvoiceCampaign getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account_id",
      "billed_amount_details",
      "campaign_id",
      "campaign_name",
      "clicks",
      "conversions",
      "impressions",
      "tags",
      "id",
    };

    @Override
    public InvoiceCampaign parseResponse(String response) throws APIException {
      return InvoiceCampaign.parseResponse(response, getContext(), this).head();
    }

    @Override
    public InvoiceCampaign execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public InvoiceCampaign execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<InvoiceCampaign> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<InvoiceCampaign> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, InvoiceCampaign>() {
           public InvoiceCampaign apply(String result) {
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

    public APIRequestGet requestAdAccountIdField () {
      return this.requestAdAccountIdField(true);
    }
    public APIRequestGet requestAdAccountIdField (boolean value) {
      this.requestField("ad_account_id", value);
      return this;
    }
    public APIRequestGet requestBilledAmountDetailsField () {
      return this.requestBilledAmountDetailsField(true);
    }
    public APIRequestGet requestBilledAmountDetailsField (boolean value) {
      this.requestField("billed_amount_details", value);
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
    public APIRequestGet requestClicksField () {
      return this.requestClicksField(true);
    }
    public APIRequestGet requestClicksField (boolean value) {
      this.requestField("clicks", value);
      return this;
    }
    public APIRequestGet requestConversionsField () {
      return this.requestConversionsField(true);
    }
    public APIRequestGet requestConversionsField (boolean value) {
      this.requestField("conversions", value);
      return this;
    }
    public APIRequestGet requestImpressionsField () {
      return this.requestImpressionsField(true);
    }
    public APIRequestGet requestImpressionsField (boolean value) {
      this.requestField("impressions", value);
      return this;
    }
    public APIRequestGet requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGet requestTagsField (boolean value) {
      this.requestField("tags", value);
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

  public InvoiceCampaign copyFrom(InvoiceCampaign instance) {
    this.mAdAccountId = instance.mAdAccountId;
    this.mBilledAmountDetails = instance.mBilledAmountDetails;
    this.mCampaignId = instance.mCampaignId;
    this.mCampaignName = instance.mCampaignName;
    this.mClicks = instance.mClicks;
    this.mConversions = instance.mConversions;
    this.mImpressions = instance.mImpressions;
    this.mTags = instance.mTags;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<InvoiceCampaign> getParser() {
    return new APIRequest.ResponseParser<InvoiceCampaign>() {
      public APINodeList<InvoiceCampaign> parseResponse(String response, APIContext context, APIRequest<InvoiceCampaign> request) throws MalformedResponseException {
        return InvoiceCampaign.parseResponse(response, context, request);
      }
    };
  }
}
