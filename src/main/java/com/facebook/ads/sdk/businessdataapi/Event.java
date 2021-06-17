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

import com.google.gson.annotations.SerializedName;

public class Event {
    @SerializedName("event_name")
    private String eventName = null;

    @SerializedName("event_time")
    private Long eventTime = null;

    @SerializedName("event_id")
    private String eventId = null;

    @SerializedName("user_data")
    private UserData userData = null;

    @SerializedName("custom_data")
    private CustomData customData = null;

    @SerializedName("data_processing_options")
    private String[] dataProcessingOptions = null;

    @SerializedName("data_processing_options_country")
    private Integer dataProcessingOptionsCountry = null;

    @SerializedName("data_processing_options_state")
    private Integer dataProcessingOptionsState = null;

    /**
     * Default Constructor.
     */
    public Event() {
    }

    /**
     * @param eventName                    A Facebook pixel Standard Event or Custom
     *                                     Event name.
     * @param eventTime                    A Unix timestamp in seconds indicating
     *                                     when the actual event occurred.
     * @param eventId                      This ID can be any string chosen by the
     *                                     advertiser.
     * @param userData                     A map that contains user data. See
     *                                     UserData Class for options.
     * @param customData                   A map that contains user data. See
     *                                     CustomData Class for options.
     * @param dataProcessingOptions        Processing options you would like to
     *                                     enable for a specific event.
     * @param dataProcessingOptionsCountry A country that you want to associate to
     *                                     this data processing option.
     * @param dataProcessingOptionsState   A state that you want to associate with
     *                                     this data processing option.
     */
    public Event(String eventName, Long eventTime, String eventId, UserData userData, CustomData customData,
            String[] dataProcessingOptions, Integer dataProcessingOptionsCountry, Integer dataProcessingOptionsState) {
        this.eventName = eventName;
        this.eventTime = eventTime;
        this.eventId = eventId;
        this.userData = userData;
        this.customData = customData;
        this.dataProcessingOptions = dataProcessingOptions;
        this.dataProcessingOptionsCountry = dataProcessingOptionsCountry;
        this.dataProcessingOptionsState = dataProcessingOptionsState;
    }

    /**
     * Gets the Event Name for the current Event.
     *
     * @return eventName
     */
    public String getEventName() {
        return this.eventName;
    }

    /**
     * Sets the Event Name for the current Event.
     *
     * @param eventName a Facebook pixel Standard Event or Custom Event name.
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Sets the Event Name for the current Event.
     *
     * @param eventName a Facebook pixel Standard Event or Custom Event name.
     * @return Event
     */
    public Event eventName(String eventName) {
        this.eventName = eventName;
        return this;
    }

    /**
     * Gets the Event Time when the current Event happened.
     *
     * @return eventTime
     */
    public Long getEventTime() {
        return this.eventTime;
    }

