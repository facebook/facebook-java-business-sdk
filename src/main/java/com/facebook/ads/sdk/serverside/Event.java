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
 * Server side pixel event
 */
public class Event {

  @SerializedName("event_name")
  private String eventName = null;

  @SerializedName("event_time")
  private Long eventTime = null;

  @SerializedName("event_source_url")
  private String eventSourceUrl = null;

  @SerializedName("opt_out")
  private Boolean optOut = null;

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

  @SerializedName("action_source")
  private ActionSource actionSource = null;

  @SerializedName("app_data")
  private AppData appData = null;

  @SerializedName("advanced_measurement_table")
  private String advancedMeasurementTable = null;

  @SerializedName("messaging_channel")
  private MessagingChannel messagingChannel = null;

  @SerializedName("original_event_data")
  private OriginalEventData originalEventData = null;

  @SerializedName("attribution_data")
  private AttributionData attributionData = null;

  /**
   * Default Constructor.
   */
  public Event() {
  }

  /**
   * Constructor.
   *
   * @param eventName Facebook pixel Standard Event or Custom Event name
   * @param eventTime Unix timestamp in seconds indicating when the actual event occurred.
   * @param eventSourceUrl browser URL where the event happened
   * @param optOut flag that indicates to use this event for ads delivery optimization or not
   * @param eventId any string chosen by the advertiser
   * @param userData UserData object that contains user info
   * @param customData customData object that includes additional business data
   * @param dataProcessingOptions Processing options you would like to enable for a specific event.
   * @param dataProcessingOptionsCountry country that you want to associate to this data processing option.
   * @param dataProcessingOptionsState state that you want to associate with this data processing option.
   * @param actionSource Where the conversion occurred.
   * @param appData AppData object that contains app data and device information
   * @param advancedMeasurementTable Only used for Advanced Measurement in the Advanced Analytics product.
   * @param messagingChannel indicated the messaging channel used.
   * *@param originalEventData indicated the original event data used for attribution passback or generalized value optimization(GVO).
   * @param attributionData indicated the attribution data used for attribution passback event to optimize the performance.
   */
  public Event(String eventName, Long eventTime, String eventSourceUrl, Boolean optOut,
      String eventId, UserData userData, CustomData customData, String[] dataProcessingOptions,
      Integer dataProcessingOptionsCountry, Integer dataProcessingOptionsState, ActionSource actionSource, AppData appData,
      String advancedMeasurementTable, MessagingChannel messagingChannel, OriginalEventData originalEventData, 
      AttributionData attributionData) {
    this.eventName = eventName;
    this.eventTime = eventTime;
    this.eventSourceUrl = eventSourceUrl;
    this.optOut = optOut;
    this.eventId = eventId;
    this.userData = userData;
    this.customData = customData;
    this.dataProcessingOptions = dataProcessingOptions;
    this.dataProcessingOptionsCountry = dataProcessingOptionsCountry;
    this.dataProcessingOptionsState = dataProcessingOptionsState;
    this.actionSource = actionSource;
    this.appData = appData;
    this.advancedMeasurementTable = advancedMeasurementTable;
    this.messagingChannel = messagingChannel;
    this.originalEventData = originalEventData;
    this.attributionData = attributionData;
  }

  /**
   * Set Facebook pixel Standard Event or Custom Event name.
   *
   * @param eventName Facebook pixel Standard Event or Custom Event name.
   * @return Event
   */
  public Event eventName(String eventName) {
    this.eventName = eventName;
    return this;
  }

  /**
   * Get Facebook pixel Standard Event or Custom Event name.
   *
   * @return eventName
   */
  public String getEventName() {
    return eventName;
  }

  /**
   * Set Facebook pixel Standard Event or Custom Event name.
   *
   * @param eventName Facebook pixel Standard Event or Custom Event name.
   */
  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  /**
   * Set Unix timestamp in seconds indicating when the actual event occurred.
   *
   * @param eventTime Unix timestamp in seconds indicating when the actual event occurred
   * @return Event
   */
  public Event eventTime(Long eventTime) {
    this.eventTime = eventTime;
    return this;
  }

  /**
   * Get Unix timestamp in seconds indicating when the actual event occurred.
   *
   * @return eventTime
   */
  public Long getEventTime() {
    return eventTime;
  }

  /**
   * Set Unix timestamp in seconds indicating when the actual event occurred.
   *
   * @param eventTime Unix timestamp in seconds indicating when the actual event occurred
   */
  public void setEventTime(Long eventTime) {
    this.eventTime = eventTime;
  }

