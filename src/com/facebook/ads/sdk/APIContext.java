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

import java.io.PrintStream;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APIContext {
  public static final String DEFAULT_API_BASE = APIConfig.DEFAULT_API_BASE;
  public static final String DEFAULT_API_VERSION = APIConfig.DEFAULT_API_VERSION;
  private String endpointBase;
  private String authToken;
  private String version;
  protected boolean isDebug = false;
  protected PrintStream logger = null;

  public APIContext(String endpointBase, String version, String authToken) {
    this.version = version;
    this.endpointBase = endpointBase;
    this.authToken = authToken;
  }

  public APIContext(String authToken) {
    this(DEFAULT_API_BASE, DEFAULT_API_VERSION, authToken);
  }

  public String getEndpointBase() {
    return this.endpointBase;
  }

  public String getAuthToken() {
    return this.authToken;
  }

  public String getVersion() {
    return this.version;
  }

  public boolean isDebug() {
    return isDebug;
  }

  public PrintStream getLogger() {
    return logger;
  }

  public void log(String s) {
    if (isDebug && logger != null) logger.println(s);
  }

  public static class DebugContext extends APIContext {

    public DebugContext(String endpointBase, String version, String authToken, PrintStream logger) {
      super(endpointBase, version, authToken);
      this.isDebug = true;
      this.logger = logger;
    }

    public DebugContext(String endpointBase, String version, String authToken) {
      this(endpointBase, version, authToken, System.out);
    }

    public DebugContext(String authToken, PrintStream logger) {
      this(DEFAULT_API_BASE, DEFAULT_API_VERSION, authToken, logger);
    }

    public DebugContext(String authToken) {
      this(authToken, System.out);
    }
  }
}
