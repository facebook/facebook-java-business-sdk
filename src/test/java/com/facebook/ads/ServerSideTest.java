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

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.serverside.*;
import com.facebook.ads.utils.ServerSideApiConstants;
import com.facebook.ads.utils.ServerSideApiUtil;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ServerSideTest {
  @Test
  public void CustomDataParametersTest() {

    // ARRANGE
    APIContext context = new APIContext("ACCESS_TOKEN").enableDebug(true);

    UserData userData = new UserData()
            .email("abc@eg.com");

    HashMap<String, String> customProperties = new HashMap<String, String>();
    customProperties.put("Key1", "Value1");
    customProperties.put("Key2", "Value2");

    List<Content> contents = new ArrayList<Content>();
    contents.add(new Content().productId("1").brand("brandA"));
    contents.add(new Content().productId("2").brand("brandB"));

    List<String> contentIds = new ArrayList<String>();
    contentIds.add("123");
    contentIds.add("456");

    String contentCategory = "content_categoryA";
    String contentName = "content_nameA";
    String currency = "USD";

    CustomData customData = new CustomData()
            .contentIds(contentIds)
            .customProperties(customProperties)
            .contents(contents)
            .contentCategory(contentCategory)
            .contentName(contentName)
            .currency(currency)
            .deliveryCategory(DeliveryCategory.curbside)
            .value(123.45F);

    Event testEvent = new Event();
    testEvent.eventName("Purchase")
            .eventTime(System.currentTimeMillis() / 1000L)
            .userData(userData)
            .dataProcessingOptions(new String[]{})
            .customData(customData);

    EventRequest eventRequest = new EventRequest("123", context);
    eventRequest.addDataItem(testEvent);

    // ACT
    String serializedPayload = eventRequest.getSerializedPayload();

    // ASSERT
    String cpString = (new Gson()).toJson(customProperties);
    String serializedContents = (new Gson()).toJson(contents);
    String serializedContentIds = (new Gson()).toJson(contentIds);
    Assert.assertTrue(serializedPayload.contains(cpString.substring(1, cpString.length() - 1)));
    Assert.assertTrue(serializedPayload.contains(serializedContents));
    Assert.assertTrue(serializedPayload.contains(serializedContentIds));
    Assert.assertTrue(serializedPayload.contains(currency.toLowerCase()));
    Assert.assertTrue(serializedPayload.contains(contentCategory));
    Assert.assertTrue(serializedPayload.contains(contentName));
    Assert.assertTrue(serializedPayload.contains(DeliveryCategory.curbside.toString()));
  }
}
