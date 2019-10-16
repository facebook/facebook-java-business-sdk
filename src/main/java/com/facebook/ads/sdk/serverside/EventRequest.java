/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * <p>You are hereby granted a non-exclusive, worldwide, royalty-free license to use, copy, modify,
 * and distribute this software in source code or binary form for use in connection with the web
 * services and APIs provided by Facebook.
 *
 * <p>As with any software that integrates with the Facebook platform, your use of this software is
 * subject to the Facebook Developer Principles and Policies
 * [http://developers.facebook.com/policy/]. This copyright notice shall be included in all copies
 * or substantial portions of the software.
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.facebook.ads.sdk.serverside;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.AdsPixel;
import com.facebook.ads.sdk.AdsPixel.APIRequestCreateEvent;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Server side pixel event request */
public class EventRequest {

  private static Gson gson = null;

  @SerializedName("data")
  private List<Event> data = new ArrayList<Event>();

  @SerializedName("test_event_code")
  private String testEventCode = null;

  private String pixelId;
  private APIContext context;

  public EventRequest(String pixelId, APIContext context) {
    this.pixelId = pixelId;
    this.context = context;
  }

  static /*package*/ synchronized Gson getGson() {
    if (gson != null) {
      return gson;
    } else {
      gson =
          new GsonBuilder()
              .excludeFieldsWithModifiers(Modifier.STATIC)
              .excludeFieldsWithModifiers(Modifier.PROTECTED)
              .disableHtmlEscaping()
              .create();
    }

    return gson;
  }

  /**
   * Set a list of Server Event objects
   *
   * @return EventRequest
   */
  public EventRequest data(List<Event> data) {
    this.data = data;
    return this;
  }

  /**
   * Add a Server Event object
   *
   * @return data
   */
  public EventRequest addDataItem(Event dataItem) {
    this.data.add(dataItem);
    return this;
  }

  /**
   * A list of Server Event objects
   *
   * @return data
   */
  public List<Event> getData() {
    return data;
  }

  /** Set a list of Server Event objects */
  public void setData(List<Event> data) {
    this.data = data;
  }

  /**
   * Set code used to verify that your server events are received correctly by Facebook. Use this
   * code to test your server events in the Test Events feature in Events Manager. See Test Events
   * Tool
   * (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/using-the-api#testEvents)
   * for an example.
   *
   * @return EventRequest
   */
  public EventRequest testEventCode(String testEventCode) {
    this.testEventCode = testEventCode;
    return this;
  }

  /**
   * Code used to verify that your server events are received correctly by Facebook. Use this code
   * to test your server events in the Test Events feature in Events Manager. See Test Events Tool
   * (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/using-the-api#testEvents)
   * for an example.
   *
   * @return testEventCode
   */
  public String getTestEventCode() {
    return testEventCode;
  }

  /**
   * Set code used to verify that your server events are received correctly by Facebook. Use this
   * code to test your server events in the Test Events feature in Events Manager. See Test Events
   * Tool
   * (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/using-the-api#testEvents)
   * for an example.
   */
  public void setTestEventCode(String testEventCode) {
    this.testEventCode = testEventCode;
  }

  /**
   * Synchronously send Event to Facebook GraphAPI.
   *
   * @return ListenableFuture<EventResponse>
   * @throws APIException
   */
  public EventResponse execute() throws APIException {
    APIRequestCreateEvent event = getPixelCreateEvent();
    EventResponse response = null;
    try {
      AdsPixel pixel = event.execute();
      response = gson.fromJson(pixel.getRawResponse(), EventResponse.class);
      context.log(String.format("Successfully sent %d event(s)", response.getEventsReceived()));
      return response;
    } catch (APIException e) {
      context.log(e.getMessage());
      throw e;
    }
  }

  /**
   * Asynchronously send Event to Facebook GraphAPI.
   *
   * @return ListenableFuture<EventResponse>
   * @throws APIException
   */
  public ListenableFuture<EventResponse> executeAsync() throws APIException {
    AdsPixel.APIRequestCreateEvent event = getPixelCreateEvent();
    ListenableFuture<EventResponse> response = null;
    try {
      ListenableFuture<AdsPixel> pixelFuture = event.executeAsync();

      response =
          Futures.transformAsync(
              pixelFuture,
              new AsyncFunction<AdsPixel, EventResponse>() {
                public ListenableFuture<EventResponse> apply(AdsPixel pixel) {
                  EventResponse eventResponse =
                      gson.fromJson(pixel.getRawResponse(), EventResponse.class);
                  context.log(
                      String.format(
                          "Successfully sent %d event(s)", eventResponse.getEventsReceived()));
                  return Futures.immediateFuture(eventResponse);
                }
              });
      return response;
    } catch (APIException e) {
      context.log(e.getMessage());
      throw e;
    }
  }

  private AdsPixel.APIRequestCreateEvent getPixelCreateEvent() {
    AdsPixel.APIRequestCreateEvent event = new AdsPixel.APIRequestCreateEvent(pixelId, context);

    event.setData(getGson().toJson(getData()));
    if (getTestEventCode() != null) {
      event.setTestEventCode(getTestEventCode());
    }
    return event;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventRequest eventRequest = (EventRequest) o;
    return Objects.equals(this.data, eventRequest.data)
        && Objects.equals(this.testEventCode, eventRequest.testEventCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, testEventCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventRequest {\n");

    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    testEventCode: ").append(toIndentedString(testEventCode)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
