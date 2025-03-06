/**
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.ads.sdk.serverside;

import com.google.gson.annotations.SerializedName;

/**
 * Server side response to a custom endpoint
 */

public class CustomEndpointResponse {

    @SerializedName("message")
    public String message;

    @SerializedName("response_code")
    public String responseCode;

    public CustomEndpointResponse(String message, String responseCode) {
        this.message = message;
        this.responseCode = responseCode;
    }
}
