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
package com.facebook.ads.sdk.serverside;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContentTest {
    @Test
    public void ContentToStringTest() {
        Content content = new Content()
                .productId("1-id")
                .quantity(2L)
                .itemPrice(3.99F)
                .title("4-title")
                .description("5-description")
                .brand("6-brand")
                .category("7-category")
                .deliveryCategory(DeliveryCategory.in_store);
        String expected = String.join("\n", "class Content {",
                "    productId: 1-id",
                "    quantity: 2",
                "    itemPrice: 3.99",
                "    title: 4-title",
                "    description: 5-description",
                "    brand: 6-brand",
                "    category: 7-category",
                "    deliveryCategory: in_store",
                "}");

        assertEquals(content.toString(), expected);
    }
}
