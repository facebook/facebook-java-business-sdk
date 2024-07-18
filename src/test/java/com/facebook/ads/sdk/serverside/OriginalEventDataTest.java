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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class OriginalEventDataTest {
    @Test
    public void TestOriginalEventDataBuilderAndGetters() {
        OriginalEventData originalEventData = new OriginalEventData();
        String eventName = "eventName-0";
        long eventTime = 123L;
        originalEventData.eventName(eventName).eventTime(eventTime);

        assertEquals(originalEventData.getEventName(), eventName);
        assertEquals((long) originalEventData.getEventTime(), eventTime);
    }

    @Test
    public void TestWhenInstancesAreEqual() {
        OriginalEventData originalEventData1 = new OriginalEventData();
        String eventName = "eventName-0";
        long eventTime = 123L;
        originalEventData1.eventName(eventName).eventTime(eventTime);
        OriginalEventData originalEventData2 = new OriginalEventData();
        originalEventData2.eventName(eventName).eventTime(eventTime);

        assertEquals(originalEventData1, originalEventData2);
        assertEquals(originalEventData1.hashCode(), originalEventData2.hashCode());
    }

    @Test
    public void TestWhenInstancesAreNotEqual() {
        OriginalEventData originalEventData1 = new OriginalEventData();
        long eventTime = 123L;
        originalEventData1.eventName("eventName-0").eventTime(eventTime);
        OriginalEventData originalEventData2 = new OriginalEventData();
        originalEventData2.eventName("eventName-1").eventTime(eventTime);

        assertNotEquals(originalEventData1, originalEventData2);
        assertNotEquals(originalEventData1.hashCode(), originalEventData2.hashCode());
    }
}
