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
package com.facebook.ads.sdk.businessdataapi;

import com.google.gson.annotations.SerializedName;

/**
 * Server side pixel event response.
 */

public class EventResponse {

    @SerializedName("events_received")
    private Integer eventsReceived;

    @SerializedName("events_dropped")
    private Integer eventsDropped;

    @SerializedName("message")
    private Message[] message;

    /**
     * Default Constructor.
     */
    public EventResponse() {
    }

    /**
     * Constructor.
     *
     * @param eventsReceived number of events received
     * @param eventsDropped  number of events dropped
     * @param message        response message
     */
    public EventResponse(Integer eventsReceived, Integer eventsDropped, Message[] message) {
        this.eventsReceived = eventsReceived;
        this.eventsDropped = eventsDropped;
        this.message = message;
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
     * Set number of events dropped.
     *
     * @param eventsDropped number of events dropped
     * @return EventResponse
     */
    public EventResponse eventsDropped(Integer eventsDropped) {
        this.eventsDropped = eventsDropped;
        return this;
    }

    /**
     * Get eventsDropped
     *
     * @return eventsDropped
     **/
    public Integer getEventsDropped() {
        return eventsDropped;
    }

    /**
     * Set number of events dropped.
     *
     * @param eventsDropped number of events dropped
     */
    public void setEventsDropped(Integer eventsDropped) {
        this.eventsDropped = eventsDropped;
    }

    /**
     * Set response message.
     *
     * @param message response message
     * @return EventResponse
     */
    public EventResponse message(Message[] message) {
        this.message = message;
        return this;
    }

    /**
     * Get response message
     *
     * @return message
     **/
    public Message[] getMessage() {
        return message;
    }

    /**
     * Set response message.
     *
     * @param message response message
     */
    public void setMessage(Message[] message) {
        this.message = message;
    }

}
