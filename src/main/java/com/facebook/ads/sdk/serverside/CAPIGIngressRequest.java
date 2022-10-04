package com.facebook.ads.sdk.serverside;


import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APIRequest;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class CAPIGIngressRequest implements CustomEndpointRequest {
    public boolean isSendToDestinationOnly() {
        return sendToDestinationOnly;
    }
    private boolean sendToDestinationOnly;
    private String endpointURL;
    private Filter filter;
    private String pixelId;
    private String accessKey;


    public CAPIGIngressRequest(String endpointURL, String pixelId, String accessKey) {
        validateEndpoint(endpointURL);
        this.endpointURL = endpointURL;
        this.sendToDestinationOnly = false;
        this.filter = null;
        this.pixelId = pixelId;
        this.accessKey = accessKey;
    }

    public void validateEndpoint(String url) throws InvalidParameterException {
        try {
            new URL(url).toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new InvalidParameterException("URL is invalid format " + e.getMessage());
        }
    }

    @Override
    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public void sendEvent(APIContext context, String pixelId, Event data) throws APIException.FailedRequestException {
        // TODO(T125695640)
    }

    @Override
    public void sendEventAsync(APIContext context, Event Data) {
        // TODO(T125695640)
    }

}
