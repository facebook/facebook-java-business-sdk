/**
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.ads.sdk.signal;

public class SignalResponse<T, U> {
    private U businessDataApi = null;
    private T conversionApi = null;

    public SignalResponse(T conversionApiData, U businessDataApiData) {
        this.businessDataApi = businessDataApiData;
        this.conversionApi = conversionApiData;
    }

    /**
     * @return business data api data
     */
    public U getBusinessDataAPIData() {
        return this.businessDataApi;
    }

    /**
     * @return conversion api
     */
    public T getConversionAPIData() {
        return this.conversionApi;
    }

}
