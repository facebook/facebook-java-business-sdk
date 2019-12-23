/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to use, copy, modify, and
 * distribute this software in source code or binary form for use in connection with the web
 * services and APIs provided by Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use of this software is
 * subject to the Facebook Developer Principles and Policies [http://developers.facebook.com/policy/].
 * This copyright notice shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.serverside.Event;
import com.facebook.ads.sdk.serverside.EventRequest;
import com.facebook.ads.sdk.serverside.EventResponse;
import com.facebook.ads.sdk.serverside.GenderEnum;
import com.facebook.ads.sdk.serverside.UserData;

public class ServerSideApiExample {

  // Set your access token and pixel id
  public static final String ACCESS_TOKEN = null;
  public static final String PIXEL_ID = null;

  public static void main(String[] args) throws Exception {

    if (ACCESS_TOKEN == null || PIXEL_ID == null) {
      throw new Exception("ACCESS_TOKEN and PIXEL_ID are required fields.");
    }

    APIContext context = new APIContext(ACCESS_TOKEN);
    context.setLogger(System.out);

    EventRequest eventRequest = new EventRequest(PIXEL_ID, context);
    Event event = new Event();
    event.eventName("Lead")
        .eventTime(System.currentTimeMillis() / 1000L);

    UserData userData = (new UserData())
        .email("joe@eg.com")
        .phone("16505551212")
        .zipcode("94035")
        .gender(GenderEnum.FEMALE);

    event.setUserData(userData);
    eventRequest.addDataItem(event);

    try {
      // Create Server-Side event request and execute.
      EventResponse response = eventRequest.execute();
      System.out.println(String.format("Server-Side API response : %s ", response));
    } catch (APIException e) {
      e.printStackTrace();
    }
  }

}
