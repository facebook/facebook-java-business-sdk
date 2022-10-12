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
package com.facebook.ads.sdk.serverside;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;

/**
 * Server side pixel event response.
 */

public class EventResponse {

  @SerializedName("events_received")
  private Integer eventsReceived = null;

  @SerializedName("messages")
  private List<String> messages = null;

  @SerializedName("fbtrace_id")
  private String fbTraceId = null;

  @SerializedName("custom_endpoint_responses")
  private Map<String, CustomEndpointResponse> customEndpointResponses;

  /**
   * Default Constructor.
   */
  public EventResponse() {
  }

  /**
   * Constructor.
   *
   * @param eventsReceived number of events received
   * @param messages response messages
   * @param fbTraceId Facebook trace id
   */
  public EventResponse(Integer eventsReceived, List<String> messages, String fbTraceId) {
    this.eventsReceived = eventsReceived;
    this.messages = messages;
    this.fbTraceId = fbTraceId;
    this.customEndpointResponses = new HashMap();
  }

  /**
   * Set number of events received.
   *
   * @param eventsReceived number of events received
   * @return EventResponse
   */
  public EventResponse eventsReceived(Integer eventsReceived) {
    this.eventsReceived = eventsReceived;
    return this;
  }

  /**
   * Get eventsReceived
   *
   * @return eventsReceived
   **/
  public Integer getEventsReceived() {
    return eventsReceived;
  }

  /**
   * Set number of events received.
   *
   * @param eventsReceived number of events received
   */
  public void setEventsReceived(Integer eventsReceived) {
    this.eventsReceived = eventsReceived;
  }

  /**
   * Set response messages.
   *
   * @param messages response messages
   * @return EventResponse
   */
  public EventResponse messages(List<String> messages) {
    this.messages = messages;
    return this;
  }

  /**
   * Add response message.
   *
   * @param messagesItem response messages
   * @return EventResponse
   */
  public EventResponse addMessagesItem(String messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<String>();
    }
    this.messages.add(messagesItem);
    return this;
  }

  /**
   * Set responses that map to each custom endpoint that we sent the events to.
   *
   * @param customEndpointResponses Map of requests to endpoints
   */

  public void setCustomEndpointResponses(Map<String, CustomEndpointResponse> customEndpointResponses) {
    this.customEndpointResponses = customEndpointResponses;
  }

  /**
   * Gets a map that maps each response to each custom endpoint that we sent the events to.
   *
   * @return customEndpointResponses Map of requests to endpoints
   */

  public Map<String, CustomEndpointResponse> getCustomEndpointResponses() {
    return customEndpointResponses;
  }


  /**
   * Get response messages
   *
   * @return messages
   **/
  public List<String> getMessages() {
    return messages;
  }

  /**
   * Set response messages.
   *
   * @param messages response messages
   */
  public void setMessages(List<String> messages) {
    this.messages = messages;
  }

  /**
   * Get Facebook trace id
   *
   * @return trace id
   */
  public String getFbTraceId() {
    return fbTraceId;
  }

  /**
   * Set Facebook trace id
   *
   * @param fbTraceId Facebook trace id
   */
  public void setFbTraceId(String fbTraceId) {
    this.fbTraceId = fbTraceId;
  }

  /**
   * Set Facebook trace id
   *
   * @param fbTraceId Facebook trace id
   * @return EventResponse
   */
  public EventResponse fbTraceId(String fbTraceId) {
    this.fbTraceId = fbTraceId;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventResponse eventResponseSucess = (EventResponse) o;
    return Objects.equals(this.eventsReceived, eventResponseSucess.eventsReceived) &&
        Objects.equals(this.fbTraceId, eventResponseSucess.fbTraceId) &&
        Objects.equals(this.messages, eventResponseSucess.messages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventsReceived, messages);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventResponse {\n");

    sb.append("    eventsReceived: ").append(toIndentedString(eventsReceived)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
    sb.append("    fbTraceId: ").append(toIndentedString(fbTraceId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first
   * line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
