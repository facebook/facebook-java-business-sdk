package com.facebook.ads.sdk.serverside;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

public interface CustomEndpointRequest {

    public CustomEndpointResponse sendEvent(APIContext context, String pixelId, List<Event> data) throws APIException.FailedRequestException;

    public ListenableFuture<CustomEndpointResponse> sendEventAsync(APIContext context, String pixelId, List<Event> Data);

    public void setFilter(Filter filter);

    public void setSendToEndpointOnly(boolean sendToEndpointOnly);

    public boolean isSendToEndpointOnly();

    public String getEndpoint();

    interface Filter<Boolean> {
        public boolean shouldSendEvent(Event a);
    }
}
