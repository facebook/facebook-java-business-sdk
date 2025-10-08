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

public class AttributionDataTest {
    @Test
    public void TestAttributionDataBuilderAndGetters() {
        AttributionData attributionData = new AttributionData();
        String scope = "click";
        String adId = "adId-0";
        String adsetId = "adsetId-0";
        String campaignId = "campaignId-0";
        long visitTime = 123L;
        int attributionWindow = 7;
        float attributionShare = 0.5f;
        float attributionValue = 0.3f;
        AttributionModelEnum attributionModel = AttributionModelEnum.LAST_CLICK;
        String attributionSource = "amm";
        String touchpointType = "onsite_click";
        int touchpointTs = 123;
        
        attributionData
                     .scope(scope)
                     .adId(adId)
                     .adsetId(adsetId)
                     .campaignId(campaignId)
                     .visitTime(visitTime)
                     .attributionWindow(attributionWindow)
                     .attributionShare(attributionShare)
                     .attributionModel(attributionModel)
                     .attributionValue(attributionValue)
                     .attributionSource(attributionSource)
                     .touchpointType(touchpointType)
                     .touchpointTs(touchpointTs);

        assertEquals(attributionData.getScope(), scope);
        assertEquals(attributionData.getAdId(), adId);
        assertEquals(attributionData.getAdsetId(), adsetId);
        assertEquals(attributionData.getCampaignId(), campaignId);
        assertEquals((int)attributionData.getAttributionWindow(), attributionWindow);
        assertEquals((float)attributionData.getAttributionShare(), attributionShare, 0);
        assertEquals((long) attributionData.getVisitTime(), visitTime);
        assertEquals(attributionData.getAttributionModel(), attributionModel);
        assertEquals((float)attributionData.getAttributionValue(), attributionValue, 0);
        assertEquals(attributionData.getAttributionSource(), attributionSource);
        assertEquals(attributionData.getTouchpointType(), touchpointType);
        assertEquals((int)attributionData.getTouchpointTs(), touchpointTs);
    }

    @Test
    public void TestWhenInstancesAreEqual() {
        AttributionData attributionData1 = new AttributionData();
        AttributionData attributionData2 = new AttributionData();
        String scope = "click";
        String adId = "adId-0";
        String adsetId = "adsetId-0";
        String campaignId = "campaignId-0";
        long visitTime = 123L;
        int attributionWindow = 7;
        float attributionShare = 0.5f;
        float attributionValue = 0.3f;
        AttributionModelEnum attributionModel = AttributionModelEnum.LAST_CLICK;
        String attributionSource = "amm";
        String touchpointType = "onsite_click";
        int touchpointTs = 123;
        
        attributionData1
                     .scope(scope)
                     .adId(adId)
                     .adsetId(adsetId)
                     .campaignId(campaignId)
                     .visitTime(visitTime)
                     .attributionWindow(attributionWindow)
                     .attributionShare(attributionShare)
                     .attributionModel(attributionModel)
                     .attributionValue(attributionValue)
                     .attributionSource(attributionSource)
                     .touchpointType(touchpointType)
                     .touchpointTs(touchpointTs);

        attributionData2
                     .scope(scope)
                     .adId(adId)
                     .adsetId(adsetId)
                     .campaignId(campaignId)
                     .visitTime(visitTime)
                     .attributionWindow(attributionWindow)
                     .attributionShare(attributionShare)
                     .attributionModel(attributionModel)
                     .attributionValue(attributionValue)
                     .attributionSource(attributionSource)
                     .touchpointType(touchpointType)
                     .touchpointTs(touchpointTs);

        assertEquals(attributionData1, attributionData2);
        assertEquals(attributionData1.hashCode(), attributionData2.hashCode());
    }

    @Test
    public void TestWhenInstancesAreNotEqual() {
        AttributionData attributionData1 = new AttributionData();
        AttributionData attributionData2 = new AttributionData();
        String scope = "click";
        String adId = "adId-0";
        String adsetId = "adsetId-0";
        String campaignId = "campaignId-0";
        long visitTime = 123L;
        float attributionShare = 0.5f;
        float attributionValue = 0.3f;
        AttributionModelEnum attributionModel = AttributionModelEnum.LAST_CLICK;
        String attributionSource = "amm";
        String touchpointType = "onsite_click";
        int touchpointTs = 123;
        
        // set different attribution windown to test
        attributionData1
                     .scope(scope)
                     .adId(adId)
                     .adsetId(adsetId)
                     .campaignId(campaignId)
                     .visitTime(visitTime)
                     .attributionWindow(28)
                     .attributionShare(attributionShare)
                     .attributionModel(attributionModel)
                     .attributionValue(attributionValue)
                     .attributionSource(attributionSource)
                     .touchpointType(touchpointType)
                     .touchpointTs(touchpointTs);

        attributionData2
                     .scope(scope)
                     .adId(adId)
                     .adsetId(adsetId)
                     .campaignId(campaignId)
                     .visitTime(visitTime)
                     .attributionWindow(7)
                     .attributionShare(attributionShare)
                     .attributionModel(attributionModel)
                     .attributionValue(attributionValue)
                     .attributionSource(attributionSource)
                     .touchpointType(touchpointType)
                     .touchpointTs(touchpointTs);

        assertNotEquals(attributionData1, attributionData2);
        assertNotEquals(attributionData1.hashCode(), attributionData2.hashCode());
    }
}
