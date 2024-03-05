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

import com.facebook.ads.sdk.APIConfig;
import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINode;
import com.facebook.ads.sdk.AdsPixel;
import com.facebook.ads.sdk.AdsPixel.APIRequestCreateEvent;
import com.facebook.ads.utils.CustomDataAdapter;
import com.facebook.ads.utils.AppDataAdapter;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Server side pixel event request
 */
public class EventRequest {

  private static Gson gson = null;

  @SerializedName("data")
  private List<Event> data = new ArrayList<Event>();

  @SerializedName("test_event_code")
  private String testEventCode = null;

  @SerializedName("partner_agent")
  private String partnerAgent = null;

  @SerializedName("namespace_id")
  private String namespaceId = null;

  @SerializedName("upload_id")
  private String uploadId = null;

  @SerializedName("upload_tag")
  private String uploadTag = null;

  @SerializedName("upload_source")
  private String uploadSource = null;

  private String pixelId;
  private APIContext context;
  private HttpServiceInterface httpServiceClient;

  private CustomEndpointRequest endpointRequest;

  /**
   * Constructor.
   *
   * @param pixelId Ad pixel id
   * @param context Api context
   */
  public EventRequest(String pixelId, APIContext context) {
    this.pixelId = pixelId;
    this.context = context;
  }

  /**
   * Constructor.
   *
   * @param pixelId Ad pixel id
   * @param context Api context
   * @param data list of event
   * @param testEventCode code used to verify that your server events are received correctly by
   * @param partnerAgent A value that represents the platform that is sending the event
   * @param namespaceId Scope used to resolve extern_id or Third-party ID. Can be another data set or data partner ID.
   * @param uploadId Unique id used to denote the current set being uploaded.
   * @param uploadTag Tag string added to track your Offline event uploads.
   * @param uploadSource The origin/source of data for the dataset to be uploaded.
   * @param httpServiceClient The HttpServiceInterface client to use for executing the request.
   * Facebook
   */
  public EventRequest(String pixelId, APIContext context, List<Event> data,
                      String testEventCode, String partnerAgent, String namespaceId, String uploadId,
                      String uploadTag, String uploadSource, HttpServiceInterface httpServiceClient) {
    this.data = data;
    this.testEventCode = testEventCode;
    this.partnerAgent = partnerAgent;
    this.pixelId = pixelId;
    this.context = context;
    this.namespaceId = namespaceId;
    this.uploadId = uploadId;
    this.uploadTag = uploadTag;
    this.uploadSource = uploadSource;
    this.httpServiceClient = httpServiceClient;
    this.endpointRequest = null;
  }

  static /*package*/ synchronized Gson getGson() {
    if (gson != null) {
      return gson;
    } else {
      gson =
          new GsonBuilder()
              .excludeFieldsWithModifiers(Modifier.STATIC, Modifier.PROTECTED)
              .disableHtmlEscaping()
              .registerTypeAdapter(CustomData.class, new CustomDataAdapter())
              .registerTypeAdapter(AppData.class, new AppDataAdapter())
              .create();
    }

    return gson;
  }

  /**
   * Set a list of Server Event objects
   *
   * @param data list of Server Event
   * @return EventRequest
   */
  public EventRequest data(List<Event> data) {
    this.data = data;
    return this;
  }

  public void setCustomEndpoint(CustomEndpointRequest endpointRequest) {
    this.endpointRequest = endpointRequest;
  }

  /**
   * Add a Server Event object
   *
   * @param dataItem Server Event
   * @return EventRequest
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

  /**
   * Set a list of Server Event objects
   *
   * @param data list of Server Event
   */
  public void setData(List<Event> data) {
    this.data = data;
  }

  /**
   * The namespace id is a scope used to resolve extern_id or Third-party ID.
   * Can be another data set or data partner ID.
   *
   * @return namespaceId
   */
  public String getNamespaceId() {
    return namespaceId;
  }

  /**
   * Set namespace id
   *
   * @param namespaceId Scope used to resolve extern_id or Third-party ID. Can be another data set or data partner ID.
   */
  public void setNamespaceId(String namespaceId) {
    this.namespaceId = namespaceId;
  }

  /**
   * Set namespace id
   *
   * @param namespaceId Scope used to resolve extern_id or Third-party ID. Can be another data set or data partner ID.
   * @return EventRequest
   */
  public EventRequest namespaceId(String namespaceId) {
    this.namespaceId = namespaceId;
    return this;
  }

