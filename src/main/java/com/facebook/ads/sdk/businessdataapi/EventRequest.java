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
package com.facebook.ads.sdk.businessdataapi;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.Page;
import com.facebook.ads.sdk.APINode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Server side pixel event request
 */
public class EventRequest {

    @SerializedName("data")
    private List<Event> data = new ArrayList<Event>();

    @SerializedName("partner_agent")
    private String partnerAgent = null;

    private String pageId;
    private APIContext context;

    /**
     * Constructor.
     *
     * @param pageId  Ad pixel id
     * @param context Api context
     */
    public EventRequest(String pageId, APIContext context) {
        this.pageId = pageId;
        this.context = context;
    }

    /**
     * Constructor.
     *
     * @param pageId       Page id
     * @param context      Api context
     * @param data         list of event
     * @param partnerAgent A value that represents the platform that is sending the
     *                     event
     */
    public EventRequest(String pageId, APIContext context, List<Event> data, String partnerAgent) {
        this.data = data;
        this.partnerAgent = partnerAgent;
        this.pageId = pageId;
        this.context = context;
    }

    /**
     * @return Gson
     */
    public Gson getGson() {
        return new GsonBuilder().excludeFieldsWithModifiers(Modifier.STATIC)
                .excludeFieldsWithModifiers(Modifier.PROTECTED).disableHtmlEscaping().create();
    }

    /**
     * Set a list of Business Data Event objects
     *
     * @param data list of Server Event
     * @return EventRequest
     */
    public EventRequest data(List<Event> data) {
        this.data = data;
        return this;
    }

    /**
     * A list of Business Data Event objects
     *
     * @return data
     */
    public List<Event> getData() {
        return data;
    }

    /**
     * Set a list of Business Data Event objects
     *
     * @param data list of Business Data Event
     */
    public void setData(List<Event> data) {
        this.data = data;
    }

    /**
     * Sets a value that represents the platform that is sending the event.
     *
     * @param partnerAgent a value that represents the platform that is sending the
     *                     event
     * @return EventRequest
     */
    public EventRequest partnerAgent(String partnerAgent) {
        this.partnerAgent = partnerAgent;
        return this;
    }

    /**
     * A value that represents the platform that is sending the event.
     *
     * @return partnerAgent
     */
    public String getPartnerAgent() {
        return partnerAgent;
    }

    /**
     * Set a value that represents the platform that is sending the event.
     *
     * @param partnerAgent a value that represents the platform that is sending the
     *                     event
     */
    public void setPartnerAgent(String partnerAgent) {
        this.partnerAgent = partnerAgent;
    }

    /**
     * Synchronously send Event to Facebook GraphAPI.
     *
     * @return event response
     * @throws APIException Api Exception
     */
    public EventResponse execute() throws APIException {
        try {
            Page.APIRequestCreateBusinessDatum request = new Page.APIRequestCreateBusinessDatum(pageId, context);
            request.setData(getGson().toJson(getData()));
            request.setPartnerAgent(getPartnerAgent());
            APINode event = request.execute();
            EventResponse response = getGson().fromJson(event.getRawResponse(), EventResponse.class);

            context.log(String.format("Successfully sent %d event(s)", response.getEventsReceived()));
            return response;
        } catch (APIException e) {
            context.log(e.getMessage());
            throw e;
        }
    }
}
