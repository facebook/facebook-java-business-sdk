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


import org.junit.Test;

import static com.facebook.ads.utils.ServerSideApiConstants.*;
import static com.facebook.ads.utils.ServerSideApiUtil.normalize;
import static org.junit.Assert.assertEquals;

public class ServerSideApiUtilTest {
  @Test
  public void NormalizeF5firstTest() {
    assertEquals(normalize("George", F5FIRST), "georg");
    assertEquals(normalize(" John ", F5FIRST), "john");
    assertEquals(normalize("", F5FIRST), "");
  }

  @Test
  public void NormalizeF5lastTest() {
    assertEquals(normalize("Washington", F5LAST), "washi");
    assertEquals(normalize(" Adams ", F5LAST), "adams");
    assertEquals(normalize("", F5LAST), "");
  }

  @Test
  public void NormalizeFiTest() {
    assertEquals(normalize("g", FI), "g");
    assertEquals(normalize(" G ", FI), "g");
    assertEquals(normalize("GW", FI), "g");
    assertEquals(normalize("", FI), "");
  }

  @Test
  public void NormalizeDobd() {
    assertEquals(normalize("1", DOBD), "01");
    assertEquals(normalize("9", DOBD), "09");
    assertEquals(normalize("31", DOBD), "31");
  }

  @Test(expected = IllegalArgumentException.class)
  public void NormalizeDobdWhenInvalidThrowsException1() {
    normalize("32", DOBD);
  }

  @Test(expected = IllegalArgumentException.class)
  public void NormalizeDobdWhenInvalidThrowsException2() {
    normalize("00", DOBD);
  }

  @Test(expected = IllegalArgumentException.class)
  public void NormalizeDobdWhenInvalidThrowsException3() {
    normalize("-1", DOBD);
  }

  @Test(expected = IllegalArgumentException.class)
  public void NormalizeDobdWhenInvalidThrowsException4() {
    normalize("001", DOBD);
  }

  @Test(expected = IllegalArgumentException.class)
  public void NormalizeDobdWhenInvalidThrowsException5() {
    normalize("ab", DOBD);
  }

  @Test
  public void NormalizeDobm() {
    assertEquals(normalize("1", DOBM), "01");
    assertEquals(normalize("9", DOBM), "09");
    assertEquals(normalize("12", DOBM), "12");
  }

  @Test(expected = IllegalArgumentException.class)
  public void NormalizeDobmWhenInvalidThrowsException1() {
    normalize("13", DOBM);
  }

  @Test(expected = IllegalArgumentException.class)
  public void NormalizeDobmWhenInvalidThrowsException2() {
    normalize("00", DOBM);
  }

  @Test(expected = IllegalArgumentException.class)
  public void NormalizeDobmWhenInvalidThrowsException3() {
    normalize("-1", DOBM);
  }

  @Test(expected = IllegalArgumentException.class)
  public void NormalizeDobmWhenInvalidThrowsException4() {
    normalize("001", DOBM);
  }

  @Test(expected = IllegalArgumentException.class)
  public void NormalizeDobmWhenInvalidThrowsException5() {
    normalize("ab", DOBM);
  }

  @Test
  public void NormalizeDoby() {
    assertEquals(normalize("2000", DOBY), "2000");
    assertEquals(normalize("0000", DOBY), "0000");
    assertEquals(normalize("9999", DOBY), "9999");
  }

  @Test(expected = IllegalArgumentException.class)
  public void NormalizeDobyWhenInvalidThrowsException1() {
    normalize("10", DOBY);
  }

  @Test(expected = IllegalArgumentException.class)
  public void NormalizeDobyWhenInvalidThrowsException2() {
    normalize("12345", DOBY);
  }

  @Test(expected = IllegalArgumentException.class)
  public void NormalizeDobyWhenInvalidThrowsException3() {
    normalize("-123", DOBY);
  }
}