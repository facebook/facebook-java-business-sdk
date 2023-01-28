package com.facebook.ads.sdk.serverside;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doCallRealMethod;

public class EventRequestCustomEndpointTest {
    private CustomEndpointRequest mockEndpointRequest;
    private EventRequest eventRequest;
    @Before
    public void mockCustomEndpointClient() {
        mockEndpointRequest = new CustomEndpointRequest() {
            private boolean sendToEndpointOnly;
            @Override
            public CustomEndpointResponse sendEvent(final APIContext context, final String pixelId, final List<Event> data) throws APIException.FailedRequestException {
                return (sendToEndpointOnly)? new CustomEndpointResponse("Events sent to mock custom endpoint only", "224"):
                        new CustomEndpointResponse("Events sent to mock endpoint and CAPI", "222");
            }

            @Override
            public ListenableFuture<CustomEndpointResponse> sendEventAsync(final APIContext context, final String pixelId, final List<Event> Data) {
                return (sendToEndpointOnly)? Futures.immediateFuture(new CustomEndpointResponse("Events asynchronously sent to mock custom endpoint only", "224")) :
                        Futures.immediateFuture(new CustomEndpointResponse("Events asynchronously sent to mock endpoint and CAPI", "222"));
            }

            @Override
            public void setFilter(Filter filter) {
            }

            @Override
            public void setSendToEndpointOnly(final boolean sendToEndpointOnly) {
                this.sendToEndpointOnly = sendToEndpointOnly;
            }

            @Override
            public boolean isSendToEndpointOnly() {
                return this.sendToEndpointOnly;
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
        mockEndpointRequest.setSendToEndpointOnly(true);
        eventRequest = setupClientForCustomEndpoint();
        eventRequest.setCustomEndpoint(mockEndpointRequest);
        final EventResponse testResponse = eventRequest.execute();
        assertEquals(testResponse.getEventsReceived(), new Integer(0));
        addEventsToRequest();

        final EventResponse testResponse2 = eventRequest.execute();
        assertEquals(testResponse2.getCustomEndpointResponses().size(), 1);
        assertEquals(testResponse2.getMessages(), new ArrayList());
        assertEquals(testResponse2.getEventsReceived(), new Integer(2));
    }

    @Test
    public void sendAsyncToCustomEndpointOnly() throws APIException, ExecutionException, InterruptedException {
        mockEndpointRequest.setSendToEndpointOnly(true);
        eventRequest = setupClientForCustomEndpoint();
        eventRequest.setCustomEndpoint(mockEndpointRequest);
        final EventResponse testResponse = eventRequest.executeAsync().get();
        assertEquals(testResponse.getEventsReceived(), new Integer(0));
        addEventsToRequest();

        final EventResponse testResponse2 = eventRequest.executeAsync().get();
        assertEquals(testResponse2.getCustomEndpointResponses().size(), 1);
        assertEquals(testResponse2.getEventsReceived(), new Integer(2));
        assertEquals(testResponse2.getMessages(), new ArrayList());
    }
}
