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
import java.util.Map;
import java.util.List;

public class APIException extends Exception implements APIResponse {
  private String header;

  public APIException () {
    super();
  }

  public APIException (Throwable e) {
    super(e);
  }

  public APIException (String message) {
    super(message);
  }

  public APIException (String message, Throwable e) {
    super(message, e);
  }

  public APIException (String header, String message, Throwable e) {
    super(message, e);
    this.header = header;
  }

  @Override
  public APINode head() {
    return null;
  }

  @Override
  public APIException getException() {
    return this;
  }

  @Override
  public String getRawResponse() {
    return this.getMessage();
  }

  @Override
  public JsonObject getRawResponseAsJsonObject() {
    JsonParser parser = new JsonParser();
    return parser.parse(this.getMessage()).getAsJsonObject();
  }

  @Override
  public String getHeader() {
    return this.header;
  }

  public static class MalformedResponseException extends APIException {
    public MalformedResponseException () {
      super();
    }

    public MalformedResponseException (Throwable e) {
      super(e);
    }

    public MalformedResponseException (String message) {
      super(message);
    }

    public MalformedResponseException (String message, Throwable e) {
      super(message, e);
    }
  }

  public static class FailedRequestException extends APIException {
    public FailedRequestException () {
      super();
    }

    public FailedRequestException (Throwable e) {
      super(e);
    }

    public FailedRequestException (String message) {
      super(message);
    }

    public FailedRequestException (String message, Throwable e) {
      super(message, e);
    }

    public FailedRequestException (String header, String message, Throwable e) {
      super(header, message, e);
    }
  }
}
