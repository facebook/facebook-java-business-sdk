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

import org.json.JSONObject;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class APINodeList<T extends APINode> extends ArrayList<T> implements IAPINodeOrNodeList {
    private String before;
    private String after;
    private APIRequest<T> request;

    public APINodeList(APIRequest<T> request) {
      this.request = request;
    }

    public APINodeList<T> nextPage() throws APIException {
      return nextPage(0);
    }

    public APINodeList<T> nextPage(int limit) throws APIException {
      if (after == null) return null;
      Map<String, Object> extraParams = new HashMap<String, Object>();
      if (limit > 0) extraParams.put("limit", limit);
      extraParams.put("after", after);
      return (APINodeList<T>) request.call(extraParams);
    }

    public void setPaging(String before, String after) {
      this.before = before;
      this.after = after;
    }

    public T head() {
      return this.size() > 0 ? this.get(0) : null;
    }
}