  /**
   * The upload id is a unique id used to denote the current set being uploaded.
   *
   * @return uploadId
   */
  public String getUploadId() {
    return uploadId;
  }

  /**
   * Set upload id
   *
   * @param uploadId Unique id used to denote the current set being uploaded.
   */
  public void setUploadId(String uploadId) {
    this.uploadId = uploadId;
  }

  /**
   * Set upload id
   *
   * @param uploadId Unique id used to denote the current set being uploaded.
   * @return EventRequest
   */
  public EventRequest uploadId(String uploadId) {
    this.uploadId = uploadId;
    return this;
  }

  /**
   * The upload tag is a tag string added to track your Offline event uploads.
   *
   * @return uploadTag
   */
  public String getUploadTag() {
    return uploadTag;
  }

  /**
   * Set upload tag
   *
   * @param uploadTag Tag string added to track your Offline event uploads.
   */
  public void setUploadTag(String uploadTag) {
    this.uploadTag = uploadTag;
  }

  /**
   * Set upload tag
   *
   * @param uploadTag Tag string added to track your Offline event uploads.
   * @return EventRequest
   */
  public EventRequest uploadTag(String uploadTag) {
    this.uploadTag = uploadTag;
    return this;
  }

  /**
   * The upload source is the origin/source of data for the dataset to be uploaded.
   *
   * @return uploadSource
   */
  public String getUploadSource() {
    return uploadSource;
  }

  /**
   * Set upload source
   *
   * @param uploadSource The origin/source of data for the dataset to be uploaded.
   */
  public void setUploadSource(String uploadSource) {
    this.uploadSource = uploadSource;
  }

  /**
   * Set upload source
   *
   * @param uploadSource The origin/source of data for the dataset to be uploaded.
   * @return EventRequest
   */
  public EventRequest uploadSource(String uploadSource) {
    this.uploadSource = uploadSource;
    return this;
  }

  /**
   * Set code used to verify that your server events are received correctly by Facebook. Use this
   * code to test your server events in the Test Events feature in Events Manager. See Test Events
   * Tool (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/using-the-api#testEvents)
   * for an example.
   *
   * @param testEventCode ode used to verify that your server events
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
   * Tool (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/using-the-api#testEvents)
   * for an example.
   *
   * @param testEventCode ode used to verify that your server events
   */
  public void setTestEventCode(String testEventCode) {
    this.testEventCode = testEventCode;
  }

  /**
   * Sets a value that represents the platform that is sending the event.
   *
   * @param partnerAgent a value that represents the platform that is sending the event
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
   * @param partnerAgent a value that represents the platform that is sending the event
   */
  public void setPartnerAgent(String partnerAgent) {
    this.partnerAgent = partnerAgent;
  }

  /**
   * Get the httpServiceClient.
   *
   * @return httpServiceClient
   */
  public HttpServiceInterface getHttpServiceClient() {
    return httpServiceClient;
  }

  /**
   * Set a custom http client that will be used to send the event request.
   *
   * @param httpServiceClient the object implementing HttpServiceInterface
   */
  public void setHttpServiceClient(HttpServiceInterface httpServiceClient) {
    this.httpServiceClient = httpServiceClient;
  }

  /**
   * Synchronously send Event to Facebook GraphAPI.
   *
   * @return event response
   * @throws APIException Api Exception
   */
  public EventResponse execute() throws APIException {
    EventResponse response;
    try {
      if (endpointRequest != null && endpointRequest.isSendToEndpointOnly()) {
        // do not send to CAPI Endpoint. If no exception was thrown, we can assume all events were sent successfully
        final Map<String, CustomEndpointResponse> customEndpointResponses = sendEventsToCustomEndpoint();
        context.log(String.format("Successfully sent %d event(s) to %s only", data.size(), endpointRequest.getEndpoint()));
        context.log("Skipping CAPI Endpoint");
        response = new EventResponse(data.size(), new ArrayList(), "");
        response.setCustomEndpointResponses(customEndpointResponses);
        return response;
      } else if (endpointRequest != null) {
        response = sendToCAPIEndpoint();
        final Map<String, CustomEndpointResponse> customEndpointResponses = sendEventsToCustomEndpoint();
        response.setCustomEndpointResponses(customEndpointResponses);
      } else {
        response = sendToCAPIEndpoint();
      }
      context.log(String.format("Successfully sent %d event(s)", response.getEventsReceived()));
      return response;
    } catch (APIException e) {
      context.log(e.getMessage());
      throw e;
    }
  }

