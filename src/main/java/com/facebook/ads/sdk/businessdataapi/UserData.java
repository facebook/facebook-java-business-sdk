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

package com.facebook.ads.sdk.businessdataapi;

import com.facebook.ads.utils.BusinessDataApiConstants;
import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName(BusinessDataApiConstants.EMAIL)
    private String email = null;

    @SerializedName(BusinessDataApiConstants.PHONE_NUMBER)
    private String phone = null;

    @SerializedName(BusinessDataApiConstants.DATE_OF_BIRTH)
    private String dateOfBirth = null;

    @SerializedName(BusinessDataApiConstants.LAST_NAME)
    private String lastName = null;

    @SerializedName(BusinessDataApiConstants.FIRST_NAME)
    private String firstName = null;

    @SerializedName(BusinessDataApiConstants.CITY)
    private String city = null;

    @SerializedName(BusinessDataApiConstants.STATE)
    private String state = null;

    @SerializedName(BusinessDataApiConstants.ZIP_CODE)
    private String zipcode = null;

    @SerializedName(BusinessDataApiConstants.COUNTRY)
    private String countryCode = null;

    @SerializedName(BusinessDataApiConstants.EXTERNAL_ID)
    private String externalId = null;

    @SerializedName(BusinessDataApiConstants.ADDRESS)
    private String address = null;

    public UserData() {
    }

    /**
     * @param email       An email address, in lowercase.
     * @param phone       A phone number. Include only digits with country code,
     *                    area code, and number.
     * @param firstName   A first name in lowercase.
     * @param lastName    A last name in lowercase.
     * @param dateOfBirth A date of birth given as year, month, and day in YYYYMMDD
     *                    format.
     * @param city        A city in lower-case without spaces or punctuation.
     * @param state       A two-letter state code in lowercase.
     * @param countryCode A two-letter country code in lowercase.
     * @param zipcode     Postal code of the city in your country standard.
     * @param externalId  Any unique ID from the business.
     * @param address     An physical address.
     */
    public UserData(String email, String phone, String dateOfBirth, String lastName, String firstName, String city,
            String state, String zipcode, String countryCode, String externalId, String address) {
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.countryCode = countryCode;
        this.externalId = externalId;
        this.address = address;
    }

    /**
     * Gets the email address for the user data field. An email address, in
     * lowercase. Example: joe@eg.com
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address for the user data field.
     *
     * @param email An email address, in lowercase. Example: joe@eg.com
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the email address for the user data field.
     *
     * @param email An email address, in lowercase. Example: joe@eg.com
     * @return UserData
     */
    public UserData email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Gets the phone number for the user data. A phone number. Include only digits
     * with country code, area code, and number. Example: 16505551212
     *
     * @return phone
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Sets the phone number for the user data.
     *
     * @param phone A phone number. Include only digits with country code, area
     *              code, and number. Example: 16505551212
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Sets the phone number for the user data.
     *
     * @param phone A phone number. Include only digits with country code, area
     *              code, and number. Example: 16505551212
     * @return UserData
     */
    public UserData phone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * Gets the date of birth for the user data. A date of birth given as year,
     * month, and day in the Format YYYYMMDD Example: 19971226 for December 26,
     * 1997.
     *
     * @return dataOfBirth
     */
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * Sets the date of birth for the user data.
     *
     * @param dateOfBirth A date of birth given as year, month, and day in the
     *                    Format YYYYMMDD Example: 19971226 for December 26, 1997.
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Sets the date of birth for the user data.
     *
     * @param dateOfBirth A date of birth given as year, month, and day in the
     *                    Format YYYYMMDD Example: 19971226 for December 26, 1997.
     * @return UserData
     */
    public UserData dataOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    /**
     * Gets the last name for the user data. lastName is the last name in lowercase.
     * Example: smith
     *
     * @return lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the last name for the user data.
     *
     * @param lastName is last name in lowercase. Example: smith
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the last name for the user data.
     *
     * @param lastName is last name in lowercase. Example: smith
     * @return UserData
     */
    public UserData lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Gets the first name for the user data. firstName is first name in lowercase.
     * Example: joe
     *
     * @return firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the first name for the user data.
     *
     * @param firstName is first name in lowercase. Example: joe
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the first name for the user data.
     *
     * @param firstName is first name in lowercase. Example: joe
     * @return UserData
     */
    public UserData firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Gets the city for the user data. city is city in lower-case without spaces or
     * punctuation. Example: menlopark
     *
     * @return city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Sets the city for the user data.
     *
     * @param city is city in lower-case without spaces or punctuation. Example:
     *             menlopark
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets the city for the user data.
     *
     * @param city is city in lower-case without spaces or punctuation. Example:
     *             menlopark
     * @return UserData
     */
    public UserData city(String city) {
        this.city = city;
        return this;
    }

    /**
     * Gets the zip/postal code for the user data. zipcode is a five-digit zip code
     * for United States.For other locations, follow each country's standards.
     * Example: 98121 (for United States zip code)
     *
     * @return zipcode
     */
    public String getZipcode() {
        return this.zipcode;
    }

    /**
     * Sets the zip/postal code for the user data.
     *
     * @param zipcode is a five-digit zip code for United States.For other
     *                locations, follow each country's standards. Example: 98121
     *                (for United States zip code)
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * Sets the zip/postal code for the user data.
     *
     * @param zipcode is a five-digit zip code for United States.For other
     *                locations, follow each country's standards. Example: 98121
     *                (for United States zip code)
     * @return UserData
     */
    public UserData zipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    /**
     * Gets the state for the user data. state is state in lower-case without spaces
     * or punctuation. Example: ca
     *
     * @return state
     */
    public String getState() {
        return this.state;
    }

    /**
     * Sets the state for the user data.
     *
     * @param state is state in lower-case without spaces or punctuation. Example:
     *              ca
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Sets the state for the user data.
     *
     * @param state is state in lower-case without spaces or punctuation. Example:
     *              ca
     * @return UserData
     */
    public UserData state(String state) {
        this.state = state;
        return this;
    }

    /**
     * Gets the country for the user data. countryCode is A two-letter country code
     * in lowercase. Example: usa
     *
     * @return countryCode
     */
    public String getCountryCode() {
        return this.countryCode;
    }

    /**
     * Sets the country for the user data.
     *
     * @param countryCode is A two-letter country code in lowercase. Example: usa
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Sets the country for the user data.
     *
     * @param countryCode is A two-letter country code in lowercase. Example: usa
     * @return UserData
     */
    public UserData countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    /**
     * Gets the external id for the user data. externalId is a unique ID from the
     * business, such as loyalty membership IDs, user IDs, and external cookie IDs.
     *
     * @return externalId
     */
    public String getExternalId() {
        return this.externalId;
    }

    /**
     * Sets the external id for the user data.
     *
     * @param externalId is a unique ID from the business, such as loyalty
     *                   membership IDs, user IDs, and external cookie IDs.
     */
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    /**
     * Sets the external id for the user data.
     *
     * @param externalId is a unique ID from the business, such as loyalty
     *                   membership IDs, user IDs, and external cookie IDs.
     * @return UserData
     */
    public UserData externalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    /**
     * Gets the address for the user data. address is a physical address
     *
     * @return address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Sets the address for the user data.
     *
     * @param address is a physical address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the address for the user data.
     *
     * @param address is a physical address
     * @return UserData
     */
    public UserData address(String address) {
        this.address = address;
        return this;
    }
}
