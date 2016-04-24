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
public class ConnectionObject extends APINode {
  @SerializedName("app_installs_tracked")
  private Boolean mAppInstallsTracked = null;
  @SerializedName("checkin_capable")
  private Boolean mCheckinCapable = null;
  @SerializedName("cpa_access")
  private Map<String, Boolean> mCpaAccess = null;
  @SerializedName("event_is_viewer_admin")
  private Boolean mEventIsViewerAdmin = null;
  @SerializedName("event_parent_page_id")
  private String mEventParentPageId = null;
  @SerializedName("event_parent_page_name")
  private String mEventParentPageName = null;
  @SerializedName("event_start_timestamp")
  private Long mEventStartTimestamp = null;
  @SerializedName("icon_url")
  private String mIconUrl = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_game")
  private Boolean mIsGame = null;
  @SerializedName("logo_url")
  private String mLogoUrl = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("name_with_location_descriptor")
  private String mNameWithLocationDescriptor = null;
  @SerializedName("native_app_store_ids")
  private Map<String, String> mNativeAppStoreIds = null;
  @SerializedName("native_app_targeting_ids")
  private Map<String, String> mNativeAppTargetingIds = null;
  @SerializedName("object_store_urls")
  private Map<String, String> mObjectStoreUrls = null;
  @SerializedName("og_actions")
  private List<ConnectionObjectOpenGraphAction> mOgActions = null;
  @SerializedName("og_namespace")
  private String mOgNamespace = null;
  @SerializedName("og_objects")
  private List<ConnectionObjectOpenGraphObject> mOgObjects = null;
  @SerializedName("picture")
  private String mPicture = null;
  @SerializedName("supported_platforms")
  private List<Long> mSupportedPlatforms = null;
  @SerializedName("tabs")
  private Map<String, String> mTabs = null;
  @SerializedName("type")
  private Long mType = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("website")
  private String mWebsite = null;
  protected static Gson gson = null;

