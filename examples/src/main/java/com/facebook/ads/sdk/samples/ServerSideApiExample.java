/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 * <p>
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to use, copy, modify, and
 * distribute this software in source code or binary form for use in connection with the web
 * services and APIs provided by Facebook.
 * <p>
 * As with any software that integrates with the Facebook platform, your use of this software is
 * subject to the Facebook Developer Principles and Policies [http://developers.facebook.com/policy/].
 * This copyright notice shall be included in all copies or substantial portions of the software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.facebook.ads;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.serverside.CustomData;
import com.facebook.ads.sdk.serverside.Event;
import com.facebook.ads.sdk.serverside.EventResponse;
import com.facebook.ads.sdk.serverside.GenderEnum;
import com.facebook.ads.sdk.serverside.Content;
import com.facebook.ads.sdk.serverside.EventRequest;
import com.facebook.ads.sdk.serverside.UserData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

public class ServerSideApiExample {

  public static final String ACCESS_TOKEN = "<INSERT_ACCESS_TOKEN>";
  public static final String PIXEL_ID = "<INSERT_PIXEL_ID>";

  public static void main(String[] args) throws InterruptedException, ExecutionException {

    APIContext context = new APIContext(ACCESS_TOKEN).enableDebug(true);
    context.setLogger(System.out);

    EventRequest eventRequest = new EventRequest(PIXEL_ID, context);
    Event event = new Event();
    event.eventName("SDK-TestEventType")
        .eventTime(System.currentTimeMillis() / 1000L)
        .eventId("event-id-1");

    UserData userData = (new UserData())
        .email("test@test.com")
        .phone("1234567890")
        .zipcode("98001")
        .gender(GenderEnum.FEMALE);

    event.setUserData(userData);

    eventRequest.addDataItem(event);

    try {
      EventResponse response = eventRequest.execute();
      System.out.println(String.format("Standard API response : %s ", response));
      ListenableFuture<EventResponse> asyncResponse = eventRequest.executeAsync();
      System.out.println(String.format("Async API response : %s ", asyncResponse.get()));
    } catch (APIException e) {
      e.printStackTrace();
    }
  }
}
