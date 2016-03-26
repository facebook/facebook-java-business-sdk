package com.facebook.ads.sdk.insights;

import com.google.gson.annotations.SerializedName;

/**
 * Author: Xardas
 * Date: 26.03.16
 * Time: 21:59
 */
public enum InsightsBreakdownsEnum {
  @SerializedName("age")
  VALUE_AGE("age"),
  @SerializedName("country")
  VALUE_COUNTRY("country"),
  @SerializedName("gender")
  VALUE_GENDER("gender"),
  @SerializedName("frequency_value")
  VALUE_FREQUENCY_VALUE("frequency_value"),
  @SerializedName("hourly_stats_aggregated_by_advertiser_time_zone")
  VALUE_HOURLY_STATS_AGGREGATED_BY_ADVERTISER_TIME_ZONE("hourly_stats_aggregated_by_advertiser_time_zone"),
  @SerializedName("hourly_stats_aggregated_by_audience_time_zone")
  VALUE_HOURLY_STATS_AGGREGATED_BY_AUDIENCE_TIME_ZONE("hourly_stats_aggregated_by_audience_time_zone"),
  @SerializedName("impression_device")
  VALUE_IMPRESSION_DEVICE("impression_device"),
  @SerializedName("place_page_id")
  VALUE_PLACE_PAGE_ID("place_page_id"),
  @SerializedName("placement")
  VALUE_PLACEMENT("placement"),
  @SerializedName("placement_merge_rhc")
  VALUE_PLACEMENT_MERGE_RHC("placement_merge_rhc"),
  @SerializedName("product_id")
  VALUE_PRODUCT_ID("product_id"),
  @SerializedName("region")
  VALUE_REGION("region"),
  NULL(null);

  private String value;

  private InsightsBreakdownsEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}