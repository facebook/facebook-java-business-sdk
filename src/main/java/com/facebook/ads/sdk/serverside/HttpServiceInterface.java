/**
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
 */

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
