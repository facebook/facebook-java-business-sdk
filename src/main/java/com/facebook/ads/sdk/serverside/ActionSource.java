/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * <p>You are hereby granted a non-exclusive, worldwide, royalty-free license to use, copy, modify,
 * and distribute this software in source code or binary form for use in connection with the web
 * services and APIs provided by Facebook.
 *
 * <p>As with any software that integrates with the Facebook platform, your use of this software is
 * subject to the Facebook Developer Principles and Policies [http://developers.facebook.com/policy/].
 * This copyright notice shall be included in all copies or substantial portions of the software.
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.facebook.ads.sdk.serverside;

/**
 * Used to specify where the conversion occurred.
 * See https://developers.facebook.com/docs/marketing-api/conversions-api/parameters/server-event#action-source
 */
public enum ActionSource {

  /**
   * Conversion happened over email.
   */
  email,

  /**
   * Conversion was made on your website.
   */
  website,

  /**
   * Conversion was made using your app.
   */
  app,

  /**
   * Conversion was made over the phone.
   */
  phone_call,

  /**
   * Conversion was made via a messaging app, SMS, or online messaging feature.
   */
  chat,

  /**
   * Conversion was made in person at your physical store.
   */
  physical_store,

  /**
   * Conversion happened automatically, for example, a subscription renewal that’s set on auto-pay each month.
   */
  system_generated,

  /**
   * Conversion happened in a way that is not listed.
   */
  other
}
