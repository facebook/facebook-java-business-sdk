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
import com.facebook.ads.sdk.serverside.utils.Sha256GenderEnumListAdaptor;
import com.facebook.ads.sdk.serverside.utils.Sha256StringAdaptor;
import com.facebook.ads.sdk.serverside.utils.Sha256StringListAdaptor;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * UserData is a set of identifiers Facebook can use for targeted attribution.
 */
public class UserData {

  @SerializedName(ServerSideApiConstants.EMAIL)
  @JsonAdapter(Sha256StringListAdaptor.class)
  private List<String> emails = null;

  @SerializedName(ServerSideApiConstants.PHONE_NUMBER)
  @JsonAdapter(Sha256StringListAdaptor.class)
  private List<String> phones = null;

  @SerializedName(ServerSideApiConstants.GENDER)
  @JsonAdapter(Sha256GenderEnumListAdaptor.class)
  private List<GenderEnum> genders = null;

  @SerializedName(ServerSideApiConstants.DATE_OF_BIRTH)
  @JsonAdapter(Sha256StringListAdaptor.class)
  private List<String> datesOfBirth = null;

  @SerializedName(ServerSideApiConstants.LAST_NAME)
  @JsonAdapter(Sha256StringListAdaptor.class)
  private List<String> lastNames = null;

  @SerializedName(ServerSideApiConstants.FIRST_NAME)
  @JsonAdapter(Sha256StringListAdaptor.class)
  private List<String> firstNames = null;

  @SerializedName(ServerSideApiConstants.CITY)
  @JsonAdapter(Sha256StringListAdaptor.class)
  private List<String> cities = null;

  @SerializedName(ServerSideApiConstants.STATE)
  @JsonAdapter(Sha256StringListAdaptor.class)
  private List<String> states = null;

  @SerializedName(ServerSideApiConstants.ZIP_CODE)
  @JsonAdapter(Sha256StringListAdaptor.class)
  private List<String> zipcodes = null;

  @SerializedName(ServerSideApiConstants.COUNTRY)
  @JsonAdapter(Sha256StringListAdaptor.class)
  private List<String> countryCodes = null;

  @SerializedName(ServerSideApiConstants.EXTERNAL_ID)
  private List<String> externalIds = null;

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

  @SerializedName(ServerSideApiConstants.MOBILE_ADVERTISER_ID)
  private String madid = null;

  @SerializedName(ServerSideApiConstants.ANONYMOUS_ID)
  private String anonId = null;

  @SerializedName(ServerSideApiConstants.CTWA_CLID)
  private String ctwaClid = null;

  @SerializedName(ServerSideApiConstants.PAGE_ID)
  private String pageId = null;

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
   * @param madid Mobile Advertiser ID
   * @param anonId ID of a person who has installed the app anonymously
   * @param ctwaClid ID of a conversation that was started on WhatsApp
   * @param pageId ID of the page that the ad is associated with
   */
  public UserData(String email, String phone, GenderEnum gender, String dateOfBirth,
      String lastName, String firstName, String city, String state, String zipcode,
      String countryCode, String externalId, String clientIpAddress, String clientUserAgent,
      String fbc, String fbp, String subscriptionId, String fbLoginId, String leadId,
      String f5first, String f5last, String fi, String dobd, String dobm, String doby, String madid, String anonId, String ctwaClid, String pageId) {
    this.emails = Arrays.asList(email);
    this.phones = Arrays.asList(phone);
    this.genders = Arrays.asList(gender);
    this.datesOfBirth = Arrays.asList(dateOfBirth);
    this.lastNames = Arrays.asList(lastName);
    this.firstNames = Arrays.asList(firstName);
    this.cities = Arrays.asList(city);
    this.states = Arrays.asList(state);
    this.zipcodes = Arrays.asList(zipcode);
    this.countryCodes = Arrays.asList(countryCode);
    this.externalIds = Arrays.asList(externalId);
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
    this.madid = madid;
    this.anonId = anonId;
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
    this.emails = Arrays.asList(email);
    return this;
  }