  /**
   * Synchronously send events to Custom Endpoint.
   *
   * @return event response
   * @throws APIException Api Exception
   */
  private Map<String, CustomEndpointResponse> sendEventsToCustomEndpoint() throws APIException.FailedRequestException {
      final Map<String, CustomEndpointResponse> responses = new HashMap();
      final CustomEndpointResponse customEndpointResponse = endpointRequest.sendEvent(context, pixelId, data);
      responses.put(endpointRequest.getEndpoint(), customEndpointResponse);
      return responses;
  }

  /**
   * Synchronously send events to Facebook Conversions API.
   *
   * @return event response
   * @throws APIException Api Exception
   */
  private EventResponse sendToCAPIEndpoint() throws APIException {
    EventResponse response;
    if (httpServiceClient == null) {
      final APIRequestCreateEvent event = getPixelCreateEvent();
      final APINode pixel = event.execute();
      response = gson.fromJson(pixel.getRawResponse(), EventResponse.class);
    } else {
      response = executeCustomHttpService(httpServiceClient);
    }
    return response;
  }

  private ListenableFuture<EventResponse> sendEventAsyncToCustomEndpointOnly() {
    final ListenableFuture<CustomEndpointResponse> customEndpointFuture = endpointRequest.sendEventAsync(context, pixelId, data);
    return Futures.transformAsync(
      customEndpointFuture,
      new AsyncFunction<CustomEndpointResponse, EventResponse>() {
        @Override
        public ListenableFuture<EventResponse> apply(final CustomEndpointResponse response) {
          // do not send to CAPI Endpoint. If no exception was thrown, we can assume all events were sent successfully
          context.log(String.format("Successfully sent %d event(s) to %s only", data.size(), endpointRequest.getEndpoint()));
          context.log("Skipping CAPI Endpoint");
          final EventResponse customEndpointResponse = new EventResponse(data.size(), new ArrayList(), "");
          final Map<String, CustomEndpointResponse> endpointResponses = new HashMap();
          endpointResponses.put(endpointRequest.getEndpoint(), response);
          customEndpointResponse.setCustomEndpointResponses(endpointResponses);
          return Futures.immediateFuture(customEndpointResponse);
        }
      },
      MoreExecutors.directExecutor()
    );
  }

  private ListenableFuture<EventResponse> sendEventAsyncToCAPIAndCustomEndpoint() throws APIException {
    final AdsPixel.APIRequestCreateEvent event = getPixelCreateEvent();
    final ListenableFuture pixelFuture = event.executeAsync();
    final ListenableFuture<CustomEndpointResponse> customEndpointFuture = endpointRequest.sendEventAsync(context, pixelId, data);
    // put CAPI endpoint and custom endpoint into a list of futures
    final ListenableFuture<List<Object>> futureOfList = Futures.allAsList(pixelFuture, customEndpointFuture);
    return Futures.transformAsync(
      futureOfList,
      new AsyncFunction<List<Object>, EventResponse>() {
        @Override
        public ListenableFuture<EventResponse> apply(final List<Object> responses) {
          // now we merge the two responses and send the merged eventResponse
          // the first response is CAPI response
          final EventResponse capiEventResponse =
                  gson.fromJson(((APINode) responses.get(0)).getRawResponse(), EventResponse.class);
          // second response is custom endpoint response
          final CustomEndpointResponse customEndpointResponse= (CustomEndpointResponse) responses.get(1);
          // now we merge the two responses and send the merged eventResponse
          final Map<String, CustomEndpointResponse> endpointResponses = new HashMap();
          endpointResponses.put(endpointRequest.getEndpoint(), customEndpointResponse);
          capiEventResponse.setCustomEndpointResponses(endpointResponses);
          context.log(
                  String.format(
                          "Successfully sent %d event(s)", capiEventResponse.getEventsReceived()));
          return Futures.immediateFuture(capiEventResponse);
        }
      },
      MoreExecutors.directExecutor()
    );
  }

