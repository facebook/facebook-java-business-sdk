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
public class ProductCatalogDiagnosticGroup extends APINode {
  @SerializedName("affected_channels")
  private List<EnumAffectedChannels> mAffectedChannels = null;
  @SerializedName("affected_entity")
  private EnumAffectedEntity mAffectedEntity = null;
  @SerializedName("affected_features")
  private List<EnumAffectedFeatures> mAffectedFeatures = null;
  @SerializedName("diagnostics")
  private List<Object> mDiagnostics = null;
  @SerializedName("error_code")
  private Long mErrorCode = null;
  @SerializedName("number_of_affected_entities")
  private Long mNumberOfAffectedEntities = null;
  @SerializedName("number_of_affected_items")
  private Long mNumberOfAffectedItems = null;
  @SerializedName("severity")
  private EnumSeverity mSeverity = null;
  @SerializedName("subtitle")
  private String mSubtitle = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("type")
  private EnumType mType = null;
  protected static Gson gson = null;

  public ProductCatalogDiagnosticGroup() {
  }

  public String getId() {
    return null;
  }
  public static ProductCatalogDiagnosticGroup loadJSON(String json, APIContext context, String header) {
    ProductCatalogDiagnosticGroup productCatalogDiagnosticGroup = getGson().fromJson(json, ProductCatalogDiagnosticGroup.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productCatalogDiagnosticGroup.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    productCatalogDiagnosticGroup.context = context;
    productCatalogDiagnosticGroup.rawValue = json;
    productCatalogDiagnosticGroup.header = header;
    return productCatalogDiagnosticGroup;
  }

  public static APINodeList<ProductCatalogDiagnosticGroup> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ProductCatalogDiagnosticGroup> productCatalogDiagnosticGroups = new APINodeList<ProductCatalogDiagnosticGroup>(request, json, header);
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
          productCatalogDiagnosticGroups.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return productCatalogDiagnosticGroups;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productCatalogDiagnosticGroups.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productCatalogDiagnosticGroups.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productCatalogDiagnosticGroups.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productCatalogDiagnosticGroups.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  productCatalogDiagnosticGroups.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              productCatalogDiagnosticGroups.add(loadJSON(obj.toString(), context, header));
            }
          }
          return productCatalogDiagnosticGroups;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productCatalogDiagnosticGroups.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return productCatalogDiagnosticGroups;
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
              productCatalogDiagnosticGroups.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productCatalogDiagnosticGroups;
          }

          // Sixth, check if it's pure JsonObject
          productCatalogDiagnosticGroups.clear();
          productCatalogDiagnosticGroups.add(loadJSON(json, context, header));
          return productCatalogDiagnosticGroups;
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


  public List<EnumAffectedChannels> getFieldAffectedChannels() {
    return mAffectedChannels;
  }

  public ProductCatalogDiagnosticGroup setFieldAffectedChannels(List<EnumAffectedChannels> value) {
    this.mAffectedChannels = value;
    return this;
  }

  public EnumAffectedEntity getFieldAffectedEntity() {
    return mAffectedEntity;
  }

  public ProductCatalogDiagnosticGroup setFieldAffectedEntity(EnumAffectedEntity value) {
    this.mAffectedEntity = value;
    return this;
  }

  public List<EnumAffectedFeatures> getFieldAffectedFeatures() {
    return mAffectedFeatures;
  }

  public ProductCatalogDiagnosticGroup setFieldAffectedFeatures(List<EnumAffectedFeatures> value) {
    this.mAffectedFeatures = value;
    return this;
  }

  public List<Object> getFieldDiagnostics() {
    return mDiagnostics;
  }

  public ProductCatalogDiagnosticGroup setFieldDiagnostics(List<Object> value) {
    this.mDiagnostics = value;
    return this;
  }

  public Long getFieldErrorCode() {
    return mErrorCode;
  }

  public ProductCatalogDiagnosticGroup setFieldErrorCode(Long value) {
    this.mErrorCode = value;
    return this;
  }

  public Long getFieldNumberOfAffectedEntities() {
    return mNumberOfAffectedEntities;
  }

  public ProductCatalogDiagnosticGroup setFieldNumberOfAffectedEntities(Long value) {
    this.mNumberOfAffectedEntities = value;
    return this;
  }

  public Long getFieldNumberOfAffectedItems() {
    return mNumberOfAffectedItems;
  }

  public ProductCatalogDiagnosticGroup setFieldNumberOfAffectedItems(Long value) {
    this.mNumberOfAffectedItems = value;
    return this;
  }

  public EnumSeverity getFieldSeverity() {
    return mSeverity;
  }

  public ProductCatalogDiagnosticGroup setFieldSeverity(EnumSeverity value) {
    this.mSeverity = value;
    return this;
  }

  public String getFieldSubtitle() {
    return mSubtitle;
  }

  public ProductCatalogDiagnosticGroup setFieldSubtitle(String value) {
    this.mSubtitle = value;
    return this;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public ProductCatalogDiagnosticGroup setFieldTitle(String value) {
    this.mTitle = value;
    return this;
  }

  public EnumType getFieldType() {
    return mType;
  }

  public ProductCatalogDiagnosticGroup setFieldType(EnumType value) {
    this.mType = value;
    return this;
  }



  public static enum EnumAffectedChannels {
      @SerializedName("b2c_marketplace")
      VALUE_B2C_MARKETPLACE("b2c_marketplace"),
      @SerializedName("c2c_marketplace")
      VALUE_C2C_MARKETPLACE("c2c_marketplace"),
      @SerializedName("da")
      VALUE_DA("da"),
      @SerializedName("daily_deals")
      VALUE_DAILY_DEALS("daily_deals"),
      @SerializedName("daily_deals_legacy")
      VALUE_DAILY_DEALS_LEGACY("daily_deals_legacy"),
      @SerializedName("ig_product_tagging")
      VALUE_IG_PRODUCT_TAGGING("ig_product_tagging"),
      @SerializedName("marketplace")
      VALUE_MARKETPLACE("marketplace"),
      @SerializedName("marketplace_ads_deprecated")
      VALUE_MARKETPLACE_ADS_DEPRECATED("marketplace_ads_deprecated"),
      @SerializedName("marketplace_shops")
      VALUE_MARKETPLACE_SHOPS("marketplace_shops"),
      @SerializedName("mini_shops")
      VALUE_MINI_SHOPS("mini_shops"),
      @SerializedName("offline_conversions")
      VALUE_OFFLINE_CONVERSIONS("offline_conversions"),
      @SerializedName("shops")
      VALUE_SHOPS("shops"),
      @SerializedName("universal_checkout")
      VALUE_UNIVERSAL_CHECKOUT("universal_checkout"),
      @SerializedName("whatsapp")
      VALUE_WHATSAPP("whatsapp"),
      ;

      private String value;

      private EnumAffectedChannels(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumAffectedEntity {
      @SerializedName("product_catalog")
      VALUE_PRODUCT_CATALOG("product_catalog"),
      @SerializedName("product_event")
      VALUE_PRODUCT_EVENT("product_event"),
      @SerializedName("product_item")
      VALUE_PRODUCT_ITEM("product_item"),
      @SerializedName("product_set")
      VALUE_PRODUCT_SET("product_set"),
      ;

      private String value;

      private EnumAffectedEntity(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumAffectedFeatures {
      @SerializedName("augmented_reality")
      VALUE_AUGMENTED_REALITY("augmented_reality"),
      @SerializedName("checkout")
      VALUE_CHECKOUT("checkout"),
      ;

      private String value;

      private EnumAffectedFeatures(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSeverity {
      @SerializedName("MUST_FIX")
      VALUE_MUST_FIX("MUST_FIX"),
      @SerializedName("OPPORTUNITY")
      VALUE_OPPORTUNITY("OPPORTUNITY"),
      ;

      private String value;

      private EnumSeverity(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumType {
      @SerializedName("AR_VISIBILITY_ISSUES")
      VALUE_AR_VISIBILITY_ISSUES("AR_VISIBILITY_ISSUES"),
      @SerializedName("ATTRIBUTES_INVALID")
      VALUE_ATTRIBUTES_INVALID("ATTRIBUTES_INVALID"),
      @SerializedName("ATTRIBUTES_MISSING")
      VALUE_ATTRIBUTES_MISSING("ATTRIBUTES_MISSING"),
      @SerializedName("CATEGORY")
      VALUE_CATEGORY("CATEGORY"),
      @SerializedName("CHECKOUT")
      VALUE_CHECKOUT("CHECKOUT"),
      @SerializedName("DA_VISIBILITY_ISSUES")
      VALUE_DA_VISIBILITY_ISSUES("DA_VISIBILITY_ISSUES"),
      @SerializedName("EVENT_SOURCE_ISSUES")
      VALUE_EVENT_SOURCE_ISSUES("EVENT_SOURCE_ISSUES"),
      @SerializedName("IMAGE_QUALITY")
      VALUE_IMAGE_QUALITY("IMAGE_QUALITY"),
      @SerializedName("LOW_QUALITY_TITLE_AND_DESCRIPTION")
      VALUE_LOW_QUALITY_TITLE_AND_DESCRIPTION("LOW_QUALITY_TITLE_AND_DESCRIPTION"),
      @SerializedName("POLICY_VIOLATION")
      VALUE_POLICY_VIOLATION("POLICY_VIOLATION"),
      @SerializedName("SHOPS_VISIBILITY_ISSUES")
      VALUE_SHOPS_VISIBILITY_ISSUES("SHOPS_VISIBILITY_ISSUES"),
      ;

      private String value;

      private EnumType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumAffectedEntities {
      @SerializedName("product_catalog")
      VALUE_PRODUCT_CATALOG("product_catalog"),
      @SerializedName("product_event")
      VALUE_PRODUCT_EVENT("product_event"),
      @SerializedName("product_item")
      VALUE_PRODUCT_ITEM("product_item"),
      @SerializedName("product_set")
      VALUE_PRODUCT_SET("product_set"),
      ;

      private String value;

      private EnumAffectedEntities(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSeverities {
      @SerializedName("MUST_FIX")
      VALUE_MUST_FIX("MUST_FIX"),
      @SerializedName("OPPORTUNITY")
      VALUE_OPPORTUNITY("OPPORTUNITY"),
      ;

      private String value;

      private EnumSeverities(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumTypes {
      @SerializedName("AR_VISIBILITY_ISSUES")
      VALUE_AR_VISIBILITY_ISSUES("AR_VISIBILITY_ISSUES"),
      @SerializedName("ATTRIBUTES_INVALID")
      VALUE_ATTRIBUTES_INVALID("ATTRIBUTES_INVALID"),
      @SerializedName("ATTRIBUTES_MISSING")
      VALUE_ATTRIBUTES_MISSING("ATTRIBUTES_MISSING"),
      @SerializedName("CATEGORY")
      VALUE_CATEGORY("CATEGORY"),
      @SerializedName("CHECKOUT")
      VALUE_CHECKOUT("CHECKOUT"),
      @SerializedName("DA_VISIBILITY_ISSUES")
      VALUE_DA_VISIBILITY_ISSUES("DA_VISIBILITY_ISSUES"),
      @SerializedName("EVENT_SOURCE_ISSUES")
      VALUE_EVENT_SOURCE_ISSUES("EVENT_SOURCE_ISSUES"),
      @SerializedName("IMAGE_QUALITY")
      VALUE_IMAGE_QUALITY("IMAGE_QUALITY"),
      @SerializedName("LOW_QUALITY_TITLE_AND_DESCRIPTION")
      VALUE_LOW_QUALITY_TITLE_AND_DESCRIPTION("LOW_QUALITY_TITLE_AND_DESCRIPTION"),
      @SerializedName("POLICY_VIOLATION")
      VALUE_POLICY_VIOLATION("POLICY_VIOLATION"),
      @SerializedName("SHOPS_VISIBILITY_ISSUES")
      VALUE_SHOPS_VISIBILITY_ISSUES("SHOPS_VISIBILITY_ISSUES"),
      ;

      private String value;

      private EnumTypes(String value) {
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

  public ProductCatalogDiagnosticGroup copyFrom(ProductCatalogDiagnosticGroup instance) {
    this.mAffectedChannels = instance.mAffectedChannels;
    this.mAffectedEntity = instance.mAffectedEntity;
    this.mAffectedFeatures = instance.mAffectedFeatures;
    this.mDiagnostics = instance.mDiagnostics;
    this.mErrorCode = instance.mErrorCode;
    this.mNumberOfAffectedEntities = instance.mNumberOfAffectedEntities;
    this.mNumberOfAffectedItems = instance.mNumberOfAffectedItems;
    this.mSeverity = instance.mSeverity;
    this.mSubtitle = instance.mSubtitle;
    this.mTitle = instance.mTitle;
    this.mType = instance.mType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductCatalogDiagnosticGroup> getParser() {
    return new APIRequest.ResponseParser<ProductCatalogDiagnosticGroup>() {
      public APINodeList<ProductCatalogDiagnosticGroup> parseResponse(String response, APIContext context, APIRequest<ProductCatalogDiagnosticGroup> request, String header) throws MalformedResponseException {
        return ProductCatalogDiagnosticGroup.parseResponse(response, context, request, header);
      }
    };
  }
}
