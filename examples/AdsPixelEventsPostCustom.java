/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

 import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.serverside.Event;
import com.facebook.ads.sdk.serverside.EventRequest;
import com.facebook.ads.sdk.serverside.EventResponse;
import com.facebook.ads.sdk.serverside.UserData;
import com.facebook.ads.sdk.serverside.CustomData;

public class ServerSideApiExample {

  public static final String ACCESS_TOKEN = "<ACCESS_TOKEN>";
  public static final String PIXEL_ID = "<ADS_PIXEL_ID>";

  public static void main(String[] args) {
    APIContext context = new APIContext(ACCESS_TOKEN).enableDebug(true);
    context.setLogger(System.out);

    UserData userData = new UserData()
        .fbc("fb.1.1554763741205.AbCdEfGhIjKlMnOpQrStUvWxYz1234567890")
        .fbp("fb.1.1558571054389.1098115397")
        .email("joe@eg.com");

    CustomData customData = new CustomData()
        .currency("usd")
        .value(123.45F);

    Event pageViewEvent = new Event();
    pageViewEvent.eventName("Purchase")
        .eventTime(System.currentTimeMillis() / 1000L)
        .userData(userData)
        .customData(customData);

    EventRequest eventRequest = new EventRequest(PIXEL_ID, context);
    eventRequest.addDataItem(pageViewEvent);

    try {
      EventResponse response = eventRequest.execute();
      System.out.println(String.format("Standard API response : %s ", response));
    } catch (APIException e) {
      e.printStackTrace();
    }
  }
}