  /**
   * An email address, in lowercase.
   * Returns the 1st value if there are multiple.
   *
   * @return email
   */
  public String getEmail() {
    return isListNullOrEmpty(this.emails) ? null : this.emails.get(0);
  }

  /**
   * Set an email address, in lowercase.
   *
   * <p>Example: joe@eg.com
   *
   * @param email an email address
   */
  public void setEmail(String email) {
    this.emails = Arrays.asList(email);
  }


  /**
   * Set multiple email addresses, in lowercase.
   *
   * <p>Example: ["joe@eg.com","smith@test.com"]
   *
   * @param emails email addresses
   * @return UserData
   */
  public UserData emails(List<String> emails) {
    this.emails = emails;
    return this;
  }

  /**
   * Email addresses, in lowercase.
   *
   * @return emails
   */
  public List<String> getEmails() {
    return this.emails;
  }

  /**
   * Set email addresses, in lowercase.
   *
   * <p>Example: ["joe@eg.com","smith@test.com"]
   *
   * @param emails email addresses
   */
  public void setEmails(List<String> emails) {
    this.emails = emails;
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
    this.phones = Arrays.asList(phone);
    return this;
  }

  /**
   * A phone number. Include only digits with countryCode code, area code, and number.
   * Returns the 1st value if there are multiple.
   *
   * @return phone
   */
  public String getPhone() {
    return isListNullOrEmpty(this.phones) ? null : this.phones.get(0);
  }

  /**
   * Set a phone number. Include only digits with countryCode code, area code, and number.
   *
   * <p>Example: 16505551212
   *
   * @param phone a phone number
   */
  public void setPhone(String phone) {
    this.phones = Arrays.asList(phone);
  }

  /**
   * Set a phone number. Include only digits with countryCode code, area code, and number.
   *
   * <p>Example: ["16505551212", "2062072008"]
   *
   * @param phones array of phone number
   * @return UserData
   */
  public UserData phones(List<String> phones) {
    this.phones = phones;
    return this;
  }

  /**
   * Phone numbers. Include only digits with countryCode code, area code, and number.
   *
   * @return phone
   */
  public List<String> getPhones() {
    return this.phones;
  }

  /**
   * Set phone numbers. Include only digits with countryCode code, area code, and number.
   *
   * <p>Example: ["16505551212", "12062072008"]
   *
   * @param phones a phone number
   */
  public void setPhones(List<String> phones) {
    this.phones = phones;
  }

  /**
   * Gender. Male or Female.
   *
   * @param gender Male or Female.
   * @return UserData
   */
  public UserData gender(GenderEnum gender) {
    this.genders = Arrays.asList(gender);
    return this;
  }

  /**
   * Gender, Male or Female.
   * Returns the 1st value if there are multiple.
   *
   * @return gender
   */
  public GenderEnum getGender() {
    return isListNullOrEmpty(this.genders) ? null : this.genders.get(0);
  }

  /**
   * Gender, Male or Female.
   *
   * @param gender Male or Female.
   */
  public void setGender(GenderEnum gender) {
    this.genders = Arrays.asList(gender);
  }

  /**
   * Gender. Male or Female.
   *
   * @param genders Male or Female.
   * @return UserData
   */
  public UserData genders(List<GenderEnum> genders) {
    this.genders = genders;
    return this;
  }

  /**
   * Gender, Male or Female.
   *
   * @return gender
   */
  public List<GenderEnum> getGenders() {
    return this.genders;
  }

  /**
   * Gender, Male or Female.
   *
   * @param genders Male or Female.
   */
  public void setGenders(List<GenderEnum> genders) {
    this.genders = genders;
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
    this.datesOfBirth = Arrays.asList(dateOfBirth);
    return this;
  }

  /**
   * Return a date of birth given as year, month, and day.
   * Returns the 1st value if there are multiple.
   *
   * @return dateOfBirth
   */
  public String getDateOfBirth() {
    return isListNullOrEmpty(this.datesOfBirth) ? null : this.datesOfBirth.get(0);
  }

