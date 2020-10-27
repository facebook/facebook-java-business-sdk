/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 * <p>
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to use, copy, modify, and
 * distribute this software in source code or binary form for use in connection with the web
 * services and APIs provided by Facebook.
 * <p>
 * As with any software that integrates with the Facebook platform, your use of this software is
 * subject to the Facebook Developer Principles and Policies [http://developers.facebook.com/policy/].
 * This copyright notice shall be included in all copies or substantial portions of the software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.facebook.ads.utils;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static com.facebook.ads.utils.ServerSideApiConstants.*;
import static com.facebook.ads.utils.ServerSideApiUtil.normalize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ServerSideApiUtilTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void NormalizeF5firstTest() {
    assertEquals(normalize("George", F5FIRST), "georg");
    assertEquals(normalize(" John ", F5FIRST), "john");
  }

  @Test
  public void NormalizeF5lastTest() {
    assertEquals(normalize("Washington", F5LAST), "washi");
    assertEquals(normalize(" Adams ", F5LAST), "adams");
  }

  @Test
  public void NormalizeFiTest() {
    assertEquals(normalize("g", FI), "g");
    assertEquals(normalize(" G ", FI), "g");
    assertEquals(normalize("GW", FI), "g");
  }

  @Test
  public void NormalizeDobd() {
    assertEquals(normalize("1", DOBD), "01");
    assertEquals(normalize("9", DOBD), "09");
    assertEquals(normalize("31", DOBD), "31");
  }

  @Test
  public void NormalizeDobdWhenInvalidThrowsException1() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid dobd: '32'. Please specify the day in 'DD' format.");
    normalize("32", DOBD);
  }

  @Test
  public void NormalizeDobdWhenInvalidThrowsException2() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid dobd: '00'. Please specify the day in 'DD' format.");
    normalize("00", DOBD);
  }

  @Test
  public void NormalizeDobdWhenInvalidThrowsException3() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid dobd: '-1'. Please specify the day in 'DD' format.");
    normalize("-1", DOBD);
  }

  @Test
  public void NormalizeDobdWhenInvalidThrowsException4() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid dobd: '001'. Please specify the day in 'DD' format.");
    normalize("001", DOBD);
  }

  @Test
  public void NormalizeDobdWhenInvalidThrowsException5() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid dobd: 'a'. Please specify the day in 'DD' format.");
    normalize("a", DOBD);
  }

  @Test
  public void NormalizeDobdWhenInvalidThrowsException6() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid dobd: '1b'. Please specify the day in 'DD' format.");
    normalize("1b", DOBD);
  }

  @Test
  public void NormalizeDobm() {
    assertEquals(normalize("1", DOBM), "01");
    assertEquals(normalize("9", DOBM), "09");
    assertEquals(normalize("12", DOBM), "12");
  }

  @Test
  public void NormalizeDobmWhenInvalidThrowsException1() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid dobm: '13'. Please specify the month in 'MM' format.");
    normalize("13", DOBM);
  }

  @Test
  public void NormalizeDobmWhenInvalidThrowsException2() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid dobm: '00'. Please specify the month in 'MM' format.");
    normalize("00", DOBM);
  }

  @Test
  public void NormalizeDobmWhenInvalidThrowsException3() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid dobm: '-1'. Please specify the month in 'MM' format.");
    normalize("-1", DOBM);
  }

  @Test
  public void NormalizeDobmWhenInvalidThrowsException4() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid dobm: '001'. Please specify the month in 'MM' format.");
    normalize("001", DOBM);
  }

  @Test
  public void NormalizeDobmWhenInvalidThrowsException5() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid dobm: 'a'. Please specify the month in 'MM' format.");
    normalize("a", DOBM);
  }

  @Test
  public void NormalizeDobmWhenInvalidThrowsException6() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid dobm: '0a'. Please specify the month in 'MM' format.");
    normalize("0a", DOBM);
  }

  @Test
  public void NormalizeDoby() {
    assertEquals(normalize("2000", DOBY), "2000");
    assertEquals(normalize("0000", DOBY), "0000");
    assertEquals(normalize("9999", DOBY), "9999");
  }

  @Test
  public void NormalizeDobyWhenInvalidThrowsException1() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid doby: '10'. Please specify the year in 'YYYY' format.");
    normalize("10", DOBY);
  }

  @Test
  public void NormalizeDobyWhenInvalidThrowsException2() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid doby: '12345'. Please specify the year in 'YYYY' format.");
    normalize("12345", DOBY);
  }

  @Test
  public void NormalizeDobyWhenInvalidThrowsException3() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid doby: '-123'. Please specify the year in 'YYYY' format.");
    normalize("-123", DOBY);
  }

  @Test
  public void NormalizeSanitizesEmptyFieldsToNull() {
    List<String> params = Arrays.asList(
      EMAIL,
      PHONE_NUMBER,
      GENDER,
      DATE_OF_BIRTH,
      LAST_NAME,
      FIRST_NAME,
      CITY,
      COUNTRY,
      STATE,
      ZIP_CODE,
      EXTERNAL_ID,
      CURRENCY,
      CLIENT_IP_ADDRESS,
      CLIENT_USER_AGENT,
      FBC,
      FBP,
      SUBSCRIPTION_ID,
      FB_LOGIN_ID,
      LEAD_ID,
      F5FIRST,
      F5LAST,
      FI,
      DOBD,
      DOBM,
      DOBY
    );

    for (String param : params) {
      assertNull(normalize("", param));
      assertNull(normalize("\n", param));
      assertNull(normalize(" \t   ", param));
    }
  }
}