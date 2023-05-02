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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class EventAmTest {
  @Test
  public void BuildersAndGettersTest() {
    Event event = new Event();
    UserData userData = new UserData();
    CustomData customData = new CustomData();
    String[] dataProcessingOptions = {"AMO"};
    String eventName = "custom";
    long eventTime = 123L;
    ActionSource actionSource = null;
    String advancedMeasurementTable = "test_am_table";

    event.setEventName(eventName);
    event.setEventTime(eventTime);
    event.setUserData(userData);
    event.setCustomData(customData);
    event.setDataProcessingOptions(dataProcessingOptions);
    event.setActionSource(actionSource);
    event.setAdvancedMeasurementTable(advancedMeasurementTable);

    assertEquals(event.getEventName(), eventName);
    assertEquals((long) event.getEventTime(), eventTime);
    assertEquals(event.getUserData(), userData);
    assertEquals(event.getCustomData(), customData);
    assertArrayEquals(event.getDataProcessingOptions(), dataProcessingOptions);
    assertEquals(event.getActionSource(), actionSource);
    assertEquals(event.getAdvancedMeasurementTable(), advancedMeasurementTable);
  }
}
