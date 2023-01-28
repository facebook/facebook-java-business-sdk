package com.facebook.ads.sdk.serverside;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.rules.ExpectedException;
import static org.mockito.Mockito.mock;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class CAPIGatewayEndpointTest {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void BuildersAndGettersTest() {
        final CAPIGatewayEndpoint capigIngressRequest = new CAPIGatewayEndpoint("https://example.com", "ACCESS_KEY");
        assertEquals(capigIngressRequest.getEndpoint(), "https://example.com");
        assertFalse(capigIngressRequest.isSendToEndpointOnly());
        capigIngressRequest.setSendToEndpointOnly(true);
        assertTrue(capigIngressRequest.isSendToEndpointOnly());
    }

    @Test
    public void invalidURLTest() {
        thrown.expect(InvalidParameterException.class);
        new CAPIGatewayEndpoint("badDomain", "ACCESS_KEY");
        thrown.expectMessage("URL is in invalid format");
    }

    @Test
    public void filterAllEvents() throws APIException.FailedRequestException {
        final CustomEndpointRequest.Filter filterAllEvents = a -> false;
        final CAPIGatewayEndpoint capigIngressRequest = new CAPIGatewayEndpoint("https://capig-instance.com", "ACCESS_KEY");
        capigIngressRequest.setFilter(filterAllEvents);
        final List<Event> events = new ArrayList();
        final Event event1 = new Event();
        event1.setEventId("1");
        final Event event2 = new Event();
        event2.setEventId("2");
        events.add(event1);
        events.add(event2);
        final CustomEndpointResponse response = capigIngressRequest.sendEvent(mock(APIContext.class), "pixelId", events);
        assertEquals(response.message, "No events to send");
        assertEquals(response.responseCode, null);
    }
}
