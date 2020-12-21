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
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class EventRequestTest {
  @Test
  public void BuildersAndGettersTest() {
    EventRequest eventRequest = new EventRequest("pixelid", null);
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
    HttpServiceInterface mockClient = mock(HttpServiceInterface.class);
    APIContext mockApiContext = mock(APIContext.class);
    EventResponse mockEventResponse = mock(EventResponse.class);
    String accessToken = "access-token-0";
    String appSecretProof = "app-secret-proof-01";
    doReturn(accessToken).when(mockApiContext).getAccessToken();
    doReturn(true).when(mockApiContext).hasAppSecret();
    doReturn(appSecretProof).when(mockApiContext).getAppSecretProof();
    doReturn(mockEventResponse).when(mockClient).executeRequest(
        ArgumentMatchers.<String>any(),
        ArgumentMatchers.<HttpMethodEnum>any(),
        ArgumentMatchers.<Map<String, String>>any(),
        ArgumentMatchers.<HttpServiceParams>any()
    );
    String pixelId = "pixel-id-1";
    String testEventCode = "test-code-2";
    String partnerAgent = "partnerAgent-3";
    String namespaceId = "namespaceId-4";
    String uploadId = "uploadId-5";
    String uploadTag = "uploadTag-6";
    String uploadSource = "uploadSource-7";
    Event event = new Event();
    UserData userData = new UserData();
    userData.email("joe@eg.com");
    event
        .userData(userData)
        .eventTime(System.currentTimeMillis() / 1000L);
    EventRequest eventRequest = new EventRequest(pixelId, mockApiContext);
    List<Event> data = Collections.singletonList(event);
    eventRequest
        .testEventCode(testEventCode)
        .partnerAgent(partnerAgent)
        .namespaceId(namespaceId)
        .uploadId(uploadId)
        .uploadTag(uploadTag)
        .uploadSource(uploadSource)
        .data(data);

    eventRequest.setHttpServiceClient(mockClient);
    String expectedUrl = String.format("%s/%s/%s/events",
        APIConfig.DEFAULT_API_BASE,
        APIConfig.DEFAULT_API_VERSION,
        pixelId
    );
    HttpServiceParams params = new HttpServiceParams(
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
    Map<String, String> expectedHeaders = new HashMap<String, String>();
    expectedHeaders.put("User-Agent", APIConfig.USER_AGENT);
    EventResponse actualEventResponse = eventRequest.execute();

    verify(mockClient).executeRequest(expectedUrl, HttpMethodEnum.POST, expectedHeaders, params);
    assertEquals(mockEventResponse, actualEventResponse);
  }

  @Test
  public void SetHttpClientWhenThereIsNoAppSecretProofTest() throws APIException {
    HttpServiceInterface mockClient = mock(HttpServiceInterface.class);
    APIContext mockApiContext = mock(APIContext.class);
    String accessToken = "access-token-0";
    doReturn(accessToken).when(mockApiContext).getAccessToken();
    doReturn(false).when(mockApiContext).hasAppSecret();
    doReturn(mock(EventResponse.class)).when(mockClient).executeRequest(
        ArgumentMatchers.<String>any(),
        ArgumentMatchers.<HttpMethodEnum>any(),
        ArgumentMatchers.<Map<String, String>>any(),
        ArgumentMatchers.<HttpServiceParams>any()
    );
    String pixelId = "pixel-id-1";
    Event event = new Event();
    UserData userData = new UserData();
    userData.email("joe@eg.com");
    event
        .userData(userData)
        .eventTime(System.currentTimeMillis() / 1000L);
    EventRequest eventRequest = new EventRequest(pixelId, mockApiContext);
    List<Event> data = Collections.singletonList(event);
    eventRequest.data(data);
    eventRequest.setHttpServiceClient(mockClient);
    String expectedUrl = String.format("%s/%s/%s/events",
        APIConfig.DEFAULT_API_BASE,
        APIConfig.DEFAULT_API_VERSION,
        pixelId
    );
    HttpServiceParams params = new HttpServiceParams(
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
    Map<String, String> expectedHeaders = new HashMap<String, String>();
    expectedHeaders.put("User-Agent", APIConfig.USER_AGENT);
    eventRequest.execute();

    verify(mockClient).executeRequest(expectedUrl, HttpMethodEnum.POST, expectedHeaders, params);
    verify(mockApiContext, times(0)).getAppSecretProof();
  }

  @Test
  public void CloneWithoutDataTest() {
    String pixelId = "pixelid";
    APIContext mockApiContext = mock(APIContext.class);
    EventRequest eventRequest = new EventRequest(pixelId, mockApiContext);
    eventRequest.namespaceId("11")
        .data(Collections.singletonList(mock(Event.class)))
        .uploadId("222")
        .uploadTag("upload-tag-3")
        .uploadSource("upload-source-4")
        .testEventCode("test-event-code-5")
        .partnerAgent("partner-agent-6");
    EventRequest expectedEventRequest = new EventRequest(pixelId, mockApiContext);
    expectedEventRequest.namespaceId(eventRequest.getNamespaceId())
        .uploadId(eventRequest.getUploadId())
        .uploadTag(eventRequest.getUploadTag())
        .uploadSource(eventRequest.getUploadSource())
        .testEventCode(eventRequest.getTestEventCode())
        .partnerAgent(eventRequest.getPartnerAgent());

    assertEquals(expectedEventRequest, eventRequest.cloneWithoutData());
  }
}