  private ListenableFuture<EventResponse> sendEventToCAPIOnly() throws APIException {
    final AdsPixel.APIRequestCreateEvent event = getPixelCreateEvent();
    final ListenableFuture nodeFuture = event.executeAsync();
    return Futures.transformAsync(
      nodeFuture,
      new AsyncFunction<APINode, EventResponse>() {
        public ListenableFuture<EventResponse> apply(final APINode node) {
          final EventResponse eventResponse =
                  gson.fromJson(node.getRawResponse(), EventResponse.class);
          context.log(
                  String.format(
                          "Successfully sent %d event(s)", eventResponse.getEventsReceived()));
          return Futures.immediateFuture(eventResponse);
        }
      },
      MoreExecutors.directExecutor()
    );
  }

  /**
   * Asynchronously send Event to Facebook GraphAPI.
   *
   * @return ListenableFuture of event response
   * @throws APIException Api Exception
   */
  public ListenableFuture<EventResponse> executeAsync() throws APIException {
    try {
      if (endpointRequest == null) {
        return sendEventToCAPIOnly();
      }
      return (endpointRequest.isSendToEndpointOnly()) ? sendEventAsyncToCustomEndpointOnly() : sendEventAsyncToCAPIAndCustomEndpoint();
    } catch (final APIException e) {
      context.log(e.getMessage());
      throw e;
    }
  }

  private EventResponse executeCustomHttpService(HttpServiceInterface httpClient) {
    String url = String.format("%s/%s/%s/events",
        APIConfig.DEFAULT_API_BASE,
        APIConfig.DEFAULT_API_VERSION,
        pixelId
    );
    Map<String, String> headers = new HashMap<String, String>();
    headers.put("User-Agent", APIConfig.USER_AGENT);
    String appSecretProof = null;
    if (context.hasAppSecret()) {
      appSecretProof = context.getAppSecretProof();
    }
    HttpServiceParams params = new HttpServiceParams(
        context.getAccessToken(),
        appSecretProof,
        data,
        testEventCode,
        partnerAgent,
        namespaceId,
        uploadId,
        uploadTag,
        uploadSource
    );
    return httpClient.executeRequest(
        url,
        HttpMethodEnum.POST,
        headers,
        params
    );
  }

  public String getSerializedPayload() {
    List<Event> s2sData = getData();
    return getGson().toJson(s2sData);
  }

  private AdsPixel.APIRequestCreateEvent getPixelCreateEvent() {
    AdsPixel.APIRequestCreateEvent event = new AdsPixel.APIRequestCreateEvent(pixelId, context);

    event.setData(getGson().toJson(getData()));
    if (getTestEventCode() != null) {
      event.setTestEventCode(getTestEventCode());
    }
    if (getPartnerAgent() != null) {
      event.setPartnerAgent(getPartnerAgent());
    }
    if (getNamespaceId() != null) {
      event.setNamespaceId(getNamespaceId());
    }
    if (getUploadId() != null) {
      event.setUploadId(getUploadId());
    }
    if (getUploadTag() != null) {
      event.setUploadTag(getUploadTag());
    }
    if (getUploadSource() != null) {
      event.setUploadSource(getUploadSource());
    }
    return event;
  }

  public EventRequest cloneWithoutData() {
    EventRequest cloned = new EventRequest(pixelId, context);
    cloned
        .testEventCode(testEventCode)
        .partnerAgent(partnerAgent)
        .namespaceId(namespaceId)
        .uploadId(uploadId)
        .uploadTag(uploadTag)
        .uploadSource(uploadSource);

    return cloned;
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
        && Objects.equals(this.testEventCode, eventRequest.testEventCode)
        && Objects.equals(this.partnerAgent, eventRequest.partnerAgent)
        && Objects.equals(this.namespaceId, eventRequest.namespaceId)
        && Objects.equals(this.uploadId, eventRequest.uploadId)
        && Objects.equals(this.uploadTag, eventRequest.uploadTag)
        && Objects.equals(this.uploadSource, eventRequest.uploadSource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, testEventCode, partnerAgent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventRequest {\n");

    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    testEventCode: ").append(toIndentedString(testEventCode)).append("\n");
    sb.append("    partnerAgent: ").append(toIndentedString(partnerAgent)).append("\n");
    sb.append("    namespaceId: ").append(toIndentedString(namespaceId)).append("\n");
    sb.append("    uploadId: ").append(toIndentedString(uploadId)).append("\n");
    sb.append("    uploadTag: ").append(toIndentedString(uploadTag)).append("\n");
    sb.append("    uploadSource: ").append(toIndentedString(uploadSource)).append("\n");
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