  /**
   * Set browser URL where the event happened.
   *
   * @param eventSourceUrl rowser URL where the event happened
   * @return Event
   */
  public Event eventSourceUrl(String eventSourceUrl) {
    this.eventSourceUrl = eventSourceUrl;
    return this;
  }

  /**
   * Get browser URL where the event happened.
   *
   * @return eventSourceUrl
   */
  public String getEventSourceUrl() {
    return eventSourceUrl;
  }

  /**
   * Set browser URL where the event happened.
   *
   * @param eventSourceUrl rowser URL where the event happened
   */
  public void setEventSourceUrl(String eventSourceUrl) {
    this.eventSourceUrl = eventSourceUrl;
  }

  /**
   * Set flag that indicates we should not use this event for ads delivery optimization. If set to
   * true, we only use the event for attribution.
   *
   * @param optOut indicates we should not use this event for ads delivery optimization
   * @return Event
   */
  public Event optOut(Boolean optOut) {
    this.optOut = optOut;
    return this;
  }

  /**
   * Set flag that indicates we should not use this event for ads delivery optimization. If set to
   * true, we only use the event for attribution.
   *
   * @param optOut indicates we should not use this event for ads delivery optimization
   */
  public void setOptOut(Boolean optOut) {
    this.optOut = optOut;
  }

  /**
   * Get flag that indicates we should not use this event for ads delivery optimization. If set to
   * true, we only use the event for attribution.
   *
   * @return Boolean
   */
  public Boolean getOptOut() {
    return this.optOut;
  }

  /**
   * Sets an ID used by Facebook to deduplicate the same event sent from both server and browser.
   *
   * @param eventId This ID can be any unique string chosen by the advertiser. eventId is used to
   * deduplicate events sent by both Facebook Pixel and Server-Side API. eventName is also used in
   * the deduplication process.
   * @return Event
   */
  public Event eventId(String eventId) {
    this.eventId = eventId;
    return this;
  }

  /**
   * Get Event ID can be any string chosen by the advertiser.
   *
   * @return eventId
   */
  public String getEventId() {
    return eventId;
  }

  /**
   * Sets an ID used by Facebook to deduplicate the same event sent from both server and browser.
   *
   * @param eventId This ID can be any unique string chosen by the advertiser. eventId is used to
   * deduplicate events sent by both Facebook Pixel and Server-Side API. eventName is also used in
   * the deduplication process.
   */
  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  /**
   * Set UserData object that contains user data
   *
   * @param userData object that contains user data
   * @return Event
   */
  public Event userData(UserData userData) {
    this.userData = userData;
    return this;
  }

  /**
   * Get UserData object that contains user data
   *
   * @return userData
   */
  public UserData getUserData() {
    return userData;
  }

  /**
   * Set UserData object that contains user data
   *
   * @param userData object that contains user data
   */
  public void setUserData(UserData userData) {
    this.userData = userData;
  }

  /**
   * Set customData object that includes additional business data about the event.
   *
   * @param customData object that includes additional business data about the event.
   * @return Event
   */
  public Event customData(CustomData customData) {
    this.customData = customData;
    return this;
  }

  /**
   * Get customData object that includes additional business data about the event.
   *
   * @return customData
   */
  public CustomData getCustomData() {
    return customData;
  }

  /**
   * Set customData object that includes additional business data about the event.
   *
   * @param customData object that includes additional business data about the event.
   */
  public void setCustomData(CustomData customData) {
    this.customData = customData;
  }

   /**
   * Set dataProcessingOptions Processing options you would like to enable for a specific event.
   *
   * @param dataProcessingOptions specfies the data processing options you would like to enable for a specific event, e.g. `new String[] {}` or `new String[] {"LDU"}`;
   * @see <a href="https://developers.facebook.com/docs/marketing-apis/data-processing-options">Data Processing Options for the event</a>
   * @return Event
   */
  public Event dataProcessingOptions(String[] dataProcessingOptions) {
    this.dataProcessingOptions = dataProcessingOptions;
    return this;
  }

  /**
   * Get dataProcessingOptions
   *
   * @return dataProcessingOptions
   */
  public String[] getDataProcessingOptions() {
    return dataProcessingOptions;
  }

  /**
   * Set dataProcessingOptions Processing options you would like to enable for a specific event.
   *
   * @param dataProcessingOptions specfies the data processing options you would like to enable for a specific event, e.g. `new String[] {}` or `new String[] {"LDU"}`;
   * @see <a href="https://developers.facebook.com/docs/marketing-apis/data-processing-options">Data Processing Options for the event</a>
   */
  public void setDataProcessingOptions(String[] dataProcessingOptions) {
    this.dataProcessingOptions = dataProcessingOptions;
  }

