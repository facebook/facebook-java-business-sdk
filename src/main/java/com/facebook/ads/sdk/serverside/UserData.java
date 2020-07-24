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

import com.facebook.ads.utils.ServerSideApiConstants;
import com.facebook.ads.utils.Sha256GenderEnumAdaptor;
import com.facebook.ads.utils.Sha256StringAdaptor;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/**
 * UserData is a set of identifiers Facebook can use for targeted attribution.
 */
public class UserData {

  @SerializedName(ServerSideApiConstants.EMAIL)
  @JsonAdapter(Sha256StringAdaptor.class)
  private String email = null;

  @SerializedName(ServerSideApiConstants.PHONE_NUMBER)
  @JsonAdapter(Sha256StringAdaptor.class)
  private String phone = null;

  @SerializedName(ServerSideApiConstants.GENDER)
  @JsonAdapter(Sha256GenderEnumAdaptor.class)
  private GenderEnum gender = null;

  @SerializedName(ServerSideApiConstants.DATE_OF_BIRTH)
  @JsonAdapter(Sha256StringAdaptor.class)
  private String dateOfBirth = null;

  @SerializedName(ServerSideApiConstants.LAST_NAME)
  @JsonAdapter(Sha256StringAdaptor.class)
  private String lastName = null;

  @SerializedName(ServerSideApiConstants.FIRST_NAME)
  @JsonAdapter(Sha256StringAdaptor.class)
  private String firstName = null;

  @SerializedName(ServerSideApiConstants.CITY)
  @JsonAdapter(Sha256StringAdaptor.class)
  private String city = null;

  @SerializedName(ServerSideApiConstants.STATE)
  @JsonAdapter(Sha256StringAdaptor.class)
  private String state = null;

  @SerializedName(ServerSideApiConstants.ZIP_CODE)
  @JsonAdapter(Sha256StringAdaptor.class)
  private String zipcode = null;

  @SerializedName(ServerSideApiConstants.COUNTRY)
  @JsonAdapter(Sha256StringAdaptor.class)
  private String countryCode = null;

  @SerializedName(ServerSideApiConstants.EXTERNAL_ID)
  @JsonAdapter(Sha256StringAdaptor.class)
  private String externalId = null;

  @SerializedName(ServerSideApiConstants.CLIENT_IP_ADDRESS)
  private String clientIpAddress = null;

  @SerializedName(ServerSideApiConstants.CLIENT_USER_AGENT)
  private String clientUserAgent = null;

  @SerializedName(ServerSideApiConstants.FBC)
  private String fbc = null;

  @SerializedName(ServerSideApiConstants.FBP)
  private String fbp = null;

  @SerializedName(ServerSideApiConstants.SUBSCRIPTION_ID)
  private String subscriptionId = null;

  @SerializedName(ServerSideApiConstants.FB_LOGIN_ID)
  private String fbLoginId = null;

  @SerializedName(ServerSideApiConstants.LEAD_ID)
  private String leadId = null;

  @SerializedName(ServerSideApiConstants.F5FIRST)
  @JsonAdapter(Sha256StringAdaptor.class)
  private String f5first = null;

  @SerializedName(ServerSideApiConstants.F5LAST)
  @JsonAdapter(Sha256StringAdaptor.class)
  private String f5last = null;

  @SerializedName(ServerSideApiConstants.FI)
  @JsonAdapter(Sha256StringAdaptor.class)
  private String fi = null;

  @SerializedName(ServerSideApiConstants.DOBD)
  @JsonAdapter(Sha256StringAdaptor.class)
  private String dobd = null;

  @SerializedName(ServerSideApiConstants.DOBM)
  @JsonAdapter(Sha256StringAdaptor.class)
  private String dobm = null;

  @SerializedName(ServerSideApiConstants.DOBY)
  @JsonAdapter(Sha256StringAdaptor.class)
  private String doby = null;

  /**
   * Default Constructor.
   */
  public UserData() {
  }

