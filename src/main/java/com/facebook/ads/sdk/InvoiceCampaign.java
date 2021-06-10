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
  protected static Gson gson = null;

  public InvoiceCampaign() {
  }

  public String getId() {
    return null;
  }
  public static InvoiceCampaign loadJSON(String json, APIContext context, String header) {
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
      }
    }
    invoiceCampaign.context = context;
    invoiceCampaign.rawValue = json;
    invoiceCampaign.header = header;
    return invoiceCampaign;
  }

  public static APINodeList<InvoiceCampaign> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<InvoiceCampaign> invoiceCampaigns = new APINodeList<InvoiceCampaign>(request, json, header);
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
          invoiceCampaigns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
              invoiceCampaigns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  invoiceCampaigns.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              invoiceCampaigns.add(loadJSON(obj.toString(), context, header));
            }
          }
          return invoiceCampaigns;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              invoiceCampaigns.add(loadJSON(entry.getValue().toString(), context, header));
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
              invoiceCampaigns.add(loadJSON(value.toString(), context, header));
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
          invoiceCampaigns.add(loadJSON(json, context, header));
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


  public String getFieldAdAccountId() {
    return mAdAccountId;
  }

  public InvoiceCampaign setFieldAdAccountId(String value) {
    this.mAdAccountId = value;
    return this;
  }

  public BilledAmountDetails getFieldBilledAmountDetails() {
    return mBilledAmountDetails;
  }

  public InvoiceCampaign setFieldBilledAmountDetails(BilledAmountDetails value) {
    this.mBilledAmountDetails = value;
    return this;
  }

  public InvoiceCampaign setFieldBilledAmountDetails(String value) {
    Type type = new TypeToken<BilledAmountDetails>(){}.getType();
    this.mBilledAmountDetails = BilledAmountDetails.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public InvoiceCampaign setFieldCampaignId(String value) {
    this.mCampaignId = value;
    return this;
  }

  public String getFieldCampaignName() {
    return mCampaignName;
  }

  public InvoiceCampaign setFieldCampaignName(String value) {
    this.mCampaignName = value;
    return this;
  }

  public Long getFieldClicks() {
    return mClicks;
  }

  public InvoiceCampaign setFieldClicks(Long value) {
    this.mClicks = value;
    return this;
  }

  public Long getFieldConversions() {
    return mConversions;
  }

  public InvoiceCampaign setFieldConversions(Long value) {
    this.mConversions = value;
    return this;
  }

  public Long getFieldImpressions() {
    return mImpressions;
  }

  public InvoiceCampaign setFieldImpressions(Long value) {
    this.mImpressions = value;
    return this;
  }

  public List<String> getFieldTags() {
    return mTags;
  }

  public InvoiceCampaign setFieldTags(List<String> value) {
    this.mTags = value;
    return this;
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
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<InvoiceCampaign> getParser() {
    return new APIRequest.ResponseParser<InvoiceCampaign>() {
      public APINodeList<InvoiceCampaign> parseResponse(String response, APIContext context, APIRequest<InvoiceCampaign> request, String header) throws MalformedResponseException {
        return InvoiceCampaign.parseResponse(response, context, request, header);
      }
    };
  }
}
