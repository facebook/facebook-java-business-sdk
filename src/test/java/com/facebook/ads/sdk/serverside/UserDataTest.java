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

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserDataTest {
  @Test
  public void BuilderAndGettersTest() {
    UserData userData = new UserData();
    userData
        .email("email0")
        .phone("1234567890")
        .gender(GenderEnum.FEMALE)
        .dateOfBirth("20000101")
        .lastName("lastname-1")
        .firstName("firstname-2")
        .city("Seattle")
        .state("WA")
        .zipcode("98123")
        .countryCode("USA")
        .externalId("external-1")
        .clientIpAddress("123.123.123.123")
        .clientUserAgent("chrome")
        .fbc("fbc.id.1")
        .fbp("fbp.id.2")
        .subscriptionId("subscription-id-3")
        .fbLoginId("fb-login-id-1")
        .leadId("lead-id-1")
        .f5first("first-5-first")
        .f5last("first-5-last")
        .fi("first-initial")
        .dobd("dob-day")
        .dobm("dob-month")
        .doby("dob-year");

    assertEquals(userData.getEmail(), "email0");
    assertEquals(userData.getPhone(), "1234567890");
    assertEquals(userData.getGender(), GenderEnum.FEMALE);
    assertEquals(userData.getDateOfBirth(), "20000101");
    assertEquals(userData.getLastName(), "lastname-1");
    assertEquals(userData.getFirstName(), "firstname-2");
    assertEquals(userData.getCity(), "Seattle");
    assertEquals(userData.getState(), "WA");
    assertEquals(userData.getZipcode(), "98123");
    assertEquals(userData.getCountryCode(), "USA");
    assertEquals(userData.getExternalId(), "external-1");
    assertEquals(userData.getClientIpAddress(), "123.123.123.123");
    assertEquals(userData.getClientUserAgent(), "chrome");
    assertEquals(userData.getFbc(), "fbc.id.1");
    assertEquals(userData.getFbp(), "fbp.id.2");
    assertEquals(userData.getSubscriptionId(), "subscription-id-3");
    assertEquals(userData.getFbLoginId(), "fb-login-id-1");
    assertEquals(userData.getLeadId(), "lead-id-1");
    assertEquals(userData.getF5first(), "first-5-first");
    assertEquals(userData.getF5last(), "first-5-last");
    assertEquals(userData.getFi(), "first-initial");
    assertEquals(userData.getDobd(), "dob-day");
    assertEquals(userData.getDobm(), "dob-month");
    assertEquals(userData.getDoby(), "dob-year");
  }

  @Test
  public void BuilderAndGettersWithMultipleValuesTest() {
    List<String> emails = Arrays.asList("email0", "email1");
    List<String> phones = Arrays.asList("1234567890", "2062062006");
    List<GenderEnum> genders = Arrays.asList(GenderEnum.MALE, GenderEnum.FEMALE);
    List<String> datesOfBirth = Arrays.asList("20000101", "20000102");
    List<String> lastNames = Arrays.asList("lastname-1", "lastname-2");
    List<String> firstNames = Arrays.asList("firstname-2", "firstname-3");
    List<String> cities = Arrays.asList("Seattle", "Portland");
    List<String> states = Arrays.asList("WA", "CA");
    List<String> zipcodes = Arrays.asList("98123", "98122");
    List<String> countryCodes = Arrays.asList("USA", "CA");
    List<String> externalIds = Arrays.asList("external-1", "external-2", "external-2");
    UserData userData = new UserData();
    userData
            .emails(emails)
            .phones(phones)
            .genders(genders)
            .datesOfBirth(datesOfBirth)
            .lastNames(lastNames)
            .firstNames(firstNames)
            .cities(cities)
            .states(states)
            .zipcodes(zipcodes)
            .countryCodes(countryCodes)
            .externalIds(externalIds);

    assertEquals(userData.getEmails(), emails);
    assertEquals(userData.getPhones(), phones);
    assertEquals(userData.getGenders(), genders);
    assertEquals(userData.getDatesOfBirth(), datesOfBirth);
    assertEquals(userData.getLastNames(), lastNames);
    assertEquals(userData.getFirstNames(), firstNames);
    assertEquals(userData.getCities(), cities);
    assertEquals(userData.getStates(), states);
    assertEquals(userData.getZipcodes(), zipcodes);
    assertEquals(userData.getCountryCodes(), countryCodes);
    assertEquals(userData.getExternalIds(), externalIds.subList(0, 2));
  }

  @Test
  public void EqualsAndHashCodeSameTest() {
    UserData userData1 = new UserData();
    userData1
        .email("email0")
        .phone("1234567890")
        .gender(GenderEnum.FEMALE)
        .dateOfBirth("20000101")
        .lastName("lastname-1")
        .firstName("firstname-2")
        .city("Seattle")
        .state("WA")
        .zipcode("98123")
        .countryCode("USA")
        .externalId("external-1")
        .clientIpAddress("123.123.123.123")
        .clientUserAgent("chrome")
        .fbc("fbc.id.1")
        .fbp("fbp.id.2")
        .subscriptionId("subscription-id-3")
        .fbLoginId("fb-login-id-1")
        .leadId("lead-id-1")
        .f5first("first-5-first")
        .f5last("first-5-last")
        .fi("first-initial")
        .dobd("dob-day")
        .dobm("dob-month")
        .doby("dob-year");

    UserData userData2 = new UserData();
    userData2
        .email("email0")
        .phone("1234567890")
        .gender(GenderEnum.FEMALE)
        .dateOfBirth("20000101")
        .lastName("lastname-1")
        .firstName("firstname-2")
        .city("Seattle")
        .state("WA")
        .zipcode("98123")
        .countryCode("USA")
        .externalId("external-1")
        .clientIpAddress("123.123.123.123")
        .clientUserAgent("chrome")
        .fbc("fbc.id.1")
        .fbp("fbp.id.2")
        .subscriptionId("subscription-id-3")
        .fbLoginId("fb-login-id-1")
        .leadId("lead-id-1")
        .f5first("first-5-first")
        .f5last("first-5-last")
        .fi("first-initial")
        .dobd("dob-day")
        .dobm("dob-month")
        .doby("dob-year");

    assertEquals(userData1, userData2);
    assertEquals(userData1.hashCode(), userData2.hashCode());
  }

  @Test
  public void EqualsAndHashCodeNotSameTest() {
    UserData userData1 = new UserData();
    userData1
        .email("email0")
        .doby("1999");

    UserData userData2 = new UserData();
    userData2
        .email("email0")
        .doby("2000");

    assertNotEquals(userData1, userData2);
    assertNotEquals(userData1.hashCode(), userData2.hashCode());
  }
}