  /**
   * @param email an email address
   * @param phone a phone number
   * @param gender gender
   * @param dateOfBirth date of birth
   * @param lastName last name
   * @param firstName first name
   * @param city city
   * @param state state
   * @param zipcode zip code
   * @param countryCode country code
   * @param externalId any unique ID from the advertiser, such as loyalty membership IDs,
   * user IDs, and external cookie IDs.
   * @param clientIpAddress IP address of the browser corresponding to the event
   * @param clientUserAgent user agent for the browser corresponding to the event
   * @param fbc Facebook click ID value stored in the _fbc browser cookie under your domain
   * @param fbp Facebook browser ID value stored in the _fbp browser cookie under your domain
   * @param subscriptionId subscription ID for the user in this transaction
   * @param fbLoginId ID issued when a person first logs into an instance of the app,
   * also known as App-Scoped Id
   * @param leadId ID associated with a lead generated by Facebook's Lead Ads.
   * @param f5first First 5 letters of the first name
   * @param f5last First 5 letters of the last name
   * @param fi First initial
   * @param dobd Date of birth day
   * @param dobm Date of birth month
   * @param doby Date of birth year
   */
  public UserData(String email, String phone, GenderEnum gender, String dateOfBirth,
      String lastName, String firstName, String city, String state, String zipcode,
      String countryCode, String externalId, String clientIpAddress, String clientUserAgent,
      String fbc, String fbp, String subscriptionId, String fbLoginId, String leadId,
      String f5first, String f5last, String fi, String dobd, String dobm, String doby) {
    this.email = email;
    this.phone = phone;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.lastName = lastName;
    this.firstName = firstName;
    this.city = city;
    this.state = state;
    this.zipcode = zipcode;
    this.countryCode = countryCode;
    this.externalId = externalId;
    this.clientIpAddress = clientIpAddress;
    this.clientUserAgent = clientUserAgent;
    this.fbc = fbc;
    this.fbp = fbp;
    this.subscriptionId = subscriptionId;
    this.fbLoginId = fbLoginId;
    this.leadId = leadId;
    this.f5first = f5first;
    this.f5last = f5last;
    this.fi = fi;
    this.dobd = dobd;
    this.dobm = dobm;
    this.doby = doby;
  }

