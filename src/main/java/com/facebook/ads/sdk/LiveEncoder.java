/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.facebook.ads.sdk.APIException.MalformedResponseException;

/**
 * This class is auto-generated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class LiveEncoder extends APINode {
  @SerializedName("brand")
  private String mBrand = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("current_broadcast")
  private LiveVideo mCurrentBroadcast = null;
  @SerializedName("current_input_stream")
  private LiveVideoInputStream mCurrentInputStream = null;
  @SerializedName("device_id")
  private String mDeviceId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("last_heartbeat_time")
  private String mLastHeartbeatTime = null;
  @SerializedName("model")
  private String mModel = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("version")
  private String mVersion = null;
  protected static Gson gson = null;

  LiveEncoder() {
  }

  public LiveEncoder(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public LiveEncoder(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public LiveEncoder fetch() throws APIException{
    LiveEncoder newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static LiveEncoder fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<LiveEncoder> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static LiveEncoder fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<LiveEncoder> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<LiveEncoder> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<LiveEncoder>)(
      new APIRequest<LiveEncoder>(context, "", "/", "GET", LiveEncoder.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<LiveEncoder>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", LiveEncoder.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static LiveEncoder loadJSON(String json, APIContext context, String header) {
    LiveEncoder liveEncoder = getGson().fromJson(json, LiveEncoder.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(liveEncoder.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    liveEncoder.context = context;
    liveEncoder.rawValue = json;
    liveEncoder.header = header;
    return liveEncoder;
  }

  public static APINodeList<LiveEncoder> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<LiveEncoder> liveEncoders = new APINodeList<LiveEncoder>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    Exception exception = null;
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          liveEncoders.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return liveEncoders;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                liveEncoders.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            liveEncoders.setPaging(previous, next);
            if (context.hasAppSecret()) {
              liveEncoders.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              liveEncoders.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  liveEncoders.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              liveEncoders.add(loadJSON(obj.toString(), context, header));
            }
          }
          return liveEncoders;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              liveEncoders.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return liveEncoders;
        } else {
          // Fifth, check if it's an array of objects indexed by id
          boolean isIdIndexedArray = true;
          for (Map.Entry entry : obj.entrySet()) {
            String key = (String) entry.getKey();
            if (key.equals("__fb_trace_id__")) {
              continue;
            }
            JsonElement value = (JsonElement) entry.getValue();
            if (
              value != null &&
              value.isJsonObject() &&
              value.getAsJsonObject().has("id") &&
              value.getAsJsonObject().get("id") != null &&
              value.getAsJsonObject().get("id").getAsString().equals(key)
            ) {
              liveEncoders.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return liveEncoders;
          }

          // Sixth, check if it's pure JsonObject
          liveEncoders.clear();
          liveEncoders.add(loadJSON(json, context, header));
          return liveEncoders;
        }
      }
    } catch (Exception e) {
      exception = e;
    }
    throw new MalformedResponseException(
      "Invalid response string: " + json,
      exception
    );
  }

  @Override
  public APIContext getContext() {
    return context;
  }

  @Override
  public void setContext(APIContext context) {
    this.context = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }

  public APIRequestCreateTelemetry createTelemetry() {
    return new APIRequestCreateTelemetry(this.getPrefixedId().toString(), context);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldBrand() {
    return mBrand;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public LiveVideo getFieldCurrentBroadcast() {
    if (mCurrentBroadcast != null) {
      mCurrentBroadcast.context = getContext();
    }
    return mCurrentBroadcast;
  }

  public LiveVideoInputStream getFieldCurrentInputStream() {
    if (mCurrentInputStream != null) {
      mCurrentInputStream.context = getContext();
    }
    return mCurrentInputStream;
  }

  public String getFieldDeviceId() {
    return mDeviceId;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldLastHeartbeatTime() {
    return mLastHeartbeatTime;
  }

  public String getFieldModel() {
    return mModel;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldVersion() {
    return mVersion;
  }



  public static class APIRequestCreateTelemetry extends APIRequest<LiveEncoder> {

    LiveEncoder lastResponse = null;
    @Override
    public LiveEncoder getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "bitrate",
      "broadcast_id",
      "cpu_load_15m",
      "cpu_load_1m",
      "cpu_load_5m",
      "cpu_temperature",
      "cpu_usage",
      "framerate",
      "frames_dropped",
      "gpu_temperature",
      "gpu_usage",
      "last_audio_timecode",
      "last_video_keyframe_timecode",
      "last_video_timecode",
      "memory_usage",
      "network_latency",
      "network_rx_bandwidth",
      "network_rx_packets_dropped",
      "network_rx_packets_errors",
      "network_tx_bandwidth",
      "network_tx_packets_dropped",
      "network_tx_packets_errors",
      "process_uptime",
      "status",
      "timestamp",
      "total_audio_frames_sent",
      "total_video_frames_sent",
      "total_video_keyframes_sent",
      "uptime",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public LiveEncoder parseResponse(String response, String header) throws APIException {
      return LiveEncoder.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LiveEncoder execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LiveEncoder execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LiveEncoder> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LiveEncoder> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LiveEncoder>() {
           public LiveEncoder apply(ResponseWrapper result) {
             try {
               return APIRequestCreateTelemetry.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateTelemetry(String nodeId, APIContext context) {
      super(context, nodeId, "/telemetry", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateTelemetry setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateTelemetry setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateTelemetry setBitrate (Long bitrate) {
      this.setParam("bitrate", bitrate);
      return this;
    }
    public APIRequestCreateTelemetry setBitrate (String bitrate) {
      this.setParam("bitrate", bitrate);
      return this;
    }

    public APIRequestCreateTelemetry setBroadcastId (String broadcastId) {
      this.setParam("broadcast_id", broadcastId);
      return this;
    }

    public APIRequestCreateTelemetry setCpuLoad15m (Double cpuLoad15m) {
      this.setParam("cpu_load_15m", cpuLoad15m);
      return this;
    }
    public APIRequestCreateTelemetry setCpuLoad15m (String cpuLoad15m) {
      this.setParam("cpu_load_15m", cpuLoad15m);
      return this;
    }

    public APIRequestCreateTelemetry setCpuLoad1m (Double cpuLoad1m) {
      this.setParam("cpu_load_1m", cpuLoad1m);
      return this;
    }
    public APIRequestCreateTelemetry setCpuLoad1m (String cpuLoad1m) {
      this.setParam("cpu_load_1m", cpuLoad1m);
      return this;
    }

    public APIRequestCreateTelemetry setCpuLoad5m (Double cpuLoad5m) {
      this.setParam("cpu_load_5m", cpuLoad5m);
      return this;
    }
    public APIRequestCreateTelemetry setCpuLoad5m (String cpuLoad5m) {
      this.setParam("cpu_load_5m", cpuLoad5m);
      return this;
    }

    public APIRequestCreateTelemetry setCpuTemperature (Long cpuTemperature) {
      this.setParam("cpu_temperature", cpuTemperature);
      return this;
    }
    public APIRequestCreateTelemetry setCpuTemperature (String cpuTemperature) {
      this.setParam("cpu_temperature", cpuTemperature);
      return this;
    }

    public APIRequestCreateTelemetry setCpuUsage (Double cpuUsage) {
      this.setParam("cpu_usage", cpuUsage);
      return this;
    }
    public APIRequestCreateTelemetry setCpuUsage (String cpuUsage) {
      this.setParam("cpu_usage", cpuUsage);
      return this;
    }

    public APIRequestCreateTelemetry setFramerate (Double framerate) {
      this.setParam("framerate", framerate);
      return this;
    }
    public APIRequestCreateTelemetry setFramerate (String framerate) {
      this.setParam("framerate", framerate);
      return this;
    }

    public APIRequestCreateTelemetry setFramesDropped (Double framesDropped) {
      this.setParam("frames_dropped", framesDropped);
      return this;
    }
    public APIRequestCreateTelemetry setFramesDropped (String framesDropped) {
      this.setParam("frames_dropped", framesDropped);
      return this;
    }

    public APIRequestCreateTelemetry setGpuTemperature (Long gpuTemperature) {
      this.setParam("gpu_temperature", gpuTemperature);
      return this;
    }
    public APIRequestCreateTelemetry setGpuTemperature (String gpuTemperature) {
      this.setParam("gpu_temperature", gpuTemperature);
      return this;
    }

    public APIRequestCreateTelemetry setGpuUsage (Double gpuUsage) {
      this.setParam("gpu_usage", gpuUsage);
      return this;
    }
    public APIRequestCreateTelemetry setGpuUsage (String gpuUsage) {
      this.setParam("gpu_usage", gpuUsage);
      return this;
    }

    public APIRequestCreateTelemetry setLastAudioTimecode (Long lastAudioTimecode) {
      this.setParam("last_audio_timecode", lastAudioTimecode);
      return this;
    }
    public APIRequestCreateTelemetry setLastAudioTimecode (String lastAudioTimecode) {
      this.setParam("last_audio_timecode", lastAudioTimecode);
      return this;
    }

    public APIRequestCreateTelemetry setLastVideoKeyframeTimecode (Long lastVideoKeyframeTimecode) {
      this.setParam("last_video_keyframe_timecode", lastVideoKeyframeTimecode);
      return this;
    }
    public APIRequestCreateTelemetry setLastVideoKeyframeTimecode (String lastVideoKeyframeTimecode) {
      this.setParam("last_video_keyframe_timecode", lastVideoKeyframeTimecode);
      return this;
    }

    public APIRequestCreateTelemetry setLastVideoTimecode (Long lastVideoTimecode) {
      this.setParam("last_video_timecode", lastVideoTimecode);
      return this;
    }
    public APIRequestCreateTelemetry setLastVideoTimecode (String lastVideoTimecode) {
      this.setParam("last_video_timecode", lastVideoTimecode);
      return this;
    }

    public APIRequestCreateTelemetry setMemoryUsage (Double memoryUsage) {
      this.setParam("memory_usage", memoryUsage);
      return this;
    }
    public APIRequestCreateTelemetry setMemoryUsage (String memoryUsage) {
      this.setParam("memory_usage", memoryUsage);
      return this;
    }

    public APIRequestCreateTelemetry setNetworkLatency (Double networkLatency) {
      this.setParam("network_latency", networkLatency);
      return this;
    }
    public APIRequestCreateTelemetry setNetworkLatency (String networkLatency) {
      this.setParam("network_latency", networkLatency);
      return this;
    }

    public APIRequestCreateTelemetry setNetworkRxBandwidth (Long networkRxBandwidth) {
      this.setParam("network_rx_bandwidth", networkRxBandwidth);
      return this;
    }
    public APIRequestCreateTelemetry setNetworkRxBandwidth (String networkRxBandwidth) {
      this.setParam("network_rx_bandwidth", networkRxBandwidth);
      return this;
    }

    public APIRequestCreateTelemetry setNetworkRxPacketsDropped (Double networkRxPacketsDropped) {
      this.setParam("network_rx_packets_dropped", networkRxPacketsDropped);
      return this;
    }
    public APIRequestCreateTelemetry setNetworkRxPacketsDropped (String networkRxPacketsDropped) {
      this.setParam("network_rx_packets_dropped", networkRxPacketsDropped);
      return this;
    }

    public APIRequestCreateTelemetry setNetworkRxPacketsErrors (Double networkRxPacketsErrors) {
      this.setParam("network_rx_packets_errors", networkRxPacketsErrors);
      return this;
    }
    public APIRequestCreateTelemetry setNetworkRxPacketsErrors (String networkRxPacketsErrors) {
      this.setParam("network_rx_packets_errors", networkRxPacketsErrors);
      return this;
    }

    public APIRequestCreateTelemetry setNetworkTxBandwidth (Long networkTxBandwidth) {
      this.setParam("network_tx_bandwidth", networkTxBandwidth);
      return this;
    }
    public APIRequestCreateTelemetry setNetworkTxBandwidth (String networkTxBandwidth) {
      this.setParam("network_tx_bandwidth", networkTxBandwidth);
      return this;
    }

    public APIRequestCreateTelemetry setNetworkTxPacketsDropped (Double networkTxPacketsDropped) {
      this.setParam("network_tx_packets_dropped", networkTxPacketsDropped);
      return this;
    }
    public APIRequestCreateTelemetry setNetworkTxPacketsDropped (String networkTxPacketsDropped) {
      this.setParam("network_tx_packets_dropped", networkTxPacketsDropped);
      return this;
    }

    public APIRequestCreateTelemetry setNetworkTxPacketsErrors (Double networkTxPacketsErrors) {
      this.setParam("network_tx_packets_errors", networkTxPacketsErrors);
      return this;
    }
    public APIRequestCreateTelemetry setNetworkTxPacketsErrors (String networkTxPacketsErrors) {
      this.setParam("network_tx_packets_errors", networkTxPacketsErrors);
      return this;
    }

    public APIRequestCreateTelemetry setProcessUptime (Long processUptime) {
      this.setParam("process_uptime", processUptime);
      return this;
    }
    public APIRequestCreateTelemetry setProcessUptime (String processUptime) {
      this.setParam("process_uptime", processUptime);
      return this;
    }

    public APIRequestCreateTelemetry setStatus (LiveEncoder.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestCreateTelemetry setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestCreateTelemetry setTimestamp (Long timestamp) {
      this.setParam("timestamp", timestamp);
      return this;
    }
    public APIRequestCreateTelemetry setTimestamp (String timestamp) {
      this.setParam("timestamp", timestamp);
      return this;
    }

    public APIRequestCreateTelemetry setTotalAudioFramesSent (Long totalAudioFramesSent) {
      this.setParam("total_audio_frames_sent", totalAudioFramesSent);
      return this;
    }
    public APIRequestCreateTelemetry setTotalAudioFramesSent (String totalAudioFramesSent) {
      this.setParam("total_audio_frames_sent", totalAudioFramesSent);
      return this;
    }

    public APIRequestCreateTelemetry setTotalVideoFramesSent (Long totalVideoFramesSent) {
      this.setParam("total_video_frames_sent", totalVideoFramesSent);
      return this;
    }
    public APIRequestCreateTelemetry setTotalVideoFramesSent (String totalVideoFramesSent) {
      this.setParam("total_video_frames_sent", totalVideoFramesSent);
      return this;
    }

    public APIRequestCreateTelemetry setTotalVideoKeyframesSent (Long totalVideoKeyframesSent) {
      this.setParam("total_video_keyframes_sent", totalVideoKeyframesSent);
      return this;
    }
    public APIRequestCreateTelemetry setTotalVideoKeyframesSent (String totalVideoKeyframesSent) {
      this.setParam("total_video_keyframes_sent", totalVideoKeyframesSent);
      return this;
    }

    public APIRequestCreateTelemetry setUptime (Long uptime) {
      this.setParam("uptime", uptime);
      return this;
    }
    public APIRequestCreateTelemetry setUptime (String uptime) {
      this.setParam("uptime", uptime);
      return this;
    }

    public APIRequestCreateTelemetry requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateTelemetry requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateTelemetry requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateTelemetry requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateTelemetry requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateTelemetry requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestDelete.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<LiveEncoder> {

    LiveEncoder lastResponse = null;
    @Override
    public LiveEncoder getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "brand",
      "creation_time",
      "current_broadcast",
      "current_input_stream",
      "device_id",
      "id",
      "last_heartbeat_time",
      "model",
      "name",
      "status",
      "version",
    };

    @Override
    public LiveEncoder parseResponse(String response, String header) throws APIException {
      return LiveEncoder.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LiveEncoder execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LiveEncoder execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LiveEncoder> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LiveEncoder> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LiveEncoder>() {
           public LiveEncoder apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestBrandField () {
      return this.requestBrandField(true);
    }
    public APIRequestGet requestBrandField (boolean value) {
      this.requestField("brand", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestCurrentBroadcastField () {
      return this.requestCurrentBroadcastField(true);
    }
    public APIRequestGet requestCurrentBroadcastField (boolean value) {
      this.requestField("current_broadcast", value);
      return this;
    }
    public APIRequestGet requestCurrentInputStreamField () {
      return this.requestCurrentInputStreamField(true);
    }
    public APIRequestGet requestCurrentInputStreamField (boolean value) {
      this.requestField("current_input_stream", value);
      return this;
    }
    public APIRequestGet requestDeviceIdField () {
      return this.requestDeviceIdField(true);
    }
    public APIRequestGet requestDeviceIdField (boolean value) {
      this.requestField("device_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLastHeartbeatTimeField () {
      return this.requestLastHeartbeatTimeField(true);
    }
    public APIRequestGet requestLastHeartbeatTimeField (boolean value) {
      this.requestField("last_heartbeat_time", value);
      return this;
    }
    public APIRequestGet requestModelField () {
      return this.requestModelField(true);
    }
    public APIRequestGet requestModelField (boolean value) {
      this.requestField("model", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestVersionField () {
      return this.requestVersionField(true);
    }
    public APIRequestGet requestVersionField (boolean value) {
      this.requestField("version", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<LiveEncoder> {

    LiveEncoder lastResponse = null;
    @Override
    public LiveEncoder getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "broadcast_id",
      "cap_audio_codecs",
      "cap_streaming_protocols",
      "cap_video_codecs",
      "error_code",
      "error_msg",
      "input_audio_channels",
      "input_audio_samplerate",
      "input_video_framerate",
      "input_video_gop_num_b_frames",
      "input_video_gop_size",
      "input_video_height",
      "input_video_interlace_mode",
      "input_video_width",
      "name",
      "needs_transcoder_restart",
      "needs_transcoder_restart_reason",
      "status",
      "target_token",
      "version",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public LiveEncoder parseResponse(String response, String header) throws APIException {
      return LiveEncoder.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LiveEncoder execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LiveEncoder execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LiveEncoder> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LiveEncoder> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LiveEncoder>() {
           public LiveEncoder apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setBroadcastId (String broadcastId) {
      this.setParam("broadcast_id", broadcastId);
      return this;
    }

    public APIRequestUpdate setCapAudioCodecs (List<LiveEncoder.EnumCapAudioCodecs> capAudioCodecs) {
      this.setParam("cap_audio_codecs", capAudioCodecs);
      return this;
    }
    public APIRequestUpdate setCapAudioCodecs (String capAudioCodecs) {
      this.setParam("cap_audio_codecs", capAudioCodecs);
      return this;
    }

    public APIRequestUpdate setCapStreamingProtocols (List<LiveEncoder.EnumCapStreamingProtocols> capStreamingProtocols) {
      this.setParam("cap_streaming_protocols", capStreamingProtocols);
      return this;
    }
    public APIRequestUpdate setCapStreamingProtocols (String capStreamingProtocols) {
      this.setParam("cap_streaming_protocols", capStreamingProtocols);
      return this;
    }

    public APIRequestUpdate setCapVideoCodecs (List<LiveEncoder.EnumCapVideoCodecs> capVideoCodecs) {
      this.setParam("cap_video_codecs", capVideoCodecs);
      return this;
    }
    public APIRequestUpdate setCapVideoCodecs (String capVideoCodecs) {
      this.setParam("cap_video_codecs", capVideoCodecs);
      return this;
    }

    public APIRequestUpdate setErrorCode (Long errorCode) {
      this.setParam("error_code", errorCode);
      return this;
    }
    public APIRequestUpdate setErrorCode (String errorCode) {
      this.setParam("error_code", errorCode);
      return this;
    }

    public APIRequestUpdate setErrorMsg (String errorMsg) {
      this.setParam("error_msg", errorMsg);
      return this;
    }

    public APIRequestUpdate setInputAudioChannels (Long inputAudioChannels) {
      this.setParam("input_audio_channels", inputAudioChannels);
      return this;
    }
    public APIRequestUpdate setInputAudioChannels (String inputAudioChannels) {
      this.setParam("input_audio_channels", inputAudioChannels);
      return this;
    }

    public APIRequestUpdate setInputAudioSamplerate (Long inputAudioSamplerate) {
      this.setParam("input_audio_samplerate", inputAudioSamplerate);
      return this;
    }
    public APIRequestUpdate setInputAudioSamplerate (String inputAudioSamplerate) {
      this.setParam("input_audio_samplerate", inputAudioSamplerate);
      return this;
    }

    public APIRequestUpdate setInputVideoFramerate (String inputVideoFramerate) {
      this.setParam("input_video_framerate", inputVideoFramerate);
      return this;
    }

    public APIRequestUpdate setInputVideoGopNumBFrames (Long inputVideoGopNumBFrames) {
      this.setParam("input_video_gop_num_b_frames", inputVideoGopNumBFrames);
      return this;
    }
    public APIRequestUpdate setInputVideoGopNumBFrames (String inputVideoGopNumBFrames) {
      this.setParam("input_video_gop_num_b_frames", inputVideoGopNumBFrames);
      return this;
    }

    public APIRequestUpdate setInputVideoGopSize (Long inputVideoGopSize) {
      this.setParam("input_video_gop_size", inputVideoGopSize);
      return this;
    }
    public APIRequestUpdate setInputVideoGopSize (String inputVideoGopSize) {
      this.setParam("input_video_gop_size", inputVideoGopSize);
      return this;
    }

    public APIRequestUpdate setInputVideoHeight (Long inputVideoHeight) {
      this.setParam("input_video_height", inputVideoHeight);
      return this;
    }
    public APIRequestUpdate setInputVideoHeight (String inputVideoHeight) {
      this.setParam("input_video_height", inputVideoHeight);
      return this;
    }

    public APIRequestUpdate setInputVideoInterlaceMode (String inputVideoInterlaceMode) {
      this.setParam("input_video_interlace_mode", inputVideoInterlaceMode);
      return this;
    }

    public APIRequestUpdate setInputVideoWidth (Long inputVideoWidth) {
      this.setParam("input_video_width", inputVideoWidth);
      return this;
    }
    public APIRequestUpdate setInputVideoWidth (String inputVideoWidth) {
      this.setParam("input_video_width", inputVideoWidth);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setNeedsTranscoderRestart (Boolean needsTranscoderRestart) {
      this.setParam("needs_transcoder_restart", needsTranscoderRestart);
      return this;
    }
    public APIRequestUpdate setNeedsTranscoderRestart (String needsTranscoderRestart) {
      this.setParam("needs_transcoder_restart", needsTranscoderRestart);
      return this;
    }

    public APIRequestUpdate setNeedsTranscoderRestartReason (List<String> needsTranscoderRestartReason) {
      this.setParam("needs_transcoder_restart_reason", needsTranscoderRestartReason);
      return this;
    }
    public APIRequestUpdate setNeedsTranscoderRestartReason (String needsTranscoderRestartReason) {
      this.setParam("needs_transcoder_restart_reason", needsTranscoderRestartReason);
      return this;
    }

    public APIRequestUpdate setStatus (LiveEncoder.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestUpdate setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestUpdate setTargetToken (String targetToken) {
      this.setParam("target_token", targetToken);
      return this;
    }

    public APIRequestUpdate setVersion (String version) {
      this.setParam("version", version);
      return this;
    }

    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static enum EnumCapAudioCodecs {
      @SerializedName("AAC")
      VALUE_AAC("AAC"),
      ;

      private String value;

      private EnumCapAudioCodecs(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCapStreamingProtocols {
      @SerializedName("HTTPS_DASH")
      VALUE_HTTPS_DASH("HTTPS_DASH"),
      @SerializedName("RTMPS")
      VALUE_RTMPS("RTMPS"),
      @SerializedName("WEBRTC")
      VALUE_WEBRTC("WEBRTC"),
      ;

      private String value;

      private EnumCapStreamingProtocols(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCapVideoCodecs {
      @SerializedName("H264")
      VALUE_H264("H264"),
      ;

      private String value;

      private EnumCapVideoCodecs(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStatus {
      @SerializedName("CAPTURE")
      VALUE_CAPTURE("CAPTURE"),
      @SerializedName("LIVE")
      VALUE_LIVE("LIVE"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("PREVIEW")
      VALUE_PREVIEW("PREVIEW"),
      @SerializedName("READY")
      VALUE_READY("READY"),
      @SerializedName("REGISTER")
      VALUE_REGISTER("REGISTER"),
      ;

      private String value;

      private EnumStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }


  synchronized /*package*/ static Gson getGson() {
    if (gson != null) {
      return gson;
    } else {
      gson = new GsonBuilder()
        .excludeFieldsWithModifiers(Modifier.STATIC)
        .excludeFieldsWithModifiers(Modifier.PROTECTED)
        .disableHtmlEscaping()
        .create();
    }
    return gson;
  }

  public LiveEncoder copyFrom(LiveEncoder instance) {
    this.mBrand = instance.mBrand;
    this.mCreationTime = instance.mCreationTime;
    this.mCurrentBroadcast = instance.mCurrentBroadcast;
    this.mCurrentInputStream = instance.mCurrentInputStream;
    this.mDeviceId = instance.mDeviceId;
    this.mId = instance.mId;
    this.mLastHeartbeatTime = instance.mLastHeartbeatTime;
    this.mModel = instance.mModel;
    this.mName = instance.mName;
    this.mStatus = instance.mStatus;
    this.mVersion = instance.mVersion;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LiveEncoder> getParser() {
    return new APIRequest.ResponseParser<LiveEncoder>() {
      public APINodeList<LiveEncoder> parseResponse(String response, APIContext context, APIRequest<LiveEncoder> request, String header) throws MalformedResponseException {
        return LiveEncoder.parseResponse(response, context, request, header);
      }
    };
  }
}