  public ConnectionObject() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ConnectionObject loadJSON(String json, APIContext context) {
    ConnectionObject connectionObject = getGson().fromJson(json, ConnectionObject.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(connectionObject.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    connectionObject.context = context;
    connectionObject.rawValue = json;
    return connectionObject;
  }

  public static APINodeList<ConnectionObject> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ConnectionObject> connectionObjects = new APINodeList<ConnectionObject>(request, json);
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
          connectionObjects.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return connectionObjects;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            connectionObjects.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              connectionObjects.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  connectionObjects.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              connectionObjects.add(loadJSON(obj.toString(), context));
            }
          }
          return connectionObjects;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              connectionObjects.add(loadJSON(entry.getValue().toString(), context));
          }
          return connectionObjects;
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
              connectionObjects.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return connectionObjects;
          }

          // Sixth, check if it's pure JsonObject
          connectionObjects.clear();
          connectionObjects.add(loadJSON(json, context));
          return connectionObjects;
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


  public Boolean getFieldAppInstallsTracked() {
    return mAppInstallsTracked;
  }

  public ConnectionObject setFieldAppInstallsTracked(Boolean value) {
    this.mAppInstallsTracked = value;
    return this;
  }

  public Boolean getFieldCheckinCapable() {
    return mCheckinCapable;
  }

  public ConnectionObject setFieldCheckinCapable(Boolean value) {
    this.mCheckinCapable = value;
    return this;
  }

  public Map<String, Boolean> getFieldCpaAccess() {
    return mCpaAccess;
  }

  public ConnectionObject setFieldCpaAccess(Map<String, Boolean> value) {
    this.mCpaAccess = value;
    return this;
  }

  public Boolean getFieldEventIsViewerAdmin() {
    return mEventIsViewerAdmin;
  }

  public ConnectionObject setFieldEventIsViewerAdmin(Boolean value) {
    this.mEventIsViewerAdmin = value;
    return this;
  }

  public String getFieldEventParentPageId() {
    return mEventParentPageId;
  }

  public ConnectionObject setFieldEventParentPageId(String value) {
    this.mEventParentPageId = value;
    return this;
  }

  public String getFieldEventParentPageName() {
    return mEventParentPageName;
  }

  public ConnectionObject setFieldEventParentPageName(String value) {
    this.mEventParentPageName = value;
    return this;
  }

  public Long getFieldEventStartTimestamp() {
    return mEventStartTimestamp;
  }

  public ConnectionObject setFieldEventStartTimestamp(Long value) {
    this.mEventStartTimestamp = value;
    return this;
  }

  public String getFieldIconUrl() {
    return mIconUrl;
  }

  public ConnectionObject setFieldIconUrl(String value) {
    this.mIconUrl = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public ConnectionObject setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public Boolean getFieldIsGame() {
    return mIsGame;
  }

  public ConnectionObject setFieldIsGame(Boolean value) {
    this.mIsGame = value;
    return this;
  }

  public String getFieldLogoUrl() {
    return mLogoUrl;
  }

  public ConnectionObject setFieldLogoUrl(String value) {
    this.mLogoUrl = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public ConnectionObject setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldNameWithLocationDescriptor() {
    return mNameWithLocationDescriptor;
  }

  public ConnectionObject setFieldNameWithLocationDescriptor(String value) {
    this.mNameWithLocationDescriptor = value;
    return this;
  }

  public Map<String, String> getFieldNativeAppStoreIds() {
    return mNativeAppStoreIds;
  }

  public ConnectionObject setFieldNativeAppStoreIds(Map<String, String> value) {
    this.mNativeAppStoreIds = value;
    return this;
  }

  public Map<String, String> getFieldNativeAppTargetingIds() {
    return mNativeAppTargetingIds;
  }

  public ConnectionObject setFieldNativeAppTargetingIds(Map<String, String> value) {
    this.mNativeAppTargetingIds = value;
    return this;
  }

  public Map<String, String> getFieldObjectStoreUrls() {
    return mObjectStoreUrls;
  }

  public ConnectionObject setFieldObjectStoreUrls(Map<String, String> value) {
    this.mObjectStoreUrls = value;
    return this;
  }

  public List<ConnectionObjectOpenGraphAction> getFieldOgActions() {
    return mOgActions;
  }

  public ConnectionObject setFieldOgActions(List<ConnectionObjectOpenGraphAction> value) {
    this.mOgActions = value;
    return this;
  }

  public ConnectionObject setFieldOgActions(String value) {
    Type type = new TypeToken<List<ConnectionObjectOpenGraphAction>>(){}.getType();
    this.mOgActions = ConnectionObjectOpenGraphAction.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldOgNamespace() {
    return mOgNamespace;
  }

  public ConnectionObject setFieldOgNamespace(String value) {
    this.mOgNamespace = value;
    return this;
  }

  public List<ConnectionObjectOpenGraphObject> getFieldOgObjects() {
    return mOgObjects;
  }

  public ConnectionObject setFieldOgObjects(List<ConnectionObjectOpenGraphObject> value) {
    this.mOgObjects = value;
    return this;
  }

  public ConnectionObject setFieldOgObjects(String value) {
    Type type = new TypeToken<List<ConnectionObjectOpenGraphObject>>(){}.getType();
    this.mOgObjects = ConnectionObjectOpenGraphObject.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldPicture() {
    return mPicture;
  }

  public ConnectionObject setFieldPicture(String value) {
    this.mPicture = value;
    return this;
  }

  public List<Long> getFieldSupportedPlatforms() {
    return mSupportedPlatforms;
  }

  public ConnectionObject setFieldSupportedPlatforms(List<Long> value) {
    this.mSupportedPlatforms = value;
    return this;
  }

  public Map<String, String> getFieldTabs() {
    return mTabs;
  }

  public ConnectionObject setFieldTabs(Map<String, String> value) {
    this.mTabs = value;
    return this;
  }

  public Long getFieldType() {
    return mType;
  }

  public ConnectionObject setFieldType(Long value) {
    this.mType = value;
    return this;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public ConnectionObject setFieldUrl(String value) {
    this.mUrl = value;
    return this;
  }

  public String getFieldWebsite() {
    return mWebsite;
  }

  public ConnectionObject setFieldWebsite(String value) {
    this.mWebsite = value;
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

  public ConnectionObject copyFrom(ConnectionObject instance) {
    this.mAppInstallsTracked = instance.mAppInstallsTracked;
    this.mCheckinCapable = instance.mCheckinCapable;
    this.mCpaAccess = instance.mCpaAccess;
    this.mEventIsViewerAdmin = instance.mEventIsViewerAdmin;
    this.mEventParentPageId = instance.mEventParentPageId;
    this.mEventParentPageName = instance.mEventParentPageName;
    this.mEventStartTimestamp = instance.mEventStartTimestamp;
    this.mIconUrl = instance.mIconUrl;
    this.mId = instance.mId;
    this.mIsGame = instance.mIsGame;
    this.mLogoUrl = instance.mLogoUrl;
    this.mName = instance.mName;
    this.mNameWithLocationDescriptor = instance.mNameWithLocationDescriptor;
    this.mNativeAppStoreIds = instance.mNativeAppStoreIds;
    this.mNativeAppTargetingIds = instance.mNativeAppTargetingIds;
    this.mObjectStoreUrls = instance.mObjectStoreUrls;
    this.mOgActions = instance.mOgActions;
    this.mOgNamespace = instance.mOgNamespace;
    this.mOgObjects = instance.mOgObjects;
    this.mPicture = instance.mPicture;
    this.mSupportedPlatforms = instance.mSupportedPlatforms;
    this.mTabs = instance.mTabs;
    this.mType = instance.mType;
    this.mUrl = instance.mUrl;
    this.mWebsite = instance.mWebsite;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ConnectionObject> getParser() {
    return new APIRequest.ResponseParser<ConnectionObject>() {
      public APINodeList<ConnectionObject> parseResponse(String response, APIContext context, APIRequest<ConnectionObject> request) throws MalformedResponseException {
        return ConnectionObject.parseResponse(response, context, request);
      }
    };
  }
}