  /**
   * Set an email address, in lowercase.
   *
   * <p>Example: joe@eg.com
   *
   * @param email an email address
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
   *
   * @param email an email address
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Set a phone number. Include only digits with countryCode code, area code, and number.
   *
   * <p>Example: 16505551212
   *
   * @param phone a phone number
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
   *
   * @param phone a phone number
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Gender. Male or Female.
   *
   * @param gender Male or Female.
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

  /**
   * Gender, Male or Female.
   *
   * @param gender Male or Female.
   */
  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  /**
   * Set a date of birth given as year, month, and day.
   *
   * <p>Example: 19971226 for December 26, 1997.
   *
   * @param dateOfBirth a date of birth given as year, month, and day.
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
   *
   * @param dateOfBirth a date of birth given as year, month, and day.
   */
  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  /**
   * Set a last name in lowercase.
   *
   * <p>Example: smith
   *
   * @param lastName last name
   * @return UserData
   */
  public UserData lastName(String lastName) {
    this.lastName = lastName;
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
   *
   * @param lastName last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Set a first name in lowercase.
   *
   * <p>Example: joe
   *
   * @param firstName first name
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
   *
   * @param firstName first name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Set a city in lower-case without spaces or punctuation.
   *
   * <p>Example: menlopark
   *
   * @param city city
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
   *
   * @param city city
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * Set a two-letter state code in lowercase.
   *
   * <p>Example: ca
   *
   * @param state two-letter state code
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
   *
   * @param state two-letter state code
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * Set a five-digit zip code.
   *
   * <p>Example: 94035
   *
   * @param zipcode five-digit zip code
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
   *
   * @param zipcode five-digit zip code
   */
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  /**
   * Set a two-letter country code in lowercase.
   *
   * <p>Example: us
   *
   * @param countryCode two-letter country code
   * @return UserData
   */
  public UserData countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * A two-letter country code in lowercase.
   *
   * <p>Example: us
   *
   * @return countryCode
   */
  public String getCountryCode() {
    return countryCode;
  }

  /**
   * Set a two-letter country code in lowercase.
   *
   * <p>Example: us
   *
   * @param countryCode two-letter country code
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
   * @param externalId unique ID from the advertiser
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
   *
   * @param externalId unique ID from the advertiser
   */
  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  /**
   * Set IP address of the browser corresponding to the event.
   *
   * @param clientIpAddress IP address of the browser corresponding to the event
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

  /**
   * Set IP address of the browser corresponding to the event.
   *
   * @param clientIpAddress IP address of the browser corresponding to the event
   */
  public void setClientIpAddress(String clientIpAddress) {
    this.clientIpAddress = clientIpAddress;
  }

  /**
   * Set user agent for the browser corresponding to the event.
   *
   * @param clientUserAgent user agent for the browser corresponding to the event
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

  /**
   * Set user agent for the browser corresponding to the event.
   *
   * @param clientUserAgent user agent for the browser corresponding to the event
   */
  public void setClientUserAgent(String clientUserAgent) {
    this.clientUserAgent = clientUserAgent;
  }

  /**
   * Set Facebook click ID value stored in the _fbc browser cookie under your domain. See Managing
   * fbc and fbp Parameters for how to get this value (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/parameters#fbc),
   * or generate this value from a fbclid query parameter.
   *
   * @param fbc Facebook click ID
   * @return UserData
   */
  public UserData fbc(String fbc) {
    this.fbc = fbc;
    return this;
  }

  /**
   * The Facebook click ID value stored in the _fbc browser cookie under your domain. See Managing
   * fbc and fbp Parameters for how to get this value (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/parameters#fbc),
   * or generate this value from a fbclid query parameter.
   *
   * @return fbc
   */
  public String getFbc() {
    return fbc;
  }

  /**
   * Set Facebook click ID value stored in the _fbc browser cookie under your domain. See Managing
   * fbc and fbp Parameters for how to get this value (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/parameters#fbc),
   * or generate this value from a fbclid query parameter.
   *
   * @param fbc Facebook click ID
   */
  public void setFbc(String fbc) {
    this.fbc = fbc;
  }

  /**
   * Set Facebook browser ID value stored in the _fbp browser cookie under your domain. See Managing
   * fbc and fbp Parameters for how to get this value (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/parameters#fbc),
   * or generate this value from a fbclid query parameter.
   *
   * @param fbp Facebook browser ID
   * @return UserData
   */
  public UserData fbp(String fbp) {
    this.fbp = fbp;
    return this;
  }

  /**
   * The Facebook browser ID value stored in the _fbp browser cookie under your domain. See Managing
   * fbc and fbp Parameters for how to get this value (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/parameters#fbc),
   * or generate this value from a fbclid query parameter.
   *
   * @return fbp
   */
  public String getFbp() {
    return fbp;
  }

  /**
   * Set Facebook browser ID value stored in the _fbp browser cookie under your domain. See Managing
   * fbc and fbp Parameters for how to get this value (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/parameters#fbc)
   *
   * @param fbp Facebook browser ID
   */
  public void setFbp(String fbp) {
    this.fbp = fbp;
  }

  /**
   * Set subscription ID for the user in this transaction. This is similar to the order ID for an
   * individual product.
   *
   * @param subscriptionId subscription ID for the user in this transaction
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
   *
   * @param subscriptionId subscription ID for the user in this transaction
   */
  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  /**
   * Set Facebook Login ID for the user in this event.
   *
   * @param fbLoginId Facebook Login ID for the user in this event
   * @return UserData
   */
  public UserData fbLoginId(String fbLoginId) {
    this.fbLoginId = fbLoginId;
    return this;
  }

  /**
   * The Facebook Login ID for the user in this event.
   *
   * @return fbLoginId
   */
  public String getFbLoginId() {
    return fbLoginId;
  }

  /**
   * Set Facebook Login ID for the user in this event
   *
   * @param fbLoginId Facebook Login ID for the user in this event
   */
  public void setFbLoginId(String fbLoginId) {
    this.fbLoginId = fbLoginId;
  }

  /**
   * Set LeadId for the event.
   *
   * @param leadId is the ID associated with a lead generated by Facebook's Lead Ads.
   * @return UserData
   */
  public UserData leadId(String leadId) {
    this.leadId = leadId;
    return this;
  }

  /**
   * The LeadId for the event.
   *
   * @return leadId
   */
  public String getLeadId() {
    return leadId;
  }

  /**
   * Set LeadId for the event.
   *
   * @param leadId is the ID associated with a lead generated by Facebook's Lead Ads.
   */
  public void setLeadId(String leadId) {
      this.leadId = leadId;
  }

  /**
   * Set f5first for the event.
   *
   * @param f5first is the first 5 letters of the first name.
   * @return UserData
   */
  public UserData f5first(String f5first) {
    this.f5first = f5first;
    return this;
  }

  /**
   * The f5first for the event.
   *
   * @return f5first
   */
  public String getF5first() {
    return f5first;
  }

  /**
   * Set f5first for the event.
   *
   * @param f5first is the first 5 letters of the first name.
   */
  public void setF5first(String f5first) {
    this.f5first = f5first;
  }

  /**
   * Set f5last for the event.
   *
   * @param f5last is the first 5 letters of the last name.
   * @return UserData
   */
  public UserData f5last(String f5last) {
    this.f5last = f5last;
    return this;
  }

  /**
   * The f5last for the event.
   *
   * @return f5last
   */
  public String getF5last() {
    return f5last;
  }

  /**
   * Set f5last for the event.
   *
   * @param f5last is the first 5 letters of the last name.
   */
  public void setF5last(String f5last) {
    this.f5last = f5last;
  }

  /**
   * Set fi for the event.
   *
   * @param fi is the first initial.
   * @return UserData
   */
  public UserData fi(String fi) {
    this.fi = fi;
    return this;
  }

  /**
   * The fi for the event.
   *
   * @return fi
   */
  public String getFi() {
    return fi;
  }

  /**
   * Set fi for the event.
   *
   * @param fi is the first initial.
   */
  public void setFi(String fi) {
    this.fi = fi;
  }

  /**
   * Set dobd for the event.
   *
   * @param dobd is the date of birth day for the event.
   * @return UserData
   */
  public UserData dobd(String dobd) {
    this.dobd = dobd;
    return this;
  }

  /**
   * The dobd for the event.
   *
   * @return dobd
   */
  public String getDobd() {
    return dobd;
  }

  /**
   * Set dobd for the event.
   *
   * @param dobd is the date of birth day for the event.
   */
  public void setDobd(String dobd) {
    this.dobd = dobd;
  }

  /**
   * Set dobm for the event.
   *
   * @param dobm is the date of birth month for the event.
   * @return UserData
   */
  public UserData dobm(String dobm) {
    this.dobm = dobm;
    return this;
  }

  /**
   * The dobm for the event.
   *
   * @return dobm
   */
  public String getDobm() {
    return dobm;
  }

  /**
   * Set dobm for the event.
   *
   * @param dobm is the date of birth month for the event.
   */
  public void setDobm(String dobm) {
    this.dobm = dobm;
  }

  /**
   * Set doby for the event.
   *
   * @param doby is the date of birth year for the event.
   * @return UserData
   */
  public UserData doby(String doby) {
    this.doby = doby;
    return this;
  }

  /**
   * The doby for the event.
   *
   * @return doby
   */
  public String getDoby() {
    return doby;
  }

  /**
   * Set doby for the event.
   *
   * @param doby is the date of birth year for the event.
   */
  public void setDoby(String doby) {
    this.doby = doby;
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
        && Objects.equals(this.subscriptionId, userData.subscriptionId)
        && Objects.equals(this.fbLoginId, userData.fbLoginId)
        && Objects.equals(this.leadId, userData.leadId)
        && Objects.equals(this.f5first, userData.f5first)
        && Objects.equals(this.f5last, userData.f5last)
        && Objects.equals(this.fi, userData.fi)
        && Objects.equals(this.dobd, userData.dobd)
        && Objects.equals(this.dobm, userData.dobm)
        && Objects.equals(this.doby, userData.doby);
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
        subscriptionId,
        fbLoginId,
        leadId,
        f5first,
        f5last,
        fi,
        dobd,
        dobm,
        doby);
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
    sb.append("    fbLoginId: ").append(toIndentedString(fbLoginId)).append("\n");
    sb.append("    leadId: ").append(toIndentedString(leadId)).append("\n");
    sb.append("    f5first: ").append(toIndentedString(f5first)).append("\n");
    sb.append("    f5last: ").append(toIndentedString(f5last)).append("\n");
    sb.append("    fi: ").append(toIndentedString(fi)).append("\n");
    sb.append("    dobd: ").append(toIndentedString(dobd)).append("\n");
    sb.append("    dobm: ").append(toIndentedString(dobm)).append("\n");
    sb.append("    doby: ").append(toIndentedString(doby)).append("\n");
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
