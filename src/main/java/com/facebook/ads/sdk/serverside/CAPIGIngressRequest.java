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

public class CAPIGIngressRequest implements CustomEndpointRequest {
    public boolean isSendToDestinationOnly() {
        return sendToDestinationOnly;
    }
    private final boolean sendToDestinationOnly;
    private final String endpointURL;
    private Filter filter;
    private final String pixelId;
    private final String accessKey;

    private final OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

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
    public String getEndpoint() {
        return this.endpointURL;
    }
    public CustomEndpointResponse sendEvent(APIContext context,  String pixelId, List<Event> events) throws APIException.FailedRequestException {
        // filter out events
        if (this.filter != null) {
            events = events.stream().filter(event -> this.filter.shouldSendEvent(event)).collect(Collectors.toList());
        }
        if (events.isEmpty()) {
            context.log("No events to send");
            return new CustomEndpointResponse("No events to send", null);
        }
        final Request request = createRequest(events);
        context.log("========Start of CAPIG Ingress API Call========");
        try (Response httpResponse = client.newCall(request).execute()) {
            if (httpResponse.code() != 202) {
                // a HTTP response code of 202 means the events were accepted
                throw new APIException.FailedRequestException("Server response code is " + httpResponse.code() + " , expect: 202");
            } else {
                context.log("Events successfully received");
                return new CustomEndpointResponse(httpResponse.message(), String.valueOf((httpResponse.code())));
            }
        } catch (IOException ex) {
            context.log(ex.getMessage());
            throw new APIException.FailedRequestException("Server failed to accept events. " + ex.getMessage());
        } finally {
            context.log("========End of API Call========");
        }
    }

    private Request createRequest(List<Event> events) {
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
    public ListenableFuture<CustomEndpointResponse> sendEventAsync(APIContext context, String pixelId, List<Event> data) {
            context.log("========Start of Async API Call========");
            Request request = createRequest(data);
            final SettableFuture<CustomEndpointResponse> future = SettableFuture.create();
            client.newCall(request).enqueue(
                    new okhttp3.Callback() {
                        @Override
                        public void onFailure(final okhttp3.Call call, IOException e) {
                            context.log(e.getMessage());
                            future.setException(
                                    new APIException.FailedRequestException("Server failed to accept events. " + e.getMessage())
                            );
                        }

                        @Override
                        public void onResponse(okhttp3.Call call, final okhttp3.Response response) throws IOException {
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
