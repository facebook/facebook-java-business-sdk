/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * <p>You are hereby granted a non-exclusive, worldwide, royalty-free license to use, copy, modify,
 * and distribute this software in source code or binary form for use in connection with the web
 * services and APIs provided by Facebook.
 *
 * <p>As with any software that integrates with the Facebook platform, your use of this software is
 * subject to the Facebook Developer Principles and Policies
 * [http://developers.facebook.com/policy/]. This copyright notice shall be included in all copies
 * or substantial portions of the software.
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.facebook.ads.sdk.serverside;

import com.facebook.ads.utils.Sha256GenderEnumAdaptor;
import com.facebook.ads.utils.Sha256StringAdaptor;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/**
 * UserData is a set of identifiers Facebook can use for targeted attribution.
 */
public class UserData {

  @SerializedName("em")
  @JsonAdapter(Sha256StringAdaptor.class)
  private String email = null;

  @SerializedName("ph")
  @JsonAdapter(Sha256StringAdaptor.class)
  private String phone = null;

  @SerializedName("ge")
  @JsonAdapter(Sha256GenderEnumAdaptor.class)
  private GenderEnum gender = null;

  @SerializedName("db")
  @JsonAdapter(Sha256StringAdaptor.class)
  private String dateOfBirth = null;

  @SerializedName("ln")
  @JsonAdapter(Sha256StringAdaptor.class)
  private String lastName = null;

  @SerializedName("fn")
  @JsonAdapter(Sha256StringAdaptor.class)
  private String firstName = null;

  @SerializedName("ct")
  @JsonAdapter(Sha256StringAdaptor.class)
  private String city = null;

  @SerializedName("st")
  @JsonAdapter(Sha256StringAdaptor.class)
  private String state = null;

  @SerializedName("zp")
  @JsonAdapter(Sha256StringAdaptor.class)
  private String zipcode = null;

  @SerializedName("country")
  @JsonAdapter(Sha256StringAdaptor.class)
  private String countryCode = null;

  @SerializedName("external_id")
  @JsonAdapter(Sha256StringAdaptor.class)
  private String externalId = null;

  @SerializedName("client_ip_address")
  private String clientIpAddress = null;

  @SerializedName("client_user_agent")
  private String clientUserAgent = null;

  @SerializedName("fbc")
  private String fbc = null;

  @SerializedName("fbp")
  private String fbp = null;

  @SerializedName("subscription_id")
  private String subscriptionId = null;

  /**
   * Set an email address, in lowercase.
   *
   * <p>Example: joe@eg.com
   *
   * @return UserData
   */
  public UserData email(String email) {
    this.email = email;
    return this;
  }

  /**
   * An email address, in lowercase.
   *
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set an email address, in lowercase.
   *
   * <p>Example: joe@eg.com
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Set a phone number. Include only digits with countryCode code, area code, and number.
   *
   * <p>Example: 16505551212
   *
   * @return UserData
   */
  public UserData phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * A phone number. Include only digits with countryCode code, area code, and number.
   *
   * @return phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Set a phone number. Include only digits with countryCode code, area code, and number.
   *
   * <p>Example: 16505551212
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Gender. Male or Female.
   *
   * @return UserData
   */
  public UserData gender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Gender, Male or Female.
   *
   * @return gender
   */
  public GenderEnum getGender() {
    return gender;
  }

  /** Gender, Male or Female. */
  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  /**
   * Set a date of birth given as year, month, and day.
   *
   * <p>Example: 19971226 for December 26, 1997.
   *
   * @return UserData
   */
  public UserData dateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Return a date of birth given as year, month, and day.
   *
   * @return dateOfBirth
   */
  public String getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * A date of birth given as year, month, and day.
   *
   * <p>Example: 19971226 for December 26, 1997.
   */
  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  /**
   * Set a last name in lowercase.
   *
   * <p>Example: smith
   *
   * @return UserData
   */
  public UserData ln(String ln) {
    this.lastName = ln;
    return this;
  }

  /**
   * A last name in lowercase.
   *
   * @return lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Set a last name in lowercase.
   *
   * <p>Example: smith
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Set a first name in lowercase.
   *
   * <p>Example: joe
   *
   * @return firstName
   */
  public UserData firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * A first name in lowercase.
   *
   * @return firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set a first name in lowercase.
   *
   * <p>Example: joe
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Set a city in lower-case without spaces or punctuation.
   *
   * <p>Example: menlopark
   *
   * @return UserData
   */
  public UserData city(String city) {
    this.city = city;
    return this;
  }

  /**
   * A city in lower-case without spaces or punctuation.
   *
   * @return city
   */
  public String getCity() {
    return city;
  }
  /**
   * Set a city in lower-case without spaces or punctuation.
   *
   * <p>Example: menlopark
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * Set a two-letter state code in lowercase.
   *
   * <p>Example: ca
   *
   * @return UserData
   */
  public UserData state(String state) {
    this.state = state;
    return this;
  }

  /**
   * A two-letter state code in lowercase.
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  /**
   * Set a two-letter state code in lowercase.
   *
   * <p>Example: ca
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * Set a five-digit zip code.
   *
   * <p>Example: 94035
   *
   * @return UserData
   */
  public UserData zipcode(String zipcode) {
    this.zipcode = zipcode;
    return this;
  }

  /**
   * A five-digit zip code.
   *
   * @return zipcode
   */
  public String getZipcode() {
    return zipcode;
  }

  /**
   * Set a five-digit zip code.
   *
   * <p>Example: 94035
   */
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  /**
   * Set a two-letter countryCode code in lowercase.
   *
   * <p>Example: us
   *
   * @return countryCode
   */
  public UserData country(String country) {
    this.countryCode = country;
    return this;
  }

  /**
   * A two-letter countryCode code in lowercase.
   *
   * <p>Example: us
   *
   * @return countryCode
   */
  public String getCountryCode() {
    return countryCode;
  }

  /**
   * Set a two-letter countryCode code in lowercase.
   *
   * <p>Example: us
   */
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  /**
   * Set any unique ID from the advertiser, such as loyalty membership IDs, user IDs, and external
   * cookie IDs. In the Offline Conversions API, this is known as extern_id. For more information,
   * see Offline Conversions, Providing External IDs. If External ID is being sent via other
   * channels, then it should be sent in the same format via the server-side API.
   *
   * @return UserData
   */
  public UserData externalId(String externalId) {
    this.externalId = externalId;
    return this;
  }

  /**
   * Any unique ID from the advertiser, such as loyalty membership IDs, user IDs, and external
   * cookie IDs. In the Offline Conversions API, this is known as extern_id. For more information,
   * see Offline Conversions, Providing External IDs. If External ID is being sent via other
   * channels, then it should be sent in the same format via the server-side API.
   *
   * @return externalId
   */
  public String getExternalId() {
    return externalId;
  }

  /**
   * Set any unique ID from the advertiser, such as loyalty membership IDs, user IDs, and external
   * cookie IDs. In the Offline Conversions API, this is known as extern_id. For more information,
   * see Offline Conversions, Providing External IDs. If External ID is being sent via other
   * channels, then it should be sent in the same format via the server-side API.
   */
  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  /**
   * Set IP address of the browser corresponding to the event.
   *
   * @return UserData
   */
  public UserData clientIpAddress(String clientIpAddress) {
    this.clientIpAddress = clientIpAddress;
    return this;
  }

  /**
   * The IP address of the browser corresponding to the event.
   *
   * @return clientIpAddress
   */
  public String getClientIpAddress() {
    return clientIpAddress;
  }

  /** Set IP address of the browser corresponding to the event. */
  public void setClientIpAddress(String clientIpAddress) {
    this.clientIpAddress = clientIpAddress;
  }

  /**
   * Set user agent for the browser corresponding to the event.
   *
   * @return UserData
   */
  public UserData clientUserAgent(String clientUserAgent) {
    this.clientUserAgent = clientUserAgent;
    return this;
  }

  /**
   * The user agent for the browser corresponding to the event.
   *
   * @return clientUserAgent
   */
  public String getClientUserAgent() {
    return clientUserAgent;
  }

  /** Set user agent for the browser corresponding to the event. */
  public void setClientUserAgent(String clientUserAgent) {
    this.clientUserAgent = clientUserAgent;
  }

  /**
   * Set Facebook click ID value stored in the _fbc browser cookie under your domain. See Managing
   * fbc and fbp Parameters for how to get this value
   * (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/parameters#fbc),
   * or generate this value from a fbclid query parameter.
   *
   * @return UserData
   */
  public UserData fbc(String fbc) {
    this.fbc = fbc;
    return this;
  }

  /**
   * The Facebook click ID value stored in the _fbc browser cookie under your domain. See Managing
   * fbc and fbp Parameters for how to get this value
   * (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/parameters#fbc),
   * or generate this value from a fbclid query parameter.
   *
   * @return fbc
   */
  public String getFbc() {
    return fbc;
  }

  /**
   * Set Facebook click ID value stored in the _fbc browser cookie under your domain. See Managing
   * fbc and fbp Parameters for how to get this value
   * (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/parameters#fbc),
   * or generate this value from a fbclid query parameter.
   */
  public void setFbc(String fbc) {
    this.fbc = fbc;
  }

  /**
   * Set Facebook browser ID value stored in the _fbp browser cookie under your domain. See Managing
   * fbc and fbp Parameters for how to get this value
   * (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/parameters#fbc),
   * or generate this value from a fbclid query parameter.
   *
   * @return UserData
   */
  public UserData fbp(String fbp) {
    this.fbp = fbp;
    return this;
  }

  /**
   * The Facebook browser ID value stored in the _fbp browser cookie under your domain. See Managing
   * fbc and fbp Parameters for how to get this value
   * (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/parameters#fbc),
   * or generate this value from a fbclid query parameter.
   *
   * @return fbp
   */
  public String getFbp() {
    return fbp;
  }

  /**
   * Set Facebook browser ID value stored in the _fbp browser cookie under your domain. See Managing
   * fbc and fbp Parameters for how to get this value
   * (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/parameters#fbc)
   */
  public void setFbp(String fbp) {
    this.fbp = fbp;
  }

  /**
   * Set subscription ID for the user in this transaction. This is similar to the order ID for an
   * individual product.
   *
   * @return UserData
   */
  public UserData subscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
    return this;
  }

  /**
   * The subscription ID for the user in this transaction. This is similar to the order ID for an
   * individual product.
   *
   * @return subscriptionId
   */
  public String getSubscriptionId() {
    return subscriptionId;
  }

  /**
   * Set subscription ID for the user in this transaction. This is similar to the order ID for an
   * individual product.
   */
  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserData userData = (UserData) o;
    return Objects.equals(this.email, userData.email)
        && Objects.equals(this.phone, userData.phone)
        && Objects.equals(this.gender, userData.gender)
        && Objects.equals(this.dateOfBirth, userData.dateOfBirth)
        && Objects.equals(this.lastName, userData.lastName)
        && Objects.equals(this.firstName, userData.firstName)
        && Objects.equals(this.city, userData.city)
        && Objects.equals(this.state, userData.state)
        && Objects.equals(this.zipcode, userData.zipcode)
        && Objects.equals(this.countryCode, userData.countryCode)
        && Objects.equals(this.externalId, userData.externalId)
        && Objects.equals(this.clientIpAddress, userData.clientIpAddress)
        && Objects.equals(this.clientUserAgent, userData.clientUserAgent)
        && Objects.equals(this.fbc, userData.fbc)
        && Objects.equals(this.fbp, userData.fbp)
        && Objects.equals(this.subscriptionId, userData.subscriptionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        email,
        phone,
        gender,
        dateOfBirth,
        lastName,
        firstName,
        city,
        state,
        zipcode,
        countryCode,
        externalId,
        clientIpAddress,
        clientUserAgent,
        fbc,
        fbp,
        subscriptionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserData {\n");

    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    zipcode: ").append(toIndentedString(zipcode)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    clientIpAddress: ").append(toIndentedString(clientIpAddress)).append("\n");
    sb.append("    clientUserAgent: ").append(toIndentedString(clientUserAgent)).append("\n");
    sb.append("    fbc: ").append(toIndentedString(fbc)).append("\n");
    sb.append("    fbp: ").append(toIndentedString(fbp)).append("\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
