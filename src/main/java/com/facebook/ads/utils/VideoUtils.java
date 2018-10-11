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

package com.facebook.ads.utils;

import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINode;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.APIRequest;
import com.facebook.ads.sdk.AdVideo.EnumUploadPhase;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class VideoUtils {

  private static String READY = "ready";
  private static String PROCESSING = "processing";
  private static String ERROR = "error";

  public static int defaultWaitForEncodingCheckInterval = 10;
  public static int defaultWaitForEncodingCheckTries = 20;
  public static int defaultChunkUploadRetries = 5;

  public static interface ProgressCallback {
    public static final int EVENT_UPLOAD_PROGRESS = 0;
    public static final int EVENT_UPLOAD_COMPLETE = 1;
    public static final int EVENT_SERVER_ENCODING_PROGRESS = 2;
    public static final int EVENT_SERVER_ENCODING_COMPLETE = 3;
    public void onProgressUpdate(int event, int progress);
  }

  public static String uploadSmallVideoFile(AdAccount account, File videoFile) throws APIException {
    return uploadSmallVideoFile(account, videoFile, true, null);
  }

  public static String uploadSmallVideoFile(AdAccount account, File videoFile, boolean waitForEncoding, ProgressCallback callback) throws APIException {
    String videoId = account.createAdVideo().addUploadFile("videoFile", videoFile).execute().getId();
    if (callback != null) callback.onProgressUpdate(ProgressCallback.EVENT_UPLOAD_COMPLETE, 100);
    if (waitForEncoding) {
      if (!waitForVideoEncoding(videoId, account.getContext(), callback)) {
        throw new APIException("Video encoding failed. videoId=" + videoId);
      }
    }
    return videoId;
  }
  public static String uploadVideoFileInChunks(AdAccount account, File videoFile) throws APIException, IOException {
    return uploadVideoFileInChunks(account, videoFile, defaultChunkUploadRetries, true, null);
  }
  public static String uploadVideoFileInChunks(AdAccount account, File videoFile, int maxRetry, boolean waitForEncoding, ProgressCallback callback) throws APIException, IOException {
    int totalRetry = 0;
    long fileSize = videoFile.length();
    FileInputStream is = null;
    String sessionId;
    String videoId;
    try {
      is = new FileInputStream(videoFile);
      JsonObject start = account.createAdVideo()
          .setUploadPhase(EnumUploadPhase.VALUE_START)
          .setFileSize(fileSize)
          .execute()
          .getRawResponseAsJsonObject();
      sessionId = start.get("upload_session_id").getAsString();
      videoId = start.get("video_id").getAsString();
      long startOffset = Long.parseLong(start.get("start_offset").getAsString());
      long endOffset = Long.parseLong(start.get("end_offset").getAsString());
      byte[] chunk = null;

      boolean transferAllDone = false;
      while (!transferAllDone) {
        int chunkSize = (int)(endOffset - startOffset);
        if (chunk == null || chunkSize != chunk.length) chunk = new byte[chunkSize];
        is.read(chunk);
        JsonObject transfer = null;
        while (totalRetry < maxRetry) {
          try {
            transfer = account.createAdVideo().setUploadPhase(EnumUploadPhase.VALUE_TRANSFER)
                .setVideoFileChunk(chunk)
                .setStartOffset(startOffset)
                .setUploadSessionId(sessionId)
                .execute()
                .getRawResponseAsJsonObject();
            if (endOffset == fileSize) {
              if (callback != null) callback.onProgressUpdate(ProgressCallback.EVENT_UPLOAD_COMPLETE, 100);
              transferAllDone = true;
            } else {
              startOffset = Long.parseLong(transfer.get("start_offset").getAsString());
              endOffset = Long.parseLong(transfer.get("end_offset").getAsString());
              if (callback != null) {
                callback.onProgressUpdate(ProgressCallback.EVENT_UPLOAD_PROGRESS, (int)(startOffset * 100L / fileSize));
              }
            }
            break;
          } catch (APIException e) {
            totalRetry++;
            if (totalRetry >= maxRetry) throw new APIException(
              "Video upload failed after max retry. Video ID: " + videoId
                + "; Upload session ID: " + sessionId
                + "; Last start offset: " + startOffset
                + "; Last end offset: " + endOffset,
              e
            );
          }
        }
      }
    } finally {
      if (is != null) is.close();
    }

    boolean success = account.createAdVideo()
        .setUploadPhase(EnumUploadPhase.VALUE_FINISH)
        .setUploadSessionId(sessionId)
        .setTitle("chunked video upload")
        .execute()
        .getRawResponseAsJsonObject().get("success").getAsBoolean();

    if (!success) {
      throw new APIException("Video upload failed unexpectedly. Video ID: " + videoId + ", Upload session ID: " + sessionId);
    }
    if (waitForEncoding) {
      if (!waitForVideoEncoding(videoId, account.getContext(), callback)) {
        throw new APIException("Video encoding failed. videoId=" + videoId);
      }
    }
    return videoId;
  }

  public static boolean waitForVideoEncoding(String videoId, APIContext context, ProgressCallback callback) throws APIException {
    return waitForVideoEncoding(
      videoId,
      context,
      defaultWaitForEncodingCheckInterval,
      defaultWaitForEncodingCheckTries,
      callback
    );
  }

  public static boolean waitForVideoEncoding(String videoId, APIContext context, int checkIntervalInSec, int retries, ProgressCallback callback) throws APIException {
    for (int retry = 0; retry < retries; retry++) {
      String status = getVideoStatus(videoId, context, callback);
      if (status.equals(READY)) {
        return true;
      }
      if (status.equals(ERROR)) {
        return false;
      }
      try {
        Thread.sleep(checkIntervalInSec * 1000);
      } catch (InterruptedException e) {
        return false;
      }
    }
    return false;
  }

  public static String getVideoStatus(String videoId, APIContext context, ProgressCallback callback) throws APIException {
    JsonObject response = new APIRequest<APINode>(context, videoId, "/", "GET")
        .requestField("status")
        .execute()
        .getRawResponseAsJsonObject();
    String status = response.get("status")
        .getAsJsonObject()
        .get("video_status")
        .getAsString();

    int progress = 0;
    if (response.get("status").getAsJsonObject().has("processing_progress")) {
      progress = response.get("status").getAsJsonObject().get("processing_progress").getAsInt();
    }

    if (callback != null) {
      if (status.equals(PROCESSING)) {
        callback.onProgressUpdate(ProgressCallback.EVENT_SERVER_ENCODING_PROGRESS, progress);
      } else if (status.equals(READY)) {
        callback.onProgressUpdate(ProgressCallback.EVENT_SERVER_ENCODING_COMPLETE, 100);
      }
    }
    return status;
  }
}
