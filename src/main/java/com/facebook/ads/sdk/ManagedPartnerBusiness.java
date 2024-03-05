/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
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
import com.google.common.util.concurrent.MoreExecutors;
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
public class ManagedPartnerBusiness extends APINode {
  @SerializedName("ad_account")
  private AdAccount mAdAccount = null;
  @SerializedName("catalog_segment")
  private ProductCatalog mCatalogSegment = null;
  @SerializedName("extended_credit")
  private ManagedPartnerExtendedCredit mExtendedCredit = null;
  @SerializedName("page")
  private Page mPage = null;
  @SerializedName("seller_business_info")
  private Object mSellerBusinessInfo = null;
  @SerializedName("seller_business_status")
  private String mSellerBusinessStatus = null;
  @SerializedName("template")
  private List<Object> mTemplate = null;
  protected static Gson gson = null;

  public ManagedPartnerBusiness() {
  }

  public String getId() {
    return null;
  }
  public static ManagedPartnerBusiness loadJSON(String json, APIContext context, String header) {
    ManagedPartnerBusiness managedPartnerBusiness = getGson().fromJson(json, ManagedPartnerBusiness.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(managedPartnerBusiness.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    managedPartnerBusiness.context = context;
    managedPartnerBusiness.rawValue = json;
    managedPartnerBusiness.header = header;
    return managedPartnerBusiness;
  }

  public static APINodeList<ManagedPartnerBusiness> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ManagedPartnerBusiness> managedPartnerBusinesss = new APINodeList<ManagedPartnerBusiness>(request, json, header);
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
          managedPartnerBusinesss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return managedPartnerBusinesss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                managedPartnerBusinesss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            managedPartnerBusinesss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              managedPartnerBusinesss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              managedPartnerBusinesss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  managedPartnerBusinesss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              managedPartnerBusinesss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return managedPartnerBusinesss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              managedPartnerBusinesss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return managedPartnerBusinesss;
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
              managedPartnerBusinesss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return managedPartnerBusinesss;
          }

          // Sixth, check if it's pure JsonObject
          managedPartnerBusinesss.clear();
          managedPartnerBusinesss.add(loadJSON(json, context, header));
          return managedPartnerBusinesss;
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


  public AdAccount getFieldAdAccount() {
    if (mAdAccount != null) {
      mAdAccount.context = getContext();
    }
    return mAdAccount;
  }

  public ManagedPartnerBusiness setFieldAdAccount(AdAccount value) {
    this.mAdAccount = value;
    return this;
  }

  public ManagedPartnerBusiness setFieldAdAccount(String value) {
    Type type = new TypeToken<AdAccount>(){}.getType();
    this.mAdAccount = AdAccount.getGson().fromJson(value, type);
    return this;
  }
  public ProductCatalog getFieldCatalogSegment() {
    if (mCatalogSegment != null) {
      mCatalogSegment.context = getContext();
    }
    return mCatalogSegment;
  }

  public ManagedPartnerBusiness setFieldCatalogSegment(ProductCatalog value) {
    this.mCatalogSegment = value;
    return this;
  }

  public ManagedPartnerBusiness setFieldCatalogSegment(String value) {
    Type type = new TypeToken<ProductCatalog>(){}.getType();
    this.mCatalogSegment = ProductCatalog.getGson().fromJson(value, type);
    return this;
  }
  public ManagedPartnerExtendedCredit getFieldExtendedCredit() {
    return mExtendedCredit;
  }

  public ManagedPartnerBusiness setFieldExtendedCredit(ManagedPartnerExtendedCredit value) {
    this.mExtendedCredit = value;
    return this;
  }

  public ManagedPartnerBusiness setFieldExtendedCredit(String value) {
    Type type = new TypeToken<ManagedPartnerExtendedCredit>(){}.getType();
    this.mExtendedCredit = ManagedPartnerExtendedCredit.getGson().fromJson(value, type);
    return this;
  }
  public Page getFieldPage() {
    if (mPage != null) {
      mPage.context = getContext();
    }
    return mPage;
  }

  public ManagedPartnerBusiness setFieldPage(Page value) {
    this.mPage = value;
    return this;
  }

  public ManagedPartnerBusiness setFieldPage(String value) {
    Type type = new TypeToken<Page>(){}.getType();
    this.mPage = Page.getGson().fromJson(value, type);
    return this;
  }
  public Object getFieldSellerBusinessInfo() {
    return mSellerBusinessInfo;
  }

  public ManagedPartnerBusiness setFieldSellerBusinessInfo(Object value) {
    this.mSellerBusinessInfo = value;
    return this;
  }

  public String getFieldSellerBusinessStatus() {
    return mSellerBusinessStatus;
  }

  public ManagedPartnerBusiness setFieldSellerBusinessStatus(String value) {
    this.mSellerBusinessStatus = value;
    return this;
  }

  public List<Object> getFieldTemplate() {
    return mTemplate;
  }

  public ManagedPartnerBusiness setFieldTemplate(List<Object> value) {
    this.mTemplate = value;
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

  public ManagedPartnerBusiness copyFrom(ManagedPartnerBusiness instance) {
    this.mAdAccount = instance.mAdAccount;
    this.mCatalogSegment = instance.mCatalogSegment;
    this.mExtendedCredit = instance.mExtendedCredit;
    this.mPage = instance.mPage;
    this.mSellerBusinessInfo = instance.mSellerBusinessInfo;
    this.mSellerBusinessStatus = instance.mSellerBusinessStatus;
    this.mTemplate = instance.mTemplate;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ManagedPartnerBusiness> getParser() {
    return new APIRequest.ResponseParser<ManagedPartnerBusiness>() {
      public APINodeList<ManagedPartnerBusiness> parseResponse(String response, APIContext context, APIRequest<ManagedPartnerBusiness> request, String header) throws MalformedResponseException {
        return ManagedPartnerBusiness.parseResponse(response, context, request, header);
      }
    };
  }
}
