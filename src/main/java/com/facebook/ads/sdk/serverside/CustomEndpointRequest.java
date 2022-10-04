package com.facebook.ads.sdk.serverside;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;

import java.util.Map;

public interface CustomEndpointRequest {

    public void sendEvent(APIContext context, String pixelId, Event data) throws APIException.FailedRequestException;

    public void sendEventAsync(APIContext context, Event data);

    public void setFilter(Filter filter);

    interface Filter<Boolean> {
        public boolean shouldSendEvent(Event a);
    }
}