  /**
   * A date of birth given as year, month, and day.
   *
   * <p>Example: 19971226 for December 26, 1997.
   *
   * @param dateOfBirth a date of birth given as year, month, and day.
   */
  public void setDateOfBirth(String dateOfBirth) {
    this.datesOfBirth = Arrays.asList(dateOfBirth);
  }

  /**
   * Set dates of birth given as year, month, and day.
   *
   * <p>Example: 19971226 for December 26, 1997.
   *
   * @param datesOfBirth an array of dates of birth given as year, month, and day.
   * @return UserData
   */
  public UserData datesOfBirth(List<String> datesOfBirth) {
    this.datesOfBirth = datesOfBirth;
    return this;
  }

  /**
   * Return dates of birth given as year, month, and day.
   *
   * @return datesOfBirth
   */
  public List<String> getDatesOfBirth() {
    return this.datesOfBirth;
  }

  /**
   * Dates of birth given as year, month, and day.
   *
   * <p>Example: 19971226 for December 26, 1997.
   *
   * @param datesOfBirth dates of birth given as year, month, and day.
   */
  public void setDatesOfBirth(List<String> datesOfBirth) {
    this.datesOfBirth = datesOfBirth;
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
    this.lastNames = Arrays.asList(lastName);
    return this;
  }

  /**
   * A last name in lowercase.
   * Returns the 1st value if there are multiple.
   *
   * @return lastName
   */
  public String getLastName() {
    return isListNullOrEmpty(this.lastNames) ? null : this.lastNames.get(0);
  }

  /**
   * Set a last name in lowercase.
   *
   * <p>Example: smith
   *
   * @param lastName last name
   */
  public void setLastName(String lastName) {
    this.lastNames = Arrays.asList(lastName);
  }

  /**
   * Set last names in lowercase.
   *
   * <p>Example: {"smith", "williams"}
   *
   * @param lastNames last names
   * @return UserData
   */
  public UserData lastNames(List<String> lastNames) {
    this.lastNames = lastNames;
    return this;
  }

  /**
   * Last names in lowercase.
   *
   * @return lastNames
   */
  public List<String> getLastNames() {
    return this.lastNames;
  }

  /**
   * Set last names in lowercase.
   *
   * <p>Example: ["smith", "williams"]
   *
   * @param lastNames last names
   */
  public void setLastNames(List<String> lastNames) {
    this.lastNames = lastNames;
  }

  /**
   * Set a first name in lowercase.
   *
   * <p>Example: joe
   *
   * @param firstName first name
   * @return UserData
   */
  public UserData firstName(String firstName) {
    this.firstNames = Arrays.asList(firstName);
    return this;
  }

  /**
   * A first name in lowercase.
   * Returns the 1st value if there are multiple.
   *
   * @return firstName
   */
  public String getFirstName() {
    return isListNullOrEmpty(this.firstNames) ? null : this.firstNames.get(0);
  }

  /**
   * Set a first name in lowercase.
   *
   * <p>Example: joe
   *
   * @param firstName first name
   */
  public void setFirstName(String firstName) {
    this.firstNames = Arrays.asList(firstName);
  }

  /**
   * Set first names in lowercase.
   *
   * <p>Example: {"joe", "john"}
   *
   * @param firstNames first names
   * @return UserData
   */
  public UserData firstNames(List<String> firstNames) {
    this.firstNames = firstNames;
    return this;
  }

  /**
   * First names in lowercase.
   *
   * @return firstName
   */
  public List<String> getFirstNames() {
    return this.firstNames;
  }

  /**
   * Set first names in lowercase.
   *
   * <p>Example: ["joe", "john"]
   *
   * @param firstNames first names
   */
  public void setFirstNames(List<String> firstNames) {
    this.firstNames = firstNames;
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
    this.cities = Arrays.asList(city);
    return this;
  }

  /**
   * A city in lower-case without spaces or punctuation.
   * Returns the 1st value if there are multiple.
   *
   * @return city
   */
  public String getCity() {
    return isListNullOrEmpty(this.cities) ? null : this.cities.get(0);
  }

