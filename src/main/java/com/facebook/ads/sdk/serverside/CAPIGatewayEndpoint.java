package com.facebook.ads.sdk.serverside;


import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CAPIGatewayEndpoint implements CustomEndpointRequest {
    private boolean sendToEndpointOnly;
    private final String endpointURL;
    private Filter filter;
    private final String accessKey;

    private final OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public CAPIGatewayEndpoint(String endpointURL, String accessKey) {
        validateEndpoint(endpointURL);
        this.endpointURL = endpointURL;
        this.sendToEndpointOnly = false;
        this.filter = null;
        this.accessKey = accessKey;
    }

    public void validateEndpoint(final String url) throws InvalidParameterException {
        try {
            new URL(url).toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new InvalidParameterException("URL is in invalid format " + e.getMessage());
        }
    }


    public boolean isSendToEndpointOnly() {
        return sendToEndpointOnly;
    }

    @Override
    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public void setSendToEndpointOnly(boolean sendToEndpointOnly) {
        this.sendToEndpointOnly = sendToEndpointOnly;
    }

    @Override
    public String getEndpoint() {
        return this.endpointURL;
    }
    public CustomEndpointResponse sendEvent(final APIContext context,  final String pixelId, List<Event> events) throws APIException.FailedRequestException {
        // filter out events
        if (this.filter != null) {
            events = events.stream().filter(event -> this.filter.shouldSendEvent(event)).collect(Collectors.toList());
        }
        if (events.isEmpty()) {
            context.log("No events to send");
            return new CustomEndpointResponse("No events to send", null);
        }
        final Request request = createRequest(events, pixelId);
        context.log("========Start of CAPIG Ingress API Call========");
        try (final Response httpResponse = client.newCall(request).execute()) {
            if (httpResponse.code() != 202) {
                // a HTTP response code of 202 means the events were accepted
                throw new APIException.FailedRequestException("Server response code is " + httpResponse.code() + " , expect: 202");
            } else {
                context.log("Events successfully received");
                return new CustomEndpointResponse(httpResponse.message(), String.valueOf((httpResponse.code())));
            }
        } catch (final IOException ex) {
            context.log(ex.getMessage());
            throw new APIException.FailedRequestException("Server failed to accept events. " + ex.getMessage());
        } finally {
            context.log("========End of API Call========");
        }
    }

    private Request createRequest(final List<Event> events, final String pixelId) {
        final Map<String, Object> bodyParams = new HashMap();
        bodyParams.put("accessKey", accessKey);
        bodyParams.put("data", events);
        final RequestBody requestBody = RequestBody.create(JSON, new Gson().toJson(bodyParams));
        return new Request.Builder()
                .url(endpointURL + "/capi/" + pixelId + "/events")
                .post(requestBody)
                .build();
    }

    @Override
    public ListenableFuture<CustomEndpointResponse> sendEventAsync(final APIContext context, final String pixelId, final List<Event> data) {
            context.log("========Start of Async API Call========");
            final Request request = createRequest(data, pixelId);
            final SettableFuture<CustomEndpointResponse> future = SettableFuture.create();
            client.newCall(request).enqueue(
                    new okhttp3.Callback() {
                        @Override
                        public void onFailure(final okhttp3.Call call, final IOException e) {
                            context.log(e.getMessage());
                            future.setException(
                                    new APIException.FailedRequestException("Server failed to accept events. " + e.getMessage())
                            );
                        }

                        @Override
                        public void onResponse(final okhttp3.Call call, final okhttp3.Response response) {
                            if (response.code() != 202) {
                                // a HTTP response code of 202 means the events were accepted
                                future.setException(new APIException.FailedRequestException("Server response code is " + response.code() + " , expect: 202"));
                            } else {
                                context.log("Events successfully received");
                                future.set(new CustomEndpointResponse(response.message().toString(), String.valueOf(response.code())));
                            }
                        }
                    });
            return future;
    }
}
