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
public class ProductCatalogUserPermissions extends APINode {
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("business_persona")
  private Object mBusinessPersona = null;
  @SerializedName("created_by")
  private User mCreatedBy = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("email")
  private String mEmail = null;
  @SerializedName("role")
  private String mRole = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("updated_by")
  private User mUpdatedBy = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("user")
  private User mUser = null;
  protected static Gson gson = null;

  public ProductCatalogUserPermissions() {
  }

  public String getId() {
    return null;
  }
  public static ProductCatalogUserPermissions loadJSON(String json, APIContext context, String header) {
    ProductCatalogUserPermissions productCatalogUserPermissions = getGson().fromJson(json, ProductCatalogUserPermissions.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productCatalogUserPermissions.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    productCatalogUserPermissions.context = context;
    productCatalogUserPermissions.rawValue = json;
    productCatalogUserPermissions.header = header;
    return productCatalogUserPermissions;
  }

  public static APINodeList<ProductCatalogUserPermissions> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ProductCatalogUserPermissions> productCatalogUserPermissionss = new APINodeList<ProductCatalogUserPermissions>(request, json, header);
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
          productCatalogUserPermissionss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return productCatalogUserPermissionss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productCatalogUserPermissionss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productCatalogUserPermissionss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productCatalogUserPermissionss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productCatalogUserPermissionss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  productCatalogUserPermissionss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              productCatalogUserPermissionss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return productCatalogUserPermissionss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productCatalogUserPermissionss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return productCatalogUserPermissionss;
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
              productCatalogUserPermissionss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productCatalogUserPermissionss;
          }

          // Sixth, check if it's pure JsonObject
          productCatalogUserPermissionss.clear();
          productCatalogUserPermissionss.add(loadJSON(json, context, header));
          return productCatalogUserPermissionss;
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


  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public ProductCatalogUserPermissions setFieldBusiness(Business value) {
    this.mBusiness = value;
    return this;
  }

  public ProductCatalogUserPermissions setFieldBusiness(String value) {
    Type type = new TypeToken<Business>(){}.getType();
    this.mBusiness = Business.getGson().fromJson(value, type);
    return this;
  }
  public Object getFieldBusinessPersona() {
    return mBusinessPersona;
  }

  public ProductCatalogUserPermissions setFieldBusinessPersona(Object value) {
    this.mBusinessPersona = value;
    return this;
  }

  public User getFieldCreatedBy() {
    if (mCreatedBy != null) {
      mCreatedBy.context = getContext();
    }
    return mCreatedBy;
  }

  public ProductCatalogUserPermissions setFieldCreatedBy(User value) {
    this.mCreatedBy = value;
    return this;
  }

  public ProductCatalogUserPermissions setFieldCreatedBy(String value) {
    Type type = new TypeToken<User>(){}.getType();
    this.mCreatedBy = User.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public ProductCatalogUserPermissions setFieldCreatedTime(String value) {
    this.mCreatedTime = value;
    return this;
  }

  public String getFieldEmail() {
    return mEmail;
  }

  public ProductCatalogUserPermissions setFieldEmail(String value) {
    this.mEmail = value;
    return this;
  }

  public String getFieldRole() {
    return mRole;
  }

  public ProductCatalogUserPermissions setFieldRole(String value) {
    this.mRole = value;
    return this;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public ProductCatalogUserPermissions setFieldStatus(String value) {
    this.mStatus = value;
    return this;
  }

  public User getFieldUpdatedBy() {
    if (mUpdatedBy != null) {
      mUpdatedBy.context = getContext();
    }
    return mUpdatedBy;
  }

  public ProductCatalogUserPermissions setFieldUpdatedBy(User value) {
    this.mUpdatedBy = value;
    return this;
  }

  public ProductCatalogUserPermissions setFieldUpdatedBy(String value) {
    Type type = new TypeToken<User>(){}.getType();
    this.mUpdatedBy = User.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public ProductCatalogUserPermissions setFieldUpdatedTime(String value) {
    this.mUpdatedTime = value;
    return this;
  }

  public User getFieldUser() {
    if (mUser != null) {
      mUser.context = getContext();
    }
    return mUser;
  }

  public ProductCatalogUserPermissions setFieldUser(User value) {
    this.mUser = value;
    return this;
  }

  public ProductCatalogUserPermissions setFieldUser(String value) {
    Type type = new TypeToken<User>(){}.getType();
    this.mUser = User.getGson().fromJson(value, type);
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

  public ProductCatalogUserPermissions copyFrom(ProductCatalogUserPermissions instance) {
    this.mBusiness = instance.mBusiness;
    this.mBusinessPersona = instance.mBusinessPersona;
    this.mCreatedBy = instance.mCreatedBy;
    this.mCreatedTime = instance.mCreatedTime;
    this.mEmail = instance.mEmail;
    this.mRole = instance.mRole;
    this.mStatus = instance.mStatus;
    this.mUpdatedBy = instance.mUpdatedBy;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mUser = instance.mUser;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductCatalogUserPermissions> getParser() {
    return new APIRequest.ResponseParser<ProductCatalogUserPermissions>() {
      public APINodeList<ProductCatalogUserPermissions> parseResponse(String response, APIContext context, APIRequest<ProductCatalogUserPermissions> request, String header) throws MalformedResponseException {
        return ProductCatalogUserPermissions.parseResponse(response, context, request, header);
      }
    };
  }
}
