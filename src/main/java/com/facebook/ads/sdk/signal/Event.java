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
package com.facebook.ads.sdk.signal;

public class Event {

    private com.facebook.ads.sdk.serverside.Event serverSideEvent = new com.facebook.ads.sdk.serverside.Event();
    private com.facebook.ads.sdk.businessdataapi.Event businessDataEvent = new com.facebook.ads.sdk.businessdataapi.Event();

    public Event() {
    }

    /**
     * @param eventName                    A Facebook pixel Standard Event or Custom
     *                                     Event name.
     * @param eventTime                    A Unix timestamp in seconds indicating
     *                                     when the actual event occurred.
     * @param eventSourceUrl               The browser URL where the event happened.
     * @param eventId                      This ID can be any string chosen by the
     *                                     advertiser.
     * @param optOut                       A flag that indicates we should not use
     *                                     this event for ads delivery optimization.
     * @param userData                     SignalUserData contains user data for
     *                                     both Business Data API and Conversion API
     * @param customData                   SignalCustomData contains custom data for
     *                                     both Business Data API and Conversion API
     * @param dataProcessingOptions        Processing options you would like to
     *                                     enable for a specific event.
     * @param dataProcessingOptionsCountry A country that you want to associate to
     *                                     this data processing option.
     * @param dataProcessingOptionsState   A state that you want to associate with
     *                                     this data processing option.
     */
    public Event(String eventName, Long eventTime, String eventSourceUrl, Boolean optOut, String eventId,
            UserData userData, CustomData customData, String[] dataProcessingOptions,
            Integer dataProcessingOptionsCountry, Integer dataProcessingOptionsState) {
        this.businessDataEvent.setEventName(eventName);
        this.businessDataEvent.setEventTime(eventTime);
        this.businessDataEvent.setEventId(eventId);
        this.businessDataEvent.setUserData(userData.getBusinessDataUserData());
        this.businessDataEvent.setCustomData(customData.getBusinessDataCustomData());
        this.businessDataEvent.setDataProcessingOptions(dataProcessingOptions);
        this.businessDataEvent.setDataProcessingOptionsCountry(dataProcessingOptionsCountry);
        this.businessDataEvent.setDataProcessingOptionsState(dataProcessingOptionsState);

        this.serverSideEvent.setEventName(eventName);
        this.serverSideEvent.setEventTime(eventTime);
        this.serverSideEvent.setEventSourceUrl(eventSourceUrl);
        this.serverSideEvent.setOptOut(optOut);
        this.serverSideEvent.setEventId(eventId);
        this.serverSideEvent.setUserData(userData.getServerSideUserData());
        this.serverSideEvent.setCustomData(customData.getServerSideCustomData());
        this.serverSideEvent.setDataProcessingOptions(dataProcessingOptions);
        this.serverSideEvent.setDataProcessingOptionsCountry(dataProcessingOptionsCountry);
        this.serverSideEvent.setDataProcessingOptionsState(dataProcessingOptionsState);
    }

    /**
     * Gets the Event Name for the current Event.
     *
     * @return EventName
     */
    public SignalResponse<String, String> getEventName() {
        return new SignalResponse<String, String>(this.serverSideEvent.getEventName(),
                this.businessDataEvent.getEventName());
    }

    /**
     * Sets the Event Name for the current Event.
     *
     * @param eventName a Facebook pixel Standard Event or Custom Event name.
     */
    public void setEventName(String eventName) {
        this.serverSideEvent.setEventName(eventName);
        this.businessDataEvent.setEventName(eventName);
    }

    /**
     * Sets the Event Name for the current Event.
     *
     * @param eventName Facebook pixel Standard Event or Custom Event name.
     * @return Event
     */
    public Event eventName(String eventName) {
        this.serverSideEvent.setEventName(eventName);
        this.businessDataEvent.setEventName(eventName);
        return this;
    }

    /**
     * Gets the Event Time when the current Event happened.
     *
     * @return EventTime
     */
    public SignalResponse<Long, Long> getEventTime() {
        return new SignalResponse<Long, Long>(this.serverSideEvent.getEventTime(),
                this.businessDataEvent.getEventTime());
    }

    /**
     * Sets the Event Time when the current Event happened.
     *
     * @param eventTime is a Unix timestamp in seconds indicating when the actual
     *                  event occurred.
     */
    public void setEventTime(Long eventTime) {
        this.serverSideEvent.setEventTime(eventTime);
        this.businessDataEvent.setEventTime(eventTime);
    }

    /**
     * Sets the Event Time when the current Event happened.
     *
     * @param eventTime is a Unix timestamp in seconds indicating when the actual
     *                  event occurred.
     * @return Event
     */
    public Event eventTime(Long eventTime) {
        this.serverSideEvent.setEventTime(eventTime);
        this.businessDataEvent.setEventTime(eventTime);
        return this;
    }

