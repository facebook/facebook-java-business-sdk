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
import com.google.gson.JsonParser;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class APINodeList<T extends APINode> extends ArrayList<T> implements APIResponse {
    // before after are cursors used by cursor based pagination
    private String before;
    private String after;
    // previous and next are URLs used to fetch pages. They are used more general
    // See https://developers.facebook.com/docs/graph-api/using-graph-api/#paging
    private String previous;
    private String next;
    private APIRequest<T> request;
    private String rawValue;
    private boolean autoPagination;

    public APINodeList(APIRequest<T> request, String rawValue) {
      this.request = request;
      this.rawValue = rawValue;
    }

    public APINodeList<T> withAutoPaginationIterator(boolean autoPagination) {
      this.autoPagination = autoPagination;
      return this;
    }

    public APINodeList<T> nextPage() throws APIException {
      return nextPage(0);
    }

    public APINodeList<T> nextPage(int limit) throws APIException {
      if (this.next != null) {
        this.request.setOverrideUrl(this.next);
        return (APINodeList<T>) request.execute();
      }
      if (after == null) return null;
      this.request.setOverrideUrl(null);
      Map<String, Object> extraParams = new HashMap<String, Object>();
      if (limit > 0) extraParams.put("limit", limit);
      extraParams.put("after", after);
      return (APINodeList<T>) request.execute(extraParams);
    }

    public void setCursors(String before, String after) {
      this.before = before;
      this.after = after;
    }

    public void setPaging(String previous, String next) {
      this.previous = previous;
      this.next = next;
    }

    @Override
    public Iterator<T> iterator() {
      return this.autoPagination ? new APINodeListAutoPaginationIterator(this) : super.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
      Objects.requireNonNull(action);
      for (T t : this) {
        action.accept(t);
      }
    }

    @Override
    public String getRawResponse() {
      return rawValue;
    }

    @Override
    public JsonObject getRawResponseAsJsonObject() {
      JsonParser parser = new JsonParser();
      return parser.parse(rawValue).getAsJsonObject();
    }

    @Override
    public T head() {
      return this.size() > 0 ? this.get(0) : null;
    }

    @Override
    public APIException getException() {
      return null;
    }

    protected Iterator<T> getCurrentListIterator() {
      return super.iterator();
    }

    private class APINodeListAutoPaginationIterator<E extends APINodeList<T>> implements Iterator<T> {
      private APINodeList<T> list;
      private Iterator<T> it;

      APINodeListAutoPaginationIterator(E list) {
        this.list = list;
        this.it = list.getCurrentListIterator();
      }

      @Override
      public boolean hasNext() {
        if (it.hasNext()) {
          return true;
        } else {
          try {
            list = list.nextPage();
          } catch (APIException e) {
            throw new RuntimeException(e);
          }
          if (list == null) {
            return false;
          } else {
            it = list.getCurrentListIterator();
            return it.hasNext();
          }
        }
      }

      @Override
      public T next() {
        return this.hasNext() ? it.next() : null;
      }
    }
}
