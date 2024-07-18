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

public class EventTest {
  @Test
  public void BuildersAndGettersTest() {
    Event event = new Event();
    UserData userData = new UserData();
    CustomData customData = new CustomData();
    OriginalEventData originalEventData = new OriginalEventData();
    AttributionData attributionData = new AttributionData();
    String[] dataProcessingOptions = {"1", "2"};
    String eventName = "eventName-0";
    long eventTime = 123L;
    boolean optOut = false;
    String eventId = "eventId-3";
    String eventSourceUrl = "eventSourceUrl-2";
    int dataProcessingOptionsCountry = 1;
    int dataProcessingOptionsState = 1;
    ActionSource actionSource = ActionSource.website;

    event.setEventName(eventName);
    event.setEventTime(eventTime);
    event.setEventSourceUrl(eventSourceUrl);
    event.setOptOut(optOut);
    event.setEventId(eventId);
    event.setUserData(userData);
    event.setCustomData(customData);
    event.setOriginalEventData(originalEventData);
    event.setAttributionData(attributionData);
    event.setDataProcessingOptions(dataProcessingOptions);
    event.setDataProcessingOptionsCountry(dataProcessingOptionsCountry);
    event.setDataProcessingOptionsState(dataProcessingOptionsState);
    event.setActionSource(actionSource);

    assertEquals(event.getEventName(), eventName);
    assertEquals((long) event.getEventTime(), eventTime);
    assertEquals(event.getEventSourceUrl(), eventSourceUrl);
    assertEquals(event.getOptOut(), optOut);
    assertEquals(event.getEventId(), eventId);
    assertEquals(event.getUserData(), userData);
    assertEquals(event.getCustomData(), customData);
    assertEquals(event.getOriginalEventData(), originalEventData);
    assertEquals(event.getAttributionData(), attributionData);
    assertArrayEquals(event.getDataProcessingOptions(), dataProcessingOptions);
    assertEquals((int) event.getDataProcessingOptionsCountry(), dataProcessingOptionsCountry);
    assertEquals((int) event.getDataProcessingOptionsState(), dataProcessingOptionsState);
    assertEquals(event.getActionSource(), actionSource);
  }
}
