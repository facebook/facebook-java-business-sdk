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

import java.lang.reflect.Modifier;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
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
public class AudiencePermissionForActions extends APINode {
  @SerializedName("can_edit")
  private Boolean mCanEdit = null;
  @SerializedName("can_see_insight")
  private Boolean mCanSeeInsight = null;
  @SerializedName("can_share")
  private Boolean mCanShare = null;
  @SerializedName("subtype_supports_lookalike")
  private Boolean mSubtypeSupportsLookalike = null;
  @SerializedName("supports_recipient_lookalike")
  private Boolean mSupportsRecipientLookalike = null;
  protected static Gson gson = null;

  public AudiencePermissionForActions() {
  }

  public String getId() {
    return null;
  }
  public static AudiencePermissionForActions loadJSON(String json, APIContext context, String header) {
    AudiencePermissionForActions audiencePermissionForActions = getGson().fromJson(json, AudiencePermissionForActions.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(audiencePermissionForActions.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    audiencePermissionForActions.context = context;
    audiencePermissionForActions.rawValue = json;
    audiencePermissionForActions.header = header;
    return audiencePermissionForActions;
  }

  public static APINodeList<AudiencePermissionForActions> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AudiencePermissionForActions> audiencePermissionForActionss = new APINodeList<AudiencePermissionForActions>(request, json, header);
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
          audiencePermissionForActionss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return audiencePermissionForActionss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                audiencePermissionForActionss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            audiencePermissionForActionss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              audiencePermissionForActionss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              audiencePermissionForActionss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  audiencePermissionForActionss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              audiencePermissionForActionss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return audiencePermissionForActionss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              audiencePermissionForActionss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return audiencePermissionForActionss;
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
              audiencePermissionForActionss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return audiencePermissionForActionss;
          }

          // Sixth, check if it's pure JsonObject
          audiencePermissionForActionss.clear();
          audiencePermissionForActionss.add(loadJSON(json, context, header));
          return audiencePermissionForActionss;
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


  public Boolean getFieldCanEdit() {
    return mCanEdit;
  }

  public AudiencePermissionForActions setFieldCanEdit(Boolean value) {
    this.mCanEdit = value;
    return this;
  }

  public Boolean getFieldCanSeeInsight() {
    return mCanSeeInsight;
  }

  public AudiencePermissionForActions setFieldCanSeeInsight(Boolean value) {
    this.mCanSeeInsight = value;
    return this;
  }

  public Boolean getFieldCanShare() {
    return mCanShare;
  }

  public AudiencePermissionForActions setFieldCanShare(Boolean value) {
    this.mCanShare = value;
    return this;
  }

  public Boolean getFieldSubtypeSupportsLookalike() {
    return mSubtypeSupportsLookalike;
  }

  public AudiencePermissionForActions setFieldSubtypeSupportsLookalike(Boolean value) {
    this.mSubtypeSupportsLookalike = value;
    return this;
  }

  public Boolean getFieldSupportsRecipientLookalike() {
    return mSupportsRecipientLookalike;
  }

  public AudiencePermissionForActions setFieldSupportsRecipientLookalike(Boolean value) {
    this.mSupportsRecipientLookalike = value;
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

  public AudiencePermissionForActions copyFrom(AudiencePermissionForActions instance) {
    this.mCanEdit = instance.mCanEdit;
    this.mCanSeeInsight = instance.mCanSeeInsight;
    this.mCanShare = instance.mCanShare;
    this.mSubtypeSupportsLookalike = instance.mSubtypeSupportsLookalike;
    this.mSupportsRecipientLookalike = instance.mSupportsRecipientLookalike;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AudiencePermissionForActions> getParser() {
    return new APIRequest.ResponseParser<AudiencePermissionForActions>() {
      public APINodeList<AudiencePermissionForActions> parseResponse(String response, APIContext context, APIRequest<AudiencePermissionForActions> request, String header) throws MalformedResponseException {
        return AudiencePermissionForActions.parseResponse(response, context, request, header);
      }
    };
  }
}
