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
import com.facebook.ads.sdk.signal.*;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SignalTest {
        @Test
        public void EventRequestTest() {

                // ARRANGE
                APIContext context = new APIContext("ACCESS_TOKEN").enableDebug(true);

                UserData userData = new UserData().email("aaa@fb.com");
                UserData billingContact = new UserData().email("bbb@fb.com");
                UserData shippingContact = new UserData().email("ccc@fb.com");

                HashMap<String, String> customProperties = new HashMap<String, String>();
                customProperties.put("Key1", "Value1");

                List<Content> contents = new ArrayList<Content>();
                contents.add(new Content().id("1").tax(1.2F));
                contents.add(new Content().id("2").brand("brand"));

                CustomData customData = new CustomData().customProperties(customProperties).contents(contents)
                                .value(123.45F).billingContact(billingContact).shippingContact(shippingContact);

                List<Event> testEvents = new ArrayList<Event>();
                testEvents.add(new Event().eventName("Purchase").eventTime(123124125L).userData(userData)
                                .dataProcessingOptions(new String[] {}).customData(customData));

                EventRequest eventRequest = new EventRequest("pixelID", "pageID", context);
                eventRequest.setData(testEvents);
                eventRequest.setPartnerAgent("partnerAgent");

                // check data
                com.facebook.ads.sdk.businessdataapi.EventRequest bdapiEventRequest = eventRequest
                                .getBusinessDataEventRequest();
                com.facebook.ads.sdk.businessdataapi.Event bdapiEvent = bdapiEventRequest.getData().get(0);
                Assert.assertTrue(bdapiEventRequest.getPartnerAgent() == "partnerAgent");
                Assert.assertTrue(bdapiEvent.getEventName() == "Purchase");
                Assert.assertTrue(bdapiEvent.getEventTime() == 123124125L);
                Assert.assertTrue(bdapiEvent.getDataProcessingOptions().length == 0);
                Assert.assertTrue(bdapiEvent.getUserData().getEmail() == "aaa@fb.com");
                Assert.assertTrue(bdapiEvent.getCustomData().getValue() == 123.45F);
                List<com.facebook.ads.sdk.businessdataapi.Content> bdapiContents = bdapiEvent.getCustomData()
                                .getContents();
                Assert.assertTrue(bdapiContents.get(0).getId() == "1");
                Assert.assertTrue(bdapiContents.get(0).getTax() == 1.2F);
                Assert.assertTrue(bdapiContents.get(1).getId() == "2");
                Assert.assertTrue(bdapiEvent.getCustomData().getBillingContact().getEmail() == "bbb@fb.com");
                Assert.assertTrue(bdapiEvent.getCustomData().getShippingContact().getEmail() == "ccc@fb.com");

                com.facebook.ads.sdk.serverside.EventRequest capiEventRequest = eventRequest
                                .getServerSideEventRequest();
                com.facebook.ads.sdk.serverside.Event capiEvent = capiEventRequest.getData().get(0);
                Assert.assertTrue(capiEventRequest.getPartnerAgent() == "partnerAgent");
                Assert.assertTrue(capiEvent.getEventName() == "Purchase");
                Assert.assertTrue(capiEvent.getEventTime() == 123124125L);
                Assert.assertTrue(capiEvent.getDataProcessingOptions().length == 0);
                Assert.assertTrue(capiEvent.getUserData().getEmail() == "aaa@fb.com");
                Assert.assertTrue(capiEvent.getCustomData().getValue() == 123.45F);
                List<com.facebook.ads.sdk.serverside.Content> capiContents = capiEvent.getCustomData().getContents();
                Assert.assertTrue(capiContents.get(0).getProductId() == "1");
                Assert.assertTrue(capiContents.get(1).getProductId() == "2");
                Assert.assertTrue(capiContents.get(1).getBrand() == "brand");
                Assert.assertTrue(capiEvent.getCustomData().getCustomProperties().get("Key1") == "Value1");

                // check JSON data
                String bdapiDataJSON = (new Gson()).toJson(bdapiEventRequest.getData());
                String bdapiContentsJSON = (new Gson()).toJson(bdapiContents);
                Assert.assertTrue(bdapiDataJSON.contains(bdapiContentsJSON));
                Assert.assertTrue(bdapiDataJSON.contains("\"event_name\":\"Purchase\""));

                String capiDataJSON = (new Gson()).toJson(capiEventRequest.getData());
                String customPropertiesJSON = (new Gson()).toJson(customProperties);
                Assert.assertTrue(capiDataJSON
                                .contains(customPropertiesJSON.substring(1, customPropertiesJSON.length() - 1)));
        }
}