  /**
   * Set a city in lower-case without spaces or punctuation.
   *
   * <p>Example: menlopark
   *
   * @param city city
   */
  public void setCity(String city) {
    this.cities = Arrays.asList(city);
  }

  /**
   * Set cities in lower-case without spaces or punctuation.
   *
   * <p>Example: {"menlopark", "seattle"}
   *
   * @param cities cities
   * @return UserData
   */
  public UserData cities(List<String> cities) {
    this.cities = cities;
    return this;
  }

  /**
   * Cities in lower-case without spaces or punctuation.
   *
   * @return cities
   */
  public List<String> getCities() {
    return this.cities;
  }

  /**
   * Set cities in lower-case without spaces or punctuation.
   *
   * <p>Example: ["menlopark", "seattle"]
   *
   * @param cities cities
   */
  public void setCities(List<String> cities) {
    this.cities = cities;
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
    this.states = Arrays.asList(state);
    return this;
  }

  /**
   * A two-letter state code in lowercase.
   * Returns the 1st value if there are multiple.
   *
   * @return state
   */
  public String getState() {
    return isListNullOrEmpty(this.states) ? null : this.states.get(0);
  }

  /**
   * Set a two-letter state code in lowercase.
   *
   * <p>Example: ca
   *
   * @param state two-letter state code
   */
  public void setState(String state) {
    this.states = Arrays.asList(state);
  }

  /**
   * Set two-letter state codes in lowercase.
   *
   * <p>Example: ["ca", "wa"]
   *
   * @param states two-letter state codes
   * @return UserData
   */
  public UserData states(List<String> states) {
    this.states = states;
    return this;
  }

  /**
   * Two-letter state codes in lowercase.
   *
   * @return states
   */
  public List<String> getStates() {
    return this.states;
  }

  /**
   * Set a two-letter state codes in lowercase.
   *
   * <p>Example: ["ca", "wa"]
   *
   * @param states two-letter state codes
   */
  public void setStates(List<String> states) {
    this.states = states;
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
    this.zipcodes = Arrays.asList(zipcode);
    return this;
  }

  /**
   * A five-digit zip code.
   * Returns the 1st value if there are multiple.
   *
   * @return zipcode
   */
  public String getZipcode() {
    return isListNullOrEmpty(this.zipcodes) ? null : this.zipcodes.get(0);
  }

  /**
   * Set a five-digit zip code.
   *
   * <p>Example: 94035
   *
   * @param zipcode five-digit zip code
   */
  public void setZipcode(String zipcode) {
    this.zipcodes = Arrays.asList(zipcode);
  }

  /**
   * Set five-digit zip codes.
   *
   * <p>Example: ["94035", "98101"]
   *
   * @param zipcodes five-digit zip codes
   * @return UserData
   */
  public UserData zipcodes(List<String> zipcodes) {
    this.zipcodes = zipcodes;
    return this;
  }

  /**
   * A five-digit zip codes.
   *
   * @return zipcodes
   */
  public List<String> getZipcodes() {
    return this.zipcodes;
  }

  /**
   * Set five-digit zip codes.
   *
   * <p>Example: ["94035", "98101"]
   *
   * @param zipcodes five-digit zip codes
   */
  public void setZipcodes(List<String> zipcodes) {
    this.zipcodes = zipcodes;
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
    this.countryCodes = Arrays.asList(countryCode);
    return this;
  }

  /**
   * A two-letter country code in lowercase.
   * Returns the 1st value if there are multiple.
   *
   * <p>Example: us
   *
   * @return countryCode
   */
  public String getCountryCode() {
    return isListNullOrEmpty(this.countryCodes) ? null : this.countryCodes.get(0);
  }

  /**
   * Set a two-letter country code in lowercase.
   *
   * <p>Example: us
   *
   * @param countryCode two-letter country code
   */
  public void setCountryCode(String countryCode) {
    this.countryCodes = Arrays.asList(countryCode);
  }

