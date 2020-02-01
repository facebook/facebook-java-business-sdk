/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 * <p>
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 * <p>
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
package com.facebook.ads;

import com.facebook.ads.utils.ServerSideApiConstants;
import com.facebook.ads.utils.ServerSideApiUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ServerSideNormalizationTest {

  @Test
  public void NameNormalizeTest() {

    // ARRANGE
    List<String[]> nameTestCases = new ArrayList<String[]>();
    nameTestCases.add(new String[]{"John", "john"});
    nameTestCases.add(new String[]{"   Smith   ", "smith"});

    for (String[] testCase : nameTestCases) {

      // ACT
      String input = testCase[0];
      String expected = testCase[1];
      String actual = ServerSideApiUtil.normalize(input, ServerSideApiConstants.FIRST_NAME);

      // ASSERT
      Assert.assertEquals(expected, actual);
    }
  }

  @Test
  public void CityNormalizeTest() {

    // ARRANGE
    List<String[]> cityTestCases = new ArrayList<String[]>();
    cityTestCases.add(new String[]{"London  ", "london"});
    cityTestCases.add(new String[]{"Menlo Park", "menlopark"});
    cityTestCases.add(new String[]{"Stanley Park 1234", "stanleypark"});
    cityTestCases.add(new String[]{"San José", "sanjosé"});

    for (String[] testCase : cityTestCases) {

      // ACT
      String input = testCase[0];
      String expected = testCase[1];
      String actual = ServerSideApiUtil.normalize(input, ServerSideApiConstants.CITY);

      // ASSERT
      Assert.assertEquals(expected, actual);
    }
  }

  @Test
  public void StateNormalizeTest() {

    // ARRANGE
    List<String[]> stateTestCases = new ArrayList<String[]>();
    stateTestCases.add(new String[]{"California", "california"});
    stateTestCases.add(new String[]{"North Carolina", "northcarolina"});
    stateTestCases.add(new String[]{"Washington, D.C.", "washingtondc"});

    for (String[] testCase : stateTestCases) {

      // ACT
      String input = testCase[0];
      String expected = testCase[1];
      String actual = ServerSideApiUtil.normalize(input, ServerSideApiConstants.STATE);

      // ASSERT
      Assert.assertEquals(expected, actual);
    }
  }

  @Test
  public void CountryNormalizeTest() {

    // ARRANGE
    List<String[]> countryTestCases = new ArrayList<String[]>();
    countryTestCases.add(new String[]{"US", "us"});
    countryTestCases.add(new String[]{"     US   ", "us"});
    countryTestCases.add(new String[]{"US!", "us"});
    countryTestCases.add(new String[]{"Germany", "Invalid format for country"});

    for (String[] testCase : countryTestCases) {

      String input = testCase[0];
      String expected = testCase[1];
      try {
        // ACT
        String actual = ServerSideApiUtil.normalize(input, ServerSideApiConstants.COUNTRY);

        // ASSERT
        Assert.assertEquals(expected, actual);
      } catch (Exception ex) {
        Assert.assertTrue(ex.getMessage().contains(expected));
      }
    }
  }

  @Test
  public void ZipNormalizeTest() {

    // ARRANGE
    List<String[]> zipTestCases = new ArrayList<String[]>();
    zipTestCases.add(new String[]{"98 121-9431", "98121"});
    zipTestCases.add(new String[]{"NR9 5AL", "nr95al"});
    zipTestCases.add(new String[]{"641041-ABC-XYZ", "641041"});
    zipTestCases.add(new String[]{"A", "Invalid postalcode format"});

    for (String[] testCase : zipTestCases) {

      // ACT
      String input = testCase[0];
      String expected = testCase[1];

      try {
        // ACT
        String actual = ServerSideApiUtil.normalize(input, ServerSideApiConstants.ZIP_CODE);

        // ASSERT
        Assert.assertEquals(expected, actual);
      } catch (Exception ex) {
        Assert.assertTrue(ex.getMessage().contains(expected));
      }
    }
  }


  @Test
  public void CurrencyNormalizeTest() {

    // ARRANGE
    List<String[]> currencyTestCases = new ArrayList<String[]>();
    currencyTestCases.add(new String[]{"USD", "usd"});
    currencyTestCases.add(new String[]{"   EUR  ", "eur"});
    currencyTestCases.add(new String[]{"USD!", "usd"});
    currencyTestCases.add(new String[]{"US Dollars", "Invalid format for currency"});

    for (String[] testCase : currencyTestCases) {

      String input = testCase[0];
      String expected = testCase[1];

      try {
        // ACT
        String actual = ServerSideApiUtil.normalize(input, ServerSideApiConstants.CURRENCY);

        // ASSERT
        Assert.assertEquals(expected, actual);
      } catch (Exception ex) {
        Assert.assertTrue(ex.getMessage().contains(expected));
      }
    }
  }

  @Test
  public void PhoneNumberNormalizeTest() {

    // ARRANGE
    List<String[]> phoneTestCases = new ArrayList<String[]>();
    phoneTestCases.add(new String[]{"123-456-7890", "1234567890"});
    phoneTestCases.add(new String[]{"(123)-456-7890", "1234567890"});
    phoneTestCases.add(new String[]{"   123456-7890   ", "1234567890"});
    phoneTestCases.add(new String[]{"12345", "Invalid phone number format for the passed phone number"});
    phoneTestCases.add(new String[]{"123456123456123456123456", "Invalid phone number format for the passed phone number"});

    for (String[] testCase : phoneTestCases) {

      String input = testCase[0];
      String expected = testCase[1];

      try {
        // ACT
        String actual = ServerSideApiUtil.normalize(input, ServerSideApiConstants.PHONE_NUMBER);

        // ASSERT
        Assert.assertEquals(expected, actual);
      } catch (Exception ex) {
        Assert.assertTrue(ex.getMessage().contains(expected));
      }
    }
  }

  @Test
  public void EmailNormalizeTest() {

    // ARRANGE
    List<String[]> nameTestCases = new ArrayList<String[]>();
    nameTestCases.add(new String[]{"  foo@foo.com  ", "foo@foo.com"});
    nameTestCases.add(new String[]{"TEST", "Invalid email format for the passed email"});

    for (String[] testCase : nameTestCases) {

      String input = testCase[0];
      String expected = testCase[1];

      try {
        // ACT
        String actual = ServerSideApiUtil.normalize(input, ServerSideApiConstants.EMAIL);

        // ASSERT
        Assert.assertEquals(expected, actual);
      } catch (Exception ex) {
        // ASSERT
        Assert.assertTrue(ex.getMessage().contains(expected));
      }
    }
  }
}

