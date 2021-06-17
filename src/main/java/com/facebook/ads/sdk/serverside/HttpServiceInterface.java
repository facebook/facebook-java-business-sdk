package com.facebook.ads.sdk.serverside;

import com.facebook.ads.sdk.AdsPixel;

import java.util.Map;

public interface HttpServiceInterface {
  public EventResponse executeRequest(
      String url,
      HttpMethodEnum httpMethod,
      Map<String, String> headers,
      HttpServiceParams params
  );
}
