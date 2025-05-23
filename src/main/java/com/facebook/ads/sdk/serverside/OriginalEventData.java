/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * <p>You are hereby granted a non-exclusive, worldwide, royalty-free license to use, copy, modify,
 * and distribute this software in source code or binary form for use in connection with the web
 * services and APIs provided by Facebook.
 *
 * <p>As with any software that integrates with the Facebook platform, your use of this software is
 * subject to the Facebook Developer Principles and Policies [http://developers.facebook.com/policy/].
 * This copyright notice shall be included in all copies or substantial portions of the software.
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.facebook.ads.sdk.serverside;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/**
 * OriginalEventData contains original event info used for attribution passback event or generalized value optimization(GVO).
 */

public class OriginalEventData {
    
  @SerializedName("event_name")
  private String eventName = null;

  @SerializedName("event_time")
  private Long eventTime = null;

  @SerializedName("order_id")
  private String orderID = null;

  @SerializedName("event_id")
  private String eventID = null;

  /**
   * Default Constructor.
   */
  public OriginalEventData() {
  }

  /**
   * Constructor.
   *
   * @param eventName Meta pixel Standard Event or Custom Event name.
   * @param eventTime Unix timestamp in seconds indicating when the original event occurred.
   * @param orderID The order ID for this transaction as a string.
   * @param eventID A unique string chosen by the advertiser.
   */
  public OriginalEventData(String eventName, Long eventTime, String orderID, String eventID) {
    this.eventName = eventName;
    this.eventTime = eventTime;
    this.orderID = orderID;
    this.eventID = eventID;
  }

  /**
   * Set Meta pixel Standard Event or Custom Event name.
   *
   * @param eventName Meta pixel Standard Event or Custom Event name.
   * @return OriginalEventData
   */
  public OriginalEventData eventName(String eventName) {
    this.eventName = eventName;
    return this;
  }

  /**
   * Get Meta pixel Standard Event or Custom Event name.
   *
   * @return eventName
   */
  public String getEventName() {
    return eventName;
  }

  /**
   * Set Meta pixel Standard Event or Custom Event name.
   *
   * @param eventName Meta pixel Standard Event or Custom Event name.
   */
  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  /**
   * Set Unix timestamp in seconds indicating when the original event occurred.
   *
   * @param eventTime Unix timestamp in seconds indicating when the original event occurred
   * @return OriginalEventData
   */
  public OriginalEventData eventTime(Long eventTime) {
    this.eventTime = eventTime;
    return this;
  }

  /**
   * Get Unix timestamp in seconds indicating when the original event occurred.
   *
   * @return eventTime
   */
  public Long getEventTime() {
    return eventTime;
  }

  /**
   * Set Unix timestamp in seconds indicating when the original event occurred.
   *
   * @param eventTime Unix timestamp in seconds indicating when the original event occurred
   */
  public void setEventTime(Long eventTime) {
    this.eventTime = eventTime;
  }

  /**
   * Set the order_id of original Event.
   *
   * @param orderID The order ID for this transaction as a string.
   * @return OriginalEventData
   */
  public OriginalEventData orderID(String orderID) {
    this.orderID = orderID;
    return this;
  }

  /**
   * Get the order_id of original Event.
   *
   * @return orderID
   */
  public String getOrderID() {
    return orderID;
  }

  /**
   * Set the order_id of original Event.
   *
   * @param orderID The order ID for this transaction as a string.
   */
  public void setOrderID(String orderID) {
    this.orderID = orderID;
  }

  /**
   * Set the event_id of original Event.
   *
   * @param eventID A unique string chosen by the advertiser.
   * @return OriginalEventData
   */
  public OriginalEventData eventID(String eventID) {
    this.eventID = eventID;
    return this;
  }

  /**
   * Get the event_id of original Event.
   *
   * @return event_id
   */
  public String getEventID() {
    return eventID;
  }

  /**
   * Set the event_id of original Event.
   *
   * @param eventID A unique string chosen by the advertiser.
   */
  public void setEventID(String eventID) {
    this.eventID = eventID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OriginalEventData originalEvent = (OriginalEventData) o;
    return Objects.equals(this.eventName, originalEvent.eventName)
        && Objects.equals(this.eventTime, originalEvent.eventTime)
        && Objects.equals(this.orderID, originalEvent.orderID)
        && Objects.equals(this.eventID, originalEvent.eventID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventName, eventTime, orderID, eventID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OriginalEventData {\n");
    sb.append("    eventName: ").append(toIndentedString(eventName)).append("\n");
    sb.append("    eventTime: ").append(toIndentedString(eventTime)).append("\n");
    sb.append("    orderID: ").append(toIndentedString(orderID)).append("\n");
    sb.append("    eventID: ").append(toIndentedString(eventID)).append("\n");
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
