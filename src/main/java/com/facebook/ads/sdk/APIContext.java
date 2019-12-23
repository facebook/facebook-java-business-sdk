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
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;

public class APIContext {
  public static final String DEFAULT_API_BASE = APIConfig.DEFAULT_API_BASE;
  public static final String DEFAULT_API_VERSION = APIConfig.DEFAULT_API_VERSION;
  public static final String DEFAULT_VIDEO_API_BASE = APIConfig.DEFAULT_VIDEO_API_BASE;
  private String endpointBase;
  private String videoEndpointBase;
  private String accessToken;
  private String appSecret;
  private String appID;
  private String version;
  protected boolean isDebug = false;
  protected PrintStream logger = System.out;

  public APIContext(String endpointBase, String videoEndpointBase, String version, String accessToken, String appSecret, String appID, boolean logCrash) {
    this.version = version;
    this.endpointBase = endpointBase;
    this.videoEndpointBase = videoEndpointBase;
    this.accessToken = accessToken;
    this.appSecret = appSecret;
    this.appID =  appID;
    if (logCrash) {
        CrashReporter.enable(this);
    }
  }

  public APIContext(String accessToken) {
    this(DEFAULT_API_BASE, DEFAULT_VIDEO_API_BASE, DEFAULT_API_VERSION, accessToken, null, null, true);
  }

  public APIContext(String accessToken, String appSecret) {
    this(DEFAULT_API_BASE, DEFAULT_VIDEO_API_BASE, DEFAULT_API_VERSION, accessToken, appSecret, null, true);
  }

  public APIContext(String accessToken, String appSecret, String appID) {
    this(DEFAULT_API_BASE, DEFAULT_VIDEO_API_BASE, DEFAULT_API_VERSION, accessToken, appSecret, appID, true);
  }

  public APIContext(String accessToken, String appSecret, String appID, boolean logCrash) {
    this(DEFAULT_API_BASE, DEFAULT_VIDEO_API_BASE, DEFAULT_API_VERSION, accessToken, appSecret, appID, logCrash);
  }

  public String getEndpointBase() {
    return this.endpointBase;
  }

  public String getVideoEndpointBase() {
    return this.videoEndpointBase;
  }

  public String getAccessToken() {
    return this.accessToken;
  }

  public String getAppSecret() {
    return this.appSecret;
  }

  public boolean hasAppSecret() {
    return appSecret != null;
  }

  public String getAppSecretProof() {
    return sha256(appSecret, accessToken);
  }

  public String getVersion() {
    return this.version;
  }

  public boolean isDebug() {
    return this.isDebug;
  }

  public APIContext enableDebug(boolean isDebug) {
    this.isDebug = isDebug;
    return this;
  }

  public PrintStream getLogger() {
    return this.logger;
  }

  public APIContext setLogger(PrintStream logger) {
    this.logger = logger;
    return this;
  }

  public void log(String s) {
    if (isDebug && logger != null) logger.println(s);
  }

  public static String sha256(String secret, String message) {
    try {
      Mac sha256HMAC = Mac.getInstance("HmacSHA256");
      SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
      sha256HMAC.init(secretKey);
      byte[] bytes = sha256HMAC.doFinal(message.getBytes());
      return toHex(bytes);
    } catch(Exception e){
      throw new IllegalArgumentException(
        "The provided app secret or access token is invalid!"
      );
    }
  }

  public static String toHex(byte[] bytes) {
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
        sb.append(String.format("%1$02x", b));
    }
    return sb.toString();
  }

  public String getAppID() {
    if (this.appID != null) {
      return this.appID;
    }
    if (this.accessToken != null) {
      try {
        APIRequest.DefaultRequestExecutor executor = new APIRequest.DefaultRequestExecutor();
        String apiUrl = this.endpointBase  + "/" + this.version  + "/debug_token";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("input_token", this.accessToken);
        params.put("access_token", this.accessToken);
        params.put("fields", "app_id");

        APIRequest.ResponseWrapper response = executor.execute("GET", apiUrl, params, this);
        JsonParser parser = new JsonParser();
        this.appID = parser.parse(response.getBody())
          .getAsJsonObject()
          .get("data")
          .getAsJsonObject()
          .get("app_id")
          .getAsString();

        return this.appID;
      } catch (Exception e) {
        log("Unable to fetch appID from the access token");
      }
    }

    return null;
  }

  public static void disableCrashReport() {
    CrashReporter.disable();
  }
}
