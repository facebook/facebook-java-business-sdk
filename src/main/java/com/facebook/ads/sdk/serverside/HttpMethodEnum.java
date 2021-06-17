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
