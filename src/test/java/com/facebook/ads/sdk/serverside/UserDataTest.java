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

import static org.junit.Assert.*;

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
