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
        .lead_id("525645896321548");

    Map<String, String> propertyBag = new HashMap<>();
    propertyBag.put("lead_event_source", "Salesforce");

    CustomData customData = new CustomData()
        .customProperties(propertyBag);

    Event purchaseEvent = new Event();
    purchaseEvent.eventName("QualifiedLead")
        .eventTime(System.currentTimeMillis() / 1000L)
        .userData(userData)
        .customData(customData)
        .actionSource(ActionSource.system_generated);

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