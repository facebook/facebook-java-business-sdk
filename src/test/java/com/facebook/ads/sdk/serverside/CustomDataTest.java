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
import java.util.Collections;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CustomDataTest {
    @Test
    public void TestCustomDataBuilderAndGetters() {
        CustomData customData = new CustomData();
        Content content = new Content();
        content.title("content-title-4");
        HashMap<String, String> customProperties = new HashMap<String, String>();
        customProperties.put("key-12", "value-12");
        customData
                .value(0.123f)
                .currency("USD")
                .contentName("content-name-1")
                .contentCategory("content-category-2")
                .contentIds(Arrays.asList("cid-3", "cid-34"))
                .contents(Collections.singletonList(content))
                .contentType("content-type-5")
                .orderId("order-id-6")
                .predictedLtv(7.89f)
                .numItems("8")
                .status("status-9")
                .searchString("search-string-10")
                .itemNumber("item-number-11")
                .deliveryCategory(DeliveryCategory.home_delivery)
                .customProperties(customProperties);

        assertEquals(customData.getValue(), 0.123f, 0);
        assertEquals(customData.getCurrency(), "USD");
        assertEquals(customData.getContentName(), "content-name-1");
        assertEquals(customData.getContentCategory(), "content-category-2");
        assertEquals(customData.getContentIds(), Arrays.asList("cid-3", "cid-34"));
        assertEquals(customData.getContents(), Collections.singletonList(content));
        assertEquals(customData.getContentType(), "content-type-5");
        assertEquals(customData.getOrderId(), "order-id-6");
        assertEquals(customData.getPredictedLtv(), 7.89f, 0);
        assertEquals(customData.getNumItems(), "8");
        assertEquals(customData.getStatus(), "status-9");
        assertEquals(customData.getSearchString(), "search-string-10");
        assertEquals(customData.getItemNumber(), "item-number-11");
        assertEquals(customData.getDeliveryCategory(), DeliveryCategory.home_delivery);
        assertEquals(customData.getCustomProperties(), customProperties);
    }

    @Test
    public void TestWhenInstancesAreEqual() {
        HashMap<String, String> customProperties = new HashMap<String, String>();
        customProperties.put("key-12", "value-12");
        CustomData customData1 = new CustomData();
        customData1.value(0.123f)
                .currency("USD")
                .contentName("content-name-1")
                .contentCategory("content-category-2")
                .contentIds(Arrays.asList("cid-3", "cid-34"))
                .contents(Collections.<Content>emptyList())
                .contentType("content-type-5")
                .orderId("order-id-6")
                .predictedLtv(7.89f)
                .numItems("8")
                .status("status-9")
                .searchString("search-string-10")
                .itemNumber("item-number-11")
                .deliveryCategory(DeliveryCategory.in_store)
                .customProperties(customProperties);

        CustomData customData2 = new CustomData();
        customData2.value(0.123f)
                .currency("USD")
                .contentName("content-name-1")
                .contentCategory("content-category-2")
                .contentIds(Arrays.asList("cid-3", "cid-34"))
                .contents(Collections.<Content>emptyList())
                .contentType("content-type-5")
                .orderId("order-id-6")
                .predictedLtv(7.89f)
                .numItems("8")
                .status("status-9")
                .searchString("search-string-10")
                .itemNumber("item-number-11")
                .deliveryCategory(DeliveryCategory.in_store)
                .customProperties(customProperties);

        assertEquals(customData1, customData2);
        assertEquals(customData1.hashCode(), customData2.hashCode());
    }

    @Test
    public void TestWhenInstancesAreNotEqual() {
        HashMap<String, String> customProperties = new HashMap<String, String>();
        customProperties.put("key-12", "value-12");
        CustomData customData1 = new CustomData();
        customData1.value(0.123f)
                .currency("USD")
                .contentName("content-name-1")
                .contentCategory("content-category-2")
                .contentIds(Arrays.asList("cid-3", "cid-34"))
                .contents(Collections.<Content>emptyList())
                .contentType("content-type-5")
                .orderId("order-id-6")
                .predictedLtv(7.89f)
                .numItems("8")
                .status("status-9")
                .searchString("search-string-10")
                .itemNumber("item-number-11")
                .deliveryCategory(DeliveryCategory.curbside)
                .customProperties(customProperties);

        CustomData customData2 = new CustomData();
        customData2.value(0.123f)
                .currency("USD")
                .contentName("content-name-1")
                .contentCategory("content-category-2")
                .contentIds(Arrays.asList("cid-3", "cid-34"))
                .contents(Collections.<Content>emptyList())
                .contentType("content-type-5")
                .orderId("order-id-6")
                .predictedLtv(7.89f)
                .numItems("8")
                .status("status-9")
                .searchString("search-string-10")
                // itemNumber is different
                .itemNumber("item-number-12345")
                .deliveryCategory(DeliveryCategory.curbside)
                .customProperties(customProperties);

        assertNotEquals(customData1, customData2);
        assertNotEquals(customData1.hashCode(), customData2.hashCode());
    }
}
