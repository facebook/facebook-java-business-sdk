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

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.facebook.ads.sdk.APIException.MalformedResponseException;

public class APINode implements APIResponse {

  protected APIContext context = null;
  protected String rawValue = null;
  protected String header = null;

  public static APINode loadJSON(String json, APIContext context, String header) {
    APINode result = null;
    result = new APINode();
    result.context = context;
    result.rawValue = json;
    result.header = header;
    return result;
  }

  public APIContext getContext() {
    return context;
  }

  public void setContext(APIContext context) {
    this.context = context;
  }

  public String toString() {
    return rawValue;
  }

  public String getId() {
    try {
      JsonParser parser = new JsonParser();
      return parser.parse(rawValue).getAsJsonObject().get("id").getAsString();
    } catch (Exception e) {
      return null;
    }
  };

  public String getRawValue() {
    return rawValue;
  }

  @Override
  public String getRawResponse() {
    return rawValue;
  }

  @Override
  public JsonObject getRawResponseAsJsonObject() {
    JsonParser parser = new JsonParser();
    try {
      return parser.parse(rawValue).getAsJsonObject();
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public APINode head() {
    return this;
  }

  @Override
  public String getHeader() {
    return this.header;
  }

  public static APINodeList<APINode> parseResponse(String json, APIContext context, APIRequest<APINode> request, String header) throws MalformedResponseException{
    APINodeList<APINode> nodes = new APINodeList<APINode>(request, json, header);
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
          nodes.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return nodes;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                nodes.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            nodes.setPaging(previous, next);
          }
          if (context.hasAppSecret()) {
            nodes.setAppSecret(context.getAppSecretProof());
          }

          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              nodes.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            nodes.add(loadJSON(obj.toString(), context, header));
          }
          return nodes;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              nodes.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return nodes;
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
              nodes.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return nodes;
          }

          // Sixth, check if it's pure JsonObject
          nodes.clear();
          nodes.add(loadJSON(json, context, header));
          return nodes;
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
  public APIException getException() {
    return null;
  }
}
