/**
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.ads.sdk.serverside;

public enum HttpMethodEnum {

  POST("POST"),
  PUT("PUT"),
  GET("GET"),
  DELETE("DELETE");

  private String value;

  HttpMethodEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }

}
