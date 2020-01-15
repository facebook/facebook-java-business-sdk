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
 */
package com.facebook.ads.sdk.samples;

import com.facebook.ads.sdk.APIContext;
import com.google.common.io.Resources;

import java.io.File;
import java.net.URISyntaxException;

public class ExampleConfig {
  public static final String ACCESS_TOKEN = "Your Access Token";
  public static final String ACCOUNT_ID = "Your Account ID";
  public static final String APP_SECRET = "Your app secret";
  public static final String PAGE_ID = "Your Page ID";

  public static final APIContext CONTEXT = new APIContext(ACCESS_TOKEN, APP_SECRET).enableDebug(true);

  public static final String VIDEO_FILE = "video.mp4";
  public static final String BUSINESS_ID = "Your Business ID";
  public static final String DPA_FEED_FILE_PATH = "dpa-feed-example.xml";
  public static final String CAMPAIGN_ID = "Your campaign ID";

  public static File IMAGE_FILE = null;

  static {
    try {
      IMAGE_FILE = new File(Resources.getResource("image.png").toURI());
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }

}