  /**
   * Set two-letter country codes in lowercase.
   *
   * <p>Example: ["us", "ca"]
   *
   * @param countryCodes two-letter country codes
   * @return UserData
   */
  public UserData countryCodes(List<String> countryCodes) {
    this.countryCodes = countryCodes;
    return this;
  }

  /**
   * Two-letter country codes in lowercase.
   *
   * <p>Example: ["us", "ca"]
   *
   * @return countryCodes
   */
  public List<String> getCountryCodes() {
    return this.countryCodes;
  }

  /**
   * Set two-letter country codes in lowercase.
   *
   * <p>Example: ["us", "ca"]
   *
   * @param countryCodes two-letter country codes
   */
  public void setCountryCodes(List<String> countryCodes) {
    this.countryCodes = countryCodes;
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
    this.externalIds = Arrays.asList(externalId);
    return this;
  }

  /**
   * Any unique ID from the advertiser, such as loyalty membership IDs, user IDs, and external
   * cookie IDs. In the Offline Conversions API, this is known as extern_id. For more information,
   * see Offline Conversions, Providing External IDs. If External ID is being sent via other
   * channels, then it should be sent in the same format via the server-side API.
   * Returns the 1st value if there are multiple.
   *
   * @return externalId
   */
  public String getExternalId() {
    return isListNullOrEmpty(this.externalIds) ? null : this.externalIds.get(0);
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
    this.externalIds = Arrays.asList(externalId);
  }

  /**
   * Set any unique IDs from the advertiser, such as loyalty membership IDs, user IDs, and external
   * cookie IDs. In the Offline Conversions API, this is known as extern_id. For more information,
   * see Offline Conversions, Providing External IDs. If External ID is being sent via other
   * channels, then it should be sent in the same format via the server-side API.
   *
   * @param externalIds unique IDs from the advertiser
   * @return UserData
   */
  public UserData externalIds(List<String> externalIds) {
    this.externalIds = dedup(externalIds);
    return this;
  }

  /**
   * Any unique ID from the advertiser, such as loyalty membership IDs, user IDs, and external
   * cookie IDs. In the Offline Conversions API, this is known as extern_id. For more information,
   * see Offline Conversions, Providing External IDs. If External ID is being sent via other
   * channels, then it should be sent in the same format via the server-side API.
   *
   * @return externalIds
   */
  public List<String> getExternalIds() {
    return this.externalIds;
  }

