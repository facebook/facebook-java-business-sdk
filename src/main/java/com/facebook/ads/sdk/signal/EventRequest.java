
/**
 * Copyright (c) 2017-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
 * @flow
 */

package com.facebook.ads.sdk.signal;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.serverside.HttpServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class EventRequest {

    private com.facebook.ads.sdk.businessdataapi.EventRequest businessDataEventRequest;

    private com.facebook.ads.sdk.serverside.EventRequest serverSideEventRequest;

    /**
     * Constructor.
     *
     * @param pageId  page id
     * @param pixelId Ad pixel id
     * @param context Api context
     */
    public EventRequest(String pixelId, String pageId, APIContext context) {
        this.businessDataEventRequest = new com.facebook.ads.sdk.businessdataapi.EventRequest(pageId, context);
        this.serverSideEventRequest = new com.facebook.ads.sdk.serverside.EventRequest(pixelId, context);
    }

    /**
     * @param context           Api context
     * @param pixelId           Pixel Id to which you are sending the events
     * @param pageId            Page Id to which you are sending the events
     * @param data              Data for the request Payload for a Server Side Event
     * @param partnerAgent      Platform from which the event is sent e.g. wordpress
     * @param testEventCode     Test Event Code used to verify that your server
     *                          events are received correctly by Facebook.
     * @param namespaceId       Scope used to resolve extern_id or Third-party ID.
     *                          Can be another data set or data partner ID.
     * @param uploadId          Unique id used to denote the current set being
     *                          uploaded.
     * @param uploadTag         Tag string added to track your Offline event
     *                          uploads.
     * @param uploadSource      The origin/source of data for the dataset to be
     *                          uploaded.
     * @param httpServiceClient Override the default http request method by setting
     *                          an object that implements HttpServiceInterface
     */
    public EventRequest(String pixelId, String pageId, APIContext context, List<Event> data, String testEventCode,
            String partnerAgent, String namespaceId, String uploadId, String uploadTag, String uploadSource,
            HttpServiceInterface httpServiceClient) {
        this.setData(data);

        this.serverSideEventRequest = new com.facebook.ads.sdk.serverside.EventRequest(pixelId, context);
        this.serverSideEventRequest.setTestEventCode(testEventCode);
        this.serverSideEventRequest.setPartnerAgent(partnerAgent);
        this.serverSideEventRequest.setNamespaceId(namespaceId);
        this.serverSideEventRequest.setUploadId(uploadId);
        this.serverSideEventRequest.setUploadTag(uploadTag);
        this.serverSideEventRequest.setUploadSource(uploadSource);
        this.serverSideEventRequest.setHttpServiceClient(httpServiceClient);

        this.businessDataEventRequest = new com.facebook.ads.sdk.businessdataapi.EventRequest(pageId, context);
        this.businessDataEventRequest.setPartnerAgent(partnerAgent);
    }

    /**
     * Set a list of Event objects
     *
     * @param data list of Event
     * @return EventRequest
     */
    public EventRequest data(List<Event> data) {
        this.setData(data);
        return this;
    }

    /**
     * A list of Event objects
     *
     * @return data
     */
    public SignalResponse<List<com.facebook.ads.sdk.serverside.Event>, List<com.facebook.ads.sdk.businessdataapi.Event>> getData() {
        return new SignalResponse<List<com.facebook.ads.sdk.serverside.Event>, List<com.facebook.ads.sdk.businessdataapi.Event>>(
                this.serverSideEventRequest.getData(), this.businessDataEventRequest.getData());
    }

    /**
     * Set a list of Event objects
     *
     * @param data list of Event
     */
    public void setData(List<Event> data) {
        List<com.facebook.ads.sdk.businessdataapi.Event> businessDataEvents = new ArrayList<com.facebook.ads.sdk.businessdataapi.Event>();
        List<com.facebook.ads.sdk.serverside.Event> serverSideEvents = new ArrayList<com.facebook.ads.sdk.serverside.Event>();
        for (Event event : data) {
            businessDataEvents.add(event.getBusinessDataEvent());
            serverSideEvents.add(event.getServerSideEvent());
        }
        this.businessDataEventRequest.setData(businessDataEvents);
        this.serverSideEventRequest.setData(serverSideEvents);
    }

    /**
     * Sets a value that represents the platform that is sending the event.
     *
     * @param partnerAgent a value that represents the platform that is sending the
     *                     event
     * @return EventRequest
     */
    public EventRequest partnerAgent(String partnerAgent) {
        this.businessDataEventRequest.setPartnerAgent(partnerAgent);
        this.serverSideEventRequest.setPartnerAgent(partnerAgent);
        return this;
    }

    /**
     * A value that represents the platform that is sending the event.
     *
     * @return partnerAgent
     */
    public SignalResponse<String, String> getPartnerAgent() {
        return new SignalResponse<String, String>(this.serverSideEventRequest.getPartnerAgent(),
                this.businessDataEventRequest.getPartnerAgent());
    }

    /**
     * Set a value that represents the platform that is sending the event.
     *
     * @param partnerAgent a value that represents the platform that is sending the
     *                     event
     */
    public void setPartnerAgent(String partnerAgent) {
        this.businessDataEventRequest.setPartnerAgent(partnerAgent);
        this.serverSideEventRequest.setPartnerAgent(partnerAgent);
    }

    /**
     * The namespace id is a scope used to resolve extern_id or Third-party ID. Can
     * be another data set or data partner ID.
     *
     * @return namespaceId
     */
    public SignalResponse<String, String> getNamespaceId() {
        return new SignalResponse<String, String>(this.serverSideEventRequest.getNamespaceId(), null);
    }

    /**
     * Set namespace id
     *
     * @param namespaceId Scope used to resolve extern_id or Third-party ID. Can be
     *                    another data set or data partner ID.
     */
    public void setNamespaceId(String namespaceId) {
        this.serverSideEventRequest.setNamespaceId(namespaceId);
    }

    /**
     * Set namespace id
     *
     * @param namespaceId Scope used to resolve extern_id or Third-party ID. Can be
     *                    another data set or data partner ID.
     * @return EventRequest
     */
    public EventRequest namespaceId(String namespaceId) {
        this.serverSideEventRequest.setNamespaceId(namespaceId);
        return this;
    }

    /**
     * The upload id is a unique id used to denote the current set being uploaded.
     *
     * @return uploadId
     */
    public SignalResponse<String, String> getUploadId() {
        return new SignalResponse<String, String>(this.serverSideEventRequest.getUploadId(), null);
    }

    /**
     * Set upload id
     *
     * @param uploadId Unique id used to denote the current set being uploaded.
     */
    public void setUploadId(String uploadId) {
        this.serverSideEventRequest.setUploadId(uploadId);
    }

    /**
     * Set upload id
     *
     * @param uploadId Unique id used to denote the current set being uploaded.
     * @return EventRequest
     */
    public EventRequest uploadId(String uploadId) {
        this.serverSideEventRequest.setUploadId(uploadId);
        return this;
    }

    /**
     * The upload tag is a tag string added to track your Offline event uploads.
     *
     * @return uploadTag
     */
    public SignalResponse<String, String> getUploadTag() {
        return new SignalResponse<String, String>(this.serverSideEventRequest.getUploadTag(), null);
    }

    /**
     * Set upload tag
     *
     * @param uploadTag Tag string added to track your Offline event uploads.
     */
    public void setUploadTag(String uploadTag) {
        this.serverSideEventRequest.setUploadTag(uploadTag);
    }

    /**
     * Set upload tag
     *
     * @param uploadTag Tag string added to track your Offline event uploads.
     * @return EventRequest
     */
    public EventRequest uploadTag(String uploadTag) {
        this.serverSideEventRequest.setUploadTag(uploadTag);
        return this;
    }

    /**
     * The upload source is the origin/source of data for the dataset to be
     * uploaded.
     *
     * @return uploadSource
     */
    public SignalResponse<String, String> getUploadSource() {
        return new SignalResponse<String, String>(this.serverSideEventRequest.getUploadSource(), null);
    }

    /**
     * Set upload source
     *
     * @param uploadSource The origin/source of data for the dataset to be uploaded.
     */
    public void setUploadSource(String uploadSource) {
        this.serverSideEventRequest.setUploadSource(uploadSource);
    }

    /**
     * Set upload source
     *
     * @param uploadSource The origin/source of data for the dataset to be uploaded.
     * @return EventRequest
     */
    public EventRequest uploadSource(String uploadSource) {
        this.serverSideEventRequest.setUploadSource(uploadSource);
        return this;
    }

    /**
     * Set code used to verify that your server events are received correctly by
     * Facebook. Use this code to test your server events in the Test Events feature
     * in Events Manager. See Test Events Tool
     * (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/using-the-api#testEvents)
     * for an example.
     *
     * @param testEventCode ode used to verify that your server events
     * @return EventRequest
     */
    public EventRequest testEventCode(String testEventCode) {
        this.serverSideEventRequest.setTestEventCode(testEventCode);
        return this;
    }

    /**
     * Code used to verify that your server events are received correctly by
     * Facebook. Use this code to test your server events in the Test Events feature
     * in Events Manager. See Test Events Tool
     * (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/using-the-api#testEvents)
     * for an example.
     *
     * @return testEventCode
     */
    public SignalResponse<String, String> getTestEventCode() {
        return new SignalResponse<String, String>(this.serverSideEventRequest.getTestEventCode(), null);
    }

    /**
     * Set code used to verify that your server events are received correctly by
     * Facebook. Use this code to test your server events in the Test Events feature
     * in Events Manager. See Test Events Tool
     * (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/using-the-api#testEvents)
     * for an example.
     *
     * @param testEventCode ode used to verify that your server events
     */
    public void setTestEventCode(String testEventCode) {
        this.serverSideEventRequest.setTestEventCode(testEventCode);
    }

    /**
     * Get the httpServiceClient.
     *
     * @return httpServiceClient
     */
    public SignalResponse<HttpServiceInterface, HttpServiceInterface> getHttpServiceClient() {
        return new SignalResponse<HttpServiceInterface, HttpServiceInterface>(
                this.serverSideEventRequest.getHttpServiceClient(), null);
    }

    /**
     * Set a custom http client that will be used to send the event request.
     *
     * @param httpServiceClient the object implementing HttpServiceInterface
     */
    public void setHttpServiceClient(HttpServiceInterface httpServiceClient) {
        this.serverSideEventRequest.setHttpServiceClient(httpServiceClient);
    }

    /**
     * Return Business Data API event request
     *
     * @return businessDataEventRequest
     */
    public com.facebook.ads.sdk.businessdataapi.EventRequest getBusinessDataEventRequest() {
        return this.businessDataEventRequest;
    }

    /**
     * Return Conversion API event request
     *
     * @return serverSideEventRequest
     */
    public com.facebook.ads.sdk.serverside.EventRequest getServerSideEventRequest() {
        return this.serverSideEventRequest;
    }

    /**
     * Synchronously send Event to Facebook GraphAPI.
     *
     * @return event response
     * @throws APIException Api Exception
     */
    public SignalResponse<com.facebook.ads.sdk.serverside.EventResponse, com.facebook.ads.sdk.businessdataapi.EventResponse> execute()
            throws APIException {
        com.facebook.ads.sdk.serverside.EventResponse serverSideEventResponse = this.serverSideEventRequest.execute();

        com.facebook.ads.sdk.businessdataapi.EventResponse businessDataEventResponse = this.businessDataEventRequest
                .execute();
        return new SignalResponse<com.facebook.ads.sdk.serverside.EventResponse, com.facebook.ads.sdk.businessdataapi.EventResponse>(
                serverSideEventResponse, businessDataEventResponse);
    }

}