   /**
   * Set dataProcessingOptionsCountry for the event.
   *
   * @param dataProcessingOptionsCountry represents country that you want to associate to this data processing option. If you set a country, you must also set a state.
   * @return Event
   */
  public Event dataProcessingOptionsCountry(Integer dataProcessingOptionsCountry) {
    this.dataProcessingOptionsCountry = dataProcessingOptionsCountry;
    return this;
  }

  /**
   * Get dataProcessingOptionsCountry
   *
   * @return dataProcessingOptionsCountry
   */
  public Integer getDataProcessingOptionsCountry() {
    return dataProcessingOptionsCountry;
  }

  /**
   * Set dataProcessingOptionsCountry for the event.
   *
   * @param dataProcessingOptionsCountry represents country that you want to associate to this data processing option. If you set a country, you must also set a state.
   * @see <a href="https://developers.facebook.com/docs/marketing-apis/data-processing-options">Data Processing Options for the event</a>
   *
   */
  public void setDataProcessingOptionsCountry(Integer dataProcessingOptionsCountry) {
    this.dataProcessingOptionsCountry = dataProcessingOptionsCountry;
  }

   /**
   * Set dataProcessingOptionsState for the event.
   *
   * @param dataProcessingOptionsState represents the state that you want to associate with this data processing option.
   * @see <a href="https://developers.facebook.com/docs/marketing-apis/data-processing-options">Data Processing Options for the event</a>
   * @return Event
   */
  public Event dataProcessingOptionsState(Integer dataProcessingOptionsState) {
    this.dataProcessingOptionsState = dataProcessingOptionsState;
    return this;
  }

  /**
   * Get dataProcessingOptionsState
   *
   * @return dataProcessingOptionsState
   */
  public Integer getDataProcessingOptionsState() {
    return dataProcessingOptionsState;
  }

  /**
   * Set dataProcessingOptionsState for the event.
   *
   * @param dataProcessingOptionsState represents the state that you want to associate with this data processing option.
   * @see <a href="https://developers.facebook.com/docs/marketing-apis/data-processing-options">Data Processing Options for the event</a>
   */
  public void setDataProcessingOptionsState(Integer dataProcessingOptionsState) {
    this.dataProcessingOptionsState = dataProcessingOptionsState;
  }

  /**
   * Set actionSource for the event.
   *
   * @param actionSource represents where the conversion occurred.
   * @see <a href="https://developers.facebook.com/docs/marketing-api/conversions-api/parameters/server-event#action-source">Action source for the event</a>
   * @return Event
   */
  public Event actionSource(ActionSource actionSource) {
    this.actionSource = actionSource;
    return this;
  }

  /**
   * Get actionSource
   *
   * @return actionSource
   */
  public ActionSource getActionSource() {
    return actionSource;
  }

  /**
   * Set actionSource for the event.
   *
   * @param actionSource represents where the conversion occurred.
   * @see <a href="https://developers.facebook.com/docs/marketing-api/conversions-api/parameters/server-event#action-source">Action source for the event</a>
   */
  public void setActionSource(ActionSource actionSource) {
    this.actionSource = actionSource;
  }

  /**
   * Set appData for the event.
   * @param appData contains app data and device information for events happening from an app
   * @see <a href="https://developers.facebook.com/docs/marketing-api/conversions-api/parameters/server-event#app_data">App Data for the event</a>
   * @return Event
   */
  public Event appData(AppData appData) {
    this.appData = appData;
    return this;
  }

  /**
   * Get appData
   *
   * @return AppData
   */
   public AppData getAppData() {
     return appData;
   }

  /**
   * Set appData for the event.
   * @param appData contains app data and device information for events happening from an app
   * @see <a href="https://developers.facebook.com/docs/marketing-api/conversions-api/parameters/server-event#app_data">App Data for the event</a>
   */
  public void setAppData(AppData appData) {
    this.appData = appData;
  }

  /**
   * Set advancedMeasurementTable for the event.
   *
   * @param advancedMeasurementTable The target table for Advanced Measurement in Advanced Analytics.
   * @return Event
   */
  public Event advancedMeasurementTable(String advancedMeasurementTable) {
    this.advancedMeasurementTable = advancedMeasurementTable;
    return this;
  }

  /**
   * Get advancedMeasurementTable
   *
   * @return advancedMeasurementTable
   */
  public String getAdvancedMeasurementTable() {
    return advancedMeasurementTable;
  }

