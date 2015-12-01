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

public class APINode implements IAPINodeOrNodeList {

  protected APIContext mContext = null;
  protected String rawValue = null;

  public static APINode loadJSON(String json, APIContext context) {
    APINode result = null;
    result = new APINode();
    result.mContext = context;
    result.rawValue = json;
    return result;
  }

  public APIContext getContext() {
    return mContext;
  }

  public void setContext(APIContext context) {
    this.mContext = context;
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

  public APINode head() {
    return this;
  }

  public static APINodeList<APINode> parseResponse(String json, APIContext context, APIRequest<APINode> request) {
    APINodeList<APINode> nodes = new APINodeList<APINode>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          nodes.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return nodes;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            nodes.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              nodes.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            nodes.add(loadJSON(obj.toString(), context));
          }
          return nodes;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              nodes.add(loadJSON(entry.getValue().toString(), context));
          }
          return nodes;
        } else {
          // Fifth, check if it's pure JsonObject
          nodes.add(loadJSON(json, context));
          return nodes;
        }
      }
    } catch (Exception e) {
    }
    return null;
  }
}
