/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
 */

 import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.serverside.ActionSource;
import com.facebook.ads.sdk.serverside.Content;
import com.facebook.ads.sdk.serverside.CustomData;
import com.facebook.ads.sdk.serverside.DeliveryCategory;
import com.facebook.ads.sdk.serverside.Event;
import com.facebook.ads.sdk.serverside.EventRequest;
import com.facebook.ads.sdk.serverside.EventResponse;
import com.facebook.ads.sdk.serverside.UserData;

import java.util.Arrays;

public class ServerSideApiExample {

  public static final String ACCESS_TOKEN = "<ACCESS_TOKEN>";
  public static final String PIXEL_ID = "<ADS_PIXEL_ID>";

  public static void main(String[] args) {
    APIContext context = new APIContext(ACCESS_TOKEN).enableDebug(true);
    context.setLogger(System.out);

    UserData userData = new UserData()
        .emails(Arrays.asList("joe@eg.com"))
        .phones(Arrays.asList("12345678901", "14251234567"))
        // It is recommended to send Client IP and User Agent for Conversions API Events.
        .clientIpAddress(clientIpAddress)
        .clientUserAgent(clientUserAgent)
        .fbc("fb.1.1554763741205.AbCdEfGhIjKlMnOpQrStUvWxYz1234567890")
        .fbp("fb.1.1558571054389.1098115397");

    Content content = new Content()
        .productId("product123")
        .quantity(1L)
        .deliveryCategory(DeliveryCategory.home_delivery);

    CustomData customData = new CustomData()
        .addContent(content)
        .currency("usd")
        .value(123.45F);

    Event purchaseEvent = new Event();
    purchaseEvent.eventName("Purchase")
        .eventTime(System.currentTimeMillis() / 1000L)
        .userData(userData)
        .customData(customData)
        .eventSourceUrl("http://jaspers-market.com/product/123")
        .actionSource(ActionSource.website);

    EventRequest eventRequest = new EventRequest(PIXEL_ID, context);
    eventRequest.addDataItem(purchaseEvent);

    try {
      EventResponse response = eventRequest.execute();
      System.out.println(String.format("Standard API response : %s ", response));
    } catch (APIException e) {
      e.printStackTrace();
    }
  }
}