    /**
     * Sets the Event Time when the current Event happened.
     *
     * @param eventTime is a Unix timestamp in seconds indicating when the actual
     *                  event occurred.
     */
    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }

    /**
     * Sets the Event Time when the current Event happened.
     *
     * @param eventTime is a Unix timestamp in seconds indicating when the actual
     *                  event occurred.
     * @return Event
     */
    public Event eventTime(Long eventTime) {
        this.eventTime = eventTime;
        return this;
    }

    /**
     * Gets the eventId for the current Event.
     *
     * @return eventId
     */
    public String getEventId() {
        return this.eventId;
    }

    /**
     * Sets the event Id for the current Event.
     *
     * @param eventId Unique id for the event.
     */
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    /**
     * Sets the event Id for the current Event.
     *
     * @param eventId Unique id for the event.
     * @return Event
     */
    public Event eventId(String eventId) {
        this.eventId = eventId;
        return this;
    }

    /**
     * Gets the user data object for the current Event.
     *
     * @return UserData
     */
    public UserData getUserData() {
        return this.userData;
    }

    /**
     * Sets the user data object for the current Event.
     *
     * @param userData userData is an object that contains user data.
     */
    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    /**
     * Sets the user data object for the current Event.
     *
     * @param userData userData is an object that contains user data.
     * @return Event
     */
    public Event userData(UserData userData) {
        this.userData = userData;
        return this;
    }

    /**
     * Gets the custom data object for the current Event.
     *
     * @return customData
     */
    public CustomData getCustomData() {
        return this.customData;
    }

    /**
     * Sets the custom data object for the current Event.
     *
     * @param customData is an object that includes additional business data about
     *                   the event.
     */
    public void setCustomData(CustomData customData) {
        this.customData = customData;
    }

    /**
     * Sets the custom data object for the current Event.
     *
     * @param customData is an object that includes additional business data about
     *                   the event.
     * @return Event
     */
    public Event customData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    /**
     * Gets the dataProcessingOptions for the current event. Processing options you
     * would like to enable for a specific event.
     *
     * @return dataProcessingOptions
     */
    public String[] getDataProcessingOptions() {
        return this.dataProcessingOptions;
    }

    /**
     * Sets the dataProcessingOptions for the current event.
     *
     * @param dataProcessingOptions represents Data processing options you would
     *                              like to enable for a specific event, e.g. [] or
     *                              ['LDU']
     */
    public void setDataProcessingOptions(String[] dataProcessingOptions) {
        this.dataProcessingOptions = dataProcessingOptions;
    }

    /**
     * Sets the dataProcessingOptions for the current event.
     *
     * @param dataProcessingOptions represents Data processing options you would
     *                              like to enable for a specific event, e.g. [] or
     *                              ['LDU']
     * @return Event
     */
    public Event dataProcessingOptions(String[] dataProcessingOptions) {
        this.dataProcessingOptions = dataProcessingOptions;
        return this;
    }

    /**
     * Gets the dataProcessingOptionsCountry for the current event. A country that
     * you want to associate to this data processing option.
     *
     * @return dataProcessingOptionsCountry
     */
    public Integer getDataProcessingOptionsCountry() {
        return this.dataProcessingOptionsCountry;
    }

    /**
     * Sets the dataProcessingOptionsCountry for the current event.
     *
     * @param dataProcessingOptionsCountry represents country that you want to
     *                                     associate to this data processing option.
     */
    public void setDataProcessingOptionsCountry(Integer dataProcessingOptionsCountry) {
        this.dataProcessingOptionsCountry = dataProcessingOptionsCountry;
    }

    /**
     * Sets the dataProcessingOptionsCountry for the current event.
     *
     * @param dataProcessingOptionsCountry represents country that you want to
     *                                     associate to this data processing option.
     * @return Event
     */
    public Event dataProcessingOptionsCountry(Integer dataProcessingOptionsCountry) {
        this.dataProcessingOptionsCountry = dataProcessingOptionsCountry;
        return this;
    }

    /**
     * Gets the dataProcessingOptionsState for the current event. A state that you
     * want to associate with this data processing option.
     *
     * @return dataProcessingOptionsState
     */
    public Integer getDataProcessingOptionsState() {
        return this.dataProcessingOptionsState;
    }

    /**
     * Sets the dataProcessingOptionsState for the current event.
     *
     * @param dataProcessingOptionsState represents state that you want to associate
     *                                   with this data processing option.
     */
    public void setDataProcessingOptionsState(Integer dataProcessingOptionsState) {
        this.dataProcessingOptionsState = dataProcessingOptionsState;
    }

    /**
     * Sets the dataProcessingOptionsState for the current event.
     *
     * @param dataProcessingOptionsState represents state that you want to associate
     *                                   with this data processing option.
     * @return Event
     */
    public Event dataProcessingOptionsState(Integer dataProcessingOptionsState) {
        this.dataProcessingOptionsState = dataProcessingOptionsState;
        return this;
    }

}
