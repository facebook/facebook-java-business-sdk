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
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
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
    private String header;
    private boolean autoPagination;
    private String appSecret;

    public APINodeList(APIRequest<T> request, String rawValue, String header) {
      this.request = request;
      this.rawValue = rawValue;
      this.header = header;
    }

    public APINodeList<T> withAutoPaginationIterator(boolean autoPagination) {
      this.autoPagination = autoPagination;
      return this;
    }

    public APINodeList<T> nextPage() throws APIException {
      return nextPage(0);
    }

    public APINodeList<T> nextPage(int limit) throws APIException {
      // First check if 'next' url is retured. If so, always use the it.
      if (this.next != null) {
        // App secret won't return with the 'next' URL. Need to append it
        // for paging.
        if (this.appSecret == null) {
          this.request.setOverrideUrl(this.next);
        } else {
          try {
            URL a = new URL(this.next);
            String connector = a.getQuery() == null ? "?" : "&";
            this.request.setOverrideUrl(
              this.next +
              connector +
              "appsecret_proof=" +
              this.appSecret
            );
          } catch (java.net.MalformedURLException e) {
            return null;
          }
        }
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

    public void setAppSecret(String appSecret) {
      this.appSecret = appSecret;
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
    public String getHeader() {
      return this.header;
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


      @Override
      public int size() {
        if (this.autoPagination) {
          throw new RuntimeException("When auto pagination is enabled, size is not available. Use stream/parallelStream or forEach to iterate");
        } else {
          return super.size();
        }
      }

      @Override
      public Spliterator<T> spliterator() {
        return this.autoPagination ? new APINodeListAutoPaginationSpliterator(this) : super.spliterator();
      }

      private class APINodeListAutoPaginationSpliterator implements Spliterator<T> {
        APINodeList<T> list;
        Iterator<T> it;
        boolean alreadySplit = false;

        APINodeListAutoPaginationSpliterator(APINodeList<T> list) {
          this.list = list.withAutoPaginationIterator(true);
          this.it = list.getCurrentListIterator();
        }

        @Override
        public boolean tryAdvance(Consumer<? super T> action) {
          if (it.hasNext()) {
            action.accept(it.next());
            return true;
          } else {
            if (alreadySplit) {
              return false;
            } else {
              try {
                this.list = list.nextPage();
                if (this.list == null) {
                  return false;
                }
                this.it = list.getCurrentListIterator();
              } catch (APIException e) {
                throw new RuntimeException(e);
              }

              if (it.hasNext()) {
                action.accept(it.next());
                return true;
              } else {
                return false;
              }
            }
          }
        }

        @Override
        public Spliterator<T> trySplit() {
          if (alreadySplit) {
            return null;
          } else {
            this.alreadySplit = true;
            try {
              APINodeList<T> nextList = list.nextPage();
              return nextList.getCurrentListIterator().hasNext() ? new APINodeListAutoPaginationSpliterator(nextList) : null;
            } catch (APIException e) {
              throw new RuntimeException(e);
            }
          }
        }

        @Override
        public long estimateSize() {
          return Integer.MAX_VALUE;
        }

        @Override
        public int characteristics() {
          return Spliterator.IMMUTABLE;
        }
      }
}