  /**
   * Set advancedMeasurementTable for the event.
   *
   * @param advancedMeasurementTable The target table for Advanced Measurement in Advanced Analytics.
   */
  public void setAdvancedMeasurementTable(String advancedMeasurementTable) {
    this.advancedMeasurementTable = advancedMeasurementTable;
  }

  /**
   * Set messagingChannel for the event.
   *
   * @param messagingChannel represents where the conversation occurred.
   * @return Event
   */
  public Event messagingChannel(MessagingChannel messagingChannel) {
    this.messagingChannel = messagingChannel;
    return this;
  }

  /**
   * Get messagingChannel for the event.
   *
   * @return messagingChannel
   */
  public MessagingChannel getMessagingChannel() {
    return messagingChannel;
  }

  /**
   * Set messagingChannel for the event.
   *
   * @param messagingChannel represents where the conversation occurred.
   */
  public void setMessagingChannel(MessagingChannel messagingChannel) {
    this.messagingChannel = messagingChannel;
  }

  /**
   * Set originalEventData for the event.
   *
   * @param originalEventData represents where the original event used for attribution passback or generalized value optimization(GVO).
   * @return Event
   */
  public Event originalEventData(OriginalEventData originalEventData) {
    this.originalEventData = originalEventData;
    return this;
  }

  /**
   * Get originalEventData for the event.
   *
   * @return OriginalEventData
   */
  public OriginalEventData getOriginalEventData() {
    return originalEventData;
  }

  /**
   * Set originalEventData for the event.
   *
   * @param originalEventData represents where the original event used for attribution passback or generalized value optimization(GVO).
   */
  public void setOriginalEventData(OriginalEventData originalEventData) {
    this.originalEventData = originalEventData;
  }

  /**
   * Set attributionData for the event.
   * 
   * @param attributionData represents attribution data used for attribution passback event to optimize the performance.
   * @return Event
   */
  public Event attributionData(AttributionData attributionData) {
    this.attributionData = attributionData;
    return this;
  }

  /**
   * Get attributionData for the event.
   * 
   * @return AttributionData
   */
  public AttributionData getAttributionData() {
    return attributionData;
  }

  /**
   * Set attributionData for the event.
   * 
   * @param attributionData represents attribution data used for attribution passback event to optimize the performance.
   */
  public void setAttributionData(AttributionData attributionData) {
    this.attributionData = attributionData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return Objects.equals(this.eventName, event.eventName)
        && Objects.equals(this.eventTime, event.eventTime)
        && Objects.equals(this.eventSourceUrl, event.eventSourceUrl)
        && Objects.equals(this.optOut, event.optOut)
        && Objects.equals(this.eventId, event.eventId)
        && Objects.equals(this.userData, event.userData)
        && Objects.equals(this.customData, event.customData)
        && Objects.equals(this.dataProcessingOptions, event.dataProcessingOptions)
        && Objects.equals(this.dataProcessingOptionsCountry, event.dataProcessingOptionsCountry)
        && Objects.equals(this.dataProcessingOptionsState, event.dataProcessingOptionsState)
        && Objects.equals(this.messagingChannel, event.messagingChannel)
        && Objects.equals(this.originalEventData, event.originalEventData)
        && Objects.equals(this.attributionData, event.attributionData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        eventName, eventTime, eventSourceUrl, optOut, eventId, userData, customData, dataProcessingOptions, dataProcessingOptionsCountry, dataProcessingOptionsState , messagingChannel, originalEventData, attributionData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event {\n");

    sb.append("    eventName: ").append(toIndentedString(eventName)).append("\n");
    sb.append("    eventTime: ").append(toIndentedString(eventTime)).append("\n");
    sb.append("    eventSourceUrl: ").append(toIndentedString(eventSourceUrl)).append("\n");
    sb.append("    optOut: ").append(toIndentedString(optOut)).append("\n");
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
    sb.append("    userData: ").append(toIndentedString(userData)).append("\n");
    sb.append("    customData: ").append(toIndentedString(customData)).append("\n");
    sb.append("    dataProcessingOptions: ").append(toIndentedString(dataProcessingOptions)).append("\n");
    sb.append("    dataProcessingOptionsCountry: ").append(toIndentedString(dataProcessingOptionsCountry)).append("\n");
    sb.append("    dataProcessingOptionsState: ").append(toIndentedString(dataProcessingOptionsState)).append("\n");
    sb.append("    messagingChannel: ").append(toIndentedString(messagingChannel)).append("\n");
    sb.append("    originalEventData: ").append(toIndentedString(originalEventData)).append("\n");
    sb.append("    attributionData: ").append(toIndentedString(attributionData)).append("\n");
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