    /**
     * Gets the browser url source for the current event.
     *
     * @return eventSourceUrl
     */
    public SignalResponse<String, String> getEventSourceUrl() {
        return new SignalResponse<String, String>(this.serverSideEvent.getEventSourceUrl(), null);
    }

    /**
     * Sets the browser url source for the current event.
     *
     * @param eventSourceUrl The browser URL where the event happened.
     */
    public void setEventSourceUrl(String eventSourceUrl) {
        this.serverSideEvent.setEventSourceUrl(eventSourceUrl);
    }

    /**
     * Sets the browser url source for the current event.
     *
     * @param eventSourceUrl The browser URL where the event happened.
     * @return Event
     */
    public Event eventSourceUrl(String eventSourceUrl) {
        this.serverSideEvent.setEventSourceUrl(eventSourceUrl);
        return this;
    }

    /**
     * Gets the eventId for the current Event.
     *
     * @return eventId
     */
    public SignalResponse<String, String> getEventId() {
        return new SignalResponse<String, String>(this.serverSideEvent.getEventId(),
                this.businessDataEvent.getEventId());
    }

    /**
     * Sets the event Id for the current Event.
     *
     * @param eventId can be any string chosen by the advertiser. This is used with
     *                eventName to determine if events are identical for Conversion
     *                API.
     */
    public void setEventId(String eventId) {
        this.serverSideEvent.setEventId(eventId);
        this.businessDataEvent.setEventId(eventId);
    }

    /**
     * Sets the event Id for the current Event.
     *
     * @param eventId can be any string chosen by the advertiser. This is used with
     *                eventName to determine if events are identical for Conversion
     *                API.
     * @return Event
     */
    public Event eventId(String eventId) {
        this.serverSideEvent.setEventId(eventId);
        this.businessDataEvent.setEventId(eventId);
        return this;
    }

    /**
     * Gets the optOut feature for the current event.optOut is a boolean flag that
     * indicates we should not use this event for ads delivery optimization. If
     * public Event to true, we only use the event for attribution.
     *
     * @return OptOut
     */
    public SignalResponse<Boolean, Boolean> getOptOut() {
        return new SignalResponse<Boolean, Boolean>(this.serverSideEvent.getOptOut(), null);
    }

    /**
     * Sets the optOut feature for the current event.
     *
     * @param optOut is a boolean flag that indicates we should not use this event
     *               for ads delivery optimization. If public void setto true, we
     *               only use the event for attribution.
     */
    public void setOptOut(Boolean optOut) {
        this.serverSideEvent.setOptOut(optOut);
    }

    /**
     * Sets the optOut feature for the current event.
     *
     * @param optOut is a boolean flag that indicates we should not use this event
     *               for ads delivery optimization. If public void setto true, we
     *               only use the event for attribution.
     * @return Event
     */
    public Event optOut(Boolean optOut) {
        this.serverSideEvent.setOptOut(optOut);
        return this;
    }

    /**
     * Gets the user data objects for Business Data API and Conversion API.
     *
     * @return userData
     */
    public SignalResponse<com.facebook.ads.sdk.serverside.UserData, com.facebook.ads.sdk.businessdataapi.UserData> getUserData() {
        return new SignalResponse<com.facebook.ads.sdk.serverside.UserData, com.facebook.ads.sdk.businessdataapi.UserData>(
                this.serverSideEvent.getUserData(), this.businessDataEvent.getUserData());
    }

    /**
     * Sets the user data objects for Business Data API and Conversion API.
     *
     * @param userData contains user data, use SignalUserData to construct
     */
    public void setUserData(UserData userData) {
        this.serverSideEvent.setUserData(userData.getServerSideUserData());
        this.businessDataEvent.setUserData(userData.getBusinessDataUserData());
    }

    /**
     * Sets the user data objects for Business Data API and Conversion API.
     *
     * @param userData contains user data, use SignalUserData to construct
     * @return Event
     */
    public Event userData(UserData userData) {
        this.serverSideEvent.setUserData(userData.getServerSideUserData());
        this.businessDataEvent.setUserData(userData.getBusinessDataUserData());
        return this;
    }

    /**
     * Gets the custom data objects for Business Data API and Conversion API.
     *
     * @return customData
     */
    public SignalResponse<com.facebook.ads.sdk.serverside.CustomData, com.facebook.ads.sdk.businessdataapi.CustomData> getCustomData() {
        return new SignalResponse<com.facebook.ads.sdk.serverside.CustomData, com.facebook.ads.sdk.businessdataapi.CustomData>(
                this.serverSideEvent.getCustomData(), this.businessDataEvent.getCustomData());
    }

    /**
     * Sets the custom data objects for Business Data API and Conversion API.
     *
     * @param customData contains custom data, use SignalCustomData to construct
     */
    public void setCustomData(CustomData customData) {
        this.serverSideEvent.setCustomData(customData.getServerSideCustomData());
        this.businessDataEvent.setCustomData(customData.getBusinessDataCustomData());
    }

