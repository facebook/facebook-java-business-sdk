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
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class EventRequestTest {
  private CustomEndpointRequest mockEndpointRequest;
  private EventRequest eventRequest;

  @Before
  public void mockCustomEndpointClient() {
    mockEndpointRequest = new CustomEndpointRequest() {
      private boolean sendToDestinationOnly;
      @Override
      public CustomEndpointResponse sendEvent(final APIContext context, final String pixelId, final List<Event> data) throws APIException.FailedRequestException {
        return (sendToDestinationOnly)? new CustomEndpointResponse("Events sent to mock custom endpoint only", "224"):
                new CustomEndpointResponse("Events sent to mock endpoint and CAPI", "222");
      }

      @Override
      public ListenableFuture<CustomEndpointResponse> sendEventAsync(final APIContext context, final String pixelId, final List<Event> Data) {
        return (sendToDestinationOnly)? Futures.immediateFuture(new CustomEndpointResponse("Events asynchronously sent to mock custom endpoint only", "224")) :
                Futures.immediateFuture(new CustomEndpointResponse("Events asynchronously sent to mock endpoint and CAPI", "222"));
      }

      @Override
      public void setFilter(Filter filter) {
      }

      @Override
      public void setSendToDestinationOnly(final boolean sendToDestinationOnly) {
        this.sendToDestinationOnly = sendToDestinationOnly;
      }

      @Override
      public boolean isSendToDestinationOnly() {
        return sendToDestinationOnly;
      }

      @Override
      public String getEndpoint() {
        return "www.endpoint.com";
      }
    };
  }

  @After
  public void Cleanup() {
    mockEndpointRequest = null;
    eventRequest = null;
  }
  @Test
  public void BuildersAndGettersTest() {
    final EventRequest eventRequest = new EventRequest("pixelid", null);
    eventRequest.namespaceId("11")
        .uploadId("222")
        .uploadTag("upload-tag-3")
        .uploadSource("upload-source-4")
        .testEventCode("test-event-code-5")
        .partnerAgent("partner-agent-6");

    assertEquals(eventRequest.getNamespaceId(), "11");
    assertEquals(eventRequest.getUploadId(), "222");
    assertEquals(eventRequest.getUploadTag(), "upload-tag-3");
    assertEquals(eventRequest.getUploadSource(), "upload-source-4");
    assertEquals(eventRequest.getTestEventCode(), "test-event-code-5");
    assertEquals(eventRequest.getPartnerAgent(), "partner-agent-6");
  }

  @Test
  public void SetHttpClientTest() throws APIException {
    final HttpServiceInterface mockClient = mock(HttpServiceInterface.class);
    final APIContext mockApiContext = mock(APIContext.class);
    final EventResponse mockEventResponse = mock(EventResponse.class);
    final String accessToken = "access-token-0";
    final String appSecretProof = "app-secret-proof-01";
    doReturn(accessToken).when(mockApiContext).getAccessToken();
    doReturn(true).when(mockApiContext).hasAppSecret();
    doReturn(appSecretProof).when(mockApiContext).getAppSecretProof();
    doReturn(mockEventResponse).when(mockClient).executeRequest(
        ArgumentMatchers.<String>any(),
        ArgumentMatchers.<HttpMethodEnum>any(),
        ArgumentMatchers.<Map<String, String>>any(),
        ArgumentMatchers.<HttpServiceParams>any()
    );
    final String pixelId = "pixel-id-1";
    final String testEventCode = "test-code-2";
    final String partnerAgent = "partnerAgent-3";
    final String namespaceId = "namespaceId-4";
    final String uploadId = "uploadId-5";
    final String uploadTag = "uploadTag-6";
    final String uploadSource = "uploadSource-7";
    final Event event = new Event();
    final UserData userData = new UserData();
    userData.email("joe@eg.com");
    event
        .userData(userData)
        .eventTime(System.currentTimeMillis() / 1000L);
    final EventRequest eventRequest = new EventRequest(pixelId, mockApiContext);
    final List<Event> data = Collections.singletonList(event);
    eventRequest
        .testEventCode(testEventCode)
        .partnerAgent(partnerAgent)
        .namespaceId(namespaceId)
        .uploadId(uploadId)
        .uploadTag(uploadTag)
        .uploadSource(uploadSource)
        .data(data);

    eventRequest.setHttpServiceClient(mockClient);
    final String expectedUrl = String.format("%s/%s/%s/events",
        APIConfig.DEFAULT_API_BASE,
        APIConfig.DEFAULT_API_VERSION,
        pixelId
    );
    final HttpServiceParams params = new HttpServiceParams(
        accessToken,
        appSecretProof,
        data,
        testEventCode,
        partnerAgent,
        namespaceId,
        uploadId,
        uploadTag,
        uploadSource
    );
    final Map<String, String> expectedHeaders = new HashMap<String, String>();
    expectedHeaders.put("User-Agent", APIConfig.USER_AGENT);
    final EventResponse actualEventResponse = eventRequest.execute();

    verify(mockClient).executeRequest(expectedUrl, HttpMethodEnum.POST, expectedHeaders, params);
    assertEquals(mockEventResponse, actualEventResponse);
  }

  @Test
  public void SetHttpClientWhenThereIsNoAppSecretProofTest() throws APIException {
    final HttpServiceInterface mockClient = mock(HttpServiceInterface.class);
    final APIContext mockApiContext = mock(APIContext.class);
    final String accessToken = "access-token-0";
    doReturn(accessToken).when(mockApiContext).getAccessToken();
    doReturn(false).when(mockApiContext).hasAppSecret();
    doReturn(mock(EventResponse.class)).when(mockClient).executeRequest(
        ArgumentMatchers.<String>any(),
        ArgumentMatchers.<HttpMethodEnum>any(),
        ArgumentMatchers.<Map<String, String>>any(),
        ArgumentMatchers.<HttpServiceParams>any()
    );
    final String pixelId = "pixel-id-1";
    final Event event = new Event();
    final UserData userData = new UserData();
    userData.email("joe@eg.com");
    event
        .userData(userData)
        .eventTime(System.currentTimeMillis() / 1000L);
    final EventRequest eventRequest = new EventRequest(pixelId, mockApiContext);
    final List<Event> data = Collections.singletonList(event);
    eventRequest.data(data);
    eventRequest.setHttpServiceClient(mockClient);
    final String expectedUrl = String.format("%s/%s/%s/events",
        APIConfig.DEFAULT_API_BASE,
        APIConfig.DEFAULT_API_VERSION,
        pixelId
    );
    final HttpServiceParams params = new HttpServiceParams(
        accessToken,
        null,
        data,
        null,
        null,
        null,
        null,
        null,
        null
    );
    final Map<String, String> expectedHeaders = new HashMap<String, String>();
    expectedHeaders.put("User-Agent", APIConfig.USER_AGENT);
    eventRequest.execute();

    verify(mockClient).executeRequest(expectedUrl, HttpMethodEnum.POST, expectedHeaders, params);
    verify(mockApiContext, times(0)).getAppSecretProof();
  }

  @Test
  public void CloneWithoutDataTest() {
    final String pixelId = "pixelid";
    final APIContext mockApiContext = mock(APIContext.class);
    final EventRequest eventRequest = new EventRequest(pixelId, mockApiContext);
    eventRequest.namespaceId("11")
        .data(Collections.singletonList(mock(Event.class)))
        .uploadId("222")
        .uploadTag("upload-tag-3")
        .uploadSource("upload-source-4")
        .testEventCode("test-event-code-5")
        .partnerAgent("partner-agent-6");
    final EventRequest expectedEventRequest = new EventRequest(pixelId, mockApiContext);
    expectedEventRequest.namespaceId(eventRequest.getNamespaceId())
        .uploadId(eventRequest.getUploadId())
        .uploadTag(eventRequest.getUploadTag())
        .uploadSource(eventRequest.getUploadSource())
        .testEventCode(eventRequest.getTestEventCode())
        .partnerAgent(eventRequest.getPartnerAgent());

    assertEquals(expectedEventRequest, eventRequest.cloneWithoutData());
  }

  private EventRequest setupClientForCustomEndpoint() {
    final String pixelId = "pixelid";
    final APIContext mockApiContext = mock(APIContext.class);
    final EventRequest eventRequest = new EventRequest(pixelId, mockApiContext);
    final HttpServiceInterface mockClient = mock(HttpServiceInterface.class);
    final EventResponse mockEventResponse = mock(EventResponse.class);
    doReturn(mockEventResponse).when(mockClient).executeRequest(
            ArgumentMatchers.<String>any(),
            ArgumentMatchers.<HttpMethodEnum>any(),
            ArgumentMatchers.<Map<String, String>>any(),
            ArgumentMatchers.<HttpServiceParams>any()
    );
    doCallRealMethod().when(mockEventResponse).setCustomEndpointResponses(ArgumentMatchers.any());
    doCallRealMethod().when(mockEventResponse).getCustomEndpointResponses();
    eventRequest.setHttpServiceClient(mockClient);
    eventRequest.setCustomEndpoint(mockEndpointRequest);
    return eventRequest;
  }

  private EventRequest addEventsToRequest() {
    // Append events to eventRequest
    final Event testEvent1 = new Event();
    testEvent1.setEventId("1");
    testEvent1.setEventName("testEvent1");
    final Event testEvent2 = new Event();
    testEvent2.setEventId("2");
    testEvent2.setEventName("testEvent2");
    eventRequest.addDataItem(testEvent1);
    eventRequest.addDataItem(testEvent2);
    return eventRequest;
  }

  @Test
  public void sendSyncToCustomEndpoint() throws APIException {
    eventRequest = setupClientForCustomEndpoint();
    final EventResponse testResponse = eventRequest.execute();
    assertEquals(testResponse.getEventsReceived(), new Integer(0));
    addEventsToRequest();

    final EventResponse testResponse2 = eventRequest.execute();
    assertNotNull(testResponse2.getCustomEndpointResponses());
    assertEquals(testResponse2.getCustomEndpointResponses().get(mockEndpointRequest.getEndpoint()).message, "Events sent to mock endpoint and CAPI");
    assertEquals(testResponse2.getCustomEndpointResponses().get(mockEndpointRequest.getEndpoint()).responseCode, "222");
  }

  @Test
  public void sendSyncToCustomEndpointOnly() throws APIException {
    mockEndpointRequest.setSendToDestinationOnly(true);
    eventRequest = setupClientForCustomEndpoint();
    eventRequest.setCustomEndpoint(mockEndpointRequest);
    final EventResponse testResponse = eventRequest.execute();
    assertEquals(testResponse.getEventsReceived(), new Integer(0));
    addEventsToRequest();

    final EventResponse testResponse2 = eventRequest.execute();
    assertEquals(testResponse2.getCustomEndpointResponses().size(), 0);
    assertEquals(testResponse2.getMessages(), new ArrayList());
    assertEquals(testResponse2.getEventsReceived(), new Integer(2));
  }

  @Test
  public void sendAsyncToCustomEndpointOnly() throws APIException, ExecutionException, InterruptedException {
    mockEndpointRequest.setSendToDestinationOnly(true);
    eventRequest = setupClientForCustomEndpoint();
    eventRequest.setCustomEndpoint(mockEndpointRequest);
    final EventResponse testResponse = eventRequest.executeAsync().get();
    assertEquals(testResponse.getEventsReceived(), new Integer(0));
    addEventsToRequest();

    final EventResponse testResponse2 = eventRequest.executeAsync().get();
    assertEquals(testResponse2.getEventsReceived(), new Integer(2));
    assertEquals(testResponse2.getMessages(), new ArrayList());
  }
}
