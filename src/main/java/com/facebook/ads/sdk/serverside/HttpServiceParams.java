package com.facebook.ads.sdk.serverside;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class HttpServiceParams {

  @SerializedName("access_token")
  private String accessToken = null;

  @SerializedName("appsecret_proof")
  private String appSecretProof = null;

  @SerializedName("data")
  private List<Event> data = null;

  @SerializedName("test_event_code")
  private String testEventCode = null;

  @SerializedName("partner_agent")
  private String partnerAgent = null;

  @SerializedName("namespace_id")
  private String namespaceId = null;

  @SerializedName("upload_id")
  private String uploadId = null;

  @SerializedName("upload_tag")
  private String uploadTag = null;

  @SerializedName("upload_source")
  private String uploadSource = null;

  public HttpServiceParams(String accessToken, String appSecretProof, List<Event> data, String testEventCode, String partnerAgent, String namespaceId, String uploadId, String uploadTag, String uploadSource) {
    this.accessToken = accessToken;
    this.appSecretProof = appSecretProof;
    this.data = data;
    this.testEventCode = testEventCode;
    this.partnerAgent = partnerAgent;
    this.namespaceId = namespaceId;
    this.uploadId = uploadId;
    this.uploadTag = uploadTag;
    this.uploadSource = uploadSource;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public String getAppSecretProof() {
    return appSecretProof;
  }

  public List<Event> getData() {
    return data;
  }

  public String getTestEventCode() {
    return testEventCode;
  }

  public String getPartnerAgent() {
    return partnerAgent;
  }

  public String getNamespaceId() {
    return namespaceId;
  }

  public String getUploadId() {
    return uploadId;
  }

  public String getUploadTag() {
    return uploadTag;
  }

  public String getUploadSource() {
    return uploadSource;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        accessToken,
        appSecretProof,
        data,
        testEventCode,
        partnerAgent,
        namespaceId,
        uploadId,
        uploadTag,
        uploadSource
    );
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HttpServiceParams params = (HttpServiceParams) o;
    return Objects.equals(this.accessToken, params.accessToken)
        && Objects.equals(this.appSecretProof, params.appSecretProof)
        && Objects.equals(this.data, params.data)
        && Objects.equals(this.testEventCode, params.testEventCode)
        && Objects.equals(this.partnerAgent, params.partnerAgent)
        && Objects.equals(this.namespaceId, params.namespaceId)
        && Objects.equals(this.uploadId, params.uploadId)
        && Objects.equals(this.uploadTag, params.uploadTag)
        && Objects.equals(this.uploadSource, params.uploadSource);
  }
}