    /**
     * Sets the custom data objects for Business Data API and Conversion API.
     *
     * @param customData contains custom data, use SignalCustomData to construct
     * @return Event
     */
    public Event customData(CustomData customData) {
        this.serverSideEvent.setCustomData(customData.getServerSideCustomData());
        this.businessDataEvent.setCustomData(customData.getBusinessDataCustomData());
        return this;
    }

    /**
     * Gets the dataProcessingOptions for the current event. Processing options you
     * would like to enable for a specific event.
     *
     * @return dataProcessingOptions
     */
    public SignalResponse<String[], String[]> getDataProcessingOptions() {
        return new SignalResponse<String[], String[]>(this.serverSideEvent.getDataProcessingOptions(),
                this.businessDataEvent.getDataProcessingOptions());
    }

    /**
     * Sets the dataProcessingOptions for the current event.
     *
     * @param dataProcessingOptions represents Data processing options you would
     *                              like to enable for a specific event, e.g. [] or
     *                              ['LDU']
     */
    public void setDataProcessingOptions(String[] dataProcessingOptions) {
        this.serverSideEvent.setDataProcessingOptions(dataProcessingOptions);
        this.businessDataEvent.setDataProcessingOptions(dataProcessingOptions);
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
        this.serverSideEvent.setDataProcessingOptions(dataProcessingOptions);
        this.businessDataEvent.setDataProcessingOptions(dataProcessingOptions);
        return this;
    }

    /**
     * Gets the dataProcessingOptionsCountry for the current event. A country that
     * you want to associate to this data processing option.
     *
     * @return dataProcessingOptionsCountry
     */
    public SignalResponse<Integer, Integer> getDataProcessingOptionsCountry() {
        return new SignalResponse<Integer, Integer>(this.serverSideEvent.getDataProcessingOptionsCountry(),
                this.businessDataEvent.getDataProcessingOptionsCountry());
    }

    /**
     * Sets the dataProcessingOptionsCountry for the current event.
     *
     * @param dataProcessingOptionsCountry represents country that you want to
     *                                     associate to this data processing option.
     */
    public void setDataProcessingOptionsCountry(Integer dataProcessingOptionsCountry) {
        this.serverSideEvent.setDataProcessingOptionsCountry(dataProcessingOptionsCountry);
        this.businessDataEvent.setDataProcessingOptionsCountry(dataProcessingOptionsCountry);
    }

    /**
     * Sets the dataProcessingOptionsCountry for the current event.
     *
     * @param dataProcessingOptionsCountry represents country that you want to
     *                                     associate to this data processing option.
     * @return Event
     */
    public Event DataProcessingOptionsCountry(Integer dataProcessingOptionsCountry) {
        this.serverSideEvent.setDataProcessingOptionsCountry(dataProcessingOptionsCountry);
        this.businessDataEvent.setDataProcessingOptionsCountry(dataProcessingOptionsCountry);
        return this;
    }

    /**
     * Gets the dataProcessingOptionsState for the current event. A state that you
     * want to associate with this data processing option.
     *
     * @return dataProcessingOptionsState
     */
    public SignalResponse<Integer, Integer> getDataProcessingOptionsState() {
        return new SignalResponse<Integer, Integer>(this.serverSideEvent.getDataProcessingOptionsState(),
                this.businessDataEvent.getDataProcessingOptionsState());
    }

    /**
     * Sets the dataProcessingOptionsstate for the current event.
     *
     * @param dataProcessingOptionsState represents state that you want to associate
     *                                   with this data processing option.
     */
    public void setDataProcessingOptionsState(Integer dataProcessingOptionsState) {
        this.serverSideEvent.setDataProcessingOptionsState(dataProcessingOptionsState);
        this.businessDataEvent.setDataProcessingOptionsState(dataProcessingOptionsState);
    }

    /**
     * Sets the dataProcessingOptionsstate for the current event.
     *
     * @param dataProcessingOptionsState represents state that you want to associate
     *                                   with this data processing option.
     * @return Event
     */
    public Event DataProcessingOptionsState(Integer dataProcessingOptionsState) {
        this.serverSideEvent.setDataProcessingOptionsState(dataProcessingOptionsState);
        this.businessDataEvent.setDataProcessingOptionsState(dataProcessingOptionsState);
        return this;
    }

    /**
     * Gets the constructed custom data for Business Data API
     *
     * @return businessDataEvent
     */
    public com.facebook.ads.sdk.businessdataapi.Event getBusinessDataEvent() {
        return this.businessDataEvent;
    }

    /**
     * Gets the constructed custom data for Business Data API
     *
     * @return serverSideEvent
     */
    public com.facebook.ads.sdk.serverside.Event getServerSideEvent() {
        return this.serverSideEvent;
    }

}
