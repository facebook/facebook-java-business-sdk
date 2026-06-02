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

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/**
 * Preference is an allowlist specifying which fields are allowed to be
 * automatically set on the CAPI event from the request context object.
 * All fields default to true.
 */
public class Preference {

  @SerializedName("is_fbc_allowed")
  private Boolean fbcAllowed = true;

  @SerializedName("is_fbp_allowed")
  private Boolean fbpAllowed = true;

  @SerializedName("is_client_ip_address_allowed")
  private Boolean clientIpAddressAllowed = true;

  @SerializedName("is_referrer_url_allowed")
  private Boolean referrerUrlAllowed = true;

  /**
   * Default constructor — all four flags default to true (allow-all).
   */
  public Preference() {
  }

  /**
   * Constructor.
   *
   * @param fbcAllowed              whether fbc is allowed (default: true)
   * @param fbpAllowed              whether fbp is allowed (default: true)
   * @param clientIpAddressAllowed  whether client_ip_address is allowed (default: true)
   * @param referrerUrlAllowed      whether referrer_url is allowed (default: true)
   */
  public Preference(Boolean fbcAllowed, Boolean fbpAllowed,
                    Boolean clientIpAddressAllowed, Boolean referrerUrlAllowed) {
    this.fbcAllowed = fbcAllowed;
    this.fbpAllowed = fbpAllowed;
    this.clientIpAddressAllowed = clientIpAddressAllowed;
    this.referrerUrlAllowed = referrerUrlAllowed;
  }

  // ---------- fbcAllowed ------------------------------------------------

  /**
   * Set whether fbc is allowed.
   *
   * @param fbcAllowed whether fbc is allowed.
   * @return Preference (fluent)
   */
  public Preference fbcAllowed(Boolean fbcAllowed) {
    this.fbcAllowed = fbcAllowed;
    return this;
  }

  /**
   * Get whether fbc is allowed.
   *
   * @return whether fbc is allowed.
   */
  public Boolean isFbcAllowed() {
    return fbcAllowed;
  }

  /**
   * Set whether fbc is allowed.
   *
   * @param fbcAllowed whether fbc is allowed.
   */
  public void setFbcAllowed(Boolean fbcAllowed) {
    this.fbcAllowed = fbcAllowed;
  }

  // ---------- fbpAllowed ------------------------------------------------

  /**
   * Set whether fbp is allowed.
   *
   * @param fbpAllowed whether fbp is allowed.
   * @return Preference (fluent)
   */
  public Preference fbpAllowed(Boolean fbpAllowed) {
    this.fbpAllowed = fbpAllowed;
    return this;
  }

  /**
   * Get whether fbp is allowed.
   *
   * @return whether fbp is allowed.
   */
  public Boolean isFbpAllowed() {
    return fbpAllowed;
  }

  /**
   * Set whether fbp is allowed.
   *
   * @param fbpAllowed whether fbp is allowed.
   */
  public void setFbpAllowed(Boolean fbpAllowed) {
    this.fbpAllowed = fbpAllowed;
  }

  // ---------- clientIpAddressAllowed ------------------------------------

  /**
   * Set whether client_ip_address is allowed.
   *
   * @param clientIpAddressAllowed whether client_ip_address is allowed.
   * @return Preference (fluent)
   */
  public Preference clientIpAddressAllowed(Boolean clientIpAddressAllowed) {
    this.clientIpAddressAllowed = clientIpAddressAllowed;
    return this;
  }

  /**
   * Get whether client_ip_address is allowed.
   *
   * @return whether client_ip_address is allowed.
   */
  public Boolean isClientIpAddressAllowed() {
    return clientIpAddressAllowed;
  }

  /**
   * Set whether client_ip_address is allowed.
   *
   * @param clientIpAddressAllowed whether client_ip_address is allowed.
   */
  public void setClientIpAddressAllowed(Boolean clientIpAddressAllowed) {
    this.clientIpAddressAllowed = clientIpAddressAllowed;
  }

  // ---------- referrerUrlAllowed ----------------------------------------

  /**
   * Set whether referrer_url is allowed.
   *
   * @param referrerUrlAllowed whether referrer_url is allowed.
   * @return Preference (fluent)
   */
  public Preference referrerUrlAllowed(Boolean referrerUrlAllowed) {
    this.referrerUrlAllowed = referrerUrlAllowed;
    return this;
  }

  /**
   * Get whether referrer_url is allowed.
   *
   * @return whether referrer_url is allowed.
   */
  public Boolean isReferrerUrlAllowed() {
    return referrerUrlAllowed;
  }

  /**
   * Set whether referrer_url is allowed.
   *
   * @param referrerUrlAllowed whether referrer_url is allowed.
   */
  public void setReferrerUrlAllowed(Boolean referrerUrlAllowed) {
    this.referrerUrlAllowed = referrerUrlAllowed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Preference preference = (Preference) o;
    return Objects.equals(this.fbcAllowed, preference.fbcAllowed)
        && Objects.equals(this.fbpAllowed, preference.fbpAllowed)
        && Objects.equals(this.clientIpAddressAllowed, preference.clientIpAddressAllowed)
        && Objects.equals(this.referrerUrlAllowed, preference.referrerUrlAllowed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fbcAllowed, fbpAllowed, clientIpAddressAllowed, referrerUrlAllowed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Preference {\n");
    sb.append("    isFbcAllowed: ").append(toIndentedString(fbcAllowed)).append("\n");
    sb.append("    isFbpAllowed: ").append(toIndentedString(fbpAllowed)).append("\n");
    sb.append("    isClientIpAddressAllowed: ").append(toIndentedString(clientIpAddressAllowed)).append("\n");
    sb.append("    isReferrerUrlAllowed: ").append(toIndentedString(referrerUrlAllowed)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first
   * line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