  /**
   * Set any unique ID from the advertiser, such as loyalty membership IDs, user IDs, and external
   * cookie IDs. In the Offline Conversions API, this is known as extern_id. For more information,
   * see Offline Conversions, Providing External IDs. If External ID is being sent via other
   * channels, then it should be sent in the same format via the server-side API.
   *
   * @param externalIds unique IDs from the advertiser
   */
  public void setExternalIds(List<String> externalIds) {
    this.externalIds = dedup(externalIds);
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

  /**
   * Set the mobile advertiser id which is either Apple's Advertising Identifier (IDFA) or
   * Google Android's advertising ID
   *
   * @param madid is the mobile advertiser id
   * @return UserData
   */
  public UserData madid(String madid) {
    setMadid(madid);
    return this;
  }

  /**
   * The mobile advertiser id
   *
   * @return madid
   */
  public String getMadid() {
      return this.madid;
  }

  /**
   * Set the mobile advertiser id which is either Apple's Advertising Identifier (IDFA) or
   * Google Android's advertising ID
   *
   * @param madid is the mobile advertiser id
   */
  public void setMadid(String madid) {
      this.madid = madid;
  }

  /**
   * Set the ID of a person who has installed the app anonymously
   *
   * @param anonId the anonymous id
   * @return UserData
   */
  public UserData anonId(String anonId) {
    setAnonId(anonId);
    return this;
  }

  /**
   * ID of the person who has installed the app anonymously
   *
   * @return anonId
   */
  public String getAnonId() {
    return this.anonId;
  }

  /**
   * Set the ID of a person who has installed the app anonymously
   *
   * @param anonId the anonymous Id
   */
  public void setAnonId(String anonId) {
    this.anonId = anonId;
  }

  /**
   * Get the ctwaClid of the conversation that was started on WhatsApp
   *
   * @param ctwaClid the anonymous id
   * @return UserData
   */
  public UserData ctwaClid(String ctwaClid) {
    setCtwaClid(ctwaClid);
    return this;
  }

  /**
   * ctwaClid of the conversation that was started on WhatsApp
   *
   * @return ctwaClid
   */
  public String getCtwaClid() {
    return this.ctwaClid;
  }

  /**
   * Set the ctwaClid of the conversation that was started on WhatsApp
   *
   * @param ctwaClid the anonymous Id
   */
  public void setCtwaClid(String ctwaClid) {
    this.ctwaClid = ctwaClid;
  }

  /**
   * Get the ID of the page that the ad is associated with
   *
   * @param pageId
   * @return UserData
   */
  public UserData pageId(String pageId) {
    setPageId(pageId);
    return this;
  }

  /**
   * ID of the page that the ad is associated with
   *
   * @return pageId
   */
  public String getPageId() {
    return this.pageId;
  }

  /**
   * Set the ID of the page that the ad is associated with
   *
   * @param pageId
   */
  public void setPageId(String pageId) {
    this.pageId = pageId;
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
    return Objects.equals(this.emails, userData.emails)
        && Objects.equals(this.phones, userData.phones)
        && Objects.equals(this.genders, userData.genders)
        && Objects.equals(this.datesOfBirth, userData.datesOfBirth)
        && Objects.equals(this.lastNames, userData.lastNames)
        && Objects.equals(this.firstNames, userData.firstNames)
        && Objects.equals(this.cities, userData.cities)
        && Objects.equals(this.states, userData.states)
        && Objects.equals(this.zipcodes, userData.zipcodes)
        && Objects.equals(this.countryCodes, userData.countryCodes)
        && Objects.equals(this.externalIds, userData.externalIds)
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
        && Objects.equals(this.doby, userData.doby)
        && Objects.equals(this.madid, userData.madid)
        && Objects.equals(this.anonId, userData.anonId)
        && Objects.equals(this.ctwaClid, userData.ctwaClid)
        && Objects.equals(this.pageId, userData.pageId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        emails,
        phones,
        genders,
        datesOfBirth,
        lastNames,
        firstNames,
        cities,
        states,
        zipcodes,
        countryCodes,
        externalIds,
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
        doby,
        madid,
        anonId,
        ctwaClid,
        pageId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserData {\n");

    sb.append("    email: ").append(toIndentedString(emails)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phones)).append("\n");
    sb.append("    gender: ").append(toIndentedString(genders)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(datesOfBirth)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastNames)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstNames)).append("\n");
    sb.append("    city: ").append(toIndentedString(cities)).append("\n");
    sb.append("    state: ").append(toIndentedString(states)).append("\n");
    sb.append("    zipcode: ").append(toIndentedString(zipcodes)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCodes)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalIds)).append("\n");
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
    sb.append("    madid: ").append(toIndentedString(madid)).append("\n");
    sb.append("    anonId: ").append(toIndentedString(anonId)).append("\n");
    sb.append("    ctwaClid: ").append(toIndentedString(ctwaClid)).append("\n");
    sb.append("    pageId: ").append(toIndentedString(pageId)).append("\n");
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

  /**
   * Check if the given list is null or empty.
   */
  private <T> boolean isListNullOrEmpty(List<T> list) {
    return list == null || list.isEmpty();
  }

  /**
   * Dedup the given list. This can be applied to fields that do not require normalization or hashing.
   * This is currently only used for external_ids.
   * @param values Input
   * @return Deduped values
   */
  private List<String> dedup(List<String> values) {
    if (isListNullOrEmpty(values)) return null;
    Set<String> set = new HashSet();
    for (String str : values) {
      if (str != null) {
        set.add(str);
      }
    }
    return new ArrayList(set);
  }
}
