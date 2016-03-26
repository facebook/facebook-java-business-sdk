package com.facebook.ads.sdk.insights;

import com.google.gson.annotations.SerializedName;

/**
 * Author: Xardas
 * Date: 26.03.16
 * Time: 21:48
 */

public enum InsightsActionBreakdownsEnum {
  @SerializedName("action_carousel_card_id")
  VALUE_ACTION_CAROUSEL_CARD_ID("action_carousel_card_id"),
  @SerializedName("action_carousel_card_name")
  VALUE_ACTION_CAROUSEL_CARD_NAME("action_carousel_card_name"),
  @SerializedName("action_destination")
  VALUE_ACTION_DESTINATION("action_destination"),
  @SerializedName("action_device")
  VALUE_ACTION_DEVICE("action_device"),
  @SerializedName("action_target_id")
  VALUE_ACTION_TARGET_ID("action_target_id"),
  @SerializedName("action_type")
  VALUE_ACTION_TYPE("action_type"),
  @SerializedName("action_video_type")
  VALUE_ACTION_VIDEO_TYPE("action_video_type"),
  NULL(null);

  private String value;

  private InsightsActionBreakdownsEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}